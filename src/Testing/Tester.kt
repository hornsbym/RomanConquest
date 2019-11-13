package Testing

import Factories.TroopFactory
import Managers.UnitCombiner
import Managers.TroopManager
import Units.Banners.AttackBanner
import Units.Banners.EmptyBanner
import Units.Troop

class Tester {
    /**
     * Tests the creation of new troops
     */
    fun testNewTroop() {
        TroopManager.addTroop(TroopFactory.newInfantry())
        TroopManager.addTroop(TroopFactory.newInfantry())
        TroopManager.addTroop(TroopFactory.newInfantry())

        TroopManager.addTroop(TroopFactory.newRanged())
        TroopManager.addTroop(TroopFactory.newCavalry())

        println(TroopManager)
    }

    /**
     * Tests the formation of differently sized uniform Centuries
     */
    fun testUniformCenturyCreation() {
        val twoUnits = ArrayList<Troop>()
        val sixUnits = ArrayList<Troop>()
        val tenUnits = ArrayList<Troop>()

        for (x in 1..2) {
            twoUnits.add(TroopFactory.newInfantry())
        }

        for (x in 1..6) {
            sixUnits.add(TroopFactory.newInfantry())
        }

        for (x in 1..10) {
            tenUnits.add(TroopFactory.newInfantry())
        }

        println(UnitCombiner.formCentury(twoUnits))
        println(UnitCombiner.formCentury(sixUnits))
        println(UnitCombiner.formCentury(tenUnits))
    }

    /**
     * Tests the effects of applying an attack banner to a century
     */
    fun testAttackBanner() {
        val troops = ArrayList<Troop>()

        for (x in 1..10) {
            troops.add(TroopFactory.newInfantry())
        }

        val century = UnitCombiner.formCentury(troops)
        println(century)
        century?.banner = AttackBanner()
        println(century)
        century?.banner = EmptyBanner()
        println(century)
    }
}