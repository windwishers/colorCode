package argb

import code.ColorCode
import code.toHex


data class CodeARGB(val alpha: Int, val red: Int, val green: Int, val blue: Int) : ColorCode<CodeARGB>(code){

    constructor(red: Int, green: Int, blue: Int) : this(255,red,green,blue)

    val hexcode: String = ("#" + (alpha toHex 2) + (red toHex 2) + (green toHex 2) + (blue toHex 2)).toUpperCase()

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
        fun from(hexcode: String): CodeARGB {
            checkValidation(hexcode)
            try {
                val (a, r, g, b) = hexcode.removeRange(0..0).chunked(2).map {
                    it.toInt(16)
                }
                return CodeARGB(a,r,g,b)
            } catch (e: Exception) {
                throw IllegalArgumentException("wrong format hexcode [$hexcode]",e)
            }

        }

        // 비어 있지 않을 것 # 으로 시작 할 것. 길이가 9일 것
        // 1~9까지의 핵스값 범위가 정확한지는 검사하지 않는데.
        // 이유는 변환과정에서 익셉션이 터질 때 처리 할 것이라 입니다.
        private fun checkValidation(hexcode: String) {

            val t : Throwable? = when {
                hexcode.isBlank() -> IllegalArgumentException("hexcode is blink")
                !hexcode.startsWith("#") -> IllegalArgumentException("hexcode is not starts with # [$hexcode]")
                hexcode.length != 9 -> IllegalArgumentException("hexcode length is not 9 [$hexcode]")  // argb 는 #FFFF 를 지원하지 않도록 하자.
                else -> null
            }

            t?.let {
                throw it
            }
        }

        const val code = "COLOR-CODE : ARGB"
    }

}



fun ColorCode.Companion.getARGB(alpha: Int,red: Int,green: Int,blue: Int) : CodeARGB = CodeARGB(alpha,red,green,blue)
fun ColorCode.Companion.getARGB(red: Int,green: Int,blue: Int) : CodeARGB = CodeARGB(red,green,blue)
fun ColorCode.Companion.getARGB(hexcode : String) : CodeARGB = CodeARGB.from(hexcode)