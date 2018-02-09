//MODULE: vertx-auth-mongo
//MODULE: io.vertx.ext.auth.mongo
//MODULE: io.vertx
//MODULE: io.vertx.scala.ext.auth.mongo
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

package object mongo{


import io.vertx.ext.auth.mongo.HashAlgorithm
import io.vertx.ext.mongo.{MongoClient => JMongoClient}
import io.vertx.ext.mongo.MongoClient
import io.vertx.core.json.JsonObject
import io.vertx.ext.auth.mongo.{HashStrategy => JHashStrategy}
import io.vertx.ext.auth.mongo.HashStrategy
import io.vertx.core.AsyncResult
import scala.collection.JavaConverters._
import io.vertx.core.Handler

  /**
   * An extension of AuthProvider which is using  as store
   */
  implicit class MongoAuthScala(val asJava: io.vertx.ext.auth.mongo.MongoAuth) extends AnyVal {

    /**
     * Like [[insertUser]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def insertUserFuture(username: String, password: String, roles: java.util.List[String], permissions: java.util.List[String]): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.insertUser(username, password, roles, permissions, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }

  type MongoAuthOptions = io.vertx.ext.auth.mongo.MongoAuthOptions

  object MongoAuthOptions {
    def apply() = new MongoAuthOptions()
    def apply(json: JsonObject) = new MongoAuthOptions(json)
  }


}
