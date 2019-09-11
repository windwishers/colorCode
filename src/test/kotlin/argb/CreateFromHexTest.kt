package argb

import code.ColorCode
import code.HEX.FF
import org.hamcrest.CoreMatchers
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class CreateFromHexTest(
    private val hexcode: String,
    private val expectedAlpha: Int,
    private val expectedRed: Int ,
    private val expectedGreen: Int ,
    private val expectedBlue: Int
) {

    @Test
    fun createFromHexInCodeARGBTest(){

        val code = CodeARGB.from(hexcode)


        Assert.assertThat(code.alpha, CoreMatchers.equalTo(expectedAlpha))
        Assert.assertThat(code.red, CoreMatchers.equalTo(expectedRed))
        Assert.assertThat(code.green, CoreMatchers.equalTo(expectedGreen))
        Assert.assertThat(code.blue, CoreMatchers.equalTo(expectedBlue))
    }

    @Test
    fun createFromHexInColorCodeTest(){

        val code = ColorCode.getARGB(hexcode)

        Assert.assertThat(code.alpha, CoreMatchers.equalTo(expectedAlpha))
        Assert.assertThat(code.red, CoreMatchers.equalTo(expectedRed))
        Assert.assertThat(code.green, CoreMatchers.equalTo(expectedGreen))
        Assert.assertThat(code.blue, CoreMatchers.equalTo(expectedBlue))
    }


    companion object{
        @JvmStatic
        @Parameterized.Parameters
        fun data(): List<Array<Any>>{
            return generateTestCase()
        }

        private fun generateTestCase(): List<Array<Any>> {
            return mutableListOf<Array<Any>>().apply {

                add(arrayOf("#00000000",FF.H00.int,FF.H00.int,FF.H00.int,FF.H00.int))
                add(arrayOf("#33000000",FF.H33.int,FF.H00.int,FF.H00.int,FF.H00.int))
                add(arrayOf("#66000000",FF.H66.int,FF.H00.int,FF.H00.int,FF.H00.int))
                add(arrayOf("#99000000",FF.H99.int,FF.H00.int,FF.H00.int,FF.H00.int))
                add(arrayOf("#CC000000",FF.HCC.int,FF.H00.int,FF.H00.int,FF.H00.int))
                add(arrayOf("#FF000000",FF.HFF.int,FF.H00.int,FF.H00.int,FF.H00.int))

                add(arrayOf("#00000000",FF.H00.int,FF.H00.int,FF.H00.int,FF.H00.int))
                add(arrayOf("#00330000",FF.H00.int,FF.H33.int,FF.H00.int,FF.H00.int))
                add(arrayOf("#00660000",FF.H00.int,FF.H66.int,FF.H00.int,FF.H00.int))
                add(arrayOf("#00990000",FF.H00.int,FF.H99.int,FF.H00.int,FF.H00.int))
                add(arrayOf("#00CC0000",FF.H00.int,FF.HCC.int,FF.H00.int,FF.H00.int))
                add(arrayOf("#00FF0000",FF.H00.int,FF.HFF.int,FF.H00.int,FF.H00.int))

                add(arrayOf("#00000000",FF.H00.int,FF.H00.int,FF.H00.int,FF.H00.int))
                add(arrayOf("#00003300",FF.H00.int,FF.H00.int,FF.H33.int,FF.H00.int))
                add(arrayOf("#00006600",FF.H00.int,FF.H00.int,FF.H66.int,FF.H00.int))
                add(arrayOf("#00009900",FF.H00.int,FF.H00.int,FF.H99.int,FF.H00.int))
                add(arrayOf("#0000CC00",FF.H00.int,FF.H00.int,FF.HCC.int,FF.H00.int))
                add(arrayOf("#0000FF00",FF.H00.int,FF.H00.int,FF.HFF.int,FF.H00.int))

                add(arrayOf("#00000000",FF.H00.int,FF.H00.int,FF.H00.int,FF.H00.int))
                add(arrayOf("#00000033",FF.H00.int,FF.H00.int,FF.H00.int,FF.H33.int))
                add(arrayOf("#00000066",FF.H00.int,FF.H00.int,FF.H00.int,FF.H66.int))
                add(arrayOf("#00000099",FF.H00.int,FF.H00.int,FF.H00.int,FF.H99.int))
                add(arrayOf("#000000CC",FF.H00.int,FF.H00.int,FF.H00.int,FF.HCC.int))
                add(arrayOf("#000000FF",FF.H00.int,FF.H00.int,FF.H00.int,FF.HFF.int))

            }.toList()
        }
    }

}