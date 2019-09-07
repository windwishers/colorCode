package argb

import code.ColorCode
import org.hamcrest.CoreMatchers
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class EqualTest (val alpha : Int,val red : Int,val green : Int,val  blue:Int){

    @Test
    fun equalBetween4IntInCodeARGBTest(){

        val code = CodeARGB(alpha, red, green, blue)

        Assert.assertThat(code,CoreMatchers.equalTo(CodeARGB(alpha, red, green, blue)))

    }

    @Test
    fun equalBetween4IntInColorCodeTest(){
        val code = ColorCode.getARGB(alpha, red, green, blue)

        Assert.assertThat(code,CoreMatchers.equalTo(CodeARGB(alpha, red, green, blue)))
    }

    @Test
    fun equalBetween3IntInCodeARGBTest(){

        val code = CodeARGB(red, green, blue)

        Assert.assertThat(code,CoreMatchers.equalTo(CodeARGB(255, red, green, blue)))
    }

    @Test
    fun equalBetween3IntInColorCodeTest(){
        val code = ColorCode.getARGB(red, green, blue)

        Assert.assertThat(code,CoreMatchers.equalTo(CodeARGB(255, red, green, blue)))
    }


    companion object{
        @JvmStatic
        @Parameterized.Parameters
        fun data(): List<Array<Int>>{
            return generateARGBInCaseTest()
        }

        private fun generateARGBInCaseTest(): List<Array<Int>> {
            return mutableListOf<Array<Int>>().apply {

                for (alpha in 0..255) {
                    add(arrayOf(alpha, 0, 0, 0))
                }

                for (red in 0..255) {
                    add(arrayOf(0, red, 0, 0))
                }

                for (green in 0..255) {
                    add(arrayOf(0, 0,  green, 0))
                }

                for (blue in 0..255) {
                    add(arrayOf(0, 0, 0,blue))
                }

                val alphas = listOf(0,25,50,75,100)
                val colors = listOf(0,99,127,200,255)

                for (alpha in alphas) {
                    for (red in colors) {
                        for (green in colors) {
                            for (blue in colors) {
                                add(arrayOf(alpha,red,green,blue))
                            }
                        }

                    }
                }
            }.toList()
        }
    }
}