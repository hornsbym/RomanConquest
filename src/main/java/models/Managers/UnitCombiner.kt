/**
 * @author Mitchell Hornsby
 * Singleton class responsible for combining and breaking apart units.
 */
package models.Managers

import Constants
import Utils.generateNumberAndOrdinal
import models.Units.*
import models.Units.Unit

object UnitCombiner {
    // Keeps track of how many centuries, cohorts, and legions exist for naming purposes
    var centuryCount = 0
    var cohortCount = 0
    var legionCount = 0

    /**
     * Removes the combined unit from the selected city's list of units.
     * Adds the troops that comprised the combined unit.
     */
    fun disband(combinedUnit: CombinedUnit): ArrayList<out Unit> {
        return combinedUnit.disband()
    }

    /**
     * Recieves an array list of units.
     * If the units can be combined, combines them and returns the combined unit.
     * If the units cannot be combined, does nothing.
     */
    fun combineUnits(units: ArrayList<in Unit>): CombinedUnit? {
        if (units.isEmpty()) {
            return null
        } else if (!unitsMatch(units)){
            return null
        } else {
            when (units[0]!!.javaClass) {
                Troop::class.java -> return formCentury(units as ArrayList<Troop>)
                Century::class.java -> return formCohort(units as ArrayList<Century>)
                Cohort::class.java -> return formLegion(units as ArrayList<Cohort>)
            }
        }
        return null
    }

    /**
     * Makes sure all units in an array list of Units are the same class.
     */
    fun unitsMatch(units: ArrayList<in Unit>) : Boolean {
        var unitsMatch = true

         for (i in 0..units.size-2){
             if (units[i]!!.javaClass !== units[i+1]!!.javaClass) {
                 unitsMatch = false
             }
        }

        return unitsMatch
    }


    /**
     * Checks whether or not a century can be formed based on the number of Troops provided.
     * Returns the new Century if the size of the Troop list is within specified bounds, returns null if not.
     */
    fun formCentury(troopList: ArrayList<Troop>) : Century? {
        if (troopList.size in Constants.CENTURY_SIZE_LOWER_BOUND..Constants.CENTURY_SIZE_UPPER_BOUND) {
            centuryCount++
            val name = generateNumberAndOrdinal(centuryCount) + " Century"

            val newCentury = Century(name, troopList)

            for (troop in troopList) {
                troop.century = newCentury
            }

            return newCentury
        } else {
            return null
        }
    }

    /**
     * Checks whether or not a Cohort can be formed based on the number of Centuries provided.
     * Returns the new Cohort if the size of the Century list is within specified bounds, returns null if not.
     */
    fun formCohort(centuryList: ArrayList<Century>) : Cohort? {
        if (centuryList.size in Constants.COHORT_SIZE_LOWER_BOUND..Constants.COHORT_SIZE_UPPER_BOUND) {
            cohortCount++
            val name = generateNumberAndOrdinal(cohortCount) + " Cohort"

            val newCohort = Cohort(name, centuryList)

            for (century in centuryList) {
                century.cohort = newCohort
            }

            return newCohort
        } else {
            return null
        }
    }

    /**
     * Checks whether or not a Legion can be formed based on the number of Cohorts provided.
     * Returns the new Legion if the size of the Cohort list is within specified bounds, returns null if not.
     */
    fun formLegion(cohortList: ArrayList<Cohort>) : Legion? {
        if (cohortList.size in Constants.LEGION_SIZE_LOWER_BOUND..Constants.LEGION_SIZE_UPPER_BOUND) {
            legionCount++
            val name = generateNumberAndOrdinal(legionCount) + " Legion"
            return Legion(name, cohortList)
        } else {
            return null
        }
    }
}