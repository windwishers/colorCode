package code
/**
 * ColorCode 의 공용 상위 클래스. 생성자로 모델 종류를 스트링으로 받는다. 이넘으로 받을까 고민해봤지만 귀찮아서 접음.
 */
abstract class ColorCode<T>(val model: String) {

    override fun hashCode(): Int {
        return model.hashCode()
    }

    override fun equals(other: Any?) =
        if (other is ColorCode<*>) {  //TODO 아마 이렇케 되면 이퀄이 안맞을 것.
            model == other.model
        }else {
            super.equals(other)
        }

    abstract fun getComplementaryColor() : T

    companion object{
    }
}