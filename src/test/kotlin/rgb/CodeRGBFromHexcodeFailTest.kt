package rgb

import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.assertThat
import org.junit.Ignore
import org.junit.Test

class CodeRGBFromHexcodeFailTest {


    @Test(expected = IllegalArgumentException::class)
    fun inEmptyStringOutIllegalArgumentExceptionTest(){
        val hexcode = ""
        CodeRGB.from(hexcode)
    }


    @Test(expected = IllegalArgumentException::class)
    fun in2lenStringOutIllegalArgumentExceptionTest(){
        val hexcode = "#A"
        CodeRGB.from(hexcode)
    }
    @Test(expected = IllegalArgumentException::class)
    fun in3lenStringOutIllegalArgumentExceptionTest(){
        val hexcode = "#AA"
        CodeRGB.from(hexcode)
    }

    @Test
    @Ignore   // #AAA 는 단축 형식이라 실패하지 않음.
    fun in4lenStringOutIllegalArgumentExceptionTest(){
        val hexcode = "#AAA"
        val code = CodeRGB.from(hexcode)

        assertThat(code.hexcode, equalTo("#AAAAAA"))
    }

    @Test(expected = IllegalArgumentException::class)
    fun in5lenStringOutIllegalArgumentExceptionTest(){
        val hexcode = "#AAAA"
        CodeRGB.from(hexcode)
    }
    @Test(expected = IllegalArgumentException::class)
    fun in6lenStringOutIllegalArgumentExceptionTest(){
        val hexcode = "#AAAAA"
        CodeRGB.from(hexcode)
    }

    @Test
    @Ignore   // #RRGGBB 라서 실패하지 않음.
    fun in7lenStringOutIllegalArgumentExceptionTest(){
        val hexcode = "#AAAAAA"
        val code = CodeRGB.from(hexcode)

        assertThat(code.hexcode, equalTo(hexcode))
    }

    @Test(expected = IllegalArgumentException::class)
    fun in8lenStringOutIllegalArgumentExceptionTest(){
        val hexcode = "#AAAAAAAA"
        CodeRGB.from(hexcode)
    }


    @Test(expected = IllegalArgumentException::class)
    fun wrongShortenCodeTest(){
        val hexcode = "#GGG"
        CodeRGB.from(hexcode)
    }



}
