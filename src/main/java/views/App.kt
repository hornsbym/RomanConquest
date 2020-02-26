/**
 * @author Mitchell Hornsby
 * Top level view.
 * Contains entire game interface that the user will interact with.
 * Contains no game logic, but rather represents what's found in the "models" package.
 * Responsible for providing the Game class with the player's name and settings.
 */
package views

import javafx.application.Application
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.scene.layout.GridPane
import javafx.stage.Stage
import javafx.scene.control.Button
import javafx.scene.control.ChoiceBox
import javafx.scene.layout.BorderPane
import models.Game
import models.GameSettings
import views.widgets.ControlPanel.ControlPanelManager
import views.widgets.InfoPanel.InfoPanelManager
import views.widgets.MapPanel.MapPanel
import views.widgets.InputBox
import views.widgets.MapPanel.MapPanelManager
import views.widgets.PlayerPanel.PlayerPanel
import java.awt.Point

class App: Application() {
    lateinit var primaryStage: Stage
    lateinit var game: Game

    override fun start(primaryStage: Stage) {
        this.primaryStage = primaryStage

        this.startPhase0()
    }

    private fun startPhase0() {
        // Get a container.
        val grid = GridPane()
        grid.alignment = Pos.CENTER

        // Set the scene on the stage. The scene is basically everything you see within the window.
        this.primaryStage.scene = Scene(grid)

        // Define the widgets.
        val nameLabel = Label("Name")
        val nameInput = InputBox(Point(0,0))
        val settingsLabel = Label("Settings")
        val settingsChoicebox = ChoiceBox<String>()
        val submitButton = Button("Play!")

        // Allow us to submit by pressing enter
        submitButton.isDefaultButton = true

        // Tweak the choice box settings.
        settingsChoicebox.items.add("Easy")
        settingsChoicebox.items.add("Standard")
        settingsChoicebox.items.addAll(("Hard"))
        settingsChoicebox.value = "Standard"

        // Tweak submit button.
        // This function will be fired whenever the button is clicked.
        submitButton.onAction = EventHandler<ActionEvent>(fun(event: ActionEvent): Unit {
            this.startPhase1(nameInput.getText())
            return
        })

        // Add the widgets to the grid.
        grid.add(nameLabel, 0, 0)
        grid.add(nameInput, 1, 0)
        grid.add(settingsLabel, 0, 1)
        grid.add(settingsChoicebox, 1, 1)
        grid.add(submitButton, 1, 2)

        // Display the window and its contents:
        this.primaryStage.show()
    }

    private fun startPhase1(name: String) {
        // Create a new game
        game = Game(name, GameSettings())

        // Create a blank grid and a new scene.
        var root = BorderPane()

        // Change the visible scene to the new one.
        var scene = Scene(root)

        // Initialize singleton manager classes
        MapPanelManager.setMap(game.map)

        // Create UI panels
        var mapPanel = MapPanelManager.mapPanel
        var playerPanel = PlayerPanel()
        var infoPanel = InfoPanelManager.infopanel
        var controlPanel = ControlPanelManager.controlPanel

        // Set alignments within border pane
        BorderPane.setAlignment(mapPanel, Pos.TOP_LEFT)

        // Add UI panels
        root.center = mapPanel
        root.top = playerPanel
        root.left= infoPanel
        root.right = controlPanel

        this.primaryStage.scene = scene
    }
}