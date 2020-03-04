package views.widgets.ControlPanel.Buttons

import javafx.event.EventHandler
import javafx.scene.control.Button
import javafx.scene.input.MouseEvent
import models.Managers.PlayerManager
import models.Units.CombinedUnit
import views.widgets.ControlPanel.ControlPanelManager

class DisbandButton: Button("Disband") {
    init {
        var playerUnits = PlayerManager.player.selectedCity!!.friendlyUnits
        var playerCombinedUnits = playerUnits.filter { unit -> unit is CombinedUnit }

        if (playerCombinedUnits.size < 1) {
            this.isDisable = true
        }
        this.onMousePressed = EventHandler<MouseEvent>(fun(event: MouseEvent) {
            ControlPanelManager.toDisbandScreen()
        })
    }
}