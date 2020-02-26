/**
 * @author Mitchell Hornsby
 * Represents a road connecting two cities.
 * Each road has a length property that determines how it takes units to traverse them.
 * Also keeps track of Units that are currently travelling along the road.
 */
package models.Map

class Road(val city1: City, val city2: City, val length: Int) {
    val traveler = ArrayList<Unit>()

    override fun toString(): String {
        return "<Road from " + city1.name + " to " + city2.name + ", " + length.toString() + ">"
    }
}