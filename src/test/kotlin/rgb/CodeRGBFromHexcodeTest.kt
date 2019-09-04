package rgb

import code.ColorCode
import org.hamcrest.CoreMatchers.*
import org.junit.Assert.assertThat

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized


@RunWith(Parameterized::class)
class CodeRGBFromHexcodeTest(data : Pair<String,CodeRGB>) {

    val expectedCode = data.second
    val formattedString = data.first

    @Before
    fun prepare(){
        println(formattedString)
    }


    @Test
    fun codeRGBFromFormattedTest(){

        val code = CodeRGB.from(formattedString)

        assertThat(code, equalTo(expectedCode))
    }

    @Test
    fun colorCodeFromFormattedTest(){
        val code = ColorCode.getRGB(formattedString)

        assertThat(code, equalTo(expectedCode))
    }


    companion object{
        @JvmStatic
        @Parameterized.Parameters
        fun data(): List<Pair<String,CodeRGB>>{

            return generateStringToCodePairList().flatMap {
                arrayListOf<Pair<String,CodeRGB>>().apply{
                    add(it.first.toUpperCase() to it.second)
                    add(it.first.toLowerCase() to it.second)
                    if(CodeRGBExt.canShorten(it.first)){
                        CodeRGBExt.toShorten(it.first)?.let { hex ->
                            add(hex to it.second)
                        }

                    }
                }
            }
        }



    }

}
