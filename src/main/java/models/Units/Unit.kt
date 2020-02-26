package models.Units

abstract class Unit (override var name: String, override var level: Int, override var xp: Int) : UnitInterface {
    override var health = TroopBaseStats.TROOP_HEALTH
    override var melee  = 0
    override var ranged = 0
    override var movement = 0
    override var defense = 0
    override var cost = 0

    /**
     * Function for changing a troop's health value.
     * Subtracts the damage argument from the unit's health.
     */
    open fun takeDamage(damage: Int) {
        health -= damage
    }
}