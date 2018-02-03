package io.vertx.lang.scala

import io.vertx.core.WorkerExecutor

import scala.concurrent.ExecutionContext
import scala.util.{Failure, Success}

import io.vertx.scala.core._

/**
  * An [[ExecutionContext]] implementation for [[WorkerExecutor]]s
  *
  * @author <a href="mailto:jochen.mader@codecentric.de">Jochen Mader</a>
  */
class WorkerExecutorExecutionContext(val ctx: WorkerExecutor) extends ExecutionContext {
  private val Log = ScalaLogger.getLogger(classOf[VertxExecutionContext].getName)

  override def execute(runnable: Runnable): Unit = {
    ctx.executeBlockingFuture[Unit](() => runnable.run()).onComplete{
      case Success(_) => ()
      case Failure(t) => reportFailure(t)
    }(this)
  }

  override def reportFailure(cause: Throwable): Unit = {
    Log.error("Failed executing on contet", cause)
  }
}

object WorkerExecutorExecutionContext {
  def apply(ctx: WorkerExecutor): WorkerExecutorExecutionContext = new WorkerExecutorExecutionContext(ctx)
}
