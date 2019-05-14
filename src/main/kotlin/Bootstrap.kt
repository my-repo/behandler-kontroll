import io.ktor.application.Application
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

data class ApplicationState(
    var running: Boolean = true,
    var initialized: Boolean = false
)

fun doReadynessCheck(): Boolean {
    return true
}

fun main(){
    val env = Environment()
    val applicationState = ApplicationState()
    val applicationServer = embeddedServer(Netty, env.applicationPort) {
        initRouting(applicationState)
    }.start(wait = false)

    println("Hello world")
}

fun Application.initRouting(applicationState: ApplicationState) {
    routing {
        registerNaisApi(readynessCheck = ::doReadynessCheck, livenessCheck = { applicationState.running })
    }
}