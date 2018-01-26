package io.vertx.lang.scala

import io.vertx.core.Handler

class HandlerWrapper[E](val f: E => Unit) extends Handler[E]{
  override def handle(event: E): Unit = f(event)
}
