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
import io.vertx.lang.scala.HandlerOps._
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

import io.vertx.ext.bridge.{PermittedOptions => JPermittedOptions}
import io.vertx.ext.bridge.PermittedOptions

/**
  * Options for configuring the event bus bridge.
  */

  implicit class BridgeOptionsScala(val asJava: io.vertx.ext.web.handler.sockjs.BridgeOptions) extends AnyVal {

    def setInboundPermitted(value: List[io.vertx.ext.bridge.PermittedOptions]) = {
      asJava.setInboundPermitted(value.asJava)
      }
    def addInboundPermitted(value: io.vertx.ext.bridge.PermittedOptions) = {
      asJava.addInboundPermitted(value)
      }
    def getInboundPermitteds: scala.collection.mutable.Buffer[io.vertx.ext.bridge.PermittedOptions] = {
      asJava.getInboundPermitteds().asScala
    }
    def setMaxAddressLength(value: java.lang.Integer) = {
      asJava.setMaxAddressLength(value)
    }
    def getMaxAddressLength: java.lang.Integer = {
      asJava.getMaxAddressLength()
    }
    def setMaxHandlersPerSocket(value: java.lang.Integer) = {
      asJava.setMaxHandlersPerSocket(value)
    }
    def getMaxHandlersPerSocket: java.lang.Integer = {
      asJava.getMaxHandlersPerSocket()
    }
    def setOutboundPermitted(value: List[io.vertx.ext.bridge.PermittedOptions]) = {
      asJava.setOutboundPermitted(value.asJava)
      }
    def addOutboundPermitted(value: io.vertx.ext.bridge.PermittedOptions) = {
      asJava.addOutboundPermitted(value)
      }
    def getOutboundPermitteds: scala.collection.mutable.Buffer[io.vertx.ext.bridge.PermittedOptions] = {
      asJava.getOutboundPermitteds().asScala
    }
    def setPingTimeout(value: java.lang.Long) = {
      asJava.setPingTimeout(value)
    }
    def getPingTimeout: java.lang.Long = {
      asJava.getPingTimeout()
    }
    def setReplyTimeout(value: java.lang.Long) = {
      asJava.setReplyTimeout(value)
    }
    def getReplyTimeout: java.lang.Long = {
      asJava.getReplyTimeout()
    }
  }
  
  type BridgeOptions = io.vertx.ext.web.handler.sockjs.BridgeOptions
  object BridgeOptions {
    def apply() = new BridgeOptions()
    def apply(json: JsonObject) = new io.vertx.ext.web.handler.sockjs.BridgeOptions(json)
  }


import io.vertx.core.Vertx
import io.vertx.core.{Vertx => JVertx}

/**
  * A session store which stores sessions in a distributed map so they are available across the cluster.
  */
implicit class ClusteredSessionStoreScala(val asJava: io.vertx.ext.web.sstore.ClusteredSessionStore) extends AnyVal {


}


/**
  * Represents an HTTP Cookie.
  * 
  * All cookies must have a name and a value and can optionally have other fields set such as path, domain, etc.
  * 
  * (Derived from io.netty.handler.codec.http.Cookie)
  */
implicit class CookieScala(val asJava: io.vertx.ext.web.Cookie) extends AnyVal {


}


/**
  * Represents a file-upload from an HTTP multipart form submission.
  * 
  */
implicit class FileUploadScala(val asJava: io.vertx.ext.web.FileUpload) extends AnyVal {


}



  implicit class Http2PushMappingScala(val asJava: io.vertx.ext.web.Http2PushMapping) extends AnyVal {

    def setExtensionTarget(value: String) = {
      asJava.setExtensionTarget(value)
    }
    def getExtensionTarget: String = {
      asJava.getExtensionTarget()
    }
    def setFilePath(value: String) = {
      asJava.setFilePath(value)
    }
    def getFilePath: String = {
      asJava.getFilePath()
    }
    def setNoPush(value: java.lang.Boolean) = {
      asJava.setNoPush(value)
    }
    def isNoPush: java.lang.Boolean = {
      asJava.isNoPush()
    }
  }
  
  type Http2PushMapping = io.vertx.ext.web.Http2PushMapping
  object Http2PushMapping {
    def apply() = new Http2PushMapping()
    def apply(json: JsonObject) = new io.vertx.ext.web.Http2PushMapping(json)
  }


import io.vertx.ext.web.ParsedHeaderValue
import io.vertx.ext.web.{ParsedHeaderValue => JParsedHeaderValue}

/**
  * A parsed language header.
  * Delivers a more direct access to the individual elements of the header it represents
  */
implicit class LanguageHeaderScala(val asJava: io.vertx.ext.web.LanguageHeader) extends AnyVal {


}

import io.vertx.core.Vertx
import io.vertx.core.{Vertx => JVertx}

/**
  * A session store which is only available on a single node.
  * 
  * Can be used when sticky sessions are being used.
  */
implicit class LocalSessionStoreScala(val asJava: io.vertx.ext.web.sstore.LocalSessionStore) extends AnyVal {


}


/**
  */
implicit class LocaleScala(val asJava: io.vertx.ext.web.Locale) extends AnyVal {


}

import io.vertx.ext.web.ParsedHeaderValue
import io.vertx.ext.web.{ParsedHeaderValue => JParsedHeaderValue}

implicit class MIMEHeaderScala(val asJava: io.vertx.ext.web.MIMEHeader) extends AnyVal {


}

import io.vertx.ext.web.ParsedHeaderValue
import io.vertx.ext.web.{ParsedHeaderValue => JParsedHeaderValue}

implicit class ParsedHeaderValueScala(val asJava: io.vertx.ext.web.ParsedHeaderValue) extends AnyVal {


}


/**
  * A container with the request's headers that are meaningful enough to be parsed
  * Contains:
  * <ul>
  * <li>Accept -> MIME header, parameters and sortable</li>
  * <li>Accept-Charset -> Parameters and sortable</li>
  * <li>Accept-Encoding -> Parameters and sortable</li>
  * <li>Accept-Language -> Parameters and sortable</li>
  * <li>Content-Type -> MIME header and parameters</li>
  * </ul>
  *
  */
implicit class ParsedHeaderValuesScala(val asJava: io.vertx.ext.web.ParsedHeaderValues) extends AnyVal {


}

import io.vertx.core.json.JsonObject

/**
  * Specify a match to allow for inbound and outbound traffic using the
  * <a href="../../../../../../../../../cheatsheet/BridgeOptions.html">BridgeOptions</a>.
  */

  implicit class PermittedOptionsScala(val asJava: io.vertx.ext.web.handler.sockjs.PermittedOptions) extends AnyVal {

    def setAddress(value: String) = {
      asJava.setAddress(value)
    }
    def getAddress: String = {
      asJava.getAddress()
    }
    def setAddressRegex(value: String) = {
      asJava.setAddressRegex(value)
    }
    def getAddressRegex: String = {
      asJava.getAddressRegex()
    }
    def setMatch(value: io.vertx.core.json.JsonObject) = {
      asJava.setMatch(value)
    }
    def getMatch: io.vertx.core.json.JsonObject = {
      asJava.getMatch()
    }
    def setRequiredAuthority(value: String) = {
      asJava.setRequiredAuthority(value)
    }
    def getRequiredAuthority: String = {
      asJava.getRequiredAuthority()
    }
  }
  
  type PermittedOptions = io.vertx.ext.web.handler.sockjs.PermittedOptions
  object PermittedOptions {
    def apply() = new PermittedOptions()
    def apply(json: JsonObject) = new io.vertx.ext.web.handler.sockjs.PermittedOptions(json)
  }


import io.vertx.ext.web.{RoutingContext => JRoutingContext}
import io.vertx.core.http.HttpMethod
import io.vertx.ext.web.RoutingContext
import io.vertx.core.Handler
import scala.collection.JavaConverters._

/**
  * A route is a holder for a set of criteria which determine whether an HTTP request or failure should be routed
  * to a handler.
  */
implicit class RouteScala(val asJava: io.vertx.ext.web.Route) extends AnyVal {


}

import io.vertx.core.http.HttpServerRequest
import io.vertx.core.http.{HttpServerRequest => JHttpServerRequest}
import io.vertx.ext.web.{RoutingContext => JRoutingContext}
import io.vertx.core.http.HttpMethod
import io.vertx.core.Vertx
import io.vertx.ext.web.Router
import io.vertx.ext.web.RoutingContext
import io.vertx.core.Handler
import io.vertx.ext.web.{Router => JRouter}
import io.vertx.core.{Vertx => JVertx}

/**
  * A router receives request from an [[io.vertx.core.http.HttpServer]] and routes it to the first matching
  * [[io.vertx.ext.web.Route]] that it contains. A router can contain many routes.
  * 
  * Routers are also used for routing failures.
  */
implicit class RouterScala(val asJava: io.vertx.ext.web.Router) extends AnyVal {


}

import io.vertx.ext.web.Cookie
import io.vertx.ext.web.{Cookie => JCookie}
import io.vertx.ext.web.Session
import io.vertx.ext.auth.User
import io.vertx.core.buffer.Buffer
import io.vertx.core.http.HttpMethod
import io.vertx.ext.auth.{User => JUser}
import io.vertx.ext.web.{Session => JSession}
import io.vertx.core.Handler

/**
  * Represents the context for the handling of a request in Vert.x-Web.
  * 
  * A new instance is created for each HTTP request that is received in the
  * [[io.vertx.ext.web.Router#accept]] of the router.
  * 
  * The same instance is passed to any matching request or failure handlers during the routing of the request or
  * failure.
  * 
  * The context provides access to the  and 
  * and allows you to maintain arbitrary data that lives for the lifetime of the context. Contexts are discarded once they
  * have been routed to the handler for the request.
  * 
  * The context also provides access to the [[io.vertx.ext.web.Session]], cookies and body for the request, given the correct handlers
  * in the application.
  */
implicit class RoutingContextScala(val asJava: io.vertx.ext.web.RoutingContext) extends AnyVal {


}


/**
  * Represents a browser session.
  * 
  * Sessions persist between HTTP requests for a single browser session. They are deleted when the browser is closed, or
  * they time-out. Session cookies are used to maintain sessions using a secure UUID.
  * 
  * Sessions can be used to maintain data for a browser session, e.g. a shopping basket.
  * 
  * The context must have first been routed to a [[io.vertx.ext.web.handler.SessionHandler]]
  * for sessions to be available.
  */
implicit class SessionScala(val asJava: io.vertx.ext.web.Session) extends AnyVal {


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


/**
  * Options for configuring a SockJS handler
  */

  implicit class SockJSHandlerOptionsScala(val asJava: io.vertx.ext.web.handler.sockjs.SockJSHandlerOptions) extends AnyVal {

    def addDisabledTransport(value: String) = {
      asJava.addDisabledTransport(value)
      }
    def getDisabledTransports: scala.collection.mutable.Set[String] = {
      asJava.getDisabledTransports().asScala
    }
    def setHeartbeatInterval(value: java.lang.Long) = {
      asJava.setHeartbeatInterval(value)
    }
    def getHeartbeatInterval: java.lang.Long = {
      asJava.getHeartbeatInterval()
    }
    def setInsertJSESSIONID(value: java.lang.Boolean) = {
      asJava.setInsertJSESSIONID(value)
    }
    def isInsertJSESSIONID: java.lang.Boolean = {
      asJava.isInsertJSESSIONID()
    }
    def setLibraryURL(value: String) = {
      asJava.setLibraryURL(value)
    }
    def getLibraryURL: String = {
      asJava.getLibraryURL()
    }
    def setMaxBytesStreaming(value: java.lang.Integer) = {
      asJava.setMaxBytesStreaming(value)
    }
    def getMaxBytesStreaming: java.lang.Integer = {
      asJava.getMaxBytesStreaming()
    }
    def setSessionTimeout(value: java.lang.Long) = {
      asJava.setSessionTimeout(value)
    }
    def getSessionTimeout: java.lang.Long = {
      asJava.getSessionTimeout()
    }
  }
  
  type SockJSHandlerOptions = io.vertx.ext.web.handler.sockjs.SockJSHandlerOptions
  object SockJSHandlerOptions {
    def apply() = new SockJSHandlerOptions()
    def apply(json: JsonObject) = new io.vertx.ext.web.handler.sockjs.SockJSHandlerOptions(json)
  }


import io.vertx.core.buffer.Buffer
import io.vertx.core.Handler

/**
  *
  * You interact with SockJS clients through instances of SockJS socket.
  * 
  * The API is very similar to [[io.vertx.core.http.WebSocket]].
  * It implements both  and 
  * so it can be used with
  * [[io.vertx.core.streams.Pump]] to pump data with flow control.
  */
implicit class SockJSSocketScala(val asJava: io.vertx.ext.web.handler.sockjs.SockJSSocket) extends AnyVal {


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
