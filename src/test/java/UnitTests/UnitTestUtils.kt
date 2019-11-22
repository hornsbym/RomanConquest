package UnitTests

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
    fun formCenturyOfSize(n: Int, troopType: Int = Constants.INFANTRY) : Century? {
        var century: Century?
        val units = ArrayList<Troop>()

        if (troopType == Constants.INFANTRY){
            for(x in 1..n){
                units.add(TroopFactory.newInfantry())
            }
        } else if (troopType == Constants.RANGED) {
            for(x in 1..n){
                units.add(TroopFactory.newRanged())
            }
        } else if (troopType == Constants.CAVALRY) {
            for(x in 1..n){
                units.add(TroopFactory.newCavalry())
            }
        }

        century = UnitCombiner.formCentury(units)
        return century
    }

    /**
     * Convenience method for easily forming a new cohort of a given size
     * Only forms uniform cohorts composed of centuries of the provided size a uniform troop type
     * @param centurySize must be an integer between 6 and 10
     * @param troopType defaults to Infantry, but can be overwritten to make centuries of the other troop types
     */
    fun formCohortOfSize(cohortSize: Int, centurySize: Int, troopType: Int = Constants.INFANTRY) : Cohort? {
        var cohort: Cohort?
        val centuries = ArrayList<Century>()
        for(x in 1..cohortSize){
            centuries.add(formCenturyOfSize(centurySize)!!)
        }
        cohort = UnitCombiner.formCohort(centuries)
        return cohort
    }
}