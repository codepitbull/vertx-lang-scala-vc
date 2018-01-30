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
import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import scala.concurrent.Promise

package object core{


  import io.vertx.core.json.{JsonObject => JJsonObject}
  import io.vertx.core.json.{JsonArray => JJsonArray}
  type JsonObject = JJsonObject
  type JsonArray = JJsonArray

  object JsonObject {
    def apply(): JsonObject = new JJsonObject()
    def apply(json: String): JsonObject = new JJsonObject(json)
    def apply(fields: (String, Any)*): JsonObject = {
      val o = new JsonObject()
      fields.foreach {
        case (key, l: Array[_]) => o.put(key, listToJsArr(l))
        case (key, l: Seq[_]) => o.put(key, listToJsArr(l))
        case (key, value) => o.put(key, value)
      }
      o
    }
  }

  object JsonArray {
    def apply(): JsonArray = new JJsonArray()
    def apply(json: String): JsonArray = new JJsonArray(json)
    def apply(fields: Any*): JsonArray = {
      val a = new JsonArray()
      fields.foreach {
        case array: Array[_] => a.add(listToJsArr(array))
        case seq: Seq[_] => a.add(listToJsArr(seq))
        case f => a.add(f)
      }
      a
    }
  }

  private def listToJsArr(a: Seq[_]) = JsonArray(a: _*)


import io.vertx.core.dns.{AddressResolverOptions => JAddressResolverOptions}
import io.vertx.core.buffer.Buffer

/**
  * Configuration options for Vert.x hostname resolver. The resolver uses the local <i>hosts</i> file and performs
  * DNS <i>A</i> and <i>AAAA</i> queries.
  */

  implicit class AddressResolverOptionsScala(val asJava: JAddressResolverOptions) extends AnyVal {


  /**
    * Set the cache maximum TTL value in seconds. After successful resolution IP addresses are cached with their DNS response TTL,
    * use this to set a maximum value to all responses TTL.
    */
    def setCacheMaxTimeToLive(value: java.lang.Integer) = {
      asJava.setCacheMaxTimeToLive(value)
    }
    def getCacheMaxTimeToLive: java.lang.Integer = {
      asJava.getCacheMaxTimeToLive()
    }

  /**
    * Set the cache minimum TTL value in seconds. After resolution successful IP addresses are cached with their DNS response TTL,
    * use this to set a minimum value to all responses TTL.
    */
    def setCacheMinTimeToLive(value: java.lang.Integer) = {
      asJava.setCacheMinTimeToLive(value)
    }
    def getCacheMinTimeToLive: java.lang.Integer = {
      asJava.getCacheMinTimeToLive()
    }

  /**
    * Set the negative cache TTL value in seconds. After a failed hostname resolution, DNS queries won't be retried
    * for a period of time equals to the negative TTL. This allows to reduce the response time of negative replies
    * and reduce the amount of messages to DNS servers.
    */
    def setCacheNegativeTimeToLive(value: java.lang.Integer) = {
      asJava.setCacheNegativeTimeToLive(value)
    }
    def getCacheNegativeTimeToLive: java.lang.Integer = {
      asJava.getCacheNegativeTimeToLive()
    }

  /**
    * Set the path of an alternate hosts configuration file to use instead of the one provided by the os.
    * <p/>
    * The default value is null, so the operating system hosts config is used.
    */
    def setHostsPath(value: String) = {
      asJava.setHostsPath(value)
    }
    def getHostsPath: String = {
      asJava.getHostsPath()
    }

  /**
    * Set an alternate hosts configuration file to use instead of the one provided by the os.
    * <p/>
    * The value should contain the hosts content literaly, for instance <i>127.0.0.1 localhost</i>
    * <p/>
    * The default value is null, so the operating system hosts config is used.
    */
    def setHostsValue(value: io.vertx.core.buffer.Buffer) = {
      asJava.setHostsValue(value)
    }
    def getHostsValue: io.vertx.core.buffer.Buffer = {
      asJava.getHostsValue()
    }

  /**
    * Set the maximum number of queries when an hostname is resolved.
    */
    def setMaxQueries(value: java.lang.Integer) = {
      asJava.setMaxQueries(value)
    }
    def getMaxQueries: java.lang.Integer = {
      asJava.getMaxQueries()
    }

  /**
    * Set the ndots value used when resolving using search domains, the default value is `-1` which
    * determines the value from the OS on Linux or uses the value `1`.
    */
    def setNdots(value: java.lang.Integer) = {
      asJava.setNdots(value)
    }
    def getNdots: java.lang.Integer = {
      asJava.getNdots()
    }

  /**
    * Set to true to enable the automatic inclusion in DNS queries of an optional record that hints
    * the remote DNS server about how much data the resolver can read per response.
    */
    def setOptResourceEnabled(value: java.lang.Boolean) = {
      asJava.setOptResourceEnabled(value)
    }
    def isOptResourceEnabled: java.lang.Boolean = {
      asJava.isOptResourceEnabled()
    }

  /**
    * Set the query timeout in milliseconds, i.e the amount of time after a query is considered to be failed.
    */
    def setQueryTimeout(value: java.lang.Long) = {
      asJava.setQueryTimeout(value)
    }
    def getQueryTimeout: java.lang.Long = {
      asJava.getQueryTimeout()
    }

  /**
    * Set the DNS queries <i>Recursion Desired</i> flag value.
    */
    def setRdFlag(value: java.lang.Boolean) = {
      asJava.setRdFlag(value)
    }
    def getRdFlag: java.lang.Boolean = {
      asJava.getRdFlag()
    }

  /**
    * Set to `true` to enable round-robin selection of the dns server to use. It spreads the query load
    * among the servers and avoids all lookup to hit the first server of the list.
    */
    def setRotateServers(value: java.lang.Boolean) = {
      asJava.setRotateServers(value)
    }
    def isRotateServers: java.lang.Boolean = {
      asJava.isRotateServers()
    }

  /**
    * Set the lists of DNS search domains.
    * <p/>
    * When the search domain list is null, the effective search domain list will be populated using
    * the system DNS search domains.
    */
    def addSearchDomain(value: String) = {
      asJava.addSearchDomain(value)
      }
    def setSearchDomains(value: List[String]) = {
      asJava.setSearchDomains(value.asJava)
      }
    def getSearchDomains: scala.collection.mutable.Buffer[String] = {
      asJava.getSearchDomains().asScala
    }

  /**
    * Set the list of DNS server addresses, an address is the IP  of the dns server, followed by an optional
    * colon and a port, e.g `8.8.8.8` or {code 192.168.0.1:40000}. When the list is empty, the resolver
    * will use the list of the system DNS server addresses from the environment, if that list cannot be retrieved
    * it will use Google's public DNS servers `"8.8.8.8"` and `"8.8.4.4"`.
    */
    def addServer(value: String) = {
      asJava.addServer(value)
      }
    def setServers(value: List[String]) = {
      asJava.setServers(value.asJava)
      }
    def getServers: scala.collection.mutable.Buffer[String] = {
      asJava.getServers().asScala
    }
  }
  
  type AddressResolverOptions = JAddressResolverOptions
  object AddressResolverOptions {
    def apply(): JAddressResolverOptions = new AddressResolverOptions()
    def apply(json: JsonObject) = new JAddressResolverOptions(json)
  }


import io.vertx.core.cli.{Argument => JArgument}

/**
  * Defines a command line argument. Unlike options, argument don't have names and are identified using an index. The
  * first index is 0 (because we are in the computer world).
  */

  implicit class ArgumentScala(val asJava: JArgument) extends AnyVal {


  /**
    * Sets the argument name of this <a href="../../../../../../../cheatsheet/Argument.html">Argument</a>.
    */
    def setArgName(value: String) = {
      asJava.setArgName(value)
    }
    def getArgName: String = {
      asJava.getArgName()
    }

  /**
    * Sets the default value of this <a href="../../../../../../../cheatsheet/Argument.html">Argument</a>.
    */
    def setDefaultValue(value: String) = {
      asJava.setDefaultValue(value)
    }
    def getDefaultValue: String = {
      asJava.getDefaultValue()
    }

  /**
    * Sets the description of the <a href="../../../../../../../cheatsheet/Argument.html">Argument</a>.
    */
    def setDescription(value: String) = {
      asJava.setDescription(value)
    }
    def getDescription: String = {
      asJava.getDescription()
    }

  /**
    * Sets whether or not the current <a href="../../../../../../../cheatsheet/Argument.html">Argument</a> is hidden.
    */
    def setHidden(value: java.lang.Boolean) = {
      asJava.setHidden(value)
    }
    def isHidden: java.lang.Boolean = {
      asJava.isHidden()
    }

  /**
    * Sets the argument index.
    */
    def setIndex(value: java.lang.Integer) = {
      asJava.setIndex(value)
    }
    def getIndex: java.lang.Integer = {
      asJava.getIndex()
    }

  /**
    * Sets whether or not the argument can receive several values. Only the last argument can receive several values.
    */
    def setMultiValued(value: java.lang.Boolean) = {
      asJava.setMultiValued(value)
    }
    def isMultiValued: java.lang.Boolean = {
      asJava.isMultiValued()
    }

  /**
    * Sets whether or not the current <a href="../../../../../../../cheatsheet/Argument.html">Argument</a> is required.
    */
    def setRequired(value: java.lang.Boolean) = {
      asJava.setRequired(value)
    }
    def isRequired: java.lang.Boolean = {
      asJava.isRequired()
    }
  }
  
  type Argument = JArgument
  object Argument {
    def apply(): JArgument = new Argument()
    def apply(json: JsonObject) = new JArgument(json)
  }


import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.file.AsyncFile
import io.vertx.core.buffer.Buffer
import io.vertx.core.file.{AsyncFile => JAsyncFile}
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.core.streams.WriteStream
import io.vertx.core.streams.ReadStream
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.core.streams.{WriteStream => JWriteStream}

/**
  * Represents a file on the file-system which can be read from, or written to asynchronously.
  * 
  * This class also implements [[io.vertx.core.streams.ReadStream]] and
  * [[io.vertx.core.streams.WriteStream]]. This allows the data to be pumped to and from
  * other streams, e.g. an [[io.vertx.core.http.HttpClientRequest]] instance,
  * using the [[io.vertx.core.streams.Pump]] class
  */
implicit class AsyncFileScala(val asJava: JAsyncFile) extends AnyVal {


  def handler(handler: scala.Option[io.vertx.core.buffer.Buffer => Unit]): JAsyncFile = {
    asJava.handler(handler match {case Some(t) => (p:io.vertx.core.buffer.Buffer) => t(p); case None => null})
  }

  def pause(): JAsyncFile = {
    asJava.pause()
  }

  def resume(): JAsyncFile = {
    asJava.resume()
  }

  def endHandler(endHandler: scala.Option[Void => Unit]): JAsyncFile = {
    asJava.endHandler(endHandler match {case Some(t) => (p:Void) => t(p); case None => null})
  }

  def write(data: io.vertx.core.buffer.Buffer): JAsyncFile = {
    asJava.write(data)
  }

  def setWriteQueueMaxSize(maxSize: java.lang.Integer): JAsyncFile = {
    asJava.setWriteQueueMaxSize(maxSize)
  }

  def drainHandler(handler: scala.Option[Void => Unit]): JAsyncFile = {
    asJava.drainHandler(handler match {case Some(t) => (p:Void) => t(p); case None => null})
  }

  def exceptionHandler(handler: scala.Option[Throwable => Unit]): JAsyncFile = {
    asJava.exceptionHandler(handler match {case Some(t) => (p:Throwable) => t(p); case None => null})
  }

  /**
    * Write a [[io.vertx.core.buffer.Buffer]] to the file at position `position` in the file, asynchronously.
    * 
    * If `position` lies outside of the current size
    * of the file, the file will be enlarged to encompass it.
    * 
    * When multiple writes are invoked on the same file
    * there are no guarantees as to order in which those writes actually occur
    * 
    * The handler will be called when the write is complete, or if an error occurs.
    * @param buffer the buffer to write
    * @param position the position in the file to write it at
    * @param handler the handler to call when the write is complete
    * @return a reference to this, so the API can be used fluently
    */
  def write(buffer: io.vertx.core.buffer.Buffer, position: java.lang.Long, handler: AsyncResult[Void] => Unit): JAsyncFile = {
    asJava.write(buffer, position, (p:AsyncResult[Void]) => handler(p))
  }

  /**
    * Reads `length` bytes of data from the file at position `position` in the file, asynchronously.
    * 
    * The read data will be written into the specified `Buffer buffer` at position `offset`.
    * 
    * If data is read past the end of the file then zero bytes will be read.
    * When multiple reads are invoked on the same file there are no guarantees as to order in which those reads actually occur.
    * 
    * The handler will be called when the close is complete, or if an error occurs.
    * @param buffer the buffer to read into
    * @param offset the offset into the buffer where the data will be read
    * @param position the position in the file where to start reading
    * @param length the number of bytes to read
    * @param handler the handler to call when the write is complete
    * @return a reference to this, so the API can be used fluently
    */
  def read(buffer: io.vertx.core.buffer.Buffer, offset: java.lang.Integer, position: java.lang.Long, length: java.lang.Integer, handler: AsyncResult[io.vertx.core.buffer.Buffer] => Unit): JAsyncFile = {
    asJava.read(buffer, offset, position, length, (p:AsyncResult[io.vertx.core.buffer.Buffer]) => handler(p))
  }

  /**
    * Flush any writes made to this file to underlying persistent storage.
    * 
    * If the file was opened with `flush` set to `true` then calling this method will have no effect.
    * 
    * The actual flush will happen asynchronously.
    * @return a reference to this, so the API can be used fluently
    */
  def flush(): JAsyncFile = {
    asJava.flush()
  }

  /**
    * Same as [[io.vertx.core.file.AsyncFile#flush]] but the handler will be called when the flush is complete or if an error occurs
    */
  def flush(handler: AsyncResult[Void] => Unit): JAsyncFile = {
    asJava.flush((p:AsyncResult[Void]) => handler(p))
  }

  /**
    * Sets the position from which data will be read from when using the file as a [[io.vertx.core.streams.ReadStream]].
    * @param readPos the position in the file
    * @return a reference to this, so the API can be used fluently
    */
  def setReadPos(readPos: java.lang.Long): JAsyncFile = {
    asJava.setReadPos(readPos)
  }

  /**
    * Sets the position from which data will be written when using the file as a [[io.vertx.core.streams.WriteStream]].
    * @param writePos the position in the file
    * @return a reference to this, so the API can be used fluently
    */
  def setWritePos(writePos: java.lang.Long): JAsyncFile = {
    asJava.setWritePos(writePos)
  }

  /**
    * Sets the buffer size that will be used to read the data from the file. Changing this value will impact how much
    * the data will be read at a time from the file system.
    * @param readBufferSize the buffer size
    * @return a reference to this, so the API can be used fluently
    */
  def setReadBufferSize(readBufferSize: java.lang.Integer): JAsyncFile = {
    asJava.setReadBufferSize(readBufferSize)
  }

  /**
    * Same as [[io.vertx.core.file.AsyncFile#end]] but writes some data to the stream before ending.
    */
  def end(t: io.vertx.core.buffer.Buffer): Unit = {
    asJava.end(t)
  }

  /**
    * This will return `true` if there are more bytes in the write queue than the value set using [[io.vertx.core.file.AsyncFile#setWriteQueueMaxSize]]
    * @return true if write queue is full
    */
  def writeQueueFull(): java.lang.Boolean = {
    asJava.writeQueueFull()
  }

  /**
    * Close the file, see [[io.vertx.core.file.AsyncFile#close]].
    */
  def end(): Unit = {
    asJava.end()
  }

  /**
    * Close the file. The actual close happens asynchronously.
    */
  def close(): Unit = {
    asJava.close()
  }

  /**
    * Close the file. The actual close happens asynchronously.
    * The handler will be called when the close is complete, or an error occurs.
    * @param handler the handler
    */
  def close(handler: AsyncResult[Void] => Unit): Unit = {
    asJava.close((p:AsyncResult[Void]) => handler(p))
  }

 /**
   * Like [[close]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def closeFuture(): scala.concurrent.Future[Unit] = {
    val promise = Promise[Unit]()
    asJava.close({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[write]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def writeFuture(buffer: io.vertx.core.buffer.Buffer, position: java.lang.Long): scala.concurrent.Future[Unit] = {
    val promise = Promise[Unit]()
    asJava.write(buffer, position, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[read]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def readFuture(buffer: io.vertx.core.buffer.Buffer, offset: java.lang.Integer, position: java.lang.Long, length: java.lang.Integer): scala.concurrent.Future[io.vertx.core.buffer.Buffer] = {
    val promise = Promise[io.vertx.core.buffer.Buffer]()
    asJava.read(buffer, offset, position, length, {a:AsyncResult[io.vertx.core.buffer.Buffer] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[flush]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def flushFuture(): scala.concurrent.Future[Unit] = {
    val promise = Promise[Unit]()
    asJava.flush({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

}

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.shareddata.{AsyncMap => JAsyncMap}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler

/**
  *
  * An asynchronous map.
  * 
  */
implicit class AsyncMapScala[K, V](val asJava: JAsyncMap[K, V]) extends AnyVal {


  /**
    * Get a value from the map, asynchronously.
    * @param k the key
    * @param resultHandler - this will be called some time later with the async result.
    */
  def get(k: K, resultHandler: AsyncResult[V] => Unit): Unit = {
    asJava.get(k, (p:AsyncResult[V]) => resultHandler(p))
  }

  /**
    * Put a value in the map, asynchronously.
    * @param k the key
    * @param v the value
    * @param completionHandler - this will be called some time later to signify the value has been put
    */
  def put(k: K, v: V, completionHandler: AsyncResult[Void] => Unit): Unit = {
    asJava.put(k, v, (p:AsyncResult[Void]) => completionHandler(p))
  }

  /**
    * Like [[io.vertx.core.shareddata.AsyncMap#putFuture]] but specifying a time to live for the entry. Entry will expire and get evicted after the
    * ttl.
    * @param k the key
    * @param v the value
    * @param ttl The time to live (in ms) for the entry
    * @param completionHandler the handler
    */
  def put(k: K, v: V, ttl: java.lang.Long, completionHandler: AsyncResult[Void] => Unit): Unit = {
    asJava.put(k, v, ttl, (p:AsyncResult[Void]) => completionHandler(p))
  }

  /**
    * Put the entry only if there is no entry with the key already present. If key already present then the existing
    * value will be returned to the handler, otherwise null.
    * @param k the key
    * @param v the value
    * @param completionHandler the handler
    */
  def putIfAbsent(k: K, v: V, completionHandler: AsyncResult[V] => Unit): Unit = {
    asJava.putIfAbsent(k, v, (p:AsyncResult[V]) => completionHandler(p))
  }

  /**
    * Link [[io.vertx.core.shareddata.AsyncMap#putIfAbsentFuture]] but specifying a time to live for the entry. Entry will expire and get evicted
    * after the ttl.
    * @param k the key
    * @param v the value
    * @param ttl The time to live (in ms) for the entry
    * @param completionHandler the handler
    */
  def putIfAbsent(k: K, v: V, ttl: java.lang.Long, completionHandler: AsyncResult[V] => Unit): Unit = {
    asJava.putIfAbsent(k, v, ttl, (p:AsyncResult[V]) => completionHandler(p))
  }

  /**
    * Remove a value from the map, asynchronously.
    * @param k the key
    * @param resultHandler - this will be called some time later to signify the value has been removed
    */
  def remove(k: K, resultHandler: AsyncResult[V] => Unit): Unit = {
    asJava.remove(k, (p:AsyncResult[V]) => resultHandler(p))
  }

  /**
    * Remove a value from the map, only if entry already exists with same value.
    * @param k the key
    * @param v the value
    * @param resultHandler - this will be called some time later to signify the value has been removed
    */
  def removeIfPresent(k: K, v: V, resultHandler: AsyncResult[java.lang.Boolean] => Unit): Unit = {
    asJava.removeIfPresent(k, v, (p:AsyncResult[java.lang.Boolean]) => resultHandler(p))
  }

  /**
    * Replace the entry only if it is currently mapped to some value
    * @param k the key
    * @param v the new value
    * @param resultHandler the result handler will be passed the previous value
    */
  def replace(k: K, v: V, resultHandler: AsyncResult[V] => Unit): Unit = {
    asJava.replace(k, v, (p:AsyncResult[V]) => resultHandler(p))
  }

  /**
    * Replace the entry only if it is currently mapped to a specific value
    * @param k the key
    * @param oldValue the existing value
    * @param newValue the new value
    * @param resultHandler the result handler
    */
  def replaceIfPresent(k: K, oldValue: V, newValue: V, resultHandler: AsyncResult[java.lang.Boolean] => Unit): Unit = {
    asJava.replaceIfPresent(k, oldValue, newValue, (p:AsyncResult[java.lang.Boolean]) => resultHandler(p))
  }

  /**
    * Clear all entries in the map
    * @param resultHandler called on completion
    */
  def clear(resultHandler: AsyncResult[Void] => Unit): Unit = {
    asJava.clear((p:AsyncResult[Void]) => resultHandler(p))
  }

  /**
    * Provide the number of entries in the map
    * @param resultHandler handler which will receive the number of entries
    */
  def size(resultHandler: AsyncResult[java.lang.Integer] => Unit): Unit = {
    asJava.size((p:AsyncResult[java.lang.Integer]) => resultHandler(p))
  }

 /**
   * Like [[get]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def getFuture(k: K): scala.concurrent.Future[V] = {
    val promise = Promise[V]()
    asJava.get(k, {a:AsyncResult[V] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[put]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def putFuture(k: K, v: V): scala.concurrent.Future[Unit] = {
    val promise = Promise[Unit]()
    asJava.put(k, v, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[put]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def putFuture(k: K, v: V, ttl: java.lang.Long): scala.concurrent.Future[Unit] = {
    val promise = Promise[Unit]()
    asJava.put(k, v, ttl, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[putIfAbsent]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def putIfAbsentFuture(k: K, v: V): scala.concurrent.Future[V] = {
    val promise = Promise[V]()
    asJava.putIfAbsent(k, v, {a:AsyncResult[V] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[putIfAbsent]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def putIfAbsentFuture(k: K, v: V, ttl: java.lang.Long): scala.concurrent.Future[V] = {
    val promise = Promise[V]()
    asJava.putIfAbsent(k, v, ttl, {a:AsyncResult[V] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[remove]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def removeFuture(k: K): scala.concurrent.Future[V] = {
    val promise = Promise[V]()
    asJava.remove(k, {a:AsyncResult[V] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[removeIfPresent]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def removeIfPresentFuture(k: K, v: V): scala.concurrent.Future[java.lang.Boolean] = {
    val promise = Promise[java.lang.Boolean]()
    asJava.removeIfPresent(k, v, {a:AsyncResult[java.lang.Boolean] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[replace]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def replaceFuture(k: K, v: V): scala.concurrent.Future[V] = {
    val promise = Promise[V]()
    asJava.replace(k, v, {a:AsyncResult[V] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[replaceIfPresent]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def replaceIfPresentFuture(k: K, oldValue: V, newValue: V): scala.concurrent.Future[java.lang.Boolean] = {
    val promise = Promise[java.lang.Boolean]()
    asJava.replaceIfPresent(k, oldValue, newValue, {a:AsyncResult[java.lang.Boolean] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
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

import io.vertx.core.cli.{Argument => JArgument}
import io.vertx.core.cli.Option
import io.vertx.core.cli.CommandLine
import io.vertx.core.cli.{Option => JOption}
import io.vertx.core.cli.CLI
import io.vertx.core.cli.{CLI => JCLI}
import io.vertx.core.cli.{CommandLine => JCommandLine}
import scala.collection.JavaConverters._
import io.vertx.core.cli.Argument

/**
  * Interface defining a command-line interface (in other words a command such as 'run', 'ls'...).
  * This interface is polyglot to ease reuse such as in Vert.x Shell.
  * <p/>
  * A command line interface has a name, and defines a set of options and arguments. Options are key-value pair such
  * as `-foo=bar` or `-flag`. The supported formats depend on the used parser. Arguments are unlike
  * options raw values. Options are defined using
  * <a href="../../../../../../../cheatsheet/Option.html">Option</a>, while argument are defined using <a href="../../../../../../../cheatsheet/Argument.html">Argument</a>.
  * <p/>
  * Command line interfaces also define a summary and a description. These attributes are used in the usage generation
  * . To disable the help generation, set the `hidden` attribute to `true`.
  * <p/>
  * Command Line Interface object does not contains "value", it's a model. It must be evaluated by a
  * parser that returns a [[io.vertx.core.cli.CommandLine]] object containing the argument and option values.
  */
implicit class CLIScala(val asJava: JCLI) extends AnyVal {


  /**
    * Sets the name of the CLI.
    * @param name the name
    * @return the current CLI instance
    */
  def setName(name: String): JCLI = {
    asJava.setName(name)
  }

  def setDescription(desc: String): JCLI = {
    asJava.setDescription(desc)
  }

  /**
    * Sets the summary of the CLI.
    * @param summary the summary
    * @return the current CLI instance
    */
  def setSummary(summary: String): JCLI = {
    asJava.setSummary(summary)
  }

  /**
    * Sets whether or not the current instance of [[io.vertx.core.cli.CLI]] must be hidden. Hidden CLI are not listed when
    * displaying usages / help messages. In other words, hidden commands are for power user.
    * @param hidden enables or disables the hidden aspect of the CI
    * @return the current CLI instance
    */
  def setHidden(hidden: java.lang.Boolean): JCLI = {
    asJava.setHidden(hidden)
  }

  /**
    * Adds an option.
    * @param option the option, must not be `null`.see <a href="../../../../../../../cheatsheet/Option.html">Option</a>
    * @return the current CLI instance
    */
  def addOption(option: JOption): JCLI = {
    asJava.addOption(option.asJava)
  }

  /**
    * Adds a set of options. Unlike [[io.vertx.core.cli.CLI#setOptions]]`, this method does not remove the existing options.
    * The given list is appended to the existing list.
    * @param options the options, must not be `null`
    * @return the current CLI instance
    */
  def addOptions(options: List[JOption]): JCLI = {
    asJava.addOptions(options.asJava)
  }

  /**
    * Sets the list of arguments.
    * @param options the list of options, must not be `null`
    * @return the current CLI instance
    */
  def setOptions(options: List[JOption]): JCLI = {
    asJava.setOptions(options.asJava)
  }

  /**
    * Adds an argument.
    * @param arg the argument, must not be `null`see <a href="../../../../../../../cheatsheet/Argument.html">Argument</a>
    * @return the current CLI instance
    */
  def addArgument(arg: JArgument): JCLI = {
    asJava.addArgument(arg.asJava)
  }

  /**
    * Adds a set of arguments. Unlike [[io.vertx.core.cli.CLI#setArguments]], this method does not remove the existing arguments.
    * The given list is appended to the existing list.
    * @param args the arguments, must not be `null`
    * @return the current CLI instance
    */
  def addArguments(args: List[JArgument]): JCLI = {
    asJava.addArguments(args.asJava)
  }

  /**
    * Sets the list of arguments.
    * @param args the list of arguments, must not be `null`
    * @return the current CLI instance
    */
  def setArguments(args: List[JArgument]): JCLI = {
    asJava.setArguments(args.asJava)
  }

  /**
    * Removes an option identified by its name. This method does nothing if the option cannot be found.
    * @param name the option name
    * @return the current CLI instance
    */
  def removeOption(name: String): JCLI = {
    asJava.removeOption(name)
  }

  /**
    * Removes an argument identified by its index. This method does nothing if the argument cannot be found.
    * @param index the argument index
    * @return the current CLI instance
    */
  def removeArgument(index: java.lang.Integer): JCLI = {
    asJava.removeArgument(index)
  }

  /**
    * Parses the user command line interface and create a new [[io.vertx.core.cli.CommandLine]] containing extracting values.
    * @param arguments the arguments
    * @return the creates command line
    */
  def parse(arguments: List[String]): JCommandLine = {
    asJava.parse(arguments.map(x => x.asInstanceOf[String]).asJava)
  }

  /**
    * Parses the user command line interface and create a new [[io.vertx.core.cli.CommandLine]] containing extracting values.
    * @param arguments the arguments
    * @param validate enable / disable parsing validation
    * @return the creates command line
    */
  def parse(arguments: List[String], validate: java.lang.Boolean): JCommandLine = {
    asJava.parse(arguments.map(x => x.asInstanceOf[String]).asJava, validate)
  }

  /**
    * @return the CLI name.
    */
  def getName(): String = {
    asJava.getName()
  }

  /**
    * @return the CLI description.
    */
  def getDescription(): scala.Option[String] = {
    scala.Option(asJava.getDescription())
  }

  /**
    * @return the CLI summary.
    */
  def getSummary(): scala.Option[String] = {
    scala.Option(asJava.getSummary())
  }

  /**
    * Checks whether or not the current [[io.vertx.core.cli.CLI]] instance is hidden.
    * @return `true` if the current CLI is hidden, false otherwise
    */
  def isHidden(): java.lang.Boolean = {
    asJava.isHidden()
  }

  /**
    * Gets the list of options.
    * @return the list of options, empty if none.
    */
  def getOptions(): List[JOption] = {
    asJava.getOptions().asScala.toList
  }

  /**
    * Gets the list of defined arguments.
    * @return the list of argument, empty if none.
    */
  def getArguments(): List[JArgument] = {
    asJava.getArguments().asScala.toList
  }

  /**
    * Gets an <a href="../../../../../../../cheatsheet/Option.html">Option</a> based on its name (short name, long name or argument name).
    * @param name the name, must not be `null`
    * @return the Option, `null` if not foundsee <a href="../../../../../../../cheatsheet/Option.html">Option</a>
    */
  def getOption(name: String): scala.Option[JOption] = {
    scala.Option(asJava.getOption(name))
  }

  /**
    * Gets an <a href="../../../../../../../cheatsheet/Argument.html">Argument</a> based on its name (argument name).
    * @param name the name of the argument, must not be `null`
    * @return the Argument, `null` if not found.see <a href="../../../../../../../cheatsheet/Argument.html">Argument</a>
    */
  def getArgument(name: String): scala.Option[JArgument] = {
    scala.Option(asJava.getArgument(name))
  }

  /**
    * Gets an <a href="../../../../../../../cheatsheet/Argument.html">Argument</a> based on its index.
    * @param index the index, must be positive or zero.
    * @return the Argument, `null` if not found.see <a href="../../../../../../../cheatsheet/Argument.html">Argument</a>
    */
  def getArgument(index: java.lang.Integer): scala.Option[JArgument] = {
    scala.Option(asJava.getArgument(index))
  }

}

import io.vertx.core.net.ProxyOptions
import io.vertx.core.net.JksOptions
import io.vertx.core.net.{PfxOptions => JPfxOptions}
import io.vertx.core.net.PfxOptions
import io.vertx.core.net.OpenSSLEngineOptions
import io.vertx.core.buffer.Buffer
import io.vertx.core.net.{OpenSSLEngineOptions => JOpenSSLEngineOptions}
import io.vertx.core.net.PemKeyCertOptions
import io.vertx.core.net.{JdkSSLEngineOptions => JJdkSSLEngineOptions}
import io.vertx.core.net.{ClientOptionsBase => JClientOptionsBase}
import io.vertx.core.net.{PemTrustOptions => JPemTrustOptions}
import io.vertx.core.net.{PemKeyCertOptions => JPemKeyCertOptions}
import io.vertx.core.net.PemTrustOptions
import io.vertx.core.net.{ProxyOptions => JProxyOptions}
import io.vertx.core.net.JdkSSLEngineOptions
import io.vertx.core.net.{JksOptions => JJksOptions}

/**
  * Base class for Client options
  */

  implicit class ClientOptionsBaseScala(val asJava: JClientOptionsBase) extends AnyVal {


  /**
    * Set the connect timeout
    */
    def setConnectTimeout(value: java.lang.Integer) = {
      asJava.setConnectTimeout(value)
    }
    def getConnectTimeout: java.lang.Integer = {
      asJava.getConnectTimeout()
    }

  /**
    * Add a CRL path
    */
    def addCrlPath(value: String) = {
      asJava.addCrlPath(value)
      }
    def getCrlPaths: scala.collection.mutable.Buffer[String] = {
      asJava.getCrlPaths().asScala
    }

  /**
    * Add a CRL value
    */
    def addCrlValue(value: io.vertx.core.buffer.Buffer) = {
      asJava.addCrlValue(value)
      }
    def getCrlValues: scala.collection.mutable.Buffer[io.vertx.core.buffer.Buffer] = {
      asJava.getCrlValues().asScala
    }

  /**
    * Add an enabled cipher suite, appended to the ordered suites.
    */
    def addEnabledCipherSuite(value: String) = {
      asJava.addEnabledCipherSuite(value)
      }
    def getEnabledCipherSuites: scala.collection.mutable.Set[String] = {
      asJava.getEnabledCipherSuites().asScala
    }

  /**
    * Sets the list of enabled SSL/TLS protocols.
    */
    def addEnabledSecureTransportProtocol(value: String) = {
      asJava.addEnabledSecureTransportProtocol(value)
      }
    def setEnabledSecureTransportProtocols(value: Set[String]) = {
      asJava.setEnabledSecureTransportProtocols(value.asJava)
    }
    def getEnabledSecureTransportProtocols: scala.collection.mutable.Set[String] = {
      asJava.getEnabledSecureTransportProtocols().asScala
    }

  /**
    * Set the idle timeout, in seconds. zero means don't timeout.
    * This determines if a connection will timeout and be closed if no data is received within the timeout.
    */
    def setIdleTimeout(value: java.lang.Integer) = {
      asJava.setIdleTimeout(value)
    }
    def getIdleTimeout: java.lang.Integer = {
      asJava.getIdleTimeout()
    }
    def setJdkSslEngineOptions(value: JJdkSSLEngineOptions) = {
      asJava.setJdkSslEngineOptions(value.asJava)
    }
    def getJdkSslEngineOptions: JJdkSSLEngineOptions = {
      asJava.getJdkSslEngineOptions()
    }

  /**
    * Set the key/cert options in jks format, aka Java keystore.
    */
    def setKeyStoreOptions(value: JJksOptions) = {
      asJava.setKeyStoreOptions(value.asJava)
    }
    def getKeyStoreOptions: JJksOptions = {
      asJava.getKeyStoreOptions()
    }

  /**
    * Set the local interface to bind for network connections. When the local address is null,
    * it will pick any local address, the default local address is null.
    */
    def setLocalAddress(value: String) = {
      asJava.setLocalAddress(value)
    }
    def getLocalAddress: String = {
      asJava.getLocalAddress()
    }

  /**
    * Set to true to enabled network activity logging: Netty's pipeline is configured for logging on Netty's logger.
    */
    def setLogActivity(value: java.lang.Boolean) = {
      asJava.setLogActivity(value)
    }
    def getLogActivity: java.lang.Boolean = {
      asJava.getLogActivity()
    }

  /**
    * Set the metrics name identifying the reported metrics, useful for grouping metrics
    * with the same name.
    */
    def setMetricsName(value: String) = {
      asJava.setMetricsName(value)
    }
    def getMetricsName: String = {
      asJava.getMetricsName()
    }
    def setOpenSslEngineOptions(value: JOpenSSLEngineOptions) = {
      asJava.setOpenSslEngineOptions(value.asJava)
    }
    def getOpenSslEngineOptions: JOpenSSLEngineOptions = {
      asJava.getOpenSslEngineOptions()
    }

  /**
    * Set the key/cert store options in pem format.
    */
    def setPemKeyCertOptions(value: JPemKeyCertOptions) = {
      asJava.setPemKeyCertOptions(value.asJava)
    }
    def getPemKeyCertOptions: JPemKeyCertOptions = {
      asJava.getPemKeyCertOptions()
    }

  /**
    * Set the trust options in pem format
    */
    def setPemTrustOptions(value: JPemTrustOptions) = {
      asJava.setPemTrustOptions(value.asJava)
    }
    def getPemTrustOptions: JPemTrustOptions = {
      asJava.getPemTrustOptions()
    }

  /**
    * Set the key/cert options in pfx format.
    */
    def setPfxKeyCertOptions(value: JPfxOptions) = {
      asJava.setPfxKeyCertOptions(value.asJava)
    }
    def getPfxKeyCertOptions: JPfxOptions = {
      asJava.getPfxKeyCertOptions()
    }

  /**
    * Set the trust options in pfx format
    */
    def setPfxTrustOptions(value: JPfxOptions) = {
      asJava.setPfxTrustOptions(value.asJava)
    }
    def getPfxTrustOptions: JPfxOptions = {
      asJava.getPfxTrustOptions()
    }

  /**
    * Set proxy options for connections via CONNECT proxy (e.g. Squid) or a SOCKS proxy.
    */
    def setProxyOptions(value: JProxyOptions) = {
      asJava.setProxyOptions(value.asJava)
    }
    def getProxyOptions: JProxyOptions = {
      asJava.getProxyOptions()
    }

  /**
    * Set the TCP receive buffer size
    */
    def setReceiveBufferSize(value: java.lang.Integer) = {
      asJava.setReceiveBufferSize(value)
    }
    def getReceiveBufferSize: java.lang.Integer = {
      asJava.getReceiveBufferSize()
    }

  /**
    * Set the value of reuse address
    */
    def setReuseAddress(value: java.lang.Boolean) = {
      asJava.setReuseAddress(value)
    }
    def isReuseAddress: java.lang.Boolean = {
      asJava.isReuseAddress()
    }

  /**
    * Set the value of reuse port.
    * <p/>
    * This is only supported by native transports.
    */
    def setReusePort(value: java.lang.Boolean) = {
      asJava.setReusePort(value)
    }
    def isReusePort: java.lang.Boolean = {
      asJava.isReusePort()
    }

  /**
    * Set the TCP send buffer size
    */
    def setSendBufferSize(value: java.lang.Integer) = {
      asJava.setSendBufferSize(value)
    }
    def getSendBufferSize: java.lang.Integer = {
      asJava.getSendBufferSize()
    }

  /**
    * Set whether SO_linger keep alive is enabled
    */
    def setSoLinger(value: java.lang.Integer) = {
      asJava.setSoLinger(value)
    }
    def getSoLinger: java.lang.Integer = {
      asJava.getSoLinger()
    }

  /**
    * Set whether SSL/TLS is enabled
    */
    def setSsl(value: java.lang.Boolean) = {
      asJava.setSsl(value)
    }
    def isSsl: java.lang.Boolean = {
      asJava.isSsl()
    }

  /**
    * Enable the `TCP_CORK` option - only with linux native transport.
    */
    def setTcpCork(value: java.lang.Boolean) = {
      asJava.setTcpCork(value)
    }
    def isTcpCork: java.lang.Boolean = {
      asJava.isTcpCork()
    }

  /**
    * Enable the `TCP_FASTOPEN` option - only with linux native transport.
    */
    def setTcpFastOpen(value: java.lang.Boolean) = {
      asJava.setTcpFastOpen(value)
    }
    def isTcpFastOpen: java.lang.Boolean = {
      asJava.isTcpFastOpen()
    }

  /**
    * Set whether TCP keep alive is enabled
    */
    def setTcpKeepAlive(value: java.lang.Boolean) = {
      asJava.setTcpKeepAlive(value)
    }
    def isTcpKeepAlive: java.lang.Boolean = {
      asJava.isTcpKeepAlive()
    }

  /**
    * Set whether TCP no delay is enabled
    */
    def setTcpNoDelay(value: java.lang.Boolean) = {
      asJava.setTcpNoDelay(value)
    }
    def isTcpNoDelay: java.lang.Boolean = {
      asJava.isTcpNoDelay()
    }

  /**
    * Enable the `TCP_QUICKACK` option - only with linux native transport.
    */
    def setTcpQuickAck(value: java.lang.Boolean) = {
      asJava.setTcpQuickAck(value)
    }
    def isTcpQuickAck: java.lang.Boolean = {
      asJava.isTcpQuickAck()
    }

  /**
    * Set the value of traffic class
    */
    def setTrafficClass(value: java.lang.Integer) = {
      asJava.setTrafficClass(value)
    }
    def getTrafficClass: java.lang.Integer = {
      asJava.getTrafficClass()
    }

  /**
    * Set whether all server certificates should be trusted
    */
    def setTrustAll(value: java.lang.Boolean) = {
      asJava.setTrustAll(value)
    }
    def isTrustAll: java.lang.Boolean = {
      asJava.isTrustAll()
    }

  /**
    * Set the trust options in jks format, aka Java truststore
    */
    def setTrustStoreOptions(value: JJksOptions) = {
      asJava.setTrustStoreOptions(value.asJava)
    }
    def getTrustStoreOptions: JJksOptions = {
      asJava.getTrustStoreOptions()
    }

  /**
    * Set the ALPN usage.
    */
    def setUseAlpn(value: java.lang.Boolean) = {
      asJava.setUseAlpn(value)
    }
    def isUseAlpn: java.lang.Boolean = {
      asJava.isUseAlpn()
    }

  /**
    * Set whether Netty pooled buffers are enabled
    */
    def setUsePooledBuffers(value: java.lang.Boolean) = {
      asJava.setUsePooledBuffers(value)
    }
    def isUsePooledBuffers: java.lang.Boolean = {
      asJava.isUsePooledBuffers()
    }
  }
  


import io.vertx.core.cli.{Argument => JArgument}
import io.vertx.core.cli.Option
import io.vertx.core.cli.CommandLine
import io.vertx.core.cli.{Option => JOption}
import io.vertx.core.cli.CLI
import io.vertx.core.cli.{CLI => JCLI}
import io.vertx.core.cli.{CommandLine => JCommandLine}
import scala.collection.JavaConverters._
import io.vertx.core.cli.Argument

/**
  * The parser transforms a CLI (a model) into an [[io.vertx.core.cli.CommandLine]]. This [[io.vertx.core.cli.CommandLine]]
  * has stored the argument and option values. Only  instance of parser should create
  * objects of this type.
  */
implicit class CommandLineScala(val asJava: JCommandLine) extends AnyVal {


  /**
    * Gets the raw values of the given option. Raw values are simple "String", not converted to the option type.
    * @param option the optionsee <a href="../../../../../../../cheatsheet/Option.html">Option</a>
    * @return the list of values, empty if none
    */
  def getRawValues(option: JOption): List[String] = {
    asJava.getRawValues(option.asJava).asScala.toList
  }

  /**
    * @return the model of this command line object.
    */
  def cli(): JCLI = {
    asJava.cli()
  }

  /**
    * @return the ordered list of arguments. Arguments are command line arguments not matching an option.
    */
  def allArguments(): List[String] = {
    asJava.allArguments().asScala.toList
  }

  /**
    * Gets the value of an option with the matching name (can be the long name, short name or arg name).
    * @param name the name
    * @return the value, `null` if not set
    */
  def getOptionValue[T](name: String): scala.Option[T] = {
    scala.Option(asJava.getOptionValue[T](name))
  }

  /**
    * Gets the value of an argument with the matching name (arg name).
    * @param name the name
    * @return the value, `null` if not set
    */
  def getArgumentValue[T](name: String): scala.Option[T] = {
    scala.Option(asJava.getArgumentValue[T](name))
  }

  /**
    * Gets the value of an argument with the given index.
    * @param index the index
    * @return the value, `null` if not set
    */
  def getArgumentValue[T](index: java.lang.Integer): scala.Option[T] = {
    scala.Option(asJava.getArgumentValue[T](index))
  }

  /**
    * Gets the value of an option marked as a flag.
    * <p/>
    * Calling this method an a non-flag option throws an IllegalStateException.
    * @param name the option name
    * @return `true` if the flag has been set in the command line, `false` otherwise.
    */
  def isFlagEnabled(name: String): java.lang.Boolean = {
    asJava.isFlagEnabled(name)
  }

  /**
    * Checks whether or not the given option has been assigned in the command line.
    * @param option the optionsee <a href="../../../../../../../cheatsheet/Option.html">Option</a>
    * @return `true` if the option has received a value, false otherwise.
    */
  def isOptionAssigned(option: JOption): java.lang.Boolean = {
    asJava.isOptionAssigned(option.asJava)
  }

  /**
    * Gets the raw values of the given option. Raw values are simple "String", not converted to the option type.
    * @param option the optionsee <a href="../../../../../../../cheatsheet/Option.html">Option</a>
    * @return the list of values, empty if none
    */
  def getRawValuesForOption(option: JOption): List[String] = {
    asJava.getRawValuesForOption(option.asJava).asScala.toList
  }

  /**
    * Gets the raw values of the given argument. Raw values are simple "String", not converted to the argument type.
    * @param argument the argumentsee <a href="../../../../../../../cheatsheet/Argument.html">Argument</a>
    * @return the list of values, empty if none
    */
  def getRawValuesForArgument(argument: JArgument): List[String] = {
    asJava.getRawValuesForArgument(argument.asJava).asScala.toList
  }

  /**
    * Gets the raw value of the given option. Raw values are the values as given in the user command line.
    * @param option the optionsee <a href="../../../../../../../cheatsheet/Option.html">Option</a>
    * @return the value, `null` if none.
    */
  def getRawValueForOption(option: JOption): scala.Option[String] = {
    scala.Option(asJava.getRawValueForOption(option.asJava))
  }

  /**
    * Checks whether or not the given option accept more values.
    * @param option the optionsee <a href="../../../../../../../cheatsheet/Option.html">Option</a>
    * @return true if the option accepts more values, false otherwise.
    */
  def acceptMoreValues(option: JOption): java.lang.Boolean = {
    asJava.acceptMoreValues(option.asJava)
  }

  /**
    * Gets the raw value of the given argument. Raw values are the values as given in the user command line.
    * @param arg the argumentsee <a href="../../../../../../../cheatsheet/Argument.html">Argument</a>
    * @return the value, `null` if none.
    */
  def getRawValueForArgument(arg: JArgument): scala.Option[String] = {
    scala.Option(asJava.getRawValueForArgument(arg.asJava))
  }

  /**
    * Checks whether or not the given argument has been assigned in the command line.
    * @param arg the argumentsee <a href="../../../../../../../cheatsheet/Argument.html">Argument</a>
    * @return `true` if the argument has received a value, false otherwise.
    */
  def isArgumentAssigned(arg: JArgument): java.lang.Boolean = {
    asJava.isArgumentAssigned(arg.asJava)
  }

  /**
    * Checks whether or not the given option has been seen in the user command line.
    * @param option the optionsee <a href="../../../../../../../cheatsheet/Option.html">Option</a>
    * @return `true` if the user command line has used the option
    */
  def isSeenInCommandLine(option: JOption): java.lang.Boolean = {
    asJava.isSeenInCommandLine(option.asJava)
  }

  /**
    * Checks whether or not the command line is valid, i.e. all constraints from arguments and options have been
    * satisfied. This method is used when the parser validation is disabled.
    * @return `true` if the current CommandLine object is valid. false otherwise.
    */
  def isValid(): java.lang.Boolean = {
    asJava.isValid()
  }

  /**
    * Checks whether or not the user has passed a "help" option and is asking for help.
    * @return `true` if the user command line has enabled a "Help" option, false otherwise.
    */
  def isAskingForHelp(): java.lang.Boolean = {
    asJava.isAskingForHelp()
  }

}

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.CompositeFuture
import io.vertx.core.{Future => JFuture}
import io.vertx.core.{CompositeFuture => JCompositeFuture}
import io.vertx.core.AsyncResult
import scala.collection.JavaConverters._
import io.vertx.core.Handler
import io.vertx.core.Future

/**
  * The composite future wraps a list of [[io.vertx.core.Future]], it is useful when several futures
  * needs to be coordinated.
  * The handlers set for the coordinated futures are overridden by the handler of the composite future.
  */
implicit class CompositeFutureScala(val asJava: JCompositeFuture) extends AnyVal {


  def setHandler(handler: AsyncResult[JCompositeFuture] => Unit): JCompositeFuture = {
    asJava.setHandler((p:AsyncResult[JCompositeFuture]) => handler(p))
  }

  /**
    * Compose this future with a provided `next` future.
    *
    * When this (the one on which `compose` is called) future succeeds, the `handler` will be called with
    * the completed value, this handler should complete the next future.
    *
    * If the `handler` throws an exception, the returned future will be failed with this exception.
    *
    * When this future fails, the failure will be propagated to the `next` future and the `handler`
    * will not be called.
    * @param handler the handler
    * @param next the next future
    * @return the next future, used for chaining
    */
  def compose[U](handler: JCompositeFuture => Unit, next: JFuture[U]): JFuture[U] = {
    asJava.compose[U]((p:JCompositeFuture) => handler(p), next.asJava)
  }

  /**
    * Compose this future with a `mapper` function.
    *
    * When this future (the one on which `compose` is called) succeeds, the `mapper` will be called with
    * the completed value and this mapper returns another future object. This returned future completion will complete
    * the future returned by this method call.
    *
    * If the `mapper` throws an exception, the returned future will be failed with this exception.
    *
    * When this future fails, the failure will be propagated to the returned future and the `mapper`
    * will not be called.
    * @param mapper the mapper function
    * @return the composed future
    */
  def compose[U](mapper: JCompositeFuture => JFuture[U]): JFuture[U] = {
    asJava.compose[U](asJavaFunction(mapper))
  }

  /**
    * Apply a `mapper` function on this future.
    *
    * When this future succeeds, the `mapper` will be called with the completed value and this mapper
    * returns a value. This value will complete the future returned by this method call.
    *
    * If the `mapper` throws an exception, the returned future will be failed with this exception.
    *
    * When this future fails, the failure will be propagated to the returned future and the `mapper`
    * will not be called.
    * @param mapper the mapper function
    * @return the mapped future
    */
  def map[U](mapper: JCompositeFuture => U): JFuture[U] = {
    asJava.map[U](a => mapper(a))
  }

  /**
    * Handles a failure of this Future by returning the result of another Future.
    * If the mapper fails, then the returned future will be failed with this failure.
    * @param mapper A function which takes the exception of a failure and returns a new future.
    * @return A recovered future
    */
  def recover(mapper: Throwable => JFuture[JCompositeFuture]): JFuture[JCompositeFuture] = {
    asJava.recover(a => mapper(a).asJava)
  }

  /**
    * Apply a `mapper` function on this future.
    *
    * When this future fails, the `mapper` will be called with the completed value and this mapper
    * returns a value. This value will complete the future returned by this method call.
    *
    * If the `mapper` throws an exception, the returned future will be failed with this exception.
    *
    * When this future succeeds, the result will be propagated to the returned future and the `mapper`
    * will not be called.
    * @param mapper the mapper function
    * @return the mapped future
    */
  def otherwise(mapper: Throwable => JCompositeFuture): JFuture[JCompositeFuture] = {
    asJava.otherwise(a => mapper(a).asJava)
  }

  /**
    * Map the failure of a future to a specific `value`.
    *
    * When this future fails, this `value` will complete the future returned by this method call.
    *
    * When this future succeeds, the result will be propagated to the returned future.
    * @param value the value that eventually completes the mapped future
    * @return the mapped future
    */
  def otherwise(value: JCompositeFuture): JFuture[JCompositeFuture] = {
    asJava.otherwise(value.asJava)
  }

  /**
    * Map the failure of a future to `null`.
    *
    * This is a convenience for `future.otherwise((T) null)`.
    *
    * When this future fails, the `null` value will complete the future returned by this method call.
    *
    * When this future succeeds, the result will be propagated to the returned future.
    * @return the mapped future
    */
  def otherwiseEmpty(): JFuture[JCompositeFuture] = {
    asJava.otherwiseEmpty()
  }

  /**
    * Set the result. Any handler will be called, if there is one, and the future will be marked as completed.
    * @param result the result
    */
  def complete(result: JCompositeFuture): Unit = {
    asJava.complete(result.asJava)
  }

  /**
    * Set the failure. Any handler will be called, if there is one, and the future will be marked as completed.
    * @param result the result
    * @return false when the future is already completed
    */
  def tryComplete(result: JCompositeFuture): java.lang.Boolean = {
    asJava.tryComplete(result.asJava)
  }

  /**
    * The result of the operation. This will be null if the operation failed.
    * @return the result or null if the operation failed.
    */
  def result(): JCompositeFuture = {
    asJava.result()
  }

  /**
    * Set this instance as result. Any handler will be called, if there is one, and the future will be marked as completed.
    */
  def complete(): Unit = {
    asJava.complete()
  }

  /**
    * Try to set this instance as result. When it happens, any handler will be called, if there is one, and the future will be marked as completed.
    * @return false when the future is already completed
    */
  def tryComplete(): java.lang.Boolean = {
    asJava.tryComplete()
  }

  /**
    * Returns a cause of a wrapped future
    * @param index the wrapped future index
    */
  def cause(index: java.lang.Integer): Throwable = {
    asJava.cause(index)
  }

  /**
    * Returns true if a wrapped future is succeeded
    * @param index the wrapped future index
    */
  def succeeded(index: java.lang.Integer): java.lang.Boolean = {
    asJava.succeeded(index)
  }

  /**
    * Returns true if a wrapped future is failed
    * @param index the wrapped future index
    */
  def failed(index: java.lang.Integer): java.lang.Boolean = {
    asJava.failed(index)
  }

  /**
    * Returns true if a wrapped future is completed
    * @param index the wrapped future index
    */
  def isComplete(index: java.lang.Integer): java.lang.Boolean = {
    asJava.isComplete(index)
  }

  /**
    * Returns the result of a wrapped future
    * @param index the wrapped future index
    */
  def resultAt[T](index: java.lang.Integer): T = {
    asJava.resultAt[T](index)
  }

  /**
    * @return the number of wrapped future
    */
  def size(): java.lang.Integer = {
    asJava.size()
  }

  /**
    * @return an handler completing this future
    */
  def completer(): Handler[AsyncResult[JCompositeFuture]] = {
    asJava.completer()
  }

}

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.{Context => JContext}
import io.vertx.core.{Future => JFuture}
import io.vertx.core.Vertx
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import scala.collection.JavaConverters._
import io.vertx.core.Handler
import io.vertx.core.Future
import io.vertx.core.Context
import io.vertx.core.{Vertx => JVertx}

/**
  * The execution context of a scala-function execution.
  * 
  * When Vert.x provides an event to a handler or calls the start or stop methods of a [[io.vertx.lang.scala.ScalaVerticle]],
  * the execution is associated with a `Context`.
  * 
  * Usually a context is an *event-loop context* and is tied to a specific event loop thread. So executions for that
  * context always occur on that exact same event loop thread.
  * 
  * In the case of worker verticles and running inline blocking code a worker context will be associated with the execution
  * which will use a thread from the worker thread pool.
  * 
  * When a handler is set by a thread associated with a specific context, the Vert.x will guarantee that when that handler
  * is executed, that execution will be associated with the same context.
  * 
  * If a handler is set by a thread not associated with a context (i.e. a non Vert.x thread). Then a new context will
  * be created for that handler.
  * 
  * In other words, a context is propagated.
  * 
  * This means that when a verticle is deployed, any handlers it sets will be associated with the same context - the context
  * of the verticle.
  * 
  * This means (in the case of a standard verticle) that the verticle code will always be executed with the exact same
  * thread, so you don't have to worry about multi-threaded acccess to the verticle state and you can code your application
  * as single threaded.
  * 
  * This class also allows arbitrary data to be [[io.vertx.core.Context#put]] and [[io.vertx.core.Context#get]] on the context so it can be shared easily
  * amongst different handlers of, for example, a verticle instance.
  * 
  * This class also provides [[io.vertx.core.Context#runOnContext]] which allows an action to be executed asynchronously using the same context.
  */
implicit class ContextScala(val asJava: JContext) extends AnyVal {


  /**
    * Set an exception handler called when the context runs an action throwing an uncaught throwable.<p/>
    *
    * When this handler is called, [[io.vertx.core.Vertx#currentContext]] will return this context.
    * @param handler the exception handler
    * @return a reference to this, so the API can be used fluently
    */
  def exceptionHandler(handler: scala.Option[Throwable => Unit]): JContext = {
    asJava.exceptionHandler(handler match {case Some(t) => (p:Throwable) => t(p); case None => null})
  }

  /**
    * Run the specified action asynchronously on the same context, some time after the current execution has completed.
    * @param action the action to run
    */
  def runOnContext(action: Void => Unit): Unit = {
    asJava.runOnContext((p:Void) => action(p))
  }

  /**
    * Safely execute some blocking code.
    *
    * Executes the blocking code in the handler `blockingCodeHandler` using a thread from the worker pool.
    *
    * When the code is complete the returned Future will be completed with the result.
    *
    * @param blockingFunction function containing blocking code
    * @param ordered if true then if executeBlocking is called several times on the same context, the executions for that context will be executed serially, not in parallel. if false then they will be no ordering guarantees
    * @return a Future representing the result of the blocking operation
    */
  def executeBlocking[T](blockingFunction: () => T, ordered: Boolean = true): concurrent.Future[T] = {
    val promise = concurrent.Promise[T]
    val h: Handler[io.vertx.core.Future[T]] = {f => util.Try(blockingFunction()) match {
      case util.Success(s) => f.complete(s)
      case util.Failure(t) => f.fail(t)
    }}
    asJava.asInstanceOf[JContext].executeBlocking[T](h, ordered, {h:AsyncResult[T] => {if (h.succeeded()) promise.success(h.result()) else promise.failure(h.cause());()} })
    promise.future
  }

  /**
    * If the context is associated with a Verticle deployment, this returns the deployment ID of that deployment.
    * @return the deployment ID of the deployment or null if not a Verticle deployment
    */
  def deploymentID(): String = {
    asJava.deploymentID()
  }

  /**
    * If the context is associated with a Verticle deployment, this returns the configuration that was specified when
    * the verticle was deployed.
    * @return the configuration of the deployment or null if not a Verticle deployment
    */
  def config(): scala.Option[io.vertx.core.json.JsonObject] = {
    scala.Option(asJava.config())
  }

  /**
    * The process args
    */
  def processArgs(): List[String] = {
    asJava.processArgs().asScala.toList
  }

  /**
    * Is the current context an event loop context?
    * 
    * NOTE! when running blocking code using [[io.vertx.core.Vertx#executeBlockingFuture]] from a
    * standard (not worker) verticle, the context will still an event loop context and this 
    * will return true.
    * @return true if false otherwise
    */
  def isEventLoopContext(): java.lang.Boolean = {
    asJava.isEventLoopContext()
  }

  /**
    * Is the current context a worker context?
    * 
    * NOTE! when running blocking code using [[io.vertx.core.Vertx#executeBlockingFuture]] from a
    * standard (not worker) verticle, the context will still an event loop context and this 
    * will return false.
    * @return true if the current context is a worker context, false otherwise
    */
  def isWorkerContext(): java.lang.Boolean = {
    asJava.isWorkerContext()
  }

  /**
    * Is the current context a multi-threaded worker context?
    * @return true if the current context is a multi-threaded worker context, false otherwise
    */
  def isMultiThreadedWorkerContext(): java.lang.Boolean = {
    asJava.isMultiThreadedWorkerContext()
  }

  /**
    * Get some data from the context.
    * @param key the key of the data
    * @return the data
    */
  def get[T](key: String): T = {
    asJava.get[T](key)
  }

  /**
    * Put some data in the context.
    * 
    * This can be used to share data between different handlers that share a context
    * @param key the key of the data
    * @param value the data
    */
  def put(key: String, value: AnyRef): Unit = {
    asJava.put(key, value)
  }

  /**
    * Remove some data from the context.
    * @param key the key to remove
    * @return true if removed successfully, false otherwise
    */
  def remove(key: String): java.lang.Boolean = {
    asJava.remove(key)
  }

  /**
    * @return The Vertx instance that created the context
    */
  def owner(): JVertx = {
    asJava.owner()
  }

  /**
    * @return the number of instances of the verticle that were deployed in the deployment (if any) related to this context
    */
  def getInstanceCount(): java.lang.Integer = {
    asJava.getInstanceCount()
  }

}

import io.vertx.core.file.{CopyOptions => JCopyOptions}

/**
  * Describes the copy (and move) options.
  */

  implicit class CopyOptionsScala(val asJava: JCopyOptions) extends AnyVal {


  /**
    * Whether move should be performed as an atomic filesystem operation. Defaults to `false`.
    */
    def setAtomicMove(value: java.lang.Boolean) = {
      asJava.setAtomicMove(value)
    }
    def isAtomicMove: java.lang.Boolean = {
      asJava.isAtomicMove()
    }

  /**
    * Whether the file attributes should be copied. Defaults to `false`.
    */
    def setCopyAttributes(value: java.lang.Boolean) = {
      asJava.setCopyAttributes(value)
    }
    def isCopyAttributes: java.lang.Boolean = {
      asJava.isCopyAttributes()
    }

  /**
    * Whether symbolic links should not be followed during copy or move operations. Defaults to `false`.
    */
    def setNofollowLinks(value: java.lang.Boolean) = {
      asJava.setNofollowLinks(value)
    }
    def isNofollowLinks: java.lang.Boolean = {
      asJava.isNofollowLinks()
    }

  /**
    * Whether an existing file, empty directory, or link should be replaced. Defaults to `false`.
    */
    def setReplaceExisting(value: java.lang.Boolean) = {
      asJava.setReplaceExisting(value)
    }
    def isReplaceExisting: java.lang.Boolean = {
      asJava.isReplaceExisting()
    }
  }
  
  type CopyOptions = JCopyOptions
  object CopyOptions {
    def apply(): JCopyOptions = new CopyOptions()
    def apply(json: JsonObject) = new JCopyOptions(json)
  }


import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.shareddata.{Counter => JCounter}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler

/**
  * An asynchronous counter that can be used to across the cluster to maintain a consistent count.
  * 
  */
implicit class CounterScala(val asJava: JCounter) extends AnyVal {


  /**
    * Get the current value of the counter
    * @param resultHandler handler which will be passed the value
    */
  def get(resultHandler: AsyncResult[java.lang.Long] => Unit): Unit = {
    asJava.get((p:AsyncResult[java.lang.Long]) => resultHandler(p))
  }

  /**
    * Increment the counter atomically and return the new count
    * @param resultHandler handler which will be passed the value
    */
  def incrementAndGet(resultHandler: AsyncResult[java.lang.Long] => Unit): Unit = {
    asJava.incrementAndGet((p:AsyncResult[java.lang.Long]) => resultHandler(p))
  }

  /**
    * Increment the counter atomically and return the value before the increment.
    * @param resultHandler handler which will be passed the value
    */
  def getAndIncrement(resultHandler: AsyncResult[java.lang.Long] => Unit): Unit = {
    asJava.getAndIncrement((p:AsyncResult[java.lang.Long]) => resultHandler(p))
  }

  /**
    * Decrement the counter atomically and return the new count
    * @param resultHandler handler which will be passed the value
    */
  def decrementAndGet(resultHandler: AsyncResult[java.lang.Long] => Unit): Unit = {
    asJava.decrementAndGet((p:AsyncResult[java.lang.Long]) => resultHandler(p))
  }

  /**
    * Add the value to the counter atomically and return the new count
    * @param value the value to add
    * @param resultHandler handler which will be passed the value
    */
  def addAndGet(value: java.lang.Long, resultHandler: AsyncResult[java.lang.Long] => Unit): Unit = {
    asJava.addAndGet(value, (p:AsyncResult[java.lang.Long]) => resultHandler(p))
  }

  /**
    * Add the value to the counter atomically and return the value before the add
    * @param value the value to add
    * @param resultHandler handler which will be passed the value
    */
  def getAndAdd(value: java.lang.Long, resultHandler: AsyncResult[java.lang.Long] => Unit): Unit = {
    asJava.getAndAdd(value, (p:AsyncResult[java.lang.Long]) => resultHandler(p))
  }

  /**
    * Set the counter to the specified value only if the current value is the expectec value. This happens
    * atomically.
    * @param expected the expected value
    * @param value the new value
    * @param resultHandler the handler will be passed true on success
    */
  def compareAndSet(expected: java.lang.Long, value: java.lang.Long, resultHandler: AsyncResult[java.lang.Boolean] => Unit): Unit = {
    asJava.compareAndSet(expected, value, (p:AsyncResult[java.lang.Boolean]) => resultHandler(p))
  }

 /**
   * Like [[get]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def getFuture(): scala.concurrent.Future[java.lang.Long] = {
    val promise = Promise[java.lang.Long]()
    asJava.get({a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[incrementAndGet]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def incrementAndGetFuture(): scala.concurrent.Future[java.lang.Long] = {
    val promise = Promise[java.lang.Long]()
    asJava.incrementAndGet({a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[getAndIncrement]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def getAndIncrementFuture(): scala.concurrent.Future[java.lang.Long] = {
    val promise = Promise[java.lang.Long]()
    asJava.getAndIncrement({a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[decrementAndGet]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def decrementAndGetFuture(): scala.concurrent.Future[java.lang.Long] = {
    val promise = Promise[java.lang.Long]()
    asJava.decrementAndGet({a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[addAndGet]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def addAndGetFuture(value: java.lang.Long): scala.concurrent.Future[java.lang.Long] = {
    val promise = Promise[java.lang.Long]()
    asJava.addAndGet(value, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[getAndAdd]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def getAndAddFuture(value: java.lang.Long): scala.concurrent.Future[java.lang.Long] = {
    val promise = Promise[java.lang.Long]()
    asJava.getAndAdd(value, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[compareAndSet]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def compareAndSetFuture(expected: java.lang.Long, value: java.lang.Long): scala.concurrent.Future[java.lang.Boolean] = {
    val promise = Promise[java.lang.Boolean]()
    asJava.compareAndSet(expected, value, {a:AsyncResult[java.lang.Boolean] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

}

import io.vertx.core.buffer.Buffer
import io.vertx.core.net.{SocketAddress => JSocketAddress}
import io.vertx.core.datagram.{DatagramPacket => JDatagramPacket}
import io.vertx.core.net.SocketAddress

/**
  * A received datagram packet (UDP) which contains the data and information about the sender of the data itself.
  */
implicit class DatagramPacketScala(val asJava: JDatagramPacket) extends AnyVal {


  /**
    * Returns the [[io.vertx.core.net.SocketAddress]] of the sender that sent
    * this [[io.vertx.core.datagram.DatagramPacket]].
    * @return the address of the sender
    */
  def sender(): JSocketAddress = {
    asJava.sender()
  }

  /**
    * Returns the data of the [[io.vertx.core.datagram.DatagramPacket]]
    * @return the data
    */
  def data(): io.vertx.core.buffer.Buffer = {
    asJava.data()
  }

}

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.metrics.{Measured => JMeasured}
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.core.datagram.DatagramSocket
import io.vertx.core.datagram.{DatagramPacket => JDatagramPacket}
import io.vertx.core.streams.{WriteStream => JWriteStream}
import io.vertx.core.datagram.{DatagramSocket => JDatagramSocket}
import io.vertx.core.buffer.Buffer
import io.vertx.core.datagram.DatagramPacket
import io.vertx.core.metrics.Measured
import io.vertx.core.streams.WriteStream
import io.vertx.core.streams.ReadStream
import io.vertx.core.net.{SocketAddress => JSocketAddress}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.core.net.SocketAddress

/**
  * A datagram socket can be used to send [[io.vertx.core.datagram.DatagramPacket]]'s to remote datagram servers
  * and receive [[io.vertx.core.datagram.DatagramPacket]]s .
  * 
  * Usually you use a datagram socket to send UDP over the wire. UDP is connection-less which means you are not connected
  * to the remote peer in a persistent way. Because of this you have to supply the address and port of the remote peer
  * when sending data.
  * 
  * You can send data to ipv4 or ipv6 addresses, which also include multicast addresses.
  * 
  * Please consult the documentation for more information on datagram sockets.
  */
implicit class DatagramSocketScala(val asJava: JDatagramSocket) extends AnyVal {


  /**
    * Write the given [[io.vertx.core.buffer.Buffer]] to the [[io.vertx.core.net.SocketAddress]].
    * The scala-function will be notified once the write completes.
    * @param packet the io.vertx.core.buffer.Buffer to write
    * @param port the host port of the remote peer
    * @param host the host address of the remote peer
    * @param handler the scala-function to notify once the write completes.
    * @return a reference to this, so the API can be used fluently
    */
  def send(packet: io.vertx.core.buffer.Buffer, port: java.lang.Integer, host: String, handler: AsyncResult[JDatagramSocket] => Unit): JDatagramSocket = {
    asJava.send(packet, port, host, (p:AsyncResult[JDatagramSocket]) => handler(p))
  }

  /**
    * Write the given String to the [[io.vertx.core.net.SocketAddress]] using UTF8 encoding.
    * The  will be notified once the write completes.
    * @param str the String to write
    * @param port the host port of the remote peer
    * @param host the host address of the remote peer
    * @param handler the scala-function to notify once the write completes.
    * @return a reference to this, so the API can be used fluently
    */
  def send(str: String, port: java.lang.Integer, host: String, handler: AsyncResult[JDatagramSocket] => Unit): JDatagramSocket = {
    asJava.send(str, port, host, (p:AsyncResult[JDatagramSocket]) => handler(p))
  }

  /**
    * Write the given String to the [[io.vertx.core.net.SocketAddress]] using the given encoding.
    * The  will be notified once the write completes.
    * @param str the String to write
    * @param enc the charset used for encoding
    * @param port the host port of the remote peer
    * @param host the host address of the remote peer
    * @param handler the scala-function to notify once the write completes.
    * @return a reference to this, so the API can be used fluently
    */
  def send(str: String, enc: String, port: java.lang.Integer, host: String, handler: AsyncResult[JDatagramSocket] => Unit): JDatagramSocket = {
    asJava.send(str, enc, port, host, (p:AsyncResult[JDatagramSocket]) => handler(p))
  }

  /**
    * Joins a multicast group and listens for packets send to it.
    * The  is notified once the operation completes.
    * @param multicastAddress the address of the multicast group to join
    * @param handler then handler to notify once the operation completes
    * @return a reference to this, so the API can be used fluently
    */
  def listenMulticastGroup(multicastAddress: String, handler: AsyncResult[JDatagramSocket] => Unit): JDatagramSocket = {
    asJava.listenMulticastGroup(multicastAddress, (p:AsyncResult[JDatagramSocket]) => handler(p))
  }

  /**
    * Joins a multicast group and listens for packets send to it on the given network interface.
    * The  is notified once the operation completes.
    * @param multicastAddress the address of the multicast group to join
    * @param networkInterface the network interface on which to listen for packets.
    * @param source the address of the source for which we will listen for multicast packets
    * @param handler then handler to notify once the operation completes
    * @return a reference to this, so the API can be used fluently
    */
  def listenMulticastGroup(multicastAddress: String, networkInterface: String, source: scala.Option[String], handler: AsyncResult[JDatagramSocket] => Unit): JDatagramSocket = {
    asJava.listenMulticastGroup(multicastAddress, networkInterface, source.orNull, (p:AsyncResult[JDatagramSocket]) => handler(p))
  }

  /**
    * Leaves a multicast group and stops listening for packets send to it.
    * The  is notified once the operation completes.
    * @param multicastAddress the address of the multicast group to leave
    * @param handler then handler to notify once the operation completes
    * @return a reference to this, so the API can be used fluently
    */
  def unlistenMulticastGroup(multicastAddress: String, handler: AsyncResult[JDatagramSocket] => Unit): JDatagramSocket = {
    asJava.unlistenMulticastGroup(multicastAddress, (p:AsyncResult[JDatagramSocket]) => handler(p))
  }

  /**
    * Leaves a multicast group and stops listening for packets send to it on the given network interface.
    * The  is notified once the operation completes.
    * @param multicastAddress the address of the multicast group to join
    * @param networkInterface the network interface on which to listen for packets.
    * @param source the address of the source for which we will listen for multicast packets
    * @param handler the handler to notify once the operation completes
    * @return a reference to this, so the API can be used fluently
    */
  def unlistenMulticastGroup(multicastAddress: String, networkInterface: String, source: scala.Option[String], handler: AsyncResult[JDatagramSocket] => Unit): JDatagramSocket = {
    asJava.unlistenMulticastGroup(multicastAddress, networkInterface, source.orNull, (p:AsyncResult[JDatagramSocket]) => handler(p))
  }

  /**
    * Block the given address for the given multicast address and notifies the  once
    * the operation completes.
    * @param multicastAddress the address for which you want to block the source address
    * @param sourceToBlock the source address which should be blocked. You will not receive an multicast packets for it anymore.
    * @param handler the handler to notify once the operation completes
    * @return a reference to this, so the API can be used fluently
    */
  def blockMulticastGroup(multicastAddress: String, sourceToBlock: String, handler: AsyncResult[JDatagramSocket] => Unit): JDatagramSocket = {
    asJava.blockMulticastGroup(multicastAddress, sourceToBlock, (p:AsyncResult[JDatagramSocket]) => handler(p))
  }

  /**
    * Block the given address for the given multicast address on the given network interface and notifies
    * the  once the operation completes.
    * @param multicastAddress the address for which you want to block the source address
    * @param networkInterface the network interface on which the blocking should occur.
    * @param sourceToBlock the source address which should be blocked. You will not receive an multicast packets for it anymore.
    * @param handler the handler to notify once the operation completes
    * @return a reference to this, so the API can be used fluently
    */
  def blockMulticastGroup(multicastAddress: String, networkInterface: String, sourceToBlock: String, handler: AsyncResult[JDatagramSocket] => Unit): JDatagramSocket = {
    asJava.blockMulticastGroup(multicastAddress, networkInterface, sourceToBlock, (p:AsyncResult[JDatagramSocket]) => handler(p))
  }

  /**
    * Start listening on the given port and host. The handler will be called when the socket is listening.
    * @param port the port to listen on
    * @param host the host to listen on
    * @param handler the handler will be called when listening
    * @return a reference to this, so the API can be used fluently
    */
  def listen(port: java.lang.Integer, host: String, handler: AsyncResult[JDatagramSocket] => Unit): JDatagramSocket = {
    asJava.listen(port, host, (p:AsyncResult[JDatagramSocket]) => handler(p))
  }

  def pause(): JDatagramSocket = {
    asJava.pause()
  }

  def resume(): JDatagramSocket = {
    asJava.resume()
  }

  def endHandler(endHandler: scala.Option[Void => Unit]): JDatagramSocket = {
    asJava.endHandler(endHandler match {case Some(t) => (p:Void) => t(p); case None => null})
  }

  def handler(handler: scala.Option[JDatagramPacket => Unit]): JDatagramSocket = {
    asJava.handler(handler match {case Some(t) => (p:JDatagramPacket) => t(p); case None => null})
  }

  def exceptionHandler(handler: scala.Option[Throwable => Unit]): JDatagramSocket = {
    asJava.exceptionHandler(handler match {case Some(t) => (p:Throwable) => t(p); case None => null})
  }

  /**
    * Whether the metrics are enabled for this measured object
    * @return true if the metrics are enabled
    */
  def isMetricsEnabled(): java.lang.Boolean = {
    asJava.isMetricsEnabled()
  }

  /**
    * Returns a `WriteStream<Buffer>` able to send  to the
    * [[io.vertx.core.net.SocketAddress]].
    * @param port the port of the remote peer
    * @param host the host address of the remote peer
    * @return the write stream for sending packets
    */
  def sender(port: java.lang.Integer, host: String): JWriteStream[io.vertx.core.buffer.Buffer] = {
    asJava.sender(port, host)
  }

  /**
    * Closes the [[io.vertx.core.datagram.DatagramSocket]] implementation asynchronous
    * and notifies the handler once done.
    * @param handler the handler to notify once complete
    */
  def close(handler: AsyncResult[Void] => Unit): Unit = {
    asJava.close((p:AsyncResult[Void]) => handler(p))
  }

  /**
    * Closes the [[io.vertx.core.datagram.DatagramSocket]]. The close itself is asynchronous.
    */
  def close(): Unit = {
    asJava.close()
  }

  /**
    * Return the [[io.vertx.core.net.SocketAddress]] to which
    * this [[io.vertx.core.datagram.DatagramSocket]] is bound.
    * @return the socket address
    */
  def localAddress(): JSocketAddress = {
    asJava.localAddress()
  }

 /**
   * Like [[send]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def sendFuture(packet: io.vertx.core.buffer.Buffer, port: java.lang.Integer, host: String): scala.concurrent.Future[JDatagramSocket] = {
    val promise = Promise[JDatagramSocket]()
    asJava.send(packet, port, host, {a:AsyncResult[io.vertx.core.datagram.DatagramSocket] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[send]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def sendFuture(str: String, port: java.lang.Integer, host: String): scala.concurrent.Future[JDatagramSocket] = {
    val promise = Promise[JDatagramSocket]()
    asJava.send(str, port, host, {a:AsyncResult[io.vertx.core.datagram.DatagramSocket] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[send]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def sendFuture(str: String, enc: String, port: java.lang.Integer, host: String): scala.concurrent.Future[JDatagramSocket] = {
    val promise = Promise[JDatagramSocket]()
    asJava.send(str, enc, port, host, {a:AsyncResult[io.vertx.core.datagram.DatagramSocket] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
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

 /**
   * Like [[listenMulticastGroup]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def listenMulticastGroupFuture(multicastAddress: String): scala.concurrent.Future[JDatagramSocket] = {
    val promise = Promise[JDatagramSocket]()
    asJava.listenMulticastGroup(multicastAddress, {a:AsyncResult[io.vertx.core.datagram.DatagramSocket] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[listenMulticastGroup]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def listenMulticastGroupFuture(multicastAddress: String, networkInterface: String, source: scala.Option[String]): scala.concurrent.Future[JDatagramSocket] = {
    val promise = Promise[JDatagramSocket]()
    asJava.listenMulticastGroup(multicastAddress, networkInterface, source.orNull, {a:AsyncResult[io.vertx.core.datagram.DatagramSocket] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[unlistenMulticastGroup]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def unlistenMulticastGroupFuture(multicastAddress: String): scala.concurrent.Future[JDatagramSocket] = {
    val promise = Promise[JDatagramSocket]()
    asJava.unlistenMulticastGroup(multicastAddress, {a:AsyncResult[io.vertx.core.datagram.DatagramSocket] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[unlistenMulticastGroup]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def unlistenMulticastGroupFuture(multicastAddress: String, networkInterface: String, source: scala.Option[String]): scala.concurrent.Future[JDatagramSocket] = {
    val promise = Promise[JDatagramSocket]()
    asJava.unlistenMulticastGroup(multicastAddress, networkInterface, source.orNull, {a:AsyncResult[io.vertx.core.datagram.DatagramSocket] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[blockMulticastGroup]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def blockMulticastGroupFuture(multicastAddress: String, sourceToBlock: String): scala.concurrent.Future[JDatagramSocket] = {
    val promise = Promise[JDatagramSocket]()
    asJava.blockMulticastGroup(multicastAddress, sourceToBlock, {a:AsyncResult[io.vertx.core.datagram.DatagramSocket] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[blockMulticastGroup]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def blockMulticastGroupFuture(multicastAddress: String, networkInterface: String, sourceToBlock: String): scala.concurrent.Future[JDatagramSocket] = {
    val promise = Promise[JDatagramSocket]()
    asJava.blockMulticastGroup(multicastAddress, networkInterface, sourceToBlock, {a:AsyncResult[io.vertx.core.datagram.DatagramSocket] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[listen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def listenFuture(port: java.lang.Integer, host: String): scala.concurrent.Future[JDatagramSocket] = {
    val promise = Promise[JDatagramSocket]()
    asJava.listen(port, host, {a:AsyncResult[io.vertx.core.datagram.DatagramSocket] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

}

import io.vertx.core.datagram.{DatagramSocketOptions => JDatagramSocketOptions}
import io.vertx.core.net.{NetworkOptions => JNetworkOptions}
import io.vertx.core.net.NetworkOptions

/**
  * Options used to configure a datagram socket.
  */

  implicit class DatagramSocketOptionsScala(val asJava: JDatagramSocketOptions) extends AnyVal {


  /**
    * Set if the socket can send or receive broadcast packets
    */
    def setBroadcast(value: java.lang.Boolean) = {
      asJava.setBroadcast(value)
    }
    def isBroadcast: java.lang.Boolean = {
      asJava.isBroadcast()
    }

  /**
    * Set if IP v6 should be used
    */
    def setIpV6(value: java.lang.Boolean) = {
      asJava.setIpV6(value)
    }
    def isIpV6: java.lang.Boolean = {
      asJava.isIpV6()
    }

  /**
    * Set to true to enabled network activity logging: Netty's pipeline is configured for logging on Netty's logger.
    */
    def setLogActivity(value: java.lang.Boolean) = {
      asJava.setLogActivity(value)
    }
    def getLogActivity: java.lang.Boolean = {
      asJava.getLogActivity()
    }

  /**
    * Set if loopback mode is disabled
    */
    def setLoopbackModeDisabled(value: java.lang.Boolean) = {
      asJava.setLoopbackModeDisabled(value)
    }
    def isLoopbackModeDisabled: java.lang.Boolean = {
      asJava.isLoopbackModeDisabled()
    }

  /**
    * Set the multicast network interface address
    */
    def setMulticastNetworkInterface(value: String) = {
      asJava.setMulticastNetworkInterface(value)
    }
    def getMulticastNetworkInterface: String = {
      asJava.getMulticastNetworkInterface()
    }

  /**
    * Set the multicast ttl value
    */
    def setMulticastTimeToLive(value: java.lang.Integer) = {
      asJava.setMulticastTimeToLive(value)
    }
    def getMulticastTimeToLive: java.lang.Integer = {
      asJava.getMulticastTimeToLive()
    }

  /**
    * Set the TCP receive buffer size
    */
    def setReceiveBufferSize(value: java.lang.Integer) = {
      asJava.setReceiveBufferSize(value)
    }
    def getReceiveBufferSize: java.lang.Integer = {
      asJava.getReceiveBufferSize()
    }

  /**
    * Set the value of reuse address
    */
    def setReuseAddress(value: java.lang.Boolean) = {
      asJava.setReuseAddress(value)
    }
    def isReuseAddress: java.lang.Boolean = {
      asJava.isReuseAddress()
    }

  /**
    * Set the value of reuse port.
    * <p/>
    * This is only supported by native transports.
    */
    def setReusePort(value: java.lang.Boolean) = {
      asJava.setReusePort(value)
    }
    def isReusePort: java.lang.Boolean = {
      asJava.isReusePort()
    }

  /**
    * Set the TCP send buffer size
    */
    def setSendBufferSize(value: java.lang.Integer) = {
      asJava.setSendBufferSize(value)
    }
    def getSendBufferSize: java.lang.Integer = {
      asJava.getSendBufferSize()
    }

  /**
    * Set the value of traffic class
    */
    def setTrafficClass(value: java.lang.Integer) = {
      asJava.setTrafficClass(value)
    }
    def getTrafficClass: java.lang.Integer = {
      asJava.getTrafficClass()
    }
  }
  
  type DatagramSocketOptions = JDatagramSocketOptions
  object DatagramSocketOptions {
    def apply(): JDatagramSocketOptions = new DatagramSocketOptions()
    def apply(json: JsonObject) = new JDatagramSocketOptions(json)
  }


import io.vertx.core.eventbus.{DeliveryOptions => JDeliveryOptions}

/**
  * Delivery options are used to configure message delivery.
  * 
  * Delivery options allow to configure delivery timeout and message codec name, and to provide any headers
  * that you wish to send with the message.
  */

  implicit class DeliveryOptionsScala(val asJava: JDeliveryOptions) extends AnyVal {


  /**
    * Set the codec name.
    */
    def setCodecName(value: String) = {
      asJava.setCodecName(value)
    }
    def getCodecName: String = {
      asJava.getCodecName()
    }

  /**
    * Add a message header.
    * 
    * Message headers can be sent with any message and will be accessible with [[io.vertx.core.eventbus.Message]]
    * at the recipient.
    */
    def addHeader(key: String, value: String) = {
      asJava.addHeader(key, value)
    }

  /**
    * Set the send timeout.
    */
    def setSendTimeout(value: java.lang.Long) = {
      asJava.setSendTimeout(value)
    }
    def getSendTimeout: java.lang.Long = {
      asJava.getSendTimeout()
    }
  }
  
  type DeliveryOptions = JDeliveryOptions
  object DeliveryOptions {
    def apply(): JDeliveryOptions = new DeliveryOptions()
    def apply(json: JsonObject) = new JDeliveryOptions(json)
  }


import io.vertx.core.{DeploymentOptions => JDeploymentOptions}
import io.vertx.core.json.JsonObject

/**
  * Options for configuring a verticle deployment.
  * 
  */

  implicit class DeploymentOptionsScala(val asJava: JDeploymentOptions) extends AnyVal {


  /**
    * Set the JSON configuration that will be passed to the verticle(s) when it's deployed
    */
    def setConfig(value: io.vertx.core.json.JsonObject) = {
      asJava.setConfig(value)
    }
    def getConfig: io.vertx.core.json.JsonObject = {
      asJava.getConfig()
    }

  /**
    * Set any extra classpath to be used when deploying the verticle.
    * 
    * Ignored if no isolation group is set.
    */
    def setExtraClasspath(value: List[String]) = {
      asJava.setExtraClasspath(value.asJava)
      }
    def getExtraClasspath: scala.collection.mutable.Buffer[String] = {
      asJava.getExtraClasspath().asScala
    }

  /**
    * Set whether the verticle(s) will be deployed as HA.
    */
    def setHa(value: java.lang.Boolean) = {
      asJava.setHa(value)
    }
    def isHa: java.lang.Boolean = {
      asJava.isHa()
    }

  /**
    * Set the number of instances that should be deployed.
    */
    def setInstances(value: java.lang.Integer) = {
      asJava.setInstances(value)
    }
    def getInstances: java.lang.Integer = {
      asJava.getInstances()
    }

  /**
    * Set the isolated class names.
    */
    def setIsolatedClasses(value: List[String]) = {
      asJava.setIsolatedClasses(value.asJava)
      }
    def getIsolatedClasses: scala.collection.mutable.Buffer[String] = {
      asJava.getIsolatedClasses().asScala
    }

  /**
    * Set the isolation group that will be used when deploying the verticle(s)
    */
    def setIsolationGroup(value: String) = {
      asJava.setIsolationGroup(value)
    }
    def getIsolationGroup: String = {
      asJava.getIsolationGroup()
    }

  /**
    * Sets the value of max worker execute time, in ns.
    */
    def setMaxWorkerExecuteTime(value: java.lang.Long) = {
      asJava.setMaxWorkerExecuteTime(value)
    }
    def getMaxWorkerExecuteTime: java.lang.Long = {
      asJava.getMaxWorkerExecuteTime()
    }

  /**
    * Set whether the verticle(s) should be deployed as a multi-threaded worker verticle
    */
    def setMultiThreaded(value: java.lang.Boolean) = {
      asJava.setMultiThreaded(value)
    }
    def isMultiThreaded: java.lang.Boolean = {
      asJava.isMultiThreaded()
    }

  /**
    * Set whether the verticle(s) should be deployed as a worker verticle
    */
    def setWorker(value: java.lang.Boolean) = {
      asJava.setWorker(value)
    }
    def isWorker: java.lang.Boolean = {
      asJava.isWorker()
    }

  /**
    * Set the worker pool name to use for this verticle. When no name is set, the Vert.x
    * worker pool will be used, when a name is set, the verticle will use a named worker pool.
    */
    def setWorkerPoolName(value: String) = {
      asJava.setWorkerPoolName(value)
    }
    def getWorkerPoolName: String = {
      asJava.getWorkerPoolName()
    }

  /**
    * Set the maximum number of worker threads to be used by the Vert.x instance.
    */
    def setWorkerPoolSize(value: java.lang.Integer) = {
      asJava.setWorkerPoolSize(value)
    }
    def getWorkerPoolSize: java.lang.Integer = {
      asJava.getWorkerPoolSize()
    }
  }
  
  type DeploymentOptions = JDeploymentOptions
  object DeploymentOptions {
    def apply(): JDeploymentOptions = new DeploymentOptions()
    def apply(json: JsonObject) = new JDeploymentOptions(json)
  }


import io.vertx.core.dns.DnsClient
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.dns.{DnsClient => JDnsClient}
import io.vertx.core.dns.MxRecord
import io.vertx.core.dns.{SrvRecord => JSrvRecord}
import io.vertx.core.AsyncResult
import scala.collection.JavaConverters._
import io.vertx.core.Handler
import io.vertx.core.dns.{MxRecord => JMxRecord}
import io.vertx.core.dns.SrvRecord

/**
  * Provides a way to asynchronously lookup information from DNS servers.
  * 
  * Please consult the documentation for more information on DNS clients.
  */
implicit class DnsClientScala(val asJava: JDnsClient) extends AnyVal {


  /**
    * Try to lookup the A (ipv4) or AAAA (ipv6) record for the given name. The first found will be used.
    * @param name the name to resolve
    * @param handler the scala-function to notify with the io.vertx.lang.scala.AsyncResult. The handler will get notified with the resolved address if a record was found. If non was found it will get notifed with `null`. If an error accours it will get failed.
    * @return a reference to this, so the API can be used fluently
    */
  def lookup(name: String, handler: AsyncResult[scala.Option[String]] => Unit): JDnsClient = {
    asJava.lookup(name, (p:AsyncResult[scala.Option[String]]) => handler(p))
  }

  /**
    * Try to lookup the A (ipv4) record for the given name. The first found will be used.
    * @param name the name to resolve
    * @param handler the scala-function to notify with the io.vertx.lang.scala.AsyncResult. The handler will get notified with the resolved java.net.Inet4Address if a record was found. If non was found it will get notifed with `null`. If an error accours it will get failed.
    * @return a reference to this, so the API can be used fluently
    */
  def lookup4(name: String, handler: AsyncResult[scala.Option[String]] => Unit): JDnsClient = {
    asJava.lookup4(name, (p:AsyncResult[scala.Option[String]]) => handler(p))
  }

  /**
    * Try to lookup the AAAA (ipv6) record for the given name. The first found will be used.
    * @param name the name to resolve
    * @param handler the scala-function to notify with the io.vertx.lang.scala.AsyncResult. The handler will get notified with the resolved java.net.Inet6Address if a record was found. If non was found it will get notifed with `null`. If an error accours it will get failed.
    * @return a reference to this, so the API can be used fluently
    */
  def lookup6(name: String, handler: AsyncResult[scala.Option[String]] => Unit): JDnsClient = {
    asJava.lookup6(name, (p:AsyncResult[scala.Option[String]]) => handler(p))
  }

  /**
    * Try to resolve all A (ipv4) records for the given name.
    * @param name the name to resolve
    * @param handler the scala-function to notify with the io.vertx.lang.scala.AsyncResult. The handler will get notified with a scala.collection.immutable.List that contains all the resolved java.net.Inet4Addresses. If none was found an empty scala.collection.immutable.List will be used. If an error accours it will get failed.
    * @return a reference to this, so the API can be used fluently
    */
  def resolveA(name: String, handler: AsyncResult[List[String]] => Unit): JDnsClient = {
    asJava.resolveA(name, (p:AsyncResult[List[String]]) => handler(p))
  }

  /**
    * Try to resolve all AAAA (ipv6) records for the given name.
    * @param name the name to resolve
    * @param handler the scala-function to notify with the io.vertx.lang.scala.AsyncResult. The handler will get notified with a scala.collection.immutable.List that contains all the resolved java.net.Inet6Addresses. If none was found an empty scala.collection.immutable.List will be used. If an error accours it will get failed.
    * @return a reference to this, so the API can be used fluently
    */
  def resolveAAAA(name: String, handler: AsyncResult[List[String]] => Unit): JDnsClient = {
    asJava.resolveAAAA(name, (p:AsyncResult[List[String]]) => handler(p))
  }

  /**
    * Try to resolve the CNAME record for the given name.
    * @param name the name to resolve the CNAME for
    * @param handler the scala-function to notify with the io.vertx.lang.scala.AsyncResult. The handler will get notified with the resolved String if a record was found. If none was found it will get notified with `null`. If an error accours it will get failed.
    * @return a reference to this, so the API can be used fluently.
    */
  def resolveCNAME(name: String, handler: AsyncResult[List[String]] => Unit): JDnsClient = {
    asJava.resolveCNAME(name, (p:AsyncResult[List[String]]) => handler(p))
  }

  /**
    * Try to resolve the MX records for the given name.
    * @param name the name for which the MX records should be resolved
    * @param handler the scala-function to notify with the io.vertx.lang.scala.AsyncResult. The handler will get notified with a List that contains all resolved MxRecords, sorted by their MxRecord#priority(). If non was found it will get notified with an empty scala.collection.immutable.List. If an error accours it will get failed.
    * @return a reference to this, so the API can be used fluently.
    */
  def resolveMX(name: String, handler: AsyncResult[List[JMxRecord]] => Unit): JDnsClient = {
    asJava.resolveMX(name, (p:AsyncResult[List[JMxRecord]]) => handler(p))
  }

  /**
    * Try to resolve the TXT records for the given name.
    * @param name the name for which the TXT records should be resolved
    * @param handler the scala-function to notify with the io.vertx.lang.scala.AsyncResult. The handler will get notified with a List that contains all resolved Strings. If none was found it will get notified with an empty scala.collection.immutable.List. If an error accours it will get failed.
    * @return a reference to this, so the API can be used fluently.
    */
  def resolveTXT(name: String, handler: AsyncResult[List[String]] => Unit): JDnsClient = {
    asJava.resolveTXT(name, (p:AsyncResult[List[String]]) => handler(p))
  }

  /**
    * Try to resolve the PTR record for the given name.
    * @param name the name to resolve the PTR for
    * @param handler the scala-function to notify with the io.vertx.lang.scala.AsyncResult. The handler will get notified with the resolved String if a record was found. If none was found it will get notified with `null`. If an error accours it will get failed.
    * @return a reference to this, so the API can be used fluently.
    */
  def resolvePTR(name: String, handler: AsyncResult[scala.Option[String]] => Unit): JDnsClient = {
    asJava.resolvePTR(name, (p:AsyncResult[scala.Option[String]]) => handler(p))
  }

  /**
    * Try to resolve the NS records for the given name.
    * @param name the name for which the NS records should be resolved
    * @param handler the scala-function to notify with the io.vertx.lang.scala.AsyncResult. The handler will get notified with a List that contains all resolved Strings. If none was found it will get notified with an empty scala.collection.immutable.List. If an error accours it will get failed.
    * @return a reference to this, so the API can be used fluently.
    */
  def resolveNS(name: String, handler: AsyncResult[List[String]] => Unit): JDnsClient = {
    asJava.resolveNS(name, (p:AsyncResult[List[String]]) => handler(p))
  }

  /**
    * Try to resolve the SRV records for the given name.
    * @param name the name for which the SRV records should be resolved
    * @param handler the scala-function to notify with the io.vertx.lang.scala.AsyncResult. The handler will get notified with a List that contains all resolved SrvRecords. If none was found it will get notified with an empty scala.collection.immutable.List. If an error accours it will get failed.
    * @return a reference to this, so the API can be used fluently.
    */
  def resolveSRV(name: String, handler: AsyncResult[List[JSrvRecord]] => Unit): JDnsClient = {
    asJava.resolveSRV(name, (p:AsyncResult[List[JSrvRecord]]) => handler(p))
  }

  /**
    * Try to do a reverse lookup of an IP address. This is basically the same as doing trying to resolve a PTR record
    * but allows you to just pass in the IP address and not a valid ptr query string.
    * @param ipaddress the IP address to resolve the PTR for
    * @param handler the scala-function to notify with the io.vertx.lang.scala.AsyncResult. The handler will get notified with the resolved String if a record was found. If none was found it will get notified with `null`. If an error accours it will get failed.
    * @return a reference to this, so the API can be used fluently.
    */
  def reverseLookup(ipaddress: String, handler: AsyncResult[scala.Option[String]] => Unit): JDnsClient = {
    asJava.reverseLookup(ipaddress, (p:AsyncResult[scala.Option[String]]) => handler(p))
  }

 /**
   * Like [[lookup]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def lookupFuture(name: String): scala.concurrent.Future[scala.Option[String]] = {
    val promise = Promise[scala.Option[String]]()
    asJava.lookup(name, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()));()})
    promise.future
  }

 /**
   * Like [[lookup4]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def lookup4Future(name: String): scala.concurrent.Future[scala.Option[String]] = {
    val promise = Promise[scala.Option[String]]()
    asJava.lookup4(name, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()));()})
    promise.future
  }

 /**
   * Like [[lookup6]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def lookup6Future(name: String): scala.concurrent.Future[scala.Option[String]] = {
    val promise = Promise[scala.Option[String]]()
    asJava.lookup6(name, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()));()})
    promise.future
  }

 /**
   * Like [[resolveA]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def resolveAFuture(name: String): scala.concurrent.Future[List[String]] = {
    val promise = Promise[List[String]]()
    asJava.resolveA(name, {a:AsyncResult[java.util.List[java.lang.String]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.toList);()})
    promise.future
  }

 /**
   * Like [[resolveAAAA]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def resolveAAAAFuture(name: String): scala.concurrent.Future[List[String]] = {
    val promise = Promise[List[String]]()
    asJava.resolveAAAA(name, {a:AsyncResult[java.util.List[java.lang.String]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.toList);()})
    promise.future
  }

 /**
   * Like [[resolveCNAME]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def resolveCNAMEFuture(name: String): scala.concurrent.Future[List[String]] = {
    val promise = Promise[List[String]]()
    asJava.resolveCNAME(name, {a:AsyncResult[java.util.List[java.lang.String]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.toList);()})
    promise.future
  }

 /**
   * Like [[resolveMX]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def resolveMXFuture(name: String): scala.concurrent.Future[List[JMxRecord]] = {
    val promise = Promise[List[JMxRecord]]()
    asJava.resolveMX(name, {a:AsyncResult[java.util.List[io.vertx.core.dns.MxRecord]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.toList);()})
    promise.future
  }

 /**
   * Like [[resolveTXT]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def resolveTXTFuture(name: String): scala.concurrent.Future[List[String]] = {
    val promise = Promise[List[String]]()
    asJava.resolveTXT(name, {a:AsyncResult[java.util.List[java.lang.String]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.toList);()})
    promise.future
  }

 /**
   * Like [[resolvePTR]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def resolvePTRFuture(name: String): scala.concurrent.Future[scala.Option[String]] = {
    val promise = Promise[scala.Option[String]]()
    asJava.resolvePTR(name, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()));()})
    promise.future
  }

 /**
   * Like [[resolveNS]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def resolveNSFuture(name: String): scala.concurrent.Future[List[String]] = {
    val promise = Promise[List[String]]()
    asJava.resolveNS(name, {a:AsyncResult[java.util.List[java.lang.String]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.toList);()})
    promise.future
  }

 /**
   * Like [[resolveSRV]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def resolveSRVFuture(name: String): scala.concurrent.Future[List[JSrvRecord]] = {
    val promise = Promise[List[JSrvRecord]]()
    asJava.resolveSRV(name, {a:AsyncResult[java.util.List[io.vertx.core.dns.SrvRecord]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.toList);()})
    promise.future
  }

 /**
   * Like [[reverseLookup]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def reverseLookupFuture(ipaddress: String): scala.concurrent.Future[scala.Option[String]] = {
    val promise = Promise[scala.Option[String]]()
    asJava.reverseLookup(ipaddress, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()));()})
    promise.future
  }

}

import io.vertx.core.dns.{DnsClientOptions => JDnsClientOptions}

/**
  * Configuration options for Vert.x DNS client.
  */

  implicit class DnsClientOptionsScala(val asJava: JDnsClientOptions) extends AnyVal {


  /**
    * Set the host name to be used by this client in requests.
    */
    def setHost(value: String) = {
      asJava.setHost(value)
    }
    def getHost: String = {
      asJava.getHost()
    }

  /**
    * Set the port to be used by this client in requests.
    */
    def setPort(value: java.lang.Integer) = {
      asJava.setPort(value)
    }
    def getPort: java.lang.Integer = {
      asJava.getPort()
    }

  /**
    * Set the query timeout in milliseconds, i.e the amount of time after a query is considered to be failed.
    */
    def setQueryTimeout(value: java.lang.Long) = {
      asJava.setQueryTimeout(value)
    }
    def getQueryTimeout: java.lang.Long = {
      asJava.getQueryTimeout()
    }
  }
  
  type DnsClientOptions = JDnsClientOptions
  object DnsClientOptions {
    def apply(): JDnsClientOptions = new DnsClientOptions()
    def apply(json: JsonObject) = new JDnsClientOptions(json)
  }


import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.metrics.{Measured => JMeasured}
import io.vertx.core.eventbus.DeliveryOptions
import io.vertx.core.eventbus.{DeliveryOptions => JDeliveryOptions}
import io.vertx.core.eventbus.Message
import io.vertx.core.eventbus.{MessageConsumer => JMessageConsumer}
import io.vertx.core.eventbus.EventBus
import io.vertx.core.metrics.Measured
import io.vertx.core.eventbus.{SendContext => JSendContext}
import io.vertx.core.eventbus.{Message => JMessage}
import io.vertx.core.eventbus.{MessageProducer => JMessageProducer}
import io.vertx.core.eventbus.SendContext
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.core.eventbus.MessageConsumer
import io.vertx.core.eventbus.MessageProducer
import io.vertx.core.eventbus.{EventBus => JEventBus}

/**
  * A Vert.x event-bus is a light-weight distributed messaging system which allows different parts of your application,
  * or different applications and services to communicate with each in a loosely coupled way.
  * 
  * An event-bus supports publish-subscribe messaging, point-to-point messaging and request-response messaging.
  * 
  * Message delivery is best-effort and messages can be lost if failure of all or part of the event bus occurs.
  * 
  * Please refer to the documentation for more information on the event bus.
  */
implicit class EventBusScala(val asJava: JEventBus) extends AnyVal {


  /**
    * Sends a message.
    * 
    * The message will be delivered to at most one of the handlers registered to the address.
    * @param address the address to send it to
    * @param message the message, may be `null`
    * @return a reference to this, so the API can be used fluently
    */
  def send(address: String, message: AnyRef): JEventBus = {
    asJava.send(address, message)
  }

  /**
    * Like [[io.vertx.core.eventbus.EventBus#send]] but specifying a `replyHandler` that will be called if the recipient
    * subsequently replies to the message.
    * @param address the address to send it to
    * @param message the message, may be `null`
    * @param replyHandler reply handler will be called when any reply from the recipient is received, may be `null`
    * @return a reference to this, so the API can be used fluently
    */
  def send[T](address: String, message: AnyRef, replyHandler: AsyncResult[JMessage[T]] => Unit): JEventBus = {
    asJava.send[T](address, message, (p:AsyncResult[JMessage[T]]) => replyHandler(p))
  }

  /**
    * Like [[io.vertx.core.eventbus.EventBus#send]] but specifying `options` that can be used to configure the delivery.
    * @param address the address to send it to
    * @param message the message, may be `null`
    * @param options delivery optionssee <a href="../../../../../../../cheatsheet/DeliveryOptions.html">DeliveryOptions</a>
    * @return a reference to this, so the API can be used fluently
    */
  def send(address: String, message: AnyRef, options: JDeliveryOptions): JEventBus = {
    asJava.send(address, message, options.asJava)
  }

  /**
    * Like [[io.vertx.core.eventbus.EventBus#send]] but specifying a `replyHandler` that will be called if the recipient
    * subsequently replies to the message.
    * @param address the address to send it to
    * @param message the message, may be `null`
    * @param options delivery optionssee <a href="../../../../../../../cheatsheet/DeliveryOptions.html">DeliveryOptions</a>
    * @param replyHandler reply handler will be called when any reply from the recipient is received, may be `null`
    * @return a reference to this, so the API can be used fluently
    */
  def send[T](address: String, message: AnyRef, options: JDeliveryOptions, replyHandler: AsyncResult[JMessage[T]] => Unit): JEventBus = {
    asJava.send[T](address, message, options.asJava, (p:AsyncResult[JMessage[T]]) => replyHandler(p))
  }

  /**
    * Publish a message.
    * The message will be delivered to all handlers registered to the address.
    * @param address the address to publish it to
    * @param message the message, may be `null`
    * @return a reference to this, so the API can be used fluently
    */
  def publish(address: String, message: AnyRef): JEventBus = {
    asJava.publish(address, message)
  }

  /**
    * Like [[io.vertx.core.eventbus.EventBus#publish]] but specifying `options` that can be used to configure the delivery.
    * @param address the address to publish it to
    * @param message the message, may be `null`
    * @param options the delivery optionssee <a href="../../../../../../../cheatsheet/DeliveryOptions.html">DeliveryOptions</a>
    * @return a reference to this, so the API can be used fluently
    */
  def publish(address: String, message: AnyRef, options: JDeliveryOptions): JEventBus = {
    asJava.publish(address, message, options.asJava)
  }

  /**
    * Whether the metrics are enabled for this measured object
    * @return true if the metrics are enabled
    */
  def isMetricsEnabled(): java.lang.Boolean = {
    asJava.isMetricsEnabled()
  }

  /**
    * Create a message consumer against the specified address.
    * 
    * The returned consumer is not yet registered
    * at the address, registration will be effective when [[io.vertx.core.eventbus.MessageConsumer#handler]]
    * is called.
    * @param address the address that it will register it at
    * @return the event bus message consumer
    */
  def consumer[T](address: String): JMessageConsumer[T] = {
    asJava.consumer[T](address)
  }

  /**
    * Create a consumer and register it against the specified address.
    * @param address the address that will register it at
    * @param handler the handler that will process the received messages
    * @return the event bus message consumer
    */
  def consumer[T](address: String, handler: JMessage[T] => Unit): JMessageConsumer[T] = {
    asJava.consumer[T](address, (p:JMessage[T]) => handler(p))
  }

  /**
    * Like [[io.vertx.core.eventbus.EventBus#consumer]] but the address won't be propagated across the cluster.
    * @param address the address to register it at
    * @return the event bus message consumer
    */
  def localConsumer[T](address: String): JMessageConsumer[T] = {
    asJava.localConsumer[T](address)
  }

  /**
    * Like [[io.vertx.core.eventbus.EventBus#consumer]] but the address won't be propagated across the cluster.
    * @param address the address that will register it at
    * @param handler the handler that will process the received messages
    * @return the event bus message consumer
    */
  def localConsumer[T](address: String, handler: JMessage[T] => Unit): JMessageConsumer[T] = {
    asJava.localConsumer[T](address, (p:JMessage[T]) => handler(p))
  }

  /**
    * Create a message sender against the specified address.
    * 
    * The returned sender will invoke the [[io.vertx.core.eventbus.EventBus#send]]
    * method when the stream [[io.vertx.core.streams.WriteStream#write]] method is called with the sender
    * address and the provided data.
    * @param address the address to send it to
    * @return The sender
    */
  def sender[T](address: String): JMessageProducer[T] = {
    asJava.sender[T](address)
  }

  /**
    * Like [[io.vertx.core.eventbus.EventBus#sender]] but specifying delivery options that will be used for configuring the delivery of
    * the message.
    * @param address the address to send it to
    * @param options the delivery optionssee <a href="../../../../../../../cheatsheet/DeliveryOptions.html">DeliveryOptions</a>
    * @return The sender
    */
  def sender[T](address: String, options: JDeliveryOptions): JMessageProducer[T] = {
    asJava.sender[T](address, options.asJava)
  }

  /**
    * Create a message publisher against the specified address.
    * 
    * The returned publisher will invoke the [[io.vertx.core.eventbus.EventBus#publish]]
    * method when the stream [[io.vertx.core.streams.WriteStream#write]] method is called with the publisher
    * address and the provided data.
    * @param address The address to publish it to
    * @return The publisher
    */
  def publisher[T](address: String): JMessageProducer[T] = {
    asJava.publisher[T](address)
  }

  /**
    * Like [[io.vertx.core.eventbus.EventBus#publisher]] but specifying delivery options that will be used for configuring the delivery of
    * the message.
    * @param address the address to publish it to
    * @param options the delivery optionssee <a href="../../../../../../../cheatsheet/DeliveryOptions.html">DeliveryOptions</a>
    * @return The publisher
    */
  def publisher[T](address: String, options: JDeliveryOptions): JMessageProducer[T] = {
    asJava.publisher[T](address, options.asJava)
  }

 /**
   * Like [[send]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def sendFuture[T](address: String, message: AnyRef): scala.concurrent.Future[JMessage[T]] = {
    val promise = Promise[JMessage[T]]()
    asJava.send[T](address, message, {a:AsyncResult[io.vertx.core.eventbus.Message[T]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[send]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def sendFuture[T](address: String, message: AnyRef, options: JDeliveryOptions): scala.concurrent.Future[JMessage[T]] = {
    val promise = Promise[JMessage[T]]()
    asJava.send[T](address, message, options, {a:AsyncResult[io.vertx.core.eventbus.Message[T]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

}

import io.vertx.core.eventbus.{EventBusOptions => JEventBusOptions}
import io.vertx.core.net.JksOptions
import io.vertx.core.net.{PfxOptions => JPfxOptions}
import io.vertx.core.net.PfxOptions
import io.vertx.core.net.OpenSSLEngineOptions
import io.vertx.core.buffer.Buffer
import io.vertx.core.net.{OpenSSLEngineOptions => JOpenSSLEngineOptions}
import io.vertx.core.net.PemKeyCertOptions
import io.vertx.core.http.ClientAuth
import io.vertx.core.net.{JdkSSLEngineOptions => JJdkSSLEngineOptions}
import io.vertx.core.net.{PemTrustOptions => JPemTrustOptions}
import io.vertx.core.net.{TCPSSLOptions => JTCPSSLOptions}
import io.vertx.core.net.{PemKeyCertOptions => JPemKeyCertOptions}
import io.vertx.core.net.PemTrustOptions
import io.vertx.core.net.JdkSSLEngineOptions
import io.vertx.core.net.{JksOptions => JJksOptions}
import io.vertx.core.net.TCPSSLOptions

/**
  * Options to configure the event bus.
  */

  implicit class EventBusOptionsScala(val asJava: JEventBusOptions) extends AnyVal {


  /**
    * Set the accept back log.
    */
    def setAcceptBacklog(value: java.lang.Integer) = {
      asJava.setAcceptBacklog(value)
    }
    def getAcceptBacklog: java.lang.Integer = {
      asJava.getAcceptBacklog()
    }

  /**
    * Set whether client auth is required
    */
    def setClientAuth(value: io.vertx.core.http.ClientAuth) = {
      asJava.setClientAuth(value)
    }
    def getClientAuth: io.vertx.core.http.ClientAuth = {
      asJava.getClientAuth()
    }

  /**
    * Set the value of cluster ping interval, in ms.
    */
    def setClusterPingInterval(value: java.lang.Long) = {
      asJava.setClusterPingInterval(value)
    }
    def getClusterPingInterval: java.lang.Long = {
      asJava.getClusterPingInterval()
    }

  /**
    * Set the value of cluster ping reply interval, in ms.
    */
    def setClusterPingReplyInterval(value: java.lang.Long) = {
      asJava.setClusterPingReplyInterval(value)
    }
    def getClusterPingReplyInterval: java.lang.Long = {
      asJava.getClusterPingReplyInterval()
    }

  /**
    * Set the public facing hostname to be used for clustering.
    * Sometimes, e.g. when running on certain clouds, the local address the server listens on for clustering is
    * not the same address that other nodes connect to it at, as the OS / cloud infrastructure does some kind of
    * proxying. If this is the case you can specify a public hostname which is different from the hostname the
    * server listens at.
    * 
    * The default value is null which means use the same as the cluster hostname.
    */
    def setClusterPublicHost(value: String) = {
      asJava.setClusterPublicHost(value)
    }
    def getClusterPublicHost: String = {
      asJava.getClusterPublicHost()
    }

  /**
    * See <a href="../../../../../../../cheatsheet/EventBusOptions.html">EventBusOptions</a> for an explanation.
    */
    def setClusterPublicPort(value: java.lang.Integer) = {
      asJava.setClusterPublicPort(value)
    }
    def getClusterPublicPort: java.lang.Integer = {
      asJava.getClusterPublicPort()
    }

  /**
    * Sets whether or not the event bus is clustered.
    */
    def setClustered(value: java.lang.Boolean) = {
      asJava.setClustered(value)
    }
    def isClustered: java.lang.Boolean = {
      asJava.isClustered()
    }

  /**
    * Sets the connect timeout
    */
    def setConnectTimeout(value: java.lang.Integer) = {
      asJava.setConnectTimeout(value)
    }
    def getConnectTimeout: java.lang.Integer = {
      asJava.getConnectTimeout()
    }

  /**
    * Add a CRL path
    */
    def addCrlPath(value: String) = {
      asJava.addCrlPath(value)
      }
    def getCrlPaths: scala.collection.mutable.Buffer[String] = {
      asJava.getCrlPaths().asScala
    }

  /**
    * Add a CRL value
    */
    def addCrlValue(value: io.vertx.core.buffer.Buffer) = {
      asJava.addCrlValue(value)
      }
    def getCrlValues: scala.collection.mutable.Buffer[io.vertx.core.buffer.Buffer] = {
      asJava.getCrlValues().asScala
    }

  /**
    * Add an enabled cipher suite, appended to the ordered suites.
    */
    def addEnabledCipherSuite(value: String) = {
      asJava.addEnabledCipherSuite(value)
      }
    def getEnabledCipherSuites: scala.collection.mutable.Set[String] = {
      asJava.getEnabledCipherSuites().asScala
    }

  /**
    * Sets the list of enabled SSL/TLS protocols.
    */
    def addEnabledSecureTransportProtocol(value: String) = {
      asJava.addEnabledSecureTransportProtocol(value)
      }
    def setEnabledSecureTransportProtocols(value: Set[String]) = {
      asJava.setEnabledSecureTransportProtocols(value.asJava)
    }
    def getEnabledSecureTransportProtocols: scala.collection.mutable.Set[String] = {
      asJava.getEnabledSecureTransportProtocols().asScala
    }

  /**
    * Sets the host.
    */
    def setHost(value: String) = {
      asJava.setHost(value)
    }
    def getHost: String = {
      asJava.getHost()
    }

  /**
    * Set the idle timeout, in seconds. zero means don't timeout.
    * This determines if a connection will timeout and be closed if no data is received within the timeout.
    */
    def setIdleTimeout(value: java.lang.Integer) = {
      asJava.setIdleTimeout(value)
    }
    def getIdleTimeout: java.lang.Integer = {
      asJava.getIdleTimeout()
    }
    def setJdkSslEngineOptions(value: JJdkSSLEngineOptions) = {
      asJava.setJdkSslEngineOptions(value.asJava)
    }
    def getJdkSslEngineOptions: JJdkSSLEngineOptions = {
      asJava.getJdkSslEngineOptions()
    }

  /**
    * Set the key/cert options in jks format, aka Java keystore.
    */
    def setKeyStoreOptions(value: JJksOptions) = {
      asJava.setKeyStoreOptions(value.asJava)
    }
    def getKeyStoreOptions: JJksOptions = {
      asJava.getKeyStoreOptions()
    }

  /**
    * Set to true to enabled network activity logging: Netty's pipeline is configured for logging on Netty's logger.
    */
    def setLogActivity(value: java.lang.Boolean) = {
      asJava.setLogActivity(value)
    }
    def getLogActivity: java.lang.Boolean = {
      asJava.getLogActivity()
    }
    def setOpenSslEngineOptions(value: JOpenSSLEngineOptions) = {
      asJava.setOpenSslEngineOptions(value.asJava)
    }
    def getOpenSslEngineOptions: JOpenSSLEngineOptions = {
      asJava.getOpenSslEngineOptions()
    }

  /**
    * Set the key/cert store options in pem format.
    */
    def setPemKeyCertOptions(value: JPemKeyCertOptions) = {
      asJava.setPemKeyCertOptions(value.asJava)
    }
    def getPemKeyCertOptions: JPemKeyCertOptions = {
      asJava.getPemKeyCertOptions()
    }

  /**
    * Set the trust options in pem format
    */
    def setPemTrustOptions(value: JPemTrustOptions) = {
      asJava.setPemTrustOptions(value.asJava)
    }
    def getPemTrustOptions: JPemTrustOptions = {
      asJava.getPemTrustOptions()
    }

  /**
    * Set the key/cert options in pfx format.
    */
    def setPfxKeyCertOptions(value: JPfxOptions) = {
      asJava.setPfxKeyCertOptions(value.asJava)
    }
    def getPfxKeyCertOptions: JPfxOptions = {
      asJava.getPfxKeyCertOptions()
    }

  /**
    * Set the trust options in pfx format
    */
    def setPfxTrustOptions(value: JPfxOptions) = {
      asJava.setPfxTrustOptions(value.asJava)
    }
    def getPfxTrustOptions: JPfxOptions = {
      asJava.getPfxTrustOptions()
    }

  /**
    * Sets the port.
    */
    def setPort(value: java.lang.Integer) = {
      asJava.setPort(value)
    }
    def getPort: java.lang.Integer = {
      asJava.getPort()
    }

  /**
    * Set the TCP receive buffer size
    */
    def setReceiveBufferSize(value: java.lang.Integer) = {
      asJava.setReceiveBufferSize(value)
    }
    def getReceiveBufferSize: java.lang.Integer = {
      asJava.getReceiveBufferSize()
    }

  /**
    * Sets the value of reconnect attempts.
    */
    def setReconnectAttempts(value: java.lang.Integer) = {
      asJava.setReconnectAttempts(value)
    }
    def getReconnectAttempts: java.lang.Integer = {
      asJava.getReconnectAttempts()
    }

  /**
    * Set the reconnect interval.
    */
    def setReconnectInterval(value: java.lang.Long) = {
      asJava.setReconnectInterval(value)
    }
    def getReconnectInterval: java.lang.Long = {
      asJava.getReconnectInterval()
    }

  /**
    * Set the value of reuse address
    */
    def setReuseAddress(value: java.lang.Boolean) = {
      asJava.setReuseAddress(value)
    }
    def isReuseAddress: java.lang.Boolean = {
      asJava.isReuseAddress()
    }

  /**
    * Set the value of reuse port.
    * <p/>
    * This is only supported by native transports.
    */
    def setReusePort(value: java.lang.Boolean) = {
      asJava.setReusePort(value)
    }
    def isReusePort: java.lang.Boolean = {
      asJava.isReusePort()
    }

  /**
    * Set the TCP send buffer size
    */
    def setSendBufferSize(value: java.lang.Integer) = {
      asJava.setSendBufferSize(value)
    }
    def getSendBufferSize: java.lang.Integer = {
      asJava.getSendBufferSize()
    }

  /**
    * Set whether SO_linger keep alive is enabled
    */
    def setSoLinger(value: java.lang.Integer) = {
      asJava.setSoLinger(value)
    }
    def getSoLinger: java.lang.Integer = {
      asJava.getSoLinger()
    }

  /**
    * Set whether SSL/TLS is enabled
    */
    def setSsl(value: java.lang.Boolean) = {
      asJava.setSsl(value)
    }
    def isSsl: java.lang.Boolean = {
      asJava.isSsl()
    }

  /**
    * Enable the `TCP_CORK` option - only with linux native transport.
    */
    def setTcpCork(value: java.lang.Boolean) = {
      asJava.setTcpCork(value)
    }
    def isTcpCork: java.lang.Boolean = {
      asJava.isTcpCork()
    }

  /**
    * Enable the `TCP_FASTOPEN` option - only with linux native transport.
    */
    def setTcpFastOpen(value: java.lang.Boolean) = {
      asJava.setTcpFastOpen(value)
    }
    def isTcpFastOpen: java.lang.Boolean = {
      asJava.isTcpFastOpen()
    }

  /**
    * Set whether TCP keep alive is enabled
    */
    def setTcpKeepAlive(value: java.lang.Boolean) = {
      asJava.setTcpKeepAlive(value)
    }
    def isTcpKeepAlive: java.lang.Boolean = {
      asJava.isTcpKeepAlive()
    }

  /**
    * Set whether TCP no delay is enabled
    */
    def setTcpNoDelay(value: java.lang.Boolean) = {
      asJava.setTcpNoDelay(value)
    }
    def isTcpNoDelay: java.lang.Boolean = {
      asJava.isTcpNoDelay()
    }

  /**
    * Enable the `TCP_QUICKACK` option - only with linux native transport.
    */
    def setTcpQuickAck(value: java.lang.Boolean) = {
      asJava.setTcpQuickAck(value)
    }
    def isTcpQuickAck: java.lang.Boolean = {
      asJava.isTcpQuickAck()
    }

  /**
    * Set the value of traffic class
    */
    def setTrafficClass(value: java.lang.Integer) = {
      asJava.setTrafficClass(value)
    }
    def getTrafficClass: java.lang.Integer = {
      asJava.getTrafficClass()
    }

  /**
    * Set whether all server certificates should be trusted.
    */
    def setTrustAll(value: java.lang.Boolean) = {
      asJava.setTrustAll(value)
    }
    def isTrustAll: java.lang.Boolean = {
      asJava.isTrustAll()
    }

  /**
    * Set the trust options in jks format, aka Java truststore
    */
    def setTrustStoreOptions(value: JJksOptions) = {
      asJava.setTrustStoreOptions(value.asJava)
    }
    def getTrustStoreOptions: JJksOptions = {
      asJava.getTrustStoreOptions()
    }

  /**
    * Set the ALPN usage.
    */
    def setUseAlpn(value: java.lang.Boolean) = {
      asJava.setUseAlpn(value)
    }
    def isUseAlpn: java.lang.Boolean = {
      asJava.isUseAlpn()
    }

  /**
    * Set whether Netty pooled buffers are enabled
    */
    def setUsePooledBuffers(value: java.lang.Boolean) = {
      asJava.setUsePooledBuffers(value)
    }
    def isUsePooledBuffers: java.lang.Boolean = {
      asJava.isUsePooledBuffers()
    }
  }
  
  type EventBusOptions = JEventBusOptions
  object EventBusOptions {
    def apply(): JEventBusOptions = new EventBusOptions()
    def apply(json: JsonObject) = new JEventBusOptions(json)
  }


import io.vertx.core.file.{FileProps => JFileProps}

/**
  * Represents properties of a file on the file system.
  * 
  */
implicit class FilePropsScala(val asJava: JFileProps) extends AnyVal {


  /**
    * The date the file was created
    */
  def creationTime(): java.lang.Long = {
    asJava.creationTime()
  }

  /**
    * The date the file was last accessed
    */
  def lastAccessTime(): java.lang.Long = {
    asJava.lastAccessTime()
  }

  /**
    * The date the file was last modified
    */
  def lastModifiedTime(): java.lang.Long = {
    asJava.lastModifiedTime()
  }

  /**
    * Is the file a directory?
    */
  def isDirectory(): java.lang.Boolean = {
    asJava.isDirectory()
  }

  /**
    * Is the file some other type? (I.e. not a directory, regular file or symbolic link)
    */
  def isOther(): java.lang.Boolean = {
    asJava.isOther()
  }

  /**
    * Is the file a regular file?
    */
  def isRegularFile(): java.lang.Boolean = {
    asJava.isRegularFile()
  }

  /**
    * Is the file a symbolic link?
    */
  def isSymbolicLink(): java.lang.Boolean = {
    asJava.isSymbolicLink()
  }

  /**
    * The size of the file, in bytes
    */
  def size(): java.lang.Long = {
    asJava.size()
  }

}

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.file.AsyncFile
import io.vertx.core.file.{FileSystem => JFileSystem}
import io.vertx.core.file.OpenOptions
import scala.collection.JavaConverters._
import io.vertx.core.file.FileSystemProps
import io.vertx.core.file.FileProps
import io.vertx.core.file.{OpenOptions => JOpenOptions}
import io.vertx.core.file.{FileSystemProps => JFileSystemProps}
import io.vertx.core.buffer.Buffer
import io.vertx.core.file.{AsyncFile => JAsyncFile}
import io.vertx.core.file.CopyOptions
import io.vertx.core.file.FileSystem
import io.vertx.core.file.{CopyOptions => JCopyOptions}
import io.vertx.core.file.{FileProps => JFileProps}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler

/**
  * Contains a broad set of operations for manipulating files on the file system.
  * 
  * A (potential) blocking and non blocking version of each operation is provided.
  * 
  * The non blocking versions take a handler which is called when the operation completes or an error occurs.
  * 
  * The blocking versions are named `xxxBlocking` and return the results, or throw exceptions directly.
  * In many cases, depending on the operating system and file system some of the potentially blocking operations
  * can return quickly, which is why we provide them, but it's highly recommended that you test how long they take to
  * return in your particular application before using them on an event loop.
  * 
  * Please consult the documentation for more information on file system support.
  */
implicit class FileSystemScala(val asJava: JFileSystem) extends AnyVal {


  /**
    * Copy a file from the path `from` to path `to`, asynchronously.
    * 
    * The copy will fail if the destination already exists.
    * @param from the path to copy from
    * @param to the path to copy to
    * @param handler the handler that will be called on completion
    * @return a reference to this, so the API can be used fluently
    */
  def copy(from: String, to: String, handler: AsyncResult[Void] => Unit): JFileSystem = {
    asJava.copy(from, to, (p:AsyncResult[Void]) => handler(p))
  }

  /**
    * Copy a file from the path `from` to path `to`, asynchronously.
    * @param from the path to copy from
    * @param to the path to copy to
    * @param options options describing how the file should be copiedsee <a href="../../../../../../../cheatsheet/CopyOptions.html">CopyOptions</a>
    * @param handler the handler that will be called on completion
    * @return a reference to this, so the API can be used fluently
    */
  def copy(from: String, to: String, options: JCopyOptions, handler: AsyncResult[Void] => Unit): JFileSystem = {
    asJava.copy(from, to, options.asJava, (p:AsyncResult[Void]) => handler(p))
  }

  /**
    * Blocking version of [[io.vertx.core.file.FileSystem#copyFuture]]
    */
  def copyBlocking(from: String, to: String): JFileSystem = {
    asJava.copyBlocking(from, to)
  }

  /**
    * Copy a file from the path `from` to path `to`, asynchronously.
    * 
    * If `recursive` is `true` and `from` represents a directory, then the directory and its contents
    * will be copied recursively to the destination `to`.
    * 
    * The copy will fail if the destination if the destination already exists.
    * @param from the path to copy from
    * @param to the path to copy to
    * @param handler the handler that will be called on completion
    * @return a reference to this, so the API can be used fluently
    */
  def copyRecursive(from: String, to: String, recursive: java.lang.Boolean, handler: AsyncResult[Void] => Unit): JFileSystem = {
    asJava.copyRecursive(from, to, recursive, (p:AsyncResult[Void]) => handler(p))
  }

  /**
    * Blocking version of [[io.vertx.core.file.FileSystem#copyRecursiveFuture]]
    */
  def copyRecursiveBlocking(from: String, to: String, recursive: java.lang.Boolean): JFileSystem = {
    asJava.copyRecursiveBlocking(from, to, recursive)
  }

  /**
    * Move a file from the path `from` to path `to`, asynchronously.
    * 
    * The move will fail if the destination already exists.
    * @param from the path to copy from
    * @param to the path to copy to
    * @param handler the handler that will be called on completion
    * @return a reference to this, so the API can be used fluently
    */
  def move(from: String, to: String, handler: AsyncResult[Void] => Unit): JFileSystem = {
    asJava.move(from, to, (p:AsyncResult[Void]) => handler(p))
  }

  /**
    * Move a file from the path `from` to path `to`, asynchronously.
    * @param from the path to copy from
    * @param to the path to copy to
    * @param options options describing how the file should be copiedsee <a href="../../../../../../../cheatsheet/CopyOptions.html">CopyOptions</a>
    * @param handler the handler that will be called on completion
    * @return a reference to this, so the API can be used fluently
    */
  def move(from: String, to: String, options: JCopyOptions, handler: AsyncResult[Void] => Unit): JFileSystem = {
    asJava.move(from, to, options.asJava, (p:AsyncResult[Void]) => handler(p))
  }

  /**
    * Blocking version of [[io.vertx.core.file.FileSystem#moveFuture]]
    */
  def moveBlocking(from: String, to: String): JFileSystem = {
    asJava.moveBlocking(from, to)
  }

  /**
    * Truncate the file represented by `path` to length `len` in bytes, asynchronously.
    * 
    * The operation will fail if the file does not exist or `len` is less than `zero`.
    * @param path the path to the file
    * @param len the length to truncate it to
    * @param handler the handler that will be called on completion
    * @return a reference to this, so the API can be used fluently
    */
  def truncate(path: String, len: java.lang.Long, handler: AsyncResult[Void] => Unit): JFileSystem = {
    asJava.truncate(path, len, (p:AsyncResult[Void]) => handler(p))
  }

  /**
    * Blocking version of [[io.vertx.core.file.FileSystem#truncateFuture]]
    */
  def truncateBlocking(path: String, len: java.lang.Long): JFileSystem = {
    asJava.truncateBlocking(path, len)
  }

  /**
    * Change the permissions on the file represented by `path` to `perms`, asynchronously.
    * 
    * The permission String takes the form rwxr-x--- as
    * specified <a href="http://download.oracle.com/javase/7/docs/api/java/nio/file/attribute/PosixFilePermissions.html">here</a>.
    * @param path the path to the file
    * @param perms the permissions string
    * @param handler the handler that will be called on completion
    * @return a reference to this, so the API can be used fluently
    */
  def chmod(path: String, perms: String, handler: AsyncResult[Void] => Unit): JFileSystem = {
    asJava.chmod(path, perms, (p:AsyncResult[Void]) => handler(p))
  }

  /**
    * Blocking version of [[io.vertx.core.file.FileSystem]]
    */
  def chmodBlocking(path: String, perms: String): JFileSystem = {
    asJava.chmodBlocking(path, perms)
  }

  /**
    * Change the permissions on the file represented by `path` to `perms`, asynchronously.
    * The permission String takes the form rwxr-x--- as
    * specified in {<a href="http://download.oracle.com/javase/7/docs/api/java/nio/file/attribute/PosixFilePermissions.html">here</a>`.
    * 
    * If the file is directory then all contents will also have their permissions changed recursively. Any directory permissions will
    * be set to `dirPerms`, whilst any normal file permissions will be set to `perms`.
    * @param path the path to the file
    * @param perms the permissions string
    * @param dirPerms the directory permissions
    * @param handler the handler that will be called on completion
    * @return a reference to this, so the API can be used fluently
    */
  def chmodRecursive(path: String, perms: String, dirPerms: String, handler: AsyncResult[Void] => Unit): JFileSystem = {
    asJava.chmodRecursive(path, perms, dirPerms, (p:AsyncResult[Void]) => handler(p))
  }

  /**
    * Blocking version of [[io.vertx.core.file.FileSystem#chmodRecursiveFuture]]
    */
  def chmodRecursiveBlocking(path: String, perms: String, dirPerms: String): JFileSystem = {
    asJava.chmodRecursiveBlocking(path, perms, dirPerms)
  }

  /**
    * Change the ownership on the file represented by `path` to `user` and {code group`, asynchronously.
    * @param path the path to the file
    * @param user the user name, `null` will not change the user name
    * @param group the user group, `null` will not change the user group name
    * @param handler the handler that will be called on completion
    * @return a reference to this, so the API can be used fluently
    */
  def chown(path: String, user: scala.Option[String], group: scala.Option[String], handler: AsyncResult[Void] => Unit): JFileSystem = {
    asJava.chown(path, user.orNull, group.orNull, (p:AsyncResult[Void]) => handler(p))
  }

  /**
    * Blocking version of [[io.vertx.core.file.FileSystem#chownFuture]]
    *
    */
  def chownBlocking(path: String, user: scala.Option[String], group: scala.Option[String]): JFileSystem = {
    asJava.chownBlocking(path, user.orNull, group.orNull)
  }

  /**
    * Obtain properties for the file represented by `path`, asynchronously.
    * 
    * If the file is a link, the link will be followed.
    * @param path the path to the file
    * @param handler the handler that will be called on completion
    * @return a reference to this, so the API can be used fluently
    */
  def props(path: String, handler: AsyncResult[JFileProps] => Unit): JFileSystem = {
    asJava.props(path, (p:AsyncResult[JFileProps]) => handler(p))
  }

  /**
    * Obtain properties for the link represented by `path`, asynchronously.
    * 
    * The link will not be followed.
    * @param path the path to the file
    * @param handler the handler that will be called on completion
    * @return a reference to this, so the API can be used fluently
    */
  def lprops(path: String, handler: AsyncResult[JFileProps] => Unit): JFileSystem = {
    asJava.lprops(path, (p:AsyncResult[JFileProps]) => handler(p))
  }

  /**
    * Create a hard link on the file system from `link` to `existing`, asynchronously.
    * @param link the link
    * @param existing the link destination
    * @param handler the handler that will be called on completion
    * @return a reference to this, so the API can be used fluently
    */
  def link(link: String, existing: String, handler: AsyncResult[Void] => Unit): JFileSystem = {
    asJava.link(link, existing, (p:AsyncResult[Void]) => handler(p))
  }

  /**
    * Blocking version of [[io.vertx.core.file.FileSystem#linkFuture]]
    */
  def linkBlocking(link: String, existing: String): JFileSystem = {
    asJava.linkBlocking(link, existing)
  }

  /**
    * Create a symbolic link on the file system from `link` to `existing`, asynchronously.
    * @param link the link
    * @param existing the link destination
    * @param handler the handler that will be called on completion
    * @return a reference to this, so the API can be used fluently
    */
  def symlink(link: String, existing: String, handler: AsyncResult[Void] => Unit): JFileSystem = {
    asJava.symlink(link, existing, (p:AsyncResult[Void]) => handler(p))
  }

  /**
    * Blocking version of [[io.vertx.core.file.FileSystem#linkFuture]]
    */
  def symlinkBlocking(link: String, existing: String): JFileSystem = {
    asJava.symlinkBlocking(link, existing)
  }

  /**
    * Unlinks the link on the file system represented by the path `link`, asynchronously.
    * @param link the link
    * @param handler the handler that will be called on completion
    * @return a reference to this, so the API can be used fluently
    */
  def unlink(link: String, handler: AsyncResult[Void] => Unit): JFileSystem = {
    asJava.unlink(link, (p:AsyncResult[Void]) => handler(p))
  }

  /**
    * Blocking version of [[io.vertx.core.file.FileSystem#unlinkFuture]]
    */
  def unlinkBlocking(link: String): JFileSystem = {
    asJava.unlinkBlocking(link)
  }

  /**
    * Returns the path representing the file that the symbolic link specified by `link` points to, asynchronously.
    * @param link the link
    * @param handler the handler that will be called on completion
    * @return a reference to this, so the API can be used fluently
    */
  def readSymlink(link: String, handler: AsyncResult[String] => Unit): JFileSystem = {
    asJava.readSymlink(link, (p:AsyncResult[String]) => handler(p))
  }

  /**
    * Deletes the file represented by the specified `path`, asynchronously.
    * @param path path to the file
    * @param handler the handler that will be called on completion
    * @return a reference to this, so the API can be used fluently
    */
  def delete(path: String, handler: AsyncResult[Void] => Unit): JFileSystem = {
    asJava.delete(path, (p:AsyncResult[Void]) => handler(p))
  }

  /**
    * Blocking version of [[io.vertx.core.file.FileSystem#deleteFuture]]
    */
  def deleteBlocking(path: String): JFileSystem = {
    asJava.deleteBlocking(path)
  }

  /**
    * Deletes the file represented by the specified `path`, asynchronously.
    * 
    * If the path represents a directory and `recursive = true` then the directory and its contents will be
    * deleted recursively.
    * @param path path to the file
    * @param recursive delete recursively?
    * @param handler the handler that will be called on completion
    * @return a reference to this, so the API can be used fluently
    */
  def deleteRecursive(path: String, recursive: java.lang.Boolean, handler: AsyncResult[Void] => Unit): JFileSystem = {
    asJava.deleteRecursive(path, recursive, (p:AsyncResult[Void]) => handler(p))
  }

  /**
    * Blocking version of [[io.vertx.core.file.FileSystem#deleteRecursiveFuture]]
    */
  def deleteRecursiveBlocking(path: String, recursive: java.lang.Boolean): JFileSystem = {
    asJava.deleteRecursiveBlocking(path, recursive)
  }

  /**
    * Create the directory represented by `path`, asynchronously.
    * 
    * The operation will fail if the directory already exists.
    * @param path path to the file
    * @param handler the handler that will be called on completion
    * @return a reference to this, so the API can be used fluently
    */
  def mkdir(path: String, handler: AsyncResult[Void] => Unit): JFileSystem = {
    asJava.mkdir(path, (p:AsyncResult[Void]) => handler(p))
  }

  /**
    * Blocking version of [[io.vertx.core.file.FileSystem#mkdirFuture]]
    */
  def mkdirBlocking(path: String): JFileSystem = {
    asJava.mkdirBlocking(path)
  }

  /**
    * Create the directory represented by `path`, asynchronously.
    * 
    * The new directory will be created with permissions as specified by `perms`.
    * 
    * The permission String takes the form rwxr-x--- as specified
    * in <a href="http://download.oracle.com/javase/7/docs/api/java/nio/file/attribute/PosixFilePermissions.html">here</a>.
    * 
    * The operation will fail if the directory already exists.
    * @param path path to the file
    * @param perms the permissions string
    * @param handler the handler that will be called on completion
    * @return a reference to this, so the API can be used fluently
    */
  def mkdir(path: String, perms: String, handler: AsyncResult[Void] => Unit): JFileSystem = {
    asJava.mkdir(path, perms, (p:AsyncResult[Void]) => handler(p))
  }

  /**
    * Blocking version of [[io.vertx.core.file.FileSystem#mkdirFuture]]
    */
  def mkdirBlocking(path: String, perms: String): JFileSystem = {
    asJava.mkdirBlocking(path, perms)
  }

  /**
    * Create the directory represented by `path` and any non existent parents, asynchronously.
    * 
    * The operation will fail if the directory already exists.
    * @param path path to the file
    * @param handler the handler that will be called on completion
    * @return a reference to this, so the API can be used fluently
    */
  def mkdirs(path: String, handler: AsyncResult[Void] => Unit): JFileSystem = {
    asJava.mkdirs(path, (p:AsyncResult[Void]) => handler(p))
  }

  /**
    * Blocking version of [[io.vertx.core.file.FileSystem#mkdirsFuture]]
    */
  def mkdirsBlocking(path: String): JFileSystem = {
    asJava.mkdirsBlocking(path)
  }

  /**
    * Create the directory represented by `path` and any non existent parents, asynchronously.
    * 
    * The new directory will be created with permissions as specified by `perms`.
    * 
    * The permission String takes the form rwxr-x--- as specified
    * in <a href="http://download.oracle.com/javase/7/docs/api/java/nio/file/attribute/PosixFilePermissions.html">here</a>.
    * 
    * The operation will fail if the directory already exists.
    * @param path path to the file
    * @param perms the permissions string
    * @param handler the handler that will be called on completion
    * @return a reference to this, so the API can be used fluently
    */
  def mkdirs(path: String, perms: String, handler: AsyncResult[Void] => Unit): JFileSystem = {
    asJava.mkdirs(path, perms, (p:AsyncResult[Void]) => handler(p))
  }

  /**
    * Blocking version of [[io.vertx.core.file.FileSystem#mkdirsFuture]]
    */
  def mkdirsBlocking(path: String, perms: String): JFileSystem = {
    asJava.mkdirsBlocking(path, perms)
  }

  /**
    * Read the contents of the directory specified by `path`, asynchronously.
    * 
    * The result is an array of String representing the paths of the files inside the directory.
    * @param path path to the file
    * @param handler the handler that will be called on completion
    * @return a reference to this, so the API can be used fluently
    */
  def readDir(path: String, handler: AsyncResult[List[String]] => Unit): JFileSystem = {
    asJava.readDir(path, (p:AsyncResult[List[String]]) => handler(p))
  }

  /**
    * Read the contents of the directory specified by `path`, asynchronously.
    * 
    * The parameter `filter` is a regular expression. If `filter` is specified then only the paths that
    * match  @{filter`will be returned.
    * 
    * The result is an array of String representing the paths of the files inside the directory.
    * @param path path to the directory
    * @param filter the filter expression
    * @param handler the handler that will be called on completion
    * @return a reference to this, so the API can be used fluently
    */
  def readDir(path: String, filter: String, handler: AsyncResult[List[String]] => Unit): JFileSystem = {
    asJava.readDir(path, filter, (p:AsyncResult[List[String]]) => handler(p))
  }

  /**
    * Reads the entire file as represented by the path `path` as a , asynchronously.
    * 
    * Do not use this method to read very large files or you risk running out of available RAM.
    * @param path path to the file
    * @param handler the handler that will be called on completion
    * @return a reference to this, so the API can be used fluently
    */
  def readFile(path: String, handler: AsyncResult[io.vertx.core.buffer.Buffer] => Unit): JFileSystem = {
    asJava.readFile(path, (p:AsyncResult[io.vertx.core.buffer.Buffer]) => handler(p))
  }

  /**
    * Creates the file, and writes the specified `Buffer data` to the file represented by the path `path`,
    * asynchronously.
    * @param path path to the file
    * @param handler the handler that will be called on completion
    * @return a reference to this, so the API can be used fluently
    */
  def writeFile(path: String, data: io.vertx.core.buffer.Buffer, handler: AsyncResult[Void] => Unit): JFileSystem = {
    asJava.writeFile(path, data, (p:AsyncResult[Void]) => handler(p))
  }

  /**
    * Blocking version of [[io.vertx.core.file.FileSystem#writeFileFuture]]
    */
  def writeFileBlocking(path: String, data: io.vertx.core.buffer.Buffer): JFileSystem = {
    asJava.writeFileBlocking(path, data)
  }

  /**
    * Open the file represented by `path`, asynchronously.
    * 
    * The file is opened for both reading and writing. If the file does not already exist it will be created.
    * @param path path to the file
    * @param options options describing how the file should be openedsee <a href="../../../../../../../cheatsheet/OpenOptions.html">OpenOptions</a>
    * @return a reference to this, so the API can be used fluently
    */
  def open(path: String, options: JOpenOptions, handler: AsyncResult[JAsyncFile] => Unit): JFileSystem = {
    asJava.open(path, options.asJava, (p:AsyncResult[JAsyncFile]) => handler(p))
  }

  /**
    * Creates an empty file with the specified `path`, asynchronously.
    * @param path path to the file
    * @param handler the handler that will be called on completion
    * @return a reference to this, so the API can be used fluently
    */
  def createFile(path: String, handler: AsyncResult[Void] => Unit): JFileSystem = {
    asJava.createFile(path, (p:AsyncResult[Void]) => handler(p))
  }

  /**
    * Blocking version of [[io.vertx.core.file.FileSystem#createFileFuture]]
    */
  def createFileBlocking(path: String): JFileSystem = {
    asJava.createFileBlocking(path)
  }

  /**
    * Creates an empty file with the specified `path` and permissions `perms`, asynchronously.
    * @param path path to the file
    * @param perms the permissions string
    * @param handler the handler that will be called on completion
    * @return a reference to this, so the API can be used fluently
    */
  def createFile(path: String, perms: String, handler: AsyncResult[Void] => Unit): JFileSystem = {
    asJava.createFile(path, perms, (p:AsyncResult[Void]) => handler(p))
  }

  /**
    * Blocking version of [[io.vertx.core.file.FileSystem#createFileFuture]]
    */
  def createFileBlocking(path: String, perms: String): JFileSystem = {
    asJava.createFileBlocking(path, perms)
  }

  /**
    * Determines whether the file as specified by the path `path` exists, asynchronously.
    * @param path path to the file
    * @param handler the handler that will be called on completion
    * @return a reference to this, so the API can be used fluently
    */
  def exists(path: String, handler: AsyncResult[java.lang.Boolean] => Unit): JFileSystem = {
    asJava.exists(path, (p:AsyncResult[java.lang.Boolean]) => handler(p))
  }

  /**
    * Returns properties of the file-system being used by the specified `path`, asynchronously.
    * @param path path to anywhere on the filesystem
    * @param handler the handler that will be called on completion
    * @return a reference to this, so the API can be used fluently
    */
  def fsProps(path: String, handler: AsyncResult[JFileSystemProps] => Unit): JFileSystem = {
    asJava.fsProps(path, (p:AsyncResult[JFileSystemProps]) => handler(p))
  }

  /**
    * Blocking version of [[io.vertx.core.file.FileSystem#propsFuture]]
    */
  def propsBlocking(path: String): JFileProps = {
    asJava.propsBlocking(path)
  }

  /**
    * Blocking version of [[io.vertx.core.file.FileSystem#lpropsFuture]]
    */
  def lpropsBlocking(path: String): JFileProps = {
    asJava.lpropsBlocking(path)
  }

  /**
    * Blocking version of [[io.vertx.core.file.FileSystem#readSymlinkFuture]]
    */
  def readSymlinkBlocking(link: String): String = {
    asJava.readSymlinkBlocking(link)
  }

  /**
    * Blocking version of [[io.vertx.core.file.FileSystem#readDirFuture]]
    */
  def readDirBlocking(path: String): List[String] = {
    asJava.readDirBlocking(path).asScala.toList
  }

  /**
    * Blocking version of [[io.vertx.core.file.FileSystem#readDirFuture]]
    */
  def readDirBlocking(path: String, filter: String): List[String] = {
    asJava.readDirBlocking(path, filter).asScala.toList
  }

  /**
    * Blocking version of [[io.vertx.core.file.FileSystem#readFileFuture]]
    */
  def readFileBlocking(path: String): io.vertx.core.buffer.Buffer = {
    asJava.readFileBlocking(path)
  }

  /**
    * Blocking version of [[io.vertx.core.file.FileSystem#openFuture]]
    */
  def openBlocking(path: String, options: JOpenOptions): JAsyncFile = {
    asJava.openBlocking(path, options.asJava)
  }

  /**
    * Blocking version of [[io.vertx.core.file.FileSystem#existsFuture]]
    */
  def existsBlocking(path: String): java.lang.Boolean = {
    asJava.existsBlocking(path)
  }

  /**
    * Blocking version of [[io.vertx.core.file.FileSystem#fsPropsFuture]]
    */
  def fsPropsBlocking(path: String): JFileSystemProps = {
    asJava.fsPropsBlocking(path)
  }

 /**
   * Like [[copy]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def copyFuture(from: String, to: String): scala.concurrent.Future[Unit] = {
    val promise = Promise[Unit]()
    asJava.copy(from, to, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[copy]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def copyFuture(from: String, to: String, options: JCopyOptions): scala.concurrent.Future[Unit] = {
    val promise = Promise[Unit]()
    asJava.copy(from, to, options, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[copyRecursive]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def copyRecursiveFuture(from: String, to: String, recursive: java.lang.Boolean): scala.concurrent.Future[Unit] = {
    val promise = Promise[Unit]()
    asJava.copyRecursive(from, to, recursive, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[move]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def moveFuture(from: String, to: String): scala.concurrent.Future[Unit] = {
    val promise = Promise[Unit]()
    asJava.move(from, to, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[move]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def moveFuture(from: String, to: String, options: JCopyOptions): scala.concurrent.Future[Unit] = {
    val promise = Promise[Unit]()
    asJava.move(from, to, options, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[truncate]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def truncateFuture(path: String, len: java.lang.Long): scala.concurrent.Future[Unit] = {
    val promise = Promise[Unit]()
    asJava.truncate(path, len, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[chmod]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def chmodFuture(path: String, perms: String): scala.concurrent.Future[Unit] = {
    val promise = Promise[Unit]()
    asJava.chmod(path, perms, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[chmodRecursive]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def chmodRecursiveFuture(path: String, perms: String, dirPerms: String): scala.concurrent.Future[Unit] = {
    val promise = Promise[Unit]()
    asJava.chmodRecursive(path, perms, dirPerms, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[chown]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def chownFuture(path: String, user: scala.Option[String], group: scala.Option[String]): scala.concurrent.Future[Unit] = {
    val promise = Promise[Unit]()
    asJava.chown(path, user.orNull, group.orNull, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[props]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def propsFuture(path: String): scala.concurrent.Future[JFileProps] = {
    val promise = Promise[JFileProps]()
    asJava.props(path, {a:AsyncResult[io.vertx.core.file.FileProps] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[lprops]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def lpropsFuture(path: String): scala.concurrent.Future[JFileProps] = {
    val promise = Promise[JFileProps]()
    asJava.lprops(path, {a:AsyncResult[io.vertx.core.file.FileProps] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[link]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def linkFuture(link: String, existing: String): scala.concurrent.Future[Unit] = {
    val promise = Promise[Unit]()
    asJava.link(link, existing, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[symlink]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def symlinkFuture(link: String, existing: String): scala.concurrent.Future[Unit] = {
    val promise = Promise[Unit]()
    asJava.symlink(link, existing, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[unlink]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def unlinkFuture(link: String): scala.concurrent.Future[Unit] = {
    val promise = Promise[Unit]()
    asJava.unlink(link, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[readSymlink]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def readSymlinkFuture(link: String): scala.concurrent.Future[String] = {
    val promise = Promise[String]()
    asJava.readSymlink(link, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[delete]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def deleteFuture(path: String): scala.concurrent.Future[Unit] = {
    val promise = Promise[Unit]()
    asJava.delete(path, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[deleteRecursive]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def deleteRecursiveFuture(path: String, recursive: java.lang.Boolean): scala.concurrent.Future[Unit] = {
    val promise = Promise[Unit]()
    asJava.deleteRecursive(path, recursive, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[mkdir]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def mkdirFuture(path: String): scala.concurrent.Future[Unit] = {
    val promise = Promise[Unit]()
    asJava.mkdir(path, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[mkdir]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def mkdirFuture(path: String, perms: String): scala.concurrent.Future[Unit] = {
    val promise = Promise[Unit]()
    asJava.mkdir(path, perms, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[mkdirs]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def mkdirsFuture(path: String): scala.concurrent.Future[Unit] = {
    val promise = Promise[Unit]()
    asJava.mkdirs(path, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[mkdirs]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def mkdirsFuture(path: String, perms: String): scala.concurrent.Future[Unit] = {
    val promise = Promise[Unit]()
    asJava.mkdirs(path, perms, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[readDir]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def readDirFuture(path: String): scala.concurrent.Future[List[String]] = {
    val promise = Promise[List[String]]()
    asJava.readDir(path, {a:AsyncResult[java.util.List[java.lang.String]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.toList);()})
    promise.future
  }

 /**
   * Like [[readDir]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def readDirFuture(path: String, filter: String): scala.concurrent.Future[List[String]] = {
    val promise = Promise[List[String]]()
    asJava.readDir(path, filter, {a:AsyncResult[java.util.List[java.lang.String]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.toList);()})
    promise.future
  }

 /**
   * Like [[readFile]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def readFileFuture(path: String): scala.concurrent.Future[io.vertx.core.buffer.Buffer] = {
    val promise = Promise[io.vertx.core.buffer.Buffer]()
    asJava.readFile(path, {a:AsyncResult[io.vertx.core.buffer.Buffer] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[writeFile]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def writeFileFuture(path: String, data: io.vertx.core.buffer.Buffer): scala.concurrent.Future[Unit] = {
    val promise = Promise[Unit]()
    asJava.writeFile(path, data, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[open]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def openFuture(path: String, options: JOpenOptions): scala.concurrent.Future[JAsyncFile] = {
    val promise = Promise[JAsyncFile]()
    asJava.open(path, options, {a:AsyncResult[io.vertx.core.file.AsyncFile] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[createFile]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def createFileFuture(path: String): scala.concurrent.Future[Unit] = {
    val promise = Promise[Unit]()
    asJava.createFile(path, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[createFile]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def createFileFuture(path: String, perms: String): scala.concurrent.Future[Unit] = {
    val promise = Promise[Unit]()
    asJava.createFile(path, perms, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[exists]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def existsFuture(path: String): scala.concurrent.Future[java.lang.Boolean] = {
    val promise = Promise[java.lang.Boolean]()
    asJava.exists(path, {a:AsyncResult[java.lang.Boolean] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[fsProps]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def fsPropsFuture(path: String): scala.concurrent.Future[JFileSystemProps] = {
    val promise = Promise[JFileSystemProps]()
    asJava.fsProps(path, {a:AsyncResult[io.vertx.core.file.FileSystemProps] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

}

import io.vertx.core.file.{FileSystemProps => JFileSystemProps}

/**
  * Represents properties of the file system.
  */
implicit class FileSystemPropsScala(val asJava: JFileSystemProps) extends AnyVal {


  /**
    * @return The total space on the file system, in bytes
    */
  def totalSpace(): java.lang.Long = {
    asJava.totalSpace()
  }

  /**
    * @return The total un-allocated space on the file system, in bytes
    */
  def unallocatedSpace(): java.lang.Long = {
    asJava.unallocatedSpace()
  }

  /**
    * @return The total usable space on the file system, in bytes
    */
  def usableSpace(): java.lang.Long = {
    asJava.usableSpace()
  }

}

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.{Future => JFuture}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.core.Future

/**
  * Represents the result of an action that may, or may not, have occurred yet.
  * 
  */
implicit class FutureScala[T](val asJava: JFuture[T]) extends AnyVal {


  /**
    * Set a handler for the result.
    * 
    * If the future has already been completed it will be called immediately. Otherwise it will be called when the
    * future is completed.
    * @param handler the Handler that will be called with the result
    * @return a reference to this, so it can be used fluently
    */
  def setHandler(handler: AsyncResult[T] => Unit): JFuture[T] = {
    asJava.setHandler((p:AsyncResult[T]) => handler(p))
  }

  /**
    * Compose this future with a provided `next` future.
    *
    * When this (the one on which `compose` is called) future succeeds, the `handler` will be called with
    * the completed value, this handler should complete the next future.
    *
    * If the `handler` throws an exception, the returned future will be failed with this exception.
    *
    * When this future fails, the failure will be propagated to the `next` future and the `handler`
    * will not be called.
    * @param handler the handler
    * @param next the next future
    * @return the next future, used for chaining
    */
  def compose[U](handler: T => Unit, next: JFuture[U]): JFuture[U] = {
    asJava.compose[U]((p:T) => handler(p), next.asJava)
  }

  /**
    * Compose this future with a `mapper` function.
    *
    * When this future (the one on which `compose` is called) succeeds, the `mapper` will be called with
    * the completed value and this mapper returns another future object. This returned future completion will complete
    * the future returned by this method call.
    *
    * If the `mapper` throws an exception, the returned future will be failed with this exception.
    *
    * When this future fails, the failure will be propagated to the returned future and the `mapper`
    * will not be called.
    * @param mapper the mapper function
    * @return the composed future
    */
  def compose[U](mapper: T => JFuture[U]): JFuture[U] = {
    asJava.compose[U](asJavaFunction(mapper))
  }

  /**
    * Apply a `mapper` function on this future.
    *
    * When this future succeeds, the `mapper` will be called with the completed value and this mapper
    * returns a value. This value will complete the future returned by this method call.
    *
    * If the `mapper` throws an exception, the returned future will be failed with this exception.
    *
    * When this future fails, the failure will be propagated to the returned future and the `mapper`
    * will not be called.
    * @param mapper the mapper function
    * @return the mapped future
    */
  def map[U](mapper: T => U): JFuture[U] = {
    asJava.map[U](asJavaFunction(mapper))
  }

  /**
    * Map the result of a future to a specific `value`.
    *
    * When this future succeeds, this `value` will complete the future returned by this method call.
    *
    * When this future fails, the failure will be propagated to the returned future.
    * @param value the value that eventually completes the mapped future
    * @return the mapped future
    */
  def map[V](value: V): JFuture[V] = {
    asJava.map[V](value)
  }

  /**
    * Map the result of a future to `null`.
    *
    * This is a conveniency for `future.map((T) null)` or `future.map((Void) null)`.
    *
    * When this future succeeds, `null` will complete the future returned by this method call.
    *
    * When this future fails, the failure will be propagated to the returned future.
    * @return the mapped future
    */
  def mapEmpty[V](): JFuture[V] = {
    asJava.mapEmpty[V]()
  }

  /**
    * Handles a failure of this Future by returning the result of another Future.
    * If the mapper fails, then the returned future will be failed with this failure.
    * @param mapper A function which takes the exception of a failure and returns a new future.
    * @return A recovered future
    */
  def recover(mapper: Throwable => JFuture[T]): JFuture[T] = {
    asJava.recover(asJavaFunction(mapper))
  }

  /**
    * Apply a `mapper` function on this future.
    *
    * When this future fails, the `mapper` will be called with the completed value and this mapper
    * returns a value. This value will complete the future returned by this method call.
    *
    * If the `mapper` throws an exception, the returned future will be failed with this exception.
    *
    * When this future succeeds, the result will be propagated to the returned future and the `mapper`
    * will not be called.
    * @param mapper the mapper function
    * @return the mapped future
    */
  def otherwise(mapper: Throwable => T): JFuture[T] = {
    asJava.otherwise(a => mapper(a))
  }

  /**
    * Map the failure of a future to a specific `value`.
    *
    * When this future fails, this `value` will complete the future returned by this method call.
    *
    * When this future succeeds, the result will be propagated to the returned future.
    * @param value the value that eventually completes the mapped future
    * @return the mapped future
    */
  def otherwise(value: T): JFuture[T] = {
    asJava.otherwise(value)
  }

  /**
    * Map the failure of a future to `null`.
    *
    * This is a convenience for `future.otherwise((T) null)`.
    *
    * When this future fails, the `null` value will complete the future returned by this method call.
    *
    * When this future succeeds, the result will be propagated to the returned future.
    * @return the mapped future
    */
  def otherwiseEmpty(): JFuture[T] = {
    asJava.otherwiseEmpty()
  }

  /**
    * Has the future completed?
    * 
    * It's completed if it's either succeeded or failed.
    * @return true if completed, false if not
    */
  def isComplete(): java.lang.Boolean = {
    asJava.isComplete()
  }

  /**
    * Set the result. Any handler will be called, if there is one, and the future will be marked as completed.
    * @param result the result
    */
  def complete(result: T): Unit = {
    asJava.complete(result)
  }

  /**
    *  Set a null result. Any handler will be called, if there is one, and the future will be marked as completed.
    */
  def complete(): Unit = {
    asJava.complete()
  }

  /**
    * Set the failure. Any handler will be called, if there is one, and the future will be marked as completed.
    * @param cause the failure cause
    */
  def fail(cause: Throwable): Unit = {
    asJava.fail(cause)
  }

  /**
    * Try to set the failure. When it happens, any handler will be called, if there is one, and the future will be marked as completed.
    * @param failureMessage the failure message
    */
  def fail(failureMessage: String): Unit = {
    asJava.fail(failureMessage)
  }

  /**
    * Set the failure. Any handler will be called, if there is one, and the future will be marked as completed.
    * @param result the result
    * @return false when the future is already completed
    */
  def tryComplete(result: T): java.lang.Boolean = {
    asJava.tryComplete(result)
  }

  /**
    * Try to set the result. When it happens, any handler will be called, if there is one, and the future will be marked as completed.
    * @return false when the future is already completed
    */
  def tryComplete(): java.lang.Boolean = {
    asJava.tryComplete()
  }

  /**
    * Try to set the failure. When it happens, any handler will be called, if there is one, and the future will be marked as completed.
    * @param cause the failure cause
    * @return false when the future is already completed
    */
  def tryFail(cause: Throwable): java.lang.Boolean = {
    asJava.tryFail(cause)
  }

  /**
    * Try to set the failure. When it happens, any handler will be called, if there is one, and the future will be marked as completed.
    * @param failureMessage the failure message
    * @return false when the future is already completed
    */
  def tryFail(failureMessage: String): java.lang.Boolean = {
    asJava.tryFail(failureMessage)
  }

  /**
    * The result of the operation. This will be null if the operation failed.
    * @return the result or null if the operation failed.
    */
  def result(): T = {
    asJava.result()
  }

  /**
    * A Throwable describing failure. This will be null if the operation succeeded.
    * @return the cause or null if the operation succeeded.
    */
  def cause(): Throwable = {
    asJava.cause()
  }

  /**
    * Did it succeed?
    * @return true if it succeded or false otherwise
    */
  def succeeded(): java.lang.Boolean = {
    asJava.succeeded()
  }

  /**
    * Did it fail?
    * @return true if it failed or false otherwise
    */
  def failed(): java.lang.Boolean = {
    asJava.failed()
  }

  /**
    * @return an handler completing this future
    */
  def completer(): Handler[AsyncResult[T]] = {
    asJava.completer()
  }

}

import io.vertx.core.buffer.Buffer
import io.vertx.core.http.{GoAway => JGoAway}

/**
  * A  frame.
  */

  implicit class GoAwayScala(val asJava: JGoAway) extends AnyVal {


  /**
    * Set the additional debug data
    */
    def setDebugData(value: io.vertx.core.buffer.Buffer) = {
      asJava.setDebugData(value)
    }
    def getDebugData: io.vertx.core.buffer.Buffer = {
      asJava.getDebugData()
    }

  /**
    */
    def setErrorCode(value: java.lang.Long) = {
      asJava.setErrorCode(value)
    }
    def getErrorCode: java.lang.Long = {
      asJava.getErrorCode()
    }

  /**
    * Set the last stream id.
    */
    def setLastStreamId(value: java.lang.Integer) = {
      asJava.setLastStreamId(value)
    }
    def getLastStreamId: java.lang.Integer = {
      asJava.getLastStreamId()
    }
  }
  
  type GoAway = JGoAway
  object GoAway {
    def apply(): JGoAway = new GoAway()
    def apply(json: JsonObject) = new JGoAway(json)
  }


import io.vertx.core.http.{Http2Settings => JHttp2Settings}

/**
  * HTTP2 settings, the settings is initialized with the default HTTP/2 values.
  *
  * The settings expose the parameters defined by the HTTP/2 specification, as well as extra settings for
  * protocol extensions.
  */

  implicit class Http2SettingsScala(val asJava: JHttp2Settings) extends AnyVal {


  /**
    * Set  HTTP/2 setting.
    */
    def setHeaderTableSize(value: java.lang.Long) = {
      asJava.setHeaderTableSize(value)
    }
    def getHeaderTableSize: java.lang.Long = {
      asJava.getHeaderTableSize()
    }

  /**
    * Set the  HTTP/2 setting
    */
    def setInitialWindowSize(value: java.lang.Integer) = {
      asJava.setInitialWindowSize(value)
    }
    def getInitialWindowSize: java.lang.Integer = {
      asJava.getInitialWindowSize()
    }

  /**
    * Set the  HTTP/2 setting
    */
    def setMaxConcurrentStreams(value: java.lang.Long) = {
      asJava.setMaxConcurrentStreams(value)
    }
    def getMaxConcurrentStreams: java.lang.Long = {
      asJava.getMaxConcurrentStreams()
    }

  /**
    * Set the  HTTP/2 setting
    */
    def setMaxFrameSize(value: java.lang.Integer) = {
      asJava.setMaxFrameSize(value)
    }
    def getMaxFrameSize: java.lang.Integer = {
      asJava.getMaxFrameSize()
    }

  /**
    * Set the  HTTP/2 setting
    */
    def setMaxHeaderListSize(value: java.lang.Long) = {
      asJava.setMaxHeaderListSize(value)
    }
    def getMaxHeaderListSize: java.lang.Long = {
      asJava.getMaxHeaderListSize()
    }

  /**
    * Set the  HTTP/2 setting
    */
    def setPushEnabled(value: java.lang.Boolean) = {
      asJava.setPushEnabled(value)
    }
    def isPushEnabled: java.lang.Boolean = {
      asJava.isPushEnabled()
    }
  }
  
  type Http2Settings = JHttp2Settings
  object Http2Settings {
    def apply(): JHttp2Settings = new Http2Settings()
    def apply(json: JsonObject) = new JHttp2Settings(json)
  }


import io.vertx.core.metrics.{Measured => JMeasured}
import io.vertx.core.http.{RequestOptions => JRequestOptions}
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.core.MultiMap
import io.vertx.core.http.RequestOptions
import io.vertx.core.http.WebSocket
import io.vertx.core.http.WebsocketVersion
import io.vertx.core.Future
import io.vertx.core.http.{HttpClient => JHttpClient}
import io.vertx.core.http.HttpClientRequest
import io.vertx.core.http.HttpClientResponse
import io.vertx.core.metrics.Measured
import io.vertx.core.http.HttpMethod
import io.vertx.core.{Future => JFuture}
import io.vertx.core.http.{HttpClientResponse => JHttpClientResponse}
import io.vertx.core.streams.ReadStream
import io.vertx.core.http.{WebSocket => JWebSocket}
import io.vertx.core.{MultiMap => JMultiMap}
import io.vertx.core.Handler
import io.vertx.core.http.{HttpClientRequest => JHttpClientRequest}
import io.vertx.core.http.HttpClient

/**
  * An asynchronous HTTP client.
  * 
  * It allows you to make requests to HTTP servers, and a single client can make requests to any server.
  * 
  * It also allows you to open WebSockets to servers.
  * 
  * The client can also pool HTTP connections.
  * 
  * For pooling to occur, keep-alive must be true on the <a href="../../../../../../../cheatsheet/HttpClientOptions.html">HttpClientOptions</a> (default is true).
  * In this case connections will be pooled and re-used if there are pending HTTP requests waiting to get a connection,
  * otherwise they will be closed.
  * 
  * This gives the benefits of keep alive when the client is loaded but means we don't keep connections hanging around
  * unnecessarily when there would be no benefits anyway.
  * 
  * The client also supports pipe-lining of requests. Pipe-lining means another request is sent on the same connection
  * before the response from the preceding one has returned. Pipe-lining is not appropriate for all requests.
  * 
  * To enable pipe-lining, it must be enabled on the <a href="../../../../../../../cheatsheet/HttpClientOptions.html">HttpClientOptions</a> (default is false).
  * 
  * When pipe-lining is enabled the connection will be automatically closed when all in-flight responses have returned
  * and there are no outstanding pending requests to write.
  * 
  * The client is designed to be reused between requests.
  */
implicit class HttpClientScala(val asJava: JHttpClient) extends AnyVal {


  /**
    * Sends an HTTP GET request to the server with the specified options, specifying a response handler to receive
    * the response
    * @param options the request optionssee <a href="../../../../../../../cheatsheet/RequestOptions.html">RequestOptions</a>
    * @param responseHandler the response handler
    * @return a reference to this, so the API can be used fluently
    */
  def getNow(options: JRequestOptions, responseHandler: JHttpClientResponse => Unit): JHttpClient = {
    asJava.getNow(options.asJava, (p:JHttpClientResponse) => responseHandler(p))
  }

  /**
    * Sends an HTTP GET request to the server at the specified host and port, specifying a response handler to receive
    * the response
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return a reference to this, so the API can be used fluently
    */
  def getNow(port: java.lang.Integer, host: String, requestURI: String, responseHandler: JHttpClientResponse => Unit): JHttpClient = {
    asJava.getNow(port, host, requestURI, (p:JHttpClientResponse) => responseHandler(p))
  }

  /**
    * Sends an HTTP GET request to the server at the specified host and default port, specifying a response handler to receive
    * the response
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return a reference to this, so the API can be used fluently
    */
  def getNow(host: String, requestURI: String, responseHandler: JHttpClientResponse => Unit): JHttpClient = {
    asJava.getNow(host, requestURI, (p:JHttpClientResponse) => responseHandler(p))
  }

  /**
    * Sends an HTTP GET request  to the server at the default host and port, specifying a response handler to receive
    * the response
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return a reference to this, so the API can be used fluently
    */
  def getNow(requestURI: String, responseHandler: JHttpClientResponse => Unit): JHttpClient = {
    asJava.getNow(requestURI, (p:JHttpClientResponse) => responseHandler(p))
  }

  /**
    * Sends an HTTP HEAD request to the server with the specified options, specifying a response handler to receive
    * the response
    * @param options the request optionssee <a href="../../../../../../../cheatsheet/RequestOptions.html">RequestOptions</a>
    * @param responseHandler the response handler
    * @return a reference to this, so the API can be used fluently
    */
  def headNow(options: JRequestOptions, responseHandler: JHttpClientResponse => Unit): JHttpClient = {
    asJava.headNow(options.asJava, (p:JHttpClientResponse) => responseHandler(p))
  }

  /**
    * Sends an HTTP HEAD request to the server at the specified host and port, specifying a response handler to receive
    * the response
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return a reference to this, so the API can be used fluently
    */
  def headNow(port: java.lang.Integer, host: String, requestURI: String, responseHandler: JHttpClientResponse => Unit): JHttpClient = {
    asJava.headNow(port, host, requestURI, (p:JHttpClientResponse) => responseHandler(p))
  }

  /**
    * Sends an HTTP HEAD request to the server at the specified host and default port, specifying a response handler to receive
    * the response
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return a reference to this, so the API can be used fluently
    */
  def headNow(host: String, requestURI: String, responseHandler: JHttpClientResponse => Unit): JHttpClient = {
    asJava.headNow(host, requestURI, (p:JHttpClientResponse) => responseHandler(p))
  }

  /**
    * Sends an HTTP HEAD request  to the server at the default host and port, specifying a response handler to receive
    * the response
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return a reference to this, so the API can be used fluently
    */
  def headNow(requestURI: String, responseHandler: JHttpClientResponse => Unit): JHttpClient = {
    asJava.headNow(requestURI, (p:JHttpClientResponse) => responseHandler(p))
  }

  /**
    * Sends an HTTP OPTIONS request to the server with the specified options, specifying a response handler to receive
    * the response
    * @param options the request optionssee <a href="../../../../../../../cheatsheet/RequestOptions.html">RequestOptions</a>
    * @param responseHandler the response handler
    * @return a reference to this, so the API can be used fluently
    */
  def optionsNow(options: JRequestOptions, responseHandler: JHttpClientResponse => Unit): JHttpClient = {
    asJava.optionsNow(options.asJava, (p:JHttpClientResponse) => responseHandler(p))
  }

  /**
    * Sends an HTTP OPTIONS request to the server at the specified host and port, specifying a response handler to receive
    * the response
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return a reference to this, so the API can be used fluently
    */
  def optionsNow(port: java.lang.Integer, host: String, requestURI: String, responseHandler: JHttpClientResponse => Unit): JHttpClient = {
    asJava.optionsNow(port, host, requestURI, (p:JHttpClientResponse) => responseHandler(p))
  }

  /**
    * Sends an HTTP OPTIONS request to the server at the specified host and default port, specifying a response handler to receive
    * the response
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return a reference to this, so the API can be used fluently
    */
  def optionsNow(host: String, requestURI: String, responseHandler: JHttpClientResponse => Unit): JHttpClient = {
    asJava.optionsNow(host, requestURI, (p:JHttpClientResponse) => responseHandler(p))
  }

  /**
    * Sends an HTTP OPTIONS request  to the server at the default host and port, specifying a response handler to receive
    * the response
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return a reference to this, so the API can be used fluently
    */
  def optionsNow(requestURI: String, responseHandler: JHttpClientResponse => Unit): JHttpClient = {
    asJava.optionsNow(requestURI, (p:JHttpClientResponse) => responseHandler(p))
  }

  /**
    * Connect a WebSocket with the specified options
    * @param options the request optionssee <a href="../../../../../../../cheatsheet/RequestOptions.html">RequestOptions</a>
    * @param wsConnect handler that will be called with the websocket when connected
    * @return a reference to this, so the API can be used fluently
    */
  def websocket(options: JRequestOptions, wsConnect: JWebSocket => Unit): JHttpClient = {
    asJava.websocket(options.asJava, (p:JWebSocket) => wsConnect(p))
  }

  /**
    * Connect a WebSocket to the specified port, host and relative request URI
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param wsConnect handler that will be called with the websocket when connected
    * @return a reference to this, so the API can be used fluently
    */
  def websocket(port: java.lang.Integer, host: String, requestURI: String, wsConnect: JWebSocket => Unit): JHttpClient = {
    asJava.websocket(port, host, requestURI, (p:JWebSocket) => wsConnect(p))
  }

  /**
    * Connect a WebSocket with the specified options
    * @param options the request optionssee <a href="../../../../../../../cheatsheet/RequestOptions.html">RequestOptions</a>
    * @param wsConnect handler that will be called with the websocket when connected
    * @param failureHandler handler that will be called if websocket connection fails
    * @return a reference to this, so the API can be used fluently
    */
  def websocket(options: JRequestOptions, wsConnect: JWebSocket => Unit, failureHandler: Throwable => Unit): JHttpClient = {
    asJava.websocket(options.asJava, (p:JWebSocket) => wsConnect(p), (p:Throwable) => failureHandler(p))
  }

  /**
    * Connect a WebSocket to the specified port, host and relative request URI
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param wsConnect handler that will be called with the websocket when connected
    * @param failureHandler handler that will be called if websocket connection fails
    * @return a reference to this, so the API can be used fluently
    */
  def websocket(port: java.lang.Integer, host: String, requestURI: String, wsConnect: JWebSocket => Unit, failureHandler: Throwable => Unit): JHttpClient = {
    asJava.websocket(port, host, requestURI, (p:JWebSocket) => wsConnect(p), (p:Throwable) => failureHandler(p))
  }

  /**
    * Connect a WebSocket to the host and relative request URI and default port
    * @param host the host
    * @param requestURI the relative URI
    * @param wsConnect handler that will be called with the websocket when connected
    * @return a reference to this, so the API can be used fluently
    */
  def websocket(host: String, requestURI: String, wsConnect: JWebSocket => Unit): JHttpClient = {
    asJava.websocket(host, requestURI, (p:JWebSocket) => wsConnect(p))
  }

  /**
    * Connect a WebSocket to the host and relative request URI and default port
    * @param host the host
    * @param requestURI the relative URI
    * @param wsConnect handler that will be called with the websocket when connected
    * @param failureHandler handler that will be called if websocket connection fails
    * @return a reference to this, so the API can be used fluently
    */
  def websocket(host: String, requestURI: String, wsConnect: JWebSocket => Unit, failureHandler: Throwable => Unit): JHttpClient = {
    asJava.websocket(host, requestURI, (p:JWebSocket) => wsConnect(p), (p:Throwable) => failureHandler(p))
  }

  /**
    * Connect a WebSocket with the specified options, and with the specified headers
    * @param options the request optionssee <a href="../../../../../../../cheatsheet/RequestOptions.html">RequestOptions</a>
    * @param headers the headers
    * @param wsConnect handler that will be called with the websocket when connected
    * @return a reference to this, so the API can be used fluently
    */
  def websocket(options: JRequestOptions, headers: JMultiMap, wsConnect: JWebSocket => Unit): JHttpClient = {
    asJava.websocket(options.asJava, headers.asJava, (p:JWebSocket) => wsConnect(p))
  }

  /**
    * Connect a WebSocket to the specified port, host and relative request URI, and with the specified headers
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param headers the headers
    * @param wsConnect handler that will be called with the websocket when connected
    * @return a reference to this, so the API can be used fluently
    */
  def websocket(port: java.lang.Integer, host: String, requestURI: String, headers: JMultiMap, wsConnect: JWebSocket => Unit): JHttpClient = {
    asJava.websocket(port, host, requestURI, headers.asJava, (p:JWebSocket) => wsConnect(p))
  }

  /**
    * Connect a WebSocket with the specified options, and with the specified headers
    * @param options the request optionssee <a href="../../../../../../../cheatsheet/RequestOptions.html">RequestOptions</a>
    * @param headers the headers
    * @param wsConnect handler that will be called with the websocket when connected
    * @param failureHandler handler that will be called if websocket connection fails
    * @return a reference to this, so the API can be used fluently
    */
  def websocket(options: JRequestOptions, headers: JMultiMap, wsConnect: JWebSocket => Unit, failureHandler: Throwable => Unit): JHttpClient = {
    asJava.websocket(options.asJava, headers.asJava, (p:JWebSocket) => wsConnect(p), (p:Throwable) => failureHandler(p))
  }

  /**
    * Connect a WebSocket to the specified port, host and relative request URI, and with the specified headers
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param headers the headers
    * @param wsConnect handler that will be called with the websocket when connected
    * @param failureHandler handler that will be called if websocket connection fails
    * @return a reference to this, so the API can be used fluently
    */
  def websocket(port: java.lang.Integer, host: String, requestURI: String, headers: JMultiMap, wsConnect: JWebSocket => Unit, failureHandler: Throwable => Unit): JHttpClient = {
    asJava.websocket(port, host, requestURI, headers.asJava, (p:JWebSocket) => wsConnect(p), (p:Throwable) => failureHandler(p))
  }

  /**
    * Connect a WebSocket to the specified host,relative request UR, and default port and with the specified headers
    * @param host the host
    * @param requestURI the relative URI
    * @param headers the headers
    * @param wsConnect handler that will be called with the websocket when connected
    * @return a reference to this, so the API can be used fluently
    */
  def websocket(host: String, requestURI: String, headers: JMultiMap, wsConnect: JWebSocket => Unit): JHttpClient = {
    asJava.websocket(host, requestURI, headers.asJava, (p:JWebSocket) => wsConnect(p))
  }

  /**
    * Connect a WebSocket to the specified host,relative request UR, and default port and with the specified headers
    * @param host the host
    * @param requestURI the relative URI
    * @param headers the headers
    * @param wsConnect handler that will be called with the websocket when connected
    * @param failureHandler handler that will be called if websocket connection fails
    * @return a reference to this, so the API can be used fluently
    */
  def websocket(host: String, requestURI: String, headers: JMultiMap, wsConnect: JWebSocket => Unit, failureHandler: Throwable => Unit): JHttpClient = {
    asJava.websocket(host, requestURI, headers.asJava, (p:JWebSocket) => wsConnect(p), (p:Throwable) => failureHandler(p))
  }

  /**
    * Connect a WebSocket with the specified optionsI, with the specified headers and using
    * the specified version of WebSockets
    * @param options the request optionssee <a href="../../../../../../../cheatsheet/RequestOptions.html">RequestOptions</a>
    * @param headers the headers
    * @param version the websocket version
    * @param wsConnect handler that will be called with the websocket when connected
    * @return a reference to this, so the API can be used fluently
    */
  def websocket(options: JRequestOptions, headers: JMultiMap, version: io.vertx.core.http.WebsocketVersion, wsConnect: JWebSocket => Unit): JHttpClient = {
    asJava.websocket(options.asJava, headers.asJava, version, (p:JWebSocket) => wsConnect(p))
  }

  /**
    * Connect a WebSocket to the specified port, host and relative request URI, with the specified headers and using
    * the specified version of WebSockets
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param headers the headers
    * @param version the websocket version
    * @param wsConnect handler that will be called with the websocket when connected
    * @return a reference to this, so the API can be used fluently
    */
  def websocket(port: java.lang.Integer, host: String, requestURI: String, headers: JMultiMap, version: io.vertx.core.http.WebsocketVersion, wsConnect: JWebSocket => Unit): JHttpClient = {
    asJava.websocket(port, host, requestURI, headers.asJava, version, (p:JWebSocket) => wsConnect(p))
  }

  /**
    * Connect a WebSocket with the specified options, with the specified headers and using
    * the specified version of WebSockets
    * @param options the request optionssee <a href="../../../../../../../cheatsheet/RequestOptions.html">RequestOptions</a>
    * @param headers the headers
    * @param version the websocket version
    * @param wsConnect handler that will be called with the websocket when connected
    * @param failureHandler handler that will be called if websocket connection fails
    * @return a reference to this, so the API can be used fluently
    */
  def websocket(options: JRequestOptions, headers: JMultiMap, version: io.vertx.core.http.WebsocketVersion, wsConnect: JWebSocket => Unit, failureHandler: Throwable => Unit): JHttpClient = {
    asJava.websocket(options.asJava, headers.asJava, version, (p:JWebSocket) => wsConnect(p), (p:Throwable) => failureHandler(p))
  }

  /**
    * Connect a WebSocket to the specified port, host and relative request URI, with the specified headers and using
    * the specified version of WebSockets
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param headers the headers
    * @param version the websocket version
    * @param wsConnect handler that will be called with the websocket when connected
    * @param failureHandler handler that will be called if websocket connection fails
    * @return a reference to this, so the API can be used fluently
    */
  def websocket(port: java.lang.Integer, host: String, requestURI: String, headers: JMultiMap, version: io.vertx.core.http.WebsocketVersion, wsConnect: JWebSocket => Unit, failureHandler: Throwable => Unit): JHttpClient = {
    asJava.websocket(port, host, requestURI, headers.asJava, version, (p:JWebSocket) => wsConnect(p), (p:Throwable) => failureHandler(p))
  }

  /**
    * Connect a WebSocket to the specified host, relative request URI and default port with the specified headers and using
    * the specified version of WebSockets
    * @param host the host
    * @param requestURI the relative URI
    * @param headers the headers
    * @param version the websocket version
    * @param wsConnect handler that will be called with the websocket when connected
    * @return a reference to this, so the API can be used fluently
    */
  def websocket(host: String, requestURI: String, headers: JMultiMap, version: io.vertx.core.http.WebsocketVersion, wsConnect: JWebSocket => Unit): JHttpClient = {
    asJava.websocket(host, requestURI, headers.asJava, version, (p:JWebSocket) => wsConnect(p))
  }

  /**
    * Connect a WebSocket to the specified host, relative request URI and default port with the specified headers and using
    * the specified version of WebSockets
    * @param host the host
    * @param requestURI the relative URI
    * @param headers the headers
    * @param version the websocket version
    * @param wsConnect handler that will be called with the websocket when connected
    * @param failureHandler handler that will be called if websocket connection fails
    * @return a reference to this, so the API can be used fluently
    */
  def websocket(host: String, requestURI: String, headers: JMultiMap, version: io.vertx.core.http.WebsocketVersion, wsConnect: JWebSocket => Unit, failureHandler: Throwable => Unit): JHttpClient = {
    asJava.websocket(host, requestURI, headers.asJava, version, (p:JWebSocket) => wsConnect(p), (p:Throwable) => failureHandler(p))
  }

  /**
    * Connect a WebSocket with the specified options, with the specified headers, using
    * the specified version of WebSockets, and the specified websocket sub protocols
    * @param options the request optionssee <a href="../../../../../../../cheatsheet/RequestOptions.html">RequestOptions</a>
    * @param headers the headers
    * @param version the websocket version
    * @param subProtocols the subprotocols to use
    * @param wsConnect handler that will be called with the websocket when connected
    * @return a reference to this, so the API can be used fluently
    */
  def websocket(options: JRequestOptions, headers: JMultiMap, version: io.vertx.core.http.WebsocketVersion, subProtocols: String, wsConnect: JWebSocket => Unit): JHttpClient = {
    asJava.websocket(options.asJava, headers.asJava, version, subProtocols, (p:JWebSocket) => wsConnect(p))
  }

  /**
    * Connect a WebSocket to the specified port, host and relative request URI, with the specified headers, using
    * the specified version of WebSockets, and the specified websocket sub protocols
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param headers the headers
    * @param version the websocket version
    * @param subProtocols the subprotocols to use
    * @param wsConnect handler that will be called with the websocket when connected
    * @return a reference to this, so the API can be used fluently
    */
  def websocket(port: java.lang.Integer, host: String, requestURI: String, headers: JMultiMap, version: io.vertx.core.http.WebsocketVersion, subProtocols: String, wsConnect: JWebSocket => Unit): JHttpClient = {
    asJava.websocket(port, host, requestURI, headers.asJava, version, subProtocols, (p:JWebSocket) => wsConnect(p))
  }

  /**
    * Connect a WebSocket with the specified absolute url, with the specified headers, using
    * the specified version of WebSockets, and the specified websocket sub protocols.
    * @param url the absolute url
    * @param headers the headers
    * @param version the websocket version
    * @param subProtocols the subprotocols to use
    * @param wsConnect handler that will be called with the websocket when connected
    * @param failureHandler handler that will be called if websocket connection fails
    * @return a reference to this, so the API can be used fluently
    */
  def websocketAbs(url: String, headers: JMultiMap, version: io.vertx.core.http.WebsocketVersion, subProtocols: String, wsConnect: JWebSocket => Unit, failureHandler: Throwable => Unit): JHttpClient = {
    asJava.websocketAbs(url, headers.asJava, version, subProtocols, (p:JWebSocket) => wsConnect(p), (p:Throwable) => failureHandler(p))
  }

  /**
    * Connect a WebSocket with the specified options, with the specified headers, using
    * the specified version of WebSockets, and the specified websocket sub protocols
    * @param options the request optionssee <a href="../../../../../../../cheatsheet/RequestOptions.html">RequestOptions</a>
    * @param headers the headers
    * @param version the websocket version
    * @param subProtocols the subprotocols to use
    * @param wsConnect handler that will be called with the websocket when connected
    * @param failureHandler handler that will be called if websocket connection fails
    * @return a reference to this, so the API can be used fluently
    */
  def websocket(options: JRequestOptions, headers: JMultiMap, version: io.vertx.core.http.WebsocketVersion, subProtocols: String, wsConnect: JWebSocket => Unit, failureHandler: Throwable => Unit): JHttpClient = {
    asJava.websocket(options.asJava, headers.asJava, version, subProtocols, (p:JWebSocket) => wsConnect(p), (p:Throwable) => failureHandler(p))
  }

  /**
    * Connect a WebSocket to the specified port, host and relative request URI, with the specified headers, using
    * the specified version of WebSockets, and the specified websocket sub protocols
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param headers the headers
    * @param version the websocket version
    * @param subProtocols the subprotocols to use
    * @param wsConnect handler that will be called with the websocket when connected
    * @param failureHandler handler that will be called if websocket connection fails
    * @return a reference to this, so the API can be used fluently
    */
  def websocket(port: java.lang.Integer, host: String, requestURI: String, headers: JMultiMap, version: io.vertx.core.http.WebsocketVersion, subProtocols: String, wsConnect: JWebSocket => Unit, failureHandler: Throwable => Unit): JHttpClient = {
    asJava.websocket(port, host, requestURI, headers.asJava, version, subProtocols, (p:JWebSocket) => wsConnect(p), (p:Throwable) => failureHandler(p))
  }

  /**
    * Connect a WebSocket to the specified host, relative request URI and default port, with the specified headers, using
    * the specified version of WebSockets, and the specified websocket sub protocols
    * @param host the host
    * @param requestURI the relative URI
    * @param headers the headers
    * @param version the websocket version
    * @param subProtocols the subprotocols to use
    * @param wsConnect handler that will be called with the websocket when connected
    * @return a reference to this, so the API can be used fluently
    */
  def websocket(host: String, requestURI: String, headers: JMultiMap, version: io.vertx.core.http.WebsocketVersion, subProtocols: String, wsConnect: JWebSocket => Unit): JHttpClient = {
    asJava.websocket(host, requestURI, headers.asJava, version, subProtocols, (p:JWebSocket) => wsConnect(p))
  }

  /**
    * Connect a WebSocket to the specified host, relative request URI and default port, with the specified headers, using
    * the specified version of WebSockets, and the specified websocket sub protocols
    * @param host the host
    * @param requestURI the relative URI
    * @param headers the headers
    * @param version the websocket version
    * @param subProtocols the subprotocols to use
    * @param wsConnect handler that will be called with the websocket when connected
    * @param failureHandler handler that will be called if websocket connection fails
    * @return a reference to this, so the API can be used fluently
    */
  def websocket(host: String, requestURI: String, headers: JMultiMap, version: io.vertx.core.http.WebsocketVersion, subProtocols: String, wsConnect: JWebSocket => Unit, failureHandler: Throwable => Unit): JHttpClient = {
    asJava.websocket(host, requestURI, headers.asJava, version, subProtocols, (p:JWebSocket) => wsConnect(p), (p:Throwable) => failureHandler(p))
  }

  /**
    * Connect a WebSocket at the relative request URI using the default host and port
    * @param requestURI the relative URI
    * @param wsConnect handler that will be called with the websocket when connected
    * @return a reference to this, so the API can be used fluently
    */
  def websocket(requestURI: String, wsConnect: JWebSocket => Unit): JHttpClient = {
    asJava.websocket(requestURI, (p:JWebSocket) => wsConnect(p))
  }

  /**
    * Connect a WebSocket at the relative request URI using the default host and port
    * @param requestURI the relative URI
    * @param wsConnect handler that will be called with the websocket when connected
    * @param failureHandler handler that will be called if websocket connection fails
    * @return a reference to this, so the API can be used fluently
    */
  def websocket(requestURI: String, wsConnect: JWebSocket => Unit, failureHandler: Throwable => Unit): JHttpClient = {
    asJava.websocket(requestURI, (p:JWebSocket) => wsConnect(p), (p:Throwable) => failureHandler(p))
  }

  /**
    * Connect a WebSocket at the relative request URI using the default host and port and the specified headers
    * @param requestURI the relative URI
    * @param headers the headers
    * @param wsConnect handler that will be called with the websocket when connected
    * @return a reference to this, so the API can be used fluently
    */
  def websocket(requestURI: String, headers: JMultiMap, wsConnect: JWebSocket => Unit): JHttpClient = {
    asJava.websocket(requestURI, headers.asJava, (p:JWebSocket) => wsConnect(p))
  }

  /**
    * Connect a WebSocket at the relative request URI using the default host and port and the specified headers
    * @param requestURI the relative URI
    * @param headers the headers
    * @param wsConnect handler that will be called with the websocket when connected
    * @param failureHandler handler that will be called if websocket connection fails
    * @return a reference to this, so the API can be used fluently
    */
  def websocket(requestURI: String, headers: JMultiMap, wsConnect: JWebSocket => Unit, failureHandler: Throwable => Unit): JHttpClient = {
    asJava.websocket(requestURI, headers.asJava, (p:JWebSocket) => wsConnect(p), (p:Throwable) => failureHandler(p))
  }

  /**
    * Connect a WebSocket at the relative request URI using the default host and port, the specified headers and the
    * specified version of WebSockets
    * @param requestURI the relative URI
    * @param headers the headers
    * @param version the websocket version
    * @param wsConnect handler that will be called with the websocket when connected
    * @return a reference to this, so the API can be used fluently
    */
  def websocket(requestURI: String, headers: JMultiMap, version: io.vertx.core.http.WebsocketVersion, wsConnect: JWebSocket => Unit): JHttpClient = {
    asJava.websocket(requestURI, headers.asJava, version, (p:JWebSocket) => wsConnect(p))
  }

  /**
    * Connect a WebSocket at the relative request URI using the default host and port, the specified headers and the
    * specified version of WebSockets
    * @param requestURI the relative URI
    * @param headers the headers
    * @param version the websocket version
    * @param wsConnect handler that will be called with the websocket when connected
    * @param failureHandler handler that will be called if websocket connection fails
    * @return a reference to this, so the API can be used fluently
    */
  def websocket(requestURI: String, headers: JMultiMap, version: io.vertx.core.http.WebsocketVersion, wsConnect: JWebSocket => Unit, failureHandler: Throwable => Unit): JHttpClient = {
    asJava.websocket(requestURI, headers.asJava, version, (p:JWebSocket) => wsConnect(p), (p:Throwable) => failureHandler(p))
  }

  /**
    * Connect a WebSocket at the relative request URI using the default host and port, the specified headers, the
    * specified version of WebSockets and the specified sub protocols
    * @param requestURI the relative URI
    * @param headers the headers
    * @param version the websocket version
    * @param subProtocols the subprotocols
    * @param wsConnect handler that will be called with the websocket when connected
    * @return a reference to this, so the API can be used fluently
    */
  def websocket(requestURI: String, headers: JMultiMap, version: io.vertx.core.http.WebsocketVersion, subProtocols: String, wsConnect: JWebSocket => Unit): JHttpClient = {
    asJava.websocket(requestURI, headers.asJava, version, subProtocols, (p:JWebSocket) => wsConnect(p))
  }

  /**
    * Connect a WebSocket at the relative request URI using the default host and port, the specified headers, the
    * specified version of WebSockets and the specified sub protocols
    * @param requestURI the relative URI
    * @param headers the headers
    * @param version the websocket version
    * @param subProtocols the subprotocols
    * @param wsConnect handler that will be called with the websocket when connected
    * @param failureHandler handler that will be called if websocket connection fails
    * @return a reference to this, so the API can be used fluently
    */
  def websocket(requestURI: String, headers: JMultiMap, version: io.vertx.core.http.WebsocketVersion, subProtocols: String, wsConnect: JWebSocket => Unit, failureHandler: Throwable => Unit): JHttpClient = {
    asJava.websocket(requestURI, headers.asJava, version, subProtocols, (p:JWebSocket) => wsConnect(p), (p:Throwable) => failureHandler(p))
  }

  /**
    * Set a redirect handler for the http client.
    * 
    * The redirect handler is called when a `3xx` response is received and the request is configured to
    * follow redirects with [[io.vertx.core.http.HttpClientRequest#setFollowRedirects]].
    * 
    * The redirect handler is passed the [[io.vertx.core.http.HttpClientResponse]], it can return an [[io.vertx.core.http.HttpClientRequest]] or `null`.
    * <ul>
    *   <li>when null is returned, the original response is processed by the original request response handler</li>
    *   <li>when a new `Future<HttpClientRequest>` is returned, the client will send this new request</li>
    * </ul>
    * The handler must return a `Future<HttpClientRequest>` unsent so the client can further configure it and send it.
    * @param handler the new redirect handler
    * @return a reference to this, so the API can be used fluently
    */
  def redirectHandler(handler: JHttpClientResponse => JFuture[JHttpClientRequest]): JHttpClient = {
    asJava.redirectHandler(a => handler(a).asJava)
  }

  /**
    * Whether the metrics are enabled for this measured object
    * @return true if the metrics are enabled
    */
  def isMetricsEnabled(): java.lang.Boolean = {
    asJava.isMetricsEnabled()
  }

  /**
    * Create an HTTP request to send to the server with the specified options.
    * @param method the HTTP method
    * @param options the request optionssee <a href="../../../../../../../cheatsheet/RequestOptions.html">RequestOptions</a>
    * @return an HTTP client request object
    */
  def request(method: io.vertx.core.http.HttpMethod, options: JRequestOptions): JHttpClientRequest = {
    asJava.request(method, options.asJava)
  }

  /**
    * Create an HTTP request to send to the server at the specified host and port.
    * @param method the HTTP method
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def request(method: io.vertx.core.http.HttpMethod, port: java.lang.Integer, host: String, requestURI: String): JHttpClientRequest = {
    asJava.request(method, port, host, requestURI)
  }

  /**
    * Create an HTTP request to send to the server at the specified host and default port.
    * @param method the HTTP method
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def request(method: io.vertx.core.http.HttpMethod, host: String, requestURI: String): JHttpClientRequest = {
    asJava.request(method, host, requestURI)
  }

  /**
    * Create an HTTP request to send to the server with the specified options, specifying a response handler to receive
    * @param method the HTTP method
    * @param options the request optionssee <a href="../../../../../../../cheatsheet/RequestOptions.html">RequestOptions</a>
    * @return an HTTP client request object
    */
  def request(method: io.vertx.core.http.HttpMethod, options: JRequestOptions, responseHandler: JHttpClientResponse => Unit): JHttpClientRequest = {
    asJava.request(method, options.asJava, (p:JHttpClientResponse) => responseHandler(p))
  }

  /**
    * Create an HTTP request to send to the server at the specified host and port, specifying a response handler to receive
    * the response
    * @param method the HTTP method
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def request(method: io.vertx.core.http.HttpMethod, port: java.lang.Integer, host: String, requestURI: String, responseHandler: JHttpClientResponse => Unit): JHttpClientRequest = {
    asJava.request(method, port, host, requestURI, (p:JHttpClientResponse) => responseHandler(p))
  }

  /**
    * Create an HTTP request to send to the server at the specified host and default port, specifying a response handler to receive
    * the response
    * @param method the HTTP method
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def request(method: io.vertx.core.http.HttpMethod, host: String, requestURI: String, responseHandler: JHttpClientResponse => Unit): JHttpClientRequest = {
    asJava.request(method, host, requestURI, (p:JHttpClientResponse) => responseHandler(p))
  }

  /**
    * Create an HTTP request to send to the server at the default host and port.
    * @param method the HTTP method
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def request(method: io.vertx.core.http.HttpMethod, requestURI: String): JHttpClientRequest = {
    asJava.request(method, requestURI)
  }

  /**
    * Create an HTTP request to send to the server at the default host and port, specifying a response handler to receive
    * the response
    * @param method the HTTP method
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def request(method: io.vertx.core.http.HttpMethod, requestURI: String, responseHandler: JHttpClientResponse => Unit): JHttpClientRequest = {
    asJava.request(method, requestURI, (p:JHttpClientResponse) => responseHandler(p))
  }

  /**
    * Create an HTTP request to send to the server using an absolute URI
    * @param method the HTTP method
    * @param absoluteURI the absolute URI
    * @return an HTTP client request object
    */
  def requestAbs(method: io.vertx.core.http.HttpMethod, absoluteURI: String): JHttpClientRequest = {
    asJava.requestAbs(method, absoluteURI)
  }

  /**
    * Create an HTTP request to send to the server using an absolute URI, specifying a response handler to receive
    * the response
    * @param method the HTTP method
    * @param absoluteURI the absolute URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def requestAbs(method: io.vertx.core.http.HttpMethod, absoluteURI: String, responseHandler: JHttpClientResponse => Unit): JHttpClientRequest = {
    asJava.requestAbs(method, absoluteURI, (p:JHttpClientResponse) => responseHandler(p))
  }

  /**
    * Create an HTTP GET request to send to the server with the specified options.
    * @param options the request optionssee <a href="../../../../../../../cheatsheet/RequestOptions.html">RequestOptions</a>
    * @return an HTTP client request object
    */
  def get(options: JRequestOptions): JHttpClientRequest = {
    asJava.get(options.asJava)
  }

  /**
    * Create an HTTP GET request to send to the server at the specified host and port.
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def get(port: java.lang.Integer, host: String, requestURI: String): JHttpClientRequest = {
    asJava.get(port, host, requestURI)
  }

  /**
    * Create an HTTP GET request to send to the server at the specified host and default port.
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def get(host: String, requestURI: String): JHttpClientRequest = {
    asJava.get(host, requestURI)
  }

  /**
    * Create an HTTP GET request to send to the server with the specified options, specifying a response handler to receive
    * the response
    * @param options the request optionssee <a href="../../../../../../../cheatsheet/RequestOptions.html">RequestOptions</a>
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def get(options: JRequestOptions, responseHandler: JHttpClientResponse => Unit): JHttpClientRequest = {
    asJava.get(options.asJava, (p:JHttpClientResponse) => responseHandler(p))
  }

  /**
    * Create an HTTP GET request to send to the server at the specified host and port, specifying a response handler to receive
    * the response
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def get(port: java.lang.Integer, host: String, requestURI: String, responseHandler: JHttpClientResponse => Unit): JHttpClientRequest = {
    asJava.get(port, host, requestURI, (p:JHttpClientResponse) => responseHandler(p))
  }

  /**
    * Create an HTTP GET request to send to the server at the specified host and default port, specifying a response handler to receive
    * the response
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def get(host: String, requestURI: String, responseHandler: JHttpClientResponse => Unit): JHttpClientRequest = {
    asJava.get(host, requestURI, (p:JHttpClientResponse) => responseHandler(p))
  }

  /**
    * Create an HTTP GET request to send to the server at the default host and port.
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def get(requestURI: String): JHttpClientRequest = {
    asJava.get(requestURI)
  }

  /**
    * Create an HTTP GET request to send to the server at the default host and port, specifying a response handler to receive
    * the response
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def get(requestURI: String, responseHandler: JHttpClientResponse => Unit): JHttpClientRequest = {
    asJava.get(requestURI, (p:JHttpClientResponse) => responseHandler(p))
  }

  /**
    * Create an HTTP GET request to send to the server using an absolute URI
    * @param absoluteURI the absolute URI
    * @return an HTTP client request object
    */
  def getAbs(absoluteURI: String): JHttpClientRequest = {
    asJava.getAbs(absoluteURI)
  }

  /**
    * Create an HTTP GET request to send to the server using an absolute URI, specifying a response handler to receive
    * the response
    * @param absoluteURI the absolute URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def getAbs(absoluteURI: String, responseHandler: JHttpClientResponse => Unit): JHttpClientRequest = {
    asJava.getAbs(absoluteURI, (p:JHttpClientResponse) => responseHandler(p))
  }

  /**
    * Create an HTTP POST request to send to the server with the specified options.
    * @param options the request optionssee <a href="../../../../../../../cheatsheet/RequestOptions.html">RequestOptions</a>
    * @return an HTTP client request object
    */
  def post(options: JRequestOptions): JHttpClientRequest = {
    asJava.post(options.asJava)
  }

  /**
    * Create an HTTP POST request to send to the server at the specified host and port.
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def post(port: java.lang.Integer, host: String, requestURI: String): JHttpClientRequest = {
    asJava.post(port, host, requestURI)
  }

  /**
    * Create an HTTP POST request to send to the server at the specified host and default port.
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def post(host: String, requestURI: String): JHttpClientRequest = {
    asJava.post(host, requestURI)
  }

  /**
    * Create an HTTP POST request to send to the server with the specified options, specifying a response handler to receive
    * the response
    * @param options the request optionssee <a href="../../../../../../../cheatsheet/RequestOptions.html">RequestOptions</a>
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def post(options: JRequestOptions, responseHandler: JHttpClientResponse => Unit): JHttpClientRequest = {
    asJava.post(options.asJava, (p:JHttpClientResponse) => responseHandler(p))
  }

  /**
    * Create an HTTP POST request to send to the server at the specified host and port, specifying a response handler to receive
    * the response
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def post(port: java.lang.Integer, host: String, requestURI: String, responseHandler: JHttpClientResponse => Unit): JHttpClientRequest = {
    asJava.post(port, host, requestURI, (p:JHttpClientResponse) => responseHandler(p))
  }

  /**
    * Create an HTTP POST request to send to the server at the specified host and default port, specifying a response handler to receive
    * the response
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def post(host: String, requestURI: String, responseHandler: JHttpClientResponse => Unit): JHttpClientRequest = {
    asJava.post(host, requestURI, (p:JHttpClientResponse) => responseHandler(p))
  }

  /**
    * Create an HTTP POST request to send to the server at the default host and port.
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def post(requestURI: String): JHttpClientRequest = {
    asJava.post(requestURI)
  }

  /**
    * Create an HTTP POST request to send to the server at the default host and port, specifying a response handler to receive
    * the response
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def post(requestURI: String, responseHandler: JHttpClientResponse => Unit): JHttpClientRequest = {
    asJava.post(requestURI, (p:JHttpClientResponse) => responseHandler(p))
  }

  /**
    * Create an HTTP POST request to send to the server using an absolute URI
    * @param absoluteURI the absolute URI
    * @return an HTTP client request object
    */
  def postAbs(absoluteURI: String): JHttpClientRequest = {
    asJava.postAbs(absoluteURI)
  }

  /**
    * Create an HTTP POST request to send to the server using an absolute URI, specifying a response handler to receive
    * the response
    * @param absoluteURI the absolute URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def postAbs(absoluteURI: String, responseHandler: JHttpClientResponse => Unit): JHttpClientRequest = {
    asJava.postAbs(absoluteURI, (p:JHttpClientResponse) => responseHandler(p))
  }

  /**
    * Create an HTTP HEAD request to send to the server with the specified options.
    * @param options the request optionssee <a href="../../../../../../../cheatsheet/RequestOptions.html">RequestOptions</a>
    * @return an HTTP client request object
    */
  def head(options: JRequestOptions): JHttpClientRequest = {
    asJava.head(options.asJava)
  }

  /**
    * Create an HTTP HEAD request to send to the server at the specified host and port.
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def head(port: java.lang.Integer, host: String, requestURI: String): JHttpClientRequest = {
    asJava.head(port, host, requestURI)
  }

  /**
    * Create an HTTP HEAD request to send to the server at the specified host and default port.
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def head(host: String, requestURI: String): JHttpClientRequest = {
    asJava.head(host, requestURI)
  }

  /**
    * Create an HTTP HEAD request to send to the server with the specified options, specifying a response handler to receive
    * the response
    * @param options the request optionssee <a href="../../../../../../../cheatsheet/RequestOptions.html">RequestOptions</a>
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def head(options: JRequestOptions, responseHandler: JHttpClientResponse => Unit): JHttpClientRequest = {
    asJava.head(options.asJava, (p:JHttpClientResponse) => responseHandler(p))
  }

  /**
    * Create an HTTP HEAD request to send to the server at the specified host and port, specifying a response handler to receive
    * the response
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def head(port: java.lang.Integer, host: String, requestURI: String, responseHandler: JHttpClientResponse => Unit): JHttpClientRequest = {
    asJava.head(port, host, requestURI, (p:JHttpClientResponse) => responseHandler(p))
  }

  /**
    * Create an HTTP HEAD request to send to the server at the specified host and default port, specifying a response handler to receive
    * the response
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def head(host: String, requestURI: String, responseHandler: JHttpClientResponse => Unit): JHttpClientRequest = {
    asJava.head(host, requestURI, (p:JHttpClientResponse) => responseHandler(p))
  }

  /**
    * Create an HTTP HEAD request to send to the server at the default host and port.
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def head(requestURI: String): JHttpClientRequest = {
    asJava.head(requestURI)
  }

  /**
    * Create an HTTP HEAD request to send to the server at the default host and port, specifying a response handler to receive
    * the response
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def head(requestURI: String, responseHandler: JHttpClientResponse => Unit): JHttpClientRequest = {
    asJava.head(requestURI, (p:JHttpClientResponse) => responseHandler(p))
  }

  /**
    * Create an HTTP HEAD request to send to the server using an absolute URI
    * @param absoluteURI the absolute URI
    * @return an HTTP client request object
    */
  def headAbs(absoluteURI: String): JHttpClientRequest = {
    asJava.headAbs(absoluteURI)
  }

  /**
    * Create an HTTP HEAD request to send to the server using an absolute URI, specifying a response handler to receive
    * the response
    * @param absoluteURI the absolute URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def headAbs(absoluteURI: String, responseHandler: JHttpClientResponse => Unit): JHttpClientRequest = {
    asJava.headAbs(absoluteURI, (p:JHttpClientResponse) => responseHandler(p))
  }

  /**
    * Create an HTTP OPTIONS request to send to the server with the specified options.
    * @param options the request optionssee <a href="../../../../../../../cheatsheet/RequestOptions.html">RequestOptions</a>
    * @return an HTTP client request object
    */
  def options(options: JRequestOptions): JHttpClientRequest = {
    asJava.options(options.asJava)
  }

  /**
    * Create an HTTP OPTIONS request to send to the server at the specified host and port.
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def options(port: java.lang.Integer, host: String, requestURI: String): JHttpClientRequest = {
    asJava.options(port, host, requestURI)
  }

  /**
    * Create an HTTP OPTIONS request to send to the server at the specified host and default port.
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def options(host: String, requestURI: String): JHttpClientRequest = {
    asJava.options(host, requestURI)
  }

  /**
    * Create an HTTP OPTIONS request to send to the server with the specified options, specifying a response handler to receive
    * the response
    * @param options the request optionssee <a href="../../../../../../../cheatsheet/RequestOptions.html">RequestOptions</a>
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def options(options: JRequestOptions, responseHandler: JHttpClientResponse => Unit): JHttpClientRequest = {
    asJava.options(options.asJava, (p:JHttpClientResponse) => responseHandler(p))
  }

  /**
    * Create an HTTP OPTIONS request to send to the server at the specified host and port, specifying a response handler to receive
    * the response
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def options(port: java.lang.Integer, host: String, requestURI: String, responseHandler: JHttpClientResponse => Unit): JHttpClientRequest = {
    asJava.options(port, host, requestURI, (p:JHttpClientResponse) => responseHandler(p))
  }

  /**
    * Create an HTTP OPTIONS request to send to the server at the specified host and default port, specifying a response handler to receive
    * the response
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def options(host: String, requestURI: String, responseHandler: JHttpClientResponse => Unit): JHttpClientRequest = {
    asJava.options(host, requestURI, (p:JHttpClientResponse) => responseHandler(p))
  }

  /**
    * Create an HTTP OPTIONS request to send to the server at the default host and port.
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def options(requestURI: String): JHttpClientRequest = {
    asJava.options(requestURI)
  }

  /**
    * Create an HTTP OPTIONS request to send to the server at the default host and port, specifying a response handler to receive
    * the response
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def options(requestURI: String, responseHandler: JHttpClientResponse => Unit): JHttpClientRequest = {
    asJava.options(requestURI, (p:JHttpClientResponse) => responseHandler(p))
  }

  /**
    * Create an HTTP OPTIONS request to send to the server using an absolute URI
    * @param absoluteURI the absolute URI
    * @return an HTTP client request object
    */
  def optionsAbs(absoluteURI: String): JHttpClientRequest = {
    asJava.optionsAbs(absoluteURI)
  }

  /**
    * Create an HTTP OPTIONS request to send to the server using an absolute URI, specifying a response handler to receive
    * the response
    * @param absoluteURI the absolute URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def optionsAbs(absoluteURI: String, responseHandler: JHttpClientResponse => Unit): JHttpClientRequest = {
    asJava.optionsAbs(absoluteURI, (p:JHttpClientResponse) => responseHandler(p))
  }

  /**
    * Create an HTTP PUT request to send to the server with the specified options.
    * @param options the request optionssee <a href="../../../../../../../cheatsheet/RequestOptions.html">RequestOptions</a>
    * @return an HTTP client request object
    */
  def put(options: JRequestOptions): JHttpClientRequest = {
    asJava.put(options.asJava)
  }

  /**
    * Create an HTTP PUT request to send to the server at the specified host and port.
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def put(port: java.lang.Integer, host: String, requestURI: String): JHttpClientRequest = {
    asJava.put(port, host, requestURI)
  }

  /**
    * Create an HTTP PUT request to send to the server at the specified host and default port.
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def put(host: String, requestURI: String): JHttpClientRequest = {
    asJava.put(host, requestURI)
  }

  /**
    * Create an HTTP PUT request to send to the server with the specified options, specifying a response handler to receive
    * the response
    * @param options the request optionssee <a href="../../../../../../../cheatsheet/RequestOptions.html">RequestOptions</a>
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def put(options: JRequestOptions, responseHandler: JHttpClientResponse => Unit): JHttpClientRequest = {
    asJava.put(options.asJava, (p:JHttpClientResponse) => responseHandler(p))
  }

  /**
    * Create an HTTP PUT request to send to the server at the specified host and port, specifying a response handler to receive
    * the response
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def put(port: java.lang.Integer, host: String, requestURI: String, responseHandler: JHttpClientResponse => Unit): JHttpClientRequest = {
    asJava.put(port, host, requestURI, (p:JHttpClientResponse) => responseHandler(p))
  }

  /**
    * Create an HTTP PUT request to send to the server at the specified host and default port, specifying a response handler to receive
    * the response
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def put(host: String, requestURI: String, responseHandler: JHttpClientResponse => Unit): JHttpClientRequest = {
    asJava.put(host, requestURI, (p:JHttpClientResponse) => responseHandler(p))
  }

  /**
    * Create an HTTP PUT request to send to the server at the default host and port.
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def put(requestURI: String): JHttpClientRequest = {
    asJava.put(requestURI)
  }

  /**
    * Create an HTTP PUT request to send to the server at the default host and port, specifying a response handler to receive
    * the response
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def put(requestURI: String, responseHandler: JHttpClientResponse => Unit): JHttpClientRequest = {
    asJava.put(requestURI, (p:JHttpClientResponse) => responseHandler(p))
  }

  /**
    * Create an HTTP PUT request to send to the server using an absolute URI
    * @param absoluteURI the absolute URI
    * @return an HTTP client request object
    */
  def putAbs(absoluteURI: String): JHttpClientRequest = {
    asJava.putAbs(absoluteURI)
  }

  /**
    * Create an HTTP PUT request to send to the server using an absolute URI, specifying a response handler to receive
    * the response
    * @param absoluteURI the absolute URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def putAbs(absoluteURI: String, responseHandler: JHttpClientResponse => Unit): JHttpClientRequest = {
    asJava.putAbs(absoluteURI, (p:JHttpClientResponse) => responseHandler(p))
  }

  /**
    * Create an HTTP DELETE request to send to the server with the specified options.
    * @param options the request optionssee <a href="../../../../../../../cheatsheet/RequestOptions.html">RequestOptions</a>
    * @return an HTTP client request object
    */
  def delete(options: JRequestOptions): JHttpClientRequest = {
    asJava.delete(options.asJava)
  }

  /**
    * Create an HTTP DELETE request to send to the server at the specified host and port.
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def delete(port: java.lang.Integer, host: String, requestURI: String): JHttpClientRequest = {
    asJava.delete(port, host, requestURI)
  }

  /**
    * Create an HTTP DELETE request to send to the server at the specified host and default port.
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def delete(host: String, requestURI: String): JHttpClientRequest = {
    asJava.delete(host, requestURI)
  }

  /**
    * Create an HTTP DELETE request to send to the server with the specified options, specifying a response handler to receive
    * the response
    * @param options the request optionssee <a href="../../../../../../../cheatsheet/RequestOptions.html">RequestOptions</a>
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def delete(options: JRequestOptions, responseHandler: JHttpClientResponse => Unit): JHttpClientRequest = {
    asJava.delete(options.asJava, (p:JHttpClientResponse) => responseHandler(p))
  }

  /**
    * Create an HTTP DELETE request to send to the server at the specified host and port, specifying a response handler to receive
    * the response
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def delete(port: java.lang.Integer, host: String, requestURI: String, responseHandler: JHttpClientResponse => Unit): JHttpClientRequest = {
    asJava.delete(port, host, requestURI, (p:JHttpClientResponse) => responseHandler(p))
  }

  /**
    * Create an HTTP DELETE request to send to the server at the specified host and default port, specifying a response handler to receive
    * the response
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def delete(host: String, requestURI: String, responseHandler: JHttpClientResponse => Unit): JHttpClientRequest = {
    asJava.delete(host, requestURI, (p:JHttpClientResponse) => responseHandler(p))
  }

  /**
    * Create an HTTP DELETE request to send to the server at the default host and port.
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def delete(requestURI: String): JHttpClientRequest = {
    asJava.delete(requestURI)
  }

  /**
    * Create an HTTP DELETE request to send to the server at the default host and port, specifying a response handler to receive
    * the response
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def delete(requestURI: String, responseHandler: JHttpClientResponse => Unit): JHttpClientRequest = {
    asJava.delete(requestURI, (p:JHttpClientResponse) => responseHandler(p))
  }

  /**
    * Create an HTTP DELETE request to send to the server using an absolute URI
    * @param absoluteURI the absolute URI
    * @return an HTTP client request object
    */
  def deleteAbs(absoluteURI: String): JHttpClientRequest = {
    asJava.deleteAbs(absoluteURI)
  }

  /**
    * Create an HTTP DELETE request to send to the server using an absolute URI, specifying a response handler to receive
    * the response
    * @param absoluteURI the absolute URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def deleteAbs(absoluteURI: String, responseHandler: JHttpClientResponse => Unit): JHttpClientRequest = {
    asJava.deleteAbs(absoluteURI, (p:JHttpClientResponse) => responseHandler(p))
  }

  /**
    * Create a WebSocket stream with the specified options
    * @param options the request optionssee <a href="../../../../../../../cheatsheet/RequestOptions.html">RequestOptions</a>
    * @return a stream emitting a WebSocket event when the client connection has been upgraded to a websocket
    */
  def websocketStream(options: JRequestOptions): JReadStream[JWebSocket] = {
    asJava.websocketStream(options.asJava)
  }

  /**
    * Create a WebSocket stream to the specified port, host and relative request URI
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @return a stream emitting a WebSocket event when the client connection has been upgraded to a websocket
    */
  def websocketStream(port: java.lang.Integer, host: String, requestURI: String): JReadStream[JWebSocket] = {
    asJava.websocketStream(port, host, requestURI)
  }

  /**
    * Create a WebSocket stream to the specified host, relative request URI and default port
    * @param host the host
    * @param requestURI the relative URI
    * @return a stream emitting a WebSocket event when the client connection has been upgraded to a websocket
    */
  def websocketStream(host: String, requestURI: String): JReadStream[JWebSocket] = {
    asJava.websocketStream(host, requestURI)
  }

  /**
    * Create a WebSocket stream with the specified options, and with the specified headers
    * @param options the request optionssee <a href="../../../../../../../cheatsheet/RequestOptions.html">RequestOptions</a>
    * @param headers the headers
    * @return a stream emitting a WebSocket event when the client connection has been upgraded to a websocket
    */
  def websocketStream(options: JRequestOptions, headers: JMultiMap): JReadStream[JWebSocket] = {
    asJava.websocketStream(options.asJava, headers.asJava)
  }

  /**
    * Create a WebSocket stream to the specified port, host and relative request URI, and with the specified headers
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param headers the headers
    * @return a stream emitting a WebSocket event when the client connection has been upgraded to a websocket
    */
  def websocketStream(port: java.lang.Integer, host: String, requestURI: String, headers: JMultiMap): JReadStream[JWebSocket] = {
    asJava.websocketStream(port, host, requestURI, headers.asJava)
  }

  /**
    * Create a WebSocket stream to the specified host, relative request URI and default port and with the specified headers
    * @param host the host
    * @param requestURI the relative URI
    * @param headers the headers
    * @return a stream emitting a WebSocket event when the client connection has been upgraded to a websocket
    */
  def websocketStream(host: String, requestURI: String, headers: JMultiMap): JReadStream[JWebSocket] = {
    asJava.websocketStream(host, requestURI, headers.asJava)
  }

  /**
    * Create a WebSocket stream with the specified options, with the specified headers and using
    * the specified version of WebSockets
    * @param options the request optionssee <a href="../../../../../../../cheatsheet/RequestOptions.html">RequestOptions</a>
    * @param headers the headers
    * @param version the websocket version
    * @return a stream emitting a WebSocket event when the client connection has been upgraded to a websocket
    */
  def websocketStream(options: JRequestOptions, headers: JMultiMap, version: io.vertx.core.http.WebsocketVersion): JReadStream[JWebSocket] = {
    asJava.websocketStream(options.asJava, headers.asJava, version)
  }

  /**
    * Create a WebSocket stream to the specified port, host and relative request URI, with the specified headers and using
    * the specified version of WebSockets
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param headers the headers
    * @param version the websocket version
    * @return a stream emitting a WebSocket event when the client connection has been upgraded to a websocket
    */
  def websocketStream(port: java.lang.Integer, host: String, requestURI: String, headers: JMultiMap, version: io.vertx.core.http.WebsocketVersion): JReadStream[JWebSocket] = {
    asJava.websocketStream(port, host, requestURI, headers.asJava, version)
  }

  /**
    * Create a WebSocket stream with the specified options and with the specified headers and using
    * the specified version of WebSockets
    * @param host the host
    * @param requestURI the relative URI
    * @param headers the headers
    * @param version the websocket version
    * @return a stream emitting a WebSocket event when the client connection has been upgraded to a websocket
    */
  def websocketStream(host: String, requestURI: String, headers: JMultiMap, version: io.vertx.core.http.WebsocketVersion): JReadStream[JWebSocket] = {
    asJava.websocketStream(host, requestURI, headers.asJava, version)
  }

  /**
    * Create a WebSocket stream with the specified absolute url, the specified headers, using the specified version of WebSockets,
    * and the specified websocket sub protocols.
    * @param url the absolute url
    * @param headers the headers
    * @param version the websocket version
    * @param subProtocols the subprotocols to use
    * @return a stream emitting a WebSocket event when the client connection has been upgraded to a websocket
    */
  def websocketStreamAbs(url: String, headers: JMultiMap, version: io.vertx.core.http.WebsocketVersion, subProtocols: String): JReadStream[JWebSocket] = {
    asJava.websocketStreamAbs(url, headers.asJava, version, subProtocols)
  }

  /**
    * Create a WebSocket stream to the specified port, host and relative request URI, with the specified headers, using
    * the specified version of WebSockets, and the specified websocket sub protocols
    * @param options the request optionssee <a href="../../../../../../../cheatsheet/RequestOptions.html">RequestOptions</a>
    * @param headers the headers
    * @param version the websocket version
    * @param subProtocols the subprotocols to use
    * @return a stream emitting a WebSocket event when the client connection has been upgraded to a websocket
    */
  def websocketStream(options: JRequestOptions, headers: JMultiMap, version: io.vertx.core.http.WebsocketVersion, subProtocols: String): JReadStream[JWebSocket] = {
    asJava.websocketStream(options.asJava, headers.asJava, version, subProtocols)
  }

  /**
    * Create a WebSocket stream to the specified port, host and relative request URI, with the specified headers, using
    * the specified version of WebSockets, and the specified websocket sub protocols
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param headers the headers
    * @param version the websocket version
    * @param subProtocols the subprotocols to use
    * @return a stream emitting a WebSocket event when the client connection has been upgraded to a websocket
    */
  def websocketStream(port: java.lang.Integer, host: String, requestURI: String, headers: JMultiMap, version: io.vertx.core.http.WebsocketVersion, subProtocols: String): JReadStream[JWebSocket] = {
    asJava.websocketStream(port, host, requestURI, headers.asJava, version, subProtocols)
  }

  /**
    * Create a WebSocket stream to the specified host, relative request URI and default port, with the specified headers, using
    * the specified version of WebSockets, and the specified websocket sub protocols
    * @param host the host
    * @param requestURI the relative URI
    * @param headers the headers
    * @param version the websocket version
    * @param subProtocols the subprotocols to use
    * @return a stream emitting a WebSocket event when the client connection has been upgraded to a websocket
    */
  def websocketStream(host: String, requestURI: String, headers: JMultiMap, version: io.vertx.core.http.WebsocketVersion, subProtocols: String): JReadStream[JWebSocket] = {
    asJava.websocketStream(host, requestURI, headers.asJava, version, subProtocols)
  }

  /**
    * Create a WebSocket stream at the relative request URI using the default host and port and the specified headers
    * @param requestURI the relative URI
    * @return a stream emitting a WebSocket event when the client connection has been upgraded to a websocket
    */
  def websocketStream(requestURI: String): JReadStream[JWebSocket] = {
    asJava.websocketStream(requestURI)
  }

  /**
    * Create a WebSocket stream at the relative request URI using the default host and port and the specified headers
    * @param requestURI the relative URI
    * @param headers the headers
    * @return a stream emitting a WebSocket event when the client connection has been upgraded to a websocket
    */
  def websocketStream(requestURI: String, headers: JMultiMap): JReadStream[JWebSocket] = {
    asJava.websocketStream(requestURI, headers.asJava)
  }

  /**
    * Create a WebSocket stream at the relative request URI using the default host and port, the specified headers and the
    * specified version of WebSockets
    * @param requestURI the relative URI
    * @param headers the headers
    * @param version the websocket version
    * @return a stream emitting a WebSocket event when the client connection has been upgraded to a websocket
    */
  def websocketStream(requestURI: String, headers: JMultiMap, version: io.vertx.core.http.WebsocketVersion): JReadStream[JWebSocket] = {
    asJava.websocketStream(requestURI, headers.asJava, version)
  }

  /**
    * Create a WebSocket stream at the relative request URI using the default host and port, the specified headers, the
    * specified version of WebSockets and the specified sub protocols
    * @param requestURI the relative URI
    * @param headers the headers
    * @param version the websocket version
    * @param subProtocols the subprotocols
    * @return a stream emitting a WebSocket event when the client connection has been upgraded to a websocket
    */
  def websocketStream(requestURI: String, headers: JMultiMap, version: io.vertx.core.http.WebsocketVersion, subProtocols: String): JReadStream[JWebSocket] = {
    asJava.websocketStream(requestURI, headers.asJava, version, subProtocols)
  }

  /**
    * Close the client. Closing will close down any pooled connections.
    * Clients should always be closed after use.
    */
  def close(): Unit = {
    asJava.close()
  }

}

import io.vertx.core.net.ProxyOptions
import io.vertx.core.net.JksOptions
import io.vertx.core.net.{PfxOptions => JPfxOptions}
import io.vertx.core.http.{HttpClientOptions => JHttpClientOptions}
import io.vertx.core.http.Http2Settings
import io.vertx.core.net.PfxOptions
import io.vertx.core.net.OpenSSLEngineOptions
import io.vertx.core.buffer.Buffer
import io.vertx.core.net.ClientOptionsBase
import io.vertx.core.http.HttpVersion
import io.vertx.core.net.{OpenSSLEngineOptions => JOpenSSLEngineOptions}
import io.vertx.core.net.PemKeyCertOptions
import io.vertx.core.net.{JdkSSLEngineOptions => JJdkSSLEngineOptions}
import io.vertx.core.net.{PemTrustOptions => JPemTrustOptions}
import io.vertx.core.net.{ClientOptionsBase => JClientOptionsBase}
import io.vertx.core.net.{PemKeyCertOptions => JPemKeyCertOptions}
import io.vertx.core.net.PemTrustOptions
import io.vertx.core.net.{ProxyOptions => JProxyOptions}
import io.vertx.core.http.{Http2Settings => JHttp2Settings}
import io.vertx.core.net.JdkSSLEngineOptions
import io.vertx.core.net.{JksOptions => JJksOptions}

/**
  * Options describing how an [[io.vertx.core.http.HttpClient]] will make connections.
  */

  implicit class HttpClientOptionsScala(val asJava: JHttpClientOptions) extends AnyVal {


  /**
    * Set the list of protocol versions to provide to the server during the Application-Layer Protocol Negotiation.
    * When the list is empty, the client provides a best effort list according to <a href="../../../../../../../cheatsheet/HttpClientOptions.html">HttpClientOptions</a>:
    *
    * <ul>
    *   <li>: [ "h2", "http/1.1" ]</li>
    *   <li>otherwise: [<a href="../../../../../../../cheatsheet/HttpClientOptions.html">HttpClientOptions</a>]</li>
    * </ul>
    */
    def setAlpnVersions(value: List[io.vertx.core.http.HttpVersion]) = {
      asJava.setAlpnVersions(value.asJava)
      }
    def getAlpnVersions: scala.collection.mutable.Buffer[io.vertx.core.http.HttpVersion] = {
      asJava.getAlpnVersions().asScala
    }

  /**
    * Set the connect timeout
    */
    def setConnectTimeout(value: java.lang.Integer) = {
      asJava.setConnectTimeout(value)
    }
    def getConnectTimeout: java.lang.Integer = {
      asJava.getConnectTimeout()
    }

  /**
    * Add a CRL path
    */
    def addCrlPath(value: String) = {
      asJava.addCrlPath(value)
      }
    def getCrlPaths: scala.collection.mutable.Buffer[String] = {
      asJava.getCrlPaths().asScala
    }

  /**
    * Add a CRL value
    */
    def addCrlValue(value: io.vertx.core.buffer.Buffer) = {
      asJava.addCrlValue(value)
      }
    def getCrlValues: scala.collection.mutable.Buffer[io.vertx.core.buffer.Buffer] = {
      asJava.getCrlValues().asScala
    }

  /**
    * set to `initialBufferSizeHttpDecoder` the initial buffer of the HttpDecoder.
    */
    def setDecoderInitialBufferSize(value: java.lang.Integer) = {
      asJava.setDecoderInitialBufferSize(value)
    }
    def getDecoderInitialBufferSize: java.lang.Integer = {
      asJava.getDecoderInitialBufferSize()
    }

  /**
    * Set the default host name to be used by this client in requests if none is provided when making the request.
    */
    def setDefaultHost(value: String) = {
      asJava.setDefaultHost(value)
    }
    def getDefaultHost: String = {
      asJava.getDefaultHost()
    }

  /**
    * Set the default port to be used by this client in requests if none is provided when making the request.
    */
    def setDefaultPort(value: java.lang.Integer) = {
      asJava.setDefaultPort(value)
    }
    def getDefaultPort: java.lang.Integer = {
      asJava.getDefaultPort()
    }

  /**
    * Add an enabled cipher suite, appended to the ordered suites.
    */
    def addEnabledCipherSuite(value: String) = {
      asJava.addEnabledCipherSuite(value)
      }
    def getEnabledCipherSuites: scala.collection.mutable.Set[String] = {
      asJava.getEnabledCipherSuites().asScala
    }

  /**
    * Sets the list of enabled SSL/TLS protocols.
    */
    def addEnabledSecureTransportProtocol(value: String) = {
      asJava.addEnabledSecureTransportProtocol(value)
      }
    def setEnabledSecureTransportProtocols(value: Set[String]) = {
      asJava.setEnabledSecureTransportProtocols(value.asJava)
    }
    def getEnabledSecureTransportProtocols: scala.collection.mutable.Set[String] = {
      asJava.getEnabledSecureTransportProtocols().asScala
    }

  /**
    * By default, the server name is only sent for Fully Qualified Domain Name (FQDN), setting
    * this property to `true` forces the server name to be always sent.
    */
    def setForceSni(value: java.lang.Boolean) = {
      asJava.setForceSni(value)
    }
    def isForceSni: java.lang.Boolean = {
      asJava.isForceSni()
    }

  /**
    * Set to `true` when an <i>h2c</i> connection is established using an HTTP/1.1 upgrade request, and `false`
    * when an <i>h2c</i> connection is established directly (with prior knowledge).
    */
    def setHttp2ClearTextUpgrade(value: java.lang.Boolean) = {
      asJava.setHttp2ClearTextUpgrade(value)
    }
    def isHttp2ClearTextUpgrade: java.lang.Boolean = {
      asJava.isHttp2ClearTextUpgrade()
    }

  /**
    * Set the default HTTP/2 connection window size. It overrides the initial window
    * size set by <a href="../../../../../../../cheatsheet/Http2Settings.html">Http2Settings</a>, so the connection window size
    * is greater than for its streams, in order the data throughput.
    * <p/>
    * A value of `-1` reuses the initial window size setting.
    */
    def setHttp2ConnectionWindowSize(value: java.lang.Integer) = {
      asJava.setHttp2ConnectionWindowSize(value)
    }
    def getHttp2ConnectionWindowSize: java.lang.Integer = {
      asJava.getHttp2ConnectionWindowSize()
    }

  /**
    * Set the maximum pool size for HTTP/2 connections
    */
    def setHttp2MaxPoolSize(value: java.lang.Integer) = {
      asJava.setHttp2MaxPoolSize(value)
    }
    def getHttp2MaxPoolSize: java.lang.Integer = {
      asJava.getHttp2MaxPoolSize()
    }

  /**
    * Set a client limit of the number concurrent streams for each HTTP/2 connection, this limits the number
    * of streams the client can create for a connection. The effective number of streams for a
    * connection is the min of this value and the server's initial settings.
    * <p/>
    * Setting the value to `-1` means to use the value sent by the server's initial settings.
    * `-1` is the default value.
    */
    def setHttp2MultiplexingLimit(value: java.lang.Integer) = {
      asJava.setHttp2MultiplexingLimit(value)
    }
    def getHttp2MultiplexingLimit: java.lang.Integer = {
      asJava.getHttp2MultiplexingLimit()
    }

  /**
    * Set the idle timeout, in seconds. zero means don't timeout.
    * This determines if a connection will timeout and be closed if no data is received within the timeout.
    */
    def setIdleTimeout(value: java.lang.Integer) = {
      asJava.setIdleTimeout(value)
    }
    def getIdleTimeout: java.lang.Integer = {
      asJava.getIdleTimeout()
    }

  /**
    * Set the HTTP/2 connection settings immediately sent by to the server when the client connects.
    */
    def setInitialSettings(value: JHttp2Settings) = {
      asJava.setInitialSettings(value.asJava)
    }
    def getInitialSettings: JHttp2Settings = {
      asJava.getInitialSettings()
    }
    def setJdkSslEngineOptions(value: JJdkSSLEngineOptions) = {
      asJava.setJdkSslEngineOptions(value.asJava)
    }
    def getJdkSslEngineOptions: JJdkSSLEngineOptions = {
      asJava.getJdkSslEngineOptions()
    }

  /**
    * Set whether keep alive is enabled on the client
    */
    def setKeepAlive(value: java.lang.Boolean) = {
      asJava.setKeepAlive(value)
    }
    def isKeepAlive: java.lang.Boolean = {
      asJava.isKeepAlive()
    }

  /**
    * Set the key/cert options in jks format, aka Java keystore.
    */
    def setKeyStoreOptions(value: JJksOptions) = {
      asJava.setKeyStoreOptions(value.asJava)
    }
    def getKeyStoreOptions: JJksOptions = {
      asJava.getKeyStoreOptions()
    }

  /**
    * Set the local interface to bind for network connections. When the local address is null,
    * it will pick any local address, the default local address is null.
    */
    def setLocalAddress(value: String) = {
      asJava.setLocalAddress(value)
    }
    def getLocalAddress: String = {
      asJava.getLocalAddress()
    }

  /**
    * Set to true to enabled network activity logging: Netty's pipeline is configured for logging on Netty's logger.
    */
    def setLogActivity(value: java.lang.Boolean) = {
      asJava.setLogActivity(value)
    }
    def getLogActivity: java.lang.Boolean = {
      asJava.getLogActivity()
    }

  /**
    * Set the maximum HTTP chunk size
    */
    def setMaxChunkSize(value: java.lang.Integer) = {
      asJava.setMaxChunkSize(value)
    }
    def getMaxChunkSize: java.lang.Integer = {
      asJava.getMaxChunkSize()
    }

  /**
    * Set the maximum length of all headers for HTTP/1.x .
    */
    def setMaxHeaderSize(value: java.lang.Integer) = {
      asJava.setMaxHeaderSize(value)
    }
    def getMaxHeaderSize: java.lang.Integer = {
      asJava.getMaxHeaderSize()
    }

  /**
    * Set the maximum length of the initial line for HTTP/1.x (e.g. `"HTTP/1.1 200 OK"`)
    */
    def setMaxInitialLineLength(value: java.lang.Integer) = {
      asJava.setMaxInitialLineLength(value)
    }
    def getMaxInitialLineLength: java.lang.Integer = {
      asJava.getMaxInitialLineLength()
    }

  /**
    * Set the maximum pool size for connections
    */
    def setMaxPoolSize(value: java.lang.Integer) = {
      asJava.setMaxPoolSize(value)
    }
    def getMaxPoolSize: java.lang.Integer = {
      asJava.getMaxPoolSize()
    }

  /**
    * Set to `maxRedirects` the maximum number of redirection a request can follow.
    */
    def setMaxRedirects(value: java.lang.Integer) = {
      asJava.setMaxRedirects(value)
    }
    def getMaxRedirects: java.lang.Integer = {
      asJava.getMaxRedirects()
    }

  /**
    * Set the maximum requests allowed in the wait queue, any requests beyond the max size will result in
    * a ConnectionPoolTooBusyException.  If the value is set to a negative number then the queue will be unbounded.
    */
    def setMaxWaitQueueSize(value: java.lang.Integer) = {
      asJava.setMaxWaitQueueSize(value)
    }
    def getMaxWaitQueueSize: java.lang.Integer = {
      asJava.getMaxWaitQueueSize()
    }

  /**
    * Set the max websocket frame size
    */
    def setMaxWebsocketFrameSize(value: java.lang.Integer) = {
      asJava.setMaxWebsocketFrameSize(value)
    }
    def getMaxWebsocketFrameSize: java.lang.Integer = {
      asJava.getMaxWebsocketFrameSize()
    }

  /**
    * Set the max websocket message size
    */
    def setMaxWebsocketMessageSize(value: java.lang.Integer) = {
      asJava.setMaxWebsocketMessageSize(value)
    }
    def getMaxWebsocketMessageSize: java.lang.Integer = {
      asJava.getMaxWebsocketMessageSize()
    }

  /**
    * Set the metrics name identifying the reported metrics, useful for grouping metrics
    * with the same name.
    */
    def setMetricsName(value: String) = {
      asJava.setMetricsName(value)
    }
    def getMetricsName: String = {
      asJava.getMetricsName()
    }
    def setOpenSslEngineOptions(value: JOpenSSLEngineOptions) = {
      asJava.setOpenSslEngineOptions(value.asJava)
    }
    def getOpenSslEngineOptions: JOpenSSLEngineOptions = {
      asJava.getOpenSslEngineOptions()
    }

  /**
    * Set the key/cert store options in pem format.
    */
    def setPemKeyCertOptions(value: JPemKeyCertOptions) = {
      asJava.setPemKeyCertOptions(value.asJava)
    }
    def getPemKeyCertOptions: JPemKeyCertOptions = {
      asJava.getPemKeyCertOptions()
    }

  /**
    * Set the trust options in pem format
    */
    def setPemTrustOptions(value: JPemTrustOptions) = {
      asJava.setPemTrustOptions(value.asJava)
    }
    def getPemTrustOptions: JPemTrustOptions = {
      asJava.getPemTrustOptions()
    }

  /**
    * Set the key/cert options in pfx format.
    */
    def setPfxKeyCertOptions(value: JPfxOptions) = {
      asJava.setPfxKeyCertOptions(value.asJava)
    }
    def getPfxKeyCertOptions: JPfxOptions = {
      asJava.getPfxKeyCertOptions()
    }

  /**
    * Set the trust options in pfx format
    */
    def setPfxTrustOptions(value: JPfxOptions) = {
      asJava.setPfxTrustOptions(value.asJava)
    }
    def getPfxTrustOptions: JPfxOptions = {
      asJava.getPfxTrustOptions()
    }

  /**
    * Set whether pipe-lining is enabled on the client
    */
    def setPipelining(value: java.lang.Boolean) = {
      asJava.setPipelining(value)
    }
    def isPipelining: java.lang.Boolean = {
      asJava.isPipelining()
    }

  /**
    * Set the limit of pending requests a pipe-lined HTTP/1 connection can send.
    */
    def setPipeliningLimit(value: java.lang.Integer) = {
      asJava.setPipeliningLimit(value)
    }
    def getPipeliningLimit: java.lang.Integer = {
      asJava.getPipeliningLimit()
    }

  /**
    * Set the protocol version.
    */
    def setProtocolVersion(value: io.vertx.core.http.HttpVersion) = {
      asJava.setProtocolVersion(value)
    }
    def getProtocolVersion: io.vertx.core.http.HttpVersion = {
      asJava.getProtocolVersion()
    }

  /**
    * Set proxy options for connections via CONNECT proxy (e.g. Squid) or a SOCKS proxy.
    */
    def setProxyOptions(value: JProxyOptions) = {
      asJava.setProxyOptions(value.asJava)
    }
    def getProxyOptions: JProxyOptions = {
      asJava.getProxyOptions()
    }

  /**
    * Set the TCP receive buffer size
    */
    def setReceiveBufferSize(value: java.lang.Integer) = {
      asJava.setReceiveBufferSize(value)
    }
    def getReceiveBufferSize: java.lang.Integer = {
      asJava.getReceiveBufferSize()
    }

  /**
    * Set the value of reuse address
    */
    def setReuseAddress(value: java.lang.Boolean) = {
      asJava.setReuseAddress(value)
    }
    def isReuseAddress: java.lang.Boolean = {
      asJava.isReuseAddress()
    }

  /**
    * Set the value of reuse port.
    * <p/>
    * This is only supported by native transports.
    */
    def setReusePort(value: java.lang.Boolean) = {
      asJava.setReusePort(value)
    }
    def isReusePort: java.lang.Boolean = {
      asJava.isReusePort()
    }

  /**
    * Set the TCP send buffer size
    */
    def setSendBufferSize(value: java.lang.Integer) = {
      asJava.setSendBufferSize(value)
    }
    def getSendBufferSize: java.lang.Integer = {
      asJava.getSendBufferSize()
    }

  /**
    * Set true when the client wants to skip frame masking.
    * You may want to set it true on server by server websocket communication: In this case you are by passing RFC6455 protocol.
    * It's false as default.
    */
    def setSendUnmaskedFrames(value: java.lang.Boolean) = {
      asJava.setSendUnmaskedFrames(value)
    }
    def isSendUnmaskedFrames: java.lang.Boolean = {
      asJava.isSendUnmaskedFrames()
    }

  /**
    * Set whether SO_linger keep alive is enabled
    */
    def setSoLinger(value: java.lang.Integer) = {
      asJava.setSoLinger(value)
    }
    def getSoLinger: java.lang.Integer = {
      asJava.getSoLinger()
    }

  /**
    * Set whether SSL/TLS is enabled
    */
    def setSsl(value: java.lang.Boolean) = {
      asJava.setSsl(value)
    }
    def isSsl: java.lang.Boolean = {
      asJava.isSsl()
    }

  /**
    * Enable the `TCP_CORK` option - only with linux native transport.
    */
    def setTcpCork(value: java.lang.Boolean) = {
      asJava.setTcpCork(value)
    }
    def isTcpCork: java.lang.Boolean = {
      asJava.isTcpCork()
    }

  /**
    * Enable the `TCP_FASTOPEN` option - only with linux native transport.
    */
    def setTcpFastOpen(value: java.lang.Boolean) = {
      asJava.setTcpFastOpen(value)
    }
    def isTcpFastOpen: java.lang.Boolean = {
      asJava.isTcpFastOpen()
    }

  /**
    * Set whether TCP keep alive is enabled
    */
    def setTcpKeepAlive(value: java.lang.Boolean) = {
      asJava.setTcpKeepAlive(value)
    }
    def isTcpKeepAlive: java.lang.Boolean = {
      asJava.isTcpKeepAlive()
    }

  /**
    * Set whether TCP no delay is enabled
    */
    def setTcpNoDelay(value: java.lang.Boolean) = {
      asJava.setTcpNoDelay(value)
    }
    def isTcpNoDelay: java.lang.Boolean = {
      asJava.isTcpNoDelay()
    }

  /**
    * Enable the `TCP_QUICKACK` option - only with linux native transport.
    */
    def setTcpQuickAck(value: java.lang.Boolean) = {
      asJava.setTcpQuickAck(value)
    }
    def isTcpQuickAck: java.lang.Boolean = {
      asJava.isTcpQuickAck()
    }

  /**
    * Set the value of traffic class
    */
    def setTrafficClass(value: java.lang.Integer) = {
      asJava.setTrafficClass(value)
    }
    def getTrafficClass: java.lang.Integer = {
      asJava.getTrafficClass()
    }

  /**
    * Set whether all server certificates should be trusted
    */
    def setTrustAll(value: java.lang.Boolean) = {
      asJava.setTrustAll(value)
    }
    def isTrustAll: java.lang.Boolean = {
      asJava.isTrustAll()
    }

  /**
    * Set the trust options in jks format, aka Java truststore
    */
    def setTrustStoreOptions(value: JJksOptions) = {
      asJava.setTrustStoreOptions(value.asJava)
    }
    def getTrustStoreOptions: JJksOptions = {
      asJava.getTrustStoreOptions()
    }

  /**
    * Set whether compression is enabled
    */
    def setTryUseCompression(value: java.lang.Boolean) = {
      asJava.setTryUseCompression(value)
    }
    def isTryUseCompression: java.lang.Boolean = {
      asJava.isTryUseCompression()
    }

  /**
    * Set the ALPN usage.
    */
    def setUseAlpn(value: java.lang.Boolean) = {
      asJava.setUseAlpn(value)
    }
    def isUseAlpn: java.lang.Boolean = {
      asJava.isUseAlpn()
    }

  /**
    * Set whether Netty pooled buffers are enabled
    */
    def setUsePooledBuffers(value: java.lang.Boolean) = {
      asJava.setUsePooledBuffers(value)
    }
    def isUsePooledBuffers: java.lang.Boolean = {
      asJava.isUsePooledBuffers()
    }

  /**
    * Set whether hostname verification is enabled
    */
    def setVerifyHost(value: java.lang.Boolean) = {
      asJava.setVerifyHost(value)
    }
    def isVerifyHost: java.lang.Boolean = {
      asJava.isVerifyHost()
    }
  }
  
  type HttpClientOptions = JHttpClientOptions
  object HttpClientOptions {
    def apply(): JHttpClientOptions = new HttpClientOptions()
    def apply(json: JsonObject) = new JHttpClientOptions(json)
  }


import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.core.http.{HttpConnection => JHttpConnection}
import io.vertx.core.MultiMap
import io.vertx.core.http.{HttpFrame => JHttpFrame}
import io.vertx.core.streams.{WriteStream => JWriteStream}
import io.vertx.core.http.HttpClientResponse
import io.vertx.core.http.HttpClientRequest
import io.vertx.core.buffer.Buffer
import io.vertx.core.http.HttpFrame
import io.vertx.core.http.HttpVersion
import io.vertx.core.streams.WriteStream
import io.vertx.core.http.HttpMethod
import io.vertx.core.http.{HttpClientResponse => JHttpClientResponse}
import io.vertx.core.streams.ReadStream
import io.vertx.core.{MultiMap => JMultiMap}
import io.vertx.core.http.HttpConnection
import io.vertx.core.Handler
import io.vertx.core.http.{HttpClientRequest => JHttpClientRequest}

/**
  * Represents a client-side HTTP request.
  * 
  * Instances are created by an [[io.vertx.core.http.HttpClient]] instance, via one of the methods corresponding to the
  * specific HTTP methods, or the generic request methods. On creation the request will not have been written to the
  * wire.
  * 
  * Once a request has been obtained, headers can be set on it, and data can be written to its body if required. Once
  * you are ready to send the request, one of the [[io.vertx.core.http.HttpClientRequest#end]] methods should be called.
  * 
  * Nothing is actually sent until the request has been internally assigned an HTTP connection.
  * 
  * The [[io.vertx.core.http.HttpClient]] instance will return an instance of this class immediately, even if there are no HTTP
  * connections available in the pool. Any requests sent before a connection is assigned will be queued
  * internally and actually sent when an HTTP connection becomes available from the pool.
  * 
  * The headers of the request are queued for writing either when the [[io.vertx.core.http.HttpClientRequest#end]] method is called, or, when the first
  * part of the body is written, whichever occurs first.
  * 
  * This class supports both chunked and non-chunked HTTP.
  * 
  * It implements [[io.vertx.core.streams.WriteStream]] so it can be used with
  * [[io.vertx.core.streams.Pump]] to pump data with flow control.
  * 
  * An example of using this class is as follows:
  * 
  */
implicit class HttpClientRequestScala(val asJava: JHttpClientRequest) extends AnyVal {


  def exceptionHandler(handler: scala.Option[Throwable => Unit]): JHttpClientRequest = {
    asJava.exceptionHandler(handler match {case Some(t) => (p:Throwable) => t(p); case None => null})
  }

  /**
    */
  def write(data: io.vertx.core.buffer.Buffer): JHttpClientRequest = {
    asJava.write(data)
  }

  def setWriteQueueMaxSize(maxSize: java.lang.Integer): JHttpClientRequest = {
    asJava.setWriteQueueMaxSize(maxSize)
  }

  def drainHandler(handler: scala.Option[Void => Unit]): JHttpClientRequest = {
    asJava.drainHandler(handler match {case Some(t) => (p:Void) => t(p); case None => null})
  }

  def handler(handler: scala.Option[JHttpClientResponse => Unit]): JHttpClientRequest = {
    asJava.handler(handler match {case Some(t) => (p:JHttpClientResponse) => t(p); case None => null})
  }

  def pause(): JHttpClientRequest = {
    asJava.pause()
  }

  def resume(): JHttpClientRequest = {
    asJava.resume()
  }

  def endHandler(endHandler: scala.Option[Void => Unit]): JHttpClientRequest = {
    asJava.endHandler(endHandler match {case Some(t) => (p:Void) => t(p); case None => null})
  }

  def setFollowRedirects(followRedirects: java.lang.Boolean): JHttpClientRequest = {
    asJava.setFollowRedirects(followRedirects)
  }

  /**
    * If chunked is true then the request will be set into HTTP chunked mode
    * @param chunked true if chunked encoding
    * @return a reference to this, so the API can be used fluently
    */
  def setChunked(chunked: java.lang.Boolean): JHttpClientRequest = {
    asJava.setChunked(chunked)
  }

  /**
    * Set the value the method to send when the method  is used.
    * @param method the raw method
    * @return a reference to this, so the API can be used fluently
    */
  def setRawMethod(method: String): JHttpClientRequest = {
    asJava.setRawMethod(method)
  }

  /**
    * Set the request host.<p/>
    *
    * For HTTP/2 it sets the  pseudo header otherwise it sets the  header
    */
  def setHost(host: String): JHttpClientRequest = {
    asJava.setHost(host)
  }

  /**
    * Put an HTTP header
    * @param name The header name
    * @param value The header value
    * @return a reference to this, so the API can be used fluently
    */
  def putHeader(name: String, value: String): JHttpClientRequest = {
    asJava.putHeader(name, value)
  }

  /**
    * Write a String to the request body, encoded as UTF-8.
    * @return @return a reference to this, so the API can be used fluently
    */
  def write(chunk: String): JHttpClientRequest = {
    asJava.write(chunk)
  }

  /**
    * Write a String to the request body, encoded using the encoding `enc`.
    * @return @return a reference to this, so the API can be used fluently
    */
  def write(chunk: String, enc: String): JHttpClientRequest = {
    asJava.write(chunk, enc)
  }

  /**
    * If you send an HTTP request with the header `Expect` set to the value `100-continue`
    * and the server responds with an interim HTTP response with a status code of `100` and a continue handler
    * has been set using this method, then the `handler` will be called.
    * 
    * You can then continue to write data to the request body and later end it. This is normally used in conjunction with
    * the [[io.vertx.core.http.HttpClientRequest#sendHead]] method to force the request header to be written before the request has ended.
    * @return a reference to this, so the API can be used fluently
    */
  def continueHandler(handler: scala.Option[Void => Unit]): JHttpClientRequest = {
    asJava.continueHandler(handler match {case Some(t) => (p:Void) => t(p); case None => null})
  }

  /**
    * Forces the head of the request to be written before [[io.vertx.core.http.HttpClientRequest#end]] is called on the request or any data is
    * written to it.
    * 
    * This is normally used to implement HTTP 100-continue handling, see [[io.vertx.core.http.HttpClientRequest#continueHandler]] for
    * more information.
    * @return a reference to this, so the API can be used fluently
    */
  def sendHead(): JHttpClientRequest = {
    asJava.sendHead()
  }

  /**
    * Like [[io.vertx.core.http.HttpClientRequest#sendHead]] but with an handler after headers have been sent. The handler will be called with
    * the [[io.vertx.core.http.HttpVersion]] if it can be determined or null otherwise.
    */
  def sendHead(completionHandler: io.vertx.core.http.HttpVersion => Unit): JHttpClientRequest = {
    asJava.sendHead((p:io.vertx.core.http.HttpVersion) => completionHandler(p))
  }

  /**
    * Set's the amount of time after which if the request does not return any data within the timeout period an
    * TimeoutException will be passed to the exception handler (if provided) and
    * the request will be closed.
    * 
    * Calling this method more than once has the effect of canceling any existing timeout and starting
    * the timeout from scratch.
    * @param timeoutMs The quantity of time in milliseconds.
    * @return a reference to this, so the API can be used fluently
    */
  def setTimeout(timeoutMs: java.lang.Long): JHttpClientRequest = {
    asJava.setTimeout(timeoutMs)
  }

  /**
    * Set a push handler for this request.<p/>
    *
    * The handler is called when the client receives a <i>push promise</i> from the server. The handler can be called
    * multiple times, for each push promise.<p/>
    *
    * The handler is called with a <i>read-only</i> [[io.vertx.core.http.HttpClientRequest]], the following methods can be called:<p/>
    *
    * <ul>
    *   <li>[[io.vertx.core.http.HttpClientRequest#method]]</li>
    *   <li>[[io.vertx.core.http.HttpClientRequest#uri]]</li>
    *   <li>[[io.vertx.core.http.HttpClientRequest#headers]]</li>
    *   <li>[[io.vertx.core.http.HttpClientRequest#getHost]]</li>
    * </ul>
    *
    * In addition the handler should call the [[io.vertx.core.http.HttpClientRequest#handler]] method to set an handler to
    * process the response.<p/>
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  def pushHandler(handler: JHttpClientRequest => Unit): JHttpClientRequest = {
    asJava.pushHandler((p:JHttpClientRequest) => handler(p))
  }

  /**
    * Set a connection handler called when an HTTP connection has been established.
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  def connectionHandler(handler: scala.Option[JHttpConnection => Unit]): JHttpClientRequest = {
    asJava.connectionHandler(handler match {case Some(t) => (p:JHttpConnection) => t(p); case None => null})
  }

  /**
    * Write an HTTP/2 frame to the request, allowing to extend the HTTP/2 protocol.
    *
    * The frame is sent immediatly and is not subject to flow control.
    *
    * This method must be called after the request headers have been sent and only for the protocol HTTP/2.
    * The [[io.vertx.core.http.HttpClientRequest#sendHead]] should be used for this purpose.
    * @param type the 8-bit frame type
    * @param flags the 8-bit frame flags
    * @param payload the frame payload
    * @return a reference to this, so the API can be used fluently
    */
  def writeCustomFrame(`type`: java.lang.Integer, flags: java.lang.Integer, payload: io.vertx.core.buffer.Buffer): JHttpClientRequest = {
    asJava.writeCustomFrame(`type`, flags, payload)
  }

  /**
    * Like [[io.vertx.core.http.HttpClientRequest#writeCustomFrame]] but with an [[io.vertx.core.http.HttpFrame]].
    * @param frame the frame to write
    */
  def writeCustomFrame(frame: JHttpFrame): JHttpClientRequest = {
    asJava.writeCustomFrame(frame.asJava)
  }

  /**
    * Reset this stream with the error code `0`.
    */
  def reset(): java.lang.Boolean = {
    asJava.reset()
  }

  /**
    * @return the id of the stream of this response, ` -1` when it is not yet determined, i.e the request has not been yet sent or it is not supported HTTP/1.x
    */
  def streamId(): java.lang.Integer = {
    asJava.streamId()
  }

  /**
    * This will return `true` if there are more bytes in the write queue than the value set using [[io.vertx.core.http.HttpClientRequest#setWriteQueueMaxSize]]
    * @return true if write queue is full
    */
  def writeQueueFull(): java.lang.Boolean = {
    asJava.writeQueueFull()
  }

  /**
    * @return Is the request chunked?
    */
  def isChunked(): java.lang.Boolean = {
    asJava.isChunked()
  }

  /**
    * The HTTP method for the request.
    */
  def method(): io.vertx.core.http.HttpMethod = {
    asJava.method()
  }

  /**
    * @return the raw value of the method this request sends
    */
  def getRawMethod(): String = {
    asJava.getRawMethod()
  }

  /**
    * @return the absolute URI corresponding to the the HTTP request
    */
  def absoluteURI(): String = {
    asJava.absoluteURI()
  }

  /**
    * @return The URI of the request.
    */
  def uri(): String = {
    asJava.uri()
  }

  /**
    * @return The path part of the uri. For example /somepath/somemorepath/someresource.foo
    */
  def path(): String = {
    asJava.path()
  }

  /**
    * @return the query part of the uri. For example someparam=32&amp;someotherparam=x
    */
  def query(): String = {
    asJava.query()
  }

  /**
    * @return the request host. For HTTP/2 it returns the ` :authority` pseudo header otherwise it returns the ` Host` header
    */
  def getHost(): String = {
    asJava.getHost()
  }

  /**
    * Same as [[io.vertx.core.http.HttpClientRequest#end]] but writes a String in UTF-8 encoding
    */
  def end(chunk: String): Unit = {
    asJava.end(chunk)
  }

  /**
    * Same as [[io.vertx.core.http.HttpClientRequest#end]] but writes a String with the specified encoding
    */
  def end(chunk: String, enc: String): Unit = {
    asJava.end(chunk, enc)
  }

  /**
    * Same as [[io.vertx.core.http.HttpClientRequest#end]] but writes some data to the request body before ending. If the request is not chunked and
    * no other data has been written then the `Content-Length` header will be automatically set
    */
  def end(chunk: io.vertx.core.buffer.Buffer): Unit = {
    asJava.end(chunk)
  }

  /**
    * Ends the request. If no data has been written to the request body, and [[io.vertx.core.http.HttpClientRequest#sendHead]] has not been called then
    * the actual request won't get written until this method gets called.
    * 
    * Once the request has ended, it cannot be used any more,
    */
  def end(): Unit = {
    asJava.end()
  }

  /**
    * Reset this request:
    * <p/>
    * <ul>
    *   <li>for HTTP/2, this performs send an HTTP/2 reset frame with the specified error `code`</li>
    *   <li>for HTTP/1.x, this closes the connection when the current request is inflight</li>
    * </ul>
    * <p/>
    * When the request has not yet been sent, the request will be aborted and false is returned as indicator.
    * <p/>
    * @param code the error code
    * @return true when reset has been performed
    */
  def reset(code: java.lang.Long): java.lang.Boolean = {
    asJava.reset(code)
  }

  /**
    * @return The HTTP headers
    */
  def headers(): JMultiMap = {
    asJava.headers()
  }

  /**
    * @return the HttpConnection associated with this request
    */
  def connection(): JHttpConnection = {
    asJava.connection()
  }

}

import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.core.MultiMap
import io.vertx.core.http.{HttpFrame => JHttpFrame}
import scala.collection.JavaConverters._
import io.vertx.core.http.HttpClientResponse
import io.vertx.core.http.HttpClientRequest
import io.vertx.core.net.{NetSocket => JNetSocket}
import io.vertx.core.buffer.Buffer
import io.vertx.core.http.HttpFrame
import io.vertx.core.http.HttpVersion
import io.vertx.core.http.{HttpClientResponse => JHttpClientResponse}
import io.vertx.core.streams.ReadStream
import io.vertx.core.{MultiMap => JMultiMap}
import io.vertx.core.Handler
import io.vertx.core.http.{HttpClientRequest => JHttpClientRequest}
import io.vertx.core.net.NetSocket

/**
  * Represents a client-side HTTP response.
  * 
  * Vert.x provides you with one of these via the handler that was provided when creating the [[io.vertx.core.http.HttpClientRequest]]
  * or that was set on the [[io.vertx.core.http.HttpClientRequest]] instance.
  * 
  * It implements [[io.vertx.core.streams.ReadStream]] so it can be used with
  * [[io.vertx.core.streams.Pump]] to pump data with flow control.
  */
implicit class HttpClientResponseScala(val asJava: JHttpClientResponse) extends AnyVal {


  def resume(): JHttpClientResponse = {
    asJava.resume()
  }

  def exceptionHandler(handler: scala.Option[Throwable => Unit]): JHttpClientResponse = {
    asJava.exceptionHandler(handler match {case Some(t) => (p:Throwable) => t(p); case None => null})
  }

  def handler(handler: scala.Option[io.vertx.core.buffer.Buffer => Unit]): JHttpClientResponse = {
    asJava.handler(handler match {case Some(t) => (p:io.vertx.core.buffer.Buffer) => t(p); case None => null})
  }

  def pause(): JHttpClientResponse = {
    asJava.pause()
  }

  def endHandler(endHandler: scala.Option[Void => Unit]): JHttpClientResponse = {
    asJava.endHandler(endHandler match {case Some(t) => (p:Void) => t(p); case None => null})
  }

  /**
    * Convenience method for receiving the entire request body in one piece.
    * 
    * This saves you having to manually set a dataHandler and an endHandler and append the chunks of the body until
    * the whole body received. Don't use this if your request body is large - you could potentially run out of RAM.
    * @param bodyHandler This handler will be called after all the body has been received
    */
  def bodyHandler(bodyHandler: io.vertx.core.buffer.Buffer => Unit): JHttpClientResponse = {
    asJava.bodyHandler((p:io.vertx.core.buffer.Buffer) => bodyHandler(p))
  }

  /**
    * Set an custom frame handler. The handler will get notified when the http stream receives an custom HTTP/2
    * frame. HTTP/2 permits extension of the protocol.
    * @return a reference to this, so the API can be used fluently
    */
  def customFrameHandler(handler: JHttpFrame => Unit): JHttpClientResponse = {
    asJava.customFrameHandler((p:JHttpFrame) => handler(p))
  }

  /**
    * @return the version of the response
    */
  def version(): io.vertx.core.http.HttpVersion = {
    asJava.version()
  }

  /**
    * @return the status code of the response
    */
  def statusCode(): java.lang.Integer = {
    asJava.statusCode()
  }

  /**
    * @return the status message of the response
    */
  def statusMessage(): String = {
    asJava.statusMessage()
  }

  /**
    * Return the first header value with the specified name
    * @param headerName the header name
    * @return the header value
    */
  def getHeader(headerName: String): scala.Option[String] = {
    scala.Option(asJava.getHeader(headerName))
  }

  /**
    * Return the first trailer value with the specified name
    * @param trailerName the trailer name
    * @return the trailer value
    */
  def getTrailer(trailerName: String): scala.Option[String] = {
    scala.Option(asJava.getTrailer(trailerName))
  }

  /**
    * @return the headers
    */
  def headers(): JMultiMap = {
    asJava.headers()
  }

  /**
    * @return the trailers
    */
  def trailers(): JMultiMap = {
    asJava.trailers()
  }

  /**
    * @return the Set-Cookie headers (including trailers)
    */
  def cookies(): List[String] = {
    asJava.cookies().asScala.toList
  }

  /**
    * Get a net socket for the underlying connection of this request.
    * 
    * USE THIS WITH CAUTION! Writing to the socket directly if you don't know what you're doing can easily break the HTTP protocol
    * 
    * One valid use-case for calling this is to receive the [[io.vertx.core.net.NetSocket]] after a HTTP CONNECT was issued to the
    * remote peer and it responded with a status code of 200.
    * @return the net socket
    */
  def netSocket(): JNetSocket = {
    asJava.netSocket()
  }

  /**
    * @return the corresponding request
    */
  def request(): JHttpClientRequest = {
    asJava.request()
  }

}

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.buffer.Buffer
import io.vertx.core.http.{HttpConnection => JHttpConnection}
import io.vertx.core.http.{GoAway => JGoAway}
import io.vertx.core.http.GoAway
import io.vertx.core.net.{SocketAddress => JSocketAddress}
import io.vertx.core.http.HttpConnection
import io.vertx.core.http.Http2Settings
import io.vertx.core.AsyncResult
import io.vertx.core.http.{Http2Settings => JHttp2Settings}
import io.vertx.core.Handler
import io.vertx.core.net.SocketAddress

/**
  * Represents an HTTP connection.
  * <p/>
  * HTTP/1.x connection provides an limited implementation, the following methods are implemented:
  * <ul>
  *   <li>[[io.vertx.core.http.HttpConnection#close]]</li>
  *   <li>[[io.vertx.core.http.HttpConnection#closeHandler]]</li>
  *   <li>[[io.vertx.core.http.HttpConnection#exceptionHandler]]</li>
  * </ul>
  */
implicit class HttpConnectionScala(val asJava: JHttpConnection) extends AnyVal {


  /**
    * Update the current connection wide window size to a new size.
    * <p/>
    * Increasing this value, gives better performance when several data streams are multiplexed
    * <p/>
    * This is not implemented for HTTP/1.x.
    * @param windowSize the new window size
    * @return a reference to this, so the API can be used fluently
    */
  def setWindowSize(windowSize: java.lang.Integer): JHttpConnection = {
    asJava.setWindowSize(windowSize)
  }

  /**
    * Like [[io.vertx.core.http.HttpConnection#goAway]] with a last stream id `-1` which means to disallow any new stream creation.
    */
  def goAway(errorCode: java.lang.Long): JHttpConnection = {
    asJava.goAway(errorCode)
  }

  /**
    * Like [[io.vertx.core.http.HttpConnection#goAway]] with no buffer.
    */
  def goAway(errorCode: java.lang.Long, lastStreamId: java.lang.Integer): JHttpConnection = {
    asJava.goAway(errorCode, lastStreamId)
  }

  /**
    * Send a go away frame to the remote endpoint of the connection.
    * <p/>
    * <ul>
    *   <li>a  frame is sent to the to the remote endpoint with the `errorCode` and `debugData`</li>
    *   <li>any stream created after the stream identified by `lastStreamId` will be closed</li>
    *   <li>for an  is different than `0` when all the remaining streams are closed this connection will be closed automatically</li>
    * </ul>
    * <p/>
    * This is not implemented for HTTP/1.x.
    * @param errorCode the ` GOAWAY` error code
    * @param lastStreamId the last stream id
    * @param debugData additional debug data sent to the remote endpoint
    * @return a reference to this, so the API can be used fluently
    */
  def goAway(errorCode: java.lang.Long, lastStreamId: java.lang.Integer, debugData: io.vertx.core.buffer.Buffer): JHttpConnection = {
    asJava.goAway(errorCode, lastStreamId, debugData)
  }

  /**
    * Set an handler called when a  frame is received.
    * <p/>
    * This is not implemented for HTTP/1.x.
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  def goAwayHandler(handler: scala.Option[JGoAway => Unit]): JHttpConnection = {
    asJava.goAwayHandler(handler match {case Some(t) => (p:JGoAway) => t(p); case None => null})
  }

  /**
    * Set an handler called when a  frame has been sent or received and all connections are closed.
    * <p/>
    * This is not implemented for HTTP/1.x.
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  def shutdownHandler(handler: scala.Option[Void => Unit]): JHttpConnection = {
    asJava.shutdownHandler(handler match {case Some(t) => (p:Void) => t(p); case None => null})
  }

  /**
    * Initiate a connection shutdown, a go away frame is sent and the connection is closed when all current active streams
    * are closed or after a time out of 30 seconds.
    * <p/>
    * This is not implemented for HTTP/1.x.
    * @return a reference to this, so the API can be used fluently
    */
  def shutdown(): JHttpConnection = {
    asJava.shutdown()
  }

  /**
    * Initiate a connection shutdown, a go away frame is sent and the connection is closed when all current streams
    * will be closed or the `timeout` is fired.
    * <p/>
    * This is not implemented for HTTP/1.x.
    * @param timeoutMs the timeout in milliseconds
    * @return a reference to this, so the API can be used fluently
    */
  def shutdown(timeoutMs: java.lang.Long): JHttpConnection = {
    asJava.shutdown(timeoutMs)
  }

  /**
    * Set a close handler. The handler will get notified when the connection is closed.
    * @param handler the handler to be notified
    * @return a reference to this, so the API can be used fluently
    */
  def closeHandler(handler: Void => Unit): JHttpConnection = {
    asJava.closeHandler((p:Void) => handler(p))
  }

  /**
    * Send to the remote endpoint an update of the server settings.
    * <p/>
    * This is not implemented for HTTP/1.x.
    * @param settings the new settingssee <a href="../../../../../../../cheatsheet/Http2Settings.html">Http2Settings</a>
    * @return a reference to this, so the API can be used fluently
    */
  def updateSettings(settings: JHttp2Settings): JHttpConnection = {
    asJava.updateSettings(settings.asJava)
  }

  /**
    * Send to the remote endpoint an update of this endpoint settings
    * <p/>
    * The `completionHandler` will be notified when the remote endpoint has acknowledged the settings.
    * <p/>
    * This is not implemented for HTTP/1.x.
    * @param settings the new settingssee <a href="../../../../../../../cheatsheet/Http2Settings.html">Http2Settings</a>
    * @param completionHandler the handler notified when the settings have been acknowledged by the remote endpoint
    * @return a reference to this, so the API can be used fluently
    */
  def updateSettings(settings: JHttp2Settings, completionHandler: AsyncResult[Void] => Unit): JHttpConnection = {
    asJava.updateSettings(settings.asJava, (p:AsyncResult[Void]) => completionHandler(p))
  }

  /**
    * Set an handler that is called when remote endpoint <a href="../../../../../../../cheatsheet/Http2Settings.html">Http2Settings</a> are updated.
    * <p/>
    * This is not implemented for HTTP/1.x.
    * @param handler the handler for remote endpoint settings
    * @return a reference to this, so the API can be used fluently
    */
  def remoteSettingsHandler(handler: JHttp2Settings => Unit): JHttpConnection = {
    asJava.remoteSettingsHandler((p:JHttp2Settings) => handler(p))
  }

  /**
    * Send a  frame to the remote endpoint.
    * <p/>
    * This is not implemented for HTTP/1.x.
    * @param data the 8 bytes data of the frame
    * @param pongHandler an async result handler notified with pong reply or the failure
    * @return a reference to this, so the API can be used fluently
    */
  def ping(data: io.vertx.core.buffer.Buffer, pongHandler: AsyncResult[io.vertx.core.buffer.Buffer] => Unit): JHttpConnection = {
    asJava.ping(data, (p:AsyncResult[io.vertx.core.buffer.Buffer]) => pongHandler(p))
  }

  /**
    * Set an handler notified when a  frame is received from the remote endpoint.
    * <p/>
    * This is not implemented for HTTP/1.x.
    * @param handler the handler to be called when a ` PING` is received
    * @return a reference to this, so the API can be used fluently
    */
  def pingHandler(handler: scala.Option[io.vertx.core.buffer.Buffer => Unit]): JHttpConnection = {
    asJava.pingHandler(handler match {case Some(t) => (p:io.vertx.core.buffer.Buffer) => t(p); case None => null})
  }

  /**
    * Set an handler called when a connection error happens
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  def exceptionHandler(handler: Throwable => Unit): JHttpConnection = {
    asJava.exceptionHandler((p:Throwable) => handler(p))
  }

  /**
    * @return the current connection window size or `-1` for HTTP/1.x
    */
  def getWindowSize(): java.lang.Integer = {
    asJava.getWindowSize()
  }

  /**
    * Close the connection and all the currently active streams.
    * <p/>
    * An HTTP/2 connection will send a  frame before.
    */
  def close(): Unit = {
    asJava.close()
  }

  /**
    * @return the latest server settings acknowledged by the remote endpoint - this is not implemented for HTTP/1.xsee <a href="../../../../../../../cheatsheet/Http2Settings.html">Http2Settings</a>
    */
  def settings(): JHttp2Settings = {
    asJava.settings()
  }

  /**
    * @return the current remote endpoint settings for this connection - this is not implemented for HTTP/1.xsee <a href="../../../../../../../cheatsheet/Http2Settings.html">Http2Settings</a>
    */
  def remoteSettings(): JHttp2Settings = {
    asJava.remoteSettings()
  }

  /**
    * @return true if this io.vertx.core.http.HttpConnection is encrypted via SSL/TLS.
    */
  def isSsl(): java.lang.Boolean = {
    asJava.isSsl()
  }

  /**
    * Returns the SNI server name presented during the SSL handshake by the client.
    * @return the indicated server name
    */
  def indicatedServerName(): String = {
    asJava.indicatedServerName()
  }

  /**
    * @return the remote address for this connection
    */
  def remoteAddress(): JSocketAddress = {
    asJava.remoteAddress()
  }

  /**
    * @return the remote address for this connection
    */
  def localAddress(): JSocketAddress = {
    asJava.localAddress()
  }

 /**
   * Like [[updateSettings]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def updateSettingsFuture(settings: JHttp2Settings): scala.concurrent.Future[Unit] = {
    val promise = Promise[Unit]()
    asJava.updateSettings(settings, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[ping]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def pingFuture(data: io.vertx.core.buffer.Buffer): scala.concurrent.Future[io.vertx.core.buffer.Buffer] = {
    val promise = Promise[io.vertx.core.buffer.Buffer]()
    asJava.ping(data, {a:AsyncResult[io.vertx.core.buffer.Buffer] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

}

import io.vertx.core.buffer.Buffer
import io.vertx.core.http.{HttpFrame => JHttpFrame}

/**
  * An HTTP/2 frame.
  */
implicit class HttpFrameScala(val asJava: JHttpFrame) extends AnyVal {


  /**
    * @return the 8-bit type of the frame
    */
  def `type`(): java.lang.Integer = {
    asJava.`type`()
  }

  /**
    * @return the 8-bit flags specific to the frame
    */
  def flags(): java.lang.Integer = {
    asJava.flags()
  }

  /**
    * @return the frame payload
    */
  def payload(): io.vertx.core.buffer.Buffer = {
    asJava.payload()
  }

}

import io.vertx.core.http.{HttpServer => JHttpServer}
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.metrics.{Measured => JMeasured}
import io.vertx.core.http.HttpServerRequest
import io.vertx.core.http.ServerWebSocket
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.core.http.{HttpConnection => JHttpConnection}
import io.vertx.core.http.HttpServer
import io.vertx.core.http.{HttpServerRequest => JHttpServerRequest}
import io.vertx.core.http.{ServerWebSocket => JServerWebSocket}
import io.vertx.core.metrics.Measured
import io.vertx.core.streams.ReadStream
import io.vertx.core.http.HttpConnection
import io.vertx.core.AsyncResult
import io.vertx.core.Handler

/**
  * An HTTP and WebSockets server.
  * 
  * You receive HTTP requests by providing a [[io.vertx.core.http.HttpServer#requestHandler]]. As requests arrive on the server the handler
  * will be called with the requests.
  * 
  * You receive WebSockets by providing a [[io.vertx.core.http.HttpServer#websocketHandler]]. As WebSocket connections arrive on the server, the
  * WebSocket is passed to the handler.
  */
implicit class HttpServerScala(val asJava: JHttpServer) extends AnyVal {


  /**
    * Set the request handler for the server to `requestHandler`. As HTTP requests are received by the server,
    * instances of [[io.vertx.core.http.HttpServerRequest]] will be created and passed to this handler.
    * @return a reference to this, so the API can be used fluently
    */
  def requestHandler(handler: JHttpServerRequest => Unit): JHttpServer = {
    asJava.requestHandler((p:JHttpServerRequest) => handler(p))
  }

  /**
    * Set a connection handler for the server.
    * @return a reference to this, so the API can be used fluently
    */
  def connectionHandler(handler: JHttpConnection => Unit): JHttpServer = {
    asJava.connectionHandler((p:JHttpConnection) => handler(p))
  }

  /**
    * Set an exception handler called for socket errors happening before the HTTP connection
    * is established, e.g during the TLS handshake.
    * @param handler the handler to set
    * @return a reference to this, so the API can be used fluently
    */
  def exceptionHandler(handler: Throwable => Unit): JHttpServer = {
    asJava.exceptionHandler((p:Throwable) => handler(p))
  }

  /**
    * Set the websocket handler for the server to `wsHandler`. If a websocket connect handshake is successful a
    * new [[io.vertx.core.http.ServerWebSocket]] instance will be created and passed to the handler.
    * @return a reference to this, so the API can be used fluently
    */
  def websocketHandler(handler: JServerWebSocket => Unit): JHttpServer = {
    asJava.websocketHandler((p:JServerWebSocket) => handler(p))
  }

  /**
    * Tell the server to start listening. The server will listen on the port and host specified in the
    * <a href="../../../../../../../cheatsheet/HttpServerOptions.html">HttpServerOptions</a> that was used when creating the server.
    * 
    * The listen happens asynchronously and the server may not be listening until some time after the call has returned.
    * @return a reference to this, so the API can be used fluently
    */
  def listen(): JHttpServer = {
    asJava.listen()
  }

  /**
    * Tell the server to start listening. The server will listen on the port and host specified here,
    * ignoring any value set in the <a href="../../../../../../../cheatsheet/HttpServerOptions.html">HttpServerOptions</a> that was used when creating the server.
    * 
    * The listen happens asynchronously and the server may not be listening until some time after the call has returned.
    * @param port the port to listen on
    * @param host the host to listen on
    * @return a reference to this, so the API can be used fluently
    */
  def listen(port: java.lang.Integer, host: String): JHttpServer = {
    asJava.listen(port, host)
  }

  /**
    * Like [[io.vertx.core.http.HttpServer#listen]] but supplying a handler that will be called when the server is actually
    * listening (or has failed).
    * @param port the port to listen on
    * @param host the host to listen on
    * @param listenHandler the listen handler
    */
  def listen(port: java.lang.Integer, host: String, listenHandler: AsyncResult[JHttpServer] => Unit): JHttpServer = {
    asJava.listen(port, host, (p:AsyncResult[JHttpServer]) => listenHandler(p))
  }

  /**
    * Like [[io.vertx.core.http.HttpServer#listen]] but the server will listen on host "0.0.0.0" and port specified here ignoring
    * any value in the <a href="../../../../../../../cheatsheet/HttpServerOptions.html">HttpServerOptions</a> that was used when creating the server.
    * @param port the port to listen on
    * @return a reference to this, so the API can be used fluently
    */
  def listen(port: java.lang.Integer): JHttpServer = {
    asJava.listen(port)
  }

  /**
    * Like [[io.vertx.core.http.HttpServer#listen]] but supplying a handler that will be called when the server is actually listening (or has failed).
    * @param port the port to listen on
    * @param listenHandler the listen handler
    */
  def listen(port: java.lang.Integer, listenHandler: AsyncResult[JHttpServer] => Unit): JHttpServer = {
    asJava.listen(port, (p:AsyncResult[JHttpServer]) => listenHandler(p))
  }

  /**
    * Like [[io.vertx.core.http.HttpServer#listen]] but supplying a handler that will be called when the server is actually listening (or has failed).
    * @param listenHandler the listen handler
    */
  def listen(listenHandler: AsyncResult[JHttpServer] => Unit): JHttpServer = {
    asJava.listen((p:AsyncResult[JHttpServer]) => listenHandler(p))
  }

  /**
    * Whether the metrics are enabled for this measured object
    * @return true if the metrics are enabled
    */
  def isMetricsEnabled(): java.lang.Boolean = {
    asJava.isMetricsEnabled()
  }

  /**
    * Close the server. Any open HTTP connections will be closed.
    * 
    * The close happens asynchronously and the server may not be closed until some time after the call has returned.
    */
  def close(): Unit = {
    asJava.close()
  }

  /**
    * Like [[io.vertx.core.http.HttpServer#close]] but supplying a handler that will be called when the server is actually closed (or has failed).
    * @param completionHandler the handler
    */
  def close(completionHandler: AsyncResult[Void] => Unit): Unit = {
    asJava.close((p:AsyncResult[Void]) => completionHandler(p))
  }

  /**
    * The actual port the server is listening on. This is useful if you bound the server specifying 0 as port number
    * signifying an ephemeral port
    * @return the actual port the server is listening on.
    */
  def actualPort(): java.lang.Integer = {
    asJava.actualPort()
  }

  /**
    * Return the request stream for the server. As HTTP requests are received by the server,
    * instances of [[io.vertx.core.http.HttpServerRequest]] will be created and passed to the stream [[io.vertx.core.streams.ReadStream#handler]].
    * @return the request stream
    */
  def requestStream(): JReadStream[JHttpServerRequest] = {
    asJava.requestStream()
  }

  /**
    * Return the websocket stream for the server. If a websocket connect handshake is successful a
    * new [[io.vertx.core.http.ServerWebSocket]] instance will be created and passed to the stream [[io.vertx.core.streams.ReadStream#handler]].
    * @return the websocket stream
    */
  def websocketStream(): JReadStream[JServerWebSocket] = {
    asJava.websocketStream()
  }

 /**
   * Like [[listen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def listenFuture(port: java.lang.Integer, host: String): scala.concurrent.Future[JHttpServer] = {
    val promise = Promise[JHttpServer]()
    asJava.listen(port, host, {a:AsyncResult[io.vertx.core.http.HttpServer] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[listen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def listenFuture(port: java.lang.Integer): scala.concurrent.Future[JHttpServer] = {
    val promise = Promise[JHttpServer]()
    asJava.listen(port, {a:AsyncResult[io.vertx.core.http.HttpServer] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[listen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def listenFuture(): scala.concurrent.Future[JHttpServer] = {
    val promise = Promise[JHttpServer]()
    asJava.listen({a:AsyncResult[io.vertx.core.http.HttpServer] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
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

import io.vertx.core.http.{HttpServerFileUpload => JHttpServerFileUpload}
import io.vertx.core.http.HttpServerFileUpload
import io.vertx.core.buffer.Buffer
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.core.streams.ReadStream
import io.vertx.core.Handler

/**
  * Represents an file upload from an HTML FORM.
  */
implicit class HttpServerFileUploadScala(val asJava: JHttpServerFileUpload) extends AnyVal {


  def exceptionHandler(handler: scala.Option[Throwable => Unit]): JHttpServerFileUpload = {
    asJava.exceptionHandler(handler match {case Some(t) => (p:Throwable) => t(p); case None => null})
  }

  def handler(handler: scala.Option[io.vertx.core.buffer.Buffer => Unit]): JHttpServerFileUpload = {
    asJava.handler(handler match {case Some(t) => (p:io.vertx.core.buffer.Buffer) => t(p); case None => null})
  }

  def endHandler(endHandler: scala.Option[Void => Unit]): JHttpServerFileUpload = {
    asJava.endHandler(endHandler match {case Some(t) => (p:Void) => t(p); case None => null})
  }

  def pause(): JHttpServerFileUpload = {
    asJava.pause()
  }

  def resume(): JHttpServerFileUpload = {
    asJava.resume()
  }

  /**
    * Stream the content of this upload to the given file on storage.
    * @param filename the name of the file
    */
  def streamToFileSystem(filename: String): JHttpServerFileUpload = {
    asJava.streamToFileSystem(filename)
  }

  /**
    * @return the filename which was used when upload the file.
    */
  def filename(): String = {
    asJava.filename()
  }

  /**
    * @return the name of the attribute
    */
  def name(): String = {
    asJava.name()
  }

  /**
    * @return the content type for the upload
    */
  def contentType(): String = {
    asJava.contentType()
  }

  /**
    * @return the contentTransferEncoding for the upload
    */
  def contentTransferEncoding(): String = {
    asJava.contentTransferEncoding()
  }

  /**
    * @return the charset for the upload
    */
  def charset(): String = {
    asJava.charset()
  }

  /**
    * The size of the upload may not be available until it is all read.
    * Check [[io.vertx.core.http.HttpServerFileUpload#isSizeAvailable]] to determine this
    * @return the size of the upload (in bytes)
    */
  def size(): java.lang.Long = {
    asJava.size()
  }

  /**
    * @return true if the size of the upload can be retrieved via #size().
    */
  def isSizeAvailable(): java.lang.Boolean = {
    asJava.isSizeAvailable()
  }

}

import io.vertx.core.net.JksOptions
import io.vertx.core.net.{PfxOptions => JPfxOptions}
import io.vertx.core.http.Http2Settings
import io.vertx.core.http.{HttpServerOptions => JHttpServerOptions}
import io.vertx.core.net.{NetServerOptions => JNetServerOptions}
import io.vertx.core.net.PfxOptions
import io.vertx.core.net.OpenSSLEngineOptions
import io.vertx.core.net.NetServerOptions
import io.vertx.core.buffer.Buffer
import io.vertx.core.http.HttpVersion
import io.vertx.core.net.{OpenSSLEngineOptions => JOpenSSLEngineOptions}
import io.vertx.core.net.PemKeyCertOptions
import io.vertx.core.net.{JdkSSLEngineOptions => JJdkSSLEngineOptions}
import io.vertx.core.http.ClientAuth
import io.vertx.core.net.{PemTrustOptions => JPemTrustOptions}
import io.vertx.core.net.{PemKeyCertOptions => JPemKeyCertOptions}
import io.vertx.core.net.PemTrustOptions
import io.vertx.core.http.{Http2Settings => JHttp2Settings}
import io.vertx.core.net.JdkSSLEngineOptions
import io.vertx.core.net.{JksOptions => JJksOptions}

/**
  * Represents options used by an [[io.vertx.core.http.HttpServer]] instance
  */

  implicit class HttpServerOptionsScala(val asJava: JHttpServerOptions) extends AnyVal {


  /**
    * Set the accept back log
    */
    def setAcceptBacklog(value: java.lang.Integer) = {
      asJava.setAcceptBacklog(value)
    }
    def getAcceptBacklog: java.lang.Integer = {
      asJava.getAcceptBacklog()
    }

  /**
    * Set true when the server accepts unmasked frame.
    * As default Server doesn't accept unmasked frame, you can bypass this behaviour (RFC 6455) setting true
    * It's set to false as default.
    */
    def setAcceptUnmaskedFrames(value: java.lang.Boolean) = {
      asJava.setAcceptUnmaskedFrames(value)
    }
    def isAcceptUnmaskedFrames: java.lang.Boolean = {
      asJava.isAcceptUnmaskedFrames()
    }

  /**
    * Set the list of protocol versions to provide to the server during the Application-Layer Protocol Negotiatiation.
    */
    def setAlpnVersions(value: List[io.vertx.core.http.HttpVersion]) = {
      asJava.setAlpnVersions(value.asJava)
      }
    def getAlpnVersions: scala.collection.mutable.Buffer[io.vertx.core.http.HttpVersion] = {
      asJava.getAlpnVersions().asScala
    }

  /**
    * Set whether client auth is required
    */
    def setClientAuth(value: io.vertx.core.http.ClientAuth) = {
      asJava.setClientAuth(value)
    }
    def getClientAuth: io.vertx.core.http.ClientAuth = {
      asJava.getClientAuth()
    }

  /**
    * Set whether client auth is required
    */
    def setClientAuthRequired(value: java.lang.Boolean) = {
      asJava.setClientAuthRequired(value)
    }
    def isClientAuthRequired: java.lang.Boolean = {
      asJava.isClientAuthRequired()
    }

  /**
    * This method allows to set the compression level to be used in http1.x/2 response bodies
    * when compression support is turned on (@see setCompressionSupported) and the client advertises
    * to support `deflate/gzip` compression in the `Accept-Encoding` header
    *
    * default value is : 6 (Netty legacy)
    *
    * The compression level determines how much the data is compressed on a scale from 1 to 9,
    * where '9' is trying to achieve the maximum compression ratio while '1' instead is giving
    * priority to speed instead of compression ratio using some algorithm optimizations and skipping
    * pedantic loops that usually gives just little improvements
    *
    * While one can think that best value is always the maximum compression ratio,
    * there's a trade-off to consider: the most compressed level requires the most
    * computational work to compress/decompress data, e.g. more dictionary lookups and loops.
    *
    * E.g. you have it set fairly high on a high-volume website, you may experience performance degradation
    * and latency on resource serving due to CPU overload, and, however - as the computational work is required also client side
    * while decompressing - setting an higher compression level can result in an overall higher page load time
    * especially nowadays when many clients are handled mobile devices with a low CPU profile.
    *
    * see also: http://www.gzip.org/algorithm.txt
    */
    def setCompressionLevel(value: java.lang.Integer) = {
      asJava.setCompressionLevel(value)
    }
    def getCompressionLevel: java.lang.Integer = {
      asJava.getCompressionLevel()
    }

  /**
    * Set whether the server should support gzip/deflate compression
    * (serving compressed responses to clients advertising support for them with Accept-Encoding header)
    */
    def setCompressionSupported(value: java.lang.Boolean) = {
      asJava.setCompressionSupported(value)
    }
    def isCompressionSupported: java.lang.Boolean = {
      asJava.isCompressionSupported()
    }

  /**
    * Add a CRL path
    */
    def addCrlPath(value: String) = {
      asJava.addCrlPath(value)
      }
    def getCrlPaths: scala.collection.mutable.Buffer[String] = {
      asJava.getCrlPaths().asScala
    }

  /**
    * Add a CRL value
    */
    def addCrlValue(value: io.vertx.core.buffer.Buffer) = {
      asJava.addCrlValue(value)
      }
    def getCrlValues: scala.collection.mutable.Buffer[io.vertx.core.buffer.Buffer] = {
      asJava.getCrlValues().asScala
    }

  /**
    * Set the initial buffer size for the HTTP decoder
    */
    def setDecoderInitialBufferSize(value: java.lang.Integer) = {
      asJava.setDecoderInitialBufferSize(value)
    }
    def getDecoderInitialBufferSize: java.lang.Integer = {
      asJava.getDecoderInitialBufferSize()
    }

  /**
    * Set whether the server supports decompression
    */
    def setDecompressionSupported(value: java.lang.Boolean) = {
      asJava.setDecompressionSupported(value)
    }
    def isDecompressionSupported: java.lang.Boolean = {
      asJava.isDecompressionSupported()
    }

  /**
    * Add an enabled cipher suite, appended to the ordered suites.
    */
    def addEnabledCipherSuite(value: String) = {
      asJava.addEnabledCipherSuite(value)
      }
    def getEnabledCipherSuites: scala.collection.mutable.Set[String] = {
      asJava.getEnabledCipherSuites().asScala
    }

  /**
    * Sets the list of enabled SSL/TLS protocols.
    */
    def addEnabledSecureTransportProtocol(value: String) = {
      asJava.addEnabledSecureTransportProtocol(value)
      }
    def setEnabledSecureTransportProtocols(value: Set[String]) = {
      asJava.setEnabledSecureTransportProtocols(value.asJava)
    }
    def getEnabledSecureTransportProtocols: scala.collection.mutable.Set[String] = {
      asJava.getEnabledSecureTransportProtocols().asScala
    }

  /**
    * Set whether 100 Continue should be handled automatically
    */
    def setHandle100ContinueAutomatically(value: java.lang.Boolean) = {
      asJava.setHandle100ContinueAutomatically(value)
    }
    def isHandle100ContinueAutomatically: java.lang.Boolean = {
      asJava.isHandle100ContinueAutomatically()
    }

  /**
    * Set the host
    */
    def setHost(value: String) = {
      asJava.setHost(value)
    }
    def getHost: String = {
      asJava.getHost()
    }

  /**
    * Set the default HTTP/2 connection window size. It overrides the initial window
    * size set by <a href="../../../../../../../cheatsheet/Http2Settings.html">Http2Settings</a>, so the connection window size
    * is greater than for its streams, in order the data throughput.
    * <p/>
    * A value of `-1` reuses the initial window size setting.
    */
    def setHttp2ConnectionWindowSize(value: java.lang.Integer) = {
      asJava.setHttp2ConnectionWindowSize(value)
    }
    def getHttp2ConnectionWindowSize: java.lang.Integer = {
      asJava.getHttp2ConnectionWindowSize()
    }

  /**
    * Set the idle timeout, in seconds. zero means don't timeout.
    * This determines if a connection will timeout and be closed if no data is received within the timeout.
    */
    def setIdleTimeout(value: java.lang.Integer) = {
      asJava.setIdleTimeout(value)
    }
    def getIdleTimeout: java.lang.Integer = {
      asJava.getIdleTimeout()
    }

  /**
    * Set the HTTP/2 connection settings immediatly sent by the server when a client connects.
    */
    def setInitialSettings(value: JHttp2Settings) = {
      asJava.setInitialSettings(value.asJava)
    }
    def getInitialSettings: JHttp2Settings = {
      asJava.getInitialSettings()
    }
    def setJdkSslEngineOptions(value: JJdkSSLEngineOptions) = {
      asJava.setJdkSslEngineOptions(value.asJava)
    }
    def getJdkSslEngineOptions: JJdkSSLEngineOptions = {
      asJava.getJdkSslEngineOptions()
    }

  /**
    * Set the key/cert options in jks format, aka Java keystore.
    */
    def setKeyStoreOptions(value: JJksOptions) = {
      asJava.setKeyStoreOptions(value.asJava)
    }
    def getKeyStoreOptions: JJksOptions = {
      asJava.getKeyStoreOptions()
    }

  /**
    * Set to true to enabled network activity logging: Netty's pipeline is configured for logging on Netty's logger.
    */
    def setLogActivity(value: java.lang.Boolean) = {
      asJava.setLogActivity(value)
    }
    def getLogActivity: java.lang.Boolean = {
      asJava.getLogActivity()
    }

  /**
    * Set the maximum HTTP chunk size
    */
    def setMaxChunkSize(value: java.lang.Integer) = {
      asJava.setMaxChunkSize(value)
    }
    def getMaxChunkSize: java.lang.Integer = {
      asJava.getMaxChunkSize()
    }

  /**
    * Set the maximum length of all headers for HTTP/1.x .
    */
    def setMaxHeaderSize(value: java.lang.Integer) = {
      asJava.setMaxHeaderSize(value)
    }
    def getMaxHeaderSize: java.lang.Integer = {
      asJava.getMaxHeaderSize()
    }

  /**
    * Set the maximum length of the initial line for HTTP/1.x (e.g. `"GET / HTTP/1.0"`)
    */
    def setMaxInitialLineLength(value: java.lang.Integer) = {
      asJava.setMaxInitialLineLength(value)
    }
    def getMaxInitialLineLength: java.lang.Integer = {
      asJava.getMaxInitialLineLength()
    }

  /**
    * Set the maximum websocket frames size
    */
    def setMaxWebsocketFrameSize(value: java.lang.Integer) = {
      asJava.setMaxWebsocketFrameSize(value)
    }
    def getMaxWebsocketFrameSize: java.lang.Integer = {
      asJava.getMaxWebsocketFrameSize()
    }

  /**
    * Set the maximum websocket message size
    */
    def setMaxWebsocketMessageSize(value: java.lang.Integer) = {
      asJava.setMaxWebsocketMessageSize(value)
    }
    def getMaxWebsocketMessageSize: java.lang.Integer = {
      asJava.getMaxWebsocketMessageSize()
    }
    def setOpenSslEngineOptions(value: JOpenSSLEngineOptions) = {
      asJava.setOpenSslEngineOptions(value.asJava)
    }
    def getOpenSslEngineOptions: JOpenSSLEngineOptions = {
      asJava.getOpenSslEngineOptions()
    }

  /**
    * Set the key/cert store options in pem format.
    */
    def setPemKeyCertOptions(value: JPemKeyCertOptions) = {
      asJava.setPemKeyCertOptions(value.asJava)
    }
    def getPemKeyCertOptions: JPemKeyCertOptions = {
      asJava.getPemKeyCertOptions()
    }

  /**
    * Set the trust options in pem format
    */
    def setPemTrustOptions(value: JPemTrustOptions) = {
      asJava.setPemTrustOptions(value.asJava)
    }
    def getPemTrustOptions: JPemTrustOptions = {
      asJava.getPemTrustOptions()
    }

  /**
    * Set the key/cert options in pfx format.
    */
    def setPfxKeyCertOptions(value: JPfxOptions) = {
      asJava.setPfxKeyCertOptions(value.asJava)
    }
    def getPfxKeyCertOptions: JPfxOptions = {
      asJava.getPfxKeyCertOptions()
    }

  /**
    * Set the trust options in pfx format
    */
    def setPfxTrustOptions(value: JPfxOptions) = {
      asJava.setPfxTrustOptions(value.asJava)
    }
    def getPfxTrustOptions: JPfxOptions = {
      asJava.getPfxTrustOptions()
    }

  /**
    * Set the port
    */
    def setPort(value: java.lang.Integer) = {
      asJava.setPort(value)
    }
    def getPort: java.lang.Integer = {
      asJava.getPort()
    }

  /**
    * Set the TCP receive buffer size
    */
    def setReceiveBufferSize(value: java.lang.Integer) = {
      asJava.setReceiveBufferSize(value)
    }
    def getReceiveBufferSize: java.lang.Integer = {
      asJava.getReceiveBufferSize()
    }

  /**
    * Set the value of reuse address
    */
    def setReuseAddress(value: java.lang.Boolean) = {
      asJava.setReuseAddress(value)
    }
    def isReuseAddress: java.lang.Boolean = {
      asJava.isReuseAddress()
    }

  /**
    * Set the value of reuse port.
    * <p/>
    * This is only supported by native transports.
    */
    def setReusePort(value: java.lang.Boolean) = {
      asJava.setReusePort(value)
    }
    def isReusePort: java.lang.Boolean = {
      asJava.isReusePort()
    }

  /**
    * Set the TCP send buffer size
    */
    def setSendBufferSize(value: java.lang.Integer) = {
      asJava.setSendBufferSize(value)
    }
    def getSendBufferSize: java.lang.Integer = {
      asJava.getSendBufferSize()
    }

  /**
    * Set whether the server supports Server Name Indiciation
    */
    def setSni(value: java.lang.Boolean) = {
      asJava.setSni(value)
    }
    def isSni: java.lang.Boolean = {
      asJava.isSni()
    }

  /**
    * Set whether SO_linger keep alive is enabled
    */
    def setSoLinger(value: java.lang.Integer) = {
      asJava.setSoLinger(value)
    }
    def getSoLinger: java.lang.Integer = {
      asJava.getSoLinger()
    }

  /**
    * Set whether SSL/TLS is enabled
    */
    def setSsl(value: java.lang.Boolean) = {
      asJava.setSsl(value)
    }
    def isSsl: java.lang.Boolean = {
      asJava.isSsl()
    }

  /**
    * Enable the `TCP_CORK` option - only with linux native transport.
    */
    def setTcpCork(value: java.lang.Boolean) = {
      asJava.setTcpCork(value)
    }
    def isTcpCork: java.lang.Boolean = {
      asJava.isTcpCork()
    }

  /**
    * Enable the `TCP_FASTOPEN` option - only with linux native transport.
    */
    def setTcpFastOpen(value: java.lang.Boolean) = {
      asJava.setTcpFastOpen(value)
    }
    def isTcpFastOpen: java.lang.Boolean = {
      asJava.isTcpFastOpen()
    }

  /**
    * Set whether TCP keep alive is enabled
    */
    def setTcpKeepAlive(value: java.lang.Boolean) = {
      asJava.setTcpKeepAlive(value)
    }
    def isTcpKeepAlive: java.lang.Boolean = {
      asJava.isTcpKeepAlive()
    }

  /**
    * Set whether TCP no delay is enabled
    */
    def setTcpNoDelay(value: java.lang.Boolean) = {
      asJava.setTcpNoDelay(value)
    }
    def isTcpNoDelay: java.lang.Boolean = {
      asJava.isTcpNoDelay()
    }

  /**
    * Enable the `TCP_QUICKACK` option - only with linux native transport.
    */
    def setTcpQuickAck(value: java.lang.Boolean) = {
      asJava.setTcpQuickAck(value)
    }
    def isTcpQuickAck: java.lang.Boolean = {
      asJava.isTcpQuickAck()
    }

  /**
    * Set the value of traffic class
    */
    def setTrafficClass(value: java.lang.Integer) = {
      asJava.setTrafficClass(value)
    }
    def getTrafficClass: java.lang.Integer = {
      asJava.getTrafficClass()
    }

  /**
    * Set the trust options in jks format, aka Java truststore
    */
    def setTrustStoreOptions(value: JJksOptions) = {
      asJava.setTrustStoreOptions(value.asJava)
    }
    def getTrustStoreOptions: JJksOptions = {
      asJava.getTrustStoreOptions()
    }

  /**
    * Set the ALPN usage.
    */
    def setUseAlpn(value: java.lang.Boolean) = {
      asJava.setUseAlpn(value)
    }
    def isUseAlpn: java.lang.Boolean = {
      asJava.isUseAlpn()
    }

  /**
    * Set whether Netty pooled buffers are enabled
    */
    def setUsePooledBuffers(value: java.lang.Boolean) = {
      asJava.setUsePooledBuffers(value)
    }
    def isUsePooledBuffers: java.lang.Boolean = {
      asJava.isUsePooledBuffers()
    }

  /**
    * Set the websocket subprotocols supported by the server.
    */
    def setWebsocketSubProtocols(value: String) = {
      asJava.setWebsocketSubProtocols(value)
    }
    def getWebsocketSubProtocols: String = {
      asJava.getWebsocketSubProtocols()
    }
  }
  
  type HttpServerOptions = JHttpServerOptions
  object HttpServerOptions {
    def apply(): JHttpServerOptions = new HttpServerOptions()
    def apply(json: JsonObject) = new JHttpServerOptions(json)
  }


import io.vertx.core.http.HttpServerRequest
import io.vertx.core.http.ServerWebSocket
import io.vertx.core.http.HttpServerFileUpload
import io.vertx.core.http.{HttpServerResponse => JHttpServerResponse}
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.core.http.{HttpConnection => JHttpConnection}
import io.vertx.core.MultiMap
import io.vertx.core.http.{HttpFrame => JHttpFrame}
import io.vertx.core.http.{HttpServerFileUpload => JHttpServerFileUpload}
import io.vertx.core.http.{HttpServerRequest => JHttpServerRequest}
import io.vertx.core.net.{NetSocket => JNetSocket}
import io.vertx.core.buffer.Buffer
import io.vertx.core.http.HttpFrame
import io.vertx.core.http.{ServerWebSocket => JServerWebSocket}
import io.vertx.core.http.HttpVersion
import io.vertx.core.http.HttpMethod
import io.vertx.core.http.HttpServerResponse
import io.vertx.core.streams.ReadStream
import io.vertx.core.{MultiMap => JMultiMap}
import io.vertx.core.net.{SocketAddress => JSocketAddress}
import io.vertx.core.http.HttpConnection
import io.vertx.core.Handler
import io.vertx.core.net.SocketAddress
import io.vertx.core.net.NetSocket

/**
  * Represents a server-side HTTP request.
  * 
  * Instances are created for each request and passed to the user via a handler.
  * 
  * Each instance of this class is associated with a corresponding [[io.vertx.core.http.HttpServerResponse]] instance via
  * [[io.vertx.core.http.HttpServerRequest#response]].
  * It implements [[io.vertx.core.streams.ReadStream]] so it can be used with
  * [[io.vertx.core.streams.Pump]] to pump data with flow control.
  * 
  */
implicit class HttpServerRequestScala(val asJava: JHttpServerRequest) extends AnyVal {


  def exceptionHandler(handler: scala.Option[Throwable => Unit]): JHttpServerRequest = {
    asJava.exceptionHandler(handler match {case Some(t) => (p:Throwable) => t(p); case None => null})
  }

  def handler(handler: scala.Option[io.vertx.core.buffer.Buffer => Unit]): JHttpServerRequest = {
    asJava.handler(handler match {case Some(t) => (p:io.vertx.core.buffer.Buffer) => t(p); case None => null})
  }

  def pause(): JHttpServerRequest = {
    asJava.pause()
  }

  def resume(): JHttpServerRequest = {
    asJava.resume()
  }

  def endHandler(endHandler: scala.Option[Void => Unit]): JHttpServerRequest = {
    asJava.endHandler(endHandler match {case Some(t) => (p:Void) => t(p); case None => null})
  }

  /**
    * Convenience method for receiving the entire request body in one piece.
    * 
    * This saves the user having to manually setting a data and end handler and append the chunks of the body until
    * the whole body received. Don't use this if your request body is large - you could potentially run out of RAM.
    * @param bodyHandler This handler will be called after all the body has been received
    */
  def bodyHandler(bodyHandler: scala.Option[io.vertx.core.buffer.Buffer => Unit]): JHttpServerRequest = {
    asJava.bodyHandler(bodyHandler match {case Some(t) => (p:io.vertx.core.buffer.Buffer) => t(p); case None => null})
  }

  /**
    * Call this with true if you are expecting a multi-part body to be submitted in the request.
    * This must be called before the body of the request has been received
    * @param expect true - if you are expecting a multi-part body
    * @return a reference to this, so the API can be used fluently
    */
  def setExpectMultipart(expect: java.lang.Boolean): JHttpServerRequest = {
    asJava.setExpectMultipart(expect)
  }

  /**
    * Set an upload handler. The handler will get notified once a new file upload was received to allow you to deal
    * with the file upload.
    * @return a reference to this, so the API can be used fluently
    */
  def uploadHandler(uploadHandler: scala.Option[JHttpServerFileUpload => Unit]): JHttpServerRequest = {
    asJava.uploadHandler(uploadHandler match {case Some(t) => (p:JHttpServerFileUpload) => t(p); case None => null})
  }

  /**
    * Set a custom frame handler. The handler will get notified when the http stream receives an custom HTTP/2
    * frame. HTTP/2 permits extension of the protocol.
    * @return a reference to this, so the API can be used fluently
    */
  def customFrameHandler(handler: JHttpFrame => Unit): JHttpServerRequest = {
    asJava.customFrameHandler((p:JHttpFrame) => handler(p))
  }

  /**
    * @return the HTTP version of the request
    */
  def version(): io.vertx.core.http.HttpVersion = {
    asJava.version()
  }

  /**
    * @return the HTTP method for the request.
    */
  def method(): io.vertx.core.http.HttpMethod = {
    asJava.method()
  }

  /**
    * @return the HTTP method as sent by the client
    */
  def rawMethod(): String = {
    asJava.rawMethod()
  }

  /**
    * @return true if this io.vertx.core.net.NetSocket is encrypted via SSL/TLS
    */
  def isSSL(): java.lang.Boolean = {
    asJava.isSSL()
  }

  /**
    * @return the scheme of the request
    */
  def scheme(): scala.Option[String] = {
    scala.Option(asJava.scheme())
  }

  /**
    * @return the URI of the request. This is usually a relative URI
    */
  def uri(): String = {
    asJava.uri()
  }

  /**
    * @return The path part of the uri. For example /somepath/somemorepath/someresource.foo
    */
  def path(): scala.Option[String] = {
    scala.Option(asJava.path())
  }

  /**
    * @return the query part of the uri. For example someparam=32&amp;someotherparam=x
    */
  def query(): scala.Option[String] = {
    scala.Option(asJava.query())
  }

  /**
    * @return the request host. For HTTP2 it returns the ` :authority` pseudo header otherwise it returns the ` Host` header
    */
  def host(): scala.Option[String] = {
    scala.Option(asJava.host())
  }

  /**
    * Return the first header value with the specified name
    * @param headerName the header name
    * @return the header value
    */
  def getHeader(headerName: String): scala.Option[String] = {
    scala.Option(asJava.getHeader(headerName))
  }

  /**
    * Return the first param value with the specified name
    * @param paramName the param name
    * @return the param value
    */
  def getParam(paramName: String): scala.Option[String] = {
    scala.Option(asJava.getParam(paramName))
  }

  /**
    * @return the absolute URI corresponding to the the HTTP request
    */
  def absoluteURI(): String = {
    asJava.absoluteURI()
  }

  /**
    * @return true if we are expecting a multi-part body for this request. See #setExpectMultipart.
    */
  def isExpectMultipart(): java.lang.Boolean = {
    asJava.isExpectMultipart()
  }

  /**
    * Return the first form attribute value with the specified name
    * @param attributeName the attribute name
    * @return the attribute value
    */
  def getFormAttribute(attributeName: String): scala.Option[String] = {
    scala.Option(asJava.getFormAttribute(attributeName))
  }

  /**
    * Upgrade the connection to a WebSocket connection.
    * 
    * This is an alternative way of handling WebSockets and can only be used if no websocket handlers are set on the
    * Http server, and can only be used during the upgrade request during the WebSocket handshake.
    * @return the WebSocket
    */
  def upgrade(): JServerWebSocket = {
    asJava.upgrade()
  }

  /**
    * Has the request ended? I.e. has the entire request, including the body been read?
    * @return true if ended
    */
  def isEnded(): java.lang.Boolean = {
    asJava.isEnded()
  }

  /**
    * @return the response. Each instance of this class has an HttpServerResponse instance attached to it. This is used to send the response back to the client.
    */
  def response(): JHttpServerResponse = {
    asJava.response()
  }

  /**
    * @return the headers in the request.
    */
  def headers(): JMultiMap = {
    asJava.headers()
  }

  /**
    * @return the query parameters in the request
    */
  def params(): JMultiMap = {
    asJava.params()
  }

  /**
    * @return the remote (client side) address of the request
    */
  def remoteAddress(): JSocketAddress = {
    asJava.remoteAddress()
  }

  /**
    * @return the local (server side) address of the server that handles the request
    */
  def localAddress(): JSocketAddress = {
    asJava.localAddress()
  }

  /**
    * Get a net socket for the underlying connection of this request.
    * 
    * USE THIS WITH CAUTION!
    * 
    * Once you have called this method, you must handle writing to the connection yourself using the net socket,
    * the server request instance will no longer be usable as normal.
    * Writing to the socket directly if you don't know what you're doing can easily break the HTTP protocol.
    * @return the net socket
    */
  def netSocket(): JNetSocket = {
    asJava.netSocket()
  }

  /**
    * Returns a map of all form attributes in the request.
    * 
    * Be aware that the attributes will only be available after the whole body has been received, i.e. after
    * the request end handler has been called.
    * 
    * [[io.vertx.core.http.HttpServerRequest#setExpectMultipart]] must be called first before trying to get the form attributes.
    * @return the form attributes
    */
  def formAttributes(): JMultiMap = {
    asJava.formAttributes()
  }

  /**
    * @return the HttpConnection associated with this request
    */
  def connection(): JHttpConnection = {
    asJava.connection()
  }

}

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.http.{HttpServerResponse => JHttpServerResponse}
import io.vertx.core.MultiMap
import io.vertx.core.http.{HttpFrame => JHttpFrame}
import io.vertx.core.streams.{WriteStream => JWriteStream}
import io.vertx.core.buffer.Buffer
import io.vertx.core.http.HttpFrame
import io.vertx.core.streams.WriteStream
import io.vertx.core.http.HttpServerResponse
import io.vertx.core.http.HttpMethod
import io.vertx.core.{MultiMap => JMultiMap}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler

/**
  * Represents a server-side HTTP response.
  * 
  * An instance of this is created and associated to every instance of
  * [[io.vertx.core.http.HttpServerRequest]] that.
  * 
  * It allows the developer to control the HTTP response that is sent back to the
  * client for a particular HTTP request.
  * 
  * It contains methods that allow HTTP headers and trailers to be set, and for a body to be written out to the response.
  * 
  * It also allows files to be streamed by the kernel directly from disk to the
  * outgoing HTTP connection, bypassing user space altogether (where supported by
  * the underlying operating system). This is a very efficient way of
  * serving files from the server since buffers do not have to be read one by one
  * from the file and written to the outgoing socket.
  * 
  * It implements [[io.vertx.core.streams.WriteStream]] so it can be used with
  * [[io.vertx.core.streams.Pump]] to pump data with flow control.
  */
implicit class HttpServerResponseScala(val asJava: JHttpServerResponse) extends AnyVal {


  def exceptionHandler(handler: scala.Option[Throwable => Unit]): JHttpServerResponse = {
    asJava.exceptionHandler(handler match {case Some(t) => (p:Throwable) => t(p); case None => null})
  }

  def write(data: io.vertx.core.buffer.Buffer): JHttpServerResponse = {
    asJava.write(data)
  }

  def setWriteQueueMaxSize(maxSize: java.lang.Integer): JHttpServerResponse = {
    asJava.setWriteQueueMaxSize(maxSize)
  }

  def drainHandler(handler: scala.Option[Void => Unit]): JHttpServerResponse = {
    asJava.drainHandler(handler match {case Some(t) => (p:Void) => t(p); case None => null})
  }

  /**
    * Set the status code. If the status message hasn't been explicitly set, a default status message corresponding
    * to the code will be looked-up and used.
    * @return a reference to this, so the API can be used fluently
    */
  def setStatusCode(statusCode: java.lang.Integer): JHttpServerResponse = {
    asJava.setStatusCode(statusCode)
  }

  /**
    * Set the status message
    * @return a reference to this, so the API can be used fluently
    */
  def setStatusMessage(statusMessage: String): JHttpServerResponse = {
    asJava.setStatusMessage(statusMessage)
  }

  /**
    * If `chunked` is `true`, this response will use HTTP chunked encoding, and each call to write to the body
    * will correspond to a new HTTP chunk sent on the wire.
    * 
    * If chunked encoding is used the HTTP header `Transfer-Encoding` with a value of `Chunked` will be
    * automatically inserted in the response.
    * 
    * If `chunked` is `false`, this response will not use HTTP chunked encoding, and therefore the total size
    * of any data that is written in the respone body must be set in the `Content-Length` header <b>before</b> any
    * data is written out.
    * 
    * An HTTP chunked response is typically used when you do not know the total size of the request body up front.
    * @return a reference to this, so the API can be used fluently
    */
  def setChunked(chunked: java.lang.Boolean): JHttpServerResponse = {
    asJava.setChunked(chunked)
  }

  /**
    * Put an HTTP header
    * @param name the header name
    * @param value the header value.
    * @return a reference to this, so the API can be used fluently
    */
  def putHeader(name: String, value: String): JHttpServerResponse = {
    asJava.putHeader(name, value)
  }

  /**
    * Put an HTTP trailer
    * @param name the trailer name
    * @param value the trailer value
    * @return a reference to this, so the API can be used fluently
    */
  def putTrailer(name: String, value: String): JHttpServerResponse = {
    asJava.putTrailer(name, value)
  }

  /**
    * Set a close handler for the response, this is called when the underlying connection is closed and the response
    * was still using the connection.
    * 
    * For HTTP/1.x it is called when the connection is closed before `end()` is called, therefore it is not
    * guaranteed to be called.
    * 
    * For HTTP/2 it is called when the related stream is closed, and therefore it will be always be called.
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  def closeHandler(handler: scala.Option[Void => Unit]): JHttpServerResponse = {
    asJava.closeHandler(handler match {case Some(t) => (p:Void) => t(p); case None => null})
  }

  /**
    * Set an end handler for the response. This will be called when the response is disposed to allow consistent cleanup
    * of the response.
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  def endHandler(handler: scala.Option[Void => Unit]): JHttpServerResponse = {
    asJava.endHandler(handler match {case Some(t) => (p:Void) => t(p); case None => null})
  }

  /**
    * Write a String to the response body, encoded using the encoding `enc`.
    * @param chunk the string to write
    * @param enc the encoding to use
    * @return a reference to this, so the API can be used fluently
    */
  def write(chunk: String, enc: String): JHttpServerResponse = {
    asJava.write(chunk, enc)
  }

  /**
    * Write a String to the response body, encoded in UTF-8.
    * @param chunk the string to write
    * @return a reference to this, so the API can be used fluently
    */
  def write(chunk: String): JHttpServerResponse = {
    asJava.write(chunk)
  }

  /**
    * Used to write an interim 100 Continue response to signify that the client should send the rest of the request.
    * Must only be used if the request contains an "Expect:100-Continue" header
    * @return a reference to this, so the API can be used fluently
    */
  def writeContinue(): JHttpServerResponse = {
    asJava.writeContinue()
  }

  /**
    * Same as [[io.vertx.core.http.HttpServerResponse#sendFile]] using offset `0` which means starting from the beginning of the file.
    * @param filename path to the file to serve
    * @return a reference to this, so the API can be used fluently
    */
  def sendFile(filename: String): JHttpServerResponse = {
    asJava.sendFile(filename)
  }

  /**
    * Same as [[io.vertx.core.http.HttpServerResponse#sendFile]] using length `Long.MAX_VALUE` which means until the end of the
    * file.
    * @param filename path to the file to serve
    * @param offset offset to start serving from
    * @return a reference to this, so the API can be used fluently
    */
  def sendFile(filename: String, offset: java.lang.Long): JHttpServerResponse = {
    asJava.sendFile(filename, offset)
  }

  /**
    * Ask the OS to stream a file as specified by `filename` directly
    * from disk to the outgoing connection, bypassing userspace altogether
    * (where supported by the underlying operating system.
    * This is a very efficient way to serve files.
    * The actual serve is asynchronous and may not complete until some time after this method has returned.
    * @param filename path to the file to serve
    * @param offset offset to start serving from
    * @param length length to serve to
    * @return a reference to this, so the API can be used fluently
    */
  def sendFile(filename: String, offset: java.lang.Long, length: java.lang.Long): JHttpServerResponse = {
    asJava.sendFile(filename, offset, length)
  }

  /**
    * Like [[io.vertx.core.http.HttpServerResponse#sendFile]] but providing a handler which will be notified once the file has been completely
    * written to the wire.
    * @param filename path to the file to serve
    * @param resultHandler handler that will be called on completion
    * @return a reference to this, so the API can be used fluently
    */
  def sendFile(filename: String, resultHandler: AsyncResult[Void] => Unit): JHttpServerResponse = {
    asJava.sendFile(filename, (p:AsyncResult[Void]) => resultHandler(p))
  }

  /**
    * Like [[io.vertx.core.http.HttpServerResponse#sendFile]] but providing a handler which will be notified once the file has been completely
    * written to the wire.
    * @param filename path to the file to serve
    * @param offset the offset to serve from
    * @param resultHandler handler that will be called on completion
    * @return a reference to this, so the API can be used fluently
    */
  def sendFile(filename: String, offset: java.lang.Long, resultHandler: AsyncResult[Void] => Unit): JHttpServerResponse = {
    asJava.sendFile(filename, offset, (p:AsyncResult[Void]) => resultHandler(p))
  }

  /**
    * Like [[io.vertx.core.http.HttpServerResponse#sendFile]] but providing a handler which will be notified once the file has been
    * completely written to the wire.
    * @param filename path to the file to serve
    * @param offset the offset to serve from
    * @param length the length to serve to
    * @param resultHandler handler that will be called on completion
    * @return a reference to this, so the API can be used fluently
    */
  def sendFile(filename: String, offset: java.lang.Long, length: java.lang.Long, resultHandler: AsyncResult[Void] => Unit): JHttpServerResponse = {
    asJava.sendFile(filename, offset, length, (p:AsyncResult[Void]) => resultHandler(p))
  }

  /**
    * Provide a handler that will be called just before the headers are written to the wire.
    * This provides a hook allowing you to add any more headers or do any more operations before this occurs.
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  def headersEndHandler(handler: scala.Option[Void => Unit]): JHttpServerResponse = {
    asJava.headersEndHandler(handler match {case Some(t) => (p:Void) => t(p); case None => null})
  }

  /**
    * Provides a handler that will be called after the last part of the body is written to the wire.
    * The handler is called asynchronously of when the response has been received by the client.
    * This provides a hook allowing you to do more operations once the request has been sent over the wire
    * such as resource cleanup.
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  def bodyEndHandler(handler: scala.Option[Void => Unit]): JHttpServerResponse = {
    asJava.bodyEndHandler(handler match {case Some(t) => (p:Void) => t(p); case None => null})
  }

  /**
    * Like [[io.vertx.core.http.HttpServerResponse#pushFuture]] with the host copied from the current request.
    */
  def push(method: io.vertx.core.http.HttpMethod, path: String, handler: AsyncResult[JHttpServerResponse] => Unit): JHttpServerResponse = {
    asJava.push(method, path, (p:AsyncResult[JHttpServerResponse]) => handler(p))
  }

  /**
    * Push a response to the client.<p/>
    *
    * The `handler` will be notified with a <i>success</i> when the push can be sent and with
    * a <i>failure</i> when the client has disabled push or reset the push before it has been sent.<p/>
    *
    * The `handler` may be queued if the client has reduced the maximum number of streams the server can push
    * concurrently.<p/>
    *
    * Push can be sent only for peer initiated streams and if the response is not ended.
    * @param method the method of the promised request
    * @param host the host of the promised request
    * @param path the path of the promised request
    * @param headers the headers of the promised request
    * @param handler the handler notified when the response can be written
    * @return a reference to this, so the API can be used fluently
    */
  def push(method: io.vertx.core.http.HttpMethod, host: String, path: String, headers: JMultiMap, handler: AsyncResult[JHttpServerResponse] => Unit): JHttpServerResponse = {
    asJava.push(method, host, path, headers.asJava, (p:AsyncResult[JHttpServerResponse]) => handler(p))
  }

  /**
    * Write an HTTP/2 frame to the response, allowing to extend the HTTP/2 protocol.
    *
    * The frame is sent immediatly and is not subject to flow control.
    * @param type the 8-bit frame type
    * @param flags the 8-bit frame flags
    * @param payload the frame payload
    * @return a reference to this, so the API can be used fluently
    */
  def writeCustomFrame(`type`: java.lang.Integer, flags: java.lang.Integer, payload: io.vertx.core.buffer.Buffer): JHttpServerResponse = {
    asJava.writeCustomFrame(`type`, flags, payload)
  }

  /**
    * Like [[io.vertx.core.http.HttpServerResponse#writeCustomFrame]] but with an [[io.vertx.core.http.HttpFrame]].
    * @param frame the frame to write
    */
  def writeCustomFrame(frame: JHttpFrame): JHttpServerResponse = {
    asJava.writeCustomFrame(frame.asJava)
  }

  /**
    * Reset this HTTP/2 stream with the error code `0`.
    */
  def reset(): Unit = {
    asJava.reset()
  }

  /**
    * This will return `true` if there are more bytes in the write queue than the value set using [[io.vertx.core.http.HttpServerResponse#setWriteQueueMaxSize]]
    * @return true if write queue is full
    */
  def writeQueueFull(): java.lang.Boolean = {
    asJava.writeQueueFull()
  }

  /**
    * @return the HTTP status code of the response. The default is `200` representing `OK`.
    */
  def getStatusCode(): java.lang.Integer = {
    asJava.getStatusCode()
  }

  /**
    * @return the HTTP status message of the response. If this is not specified a default value will be used depending on what #setStatusCode has been set to.
    */
  def getStatusMessage(): String = {
    asJava.getStatusMessage()
  }

  /**
    * @return is the response chunked?
    */
  def isChunked(): java.lang.Boolean = {
    asJava.isChunked()
  }

  /**
    * Same as [[io.vertx.core.http.HttpServerResponse#end]] but writes a String in UTF-8 encoding before ending the response.
    * @param chunk the string to write before ending the response
    */
  def end(chunk: String): Unit = {
    asJava.end(chunk)
  }

  /**
    * Same as [[io.vertx.core.http.HttpServerResponse#end]] but writes a String with the specified encoding before ending the response.
    * @param chunk the string to write before ending the response
    * @param enc the encoding to use
    */
  def end(chunk: String, enc: String): Unit = {
    asJava.end(chunk, enc)
  }

  /**
    * Same as [[io.vertx.core.http.HttpServerResponse#end]] but writes some data to the response body before ending. If the response is not chunked and
    * no other data has been written then the `Content-Length` header will be automatically set.
    * @param chunk the buffer to write before ending the response
    */
  def end(chunk: io.vertx.core.buffer.Buffer): Unit = {
    asJava.end(chunk)
  }

  /**
    * Ends the response. If no data has been written to the response body,
    * the actual response won't get written until this method gets called.
    * 
    * Once the response has ended, it cannot be used any more.
    */
  def end(): Unit = {
    asJava.end()
  }

  /**
    * Close the underlying TCP connection corresponding to the request.
    */
  def close(): Unit = {
    asJava.close()
  }

  /**
    * @return has the response already ended?
    */
  def ended(): java.lang.Boolean = {
    asJava.ended()
  }

  /**
    * @return has the underlying TCP connection corresponding to the request already been closed?
    */
  def closed(): java.lang.Boolean = {
    asJava.closed()
  }

  /**
    * @return have the headers for the response already been written?
    */
  def headWritten(): java.lang.Boolean = {
    asJava.headWritten()
  }

  /**
    * @return the total number of bytes written for the body of the response.
    */
  def bytesWritten(): java.lang.Long = {
    asJava.bytesWritten()
  }

  /**
    * @return the id of the stream of this response, ` -1` for HTTP/1.x
    */
  def streamId(): java.lang.Integer = {
    asJava.streamId()
  }

  /**
    * Like [[io.vertx.core.http.HttpServerResponse#pushFuture]] with no headers.
    */
  def push(method: io.vertx.core.http.HttpMethod, host: String, path: String, handler: AsyncResult[JHttpServerResponse] => Unit): JHttpServerResponse = {
    asJava.push(method, host, path, (p:AsyncResult[JHttpServerResponse]) => handler(p))
  }

  /**
    * Like [[io.vertx.core.http.HttpServerResponse#pushFuture]] with the host copied from the current request.
    */
  def push(method: io.vertx.core.http.HttpMethod, path: String, headers: JMultiMap, handler: AsyncResult[JHttpServerResponse] => Unit): JHttpServerResponse = {
    asJava.push(method, path, headers.asJava, (p:AsyncResult[JHttpServerResponse]) => handler(p))
  }

  /**
    * Reset this HTTP/2 stream with the error `code`.
    * @param code the error code
    */
  def reset(code: java.lang.Long): Unit = {
    asJava.reset(code)
  }

  /**
    * @return The HTTP headers
    */
  def headers(): JMultiMap = {
    asJava.headers()
  }

  /**
    * @return The HTTP trailers
    */
  def trailers(): JMultiMap = {
    asJava.trailers()
  }

 /**
   * Like [[sendFile]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def sendFileFuture(filename: String): scala.concurrent.Future[Unit] = {
    val promise = Promise[Unit]()
    asJava.sendFile(filename, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[sendFile]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def sendFileFuture(filename: String, offset: java.lang.Long): scala.concurrent.Future[Unit] = {
    val promise = Promise[Unit]()
    asJava.sendFile(filename, offset, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[sendFile]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def sendFileFuture(filename: String, offset: java.lang.Long, length: java.lang.Long): scala.concurrent.Future[Unit] = {
    val promise = Promise[Unit]()
    asJava.sendFile(filename, offset, length, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[push]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def pushFuture(method: io.vertx.core.http.HttpMethod, host: String, path: String): scala.concurrent.Future[JHttpServerResponse] = {
    val promise = Promise[JHttpServerResponse]()
    asJava.push(method, host, path, {a:AsyncResult[io.vertx.core.http.HttpServerResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[push]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def pushFuture(method: io.vertx.core.http.HttpMethod, path: String, headers: JMultiMap): scala.concurrent.Future[JHttpServerResponse] = {
    val promise = Promise[JHttpServerResponse]()
    asJava.push(method, path, headers, {a:AsyncResult[io.vertx.core.http.HttpServerResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[push]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def pushFuture(method: io.vertx.core.http.HttpMethod, path: String): scala.concurrent.Future[JHttpServerResponse] = {
    val promise = Promise[JHttpServerResponse]()
    asJava.push(method, path, {a:AsyncResult[io.vertx.core.http.HttpServerResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[push]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def pushFuture(method: io.vertx.core.http.HttpMethod, host: String, path: String, headers: JMultiMap): scala.concurrent.Future[JHttpServerResponse] = {
    val promise = Promise[JHttpServerResponse]()
    asJava.push(method, host, path, headers, {a:AsyncResult[io.vertx.core.http.HttpServerResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

}

import io.vertx.core.net.{JdkSSLEngineOptions => JJdkSSLEngineOptions}

/**
  * Configures a <a href="../../../../../../../cheatsheet/TCPSSLOptions.html">TCPSSLOptions</a> to use the JDK ssl engine implementation.
  */

  implicit class JdkSSLEngineOptionsScala(val asJava: JJdkSSLEngineOptions) extends AnyVal {

  }
  
  type JdkSSLEngineOptions = JJdkSSLEngineOptions
  object JdkSSLEngineOptions {
    def apply(): JJdkSSLEngineOptions = new JdkSSLEngineOptions()
    def apply(json: JsonObject) = new JJdkSSLEngineOptions(json)
  }


import io.vertx.core.buffer.Buffer
import io.vertx.core.net.{JksOptions => JJksOptions}

/**
  * Key or trust store options configuring private key and/or certificates based on Java Keystore files.
  * 
  * When used as a key store, it should point to a store containing a private key and its certificate.
  * When used as a trust store, it should point to a store containing a list of trusted certificates.
  * 
  * The store can either be loaded by Vert.x from the filesystem:
  * 
  * <pre>
  * HttpServerOptions options = HttpServerOptions.httpServerOptions();
  * options.setKeyStore(new JKSOptions().setPath("/mykeystore.jks").setPassword("foo"));
  * </pre>
  *
  * Or directly provided as a buffer:
  * 
  *
  * <pre>
  * Buffer store = vertx.fileSystem().readFileSync("/mykeystore.jks");
  * options.setKeyStore(new JKSOptions().setValue(store).setPassword("foo"));
  * </pre>
  */

  implicit class JksOptionsScala(val asJava: JJksOptions) extends AnyVal {


  /**
    * Set the password for the key store
    */
    def setPassword(value: String) = {
      asJava.setPassword(value)
    }
    def getPassword: String = {
      asJava.getPassword()
    }

  /**
    * Set the path to the key store
    */
    def setPath(value: String) = {
      asJava.setPath(value)
    }
    def getPath: String = {
      asJava.getPath()
    }

  /**
    * Set the key store as a buffer
    */
    def setValue(value: io.vertx.core.buffer.Buffer) = {
      asJava.setValue(value)
    }
    def getValue: io.vertx.core.buffer.Buffer = {
      asJava.getValue()
    }
  }
  
  type JksOptions = JJksOptions
  object JksOptions {
    def apply(): JJksOptions = new JksOptions()
    def apply(json: JsonObject) = new JJksOptions(json)
  }


import io.vertx.core.json.JsonArray
import io.vertx.core.parsetools.{JsonEvent => JJsonEvent}
import io.vertx.core.parsetools.JsonEventType
import io.vertx.core.buffer.Buffer
import io.vertx.core.json.JsonObject

/**
  * A JSON event emited by the [[io.vertx.core.parsetools.JsonParser]].
  */
implicit class JsonEventScala(val asJava: JJsonEvent) extends AnyVal {


  /**
    * @return the type of the event
    */
  def `type`(): io.vertx.core.parsetools.JsonEventType = {
    asJava.`type`()
  }

  /**
    * @return the name of the field when the event is emitted as a JSON object member
    */
  def fieldName(): String = {
    asJava.fieldName()
  }

  /**
    * @return the json value for JsonEventType#VALUE events
    */
  def value(): AnyRef = {
    asJava.value()
  }

  /**
    * @return true when the JSON value is a number
    */
  def isNumber(): java.lang.Boolean = {
    asJava.isNumber()
  }

  /**
    * @return the `Integer` value or `null` if the event has no JSON value
    */
  def integerValue(): java.lang.Integer = {
    asJava.integerValue()
  }

  /**
    * @return the `Long` value or `null` if the event has no JSON value
    */
  def longValue(): java.lang.Long = {
    asJava.longValue()
  }

  /**
    * @return the `Float` value or `null` if the event has no JSON value
    */
  def floatValue(): java.lang.Float = {
    asJava.floatValue()
  }

  /**
    * @return the `Double` value or `null` if the event has no JSON value
    */
  def doubleValue(): java.lang.Double = {
    asJava.doubleValue()
  }

  /**
    * @return true when the JSON value is a boolean
    */
  def isBoolean(): java.lang.Boolean = {
    asJava.isBoolean()
  }

  /**
    * @return the `Boolean` value or `null` if the event has no JSON value
    */
  def booleanValue(): java.lang.Boolean = {
    asJava.booleanValue()
  }

  /**
    * @return true when the JSON value is a string
    */
  def isString(): java.lang.Boolean = {
    asJava.isString()
  }

  /**
    * @return the string value or `null` if the event has no JSON value
    */
  def stringValue(): String = {
    asJava.stringValue()
  }

  /**
    * Return the binary value.
    * 
    * JSON itself has no notion of a binary, this extension complies to the RFC-7493, so this method assumes there is a
    * String value with the key and it contains a Base64 encoded binary, which it decodes if found and returns.
    * @return the binary value or `null` if the event has no JSON value
    */
  def binaryValue(): io.vertx.core.buffer.Buffer = {
    asJava.binaryValue()
  }

  /**
    * @return true when the JSON value is null
    */
  def isNull(): java.lang.Boolean = {
    asJava.isNull()
  }

  /**
    * @return true when the JSON value is a JSON object
    */
  def isObject(): java.lang.Boolean = {
    asJava.isObject()
  }

  /**
    * @return the JSON object value or `null` if the event has no JSON value
    */
  def objectValue(): io.vertx.core.json.JsonObject = {
    asJava.objectValue()
  }

  /**
    * @return true when the JSON value is a JSON array
    */
  def isArray(): java.lang.Boolean = {
    asJava.isArray()
  }

  /**
    * @return the JSON array value or `null` if the event has no JSON value
    */
  def arrayValue(): io.vertx.core.json.JsonArray = {
    asJava.arrayValue()
  }

  /**
    * Decodes and returns the current value as the specified `type`.
    * @param type the type to decode the value to
    * @return the decoded value
    */
  def mapTo[T](`type`: Class[T]): T = {
    asJava.mapTo[T](`type`)
  }

}

import io.vertx.core.parsetools.{JsonEvent => JJsonEvent}
import io.vertx.core.buffer.Buffer
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.core.streams.ReadStream
import io.vertx.core.parsetools.JsonParser
import io.vertx.core.parsetools.{JsonParser => JJsonParser}
import io.vertx.core.Handler
import io.vertx.core.parsetools.JsonEvent

/**
  * A parser class which allows to incrementally parse json elements and emit json parse events instead of parsing a json
  * element fully. This parser is convenient for parsing large json structures.
  * <p/>
  * The parser also parses concatenated json streams or line delimited json streams.
  * <p/>
  * The parser can also parse entire object or array when it is convenient, for instance a very large array
  * of small objects can be parsed efficiently by handling array <i>start</i>/<i>end</i> and <i>object</i>
  * events.
  * <p/>
  * Whenever the parser fails to parse or process the stream, the [[io.vertx.core.parsetools.JsonParser#exceptionHandler]] is called with
  * the cause of the failure and the current handling stops. After such event, the parser should not handle data
  * anymore.
  */
implicit class JsonParserScala(val asJava: JJsonParser) extends AnyVal {


  /**
    * Handle a `Buffer`, pretty much like calling [[io.vertx.core.Handler#handle]].
    * @return a reference to this, so the API can be used fluently
    */
  def write(buffer: io.vertx.core.buffer.Buffer): JJsonParser = {
    asJava.write(buffer)
  }

  /**
    * Flip the parser to emit a stream of events for each new json object.
    * @return a reference to this, so the API can be used fluently
    */
  def objectEventMode(): JJsonParser = {
    asJava.objectEventMode()
  }

  /**
    * Flip the parser to emit a single value event for each new json object.
    * </p>
    * Json object currently streamed won't be affected.
    * @return a reference to this, so the API can be used fluently
    */
  def objectValueMode(): JJsonParser = {
    asJava.objectValueMode()
  }

  /**
    * Flip the parser to emit a stream of events for each new json array.
    * @return a reference to this, so the API can be used fluently
    */
  def arrayEventMode(): JJsonParser = {
    asJava.arrayEventMode()
  }

  /**
    * Flip the parser to emit a single value event for each new json array.
    * </p>
    * Json array currently streamed won't be affected.
    * @return a reference to this, so the API can be used fluently
    */
  def arrayValueMode(): JJsonParser = {
    asJava.arrayValueMode()
  }

  def pause(): JJsonParser = {
    asJava.pause()
  }

  def resume(): JJsonParser = {
    asJava.resume()
  }

  def endHandler(endHandler: scala.Option[Void => Unit]): JJsonParser = {
    asJava.endHandler(endHandler match {case Some(t) => (p:Void) => t(p); case None => null})
  }

  def handler(handler: scala.Option[JJsonEvent => Unit]): JJsonParser = {
    asJava.handler(handler match {case Some(t) => (p:JJsonEvent) => t(p); case None => null})
  }

  def exceptionHandler(handler: scala.Option[Throwable => Unit]): JJsonParser = {
    asJava.exceptionHandler(handler match {case Some(t) => (p:Throwable) => t(p); case None => null})
  }

  /**
    * Something has happened, so handle it.
    * @param event the event to handle
    */
  def handle(event: io.vertx.core.buffer.Buffer): Unit = {
    asJava.handle(event)
  }

  /**
    * End the stream, this must be called after all the json stream has been processed.
    */
  def end(): Unit = {
    asJava.end()
  }

}

import io.vertx.core.shareddata.{LocalMap => JLocalMap}
import scala.collection.JavaConverters._

/**
  * Local maps can be used to share data safely in a single Vert.x instance.
  * 
  * The map only allows immutable keys and values in the map, OR certain mutable objects such as [[io.vertx.core.buffer.Buffer]]
  * instances which will be copied when they are added to the map.
  * 
  * This ensures there is no shared access to mutable state from different threads (e.g. different event loops) in the
  * Vert.x instance, and means you don't have to protect access to that state using synchronization or locks.
  * 
  * Your own objects can be marked as immutable by implementing the [[io.vertx.core.shareddata.Shareable]] interface.
  *
  * Since the version 3.4, this class extends the  interface. However some methods are only accessible in Java.
  */
implicit class LocalMapScala[K, V](val asJava: JLocalMap[K, V]) extends AnyVal {


  /**
    * Get a value from the map
    * @param key the key
    * @return the value, or null if none
    */
  def get(key: AnyRef): V = {
    asJava.get(key)
  }

  /**
    * Put an entry in the map
    * @param key the key
    * @param value the value
    * @return return the old value, or null if none
    */
  def put(key: K, value: V): V = {
    asJava.put(key, value)
  }

  /**
    * Remove an entry from the map
    * @param key the key
    * @return the old value
    */
  def remove(key: AnyRef): V = {
    asJava.remove(key)
  }

  /**
    * Clear all entries in the map
    */
  def clear(): Unit = {
    asJava.clear()
  }

  /**
    * Get the size of the map
    * @return the number of entries in the map
    */
  def size(): java.lang.Integer = {
    asJava.size()
  }

  /**
    * @return true if there are zero entries in the map
    */
  def isEmpty(): java.lang.Boolean = {
    asJava.isEmpty()
  }

  /**
    * Put the entry only if there is no existing entry for that key
    * @param key the key
    * @param value the value
    * @return the old value or null, if none
    */
  def putIfAbsent(key: K, value: V): V = {
    asJava.putIfAbsent(key, value)
  }

  /**
    * Remove the entry only if there is an entry with the specified key and value.
    * 
    * This method is the poyglot version of [[io.vertx.core.shareddata.LocalMap#remove]].
    * @param key the key
    * @param value the value
    * @return true if removed
    */
  def removeIfPresent(key: K, value: V): java.lang.Boolean = {
    asJava.removeIfPresent(key, value)
  }

  /**
    * Replace the entry only if there is an existing entry with the specified key and value.
    * 
    * This method is the polyglot version of [[io.vertx.core.shareddata.LocalMap#replace]].
    * @param key the key
    * @param oldValue the old value
    * @param newValue the new value
    * @return true if removed
    */
  def replaceIfPresent(key: K, oldValue: V, newValue: V): java.lang.Boolean = {
    asJava.replaceIfPresent(key, oldValue, newValue)
  }

  /**
    * Replace the entry only if there is an existing entry with the key
    * @param key the key
    * @param value the new value
    * @return the old value
    */
  def replace(key: K, value: V): V = {
    asJava.replace(key, value)
  }

  /**
    * Close and release the map
    */
  def close(): Unit = {
    asJava.close()
  }

  /**
    * Returns `true` if this map contains a mapping for the specified
    * key.
    * @param key key whose presence in this map is to be tested
    * @return `true` if this map contains a mapping for the specified key
    */
  def containsKey(key: AnyRef): java.lang.Boolean = {
    asJava.containsKey(key)
  }

  /**
    * Returns @{code true` if this map maps one or more keys to the
    * specified value.
    * @param value value whose presence in this map is to be tested
    * @return @{code true` if this map maps one or more keys to the specified value
    */
  def containsValue(value: AnyRef): java.lang.Boolean = {
    asJava.containsValue(value)
  }

  /**
    * Returns the value to which the specified key is mapped, or
    * `defaultValue` if this map contains no mapping for the key.
    * @param key the key whose associated value is to be returned
    * @param defaultValue the default mapping of the key
    * @return the value to which the specified key is mapped, or `defaultValue` if this map contains no mapping for the key
    */
  def getOrDefault(key: AnyRef, defaultValue: V): V = {
    asJava.getOrDefault(key, defaultValue)
  }

}

import io.vertx.core.shareddata.{Lock => JLock}

/**
  * An asynchronous exclusive lock which can be obtained from any node in the cluster.
  * 
  * When the lock is obtained, no-one else in the cluster can obtain the lock with the same name until the lock
  * is released.
  */
implicit class LockScala(val asJava: JLock) extends AnyVal {


  /**
    * Release the lock. Once the lock is released another will be able to obtain the lock.
    */
  def release(): Unit = {
    asJava.release()
  }

}

import io.vertx.core.metrics.{Measured => JMeasured}

/**
  */
implicit class MeasuredScala(val asJava: JMeasured) extends AnyVal {


  /**
    * Whether the metrics are enabled for this measured object
    * @return true if the metrics are enabled
    */
  def isMetricsEnabled(): java.lang.Boolean = {
    asJava.isMetricsEnabled()
  }

}

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.eventbus.DeliveryOptions
import io.vertx.core.eventbus.{Message => JMessage}
import io.vertx.core.eventbus.{DeliveryOptions => JDeliveryOptions}
import io.vertx.core.MultiMap
import io.vertx.core.eventbus.Message
import io.vertx.core.{MultiMap => JMultiMap}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler

/**
  * Represents a message that is received from the event bus in a handler.
  * 
  * Messages have a [[io.vertx.core.eventbus.Message#body]], which can be null, and also [[io.vertx.core.eventbus.Message#headers]], which can be empty.
  * 
  * If the message was sent specifying a reply handler it will also have a [[io.vertx.core.eventbus.Message#replyAddress]]. In that case the message
  * can be replied to using that reply address, or, more simply by just using [[io.vertx.core.eventbus.Message#reply]].
  * 
  * If you want to notify the sender that processing failed, then [[io.vertx.core.eventbus.Message#fail]] can be called.
  */
implicit class MessageScala[T](val asJava: JMessage[T]) extends AnyVal {


  /**
    * The address the message was sent to
    */
  def address(): String = {
    asJava.address()
  }

  /**
    * Multi-map of message headers. Can be empty
    * @return the headers
    */
  def headers(): JMultiMap = {
    asJava.headers()
  }

  /**
    * The reply address. Can be null.
    * @return the reply address, or null, if message was sent without a reply handler.
    */
  def replyAddress(): scala.Option[String] = {
    scala.Option(asJava.replyAddress())
  }

  /**
    * Signals if this message represents a send or publish event.
    * @return true if this is a send.
    */
  def isSend(): java.lang.Boolean = {
    asJava.isSend()
  }

  /**
    * Reply to this message.
    * 
    * If the message was sent specifying a reply handler, that handler will be
    * called when it has received a reply. If the message wasn't sent specifying a receipt handler
    * this method does nothing.
    * @param message the message to reply with.
    */
  def reply(message: AnyRef): Unit = {
    asJava.reply(message)
  }

  /**
    * The same as `reply(R message)` but you can specify handler for the reply - i.e.
    * to receive the reply to the reply.
    * @param message the message to reply with.
    * @param replyHandler the reply handler for the reply.
    */
  def reply[R](message: AnyRef, replyHandler: AsyncResult[JMessage[R]] => Unit): Unit = {
    asJava.reply[R](message, (p:AsyncResult[JMessage[R]]) => replyHandler(p))
  }

  /**
    * Link [[io.vertx.core.eventbus.Message#reply]] but allows you to specify delivery options for the reply.
    * @param message the reply message
    * @param options the delivery optionssee <a href="../../../../../../../cheatsheet/DeliveryOptions.html">DeliveryOptions</a>
    */
  def reply(message: AnyRef, options: JDeliveryOptions): Unit = {
    asJava.reply(message, options.asJava)
  }

  /**
    * The same as `reply(R message, DeliveryOptions)` but you can specify handler for the reply - i.e.
    * to receive the reply to the reply.
    * @param message the reply message
    * @param options the delivery optionssee <a href="../../../../../../../cheatsheet/DeliveryOptions.html">DeliveryOptions</a>
    * @param replyHandler the reply handler for the reply.
    */
  def reply[R](message: AnyRef, options: JDeliveryOptions, replyHandler: AsyncResult[JMessage[R]] => Unit): Unit = {
    asJava.reply[R](message, options.asJava, (p:AsyncResult[JMessage[R]]) => replyHandler(p))
  }

  /**
    * Signal to the sender that processing of this message failed.
    * 
    * If the message was sent specifying a result handler
    * the handler will be called with a failure corresponding to the failure code and message specified here.
    * @param failureCode A failure code to pass back to the sender
    * @param message A message to pass back to the sender
    */
  def fail(failureCode: java.lang.Integer, message: String): Unit = {
    asJava.fail(failureCode, message)
  }

  /**
    * The body of the message. Can be null.
    * @return the body, or null.
    */
  def body(): T = {
    asJava.body()
  }

 /**
   * Like [[reply]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def replyFuture[R](message: AnyRef): scala.concurrent.Future[JMessage[R]] = {
    val promise = Promise[JMessage[R]]()
    asJava.reply[R](message, {a:AsyncResult[io.vertx.core.eventbus.Message[R]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[reply]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def replyFuture[R](message: AnyRef, options: JDeliveryOptions): scala.concurrent.Future[JMessage[R]] = {
    val promise = Promise[JMessage[R]]()
    asJava.reply[R](message, options, {a:AsyncResult[io.vertx.core.eventbus.Message[R]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

}

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.core.eventbus.{Message => JMessage}
import io.vertx.core.streams.ReadStream
import io.vertx.core.eventbus.Message
import io.vertx.core.AsyncResult
import io.vertx.core.eventbus.MessageConsumer
import io.vertx.core.Handler
import io.vertx.core.eventbus.{MessageConsumer => JMessageConsumer}

/**
  * An event bus consumer object representing a stream of message to an [[io.vertx.core.eventbus.EventBus]] address that can
  * be read from.
  * 
  * The [[io.vertx.core.eventbus.EventBus#consumer]] or [[io.vertx.core.eventbus.EventBus#localConsumer]]
  * creates a new consumer, the returned consumer is not yet registered against the event bus. Registration
  * is effective after the [[io.vertx.core.eventbus.MessageConsumer#handler]] method is invoked.
  *
  * The consumer is unregistered from the event bus using the [[io.vertx.core.eventbus.MessageConsumer#unregister]] method or by calling the
  * [[io.vertx.core.eventbus.MessageConsumer#handler]] with a null value..
  */
implicit class MessageConsumerScala[T](val asJava: JMessageConsumer[T]) extends AnyVal {


  def exceptionHandler(handler: scala.Option[Throwable => Unit]): JMessageConsumer[T] = {
    asJava.exceptionHandler(handler match {case Some(t) => (p:Throwable) => t(p); case None => null})
  }

  def handler(handler: scala.Option[JMessage[T] => Unit]): JMessageConsumer[T] = {
    asJava.handler(handler match {case Some(t) => (p:JMessage[T]) => t(p); case None => null})
  }

  def pause(): JMessageConsumer[T] = {
    asJava.pause()
  }

  def resume(): JMessageConsumer[T] = {
    asJava.resume()
  }

  def endHandler(endHandler: scala.Option[Void => Unit]): JMessageConsumer[T] = {
    asJava.endHandler(endHandler match {case Some(t) => (p:Void) => t(p); case None => null})
  }

  /**
    * @return a read stream for the body of the message stream.
    */
  def bodyStream(): JReadStream[T] = {
    asJava.bodyStream()
  }

  /**
    * @return true if the current consumer is registered
    */
  def isRegistered(): java.lang.Boolean = {
    asJava.isRegistered()
  }

  /**
    * @return The address the handler was registered with.
    */
  def address(): String = {
    asJava.address()
  }

  /**
    * Set the number of messages this registration will buffer when this stream is paused. The default
    * value is <code>1000</code>. When a new value is set, buffered messages may be discarded to reach
    * the new value.
    * @param maxBufferedMessages the maximum number of messages that can be buffered
    * @return this registration
    */
  def setMaxBufferedMessages(maxBufferedMessages: java.lang.Integer): JMessageConsumer[T] = {
    asJava.setMaxBufferedMessages(maxBufferedMessages)
  }

  /**
    * @return the maximum number of messages that can be buffered when this stream is paused
    */
  def getMaxBufferedMessages(): java.lang.Integer = {
    asJava.getMaxBufferedMessages()
  }

  /**
    * Optional method which can be called to indicate when the registration has been propagated across the cluster.
    * @param completionHandler the completion handler
    */
  def completionHandler(completionHandler: AsyncResult[Void] => Unit): Unit = {
    asJava.completionHandler((p:AsyncResult[Void]) => completionHandler(p))
  }

  /**
    * Unregisters the handler which created this registration
    */
  def unregister(): Unit = {
    asJava.unregister()
  }

  /**
    * Unregisters the handler which created this registration
    * @param completionHandler the handler called when the unregister is done. For example in a cluster when all nodes of the event bus have been unregistered.
    */
  def unregister(completionHandler: AsyncResult[Void] => Unit): Unit = {
    asJava.unregister((p:AsyncResult[Void]) => completionHandler(p))
  }

 /**
   * Like [[completionHandler]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def completionFuture(): scala.concurrent.Future[Unit] = {
    val promise = Promise[Unit]()
    asJava.completionHandler({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[unregister]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def unregisterFuture(): scala.concurrent.Future[Unit] = {
    val promise = Promise[Unit]()
    asJava.unregister({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

}

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.eventbus.DeliveryOptions
import io.vertx.core.eventbus.{MessageProducer => JMessageProducer}
import io.vertx.core.eventbus.{DeliveryOptions => JDeliveryOptions}
import io.vertx.core.eventbus.{Message => JMessage}
import io.vertx.core.streams.WriteStream
import io.vertx.core.eventbus.Message
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.core.streams.{WriteStream => JWriteStream}
import io.vertx.core.eventbus.MessageProducer

/**
  * Represents a stream of message that can be written to.
  * 
  */
implicit class MessageProducerScala[T](val asJava: JMessageProducer[T]) extends AnyVal {


  def exceptionHandler(handler: scala.Option[Throwable => Unit]): JMessageProducer[T] = {
    asJava.exceptionHandler(handler match {case Some(t) => (p:Throwable) => t(p); case None => null})
  }

  def write(data: T): JMessageProducer[T] = {
    asJava.write(data)
  }

  def setWriteQueueMaxSize(maxSize: java.lang.Integer): JMessageProducer[T] = {
    asJava.setWriteQueueMaxSize(maxSize)
  }

  def drainHandler(handler: scala.Option[Void => Unit]): JMessageProducer[T] = {
    asJava.drainHandler(handler match {case Some(t) => (p:Void) => t(p); case None => null})
  }

  /**
    * Update the delivery options of this producer.
    * @param options the new optionssee <a href="../../../../../../../cheatsheet/DeliveryOptions.html">DeliveryOptions</a>
    * @return this producer object
    */
  def deliveryOptions(options: JDeliveryOptions): JMessageProducer[T] = {
    asJava.deliveryOptions(options.asJava)
  }

  /**
    * Same as [[io.vertx.core.eventbus.MessageProducer#end]] but writes some data to the stream before ending.
    */
  def end(t: T): Unit = {
    asJava.end(t)
  }

  /**
    * This will return `true` if there are more bytes in the write queue than the value set using [[io.vertx.core.eventbus.MessageProducer#setWriteQueueMaxSize]]
    * @return true if write queue is full
    */
  def writeQueueFull(): java.lang.Boolean = {
    asJava.writeQueueFull()
  }

  /**
    * Synonym for [[io.vertx.core.eventbus.MessageProducer#write]].
    * @param message the message to send
    * @return reference to this for fluency
    */
  def send(message: T): JMessageProducer[T] = {
    asJava.send(message)
  }

  def send[R](message: T, replyHandler: AsyncResult[JMessage[R]] => Unit): JMessageProducer[T] = {
    asJava.send[R](message, (p:AsyncResult[JMessage[R]]) => replyHandler(p))
  }

  /**
    * @return The address to which the producer produces messages.
    */
  def address(): String = {
    asJava.address()
  }

  /**
    * Closes the producer, calls [[io.vertx.core.eventbus.MessageProducer#close]]
    */
  def end(): Unit = {
    asJava.end()
  }

  /**
    * Closes the producer, this method should be called when the message producer is not used anymore.
    */
  def close(): Unit = {
    asJava.close()
  }

  def sendFuture[R](message: T): scala.concurrent.Future[JMessage[R]] = {
    val promise = Promise[JMessage[R]]()
    asJava.send[R](message, {a:AsyncResult[io.vertx.core.eventbus.Message[R]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

}

import io.vertx.core.metrics.{MetricsOptions => JMetricsOptions}

/**
  * Vert.x metrics base configuration, this class can be extended by provider implementations to configure
  * those specific implementations.
  */

  implicit class MetricsOptionsScala(val asJava: JMetricsOptions) extends AnyVal {


  /**
    * Set whether metrics will be enabled on the Vert.x instance.
    */
    def setEnabled(value: java.lang.Boolean) = {
      asJava.setEnabled(value)
    }
    def isEnabled: java.lang.Boolean = {
      asJava.isEnabled()
    }
  }
  
  type MetricsOptions = JMetricsOptions
  object MetricsOptions {
    def apply(): JMetricsOptions = new MetricsOptions()
    def apply(json: JsonObject) = new JMetricsOptions(json)
  }


import io.vertx.core.MultiMap
import io.vertx.core.{MultiMap => JMultiMap}
import scala.collection.JavaConverters._

/**
  * This class represents a MultiMap of String keys to a List of String values.
  * 
  * It's useful in Vert.x to represent things in Vert.x like HTTP headers and HTTP parameters which allow
  * multiple values for keys.
  */
implicit class MultiMapScala(val asJava: JMultiMap) extends AnyVal {


  /**
    * Adds a new value with the specified name and value.
    * @param name The name
    * @param value The value being added
    * @return a reference to this, so the API can be used fluently
    */
  def add(name: String, value: String): JMultiMap = {
    asJava.add(name, value)
  }

  /**
    * Adds all the entries from another MultiMap to this one
    * @return a reference to this, so the API can be used fluently
    */
  def addAll(map: JMultiMap): JMultiMap = {
    asJava.addAll(map.asJava)
  }

  /**
    * Sets a value under the specified name.
    * 
    * If there is an existing header with the same name, it is removed.
    * @param name The name
    * @param value The value
    * @return a reference to this, so the API can be used fluently
    */
  def set(name: String, value: String): JMultiMap = {
    asJava.set(name, value)
  }

  /**
    * Cleans this instance.
    * @return a reference to this, so the API can be used fluently
    */
  def setAll(map: JMultiMap): JMultiMap = {
    asJava.setAll(map.asJava)
  }

  /**
    * Removes the value with the given name
    * @param name The name of the value to remove
    * @return a reference to this, so the API can be used fluently
    */
  def remove(name: String): JMultiMap = {
    asJava.remove(name)
  }

  /**
    * Removes all
    * @return a reference to this, so the API can be used fluently
    */
  def clear(): JMultiMap = {
    asJava.clear()
  }

  /**
    * Check if there is a header with the specified `name` and `value`.
    *
    * If `caseInsensitive` is `true`, `value` is compared in a case-insensitive way.
    * @param name the name to search for
    * @param value the value to search for
    * @return `true` if at least one entry is found
    */
  def contains(name: String, value: String, caseInsensitive: java.lang.Boolean): java.lang.Boolean = {
    asJava.contains(name, value, caseInsensitive)
  }

  /**
    * Returns the value of with the specified name.  If there are
    * more than one values for the specified name, the first value is returned.
    * @param name The name of the header to search
    * @return The first header value or `null` if there is no such entry
    */
  def get(name: String): scala.Option[String] = {
    scala.Option(asJava.get(name))
  }

  /**
    * Returns the values with the specified name
    * @param name The name to search
    * @return A immutable scala.collection.immutable.List of values which will be empty if no values are found
    */
  def getAll(name: String): List[String] = {
    asJava.getAll(name).asScala.toList
  }

  /**
    * Checks to see if there is a value with the specified name
    * @param name The name to search for
    * @return true if at least one entry is found
    */
  def contains(name: String): java.lang.Boolean = {
    asJava.contains(name)
  }

  /**
    * Return true if empty
    */
  def isEmpty(): java.lang.Boolean = {
    asJava.isEmpty()
  }

  /**
    * Gets a immutable Set of all names
    * @return A scala.collection.immutable.Set of all names
    */
  def names(): Set[String] = {
    asJava.names().asScala.toSet
  }

  /**
    * Return the number of keys.
    */
  def size(): java.lang.Integer = {
    asJava.size()
  }

}

import io.vertx.core.dns.{MxRecord => JMxRecord}

/**
  * Represent a Mail-Exchange-Record (MX) which was resolved for a domain.
  */
implicit class MxRecordScala(val asJava: JMxRecord) extends AnyVal {


  /**
    * The priority of the MX record.
    */
  def priority(): java.lang.Integer = {
    asJava.priority()
  }

  /**
    * The name of the MX record
    */
  def name(): String = {
    asJava.name()
  }

}

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.metrics.{Measured => JMeasured}
import io.vertx.core.net.{NetSocket => JNetSocket}
import io.vertx.core.net.{NetClient => JNetClient}
import io.vertx.core.metrics.Measured
import io.vertx.core.net.{SocketAddress => JSocketAddress}
import io.vertx.core.AsyncResult
import io.vertx.core.net.NetClient
import io.vertx.core.Handler
import io.vertx.core.net.NetSocket
import io.vertx.core.net.SocketAddress

/**
  * A TCP client.
  * 
  * Multiple connections to different servers can be made using the same instance.
  * 
  * This client supports a configurable number of connection attempts and a configurable
  * delay between attempts.
  */
implicit class NetClientScala(val asJava: JNetClient) extends AnyVal {


  /**
    * Open a connection to a server at the specific `port` and `host`.
    * 
    * `host` can be a valid host name or IP address. The connect is done asynchronously and on success, a
    * [[io.vertx.core.net.NetSocket]] instance is supplied via the `connectHandler` instance
    * @param port the port
    * @param host the host
    * @return a reference to this, so the API can be used fluently
    */
  def connect(port: java.lang.Integer, host: String, connectHandler: AsyncResult[JNetSocket] => Unit): JNetClient = {
    asJava.connect(port, host, (p:AsyncResult[JNetSocket]) => connectHandler(p))
  }

  /**
    * Open a connection to a server at the specific `port` and `host`.
    * 
    * `host` can be a valid host name or IP address. The connect is done asynchronously and on success, a
    * [[io.vertx.core.net.NetSocket]] instance is supplied via the `connectHandler` instance
    * @param port the port
    * @param host the host
    * @param serverName the SNI server name
    * @return a reference to this, so the API can be used fluently
    */
  def connect(port: java.lang.Integer, host: String, serverName: String, connectHandler: AsyncResult[JNetSocket] => Unit): JNetClient = {
    asJava.connect(port, host, serverName, (p:AsyncResult[JNetSocket]) => connectHandler(p))
  }

  /**
    * Open a connection to a server at the specific `remoteAddress`.
    * 
    * The connect is done asynchronously and on success, a [[io.vertx.core.net.NetSocket]] instance is supplied via the `connectHandler` instance
    * @param remoteAddress the remote address
    * @return a reference to this, so the API can be used fluently
    */
  def connect(remoteAddress: JSocketAddress, connectHandler: AsyncResult[JNetSocket] => Unit): JNetClient = {
    asJava.connect(remoteAddress.asJava, (p:AsyncResult[JNetSocket]) => connectHandler(p))
  }

  /**
    * Open a connection to a server at the specific `remoteAddress`.
    * 
    * The connect is done asynchronously and on success, a [[io.vertx.core.net.NetSocket]] instance is supplied via the `connectHandler` instance
    * @param remoteAddress the remote address
    * @param serverName the SNI server name
    * @return a reference to this, so the API can be used fluently
    */
  def connect(remoteAddress: JSocketAddress, serverName: String, connectHandler: AsyncResult[JNetSocket] => Unit): JNetClient = {
    asJava.connect(remoteAddress.asJava, serverName, (p:AsyncResult[JNetSocket]) => connectHandler(p))
  }

  /**
    * Whether the metrics are enabled for this measured object
    * @return true if the metrics are enabled
    */
  def isMetricsEnabled(): java.lang.Boolean = {
    asJava.isMetricsEnabled()
  }

  /**
    * Close the client.
    * 
    * Any sockets which have not been closed manually will be closed here. The close is asynchronous and may not
    * complete until some time after the method has returned.
    */
  def close(): Unit = {
    asJava.close()
  }

 /**
   * Like [[connect]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def connectFuture(port: java.lang.Integer, host: String): scala.concurrent.Future[JNetSocket] = {
    val promise = Promise[JNetSocket]()
    asJava.connect(port, host, {a:AsyncResult[io.vertx.core.net.NetSocket] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[connect]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def connectFuture(port: java.lang.Integer, host: String, serverName: String): scala.concurrent.Future[JNetSocket] = {
    val promise = Promise[JNetSocket]()
    asJava.connect(port, host, serverName, {a:AsyncResult[io.vertx.core.net.NetSocket] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[connect]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def connectFuture(remoteAddress: JSocketAddress): scala.concurrent.Future[JNetSocket] = {
    val promise = Promise[JNetSocket]()
    asJava.connect(remoteAddress, {a:AsyncResult[io.vertx.core.net.NetSocket] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[connect]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def connectFuture(remoteAddress: JSocketAddress, serverName: String): scala.concurrent.Future[JNetSocket] = {
    val promise = Promise[JNetSocket]()
    asJava.connect(remoteAddress, serverName, {a:AsyncResult[io.vertx.core.net.NetSocket] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

}

import io.vertx.core.net.ProxyOptions
import io.vertx.core.net.JksOptions
import io.vertx.core.net.{PfxOptions => JPfxOptions}
import io.vertx.core.net.PfxOptions
import io.vertx.core.net.OpenSSLEngineOptions
import io.vertx.core.buffer.Buffer
import io.vertx.core.net.{OpenSSLEngineOptions => JOpenSSLEngineOptions}
import io.vertx.core.net.PemKeyCertOptions
import io.vertx.core.net.{NetClientOptions => JNetClientOptions}
import io.vertx.core.net.{JdkSSLEngineOptions => JJdkSSLEngineOptions}
import io.vertx.core.net.{PemTrustOptions => JPemTrustOptions}
import io.vertx.core.net.{PemKeyCertOptions => JPemKeyCertOptions}
import io.vertx.core.net.PemTrustOptions
import io.vertx.core.net.{ProxyOptions => JProxyOptions}
import io.vertx.core.net.JdkSSLEngineOptions
import io.vertx.core.net.{JksOptions => JJksOptions}

/**
  * Options for configuring a [[io.vertx.core.net.NetClient]].
  */

  implicit class NetClientOptionsScala(val asJava: JNetClientOptions) extends AnyVal {


  /**
    * Set the connect timeout
    */
    def setConnectTimeout(value: java.lang.Integer) = {
      asJava.setConnectTimeout(value)
    }
    def getConnectTimeout: java.lang.Integer = {
      asJava.getConnectTimeout()
    }

  /**
    * Add a CRL path
    */
    def addCrlPath(value: String) = {
      asJava.addCrlPath(value)
      }
    def getCrlPaths: scala.collection.mutable.Buffer[String] = {
      asJava.getCrlPaths().asScala
    }

  /**
    * Add a CRL value
    */
    def addCrlValue(value: io.vertx.core.buffer.Buffer) = {
      asJava.addCrlValue(value)
      }
    def getCrlValues: scala.collection.mutable.Buffer[io.vertx.core.buffer.Buffer] = {
      asJava.getCrlValues().asScala
    }

  /**
    * Add an enabled cipher suite, appended to the ordered suites.
    */
    def addEnabledCipherSuite(value: String) = {
      asJava.addEnabledCipherSuite(value)
      }
    def getEnabledCipherSuites: scala.collection.mutable.Set[String] = {
      asJava.getEnabledCipherSuites().asScala
    }

  /**
    * Sets the list of enabled SSL/TLS protocols.
    */
    def addEnabledSecureTransportProtocol(value: String) = {
      asJava.addEnabledSecureTransportProtocol(value)
      }
    def setEnabledSecureTransportProtocols(value: Set[String]) = {
      asJava.setEnabledSecureTransportProtocols(value.asJava)
    }
    def getEnabledSecureTransportProtocols: scala.collection.mutable.Set[String] = {
      asJava.getEnabledSecureTransportProtocols().asScala
    }

  /**
    * Set the hostname verification algorithm interval
    * To disable hostname verification, set hostnameVerificationAlgorithm to an empty String
    */
    def setHostnameVerificationAlgorithm(value: String) = {
      asJava.setHostnameVerificationAlgorithm(value)
    }
    def getHostnameVerificationAlgorithm: String = {
      asJava.getHostnameVerificationAlgorithm()
    }

  /**
    * Set the idle timeout, in seconds. zero means don't timeout.
    * This determines if a connection will timeout and be closed if no data is received within the timeout.
    */
    def setIdleTimeout(value: java.lang.Integer) = {
      asJava.setIdleTimeout(value)
    }
    def getIdleTimeout: java.lang.Integer = {
      asJava.getIdleTimeout()
    }
    def setJdkSslEngineOptions(value: JJdkSSLEngineOptions) = {
      asJava.setJdkSslEngineOptions(value.asJava)
    }
    def getJdkSslEngineOptions: JJdkSSLEngineOptions = {
      asJava.getJdkSslEngineOptions()
    }

  /**
    * Set the key/cert options in jks format, aka Java keystore.
    */
    def setKeyStoreOptions(value: JJksOptions) = {
      asJava.setKeyStoreOptions(value.asJava)
    }
    def getKeyStoreOptions: JJksOptions = {
      asJava.getKeyStoreOptions()
    }

  /**
    * Set the local interface to bind for network connections. When the local address is null,
    * it will pick any local address, the default local address is null.
    */
    def setLocalAddress(value: String) = {
      asJava.setLocalAddress(value)
    }
    def getLocalAddress: String = {
      asJava.getLocalAddress()
    }

  /**
    * Set to true to enabled network activity logging: Netty's pipeline is configured for logging on Netty's logger.
    */
    def setLogActivity(value: java.lang.Boolean) = {
      asJava.setLogActivity(value)
    }
    def getLogActivity: java.lang.Boolean = {
      asJava.getLogActivity()
    }

  /**
    * Set the metrics name identifying the reported metrics, useful for grouping metrics
    * with the same name.
    */
    def setMetricsName(value: String) = {
      asJava.setMetricsName(value)
    }
    def getMetricsName: String = {
      asJava.getMetricsName()
    }
    def setOpenSslEngineOptions(value: JOpenSSLEngineOptions) = {
      asJava.setOpenSslEngineOptions(value.asJava)
    }
    def getOpenSslEngineOptions: JOpenSSLEngineOptions = {
      asJava.getOpenSslEngineOptions()
    }

  /**
    * Set the key/cert store options in pem format.
    */
    def setPemKeyCertOptions(value: JPemKeyCertOptions) = {
      asJava.setPemKeyCertOptions(value.asJava)
    }
    def getPemKeyCertOptions: JPemKeyCertOptions = {
      asJava.getPemKeyCertOptions()
    }

  /**
    * Set the trust options in pem format
    */
    def setPemTrustOptions(value: JPemTrustOptions) = {
      asJava.setPemTrustOptions(value.asJava)
    }
    def getPemTrustOptions: JPemTrustOptions = {
      asJava.getPemTrustOptions()
    }

  /**
    * Set the key/cert options in pfx format.
    */
    def setPfxKeyCertOptions(value: JPfxOptions) = {
      asJava.setPfxKeyCertOptions(value.asJava)
    }
    def getPfxKeyCertOptions: JPfxOptions = {
      asJava.getPfxKeyCertOptions()
    }

  /**
    * Set the trust options in pfx format
    */
    def setPfxTrustOptions(value: JPfxOptions) = {
      asJava.setPfxTrustOptions(value.asJava)
    }
    def getPfxTrustOptions: JPfxOptions = {
      asJava.getPfxTrustOptions()
    }

  /**
    * Set proxy options for connections via CONNECT proxy (e.g. Squid) or a SOCKS proxy.
    */
    def setProxyOptions(value: JProxyOptions) = {
      asJava.setProxyOptions(value.asJava)
    }
    def getProxyOptions: JProxyOptions = {
      asJava.getProxyOptions()
    }

  /**
    * Set the TCP receive buffer size
    */
    def setReceiveBufferSize(value: java.lang.Integer) = {
      asJava.setReceiveBufferSize(value)
    }
    def getReceiveBufferSize: java.lang.Integer = {
      asJava.getReceiveBufferSize()
    }

  /**
    * Set the value of reconnect attempts
    */
    def setReconnectAttempts(value: java.lang.Integer) = {
      asJava.setReconnectAttempts(value)
    }
    def getReconnectAttempts: java.lang.Integer = {
      asJava.getReconnectAttempts()
    }

  /**
    * Set the reconnect interval
    */
    def setReconnectInterval(value: java.lang.Long) = {
      asJava.setReconnectInterval(value)
    }
    def getReconnectInterval: java.lang.Long = {
      asJava.getReconnectInterval()
    }

  /**
    * Set the value of reuse address
    */
    def setReuseAddress(value: java.lang.Boolean) = {
      asJava.setReuseAddress(value)
    }
    def isReuseAddress: java.lang.Boolean = {
      asJava.isReuseAddress()
    }

  /**
    * Set the value of reuse port.
    * <p/>
    * This is only supported by native transports.
    */
    def setReusePort(value: java.lang.Boolean) = {
      asJava.setReusePort(value)
    }
    def isReusePort: java.lang.Boolean = {
      asJava.isReusePort()
    }

  /**
    * Set the TCP send buffer size
    */
    def setSendBufferSize(value: java.lang.Integer) = {
      asJava.setSendBufferSize(value)
    }
    def getSendBufferSize: java.lang.Integer = {
      asJava.getSendBufferSize()
    }

  /**
    * Set whether SO_linger keep alive is enabled
    */
    def setSoLinger(value: java.lang.Integer) = {
      asJava.setSoLinger(value)
    }
    def getSoLinger: java.lang.Integer = {
      asJava.getSoLinger()
    }

  /**
    * Set whether SSL/TLS is enabled
    */
    def setSsl(value: java.lang.Boolean) = {
      asJava.setSsl(value)
    }
    def isSsl: java.lang.Boolean = {
      asJava.isSsl()
    }

  /**
    * Enable the `TCP_CORK` option - only with linux native transport.
    */
    def setTcpCork(value: java.lang.Boolean) = {
      asJava.setTcpCork(value)
    }
    def isTcpCork: java.lang.Boolean = {
      asJava.isTcpCork()
    }

  /**
    * Enable the `TCP_FASTOPEN` option - only with linux native transport.
    */
    def setTcpFastOpen(value: java.lang.Boolean) = {
      asJava.setTcpFastOpen(value)
    }
    def isTcpFastOpen: java.lang.Boolean = {
      asJava.isTcpFastOpen()
    }

  /**
    * Set whether TCP keep alive is enabled
    */
    def setTcpKeepAlive(value: java.lang.Boolean) = {
      asJava.setTcpKeepAlive(value)
    }
    def isTcpKeepAlive: java.lang.Boolean = {
      asJava.isTcpKeepAlive()
    }

  /**
    * Set whether TCP no delay is enabled
    */
    def setTcpNoDelay(value: java.lang.Boolean) = {
      asJava.setTcpNoDelay(value)
    }
    def isTcpNoDelay: java.lang.Boolean = {
      asJava.isTcpNoDelay()
    }

  /**
    * Enable the `TCP_QUICKACK` option - only with linux native transport.
    */
    def setTcpQuickAck(value: java.lang.Boolean) = {
      asJava.setTcpQuickAck(value)
    }
    def isTcpQuickAck: java.lang.Boolean = {
      asJava.isTcpQuickAck()
    }

  /**
    * Set the value of traffic class
    */
    def setTrafficClass(value: java.lang.Integer) = {
      asJava.setTrafficClass(value)
    }
    def getTrafficClass: java.lang.Integer = {
      asJava.getTrafficClass()
    }

  /**
    * Set whether all server certificates should be trusted
    */
    def setTrustAll(value: java.lang.Boolean) = {
      asJava.setTrustAll(value)
    }
    def isTrustAll: java.lang.Boolean = {
      asJava.isTrustAll()
    }

  /**
    * Set the trust options in jks format, aka Java truststore
    */
    def setTrustStoreOptions(value: JJksOptions) = {
      asJava.setTrustStoreOptions(value.asJava)
    }
    def getTrustStoreOptions: JJksOptions = {
      asJava.getTrustStoreOptions()
    }

  /**
    * Set the ALPN usage.
    */
    def setUseAlpn(value: java.lang.Boolean) = {
      asJava.setUseAlpn(value)
    }
    def isUseAlpn: java.lang.Boolean = {
      asJava.isUseAlpn()
    }

  /**
    * Set whether Netty pooled buffers are enabled
    */
    def setUsePooledBuffers(value: java.lang.Boolean) = {
      asJava.setUsePooledBuffers(value)
    }
    def isUsePooledBuffers: java.lang.Boolean = {
      asJava.isUsePooledBuffers()
    }
  }
  
  type NetClientOptions = JNetClientOptions
  object NetClientOptions {
    def apply(): JNetClientOptions = new NetClientOptions()
    def apply(json: JsonObject) = new JNetClientOptions(json)
  }


import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.net.{NetServer => JNetServer}
import io.vertx.core.metrics.{Measured => JMeasured}
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.core.net.{NetSocket => JNetSocket}
import io.vertx.core.metrics.Measured
import io.vertx.core.net.NetServer
import io.vertx.core.streams.ReadStream
import io.vertx.core.net.{SocketAddress => JSocketAddress}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.core.net.NetSocket
import io.vertx.core.net.SocketAddress

/**
  * Represents a TCP server
  */
implicit class NetServerScala(val asJava: JNetServer) extends AnyVal {


  /**
    * Start listening on the port and host as configured in the <a href="../../../../../../../cheatsheet/NetServerOptions.html">NetServerOptions</a> used when
    * creating the server.
    * 
    * The server may not be listening until some time after the call to listen has returned.
    * @return a reference to this, so the API can be used fluently
    */
  def listen(): JNetServer = {
    asJava.listen()
  }

  /**
    * Like [[io.vertx.core.net.NetServer#listen]] but providing a handler that will be notified when the server is listening, or fails.
    * @param listenHandler handler that will be notified when listening or failed
    * @return a reference to this, so the API can be used fluently
    */
  def listen(listenHandler: AsyncResult[JNetServer] => Unit): JNetServer = {
    asJava.listen((p:AsyncResult[JNetServer]) => listenHandler(p))
  }

  /**
    * Start listening on the specified port and host, ignoring port and host configured in the <a href="../../../../../../../cheatsheet/NetServerOptions.html">NetServerOptions</a> used when
    * creating the server.
    * 
    * Port `0` can be specified meaning "choose an random port".
    * 
    * Host `0.0.0.0` can be specified meaning "listen on all available interfaces".
    * 
    * The server may not be listening until some time after the call to listen has returned.
    * @return a reference to this, so the API can be used fluently
    */
  def listen(port: java.lang.Integer, host: String): JNetServer = {
    asJava.listen(port, host)
  }

  /**
    * Like [[io.vertx.core.net.NetServer#listen]] but providing a handler that will be notified when the server is listening, or fails.
    * @param port the port to listen on
    * @param host the host to listen on
    * @param listenHandler handler that will be notified when listening or failed
    * @return a reference to this, so the API can be used fluently
    */
  def listen(port: java.lang.Integer, host: String, listenHandler: AsyncResult[JNetServer] => Unit): JNetServer = {
    asJava.listen(port, host, (p:AsyncResult[JNetServer]) => listenHandler(p))
  }

  /**
    * Start listening on the specified port and host "0.0.0.0", ignoring port and host configured in the
    * <a href="../../../../../../../cheatsheet/NetServerOptions.html">NetServerOptions</a> used when creating the server.
    * 
    * Port `0` can be specified meaning "choose an random port".
    * 
    * The server may not be listening until some time after the call to listen has returned.
    * @return a reference to this, so the API can be used fluently
    */
  def listen(port: java.lang.Integer): JNetServer = {
    asJava.listen(port)
  }

  /**
    * Like [[io.vertx.core.net.NetServer#listen]] but providing a handler that will be notified when the server is listening, or fails.
    * @param port the port to listen on
    * @param listenHandler handler that will be notified when listening or failed
    * @return a reference to this, so the API can be used fluently
    */
  def listen(port: java.lang.Integer, listenHandler: AsyncResult[JNetServer] => Unit): JNetServer = {
    asJava.listen(port, (p:AsyncResult[JNetServer]) => listenHandler(p))
  }

  /**
    * Start listening on the specified local address, ignoring port and host configured in the <a href="../../../../../../../cheatsheet/NetServerOptions.html">NetServerOptions</a> used when
    * creating the server.
    * 
    * The server may not be listening until some time after the call to listen has returned.
    * @param localAddress the local address to listen on
    * @return a reference to this, so the API can be used fluently
    */
  def listen(localAddress: JSocketAddress): JNetServer = {
    asJava.listen(localAddress.asJava)
  }

  /**
    * Like [[io.vertx.core.net.NetServer#listen]] but providing a handler that will be notified when the server is listening, or fails.
    * @param localAddress the local address to listen on
    * @param listenHandler handler that will be notified when listening or failed
    * @return a reference to this, so the API can be used fluently
    */
  def listen(localAddress: JSocketAddress, listenHandler: AsyncResult[JNetServer] => Unit): JNetServer = {
    asJava.listen(localAddress.asJava, (p:AsyncResult[JNetServer]) => listenHandler(p))
  }

  /**
    * Set an exception handler called for socket errors happening before the connection
    * is passed to the [[io.vertx.core.net.NetServer#connectHandler]], e.g during the TLS handshake.
    * @param handler the handler to set
    * @return a reference to this, so the API can be used fluently
    */
  def exceptionHandler(handler: Throwable => Unit): JNetServer = {
    asJava.exceptionHandler((p:Throwable) => handler(p))
  }

  /**
    * Whether the metrics are enabled for this measured object
    * @return true if the metrics are enabled
    */
  def isMetricsEnabled(): java.lang.Boolean = {
    asJava.isMetricsEnabled()
  }

  /**
    * Return the connect stream for this server. The server can only have at most one handler at any one time.
    * As the server accepts TCP or SSL connections it creates an instance of [[io.vertx.core.net.NetSocket]] and passes it to the
    * connect stream .
    * @return the connect stream
    */
  def connectStream(): JReadStream[JNetSocket] = {
    asJava.connectStream()
  }

  /**
    * Supply a connect handler for this server. The server can only have at most one connect handler at any one time.
    * As the server accepts TCP or SSL connections it creates an instance of [[io.vertx.core.net.NetSocket]] and passes it to the
    * connect handler.
    * @return a reference to this, so the API can be used fluently
    */
  def connectHandler(handler: scala.Option[JNetSocket => Unit]): JNetServer = {
    asJava.connectHandler(handler match {case Some(t) => (p:JNetSocket) => t(p); case None => null})
  }

  /**
    * Close the server. This will close any currently open connections. The close may not complete until after this
    * method has returned.
    */
  def close(): Unit = {
    asJava.close()
  }

  /**
    * Like [[io.vertx.core.net.NetServer#close]] but supplying a handler that will be notified when close is complete.
    * @param completionHandler the handler
    */
  def close(completionHandler: AsyncResult[Void] => Unit): Unit = {
    asJava.close((p:AsyncResult[Void]) => completionHandler(p))
  }

  /**
    * The actual port the server is listening on. This is useful if you bound the server specifying 0 as port number
    * signifying an ephemeral port
    * @return the actual port the server is listening on.
    */
  def actualPort(): java.lang.Integer = {
    asJava.actualPort()
  }

 /**
   * Like [[listen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def listenFuture(): scala.concurrent.Future[JNetServer] = {
    val promise = Promise[JNetServer]()
    asJava.listen({a:AsyncResult[io.vertx.core.net.NetServer] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[listen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def listenFuture(port: java.lang.Integer, host: String): scala.concurrent.Future[JNetServer] = {
    val promise = Promise[JNetServer]()
    asJava.listen(port, host, {a:AsyncResult[io.vertx.core.net.NetServer] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[listen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def listenFuture(port: java.lang.Integer): scala.concurrent.Future[JNetServer] = {
    val promise = Promise[JNetServer]()
    asJava.listen(port, {a:AsyncResult[io.vertx.core.net.NetServer] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[listen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def listenFuture(localAddress: JSocketAddress): scala.concurrent.Future[JNetServer] = {
    val promise = Promise[JNetServer]()
    asJava.listen(localAddress, {a:AsyncResult[io.vertx.core.net.NetServer] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
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

import io.vertx.core.net.JksOptions
import io.vertx.core.net.{PfxOptions => JPfxOptions}
import io.vertx.core.net.{NetServerOptions => JNetServerOptions}
import io.vertx.core.net.PfxOptions
import io.vertx.core.net.OpenSSLEngineOptions
import io.vertx.core.buffer.Buffer
import io.vertx.core.net.{OpenSSLEngineOptions => JOpenSSLEngineOptions}
import io.vertx.core.net.PemKeyCertOptions
import io.vertx.core.http.ClientAuth
import io.vertx.core.net.{JdkSSLEngineOptions => JJdkSSLEngineOptions}
import io.vertx.core.net.{PemTrustOptions => JPemTrustOptions}
import io.vertx.core.net.{PemKeyCertOptions => JPemKeyCertOptions}
import io.vertx.core.net.PemTrustOptions
import io.vertx.core.net.JdkSSLEngineOptions
import io.vertx.core.net.{JksOptions => JJksOptions}

/**
  * Options for configuring a [[io.vertx.core.net.NetServer]].
  */

  implicit class NetServerOptionsScala(val asJava: JNetServerOptions) extends AnyVal {


  /**
    * Set the accept back log
    */
    def setAcceptBacklog(value: java.lang.Integer) = {
      asJava.setAcceptBacklog(value)
    }
    def getAcceptBacklog: java.lang.Integer = {
      asJava.getAcceptBacklog()
    }

  /**
    * Set whether client auth is required
    */
    def setClientAuth(value: io.vertx.core.http.ClientAuth) = {
      asJava.setClientAuth(value)
    }
    def getClientAuth: io.vertx.core.http.ClientAuth = {
      asJava.getClientAuth()
    }

  /**
    * Set whether client auth is required
    */
    def setClientAuthRequired(value: java.lang.Boolean) = {
      asJava.setClientAuthRequired(value)
    }
    def isClientAuthRequired: java.lang.Boolean = {
      asJava.isClientAuthRequired()
    }

  /**
    * Add a CRL path
    */
    def addCrlPath(value: String) = {
      asJava.addCrlPath(value)
      }
    def getCrlPaths: scala.collection.mutable.Buffer[String] = {
      asJava.getCrlPaths().asScala
    }

  /**
    * Add a CRL value
    */
    def addCrlValue(value: io.vertx.core.buffer.Buffer) = {
      asJava.addCrlValue(value)
      }
    def getCrlValues: scala.collection.mutable.Buffer[io.vertx.core.buffer.Buffer] = {
      asJava.getCrlValues().asScala
    }

  /**
    * Add an enabled cipher suite, appended to the ordered suites.
    */
    def addEnabledCipherSuite(value: String) = {
      asJava.addEnabledCipherSuite(value)
      }
    def getEnabledCipherSuites: scala.collection.mutable.Set[String] = {
      asJava.getEnabledCipherSuites().asScala
    }

  /**
    * Sets the list of enabled SSL/TLS protocols.
    */
    def addEnabledSecureTransportProtocol(value: String) = {
      asJava.addEnabledSecureTransportProtocol(value)
      }
    def setEnabledSecureTransportProtocols(value: Set[String]) = {
      asJava.setEnabledSecureTransportProtocols(value.asJava)
    }
    def getEnabledSecureTransportProtocols: scala.collection.mutable.Set[String] = {
      asJava.getEnabledSecureTransportProtocols().asScala
    }

  /**
    * Set the host
    */
    def setHost(value: String) = {
      asJava.setHost(value)
    }
    def getHost: String = {
      asJava.getHost()
    }

  /**
    * Set the idle timeout, in seconds. zero means don't timeout.
    * This determines if a connection will timeout and be closed if no data is received within the timeout.
    */
    def setIdleTimeout(value: java.lang.Integer) = {
      asJava.setIdleTimeout(value)
    }
    def getIdleTimeout: java.lang.Integer = {
      asJava.getIdleTimeout()
    }
    def setJdkSslEngineOptions(value: JJdkSSLEngineOptions) = {
      asJava.setJdkSslEngineOptions(value.asJava)
    }
    def getJdkSslEngineOptions: JJdkSSLEngineOptions = {
      asJava.getJdkSslEngineOptions()
    }

  /**
    * Set the key/cert options in jks format, aka Java keystore.
    */
    def setKeyStoreOptions(value: JJksOptions) = {
      asJava.setKeyStoreOptions(value.asJava)
    }
    def getKeyStoreOptions: JJksOptions = {
      asJava.getKeyStoreOptions()
    }

  /**
    * Set to true to enabled network activity logging: Netty's pipeline is configured for logging on Netty's logger.
    */
    def setLogActivity(value: java.lang.Boolean) = {
      asJava.setLogActivity(value)
    }
    def getLogActivity: java.lang.Boolean = {
      asJava.getLogActivity()
    }
    def setOpenSslEngineOptions(value: JOpenSSLEngineOptions) = {
      asJava.setOpenSslEngineOptions(value.asJava)
    }
    def getOpenSslEngineOptions: JOpenSSLEngineOptions = {
      asJava.getOpenSslEngineOptions()
    }

  /**
    * Set the key/cert store options in pem format.
    */
    def setPemKeyCertOptions(value: JPemKeyCertOptions) = {
      asJava.setPemKeyCertOptions(value.asJava)
    }
    def getPemKeyCertOptions: JPemKeyCertOptions = {
      asJava.getPemKeyCertOptions()
    }

  /**
    * Set the trust options in pem format
    */
    def setPemTrustOptions(value: JPemTrustOptions) = {
      asJava.setPemTrustOptions(value.asJava)
    }
    def getPemTrustOptions: JPemTrustOptions = {
      asJava.getPemTrustOptions()
    }

  /**
    * Set the key/cert options in pfx format.
    */
    def setPfxKeyCertOptions(value: JPfxOptions) = {
      asJava.setPfxKeyCertOptions(value.asJava)
    }
    def getPfxKeyCertOptions: JPfxOptions = {
      asJava.getPfxKeyCertOptions()
    }

  /**
    * Set the trust options in pfx format
    */
    def setPfxTrustOptions(value: JPfxOptions) = {
      asJava.setPfxTrustOptions(value.asJava)
    }
    def getPfxTrustOptions: JPfxOptions = {
      asJava.getPfxTrustOptions()
    }

  /**
    * Set the port
    */
    def setPort(value: java.lang.Integer) = {
      asJava.setPort(value)
    }
    def getPort: java.lang.Integer = {
      asJava.getPort()
    }

  /**
    * Set the TCP receive buffer size
    */
    def setReceiveBufferSize(value: java.lang.Integer) = {
      asJava.setReceiveBufferSize(value)
    }
    def getReceiveBufferSize: java.lang.Integer = {
      asJava.getReceiveBufferSize()
    }

  /**
    * Set the value of reuse address
    */
    def setReuseAddress(value: java.lang.Boolean) = {
      asJava.setReuseAddress(value)
    }
    def isReuseAddress: java.lang.Boolean = {
      asJava.isReuseAddress()
    }

  /**
    * Set the value of reuse port.
    * <p/>
    * This is only supported by native transports.
    */
    def setReusePort(value: java.lang.Boolean) = {
      asJava.setReusePort(value)
    }
    def isReusePort: java.lang.Boolean = {
      asJava.isReusePort()
    }

  /**
    * Set the TCP send buffer size
    */
    def setSendBufferSize(value: java.lang.Integer) = {
      asJava.setSendBufferSize(value)
    }
    def getSendBufferSize: java.lang.Integer = {
      asJava.getSendBufferSize()
    }

  /**
    * Set whether the server supports Server Name Indiciation
    */
    def setSni(value: java.lang.Boolean) = {
      asJava.setSni(value)
    }
    def isSni: java.lang.Boolean = {
      asJava.isSni()
    }

  /**
    * Set whether SO_linger keep alive is enabled
    */
    def setSoLinger(value: java.lang.Integer) = {
      asJava.setSoLinger(value)
    }
    def getSoLinger: java.lang.Integer = {
      asJava.getSoLinger()
    }

  /**
    * Set whether SSL/TLS is enabled
    */
    def setSsl(value: java.lang.Boolean) = {
      asJava.setSsl(value)
    }
    def isSsl: java.lang.Boolean = {
      asJava.isSsl()
    }

  /**
    * Enable the `TCP_CORK` option - only with linux native transport.
    */
    def setTcpCork(value: java.lang.Boolean) = {
      asJava.setTcpCork(value)
    }
    def isTcpCork: java.lang.Boolean = {
      asJava.isTcpCork()
    }

  /**
    * Enable the `TCP_FASTOPEN` option - only with linux native transport.
    */
    def setTcpFastOpen(value: java.lang.Boolean) = {
      asJava.setTcpFastOpen(value)
    }
    def isTcpFastOpen: java.lang.Boolean = {
      asJava.isTcpFastOpen()
    }

  /**
    * Set whether TCP keep alive is enabled
    */
    def setTcpKeepAlive(value: java.lang.Boolean) = {
      asJava.setTcpKeepAlive(value)
    }
    def isTcpKeepAlive: java.lang.Boolean = {
      asJava.isTcpKeepAlive()
    }

  /**
    * Set whether TCP no delay is enabled
    */
    def setTcpNoDelay(value: java.lang.Boolean) = {
      asJava.setTcpNoDelay(value)
    }
    def isTcpNoDelay: java.lang.Boolean = {
      asJava.isTcpNoDelay()
    }

  /**
    * Enable the `TCP_QUICKACK` option - only with linux native transport.
    */
    def setTcpQuickAck(value: java.lang.Boolean) = {
      asJava.setTcpQuickAck(value)
    }
    def isTcpQuickAck: java.lang.Boolean = {
      asJava.isTcpQuickAck()
    }

  /**
    * Set the value of traffic class
    */
    def setTrafficClass(value: java.lang.Integer) = {
      asJava.setTrafficClass(value)
    }
    def getTrafficClass: java.lang.Integer = {
      asJava.getTrafficClass()
    }

  /**
    * Set the trust options in jks format, aka Java truststore
    */
    def setTrustStoreOptions(value: JJksOptions) = {
      asJava.setTrustStoreOptions(value.asJava)
    }
    def getTrustStoreOptions: JJksOptions = {
      asJava.getTrustStoreOptions()
    }

  /**
    * Set the ALPN usage.
    */
    def setUseAlpn(value: java.lang.Boolean) = {
      asJava.setUseAlpn(value)
    }
    def isUseAlpn: java.lang.Boolean = {
      asJava.isUseAlpn()
    }

  /**
    * Set whether Netty pooled buffers are enabled
    */
    def setUsePooledBuffers(value: java.lang.Boolean) = {
      asJava.setUsePooledBuffers(value)
    }
    def isUsePooledBuffers: java.lang.Boolean = {
      asJava.isUsePooledBuffers()
    }
  }
  
  type NetServerOptions = JNetServerOptions
  object NetServerOptions {
    def apply(): JNetServerOptions = new NetServerOptions()
    def apply(json: JsonObject) = new JNetServerOptions(json)
  }


import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.net.{NetSocket => JNetSocket}
import io.vertx.core.buffer.Buffer
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.core.streams.WriteStream
import io.vertx.core.streams.ReadStream
import io.vertx.core.net.{SocketAddress => JSocketAddress}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.core.streams.{WriteStream => JWriteStream}
import io.vertx.core.net.NetSocket
import io.vertx.core.net.SocketAddress

/**
  * Represents a socket-like interface to a TCP connection on either the
  * client or the server side.
  * 
  * Instances of this class are created on the client side by an [[io.vertx.core.net.NetClient]]
  * when a connection to a server is made, or on the server side by a [[io.vertx.core.net.NetServer]]
  * when a server accepts a connection.
  * 
  * It implements both  and  so it can be used with
  * [[io.vertx.core.streams.Pump]] to pump data with flow control.
  */
implicit class NetSocketScala(val asJava: JNetSocket) extends AnyVal {


  def exceptionHandler(handler: scala.Option[Throwable => Unit]): JNetSocket = {
    asJava.exceptionHandler(handler match {case Some(t) => (p:Throwable) => t(p); case None => null})
  }

  def handler(handler: scala.Option[io.vertx.core.buffer.Buffer => Unit]): JNetSocket = {
    asJava.handler(handler match {case Some(t) => (p:io.vertx.core.buffer.Buffer) => t(p); case None => null})
  }

  def pause(): JNetSocket = {
    asJava.pause()
  }

  def resume(): JNetSocket = {
    asJava.resume()
  }

  def endHandler(endHandler: scala.Option[Void => Unit]): JNetSocket = {
    asJava.endHandler(endHandler match {case Some(t) => (p:Void) => t(p); case None => null})
  }

  def write(data: io.vertx.core.buffer.Buffer): JNetSocket = {
    asJava.write(data)
  }

  def setWriteQueueMaxSize(maxSize: java.lang.Integer): JNetSocket = {
    asJava.setWriteQueueMaxSize(maxSize)
  }

  def drainHandler(handler: scala.Option[Void => Unit]): JNetSocket = {
    asJava.drainHandler(handler match {case Some(t) => (p:Void) => t(p); case None => null})
  }

  /**
    * Write a String to the connection, encoded in UTF-8.
    * @param str the string to write
    * @return a reference to this, so the API can be used fluently
    */
  def write(str: String): JNetSocket = {
    asJava.write(str)
  }

  /**
    * Write a String to the connection, encoded using the encoding `enc`.
    * @param str the string to write
    * @param enc the encoding to use
    * @return a reference to this, so the API can be used fluently
    */
  def write(str: String, enc: String): JNetSocket = {
    asJava.write(str, enc)
  }

  /**
    * Tell the operating system to stream a file as specified by `filename` directly from disk to the outgoing connection,
    * bypassing userspace altogether (where supported by the underlying operating system. This is a very efficient way to stream files.
    * @param filename file name of the file to send
    * @return a reference to this, so the API can be used fluently
    */
  def sendFile(filename: String): JNetSocket = {
    asJava.sendFile(filename)
  }

  /**
    * Tell the operating system to stream a file as specified by `filename` directly from disk to the outgoing connection,
    * bypassing userspace altogether (where supported by the underlying operating system. This is a very efficient way to stream files.
    * @param filename file name of the file to send
    * @param offset offset
    * @return a reference to this, so the API can be used fluently
    */
  def sendFile(filename: String, offset: java.lang.Long): JNetSocket = {
    asJava.sendFile(filename, offset)
  }

  /**
    * Tell the operating system to stream a file as specified by `filename` directly from disk to the outgoing connection,
    * bypassing userspace altogether (where supported by the underlying operating system. This is a very efficient way to stream files.
    * @param filename file name of the file to send
    * @param offset offset
    * @param length length
    * @return a reference to this, so the API can be used fluently
    */
  def sendFile(filename: String, offset: java.lang.Long, length: java.lang.Long): JNetSocket = {
    asJava.sendFile(filename, offset, length)
  }

  /**
    * Same as [[io.vertx.core.net.NetSocket#sendFile]] but also takes a handler that will be called when the send has completed or
    * a failure has occurred
    * @param filename file name of the file to send
    * @param resultHandler handler
    * @return a reference to this, so the API can be used fluently
    */
  def sendFile(filename: String, resultHandler: AsyncResult[Void] => Unit): JNetSocket = {
    asJava.sendFile(filename, (p:AsyncResult[Void]) => resultHandler(p))
  }

  /**
    * Same as [[io.vertx.core.net.NetSocket#sendFile]] but also takes a handler that will be called when the send has completed or
    * a failure has occurred
    * @param filename file name of the file to send
    * @param offset offset
    * @param resultHandler handler
    * @return a reference to this, so the API can be used fluently
    */
  def sendFile(filename: String, offset: java.lang.Long, resultHandler: AsyncResult[Void] => Unit): JNetSocket = {
    asJava.sendFile(filename, offset, (p:AsyncResult[Void]) => resultHandler(p))
  }

  /**
    * Same as [[io.vertx.core.net.NetSocket#sendFile]] but also takes a handler that will be called when the send has completed or
    * a failure has occurred
    * @param filename file name of the file to send
    * @param offset offset
    * @param length length
    * @param resultHandler handler
    * @return a reference to this, so the API can be used fluently
    */
  def sendFile(filename: String, offset: java.lang.Long, length: java.lang.Long, resultHandler: AsyncResult[Void] => Unit): JNetSocket = {
    asJava.sendFile(filename, offset, length, (p:AsyncResult[Void]) => resultHandler(p))
  }

  /**
    * Set a handler that will be called when the NetSocket is closed
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  def closeHandler(handler: scala.Option[Void => Unit]): JNetSocket = {
    asJava.closeHandler(handler match {case Some(t) => (p:Void) => t(p); case None => null})
  }

  /**
    * Upgrade channel to use SSL/TLS. Be aware that for this to work SSL must be configured.
    * @param handler the handler will be notified when it's upgraded
    * @return a reference to this, so the API can be used fluently
    */
  def upgradeToSsl(handler: Void => Unit): JNetSocket = {
    asJava.upgradeToSsl((p:Void) => handler(p))
  }

  /**
    * Upgrade channel to use SSL/TLS. Be aware that for this to work SSL must be configured.
    * @param serverName the server name
    * @param handler the handler will be notified when it's upgraded
    * @return a reference to this, so the API can be used fluently
    */
  def upgradeToSsl(serverName: String, handler: Void => Unit): JNetSocket = {
    asJava.upgradeToSsl(serverName, (p:Void) => handler(p))
  }

  /**
    * Same as [[io.vertx.core.net.NetSocket#end]] but writes some data to the stream before ending.
    */
  def end(t: io.vertx.core.buffer.Buffer): Unit = {
    asJava.end(t)
  }

  /**
    * This will return `true` if there are more bytes in the write queue than the value set using [[io.vertx.core.net.NetSocket#setWriteQueueMaxSize]]
    * @return true if write queue is full
    */
  def writeQueueFull(): java.lang.Boolean = {
    asJava.writeQueueFull()
  }

  /**
    * When a `NetSocket` is created it automatically registers an event handler with the event bus, the ID of that
    * handler is given by `writeHandlerID`.
    * 
    * Given this ID, a different event loop can send a buffer to that event handler using the event bus and
    * that buffer will be received by this instance in its own event loop and written to the underlying connection. This
    * allows you to write data to other connections which are owned by different event loops.
    * @return the write handler ID
    */
  def writeHandlerID(): String = {
    asJava.writeHandlerID()
  }

  /**
    * Calls [[io.vertx.core.net.NetSocket#close]]
    */
  def end(): Unit = {
    asJava.end()
  }

  /**
    * Close the NetSocket
    */
  def close(): Unit = {
    asJava.close()
  }

  /**
    * @return true if this io.vertx.core.net.NetSocket is encrypted via SSL/TLS.
    */
  def isSsl(): java.lang.Boolean = {
    asJava.isSsl()
  }

  /**
    * Returns the SNI server name presented during the SSL handshake by the client.
    * @return the indicated server name
    */
  def indicatedServerName(): String = {
    asJava.indicatedServerName()
  }

  /**
    * @return the remote address for this socket
    */
  def remoteAddress(): JSocketAddress = {
    asJava.remoteAddress()
  }

  /**
    * @return the local address for this socket
    */
  def localAddress(): JSocketAddress = {
    asJava.localAddress()
  }

 /**
   * Like [[sendFile]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def sendFileFuture(filename: String): scala.concurrent.Future[Unit] = {
    val promise = Promise[Unit]()
    asJava.sendFile(filename, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[sendFile]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def sendFileFuture(filename: String, offset: java.lang.Long): scala.concurrent.Future[Unit] = {
    val promise = Promise[Unit]()
    asJava.sendFile(filename, offset, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[sendFile]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def sendFileFuture(filename: String, offset: java.lang.Long, length: java.lang.Long): scala.concurrent.Future[Unit] = {
    val promise = Promise[Unit]()
    asJava.sendFile(filename, offset, length, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

}

import io.vertx.core.net.{NetworkOptions => JNetworkOptions}

/**
  */

  implicit class NetworkOptionsScala(val asJava: JNetworkOptions) extends AnyVal {


  /**
    * Set to true to enabled network activity logging: Netty's pipeline is configured for logging on Netty's logger.
    */
    def setLogActivity(value: java.lang.Boolean) = {
      asJava.setLogActivity(value)
    }
    def getLogActivity: java.lang.Boolean = {
      asJava.getLogActivity()
    }

  /**
    * Set the TCP receive buffer size
    */
    def setReceiveBufferSize(value: java.lang.Integer) = {
      asJava.setReceiveBufferSize(value)
    }
    def getReceiveBufferSize: java.lang.Integer = {
      asJava.getReceiveBufferSize()
    }

  /**
    * Set the value of reuse address
    */
    def setReuseAddress(value: java.lang.Boolean) = {
      asJava.setReuseAddress(value)
    }
    def isReuseAddress: java.lang.Boolean = {
      asJava.isReuseAddress()
    }

  /**
    * Set the value of reuse port.
    * <p/>
    * This is only supported by native transports.
    */
    def setReusePort(value: java.lang.Boolean) = {
      asJava.setReusePort(value)
    }
    def isReusePort: java.lang.Boolean = {
      asJava.isReusePort()
    }

  /**
    * Set the TCP send buffer size
    */
    def setSendBufferSize(value: java.lang.Integer) = {
      asJava.setSendBufferSize(value)
    }
    def getSendBufferSize: java.lang.Integer = {
      asJava.getSendBufferSize()
    }

  /**
    * Set the value of traffic class
    */
    def setTrafficClass(value: java.lang.Integer) = {
      asJava.setTrafficClass(value)
    }
    def getTrafficClass: java.lang.Integer = {
      asJava.getTrafficClass()
    }
  }
  


import io.vertx.core.file.{OpenOptions => JOpenOptions}

/**
  * Describes how an [[io.vertx.core.file.AsyncFile]] should be opened.
  */

  implicit class OpenOptionsScala(val asJava: JOpenOptions) extends AnyVal {


  /**
    * Whether the file should be opened in append mode. Defaults to `false`.
    */
    def setAppend(value: java.lang.Boolean) = {
      asJava.setAppend(value)
    }
    def isAppend: java.lang.Boolean = {
      asJava.isAppend()
    }

  /**
    * Set whether the file should be created if it does not already exist.
    */
    def setCreate(value: java.lang.Boolean) = {
      asJava.setCreate(value)
    }
    def isCreate: java.lang.Boolean = {
      asJava.isCreate()
    }

  /**
    * Set whether the file should be created and fail if it does exist already.
    */
    def setCreateNew(value: java.lang.Boolean) = {
      asJava.setCreateNew(value)
    }
    def isCreateNew: java.lang.Boolean = {
      asJava.isCreateNew()
    }

  /**
    * Set whether the file should be deleted when it's closed, or the JVM is shutdown.
    */
    def setDeleteOnClose(value: java.lang.Boolean) = {
      asJava.setDeleteOnClose(value)
    }
    def isDeleteOnClose: java.lang.Boolean = {
      asJava.isDeleteOnClose()
    }

  /**
    * Set whether every write to the file's content  ill be written synchronously to the underlying hardware.
    */
    def setDsync(value: java.lang.Boolean) = {
      asJava.setDsync(value)
    }
    def isDsync: java.lang.Boolean = {
      asJava.isDsync()
    }

  /**
    * Set the permissions string
    */
    def setPerms(value: String) = {
      asJava.setPerms(value)
    }
    def getPerms: String = {
      asJava.getPerms()
    }

  /**
    * Set whether the file is to be opened for reading
    */
    def setRead(value: java.lang.Boolean) = {
      asJava.setRead(value)
    }
    def isRead: java.lang.Boolean = {
      asJava.isRead()
    }

  /**
    * Set whether a hint should be provided that the file to created is sparse
    */
    def setSparse(value: java.lang.Boolean) = {
      asJava.setSparse(value)
    }
    def isSparse: java.lang.Boolean = {
      asJava.isSparse()
    }

  /**
    * Set whether every write to the file's content and meta-data will be written synchronously to the underlying hardware.
    */
    def setSync(value: java.lang.Boolean) = {
      asJava.setSync(value)
    }
    def isSync: java.lang.Boolean = {
      asJava.isSync()
    }

  /**
    * Set whether the file should be truncated to zero length on opening if it exists and is opened for write
    */
    def setTruncateExisting(value: java.lang.Boolean) = {
      asJava.setTruncateExisting(value)
    }
    def isTruncateExisting: java.lang.Boolean = {
      asJava.isTruncateExisting()
    }

  /**
    * Set whether the file is to be opened for writing
    */
    def setWrite(value: java.lang.Boolean) = {
      asJava.setWrite(value)
    }
    def isWrite: java.lang.Boolean = {
      asJava.isWrite()
    }
  }
  
  type OpenOptions = JOpenOptions
  object OpenOptions {
    def apply(): JOpenOptions = new OpenOptions()
    def apply(json: JsonObject) = new JOpenOptions(json)
  }


import io.vertx.core.net.{OpenSSLEngineOptions => JOpenSSLEngineOptions}

/**
  * Configures a <a href="../../../../../../../cheatsheet/TCPSSLOptions.html">TCPSSLOptions</a> to use OpenSsl.
  */

  implicit class OpenSSLEngineOptionsScala(val asJava: JOpenSSLEngineOptions) extends AnyVal {


  /**
    * Set whether session cache is enabled in open SSL session server context
    */
    def setSessionCacheEnabled(value: java.lang.Boolean) = {
      asJava.setSessionCacheEnabled(value)
    }
    def isSessionCacheEnabled: java.lang.Boolean = {
      asJava.isSessionCacheEnabled()
    }
  }
  
  type OpenSSLEngineOptions = JOpenSSLEngineOptions
  object OpenSSLEngineOptions {
    def apply(): JOpenSSLEngineOptions = new OpenSSLEngineOptions()
    def apply(json: JsonObject) = new JOpenSSLEngineOptions(json)
  }


import io.vertx.core.cli.{Option => JOption}

/**
  * Models command line options. Options are values passed to a command line interface using -x or --x. Supported
  * syntaxes depend on the parser.
  * <p/>
  * Short name is generally used with a single dash, while long name requires a double-dash.
  */

  implicit class OptionScala(val asJava: JOption) extends AnyVal {


  /**
    * Sets te arg name for this option.
    */
    def setArgName(value: String) = {
      asJava.setArgName(value)
    }
    def getArgName: String = {
      asJava.getArgName()
    }

  /**
    * Sets the list of values accepted by this option. If the value set by the user does not match once of these
    * values, a [[io.vertx.core.cli.InvalidValueException]] exception is thrown.
    */
    def addChoice(value: String) = {
      asJava.addChoice(value)
      }
    def setChoices(value: Set[String]) = {
      asJava.setChoices(value.asJava)
    }
    def getChoices: scala.collection.mutable.Set[String] = {
      asJava.getChoices().asScala
    }

  /**
    * Sets the default value of this option
    */
    def setDefaultValue(value: String) = {
      asJava.setDefaultValue(value)
    }
    def getDefaultValue: String = {
      asJava.getDefaultValue()
    }

  /**
    * Sets te description of this option.
    */
    def setDescription(value: String) = {
      asJava.setDescription(value)
    }
    def getDescription: String = {
      asJava.getDescription()
    }

  /**
    * Configures the current <a href="../../../../../../../cheatsheet/Option.html">Option</a> to be a flag. It will be evaluated to `true` if it's found in
    * the command line. If you need a flag that may receive a value, use, in this order:
    * <code><pre>
    *   option.setFlag(true).setSingleValued(true)
    * </pre></code>
    */
    def setFlag(value: java.lang.Boolean) = {
      asJava.setFlag(value)
    }
    def isFlag: java.lang.Boolean = {
      asJava.isFlag()
    }

  /**
    * Sets whether or not this option is a "help" option
    */
    def setHelp(value: java.lang.Boolean) = {
      asJava.setHelp(value)
    }
    def isHelp: java.lang.Boolean = {
      asJava.isHelp()
    }

  /**
    * Sets whether or not this option should be hidden
    */
    def setHidden(value: java.lang.Boolean) = {
      asJava.setHidden(value)
    }
    def isHidden: java.lang.Boolean = {
      asJava.isHidden()
    }

  /**
    * Sets the long name of this option.
    */
    def setLongName(value: String) = {
      asJava.setLongName(value)
    }
    def getLongName: String = {
      asJava.getLongName()
    }

  /**
    * Sets whether or not this option can receive several values.
    */
    def setMultiValued(value: java.lang.Boolean) = {
      asJava.setMultiValued(value)
    }
    def isMultiValued: java.lang.Boolean = {
      asJava.isMultiValued()
    }

  /**
    */

  /**
    * Sets whether or not this option is mandatory.
    */
    def setRequired(value: java.lang.Boolean) = {
      asJava.setRequired(value)
    }
    def isRequired: java.lang.Boolean = {
      asJava.isRequired()
    }

  /**
    * Sets the short name of this option.
    */
    def setShortName(value: String) = {
      asJava.setShortName(value)
    }
    def getShortName: String = {
      asJava.getShortName()
    }

  /**
    * Sets whether or not this option can receive a value.
    */
    def setSingleValued(value: java.lang.Boolean) = {
      asJava.setSingleValued(value)
    }
    def isSingleValued: java.lang.Boolean = {
      asJava.isSingleValued()
    }
  }
  
  type Option = JOption
  object Option {
    def apply(): JOption = new Option()
    def apply(json: JsonObject) = new JOption(json)
  }


import io.vertx.core.buffer.Buffer
import io.vertx.core.net.{PemKeyCertOptions => JPemKeyCertOptions}

/**
  * Key store options configuring a list of private key and its certificate based on
  * <i>Privacy-enhanced Electronic Email</i> (PEM) files.
  * 
  *
  * A key file must contain a <b>non encrypted</b> private key in <b>PKCS8</b> format wrapped in a PEM
  * block, for example:
  * 
  *
  * <pre>
  * -----BEGIN PRIVATE KEY-----
  * MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDV6zPk5WqLwS0a
  * ...
  * K5xBhtm1AhdnZjx5KfW3BecE
  * -----END PRIVATE KEY-----
  * </pre>
  *
  * Or contain a <b>non encrypted</b> private key in <b>PKCS1</b> format wrapped in a PEM
  * block, for example:
  * 
  *
  * <pre>
  * -----BEGIN RSA PRIVATE KEY-----
  * MIIEowIBAAKCAQEAlO4gbHeFb/fmbUF/tOJfNPJumJUEqgzAzx8MBXv9Acyw9IRa
  * ...
  * zJ14Yd+t2fsLYVs2H0gxaA4DW6neCzgY3eKpSU0EBHUCFSXp/1+/
  * -----END RSA PRIVATE KEY-----
  * </pre>
  *
  * A certificate file must contain an X.509 certificate wrapped in a PEM block, for example:
  * 
  *
  * <pre>
  * -----BEGIN CERTIFICATE-----
  * MIIDezCCAmOgAwIBAgIEZOI/3TANBgkqhkiG9w0BAQsFADBuMRAwDgYDVQQGEwdV
  * ...
  * +tmLSvYS39O2nqIzzAUfztkYnUlZmB0l/mKkVqbGJA==
  * -----END CERTIFICATE-----
  * </pre>
  *
  * Keys and certificates can either be loaded by Vert.x from the filesystem:
  * 
  * <pre>
  * HttpServerOptions options = new HttpServerOptions();
  * options.setPemKeyCertOptions(new PemKeyCertOptions().setKeyPath("/mykey.pem").setCertPath("/mycert.pem"));
  * </pre>
  *
  * Or directly provided as a buffer:
  *
  * <pre>
  * Buffer key = vertx.fileSystem().readFileSync("/mykey.pem");
  * Buffer cert = vertx.fileSystem().readFileSync("/mycert.pem");
  * options.setPemKeyCertOptions(new PemKeyCertOptions().setKeyValue(key).setCertValue(cert));
  * </pre>
  *
  * Several key/certificate pairs can be used:
  * 
  * <pre>
  * HttpServerOptions options = new HttpServerOptions();
  * options.setPemKeyCertOptions(new PemKeyCertOptions()
  *    .addKeyPath("/mykey1.pem").addCertPath("/mycert1.pem")
  *    .addKeyPath("/mykey2.pem").addCertPath("/mycert2.pem"));
  * </pre>
  */

  implicit class PemKeyCertOptionsScala(val asJava: JPemKeyCertOptions) extends AnyVal {


  /**
    * Set the path of the first certificate, replacing the previous certificates paths
    */
    def setCertPath(value: String) = {
      asJava.setCertPath(value)
    }

  /**
    * Set all the paths to the certificates files
    */
    def setCertPaths(value: List[String]) = {
      asJava.setCertPaths(value.asJava)
      }
    def getCertPaths: scala.collection.mutable.Buffer[String] = {
      asJava.getCertPaths().asScala
    }

  /**
    * Set the first certificate as a buffer, replacing the previous certificates buffers
    */
    def setCertValue(value: io.vertx.core.buffer.Buffer) = {
      asJava.setCertValue(value)
    }

  /**
    * Set all the certificates as a list of buffer
    */
    def setCertValues(value: List[io.vertx.core.buffer.Buffer]) = {
      asJava.setCertValues(value.asJava)
      }
    def getCertValues: scala.collection.mutable.Buffer[io.vertx.core.buffer.Buffer] = {
      asJava.getCertValues().asScala
    }

  /**
    * Set the path of the first key file, replacing the keys paths
    */
    def setKeyPath(value: String) = {
      asJava.setKeyPath(value)
    }

  /**
    * Set all the paths to the keys files
    */
    def setKeyPaths(value: List[String]) = {
      asJava.setKeyPaths(value.asJava)
      }
    def getKeyPaths: scala.collection.mutable.Buffer[String] = {
      asJava.getKeyPaths().asScala
    }

  /**
    * Set the first key a a buffer, replacing the previous keys buffers
    */
    def setKeyValue(value: io.vertx.core.buffer.Buffer) = {
      asJava.setKeyValue(value)
    }

  /**
    * Set all the keys as a list of buffer
    */
    def setKeyValues(value: List[io.vertx.core.buffer.Buffer]) = {
      asJava.setKeyValues(value.asJava)
      }
    def getKeyValues: scala.collection.mutable.Buffer[io.vertx.core.buffer.Buffer] = {
      asJava.getKeyValues().asScala
    }
  }
  
  type PemKeyCertOptions = JPemKeyCertOptions
  object PemKeyCertOptions {
    def apply(): JPemKeyCertOptions = new PemKeyCertOptions()
    def apply(json: JsonObject) = new JPemKeyCertOptions(json)
  }


import io.vertx.core.buffer.Buffer
import io.vertx.core.net.{PemTrustOptions => JPemTrustOptions}

/**
  * Certificate Authority options configuring certificates based on
  * <i>Privacy-enhanced Electronic Email</i> (PEM) files. The options is configured with a list of
  * validating certificates.
  * 
  * Validating certificates must contain X.509 certificates wrapped in a PEM block:
  *
  * <pre>
  * -----BEGIN CERTIFICATE-----
  * MIIDezCCAmOgAwIBAgIEVmLkwTANBgkqhkiG9w0BAQsFADBuMRAwDgYDVQQGEwdV
  * ...
  * z5+DuODBJUQst141Jmgq8bS543IU/5apcKQeGNxEyQ==
  * -----END CERTIFICATE-----
  * </pre>
  *
  * The certificates can either be loaded by Vert.x from the filesystem:
  * 
  * <pre>
  * HttpServerOptions options = new HttpServerOptions();
  * options.setPemTrustOptions(new PemTrustOptions().addCertPath("/cert.pem"));
  * </pre>
  *
  * Or directly provided as a buffer:
  * 
  *
  * <pre>
  * Buffer cert = vertx.fileSystem().readFileSync("/cert.pem");
  * HttpServerOptions options = new HttpServerOptions();
  * options.setPemTrustOptions(new PemTrustOptions().addCertValue(cert));
  * </pre>
  */

  implicit class PemTrustOptionsScala(val asJava: JPemTrustOptions) extends AnyVal {


  /**
    * Add a certificate path
    */
    def addCertPath(value: String) = {
      asJava.addCertPath(value)
      }
    def getCertPaths: scala.collection.mutable.Buffer[String] = {
      asJava.getCertPaths().asScala
    }

  /**
    * Add a certificate value
    */
    def addCertValue(value: io.vertx.core.buffer.Buffer) = {
      asJava.addCertValue(value)
      }
    def getCertValues: scala.collection.mutable.Buffer[io.vertx.core.buffer.Buffer] = {
      asJava.getCertValues().asScala
    }
  }
  
  type PemTrustOptions = JPemTrustOptions
  object PemTrustOptions {
    def apply(): JPemTrustOptions = new PemTrustOptions()
    def apply(json: JsonObject) = new JPemTrustOptions(json)
  }


import io.vertx.core.buffer.Buffer
import io.vertx.core.net.{PfxOptions => JPfxOptions}

/**
  * Key or trust store options configuring private key and/or certificates based on PKCS#12 files.
  * 
  * When used as a key store, it should point to a store containing a private key and its certificate.
  * When used as a trust store, it should point to a store containing a list of accepted certificates.
  * 
  *
  * The store can either be loaded by Vert.x from the filesystem:
  * 
  * <pre>
  * HttpServerOptions options = new HttpServerOptions();
  * options.setPfxKeyCertOptions(new PfxOptions().setPath("/mykeystore.p12").setPassword("foo"));
  * </pre>
  *
  * Or directly provided as a buffer:
  *
  * <pre>
  * Buffer store = vertx.fileSystem().readFileSync("/mykeystore.p12");
  * options.setPfxKeyCertOptions(new PfxOptions().setValue(store).setPassword("foo"));
  * </pre>
  */

  implicit class PfxOptionsScala(val asJava: JPfxOptions) extends AnyVal {


  /**
    * Set the password
    */
    def setPassword(value: String) = {
      asJava.setPassword(value)
    }
    def getPassword: String = {
      asJava.getPassword()
    }

  /**
    * Set the path
    */
    def setPath(value: String) = {
      asJava.setPath(value)
    }
    def getPath: String = {
      asJava.getPath()
    }

  /**
    * Set the store as a buffer
    */
    def setValue(value: io.vertx.core.buffer.Buffer) = {
      asJava.setValue(value)
    }
    def getValue: io.vertx.core.buffer.Buffer = {
      asJava.getValue()
    }
  }
  
  type PfxOptions = JPfxOptions
  object PfxOptions {
    def apply(): JPfxOptions = new PfxOptions()
    def apply(json: JsonObject) = new JPfxOptions(json)
  }


import io.vertx.core.net.ProxyType
import io.vertx.core.net.{ProxyOptions => JProxyOptions}

/**
  * Proxy options for a net client or a net client.
  */

  implicit class ProxyOptionsScala(val asJava: JProxyOptions) extends AnyVal {


  /**
    * Set proxy host.
    */
    def setHost(value: String) = {
      asJava.setHost(value)
    }
    def getHost: String = {
      asJava.getHost()
    }

  /**
    * Set proxy password.
    */
    def setPassword(value: String) = {
      asJava.setPassword(value)
    }
    def getPassword: String = {
      asJava.getPassword()
    }

  /**
    * Set proxy port.
    */
    def setPort(value: java.lang.Integer) = {
      asJava.setPort(value)
    }
    def getPort: java.lang.Integer = {
      asJava.getPort()
    }

  /**
    * Set proxy type.
    *
    * ProxyType can be HTTP, SOCKS4 and SOCKS5
    */
    def setType(value: io.vertx.core.net.ProxyType) = {
      asJava.setType(value)
    }
    def getType: io.vertx.core.net.ProxyType = {
      asJava.getType()
    }

  /**
    * Set proxy username.
    */
    def setUsername(value: String) = {
      asJava.setUsername(value)
    }
    def getUsername: String = {
      asJava.getUsername()
    }
  }
  
  type ProxyOptions = JProxyOptions
  object ProxyOptions {
    def apply(): JProxyOptions = new ProxyOptions()
    def apply(json: JsonObject) = new JProxyOptions(json)
  }


import io.vertx.core.streams.{Pump => JPump}
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.core.streams.WriteStream
import io.vertx.core.streams.ReadStream
import io.vertx.core.streams.Pump
import io.vertx.core.streams.{WriteStream => JWriteStream}

/**
  * Pumps data from a [[io.vertx.core.streams.ReadStream]] to a [[io.vertx.core.streams.WriteStream]] and performs flow control where necessary to
  * prevent the write stream buffer from getting overfull.
  * 
  * Instances of this class read items from a [[io.vertx.core.streams.ReadStream]] and write them to a [[io.vertx.core.streams.WriteStream]]. If data
  * can be read faster than it can be written this could result in the write queue of the [[io.vertx.core.streams.WriteStream]] growing
  * without bound, eventually causing it to exhaust all available RAM.
  * 
  * To prevent this, after each write, instances of this class check whether the write queue of the [[io.vertx.core.streams.WriteStream]] is full, and if so, the [[io.vertx.core.streams.ReadStream]] is paused, and a `drainHandler` is set on the
  * [[io.vertx.core.streams.WriteStream]].
  * 
  * When the [[io.vertx.core.streams.WriteStream]] has processed half of its backlog, the `drainHandler` will be
  * called, which results in the pump resuming the [[io.vertx.core.streams.ReadStream]].
  * 
  * This class can be used to pump from any [[io.vertx.core.streams.ReadStream]] to any [[io.vertx.core.streams.WriteStream]],
  * e.g. from an [[io.vertx.core.http.HttpServerRequest]] to an [[io.vertx.core.file.AsyncFile]],
  * or from [[io.vertx.core.net.NetSocket]] to a [[io.vertx.core.http.WebSocket]].
  * 
  * Please see the documentation for more information.
  */
implicit class PumpScala(val asJava: JPump) extends AnyVal {


  /**
    * Set the write queue max size to `maxSize`
    * @param maxSize the max size
    * @return a reference to this, so the API can be used fluently
    */
  def setWriteQueueMaxSize(maxSize: java.lang.Integer): JPump = {
    asJava.setWriteQueueMaxSize(maxSize)
  }

  /**
    * Start the Pump. The Pump can be started and stopped multiple times.
    * @return a reference to this, so the API can be used fluently
    */
  def start(): JPump = {
    asJava.start()
  }

  /**
    * Stop the Pump. The Pump can be started and stopped multiple times.
    * @return a reference to this, so the API can be used fluently
    */
  def stop(): JPump = {
    asJava.stop()
  }

  /**
    * Return the total number of items pumped by this pump.
    */
  def numberPumped(): java.lang.Integer = {
    asJava.numberPumped()
  }

}

import io.vertx.core.streams.{StreamBase => JStreamBase}
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.core.streams.StreamBase
import io.vertx.core.streams.ReadStream
import io.vertx.core.Handler

/**
  * Represents a stream of items that can be read from.
  * 
  * Any class that implements this interface can be used by a [[io.vertx.core.streams.Pump]] to pump data from it
  * to a [[io.vertx.core.streams.WriteStream]].
  */
implicit class ReadStreamScala[T](val asJava: JReadStream[T]) extends AnyVal {


  /**
    * Set an exception handler on the read stream.
    * @param handler the exception handler
    * @return a reference to this, so the API can be used fluently
    */
  def exceptionHandler(handler: scala.Option[Throwable => Unit]): JReadStream[T] = {
    asJava.exceptionHandler(handler match {case Some(t) => (p:Throwable) => t(p); case None => null})
  }

  /**
    * Set a data handler. As data is read, the handler will be called with the data.
    * @return a reference to this, so the API can be used fluently
    */
  def handler(handler: scala.Option[T => Unit]): JReadStream[T] = {
    asJava.handler(handler match {case Some(t) => (p:T) => t(p); case None => null})
  }

  /**
    * Pause the `ReadSupport`. While it's paused, no data will be sent to the `dataHandler`
    * @return a reference to this, so the API can be used fluently
    */
  def pause(): JReadStream[T] = {
    asJava.pause()
  }

  /**
    * Resume reading. If the `ReadSupport` has been paused, reading will recommence on it.
    * @return a reference to this, so the API can be used fluently
    */
  def resume(): JReadStream[T] = {
    asJava.resume()
  }

  /**
    * Set an end handler. Once the stream has ended, and there is no more data to be read, this handler will be called.
    * @return a reference to this, so the API can be used fluently
    */
  def endHandler(endHandler: scala.Option[Void => Unit]): JReadStream[T] = {
    asJava.endHandler(endHandler match {case Some(t) => (p:Void) => t(p); case None => null})
  }

}

import io.vertx.core.buffer.Buffer
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.core.streams.ReadStream
import io.vertx.core.parsetools.RecordParser
import io.vertx.core.Handler
import io.vertx.core.parsetools.{RecordParser => JRecordParser}

/**
  * A helper class which allows you to easily parse protocols which are delimited by a sequence of bytes, or fixed
  * size records.
  * 
  * Instances of this class take as input [[io.vertx.core.buffer.Buffer]] instances containing raw bytes,
  * and output records.
  * 
  * For example, if I had a simple ASCII text protocol delimited by '\n' and the input was the following:
  * 
  * <pre>
  * buffer1:HELLO\nHOW ARE Y
  * buffer2:OU?\nI AM
  * buffer3: DOING OK
  * buffer4:\n
  * </pre>
  * Then the output would be:
  * <pre>
  * buffer1:HELLO
  * buffer2:HOW ARE YOU?
  * buffer3:I AM DOING OK
  * </pre>
  * Instances of this class can be changed between delimited mode and fixed size record mode on the fly as
  * individual records are read, this allows you to parse protocols where, for example, the first 5 records might
  * all be fixed size (of potentially different sizes), followed by some delimited records, followed by more fixed
  * size records.
  * 
  * Instances of this class can't currently be used for protocols where the text is encoded with something other than
  * a 1-1 byte-char mapping.
  * 
  * Please see the documentation for more information.
  */
implicit class RecordParserScala(val asJava: JRecordParser) extends AnyVal {


  def exceptionHandler(handler: scala.Option[Throwable => Unit]): JRecordParser = {
    asJava.exceptionHandler(handler match {case Some(t) => (p:Throwable) => t(p); case None => null})
  }

  def handler(handler: scala.Option[io.vertx.core.buffer.Buffer => Unit]): JRecordParser = {
    asJava.handler(handler match {case Some(t) => (p:io.vertx.core.buffer.Buffer) => t(p); case None => null})
  }

  def pause(): JRecordParser = {
    asJava.pause()
  }

  def resume(): JRecordParser = {
    asJava.resume()
  }

  def endHandler(endHandler: scala.Option[Void => Unit]): JRecordParser = {
    asJava.endHandler(endHandler match {case Some(t) => (p:Void) => t(p); case None => null})
  }

  def setOutput(output: io.vertx.core.buffer.Buffer => Unit): Unit = {
    asJava.setOutput((p:io.vertx.core.buffer.Buffer) => output(p))
  }

  /**
    * Flip the parser into delimited mode, and where the delimiter can be represented
    * by the String `delim` encoded in latin-1 . Don't use this if your String contains other than latin-1 characters.
    * 
    * This method can be called multiple times with different values of delim while data is being parsed.
    * @param delim the new delimeter
    */
  def delimitedMode(delim: String): Unit = {
    asJava.delimitedMode(delim)
  }

  /**
    * Flip the parser into delimited mode, and where the delimiter can be represented
    * by the delimiter `delim`.
    * 
    * This method can be called multiple times with different values of delim while data is being parsed.
    * @param delim the new delimiter
    */
  def delimitedMode(delim: io.vertx.core.buffer.Buffer): Unit = {
    asJava.delimitedMode(delim)
  }

  /**
    * Flip the parser into fixed size mode, where the record size is specified by `size` in bytes.
    * 
    * This method can be called multiple times with different values of size while data is being parsed.
    * @param size the new record size
    */
  def fixedSizeMode(size: java.lang.Integer): Unit = {
    asJava.fixedSizeMode(size)
  }

  /**
    * This method is called to provide the parser with data.
    * @param buffer a chunk of data
    */
  def handle(buffer: io.vertx.core.buffer.Buffer): Unit = {
    asJava.handle(buffer)
  }

}

import io.vertx.core.http.{RequestOptions => JRequestOptions}

/**
  * Options describing how an [[io.vertx.core.http.HttpClient]] will make connect to make a request.
  */

  implicit class RequestOptionsScala(val asJava: JRequestOptions) extends AnyVal {


  /**
    * Set the host name to be used by the client request.
    */
    def setHost(value: String) = {
      asJava.setHost(value)
    }
    def getHost: String = {
      asJava.getHost()
    }

  /**
    * Set the port to be used by the client request.
    */
    def setPort(value: java.lang.Integer) = {
      asJava.setPort(value)
    }
    def getPort: java.lang.Integer = {
      asJava.getPort()
    }

  /**
    * Set whether SSL/TLS is enabled
    */
    def setSsl(value: java.lang.Boolean) = {
      asJava.setSsl(value)
    }
    def isSsl: java.lang.Boolean = {
      asJava.isSsl()
    }

  /**
    * Set the request relative URI
    */
    def setURI(value: String) = {
      asJava.setURI(value)
    }
    def getURI: String = {
      asJava.getURI()
    }
  }
  
  type RequestOptions = JRequestOptions
  object RequestOptions {
    def apply(): JRequestOptions = new RequestOptions()
    def apply(json: JsonObject) = new JRequestOptions(json)
  }


import io.vertx.core.net.{SelfSignedCertificate => JSelfSignedCertificate}
import io.vertx.core.net.PemKeyCertOptions
import io.vertx.core.net.{PemTrustOptions => JPemTrustOptions}
import io.vertx.core.net.SelfSignedCertificate
import io.vertx.core.net.{PemKeyCertOptions => JPemKeyCertOptions}
import io.vertx.core.net.PemTrustOptions

/**
  * A self-signed certificate helper for testing and development purposes.
  * 
  * While it helps for testing and development, it should never ever be used in production settings.
  */
implicit class SelfSignedCertificateScala(val asJava: JSelfSignedCertificate) extends AnyVal {


  /**
    * Provides the [[io.vertx.core.net.KeyCertOptions]] RSA private key file in PEM format corresponding to the [[io.vertx.core.net.SelfSignedCertificate#privateKeyPath]]
    * @return a PemKeyCertOptions based on the generated certificate.see <a href="../../../../../../../cheatsheet/PemKeyCertOptions.html">PemKeyCertOptions</a>
    */
  def keyCertOptions(): JPemKeyCertOptions = {
    asJava.keyCertOptions()
  }

  /**
    * Provides the [[io.vertx.core.net.TrustOptions]] X.509 certificate file in PEM format corresponding to the [[io.vertx.core.net.SelfSignedCertificate#certificatePath]]
    * @return a PemTrustOptions based on the generated certificate.see <a href="../../../../../../../cheatsheet/PemTrustOptions.html">PemTrustOptions</a>
    */
  def trustOptions(): JPemTrustOptions = {
    asJava.trustOptions()
  }

  /**
    * Filesystem path to the RSA private key file in PEM format
    * @return the absolute path to the private key.
    */
  def privateKeyPath(): String = {
    asJava.privateKeyPath()
  }

  /**
    * Filesystem path to the X.509 certificate file in PEM format .
    * @return the absolute path to the certificate.
    */
  def certificatePath(): String = {
    asJava.certificatePath()
  }

  /**
    * Delete the private key and certificate files.
    */
  def delete(): Unit = {
    asJava.delete()
  }

}

import io.vertx.core.eventbus.{SendContext => JSendContext}
import io.vertx.core.eventbus.{Message => JMessage}
import io.vertx.core.eventbus.Message

/**
  *
  * Encapsulates a message being sent from Vert.x. Used with event bus interceptors
  */
implicit class SendContextScala[T](val asJava: JSendContext[T]) extends AnyVal {


  /**
    * @return The message being sent
    */
  def message(): JMessage[T] = {
    asJava.message()
  }

  /**
    * Call the next interceptor
    */
  def next(): Unit = {
    asJava.next()
  }

  /**
    * @return true if the message is being sent (point to point) or False if the message is being published
    */
  def send(): java.lang.Boolean = {
    asJava.send()
  }

  /**
    * @return the value sent or published (before being processed by the codec)
    */
  def sentBody(): AnyRef = {
    asJava.sentBody()
  }

}

import io.vertx.core.http.ServerWebSocket
import io.vertx.core.http.WebSocketBase
import io.vertx.core.buffer.Buffer
import io.vertx.core.http.{ServerWebSocket => JServerWebSocket}
import io.vertx.core.http.{WebSocketBase => JWebSocketBase}
import io.vertx.core.MultiMap
import io.vertx.core.http.{WebSocketFrame => JWebSocketFrame}
import io.vertx.core.{MultiMap => JMultiMap}
import io.vertx.core.net.{SocketAddress => JSocketAddress}
import io.vertx.core.Handler
import io.vertx.core.http.WebSocketFrame
import io.vertx.core.net.SocketAddress

/**
  * Represents a server side WebSocket.
  * 
  * Instances of this class are passed into a [[io.vertx.core.http.HttpServer#websocketHandler]] or provided
  * when a WebSocket handshake is manually [[io.vertx.core.http.HttpServerRequest#upgrade]]ed.
  */
implicit class ServerWebSocketScala(val asJava: JServerWebSocket) extends AnyVal {


  /**
    * Writes a (potentially large) piece of text data to the connection. This data might be written as multiple frames
    * if it exceeds the maximum WebSocket frame size.
    * @param text the data to write
    * @return a reference to this, so the API can be used fluently
    */
  def writeTextMessage(text: String): JWebSocketBase = {
    asJava.writeTextMessage(text)
  }

  /**
    * Writes a ping to the connection. This will be written in a single frame. Ping frames may be at most 125 bytes (octets).
    * 
    * This method should not be used to write application data and should only be used for implementing a keep alive or
    * to ensure the client is still responsive, see RFC 6455 Section 5.5.2.
    * 
    * There is no pingHandler because RFC 6455 section 5.5.2 clearly states that the only response to a ping is a pong
    * with identical contents.
    * @param data the data to write, may be at most 125 bytes
    * @return a reference to this, so the API can be used fluently
    */
  def writePing(data: io.vertx.core.buffer.Buffer): JWebSocketBase = {
    asJava.writePing(data)
  }

  /**
    * Writes a pong to the connection. This will be written in a single frame. Pong frames may be at most 125 bytes (octets).
    * 
    * This method should not be used to write application data and should only be used for implementing a keep alive or
    * to ensure the client is still responsive, see RFC 6455 Section 5.5.2.
    * 
    * There is no need to manually write a Pong, as the server and client both handle responding to a ping with a pong
    * automatically and this is exposed to users.RFC 6455 Section 5.5.3 states that pongs may be sent unsolicited in order
    * to implement a one way heartbeat.
    * @param data the data to write, may be at most 125 bytes
    * @return a reference to this, so the API can be used fluently
    */
  def writePong(data: io.vertx.core.buffer.Buffer): JWebSocketBase = {
    asJava.writePong(data)
  }

  /**
    * Set a text message handler on the connection. This handler will be called similar to the
    * [[io.vertx.core.http.WebSocketBase#binaryMessageHandler]], but the buffer will be converted to a String first
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  def textMessageHandler(handler: scala.Option[String => Unit]): JWebSocketBase = {
    asJava.textMessageHandler(handler match {case Some(t) => (p:String) => t(p); case None => null})
  }

  /**
    * Set a binary message handler on the connection. This handler serves a similar purpose to [[io.vertx.core.http.ServerWebSocket#handler]]
    * except that if a message comes into the socket in multiple frames, the data from the frames will be aggregated
    * into a single buffer before calling the handler (using [[io.vertx.core.http.WebSocketFrame#isFinal]] to find the boundaries).
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  def binaryMessageHandler(handler: scala.Option[io.vertx.core.buffer.Buffer => Unit]): JWebSocketBase = {
    asJava.binaryMessageHandler(handler match {case Some(t) => (p:io.vertx.core.buffer.Buffer) => t(p); case None => null})
  }

  /**
    * Set a pong message handler on the connection.  This handler will be invoked every time a pong message is received
    * on the server, and can be used by both clients and servers since the RFC 6455 Sections 5.5.2 and 5.5.3 do not
    * specify whether the client or server sends a ping.
    * 
    * Pong frames may be at most 125 bytes (octets).
    * 
    * There is no ping handler since pings should immediately be responded to with a pong with identical content
    * 
    * Pong frames may be received unsolicited.
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  def pongHandler(handler: scala.Option[io.vertx.core.buffer.Buffer => Unit]): JWebSocketBase = {
    asJava.pongHandler(handler match {case Some(t) => (p:io.vertx.core.buffer.Buffer) => t(p); case None => null})
  }

  def exceptionHandler(handler: scala.Option[Throwable => Unit]): JServerWebSocket = {
    asJava.exceptionHandler(handler match {case Some(t) => (p:Throwable) => t(p); case None => null})
  }

  def handler(handler: scala.Option[io.vertx.core.buffer.Buffer => Unit]): JServerWebSocket = {
    asJava.handler(handler match {case Some(t) => (p:io.vertx.core.buffer.Buffer) => t(p); case None => null})
  }

  def pause(): JServerWebSocket = {
    asJava.pause()
  }

  def resume(): JServerWebSocket = {
    asJava.resume()
  }

  def endHandler(endHandler: scala.Option[Void => Unit]): JServerWebSocket = {
    asJava.endHandler(endHandler match {case Some(t) => (p:Void) => t(p); case None => null})
  }

  def write(data: io.vertx.core.buffer.Buffer): JServerWebSocket = {
    asJava.write(data)
  }

  def setWriteQueueMaxSize(maxSize: java.lang.Integer): JServerWebSocket = {
    asJava.setWriteQueueMaxSize(maxSize)
  }

  def drainHandler(handler: scala.Option[Void => Unit]): JServerWebSocket = {
    asJava.drainHandler(handler match {case Some(t) => (p:Void) => t(p); case None => null})
  }

  def writeFrame(frame: JWebSocketFrame): JServerWebSocket = {
    asJava.writeFrame(frame.asJava)
  }

  def writeFinalTextFrame(text: String): JServerWebSocket = {
    asJava.writeFinalTextFrame(text)
  }

  def writeFinalBinaryFrame(data: io.vertx.core.buffer.Buffer): JServerWebSocket = {
    asJava.writeFinalBinaryFrame(data)
  }

  def writeBinaryMessage(data: io.vertx.core.buffer.Buffer): JServerWebSocket = {
    asJava.writeBinaryMessage(data)
  }

  def closeHandler(handler: scala.Option[Void => Unit]): JServerWebSocket = {
    asJava.closeHandler(handler match {case Some(t) => (p:Void) => t(p); case None => null})
  }

  def frameHandler(handler: scala.Option[JWebSocketFrame => Unit]): JServerWebSocket = {
    asJava.frameHandler(handler match {case Some(t) => (p:JWebSocketFrame) => t(p); case None => null})
  }

  /**
    * Same as [[io.vertx.core.http.WebSocketBase#end]] but writes some data to the stream before ending.
    */
  def end(t: io.vertx.core.buffer.Buffer): Unit = {
    asJava.end(t)
  }

  /**
    * This will return `true` if there are more bytes in the write queue than the value set using [[io.vertx.core.http.ServerWebSocket#setWriteQueueMaxSize]]
    * @return true if write queue is full
    */
  def writeQueueFull(): java.lang.Boolean = {
    asJava.writeQueueFull()
  }

  /**
    * When a `Websocket` is created it automatically registers an event handler with the event bus - the ID of that
    * handler is given by this method.
    * 
    * Given this ID, a different event loop can send a binary frame to that event handler using the event bus and
    * that buffer will be received by this instance in its own event loop and written to the underlying connection. This
    * allows you to write data to other WebSockets which are owned by different event loops.
    * @return the binary handler id
    */
  def binaryHandlerID(): String = {
    asJava.binaryHandlerID()
  }

  /**
    * When a `Websocket` is created it automatically registers an event handler with the eventbus, the ID of that
    * handler is given by `textHandlerID`.
    * 
    * Given this ID, a different event loop can send a text frame to that event handler using the event bus and
    * that buffer will be received by this instance in its own event loop and written to the underlying connection. This
    * allows you to write data to other WebSockets which are owned by different event loops.
    */
  def textHandlerID(): String = {
    asJava.textHandlerID()
  }

  /**
    * Returns the websocket sub protocol selected by the websocket handshake.
    * <p/>
    * On the server, the value will be `null` when the handler receives the websocket callback as the
    * handshake will not be completed yet.
    */
  def subProtocol(): String = {
    asJava.subProtocol()
  }

  /**
    * Calls [[io.vertx.core.http.WebSocketBase#close]]
    */
  def end(): Unit = {
    asJava.end()
  }

  /**
    * Close the WebSocket.
    */
  def close(): Unit = {
    asJava.close()
  }

  def close(statusCode: java.lang.Short): Unit = {
    asJava.close(statusCode)
  }

  def close(statusCode: java.lang.Short, reason: scala.Option[String]): Unit = {
    asJava.close(statusCode, reason.orNull)
  }

  /**
    * @return true if this io.vertx.core.http.HttpConnection is encrypted via SSL/TLS.
    */
  def isSsl(): java.lang.Boolean = {
    asJava.isSsl()
  }

  def uri(): String = {
    asJava.uri()
  }

  /**
    * @return the WebSocket handshake path.
    */
  def path(): String = {
    asJava.path()
  }

  /**
    * @return the WebSocket handshake query string.
    */
  def query(): scala.Option[String] = {
    scala.Option(asJava.query())
  }

  /**
    * Accept the WebSocket and terminate the WebSocket handshake.
    * <p/>
    * This method should be called from the websocket handler to explicitely accept the websocker and
    * terminate the WebSocket handshake.
    */
  def accept(): Unit = {
    asJava.accept()
  }

  /**
    * Reject the WebSocket.
    * 
    * Calling this method from the websocket handler when it is first passed to you gives you the opportunity to reject
    * the websocket, which will cause the websocket handshake to fail by returning
    * a  response code.
    * 
    * You might use this method, if for example you only want to accept WebSockets with a particular path.
    */
  def reject(): Unit = {
    asJava.reject()
  }

  /**
    * Like [[io.vertx.core.http.ServerWebSocket#reject]] but with a `status`.
    */
  def reject(status: java.lang.Integer): Unit = {
    asJava.reject(status)
  }

  /**
    * @return the remote address for this socket
    */
  def remoteAddress(): JSocketAddress = {
    asJava.remoteAddress()
  }

  /**
    * @return the local address for this socket
    */
  def localAddress(): JSocketAddress = {
    asJava.localAddress()
  }

  /**
    * @return the headers in the WebSocket handshake
    */
  def headers(): JMultiMap = {
    asJava.headers()
  }

}

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.shareddata.AsyncMap
import io.vertx.core.shareddata.Lock
import io.vertx.core.shareddata.LocalMap
import io.vertx.core.shareddata.{Counter => JCounter}
import io.vertx.core.shareddata.{AsyncMap => JAsyncMap}
import io.vertx.core.shareddata.{LocalMap => JLocalMap}
import io.vertx.core.shareddata.Counter
import io.vertx.core.shareddata.{Lock => JLock}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.core.shareddata.{SharedData => JSharedData}

/**
  * Shared data allows you to share data safely between different parts of your application in a safe way.
  * 
  * Shared data provides:
  * <ul>
  *   <li>synchronous shared maps (local)</li>
  *   <li>asynchronous maps (local or cluster-wide)</li>
  *   <li>asynchronous locks (local or cluster-wide)</li>
  *   <li>asynchronous counters (local or cluster-wide)</li>
  * </ul>
  * 
  * 
  *   <strong>WARNING</strong>: In clustered mode, asynchronous maps/locks/counters rely on distributed data structures provided by the cluster manager.
  *   Beware that the latency relative to asynchronous maps/locks/counters operations can be much higher in clustered than in local mode.
  * </p>
  * Please see the documentation for more information.
  */
implicit class SharedDataScala(val asJava: JSharedData) extends AnyVal {


  /**
    * Get the cluster wide map with the specified name. The map is accessible to all nodes in the cluster and data
    * put into the map from any node is visible to to any other node.
    * @param name the name of the map
    * @param resultHandler the map will be returned asynchronously in this handler
    */
  def getClusterWideMap[K, V](name: String, resultHandler: AsyncResult[JAsyncMap[K, V]] => Unit): Unit = {
    asJava.getClusterWideMap[K, V](name, (p:AsyncResult[JAsyncMap[K, V]]) => resultHandler(p))
  }

  /**
    * Get the [[io.vertx.core.shareddata.AsyncMap]] with the specified name. When clustered, the map is accessible to all nodes in the cluster
    * and data put into the map from any node is visible to to any other node.
    * 
    *   <strong>WARNING</strong>: In clustered mode, asynchronous shared maps rely on distributed data structures provided by the cluster manager.
    *   Beware that the latency relative to asynchronous shared maps operations can be much higher in clustered than in local mode.
    * </p>
    * @param name the name of the map
    * @param resultHandler the map will be returned asynchronously in this handler
    */
  def getAsyncMap[K, V](name: String, resultHandler: AsyncResult[JAsyncMap[K, V]] => Unit): Unit = {
    asJava.getAsyncMap[K, V](name, (p:AsyncResult[JAsyncMap[K, V]]) => resultHandler(p))
  }

  /**
    * Get an asynchronous lock with the specified name. The lock will be passed to the handler when it is available.
    * @param name the name of the lock
    * @param resultHandler the handler
    */
  def getLock(name: String, resultHandler: AsyncResult[JLock] => Unit): Unit = {
    asJava.getLock(name, (p:AsyncResult[JLock]) => resultHandler(p))
  }

  /**
    * Like [[io.vertx.core.shareddata.SharedData#getLockFuture]] but specifying a timeout. If the lock is not obtained within the timeout
    * a failure will be sent to the handler
    * @param name the name of the lock
    * @param timeout the timeout in ms
    * @param resultHandler the handler
    */
  def getLockWithTimeout(name: String, timeout: java.lang.Long, resultHandler: AsyncResult[JLock] => Unit): Unit = {
    asJava.getLockWithTimeout(name, timeout, (p:AsyncResult[JLock]) => resultHandler(p))
  }

  /**
    * Get an asynchronous counter. The counter will be passed to the handler.
    * @param name the name of the counter.
    * @param resultHandler the handler
    */
  def getCounter(name: String, resultHandler: AsyncResult[JCounter] => Unit): Unit = {
    asJava.getCounter(name, (p:AsyncResult[JCounter]) => resultHandler(p))
  }

  /**
    * Return a `LocalMap` with the specific `name`.
    * @param name the name of the map
    * @return the msp
    */
  def getLocalMap[K, V](name: String): JLocalMap[K, V] = {
    asJava.getLocalMap[K, V](name)
  }

 /**
   * Like [[getClusterWideMap]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def getClusterWideMapFuture[K, V](name: String): scala.concurrent.Future[JAsyncMap[K, V]] = {
    val promise = Promise[JAsyncMap[K, V]]()
    asJava.getClusterWideMap[K, V](name, {a:AsyncResult[io.vertx.core.shareddata.AsyncMap[K,V]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[getAsyncMap]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def getAsyncMapFuture[K, V](name: String): scala.concurrent.Future[JAsyncMap[K, V]] = {
    val promise = Promise[JAsyncMap[K, V]]()
    asJava.getAsyncMap[K, V](name, {a:AsyncResult[io.vertx.core.shareddata.AsyncMap[K,V]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[getLock]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def getLockFuture(name: String): scala.concurrent.Future[JLock] = {
    val promise = Promise[JLock]()
    asJava.getLock(name, {a:AsyncResult[io.vertx.core.shareddata.Lock] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[getLockWithTimeout]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def getLockWithTimeoutFuture(name: String, timeout: java.lang.Long): scala.concurrent.Future[JLock] = {
    val promise = Promise[JLock]()
    asJava.getLockWithTimeout(name, timeout, {a:AsyncResult[io.vertx.core.shareddata.Lock] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[getCounter]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def getCounterFuture(name: String): scala.concurrent.Future[JCounter] = {
    val promise = Promise[JCounter]()
    asJava.getCounter(name, {a:AsyncResult[io.vertx.core.shareddata.Counter] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

}

import io.vertx.core.net.{SocketAddress => JSocketAddress}
import io.vertx.core.net.SocketAddress

/**
  * The address of a socket, an inet socket address or a domain socket address.
  * <p/>
  * Use [[io.vertx.core.net.SocketAddress#inetSocketAddress]] to create an inet socket address and [[io.vertx.core.net.SocketAddress#domainSocketAddress]]
  * to create a domain socket address
  */
implicit class SocketAddressScala(val asJava: JSocketAddress) extends AnyVal {


  /**
    * @return the address host or `null` for a domain socket
    */
  def host(): String = {
    asJava.host()
  }

  /**
    * @return the address port or `-1` for a domain socket
    */
  def port(): java.lang.Integer = {
    asJava.port()
  }

  /**
    * @return the address path or `null` for a inet socket
    */
  def path(): String = {
    asJava.path()
  }

}

import io.vertx.core.dns.{SrvRecord => JSrvRecord}

/**
  * Represent a Service-Record (SRV) which was resolved for a domain.
  */
implicit class SrvRecordScala(val asJava: JSrvRecord) extends AnyVal {


  /**
    * Returns the priority for this service record.
    */
  def priority(): java.lang.Integer = {
    asJava.priority()
  }

  /**
    * Returns the weight of this service record.
    */
  def weight(): java.lang.Integer = {
    asJava.weight()
  }

  /**
    * Returns the port the service is running on.
    */
  def port(): java.lang.Integer = {
    asJava.port()
  }

  /**
    * Returns the name for the server being queried.
    */
  def name(): String = {
    asJava.name()
  }

  /**
    * Returns the protocol for the service being queried (i.e. "_tcp").
    */
  def protocol(): String = {
    asJava.protocol()
  }

  /**
    * Returns the service's name (i.e. "_http").
    */
  def service(): String = {
    asJava.service()
  }

  /**
    * Returns the name of the host for the service.
    */
  def target(): scala.Option[String] = {
    scala.Option(asJava.target())
  }

}

import io.vertx.core.streams.{StreamBase => JStreamBase}
import io.vertx.core.streams.StreamBase
import io.vertx.core.Handler

/**
  * Base interface for a stream.
  */
implicit class StreamBaseScala(val asJava: JStreamBase) extends AnyVal {


  /**
    * Set an exception handler.
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  def exceptionHandler(handler: scala.Option[Throwable => Unit]): JStreamBase = {
    asJava.exceptionHandler(handler match {case Some(t) => (p:Throwable) => t(p); case None => null})
  }

}

import io.vertx.core.net.JksOptions
import io.vertx.core.net.{PfxOptions => JPfxOptions}
import io.vertx.core.net.PfxOptions
import io.vertx.core.net.OpenSSLEngineOptions
import io.vertx.core.buffer.Buffer
import io.vertx.core.net.{OpenSSLEngineOptions => JOpenSSLEngineOptions}
import io.vertx.core.net.PemKeyCertOptions
import io.vertx.core.net.{JdkSSLEngineOptions => JJdkSSLEngineOptions}
import io.vertx.core.net.{PemTrustOptions => JPemTrustOptions}
import io.vertx.core.net.{TCPSSLOptions => JTCPSSLOptions}
import io.vertx.core.net.{PemKeyCertOptions => JPemKeyCertOptions}
import io.vertx.core.net.PemTrustOptions
import io.vertx.core.net.JdkSSLEngineOptions
import io.vertx.core.net.{JksOptions => JJksOptions}

/**
  * Base class. TCP and SSL related options
  */

  implicit class TCPSSLOptionsScala(val asJava: JTCPSSLOptions) extends AnyVal {


  /**
    * Add a CRL path
    */
    def addCrlPath(value: String) = {
      asJava.addCrlPath(value)
      }
    def getCrlPaths: scala.collection.mutable.Buffer[String] = {
      asJava.getCrlPaths().asScala
    }

  /**
    * Add a CRL value
    */
    def addCrlValue(value: io.vertx.core.buffer.Buffer) = {
      asJava.addCrlValue(value)
      }
    def getCrlValues: scala.collection.mutable.Buffer[io.vertx.core.buffer.Buffer] = {
      asJava.getCrlValues().asScala
    }

  /**
    * Add an enabled cipher suite, appended to the ordered suites.
    */
    def addEnabledCipherSuite(value: String) = {
      asJava.addEnabledCipherSuite(value)
      }
    def getEnabledCipherSuites: scala.collection.mutable.Set[String] = {
      asJava.getEnabledCipherSuites().asScala
    }

  /**
    * Sets the list of enabled SSL/TLS protocols.
    */
    def addEnabledSecureTransportProtocol(value: String) = {
      asJava.addEnabledSecureTransportProtocol(value)
      }
    def setEnabledSecureTransportProtocols(value: Set[String]) = {
      asJava.setEnabledSecureTransportProtocols(value.asJava)
    }
    def getEnabledSecureTransportProtocols: scala.collection.mutable.Set[String] = {
      asJava.getEnabledSecureTransportProtocols().asScala
    }

  /**
    * Set the idle timeout, in seconds. zero means don't timeout.
    * This determines if a connection will timeout and be closed if no data is received within the timeout.
    */
    def setIdleTimeout(value: java.lang.Integer) = {
      asJava.setIdleTimeout(value)
    }
    def getIdleTimeout: java.lang.Integer = {
      asJava.getIdleTimeout()
    }
    def setJdkSslEngineOptions(value: JJdkSSLEngineOptions) = {
      asJava.setJdkSslEngineOptions(value.asJava)
    }
    def getJdkSslEngineOptions: JJdkSSLEngineOptions = {
      asJava.getJdkSslEngineOptions()
    }

  /**
    * Set the key/cert options in jks format, aka Java keystore.
    */
    def setKeyStoreOptions(value: JJksOptions) = {
      asJava.setKeyStoreOptions(value.asJava)
    }
    def getKeyStoreOptions: JJksOptions = {
      asJava.getKeyStoreOptions()
    }

  /**
    * Set to true to enabled network activity logging: Netty's pipeline is configured for logging on Netty's logger.
    */
    def setLogActivity(value: java.lang.Boolean) = {
      asJava.setLogActivity(value)
    }
    def getLogActivity: java.lang.Boolean = {
      asJava.getLogActivity()
    }
    def setOpenSslEngineOptions(value: JOpenSSLEngineOptions) = {
      asJava.setOpenSslEngineOptions(value.asJava)
    }
    def getOpenSslEngineOptions: JOpenSSLEngineOptions = {
      asJava.getOpenSslEngineOptions()
    }

  /**
    * Set the key/cert store options in pem format.
    */
    def setPemKeyCertOptions(value: JPemKeyCertOptions) = {
      asJava.setPemKeyCertOptions(value.asJava)
    }
    def getPemKeyCertOptions: JPemKeyCertOptions = {
      asJava.getPemKeyCertOptions()
    }

  /**
    * Set the trust options in pem format
    */
    def setPemTrustOptions(value: JPemTrustOptions) = {
      asJava.setPemTrustOptions(value.asJava)
    }
    def getPemTrustOptions: JPemTrustOptions = {
      asJava.getPemTrustOptions()
    }

  /**
    * Set the key/cert options in pfx format.
    */
    def setPfxKeyCertOptions(value: JPfxOptions) = {
      asJava.setPfxKeyCertOptions(value.asJava)
    }
    def getPfxKeyCertOptions: JPfxOptions = {
      asJava.getPfxKeyCertOptions()
    }

  /**
    * Set the trust options in pfx format
    */
    def setPfxTrustOptions(value: JPfxOptions) = {
      asJava.setPfxTrustOptions(value.asJava)
    }
    def getPfxTrustOptions: JPfxOptions = {
      asJava.getPfxTrustOptions()
    }

  /**
    * Set the TCP receive buffer size
    */
    def setReceiveBufferSize(value: java.lang.Integer) = {
      asJava.setReceiveBufferSize(value)
    }
    def getReceiveBufferSize: java.lang.Integer = {
      asJava.getReceiveBufferSize()
    }

  /**
    * Set the value of reuse address
    */
    def setReuseAddress(value: java.lang.Boolean) = {
      asJava.setReuseAddress(value)
    }
    def isReuseAddress: java.lang.Boolean = {
      asJava.isReuseAddress()
    }

  /**
    * Set the value of reuse port.
    * <p/>
    * This is only supported by native transports.
    */
    def setReusePort(value: java.lang.Boolean) = {
      asJava.setReusePort(value)
    }
    def isReusePort: java.lang.Boolean = {
      asJava.isReusePort()
    }

  /**
    * Set the TCP send buffer size
    */
    def setSendBufferSize(value: java.lang.Integer) = {
      asJava.setSendBufferSize(value)
    }
    def getSendBufferSize: java.lang.Integer = {
      asJava.getSendBufferSize()
    }

  /**
    * Set whether SO_linger keep alive is enabled
    */
    def setSoLinger(value: java.lang.Integer) = {
      asJava.setSoLinger(value)
    }
    def getSoLinger: java.lang.Integer = {
      asJava.getSoLinger()
    }

  /**
    * Set whether SSL/TLS is enabled
    */
    def setSsl(value: java.lang.Boolean) = {
      asJava.setSsl(value)
    }
    def isSsl: java.lang.Boolean = {
      asJava.isSsl()
    }

  /**
    * Enable the `TCP_CORK` option - only with linux native transport.
    */
    def setTcpCork(value: java.lang.Boolean) = {
      asJava.setTcpCork(value)
    }
    def isTcpCork: java.lang.Boolean = {
      asJava.isTcpCork()
    }

  /**
    * Enable the `TCP_FASTOPEN` option - only with linux native transport.
    */
    def setTcpFastOpen(value: java.lang.Boolean) = {
      asJava.setTcpFastOpen(value)
    }
    def isTcpFastOpen: java.lang.Boolean = {
      asJava.isTcpFastOpen()
    }

  /**
    * Set whether TCP keep alive is enabled
    */
    def setTcpKeepAlive(value: java.lang.Boolean) = {
      asJava.setTcpKeepAlive(value)
    }
    def isTcpKeepAlive: java.lang.Boolean = {
      asJava.isTcpKeepAlive()
    }

  /**
    * Set whether TCP no delay is enabled
    */
    def setTcpNoDelay(value: java.lang.Boolean) = {
      asJava.setTcpNoDelay(value)
    }
    def isTcpNoDelay: java.lang.Boolean = {
      asJava.isTcpNoDelay()
    }

  /**
    * Enable the `TCP_QUICKACK` option - only with linux native transport.
    */
    def setTcpQuickAck(value: java.lang.Boolean) = {
      asJava.setTcpQuickAck(value)
    }
    def isTcpQuickAck: java.lang.Boolean = {
      asJava.isTcpQuickAck()
    }

  /**
    * Set the value of traffic class
    */
    def setTrafficClass(value: java.lang.Integer) = {
      asJava.setTrafficClass(value)
    }
    def getTrafficClass: java.lang.Integer = {
      asJava.getTrafficClass()
    }

  /**
    * Set the trust options in jks format, aka Java truststore
    */
    def setTrustStoreOptions(value: JJksOptions) = {
      asJava.setTrustStoreOptions(value.asJava)
    }
    def getTrustStoreOptions: JJksOptions = {
      asJava.getTrustStoreOptions()
    }

  /**
    * Set the ALPN usage.
    */
    def setUseAlpn(value: java.lang.Boolean) = {
      asJava.setUseAlpn(value)
    }
    def isUseAlpn: java.lang.Boolean = {
      asJava.isUseAlpn()
    }

  /**
    * Set whether Netty pooled buffers are enabled
    */
    def setUsePooledBuffers(value: java.lang.Boolean) = {
      asJava.setUsePooledBuffers(value)
    }
    def isUsePooledBuffers: java.lang.Boolean = {
      asJava.isUsePooledBuffers()
    }
  }
  


import io.vertx.core.TimeoutStream
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.core.streams.ReadStream
import io.vertx.core.Handler
import io.vertx.core.{TimeoutStream => JTimeoutStream}

/**
  * A timeout stream is triggered by a timer, the scala-function will be call when the timer is fired,
  * it can be once or several times depending on the nature of the timer related to this stream. The
  *  will be called after the timer handler has been called.
  * 
  * Pausing the timer inhibits the timer shots until the stream is resumed. Setting a null handler callback cancels
  * the timer.
  */
implicit class TimeoutStreamScala(val asJava: JTimeoutStream) extends AnyVal {


  def exceptionHandler(handler: scala.Option[Throwable => Unit]): JTimeoutStream = {
    asJava.exceptionHandler(handler match {case Some(t) => (p:Throwable) => t(p); case None => null})
  }

  def handler(handler: scala.Option[java.lang.Long => Unit]): JTimeoutStream = {
    asJava.handler(handler match {case Some(t) => (p:java.lang.Long) => t(p); case None => null})
  }

  def pause(): JTimeoutStream = {
    asJava.pause()
  }

  def resume(): JTimeoutStream = {
    asJava.resume()
  }

  def endHandler(endHandler: scala.Option[Void => Unit]): JTimeoutStream = {
    asJava.endHandler(endHandler match {case Some(t) => (p:Void) => t(p); case None => null})
  }

  /**
    * Cancels the timeout. Note this has the same effect as calling [[io.vertx.core.TimeoutStream#handler]] with a null
    * argument.
    */
  def cancel(): Unit = {
    asJava.cancel()
  }

}

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.{DeploymentOptions => JDeploymentOptions}
import io.vertx.core.http.HttpServer
import io.vertx.core.Context
import io.vertx.core.http.{HttpServerOptions => JHttpServerOptions}
import io.vertx.core.net.{NetServerOptions => JNetServerOptions}
import io.vertx.core.WorkerExecutor
import io.vertx.core.eventbus.EventBus
import io.vertx.core.dns.{DnsClient => JDnsClient}
import io.vertx.core.net.{NetClientOptions => JNetClientOptions}
import io.vertx.core.datagram.DatagramSocketOptions
import io.vertx.core.metrics.{Measured => JMeasured}
import io.vertx.core.VertxOptions
import scala.collection.JavaConverters._
import io.vertx.core.Future
import io.vertx.core.{Vertx => JVertx}
import io.vertx.core.net.NetClientOptions
import io.vertx.core.dns.DnsClient
import io.vertx.core.http.{HttpClient => JHttpClient}
import io.vertx.core.net.NetServerOptions
import io.vertx.core.{Context => JContext}
import io.vertx.core.metrics.Measured
import io.vertx.core.file.FileSystem
import io.vertx.core.http.HttpClient
import io.vertx.core.net.{NetServer => JNetServer}
import io.vertx.core.datagram.DatagramSocket
import io.vertx.core.dns.DnsClientOptions
import io.vertx.core.shareddata.SharedData
import io.vertx.core.TimeoutStream
import io.vertx.core.datagram.{DatagramSocket => JDatagramSocket}
import io.vertx.core.dns.{DnsClientOptions => JDnsClientOptions}
import io.vertx.core.AsyncResult
import io.vertx.core.http.HttpClientOptions
import io.vertx.core.net.NetClient
import io.vertx.core.{VertxOptions => JVertxOptions}
import io.vertx.core.eventbus.{EventBus => JEventBus}
import io.vertx.core.http.{HttpServer => JHttpServer}
import io.vertx.core.file.{FileSystem => JFileSystem}
import io.vertx.core.net.{NetClient => JNetClient}
import io.vertx.core.Vertx
import io.vertx.core.http.{HttpClientOptions => JHttpClientOptions}
import io.vertx.core.{WorkerExecutor => JWorkerExecutor}
import io.vertx.core.shareddata.{SharedData => JSharedData}
import io.vertx.core.datagram.{DatagramSocketOptions => JDatagramSocketOptions}
import io.vertx.core.net.NetServer
import io.vertx.core.DeploymentOptions
import io.vertx.core.{Future => JFuture}
import io.vertx.core.http.HttpServerOptions
import io.vertx.core.Handler
import io.vertx.core.{TimeoutStream => JTimeoutStream}

/**
  * The entry point into the Vert.x Core API.
  * 
  * You use an instance of this class for functionality including:
  * <ul>
  *   <li>Creating TCP clients and servers</li>
  *   <li>Creating HTTP clients and servers</li>
  *   <li>Creating DNS clients</li>
  *   <li>Creating Datagram sockets</li>
  *   <li>Setting and cancelling periodic and one-shot timers</li>
  *   <li>Getting a reference to the event bus API</li>
  *   <li>Getting a reference to the file system API</li>
  *   <li>Getting a reference to the shared data API</li>
  *   <li>Deploying and undeploying verticles</li>
  * </ul>
  * 
  * Most functionality in Vert.x core is fairly low level.
  * 
  * To create an instance of this class you can use the static factory methods: [[io.vertx.core.Vertx#vertx]],
  * [[io.vertx.core.Vertx#vertx]] and [[io.vertx.core.Vertx#clusteredVertxFuture]].
  * 
  * Please see the user manual for more detailed usage information.
  */
implicit class VertxScala(val asJava: JVertx) extends AnyVal {

  import io.vertx.lang.scala.ScalaVerticle;  /**
    * Deploy a verticle instance that you have created yourself.
    * <p>
    * Vert.x will assign the verticle a context and start the verticle.
    * <p>
    * The actual deploy happens asynchronously and may not complete until after the call has returned.
    *
    * @param verticle the verticle instance to deploy.
    */
  def deployVerticle(verticle: ScalaVerticle): Unit = {
    asJava.asInstanceOf[JVertx].deployVerticle(verticle.asJava)
  }

  /**
    * Like [[deployVerticle]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
    */
  def deployVerticleFuture(verticle: ScalaVerticle): scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JVertx].deployVerticle(verticle.asJava(), promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Like {@link #deployVerticle(Verticle)} but {@link io.vertx.core.DeploymentOptions} are provided to configure the
    * deployment.
    *
    * @param verticle the verticle instance to deploy
    * @param options  the deployment options.
    */
  def deployVerticle(verticle: ScalaVerticle, options: DeploymentOptions): Unit = {
    asJava.asInstanceOf[JVertx].deployVerticle(verticle.asJava, options.asJava)
  }

  /**
    * Like [[deployVerticle]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
    */
  def deployVerticleFuture(verticle: ScalaVerticle, options: DeploymentOptions): scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JVertx].deployVerticle(verticle.asJava(), options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Set a default exception handler for [[io.vertx.core.Context]], set on [[io.vertx.core.Context#exceptionHandler]] at creation.
    * @param handler the exception handler
    * @return a reference to this, so the API can be used fluently
    */
  def exceptionHandler(handler: scala.Option[Throwable => Unit]): JVertx = {
    asJava.exceptionHandler(handler match {case Some(t) => (p:Throwable) => t(p); case None => null})
  }

  /**
    * Whether the metrics are enabled for this measured object
    * @return true if the metrics are enabled
    */
  def isMetricsEnabled(): java.lang.Boolean = {
    asJava.isMetricsEnabled()
  }

  /**
    * Gets the current context, or creates one if there isn't one
    * @return The current context (created if didn't exist)
    */
  def getOrCreateContext(): JContext = {
    asJava.getOrCreateContext()
  }

  /**
    * Create a TCP/SSL server using the specified options
    * @param options the options to usesee <a href="../../../../../../cheatsheet/NetServerOptions.html">NetServerOptions</a>
    * @return the server
    */
  def createNetServer(options: JNetServerOptions): JNetServer = {
    asJava.createNetServer(options.asJava)
  }

  /**
    * Create a TCP/SSL server using default options
    * @return the server
    */
  def createNetServer(): JNetServer = {
    asJava.createNetServer()
  }

  /**
    * Create a TCP/SSL client using the specified options
    * @param options the options to usesee <a href="../../../../../../cheatsheet/NetClientOptions.html">NetClientOptions</a>
    * @return the client
    */
  def createNetClient(options: JNetClientOptions): JNetClient = {
    asJava.createNetClient(options.asJava)
  }

  /**
    * Create a TCP/SSL client using default options
    * @return the client
    */
  def createNetClient(): JNetClient = {
    asJava.createNetClient()
  }

  /**
    * Create an HTTP/HTTPS server using the specified options
    * @param options the options to usesee <a href="../../../../../../cheatsheet/HttpServerOptions.html">HttpServerOptions</a>
    * @return the server
    */
  def createHttpServer(options: JHttpServerOptions): JHttpServer = {
    asJava.createHttpServer(options.asJava)
  }

  /**
    * Create an HTTP/HTTPS server using default options
    * @return the server
    */
  def createHttpServer(): JHttpServer = {
    asJava.createHttpServer()
  }

  /**
    * Create a HTTP/HTTPS client using the specified options
    * @param options the options to usesee <a href="../../../../../../cheatsheet/HttpClientOptions.html">HttpClientOptions</a>
    * @return the client
    */
  def createHttpClient(options: JHttpClientOptions): JHttpClient = {
    asJava.createHttpClient(options.asJava)
  }

  /**
    * Create a HTTP/HTTPS client using default options
    * @return the client
    */
  def createHttpClient(): JHttpClient = {
    asJava.createHttpClient()
  }

  /**
    * Create a datagram socket using the specified options
    * @param options the options to usesee <a href="../../../../../../cheatsheet/DatagramSocketOptions.html">DatagramSocketOptions</a>
    * @return the socket
    */
  def createDatagramSocket(options: JDatagramSocketOptions): JDatagramSocket = {
    asJava.createDatagramSocket(options.asJava)
  }

  /**
    * Create a datagram socket using default options
    * @return the socket
    */
  def createDatagramSocket(): JDatagramSocket = {
    asJava.createDatagramSocket()
  }

  /**
    * Create a DNS client to connect to a DNS server at the specified host and port, with the default query timeout (5 seconds)
    * <p/>
    * @param port the port
    * @param host the host
    * @return the DNS client
    */
  def createDnsClient(port: java.lang.Integer, host: String): JDnsClient = {
    asJava.createDnsClient(port, host)
  }

  /**
    * Create a DNS client to connect to the DNS server configured by <a href="../../../../../../cheatsheet/VertxOptions.html">VertxOptions</a>
    * 
    * DNS client takes the first configured resolver address provided by `
    * @return the DNS client
    */
  def createDnsClient(): JDnsClient = {
    asJava.createDnsClient()
  }

  /**
    * Create a DNS client to connect to a DNS server
    * @param options the client optionssee <a href="../../../../../../cheatsheet/DnsClientOptions.html">DnsClientOptions</a>
    * @return the DNS client
    */
  def createDnsClient(options: JDnsClientOptions): JDnsClient = {
    asJava.createDnsClient(options.asJava)
  }

  /**
    * Set a one-shot timer to fire after `delay` milliseconds, at which point `handler` will be called with
    * the id of the timer.
    * @param delay the delay in milliseconds, after which the timer will fire
    * @param handler the handler that will be called with the timer ID when the timer fires
    * @return the unique ID of the timer
    */
  def setTimer(delay: java.lang.Long, handler: java.lang.Long => Unit): java.lang.Long = {
    asJava.setTimer(delay, (p:java.lang.Long) => handler(p))
  }

  /**
    * Returns a one-shot timer as a read stream. The timer will be fired after `delay` milliseconds after
    * the  has been called.
    * @param delay the delay in milliseconds, after which the timer will fire
    * @return the timer stream
    */
  def timerStream(delay: java.lang.Long): JTimeoutStream = {
    asJava.timerStream(delay)
  }

  /**
    * Set a periodic timer to fire every `delay` milliseconds, at which point `handler` will be called with
    * the id of the timer.
    * @param delay the delay in milliseconds, after which the timer will fire
    * @param handler the handler that will be called with the timer ID when the timer fires
    * @return the unique ID of the timer
    */
  def setPeriodic(delay: java.lang.Long, handler: java.lang.Long => Unit): java.lang.Long = {
    asJava.setPeriodic(delay, (p:java.lang.Long) => handler(p))
  }

  /**
    * Returns a periodic timer as a read stream. The timer will be fired every `delay` milliseconds after
    * the  has been called.
    * @param delay the delay in milliseconds, after which the timer will fire
    * @return the periodic stream
    */
  def periodicStream(delay: java.lang.Long): JTimeoutStream = {
    asJava.periodicStream(delay)
  }

  /**
    * Cancels the timer with the specified `id`.
    * @param id The id of the timer to cancel
    * @return true if the timer was successfully cancelled, or false if the timer does not exist.
    */
  def cancelTimer(id: java.lang.Long): java.lang.Boolean = {
    asJava.cancelTimer(id)
  }

  /**
    * Puts the handler on the event queue for the current context so it will be run asynchronously ASAP after all
    * preceeding events have been handled.
    * @param action - a handler representing the action to execute
    */
  def runOnContext(action: Void => Unit): Unit = {
    asJava.runOnContext((p:Void) => action(p))
  }

  /**
    * Stop the the Vertx instance and release any resources held by it.
    * 
    * The instance cannot be used after it has been closed.
    * 
    * The actual close is asynchronous and may not complete until after the call has returned.
    */
  def close(): Unit = {
    asJava.close()
  }

  /**
    * Like [[io.vertx.core.Vertx#close]] but the completionHandler will be called when the close is complete
    * @param completionHandler The handler will be notified when the close is complete.
    */
  def close(completionHandler: AsyncResult[Void] => Unit): Unit = {
    asJava.close((p:AsyncResult[Void]) => completionHandler(p))
  }

  /**
    * Deploy a verticle instance given a name.
    * 
    * Given the name, Vert.x selects a  instance to use to instantiate the verticle.
    * 
    * For the rules on how factories are selected please consult the user manual.
    * @param name the name.
    */
  def deployVerticle(name: String): Unit = {
    asJava.deployVerticle(name)
  }

  /**
    * Like [[io.vertx.core.Vertx#deployVerticle]] but the completionHandler will be notified when the deployment is complete.
    * 
    * If the deployment is successful the result will contain a String representing the unique deployment ID of the
    * deployment.
    * 
    * This deployment ID can subsequently be used to undeploy the verticle.
    * @param name The identifier
    * @param completionHandler a handler which will be notified when the deployment is complete
    */
  def deployVerticle(name: String, completionHandler: AsyncResult[String] => Unit): Unit = {
    asJava.deployVerticle(name, (p:AsyncResult[String]) => completionHandler(p))
  }

  /**
    * Like [[io.vertx.core.Vertx#deployVerticle]] but <a href="../../../../../../cheatsheet/DeploymentOptions.html">DeploymentOptions</a> are provided to configure the
    * deployment.
    * @param name the name
    * @param options the deployment options.see <a href="../../../../../../cheatsheet/DeploymentOptions.html">DeploymentOptions</a>
    */
  def deployVerticle(name: String, options: JDeploymentOptions): Unit = {
    asJava.deployVerticle(name, options.asJava)
  }

  /**
    * Like [[io.vertx.core.Vertx#deployVerticleFuture]] but <a href="../../../../../../cheatsheet/DeploymentOptions.html">DeploymentOptions</a> are provided to configure the
    * deployment.
    * @param name the name
    * @param options the deployment options.see <a href="../../../../../../cheatsheet/DeploymentOptions.html">DeploymentOptions</a>
    * @param completionHandler a handler which will be notified when the deployment is complete
    */
  def deployVerticle(name: String, options: JDeploymentOptions, completionHandler: AsyncResult[String] => Unit): Unit = {
    asJava.deployVerticle(name, options.asJava, (p:AsyncResult[String]) => completionHandler(p))
  }

  /**
    * Undeploy a verticle deployment.
    * 
    * The actual undeployment happens asynchronously and may not complete until after the method has returned.
    * @param deploymentID the deployment ID
    */
  def undeploy(deploymentID: String): Unit = {
    asJava.undeploy(deploymentID)
  }

  /**
    * Like [[io.vertx.core.Vertx]] but the completionHandler will be notified when the undeployment is complete.
    * @param deploymentID the deployment ID
    * @param completionHandler a handler which will be notified when the undeployment is complete
    */
  def undeploy(deploymentID: String, completionHandler: AsyncResult[Void] => Unit): Unit = {
    asJava.undeploy(deploymentID, (p:AsyncResult[Void]) => completionHandler(p))
  }

  /**
    * Return a Set of deployment IDs for the currently deployed deploymentIDs.
    * @return Set of deployment IDs
    */
  def deploymentIDs(): Set[String] = {
    asJava.deploymentIDs().asScala.toSet
  }

  /**
    * Is this Vert.x instance clustered?
    * @return true if clustered
    */
  def isClustered(): java.lang.Boolean = {
    asJava.isClustered()
  }

  /**
    * Safely execute some blocking code.
    *
    * Executes the blocking code in the handler `blockingCodeHandler` using a thread from the worker pool.
    *
    * When the code is complete the returned Future will be completed with the result.
    *
    * @param blockingFunction function containing blocking code
    * @param ordered if true then if executeBlocking is called several times on the same context, the executions for that context will be executed serially, not in parallel. if false then they will be no ordering guarantees
    * @return a Future representing the result of the blocking operation
    */
  def executeBlocking[T](blockingFunction: () => T, ordered: Boolean = true): concurrent.Future[T] = {
    val promise = concurrent.Promise[T]
    val h: Handler[io.vertx.core.Future[T]] = {f => util.Try(blockingFunction()) match {
      case util.Success(s) => f.complete(s)
      case util.Failure(t) => f.fail(t)
    }}
    asJava.asInstanceOf[JVertx].executeBlocking[T](h, ordered, {h:AsyncResult[T] => {if (h.succeeded()) promise.success(h.result()) else promise.failure(h.cause());()} })
    promise.future
  }

  /**
    * Like [[io.vertx.core.Vertx#createSharedWorkerExecutor]] but with the <a href="../../../../../../cheatsheet/VertxOptions.html">VertxOptions</a> `poolSize`.
    */
  def createSharedWorkerExecutor(name: String): JWorkerExecutor = {
    asJava.createSharedWorkerExecutor(name)
  }

  /**
    * Like [[io.vertx.core.Vertx#createSharedWorkerExecutor]] but with the <a href="../../../../../../cheatsheet/VertxOptions.html">VertxOptions</a> `maxExecuteTime`.
    */
  def createSharedWorkerExecutor(name: String, poolSize: java.lang.Integer): JWorkerExecutor = {
    asJava.createSharedWorkerExecutor(name, poolSize)
  }

  /**
    * Create a named worker executor, the executor should be closed when it's not needed anymore to release
    * resources.<p/>
    *
    * This method can be called mutiple times with the same `name`. Executors with the same name will share
    * the same worker pool. The worker pool size and max execute time are set when the worker pool is created and
    * won't change after.
    *
    * The worker pool is released when all the [[io.vertx.core.WorkerExecutor]] sharing the same name are closed.
    * @param name the name of the worker executor
    * @param poolSize the size of the pool
    * @param maxExecuteTime the value of max worker execute time, in ns
    * @return the named worker executor
    */
  def createSharedWorkerExecutor(name: String, poolSize: java.lang.Integer, maxExecuteTime: java.lang.Long): JWorkerExecutor = {
    asJava.createSharedWorkerExecutor(name, poolSize, maxExecuteTime)
  }

  /**
    * Get the filesystem object. There is a single instance of FileSystem per Vertx instance.
    * @return the filesystem object
    */
  def fileSystem(): JFileSystem = {
    asJava.fileSystem()
  }

  /**
    * Get the event bus object. There is a single instance of EventBus per Vertx instance.
    * @return the event bus object
    */
  def eventBus(): JEventBus = {
    asJava.eventBus()
  }

  /**
    * Get the shared data object. There is a single instance of SharedData per Vertx instance.
    * @return the shared data object
    */
  def sharedData(): JSharedData = {
    asJava.sharedData()
  }

  /**
    * @return wether the native transport is used
    */
  def isNativeTransportEnabled(): java.lang.Boolean = {
    asJava.isNativeTransportEnabled()
  }

 /**
   * Like [[close]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def closeFuture(): scala.concurrent.Future[Unit] = {
    val promise = Promise[Unit]()
    asJava.close({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[deployVerticle]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def deployVerticleFuture(name: String): scala.concurrent.Future[String] = {
    val promise = Promise[String]()
    asJava.deployVerticle(name, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[deployVerticle]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def deployVerticleFuture(name: String, options: JDeploymentOptions): scala.concurrent.Future[String] = {
    val promise = Promise[String]()
    asJava.deployVerticle(name, options, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[undeploy]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def undeployFuture(deploymentID: String): scala.concurrent.Future[Unit] = {
    val promise = Promise[Unit]()
    asJava.undeploy(deploymentID, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

}

import io.vertx.core.dns.{AddressResolverOptions => JAddressResolverOptions}
import io.vertx.core.metrics.{MetricsOptions => JMetricsOptions}
import io.vertx.core.metrics.MetricsOptions
import io.vertx.core.eventbus.{EventBusOptions => JEventBusOptions}
import io.vertx.core.eventbus.EventBusOptions
import io.vertx.core.{VertxOptions => JVertxOptions}
import io.vertx.core.dns.AddressResolverOptions

/**
  * Instances of this class are used to configure [[io.vertx.core.Vertx]] instances.
  */

  implicit class VertxOptionsScala(val asJava: JVertxOptions) extends AnyVal {


  /**
    * Sets the address resolver configuration to configure resolving DNS servers, cache TTL, etc...
    */
    def setAddressResolverOptions(value: JAddressResolverOptions) = {
      asJava.setAddressResolverOptions(value.asJava)
    }
    def getAddressResolverOptions: JAddressResolverOptions = {
      asJava.getAddressResolverOptions()
    }

  /**
    * Sets the value of blocked thread check period, in ms.
    */
    def setBlockedThreadCheckInterval(value: java.lang.Long) = {
      asJava.setBlockedThreadCheckInterval(value)
    }
    def getBlockedThreadCheckInterval: java.lang.Long = {
      asJava.getBlockedThreadCheckInterval()
    }

  /**
    * Set the hostname to be used for clustering.
    */
    def setClusterHost(value: String) = {
      asJava.setClusterHost(value)
    }
    def getClusterHost: String = {
      asJava.getClusterHost()
    }

  /**
    * Set the value of cluster ping interval, in ms.
    */
    def setClusterPingInterval(value: java.lang.Long) = {
      asJava.setClusterPingInterval(value)
    }
    def getClusterPingInterval: java.lang.Long = {
      asJava.getClusterPingInterval()
    }

  /**
    * Set the value of cluster ping reply interval, in ms.
    */
    def setClusterPingReplyInterval(value: java.lang.Long) = {
      asJava.setClusterPingReplyInterval(value)
    }
    def getClusterPingReplyInterval: java.lang.Long = {
      asJava.getClusterPingReplyInterval()
    }

  /**
    * Set the port to be used for clustering.
    */
    def setClusterPort(value: java.lang.Integer) = {
      asJava.setClusterPort(value)
    }
    def getClusterPort: java.lang.Integer = {
      asJava.getClusterPort()
    }

  /**
    * Set the public facing hostname to be used for clustering.
    * Sometimes, e.g. when running on certain clouds, the local address the server listens on for clustering is not the same
    * address that other nodes connect to it at, as the OS / cloud infrastructure does some kind of proxying.
    * If this is the case you can specify a public hostname which is different from the hostname the server listens at.
    * The default value is null which means use the same as the cluster hostname.
    */
    def setClusterPublicHost(value: String) = {
      asJava.setClusterPublicHost(value)
    }
    def getClusterPublicHost: String = {
      asJava.getClusterPublicHost()
    }

  /**
    * See <a href="../../../../../../cheatsheet/VertxOptions.html">VertxOptions</a> for an explanation.
    */
    def setClusterPublicPort(value: java.lang.Integer) = {
      asJava.setClusterPublicPort(value)
    }
    def getClusterPublicPort: java.lang.Integer = {
      asJava.getClusterPublicPort()
    }

  /**
    * Set whether or not the Vert.x instance will be clustered.
    */
    def setClustered(value: java.lang.Boolean) = {
      asJava.setClustered(value)
    }
    def isClustered: java.lang.Boolean = {
      asJava.isClustered()
    }

  /**
    * Sets the event bus configuration to configure the host, port, ssl...
    */
    def setEventBusOptions(value: JEventBusOptions) = {
      asJava.setEventBusOptions(value.asJava)
    }
    def getEventBusOptions: JEventBusOptions = {
      asJava.getEventBusOptions()
    }

  /**
    * Set the number of event loop threads to be used by the Vert.x instance.
    */
    def setEventLoopPoolSize(value: java.lang.Integer) = {
      asJava.setEventLoopPoolSize(value)
    }
    def getEventLoopPoolSize: java.lang.Integer = {
      asJava.getEventLoopPoolSize()
    }

  /**
    * Set wether the Vert.x file resolver uses caching for classpath resources.
    */
    def setFileResolverCachingEnabled(value: java.lang.Boolean) = {
      asJava.setFileResolverCachingEnabled(value)
    }
    def isFileResolverCachingEnabled: java.lang.Boolean = {
      asJava.isFileResolverCachingEnabled()
    }

  /**
    * Set whether HA will be enabled on the Vert.x instance.
    */
    def setHAEnabled(value: java.lang.Boolean) = {
      asJava.setHAEnabled(value)
    }
    def isHAEnabled: java.lang.Boolean = {
      asJava.isHAEnabled()
    }

  /**
    * Set the HA group to be used when HA is enabled.
    */
    def setHAGroup(value: String) = {
      asJava.setHAGroup(value)
    }
    def getHAGroup: String = {
      asJava.getHAGroup()
    }

  /**
    * Set the value of internal blocking pool size
    */
    def setInternalBlockingPoolSize(value: java.lang.Integer) = {
      asJava.setInternalBlockingPoolSize(value)
    }
    def getInternalBlockingPoolSize: java.lang.Integer = {
      asJava.getInternalBlockingPoolSize()
    }

  /**
    * Sets the value of max event loop execute time, in ns.
    */
    def setMaxEventLoopExecuteTime(value: java.lang.Long) = {
      asJava.setMaxEventLoopExecuteTime(value)
    }
    def getMaxEventLoopExecuteTime: java.lang.Long = {
      asJava.getMaxEventLoopExecuteTime()
    }

  /**
    * Sets the value of max worker execute time, in ns.
    */
    def setMaxWorkerExecuteTime(value: java.lang.Long) = {
      asJava.setMaxWorkerExecuteTime(value)
    }
    def getMaxWorkerExecuteTime: java.lang.Long = {
      asJava.getMaxWorkerExecuteTime()
    }

  /**
    * Set the metrics options
    */
    def setMetricsOptions(value: JMetricsOptions) = {
      asJava.setMetricsOptions(value.asJava)
    }
    def getMetricsOptions: JMetricsOptions = {
      asJava.getMetricsOptions()
    }

  /**
    * Set wether to prefer the native transport to the JDK transport.
    */
    def setPreferNativeTransport(value: java.lang.Boolean) = {
      asJava.setPreferNativeTransport(value)
    }
    def getPreferNativeTransport: java.lang.Boolean = {
      asJava.getPreferNativeTransport()
    }

  /**
    * Set the quorum size to be used when HA is enabled.
    */
    def setQuorumSize(value: java.lang.Integer) = {
      asJava.setQuorumSize(value)
    }
    def getQuorumSize: java.lang.Integer = {
      asJava.getQuorumSize()
    }

  /**
    * Set the threshold value above this, the blocked warning contains a stack trace.
    */
    def setWarningExceptionTime(value: java.lang.Long) = {
      asJava.setWarningExceptionTime(value)
    }
    def getWarningExceptionTime: java.lang.Long = {
      asJava.getWarningExceptionTime()
    }

  /**
    * Set the maximum number of worker threads to be used by the Vert.x instance.
    */
    def setWorkerPoolSize(value: java.lang.Integer) = {
      asJava.setWorkerPoolSize(value)
    }
    def getWorkerPoolSize: java.lang.Integer = {
      asJava.getWorkerPoolSize()
    }
  }
  
  type VertxOptions = JVertxOptions
  object VertxOptions {
    def apply(): JVertxOptions = new VertxOptions()
    def apply(json: JsonObject) = new JVertxOptions(json)
  }


import io.vertx.core.http.WebSocketBase
import io.vertx.core.buffer.Buffer
import io.vertx.core.http.{WebSocketBase => JWebSocketBase}
import io.vertx.core.http.{WebSocket => JWebSocket}
import io.vertx.core.http.{WebSocketFrame => JWebSocketFrame}
import io.vertx.core.net.{SocketAddress => JSocketAddress}
import io.vertx.core.http.WebSocket
import io.vertx.core.Handler
import io.vertx.core.http.WebSocketFrame
import io.vertx.core.net.SocketAddress

/**
  * Represents a client-side WebSocket.
  */
implicit class WebSocketScala(val asJava: JWebSocket) extends AnyVal {


  /**
    * Writes a ping to the connection. This will be written in a single frame. Ping frames may be at most 125 bytes (octets).
    * 
    * This method should not be used to write application data and should only be used for implementing a keep alive or
    * to ensure the client is still responsive, see RFC 6455 Section 5.5.2.
    * 
    * There is no pingHandler because RFC 6455 section 5.5.2 clearly states that the only response to a ping is a pong
    * with identical contents.
    * @param data the data to write, may be at most 125 bytes
    * @return a reference to this, so the API can be used fluently
    */
  def writePing(data: io.vertx.core.buffer.Buffer): JWebSocketBase = {
    asJava.writePing(data)
  }

  /**
    * Writes a pong to the connection. This will be written in a single frame. Pong frames may be at most 125 bytes (octets).
    * 
    * This method should not be used to write application data and should only be used for implementing a keep alive or
    * to ensure the client is still responsive, see RFC 6455 Section 5.5.2.
    * 
    * There is no need to manually write a Pong, as the server and client both handle responding to a ping with a pong
    * automatically and this is exposed to users.RFC 6455 Section 5.5.3 states that pongs may be sent unsolicited in order
    * to implement a one way heartbeat.
    * @param data the data to write, may be at most 125 bytes
    * @return a reference to this, so the API can be used fluently
    */
  def writePong(data: io.vertx.core.buffer.Buffer): JWebSocketBase = {
    asJava.writePong(data)
  }

  /**
    * Set a text message handler on the connection. This handler will be called similar to the
    * [[io.vertx.core.http.WebSocketBase#binaryMessageHandler]], but the buffer will be converted to a String first
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  def textMessageHandler(handler: scala.Option[String => Unit]): JWebSocketBase = {
    asJava.textMessageHandler(handler match {case Some(t) => (p:String) => t(p); case None => null})
  }

  /**
    * Set a binary message handler on the connection. This handler serves a similar purpose to [[io.vertx.core.http.WebSocket#handler]]
    * except that if a message comes into the socket in multiple frames, the data from the frames will be aggregated
    * into a single buffer before calling the handler (using [[io.vertx.core.http.WebSocketFrame#isFinal]] to find the boundaries).
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  def binaryMessageHandler(handler: scala.Option[io.vertx.core.buffer.Buffer => Unit]): JWebSocketBase = {
    asJava.binaryMessageHandler(handler match {case Some(t) => (p:io.vertx.core.buffer.Buffer) => t(p); case None => null})
  }

  /**
    * Set a pong message handler on the connection.  This handler will be invoked every time a pong message is received
    * on the server, and can be used by both clients and servers since the RFC 6455 Sections 5.5.2 and 5.5.3 do not
    * specify whether the client or server sends a ping.
    * 
    * Pong frames may be at most 125 bytes (octets).
    * 
    * There is no ping handler since pings should immediately be responded to with a pong with identical content
    * 
    * Pong frames may be received unsolicited.
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  def pongHandler(handler: scala.Option[io.vertx.core.buffer.Buffer => Unit]): JWebSocketBase = {
    asJava.pongHandler(handler match {case Some(t) => (p:io.vertx.core.buffer.Buffer) => t(p); case None => null})
  }

  def exceptionHandler(handler: scala.Option[Throwable => Unit]): JWebSocket = {
    asJava.exceptionHandler(handler match {case Some(t) => (p:Throwable) => t(p); case None => null})
  }

  def handler(handler: scala.Option[io.vertx.core.buffer.Buffer => Unit]): JWebSocket = {
    asJava.handler(handler match {case Some(t) => (p:io.vertx.core.buffer.Buffer) => t(p); case None => null})
  }

  def pause(): JWebSocket = {
    asJava.pause()
  }

  def resume(): JWebSocket = {
    asJava.resume()
  }

  def endHandler(endHandler: scala.Option[Void => Unit]): JWebSocket = {
    asJava.endHandler(endHandler match {case Some(t) => (p:Void) => t(p); case None => null})
  }

  def write(data: io.vertx.core.buffer.Buffer): JWebSocket = {
    asJava.write(data)
  }

  def setWriteQueueMaxSize(maxSize: java.lang.Integer): JWebSocket = {
    asJava.setWriteQueueMaxSize(maxSize)
  }

  def drainHandler(handler: scala.Option[Void => Unit]): JWebSocket = {
    asJava.drainHandler(handler match {case Some(t) => (p:Void) => t(p); case None => null})
  }

  def writeFrame(frame: JWebSocketFrame): JWebSocket = {
    asJava.writeFrame(frame.asJava)
  }

  def writeFinalTextFrame(text: String): JWebSocket = {
    asJava.writeFinalTextFrame(text)
  }

  def writeFinalBinaryFrame(data: io.vertx.core.buffer.Buffer): JWebSocket = {
    asJava.writeFinalBinaryFrame(data)
  }

  def writeBinaryMessage(data: io.vertx.core.buffer.Buffer): JWebSocket = {
    asJava.writeBinaryMessage(data)
  }

  def writeTextMessage(text: String): JWebSocket = {
    asJava.writeTextMessage(text)
  }

  def closeHandler(handler: scala.Option[Void => Unit]): JWebSocket = {
    asJava.closeHandler(handler match {case Some(t) => (p:Void) => t(p); case None => null})
  }

  def frameHandler(handler: scala.Option[JWebSocketFrame => Unit]): JWebSocket = {
    asJava.frameHandler(handler match {case Some(t) => (p:JWebSocketFrame) => t(p); case None => null})
  }

  /**
    * Same as [[io.vertx.core.http.WebSocketBase#end]] but writes some data to the stream before ending.
    */
  def end(t: io.vertx.core.buffer.Buffer): Unit = {
    asJava.end(t)
  }

  /**
    * This will return `true` if there are more bytes in the write queue than the value set using [[io.vertx.core.http.WebSocket#setWriteQueueMaxSize]]
    * @return true if write queue is full
    */
  def writeQueueFull(): java.lang.Boolean = {
    asJava.writeQueueFull()
  }

  /**
    * When a `Websocket` is created it automatically registers an event handler with the event bus - the ID of that
    * handler is given by this method.
    * 
    * Given this ID, a different event loop can send a binary frame to that event handler using the event bus and
    * that buffer will be received by this instance in its own event loop and written to the underlying connection. This
    * allows you to write data to other WebSockets which are owned by different event loops.
    * @return the binary handler id
    */
  def binaryHandlerID(): String = {
    asJava.binaryHandlerID()
  }

  /**
    * When a `Websocket` is created it automatically registers an event handler with the eventbus, the ID of that
    * handler is given by `textHandlerID`.
    * 
    * Given this ID, a different event loop can send a text frame to that event handler using the event bus and
    * that buffer will be received by this instance in its own event loop and written to the underlying connection. This
    * allows you to write data to other WebSockets which are owned by different event loops.
    */
  def textHandlerID(): String = {
    asJava.textHandlerID()
  }

  /**
    * Returns the websocket sub protocol selected by the websocket handshake.
    * <p/>
    * On the server, the value will be `null` when the handler receives the websocket callback as the
    * handshake will not be completed yet.
    */
  def subProtocol(): String = {
    asJava.subProtocol()
  }

  /**
    * Calls [[io.vertx.core.http.WebSocketBase#close]]
    */
  def end(): Unit = {
    asJava.end()
  }

  /**
    * Close the WebSocket.
    */
  def close(): Unit = {
    asJava.close()
  }

  def close(statusCode: java.lang.Short): Unit = {
    asJava.close(statusCode)
  }

  def close(statusCode: java.lang.Short, reason: scala.Option[String]): Unit = {
    asJava.close(statusCode, reason.orNull)
  }

  /**
    * @return true if this io.vertx.core.http.HttpConnection is encrypted via SSL/TLS.
    */
  def isSsl(): java.lang.Boolean = {
    asJava.isSsl()
  }

  /**
    * @return the remote address for this socket
    */
  def remoteAddress(): JSocketAddress = {
    asJava.remoteAddress()
  }

  /**
    * @return the local address for this socket
    */
  def localAddress(): JSocketAddress = {
    asJava.localAddress()
  }

}

import io.vertx.core.buffer.Buffer
import io.vertx.core.http.WebSocketBase
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.core.http.{WebSocketBase => JWebSocketBase}
import io.vertx.core.streams.WriteStream
import io.vertx.core.streams.ReadStream
import io.vertx.core.http.{WebSocketFrame => JWebSocketFrame}
import io.vertx.core.net.{SocketAddress => JSocketAddress}
import io.vertx.core.Handler
import io.vertx.core.streams.{WriteStream => JWriteStream}
import io.vertx.core.http.WebSocketFrame
import io.vertx.core.net.SocketAddress

/**
  * Base WebSocket implementation.
  * 
  * It implements both  and  so it can be used with
  * [[io.vertx.core.streams.Pump]] to pump data with flow control.
  */
implicit class WebSocketBaseScala(val asJava: JWebSocketBase) extends AnyVal {


  def exceptionHandler(handler: scala.Option[Throwable => Unit]): JWebSocketBase = {
    asJava.exceptionHandler(handler match {case Some(t) => (p:Throwable) => t(p); case None => null})
  }

  def handler(handler: scala.Option[io.vertx.core.buffer.Buffer => Unit]): JWebSocketBase = {
    asJava.handler(handler match {case Some(t) => (p:io.vertx.core.buffer.Buffer) => t(p); case None => null})
  }

  def pause(): JWebSocketBase = {
    asJava.pause()
  }

  def resume(): JWebSocketBase = {
    asJava.resume()
  }

  def endHandler(endHandler: scala.Option[Void => Unit]): JWebSocketBase = {
    asJava.endHandler(endHandler match {case Some(t) => (p:Void) => t(p); case None => null})
  }

  def write(data: io.vertx.core.buffer.Buffer): JWebSocketBase = {
    asJava.write(data)
  }

  def setWriteQueueMaxSize(maxSize: java.lang.Integer): JWebSocketBase = {
    asJava.setWriteQueueMaxSize(maxSize)
  }

  def drainHandler(handler: scala.Option[Void => Unit]): JWebSocketBase = {
    asJava.drainHandler(handler match {case Some(t) => (p:Void) => t(p); case None => null})
  }

  /**
    * Write a WebSocket frame to the connection
    * @param frame the frame to write
    * @return a reference to this, so the API can be used fluently
    */
  def writeFrame(frame: JWebSocketFrame): JWebSocketBase = {
    asJava.writeFrame(frame.asJava)
  }

  /**
    * Write a final WebSocket text frame to the connection
    * @param text The text to write
    * @return a reference to this, so the API can be used fluently
    */
  def writeFinalTextFrame(text: String): JWebSocketBase = {
    asJava.writeFinalTextFrame(text)
  }

  /**
    * Write a final WebSocket binary frame to the connection
    * @param data The data to write
    * @return a reference to this, so the API can be used fluently
    */
  def writeFinalBinaryFrame(data: io.vertx.core.buffer.Buffer): JWebSocketBase = {
    asJava.writeFinalBinaryFrame(data)
  }

  /**
    * Writes a (potentially large) piece of binary data to the connection. This data might be written as multiple frames
    * if it exceeds the maximum WebSocket frame size.
    * @param data the data to write
    * @return a reference to this, so the API can be used fluently
    */
  def writeBinaryMessage(data: io.vertx.core.buffer.Buffer): JWebSocketBase = {
    asJava.writeBinaryMessage(data)
  }

  /**
    * Writes a (potentially large) piece of text data to the connection. This data might be written as multiple frames
    * if it exceeds the maximum WebSocket frame size.
    * @param text the data to write
    * @return a reference to this, so the API can be used fluently
    */
  def writeTextMessage(text: String): JWebSocketBase = {
    asJava.writeTextMessage(text)
  }

  /**
    * Writes a ping to the connection. This will be written in a single frame. Ping frames may be at most 125 bytes (octets).
    * 
    * This method should not be used to write application data and should only be used for implementing a keep alive or
    * to ensure the client is still responsive, see RFC 6455 Section 5.5.2.
    * 
    * There is no pingHandler because RFC 6455 section 5.5.2 clearly states that the only response to a ping is a pong
    * with identical contents.
    * @param data the data to write, may be at most 125 bytes
    * @return a reference to this, so the API can be used fluently
    */
  def writePing(data: io.vertx.core.buffer.Buffer): JWebSocketBase = {
    asJava.writePing(data)
  }

  /**
    * Writes a pong to the connection. This will be written in a single frame. Pong frames may be at most 125 bytes (octets).
    * 
    * This method should not be used to write application data and should only be used for implementing a keep alive or
    * to ensure the client is still responsive, see RFC 6455 Section 5.5.2.
    * 
    * There is no need to manually write a Pong, as the server and client both handle responding to a ping with a pong
    * automatically and this is exposed to users.RFC 6455 Section 5.5.3 states that pongs may be sent unsolicited in order
    * to implement a one way heartbeat.
    * @param data the data to write, may be at most 125 bytes
    * @return a reference to this, so the API can be used fluently
    */
  def writePong(data: io.vertx.core.buffer.Buffer): JWebSocketBase = {
    asJava.writePong(data)
  }

  /**
    * Set a close handler. This will be called when the WebSocket is closed.
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  def closeHandler(handler: scala.Option[Void => Unit]): JWebSocketBase = {
    asJava.closeHandler(handler match {case Some(t) => (p:Void) => t(p); case None => null})
  }

  /**
    * Set a frame handler on the connection. This handler will be called when frames are read on the connection.
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  def frameHandler(handler: scala.Option[JWebSocketFrame => Unit]): JWebSocketBase = {
    asJava.frameHandler(handler match {case Some(t) => (p:JWebSocketFrame) => t(p); case None => null})
  }

  /**
    * Set a text message handler on the connection. This handler will be called similar to the
    * [[io.vertx.core.http.WebSocketBase#binaryMessageHandler]], but the buffer will be converted to a String first
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  def textMessageHandler(handler: scala.Option[String => Unit]): JWebSocketBase = {
    asJava.textMessageHandler(handler match {case Some(t) => (p:String) => t(p); case None => null})
  }

  /**
    * Set a binary message handler on the connection. This handler serves a similar purpose to [[io.vertx.core.http.WebSocketBase#handler]]
    * except that if a message comes into the socket in multiple frames, the data from the frames will be aggregated
    * into a single buffer before calling the handler (using [[io.vertx.core.http.WebSocketFrame#isFinal]] to find the boundaries).
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  def binaryMessageHandler(handler: scala.Option[io.vertx.core.buffer.Buffer => Unit]): JWebSocketBase = {
    asJava.binaryMessageHandler(handler match {case Some(t) => (p:io.vertx.core.buffer.Buffer) => t(p); case None => null})
  }

  /**
    * Set a pong message handler on the connection.  This handler will be invoked every time a pong message is received
    * on the server, and can be used by both clients and servers since the RFC 6455 Sections 5.5.2 and 5.5.3 do not
    * specify whether the client or server sends a ping.
    * 
    * Pong frames may be at most 125 bytes (octets).
    * 
    * There is no ping handler since pings should immediately be responded to with a pong with identical content
    * 
    * Pong frames may be received unsolicited.
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  def pongHandler(handler: scala.Option[io.vertx.core.buffer.Buffer => Unit]): JWebSocketBase = {
    asJava.pongHandler(handler match {case Some(t) => (p:io.vertx.core.buffer.Buffer) => t(p); case None => null})
  }

  /**
    * Same as [[io.vertx.core.http.WebSocketBase#end]] but writes some data to the stream before ending.
    */
  def end(t: io.vertx.core.buffer.Buffer): Unit = {
    asJava.end(t)
  }

  /**
    * This will return `true` if there are more bytes in the write queue than the value set using [[io.vertx.core.http.WebSocketBase#setWriteQueueMaxSize]]
    * @return true if write queue is full
    */
  def writeQueueFull(): java.lang.Boolean = {
    asJava.writeQueueFull()
  }

  /**
    * When a `Websocket` is created it automatically registers an event handler with the event bus - the ID of that
    * handler is given by this method.
    * 
    * Given this ID, a different event loop can send a binary frame to that event handler using the event bus and
    * that buffer will be received by this instance in its own event loop and written to the underlying connection. This
    * allows you to write data to other WebSockets which are owned by different event loops.
    * @return the binary handler id
    */
  def binaryHandlerID(): String = {
    asJava.binaryHandlerID()
  }

  /**
    * When a `Websocket` is created it automatically registers an event handler with the eventbus, the ID of that
    * handler is given by `textHandlerID`.
    * 
    * Given this ID, a different event loop can send a text frame to that event handler using the event bus and
    * that buffer will be received by this instance in its own event loop and written to the underlying connection. This
    * allows you to write data to other WebSockets which are owned by different event loops.
    */
  def textHandlerID(): String = {
    asJava.textHandlerID()
  }

  /**
    * Returns the websocket sub protocol selected by the websocket handshake.
    * <p/>
    * On the server, the value will be `null` when the handler receives the websocket callback as the
    * handshake will not be completed yet.
    */
  def subProtocol(): String = {
    asJava.subProtocol()
  }

  /**
    * Calls [[io.vertx.core.http.WebSocketBase#close]]
    */
  def end(): Unit = {
    asJava.end()
  }

  /**
    * Close the WebSocket.
    */
  def close(): Unit = {
    asJava.close()
  }

  def close(statusCode: java.lang.Short): Unit = {
    asJava.close(statusCode)
  }

  def close(statusCode: java.lang.Short, reason: scala.Option[String]): Unit = {
    asJava.close(statusCode, reason.orNull)
  }

  /**
    * @return true if this io.vertx.core.http.HttpConnection is encrypted via SSL/TLS.
    */
  def isSsl(): java.lang.Boolean = {
    asJava.isSsl()
  }

  /**
    * @return the remote address for this socket
    */
  def remoteAddress(): JSocketAddress = {
    asJava.remoteAddress()
  }

  /**
    * @return the local address for this socket
    */
  def localAddress(): JSocketAddress = {
    asJava.localAddress()
  }

}

import io.vertx.core.buffer.Buffer
import io.vertx.core.http.{WebSocketFrame => JWebSocketFrame}
import io.vertx.core.http.WebSocketFrame

/**
  * A WebSocket frame that represents either text or binary data.
  * 
  * A WebSocket message is composed of one or more WebSocket frames.
  * 
  * If there is a just a single frame in the message then a single text or binary frame should be created with final = true.
  * 
  * If there are more than one frames in the message, then the first frame should be a text or binary frame with
  * final = false, followed by one or more continuation frames. The last continuation frame should have final = true.
  */
implicit class WebSocketFrameScala(val asJava: JWebSocketFrame) extends AnyVal {


  /**
    * @return true if it's a text frame
    */
  def isText(): java.lang.Boolean = {
    asJava.isText()
  }

  /**
    * @return true if it's a binary frame
    */
  def isBinary(): java.lang.Boolean = {
    asJava.isBinary()
  }

  /**
    * @return true if it's a continuation frame
    */
  def isContinuation(): java.lang.Boolean = {
    asJava.isContinuation()
  }

  /**
    * @return true if it's close frame
    */
  def isClose(): java.lang.Boolean = {
    asJava.isClose()
  }

  /**
    * @return true if this is the final frame.
    */
  def isFinal(): java.lang.Boolean = {
    asJava.isFinal()
  }

  /**
    * @return status code of close frame. Only use this for close frames
    */
  def closeStatusCode(): java.lang.Short = {
    asJava.closeStatusCode()
  }

  /**
    * @return string explaining close reason. Only use this for close frames
    */
  def closeReason(): String = {
    asJava.closeReason()
  }

  /**
    * @return the content of this frame as a UTF-8 string and returns the converted string. Only use this for text frames.
    */
  def textData(): String = {
    asJava.textData()
  }

  /**
    * @return the data of the frame
    */
  def binaryData(): io.vertx.core.buffer.Buffer = {
    asJava.binaryData()
  }

}

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.metrics.{Measured => JMeasured}
import io.vertx.core.metrics.Measured
import io.vertx.core.{Future => JFuture}
import io.vertx.core.{WorkerExecutor => JWorkerExecutor}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.core.Future

/**
  * An executor for executing blocking code in Vert.x .
  *
  * It provides the same <code>executeBlocking</code> operation than [[io.vertx.core.Context]] and
  * [[io.vertx.core.Vertx]] but on a separate worker pool.
  */
implicit class WorkerExecutorScala(val asJava: JWorkerExecutor) extends AnyVal {


  /**
    * Safely execute some blocking code.
    *
    * Executes the blocking code in the handler `blockingCodeHandler` using a thread from the worker pool.
    *
    * When the code is complete the returned Future will be completed with the result.
    *
    * @param blockingFunction function containing blocking code
    * @param ordered if true then if executeBlocking is called several times on the same context, the executions for that context will be executed serially, not in parallel. if false then they will be no ordering guarantees
    * @return a Future representing the result of the blocking operation
    */
  def executeBlocking[T](blockingFunction: () => T, ordered: Boolean = true): concurrent.Future[T] = {
    val promise = concurrent.Promise[T]
    val h: Handler[io.vertx.core.Future[T]] = {f => util.Try(blockingFunction()) match {
      case util.Success(s) => f.complete(s)
      case util.Failure(t) => f.fail(t)
    }}
    asJava.asInstanceOf[JWorkerExecutor].executeBlocking[T](h, ordered, {h:AsyncResult[T] => {if (h.succeeded()) promise.success(h.result()) else promise.failure(h.cause());()} })
    promise.future
  }

  /**
    * Close the executor.
    */
  def close(): Unit = {
    asJava.close()
  }

  /**
    * Whether the metrics are enabled for this measured object
    * @return true if the metrics are enabled
    */
  def isMetricsEnabled(): java.lang.Boolean = {
    asJava.isMetricsEnabled()
  }

}

import io.vertx.core.streams.{StreamBase => JStreamBase}
import io.vertx.core.streams.WriteStream
import io.vertx.core.streams.StreamBase
import io.vertx.core.Handler
import io.vertx.core.streams.{WriteStream => JWriteStream}

/**
  *
  * Represents a stream of data that can be written to.
  * 
  * Any class that implements this interface can be used by a [[io.vertx.core.streams.Pump]] to pump data from a `ReadStream`
  * to it.
  */
implicit class WriteStreamScala[T](val asJava: JWriteStream[T]) extends AnyVal {


  /**
    * Set an exception handler on the write stream.
    * @param handler the exception handler
    * @return a reference to this, so the API can be used fluently
    */
  def exceptionHandler(handler: scala.Option[Throwable => Unit]): JWriteStream[T] = {
    asJava.exceptionHandler(handler match {case Some(t) => (p:Throwable) => t(p); case None => null})
  }

  /**
    * Write some data to the stream. The data is put on an internal write queue, and the write actually happens
    * asynchronously. To avoid running out of memory by putting too much on the write queue,
    * check the [[io.vertx.core.streams.WriteStream#writeQueueFull]] method before writing. This is done automatically if using a [[io.vertx.core.streams.Pump]].
    * @param data the data to write
    * @return a reference to this, so the API can be used fluently
    */
  def write(data: T): JWriteStream[T] = {
    asJava.write(data)
  }

  /**
    * Set the maximum size of the write queue to `maxSize`. You will still be able to write to the stream even
    * if there is more than `maxSize` items in the write queue. This is used as an indicator by classes such as
    * `Pump` to provide flow control.
    * <p/>
    * The value is defined by the implementation of the stream, e.g in bytes for a
    * [[io.vertx.core.net.NetSocket]], the number of [[io.vertx.core.eventbus.Message]] for a
    * [[io.vertx.core.eventbus.MessageProducer]], etc...
    * @param maxSize the max size of the write stream
    * @return a reference to this, so the API can be used fluently
    */
  def setWriteQueueMaxSize(maxSize: java.lang.Integer): JWriteStream[T] = {
    asJava.setWriteQueueMaxSize(maxSize)
  }

  /**
    * Set a drain handler on the stream. If the write queue is full, then the handler will be called when the write
    * queue is ready to accept buffers again. See [[io.vertx.core.streams.Pump]] for an example of this being used.
    * <p/>
    * The stream implementation defines when the drain handler, for example it could be when the queue size has been
    * reduced to `maxSize / 2`.
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  def drainHandler(handler: scala.Option[Void => Unit]): JWriteStream[T] = {
    asJava.drainHandler(handler match {case Some(t) => (p:Void) => t(p); case None => null})
  }

  /**
    * Same as [[io.vertx.core.streams.WriteStream#end]] but writes some data to the stream before ending.
    */
  def end(t: T): Unit = {
    asJava.end(t)
  }

  /**
    * Ends the stream.
    * 
    * Once the stream has ended, it cannot be used any more.
    */
  def end(): Unit = {
    asJava.end()
  }

  /**
    * This will return `true` if there are more bytes in the write queue than the value set using [[io.vertx.core.streams.WriteStream#setWriteQueueMaxSize]]
    * @return true if write queue is full
    */
  def writeQueueFull(): java.lang.Boolean = {
    asJava.writeQueueFull()
  }

}

}
