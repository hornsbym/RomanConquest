package Testing

import Factories.TroopFactory
import Managers.UnitCombiner
import Modifiers.Banners.AttackBanner
import Modifiers.Banners.EmptyBanner
import Units.Century
import Units.Cohort
import Units.Troop

class TestDriver {
    init {
        println("Running test suit...")
    }

    /**
     * Tests the creation of new infantry troops
     */
    fun testNewInfantry() {
        var retStr = "Creating new infantry: "

        val troop = TroopFactory.newInfantry()

        val expectedMelee = TroopBaseStats.INFANTRY_MELEE
        val expectedRanged = TroopBaseStats.INFANTRY_RANGED
        val expectedMovement = TroopBaseStats.INFANTRY_MOVEMENT
        val expectedDefense = TroopBaseStats.INFANTRY_DEFENSE

        if (troop.melee == expectedMelee && troop.ranged == expectedRanged && troop.movement == expectedMovement && troop.defense == expectedDefense) {
            retStr += "PASS"
        } else {
            retStr += "FAIL -> " + troop.toString()
        }

        println(retStr)
    }

    /**
     * Tests the creation of new ranged troops
     */
    fun testNewRanged() {
        var retStr = "Creating new ranged: "

        val troop = TroopFactory.newRanged()

        val expectedMelee = TroopBaseStats.RANGED_MELEE
        val expectedRanged = TroopBaseStats.RANGED_RANGED
        val expectedMovement = TroopBaseStats.RANGED_MOVEMENT
        val expectedDefense = TroopBaseStats.RANGED_DEFENSE

        if (troop.melee == expectedMelee && troop.ranged == expectedRanged && troop.movement == expectedMovement && troop.defense == expectedDefense) {
            retStr += "PASS"
        } else {
            retStr += "FAIL -> " + troop.toString()
        }

        println(retStr)
    }

    /**
     * Tests the creation of new ranged troops
     */
    fun testNewCavalry() {
        var retStr = "Creating new cavalry: "

        val troop = TroopFactory.newCavalry()

        val expectedMelee = TroopBaseStats.CAVALRY_MELEE
        val expectedRanged = TroopBaseStats.CAVALRY_RANGED
        val expectedMovement = TroopBaseStats.CAVALRY_MOVEMENT
        val expectedDefense = TroopBaseStats.CAVALRY_DEFENSE

        if (troop.melee == expectedMelee && troop.ranged == expectedRanged && troop.movement == expectedMovement && troop.defense == expectedDefense) {
            retStr += "PASS"
        } else {
            retStr += "FAIL -> " + troop.toString()
        }

        println(retStr)
    }


    /**
     * Tests the formation of a century with only two troops.
     * Should not successfully form a century.
     */
    fun testTooSmallCentury() {
        var retStr = "Forming century with ${Constants.CENTURY_SIZE_LOWER_BOUND - 1} troops: "

        val century = formCenturyOfSize(Constants.CENTURY_SIZE_LOWER_BOUND - 1)

        if (century == null) {
            retStr += "PASS"
        } else {
            retStr += "FAIL --> " + century.toString()
        }

        println(retStr)
    }

    /**
     * Tests the formation of a century with 11 troops.
     * Should not successfully form a century.
     */
    fun testTooBigCentury() {
        var retStr = "Forming century with ${Constants.CENTURY_SIZE_UPPER_BOUND + 1} troops: "

        val century = formCenturyOfSize(Constants.CENTURY_SIZE_UPPER_BOUND + 1)

        if (century == null) {
            retStr += "PASS"
        } else {
            retStr += "FAIL --> " + century.toString()
        }

        println(retStr)
    }

    /**
     * Tests the formation of a century with 10 troops.
     * Should successfully form a century.
     */
    fun testBiggestCentury() {
        var retStr = "Forming century with ${Constants.CENTURY_SIZE_UPPER_BOUND} troops: "

        val century = formCenturyOfSize(Constants.CENTURY_SIZE_UPPER_BOUND)

        if (century != null) {
            retStr += "PASS"
        } else {
            retStr += "FAIL --> " + century.toString()
        }

        println(retStr)
    }

    /**
     * Tests the formation of a century with 6 troops.
     * Should successfully form a century.
     */
    fun testSmallestCentury() {
        var retStr = "Forming century with ${Constants.CENTURY_SIZE_LOWER_BOUND} troops: "

        val century = formCenturyOfSize(Constants.CENTURY_SIZE_LOWER_BOUND)

        if (century != null) {
            retStr += "PASS"
        } else {
            retStr += "FAIL --> " + century.toString()
        }

        println(retStr)
    }

    /**
     * Tests the effect of applying an attack banner to a century.
     * Should increase the effect by the value of the banner's attack boost
     */
    fun testApplyAttackBanner() {
        var retStr = "Applying attack banner: "

        val century = formCenturyOfSize(10)!!
        val initialMelee = century.melee
        val attackBanner = AttackBanner()
        century.banner = attackBanner
        val newMelee = century.melee
        val difference = newMelee - initialMelee

        if (difference == attackBanner.meleeBoost) {
            retStr += "PASS"
        } else {
            retStr += "FAIL -> " + attackBanner.meleeBoost.toString() + " != " + difference.toString()
        }

        println(retStr)
    }

    /**
     * Tests the effect of removing an attack banner from a century.
     * Should reset the century's attack value
     */
    fun testRemoveAttackBanner() {
        var retStr = "Removing attack banner: "

        val century = formCenturyOfSize(10)!!

        val initialMelee = century.melee

        // Applies then removes the attack banner
        century.banner = AttackBanner()
        century.banner = EmptyBanner()

        val newMelee = century.melee

        if (newMelee == initialMelee) {
            retStr += "PASS"
        } else {
            retStr += "FAIL -> " + initialMelee.toString() + " != " + newMelee.toString()
        }

        println(retStr)
    }

    /**
     * Tests the formation of the smallest cohort possible.
     * Forms the smallest possible cohort composed of the smallest possible Centuries.
     */
    fun testSmallestCohort() {
        var retStr = "Forming cohort of ${Constants.COHORT_SIZE_LOWER_BOUND} centuries of ${Constants.CENTURY_SIZE_LOWER_BOUND} troops: "

        val cohort = formCohortOfSize(Constants.COHORT_SIZE_LOWER_BOUND, Constants.CENTURY_SIZE_LOWER_BOUND)

        if (cohort != null) {
            retStr += "PASS"
        } else {
            retStr += "FAIL --> " + cohort.toString()
        }

        println(retStr)
    }

    /**
     * Tests the formation of the smallest cohort possible.
     * Forms the smallest possible cohort composed of the smallest possible Centuries.
     */
    fun testBiggestCohort() {
        var retStr = "Forming cohort from ${Constants.COHORT_SIZE_UPPER_BOUND} centuries of ${Constants.CENTURY_SIZE_UPPER_BOUND}: "

        val cohort = formCohortOfSize(Constants.COHORT_SIZE_UPPER_BOUND, Constants.CENTURY_SIZE_UPPER_BOUND)

        if (cohort != null) {
            retStr += "PASS"
        } else {
            retStr += "FAIL --> " + cohort.toString()
        }

        println(retStr)
    }

    /**
     * Tests the formation of a Cohort from too many Centuries.
     * Should not successfully a Cohort.
     */
    fun testTooBigCohort() {
        var retStr = "Form century with ${Constants.COHORT_SIZE_UPPER_BOUND + 1} centuries: "

        val cohort = formCohortOfSize(Constants.COHORT_SIZE_UPPER_BOUND + 1, Constants.CENTURY_SIZE_LOWER_BOUND)

        if (cohort == null) {
            retStr += "PASS"
        } else {
            retStr += "FAIL --> " + cohort.toString()
        }

        println(retStr)
    }

    /**
     * Tests the formation of a Cohort from too few Centuries.
     * Should not successfully a Cohort.
     */
    fun testTooSmallCohort() {
        var retStr = "Form century with ${Constants.COHORT_SIZE_LOWER_BOUND - 1} centuries: "

        val cohort = formCohortOfSize(Constants.COHORT_SIZE_LOWER_BOUND - 1, Constants.CENTURY_SIZE_LOWER_BOUND)

        if (cohort == null) {
            retStr += "PASS"
        } else {
            retStr += "FAIL --> " + cohort.toString()
        }

        println(retStr)
    }

    /**
     * Convenience method for easily forming a new century of a given size
     * Only forms uniform centuries of all infantry troops
     */
    private fun formCenturyOfSize(n: Int) : Century? {
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
    private fun formCohortOfSize(cohortSize: Int, centurySize: Int) : Cohort? {
        var cohort: Cohort?

        val centuries = ArrayList<Century>()

        for(x in 1..cohortSize){
            centuries.add(formCenturyOfSize(centurySize)!!)
        }

        cohort = UnitCombiner.formCohort(centuries)

        return cohort
    }
}