package data

import repository.ParkingRepository
import util.MessageErrorHandler
import util.MessageHandler
import util.Messages
import util.UtilFunctions

class Manager : ParkingRepository {

    private val util = UtilFunctions()
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
            val time = util.initTimer()
            timeParking = System.currentTimeMillis()
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
                val currentTime = (System.currentTimeMillis() - timeParking) / 3600
                MessageHandler.timerParkingMessage(currentTime)
            }
        } else {
            MessageErrorHandler.wrongArgumentsMessage(3)
        }
    }

    override fun getParkInfoByCar(carArgs: List<String>) {
        if (checkArgumentsSize(carArgs.size, 1)) {
            for (place in parking) {
                when (place.value?.number) {
                    carArgs[0] -> {
                        Messages.sendMessage("Ваша машина припаркована на месте ${place.key}")
                        break
                    }
                    else -> {
                        Messages.sendMessage("нет такого автомобиля")
                        break
                    }
                }
            }
        } else {
            MessageErrorHandler.wrongArgumentsMessage(1)
        }
    }


    override fun getParkIntoByPlace(carArgs: List<String>) {
        val carOnPlace = parking[carArgs[0]]
        if (carOnPlace == null) {
            Messages.sendMessage("На этом месте нет автомобилей")
        } else {
            Messages.sendMessage("На этом месте припаркован автомобиль: ${carOnPlace}")
        }
    }

    override fun getParkingStats() {
        parking.forEach { (key, value) ->
            print("$key - ")
            println(value ?: "free")
        }
    }

    override fun getCountParkingActions() {
        Messages.sendMessage("Количество операций на парковке равно: $countParking")
    }

    private fun checkArgumentsSize(argsParam: Int, size: Int) = argsParam == size
}



