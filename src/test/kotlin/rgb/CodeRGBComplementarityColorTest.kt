package rgb

import code.ColorCode
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.*
import org.junit.Assert
import org.junit.Assert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
//TODO 보색 테스트.
@RunWith(Parameterized::class)
class CodeRGBComplementarityColorTest(val red : Int, val green: Int, val blue:Int){

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
        if (code is CodeRGB) {
            println("$red/$green/$blue")
            assertThat(code.red, equalTo(red))
            assertThat(code.green, equalTo(green))
            assertThat(code.blue, equalTo(blue))
        }
    }

    companion object{
        @JvmStatic
        @Parameterized.Parameters
        fun data(): List<Array<Int>>{

            return mutableListOf<Array<Int>>().apply {
                for (red in 0..255) {
                    add(arrayOf(red,0,0))
                }
                for (green in 0..255) {
                    add(arrayOf(0,green,0))
                }
                for (blue in 0..255) {
                    add(arrayOf(0,0,blue))
                }

                val range = listOf(0,23,50,77,100,103,150,200,222,255)

                for (red in range) {
                    for (green in range) {
                        for (blue in range) {
                            add(arrayOf(red,green,blue))
                        }
                    }
                }

            }.toList()
        }
    }


}