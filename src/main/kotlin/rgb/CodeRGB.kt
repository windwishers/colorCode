package rgb

import code.ColorCode
import java.lang.NumberFormatException

data class CodeRGB(val red: Int, val green: Int, val blue: Int) : ColorCode<CodeRGB>(code) {

    val hexcode: String = CodeRGBExt.generateHexcode(red,green,blue)


    constructor(red: Number, green: Number, blue: Number) : this(red.toInt(),green.toInt(),blue.toInt())

    init {
        if (red !in 0..255 || green !in 0..255 || blue !in 0..255 ) {
            throw IllegalArgumentException("r,g,b의 입력 가능한 범위는 0..255 입니다. $red/$green/$blue")
        }

    }

    override fun getComplementaryColor(): CodeRGB {
        return CodeRGB(255-red,255-green,255-blue)
    }


    companion object{

        fun from(hexcode: String): CodeRGB {

            if (hexcode.length != 4 && hexcode.length != 7) {
                throw IllegalArgumentException("hexcode wrong length /  [$hexcode]")
            }

            if (!hexcode.startsWith("#")) {
                throw IllegalArgumentException("hexcode must start with # but hexcode is [$hexcode]")
            }

            //TODO toFullCode 내부에서 isShorten 을 처리하고 있기 때문에 코드를 제거 하는 것을 검토 할 것.
            val code = if(CodeRGBExt.isShorten(hexcode)) CodeRGBExt.toFullCode(hexcode) else hexcode

            code ?: throw IllegalArgumentException("wrong formatted hexcode in [$hexcode]")

            val (redHex,greenHex,blueHex) = code.let{it: String ->
                Triple("${it[1]}${it[2]}","${it[3]}${it[4]}","${it[5]}${it[6]}")
            }

            try {
                return CodeRGB(redHex.toInt(16),greenHex.toInt(16),blueHex.toInt(16))
            } catch (e: NumberFormatException) {
                throw IllegalArgumentException("wrong hexcode contain [$hexcode]",e)
            }
        }

        const val code = "COLOR-CODE : RGB"
    }
}

fun ColorCode.Companion.getRGB(red: Number,green: Number,blue: Number) : CodeRGB = CodeRGB(red,green,blue)

fun ColorCode.Companion.getRGB(hexcode: String): CodeRGB = CodeRGB.from(hexcode)


