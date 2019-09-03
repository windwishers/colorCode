package rgb

import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

/** 보색 테스트 RGB의 보색은 255에서 해당 값들을 뺸 값을 가집니다.  */
@RunWith(Parameterized::class)
class CodeRGBComplementarityColorInverseTest(val red : Int, val green: Int, val blue:Int){


    @Test
    fun complementarityColorInverseTest() {

        val code = CodeRGB(red, green, blue)
        val complementColor = code.getComplementaryColor()
        val complementColorRepeat = complementColor.getComplementaryColor()

        assertThat(255 - code.red , equalTo(complementColor.red))
        assertThat(255 - code.green , equalTo(complementColor.green))
        assertThat(255 - code.blue , equalTo(complementColor.blue))


        assertThat(complementColorRepeat.red, equalTo(code.red))
        assertThat(complementColorRepeat.green, equalTo(code.green))
        assertThat(complementColorRepeat.blue, equalTo(code.blue))

    }


    companion object{
        @JvmStatic
        @Parameterized.Parameters
        fun data(): List<Array<Int>>{

            return generateWideCaseList()
        }
    }


}