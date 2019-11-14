package Units

import TroopBaseStats;

class Troop(var level: Int, var xp: Int, val classification: Int) {
    var health = TroopBaseStats.TROOP_HEALTH
    var melee  = 0
    var ranged = 0
    var movement = 0
    var defense = 0

    init {
        // Assigns strengths depending on a Troop's class
        when(classification){
            Constants.INFANTRY -> {applyInfantryStats()}
            Constants.RANGED -> {applyRangedStats()}
            Constants.CAVALRY -> {applyCavalryStats()}
        }
    }

    override fun toString(): String {
        return "<Troop level=${level} xp:${xp} stats(h,me,r,mo,d):(${health}, ${melee}, ${ranged}, ${movement}, ${defense}) class=${classification}>"
    }

    /**
     * Sets the troop's stats to the default Infantry loadout
     */
    private fun applyInfantryStats() {
        melee = TroopBaseStats.INFANTRY_MELEE
        ranged = TroopBaseStats.INFANTRY_RANGED
        movement = TroopBaseStats.INFANTRY_MOVEMENT
        defense = TroopBaseStats.INFANTRY_DEFENSE
    }

    /**
     * Sets the troop's stats to the default Ranged loadout
     */
    private fun applyRangedStats() {
        melee = TroopBaseStats.RANGED_MELEE
        ranged = TroopBaseStats.RANGED_RANGED
        movement = TroopBaseStats.RANGED_MOVEMENT
        defense = TroopBaseStats.RANGED_DEFENSE
    }

    /**
     * Sets the troop's stats to the default Cavalry loadout
     */
    private fun applyCavalryStats() {
        melee = TroopBaseStats.CAVALRY_MELEE
        ranged = TroopBaseStats.CAVALRY_RANGED
        movement = TroopBaseStats.CAVALRY_MOVEMENT
        defense = TroopBaseStats.CAVALRY_DEFENSE
    }
}