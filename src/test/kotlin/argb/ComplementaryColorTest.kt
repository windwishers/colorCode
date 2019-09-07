package argb

import org.hamcrest.CoreMatchers
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class ComplementaryColorTest(
    private val alpha : Int,
    private val red : Int,
    private val green : Int,
    private val blue:Int,
    private val expectedAlpha : Int,
    private val expectedRed : Int,
    private val expectedGreen : Int,
    private val expectedBlue:Int
){

    @Test
    fun complementaryColorTest(){
        val expectedCode = CodeARGB(expectedAlpha,expectedRed,expectedGreen,expectedBlue)

        val code = CodeARGB(alpha, red, green, blue).getComplementaryColor()

        Assert.assertThat(code,CoreMatchers.equalTo(expectedCode))

    }

    companion object{
        @JvmStatic
        @Parameterized.Parameters
        fun data(): List<Array<Int>>{
            return generateTestData()
        }

        private fun generateTestData(): List<Array<Int>>
            = listOf(
            arrayOf(255,0,0,0,255,255,255,255),
            arrayOf(255,255,255,255,255,0,0,0),

            arrayOf(255,255,0,0,255,0,255,255),
            arrayOf(255,0,255,0,255,255,0,255),
            arrayOf(255,0,0,255,255,255,255,0),


            arrayOf(255,255,255,0,255,0,0,255),
            arrayOf(255,0,255,255,255,255,0,0),
            arrayOf(255,255,0,255,255,0,255,0),

            arrayOf(255,0,127,255,255,255,128,0),
            arrayOf(255,127,0,255,255,128,255,0),
            arrayOf(255,255,0,127,255,0,255,128),
            arrayOf(255,255,127,0,255,0,128,255),
            arrayOf(255,127,255,0,255,128,0,255),
            arrayOf(255,0,255,127,255,255,0,128)
        )

    }
}