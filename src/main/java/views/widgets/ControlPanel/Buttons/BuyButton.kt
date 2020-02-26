package views.widgets.ControlPanel.Buttons

import javafx.event.EventHandler
import javafx.scene.control.Button
import javafx.scene.input.MouseEvent
import models.Managers.PlayerManager
import views.widgets.ControlPanel.ControlPanelManager

class BuyButton: Button("Buy") {
    init {
        if (PlayerManager.player.gold < TroopCosts.INFANTRY) {
            this.isDisable
        }

        onMouseClicked = EventHandler<MouseEvent>(fun(event:MouseEvent) {
            ControlPanelManager.toPurchaseTroopsScreen()
        })
    }
}