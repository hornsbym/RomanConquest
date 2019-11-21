package UnitTests

import Factories.SkirmishManagerFactory
import Factories.TroopFactory
import Units.Unit
import org.junit.jupiter.api.Test


class SkirmishTests {
    private val smf = SkirmishManagerFactory()

    @Test
    fun testTroopSkirmish() {
        val manager = smf.newMeleeSkirmishManager(TroopFactory.newCavalry(), TroopFactory.newInfantry())

    }
}