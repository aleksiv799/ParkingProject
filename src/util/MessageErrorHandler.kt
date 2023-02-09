package util

import util.Colors.red
import util.Colors.resetColor

object MessageErrorHandler {

    fun wrongCommandExec() {
        Messages.sendMessage(Messages.wrongMessage)
    }

    fun wrongArgumentsMessage(args: Int) {
        Messages.sendMessage("${red}Неверное количество аргументов, количество аргументов должно быть равно $args$resetColor")
    }

    fun invalidateOwner() {
        Messages.sendMessage("$red Этот автомобиль не Ваш! Повторите попытку пожалуйста$resetColor")
    }
}