@file:Suppress("TestFunctionName")

package colorCode

import code.ColorCode
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.CoreMatchers.not
import org.junit.Assert.assertThat
import org.junit.Test

class ColorCodeTest{

    @Test
    fun `argument is model`(){
        val arg = "String"

        val color = ColorCode(arg)

        assertThat(color.model, equalTo(arg))
    }

    @Test
    fun sameModelEqualTrue(){
        val model = ""

        val code1 = ColorCode(model)
        val code2 = ColorCode(model)

        assertThat(code1, equalTo(code2))

    }

    @Test
    fun notSameModelEqualFalse(){
        val model1 = ""
        val model2 = "RGBA"

        val code1 = ColorCode(model1)
        val code2 = ColorCode(model2)

        assertThat(code1, not(equalTo(code2)))

    }



}