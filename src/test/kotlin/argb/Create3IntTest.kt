package argb

import code.ColorCode
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Create3IntTest(val alpha : Int, val red : Int, val green : Int, val  blue:Int){

    @Test
    fun create3IntInARGB(){

        val code = CodeARGB(red, green, blue)

        assertThat(code.alpha, equalTo(255))
        assertThat(code.red, equalTo(red))
        assertThat(code.green, equalTo(green))
        assertThat(code.blue, equalTo(blue))
    }

    @Test
    fun create3IntInCodeColor(){
        val code = ColorCode.getARGB(red, green, blue)

        assertThat(code.alpha, equalTo(255))
        assertThat(code.red, equalTo(red))
        assertThat(code.green, equalTo(green))
        assertThat(code.blue, equalTo(blue))
    }



    companion object{
        @JvmStatic
        @Parameterized.Parameters
        fun data(): List<Array<Int>>{
            return generateARGBInCaseTest()
        }

        private fun generateARGBInCaseTest(): List<Array<Int>> {
            return mutableListOf<Array<Int>>().apply {

                 for (red in 0..255) {
                    add(arrayOf(0, red, 0, 0))
                }

                for (green in 0..255) {
                    add(arrayOf(0, 0,  green, 0))
                }

                for (blue in 0..255) {
                    add(arrayOf(0, 0, 0,blue))
                }

                val inBounds = listOf(0,99,127,200,255)


                for (red in inBounds) {
                    for (green in inBounds) {
                        for (blue in inBounds) {
                            add(arrayOf(255,red,green,blue))
                        }
                    }

                }

            }.toList()
        }
    }

}