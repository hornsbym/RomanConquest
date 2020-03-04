package views.widgets.InfoPanel

import javafx.scene.control.Label
import javafx.scene.layout.VBox
import models.Managers.PlayerManager

class CityOverviewScreen: VBox() {
    init {
        val selectedCity = PlayerManager.player.selectedCity!!
        spacing = 15.0

        children.add(Label(selectedCity.name))
        children.add(Label("Friendly units:"))
        children.add(UnitList(selectedCity.friendlyUnits))
        children.add(Label("Hostile units:"))
        children.add(UnitList(selectedCity.hostileUnits))
    }
}