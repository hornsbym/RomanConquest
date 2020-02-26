package views.widgets.MapPanel

import models.Map.Map

object MapPanelManager {
    lateinit var mapPanel: MapPanel

    fun setMap(map: Map) {
        this.mapPanel = MapPanel(map)
    }
}