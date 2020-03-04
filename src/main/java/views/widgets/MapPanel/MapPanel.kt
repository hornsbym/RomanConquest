/**
 * @author Mitchell Hornsby
 * Displays the map that the user will interact with.
 * Attaches to a Map model to represent.
 */
package views.widgets.MapPanel

import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.*
import models.Map.Map
import java.io.File

class MapPanel(private val map: Map): StackPane() {
    private val cityMarkers = ArrayList<CityMarker>()
    private val roadMarkers = ArrayList<RoadMarker>()
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
//        markerPane.background = Background(BackgroundFill(Paint.valueOf("999999"), CornerRadii.EMPTY, Insets.EMPTY))

        markerPane.children.addAll(this.roadMarkers)
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
            val cityMarker = CityMarker(city, markerImg)
            this.cityMarkers.add(cityMarker)

            for(road in city.roads){
                this.roadMarkers.add(RoadMarker(road))
            }
        }
    }
}