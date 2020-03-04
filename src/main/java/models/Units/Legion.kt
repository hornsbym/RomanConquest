package models.Units

import models.Modifiers.Standards.EmptyStandard

class Legion(override var name: String, private val cohorts: ArrayList<Cohort>) : CombinedUnit(name, cohorts) {
    var standard = EmptyStandard()
        set(standard)  {
            field = standard
            calculateStats()
        }

    init {
        calculateStats()
    }

    override fun toString(): String {
        return name
    }

    override fun calculateStats() {
        super.calculateStats()
        applyStandardBonuses()
    }

    private fun applyStandardBonuses() {
        health += standard.healthBoost
        melee += standard.meleeBoost
        ranged += standard.rangedBoost
        movement += standard.movementBoost
        defense += standard.defenseBoost
    }
}