package views.widgets.ControlPanel.CheckBoxes

import javafx.event.EventHandler
import javafx.scene.control.CheckBox
import javafx.scene.input.MouseEvent
import models.Units.Unit

class UnitCheckbox(val unit: Unit): CheckBox(unit.toString()) {
}