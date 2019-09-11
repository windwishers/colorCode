package argb

import org.junit.Test


class CreateFromHexFailTest {

    @Test(expected = IllegalArgumentException::class)
    fun createFromEmptyTest(){

        val hexcode = ""

        CodeARGB.from(hexcode)

    }

    @Test(expected = IllegalArgumentException::class)
    fun createFromNotStartsWithSharpToExceptionTest(){

        val hexcode = "$00000000"

        CodeARGB.from(hexcode)
    }

    @Test(expected = IllegalArgumentException::class)
    fun createFromNotStartsWithSharpToExceptionTest2(){

        val hexcode = "100000000"

        CodeARGB.from(hexcode)
    }


    @Test(expected = IllegalArgumentException::class)
    fun createFrom7LengthExceptionTest1(){

        val hexcode = "#000000"

        CodeARGB.from(hexcode)
    }
    @Test(expected = IllegalArgumentException::class)
    fun createFrom8LengthExceptionTest2(){

        val hexcode = "#0000000"

        CodeARGB.from(hexcode)
    }
    @Test(expected = IllegalArgumentException::class)
    fun createFrom10LengthExceptionTest3(){

        val hexcode = "#000000000"

        CodeARGB.from(hexcode)
    }



    @Test(expected = IllegalArgumentException::class)
    fun createFromOutOfHEXTest(){

        val hexcode = "#GGGGGGG"

        CodeARGB.from(hexcode)
    }

    @Test(expected = IllegalArgumentException::class)
    fun createFromAlphaOutOfHEXTest(){

        val hexcode = "#GG000000"

        CodeARGB.from(hexcode)
    }

    @Test(expected = IllegalArgumentException::class)
    fun createFromRedOutOfHEXTest(){

        val hexcode = "#00GG0000"

        CodeARGB.from(hexcode)
    }

    @Test(expected = IllegalArgumentException::class)
    fun createFromGreenOutOfHEXTest(){

        val hexcode = "#0000GG00"

        CodeARGB.from(hexcode)
    }

    @Test(expected = IllegalArgumentException::class)
    fun createFromBlueOutOfHEXTest(){

        val hexcode = "#000000GG"

        CodeARGB.from(hexcode)
    }

}