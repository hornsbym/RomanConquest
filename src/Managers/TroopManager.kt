/**
 * @author Mitchell Hornsby
 * Singleton object for keeping track of a player's troops
 */
package Managers

import Units.Troop
import Constants

object TroopManager {
    // Holds a dictionary for finding troops
    private val TroopList = HashMap<Int, ArrayList<Troop>>()

    /**
     * Initializes the three main classifications of troops in the dictionary
     * Makes finding a particular troop much easier
     * */
    init {
        TroopList[Constants.INFANTRY] = ArrayList<Troop>()
        TroopList[Constants.RANGED] = ArrayList<Troop>()
        TroopList[Constants.CAVALRY] = ArrayList<Troop>()
    }

    /**
     * Lets us look at the troop list
     */
    override fun toString(): String {
        val infantry = TroopList[Constants.INFANTRY]!!
        val ranged = TroopList[Constants.RANGED]!!
        val cavalry = TroopList[Constants.CAVALRY]!!

        var returnString = "Infantry: "
        if (infantry.size > 0){
            for (troop in infantry){
                returnString += "$troop, "
            }
            returnString = returnString.substring(0, returnString.length - 2)
        }

        returnString += "\nRanged: "
        if (ranged.size > 0){
            for (troop in ranged){
                returnString += "$troop, "
            }
            returnString = returnString.substring(0, returnString.length - 2)
        }

        returnString += "\nCavalry: "
        if (cavalry.size > 0){
            for (troop in cavalry){
                returnString += "$troop, "
            }
            returnString = returnString.substring(0, returnString.length - 2)
        }

        return returnString
    }

    /**
     * Adds a given troop to the Troop list
     * @param Troop
     */
    fun addTroop(newTroop: Troop){
        TroopList[newTroop.classification]!!.add(newTroop)
    }
}