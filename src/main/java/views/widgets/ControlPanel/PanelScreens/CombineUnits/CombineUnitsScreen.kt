/**
 * @author Mitchell Hornsby
 * Allows the user to combine units into more powerful units.
 */
package views.widgets.ControlPanel.PanelScreens.CombineUnits

import models.Managers.GameManager
import models.Managers.PlayerManager
import views.widgets.ControlPanel.PanelScreens.SelectMultipleUnitsScreen

class CombineUnitsScreen: SelectMultipleUnitsScreen(PlayerManager.player.selectedCity!!.friendlyUnits,"Combine") {
    override fun buttonAction() {
        val unitsForCombination = this.getSelectedValues()
        GameManager.combineUnits(unitsForCombination)
    }
}