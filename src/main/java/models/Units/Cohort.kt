package models.Units

import models.Modifiers.Honors.EmptyHonor

class Cohort(override var name: String, private var centuries: ArrayList<Century>) : CombinedUnit(name, centuries) {
    var legion: Legion? = null

    var honor = EmptyHonor()
    set(honor)  {
        field = honor
        calculateStats()
    }

    init {
        calculateStats()
    }

    override fun toString(): String {
        return "<Cohort name=\"${name}\" level=${level} xp:${xp} legion:\"${legion?.name}\" stats(h,me,r,mo,d):(${health},${melee},${ranged},${movement},${defense}) honor:${honor.name} centuryCount:${centuries.size}>"
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

    /**
     * FOR DEBUGGING ONLY
     * Lets us see the units in the combined units
     */
    fun printUnits(){
        println("models.Units in $this:")
        for (unit in centuries) {
            println("\t- $unit")
        }
    }

    /**
     * Adds Cohort (and Legion) related code to the takeDamage function
     */
    override fun takeDamage(damage: Int) {
        super.takeDamage(damage)
        removeDisbandedUnits()
        calculateStats()
    }

    /**
     * Builds a new list of models.Units.
     * Only includes models.Units whose health is greater than 0.
     */
    private fun removeDisbandedUnits() {
        val newCenturyList = ArrayList<Century>()

        for (century in centuries) {
            if (century.health > 0) {
                newCenturyList.add(century)
            }
        }

        this.centuries = newCenturyList
    }
}