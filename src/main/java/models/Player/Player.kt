/**
 * @author Mitchell Hornsby
 * Keeps track of information about the player
 */
package models.Player

import models.Map.City

class Player(val name: String) {
    var selectedCity: City? = null
    var gold = 500
}