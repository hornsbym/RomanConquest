package models.Modifiers.Banners

interface Banner {
    val name: String

    val healthBoost: Int
        get() = 0

    val meleeBoost: Int
        get() = 0

    val rangedBoost: Int
        get() = 0

    val movementBoost: Int
        get() = 0

    val defenseBoost: Int
        get() = 0
}