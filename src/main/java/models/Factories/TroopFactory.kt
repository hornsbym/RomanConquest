package models.Factories

import models.Managers.TroopManager
import models.Units.Troop
import Utils.generateNumberAndOrdinal

/**
 * Responsible for generating new, blank troops of each distinct class.
 */
object TroopFactory {
    // Tracks how many of each unit have been made already for naming purposes
    private var infantryCount = 0
    private var rangedCount = 0
    private var cavalryCount = 0

    /**
     * Creates and returns a brand new infantry class Troop object.
     * Tracks the number already created for naming purposes
     */
    fun newInfantry() : Troop {
        infantryCount++
        val name = generateNumberAndOrdinal(infantryCount) + " Infantry Unit"
        val newTroop = Troop(name, 1, 0, Constants.INFANTRY)
        TroopManager.addTroop(newTroop)
        return newTroop
    }

    /**
     * Creates and returns a brand new ranged class Troop object.
     * Tracks the number already created for naming purposes
     */
    fun newRanged() : Troop {
        rangedCount++
        val name = generateNumberAndOrdinal(rangedCount) + " Ranged Unit"
        val newTroop = Troop(name,1, 0, Constants.RANGED)
        TroopManager.addTroop(newTroop)
        return newTroop
    }

    /**
     * Creates and returns a brand new cavalry class Troop object.
     * Tracks the number already created for naming purposes
     */
    fun newCavalry() : Troop {
        cavalryCount++
        val name = generateNumberAndOrdinal(cavalryCount) + " Cavalry Unit"
        val newTroop = Troop(name, 1, 0 , Constants.CAVALRY)
        TroopManager.addTroop(newTroop)
        return newTroop
    }
}