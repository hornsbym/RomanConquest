package views.widgets.PlayerPanel

import javafx.event.EventHandler
import javafx.scene.control.Label
import javafx.scene.input.MouseEvent
import javafx.scene.layout.*
import javafx.scene.paint.Color
import models.Managers.GameManager
import models.Managers.PlayerManager

class PlayerPanel: HBox() {
    init {
        this.spacing = 50.0

        var nameLabel = Label(PlayerManager.player.name)
        var goldLabel = Label(PlayerManager.player.gold.toString() + " gold")
        var turnLabel = Label("Turn " + GameManager.game.turn)

        this.children.addAll(nameLabel, goldLabel, turnLabel)
    }

    fun refresh() {
        children[0] = Label(PlayerManager.player.name)
        children[1] = Label(PlayerManager.player.gold.toString() + " gold")
        children[2] = Label("Turn " + GameManager.game.turn)
    }
}