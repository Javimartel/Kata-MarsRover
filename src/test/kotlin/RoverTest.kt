import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import kotlin.test.assertFailsWith
class RoverTest {

    private val initialPosition = Position(0, 0)
    private val initialDirection = DIRECTION.NORTH

    private val curiosity: Rover = Rover(
        initialPosition,
        initialDirection
    )

    @Test
    fun `check if there is any command`() {
        val exception = assertFailsWith<NotCommandException>(
            block = { curiosity.followThisOrders(listOf()) }
        )
        assertEquals(exception.message, "Any command received")
    }
}