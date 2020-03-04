package views.widgets.ControlPanel.PanelScreens

import javafx.event.EventHandler
import javafx.scene.control.Button
import javafx.scene.control.RadioButton
import javafx.scene.input.MouseEvent
import javafx.scene.layout.VBox
import models.Managers.PlayerManager
import models.Map.City
import models.Units.Unit
import views.AppManager
import views.widgets.ControlPanel.ControlPanelManager
import views.widgets.ControlPanel.RadioButtons.CityRadioButton

open class SelectAdjacentCityScreen(var buttonText: String = "Submit"): VBox() {
    val adjacentCities = PlayerManager.player.selectedCity!!.getAdjacentCities()
    val radioOptions = ArrayList<CityRadioButton>()

    init {
        createRadioOptions()
        createActionButton()
        createBackButton()
    }

    /**
     * Creates the radio buttons for each adjacent city.
     */
    fun createRadioOptions() {
        for (city in adjacentCities) {
            radioOptions.add(CityRadioButton(city))
        }
        children.addAll(radioOptions)
    }

    /**
     * Creates the button to send players back to the control panel "selected city" screen.
     */
    open fun createBackButton() {
        val backButton = Button("Back")
        backButton.onMousePressed = EventHandler<MouseEvent> (fun(event: MouseEvent) {
            ControlPanelManager.toMoveUnitsScreen()
        })
        children.add(backButton)
    }

    /**
     * Gets the value of all selected checkboxes.
     */
    open fun getSelectedValue(): City? {
        var city: City? = null

        for(radioButton in radioOptions) {
            if (radioButton.isSelected) {
                city = radioButton.city
            }
        }

        return city
    }

    /**
     * Creates the button that will initiate the next step.
     * E.x., pressing this button on the combine units screen will actually cause the units to combine.
     */
    open fun createActionButton() {
        val actionButton = Button(this.buttonText)
        actionButton.onMousePressed = EventHandler<MouseEvent> (fun(event: MouseEvent) {
            this.buttonAction()
            ControlPanelManager.toSelectedCityScreen()
            AppManager.refreshAllPanels()
        })
        children.add(actionButton)
    }

    /**
     * This function should always be overridden by child classes.
     * This is the logic that will be executed whenever the main button is pressed.
     */
    open fun buttonAction(): kotlin.Unit {
        return kotlin.Unit
    }
}