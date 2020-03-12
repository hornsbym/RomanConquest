package models.Factories

import models.Managers.UnitManager
import models.Units.Troop
import Utils.generateNumberAndOrdinal
import models.Enemy.Enemy
import models.Managers.PlayerManager

/**
 * Responsible for generating new, blank troops of each distinct class.
 */
object TroopFactory {
    // Tracks how many of each unit have been made already for naming purposes
    private val infantryCount = HashMap<String, Int>()
    private var rangedCount = HashMap<String, Int>()
    private var cavalryCount = HashMap<String, Int>()


    /**
     * Creates and returns a brand new infantry class Troop object.
     * Tracks the number already created for naming purposes
     */
    fun newEnemyInfantry(enemy: Enemy, cityName: String) : Troop {
        val enemyName = enemy.name

        // Puts in the 0 for the player's starting number of troops
        if (!infantryCount.containsKey(enemyName)) {
            infantryCount[enemyName] = 0
        }

        infantryCount[enemyName] = infantryCount[enemyName]!! + 1

        val name = generateNumberAndOrdinal(infantryCount[enemyName]!!) + " Infantry Unit"
        val newTroop = Troop(name, 1, 0, Constants.INFANTRY, enemyName, cityName)
        UnitManager.addUnit(newTroop)

        return newTroop
    }

    /**
     * Creates and returns a brand new ranged class Troop object.
     * Tracks the number already created for naming purposes
     */
    fun newEnemyRanged(enemy: Enemy, cityName: String) : Troop {
        val enemyName = enemy.name

        // Puts in the 0 for the player's starting number of troops
        if (!rangedCount.containsKey(enemyName)) {
            rangedCount[enemyName] = 0
        }

        rangedCount[enemyName] = infantryCount[enemyName]!! + 1

        val name = generateNumberAndOrdinal(rangedCount[enemyName]!!) + " Ranged Unit"
        val newTroop = Troop(name,1, 0, Constants.RANGED, enemyName, cityName)
        UnitManager.addUnit(newTroop)

        return newTroop
    }

    /**
     * Creates and returns a brand new cavalry class Troop object.
     * Tracks the number already created for naming purposes
     */
    fun newEnemyCavalry(enemy: Enemy, cityName: String) : Troop {
        val enemyName = enemy.name

        // Puts in the 0 for the player's starting number of troops
        if (!cavalryCount.containsKey(enemyName)) {
            cavalryCount[enemyName] = 0
        }

        cavalryCount[enemyName] = cavalryCount[enemyName]!! + 1

        val name = generateNumberAndOrdinal(cavalryCount[enemyName]!!) + " Cavalry Unit"
        val newTroop = Troop(name, 1, 0 , Constants.CAVALRY, enemyName, cityName)
        UnitManager.addUnit(newTroop)

        return newTroop
    }


    /**
     * Creates and returns a brand new infantry class Troop object.
     * Tracks the number already created for naming purposes
     */
    fun newPlayerInfantry() : Troop {
        val player = PlayerManager.player
        val playerName = player.name
        val selectedCityName = player.selectedCity!!.name

        // Puts in the 0 for the player's starting number of troops
        if (!infantryCount.containsKey(playerName)) {
            infantryCount[playerName] = 0
        }

        infantryCount[playerName] = infantryCount[playerName]!! + 1

        val name = generateNumberAndOrdinal(infantryCount[playerName]!!) + " Infantry Unit"
        val newTroop = Troop(name, 1, 0, Constants.INFANTRY, playerName, selectedCityName)
        UnitManager.addUnit(newTroop)

        return newTroop
    }

    /**
     * Creates and returns a brand new ranged class Troop object.
     * Tracks the number already created for naming purposes
     */
    fun newPlayerRanged() : Troop {
        val player = PlayerManager.player
        val playerName = player.name
        val selectedCityName = player.selectedCity!!.name

        // Puts in the 0 for the player's starting number of troops
        if (!rangedCount.containsKey(playerName)) {
            rangedCount[playerName] = 0
        }

        rangedCount[playerName] = rangedCount[playerName]!! + 1

        val name = generateNumberAndOrdinal(rangedCount[playerName]!!) + " Ranged Unit"
        val newTroop = Troop(name,1, 0, Constants.RANGED, playerName, selectedCityName)
        UnitManager.addUnit(newTroop)

        return newTroop
    }

    /**
     * Creates and returns a brand new cavalry class Troop object.
     * Tracks the number already created for naming purposes
     */
    fun newPlayerCavalry() : Troop {
        val player = PlayerManager.player
        val playerName = player.name
        val selectedCityName = player.selectedCity!!.name

        // Puts in the 0 for the player's starting number of troops
        if (!cavalryCount.containsKey(playerName)) {
            cavalryCount[playerName] = 0
        }

        cavalryCount[playerName] = cavalryCount[playerName]!! + 1

        val name = generateNumberAndOrdinal(cavalryCount[playerName]!!) + " Cavalry Unit"
        val newTroop = Troop(name, 1, 0 , Constants.CAVALRY, playerName, selectedCityName)
        UnitManager.addUnit(newTroop)

        return newTroop
    }
}