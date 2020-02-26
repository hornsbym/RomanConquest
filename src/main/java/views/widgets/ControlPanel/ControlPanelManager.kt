package views.widgets.ControlPanel

object ControlPanelManager {
    var controlPanel = ControlPanel()

    fun toSelectedCityScreen() {
        controlPanel.toSelectedCityScreen()
    }

    fun toPurchaseTroopsScreen() {
        controlPanel.toPurchaseTroopsScreen()
    }

    fun toDefaultScreen() {
        controlPanel.toDefaultScreen()
    }
}