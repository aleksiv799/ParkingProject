import data.Commands
import data.Manager
import util.MessageErrorHandler
import util.Messages
import util.MessageHandler

val manager = Manager()

fun main(args: Array<String>) {
    startConfiguration()
    selectMenu()

}

fun startConfiguration() {
    Messages.sendMessage(Messages.introMessage)
    Messages.sendMessage(
        """Введите команду "${Commands.startCommand}" для запуска работы программы
или наберите команду: "${Commands.helpCommand}" для получения справки:
        """.trimMargin()
    )

}

fun selectMenu() {

    while (true) {
        when (readLine().toString()) {
            Commands.finishCommand -> MessageHandler.endProgramExec()
            Commands.helpCommand -> MessageHandler.getHelpInfo()
            Commands.startCommand -> startProgram()
            else -> MessageErrorHandler.wrongCommandExec()
        }
    }
}

fun startProgram() {

}



















