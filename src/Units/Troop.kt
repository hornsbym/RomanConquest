package Units

class Troop(var level: Int, var xp: Int, val classification: Int) {
    var health = 100
    var melee  = 0
    var ranged = 0
    var movement = 0
    var defense = 0

    init {
        // Assigns strengths depending on a Troop's class
        when(classification){
            Constants.INFANTRY -> {melee=8; ranged=0; movement=1; defense=4}
            Constants.RANGED -> {melee=2; ranged=6; movement=1; defense=1}
            Constants.CAVALRY -> {melee=12; ranged=0; movement=3; defense=2}
        }
    }

    override fun toString(): String {
        return "<Troop level=${level} xp:${xp} stats(h,me,r,mo,d):(${health}, ${melee}, ${ranged}, ${movement}, ${defense}) class=${classification}>"
    }
}