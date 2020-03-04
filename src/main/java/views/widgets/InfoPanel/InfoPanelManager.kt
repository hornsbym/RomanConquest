/**
 * @author Mitchell Hornsby
 * Singleton object.
 * Allows for modification of the info panel from other parts of the app.
 */
package views.widgets.InfoPanel

import models.Managers.PlayerManager
import models.Units.Unit

object InfoPanelManager {
    var currentScreen = "DEFAULT"
    val infopanel = InfoPanel()

    fun toSelectedCityScreen() {
        currentScreen = "SELECTED_CITY"
        infopanel.toSelectedCityScreen()
    }

    fun toDefaultScreen() {
        currentScreen = "DEFAULT"
        infopanel.toDefaultScreen()
    }

    fun toViewUnitScreen(unit: Unit) {
        currentScreen = "VIEW_UNIT"
        infopanel.toViewUnitScreen(unit)
    }

    fun refresh() {
        when (currentScreen) {
            "DEFAULT" -> toDefaultScreen()
//            "VIEW_UNIT" -> toViewUnitScreen()
            "SELECTED_CITY" -> toSelectedCityScreen()
        }
    }
}