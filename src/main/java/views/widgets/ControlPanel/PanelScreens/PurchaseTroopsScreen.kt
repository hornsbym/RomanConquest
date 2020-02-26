package views.widgets.ControlPanel.PanelScreens

import javafx.scene.control.Button
import javafx.scene.layout.VBox
import models.Managers.PlayerManager

class PurchaseTroopsScreen: VBox() {
    init {
        val infantryButton = Button("Infantry")
        val rangedButton = Button("Ranged")
        val cavalryButton = Button("Cavalry")

        val availableGold = PlayerManager.player.gold
        if (availableGold < TroopCosts.CAVALRY){
            cavalryButton.isDisable = true
        }
        if (availableGold < TroopCosts.RANGED) {
            rangedButton.isDisable = true
        }
        if (availableGold < TroopCosts.INFANTRY) {
            infantryButton.isDisable = true
        }

        this.children.addAll(infantryButton, rangedButton, cavalryButton)
    }
}