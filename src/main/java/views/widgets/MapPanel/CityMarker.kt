/**
 * @author Mitchell Hornsby
 * Marks a city on the map.
 * Sits on top of the MapPanel.
 */
package views.widgets.MapPanel

import javafx.event.EventHandler
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.input.MouseButton
import javafx.scene.input.MouseEvent
import javafx.scene.layout.GridPane
import javafx.scene.layout.Region
import javafx.scene.layout.VBox
import javafx.scene.text.Text
import models.Managers.PlayerManager
import models.Map.City
import views.widgets.ControlPanel.ControlPanelManager
import views.widgets.InfoPanel.InfoPanelManager

class CityMarker(val city: City, val marker: Image): Region() {
    lateinit var coords: Pair<Int, Int>

    init {
        this.setCoords()

        this.onMouseEntered = EventHandler<MouseEvent>(fun(event: MouseEvent): Unit {
            var label = Label(city.name)
        })

        this.children.add(VBox())
    }

    /**
     * Provides instructions for how to draw the city marker.
     * Draws an image and allows space for the city name's text
     */
    override fun layoutChildren() {
        // Creates a new vertical layout to house the marker image view and its text label
        val vbox = VBox()
        val tooltip = Text()
        val markerImgView = ImageView(marker)

        // Displays a label for the city when the mouse is hovered over
        markerImgView.onMouseEntered = EventHandler<MouseEvent> (fun (event: MouseEvent): Unit {
            tooltip.text = city.name
            vbox.toFront()  ///// This isn't working... find out why
        })

        // Removes the label when the mouse is not hovering over
        markerImgView.onMouseExited = EventHandler<MouseEvent> (fun (event: MouseEvent): Unit {
            tooltip.text = ""
        })

        // Updates the info panel when the marker is clicked
        markerImgView.onMousePressed = EventHandler<MouseEvent> (fun (event: MouseEvent): Unit {
            PlayerManager.player.selectedCity = city
            InfoPanelManager.refreshSelectedCity()
            ControlPanelManager.toSelectedCityScreen()
        })

        // Adds the marker and the text label to the layout
        vbox.children.add(markerImgView)
        vbox.children.add(tooltip)

        // Adds the layout to the region
        this.children.add(vbox)
    }

    /**
     * Determines where the marker should be drawn on the map.
     * Change this by changing the 'CityCoords' singleton.
     * All cities in the game must have defined coords; errors will be thrown otherwise.
     */
    private fun setCoords() {
        this.coords = CityCoords.coords[this.city.name]!!
        this.layoutX = coords.first.toDouble() - 16.0
        this.layoutY = coords.second.toDouble() - 16.0
    }
}