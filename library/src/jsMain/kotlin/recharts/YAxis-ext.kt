package recharts


object YAxisOrientationFactory {
    fun ofValue(value: String): YAxisOrientation {
        return when (value) {
            YAxisOrientation.right.toString() -> YAxisOrientation.right
            else -> YAxisOrientation.left
        }
    }
}
