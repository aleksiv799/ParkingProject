package repository

interface ParkingRepository {


    fun parkByCar(parkPlace: MutableMap<String, String>)

    fun returnCarByOwner(parkPlace: MutableMap<String, String>)

    fun getParkInfoByCar(parkPlace: MutableMap<String, String>)

    fun getParkIntoByPlace(parkPlace: MutableMap<String, String>)
}