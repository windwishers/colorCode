package code

data class Hexes(val hex : String, val int : Int, val float : Float, val percent: Int)

object HEX {

    @Suppress("MemberVisibilityCanBePrivate", "unused")
    object FF{

        val H00 = Hexes("00",  0,  0.0f,  0)
        val H19 = Hexes("19", 25, 25.5f, 10)
        val H33 = Hexes("33", 51, 51.0f, 20)
        val H4C = Hexes("4C", 76, 76.5f, 30)
        val H66 = Hexes("66",102,102.0f, 40)
        val H7F = Hexes("7F",127,127.5f, 50)
        val H99 = Hexes("99",153,153.0f, 60)
        val HB2 = Hexes("B2",178,178.5f, 70)
        val HCC = Hexes("CC",204,204.0f, 80)
        val HE9 = Hexes("E9",229,229.0f, 90)
        val HFF = Hexes("FF",255,255.0f,100)

        val MAX = HFF
        val MIN = H00


        object PERCENT{
            val P0   = H00
            val P10  = H19
            val P20  = H33
            val P30  = H4C
            val P40  = H66
            val P50  = H7F
            val P60  = H99
            val P70  = HB2
            val P80  = HCC
            val P90  = HE9
            val P100 = HFF
        }

    }
}