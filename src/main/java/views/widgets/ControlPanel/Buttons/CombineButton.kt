package views.widgets.ControlPanel.Buttons

import javafx.event.EventHandler
import javafx.scene.control.Button
import javafx.scene.input.MouseEvent
import models.Managers.PlayerManager
import views.widgets.ControlPanel.ControlPanelManager

class CombineButton: Button("Combine") {
    init {
        // Disables the button if the player doesn't have at least 3 units
        if (PlayerManager.player.selectedCity!!.friendlyUnits.size < 3) {
            this.isDisable = true
        }

        this.onMouseClicked = EventHandler<MouseEvent>(fun (event: MouseEvent) {
            ControlPanelManager.toCombineScreen()
        })
    }
}