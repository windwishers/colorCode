package rgb

import org.hamcrest.CoreMatchers.*
import org.junit.Assert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class CodeRGBComplementarityColorTest(val red : Int, val green: Int, val blue:Int,val complementRed : Int, val complementGreen: Int, val complementBlue:Int){



    @Test
    fun complementarityColorInverseTest() {

        val code = CodeRGB(red, green, blue)
        val complement = CodeRGB(complementRed,complementGreen,complementBlue)

        assertThat(code.getComplementaryColor(),equalTo(complement))

    }


    companion object{
        @JvmStatic
        @Parameterized.Parameters
        fun data(): List<Array<Int>>{

            return mutableListOf<Array<Int>>().apply {
                add(arrayOf(0,0,0,255,255,255))  //  black
                add(arrayOf(255,255,255,0,0,0))  //  white
                add(arrayOf(255,0,0,0,255,255))  //  red
                add(arrayOf(255,0,0,0,255,255))  //  green
                add(arrayOf(255,0,0,0,255,255))  //  blue


            }.toList()
        }
    }


}