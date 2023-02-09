package data

object Parking {


    fun initParkingPlacesScheme(): MutableMap<String, Car?> {
        val parkingPlaces = mutableMapOf<String, Car?>()
        for (index in 1..20) {
            parkingPlaces["P$index"] = null
        }
        return parkingPlaces
    }
}

