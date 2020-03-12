/**
 * @author Mitchell Hornsby
 * Singleton class for performing app-level operations, such as refreshing multiple panels at once.
 */
package views

import views.widgets.ControlPanel.ControlPanelManager
import views.widgets.InfoPanel.InfoPanelManager
import views.widgets.PlayerPanel.PlayerPanelManager

object AppManager {
    fun refreshAllPanels() {
        InfoPanelManager.refresh()
        PlayerPanelManager.refresh()
        ControlPanelManager.refresh()
    }
}