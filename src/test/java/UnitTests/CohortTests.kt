package Unit

import Modifiers.Banners.AttackBanner
import Modifiers.Banners.EmptyBanner
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CohortTests {
    @Test
    fun testCenturyLowerBound() {
        val century = UnitTestUtils.formCenturyOfSize(Constants.CENTURY_SIZE_LOWER_BOUND - 1)
        assertEquals(null, century)
    }

    @Test
    fun testCenturyUpperBound() {
        val century = UnitTestUtils.formCenturyOfSize(Constants.CENTURY_SIZE_UPPER_BOUND + 1)
        assertEquals(null, century)
    }

    @Test
    fun testApplyAttackBanner() {
        val century = UnitTestUtils.formCenturyOfSize(Constants.CENTURY_SIZE_LOWER_BOUND)!!
        val initialMelee = century.melee
        val attBanner = AttackBanner()
        century.banner = attBanner
        val modifiedMelee = century.melee
        val expected = attBanner.meleeBoost
        assertEquals(expected, modifiedMelee - initialMelee)
    }

    @Test
    fun testRemoveAttackBanner() {
        val century = UnitTestUtils.formCenturyOfSize(Constants.CENTURY_SIZE_LOWER_BOUND)!!
        val initialMelee = century.melee
        century.banner = AttackBanner()
        century.banner = EmptyBanner()
        val modifiedMelee = century.melee
        assertEquals(initialMelee, modifiedMelee)
    }
}