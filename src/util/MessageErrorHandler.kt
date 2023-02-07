package util

object MessageErrorHandler {

    fun wrongCommandExec() {
        Messages.sendMessage(Messages.wrongMessage)
    }
}