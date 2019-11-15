package Units

import Units.Honors.EmptyHonor

class Cohort(private val centuries: ArrayList<Unit>) : CombinedUnit(centuries) {
    var honor = EmptyHonor()
    set(honor)  {
        field = honor
        calculateStats()
    }

    init {
        calculateStats()

    }
}