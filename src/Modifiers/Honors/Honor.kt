package Modifiers.Honors

interface Honor {
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


//abstract class Honor {
//    open val name = ""
//    open val healthBoost = 0
//    open val meleeBoost = 0
//    open val rangedBoost = 0
//    open val movementBoost = 0
//    open val defenseBoost = 0
//}