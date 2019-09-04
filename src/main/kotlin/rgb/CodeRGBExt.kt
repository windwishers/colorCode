package rgb

class CodeRGBExt {

    companion object{

        /** #FFF 형태의 단축 헥스코드인지 여부를 반환 합니다.   */
        fun isShorten(hexcode : String) : Boolean = hexcode.startsWith('#') && hexcode.length == 4

        /** #FFF 형태로 단축 할수 있는 형태의 코드 이면 true 를 아니면 false  를 리턴 합니다.  */
        fun canShorten(code : String) : Boolean{
            return when{
                !code.startsWith("#") -> false
                code.length != 7 -> false
                code[1] != code[2] -> false
                code[3] != code[4] -> false
                code[5] != code[6] -> false
                else -> true
            }
        }

        /** #FFFFFF 를 #FFF 로 바꿔 반환 합니다. 변환 이 불가능한 경우 null 을 반환합니다. (예 #7F7F7F)   */
        fun toShorten(code : String) : String?{
            if(!canShorten(code)) return null
            return "#"+code[1]+code[3]+code[5]
        }

        /** #FFF 를 #FFFFFF 로 바꿔 반환 합니다. 변환 이 불가능한 경우 null 을 반환합니다. (예 #7F7F7F)    */
        fun toFullCode(code : String) : String? {
            return if(isShorten(code)) "#"+code[1]+code[1]+code[2]+code[2]+code[3]+code[3] else null
        }

        /** red green blue 를 받아서 hexcode 로 바꿔주는 겁니다.  */
        fun generateHexcode(red: Int, green: Int, blue: Int): String {
            return ("#${red.toString(16).padStart(2, '0')}" +
                    green.toString(16).padStart(2, '0') +
                    blue.toString(16).padStart(2, '0')).toUpperCase()
        }
    }
}