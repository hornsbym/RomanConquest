package models.Units

import models.Modifiers.Banners.Banner
import models.Modifiers.Banners.EmptyBanner

class Century(override var name: String , private var troops: ArrayList<Troop>): CombinedUnit(name, troops) {
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


    /**
     * FOR DEBUGGING ONLY
     * Lets us see the units in the combined units
     */
    fun printUnits(){
        println("models.Units in $this:")
        for (unit in troops) {
            println("\t- $unit")
        }
    }

    /**
     * Adds Century specific code to the takeDamage method
     */
    override fun takeDamage(damage: Int) {
        super.takeDamage(damage)
        removeDeadTroops()
        calculateStats()
    }

    /**
     * Builds a new list of Troops.
     * Only includes Troops whose health is greater than 0.
     */
    private fun removeDeadTroops() {
        val newTroopList = ArrayList<Troop>()

        for (troop in troops) {
            if (troop.health > 0) {
                newTroopList.add(troop)
            }
        }

        this.troops = newTroopList
        println("New troops in ${this.name}: " + this.troops)
    }
}