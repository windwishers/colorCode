package cmyk

import code.ColorCode

data class CodeCMYK(val cyan : Float, val magenta : Float,val yellow : Float,val key : Float) : ColorCode<CodeCMYK>(code) {

    init {
        if (cyan !in 0f..1f || magenta !in 0f..1f || yellow !in 0f..1f ||key !in 0f..1f ) {
            throw IllegalArgumentException("cyan, magenta, yellow, key 의 입력 가능한 범위는 0.0 ~ 1.0 입니다. $cyan/$magenta/$yellow/$key")
        }

    }


    /** 해당 CMYK의 보색을 리턴 한다.   */
    override fun getComplementaryColor(): CodeCMYK
            = CodeCMYK(1.0f-cyan,1.0f-magenta,1.0f-yellow,key)


    companion object{
        const val code = "COLOR-CODE : CMYK"
    }
}


fun ColorCode.Companion.getCMYK(cyan : Float,magenta : Float,yellow : Float,key : Float) : CodeCMYK = CodeCMYK(cyan,magenta,yellow,key)