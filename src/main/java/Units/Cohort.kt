package Units

import Modifiers.Honors.EmptyHonor

class Cohort(override var name: String, private val centuries: ArrayList<Century>) : CombinedUnit(name, centuries) {
    var honor = EmptyHonor()
    set(honor)  {
        field = honor
        calculateStats()
    }

    init {
        calculateStats()
    }

    override fun toString(): String {
        return "<Cohort name=\"${name}\" level=${level} xp:${xp} stats(h,me,r,mo,d):(${health},${melee},${ranged},${movement},${defense}) honor:${honor.name} centuryCount:${centuries.size}>"
    }

    override fun calculateStats() {
        super.calculateStats()
        applyHonorBonuses()
    }

    private fun applyHonorBonuses() {
        health += honor.healthBoost
        melee += honor.meleeBoost
        ranged += honor.rangedBoost
        movement += honor.movementBoost
        defense += honor.defenseBoost
    }
}