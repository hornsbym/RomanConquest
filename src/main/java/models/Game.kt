/**
 * @author Mitchell Hornsby
 * Contains all of the game logic.
 * Top level model.
 */
package models

import models.Factories.TroopFactory
import models.Managers.*
import models.Map.Map
import models.Map.City
import models.Units.CombinedUnit
import models.Units.Unit

class Game (var name: String, var settings: GameSettings) {
    val map = Map()
    var turn = 0

    init {
        PlayerManager.createPlayer(name)
    }

    /**
     * Allows players to purchase Troops if they have enough gold.
     * Doesn't do anything if they don't.
     */
    fun purchaseTroops(troopConstant: Int, number: Int) {
        val availableGold = PlayerManager.player.gold

        // Behaves differently based on which troop is being created
        when (troopConstant) {
            Constants.INFANTRY -> {
                if (availableGold >= (TroopCosts.INFANTRY * number)) {
                    TroopFactory.newPlayerInfantry()
                    PlayerManager.player.gold -= TroopCosts.CAVALRY
                }
            }
            Constants.RANGED -> {
                if (availableGold >= (TroopCosts.RANGED * number)) {
                    TroopFactory.newPlayerRanged()
                    PlayerManager.player.gold -= TroopCosts.CAVALRY
                }
            }
            Constants.CAVALRY -> {
                if (availableGold >= (TroopCosts.CAVALRY * number)) {
                    TroopFactory.newPlayerCavalry()
                    PlayerManager.player.gold -= TroopCosts.CAVALRY
                }
            }
            else -> {
                throw Error("Unrecognized troop constant")
            }
        }

        GameManager.game.map.updateCityTroopLists()
    }

    /**
     * Allows players to move units from one city to another, if they have remaining moves.
     * Deducts their remaining moves by 1.
     */
    fun moveUnits(units: ArrayList<Unit>, city: City) {
        // Assign to variables for readability
        val targetCity = city.name

        // Remove from the current city, add to the target city
        UnitManager.moveUnits(units, targetCity)
    }

    /**
     * Allows players to combine units.
     */
    fun combineUnits(units: ArrayList<Unit>) {
        UnitCombiner.combineUnits(units)

        // Updates the map if there's been any changes
        GameManager.game.map.updateCityTroopLists()
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

    fun battle(attackingUnits: ArrayList<Unit>, defendingUnits: ArrayList<Unit>) {
        BattleManager.fullBattle(attackingUnits, defendingUnits)
    }

    /**
     * Performs all end-turn game logic.
     * Takes training gold from the player, decreases move count for travelling units, and creates and moves enemy units.
     */
    fun nextTurn() {
        TrainingManager.trainAll()
        UnitManager.resetMoves()
        EnemyManager.addEnemiesToMap()
        turn++
    }
}
