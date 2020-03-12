package views.widgets.ControlPanel.PanelScreens.Battle

import javafx.scene.control.Label
import javafx.scene.layout.VBox
import models.Managers.GameManager
import models.Managers.PlayerManager
import views.widgets.ControlPanel.PanelScreens.SelectMultipleUnitsScreen

class GoToBattleScreen: VBox(){
    init {
        val playerUnitsLabel = Label("Choose your units")
        val playerUnitsSelection = SelectMultipleUnitsScreen(PlayerManager.player.selectedCity!!.friendlyUnits, "", false,false)
        val enemyUnitsLable = Label("Choose your targets")
        val enemyUnitSelection = object: SelectMultipleUnitsScreen(PlayerManager.player.selectedCity!!.hostileUnits, "Battle!") {
            override fun buttonAction() {
                val selectedFriendlyUnits = playerUnitsSelection.getSelectedValues()
                val selectedEnemyUnits = this.getSelectedValues()

                GameManager.battle(selectedFriendlyUnits, selectedEnemyUnits)
            }
        }

        this.children.addAll(playerUnitsLabel, playerUnitsSelection, enemyUnitsLable, enemyUnitSelection)
    }
}