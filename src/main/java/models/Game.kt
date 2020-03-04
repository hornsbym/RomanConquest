/**
 * @author Mitchell Hornsby
 * Contains all of the game logic.
 * Top level model.
 */
package models

import models.Map.Map
import models.Managers.PlayerManager
import models.Managers.TrainingManager
import models.Managers.UnitCombiner
import models.Map.City
import models.Units.CombinedUnit
import models.Units.Troop
import models.Units.Unit

class Game (var name: String, var settings: GameSettings) {
    val map = Map()
    val turn = 0

    init {
        PlayerManager.createPlayer(name)
    }

    /**
     * Allows players to purchase Troops if they have enough gold.
     * Doesn't do anything if they don't.
     */
    fun purchaseTroops(troop: Troop, number: Int) {
        val availableGold = PlayerManager.player.gold
        if (availableGold >= (troop.purchaseCost * number)) {
            PlayerManager.player.selectedCity!!.addFriendlyUnit(troop)
            PlayerManager.player.gold -= troop.purchaseCost
        }
    }

    /**
     * Allows players to move units from one city to another.
     */
    fun moveUnits(units: ArrayList<Unit>, city: City) {
        // Assign to variables for readability
        val selectedCity = PlayerManager.player.selectedCity!!
        val targetCity = city

        // Remove from the current city, add to the target city
        targetCity.addFriendlyUnits(units)
        selectedCity.removeFriendlyUnits(units)
    }

    /**
     * Allows players to combine units.
     */
    fun combineUnits(units: ArrayList<Unit>) {
        val combinedUnit = UnitCombiner.combineUnits(units)
        if (combinedUnit != null) {
            val selectedCity = PlayerManager.player.selectedCity!!
            selectedCity.removeFriendlyUnits(units)
            selectedCity.addFriendlyUnit(combinedUnit)
        }
    }

    /**
     * Allows players to combine units.
     */
    fun disbandUnits(units: ArrayList<Unit>) {
        for (unit in units) {
            if (unit is CombinedUnit) {
                // Gets the selected city
                val selectedCity = PlayerManager.player.selectedCity!!

                // Get the troops to add back in place of the disbanded unit
                val disbandedUnits = UnitCombiner.disband(unit)

                // Removes the disbanded unit
                val removalList = ArrayList<Unit>()
                removalList.add(unit)
                selectedCity.removeFriendlyUnits(removalList)

                // Adds back in the disbanded troops
                for (disbandedUnit in disbandedUnits) {
                    selectedCity.addFriendlyUnit(disbandedUnit)
                }
            }
        }
    }

    /**
     * Performs all end-turn game logic.
     * Takes training gold from the player, decreases move count for travelling units, and creates and moves enemy units.
     */
    fun nextTurn() {
        TrainingManager.trainAll()
    }
}
