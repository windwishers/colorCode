package rgb

import org.hamcrest.CoreMatchers
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class RGBCodeCanShortenStringTest(value :Pair<String,Boolean>) {
    private val hexString = value.first
    private val isShorten = value.second

    @Test
    fun canShortenStringTest(){

        Assert.assertThat(RGBCode.canShorten(hexString),CoreMatchers.equalTo(isShorten))
    }

    companion object{
        @JvmStatic
        @Parameterized.Parameters
        fun data(): List<Pair<String,Boolean>>{
            return listOf(
                "#FFFFFF" to true,
                "#000000" to true,
                "#FF0000" to true,
                "#00FF00" to true,
                "#0000FF" to true,
                "#FFFF00" to true,
                "#00FFFF" to true,
                "#FF00FF" to true,
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