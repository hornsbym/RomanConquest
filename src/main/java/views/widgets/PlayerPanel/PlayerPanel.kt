package views.widgets.PlayerPanel

import javafx.event.EventHandler
import javafx.scene.control.Label
import javafx.scene.input.MouseEvent
import javafx.scene.layout.*
import javafx.scene.paint.Color
import models.Managers.PlayerManager

class PlayerPanel: HBox() {
    init {
        this.spacing = 50.0

        var nameLabel = Label(PlayerManager.player.name)
        var goldLabel = Label(PlayerManager.player.gold.toString() + " gold")
        var turnLabel = Label("Turn ")

        this.children.addAll(nameLabel, goldLabel, turnLabel)
    }
}