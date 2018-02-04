package io.vertx.lang.scala

import io.reactivex.Flowable.fromPublisher
import io.vertx.lang.scala.reactivestreams.FuturePublisher

import scala.concurrent.Future

package object rxjava {
  implicit class ReactiveFuture[O](val future: Future[O])(implicit ec: VertxExecutionContext) {
    def flowable() = fromPublisher(new FuturePublisher(future))
  }
}
