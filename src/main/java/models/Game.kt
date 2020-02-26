/**
 * @author Mitchell Hornsby
 * Contains all of the game logic.
 * Top level model.
 */
package models

import models.Map.Map
import models.Managers.PlayerManager
import models.Units.Troop

class Game (var name: String, var settings: GameSettings) {
    val map = Map()

    init {
        PlayerManager.createPlayer(name)
    }

    /**
     * Allows players to purchase Troops if they have enough gold.
     * Doesn't do anything if they don't.
     */
    fun purchaseTroops(troop: Troop, number: Int = 1) {
        val availableGold = PlayerManager.player.gold
        if (availableGold >= (troop.cost * number)) {
            PlayerManager.player.selectedCity!!.addFriendlyUnit(troop)
        }
    }
}
