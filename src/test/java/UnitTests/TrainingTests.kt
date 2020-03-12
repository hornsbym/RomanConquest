package UnitTests

import models.Factories.TroopFactory
import models.Game
import models.GameSettings
import models.Managers.TrainingManager
import org.junit.jupiter.api.Test

class TrainingTests {
    @Test
    fun testCostPrediction() {
        TrainingManager.addUnit(UnitTestUtils.formCenturyOfSize(6)!!)
        TrainingManager.addUnit(UnitTestUtils.formCohortOfSize(3, 6)!!)
        TrainingManager.addUnit(TroopFactory.newPlayerInfantry())
        TrainingManager.addUnit(TroopFactory.newPlayerInfantry())

        println(TrainingManager.getCostPerTurn())
    }

    @Test
    fun testXPBoost() {
        var Game = Game("Test game", GameSettings())
        var century = UnitTestUtils.formCenturyOfSize(6)!!
        TrainingManager.addUnit(century)

        var initialXp = ArrayList<Pair<String, Int>>()
        for (unit in century.units) {
            initialXp.add(Pair(unit.name, unit.xp))
        }

        TrainingManager.trainAll()

        var afterXp = ArrayList<Pair<String, Int>>()
        for (unit in century.units) {
            afterXp.add(Pair(unit.name, unit.xp))
        }

        for (i in 0..initialXp.size-1) {
            println(initialXp[i].toString() + " -> " + afterXp[i].toString())
        }
    }
}