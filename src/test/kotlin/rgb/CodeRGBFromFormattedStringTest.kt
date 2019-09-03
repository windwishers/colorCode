package rgb

import code.ColorCode
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.*
import org.junit.Assert
import org.junit.Assert.assertThat
import org.junit.Test
import org.junit.runners.Parameterized


//TODO create from #RGB #RRGGBB 로 부터 잘 생성 되는지 확인 테스트.
class CodeRGBFromFormattedStringTest(val formattedString : String,val expectedCode : CodeRGB) {

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
                return arrayListOf<Pair<String,CodeRGB>>().apply{
                    add(it.first.toUpperCase() to it.second)
                    add(it.first.toLowerCase() to it.second)
                    if(RGBCode.canShorten(it.first)){
                        RGBCode.toShorten(it.first)?.let { hex ->
                            add(hex to it.second)
                        }

                    }
                }
            }
        }



    }

}
