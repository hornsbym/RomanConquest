/**
 * @author Mitchell Hornsby
 * Represents an enemy.
 * Enemies can raise armies and move them around the map.
 * Enemies units will occupy cities and oppose the player.
 * New enemies can only appear in cities designated in the "spawnCities" argument.
 */
package models.Enemy

import models.Factories.TroopFactory
import models.Managers.GameManager
import models.Map.City
import kotlin.random.Random

abstract class Enemy(override val name: String, val spawnCityNames: ArrayList<String>): EnemyInterface {
    val units = ArrayList<Unit>()
    override val spawnCities = ArrayList<City>()

    init {
        getSpawnCities()
    }

    /**
     * Takes the provided city names and gets the city objects.
     */
    private fun getSpawnCities() {
        for (cityName in spawnCityNames) {
            spawnCities.add(GameManager.game.map.getCity(cityName))
        }
    }

    /**
     * This function allows enemies to put new troops on the map.
     */
    open fun spawnNewEnemies() {
        val randomDouble = Random.nextDouble(0.0, 1.0)
        var numCities = 0


        if (randomDouble < .2) {
            numCities = 2
        } else if (randomDouble < .35) {
            numCities = 1
        } else {
            numCities = 0
        }

        for (i in 0 until numCities) {
            val city = Utils.pickFromArrayList(this.spawnCities) as City
            city.addHostileUnit(TroopFactory.newEnemyInfantry(this, city.name))
            println("Added enemy to " + city.name)
        }
    }
}