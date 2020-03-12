package future

import models.Units.Unit

/**
 * Class for creating new skirmish managers
 * Each battle manager will maintain a single instance of this class.
 */
class SkirmishManagerFactory {
    fun newMeleeSkirmishManager(attacker: Unit, defender: Unit) : MeleeSkirmishManager {
        return MeleeSkirmishManager(attacker, defender)
    }
}