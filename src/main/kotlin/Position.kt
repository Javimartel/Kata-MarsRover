class Position(private var x: Int, private var y: Int) {
    private val MIN: Int = 0
    init {
        val isNegativeInPosX = this.x < this.MIN
        val isNegativeInPosY = this.y < this.MIN
        if (isNegativeInPosX || isNegativeInPosY) {
            throw PositionOutOfBoundsException("Negative position not allowed")
        }
    }

    fun moveVertically(position: Int) {
        this.x += position
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Position

        if (x != other.x) return false
        return y == other.y
    }

    override fun hashCode(): Int {
        var result = x
        result = 31 * result + y
        return result
    }

    override fun toString(): String {
        return "Position(x=$x, y=$y)"
    }
}
