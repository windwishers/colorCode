package rgb

import org.hamcrest.CoreMatchers.*
import org.junit.Assert
import org.junit.Test


class CodeRGBEqualTest {
    @Test
    fun equalBlackTest(){
        val code = CodeRGB(0,0,0)
        val codeAlt = CodeRGB(0,0,0)

        Assert.assertThat(code, equalTo(codeAlt))
    }

    @Test
    fun equalWhiteTest(){
        val code = CodeRGB(255,255,255)
        val codeAlt = CodeRGB(255,255,255)

        Assert.assertThat(code, equalTo(codeAlt))
    }

    @Test
    fun equalFloatWithIntTest(){
        val floatWhite = CodeRGB(255F,255F,255F)
        val intWhite = CodeRGB(255,255,255)

        Assert.assertThat(floatWhite, equalTo(intWhite))
    }

    @Test
    fun noEqualWhiteWithBlackTest(){
        val white = CodeRGB(255,255,255)
        val black = CodeRGB(0,0,0)

        Assert.assertThat(white, not(equalTo(black)))
    }
}