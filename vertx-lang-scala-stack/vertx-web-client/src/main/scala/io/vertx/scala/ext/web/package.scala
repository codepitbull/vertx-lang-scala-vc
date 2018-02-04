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

package io.vertx.scala.ext.web
import scala.collection.JavaConverters._
import scala.compat.java8.FunctionConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import scala.concurrent.Promise

package object client{


import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.ext.web.client.HttpResponse
import io.vertx.ext.web.codec.{BodyCodec => JBodyCodec}
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.ext.web.codec.BodyCodec
import io.vertx.core.MultiMap
import io.vertx.ext.web.client.{HttpResponse => JHttpResponse}
import io.vertx.core.buffer.Buffer
import io.vertx.core.http.HttpMethod
import io.vertx.core.streams.ReadStream
import io.vertx.core.json.JsonObject
import io.vertx.core.{MultiMap => JMultiMap}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler

  /**
   * A client-side HTTP request.
   * 
   * Instances are created by an [[io.vertx.ext.web.client.WebClient]] instance, via one of the methods corresponding to the specific
   * HTTP methods such as [[io.vertx.ext.web.client.WebClient#get]], etc...
   * 
   * The request shall be configured prior sending, the request is immutable and when a mutator method
   * is called, a new request is returned allowing to expose the request in a public API and apply further customization.
   * 
   * After the request has been configured, the methods
   * <ul>
   *   <li>[[io.vertx.ext.web.client.HttpRequest#sendFuture]]</li>
   *   <li>[[io.vertx.ext.web.client.HttpRequest#sendStreamFuture]]</li>
   *   <li>[[io.vertx.ext.web.client.HttpRequest#sendJsonFuture]] ()}</li>
   *   <li>[[io.vertx.ext.web.client.HttpRequest#sendFormFuture]]</li>
   * </ul>
   * can be called.
   * The `sendXXX` methods perform the actual request, they can be called multiple times to perform the same HTTP
   * request at different points in time.
   * 
   * The handler is called back with
   * <ul>
   *   <li>an [[io.vertx.ext.web.client.HttpResponse]] instance when the HTTP response has been received</li>
   *   <li>a failure when the HTTP request failed (like a connection error) or when the HTTP response could
   *   not be obtained (like connection or unmarshalling errors)</li>
   * </ul>
   * 
   * Most of the time, this client will buffer the HTTP response fully unless a specific  is used
   * such as .
   */
  implicit class HttpRequestScala[T](val asJava: io.vertx.ext.web.client.HttpRequest[T]) extends AnyVal {

    /**
     * Like [[sendStream]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sendStreamFuture(body: io.vertx.core.streams.ReadStream[io.vertx.core.buffer.Buffer]): scala.concurrent.Future[io.vertx.ext.web.client.HttpResponse[T]] = {
      val promise = Promise[io.vertx.ext.web.client.HttpResponse[T]]()
      asJava.sendStream(body, {a:AsyncResult[io.vertx.ext.web.client.HttpResponse[T]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sendBuffer]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sendBufferFuture(body: io.vertx.core.buffer.Buffer): scala.concurrent.Future[io.vertx.ext.web.client.HttpResponse[T]] = {
      val promise = Promise[io.vertx.ext.web.client.HttpResponse[T]]()
      asJava.sendBuffer(body, {a:AsyncResult[io.vertx.ext.web.client.HttpResponse[T]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sendJsonObject]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sendJsonObjectFuture(body: io.vertx.core.json.JsonObject): scala.concurrent.Future[io.vertx.ext.web.client.HttpResponse[T]] = {
      val promise = Promise[io.vertx.ext.web.client.HttpResponse[T]]()
      asJava.sendJsonObject(body, {a:AsyncResult[io.vertx.ext.web.client.HttpResponse[T]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sendJson]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sendJsonFuture(body: AnyRef): scala.concurrent.Future[io.vertx.ext.web.client.HttpResponse[T]] = {
      val promise = Promise[io.vertx.ext.web.client.HttpResponse[T]]()
      asJava.sendJson(body, {a:AsyncResult[io.vertx.ext.web.client.HttpResponse[T]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sendForm]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sendFormFuture(body: io.vertx.core.MultiMap): scala.concurrent.Future[io.vertx.ext.web.client.HttpResponse[T]] = {
      val promise = Promise[io.vertx.ext.web.client.HttpResponse[T]]()
      asJava.sendForm(body, {a:AsyncResult[io.vertx.ext.web.client.HttpResponse[T]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[send]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sendFuture(): scala.concurrent.Future[io.vertx.ext.web.client.HttpResponse[T]] = {
      val promise = Promise[io.vertx.ext.web.client.HttpResponse[T]]()
      asJava.send({a:AsyncResult[io.vertx.ext.web.client.HttpResponse[T]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }

  type WebClientOptions = io.vertx.ext.web.client.WebClientOptions

  object WebClientOptions {
    def apply() = new WebClientOptions()
    def apply(json: JsonObject) = new WebClientOptions(json)
  }


}
