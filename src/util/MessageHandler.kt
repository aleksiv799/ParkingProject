package util

import kotlin.system.exitProcess

object MessageHandler {

    fun startProgramExec() {
        Messages.sendMessage(Messages.welcomeMessage)
    }

    fun endProgramExec() {
        Messages.sendMessage(Messages.overMessage)
        exitProcess(0)
    }

    fun getHelpInfo() {
        Messages.sendMessage(Messages.infoMessage.trimIndent())
    }


}