/**
 * @author Mitchell Hornsby
 * Singleton object.
 * Allows for modification of the info panel from other parts of the app.
 */
package views.widgets.InfoPanel

import models.Units.Unit

object InfoPanelManager {
    var currentScreen = "DEFAULT"
    val infopanel = InfoPanel()

    var previewUnit: Unit? = null

    fun toSelectedCityScreen() {
        currentScreen = "SELECTED_CITY"
        infopanel.toSelectedCityScreen()
    }

    fun toDefaultScreen() {
        currentScreen = "DEFAULT"
        infopanel.toDefaultScreen()
    }

    fun toViewUnitScreen() {
        currentScreen = "VIEW_UNIT"
        infopanel.toViewUnitScreen(previewUnit)
    }

    fun refresh() {
        when (currentScreen) {
            "DEFAULT" -> toDefaultScreen()
            "VIEW_UNIT" -> toViewUnitScreen()
            "SELECTED_CITY" -> toSelectedCityScreen()
        }
    }
}