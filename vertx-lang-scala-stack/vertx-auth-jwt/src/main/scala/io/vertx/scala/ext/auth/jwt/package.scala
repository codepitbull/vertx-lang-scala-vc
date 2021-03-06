//MODULE: vertx-auth-jwt
//MODULE: io.vertx.ext.auth.jwt
//MODULE: io.vertx
//MODULE: io.vertx.scala.ext.auth.jwt
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

package object jwt{


  type JWTAuthOptions = io.vertx.ext.auth.jwt.JWTAuthOptions

  object JWTAuthOptions {
    def apply() = new JWTAuthOptions()
    def apply(json: JsonObject) = new JWTAuthOptions(json)
  }


  type JWTKeyStoreOptions = io.vertx.ext.auth.jwt.JWTKeyStoreOptions

  object JWTKeyStoreOptions {
    def apply() = new JWTKeyStoreOptions()
    def apply(json: JsonObject) = new JWTKeyStoreOptions(json)
  }


  type JWTOptions = io.vertx.ext.auth.jwt.JWTOptions

  object JWTOptions {
    def apply() = new JWTOptions()
    def apply(json: JsonObject) = new JWTOptions(json)
  }


}
