/**
 * @author Mitchell Hornsby
 * Singleton object for instantiating enemies.
 * Enemies are similar to Player object in that they control troops, but they are more limited in their what they can do.
 * Places enemy troops on the board and moves them around.
 */
package models.Managers

import models.Enemy.Enemy
import models.Enemy.Gauls.Gauls

object EnemyManager {
    // This array keeps track of enemy objects, not their troops
    val enemies = ArrayList<Enemy>()

    init {
        // Specify which enemies will be in the game here
        enemies.add(Gauls())
    }

    // Iterates over the list of enemies and adds units to the board
    fun addEnemiesToMap() {
        for (enemy in enemies) {
            enemy.spawnNewEnemies()
        }
    }
}