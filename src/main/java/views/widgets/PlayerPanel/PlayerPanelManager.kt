package views.widgets.PlayerPanel

import models.Player.Player

object PlayerPanelManager {
    lateinit var playerPanel: PlayerPanel

    fun refresh () {
        playerPanel.refresh()
    }
}