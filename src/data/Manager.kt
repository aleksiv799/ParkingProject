package data

import repository.ParkingRepository
import util.Colors.green
import util.Colors.red
import util.MessageErrorHandler
import util.MessageHandler
import util.Messages
import util.UtilFunctions
import util.UtilFunctions.toColor


class Manager : ParkingRepository {

    private val parking = Parking.initParkingPlacesScheme()
    var timeParking: Long = 0
    var countParking: Int = 0


    override fun parkByCar(carArgs: List<String>) {
        if (checkArgumentsSize(carArgs.size, 5)) {
            val owner = Owner(

                name = carArgs[3],
                surname = carArgs[4]
            )
            val car = Car(
                model = carArgs[0],
                color = carArgs[1],
                number = carArgs[2],
                owner
            )
            val parkingPlace =
                parking.filterValues { value -> value == null }.keys.first()
            parking[parkingPlace] = car
            MessageHandler.successfullyParkingMessage(
                ownerName = owner.name,
                ownerSurname = owner.surname,
                parkingPlace = parkingPlace
            )
            countParking++
            val time = UtilFunctions.initTimer()
            timeParking = System.nanoTime()
            MessageHandler.timeToParkingMessage(time)
        } else {
            MessageErrorHandler.wrongArgumentsMessage(5)
        }
    }

    override fun returnCarByOwner(carArgs: List<String>) {

        if (checkArgumentsSize(carArgs.size, 3)) {
            val owner = Owner(
                name = carArgs[1],
                surname = carArgs[2]
            )
            val car = parking[carArgs[0]] ?: parking.filterValues { it?.number == carArgs[0] }.values.firstOrNull()
            if (car?.owner != owner) {
                MessageErrorHandler.invalidateOwner()
            } else {
                val parkingPlace = parking.filterValues { value -> value == car }.keys.first()
                parking[parkingPlace] = null
                MessageHandler.successfulReturnAutoMessage(parkingPlace)
                val currentTime = UtilFunctions.timerChecked(timeParking)
                MessageHandler.timerParkingMessage(currentTime)
            }
        } else {
            MessageErrorHandler.wrongArgumentsMessage(3)
        }
    }

    override fun getParkInfoByCar(carArgs: List<String>) {

        if (carArgs.size == 1) {
            for (place in parking) {
                if (carArgs[0] == place.value?.number) {
                    Messages.sendMessage("Ваша машина припаркована на месте ${place.key}".toColor(green))
                } else {
                    Messages.sendMessage("Автомобиль с указанным номером на парковке не обнаружен".toColor(red))
                }
                break
            }
        } else {
            Messages.sendMessage("Для получения информации по авто введите его номер".toColor(red))
        }
    }


    override fun getParkIntoByPlace(carArgs: List<String>) {
        val carOnPlace = parking[carArgs[0]]
        if (carOnPlace == null) {
            Messages.sendMessage("На этом месте нет автомобилей".toColor(red))
        } else {
            Messages.sendMessage("На этом месте припаркован автомобиль: ${carOnPlace}".toColor(green))
        }
    }

    override fun getParkingStats() {
        parking.forEach { (key, value) ->
            print("$key - ")
            println(value ?: "free")
        }
    }

    override fun getCountParkingActions() {
        Messages.sendMessage("Количество операций на парковке равно: $countParking".toColor(green))
    }

    private fun checkArgumentsSize(argsParam: Int, size: Int) = argsParam == size
}



