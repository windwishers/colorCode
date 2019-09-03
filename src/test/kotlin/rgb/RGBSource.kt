package rgb

fun generateWideCaseList(): List<Array<Int>> {
    return mutableListOf<Array<Int>>().apply {
        for (red in 0..255) {
            add(arrayOf(red, 0, 0))
        }
        for (green in 0..255) {
            add(arrayOf(0, green, 0))
        }
        for (blue in 0..255) {
            add(arrayOf(0, 0, blue))
        }

        val range = listOf(0, 23, 50, 77, 100, 103, 150, 200, 222, 255)

        for (red in range) {
            for (green in range) {
                for (blue in range) {
                    add(arrayOf(red, green, blue))
                }
            }
        }

    }.toList()
}