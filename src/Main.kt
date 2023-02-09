import data.Commands
import data.Manager
import util.Colors.blue
import util.Colors.resetColor
import util.MessageErrorHandler
import util.MessageHandler
import util.Messages


val manager = Manager()


fun main(args: Array<String>) {
    startConfiguration()
    selectMenu()

}

fun startConfiguration() {
    Messages.sendMessage(Messages.messageHelper)
}

fun selectMenu() {
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
            Commands.parkAllStatsCommand -> manager.getCountParkingActions()
            else -> MessageErrorHandler.wrongCommandExec()
        }
        input = readLine()
    }
}























