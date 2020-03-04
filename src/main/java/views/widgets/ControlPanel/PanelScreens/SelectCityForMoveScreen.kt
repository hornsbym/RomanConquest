package views.widgets.ControlPanel.PanelScreens

import models.Managers.GameManager
import models.Units.Unit

class SelectCityForMoveScreen(val unitsToMove: ArrayList<Unit>): SelectAdjacentCityScreen("Move units") {
    override fun buttonAction() {
        val selectedCity = this.getSelectedValue()
        println(selectedCity?.name)
        if (selectedCity != null) {
            GameManager.moveUnits(unitsToMove, selectedCity)
            println("Moved.")
        }
    }
}