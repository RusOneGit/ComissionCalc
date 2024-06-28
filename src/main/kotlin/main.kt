fun main() {
    val cardType = "Мир"
    val transfer = 0
    var comission: Double = 0.00
    val limitDay = 150_000
    val limitMonth = 600_000
    val previosTransfer = 0
    val MasterCardLimit = 75_000

    fun CalcComission(cardType: String, previosTransfer: Int, transfer: Int): Double {
        when (cardType) {
            "Мир" -> comission = 0.00
            "Visa" -> comission = Math.max(0.0075 * transfer, 35.0)
            "MasterCard" -> comission =
                if (previosTransfer+transfer <= MasterCardLimit) 0.0 else 0.006 * (transfer+previosTransfer - MasterCardLimit) + 20

        }
        if (transfer <= limitDay && previosTransfer + transfer <= limitMonth) return comission else return 0.00
    }

    println(CalcComission("MasterCard", 0, 150_000))
}