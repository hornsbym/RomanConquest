package Units.Banners

/**
 * Applies a boost to a Century's ranged attack equivalent to having an extra Ranged troop
 */
class RangedBanner: Banner() {
    override val name = "Apollo"
    override val rangedBoost = TroopBaseStats.RANGED_RANGED
}