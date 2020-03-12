/**
 * @author Mitchell Hornsby
 * A Map class represents a collection of City objects.
 * */
package models.Map

import com.google.gson.Gson
import com.google.gson.JsonArray
import java.io.FileReader

class Map {
    val cities: HashMap<String, City> = HashMap()

    init {
        // Get the city specifics from the 'MapSpecifications.json' file
        val gson = Gson()
        val reader = gson.newJsonReader(FileReader(Utils.rootPath + "/models/Map/MapSpecifications.json"))
        val citySpecificationsJSON = gson.fromJson<JsonArray>(reader, JsonArray::class.java)

        // Pass those city specifications to the 'connectCities' function
        connectCities(citySpecificationsJSON)
    }

    /**
     * Iterates over the provided JSON array.
     * Each item in the array should be in the form "[city, city, distance]"
     * Checks the dictionary of cities, and if a city of either name doesn't exist it creates it.
     * Creates a road between the two cities by storing it in both cities.
     */
    private fun connectCities(citySpecifications: JsonArray){
        for (i in 0 until citySpecifications.size()) {
            // Rename for sanity
            val specification = citySpecifications[i].asJsonArray

            // Extract data from JSON array
            val cityName1 = specification[0].asString
            val cityName2 = specification[1].asString
            val length = specification[2].asInt

            // Create new cities if need be
            // Extract cities if they already exist
            var city1: City;
            var city2: City;

            // First city
            if (this.cities.containsKey(cityName1)) {
                city1 = this.cities[cityName1]!!
            } else {
                city1 = this.createCity(cityName1)
                this.cities[cityName1] = city1
            }

            // Second city
            if (this.cities.containsKey(cityName2)) {
                city2 = this.cities[cityName2]!!
            } else {
                city2 = this.createCity(cityName2)
                this.cities[cityName2] = city2
            }

            // Now, we will always have the two city objects
            // Create the new road, then give both cities a reference to it
            val road = Road(city1, city2, length)
            city1.addRoad(road)
            city2.addRoad(road)
        }
    }

    /**
     * Accepts a city name.
     * Returns the city associated with that name.
     */
    fun getCity(cityName: String): City {
        return cities[cityName]!!
    }


    /**
     * Creates a city from a city name
     */
    private fun createCity(cityName: String): City {
        return City(cityName)
    }

    /**
     * Updates the troops in each city.
     */
    fun updateCityTroopLists() {
        for (cityName in cities.keys) {
            cities[cityName]!!.getTroops()
        }
    }
}