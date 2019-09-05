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

    /** CodeCMYK.equalBound 간격이내의 오차는 무시한다.  */
    override fun equals(other: Any?)
            = if (other is CodeCMYK) {
                (closeTo(cyan,other.cyan, equalBound)
                && closeTo(magenta,other.magenta,0.0001f)
                && closeTo(yellow,other.yellow,0.0001f)
                && closeTo(key,other.key,0.0001f))
            }else {
                super.equals(other)
            }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + cyan.hashCode()
        result = 31 * result + magenta.hashCode()
        result = 31 * result + yellow.hashCode()
        result = 31 * result + key.hashCode()
        return result
    }

    companion object{
        const val code = "COLOR-CODE : CMYK"
        const val equalBound = 0.000001f
        fun closeTo(float1 : Float,float2:Float,bound : Float) : Boolean{
            return when{
                float1 == float2 -> true
                float1 > float2 -> float1 - float2 <= bound
                float1 < float2 -> float2 - float1 <= bound
                else -> false
            }
        }
    }
}


fun ColorCode.Companion.getCMYK(cyan : Float,magenta : Float,yellow : Float,key : Float) : CodeCMYK = CodeCMYK(cyan,magenta,yellow,key)