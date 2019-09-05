@file:Suppress("ClassName")

package cmyk

import code.ColorCode
import org.hamcrest.CoreMatchers
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class CreateInBoundaryTest(
    val cyan: Float,
    val magenta: Float,
    val yellow: Float,
    val key: Float
) {

    @Test
    fun createFourFloatInCMYK(){

        val cmyk = CodeCMYK(cyan,magenta,yellow,key)

        Assert.assertThat(cmyk.cyan, CoreMatchers.equalTo(cyan))
        Assert.assertThat(cmyk.magenta,CoreMatchers.equalTo(magenta))
        Assert.assertThat(cmyk.yellow,CoreMatchers.equalTo(yellow))
        Assert.assertThat(cmyk.key,CoreMatchers.equalTo(key))
    }

    @Test
    fun createFourFloatInColorCode(){
        val cmyk = ColorCode.getCMYK(cyan,magenta,yellow,key)

        Assert.assertThat(cmyk.cyan,CoreMatchers.equalTo(cyan))
        Assert.assertThat(cmyk.magenta,CoreMatchers.equalTo(magenta))
        Assert.assertThat(cmyk.yellow,CoreMatchers.equalTo(yellow))
        Assert.assertThat(cmyk.key,CoreMatchers.equalTo(key))
    }



    companion object{
        @JvmStatic
        @Parameterized.Parameters
        fun data(): List<Array<Float>>{
            return generateWideCaseList()
        }
    }


}