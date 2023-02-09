package repository

import data.Car

interface ParkingRepository {


    fun parkByCar(carArgs: List<String>)

    fun returnCarByOwner(carArgs: List<String>)

    fun getParkInfoByCar(carArgs: List<String>)

    fun getParkIntoByPlace(carArgs: List<String>)

    fun getParkingStats()

    fun getCountParkingActions()
}