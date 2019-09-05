@file:Suppress("ClassName")

package cmyk

import code.ColorCode
import org.hamcrest.CoreMatchers
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import java.lang.IllegalArgumentException

@RunWith(Parameterized::class)
class CreateOutBoundaryTest(
    private val cyan: Float,
    private val magenta: Float,
    private val yellow: Float,
    private val key: Float
) {

    @Test(expected = IllegalArgumentException::class)
    fun createFourFloatInCMYK(){

        val cmyk = CodeCMYK(cyan,magenta,yellow,key)

        Assert.assertThat(cmyk.cyan, CoreMatchers.equalTo(cyan))
        Assert.assertThat(cmyk.magenta,CoreMatchers.equalTo(magenta))
        Assert.assertThat(cmyk.yellow,CoreMatchers.equalTo(yellow))
        Assert.assertThat(cmyk.key,CoreMatchers.equalTo(key))
    }

    @Test(expected = IllegalArgumentException::class)
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
            return mutableListOf<Array<Float>>().apply {
                add(arrayOf<Float>(-1f,-1f,-1f,-1f))
                add(arrayOf<Float>(0f,-1f,0f,-0f))
                add(arrayOf<Float>(-0f,-0f,-1f,-0f))
                add(arrayOf<Float>(-0f,-0f,-0f,-1f))
                add(arrayOf<Float>(-1f,-1f,-1f,-1f))
                add(arrayOf<Float>(0f,1.01f,0f,-0f))
                add(arrayOf<Float>(-0f,-0f,1.01f,-0f))
                add(arrayOf<Float>(-0f,-0f,-0f,1.01f))
                add(arrayOf<Float>(1.01f,1.01f,1.01f,1.01f))

                val li = listOf(Float.MAX_VALUE * -1 ,-0.02f,-0.5f,-3f,-6f,1.02f,1.5f,3f,6f,10f,Float.MAX_VALUE)

                for (meter in li) {
                    add(arrayOf<Float>(meter,0f,0f,0f))
                    add(arrayOf<Float>(0f,meter,0f,0f))
                    add(arrayOf<Float>(0f,0f,meter,0f))
                    add(arrayOf<Float>(0f,0f,0f,meter))
                }

            }.toList()
        }
    }


}