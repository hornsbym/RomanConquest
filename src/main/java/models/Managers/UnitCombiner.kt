package models.Managers

import Constants
import models.Units.Century
import models.Units.Cohort
import models.Units.Legion
import models.Units.Troop
import Utils.generateNumberAndOrdinal

object UnitCombiner {
    // Keeps track of how many centuries, cohorts, and legions exist for naming purposes
    var centuryCount = 0
    var cohortCount = 0
    var legionCount = 0

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