class Position(private val x: Int, private val y: Int) {
    private val MIN: Int = 0
    init {
        val isNegativeInPosX = this.x < this.MIN
        val isNegativeInPosY = this.y < this.MIN
        if (isNegativeInPosX || isNegativeInPosY) {
            throw PositionOutOfBoundsException("Negative position not allowed")
        }
    }
}
