/**
 * @author Mitchell Hornsby
 * Allows users to add and remove troops from training.
 */
package views.widgets.ControlPanel.PanelScreens

import javafx.scene.layout.VBox
import models.Managers.PlayerManager
import models.Managers.TrainingManager
import models.Units.Unit

class ManageTrainingScreen: VBox() {
    val selectedCityUnits = PlayerManager.player.selectedCity!!.friendlyUnits
    var selectedCityTroopsInTraining = ArrayList<Unit>()
    var selectedCityTroopsNotInTraining = ArrayList<Unit>()

    init {
        createTroopLists()

        // Creates a widget for adding troops to the training manager
        var addTroopsPanel = object: SelectMultipleUnitsScreen(selectedCityTroopsNotInTraining, "Start training", false) {
            override fun buttonAction() {
                TrainingManager.addUnits(this.getSelectedValues())
            }
        }

        // Creates a widget for removing troops from the training manager
        var removeTroops = object: SelectMultipleUnitsScreen(selectedCityTroopsInTraining, "Stop training") {
            override fun buttonAction() {
                TrainingManager.removeUnits(this.getSelectedValues())
            }
        }
        this.children.addAll(addTroopsPanel, removeTroops)
    }

    /**
     * Fills out the troops in training and troops not in training lists.
     */
    fun createTroopLists() {
        for (unit in selectedCityUnits) {
            if (unit in TrainingManager.unitsInTraining) {
                selectedCityTroopsInTraining.add(unit)
            } else {
                selectedCityTroopsNotInTraining.add(unit)
            }
        }
    }
}