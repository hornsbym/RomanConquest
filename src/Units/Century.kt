package Units

import kotlin.math.floor
import kotlin.math.roundToInt

class Century(private val troops: ArrayList<Troop>) {
    var melee  = 0
    var ranged = 0
    var movement = 0
    var defense = 0

    var banner = Constants.NONE
    var cohesion = 1f

    init {
        calculateStats()
    }

    private fun calculateStats() {
        calculateMelee()
        calculateRanged()
        calculateMovement()
        calculateDefense()
    }

    private fun calculateMelee() {
        // Sums up the total of all troops in the century
        for (troop in troops) {
            melee += troop.melee
        }

        melee = (melee * cohesion).roundToInt()
    }

    private fun calculateRanged() {
        // Sums up the total of all troops in the century
        for (troop in troops) {
            ranged += troop.ranged
        }

        ranged = (ranged * cohesion).roundToInt()
    }

    private fun calculateMovement() {
        // Sums up the total of all troops in the century
        for (troop in troops) {
            movement += troop.movement
        }

        movement = floor(movement.div(troops.size).toDouble()).toInt()
    }

    private fun calculateDefense() {
        // Sums up the total of all troops in the century
        for (troop in troops) {
            defense += troop.defense
        }

        defense = (defense * cohesion).roundToInt()
    }
}