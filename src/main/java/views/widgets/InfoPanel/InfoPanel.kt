/**
 * @author Mitchell Hornsby
 * Represents information about the currently selected city.
 */
package views.widgets.InfoPanel

import javafx.scene.control.Label
import javafx.scene.layout.StackPane
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle
import models.Managers.PlayerManager
import views.widgets.MapPanel.MapPanelManager

class InfoPanel : StackPane(){
    private lateinit var cityNameLabel: Label
    private lateinit var cityHostileUnits: Label
    private lateinit var cityFriendlyUnits: Label
    private var infoPanel =  VBox()

    init {
        // Adds a background rectangle to occupy space on the display
        this.children.add(Rectangle(200.0, MapPanelManager.mapPanel.mapHeight, Color.WHITE))
        this.children.add(infoPanel)
    }

    fun setCityName(name: String) {
        this.cityNameLabel = Label(name)
    }

    fun setCityHostileUnits(units: String) {
        this.cityHostileUnits = Label(units)
    }

    fun setCityFriendlyUnits(units: String) {
        this.cityFriendlyUnits = Label(units)
    }

    fun refresh() {
        if (PlayerManager.player.selectedCity !== null) {
            var selectedCity = PlayerManager.player.selectedCity

            // Creates a layout for storing the actual information
            val vbox = VBox()

            vbox.children.add(cityNameLabel)
            vbox.children.add(cityFriendlyUnits)
            vbox.children.add(cityHostileUnits)

            // Replaces the the information in the VBox
            // Removes the VBox from the panel, then puts the new information on
            this.children.remove(infoPanel)
            this.infoPanel = vbox
            this.children.add(this.infoPanel)
        }
    }
}