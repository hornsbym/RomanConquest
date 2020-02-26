/**
 * @author Mitchell Hornsby
 * Displays the map that the user will interact with.
 * Attaches to a Map model to represent.
 */
package views.widgets.MapPanel

import javafx.event.EventHandler
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.input.MouseEvent
import javafx.scene.layout.Pane
import javafx.scene.layout.StackPane
import models.Managers.PlayerManager
import models.Map.Map
import views.widgets.ControlPanel.ControlPanelManager
import views.widgets.InfoPanel.InfoPanelManager
import java.io.File

class MapPanel(private val map: Map): StackPane() {
    private val cityMarkers = ArrayList<CityMarker>()
    var mapWidth = 0.0
    var mapHeight = 0.0

    init {
        this.displayMap()
        this.displayMarkers()
    }

    /**
     * Puts the map ImageView as the bottom layer of the stack pane.
     */
    private fun displayMap() {
        var imgPath = Utils.rootPath + "/views/assets/map.png"
        var img = Image(File(imgPath).toURI().toString())
        var imgView = ImageView(img)

        this.mapWidth = img.width
        this.mapHeight = img.height

        children.add(imgView)
    }

    /**
     * Displays the city markers on top of the stack pane.
     */
    private fun displayMarkers() {
        this.createMarkers()

        val markerPane = Pane()

        markerPane.minWidth = mapWidth
        markerPane.minHeight = mapHeight

        markerPane.children.addAll(this.cityMarkers)

        children.add(markerPane)
    }

    /**
     * Initializes the city markers based on the cities provided by the Map object.
     */
    private fun createMarkers() {
        val markerPath = Utils.rootPath + "/views/assets/cityMarker.png"
        val markerImg = Image(File(markerPath).toURI().toString())

        for (key in this.map.cities.keys) {
            val city = this.map.cities[key]!!
            this.cityMarkers.add(CityMarker(city, markerImg))
        }
    }
}