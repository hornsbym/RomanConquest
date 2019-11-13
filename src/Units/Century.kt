package Units

import Units.Banners.EmptyBanner
import kotlin.math.floor
import kotlin.math.roundToInt

class Century(private val troops: ArrayList<Troop>) {
    var melee  = 0
    var ranged = 0
    var movement = 0
    var defense = 0

    var xp = 0
    var level = 1

    var banner = EmptyBanner()
    var cohesion = 1f

    init {
        calculateStats()
    }

    /**
     * Calculates the statistics for the entire Century, accounting for cohesion modifier and banner bonuses
     *
     */
    private fun calculateStats() {
        calculateMelee()
        calculateRanged()
        calculateMovement()
        calculateDefense()
        applyBannerBonuses()
    }

    /**
     * Applies any boosts provided by  the Century's banner
     */
    private fun applyBannerBonuses() {
        melee += banner.meleeBoost
        ranged += banner.rangedBoost
        movement += banner.movementBoost
        defense += banner.defenseBoost
    }

    /**
     * Sums each troops' melee attack values and multiplies it by the Century's cohesion bonus
     */
    private fun calculateMelee() {
        // Sums up the total of all troops in the century
        for (troop in troops) {
            melee += troop.melee
        }

        melee = (melee * cohesion).roundToInt()
    }

    /**
     * Sums each troops' ranged attack values and multiplies it by the Century's cohesion bonus
     */
    private fun calculateRanged() {
        // Sums up the total of all troops in the century
        for (troop in troops) {
            ranged += troop.ranged
        }

        ranged = (ranged * cohesion).roundToInt()
    }

    /**
     * Finds the average movement value of the Century, then rounds down to the nearest integer
     */
    private fun calculateMovement() {
        // Sums up the total of all troops in the century
        for (troop in troops) {
            movement += troop.movement
        }

        movement = floor(movement.div(troops.size).toDouble()).toInt()
    }

    /**
     * Sums each troops' defense values and multiplies it by the Century's cohesion bonus
     */
    private fun calculateDefense() {
        // Sums up the total of all troops in the century
        for (troop in troops) {
            defense += troop.defense
        }

        defense = (defense * cohesion).roundToInt()
    }
}