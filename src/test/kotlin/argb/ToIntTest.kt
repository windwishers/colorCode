package argb

import junitparams.FileParameters
import junitparams.JUnitParamsRunner
import org.hamcrest.CoreMatchers
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(JUnitParamsRunner::class)
class ToIntTest{

    @Test
    @FileParameters("testData/codeARGB2Int.csv")
    fun toIntTest(alpha : Int,red : Int,green : Int,blue : Int,expectedInt : Int){

        val code = CodeARGB(alpha, red, green, blue)

        Assert.assertThat(code.toInt(),CoreMatchers.equalTo(expectedInt))

    }
}
