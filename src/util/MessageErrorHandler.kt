package util

object MessageErrorHandler {

    fun wrongCommandExec() {
        Messages.sendMessage(Messages.wrongMessage)
    }

    fun wrongArguments(args: String) {
        return println("Неверное количество аргументов, количество аргументов должно быть равно $args")
    }

}