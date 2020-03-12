package views.widgets.ControlPanel.Buttons

import javafx.event.EventHandler
import javafx.scene.control.Button
import javafx.scene.input.MouseEvent
import models.Managers.GameManager
import views.AppManager

class EndTurnButton: Button("End turn") {
    init {
        this.onMousePressed = EventHandler<MouseEvent>(fun(event: MouseEvent) {
            GameManager.nextTurn()
            AppManager.refreshAllPanels()
        })
    }
}