/**
 * @author Mitchell Hornsby
 * Creates a text box for receiving keyboard input from the keyboard.
 * Only accepts capital letters, lowercase letters, and spaces.
 */
package views.widgets

import javafx.scene.Cursor
import javafx.scene.control.TextField
import java.awt.Point
import javafx.scene.text.Font

class InputBox(position: Point): TextField() {
    init {
        this.fontProperty().set(Font(16.0))
        this.prefColumnCount = 20

        this.width = 300.0
        this.height = 50.0
        this.cursor = Cursor.TEXT
    }
}