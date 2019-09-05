@file:Suppress("ClassName")

package cmyk

import code.ColorCode
import org.hamcrest.CoreMatchers
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import java.lang.IllegalArgumentException
/** CMYK 의 보색은 CMY가 1.0을 기준으로 보수를 취한 값이며. K는 유지 된다.  */
@RunWith(Parameterized::class)
class ComplementarityColorTest(
    private val cyan: Float,
    private val magenta: Float,
    private val yellow: Float,
    private val key: Float,
    private val expectedCyan: Float,
    private val expectedMagenta: Float,
    private val expectedYellow: Float,
    private val expectedKey: Float
) {

    @Test
    fun createFourFloatInCMYK(){

        val cmyk = CodeCMYK(cyan,magenta,yellow,key).getComplementaryColor()

        Assert.assertThat(cmyk.cyan, CoreMatchers.equalTo(expectedCyan))
        Assert.assertThat(cmyk.magenta,CoreMatchers.equalTo(expectedMagenta))
        Assert.assertThat(cmyk.yellow,CoreMatchers.equalTo(expectedYellow))
        Assert.assertThat(cmyk.key,CoreMatchers.equalTo(expectedKey))
    }

    companion object{
        @JvmStatic
        @Parameterized.Parameters
        fun data(): List<Array<Float>>{
            return generateWideCaseList().map {
                arrayOf(it[0],it[1],it[2],it[3],1.0f-it[0],1.0f-it[1],1.0f-it[2],it[3])
            }.toList()
        }
    }


}