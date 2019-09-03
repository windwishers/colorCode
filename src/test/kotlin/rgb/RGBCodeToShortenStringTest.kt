package rgb

import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.*
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class RGBCodeToShortenStringTest(data : Triple<String,Boolean,String>) {
    val hexcode = data.first
    val isShorten = data.second
    val expected = data.third

    @Test
    fun toShortenStringTest(){
        // SRP 원칙이는 맞지 않는다고 보이지만 굳이 나눌 필요까지 못느껴서 넘김.
        val shortCode = RGBCode.toShorten(hexcode)


        if(isShorten){
            Assert.assertThat(shortCode, equalTo(expected))
        }else{
            Assert.assertThat(shortCode, `is`(nullValue()))
        }

    }


    companion object{
        @JvmStatic
        @Parameterized.Parameters
        fun data(): List<Triple<String,Boolean,String>>{
            return listOf(
                Triple("#FFFFFF",true,"#FFF"),
                Triple("#000000",true,"#000"),
                Triple("#FF0000",true,"#F00"),
                Triple("#00FF00",true,"#0F0"),
                Triple("#0000FF",true,"#00F"),
                Triple("#FFFF00",true,"#FF0"),
                Triple("#00FFFF",true,"#0FF"),
                Triple("#FF00FF",true,"#F0F"),
                Triple("#007FFF",false,"#007FFF"),
                Triple("#7F00FF",false,"#7F00FF"),
                Triple("#FF007F",false,"#FF007F"),
                Triple("#FF7F00",false,"#FF7F00"),
                Triple("#7FFF00",false,"#7FFF00"),
                Triple("#00FF7F",false,"#00FF7F"),
                Triple("#123456",false,"#123456")
            )
        }
    }
}