package argb

import code.ColorCode
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Create4OutTest(val alpha : Int, val red : Int, val green : Int, val  blue:Int){

    @Test(expected = IllegalArgumentException::class)
    fun create4IntInARGB(){

        CodeARGB(alpha, red, green, blue)

        //no assert here
    }

    @Test(expected = IllegalArgumentException::class)
    fun create4IntInCodeColor(){

        ColorCode.getARGB(alpha, red, green, blue)

        //no assert here
    }



    companion object{
        @JvmStatic
        @Parameterized.Parameters
        fun data(): List<Array<Int>>{
            return generateARGBOutCaseTest()
        }

        private fun generateARGBOutCaseTest(): List<Array<Int>> {
            return mutableListOf<Array<Int>>().apply {


                val outBounds = listOf(Int.MIN_VALUE,-1,256,Int.MAX_VALUE)


                for (alpha in outBounds) {
                    add(arrayOf(alpha, 0, 0, 0))
                }

                for (red in outBounds) {
                    add(arrayOf(0, red, 0, 0))
                }

                for (green in outBounds) {
                    add(arrayOf(0, 0,  green, 0))
                }

                for (blue in outBounds) {
                    add(arrayOf(0, 0, 0,blue))
                }



                for (alpha in outBounds) {
                    for (red in outBounds) {
                        for (green in outBounds) {
                            for (blue in outBounds) {
                                add(arrayOf(alpha,red,green,blue))
                            }
                        }

                    }
                }
            }.toList()
        }
    }

}