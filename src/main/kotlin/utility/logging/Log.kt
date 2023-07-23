package utility.logging

import mu.KotlinLogging.logger

object Logger {
    private val logger = logger {}

    fun info(message: String): Unit = logger.info(message)

    fun warn(message: String): Unit = logger.warn(message)

    fun error(message: String, e: Exception): Unit = logger.error(message, e)

    fun <T> log(message: String, fn: () -> T): T = try {
        info("Received $message")
        fn().also { info("Processed $message successfully") }
    } catch (e: Exception) {
        error("Failed to process $message ${e.message}", e).let { throw e }
    }
}
