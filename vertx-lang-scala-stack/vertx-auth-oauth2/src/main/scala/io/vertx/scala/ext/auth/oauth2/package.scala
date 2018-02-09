//MODULE: vertx-auth-oauth2
//MODULE: io.vertx.ext.auth.oauth2
//MODULE: io.vertx
//MODULE: io.vertx.scala.ext.auth.oauth2
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

package io.vertx.scala.ext.auth
import scala.collection.JavaConverters._
import scala.compat.java8.FunctionConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import scala.concurrent.Promise

package object oauth2{


import io.vertx.core.buffer.Buffer
import io.vertx.core.http.HttpMethod
import io.vertx.core.json.JsonObject
import io.vertx.ext.auth.oauth2.OAuth2Response
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.ext.auth.oauth2.{OAuth2Response => JOAuth2Response}

  /**
   * AccessToken extension to the User interface
   */
  implicit class AccessTokenScala(val asJava: io.vertx.ext.auth.oauth2.AccessToken) extends AnyVal {

    /**
     * Like [[refresh]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def refreshFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.refresh({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[revoke]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def revokeFuture(token_type: String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.revoke(token_type, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[logout]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def logoutFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.logout({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[introspect]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def introspectFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.introspect({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[introspect]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def introspectFuture(tokenType: String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.introspect(tokenType, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[userInfo]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def userInfoFuture(): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = Promise[io.vertx.core.json.JsonObject]()
      asJava.userInfo({a:AsyncResult[io.vertx.core.json.JsonObject] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[fetch]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def fetchFuture(resource: String): scala.concurrent.Future[io.vertx.ext.auth.oauth2.OAuth2Response] = {
      val promise = Promise[io.vertx.ext.auth.oauth2.OAuth2Response]()
      asJava.fetch(resource, {a:AsyncResult[io.vertx.ext.auth.oauth2.OAuth2Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[fetch]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def fetchFuture(method: io.vertx.core.http.HttpMethod, resource: String, headers: io.vertx.core.json.JsonObject, payload: io.vertx.core.buffer.Buffer): scala.concurrent.Future[io.vertx.ext.auth.oauth2.OAuth2Response] = {
      val promise = Promise[io.vertx.ext.auth.oauth2.OAuth2Response]()
      asJava.fetch(method, resource, headers, payload, {a:AsyncResult[io.vertx.ext.auth.oauth2.OAuth2Response] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }

import io.vertx.ext.auth.oauth2.{AccessToken => JAccessToken}
import io.vertx.core.Vertx
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.ext.auth.oauth2.OAuth2FlowType
import io.vertx.core.Handler
import io.vertx.ext.auth.oauth2.{OAuth2ClientOptions => JOAuth2ClientOptions}
import io.vertx.ext.auth.oauth2.AccessToken
import io.vertx.ext.auth.oauth2.OAuth2ClientOptions
import io.vertx.core.{Vertx => JVertx}

  /**
   * Factory interface for creating OAuth2 based [[io.vertx.ext.auth.AuthProvider]] instances.
   */
  implicit class OAuth2AuthScala(val asJava: io.vertx.ext.auth.oauth2.OAuth2Auth) extends AnyVal {

    /**
     * Like [[getToken]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getTokenFuture(params: io.vertx.core.json.JsonObject): scala.concurrent.Future[io.vertx.ext.auth.oauth2.AccessToken] = {
      val promise = Promise[io.vertx.ext.auth.oauth2.AccessToken]()
      asJava.getToken(params, {a:AsyncResult[io.vertx.ext.auth.oauth2.AccessToken] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[decodeToken]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def decodeTokenFuture(token: String): scala.concurrent.Future[io.vertx.ext.auth.oauth2.AccessToken] = {
      val promise = Promise[io.vertx.ext.auth.oauth2.AccessToken]()
      asJava.decodeToken(token, {a:AsyncResult[io.vertx.ext.auth.oauth2.AccessToken] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[introspectToken]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def introspectTokenFuture(token: String): scala.concurrent.Future[io.vertx.ext.auth.oauth2.AccessToken] = {
      val promise = Promise[io.vertx.ext.auth.oauth2.AccessToken]()
      asJava.introspectToken(token, {a:AsyncResult[io.vertx.ext.auth.oauth2.AccessToken] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[introspectToken]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def introspectTokenFuture(token: String, tokenType: String): scala.concurrent.Future[io.vertx.ext.auth.oauth2.AccessToken] = {
      val promise = Promise[io.vertx.ext.auth.oauth2.AccessToken]()
      asJava.introspectToken(token, tokenType, {a:AsyncResult[io.vertx.ext.auth.oauth2.AccessToken] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[loadJWK]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def loadJWKFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.loadJWK({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }

  type OAuth2ClientOptions = io.vertx.ext.auth.oauth2.OAuth2ClientOptions

  object OAuth2ClientOptions {
    def apply() = new OAuth2ClientOptions()
    def apply(json: JsonObject) = new OAuth2ClientOptions(json)
  }


}
