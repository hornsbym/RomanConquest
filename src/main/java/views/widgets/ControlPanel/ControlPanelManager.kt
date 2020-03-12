package views.widgets.ControlPanel

import models.Units.Unit

object ControlPanelManager {
    var controlPanel = ControlPanel()
    var currentScreen = "DEFAULT"

    var selectionUnits: ArrayList<Unit>? = null

    fun toSelectedCityScreen() {
        currentScreen = "SELECTED_CITY"
        controlPanel.toSelectedCityScreen()
    }

    fun toPurchaseTroopsScreen() {
        currentScreen = "PURCHASE_TROOPS"
        controlPanel.toPurchaseTroopsScreen()
    }

    fun toDefaultScreen() {
        currentScreen = "DEFAULT"
        controlPanel.toDefaultScreen()
    }

    fun toCombineScreen(){
        currentScreen = "COMBINE_UNITS"
        controlPanel.toCombineUnitsScreen()
    }

    fun toDisbandScreen() {
        currentScreen = "DISBAND_UNITS"
        controlPanel.toDisbandUnitsScreen()
    }

    fun toMoveUnitsScreen() {
        currentScreen = "MOVE_UNITS"
        controlPanel.toMoveUnitsScreen()
    }

    fun toSelectCityForMoveScreen() {
        currentScreen = "SELECT_ADJACENT_CITY"
        controlPanel.toSelectCityForMoveScreen(selectionUnits)
    }

    fun toTrainTroopsScreen() {
        currentScreen = "TRAINING"
        controlPanel.toTrainTroopsScreen()
    }

    fun toBattleScreen() {
        currentScreen = "BATTLE"
        controlPanel.toBattleScreen()
    }

    fun refresh() {
        when (currentScreen) {
            "SELECTED_CITY" -> toSelectedCityScreen()
            "PURCHASE_TROOPS" -> toPurchaseTroopsScreen()
            "COMBINE_UNITS" -> toCombineScreen()
            "DISBAND_UNITS" -> toDisbandScreen()
            "MOVE_UNITS" -> toMoveUnitsScreen()
            "SELECT_ADJACENT_CITY" -> toSelectCityForMoveScreen()
            "TRAINING" -> toTrainTroopsScreen()
            "BATTLE" -> toBattleScreen()
            else -> toDefaultScreen()
        }
    }
}