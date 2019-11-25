package Units

import Modifiers.Banners.Banner
import Modifiers.Banners.EmptyBanner

class Century(override var name: String , private val troops: ArrayList<Troop>): CombinedUnit(name, troops) {
    var cohort: Cohort? = null

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
        return "<Century name=\"${name}\" level=${level} xp:${xp} cohort:\"${cohort?.name}\" stats(h,me,r,mo,d):(${health},${melee},${ranged},${movement},${defense}) banner:${banner.name} troopCount:${troops.size}>"
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