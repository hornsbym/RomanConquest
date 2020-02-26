package models.Managers

import models.Units.Unit

/**
 * Class for handling calculations between two battling models.Units.
 * Created before a skirmish, then destroyed after the skirmish has been facilitated.
 */
class MeleeSkirmishManager(private val attacker: Unit, private val defender: Unit) {
    fun meleeSkirmish() {
        // Initial attack
        meleeAttack(attacker, defender)

        // NEED TO MAKE SURE THE DEFENDING UNIT IS STILL ALIVE HERE

        // Counter attack
        meleeAttack(defender, attacker)
    }

    /**
     * Method for facilitating an melee attack.
     * Performs melee attack logic, damaging the defending unit.
     * If the defending unit's health reaches 0, the kills the unit.
     */
    fun meleeAttack(attackingUnit: Unit, defendingUnit: Unit) {
        val damage = ((attackingUnit.melee.toDouble() / defendingUnit.defense.toDouble()) * attackingUnit.melee.toDouble()).toInt()

        defendingUnit.takeDamage(damage)
    }
}
