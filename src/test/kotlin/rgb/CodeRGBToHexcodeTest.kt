package rgb

import org.hamcrest.CoreMatchers.*
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class CodeRGBToHexcodeTest(data : Pair<CodeRGB,String>) {
    private val code = data.first
    private val expected = data.second

    @Test
    fun toHexcodeTest(){

        val hexcode = code.hexcode

        assertThat(hexcode, equalTo(expected))

    }

    @Test
    fun rGBCodeGenHexcodeTest(){

        val hexcode = CodeRGBExt.generateHexcode(code.red,code.green,code.blue)

        assertThat(hexcode, equalTo(expected))

    }


    companion object{
        @JvmStatic
        @Parameterized.Parameters
        fun data(): List<Pair<CodeRGB,String>>{
            return listOf(
                CodeRGB(0,0,0) to "#000000",
                CodeRGB(3,3,3) to "#030303",
                CodeRGB(6,6,6) to "#060606",
                CodeRGB(10,10,10) to "#0A0A0A",
                CodeRGB(51,51,51) to "#333333",
                CodeRGB(102,102,102) to "#666666",
                CodeRGB(153,153,153) to "#999999",
                CodeRGB(204,204,204) to "#CCCCCC",
                CodeRGB(255,255,255) to "#FFFFFF",
                CodeRGB(255,0,0) to "#FF0000",
                CodeRGB(0,255,0) to "#00FF00",
                CodeRGB(0,0,255) to "#0000FF",
                CodeRGB(255,255,0) to "#FFFF00",
                CodeRGB(0,255,255) to "#00FFFF",
                CodeRGB(255,0,255) to "#FF00FF",
                CodeRGB(0,127,255) to "#007FFF",
                CodeRGB(127,0,255) to "#7F00FF",
                CodeRGB(255,0,127) to "#FF007F",
                CodeRGB(255,127,0) to "#FF7F00",
                CodeRGB(127,255,0) to "#7FFF00",
                CodeRGB(0,255,127) to "#00FF7F"
            )
        }
    }
}