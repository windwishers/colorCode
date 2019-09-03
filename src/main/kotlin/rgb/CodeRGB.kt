package rgb

import code.ColorCode

data class CodeRGB(val red: Int, val green: Int, val blue: Int) : ColorCode<CodeRGB>(code) {

    val hexcode: String = RGBCode.generateHexcode(red,green,blue)


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
        fun from(formattedString: String): CodeRGB {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        const val code = "COLOR-CODE : RGB"
    }
}

fun ColorCode.Companion.getRGB(red: Number,green: Number,blue: Number) : CodeRGB = CodeRGB(red,green,blue)

fun ColorCode.Companion.getRGB(formattedString: String): CodeRGB = CodeRGB.from(formattedString)


