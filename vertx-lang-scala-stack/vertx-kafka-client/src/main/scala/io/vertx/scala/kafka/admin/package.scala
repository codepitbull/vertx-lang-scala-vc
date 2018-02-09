//MODULE: vertx-kafka-client
//MODULE: io.vertx.kafka.admin
//MODULE: io.vertx
//MODULE: io.vertx.scala.kafka.admin
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

package io.vertx.scala.kafka
import scala.collection.JavaConverters._
import scala.compat.java8.FunctionConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import scala.concurrent.Promise

package object admin{


import io.vertx.core.Vertx
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.collection.JavaConverters._
import io.vertx.core.{Vertx => JVertx}

  /**
   * Provides a wrapper around important methods in Kafka's AdminUtils, namely
   */
  implicit class AdminUtilsScala(val asJava: io.vertx.kafka.admin.AdminUtils) extends AnyVal {

    /**
     * Like [[createTopic]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def createTopicFuture(topicName: String, partitionCount: java.lang.Integer, replicationFactor: java.lang.Integer): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.createTopic(topicName, partitionCount, replicationFactor, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[createTopic]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def createTopicFuture(topicName: String, partitionCount: java.lang.Integer, replicationFactor: java.lang.Integer, topicConfig: java.util.Map[String, String]): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.createTopic(topicName, partitionCount, replicationFactor, topicConfig, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[deleteTopic]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def deleteTopicFuture(topicName: String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.deleteTopic(topicName, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[topicExists]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def topicExistsFuture(topicName: String): scala.concurrent.Future[java.lang.Boolean] = {
      val promise = Promise[java.lang.Boolean]()
      asJava.topicExists(topicName, {a:AsyncResult[java.lang.Boolean] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[changeTopicConfig]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def changeTopicConfigFuture(topicName: String, topicConfig: java.util.Map[String, String]): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.changeTopicConfig(topicName, topicConfig, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
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
