package argb

import code.ColorCode

data class CodeARGB(val alpha: Int, val red: Int, val green: Int, val blue: Int) : ColorCode<CodeARGB>(code){

    constructor(red: Int, green: Int,blue: Int) : this(255,red,green,blue)

    init {

        if (alpha !in 0..255 ) {
            throw IllegalArgumentException("alpha 의 입력 가능한 범위는 0..255 입니다. $alpha/$red/$green/$blue")
        }

        if (red !in 0..255 || green !in 0..255 || blue !in 0..255 ) {
            throw IllegalArgumentException("red,green ,blue 의 입력 가능한 범위는 0..255 입니다. $alpha/$red/$green/$blue")
        }
    }

    override fun getComplementaryColor(): CodeARGB = CodeARGB(alpha,255-red,255- green,255- blue)

    companion object{
        const val code = "COLOR-CODE : ARGB"
    }

}

fun ColorCode.Companion.getARGB(alpha: Int,red: Int,green: Int,blue: Int) : CodeARGB = CodeARGB(alpha,red,green,blue)
fun ColorCode.Companion.getARGB(red: Int,green: Int,blue: Int) : CodeARGB = CodeARGB(red,green,blue)