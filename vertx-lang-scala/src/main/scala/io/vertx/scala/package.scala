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


import io.vertx.core.buffer.Buffer

/**
  * Configuration options for Vert.x hostname resolver. The resolver uses the local <i>hosts</i> file and performs
  * DNS <i>A</i> and <i>AAAA</i> queries.
  */

  implicit class AddressResolverOptionsScala(val asJava: io.vertx.core.dns.AddressResolverOptions) extends AnyVal {


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
  
  type AddressResolverOptions = io.vertx.core.dns.AddressResolverOptions

  object AddressResolverOptions {
    def apply() = new AddressResolverOptions()
    def apply(json: JsonObject) = new AddressResolverOptions(json)
  }



/**
  * Defines a command line argument. Unlike options, argument don't have names and are identified using an index. The
  * first index is 0 (because we are in the computer world).
  */

  implicit class ArgumentScala(val asJava: io.vertx.core.cli.Argument) extends AnyVal {


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
  
  type Argument = io.vertx.core.cli.Argument

  object Argument {
    def apply() = new Argument()
    def apply(json: JsonObject) = new Argument(json)
  }


import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.buffer.Buffer
import io.vertx.core.AsyncResult
import io.vertx.core.Handler

/**
  * Represents a file on the file-system which can be read from, or written to asynchronously.
  * 
  * This class also implements [[io.vertx.core.streams.ReadStream]] and
  * [[io.vertx.core.streams.WriteStream]]. This allows the data to be pumped to and from
  * other streams, e.g. an [[io.vertx.core.http.HttpClientRequest]] instance,
  * using the [[io.vertx.core.streams.Pump]] class
  */
implicit class AsyncFileScala(val asJava: io.vertx.core.file.AsyncFile) extends AnyVal {


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
import io.vertx.core.AsyncResult
import io.vertx.core.Handler

/**
  *
  * An asynchronous map.
  * 
  */
implicit class AsyncMapScala[K, V](val asJava: io.vertx.core.shareddata.AsyncMap[K, V]) extends AnyVal {


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

import io.vertx.core.net.ProxyOptions
import io.vertx.core.net.JksOptions
import io.vertx.core.net.{PfxOptions => JPfxOptions}
import io.vertx.core.net.PfxOptions
import io.vertx.core.net.OpenSSLEngineOptions
import io.vertx.core.buffer.Buffer
import io.vertx.core.net.{OpenSSLEngineOptions => JOpenSSLEngineOptions}
import io.vertx.core.net.PemKeyCertOptions
import io.vertx.core.net.{JdkSSLEngineOptions => JJdkSSLEngineOptions}
import io.vertx.core.net.{PemTrustOptions => JPemTrustOptions}
import io.vertx.core.net.{PemKeyCertOptions => JPemKeyCertOptions}
import io.vertx.core.net.PemTrustOptions
import io.vertx.core.net.{ProxyOptions => JProxyOptions}
import io.vertx.core.net.JdkSSLEngineOptions
import io.vertx.core.net.{JksOptions => JJksOptions}

/**
  * Base class for Client options
  */

  implicit class ClientOptionsBaseScala(val asJava: io.vertx.core.net.ClientOptionsBase) extends AnyVal {


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
    def setJdkSslEngineOptions(value: io.vertx.core.net.JdkSSLEngineOptions) = {
      asJava.setJdkSslEngineOptions(value)
    }
    def getJdkSslEngineOptions: io.vertx.core.net.JdkSSLEngineOptions = {
      asJava.getJdkSslEngineOptions()
    }

  /**
    * Set the key/cert options in jks format, aka Java keystore.
    */
    def setKeyStoreOptions(value: io.vertx.core.net.JksOptions) = {
      asJava.setKeyStoreOptions(value)
    }
    def getKeyStoreOptions: io.vertx.core.net.JksOptions = {
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
    def setOpenSslEngineOptions(value: io.vertx.core.net.OpenSSLEngineOptions) = {
      asJava.setOpenSslEngineOptions(value)
    }
    def getOpenSslEngineOptions: io.vertx.core.net.OpenSSLEngineOptions = {
      asJava.getOpenSslEngineOptions()
    }

  /**
    * Set the key/cert store options in pem format.
    */
    def setPemKeyCertOptions(value: io.vertx.core.net.PemKeyCertOptions) = {
      asJava.setPemKeyCertOptions(value)
    }
    def getPemKeyCertOptions: io.vertx.core.net.PemKeyCertOptions = {
      asJava.getPemKeyCertOptions()
    }

  /**
    * Set the trust options in pem format
    */
    def setPemTrustOptions(value: io.vertx.core.net.PemTrustOptions) = {
      asJava.setPemTrustOptions(value)
    }
    def getPemTrustOptions: io.vertx.core.net.PemTrustOptions = {
      asJava.getPemTrustOptions()
    }

  /**
    * Set the key/cert options in pfx format.
    */
    def setPfxKeyCertOptions(value: io.vertx.core.net.PfxOptions) = {
      asJava.setPfxKeyCertOptions(value)
    }
    def getPfxKeyCertOptions: io.vertx.core.net.PfxOptions = {
      asJava.getPfxKeyCertOptions()
    }

  /**
    * Set the trust options in pfx format
    */
    def setPfxTrustOptions(value: io.vertx.core.net.PfxOptions) = {
      asJava.setPfxTrustOptions(value)
    }
    def getPfxTrustOptions: io.vertx.core.net.PfxOptions = {
      asJava.getPfxTrustOptions()
    }

  /**
    * Set proxy options for connections via CONNECT proxy (e.g. Squid) or a SOCKS proxy.
    */
    def setProxyOptions(value: io.vertx.core.net.ProxyOptions) = {
      asJava.setProxyOptions(value)
    }
    def getProxyOptions: io.vertx.core.net.ProxyOptions = {
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
    def setTrustStoreOptions(value: io.vertx.core.net.JksOptions) = {
      asJava.setTrustStoreOptions(value)
    }
    def getTrustStoreOptions: io.vertx.core.net.JksOptions = {
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
  


import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.CompositeFuture
import io.vertx.core.{Future => JFuture}
import io.vertx.core.{CompositeFuture => JCompositeFuture}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.collection.JavaConverters._
import io.vertx.core.Future

/**
  * The composite future wraps a list of [[io.vertx.core.Future]], it is useful when several futures
  * needs to be coordinated.
  * The handlers set for the coordinated futures are overridden by the handler of the composite future.
  */
implicit class CompositeFutureScala(val asJava: io.vertx.core.CompositeFuture) extends AnyVal {


}

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.{Future => JFuture}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.core.Future

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
implicit class ContextScala(val asJava: io.vertx.core.Context) extends AnyVal {


}


/**
  * Describes the copy (and move) options.
  */

  implicit class CopyOptionsScala(val asJava: io.vertx.core.file.CopyOptions) extends AnyVal {


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
  
  type CopyOptions = io.vertx.core.file.CopyOptions

  object CopyOptions {
    def apply() = new CopyOptions()
    def apply(json: JsonObject) = new CopyOptions(json)
  }


import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.AsyncResult
import io.vertx.core.Handler

/**
  * An asynchronous counter that can be used to across the cluster to maintain a consistent count.
  * 
  */
implicit class CounterScala(val asJava: io.vertx.core.shareddata.Counter) extends AnyVal {


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

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.datagram.{DatagramSocket => JDatagramSocket}
import io.vertx.core.buffer.Buffer
import io.vertx.core.datagram.DatagramPacket
import io.vertx.core.datagram.DatagramSocket
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.core.datagram.{DatagramPacket => JDatagramPacket}

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
implicit class DatagramSocketScala(val asJava: io.vertx.core.datagram.DatagramSocket) extends AnyVal {


 /**
   * Like [[send]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def sendFuture(packet: io.vertx.core.buffer.Buffer, port: java.lang.Integer, host: String): scala.concurrent.Future[io.vertx.core.datagram.DatagramSocket] = {
    val promise = Promise[io.vertx.core.datagram.DatagramSocket]()
    asJava.send(packet, port, host, {a:AsyncResult[io.vertx.core.datagram.DatagramSocket] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[send]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def sendFuture(str: String, port: java.lang.Integer, host: String): scala.concurrent.Future[io.vertx.core.datagram.DatagramSocket] = {
    val promise = Promise[io.vertx.core.datagram.DatagramSocket]()
    asJava.send(str, port, host, {a:AsyncResult[io.vertx.core.datagram.DatagramSocket] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[send]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def sendFuture(str: String, enc: String, port: java.lang.Integer, host: String): scala.concurrent.Future[io.vertx.core.datagram.DatagramSocket] = {
    val promise = Promise[io.vertx.core.datagram.DatagramSocket]()
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
  def listenMulticastGroupFuture(multicastAddress: String): scala.concurrent.Future[io.vertx.core.datagram.DatagramSocket] = {
    val promise = Promise[io.vertx.core.datagram.DatagramSocket]()
    asJava.listenMulticastGroup(multicastAddress, {a:AsyncResult[io.vertx.core.datagram.DatagramSocket] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[listenMulticastGroup]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def listenMulticastGroupFuture(multicastAddress: String, networkInterface: String, source: String): scala.concurrent.Future[io.vertx.core.datagram.DatagramSocket] = {
    val promise = Promise[io.vertx.core.datagram.DatagramSocket]()
    asJava.listenMulticastGroup(multicastAddress, networkInterface, source, {a:AsyncResult[io.vertx.core.datagram.DatagramSocket] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[unlistenMulticastGroup]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def unlistenMulticastGroupFuture(multicastAddress: String): scala.concurrent.Future[io.vertx.core.datagram.DatagramSocket] = {
    val promise = Promise[io.vertx.core.datagram.DatagramSocket]()
    asJava.unlistenMulticastGroup(multicastAddress, {a:AsyncResult[io.vertx.core.datagram.DatagramSocket] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[unlistenMulticastGroup]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def unlistenMulticastGroupFuture(multicastAddress: String, networkInterface: String, source: String): scala.concurrent.Future[io.vertx.core.datagram.DatagramSocket] = {
    val promise = Promise[io.vertx.core.datagram.DatagramSocket]()
    asJava.unlistenMulticastGroup(multicastAddress, networkInterface, source, {a:AsyncResult[io.vertx.core.datagram.DatagramSocket] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[blockMulticastGroup]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def blockMulticastGroupFuture(multicastAddress: String, sourceToBlock: String): scala.concurrent.Future[io.vertx.core.datagram.DatagramSocket] = {
    val promise = Promise[io.vertx.core.datagram.DatagramSocket]()
    asJava.blockMulticastGroup(multicastAddress, sourceToBlock, {a:AsyncResult[io.vertx.core.datagram.DatagramSocket] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[blockMulticastGroup]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def blockMulticastGroupFuture(multicastAddress: String, networkInterface: String, sourceToBlock: String): scala.concurrent.Future[io.vertx.core.datagram.DatagramSocket] = {
    val promise = Promise[io.vertx.core.datagram.DatagramSocket]()
    asJava.blockMulticastGroup(multicastAddress, networkInterface, sourceToBlock, {a:AsyncResult[io.vertx.core.datagram.DatagramSocket] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[listen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def listenFuture(port: java.lang.Integer, host: String): scala.concurrent.Future[io.vertx.core.datagram.DatagramSocket] = {
    val promise = Promise[io.vertx.core.datagram.DatagramSocket]()
    asJava.listen(port, host, {a:AsyncResult[io.vertx.core.datagram.DatagramSocket] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

}


/**
  * Options used to configure a datagram socket.
  */

  implicit class DatagramSocketOptionsScala(val asJava: io.vertx.core.datagram.DatagramSocketOptions) extends AnyVal {


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
  
  type DatagramSocketOptions = io.vertx.core.datagram.DatagramSocketOptions

  object DatagramSocketOptions {
    def apply() = new DatagramSocketOptions()
    def apply(json: JsonObject) = new DatagramSocketOptions(json)
  }



/**
  * Delivery options are used to configure message delivery.
  * 
  * Delivery options allow to configure delivery timeout and message codec name, and to provide any headers
  * that you wish to send with the message.
  */

  implicit class DeliveryOptionsScala(val asJava: io.vertx.core.eventbus.DeliveryOptions) extends AnyVal {


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
  
  type DeliveryOptions = io.vertx.core.eventbus.DeliveryOptions

  object DeliveryOptions {
    def apply() = new DeliveryOptions()
    def apply(json: JsonObject) = new DeliveryOptions(json)
  }


import io.vertx.core.json.JsonObject

/**
  * Options for configuring a verticle deployment.
  * 
  */

  implicit class DeploymentOptionsScala(val asJava: io.vertx.core.DeploymentOptions) extends AnyVal {


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
  
  type DeploymentOptions = io.vertx.core.DeploymentOptions

  object DeploymentOptions {
    def apply() = new DeploymentOptions()
    def apply(json: JsonObject) = new DeploymentOptions(json)
  }


import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.collection.JavaConverters._

/**
  * Provides a way to asynchronously lookup information from DNS servers.
  * 
  * Please consult the documentation for more information on DNS clients.
  */
implicit class DnsClientScala(val asJava: io.vertx.core.dns.DnsClient) extends AnyVal {


 /**
   * Like [[lookup]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def lookupFuture(name: String): scala.concurrent.Future[String] = {
    val promise = Promise[String]()
    asJava.lookup(name, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[lookup4]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def lookup4Future(name: String): scala.concurrent.Future[String] = {
    val promise = Promise[String]()
    asJava.lookup4(name, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[lookup6]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def lookup6Future(name: String): scala.concurrent.Future[String] = {
    val promise = Promise[String]()
    asJava.lookup6(name, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[resolveA]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def resolveAFuture(name: String): scala.concurrent.Future[java.util.List[String]] = {
    val promise = Promise[java.util.List[String]]()
    asJava.resolveA(name, {a:AsyncResult[java.util.List[java.lang.String]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[resolveAAAA]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def resolveAAAAFuture(name: String): scala.concurrent.Future[java.util.List[String]] = {
    val promise = Promise[java.util.List[String]]()
    asJava.resolveAAAA(name, {a:AsyncResult[java.util.List[java.lang.String]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[resolveCNAME]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def resolveCNAMEFuture(name: String): scala.concurrent.Future[java.util.List[String]] = {
    val promise = Promise[java.util.List[String]]()
    asJava.resolveCNAME(name, {a:AsyncResult[java.util.List[java.lang.String]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[resolveMX]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def resolveMXFuture(name: String): scala.concurrent.Future[java.util.List[io.vertx.core.dns.MxRecord]] = {
    val promise = Promise[java.util.List[io.vertx.core.dns.MxRecord]]()
    asJava.resolveMX(name, {a:AsyncResult[java.util.List[io.vertx.core.dns.MxRecord]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[resolveTXT]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def resolveTXTFuture(name: String): scala.concurrent.Future[java.util.List[String]] = {
    val promise = Promise[java.util.List[String]]()
    asJava.resolveTXT(name, {a:AsyncResult[java.util.List[java.lang.String]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[resolvePTR]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def resolvePTRFuture(name: String): scala.concurrent.Future[String] = {
    val promise = Promise[String]()
    asJava.resolvePTR(name, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[resolveNS]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def resolveNSFuture(name: String): scala.concurrent.Future[java.util.List[String]] = {
    val promise = Promise[java.util.List[String]]()
    asJava.resolveNS(name, {a:AsyncResult[java.util.List[java.lang.String]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[resolveSRV]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def resolveSRVFuture(name: String): scala.concurrent.Future[java.util.List[io.vertx.core.dns.SrvRecord]] = {
    val promise = Promise[java.util.List[io.vertx.core.dns.SrvRecord]]()
    asJava.resolveSRV(name, {a:AsyncResult[java.util.List[io.vertx.core.dns.SrvRecord]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[reverseLookup]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def reverseLookupFuture(ipaddress: String): scala.concurrent.Future[String] = {
    val promise = Promise[String]()
    asJava.reverseLookup(ipaddress, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

}


/**
  * Configuration options for Vert.x DNS client.
  */

  implicit class DnsClientOptionsScala(val asJava: io.vertx.core.dns.DnsClientOptions) extends AnyVal {


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
  
  type DnsClientOptions = io.vertx.core.dns.DnsClientOptions

  object DnsClientOptions {
    def apply() = new DnsClientOptions()
    def apply(json: JsonObject) = new DnsClientOptions(json)
  }


import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.eventbus.DeliveryOptions
import io.vertx.core.eventbus.{Message => JMessage}
import io.vertx.core.eventbus.{DeliveryOptions => JDeliveryOptions}
import io.vertx.core.eventbus.{SendContext => JSendContext}
import io.vertx.core.eventbus.SendContext
import io.vertx.core.eventbus.Message
import io.vertx.core.AsyncResult
import io.vertx.core.Handler

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
implicit class EventBusScala(val asJava: io.vertx.core.eventbus.EventBus) extends AnyVal {


 /**
   * Like [[send]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def sendFuture[T](address: String, message: AnyRef): scala.concurrent.Future[io.vertx.core.eventbus.Message[T]] = {
    val promise = Promise[io.vertx.core.eventbus.Message[T]]()
    asJava.send[T](address, message, {a:AsyncResult[io.vertx.core.eventbus.Message[T]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[send]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def sendFuture[T](address: String, message: AnyRef, options: io.vertx.core.eventbus.DeliveryOptions): scala.concurrent.Future[io.vertx.core.eventbus.Message[T]] = {
    val promise = Promise[io.vertx.core.eventbus.Message[T]]()
    asJava.send[T](address, message, options, {a:AsyncResult[io.vertx.core.eventbus.Message[T]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

}

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
import io.vertx.core.net.{PemKeyCertOptions => JPemKeyCertOptions}
import io.vertx.core.net.PemTrustOptions
import io.vertx.core.net.JdkSSLEngineOptions
import io.vertx.core.net.{JksOptions => JJksOptions}

/**
  * Options to configure the event bus.
  */

  implicit class EventBusOptionsScala(val asJava: io.vertx.core.eventbus.EventBusOptions) extends AnyVal {


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
    def setJdkSslEngineOptions(value: io.vertx.core.net.JdkSSLEngineOptions) = {
      asJava.setJdkSslEngineOptions(value)
    }
    def getJdkSslEngineOptions: io.vertx.core.net.JdkSSLEngineOptions = {
      asJava.getJdkSslEngineOptions()
    }

  /**
    * Set the key/cert options in jks format, aka Java keystore.
    */
    def setKeyStoreOptions(value: io.vertx.core.net.JksOptions) = {
      asJava.setKeyStoreOptions(value)
    }
    def getKeyStoreOptions: io.vertx.core.net.JksOptions = {
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
    def setOpenSslEngineOptions(value: io.vertx.core.net.OpenSSLEngineOptions) = {
      asJava.setOpenSslEngineOptions(value)
    }
    def getOpenSslEngineOptions: io.vertx.core.net.OpenSSLEngineOptions = {
      asJava.getOpenSslEngineOptions()
    }

  /**
    * Set the key/cert store options in pem format.
    */
    def setPemKeyCertOptions(value: io.vertx.core.net.PemKeyCertOptions) = {
      asJava.setPemKeyCertOptions(value)
    }
    def getPemKeyCertOptions: io.vertx.core.net.PemKeyCertOptions = {
      asJava.getPemKeyCertOptions()
    }

  /**
    * Set the trust options in pem format
    */
    def setPemTrustOptions(value: io.vertx.core.net.PemTrustOptions) = {
      asJava.setPemTrustOptions(value)
    }
    def getPemTrustOptions: io.vertx.core.net.PemTrustOptions = {
      asJava.getPemTrustOptions()
    }

  /**
    * Set the key/cert options in pfx format.
    */
    def setPfxKeyCertOptions(value: io.vertx.core.net.PfxOptions) = {
      asJava.setPfxKeyCertOptions(value)
    }
    def getPfxKeyCertOptions: io.vertx.core.net.PfxOptions = {
      asJava.getPfxKeyCertOptions()
    }

  /**
    * Set the trust options in pfx format
    */
    def setPfxTrustOptions(value: io.vertx.core.net.PfxOptions) = {
      asJava.setPfxTrustOptions(value)
    }
    def getPfxTrustOptions: io.vertx.core.net.PfxOptions = {
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
    def setTrustStoreOptions(value: io.vertx.core.net.JksOptions) = {
      asJava.setTrustStoreOptions(value)
    }
    def getTrustStoreOptions: io.vertx.core.net.JksOptions = {
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
  
  type EventBusOptions = io.vertx.core.eventbus.EventBusOptions

  object EventBusOptions {
    def apply() = new EventBusOptions()
    def apply(json: JsonObject) = new EventBusOptions(json)
  }


import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.file.AsyncFile
import io.vertx.core.file.OpenOptions
import scala.collection.JavaConverters._
import io.vertx.core.file.FileSystemProps
import io.vertx.core.file.FileProps
import io.vertx.core.file.{OpenOptions => JOpenOptions}
import io.vertx.core.file.{FileSystemProps => JFileSystemProps}
import io.vertx.core.buffer.Buffer
import io.vertx.core.file.CopyOptions
import io.vertx.core.file.{AsyncFile => JAsyncFile}
import io.vertx.core.file.{CopyOptions => JCopyOptions}
import io.vertx.core.AsyncResult
import io.vertx.core.file.{FileProps => JFileProps}
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
implicit class FileSystemScala(val asJava: io.vertx.core.file.FileSystem) extends AnyVal {


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
  def copyFuture(from: String, to: String, options: io.vertx.core.file.CopyOptions): scala.concurrent.Future[Unit] = {
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
  def moveFuture(from: String, to: String, options: io.vertx.core.file.CopyOptions): scala.concurrent.Future[Unit] = {
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
  def chownFuture(path: String, user: String, group: String): scala.concurrent.Future[Unit] = {
    val promise = Promise[Unit]()
    asJava.chown(path, user, group, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[props]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def propsFuture(path: String): scala.concurrent.Future[io.vertx.core.file.FileProps] = {
    val promise = Promise[io.vertx.core.file.FileProps]()
    asJava.props(path, {a:AsyncResult[io.vertx.core.file.FileProps] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[lprops]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def lpropsFuture(path: String): scala.concurrent.Future[io.vertx.core.file.FileProps] = {
    val promise = Promise[io.vertx.core.file.FileProps]()
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
  def readDirFuture(path: String): scala.concurrent.Future[java.util.List[String]] = {
    val promise = Promise[java.util.List[String]]()
    asJava.readDir(path, {a:AsyncResult[java.util.List[java.lang.String]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[readDir]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def readDirFuture(path: String, filter: String): scala.concurrent.Future[java.util.List[String]] = {
    val promise = Promise[java.util.List[String]]()
    asJava.readDir(path, filter, {a:AsyncResult[java.util.List[java.lang.String]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
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
  def openFuture(path: String, options: io.vertx.core.file.OpenOptions): scala.concurrent.Future[io.vertx.core.file.AsyncFile] = {
    val promise = Promise[io.vertx.core.file.AsyncFile]()
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
  def fsPropsFuture(path: String): scala.concurrent.Future[io.vertx.core.file.FileSystemProps] = {
    val promise = Promise[io.vertx.core.file.FileSystemProps]()
    asJava.fsProps(path, {a:AsyncResult[io.vertx.core.file.FileSystemProps] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
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
implicit class FutureScala[T](val asJava: io.vertx.core.Future[T]) extends AnyVal {


}

import io.vertx.core.buffer.Buffer

/**
  * A  frame.
  */

  implicit class GoAwayScala(val asJava: io.vertx.core.http.GoAway) extends AnyVal {


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
  
  type GoAway = io.vertx.core.http.GoAway

  object GoAway {
    def apply() = new GoAway()
    def apply(json: JsonObject) = new GoAway(json)
  }



/**
  * HTTP2 settings, the settings is initialized with the default HTTP/2 values.
  *
  * The settings expose the parameters defined by the HTTP/2 specification, as well as extra settings for
  * protocol extensions.
  */

  implicit class Http2SettingsScala(val asJava: io.vertx.core.http.Http2Settings) extends AnyVal {


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
  
  type Http2Settings = io.vertx.core.http.Http2Settings

  object Http2Settings {
    def apply() = new Http2Settings()
    def apply(json: JsonObject) = new Http2Settings(json)
  }


import io.vertx.core.net.ProxyOptions
import io.vertx.core.net.JksOptions
import io.vertx.core.net.{PfxOptions => JPfxOptions}
import io.vertx.core.http.Http2Settings
import io.vertx.core.net.PfxOptions
import io.vertx.core.net.OpenSSLEngineOptions
import io.vertx.core.buffer.Buffer
import io.vertx.core.http.HttpVersion
import io.vertx.core.net.{OpenSSLEngineOptions => JOpenSSLEngineOptions}
import io.vertx.core.net.PemKeyCertOptions
import io.vertx.core.net.{JdkSSLEngineOptions => JJdkSSLEngineOptions}
import io.vertx.core.net.{PemTrustOptions => JPemTrustOptions}
import io.vertx.core.http.{Http2Settings => JHttp2Settings}
import io.vertx.core.net.{PemKeyCertOptions => JPemKeyCertOptions}
import io.vertx.core.net.PemTrustOptions
import io.vertx.core.net.{ProxyOptions => JProxyOptions}
import io.vertx.core.net.JdkSSLEngineOptions
import io.vertx.core.net.{JksOptions => JJksOptions}

/**
  * Options describing how an [[io.vertx.core.http.HttpClient]] will make connections.
  */

  implicit class HttpClientOptionsScala(val asJava: io.vertx.core.http.HttpClientOptions) extends AnyVal {


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
    def setInitialSettings(value: io.vertx.core.http.Http2Settings) = {
      asJava.setInitialSettings(value)
    }
    def getInitialSettings: io.vertx.core.http.Http2Settings = {
      asJava.getInitialSettings()
    }
    def setJdkSslEngineOptions(value: io.vertx.core.net.JdkSSLEngineOptions) = {
      asJava.setJdkSslEngineOptions(value)
    }
    def getJdkSslEngineOptions: io.vertx.core.net.JdkSSLEngineOptions = {
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
    def setKeyStoreOptions(value: io.vertx.core.net.JksOptions) = {
      asJava.setKeyStoreOptions(value)
    }
    def getKeyStoreOptions: io.vertx.core.net.JksOptions = {
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
    def setOpenSslEngineOptions(value: io.vertx.core.net.OpenSSLEngineOptions) = {
      asJava.setOpenSslEngineOptions(value)
    }
    def getOpenSslEngineOptions: io.vertx.core.net.OpenSSLEngineOptions = {
      asJava.getOpenSslEngineOptions()
    }

  /**
    * Set the key/cert store options in pem format.
    */
    def setPemKeyCertOptions(value: io.vertx.core.net.PemKeyCertOptions) = {
      asJava.setPemKeyCertOptions(value)
    }
    def getPemKeyCertOptions: io.vertx.core.net.PemKeyCertOptions = {
      asJava.getPemKeyCertOptions()
    }

  /**
    * Set the trust options in pem format
    */
    def setPemTrustOptions(value: io.vertx.core.net.PemTrustOptions) = {
      asJava.setPemTrustOptions(value)
    }
    def getPemTrustOptions: io.vertx.core.net.PemTrustOptions = {
      asJava.getPemTrustOptions()
    }

  /**
    * Set the key/cert options in pfx format.
    */
    def setPfxKeyCertOptions(value: io.vertx.core.net.PfxOptions) = {
      asJava.setPfxKeyCertOptions(value)
    }
    def getPfxKeyCertOptions: io.vertx.core.net.PfxOptions = {
      asJava.getPfxKeyCertOptions()
    }

  /**
    * Set the trust options in pfx format
    */
    def setPfxTrustOptions(value: io.vertx.core.net.PfxOptions) = {
      asJava.setPfxTrustOptions(value)
    }
    def getPfxTrustOptions: io.vertx.core.net.PfxOptions = {
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
    def setProxyOptions(value: io.vertx.core.net.ProxyOptions) = {
      asJava.setProxyOptions(value)
    }
    def getProxyOptions: io.vertx.core.net.ProxyOptions = {
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
    def setTrustStoreOptions(value: io.vertx.core.net.JksOptions) = {
      asJava.setTrustStoreOptions(value)
    }
    def getTrustStoreOptions: io.vertx.core.net.JksOptions = {
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
  
  type HttpClientOptions = io.vertx.core.http.HttpClientOptions

  object HttpClientOptions {
    def apply() = new HttpClientOptions()
    def apply(json: JsonObject) = new HttpClientOptions(json)
  }


import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.buffer.Buffer
import io.vertx.core.http.{GoAway => JGoAway}
import io.vertx.core.http.GoAway
import io.vertx.core.http.Http2Settings
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.core.http.{Http2Settings => JHttp2Settings}

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
implicit class HttpConnectionScala(val asJava: io.vertx.core.http.HttpConnection) extends AnyVal {


 /**
   * Like [[updateSettings]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def updateSettingsFuture(settings: io.vertx.core.http.Http2Settings): scala.concurrent.Future[Unit] = {
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

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.http.{HttpServer => JHttpServer}
import io.vertx.core.http.HttpServerRequest
import io.vertx.core.http.ServerWebSocket
import io.vertx.core.http.{HttpServerRequest => JHttpServerRequest}
import io.vertx.core.http.{HttpConnection => JHttpConnection}
import io.vertx.core.http.{ServerWebSocket => JServerWebSocket}
import io.vertx.core.http.HttpServer
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
implicit class HttpServerScala(val asJava: io.vertx.core.http.HttpServer) extends AnyVal {


 /**
   * Like [[listen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def listenFuture(port: java.lang.Integer, host: String): scala.concurrent.Future[io.vertx.core.http.HttpServer] = {
    val promise = Promise[io.vertx.core.http.HttpServer]()
    asJava.listen(port, host, {a:AsyncResult[io.vertx.core.http.HttpServer] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[listen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def listenFuture(port: java.lang.Integer): scala.concurrent.Future[io.vertx.core.http.HttpServer] = {
    val promise = Promise[io.vertx.core.http.HttpServer]()
    asJava.listen(port, {a:AsyncResult[io.vertx.core.http.HttpServer] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[listen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def listenFuture(): scala.concurrent.Future[io.vertx.core.http.HttpServer] = {
    val promise = Promise[io.vertx.core.http.HttpServer]()
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

import io.vertx.core.net.JksOptions
import io.vertx.core.net.{PfxOptions => JPfxOptions}
import io.vertx.core.http.Http2Settings
import io.vertx.core.net.PfxOptions
import io.vertx.core.net.OpenSSLEngineOptions
import io.vertx.core.buffer.Buffer
import io.vertx.core.http.HttpVersion
import io.vertx.core.net.{OpenSSLEngineOptions => JOpenSSLEngineOptions}
import io.vertx.core.net.PemKeyCertOptions
import io.vertx.core.http.ClientAuth
import io.vertx.core.net.{JdkSSLEngineOptions => JJdkSSLEngineOptions}
import io.vertx.core.net.{PemTrustOptions => JPemTrustOptions}
import io.vertx.core.http.{Http2Settings => JHttp2Settings}
import io.vertx.core.net.{PemKeyCertOptions => JPemKeyCertOptions}
import io.vertx.core.net.PemTrustOptions
import io.vertx.core.net.JdkSSLEngineOptions
import io.vertx.core.net.{JksOptions => JJksOptions}

/**
  * Represents options used by an [[io.vertx.core.http.HttpServer]] instance
  */

  implicit class HttpServerOptionsScala(val asJava: io.vertx.core.http.HttpServerOptions) extends AnyVal {


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
    def setInitialSettings(value: io.vertx.core.http.Http2Settings) = {
      asJava.setInitialSettings(value)
    }
    def getInitialSettings: io.vertx.core.http.Http2Settings = {
      asJava.getInitialSettings()
    }
    def setJdkSslEngineOptions(value: io.vertx.core.net.JdkSSLEngineOptions) = {
      asJava.setJdkSslEngineOptions(value)
    }
    def getJdkSslEngineOptions: io.vertx.core.net.JdkSSLEngineOptions = {
      asJava.getJdkSslEngineOptions()
    }

  /**
    * Set the key/cert options in jks format, aka Java keystore.
    */
    def setKeyStoreOptions(value: io.vertx.core.net.JksOptions) = {
      asJava.setKeyStoreOptions(value)
    }
    def getKeyStoreOptions: io.vertx.core.net.JksOptions = {
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
    def setOpenSslEngineOptions(value: io.vertx.core.net.OpenSSLEngineOptions) = {
      asJava.setOpenSslEngineOptions(value)
    }
    def getOpenSslEngineOptions: io.vertx.core.net.OpenSSLEngineOptions = {
      asJava.getOpenSslEngineOptions()
    }

  /**
    * Set the key/cert store options in pem format.
    */
    def setPemKeyCertOptions(value: io.vertx.core.net.PemKeyCertOptions) = {
      asJava.setPemKeyCertOptions(value)
    }
    def getPemKeyCertOptions: io.vertx.core.net.PemKeyCertOptions = {
      asJava.getPemKeyCertOptions()
    }

  /**
    * Set the trust options in pem format
    */
    def setPemTrustOptions(value: io.vertx.core.net.PemTrustOptions) = {
      asJava.setPemTrustOptions(value)
    }
    def getPemTrustOptions: io.vertx.core.net.PemTrustOptions = {
      asJava.getPemTrustOptions()
    }

  /**
    * Set the key/cert options in pfx format.
    */
    def setPfxKeyCertOptions(value: io.vertx.core.net.PfxOptions) = {
      asJava.setPfxKeyCertOptions(value)
    }
    def getPfxKeyCertOptions: io.vertx.core.net.PfxOptions = {
      asJava.getPfxKeyCertOptions()
    }

  /**
    * Set the trust options in pfx format
    */
    def setPfxTrustOptions(value: io.vertx.core.net.PfxOptions) = {
      asJava.setPfxTrustOptions(value)
    }
    def getPfxTrustOptions: io.vertx.core.net.PfxOptions = {
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
    def setTrustStoreOptions(value: io.vertx.core.net.JksOptions) = {
      asJava.setTrustStoreOptions(value)
    }
    def getTrustStoreOptions: io.vertx.core.net.JksOptions = {
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
  
  type HttpServerOptions = io.vertx.core.http.HttpServerOptions

  object HttpServerOptions {
    def apply() = new HttpServerOptions()
    def apply(json: JsonObject) = new HttpServerOptions(json)
  }


import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.buffer.Buffer
import io.vertx.core.http.{HttpServerResponse => JHttpServerResponse}
import io.vertx.core.http.HttpFrame
import io.vertx.core.http.HttpMethod
import io.vertx.core.http.HttpServerResponse
import io.vertx.core.MultiMap
import io.vertx.core.{MultiMap => JMultiMap}
import io.vertx.core.http.{HttpFrame => JHttpFrame}
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
implicit class HttpServerResponseScala(val asJava: io.vertx.core.http.HttpServerResponse) extends AnyVal {


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
  def pushFuture(method: io.vertx.core.http.HttpMethod, host: String, path: String): scala.concurrent.Future[io.vertx.core.http.HttpServerResponse] = {
    val promise = Promise[io.vertx.core.http.HttpServerResponse]()
    asJava.push(method, host, path, {a:AsyncResult[io.vertx.core.http.HttpServerResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[push]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def pushFuture(method: io.vertx.core.http.HttpMethod, path: String, headers: io.vertx.core.MultiMap): scala.concurrent.Future[io.vertx.core.http.HttpServerResponse] = {
    val promise = Promise[io.vertx.core.http.HttpServerResponse]()
    asJava.push(method, path, headers, {a:AsyncResult[io.vertx.core.http.HttpServerResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[push]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def pushFuture(method: io.vertx.core.http.HttpMethod, path: String): scala.concurrent.Future[io.vertx.core.http.HttpServerResponse] = {
    val promise = Promise[io.vertx.core.http.HttpServerResponse]()
    asJava.push(method, path, {a:AsyncResult[io.vertx.core.http.HttpServerResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[push]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def pushFuture(method: io.vertx.core.http.HttpMethod, host: String, path: String, headers: io.vertx.core.MultiMap): scala.concurrent.Future[io.vertx.core.http.HttpServerResponse] = {
    val promise = Promise[io.vertx.core.http.HttpServerResponse]()
    asJava.push(method, host, path, headers, {a:AsyncResult[io.vertx.core.http.HttpServerResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

}


/**
  * Configures a <a href="../../../../../../../cheatsheet/TCPSSLOptions.html">TCPSSLOptions</a> to use the JDK ssl engine implementation.
  */

  implicit class JdkSSLEngineOptionsScala(val asJava: io.vertx.core.net.JdkSSLEngineOptions) extends AnyVal {

  }
  
  type JdkSSLEngineOptions = io.vertx.core.net.JdkSSLEngineOptions

  object JdkSSLEngineOptions {
    def apply() = new JdkSSLEngineOptions()
    def apply(json: JsonObject) = new JdkSSLEngineOptions(json)
  }


import io.vertx.core.buffer.Buffer

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

  implicit class JksOptionsScala(val asJava: io.vertx.core.net.JksOptions) extends AnyVal {


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
  
  type JksOptions = io.vertx.core.net.JksOptions

  object JksOptions {
    def apply() = new JksOptions()
    def apply(json: JsonObject) = new JksOptions(json)
  }


import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.eventbus.DeliveryOptions
import io.vertx.core.eventbus.{Message => JMessage}
import io.vertx.core.eventbus.{DeliveryOptions => JDeliveryOptions}
import io.vertx.core.eventbus.Message
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
implicit class MessageScala[T](val asJava: io.vertx.core.eventbus.Message[T]) extends AnyVal {


 /**
   * Like [[reply]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def replyFuture[R](message: AnyRef): scala.concurrent.Future[io.vertx.core.eventbus.Message[R]] = {
    val promise = Promise[io.vertx.core.eventbus.Message[R]]()
    asJava.reply[R](message, {a:AsyncResult[io.vertx.core.eventbus.Message[R]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[reply]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def replyFuture[R](message: AnyRef, options: io.vertx.core.eventbus.DeliveryOptions): scala.concurrent.Future[io.vertx.core.eventbus.Message[R]] = {
    val promise = Promise[io.vertx.core.eventbus.Message[R]]()
    asJava.reply[R](message, options, {a:AsyncResult[io.vertx.core.eventbus.Message[R]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

}

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.eventbus.{Message => JMessage}
import io.vertx.core.eventbus.Message
import io.vertx.core.AsyncResult
import io.vertx.core.Handler

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
implicit class MessageConsumerScala[T](val asJava: io.vertx.core.eventbus.MessageConsumer[T]) extends AnyVal {


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
import io.vertx.core.eventbus.{Message => JMessage}
import io.vertx.core.eventbus.{DeliveryOptions => JDeliveryOptions}
import io.vertx.core.eventbus.Message
import io.vertx.core.AsyncResult
import io.vertx.core.Handler

/**
  * Represents a stream of message that can be written to.
  * 
  */
implicit class MessageProducerScala[T](val asJava: io.vertx.core.eventbus.MessageProducer[T]) extends AnyVal {


  def sendFuture[R](message: T): scala.concurrent.Future[io.vertx.core.eventbus.Message[R]] = {
    val promise = Promise[io.vertx.core.eventbus.Message[R]]()
    asJava.send[R](message, {a:AsyncResult[io.vertx.core.eventbus.Message[R]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

}


/**
  * Vert.x metrics base configuration, this class can be extended by provider implementations to configure
  * those specific implementations.
  */

  implicit class MetricsOptionsScala(val asJava: io.vertx.core.metrics.MetricsOptions) extends AnyVal {


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
  
  type MetricsOptions = io.vertx.core.metrics.MetricsOptions

  object MetricsOptions {
    def apply() = new MetricsOptions()
    def apply(json: JsonObject) = new MetricsOptions(json)
  }


import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.net.{NetSocket => JNetSocket}
import io.vertx.core.net.{SocketAddress => JSocketAddress}
import io.vertx.core.AsyncResult
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
implicit class NetClientScala(val asJava: io.vertx.core.net.NetClient) extends AnyVal {


 /**
   * Like [[connect]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def connectFuture(port: java.lang.Integer, host: String): scala.concurrent.Future[io.vertx.core.net.NetSocket] = {
    val promise = Promise[io.vertx.core.net.NetSocket]()
    asJava.connect(port, host, {a:AsyncResult[io.vertx.core.net.NetSocket] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[connect]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def connectFuture(port: java.lang.Integer, host: String, serverName: String): scala.concurrent.Future[io.vertx.core.net.NetSocket] = {
    val promise = Promise[io.vertx.core.net.NetSocket]()
    asJava.connect(port, host, serverName, {a:AsyncResult[io.vertx.core.net.NetSocket] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[connect]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def connectFuture(remoteAddress: io.vertx.core.net.SocketAddress): scala.concurrent.Future[io.vertx.core.net.NetSocket] = {
    val promise = Promise[io.vertx.core.net.NetSocket]()
    asJava.connect(remoteAddress, {a:AsyncResult[io.vertx.core.net.NetSocket] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[connect]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def connectFuture(remoteAddress: io.vertx.core.net.SocketAddress, serverName: String): scala.concurrent.Future[io.vertx.core.net.NetSocket] = {
    val promise = Promise[io.vertx.core.net.NetSocket]()
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

  implicit class NetClientOptionsScala(val asJava: io.vertx.core.net.NetClientOptions) extends AnyVal {


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
    def setJdkSslEngineOptions(value: io.vertx.core.net.JdkSSLEngineOptions) = {
      asJava.setJdkSslEngineOptions(value)
    }
    def getJdkSslEngineOptions: io.vertx.core.net.JdkSSLEngineOptions = {
      asJava.getJdkSslEngineOptions()
    }

  /**
    * Set the key/cert options in jks format, aka Java keystore.
    */
    def setKeyStoreOptions(value: io.vertx.core.net.JksOptions) = {
      asJava.setKeyStoreOptions(value)
    }
    def getKeyStoreOptions: io.vertx.core.net.JksOptions = {
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
    def setOpenSslEngineOptions(value: io.vertx.core.net.OpenSSLEngineOptions) = {
      asJava.setOpenSslEngineOptions(value)
    }
    def getOpenSslEngineOptions: io.vertx.core.net.OpenSSLEngineOptions = {
      asJava.getOpenSslEngineOptions()
    }

  /**
    * Set the key/cert store options in pem format.
    */
    def setPemKeyCertOptions(value: io.vertx.core.net.PemKeyCertOptions) = {
      asJava.setPemKeyCertOptions(value)
    }
    def getPemKeyCertOptions: io.vertx.core.net.PemKeyCertOptions = {
      asJava.getPemKeyCertOptions()
    }

  /**
    * Set the trust options in pem format
    */
    def setPemTrustOptions(value: io.vertx.core.net.PemTrustOptions) = {
      asJava.setPemTrustOptions(value)
    }
    def getPemTrustOptions: io.vertx.core.net.PemTrustOptions = {
      asJava.getPemTrustOptions()
    }

  /**
    * Set the key/cert options in pfx format.
    */
    def setPfxKeyCertOptions(value: io.vertx.core.net.PfxOptions) = {
      asJava.setPfxKeyCertOptions(value)
    }
    def getPfxKeyCertOptions: io.vertx.core.net.PfxOptions = {
      asJava.getPfxKeyCertOptions()
    }

  /**
    * Set the trust options in pfx format
    */
    def setPfxTrustOptions(value: io.vertx.core.net.PfxOptions) = {
      asJava.setPfxTrustOptions(value)
    }
    def getPfxTrustOptions: io.vertx.core.net.PfxOptions = {
      asJava.getPfxTrustOptions()
    }

  /**
    * Set proxy options for connections via CONNECT proxy (e.g. Squid) or a SOCKS proxy.
    */
    def setProxyOptions(value: io.vertx.core.net.ProxyOptions) = {
      asJava.setProxyOptions(value)
    }
    def getProxyOptions: io.vertx.core.net.ProxyOptions = {
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
    def setTrustStoreOptions(value: io.vertx.core.net.JksOptions) = {
      asJava.setTrustStoreOptions(value)
    }
    def getTrustStoreOptions: io.vertx.core.net.JksOptions = {
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
  
  type NetClientOptions = io.vertx.core.net.NetClientOptions

  object NetClientOptions {
    def apply() = new NetClientOptions()
    def apply(json: JsonObject) = new NetClientOptions(json)
  }


import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.net.{NetServer => JNetServer}
import io.vertx.core.net.{NetSocket => JNetSocket}
import io.vertx.core.net.NetServer
import io.vertx.core.net.{SocketAddress => JSocketAddress}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.core.net.NetSocket
import io.vertx.core.net.SocketAddress

/**
  * Represents a TCP server
  */
implicit class NetServerScala(val asJava: io.vertx.core.net.NetServer) extends AnyVal {


 /**
   * Like [[listen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def listenFuture(): scala.concurrent.Future[io.vertx.core.net.NetServer] = {
    val promise = Promise[io.vertx.core.net.NetServer]()
    asJava.listen({a:AsyncResult[io.vertx.core.net.NetServer] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[listen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def listenFuture(port: java.lang.Integer, host: String): scala.concurrent.Future[io.vertx.core.net.NetServer] = {
    val promise = Promise[io.vertx.core.net.NetServer]()
    asJava.listen(port, host, {a:AsyncResult[io.vertx.core.net.NetServer] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[listen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def listenFuture(port: java.lang.Integer): scala.concurrent.Future[io.vertx.core.net.NetServer] = {
    val promise = Promise[io.vertx.core.net.NetServer]()
    asJava.listen(port, {a:AsyncResult[io.vertx.core.net.NetServer] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[listen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def listenFuture(localAddress: io.vertx.core.net.SocketAddress): scala.concurrent.Future[io.vertx.core.net.NetServer] = {
    val promise = Promise[io.vertx.core.net.NetServer]()
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

  implicit class NetServerOptionsScala(val asJava: io.vertx.core.net.NetServerOptions) extends AnyVal {


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
    def setJdkSslEngineOptions(value: io.vertx.core.net.JdkSSLEngineOptions) = {
      asJava.setJdkSslEngineOptions(value)
    }
    def getJdkSslEngineOptions: io.vertx.core.net.JdkSSLEngineOptions = {
      asJava.getJdkSslEngineOptions()
    }

  /**
    * Set the key/cert options in jks format, aka Java keystore.
    */
    def setKeyStoreOptions(value: io.vertx.core.net.JksOptions) = {
      asJava.setKeyStoreOptions(value)
    }
    def getKeyStoreOptions: io.vertx.core.net.JksOptions = {
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
    def setOpenSslEngineOptions(value: io.vertx.core.net.OpenSSLEngineOptions) = {
      asJava.setOpenSslEngineOptions(value)
    }
    def getOpenSslEngineOptions: io.vertx.core.net.OpenSSLEngineOptions = {
      asJava.getOpenSslEngineOptions()
    }

  /**
    * Set the key/cert store options in pem format.
    */
    def setPemKeyCertOptions(value: io.vertx.core.net.PemKeyCertOptions) = {
      asJava.setPemKeyCertOptions(value)
    }
    def getPemKeyCertOptions: io.vertx.core.net.PemKeyCertOptions = {
      asJava.getPemKeyCertOptions()
    }

  /**
    * Set the trust options in pem format
    */
    def setPemTrustOptions(value: io.vertx.core.net.PemTrustOptions) = {
      asJava.setPemTrustOptions(value)
    }
    def getPemTrustOptions: io.vertx.core.net.PemTrustOptions = {
      asJava.getPemTrustOptions()
    }

  /**
    * Set the key/cert options in pfx format.
    */
    def setPfxKeyCertOptions(value: io.vertx.core.net.PfxOptions) = {
      asJava.setPfxKeyCertOptions(value)
    }
    def getPfxKeyCertOptions: io.vertx.core.net.PfxOptions = {
      asJava.getPfxKeyCertOptions()
    }

  /**
    * Set the trust options in pfx format
    */
    def setPfxTrustOptions(value: io.vertx.core.net.PfxOptions) = {
      asJava.setPfxTrustOptions(value)
    }
    def getPfxTrustOptions: io.vertx.core.net.PfxOptions = {
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
    def setTrustStoreOptions(value: io.vertx.core.net.JksOptions) = {
      asJava.setTrustStoreOptions(value)
    }
    def getTrustStoreOptions: io.vertx.core.net.JksOptions = {
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
  
  type NetServerOptions = io.vertx.core.net.NetServerOptions

  object NetServerOptions {
    def apply() = new NetServerOptions()
    def apply(json: JsonObject) = new NetServerOptions(json)
  }


import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.buffer.Buffer
import io.vertx.core.AsyncResult
import io.vertx.core.Handler

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
implicit class NetSocketScala(val asJava: io.vertx.core.net.NetSocket) extends AnyVal {


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


/**
  */

  implicit class NetworkOptionsScala(val asJava: io.vertx.core.net.NetworkOptions) extends AnyVal {


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
  



/**
  * Describes how an [[io.vertx.core.file.AsyncFile]] should be opened.
  */

  implicit class OpenOptionsScala(val asJava: io.vertx.core.file.OpenOptions) extends AnyVal {


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
  
  type OpenOptions = io.vertx.core.file.OpenOptions

  object OpenOptions {
    def apply() = new OpenOptions()
    def apply(json: JsonObject) = new OpenOptions(json)
  }



/**
  * Configures a <a href="../../../../../../../cheatsheet/TCPSSLOptions.html">TCPSSLOptions</a> to use OpenSsl.
  */

  implicit class OpenSSLEngineOptionsScala(val asJava: io.vertx.core.net.OpenSSLEngineOptions) extends AnyVal {


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
  
  type OpenSSLEngineOptions = io.vertx.core.net.OpenSSLEngineOptions

  object OpenSSLEngineOptions {
    def apply() = new OpenSSLEngineOptions()
    def apply(json: JsonObject) = new OpenSSLEngineOptions(json)
  }



/**
  * Models command line options. Options are values passed to a command line interface using -x or --x. Supported
  * syntaxes depend on the parser.
  * <p/>
  * Short name is generally used with a single dash, while long name requires a double-dash.
  */

  implicit class OptionScala(val asJava: io.vertx.core.cli.Option) extends AnyVal {


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
  
  type Option = io.vertx.core.cli.Option

  object Option {
    def apply() = new Option()
    def apply(json: JsonObject) = new Option(json)
  }


import io.vertx.core.buffer.Buffer

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

  implicit class PemKeyCertOptionsScala(val asJava: io.vertx.core.net.PemKeyCertOptions) extends AnyVal {


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
  
  type PemKeyCertOptions = io.vertx.core.net.PemKeyCertOptions

  object PemKeyCertOptions {
    def apply() = new PemKeyCertOptions()
    def apply(json: JsonObject) = new PemKeyCertOptions(json)
  }


import io.vertx.core.buffer.Buffer

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

  implicit class PemTrustOptionsScala(val asJava: io.vertx.core.net.PemTrustOptions) extends AnyVal {


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
  
  type PemTrustOptions = io.vertx.core.net.PemTrustOptions

  object PemTrustOptions {
    def apply() = new PemTrustOptions()
    def apply(json: JsonObject) = new PemTrustOptions(json)
  }


import io.vertx.core.buffer.Buffer

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

  implicit class PfxOptionsScala(val asJava: io.vertx.core.net.PfxOptions) extends AnyVal {


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
  
  type PfxOptions = io.vertx.core.net.PfxOptions

  object PfxOptions {
    def apply() = new PfxOptions()
    def apply(json: JsonObject) = new PfxOptions(json)
  }


import io.vertx.core.net.ProxyType

/**
  * Proxy options for a net client or a net client.
  */

  implicit class ProxyOptionsScala(val asJava: io.vertx.core.net.ProxyOptions) extends AnyVal {


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
  
  type ProxyOptions = io.vertx.core.net.ProxyOptions

  object ProxyOptions {
    def apply() = new ProxyOptions()
    def apply(json: JsonObject) = new ProxyOptions(json)
  }



/**
  * Options describing how an [[io.vertx.core.http.HttpClient]] will make connect to make a request.
  */

  implicit class RequestOptionsScala(val asJava: io.vertx.core.http.RequestOptions) extends AnyVal {


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
  
  type RequestOptions = io.vertx.core.http.RequestOptions

  object RequestOptions {
    def apply() = new RequestOptions()
    def apply(json: JsonObject) = new RequestOptions(json)
  }


import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.shareddata.AsyncMap
import io.vertx.core.shareddata.Lock
import io.vertx.core.shareddata.{Counter => JCounter}
import io.vertx.core.shareddata.{AsyncMap => JAsyncMap}
import io.vertx.core.shareddata.Counter
import io.vertx.core.AsyncResult
import io.vertx.core.shareddata.{Lock => JLock}
import io.vertx.core.Handler

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
implicit class SharedDataScala(val asJava: io.vertx.core.shareddata.SharedData) extends AnyVal {


 /**
   * Like [[getClusterWideMap]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def getClusterWideMapFuture[K, V](name: String): scala.concurrent.Future[io.vertx.core.shareddata.AsyncMap[K, V]] = {
    val promise = Promise[io.vertx.core.shareddata.AsyncMap[K, V]]()
    asJava.getClusterWideMap[K, V](name, {a:AsyncResult[io.vertx.core.shareddata.AsyncMap[K,V]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[getAsyncMap]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def getAsyncMapFuture[K, V](name: String): scala.concurrent.Future[io.vertx.core.shareddata.AsyncMap[K, V]] = {
    val promise = Promise[io.vertx.core.shareddata.AsyncMap[K, V]]()
    asJava.getAsyncMap[K, V](name, {a:AsyncResult[io.vertx.core.shareddata.AsyncMap[K,V]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[getLock]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def getLockFuture(name: String): scala.concurrent.Future[io.vertx.core.shareddata.Lock] = {
    val promise = Promise[io.vertx.core.shareddata.Lock]()
    asJava.getLock(name, {a:AsyncResult[io.vertx.core.shareddata.Lock] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[getLockWithTimeout]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def getLockWithTimeoutFuture(name: String, timeout: java.lang.Long): scala.concurrent.Future[io.vertx.core.shareddata.Lock] = {
    val promise = Promise[io.vertx.core.shareddata.Lock]()
    asJava.getLockWithTimeout(name, timeout, {a:AsyncResult[io.vertx.core.shareddata.Lock] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

 /**
   * Like [[getCounter]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def getCounterFuture(name: String): scala.concurrent.Future[io.vertx.core.shareddata.Counter] = {
    val promise = Promise[io.vertx.core.shareddata.Counter]()
    asJava.getCounter(name, {a:AsyncResult[io.vertx.core.shareddata.Counter] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
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
import io.vertx.core.net.{PemKeyCertOptions => JPemKeyCertOptions}
import io.vertx.core.net.PemTrustOptions
import io.vertx.core.net.JdkSSLEngineOptions
import io.vertx.core.net.{JksOptions => JJksOptions}

/**
  * Base class. TCP and SSL related options
  */

  implicit class TCPSSLOptionsScala(val asJava: io.vertx.core.net.TCPSSLOptions) extends AnyVal {


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
    def setJdkSslEngineOptions(value: io.vertx.core.net.JdkSSLEngineOptions) = {
      asJava.setJdkSslEngineOptions(value)
    }
    def getJdkSslEngineOptions: io.vertx.core.net.JdkSSLEngineOptions = {
      asJava.getJdkSslEngineOptions()
    }

  /**
    * Set the key/cert options in jks format, aka Java keystore.
    */
    def setKeyStoreOptions(value: io.vertx.core.net.JksOptions) = {
      asJava.setKeyStoreOptions(value)
    }
    def getKeyStoreOptions: io.vertx.core.net.JksOptions = {
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
    def setOpenSslEngineOptions(value: io.vertx.core.net.OpenSSLEngineOptions) = {
      asJava.setOpenSslEngineOptions(value)
    }
    def getOpenSslEngineOptions: io.vertx.core.net.OpenSSLEngineOptions = {
      asJava.getOpenSslEngineOptions()
    }

  /**
    * Set the key/cert store options in pem format.
    */
    def setPemKeyCertOptions(value: io.vertx.core.net.PemKeyCertOptions) = {
      asJava.setPemKeyCertOptions(value)
    }
    def getPemKeyCertOptions: io.vertx.core.net.PemKeyCertOptions = {
      asJava.getPemKeyCertOptions()
    }

  /**
    * Set the trust options in pem format
    */
    def setPemTrustOptions(value: io.vertx.core.net.PemTrustOptions) = {
      asJava.setPemTrustOptions(value)
    }
    def getPemTrustOptions: io.vertx.core.net.PemTrustOptions = {
      asJava.getPemTrustOptions()
    }

  /**
    * Set the key/cert options in pfx format.
    */
    def setPfxKeyCertOptions(value: io.vertx.core.net.PfxOptions) = {
      asJava.setPfxKeyCertOptions(value)
    }
    def getPfxKeyCertOptions: io.vertx.core.net.PfxOptions = {
      asJava.getPfxKeyCertOptions()
    }

  /**
    * Set the trust options in pfx format
    */
    def setPfxTrustOptions(value: io.vertx.core.net.PfxOptions) = {
      asJava.setPfxTrustOptions(value)
    }
    def getPfxTrustOptions: io.vertx.core.net.PfxOptions = {
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
    def setTrustStoreOptions(value: io.vertx.core.net.JksOptions) = {
      asJava.setTrustStoreOptions(value)
    }
    def getTrustStoreOptions: io.vertx.core.net.JksOptions = {
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
  


import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.{DeploymentOptions => JDeploymentOptions}
import io.vertx.core.Vertx
import io.vertx.core.dns.DnsClientOptions
import io.vertx.core.VertxOptions
import io.vertx.core.http.{HttpClientOptions => JHttpClientOptions}
import io.vertx.core.http.{HttpServerOptions => JHttpServerOptions}
import io.vertx.core.Future
import io.vertx.core.net.{NetServerOptions => JNetServerOptions}
import io.vertx.core.{Vertx => JVertx}
import io.vertx.core.net.NetClientOptions
import io.vertx.core.datagram.{DatagramSocketOptions => JDatagramSocketOptions}
import io.vertx.core.net.NetServerOptions
import io.vertx.core.dns.{DnsClientOptions => JDnsClientOptions}
import io.vertx.core.DeploymentOptions
import io.vertx.core.net.{NetClientOptions => JNetClientOptions}
import io.vertx.core.{Future => JFuture}
import io.vertx.core.http.HttpServerOptions
import io.vertx.core.AsyncResult
import io.vertx.core.http.HttpClientOptions
import io.vertx.core.datagram.DatagramSocketOptions
import io.vertx.core.{VertxOptions => JVertxOptions}
import io.vertx.core.Handler

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
implicit class VertxScala(val asJava: io.vertx.core.Vertx) extends AnyVal {

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
  def deployVerticleFuture(name: String, options: io.vertx.core.DeploymentOptions): scala.concurrent.Future[String] = {
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
import io.vertx.core.dns.AddressResolverOptions

/**
  * Instances of this class are used to configure [[io.vertx.core.Vertx]] instances.
  */

  implicit class VertxOptionsScala(val asJava: io.vertx.core.VertxOptions) extends AnyVal {


  /**
    * Sets the address resolver configuration to configure resolving DNS servers, cache TTL, etc...
    */
    def setAddressResolverOptions(value: io.vertx.core.dns.AddressResolverOptions) = {
      asJava.setAddressResolverOptions(value)
    }
    def getAddressResolverOptions: io.vertx.core.dns.AddressResolverOptions = {
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
    def setEventBusOptions(value: io.vertx.core.eventbus.EventBusOptions) = {
      asJava.setEventBusOptions(value)
    }
    def getEventBusOptions: io.vertx.core.eventbus.EventBusOptions = {
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
    def setMetricsOptions(value: io.vertx.core.metrics.MetricsOptions) = {
      asJava.setMetricsOptions(value)
    }
    def getMetricsOptions: io.vertx.core.metrics.MetricsOptions = {
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
  
  type VertxOptions = io.vertx.core.VertxOptions

  object VertxOptions {
    def apply() = new VertxOptions()
    def apply(json: JsonObject) = new VertxOptions(json)
  }


import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.{Future => JFuture}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.core.Future

/**
  * An executor for executing blocking code in Vert.x .
  *
  * It provides the same <code>executeBlocking</code> operation than [[io.vertx.core.Context]] and
  * [[io.vertx.core.Vertx]] but on a separate worker pool.
  */
implicit class WorkerExecutorScala(val asJava: io.vertx.core.WorkerExecutor) extends AnyVal {


}

}
