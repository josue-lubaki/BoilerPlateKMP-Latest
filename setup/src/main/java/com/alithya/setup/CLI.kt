package com.alithya.setup

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.arguments.default
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.prompt
import com.github.ajalt.clikt.parameters.types.file
import java.io.File

/**
 * created by Josue Lubaki
 * date : 2024-03-08
 * version : 1.0.0
 */

class CLI : CliktCommand(){

    private val actualPackageName = "com.alithya.boilerplate"
    private val rootProjectName = "BoilerPlate"

    private val composeAppBuildGradle by argument().file().default(File("composeApp/build.gradle.kts"))
    private val settingsGradle by argument().file().default(File("settings.gradle.kts"))

    private val appName : String by option().prompt("Enter the name of your app (example : MyAwesomeApp)")
    private val packageName : String by option().prompt("Enter the package name of your app (example : com.example.app)")

    override fun run() {
        echo("Step 1 : composeApp changes...")
        val composeAppBuildGradleContent = composeAppBuildGradle.readText()
        composeAppBuildGradle.delete()
        composeAppBuildGradle.createNewFile()
        composeAppBuildGradle.writeText(composeAppBuildGradleContent.replace(actualPackageName, packageName))
        echo("Step 1 : DONE")
        setupComposeApp(packageName)
        setupSettingsGradle(appName)
        GitAddCommitCommand("setup app completed successfully").main(emptyArray())
        echo("Processing --> DONE")
    }

    private fun setupComposeApp(packageName: String) {
        val oldImportPattern1 = "import ${rootProjectName.lowercase()}"
        val newImportPattern1 = "import ${appName.lowercase()}"

        echo("Step 2 : setupComposeApp changes...")
        echo("Processing : androidApp changes...")
        val oldAndroidMain = File("composeApp/src/androidMain/kotlin/${actualPackageName.replace(".", "/")}")
        val newAndroidMain = File("composeApp/src/androidMain/kotlin/${packageName.replace(".", "/")}")
        val excludedExtensions = listOf(".png", ".webp", ".xml", ".jpg", ".jpeg", ".gif")

        newAndroidMain.mkdirs()
        oldAndroidMain.copyRecursively(newAndroidMain, overwrite = false)
        oldAndroidMain.deleteRecursively()
        newAndroidMain
            .walkTopDown()
            .filter { it.isFile }
            .filter { file -> excludedExtensions.none { extension -> file.name.endsWith(extension) } }
            .forEach {
                val content = it.readText()
                it.delete()
                it.createNewFile()

                val contentModified = content
                    .replace(actualPackageName, packageName)
                    .replace(oldImportPattern1, newImportPattern1)
                it.writeText(contentModified)
            }
        echo("Processing : androidApp done")

        echo("Processing : commonMainApp changes...")
        val oldCommonMain = File("composeApp/src/commonMain/kotlin/${actualPackageName.replace(".", "/")}")
        val newCommonMain = File("composeApp/src/commonMain/kotlin/${packageName.replace(".", "/")}")
        newCommonMain.mkdirs()
        oldCommonMain.copyRecursively(newCommonMain, overwrite = false)
        oldCommonMain.deleteRecursively()
        newCommonMain
            .walkTopDown()
            .filter { it.isFile }
            .filter { file -> excludedExtensions.none { extension -> file.name.endsWith(extension) } }
            .forEach {
                val content = it.readText()
                it.delete()
                it.createNewFile()
                val contentModified = content
                    .replace(actualPackageName, packageName)
                    .replace(oldImportPattern1, newImportPattern1)
                it.writeText(contentModified)
            }
        echo("Processing : commonMainApp done")

        echo("Processing : desktopMainApp changes...")
        val oldDesktopMain = File("composeApp/src/desktopMain/kotlin/${actualPackageName.replace(".", "/")}")
        val newDesktopMain = File("composeApp/src/desktopMain/kotlin/${packageName.replace(".", "/")}")
        newDesktopMain.mkdirs()
        oldDesktopMain.copyRecursively(newDesktopMain, overwrite = false)
        oldDesktopMain.deleteRecursively()
        newDesktopMain
            .walkTopDown()
            .filter { it.isFile }
            .filter { file -> excludedExtensions.none { extension -> file.name.endsWith(extension) } }
            .forEach {
                val content = it.readText()
                it.delete()
                it.createNewFile()

                val contentModified = content
                    .replace(actualPackageName, packageName)
                    .replace(oldImportPattern1, newImportPattern1)
                it.writeText(contentModified)
            }
        echo("Processing : desktopMainApp done")

        echo("Processing : iosMainApp changes...")
        val oldIosMain = File("composeApp/src/iosMain/kotlin/${actualPackageName.replace(".", "/")}")
        val newIosMain = File("composeApp/src/iosMain/kotlin/${packageName.replace(".", "/")}")
        newIosMain.mkdirs()
        oldIosMain.copyRecursively(newIosMain, overwrite = false)
        oldIosMain.deleteRecursively()
        newIosMain
            .walkTopDown()
            .filter { it.isFile }
            .filter { file -> excludedExtensions.none { extension -> file.name.endsWith(extension) } }
            .forEach {
                val content = it.readText()
                it.delete()
                it.createNewFile()

                val contentModified = content
                    .replace(actualPackageName, packageName)
                    .replace(oldImportPattern1, newImportPattern1)
                it.writeText(contentModified)
            }
        echo("Processing : iosMainApp done")

        echo("Processing : wasmJsMain changes...")
        val path = File("composeApp/src/wasJsMain/kotlin/${actualPackageName.replace(".", "/")}")
        val oldWasmJsMain =
            if (path.exists()) path
            else {
                echo("Processing : wasmJsMain done")
                echo("Step 2 --> DONE")
                return
            }
        val newWasmJsMain =
            if(oldWasmJsMain.isFile) File("composeApp/src/wasJsMain/kotlin/${packageName.replace(".", "/")}")
            else {
                echo("Processing : wasmJsMain done")
                echo("Step 2 --> DONE")
                return
            }
        newWasmJsMain.mkdirs()
        oldWasmJsMain.copyRecursively(newWasmJsMain, overwrite = false)
        oldWasmJsMain.deleteRecursively()
        newWasmJsMain
            .walkTopDown()
            .filter { it.isFile }
            .filter { file -> excludedExtensions.none { extension -> file.name.endsWith(extension) } }
            .forEach {
                val content = it.readText()
                it.delete()
                it.createNewFile()

                val contentModified = content
                    .replace(actualPackageName, packageName)
                    .replace(oldImportPattern1, newImportPattern1)
                it.writeText(contentModified)
            }
        echo("Processing : wasmJsMain done")
        echo("Step 2 --> DONE")
    }

    private fun setupSettingsGradle(appName: String) {
        echo("Step 3 : setupSettingsGradle changes...")
        val settingsGradleContent = settingsGradle.readText()
        settingsGradle.delete()
        settingsGradle.createNewFile()
        settingsGradle.writeText(settingsGradleContent.replace(rootProjectName, appName))
        echo("Step 3 --> DONE")
    }
}


class GitAddCommitCommand(private val message: String) : CliktCommand() {
    override fun run() {
        val gitAdd = ProcessBuilder("git", "add", ".")
        val gitCommit = ProcessBuilder("git", "commit", "-m", message)

        val gitAddProcess = gitAdd
            .redirectOutput(ProcessBuilder.Redirect.INHERIT)
            .redirectError(ProcessBuilder.Redirect.INHERIT)
            .start()

        val addExitCode = gitAddProcess.waitFor()
        if (addExitCode != 0) {
            echo(message = "git add failed with exit code : $addExitCode")
        }

        // Generate new Resource file
        val res = ProcessBuilder("./gradlew", "generateComposeResClass")
        val resProcess = res
            .redirectOutput(ProcessBuilder.Redirect.INHERIT)
            .redirectError(ProcessBuilder.Redirect.INHERIT)
            .start()
        val resProcessExitCode = resProcess.waitFor()
        if (resProcessExitCode >= -1){
            echo("generateComposeResClass task completed successfully")
            return
        }

//
//        val gitCommitProcess = gitCommit
//            .redirectOutput(ProcessBuilder.Redirect.INHERIT)
//            .redirectError(ProcessBuilder.Redirect.INHERIT)
//            .start()
//
//        val commitExitCode = gitCommitProcess.waitFor()

        echo(message = "git add success")
    }
}