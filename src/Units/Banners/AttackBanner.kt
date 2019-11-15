package Units.Banners

/**
 * Applies a boost to a Century's melee attack equivalent to having an extra Infantry troop
 */
class AttackBanner: Banner() {
    override val name = "Mars"
    override val meleeBoost = TroopBaseStats.INFANTRY_MELEE
}