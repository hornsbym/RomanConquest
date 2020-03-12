/**
 * @author Mitchell Hornsby
 * Represents information about the currently selected city.
 */
package views.widgets.InfoPanel

import javafx.scene.layout.StackPane
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle
import models.Managers.PlayerManager
import models.Units.Unit
import views.widgets.InfoPanel.Screens.CityOverviewScreen
import views.widgets.InfoPanel.Screens.ViewUnitScreen
import views.widgets.MapPanel.MapPanelManager


class InfoPanel : StackPane(){
    init {
        // Adds a background rectangle to occupy space on the display
        this.children.add(Rectangle(200.0, MapPanelManager.mapPanel.mapHeight, Color.WHITE))
        this.children.add(VBox())
    }

    fun toSelectedCityScreen() {
        if (PlayerManager.player.selectedCity !== null){
            this.children[1] = CityOverviewScreen()
        }
    }

    fun toDefaultScreen() {
        this.children[1] = VBox()
    }

    fun toViewUnitScreen(unit: Unit?) {
        this.children[1] = ViewUnitScreen(unit)
    }
}