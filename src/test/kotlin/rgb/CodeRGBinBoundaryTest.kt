package rgb

import code.ColorCode
import org.hamcrest.CoreMatchers.*
import org.junit.Assert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class CodeRGBinBoundaryTest(val red : Int, val green: Int, val blue:Int){

    @Test
    fun argumentWellSeatedTest(){

        val code = CodeRGB(red,green,blue)
        println("$red/$green/$blue")
        assertThat(code.red, equalTo(red))
        assertThat(code.green, equalTo(green))
        assertThat(code.blue, equalTo(blue))
    }

    @Test
    fun argumentWellSeatedFromColorCodeTest(){

        val code = ColorCode.getRGB(red,green,blue)
        println("$red/$green/$blue")
        assertThat(code.red, equalTo(red))
        assertThat(code.green, equalTo(green))
        assertThat(code.blue, equalTo(blue))
    }

    companion object{
        @JvmStatic
        @Parameterized.Parameters
        fun data(): List<Array<Int>>{

            return generateWideCaseList()
        }
    }

}