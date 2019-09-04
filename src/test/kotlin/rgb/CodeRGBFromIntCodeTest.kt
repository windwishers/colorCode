package rgb

import code.ColorCode
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.*
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized


/** android int 디코딩에 준함 (https://developer.android.com/reference/android/graphics/Color#decoding) */
@RunWith(Parameterized::class)
class CodeRGBFromIntCodeTest(data : Pair<Triple<Int, Int, Int>, Int>) {

    private val  argInt = data.second
    private val expectRed = data.first.first
    private val expectGreen = data.first.second
    private val expectBlue = data.first.third


    @Test
    fun codeRGBFromIntTest(){

        val actual = CodeRGB.from(argInt)

        assertThat(actual.red, equalTo(expectRed))
        assertThat(actual.green, equalTo(expectGreen))
        assertThat(actual.blue, equalTo(expectBlue))
    }

    @Test
    fun codeCodeFromIntTest(){

        val actual = ColorCode.getRGB(argInt)

        assertThat(actual.red, equalTo(expectRed))
        assertThat(actual.green, equalTo(expectGreen))
        assertThat(actual.blue, equalTo(expectBlue))
    }


    companion object{
        @JvmStatic
        @Parameterized.Parameters
        fun data(): List<Pair<Triple<Int, Int, Int>, Int>> {
            return generateTripleIntPairList()
        }
    }
}
