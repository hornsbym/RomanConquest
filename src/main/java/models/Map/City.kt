/**
 * @author Mitchell Hornsby
 * A City represents a location on a Map.
 * Cities can contain friendly or hostile Units of any type.
 */
package models.Map

import models.Managers.PlayerManager
import models.Managers.UnitManager
import models.Units.Unit

class City(val name: String) {
    // Keep track of all Units within the city
    val hostileUnits = ArrayList<Unit>()
    val friendlyUnits = ArrayList<Unit>()

    // Keep track of all roads connected to the city
    val roads = ArrayList<Road>()

    /**
     * Gets the troops that are supposed to be in the city.
     * This is found in the TroopManager.
     */
    fun getTroops () {
        val playerName = PlayerManager.player.name

        // Empties out both arrays
        friendlyUnits.clear()
        hostileUnits.clear()

        // Gets all troops from the Troop Manager and sorts them by owner
        // Player's troops go in one list, all enemy troops go in the other.
        for (unit in UnitManager.allUnits[name]!!) {
            if (unit.owner == playerName) {
                friendlyUnits.add(unit)
            } else {
                hostileUnits.add(unit)
            }
        }
    }

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
        this.friendlyUnits.addAll(units)
    }

    /**
     * Adds a new unit to the list of hostile units.
     */
    fun addHostileUnit(unit: Unit){
        this.hostileUnits.add(unit)
    }

    /**
     * Adds an array list of units to the list of hostile units
     */
    fun addHostileUnits(units: ArrayList<Unit>) {
        this.hostileUnits.addAll(units)
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
}