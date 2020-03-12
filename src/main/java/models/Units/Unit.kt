/**
 * @author Mitchell Hornsby
 * Class for any military unit in the game.
 * Must be implemented whenever a new unit is introduced to the game.
 */
package models.Units

abstract class Unit (override var name: String, override var level: Int, override var xp: Int, override var owner: String,
                     override var currentCity: String) : UnitInterface {
    override var health = TroopBaseStats.TROOP_HEALTH
    override var melee  = 0
    override var ranged = 0
    override var movement = 0
    override var defense = 0
    override var purchaseCost = 0
    override var trainingCost = 0

    var remainingMoves = movement

    /**
     * Function for changing a troop's health value.
     * Subtracts the damage argument from the unit's health.
     */
    open fun takeDamage(damage: Int) {
        health -= damage
    }

    /**
     * Function for determining whether or not a unit can perform an action this turn.
     * Moves are spent whenever a unit moves or attacks.
     */
    fun canMove(): Boolean {
        when (remainingMoves > 0) {
            true -> return true
            false -> return false
        }
    }

    /**
     * Resets the number of actions unit can take.
     * This will be called at the beginning of each turn.
     */
    fun resetMoves() {
        remainingMoves = movement
    }
}