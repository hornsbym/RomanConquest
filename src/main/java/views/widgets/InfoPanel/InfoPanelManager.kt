/**
 * @author Mitchell Hornsby
 * Singleton object.
 * Allows for modification of the info panel from other parts of the app.
 */
package views.widgets.InfoPanel

import models.Managers.PlayerManager
import models.Map.City

object InfoPanelManager {
    val infopanel = InfoPanel()

    fun refreshSelectedCity() {
        var selectedCity = PlayerManager.player.selectedCity

        if (selectedCity !== null) {
            this.infopanel.setCityName(selectedCity.name)
            this.infopanel.setCityFriendlyUnits("Your units: " + selectedCity.friendlyUnits.toString())
            this.infopanel.setCityHostileUnits("Enemy units: " + selectedCity.hostileUnits.toString())
        }

        infopanel.refresh()
    }
}