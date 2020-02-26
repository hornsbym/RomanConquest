package UnitTests

import models.Factories.TroopFactory
import UnitTests.UnitTestUtils.formCenturyOfSize
import UnitTests.UnitTestUtils.formCohortOfSize
import org.junit.jupiter.api.Test

class CombatBalanceTests {
    @Test
    fun compareSmallestInfantry() {
        val unit = TroopFactory.newInfantry()
        val century = formCenturyOfSize(Constants.CENTURY_SIZE_LOWER_BOUND)
        val cohort = formCohortOfSize(Constants.COHORT_SIZE_LOWER_BOUND, Constants.CENTURY_SIZE_LOWER_BOUND)

        println(unit)
        println(century)
        println(cohort)
    }

    @Test
    fun compareLargestInfantry() {
        val unit = TroopFactory.newInfantry()
        val century = formCenturyOfSize(Constants.CENTURY_SIZE_UPPER_BOUND)
        val cohort = formCohortOfSize(Constants.COHORT_SIZE_UPPER_BOUND, Constants.CENTURY_SIZE_UPPER_BOUND)

        println(unit)
        println(century)
        println(cohort)
    }

    @Test
    fun compareLargeInfantryCenturyVsSmallInfantryCohort() {
        val century = formCenturyOfSize(Constants.CENTURY_SIZE_UPPER_BOUND)
        val cohort = formCohortOfSize(Constants.COHORT_SIZE_LOWER_BOUND, Constants.CENTURY_SIZE_LOWER_BOUND)

        println(century)
        println(cohort)
    }

    @Test
    fun compareSmallestInfantryCohortVsLargestInfantryCohort() {
        val smallestCohort = formCohortOfSize(Constants.COHORT_SIZE_LOWER_BOUND, Constants.CENTURY_SIZE_LOWER_BOUND)
        val largestCohort = formCohortOfSize(Constants.COHORT_SIZE_UPPER_BOUND, Constants.CENTURY_SIZE_UPPER_BOUND)

        println(smallestCohort)
        println(largestCohort)
    }
}