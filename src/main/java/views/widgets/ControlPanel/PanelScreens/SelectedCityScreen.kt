/**
 * @author Mitchell Hornsby
 * Screen for displaying the available options at a city.
 * Invalid options should be automatically disabled.
 */
package views.widgets.ControlPanel.PanelScreens

import javafx.scene.control.Button
import javafx.scene.layout.VBox
import views.widgets.ControlPanel.Buttons.*

class SelectedCityScreen: VBox() {
    init {
        this.children.add(BuyButton())
        this.children.add(CombineButton())
        this.children.add(DisbandButton())
        this.children.add(MoveButton())
        this.children.add(TrainButton())
        this.children.add(Button("Go to battle"))
        this.children.add(Button("End turn"))
    }
}