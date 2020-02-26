/**
 * @author Mitchell Hornsby
 * A City represents a location on a Map.
 * Cities can contain friendly or hostile Units of any type.
 */
package models.Map

import models.Units.Unit

class City(val name: String) {
    // Keep track of all Units within the city
    val hostileUnits = ArrayList<Unit>()
    val friendlyUnits = ArrayList<Unit>()

    // Keep track of all roads connected to the city
    val roads = ArrayList<Road>()

    /**
     * Adds a new road between two cities.
     */
    fun addRoad(newRoad: Road) {
        this.roads.add(newRoad)
    }

    /**
     * Adds a new unit to the list of friendly units.
     */
    fun addFriendlyUnit(unit: Unit){
        this.friendlyUnits.add(unit)
    }
}