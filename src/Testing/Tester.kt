package Testing

import Factories.TroopFactory
import Managers.TroopManager
import Units.Troop

class Tester {
    fun testNewTroop() {
        TroopManager.addTroop(TroopFactory.newInfantry())
        TroopManager.addTroop(TroopFactory.newInfantry())
        TroopManager.addTroop(TroopFactory.newInfantry())

        TroopManager.addTroop(TroopFactory.newRanged())
        TroopManager.addTroop(TroopFactory.newCavalry())

        println(TroopManager)
    }

    fun testFormCentury() {

    }
}