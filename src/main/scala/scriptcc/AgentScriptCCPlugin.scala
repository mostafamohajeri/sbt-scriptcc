package scriptcc

import sbt.{Compile, Def, File, _}
import sbt.Keys._
import translation.Translator

object AgentScriptCCPlugin extends AutoPlugin {
  // by defining autoImport, the settings are automatically imported into user's `*.sbt`
  object autoImport {
    // configuration points, like the built-in `version`, `libraryDependencies`, or `compile`
    val agentScriptCC = taskKey[Seq[java.io.File]]("Translate .asl files.")
    val agentScriptCCPath = settingKey[File]("input directory.")
    val agentScriptCCOutPath = settingKey[File]("output directory.")

    // default values for the tasks and settings
    lazy val baseScriptCCSettings: Seq[Def.Setting[_]] = Seq(
      agentScriptCC := {
        Translate((agentScriptCC / agentScriptCCPath).value,(agentScriptCC / agentScriptCCOutPath).value)
      },
      agentScriptCCPath in agentScriptCC := (baseDirectory).value / "src" / "main" / "asl",
      agentScriptCCOutPath in agentScriptCC := (sourceManaged).value
    )
  }

  import autoImport._
  //  override def trigger = allRequirements

  // a group of settings that are automatically added to projects.
  override val projectSettings: Seq[Def.Setting[_]] =
    inConfig(Compile)(baseScriptCCSettings) ++
      inConfig(Test)(baseScriptCCSettings)


}

object utils {
  def getListOfFiles(dir: File):List[File] = {

    if (dir.exists && dir.isDirectory) {
      dir.listFiles.filter(_.isFile).toList
    } else {
      List[File]()
    }
  }

}

object Translate {
  def apply(directory: File,out: File): Seq[java.io.File] = {
    println(s"Translating sources from dir: ${directory.toString}")
    val files =  utils.getListOfFiles(directory)

        files.map(f => {
          val name = f.getName.split("\\.").head
          val pkg = directory.getName
          val output =  out / pkg / s"$name.scala"

          IO.write(output,"")
          val translator: Translator = new Translator()
          val code = translator.translate(f.getAbsolutePath,name)
    //      println(IO.read(f))
          IO.write(output,s"""
            package ${pkg}

           $code""")
          output
        })
  }
}
