/**
 * @author Mitchell Hornsby
 * Allows users to see the details of one of their troops.
 */
package views.widgets.InfoPanel.Screens

import javafx.event.EventHandler
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.input.MouseEvent
import javafx.scene.layout.VBox
import models.Units.CombinedUnit
import models.Units.Troop
import models.Units.Unit
import views.widgets.InfoPanel.InfoPanelManager
import views.widgets.InfoPanel.UnitList

class ViewUnitScreen(unit: Unit?): VBox() {
    init {
        if (unit != null) {
            // This information will be shown for all Units
            var unitName = Label(unit.name)
            var remainingMoves = Label("${unit.remainingMoves} move(s) remaining")
            var ownerName = Label(unit.owner)
            var unitHealth = Label(unit.health.toString() + " HP" )
            var unitMelee = Label(unit.melee.toString() + " melee attack")
            var unitRanged = Label(unit.ranged.toString() + " ranged attack")
            var unitDefense = Label(unit.defense.toString() + " defense")
            var unitMobility = Label(unit.movement.toString() + " mobility")

            // Allows users to go back to their previous screen
            var backButton = Button("Back")
            backButton.onMouseClicked = EventHandler<MouseEvent>(fun(event: MouseEvent) {
                InfoPanelManager.toSelectedCityScreen()
            })

            children.addAll(backButton, unitName, remainingMoves, ownerName)

            // Shows unit information relevant only for troops
            if (unit is Troop) {
                var unitLevel = Label("Level " + unit.level.toString())
                var unitXP = Label("${unit.xp}/${unit.levelUpRequirement} xp")
                children.addAll(unitLevel, unitXP)
            }

            children.addAll(unitHealth, unitMelee, unitRanged, unitDefense, unitMobility)

            // Shows unit information only relevant for Legions, Cohorts, and Centuries
            if (unit is CombinedUnit) {
                var cohesionLabel = Label("Cohesion: " + unit.cohesion)
                var subUnits = UnitList(unit.units)

                children.addAll(cohesionLabel, subUnits)
            }
        }
    }
}