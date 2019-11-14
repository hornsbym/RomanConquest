package Units

import Units.Banners.Banner
import Units.Banners.EmptyBanner
import kotlin.math.floor
import kotlin.math.roundToInt

class Century(private val troops: ArrayList<Troop>) {
    var health = 0
    var melee  = 0
    var ranged = 0
    var movement = 0
    var defense = 0

    var xp = 0
    var level = 1
    var cohesion = 1f

    // Holds banner info here... re-calculates stats every time banner changes
    var banner: Banner = EmptyBanner()
    set(newBanner) {
        field = newBanner
        calculateStats()
    }

    init {
        calculateStats()
    }

    override fun toString(): String {
        return "<Century level=${level} xp:${xp} stats(h,me,r,mo,d):(${health}, ${melee}, ${ranged}, ${movement}, ${defense}) banner:${banner.name} troopCount:${troops.size}>"
    }

    /**
     * Calculates the statistics for the entire Century, accounting for cohesion and banner bonuses
     */
    private fun calculateStats() {
        // Sets melee, ranged, movement, and defense to 0 so they can be summed accurately
        zeroStats()

        calculateHealth()
        calculateMelee()
        calculateRanged()
        calculateMovement()
        calculateDefense()
        applyBannerBonuses()
    }

    private fun zeroStats() {
        health = 0
        melee  = 0
        ranged = 0
        movement = 0
        defense = 0
    }

    /**
     * Applies any boosts provided by  the Century's banner
     */
    private fun applyBannerBonuses() {
        health += banner.healthBoost
        melee += banner.meleeBoost
        ranged += banner.rangedBoost
        movement += banner.movementBoost
        defense += banner.defenseBoost
    }

    /**
     * Calculates the Century's health based on it's Troops' combined health values
     */
    private fun calculateHealth() {
        for (troop in troops) {
            health += troop.health
        }

        health = (health * Constants.CENTURY_HEALTH_MULTIPLIER).toInt()
    }

    /**
     * Sums each troops' melee attack values and multiplies it by the Century's cohesion bonus
     */
    private fun calculateMelee() {
        // Sums up the total melee attack of all troops in the century
        for (troop in troops) {
            melee += troop.melee
        }

        melee = (melee * cohesion).roundToInt()
    }

    /**
     * Sums each troops' ranged attack values and multiplies it by the Century's cohesion bonus
     */
    private fun calculateRanged() {
        // Sums up the total range attack of all troops in the century
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

        // Gets the average of the Troops' movement, rounded down
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