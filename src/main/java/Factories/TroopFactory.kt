package Factories

import Units.Troop

/**
 * Responsible for generating new, blank troops of each distinct class.
 */
object TroopFactory {
    // Tracks how many of each unit have been made already for naming purposes
    private var infantryCount = 0
    private var rangedCount = 0
    private var cavalryCount = 0

    /**
     * Adds an ordinal abbreviation to the end of the number (etc, 1st, 13th, 24th)
     * @return String
     */
    private fun generateNumberAndOrdinal(number: Int) : String {
        val digitArray = number.toString().toCharArray()

        // Handles outliers (anything ending in 11, 12, or 13)
        if (digitArray.size > 2) {
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
     * Creates and returns a brand new infantry class Troop object.
     * Tracks the number already created for naming purposes
     */
    fun newInfantry() : Troop {
        infantryCount++
        val name = generateNumberAndOrdinal(infantryCount) + " Infantry Unit"
        return Troop(name, 1, 0, Constants.INFANTRY)
    }

    /**
     * Creates and returns a brand new ranged class Troop object.
     * Tracks the number already created for naming purposes
     */
    fun newRanged() : Troop {
        rangedCount++
        val name = generateNumberAndOrdinal(rangedCount) + " Ranged Unit"
        return Troop(name,1, 0, Constants.RANGED)
    }

    /**
     * Creates and returns a brand new cavalry class Troop object.
     * Tracks the number already created for naming purposes
     */
    fun newCavalry() : Troop {
        cavalryCount++
        val name = generateNumberAndOrdinal(cavalryCount) + " Cavalry Unit"
        return Troop(name, 1, 0 , Constants.CAVALRY)
    }
}