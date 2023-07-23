package utility.logging

import org.junit.jupiter.api.assertThrows
import utility.logging.Logger.info
import utility.logging.Logger.log
import utility.logging.Logger.warn
import kotlin.test.Test
import kotlin.test.assertEquals

class LoggerTest {

    private val message = "API request"

    @Test
    fun `info on valid input should successfully output message`() {
        assertEquals(Unit, info(message))
    }

    @Test
    fun `warn on valid input should successfully output message`() {
        assertEquals(Unit, warn(message))
    }

    @Test
    fun `error on valid input should successfully output message`() {
        assertEquals(Unit, Logger.error(message, RuntimeException()))
    }

    @Test
    fun `log on valid input should successfully output message`() {
        assertEquals(Unit, log("store to DB") {})
    }

    @Test
    fun `log on invalid input should throw exception`() {
        assertThrows<RuntimeException> { log("store to DB") { throw RuntimeException() } }
    }
}
