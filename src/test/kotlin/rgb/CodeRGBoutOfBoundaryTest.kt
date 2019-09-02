package rgb

import code.ColorCode
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class CodeRGBoutOfBoundaryTest(val red : Int, val green: Int, val blue:Int){

    @Test(expected = IllegalArgumentException::class)
    fun argumentBoundaryCodeRGB_withFloat(){
        println("$red/$green/$blue")
        CodeRGB(red,blue,green)
    }

    @Test(expected = IllegalArgumentException::class)
    fun argumentBoundaryColorCode_getRGB_withFloat(){
        println("$red/$green/$blue")
        ColorCode.getRGB(red,blue,green)
    }

    @Test(expected = IllegalArgumentException::class)
    fun argumentBoundaryCodeRGB_withInt(){
        val red = red.toInt()
        val green = green.toInt()
        val blue = blue.toInt()
        println("$red/$green/$blue")
        CodeRGB(red,blue,green)
    }

    @Test(expected = IllegalArgumentException::class)
    fun argumentBoundaryColorCode_getRGB_withInt(){
        val red = red.toInt()
        val green = green.toInt()
        val blue = blue.toInt()
        println("$red/$green/$blue")
        ColorCode.getRGB(red,blue,green)
    }

    companion object{
        @JvmStatic
        @Parameterized.Parameters
        fun data() = listOf(
            arrayOf(-1,0,0),   //under  //0
            arrayOf(0,-1,0),
            arrayOf(0,0,-1),
            arrayOf(-1,-1,1),
            arrayOf(-1,0,-1),
            arrayOf(0,-1,-1),
            arrayOf(-1,-1,-1),
            arrayOf(256,0,0),   //over
            arrayOf(0,256,0),
            arrayOf(0,0,256),
            arrayOf(256,256,1),
            arrayOf(256,0,256),
            arrayOf(0,256,256),
            arrayOf(256,256,256),
            arrayOf(Int.MIN_VALUE,0,0),
            arrayOf(0,Int.MIN_VALUE,0),
            arrayOf(0,0,Int.MIN_VALUE),
            arrayOf(Int.MAX_VALUE,0,0),
            arrayOf(0,Int.MAX_VALUE,0),
            arrayOf(0,0,Int.MAX_VALUE)
        )
    }


}