package data

object Parking {

    var parkingPlaces = mutableMapOf<String, String>()

    fun initParkingPlacesScheme() {
        for (index in 1..20) {
            parkingPlaces["P$index"] = "Free"
        }
    }
}

