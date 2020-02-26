package models.Units

import kotlin.math.floor
import kotlin.math.roundToInt
import kotlin.random.Random

// <out Unit> I think means "Accept any subclass of type Unit"?
abstract class CombinedUnit (override var name: String, private var units: ArrayList<out Unit>): Unit(name,1, 0), CombinedUnitInterface {
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

        if (units.size > 0) {
            calculateHealth()
            calculateMelee()
            calculateRanged()
            calculateMovement()
            calculateDefense()
        }
    }

    /**
     * Calculates the Century's health based on it's Troops' combined health values
     */
    private fun calculateHealth() {
        for (unit in units) {
            health += unit.health
        }

        health = (health * Constants.COMBINED_UNIT_HEALTH_MULTIPLIER).toInt()
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

//    /**
//     * FOR DEBUGGING ONLY
//     * Lets us see the units in the combined units
//     */
//    fun printUnits(){
//        println("models.Units in $this:")
//        for (unit in units) {
//            println("\t- $unit")
//        }
//    }

    /**
     * Overrides the "takeDamage" method of the abstract Unit.
     * Disperses the damage taken evenly over all models.Units that comprise the CombinedUnit
     */
    override fun takeDamage(damage: Int){
        // Calculates how much damage each unit should receive as a double
        val exactDamagePerUnit = damage.div(units.size.toDouble())

        // Turns that into a string
        val exactDamageAsString = exactDamagePerUnit.toString()

        // Separates the whole number from the decimal
        val wholeAndDecimalList = exactDamageAsString.split(".")

        // Isolates the whole and decimals
        val whole = wholeAndDecimalList[0].toInt()
        val decimal = (".${wholeAndDecimalList[1]}").toDouble()

        // Applies the whole number damage to all troops in the unit
        for (unit in units) {
            unit.takeDamage(whole)
        }

        // Randomly applies the remaining damage to random Troops
        val disperseDecimal = (decimal * units.size.toDouble()).toInt()
        for (x in 0..disperseDecimal){
            val randomTroopIndex = Random.nextInt(0, units.size)
            units[randomTroopIndex].takeDamage(1)
        }
    }

    /**
     * Method for removing units from the master list of units.
     * Happens when moving units around or whenever a unit dies/disbands
     */
    fun removeUnit(unitForRemoval: Unit) {
        units.remove(unitForRemoval)
    }
}