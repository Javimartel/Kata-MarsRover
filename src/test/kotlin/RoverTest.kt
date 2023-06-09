import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import kotlin.test.assertFailsWith
class RoverTest {

    private val initialPosition = Position(1, 1)
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

    @Test
    fun `check if curiosity moves correctly`() {
        val commands = listOf(MOVE.FORWARD)
        curiosity.followThisOrders(commands)

        assertEquals(Position(0,1), curiosity.getCurrentPosition())
    }

    @Test
    fun `check if curiosity turns correctly`() {
        val commands = listOf(TURN.LEFT)
        curiosity.followThisOrders(commands)

        assertEquals(DIRECTION.WEST, curiosity.getCurrentDirection())
    }

    @Test
    fun `check if curiosity moves and turns correctly`() {
        val commands = listOf(MOVE.BACKWARD, TURN.RIGHT)
        curiosity.followThisOrders(commands)

        assertEquals(Position(2,1), curiosity.getCurrentPosition())
        assertEquals(DIRECTION.EAST, curiosity.getCurrentDirection())
    }

    @Test
    fun `check if curiosity moves, turns and moves correctly`() {
        val commands = listOf(MOVE.FORWARD, TURN.LEFT, MOVE.FORWARD)
        curiosity.followThisOrders(commands)

        assertEquals(Position(0,0), curiosity.getCurrentPosition())
        assertEquals(DIRECTION.WEST, curiosity.getCurrentDirection())
    }
}