package convert

import cmyk.CodeCMYK
import rgb.CodeRGB
import kotlin.math.roundToInt

fun CodeRGB.toCMYK() : CodeCMYK?{
    val cyan = red / 255f
    val magenta = green / 255f
    val yellow = blue / 255f
    // 키를 최소값으로 취하고 있지만 조절이 가능할 것인가?
    val key = 1 - maxOf(cyan,magenta,yellow)
    if (key == 1.0f) {
        return CodeCMYK(0f,0f,0f,key)
    }
    val c = (1 - cyan - key ) / (1 - key)
    val m = (1 - magenta - key ) / (1 - key)
    val y = (1 - yellow - key ) / (1 - key)
    return CodeCMYK(c,m,y,key)
}


fun CodeCMYK.toRGB() : CodeRGB?{
    val kbar = 1 - key
    val r = (255 * (1 - cyan) * kbar).roundToInt()
    val g = (255 * (1 - magenta) * kbar).roundToInt()
    val b =  (255 * (1 - yellow) * kbar).roundToInt()
    return CodeRGB(r,g,b)
}