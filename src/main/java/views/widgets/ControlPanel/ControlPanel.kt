/**
 * @author Mitchell Hornsby
 * Panel that provides users with options for interacting with the game.
 */
package views.widgets.ControlPanel

import javafx.scene.layout.StackPane
import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle
import models.Units.Unit
import views.widgets.ControlPanel.PanelScreens.*
import views.widgets.MapPanel.MapPanelManager

class ControlPanel: StackPane() {
    init{
        // Adds a background rectangle to occupy space on the display
        this.children.add(Rectangle(200.0, MapPanelManager.mapPanel.mapHeight, Color.WHITE))

        this.children.add(DefaultScreen())
    }

    fun toSelectedCityScreen() {
        this.children[1] = SelectedCityScreen()
    }

    fun toPurchaseTroopsScreen() {
        this.children[1] = PurchaseTroopsScreen()
    }

    fun toCombineUnitsScreen() {
        this.children[1] = CombineUnitsScreen()
    }

    fun toDisbandUnitsScreen() {
        this.children[1] = DisbandUnitsScreen()
    }

    fun toDefaultScreen() {
        this.children[1] = DefaultScreen()
    }

    fun toMoveUnitsScreen() {
        this.children[1] = MoveUnitsScreen()
    }

    fun toSelectCityForMoveScreen(units: ArrayList<Unit>){
        this.children[1] = SelectCityForMoveScreen(units)
    }

    fun toTrainTroopsScreen() {
        this.children[1] = ManageTrainingScreen()
    }
}