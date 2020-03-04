package views.widgets.ControlPanel.RadioButtons

import javafx.scene.control.RadioButton
import models.Map.City

class CityRadioButton(val city: City): RadioButton(city.name)