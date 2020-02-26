package views.widgets.ControlPanel.PanelScreens

import javafx.scene.control.Button
import javafx.scene.layout.VBox
import views.widgets.ControlPanel.Buttons.BuyButton

class SelectedCityScreen: VBox() {
    init {
        this.children.add(BuyButton())
        this.children.add(Button("Combine"))
        this.children.add(Button("Train"))
        this.children.add(Button("Go to battle"))
        this.children.add(Button("End turn"))
    }
}