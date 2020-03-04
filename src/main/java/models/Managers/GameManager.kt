/**
 * @author Mitchell Hornsby
 * Singleton object that allows universal access to the Game object
 */
package models.Managers

import models.Game
import models.Map.City
import models.Units.Troop
import models.Units.Unit

object GameManager {
    lateinit var game: Game

    /**
     * Allows users to purchase troops
     */
    fun purchaseTroops(troop: Troop, number: Int = 1) {
        game.purchaseTroops(troop, number)
    }

    /**
     * Allows users to move units from one city to an adjacent city.
     */
    fun moveUnits(units: ArrayList<Unit>, city: City) {
        game.moveUnits(units, city)
    }

    /**
     * Allows users to combine troops.
     */
    fun combineUnits(units: ArrayList<Unit>) {
        game.combineUnits(units)
    }

    /**
     * Allows users to disband troops
     */
    fun disbandUnits(combinedUnits: ArrayList<Unit>) {
        game.disbandUnits(combinedUnits)
    }

    /**
     * Advances play to the next turn.
     */
    fun nextTurn() {
        game.nextTurn()
    }
}