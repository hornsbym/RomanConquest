package Managers

import Units.Century
import Units.Troop

object UnitCombiner {
    fun formCentury(troopList: ArrayList<Troop>) : Century? {
        if (troopList.size in 6..10) {
            return Century(troopList)
        } else {
            return null
        }
    }
}