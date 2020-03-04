package views.widgets.InfoPanel

import javafx.event.EventHandler
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.input.MouseEvent
import javafx.scene.layout.VBox
import models.Units.Unit

class ViewUnitScreen(unit: Unit): VBox() {
    init {
        var unitName = Label(unit.name)
        var unitLevel = Label("Level " + unit.level.toString())
        var unitHealth = Label(unit.health.toString() + " HP" )
        var unitMelee = Label(unit.melee.toString() + " melee attack")
        var unitRanged = Label(unit.ranged.toString() + " ranged attack")
        var unitDefense = Label(unit.defense.toString() + " defense")
        var unitMobility = Label(unit.movement.toString() + " mobility")

        var backButton = Button("Back")
        backButton.onMouseClicked = EventHandler<MouseEvent>(fun(event: MouseEvent) {
            InfoPanelManager.toSelectedCityScreen()
        })

        children.addAll(backButton, unitName, unitLevel, unitHealth, unitMelee, unitRanged, unitDefense, unitMobility)
    }

}