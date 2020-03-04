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

    /**
     * Adds an array list of units to the list of friendly units
     */
    fun addFriendlyUnits(units: ArrayList<Unit>) {
        friendlyUnits.addAll(units)
    }

    /**
     * Removes the given units from the list of friendly units.
     */
    fun removeFriendlyUnits(units: ArrayList<Unit>) {
        friendlyUnits.removeAll(units)
    }

    /**
     * Gets only the cities connected to this city by a road.
     */
    fun getAdjacentCities(): ArrayList<City> {
        val adjCities = ArrayList<City>()

        // Iterates over all roads connected to the city.
        // Only returns cities attached to those roads if it's not this city.
        for (road in roads) {
            if (road.city1 !== this){
                adjCities.add(road.city1)
            } else if (road.city2 !== this) {
                adjCities.add(road.city2)
            }
        }

        return adjCities
    }

    /**
     * Moves units from one city to an adjacent city.
     */
    fun transferUnits(units: ArrayList<Unit>, targetCity: City) {
        for (unit in units){
            if (this.friendlyUnits.contains(unit)){
                targetCity.addFriendlyUnit(unit)
                this.friendlyUnits.remove(unit)
            }
        }
//        targetCity.addFriendlyUnits(units)
//        removeFriendlyUnits(units)
    }
}