//MODULE: vertx-service-discovery
//MODULE: io.vertx.servicediscovery
//MODULE: io.vertx
//MODULE: io.vertx.scala.servicediscovery
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

package object servicediscovery{


  type HttpLocation = io.vertx.servicediscovery.types.HttpLocation

  object HttpLocation {
    def apply() = new HttpLocation()
    def apply(json: JsonObject) = new HttpLocation(json)
  }


  type Record = io.vertx.servicediscovery.Record

  object Record {
    def apply() = new Record()
    def apply(json: JsonObject) = new Record(json)
  }


import io.vertx.servicediscovery.{Record => JRecord}
import io.vertx.servicediscovery.{ServiceDiscoveryOptions => JServiceDiscoveryOptions}
import io.vertx.servicediscovery.ServiceReference
import io.vertx.core.Vertx
import io.vertx.servicediscovery.spi.{ServiceImporter => JServiceImporter}
import io.vertx.servicediscovery.Record
import scala.collection.JavaConverters._
import io.vertx.servicediscovery.spi.{ServiceExporter => JServiceExporter}
import io.vertx.servicediscovery.spi.ServiceImporter
import io.vertx.core.{Vertx => JVertx}
import io.vertx.servicediscovery.{ServiceReference => JServiceReference}
import io.vertx.servicediscovery.ServiceDiscoveryOptions
import io.vertx.servicediscovery.{ServiceDiscovery => JServiceDiscovery}
import io.vertx.core.json.JsonObject
import io.vertx.servicediscovery.ServiceDiscovery
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.servicediscovery.spi.ServiceExporter

  /**
   * Service Discovery main entry point.
   * 
   * The service discovery is an infrastructure that let you publish and find `services`. A `service` is a discoverable
   * functionality. It can be qualified by its type, metadata, and location. So a `service` can be a database, a
   * service proxy, a HTTP endpoint. It does not have to be a vert.x entity, but can be anything. Each service is
   * described by a <a href="../../../../../../cheatsheet/Record.html">Record</a>.
   * 
   * The service discovery implements the interactions defined in the service-oriented computing. And to some extend,
   * also provides the dynamic service-oriented computing interaction. So, application can react to arrival and
   * departure of services.
   * 
   * A service provider can:
   * 
   * * publish a service record
   * * un-publish a published record
   * * update the status of a published service (down, out of service...)
   * 
   * A service consumer can:
   * 
   * * lookup for services
   * * bind to a selected service (it gets a [[io.vertx.servicediscovery.ServiceReference]]) and use it
   * * release the service once the consumer is done with it
   * * listen for arrival, departure and modification of services.
   * 
   * Consumer would 1) lookup for service record matching their need, 2) retrieve the [[io.vertx.servicediscovery.ServiceReference]] that give access
   * to the service, 3) get a service object to access the service, 4) release the service object once done.
   * 
   * A state above, the central piece of information shared by the providers and consumers are <a href="../../../../../../cheatsheet/Record.html">Record</a>.
   * 
   * Providers and consumers must create their own [[io.vertx.servicediscovery.ServiceDiscovery]] instance. These instances are collaborating
   * in background (distributed structure) to keep the set of services in sync.
   */
  implicit class ServiceDiscoveryScala(val asJava: io.vertx.servicediscovery.ServiceDiscovery) extends AnyVal {

    /**
     * Like [[registerServiceImporter]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def registerServiceImporterFuture(importer: io.vertx.servicediscovery.spi.ServiceImporter, configuration: io.vertx.core.json.JsonObject): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.registerServiceImporter(importer, configuration, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[registerServiceExporter]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def registerServiceExporterFuture(exporter: io.vertx.servicediscovery.spi.ServiceExporter, configuration: io.vertx.core.json.JsonObject): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.registerServiceExporter(exporter, configuration, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[publish]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def publishFuture(record: io.vertx.servicediscovery.Record): scala.concurrent.Future[io.vertx.servicediscovery.Record] = {
      val promise = Promise[io.vertx.servicediscovery.Record]()
      asJava.publish(record, {a:AsyncResult[io.vertx.servicediscovery.Record] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[unpublish]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def unpublishFuture(id: String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.unpublish(id, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[getRecord]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getRecordFuture(filter: io.vertx.core.json.JsonObject): scala.concurrent.Future[io.vertx.servicediscovery.Record] = {
      val promise = Promise[io.vertx.servicediscovery.Record]()
      asJava.getRecord(filter, {a:AsyncResult[io.vertx.servicediscovery.Record] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[getRecord]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getRecordFuture(filter: io.vertx.servicediscovery.Record => java.lang.Boolean): scala.concurrent.Future[io.vertx.servicediscovery.Record] = {
      val promise = Promise[io.vertx.servicediscovery.Record]()
      asJava.getRecord(a => filter(a), {a:AsyncResult[io.vertx.servicediscovery.Record] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[getRecord]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getRecordFuture(filter: io.vertx.servicediscovery.Record => java.lang.Boolean, includeOutOfService: java.lang.Boolean): scala.concurrent.Future[io.vertx.servicediscovery.Record] = {
      val promise = Promise[io.vertx.servicediscovery.Record]()
      asJava.getRecord(a => filter(a), includeOutOfService, {a:AsyncResult[io.vertx.servicediscovery.Record] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[getRecords]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getRecordsFuture(filter: io.vertx.core.json.JsonObject): scala.concurrent.Future[java.util.List[io.vertx.servicediscovery.Record]] = {
      val promise = Promise[java.util.List[io.vertx.servicediscovery.Record]]()
      asJava.getRecords(filter, {a:AsyncResult[java.util.List[io.vertx.servicediscovery.Record]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[getRecords]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getRecordsFuture(filter: io.vertx.servicediscovery.Record => java.lang.Boolean): scala.concurrent.Future[java.util.List[io.vertx.servicediscovery.Record]] = {
      val promise = Promise[java.util.List[io.vertx.servicediscovery.Record]]()
      asJava.getRecords(a => filter(a), {a:AsyncResult[java.util.List[io.vertx.servicediscovery.Record]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[getRecords]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getRecordsFuture(filter: io.vertx.servicediscovery.Record => java.lang.Boolean, includeOutOfService: java.lang.Boolean): scala.concurrent.Future[java.util.List[io.vertx.servicediscovery.Record]] = {
      val promise = Promise[java.util.List[io.vertx.servicediscovery.Record]]()
      asJava.getRecords(a => filter(a), includeOutOfService, {a:AsyncResult[java.util.List[io.vertx.servicediscovery.Record]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[update]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def updateFuture(record: io.vertx.servicediscovery.Record): scala.concurrent.Future[io.vertx.servicediscovery.Record] = {
      val promise = Promise[io.vertx.servicediscovery.Record]()
      asJava.update(record, {a:AsyncResult[io.vertx.servicediscovery.Record] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }

  type ServiceDiscoveryOptions = io.vertx.servicediscovery.ServiceDiscoveryOptions

  object ServiceDiscoveryOptions {
    def apply() = new ServiceDiscoveryOptions()
    def apply(json: JsonObject) = new ServiceDiscoveryOptions(json)
  }


import io.vertx.servicediscovery.{Record => JRecord}
import io.vertx.servicediscovery.Record
import io.vertx.core.AsyncResult
import io.vertx.core.Handler

  /**
   * The publisher is used by the importer to publish or unpublish records.
   */
  implicit class ServicePublisherScala(val asJava: io.vertx.servicediscovery.spi.ServicePublisher) extends AnyVal {

    /**
     * Like [[publish]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def publishFuture(record: io.vertx.servicediscovery.Record): scala.concurrent.Future[io.vertx.servicediscovery.Record] = {
      val promise = Promise[io.vertx.servicediscovery.Record]()
      asJava.publish(record, {a:AsyncResult[io.vertx.servicediscovery.Record] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[unpublish]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def unpublishFuture(id: String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.unpublish(id, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[update]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def updateFuture(record: io.vertx.servicediscovery.Record): scala.concurrent.Future[io.vertx.servicediscovery.Record] = {
      val promise = Promise[io.vertx.servicediscovery.Record]()
      asJava.update(record, {a:AsyncResult[io.vertx.servicediscovery.Record] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }

}
