package util

import util.Colors.green
import util.Colors.resetColor
import kotlin.system.exitProcess

object MessageHandler {

    fun endProgramExec() {
        Messages.sendMessage(Messages.overMessage)
        exitProcess(0)
    }

    fun getHelpInfo() {
        Messages.sendMessage(Messages.infoMessage.trimIndent())
    }

    fun successfullyParkingMessage( ownerName: String, ownerSurname: String, parkingPlace: String) {
        Messages.sendMessage("${green}Автомобиль владельца" +
                " $ownerName $ownerSurname успешно припаркован на месте $parkingPlace$resetColor")
    }

    fun successfulReturnAutoMessage(parkingPlace: String) {
        Messages.sendMessage("${green}Автомобиль был возвращен владельцу, место \"$parkingPlace\" теперь свободно$resetColor")
    }

    fun timerParkingMessage(currentTime: Long) {
        Messages.sendMessage("Время пребывания на парковке вашего автомобиля - $currentTime секунд")
    }

    fun timeToParkingMessage(timeParking: String) {
        Messages.sendMessage("Время парковки Вашего автомобиля: $timeParking")
    }

}