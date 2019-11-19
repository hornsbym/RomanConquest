package Factories

import Units.Troop

/**
 * Responsible for generating new, blank troops of each distinct class.
 */
object TroopFactory {
    // Tracks how many of each unit have been made already for naming purposes
    private var infantryCount = 0
    private var rangedCount = 0
    private var cavalryCount = 0

    fun generateNumberStringForName(){
        
    }

    fun newInfantry() : Troop {
        infantryCount++
        return Troop(1, 0, Constants.INFANTRY)
    }

    fun newRanged() : Troop {
        rangedCount++
        return Troop(1, 0, Constants.RANGED)
    }

    fun newCavalry() : Troop {
        cavalryCount++

        return Troop(cavalryCount + "1, 0 , Constants.CAVALRY)
    }
}