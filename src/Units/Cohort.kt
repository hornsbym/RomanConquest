package Units

import Modifiers.Honors.EmptyHonor

class Cohort(private val centuries: ArrayList<Century>) : CombinedUnit(centuries) {
    var honor = EmptyHonor()
    set(honor)  {
        field = honor
        calculateStats()
    }

    init {
        calculateStats()
    }

    override fun toString(): String {
        return "<Cohort level=${level} xp:${xp} stats(h,me,r,mo,d):(${health},${melee},${ranged},${movement},${defense}) banner:${honor.name} troopCount:${centuries.size} >"
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