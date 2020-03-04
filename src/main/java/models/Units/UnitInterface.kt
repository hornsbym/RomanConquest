package models.Units

/**
 * Outlines the basic functionality of any given unit in the game
 */
interface UnitInterface {
    var name: String

    var health: Int
    var melee: Int
    var ranged: Int
    var movement: Int
    var defense: Int

    var purchaseCost: Int
    var trainingCost: Int
    var xp: Int
    var level: Int
}