/**
 * @author Mitchell Hornsby
 * Singleton object for handling battles.
 * Contains all combat logic.
 */
package models.Managers

import models.Units.Unit

object BattleManager {
    class StatSum(var health: Int, var melee: Int, var ranged: Int, var defense: Int)
    /**
     * Represents a full battle scenario.
     * A full scenario takes place whenever an attacking unit decides to use both range and melee.
     * The attacking unit deals damage first, but the defending unit gets to retaliate for free if they survive.
     * Damage is split evenly and distributed to each unit in the attacking and defending list.
     * Full battles are split into two phases: the Range phase and the Melee phase.
     */
    fun fullBattle(attackers: ArrayList<out Unit>, defenders: ArrayList<out Unit>) {
        // Only allows attackers to attack when all attacking units have at least 1 remaining move
        if (Utils.allUnitsCanMove(attackers as ArrayList<Unit>)) {
            rangePhase(attackers, defenders)
            meleePhase(attackers, defenders)
            spendMoves(attackers)
            GameManager.game.map.updateCityTroopLists()
        }
    }

    /**
     * Represents just a ranged battle.
     * Only executes phase 1 of a full battle.
     */
    fun rangedBattle(attackers: ArrayList<out Unit>, defenders: ArrayList<out Unit>) {
        // Only allows attacker to attack when all attacking units have at least 1 remaining move
        if (Utils.allUnitsCanMove(attackers as ArrayList<Unit>)) {
            rangePhase(attackers, defenders)
            spendMoves(attackers)
            GameManager.game.map.updateCityTroopLists()
        }
    }

    /**
     * First phase of a battle.
     * Units exchange vollies of ranged weapons to inflict damage.
     */
    private fun rangePhase(attackers: ArrayList<out Unit>, defenders: ArrayList<out Unit>) {
        // Calculates the initial stats of the attackers and defenders
        var attackerStats = getUnitStatSum(attackers)
        var defenderStats = getUnitStatSum(defenders)

        // Calculates the result of the ranged attack
        var damageToDefenders = attackerStats.ranged - defenderStats.defense

        // If the damage is positive, distributes the damage.
        if (damageToDefenders > 0) {
            distributeDamage(damageToDefenders, defenders)
        }

        // Recalculates the defenders' stats
        defenderStats = getUnitStatSum(defenders)

        // If the defender survived, counterattack
        if (defenderStats.health > 0) {
            val damageToAttackers = defenderStats.ranged - attackerStats.defense
            if (damageToAttackers > 0) {
                distributeDamage(damageToAttackers, attackers)
            }
        }
    }

    /**
     * Second phase of a battle.
     * Units clash and damage is done at the same time (attackers or defenders don't matter, damage is dealt to both)
     */
    private fun meleePhase(attackers: ArrayList<out Unit>, defenders: ArrayList<out Unit>) {
        // Calculates the initial stats of the attackers and defenders
        var attackerStats = getUnitStatSum(attackers)
        var defenderStats = getUnitStatSum(defenders)

        // Calculates result of the clash
        var damageToAttackers = defenderStats.melee - attackerStats.defense
        var damageToDefenders = attackerStats.melee - defenderStats.defense

        // Applies the damage (only if damage is positive)
        if (damageToAttackers > 0) {
            distributeDamage(damageToAttackers, attackers)
        }
        if (damageToDefenders > 0) {
            distributeDamage(damageToDefenders, defenders)
        }
    }

    /**
     * Loops over an array of Units sums their stats.
     * Returns a StatSum class containing the totals.
     */
    private fun getUnitStatSum(units: ArrayList<out Unit>): StatSum {
        var totalHealth = 0
        var totalMeleeAttack = 0
        var totalRangedAttack = 0
        var totalDefense = 0

        for (unit in units) {
            totalHealth += unit.health
            totalMeleeAttack += unit.melee
            totalRangedAttack += unit.ranged
            totalDefense += unit.defense
        }

        return StatSum(totalHealth, totalMeleeAttack, totalRangedAttack, totalDefense)
    }

    /**
     * Evenly the given damage to the provided array of troops.
     */
    private fun distributeDamage(damage: Int, defenders: ArrayList<out Unit>) {
        var inflictedDamage = (damage/defenders.size)

        for (unit in defenders) {
            unit.takeDamage(inflictedDamage)
        }
    }

    /**
     * Decreases each unit's remaining moves by 1.
     */
    private fun spendMoves(units: ArrayList<Unit>) {
        for (unit in units) {
            unit.remainingMoves--
        }
    }
}