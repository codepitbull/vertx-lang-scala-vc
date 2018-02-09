//MODULE: vertx-tcp-eventbus-bridge
//MODULE: io.vertx.ext.eventbus.bridge.tcp
//MODULE: io.vertx.ext
//MODULE: io.vertx.ext.scala.eventbus.bridge.tcp
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

package io.vertx.ext.scala.eventbus.bridge
import scala.collection.JavaConverters._
import scala.compat.java8.FunctionConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import scala.concurrent.Promise

package object tcp{


import io.vertx.core.{Future => JFuture}
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.core.Future

  /**
   * Represents an event that occurs on the event bus bridge.
   * 
   * Please consult the documentation for a full explanation.
   */
  implicit class BridgeEventScala(val asJava: io.vertx.ext.eventbus.bridge.tcp.BridgeEvent) extends AnyVal {

    def setFuture(): scala.concurrent.Future[java.lang.Boolean] = {
      val promise = Promise[java.lang.Boolean]()
      asJava.setHandler({a:AsyncResult[java.lang.Boolean] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }

import io.vertx.ext.eventbus.bridge.tcp.{TcpEventBusBridge => JTcpEventBusBridge}
import io.vertx.core.net.NetServerOptions
import io.vertx.ext.eventbus.bridge.tcp.BridgeEvent
import io.vertx.ext.eventbus.bridge.tcp.{BridgeEvent => JBridgeEvent}
import io.vertx.core.Vertx
import io.vertx.ext.bridge.BridgeOptions
import io.vertx.ext.bridge.{BridgeOptions => JBridgeOptions}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge
import io.vertx.core.net.{NetServerOptions => JNetServerOptions}
import io.vertx.core.{Vertx => JVertx}

  /**
   * TCP EventBus bridge for Vert.x
   */
  implicit class TcpEventBusBridgeScala(val asJava: io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge) extends AnyVal {

    /**
     * Like [[listen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def listenFuture(): scala.concurrent.Future[io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge] = {
      val promise = Promise[io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge]()
      asJava.listen({a:AsyncResult[io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[listen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def listenFuture(port: java.lang.Integer, address: String): scala.concurrent.Future[io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge] = {
      val promise = Promise[io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge]()
      asJava.listen(port, address, {a:AsyncResult[io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[listen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def listenFuture(port: java.lang.Integer): scala.concurrent.Future[io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge] = {
      val promise = Promise[io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge]()
      asJava.listen(port, {a:AsyncResult[io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[close]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def closeFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.close({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }

}
