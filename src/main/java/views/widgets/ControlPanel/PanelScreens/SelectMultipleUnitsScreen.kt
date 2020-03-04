/**
 * @author Mitchell Hornsby
 * Parent class for any control panel screen allows users to select multiple units.
 * Provide an array of units to display.
 * Provide optional string for submit button displayed text.
 * Provide optional boolean for whether or not to add a button that links back to the selected city screen.
 * Override the buttonAction method to implement functionality.
 */
package views.widgets.ControlPanel.PanelScreens

import javafx.event.EventHandler
import javafx.scene.control.Button
import javafx.scene.control.ScrollPane
import javafx.scene.input.MouseEvent
import javafx.scene.layout.VBox
import models.Units.Unit
import views.AppManager
import views.widgets.ControlPanel.CheckBoxes.UnitCheckbox
import views.widgets.ControlPanel.ControlPanelManager

open class SelectMultipleUnitsScreen(units: ArrayList<Unit>, var buttonText: String = "Submit", var createBackButton: Boolean = true): VBox() {
    open var unitValues = units
    open var unitCheckboxes = ArrayList<UnitCheckbox>()

    init {
        createOptions()
        createActionButton()
        if (createBackButton) {
            createBackButton()
        }
    }

    /**
     * Gets the troops present at the currently selected city and displays them as check boxes.
     */
     open fun createOptions() {
        for (unit in this.unitValues) {
            unitCheckboxes.add(UnitCheckbox(unit))
        }

        // Creates a scroll pane to hold the units
        var scrollPane = ScrollPane()
        scrollPane.minViewportHeight = 200.0
        scrollPane.maxHeight = 200.0

        // Creates a vbox and adds the checkboxes to it
        var interiorVBox = VBox()
        interiorVBox.children.addAll(this.unitCheckboxes)
        scrollPane.content = interiorVBox

        // Puts the vbox in the scroll pane
        this.children.add(scrollPane)
    }

    /**
     * Creates the button to send players back to the control panel "selected city" screen.
     */
    open fun createBackButton() {
        val backButton = Button("Back")
        backButton.onMousePressed = EventHandler<MouseEvent> (fun(event: MouseEvent) {
            ControlPanelManager.toSelectedCityScreen()
        })
        children.add(backButton)
    }

    /**
     * Gets the value of all selected checkboxes.
      */
    open fun getSelectedValues(): ArrayList<Unit> {
        var units = ArrayList<Unit>()
        for(checkbox in unitCheckboxes) {
            if (checkbox.isSelected) {
                units.add(checkbox.unit)
            }
        }

        return units
    }

    /**
     * Creates the button that will initiate the next step.
     * E.x., pressing this button on the combine units screen will actually cause the units to combine.
     */
    open fun createActionButton() {
        val actionButton = Button(this.buttonText)
        if (this.unitCheckboxes.size < 1) {
            actionButton.isDisable = true
        } else {
            actionButton.onMousePressed = EventHandler<MouseEvent> (fun(event: MouseEvent) {
                this.buttonAction()
                AppManager.refreshAllPanels()
            })
        }
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