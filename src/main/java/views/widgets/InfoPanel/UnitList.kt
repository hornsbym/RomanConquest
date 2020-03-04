/**
 * @author Mitchell Hornsby
 * Creates a widget for displaying info in the info panel
 */
package views.widgets.InfoPanel

import javafx.scene.control.ScrollPane
import javafx.scene.layout.VBox
import models.Units.Unit

class UnitList(units: ArrayList<out Unit>): ScrollPane() {
    val vbox = VBox()
    init {
        this.minViewportHeight = 200.0
        this.maxHeight = 200.0

        for (unit in units) {
            vbox.children.add(UnitClickLabel(unit))
        }
        content = vbox
    }
}