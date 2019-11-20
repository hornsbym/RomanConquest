package Unit

import Factories.TroopFactory
import Managers.UnitCombiner
import Units.Century
import Units.Cohort
import Units.Troop

object UnitTestUtils {
    /**
     * Convenience method for easily forming a new century of a given size
     * Only forms uniform centuries of all infantry troops
     */
    fun formCenturyOfSize(n: Int) : Century? {
        var century: Century?
        val units = ArrayList<Troop>()
        for(x in 1..n){
            units.add(TroopFactory.newInfantry())
        }
        century = UnitCombiner.formCentury(units)
        return century
    }

    /**
     * Convenience method for easily forming a new cohort of a given size
     * Only forms uniform cohorts composed of centuries of the provided size of infantry troops
     * @param centurySize must be an integer between 6 and 10
     */
    fun formCohortOfSize(cohortSize: Int, centurySize: Int) : Cohort? {
        var cohort: Cohort?
        val centuries = ArrayList<Century>()
        for(x in 1..cohortSize){
            centuries.add(formCenturyOfSize(centurySize)!!)
        }
        cohort = UnitCombiner.formCohort(centuries)
        return cohort
    }
}