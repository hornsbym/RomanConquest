import models.Units.Unit

/**
 * @author Mitchell Hornsby
 * Misc. convenience functions/properties
 */
object Utils {
    val rootPath = System.getProperty("user.dir") + "/src/main/java"

    /**
     * Adds an ordinal abbreviation to the end of the number (etc, 1st, 13th, 24th)
     * @return String
     */
    fun generateNumberAndOrdinal(number: Int) : String {
        val digitArray = number.toString().toCharArray()

        // Handles outliers (anything ending in 11, 12, or 13)
        if (digitArray.size >= 2) {
            val outlierCheck = digitArray.sliceArray(IntRange(digitArray.size - 2, digitArray.size - 1)).joinToString("")
            if (outlierCheck == "11" || outlierCheck == "12" || outlierCheck == "13") {
                return number.toString() + "th"
            }
        }

        val lastDigit = digitArray[digitArray.size - 1]
        var ordinal: String
        when(lastDigit) {
            '1'  -> ordinal = "st"
            '2'  -> ordinal = "nd"
            '3'  -> ordinal = "rd"
            else -> ordinal = "th"
        }
        return number.toString() + ordinal
    }

    /**
     * Picks a random item from an array list and returns it.
     */
    fun pickFromArrayList(arrayList: ArrayList<out Any>): Any {
        arrayList.shuffle()
        return arrayList[0]
    }

    /**
     * Determines whether each Unit in an array has at least 1 remaining move.
     */
    fun allUnitsCanMove(units: ArrayList<Unit>): Boolean {
        var returnBool = true

        for (unit in units) {
            if (!unit.canMove()) {
                returnBool = false
            }
        }

        return returnBool
    }
}