package views.widgets.InfoPanel

import javafx.event.EventHandler
import javafx.scene.control.Label
import javafx.scene.input.MouseEvent
import javafx.scene.layout.*
import javafx.scene.paint.Color
import models.Units.Unit

class UnitClickLabel(val unit: Unit): Label(unit.toString()) {
    init {
        this.onMouseEntered = EventHandler<MouseEvent> (fun(event: MouseEvent) {
            this.border = Border(BorderStroke(Color.BLUE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT))
        })

        this.onMouseExited = EventHandler<MouseEvent> (fun(event: MouseEvent) {
            this.border = Border.EMPTY
        })

        this.onMousePressed = EventHandler<MouseEvent> (fun(event: MouseEvent) {
            InfoPanelManager.toViewUnitScreen(unit)
        })
    }
}