package data

import repository.ParkingRepository
import util.Messages
import util.UtilFunctions
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class Manager : ParkingRepository {

    private val util = UtilFunctions()
    private val parking = Parking.initParkingPlacesScheme()
    var timeParking: Long = 0
    var countParking: Int = 0


    override fun parkByCar(carArgs: List<String>) {
        if (carArgs.size == 5) {
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
            Messages.sendMessage("Автомобиль владельца ${owner.name} ${owner.surname} успешно припаркован на месте $parkingPlace")
            countParking++
            val time = util.initTimer()
            timeParking = System.currentTimeMillis()
            Messages.sendMessage("Время парковки Вашего автомобиля:  $time")
        } else {
            Messages.sendMessage("Неверное количество аргументов, количество аргументов должно быть равно 5")
        }
    }

    override fun returnCarByOwner(carArgs: List<String>) {
        if (carArgs.size == 3) {
            val owner = Owner(
                name = carArgs[1],
                surname = carArgs[2]
            )
            val car = parking[carArgs[0]] ?: parking.filterValues { it?.number == carArgs[0] }.values.firstOrNull()
            if (car?.owner != owner) {
                Messages.sendMessage("Этот автомобиль не Ваш! Повторите попытку пожалуйста")
            } else {
                val parkingPlace = parking.filterValues { value -> value == car }.keys.first()
                parking[parkingPlace] = null
                Messages.sendMessage("Автомобиль был возвращен владельцу, место \"$parkingPlace\" теперь свободно")
                val currentTime = (System.currentTimeMillis() - timeParking)/3600
                Messages.sendMessage("Время пребывания на парковке вашего автомобиля - $currentTime секунд")
            }
        }
    }

    override fun getParkInfoByCar(carArgs: List<String>) {
        if (carArgs.size == 1) {
            for (place in parking) {
                if (carArgs[0] == place.value?.number) {
                    Messages.sendMessage("Ваша машина припаркована на месте ${place.key}")
                } else {
                    Messages.sendMessage("Автомобиль с указанным номером на парковке не обнаружен")
                }
                break
            }
        } else {
            Messages.sendMessage("Неверное количество аргументов, количество аргументов должно быть равно 1")
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
        parking.forEach{(key, value) ->
            print("$key - ")
            println(value ?: "free")
        }
    }

    override fun getCountParkingActions() {
        Messages.sendMessage("Количество операций на парковке равно: $countParking")
    }


}

class ArgumentsException(override val message: String?) : IllegalArgumentException() {}




