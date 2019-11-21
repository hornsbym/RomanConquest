/**
 * @author Mitchell Hornsby
 * Singleton object for keeping track of a player's troops
 */
package Managers

import Units.Troop
import Constants

/**
 * Responsible for maintaining references to all troops in the game.
 */
object TroopManager {
    // Holds a dictionary for finding troops
    private val TroopDict = HashMap<Int, ArrayList<Troop>>()

    /**
     * Initializes the three main classifications of troops in the dictionary
     * Makes finding a particular troop much easier
     * */
    init {
        TroopDict[Constants.INFANTRY] = ArrayList()
        TroopDict[Constants.RANGED] = ArrayList()
        TroopDict[Constants.CAVALRY] = ArrayList()
    }

    /**
     * Lets us look at the troop list
     */
    override fun toString(): String {
        val infantry = TroopDict[Constants.INFANTRY]!!
        val ranged = TroopDict[Constants.RANGED]!!
        val cavalry = TroopDict[Constants.CAVALRY]!!

        var returnString = "Infantry: "
        if (infantry.size > 0){
            for (troop in infantry){
                returnString += "\n\t$troop"
            }
            returnString = returnString.substring(0, returnString.length - 2)
        }

        returnString += "\nRanged: "
        if (ranged.size > 0){
            for (troop in ranged){
                returnString += "\n\t$troop"
            }
            returnString = returnString.substring(0, returnString.length - 2)
        }

        returnString += "\nCavalry: "
        if (cavalry.size > 0){
            for (troop in cavalry){
                returnString += "\n\t$troop"
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
        TroopDict[newTroop.classification]!!.add(newTroop)
    }
}