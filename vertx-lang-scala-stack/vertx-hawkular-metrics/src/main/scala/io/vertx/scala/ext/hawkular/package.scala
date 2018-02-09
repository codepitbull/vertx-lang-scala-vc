//MODULE: vertx-hawkular
//MODULE: io.vertx.ext.hawkular
//MODULE: io.vertx
//MODULE: io.vertx.scala.ext.hawkular
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
import scala.concurrent.Promise

package object hawkular{


  type AuthenticationOptions = io.vertx.ext.hawkular.AuthenticationOptions

  object AuthenticationOptions {
    def apply() = new AuthenticationOptions()
    def apply(json: JsonObject) = new AuthenticationOptions(json)
  }


  type MetricTagsMatch = io.vertx.ext.hawkular.MetricTagsMatch

  object MetricTagsMatch {
    def apply() = new MetricTagsMatch()
    def apply(json: JsonObject) = new MetricTagsMatch(json)
  }


  type VertxHawkularOptions = io.vertx.ext.hawkular.VertxHawkularOptions

  object VertxHawkularOptions {
    def apply() = new VertxHawkularOptions()
    def apply(json: JsonObject) = new VertxHawkularOptions(json)
  }


}
