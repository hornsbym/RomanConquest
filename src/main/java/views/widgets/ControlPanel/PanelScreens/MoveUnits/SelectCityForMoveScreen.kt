package views.widgets.ControlPanel.PanelScreens.MoveUnits

import models.Managers.GameManager
import models.Units.Unit
import views.widgets.ControlPanel.PanelScreens.SelectAdjacentCityScreen

class SelectCityForMoveScreen(val unitsToMove: ArrayList<Unit>?): SelectAdjacentCityScreen("Move units") {
    override fun buttonAction() {
        val selectedCity = this.getSelectedValue()
        if (selectedCity != null && unitsToMove != null) {
            GameManager.moveUnits(unitsToMove, selectedCity)
        }
    }
}