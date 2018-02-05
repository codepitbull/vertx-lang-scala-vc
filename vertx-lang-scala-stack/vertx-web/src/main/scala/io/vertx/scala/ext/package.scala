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

package io.vertx.scala.ext
import scala.collection.JavaConverters._
import scala.compat.java8.FunctionConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import scala.reflect.runtime.universe._
import scala.concurrent.Promise

package object web{


import io.vertx.lang.scala.AsyncResultWrapper
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
  implicit class BridgeEventScala(val asJava: io.vertx.ext.web.handler.sockjs.BridgeEvent) extends AnyVal {

    def setFuture(): scala.concurrent.Future[java.lang.Boolean] = {
      val promise = Promise[java.lang.Boolean]()
      asJava.setHandler({a:AsyncResult[java.lang.Boolean] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }

  type BridgeOptions = io.vertx.ext.web.handler.sockjs.BridgeOptions

  object BridgeOptions {
    def apply() = new BridgeOptions()
    def apply(json: JsonObject) = new BridgeOptions(json)
  }


  type Http2PushMapping = io.vertx.ext.web.Http2PushMapping

  object Http2PushMapping {
    def apply() = new Http2PushMapping()
    def apply(json: JsonObject) = new Http2PushMapping(json)
  }


  type PermittedOptions = io.vertx.ext.web.handler.sockjs.PermittedOptions

  object PermittedOptions {
    def apply() = new PermittedOptions()
    def apply(json: JsonObject) = new PermittedOptions(json)
  }


import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.ext.web.Session
import io.vertx.ext.web.{Session => JSession}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler

  /**
   * A session store is used to store sessions for an Vert.x-Web web app
   */
  implicit class SessionStoreScala(val asJava: io.vertx.ext.web.sstore.SessionStore) extends AnyVal {

    /**
     * Like [[get]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getFuture(id: String): scala.concurrent.Future[io.vertx.ext.web.Session] = {
      val promise = Promise[io.vertx.ext.web.Session]()
      asJava.get(id, {a:AsyncResult[io.vertx.ext.web.Session] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[delete]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def deleteFuture(id: String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.delete(id, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[put]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def putFuture(session: io.vertx.ext.web.Session): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.put(session, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clear]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clearFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.clear({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[size]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sizeFuture(): scala.concurrent.Future[java.lang.Integer] = {
      val promise = Promise[java.lang.Integer]()
      asJava.size({a:AsyncResult[java.lang.Integer] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }

  type SockJSHandlerOptions = io.vertx.ext.web.handler.sockjs.SockJSHandlerOptions

  object SockJSHandlerOptions {
    def apply() = new SockJSHandlerOptions()
    def apply(json: JsonObject) = new SockJSHandlerOptions(json)
  }


import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.ext.web.{RoutingContext => JRoutingContext}
import io.vertx.core.buffer.Buffer
import io.vertx.ext.web.RoutingContext
import io.vertx.core.AsyncResult
import io.vertx.core.Handler

  /**
   * A template engine uses a specific template and the data in a routing context to render a resource into a buffer.
   * 
   * Concrete implementations exist for several well-known template engines.
   */
  implicit class TemplateEngineScala(val asJava: io.vertx.ext.web.templ.TemplateEngine) extends AnyVal {

    /**
     * Like [[render]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def renderFuture(context: io.vertx.ext.web.RoutingContext, templateFileName: String): scala.concurrent.Future[io.vertx.core.buffer.Buffer] = {
      val promise = Promise[io.vertx.core.buffer.Buffer]()
      asJava.render(context, templateFileName, {a:AsyncResult[io.vertx.core.buffer.Buffer] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[render]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def renderFuture(context: io.vertx.ext.web.RoutingContext, templateDirectory: String, templateFileName: String): scala.concurrent.Future[io.vertx.core.buffer.Buffer] = {
      val promise = Promise[io.vertx.core.buffer.Buffer]()
      asJava.render(context, templateDirectory, templateFileName, {a:AsyncResult[io.vertx.core.buffer.Buffer] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }

}
