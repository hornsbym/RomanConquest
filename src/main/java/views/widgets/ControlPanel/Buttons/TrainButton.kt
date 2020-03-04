package views.widgets.ControlPanel.Buttons

import javafx.event.EventHandler
import javafx.scene.control.Button
import javafx.scene.input.MouseEvent
import views.widgets.ControlPanel.ControlPanelManager

class TrainButton: Button("Train") {
    init {
        this.onMousePressed = EventHandler<MouseEvent>(fun(event: MouseEvent) {
            ControlPanelManager.toTrainTroopsScreen()
        })
    }
}