import Testing.TestDriver

fun main() {
    val driver = TestDriver()

    driver.testNewInfantry()
    driver.testNewRanged()
    driver.testNewCavalry()
    driver.testSmallestCentury()
    driver.testBiggestCentury()
    driver.testTooSmallCentury()
    driver.testTooBigCentury()
    driver.testApplyAttackBanner()
    driver.testRemoveAttackBanner()
    driver.testSmallestCohort()
}