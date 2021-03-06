//MODULE: vertx-rabbitmq
//MODULE: io.vertx.rabbitmq
//MODULE: io.vertx
//MODULE: io.vertx.scala.rabbitmq
/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package io.vertx.scala
import scala.collection.JavaConverters._
import scala.compat.java8.FunctionConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import scala.concurrent.Promise

package object rabbitmq{


import io.vertx.rabbitmq.{RabbitMQOptions => JRabbitMQOptions}
import io.vertx.rabbitmq.RabbitMQOptions
import io.vertx.core.Vertx
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.core.{Vertx => JVertx}

  /**
   */
  implicit class RabbitMQClientScala(val asJava: io.vertx.rabbitmq.RabbitMQClient) extends AnyVal {

    /**
     * Like [[basicAck]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def basicAckFuture(deliveryTag: java.lang.Long, multiple: java.lang.Boolean): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = Promise[io.vertx.core.json.JsonObject]()
      asJava.basicAck(deliveryTag, multiple, {a:AsyncResult[io.vertx.core.json.JsonObject] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[basicNack]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def basicNackFuture(deliveryTag: java.lang.Long, multiple: java.lang.Boolean, requeue: java.lang.Boolean): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = Promise[io.vertx.core.json.JsonObject]()
      asJava.basicNack(deliveryTag, multiple, requeue, {a:AsyncResult[io.vertx.core.json.JsonObject] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[basicGet]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def basicGetFuture(queue: String, autoAck: java.lang.Boolean): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = Promise[io.vertx.core.json.JsonObject]()
      asJava.basicGet(queue, autoAck, {a:AsyncResult[io.vertx.core.json.JsonObject] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[basicConsume]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def basicConsumeFuture(queue: String, address: String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.basicConsume(queue, address, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[basicConsume]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def basicConsumeFuture(queue: String, address: String, autoAck: java.lang.Boolean): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.basicConsume(queue, address, autoAck, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[basicPublish]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def basicPublishFuture(exchange: String, routingKey: String, message: io.vertx.core.json.JsonObject): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.basicPublish(exchange, routingKey, message, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[confirmSelect]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def confirmSelectFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.confirmSelect({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[waitForConfirms]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def waitForConfirmsFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.waitForConfirms({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[waitForConfirms]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def waitForConfirmsFuture(timeout: java.lang.Long): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.waitForConfirms(timeout, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[basicQos]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def basicQosFuture(prefetchCount: java.lang.Integer): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.basicQos(prefetchCount, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[exchangeDeclare]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def exchangeDeclareFuture(exchange: String, `type`: String, durable: java.lang.Boolean, autoDelete: java.lang.Boolean): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.exchangeDeclare(exchange, `type`, durable, autoDelete, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[exchangeDeclare]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def exchangeDeclareFuture(exchange: String, `type`: String, durable: java.lang.Boolean, autoDelete: java.lang.Boolean, config: io.vertx.core.json.JsonObject): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.exchangeDeclare(exchange, `type`, durable, autoDelete, config, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[exchangeDelete]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def exchangeDeleteFuture(exchange: String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.exchangeDelete(exchange, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[exchangeBind]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def exchangeBindFuture(destination: String, source: String, routingKey: String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.exchangeBind(destination, source, routingKey, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[exchangeUnbind]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def exchangeUnbindFuture(destination: String, source: String, routingKey: String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.exchangeUnbind(destination, source, routingKey, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[queueDeclareAuto]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def queueDeclareAutoFuture(): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = Promise[io.vertx.core.json.JsonObject]()
      asJava.queueDeclareAuto({a:AsyncResult[io.vertx.core.json.JsonObject] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[queueDeclare]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def queueDeclareFuture(queue: String, durable: java.lang.Boolean, exclusive: java.lang.Boolean, autoDelete: java.lang.Boolean): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = Promise[io.vertx.core.json.JsonObject]()
      asJava.queueDeclare(queue, durable, exclusive, autoDelete, {a:AsyncResult[io.vertx.core.json.JsonObject] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[queueDeclare]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def queueDeclareFuture(queue: String, durable: java.lang.Boolean, exclusive: java.lang.Boolean, autoDelete: java.lang.Boolean, config: io.vertx.core.json.JsonObject): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = Promise[io.vertx.core.json.JsonObject]()
      asJava.queueDeclare(queue, durable, exclusive, autoDelete, config, {a:AsyncResult[io.vertx.core.json.JsonObject] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[queueDelete]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def queueDeleteFuture(queue: String): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = Promise[io.vertx.core.json.JsonObject]()
      asJava.queueDelete(queue, {a:AsyncResult[io.vertx.core.json.JsonObject] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[queueDeleteIf]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def queueDeleteIfFuture(queue: String, ifUnused: java.lang.Boolean, ifEmpty: java.lang.Boolean): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = Promise[io.vertx.core.json.JsonObject]()
      asJava.queueDeleteIf(queue, ifUnused, ifEmpty, {a:AsyncResult[io.vertx.core.json.JsonObject] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[queueBind]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def queueBindFuture(queue: String, exchange: String, routingKey: String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.queueBind(queue, exchange, routingKey, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[messageCount]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def messageCountFuture(queue: String): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = Promise[io.vertx.core.json.JsonObject]()
      asJava.messageCount(queue, {a:AsyncResult[io.vertx.core.json.JsonObject] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[start]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def startFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.start({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[stop]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def stopFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.stop({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }

  type RabbitMQOptions = io.vertx.rabbitmq.RabbitMQOptions

  object RabbitMQOptions {
    def apply() = new RabbitMQOptions()
    def apply(json: JsonObject) = new RabbitMQOptions(json)
  }


}
