package rgb

/** 가용 범위를 최대한 넓게 포함 하도록 케이스 리스트를 뽑는 함수. 총 255 * 3 + 10 * 10 * 10  해서 총 1765개 의 케이스가 나온다. */
fun generateWideCaseList(): List<Array<Int>> {
    return mutableListOf<Array<Int>>().apply {
        for (red in 0..255) {
            add(arrayOf(red, 0, 0))
        }
        for (green in 0..255) {
            add(arrayOf(0, green, 0))
        }
        for (blue in 0..255) {
            add(arrayOf(0, 0, blue))
        }

        val range = listOf(0, 23, 50, 77, 100, 103, 150, 200, 222, 255)

        for (red in range) {
            for (green in range) {
                for (blue in range) {
                    add(arrayOf(red, green, blue))
                }
            }
        }

    }.toList()
}

/** formattedString 과 매칭 되는 code 값이 나오는 Pair 가 나오는 케이스 리스트다. */
fun generateStringToCodePairList(): List<Pair<String, CodeRGB>> {
    return mutableListOf<Pair<String, CodeRGB>>().apply {
        add("#000000" to CodeRGB(0, 0, 0))
        add("#FFFFFF" to CodeRGB(255, 255, 255))
        //primary
        add("#FF0000" to CodeRGB(255, 0, 0))
        add("#00FF00" to CodeRGB(0, 255, 0))
        add("#0000FF" to CodeRGB(0, 0, 255))
        //secondary
        add("#FFFF00" to CodeRGB(255, 255, 0))   // yellow
        add("#00FFFF" to CodeRGB(0, 255, 255))   // cyan
        add("#FF00FF" to CodeRGB(255, 0, 255))   // magenta
        //Tertiary
        add("#007FFF" to CodeRGB(0, 127, 255))   // azure  ( blue + cyan)
        add("#7F00FF" to CodeRGB(127, 0, 255))   // violet (
        add("#FF007F" to CodeRGB(255, 0, 127))   // rose
        add("#FF7F00" to CodeRGB(255, 127, 0))   // orange
        add("#7FFF00" to CodeRGB(127, 255, 0))   // chartreuse
        add("#00FF7F" to CodeRGB(0, 255, 127))   // spring green

    }.toList()
}

fun generateTripleIntPairList()
        = listOf(
    Triple(0,0,0) to        -16777216,  //Triple(0,0,0) to 0xFF000000
    Triple(3,3,3) to        -16579837,  //Triple(3,3,3) to 0xFF030303
    Triple(6,6,6) to        -16382458,  //Triple(6,6,6) to 0xFF060606
    Triple(10,10,10) to     -16119286,  //Triple(10,10,10) to 0xFF0A0A0A
    Triple(51,51,51) to     -13421773,  //Triple(51,51,51) to 0xFF333333
    Triple(102,102,102) to  -10066330,  //Triple(102,102,102) to 0xFF666666
    Triple(153,153,153) to  -6710887,   //Triple(153,153,153) to 0xFF999999
    Triple(204,204,204) to  -3355444,   //Triple(204,204,204) to 0xFFCCCCCC
    Triple(255,255,255) to  -1,         //Triple(255,255,255) to 0xFFFFFFFF
    Triple(255,0,0) to      -65536,     //Triple(255,0,0) to 0xFFFF0000
    Triple(0,255,0) to      -16711936,  //Triple(0,255,0) to 0xFF00FF00
    Triple(0,0,255) to      -16776961,  //Triple(0,0,255) to 0xFF0000FF
    Triple(255,255,0) to    -256,       //Triple(255,255,0) to 0xFFFFFF00
    Triple(0,255,255) to    -16711681,  //Triple(0,255,255) to 0xFF00FFFF
    Triple(255,0,255) to    -65281,     //Triple(255,0,255) to 0xFFFF00FF
    Triple(0,127,255) to    -16744449,  //Triple(0,127,255) to 0xFF007FFF
    Triple(127,0,255) to    -8453889,   //Triple(127,0,255) to 0xFF7F00FF
    Triple(255,0,127) to    -65409,     //Triple(255,0,127) to 0xFFFF007F
    Triple(255,127,0) to    -33024,     //Triple(255,127,0) to 0xFFFF7F00
    Triple(127,255,0) to    -8388864,   //Triple(127,255,0) to 0xFF7FFF00
    Triple(0,255,127) to    -16711809   //Triple(0,255,127) to 0xFF00FF7F
)


/*

























 */