package Units

import Units.Banners.Banner
import Units.Banners.EmptyBanner
import kotlin.math.floor
import kotlin.math.roundToInt

class Century(private val troops: ArrayList<Troop>): CombinedUnit(troops) {
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

    override fun calculateStats() {
        super.calculateStats()
        applyBannerBonuses()
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
}