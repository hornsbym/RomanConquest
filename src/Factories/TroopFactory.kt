package Factories

import Units.Troop

object TroopFactory {
    fun newInfantry() : Troop {
        return Troop(1, 0, Constants.INFANTRY)
    }

    fun newRanged() : Troop {
        return Troop(1, 0, Constants.RANGED)
    }

    fun newCavalry() : Troop {
        return Troop(1, 0 , Constants.CAVALRY)
    }
}