package data

import repository.ParkingRepository
import util.Messages
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter



class Manager : ParkingRepository {


    private val parking = Parking.initParkingPlacesScheme()
    var time: String? = ""


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
                parking.filterValues { value -> value == null }.keys.firstOrNull()
                    ?: throw ArgumentsException("Введены неверные аргументы для запроса," +
                            "повторите попытку")

            parking[parkingPlace] = car
            println("Автомобиль владельца ${owner.name} ${owner.surname} успешно припаркован на месте $parkingPlace")
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
                val parkingPlace = parking.filterValues { value -> value  == car }.keys.first()
                parking[parkingPlace] = null
                Messages.sendMessage("Автомобиль был возвращен владельцу, место \"$parkingPlace\" теперь свободно")
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
        parking.forEach{println(it)}
    }
}

fun initTimer(): String {
    val time =  LocalDateTime.now()
        .format(DateTimeFormatter.ofPattern("MMM dd yyyy, hh:mm:ss a"))
    return time
}

fun getTime(currentTime: Int): String {
    val initTime = initTimer().toInt()
    val time = currentTime - initTime
    return time.toString()
}

class ArgumentsException(override val message: String?): IllegalArgumentException(){}




