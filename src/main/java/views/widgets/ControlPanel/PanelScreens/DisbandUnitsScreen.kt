/**
 * @author Mitchell Hornsby
 * Allows the player to separate combined units back into individual units.
 */
package views.widgets.ControlPanel.PanelScreens

import models.Managers.GameManager
import models.Managers.PlayerManager
import models.Managers.UnitCombiner
import models.Units.CombinedUnit
import models.Units.Unit

class DisbandUnitsScreen: SelectMultipleUnitsScreen(ArrayList(PlayerManager.player.selectedCity!!.friendlyUnits.filter { unit -> unit is CombinedUnit}),"Disband") {
    override fun buttonAction() {
        val unitsToDisband = this.getSelectedValues()
        GameManager.disbandUnits(unitsToDisband)
    }
}