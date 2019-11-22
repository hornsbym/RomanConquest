package UnitTests

import Factories.SkirmishManagerFactory
import Factories.TroopFactory
import UnitTests.UnitTestUtils.formCenturyOfSize
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
}