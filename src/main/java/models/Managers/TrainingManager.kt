/**
 * @author Mitchell Hornsby
 * Facilitates the training of units.
 */
package models.Managers

import models.Units.CombinedUnit
import models.Units.Troop
import models.Units.Unit
import kotlin.math.roundToInt

object TrainingManager {
    val unitsInTraining = ArrayList<Unit>()

    /**
     * Adds a new unit to the training manager.
     */
    fun addUnit(unit: Unit) {
        unitsInTraining.add(unit)
    }

    /**
     * Adds an array of units to the training manager.
     */
    fun addUnits(units: ArrayList<Unit>){
        unitsInTraining.addAll(units)
    }

    /**
     * Removes the selected unit from the training manager.
     */
    fun removeUnit(unit: Unit) {
        unitsInTraining.remove(unit)
    }

    /**
     * Removes several units from the training manager.
     */
    fun removeUnits(unit: ArrayList<Unit>) {
        unitsInTraining.removeAll(unit)
    }


    /**
     * Gets the current total cost per turn to train the troops.
     */
    fun getCostPerTurn(): Int {
        var cumulativeCost = 0
        for (unit in unitsInTraining) {
            cumulativeCost += singleUnitCost(unit)
        }
        return cumulativeCost
    }

    /**
     * Calculates the cost to train a single unit.
     * If the unit is combined, recurses until it gets just a single unit.
     */
    fun singleUnitCost(unit: Unit): Int {
        var cumulativeCost = 0
        if (unit is CombinedUnit) {
            for (individualUnit in unit.units) {
                cumulativeCost += singleUnitCost(individualUnit)
            }
        } else {
            cumulativeCost += unit.trainingCost
        }
        return cumulativeCost
    }

    /**
     * Takes gold from the player and trains all units.
     * If the player doesn't have enough gold, doesn't train any unit.
     */
    fun trainAll() {
        val cost = getCostPerTurn()
        if (PlayerManager.player.gold < cost) {
            return
        } else {
            // Deducts the cost of training from the user's gold
            PlayerManager.player.gold -= cost

            // Trains each unit
            for (unit in unitsInTraining) {
                trainUnit(unit)
            }
        }
    }

    /**
     * If the unit is combined, recurses until it gets to the base unit cost.
     * If the unit is not combined, adds XP to the unit.
     */
    fun trainUnit(unit: Unit) {
        if (unit is CombinedUnit) {
            for (individualUnit in unit.units) {
                trainUnit(individualUnit)
            }
        } else {
            unit.xp += Constants.TRAINING_BOOST
            levelUpTroop(unit as Troop)
        }
    }

    /**
     * If the troop has gained enough experience, level the troop up.
     * Doesn't do anything if the troop has reached the level limit.
     */
    fun levelUpTroop(troop: Troop) {
        // If the troop hasn't met the level limit and has enough experience points to level up
        if (troop.level < Constants.TROOP_LEVEL_LIMIT && troop.xp >= troop.levelUpRequirement) {
            troop.levelUp()
        }
        // If the troop has reached the maximum level, sets its xp to the highest amount it can be
        else if (troop.level == Constants.TROOP_LEVEL_LIMIT) {
            troop.xp = troop.levelUpRequirement
        }
    }
}