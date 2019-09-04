package rgb

import org.hamcrest.CoreMatchers
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized


/** android int 인코딩에 준함 (https://developer.android.com/reference/android/graphics/Color#encoding) */
@RunWith(Parameterized::class)
class CodeRGBToIntCodeTest(data : Pair<Triple<Int, Int, Int>, Int>) {

    private val red = data.first.first
    private val green = data.first.second
    private val blue = data.first.third
    private val expected = data.second

    @Test
    fun codeRGBToIntTest(){

        val integer = CodeRGB(red,green,blue).toInt()

        Assert.assertThat(integer,CoreMatchers.equalTo(expected))
    }


    companion object{
        @JvmStatic
        @Parameterized.Parameters
        fun data(): List<Pair<Triple<Int, Int, Int>, Int>> {
            return generateTripleIntPairList()
        }
    }
}