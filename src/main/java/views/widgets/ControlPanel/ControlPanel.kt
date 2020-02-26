package views.widgets.ControlPanel

import javafx.scene.control.Button
import javafx.scene.layout.StackPane
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle
import views.widgets.ControlPanel.Buttons.BuyButton
import views.widgets.ControlPanel.PanelScreens.DefaultScreen
import views.widgets.ControlPanel.PanelScreens.PurchaseTroopsScreen
import views.widgets.ControlPanel.PanelScreens.SelectedCityScreen
import views.widgets.MapPanel.MapPanelManager

class ControlPanel: StackPane() {
    init{
        // Adds a background rectangle to occupy space on the display
        this.children.add(Rectangle(200.0, MapPanelManager.mapPanel.mapHeight, Color.WHITE))

        this.children.add(DefaultScreen())
    }

    fun toSelectedCityScreen() {
        this.children[1] = SelectedCityScreen()
    }

    fun toPurchaseTroopsScreen() {
        this.children[1] = PurchaseTroopsScreen()
    }

    fun toDefaultScreen() {
        this.children[1] = DefaultScreen()
    }
}