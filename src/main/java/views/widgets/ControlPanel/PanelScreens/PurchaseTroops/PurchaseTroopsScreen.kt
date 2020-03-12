/**
 * @author Mitchell Hornsby
 * Control panel that facilitates the purchasing of Troops
 */
package views.widgets.ControlPanel.PanelScreens.PurchaseTroops

import javafx.event.EventHandler
import javafx.scene.control.Button
import javafx.scene.input.MouseEvent
import javafx.scene.layout.VBox
import models.Factories.TroopFactory
import models.Managers.GameManager
import models.Managers.PlayerManager
import views.AppManager
import views.widgets.ControlPanel.ControlPanelManager

class PurchaseTroopsScreen: VBox() {
    init {
        // Create buttons
        val infantryButton = Button("Infantry")
        val rangedButton = Button("Ranged")
        val cavalryButton = Button("Cavalry")
        val backButton = Button("Back")

        // Add functionality to buttons
        infantryButton.onMouseClicked = EventHandler<MouseEvent>(fun (event: MouseEvent) {
            GameManager.purchaseTroops(Constants.INFANTRY)
            AppManager.refreshAllPanels()
        })
        rangedButton.onMouseClicked = EventHandler<MouseEvent>(fun (event: MouseEvent) {
            GameManager.purchaseTroops(Constants.RANGED)
            AppManager.refreshAllPanels()
        })
        cavalryButton.onMouseClicked = EventHandler<MouseEvent>(fun (event: MouseEvent) {
            GameManager.purchaseTroops(Constants.CAVALRY)
            AppManager.refreshAllPanels()
        })
        backButton.onMouseClicked = EventHandler<MouseEvent>(fun (event: MouseEvent) {
            ControlPanelManager.toSelectedCityScreen()
            AppManager.refreshAllPanels()
        })

        // Disables buttons that can't be used
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

        this.children.addAll(infantryButton, rangedButton, cavalryButton, backButton)
    }
}