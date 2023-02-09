package util

import util.Colors.red
import util.UtilFunctions.toColor

object MessageErrorHandler {

    fun wrongCommandExec() {
        Messages.sendMessage(Messages.wrongMessage.toColor(red))
    }

    fun wrongArgumentsMessage(args: Int) {
        Messages.sendMessage("Вы указали неверное количество параметров для запроса, ".toColor(red) +
                "количество параметров должно быть равно - $args".toColor(red))
    }

    fun invalidateOwner() {
        Messages.sendMessage("Этот автомобиль не Ваш! Повторите попытку пожалуйста".toColor(red))
    }
}