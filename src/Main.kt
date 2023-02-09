import data.Car
import data.Commands
import data.Manager
import data.Owner
import util.MessageErrorHandler
import util.MessageHandler
import util.Messages

val manager = Manager()


fun main(args: Array<String>) {
    startConfiguration()
    var input = readLine()
    while (true) {
        val command = input?.substringBefore(" ")
        val args = input?.substringAfter(" ")
        val carsParam = args!!.split(" ")
        when (command) {
            Commands.startCommand -> Messages.sendMessage(
                "Введите команду: "
            )
            Commands.helpCommand -> MessageHandler.getHelpInfo()
            Commands.parkingCommand -> manager.parkByCar(carsParam)
            Commands.returnCommand -> manager.returnCarByOwner(carsParam)
            Commands.parkInfoByCarCommand -> manager.getParkInfoByCar(carsParam)
            Commands.parkInfoByPlaceCommand -> manager.getParkIntoByPlace(carsParam)
            Commands.finishCommand -> MessageHandler.endProgramExec()
            Commands.parkStatsCommand -> manager.getParkingStats()
            else -> MessageErrorHandler.wrongCommandExec()
        }
        input = readLine()
    }
}

fun startConfiguration() {
    Messages.sendMessage(Messages.introMessage)
    Messages.sendMessage(
        """Введите команду "${Commands.startCommand}" для запуска работы программы
или наберите команду: "${Commands.helpCommand}" для получения справки:
        """.trimMargin()

    )

}























