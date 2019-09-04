package rgb

import org.hamcrest.CoreMatchers
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

/**
 * val (red,green,blue) = codeRGB 의 형식으로 사용하는 코드 작성.
 * data 클래스 라서 구조분해를 자동으로 지원 함.
 */
@RunWith(Parameterized::class)
class CodeRGBDestructuringDeclarationsTest(val red : Int, val green: Int, val blue:Int){

    @Test
    fun destructuringDeclarationsTest(){

        val(actualRed,actualGreen,actualBlue) = CodeRGB(red,green, blue)

        Assert.assertThat(actualRed,CoreMatchers.equalTo(red))
        Assert.assertThat(actualGreen,CoreMatchers.equalTo(green))
        Assert.assertThat(actualBlue,CoreMatchers.equalTo(blue))

    }


    companion object{
        @JvmStatic
        @Parameterized.Parameters
        fun data(): List<Array<Int>>{

            return generateWideCaseList()
        }
    }

}