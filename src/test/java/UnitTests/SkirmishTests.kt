package UnitTests

import models.Factories.SkirmishManagerFactory
import models.Factories.TroopFactory
import UnitTests.UnitTestUtils.formCenturyOfSize
import UnitTests.UnitTestUtils.formCohortOfSize
import org.junit.jupiter.api.Test


class SkirmishTests {
    private val smf = SkirmishManagerFactory()

    @Test
    fun testTroopSkirmish() {
        val unit1 = TroopFactory.newCavalry()
        val unit2 = TroopFactory.newInfantry()

        println("Before: ")
        println(unit1)
        println(unit2)

        val manager = smf.newMeleeSkirmishManager(unit1, unit2)
        manager.meleeSkirmish()

        println("After: ")
        println(unit1)
        println(unit2)
    }

    @Test
    fun testCenturySkirmish() {
        val unit1 = formCenturyOfSize(6, Constants.CAVALRY)!!
        val unit2 = formCenturyOfSize(6)!!

        println("Before: ")
        println(unit1)
        println(unit2)

        val manager = smf.newMeleeSkirmishManager(unit1, unit2)
        manager.meleeSkirmish()

        println("After: ")
        println(unit1)
        println(unit2)

        unit2.printUnits()
    }

    @Test
    fun testTroopVsCenturySkirmish() {
        val unit1 = TroopFactory.newInfantry()
        val unit2 = formCenturyOfSize(10)!!

        println("Before: ")
        println(unit1)
        println(unit2)

        val manager = smf.newMeleeSkirmishManager(unit1, unit2)
        manager.meleeSkirmish()

        println("After: ")
        println(unit1)
        println(unit2)
    }

    @Test
    fun testDestroyCentury() {
        val unit1 = formCenturyOfSize(Constants.CENTURY_SIZE_UPPER_BOUND, Constants.CAVALRY)!!
        val unit2 = formCenturyOfSize(Constants.CENTURY_SIZE_LOWER_BOUND, Constants.RANGED)!!

        println("Before: ")
        unit2.printUnits()

        val manager = smf.newMeleeSkirmishManager(unit1, unit2)
        manager.meleeSkirmish()

        println("After: ")
        unit2.printUnits()
    }

    @Test
    fun testDestroyCohort() {
        val unit1 = formCohortOfSize(Constants.COHORT_SIZE_UPPER_BOUND, Constants.CENTURY_SIZE_UPPER_BOUND, Constants.CAVALRY)!!
        val unit2 = formCohortOfSize(Constants.COHORT_SIZE_LOWER_BOUND, Constants.CENTURY_SIZE_LOWER_BOUND, Constants.RANGED)!!

        println("Before: ")
        unit1.printUnits()
        unit2.printUnits()

        val manager = smf.newMeleeSkirmishManager(unit1, unit2)
        manager.meleeSkirmish()

        println("After: ")
        unit1.printUnits()
        unit2.printUnits()
    }
}