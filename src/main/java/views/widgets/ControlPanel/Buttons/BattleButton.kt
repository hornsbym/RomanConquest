/**
 * @author Mitchell Hornsby
 * Provides sends the user to the "Purchase Troops" panel so they can spend gold on troops.
 */
package views.widgets.ControlPanel.Buttons

import javafx.event.EventHandler
import javafx.scene.control.Button
import javafx.scene.input.MouseEvent
import models.Managers.PlayerManager
import views.widgets.ControlPanel.ControlPanelManager

class BattleButton: Button("Go to battle") {
    init {
        onMouseClicked = EventHandler<MouseEvent>(fun(event:MouseEvent) {
            ControlPanelManager.toBattleScreen()
        })
    }
}