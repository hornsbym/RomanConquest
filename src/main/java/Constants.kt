/**
 * Class for maintaining various "Static" constants in the game
 */
class Constants {
    companion object Constants {
        // Contains constants regarding troop class:
        const val INFANTRY = 0
        const val RANGED = 1
        const val CAVALRY = 2

        // Contains constants regarding stat multipliers:
        // Some of these decrease stats for balancing purposes, like the health multiplier
        const val COMBINED_UNIT_HEALTH_MULTIPLIER = .9

        // Contains constants regarding CombinedUnit restraints:
        const val CENTURY_SIZE_LOWER_BOUND = 6
        const val CENTURY_SIZE_UPPER_BOUND = 10
        const val COHORT_SIZE_LOWER_BOUND = 3
        const val COHORT_SIZE_UPPER_BOUND = 6
        const val LEGION_SIZE_LOWER_BOUND = 6
        const val LEGION_SIZE_UPPER_BOUND = 10
    }
}