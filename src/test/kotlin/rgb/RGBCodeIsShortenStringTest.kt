package rgb

import org.hamcrest.CoreMatchers
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class RGBCodeIsShortenStringTest(value :Pair<String,Boolean>) {
    private val hexString = value.first
    private val isShorten = value.second

    @Test
    fun isShortenStringTest(){

        Assert.assertThat(RGBCode.isShorten(hexString), CoreMatchers.equalTo(isShorten))
    }


    companion object{
        @JvmStatic
        @Parameterized.Parameters
        fun data(): List<Pair<String,Boolean>>{
            return listOf(
                "#FFF" to true,
                "#000" to true,
                "#F00" to true,
                "#0F0" to true,
                "#00F" to true,
                "#FF0" to true,
                "#0FF" to true,
                "#F0F" to true,
                "F0F" to false,
                "#007FF" to false,
                "#0F" to false,
                "#" to false,
                "" to false,
                "#007FFF" to false,
                "#7F00FF" to false,
                "#FF007F" to false,
                "#FF7F00" to false,
                "#7FFF00" to false,
                "#00FF7F" to false,
                "#123456" to false
            )
        }
    }
}