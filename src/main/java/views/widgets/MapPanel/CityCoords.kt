/**
 * @author Mitchell Hornsby
 * Class containing information about where each city should be placed on the map.
 * Each pair represents the a set of (x, y) pixel coordinates.
 */
package views.widgets.MapPanel

object CityCoords {
    val coords = HashMap<String, Pair<Int, Int>>()

    init {
        coords["Rome"] = Pair(476, 488)
        coords["Neapolis"] = Pair(509, 510)
        coords["Perusia"] = Pair(472, 460)
        coords["Volterra"] = Pair(454, 474)
        coords["Arretium"] = Pair(454, 453)
        coords["Croton"] = Pair(537, 535)
        coords["Tares"] = Pair(547, 515)
        coords["Syracuse"] = Pair(513, 569)
        coords["Panormus"] = Pair(491, 561)
    }
}