package cmyk

/** 가용 범위를 최대한 넓게 포함 하도록 케이스 리스트를 뽑는 함수.  100 * 4 + 6 * 6 * 6 * 6 해서  총 3400개 의 케이스가 나온다. */
fun generateWideCaseList(): List<Array<Float>> {
    return mutableListOf<Array<Float>>().apply {
        for (cyan in 0..100) {
            add(arrayOf(cyan/100f, 0f, 0f,0f))
        }
        for (magenta in 0..100) {
            add(arrayOf(0f, magenta/100f, 0f,0f))
        }
        for (yellow in 0..100) {
            add(arrayOf(0f, 0f, yellow/100f,0f))
        }
        for (key in 0..100) {
            add(arrayOf(0f, 0f,0f, key/100f))
        }

        val range = listOf(0f, 0.2f, 0.3f, 0.5f, 0.8f, 1.0f)

        for (cyan in range) {
            for (magenta in range) {
                for (yellow in range) {
                    for (key in range) {
                        add(arrayOf(cyan, magenta, yellow,key))
                    }
                }
            }
        }

    }.toList()
}