package repository

import util.Messages
import kotlin.system.exitProcess

class MessageRepository {

    fun startProgramExec() {
        println(Messages.welcomeMessage)
    }

    fun endProgramExec() {
        println(Messages.overMessage)
        exitProcess(0)
    }

    fun getHelpInfo() {
        println(Messages.infoMessage.trimIndent())
    }

    fun wrongCommandExec() {
        println(Messages.wrongMessage)
    }
}