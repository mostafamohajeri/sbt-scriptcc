# sbt-scriptcc
The sbt plugin for compilation of AgentScript programs via sbt 

AgentScript Cross-Compiler

## How to use

Add the plugin to you sbt project in `repo/project/plugins.sbt`
```scala
resolvers += Resolver.bintrayRepo("uva-cci","script-cc-grammars")

addSbtPlugin("nl.uva.sne.cci" % "sbt-scriptcc" % "<version>")
```

In your main `build.sbt` enable the plugin

```scala
enablePlugins(AgentScriptCCPlugin)
```

and point the plugin to your AgentScript package(s), in this case located in the `asl` package so it knows what to translate in either Compile or Test

```scala
(agentScriptCC / agentScriptCCPath) in Compile := (baseDirectory.value / "src" / "main" / "asl")
```

and add this plugin task as a source generation task in Compile or Test

```scala
Compile / sourceGenerators += (Compile / agentScriptCC).taskValue
```

After compilation the Scala counterpart of your agents should be located in `sourceManaged` and accessible form the rest of the project
