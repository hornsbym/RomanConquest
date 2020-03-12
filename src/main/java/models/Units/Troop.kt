package models.Units

import TroopBaseStats
import models.Managers.UnitManager
import kotlin.math.roundToInt

class Troop(override var name: String, override var level: Int, override var xp: Int, val classification: Int,
            override var owner: String, override var currentCity: String): Unit(name, level, xp, owner, currentCity) {
    var century: Century? = null
    var levelUpRequirement = 100

    init {
        // Assigns strengths depending on a Troop's class
        when(classification){
            Constants.INFANTRY -> {applyInfantryStats()}
            Constants.RANGED -> {applyRangedStats()}
            Constants.CAVALRY -> {applyCavalryStats()}
        }
    }

    override fun toString(): String {
        return "${owner}, ${name}"
    }

    /**
     * Adds troop death functionality to the stock unit take damage.
     */
    override fun takeDamage(damage: Int) {
        // Decreases the troop's HP
        super.takeDamage(damage)

        // Removes the troop from the game if it reaches below 0 health
        if (this.health <= 0){
            this.die()
        }
    }

    /**
     * Removes the troop from the master troop list.
     */
    private fun die() {
        UnitManager.removeUnit(this)
    }

    /**
     * Sets the troop's stats to the default Infantry loadout
     */
    private fun applyInfantryStats() {
        melee = TroopBaseStats.INFANTRY_MELEE
        ranged = TroopBaseStats.INFANTRY_RANGED
        movement = TroopBaseStats.INFANTRY_MOVEMENT
        defense = TroopBaseStats.INFANTRY_DEFENSE
        purchaseCost = TroopCosts.INFANTRY
        trainingCost = TroopCosts.INFANTRY_TRAINING_COST
    }

    /**
     * Sets the troop's stats to the default Ranged loadout
     */
    private fun applyRangedStats() {
        melee = TroopBaseStats.RANGED_MELEE
        ranged = TroopBaseStats.RANGED_RANGED
        movement = TroopBaseStats.RANGED_MOVEMENT
        defense = TroopBaseStats.RANGED_DEFENSE
        purchaseCost = TroopCosts.RANGED
        trainingCost = TroopCosts.RANGED_TRAINING_COST
    }

    /**
     * Sets the troop's stats to the default Cavalry loadout
     */
    private fun applyCavalryStats() {
        melee = TroopBaseStats.CAVALRY_MELEE
        ranged = TroopBaseStats.CAVALRY_RANGED
        movement = TroopBaseStats.CAVALRY_MOVEMENT
        defense = TroopBaseStats.CAVALRY_DEFENSE
        purchaseCost = TroopCosts.CAVALRY
        trainingCost = TroopCosts.CAVALRY_TRAINING_COST
    }

    /**
     * Adjusts the troop's stats when they level up.
     * Resets
     */
    fun levelUp() {
        // Increment level
        level++

        // Subtracts current level's amount of xp from the troop
        xp -= levelUpRequirement

        // Scales up how much xp the troop needs to level up again
        levelUpRequirement = (levelUpRequirement * Constants.LEVEL_UP_REQUIREMENT_SCALE).roundToInt()

        // Adjust stats according to level up.
        melee++
        ranged++
        defense++
    }
}