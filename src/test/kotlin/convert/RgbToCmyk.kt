package convert

import cmyk.CodeCMYK
import org.hamcrest.CoreMatchers
import org.junit.Assert
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import rgb.CodeRGB

@RunWith(Parameterized::class)
class RgbToCmyk(
    val cyan: Float,
    val magenta: Float,
    val yellow: Float,
    val key: Float,
    val red: Int,
    val green: Int,
    val blue: Int
) {

    @Test
    fun cmykToRGBTest(){
        val rgb = CodeRGB(red,green,blue).toCMYK()

        rgb?.let {
            Assert.assertThat(it, CoreMatchers.equalTo(CodeCMYK(cyan,magenta,yellow,key)))
        }

    }

    @Test
    fun cmykToRGBInverseTest(){
        val rgb = CodeRGB(red,green,blue)
        val rgbAlt = rgb.toCMYK()?.toRGB()

        rgbAlt?.let {
            Assert.assertThat(rgbAlt, CoreMatchers.equalTo(rgb))
        }
    }

    companion object{
        @Suppress("RemoveExplicitTypeArguments")  // Number 가 생략되면 에러남.
        @JvmStatic
        @Parameterized.Parameters
        fun data(): List<Array<Number>>{
            // total 2099 case
            return generateTestCase()
        }
    }

}