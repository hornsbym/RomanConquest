/**
 * @author Mitchell Hornsby
 * Displays information relevant to the player/game
 */
package views.widgets.PlayerPanel

import javafx.scene.control.Label
import javafx.scene.layout.*
import models.Managers.GameManager
import models.Managers.PlayerManager
import models.Managers.TrainingManager

class PlayerPanel: HBox() {
    init {
        this.spacing = 50.0

        this.refresh()
    }

    /**
     * Fills out the panel with the most recent information
     */
    fun refresh() {
        // Wipes out the current labels
        children.clear()

        // Creates new labels with the freshest data
        var nameLabel = Label(PlayerManager.player.name)
        var goldLabel = Label(PlayerManager.player.gold.toString() + " gold")
        var turnLabel = Label("Turn " + GameManager.game.turn)
        var costLabel = Label("${TrainingManager.getCostPerTurn()} gold/turn")

        // Adds the labels back
        this.children.addAll(nameLabel, goldLabel, turnLabel, costLabel)
    }
}