/**
 * @author Mitchell Hornsby
 */
package models.Enemy

import models.Map.City

interface EnemyInterface {
    val name: String
    val spawnCities: ArrayList<City>
}