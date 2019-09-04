package rgb

import org.hamcrest.CoreMatchers
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class CodeToFullCodeRGBExt(data : Triple<String,Boolean,String>) {
    val fullcode = data.first
    val canShorten = data.second
    val shortOrEmpty = data.third

    @Test
    fun toFullCodeTest(){

        // SRP abort.
        if(canShorten){
            Assert.assertThat(CodeRGBExt.toFullCode(shortOrEmpty),CoreMatchers.equalTo(fullcode))
        }else{
            Assert.assertThat(CodeRGBExt.toFullCode(shortOrEmpty),CoreMatchers.nullValue())
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
                Triple("#007FFF",false,""),
                Triple("#7F00FF",false,""),
                Triple("#FF007F",false,""),
                Triple("#FF7F00",false,""),
                Triple("#7FFF00",false,""),
                Triple("#00FF7F",false,""),
                Triple("#123456",false,"")
            )
        }
    }

}