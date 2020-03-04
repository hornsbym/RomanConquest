package views.widgets.MapPanel

import javafx.scene.paint.Color
import javafx.scene.shape.Line
import models.Map.Road

class RoadMarker(val road: Road): Line() {
    init {
        val city1coords = CityCoords.coords[road.city1.name]!!
        val city2coords = CityCoords.coords[road.city2.name]!!

        this.startX = city1coords.first.toDouble()
        this.startY = city1coords.second.toDouble()
        this.endX = city2coords.first.toDouble()
        this.endY = city2coords.second.toDouble()
        this.strokeWidth = 3.0
        this.fill = Color.SANDYBROWN
    }
}