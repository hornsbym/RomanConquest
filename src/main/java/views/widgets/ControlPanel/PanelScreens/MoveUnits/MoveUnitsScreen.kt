/**
 * @author Mitchell Hornsby
 * Creates the screen that allows users to move their troops between cities.
 */
package views.widgets.ControlPanel.PanelScreens.MoveUnits

import javafx.event.EventHandler
import javafx.scene.control.Button
import javafx.scene.input.MouseEvent
import models.Managers.PlayerManager
import views.widgets.ControlPanel.ControlPanelManager
import views.widgets.ControlPanel.PanelScreens.SelectMultipleUnitsScreen

class MoveUnitsScreen: SelectMultipleUnitsScreen(PlayerManager.player.selectedCity!!.friendlyUnits, "Move units") {
    override fun buttonAction() {
        // Gets the units that the user wants to move
        val unitsToMove = this.getSelectedValues()
        ControlPanelManager.selectionUnits = unitsToMove
        ControlPanelManager.toSelectCityForMoveScreen()
    }

    override fun createActionButton() {
        val actionButton = Button(this.buttonText)
        actionButton.onMousePressed = EventHandler<MouseEvent> (fun(event: MouseEvent) {
            this.buttonAction()
        })
        children.add(actionButton)
    }
}