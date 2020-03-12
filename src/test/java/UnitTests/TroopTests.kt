package Unit

import models.Factories.TroopFactory
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TroopTests {
    @Test
    fun testInfantryMelee() {
        val troop = TroopFactory.newPlayerInfantry()
        val expected = TroopBaseStats.INFANTRY_MELEE
        assertEquals(expected, troop.melee)
    }

    @Test
    fun testInfantryRanged() {
        val troop = TroopFactory.newPlayerInfantry()
        val expected = TroopBaseStats.INFANTRY_RANGED
        assertEquals(expected, troop.ranged)
    }

    @Test
    fun testInfantryDefense() {
        val troop = TroopFactory.newPlayerInfantry()
        val expected = TroopBaseStats.INFANTRY_DEFENSE
        assertEquals(expected, troop.defense)
    }

    @Test
    fun testInfantryMovement() {
        val troop = TroopFactory.newPlayerInfantry()
        val expected = TroopBaseStats.INFANTRY_MOVEMENT
        assertEquals(expected, troop.movement)
    }

    @Test
    fun testRangedMelee() {
        val troop = TroopFactory.newPlayerRanged()
        val expected = TroopBaseStats.RANGED_MELEE
        assertEquals(expected, troop.melee)
    }

    @Test
    fun testRangedRanged() {
        val troop = TroopFactory.newPlayerRanged()
        val expected = TroopBaseStats.RANGED_RANGED
        assertEquals(expected, troop.ranged)
    }

    @Test
    fun testRangedDefense() {
        val troop = TroopFactory.newPlayerRanged()
        val expectedMelee = TroopBaseStats.RANGED_DEFENSE
        assertEquals(expectedMelee, troop.defense)
    }

    @Test
    fun testRangedMovement() {
        val troop = TroopFactory.newPlayerRanged()
        val expected = TroopBaseStats.RANGED_MOVEMENT
        assertEquals(expected, troop.movement)
    }

    @Test
    fun testCavalryMelee() {
        val troop = TroopFactory.newPlayerCavalry()
        val expected = TroopBaseStats.CAVALRY_MELEE
        assertEquals(expected, troop.melee)
    }

    @Test
    fun testCavalryRanged() {
        val troop = TroopFactory.newPlayerCavalry()
        val expected = TroopBaseStats.CAVALRY_RANGED
        assertEquals(expected, troop.ranged)
    }

    @Test
    fun testCavalryDefense() {
        val troop = TroopFactory.newPlayerCavalry()
        val expected = TroopBaseStats.CAVALRY_DEFENSE
        assertEquals(expected, troop.defense)
    }

    @Test
    fun testCavalryMovement() {
        val troop = TroopFactory.newPlayerCavalry()
        val expected = TroopBaseStats.CAVALRY_MOVEMENT
        assertEquals(expected, troop.movement)
    }

}