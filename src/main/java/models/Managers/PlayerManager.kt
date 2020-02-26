package models.Managers

import models.Map.City
import models.Player.Player

object PlayerManager {
    lateinit var player: Player

    fun createPlayer(name: String) {
        player = Player(name)
    }

    fun setSelectedCity(city: City) {
        player.selectedCity = city
    }
}