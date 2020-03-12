/**
 * @author Mitchell Hornsby
 * Allows the player to separate combined units back into individual units.
 */
package views.widgets.ControlPanel.PanelScreens.DisbandUnits

import models.Managers.GameManager
import models.Managers.PlayerManager
import models.Units.CombinedUnit
import views.widgets.ControlPanel.PanelScreens.SelectMultipleUnitsScreen

class DisbandUnitsScreen: SelectMultipleUnitsScreen(ArrayList(PlayerManager.player.selectedCity!!.friendlyUnits.filter { unit -> unit is CombinedUnit}),"Disband") {
    override fun buttonAction() {
        val unitsToDisband = this.getSelectedValues()
        GameManager.disbandUnits(unitsToDisband)
    }
}