package models.Units

import TroopBaseStats

class Troop(override var name: String, override var level: Int, override var xp: Int, val classification: Int): Unit(name, level, xp) {
    var century: Century? = null

    init {
        // Assigns strengths depending on a Troop's class
        when(classification){
            Constants.INFANTRY -> {applyInfantryStats()}
            Constants.RANGED -> {applyRangedStats()}
            Constants.CAVALRY -> {applyCavalryStats()}
        }
    }

    override fun toString(): String {
        return "<Troop name=\"${name}\" level=${level} xp:${xp} century:\"${century?.name}\" stats(h,me,r,mo,d):(${health}, ${melee}, ${ranged}, ${movement}, ${defense}) class=${classification}>"
    }

    /**
     * Sets the troop's stats to the default Infantry loadout
     */
    private fun applyInfantryStats() {
        melee = TroopBaseStats.INFANTRY_MELEE
        ranged = TroopBaseStats.INFANTRY_RANGED
        movement = TroopBaseStats.INFANTRY_MOVEMENT
        defense = TroopBaseStats.INFANTRY_DEFENSE
        cost = TroopCosts.INFANTRY
    }

    /**
     * Sets the troop's stats to the default Ranged loadout
     */
    private fun applyRangedStats() {
        melee = TroopBaseStats.RANGED_MELEE
        ranged = TroopBaseStats.RANGED_RANGED
        movement = TroopBaseStats.RANGED_MOVEMENT
        defense = TroopBaseStats.RANGED_DEFENSE
        cost = TroopCosts.RANGED
    }

    /**
     * Sets the troop's stats to the default Cavalry loadout
     */
    private fun applyCavalryStats() {
        melee = TroopBaseStats.CAVALRY_MELEE
        ranged = TroopBaseStats.CAVALRY_RANGED
        movement = TroopBaseStats.CAVALRY_MOVEMENT
        defense = TroopBaseStats.CAVALRY_DEFENSE
        cost = TroopCosts.CAVALRY
    }
}