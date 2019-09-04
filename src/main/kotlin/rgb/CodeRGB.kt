package rgb

import code.ColorCode
import java.lang.NumberFormatException

data class CodeRGB(val red: Int, val green: Int, val blue: Int) : ColorCode<CodeRGB>(code) {

    val hexcode: String = CodeRGBExt.generateHexcode(red,green,blue)
    private val intCode: Int = 0xFF and 0xff shl 24 or (red and 0xff shl 16) or (green and 0xff shl 8) or (blue and 0xff)

    constructor(red: Number, green: Number, blue: Number) : this(red.toInt(),green.toInt(),blue.toInt())

    init {
        if (red !in 0..255 || green !in 0..255 || blue !in 0..255 ) {
            throw IllegalArgumentException("r,g,b의 입력 가능한 범위는 0..255 입니다. $red/$green/$blue")
        }

    }

    override fun getComplementaryColor(): CodeRGB {
        return CodeRGB(255-red,255-green,255-blue)
    }

    fun toInt(): Int = intCode


    companion object{

        fun from(hexcode: String): CodeRGB {

            if (hexcode.length != 4 && hexcode.length != 7) {
                throw IllegalArgumentException("hexcode wrong length /  [$hexcode]")
            }

            if (!hexcode.startsWith("#")) {
                throw IllegalArgumentException("hexcode must start with # but hexcode is [$hexcode]")
            }

            val code = CodeRGBExt.toFullCode(hexcode) ?: hexcode

            val (redHex,greenHex,blueHex) = code.let{
                Triple("${it[1]}${it[2]}","${it[3]}${it[4]}","${it[5]}${it[6]}")
            }

            try {
                return CodeRGB(redHex.toInt(16),greenHex.toInt(16),blueHex.toInt(16))
            } catch (e: NumberFormatException) {
                throw IllegalArgumentException("wrong hexcode contain [$hexcode]",e)
            }
        }

        /** Android Color Int 귝격에 맞는 Int 에 해당 하는 Int 값을 바탕으로 CodeRGB를 생성함.  */
        fun from(intCode: Int) : CodeRGB {

            //https://developer.android.com/reference/android/graphics/Color.html#decoding
//            intCode shr 24 and 0xff // or color >>> 24  // RGB 에서 사용 하지 않음.
            val red = intCode shr 16 and 0xff
            val green = intCode shr 8 and 0xff
            val blue = intCode and 0xff
            return CodeRGB(red,green,blue)
        }

        const val code = "COLOR-CODE : RGB"
    }
}

fun ColorCode.Companion.getRGB(red: Number,green: Number,blue: Number) : CodeRGB = CodeRGB(red,green,blue)

fun ColorCode.Companion.getRGB(hexcode: String): CodeRGB = CodeRGB.from(hexcode)

@Suppress("SpellCheckingInspection")
fun ColorCode.Companion.getRGB(intcode: Int): CodeRGB = CodeRGB.from(intcode)
