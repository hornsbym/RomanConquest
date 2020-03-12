/**
 * @author Mitchell Hornsby
 * Singleton object for keeping track of a player's troops
 */
package models.Managers

import models.Units.CombinedUnit
import models.Units.Troop
import models.Units.Unit

/**
 * Responsible for maintaining references to all units in the game.
 * Intended to make finding units easier/faster.
 */
object UnitManager {
    // Holds a dictionary for finding troops
    // Each city in the game will maintain its troops here
    val allUnits = HashMap<String, ArrayList<Unit>>()

    /**
     * Initializes the three main classifications of troops in the dictionary
     * Makes finding a particular troop much easier
     * */
    init {
        // Maintains a dictionary of all troops in all cities in the game
        // Keys in this dictionary are the city names
        for (cityName in GameManager.game.map.cities.keys) {
            allUnits[cityName] = ArrayList()
        }
    }

    /**
     * Lets us look at the troop list
     */
    override fun toString(): String {
        var returnString = ""

        for (cityName in allUnits.keys) {
            returnString += "${cityName}: ["

            for (troop in allUnits[cityName]!!) {
                returnString += troop.toString()
            }
            returnString += "]\n"
        }

        return returnString
    }

    /**
     * Adds a given unit to the unit list for the city the unit's in
     */
    fun addUnit(unit: Unit){
        allUnits[unit.currentCity]!!.add(unit)
    }

    /**
     * Removes a given unit from the unit list for the city that unit's in
     */
    fun removeUnit(unit: Unit){
        allUnits[unit.currentCity]!!.remove(unit)
    }

    /**
     * Removes a list of units from the unit manager
     */
    fun removeUnits(units: ArrayList<out Unit>) {
        // Removes units this way in case all units in the list aren't from the same city
        for (unit in units) {
            removeUnit(unit)
        }
    }

    /**
     * Moves a group of units from their current city to another.
     */
    fun moveUnits(units: ArrayList<Unit>, targetCity: String) {
        // Only moves any troop if all troops if all troops can move
        if (Utils.allUnitsCanMove(units)) {
            for (unit in units) {
                removeUnit(unit)
                unit.currentCity = targetCity
                addUnit(unit)
                unit.remainingMoves--
            }
            GameManager.game.map.updateCityTroopLists()
        }
    }

    /**
     * Resets the moves for all Units in the game.
     */
    fun resetMoves() {
        for (cityName in allUnits.keys) {
            for (unit in allUnits[cityName]!!) {
                unit.resetMoves()
            }
        }
    }
}