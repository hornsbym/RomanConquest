package Units

import kotlin.math.floor
import kotlin.math.roundToInt

// <out Unit> I think means "Accept any subclass of type Unit?
abstract class CombinedUnit (override var name: String, private val units: ArrayList<out Unit>): Unit(name,1, 0), CombinedUnitInterface {
    override var health = TroopBaseStats.TROOP_HEALTH
    override var melee  = 0
    override var ranged = 0
    override var movement = 0
    override var defense = 0

    override var cohesion = 1f

    /**
     * Resets a CombinedUnit's stats to 0 so they can be re-calculated
     */
    private fun zeroStats() {
        health = 0
        melee  = 0
        ranged = 0
        movement = 0
        defense = 0
    }

    /**
     * Calculates the statistics for the entire Century, accounting for cohesion and banner bonuses
     */
    protected open fun calculateStats() {
        // Sets melee, ranged, movement, and defense to 0 so they can be summed accurately
        zeroStats()

        calculateHealth()
        calculateMelee()
        calculateRanged()
        calculateMovement()
        calculateDefense()
    }

    /**
     * Calculates the Century's health based on it's Troops' combined health values
     */
    private fun calculateHealth() {
        for (unit in units) {
            health += unit.health
        }

        health = (health * Constants.CENTURY_HEALTH_MULTIPLIER).toInt()
    }

    /**
     * Sums each unit's' melee attack values and multiplies it by the Century's cohesion bonus
     */
    private fun calculateMelee() {
        // Sums up the total melee attack of all troops in the century
        for (unit in units) {
            melee += unit.melee
        }

        melee = (melee * cohesion).roundToInt()
    }

    /**
     * Sums each troops' ranged attack values and multiplies it by the Century's cohesion bonus
     */
    private fun calculateRanged() {
        // Sums up the total range attack of all troops in the century
        for (unit in units) {
            ranged += unit.ranged
        }

        ranged = (ranged * cohesion).roundToInt()
    }

    /**
     * Finds the average movement value of the Century, then rounds down to the nearest integer
     */
    private fun calculateMovement() {
        // Sums up the total of all troops in the century
        for (unit in units) {
            movement += unit.movement
        }

        // Gets the average of the Troops' movement, rounded down
        movement = floor(movement.div(units.size).toDouble()).toInt()
    }

    /**
     * Sums each troops' defense values and multiplies it by the Century's cohesion bonus
     */
    private fun calculateDefense() {
        // Sums up the total of all troops in the century
        for (unit in units) {
            defense += unit.defense
        }

        defense = (defense * cohesion).roundToInt()
    }

}