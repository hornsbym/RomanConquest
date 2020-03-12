package models.Units

interface CombinedUnitInterface {
    var cohesion: Float

    /**
     * Should return an array list of each Troop unit that comprises the combined unit, no matter which combined unit it is.
     */
    fun getAllTroops(): ArrayList<Troop>
}