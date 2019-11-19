package Managers

import Constants
import Units.Century
import Units.Cohort
import Units.Troop

object UnitCombiner {
    /**
     * Checks whether or not a century can be formed based on the number of Troops provided.
     * Returns the new Century if the size of the Troop list is within the bounds, returns null if not.
     */
    fun formCentury(troopList: ArrayList<Troop>) : Century? {
        if (troopList.size in Constants.CENTURY_SIZE_LOWER_BOUND..Constants.CENTURY_SIZE_UPPER_BOUND) {
            return Century(troopList)
        } else {
            return null
        }
    }

    /**
     * Checks whether or not a Cohort can be formed based on the number of Centuries provided.
     * Returns the new Cohort if the size of the Century list is within the bounds, returns null if not.
     */
    fun formCohort(centuryList: ArrayList<Century>) : Cohort? {
        if (centuryList.size in Constants.COHORT_SIZE_LOWER_BOUND..Constants.COHORT_SIZE_UPPER_BOUND) {
            return Cohort(centuryList)
        } else {
            return null
        }
    }
}