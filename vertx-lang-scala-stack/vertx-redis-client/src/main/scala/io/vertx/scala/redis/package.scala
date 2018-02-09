//MODULE: vertx-redis
//MODULE: io.vertx.redis
//MODULE: io.vertx
//MODULE: io.vertx.scala.redis
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

package object redis{


  type BitFieldGetCommand = io.vertx.redis.op.BitFieldGetCommand

  object BitFieldGetCommand {
    def apply() = new BitFieldGetCommand()
    def apply(json: JsonObject) = new BitFieldGetCommand(json)
  }


  type BitFieldIncrbyCommand = io.vertx.redis.op.BitFieldIncrbyCommand

  object BitFieldIncrbyCommand {
    def apply() = new BitFieldIncrbyCommand()
    def apply(json: JsonObject) = new BitFieldIncrbyCommand(json)
  }


  type BitFieldOptions = io.vertx.redis.op.BitFieldOptions

  object BitFieldOptions {
    def apply() = new BitFieldOptions()
    def apply(json: JsonObject) = new BitFieldOptions(json)
  }


  type BitFieldSetCommand = io.vertx.redis.op.BitFieldSetCommand

  object BitFieldSetCommand {
    def apply() = new BitFieldSetCommand()
    def apply(json: JsonObject) = new BitFieldSetCommand(json)
  }


  type GeoMember = io.vertx.redis.op.GeoMember

  object GeoMember {
    def apply() = new GeoMember()
    def apply(json: JsonObject) = new GeoMember(json)
  }


  type GeoRadiusOptions = io.vertx.redis.op.GeoRadiusOptions

  object GeoRadiusOptions {
    def apply() = new GeoRadiusOptions()
    def apply(json: JsonObject) = new GeoRadiusOptions(json)
  }


  type KillFilter = io.vertx.redis.op.KillFilter

  object KillFilter {
    def apply() = new KillFilter()
    def apply(json: JsonObject) = new KillFilter(json)
  }


  type LimitOptions = io.vertx.redis.op.LimitOptions

  object LimitOptions {
    def apply() = new LimitOptions()
    def apply(json: JsonObject) = new LimitOptions(json)
  }


  type MigrateOptions = io.vertx.redis.op.MigrateOptions

  object MigrateOptions {
    def apply() = new MigrateOptions()
    def apply(json: JsonObject) = new MigrateOptions(json)
  }


  type RangeLimitOptions = io.vertx.redis.op.RangeLimitOptions

  object RangeLimitOptions {
    def apply() = new RangeLimitOptions()
    def apply(json: JsonObject) = new RangeLimitOptions(json)
  }


import io.vertx.redis.{Script => JScript}
import io.vertx.redis.op.BitOperation
import io.vertx.redis.op.ResetOptions
import io.vertx.redis.op.{ScanOptions => JScanOptions}
import io.vertx.redis.op.ObjectCmd
import io.vertx.redis.op.{SetOptions => JSetOptions}
import io.vertx.redis.op.KillFilter
import io.vertx.redis.op.{LimitOptions => JLimitOptions}
import io.vertx.redis.op.ClientReplyOptions
import io.vertx.redis.op.{MigrateOptions => JMigrateOptions}
import io.vertx.redis.op.GeoUnit
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.redis.op.RangeOptions
import io.vertx.redis.op.GeoRadiusOptions
import io.vertx.redis.op.InsertOptions
import io.vertx.redis.op.AggregateOptions
import io.vertx.redis.op.{BitFieldOptions => JBitFieldOptions}
import io.vertx.redis.op.SetOptions
import io.vertx.redis.op.SortOptions
import io.vertx.redis.op.MigrateOptions
import io.vertx.redis.op.ScanOptions
import io.vertx.redis.op.BitFieldOptions
import io.vertx.redis.op.ScriptDebugOptions
import io.vertx.core.Vertx
import io.vertx.redis.op.FailoverOptions
import io.vertx.redis.op.{GeoRadiusOptions => JGeoRadiusOptions}
import scala.collection.JavaConverters._
import io.vertx.redis.op.SlotCmd
import io.vertx.redis.op.BitFieldOverflowOptions
import io.vertx.core.{Vertx => JVertx}
import io.vertx.redis.op.RangeLimitOptions
import io.vertx.redis.op.{RangeLimitOptions => JRangeLimitOptions}
import io.vertx.redis.op.LimitOptions
import io.vertx.core.json.JsonArray
import io.vertx.core.buffer.Buffer
import io.vertx.redis.RedisOptions
import io.vertx.redis.op.{SortOptions => JSortOptions}
import io.vertx.redis.Script
import io.vertx.redis.{RedisOptions => JRedisOptions}
import io.vertx.core.Handler
import io.vertx.redis.op.{KillFilter => JKillFilter}

  implicit class RedisClientScala(val asJava: io.vertx.redis.RedisClient) extends AnyVal {

    /**
     * Like [[close]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def closeFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.close({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[append]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def appendFuture(key: String, value: String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.append(key, value, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[auth]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def authFuture(password: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.auth(password, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[bgrewriteaof]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def bgrewriteaofFuture(): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.bgrewriteaof({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[bgsave]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def bgsaveFuture(): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.bgsave({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[bitcount]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def bitcountFuture(key: String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.bitcount(key, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[bitcountRange]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def bitcountRangeFuture(key: String, start: java.lang.Long, end: java.lang.Long): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.bitcountRange(key, start, end, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[bitop]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def bitopFuture(operation: io.vertx.redis.op.BitOperation, destkey: String, keys: java.util.List[String]): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.bitop(operation, destkey, keys, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[bitpos]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def bitposFuture(key: String, bit: java.lang.Integer): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.bitpos(key, bit, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[bitposFrom]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def bitposFromFuture(key: String, bit: java.lang.Integer, start: java.lang.Integer): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.bitposFrom(key, bit, start, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[bitposRange]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def bitposRangeFuture(key: String, bit: java.lang.Integer, start: java.lang.Integer, stop: java.lang.Integer): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.bitposRange(key, bit, start, stop, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[blpop]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def blpopFuture(key: String, seconds: java.lang.Integer): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.blpop(key, seconds, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[blpopMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def blpopManyFuture(keys: java.util.List[String], seconds: java.lang.Integer): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.blpopMany(keys, seconds, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[brpop]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def brpopFuture(key: String, seconds: java.lang.Integer): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.brpop(key, seconds, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[brpopMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def brpopManyFuture(keys: java.util.List[String], seconds: java.lang.Integer): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.brpopMany(keys, seconds, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[brpoplpush]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def brpoplpushFuture(key: String, destkey: String, seconds: java.lang.Integer): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.brpoplpush(key, destkey, seconds, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clientKill]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clientKillFuture(filter: io.vertx.redis.op.KillFilter): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.clientKill(filter, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clientList]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clientListFuture(): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.clientList({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clientGetname]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clientGetnameFuture(): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.clientGetname({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clientPause]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clientPauseFuture(millis: java.lang.Long): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.clientPause(millis, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clientSetname]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clientSetnameFuture(name: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.clientSetname(name, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterAddslots]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterAddslotsFuture(slots: java.util.List[java.lang.Long]): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.clusterAddslots(slots, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterCountFailureReports]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterCountFailureReportsFuture(nodeId: String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.clusterCountFailureReports(nodeId, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterCountkeysinslot]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterCountkeysinslotFuture(slot: java.lang.Long): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.clusterCountkeysinslot(slot, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterDelslots]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterDelslotsFuture(slot: java.lang.Long): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.clusterDelslots(slot, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterDelslotsMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterDelslotsManyFuture(slots: java.util.List[java.lang.Long]): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.clusterDelslotsMany(slots, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterFailover]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterFailoverFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.clusterFailover({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterFailOverWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterFailOverWithOptionsFuture(options: io.vertx.redis.op.FailoverOptions): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.clusterFailOverWithOptions(options, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterForget]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterForgetFuture(nodeId: String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.clusterForget(nodeId, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterGetkeysinslot]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterGetkeysinslotFuture(slot: java.lang.Long, count: java.lang.Long): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.clusterGetkeysinslot(slot, count, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterInfo]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterInfoFuture(): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.clusterInfo({a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterKeyslot]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterKeyslotFuture(key: String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.clusterKeyslot(key, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterMeet]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterMeetFuture(ip: String, port: java.lang.Long): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.clusterMeet(ip, port, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterNodes]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterNodesFuture(): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.clusterNodes({a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterReplicate]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterReplicateFuture(nodeId: String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.clusterReplicate(nodeId, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterReset]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterResetFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.clusterReset({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterResetWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterResetWithOptionsFuture(options: io.vertx.redis.op.ResetOptions): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.clusterResetWithOptions(options, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterSaveconfig]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterSaveconfigFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.clusterSaveconfig({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterSetConfigEpoch]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterSetConfigEpochFuture(epoch: java.lang.Long): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.clusterSetConfigEpoch(epoch, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterSetslot]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterSetslotFuture(slot: java.lang.Long, subcommand: io.vertx.redis.op.SlotCmd): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.clusterSetslot(slot, subcommand, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterSetslotWithNode]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterSetslotWithNodeFuture(slot: java.lang.Long, subcommand: io.vertx.redis.op.SlotCmd, nodeId: String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.clusterSetslotWithNode(slot, subcommand, nodeId, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterSlaves]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterSlavesFuture(nodeId: String): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.clusterSlaves(nodeId, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterSlots]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterSlotsFuture(): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.clusterSlots({a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[command]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def commandFuture(): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.command({a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[commandCount]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def commandCountFuture(): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.commandCount({a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[commandGetkeys]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def commandGetkeysFuture(): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.commandGetkeys({a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[commandInfo]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def commandInfoFuture(commands: java.util.List[String]): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.commandInfo(commands, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[configGet]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def configGetFuture(parameter: String): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.configGet(parameter, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[configRewrite]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def configRewriteFuture(): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.configRewrite({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[configSet]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def configSetFuture(parameter: String, value: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.configSet(parameter, value, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[configResetstat]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def configResetstatFuture(): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.configResetstat({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[dbsize]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def dbsizeFuture(): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.dbsize({a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[debugObject]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def debugObjectFuture(key: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.debugObject(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[debugSegfault]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def debugSegfaultFuture(): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.debugSegfault({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[decr]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def decrFuture(key: String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.decr(key, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[decrby]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def decrbyFuture(key: String, decrement: java.lang.Long): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.decrby(key, decrement, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[del]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def delFuture(key: String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.del(key, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[delMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def delManyFuture(keys: java.util.List[String]): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.delMany(keys, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[dump]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def dumpFuture(key: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.dump(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[echo]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def echoFuture(message: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.echo(message, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[eval]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def evalFuture(script: String, keys: java.util.List[String], args: java.util.List[String]): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.eval(script, keys, args, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[evalsha]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def evalshaFuture(sha1: String, keys: java.util.List[String], values: java.util.List[String]): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.evalsha(sha1, keys, values, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[evalScript]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def evalScriptFuture(script: io.vertx.redis.Script, keys: java.util.List[String], args: java.util.List[String]): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.evalScript(script, keys, args, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[exists]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def existsFuture(key: String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.exists(key, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[existsMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def existsManyFuture(keys: java.util.List[String]): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.existsMany(keys, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[expire]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def expireFuture(key: String, seconds: java.lang.Long): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.expire(key, seconds, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[expireat]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def expireatFuture(key: String, seconds: java.lang.Long): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.expireat(key, seconds, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[flushall]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def flushallFuture(): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.flushall({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[flushdb]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def flushdbFuture(): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.flushdb({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[get]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getFuture(key: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.get(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[getBinary]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getBinaryFuture(key: String): scala.concurrent.Future[io.vertx.core.buffer.Buffer] = {
      val promise = Promise[io.vertx.core.buffer.Buffer]()
      asJava.getBinary(key, {a:AsyncResult[io.vertx.core.buffer.Buffer] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[getbit]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getbitFuture(key: String, offset: java.lang.Long): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.getbit(key, offset, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[getrange]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getrangeFuture(key: String, start: java.lang.Long, end: java.lang.Long): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.getrange(key, start, end, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[getset]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getsetFuture(key: String, value: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.getset(key, value, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hdel]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hdelFuture(key: String, field: String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.hdel(key, field, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hdelMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hdelManyFuture(key: String, fields: java.util.List[String]): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.hdelMany(key, fields, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hexists]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hexistsFuture(key: String, field: String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.hexists(key, field, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hget]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hgetFuture(key: String, field: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.hget(key, field, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hgetall]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hgetallFuture(key: String): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = Promise[io.vertx.core.json.JsonObject]()
      asJava.hgetall(key, {a:AsyncResult[io.vertx.core.json.JsonObject] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hincrby]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hincrbyFuture(key: String, field: String, increment: java.lang.Long): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.hincrby(key, field, increment, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hincrbyfloat]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hincrbyfloatFuture(key: String, field: String, increment: java.lang.Double): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.hincrbyfloat(key, field, increment, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hkeys]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hkeysFuture(key: String): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.hkeys(key, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hlen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hlenFuture(key: String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.hlen(key, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hmget]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hmgetFuture(key: String, fields: java.util.List[String]): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.hmget(key, fields, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hmset]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hmsetFuture(key: String, values: io.vertx.core.json.JsonObject): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.hmset(key, values, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hset]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hsetFuture(key: String, field: String, value: String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.hset(key, field, value, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hsetnx]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hsetnxFuture(key: String, field: String, value: String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.hsetnx(key, field, value, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hvals]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hvalsFuture(key: String): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.hvals(key, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[incr]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def incrFuture(key: String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.incr(key, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[incrby]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def incrbyFuture(key: String, increment: java.lang.Long): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.incrby(key, increment, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[incrbyfloat]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def incrbyfloatFuture(key: String, increment: java.lang.Double): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.incrbyfloat(key, increment, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[info]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def infoFuture(): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = Promise[io.vertx.core.json.JsonObject]()
      asJava.info({a:AsyncResult[io.vertx.core.json.JsonObject] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[infoSection]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def infoSectionFuture(section: String): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = Promise[io.vertx.core.json.JsonObject]()
      asJava.infoSection(section, {a:AsyncResult[io.vertx.core.json.JsonObject] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[keys]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def keysFuture(pattern: String): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.keys(pattern, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[lastsave]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def lastsaveFuture(): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.lastsave({a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[lindex]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def lindexFuture(key: String, index: java.lang.Integer): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.lindex(key, index, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[linsert]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def linsertFuture(key: String, option: io.vertx.redis.op.InsertOptions, pivot: String, value: String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.linsert(key, option, pivot, value, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[llen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def llenFuture(key: String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.llen(key, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[lpop]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def lpopFuture(key: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.lpop(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[lpushMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def lpushManyFuture(key: String, values: java.util.List[String]): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.lpushMany(key, values, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[lpush]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def lpushFuture(key: String, value: String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.lpush(key, value, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[lpushx]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def lpushxFuture(key: String, value: String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.lpushx(key, value, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[lrange]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def lrangeFuture(key: String, from: java.lang.Long, to: java.lang.Long): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.lrange(key, from, to, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[lrem]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def lremFuture(key: String, count: java.lang.Long, value: String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.lrem(key, count, value, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[lset]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def lsetFuture(key: String, index: java.lang.Long, value: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.lset(key, index, value, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[ltrim]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def ltrimFuture(key: String, from: java.lang.Long, to: java.lang.Long): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.ltrim(key, from, to, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[mget]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def mgetFuture(key: String): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.mget(key, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[mgetMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def mgetManyFuture(keys: java.util.List[String]): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.mgetMany(keys, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[migrate]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def migrateFuture(host: String, port: java.lang.Integer, key: String, destdb: java.lang.Integer, timeout: java.lang.Long, options: io.vertx.redis.op.MigrateOptions): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.migrate(host, port, key, destdb, timeout, options, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[monitor]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def monitorFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.monitor({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[move]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def moveFuture(key: String, destdb: java.lang.Integer): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.move(key, destdb, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[mset]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def msetFuture(keyvals: io.vertx.core.json.JsonObject): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.mset(keyvals, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[msetnx]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def msetnxFuture(keyvals: io.vertx.core.json.JsonObject): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.msetnx(keyvals, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[object]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def objectFuture(key: String, cmd: io.vertx.redis.op.ObjectCmd): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.`object`(key, cmd, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[persist]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def persistFuture(key: String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.persist(key, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pexpire]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pexpireFuture(key: String, millis: java.lang.Long): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.pexpire(key, millis, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pexpireat]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pexpireatFuture(key: String, millis: java.lang.Long): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.pexpireat(key, millis, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pfadd]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pfaddFuture(key: String, element: String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.pfadd(key, element, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pfaddMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pfaddManyFuture(key: String, elements: java.util.List[String]): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.pfaddMany(key, elements, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pfcount]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pfcountFuture(key: String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.pfcount(key, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pfcountMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pfcountManyFuture(keys: java.util.List[String]): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.pfcountMany(keys, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pfmerge]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pfmergeFuture(destkey: String, keys: java.util.List[String]): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.pfmerge(destkey, keys, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[ping]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pingFuture(): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.ping({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[psetex]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def psetexFuture(key: String, millis: java.lang.Long, value: String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.psetex(key, millis, value, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[psubscribe]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def psubscribeFuture(pattern: String): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.psubscribe(pattern, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[psubscribeMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def psubscribeManyFuture(patterns: java.util.List[String]): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.psubscribeMany(patterns, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pubsubChannels]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pubsubChannelsFuture(pattern: String): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.pubsubChannels(pattern, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pubsubNumsub]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pubsubNumsubFuture(channels: java.util.List[String]): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.pubsubNumsub(channels, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pubsubNumpat]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pubsubNumpatFuture(): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.pubsubNumpat({a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pttl]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pttlFuture(key: String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.pttl(key, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[publish]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def publishFuture(channel: String, message: String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.publish(channel, message, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[punsubscribe]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def punsubscribeFuture(patterns: java.util.List[String]): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.punsubscribe(patterns, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[randomkey]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def randomkeyFuture(): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.randomkey({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[rename]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def renameFuture(key: String, newkey: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.rename(key, newkey, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[renamenx]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def renamenxFuture(key: String, newkey: String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.renamenx(key, newkey, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[restore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def restoreFuture(key: String, millis: java.lang.Long, serialized: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.restore(key, millis, serialized, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[role]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def roleFuture(): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.role({a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[rpop]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def rpopFuture(key: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.rpop(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[rpoplpush]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def rpoplpushFuture(key: String, destkey: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.rpoplpush(key, destkey, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[rpushMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def rpushManyFuture(key: String, values: java.util.List[String]): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.rpushMany(key, values, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[rpush]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def rpushFuture(key: String, value: String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.rpush(key, value, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[rpushx]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def rpushxFuture(key: String, value: String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.rpushx(key, value, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sadd]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def saddFuture(key: String, member: String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.sadd(key, member, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[saddMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def saddManyFuture(key: String, members: java.util.List[String]): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.saddMany(key, members, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[save]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def saveFuture(): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.save({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[scard]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def scardFuture(key: String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.scard(key, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[scriptExists]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def scriptExistsFuture(script: String): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.scriptExists(script, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[scriptExistsMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def scriptExistsManyFuture(scripts: java.util.List[String]): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.scriptExistsMany(scripts, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[scriptFlush]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def scriptFlushFuture(): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.scriptFlush({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[scriptKill]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def scriptKillFuture(): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.scriptKill({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[scriptLoad]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def scriptLoadFuture(script: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.scriptLoad(script, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sdiff]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sdiffFuture(key: String, cmpkeys: java.util.List[String]): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.sdiff(key, cmpkeys, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sdiffstore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sdiffstoreFuture(destkey: String, key: String, cmpkeys: java.util.List[String]): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.sdiffstore(destkey, key, cmpkeys, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[select]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def selectFuture(dbindex: java.lang.Integer): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.select(dbindex, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[set]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def setFuture(key: String, value: String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.set(key, value, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[setWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def setWithOptionsFuture(key: String, value: String, options: io.vertx.redis.op.SetOptions): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.setWithOptions(key, value, options, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[setBinary]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def setBinaryFuture(key: String, value: io.vertx.core.buffer.Buffer): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.setBinary(key, value, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[setBinaryWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def setBinaryWithOptionsFuture(key: String, value: io.vertx.core.buffer.Buffer, options: io.vertx.redis.op.SetOptions): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.setBinaryWithOptions(key, value, options, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[setbit]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def setbitFuture(key: String, offset: java.lang.Long, bit: java.lang.Integer): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.setbit(key, offset, bit, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[setex]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def setexFuture(key: String, seconds: java.lang.Long, value: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.setex(key, seconds, value, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[setnx]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def setnxFuture(key: String, value: String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.setnx(key, value, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[setrange]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def setrangeFuture(key: String, offset: java.lang.Integer, value: String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.setrange(key, offset, value, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sinter]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sinterFuture(keys: java.util.List[String]): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.sinter(keys, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sinterstore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sinterstoreFuture(destkey: String, keys: java.util.List[String]): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.sinterstore(destkey, keys, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sismember]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sismemberFuture(key: String, member: String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.sismember(key, member, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[slaveof]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def slaveofFuture(host: String, port: java.lang.Integer): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.slaveof(host, port, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[slaveofNoone]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def slaveofNooneFuture(): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.slaveofNoone({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[slowlogGet]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def slowlogGetFuture(limit: java.lang.Integer): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.slowlogGet(limit, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[slowlogLen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def slowlogLenFuture(): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.slowlogLen({a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[slowlogReset]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def slowlogResetFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.slowlogReset({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[smembers]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def smembersFuture(key: String): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.smembers(key, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[smove]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def smoveFuture(key: String, destkey: String, member: String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.smove(key, destkey, member, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sort]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sortFuture(key: String, options: io.vertx.redis.op.SortOptions): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.sort(key, options, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[spop]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def spopFuture(key: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.spop(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[spopMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def spopManyFuture(key: String, count: java.lang.Integer): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.spopMany(key, count, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[srandmember]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def srandmemberFuture(key: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.srandmember(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[srandmemberCount]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def srandmemberCountFuture(key: String, count: java.lang.Integer): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.srandmemberCount(key, count, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[srem]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sremFuture(key: String, member: String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.srem(key, member, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sremMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sremManyFuture(key: String, members: java.util.List[String]): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.sremMany(key, members, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[strlen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def strlenFuture(key: String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.strlen(key, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[subscribe]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def subscribeFuture(channel: String): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.subscribe(channel, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[subscribeMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def subscribeManyFuture(channels: java.util.List[String]): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.subscribeMany(channels, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sunion]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sunionFuture(keys: java.util.List[String]): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.sunion(keys, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sunionstore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sunionstoreFuture(destkey: String, keys: java.util.List[String]): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.sunionstore(destkey, keys, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sync]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def syncFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.sync({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[time]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def timeFuture(): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.time({a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[ttl]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def ttlFuture(key: String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.ttl(key, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[type]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def typeFuture(key: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.`type`(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[unsubscribe]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def unsubscribeFuture(channels: java.util.List[String]): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.unsubscribe(channels, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[wait]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def waitFuture(numSlaves: java.lang.Long, timeout: java.lang.Long): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.wait(numSlaves, timeout, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zadd]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zaddFuture(key: String, score: java.lang.Double, member: String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.zadd(key, score, member, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zaddMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zaddManyFuture(key: String, members: java.util.Map[String, java.lang.Double]): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.zaddMany(key, members, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zcard]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zcardFuture(key: String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.zcard(key, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zcount]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zcountFuture(key: String, min: java.lang.Double, max: java.lang.Double): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.zcount(key, min, max, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zincrby]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zincrbyFuture(key: String, increment: java.lang.Double, member: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.zincrby(key, increment, member, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zinterstore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zinterstoreFuture(destkey: String, sets: java.util.List[String], options: io.vertx.redis.op.AggregateOptions): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.zinterstore(destkey, sets, options, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zinterstoreWeighed]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zinterstoreWeighedFuture(destkey: String, sets: java.util.Map[String, java.lang.Double], options: io.vertx.redis.op.AggregateOptions): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.zinterstoreWeighed(destkey, sets, options, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zlexcount]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zlexcountFuture(key: String, min: String, max: String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.zlexcount(key, min, max, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zrange]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zrangeFuture(key: String, start: java.lang.Long, stop: java.lang.Long): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.zrange(key, start, stop, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zrangeWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zrangeWithOptionsFuture(key: String, start: java.lang.Long, stop: java.lang.Long, options: io.vertx.redis.op.RangeOptions): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.zrangeWithOptions(key, start, stop, options, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zrangebylex]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zrangebylexFuture(key: String, min: String, max: String, options: io.vertx.redis.op.LimitOptions): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.zrangebylex(key, min, max, options, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zrangebyscore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zrangebyscoreFuture(key: String, min: String, max: String, options: io.vertx.redis.op.RangeLimitOptions): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.zrangebyscore(key, min, max, options, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zrank]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zrankFuture(key: String, member: String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.zrank(key, member, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zrem]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zremFuture(key: String, member: String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.zrem(key, member, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zremMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zremManyFuture(key: String, members: java.util.List[String]): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.zremMany(key, members, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zremrangebylex]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zremrangebylexFuture(key: String, min: String, max: String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.zremrangebylex(key, min, max, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zremrangebyrank]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zremrangebyrankFuture(key: String, start: java.lang.Long, stop: java.lang.Long): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.zremrangebyrank(key, start, stop, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zremrangebyscore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zremrangebyscoreFuture(key: String, min: String, max: String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.zremrangebyscore(key, min, max, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zrevrange]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zrevrangeFuture(key: String, start: java.lang.Long, stop: java.lang.Long, options: io.vertx.redis.op.RangeOptions): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.zrevrange(key, start, stop, options, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zrevrangebylex]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zrevrangebylexFuture(key: String, max: String, min: String, options: io.vertx.redis.op.LimitOptions): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.zrevrangebylex(key, max, min, options, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zrevrangebyscore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zrevrangebyscoreFuture(key: String, max: String, min: String, options: io.vertx.redis.op.RangeLimitOptions): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.zrevrangebyscore(key, max, min, options, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zrevrank]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zrevrankFuture(key: String, member: String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.zrevrank(key, member, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zscore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zscoreFuture(key: String, member: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.zscore(key, member, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zunionstore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zunionstoreFuture(destkey: String, sets: java.util.List[String], options: io.vertx.redis.op.AggregateOptions): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.zunionstore(destkey, sets, options, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zunionstoreWeighed]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zunionstoreWeighedFuture(key: String, sets: java.util.Map[String, java.lang.Double], options: io.vertx.redis.op.AggregateOptions): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.zunionstoreWeighed(key, sets, options, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[scan]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def scanFuture(cursor: String, options: io.vertx.redis.op.ScanOptions): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.scan(cursor, options, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sscan]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sscanFuture(key: String, cursor: String, options: io.vertx.redis.op.ScanOptions): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.sscan(key, cursor, options, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hscan]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hscanFuture(key: String, cursor: String, options: io.vertx.redis.op.ScanOptions): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.hscan(key, cursor, options, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zscan]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zscanFuture(key: String, cursor: String, options: io.vertx.redis.op.ScanOptions): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.zscan(key, cursor, options, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[geoadd]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def geoaddFuture(key: String, longitude: java.lang.Double, latitude: java.lang.Double, member: String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.geoadd(key, longitude, latitude, member, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[geoaddMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def geoaddManyFuture(key: String, members: java.util.List[io.vertx.redis.op.GeoMember]): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.geoaddMany(key, members, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[geohash]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def geohashFuture(key: String, member: String): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.geohash(key, member, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[geohashMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def geohashManyFuture(key: String, members: java.util.List[String]): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.geohashMany(key, members, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[geopos]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def geoposFuture(key: String, member: String): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.geopos(key, member, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[geoposMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def geoposManyFuture(key: String, members: java.util.List[String]): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.geoposMany(key, members, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[geodist]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def geodistFuture(key: String, member1: String, member2: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.geodist(key, member1, member2, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[geodistWithUnit]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def geodistWithUnitFuture(key: String, member1: String, member2: String, unit: io.vertx.redis.op.GeoUnit): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.geodistWithUnit(key, member1, member2, unit, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[georadius]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def georadiusFuture(key: String, longitude: java.lang.Double, latitude: java.lang.Double, radius: java.lang.Double, unit: io.vertx.redis.op.GeoUnit): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.georadius(key, longitude, latitude, radius, unit, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[georadiusWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def georadiusWithOptionsFuture(key: String, longitude: java.lang.Double, latitude: java.lang.Double, radius: java.lang.Double, unit: io.vertx.redis.op.GeoUnit, options: io.vertx.redis.op.GeoRadiusOptions): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.georadiusWithOptions(key, longitude, latitude, radius, unit, options, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[georadiusbymember]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def georadiusbymemberFuture(key: String, member: String, radius: java.lang.Double, unit: io.vertx.redis.op.GeoUnit): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.georadiusbymember(key, member, radius, unit, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[georadiusbymemberWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def georadiusbymemberWithOptionsFuture(key: String, member: String, radius: java.lang.Double, unit: io.vertx.redis.op.GeoUnit, options: io.vertx.redis.op.GeoRadiusOptions): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.georadiusbymemberWithOptions(key, member, radius, unit, options, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clientReply]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clientReplyFuture(options: io.vertx.redis.op.ClientReplyOptions): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.clientReply(options, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hstrlen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hstrlenFuture(key: String, field: String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.hstrlen(key, field, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[touch]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def touchFuture(key: String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.touch(key, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[touchMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def touchManyFuture(keys: java.util.List[String]): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.touchMany(keys, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[scriptDebug]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def scriptDebugFuture(scriptDebugOptions: io.vertx.redis.op.ScriptDebugOptions): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.scriptDebug(scriptDebugOptions, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[bitfield]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def bitfieldFuture(key: String, bitFieldOptions: io.vertx.redis.op.BitFieldOptions): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.bitfield(key, bitFieldOptions, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[bitfieldWithOverflow]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def bitfieldWithOverflowFuture(key: String, commands: io.vertx.redis.op.BitFieldOptions, overflow: io.vertx.redis.op.BitFieldOverflowOptions): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.bitfieldWithOverflow(key, commands, overflow, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[unlink]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def unlinkFuture(key: String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.unlink(key, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[unlinkMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def unlinkManyFuture(keys: java.util.List[String]): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.unlinkMany(keys, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[swapdb]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def swapdbFuture(index1: java.lang.Integer, index2: java.lang.Integer): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.swapdb(index1, index2, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }

  type RedisOptions = io.vertx.redis.RedisOptions

  object RedisOptions {
    def apply() = new RedisOptions()
    def apply(json: JsonObject) = new RedisOptions(json)
  }


import io.vertx.core.json.JsonArray
import io.vertx.redis.RedisOptions
import io.vertx.core.Vertx
import io.vertx.redis.{RedisOptions => JRedisOptions}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.core.{Vertx => JVertx}

  /**
   * Interface for sentinel commands
   */
  implicit class RedisSentinelScala(val asJava: io.vertx.redis.sentinel.RedisSentinel) extends AnyVal {

    /**
     * Like [[close]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def closeFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.close({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[masters]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def mastersFuture(): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.masters({a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[master]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def masterFuture(name: String): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.master(name, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[slaves]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def slavesFuture(name: String): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.slaves(name, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sentinels]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sentinelsFuture(name: String): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.sentinels(name, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[getMasterAddrByName]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getMasterAddrByNameFuture(name: String): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.getMasterAddrByName(name, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[reset]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def resetFuture(pattern: String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.reset(pattern, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[failover]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def failoverFuture(name: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.failover(name, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[ckquorum]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def ckquorumFuture(name: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.ckquorum(name, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[flushConfig]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def flushConfigFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.flushConfig({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }

import io.vertx.redis.op.BitOperation
import io.vertx.redis.op.ResetOptions
import io.vertx.redis.op.{ScanOptions => JScanOptions}
import io.vertx.redis.op.ObjectCmd
import io.vertx.redis.op.{SetOptions => JSetOptions}
import io.vertx.redis.op.KillFilter
import io.vertx.redis.op.{LimitOptions => JLimitOptions}
import io.vertx.redis.op.{MigrateOptions => JMigrateOptions}
import io.vertx.redis.op.GeoUnit
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.redis.op.RangeOptions
import io.vertx.redis.op.GeoRadiusOptions
import io.vertx.redis.op.InsertOptions
import io.vertx.redis.op.AggregateOptions
import io.vertx.redis.op.SetOptions
import io.vertx.redis.op.SortOptions
import io.vertx.redis.op.MigrateOptions
import io.vertx.redis.op.ScanOptions
import io.vertx.redis.op.FailoverOptions
import io.vertx.redis.op.{GeoRadiusOptions => JGeoRadiusOptions}
import scala.collection.JavaConverters._
import io.vertx.redis.op.SlotCmd
import io.vertx.redis.op.RangeLimitOptions
import io.vertx.redis.op.{RangeLimitOptions => JRangeLimitOptions}
import io.vertx.redis.op.LimitOptions
import io.vertx.core.json.JsonArray
import io.vertx.core.buffer.Buffer
import io.vertx.redis.op.{SortOptions => JSortOptions}
import io.vertx.core.Handler
import io.vertx.redis.op.{KillFilter => JKillFilter}

  /**
   * This Interface represents a TX
   */
  implicit class RedisTransactionScala(val asJava: io.vertx.redis.RedisTransaction) extends AnyVal {

    /**
     * Like [[close]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def closeFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.close({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[append]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def appendFuture(key: String, value: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.append(key, value, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[auth]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def authFuture(password: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.auth(password, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[bgrewriteaof]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def bgrewriteaofFuture(): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.bgrewriteaof({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[bgsave]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def bgsaveFuture(): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.bgsave({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[bitcount]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def bitcountFuture(key: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.bitcount(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[bitcountRange]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def bitcountRangeFuture(key: String, start: java.lang.Long, end: java.lang.Long): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.bitcountRange(key, start, end, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[bitop]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def bitopFuture(operation: io.vertx.redis.op.BitOperation, destkey: String, keys: java.util.List[String]): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.bitop(operation, destkey, keys, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[bitpos]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def bitposFuture(key: String, bit: java.lang.Integer): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.bitpos(key, bit, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[bitposFrom]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def bitposFromFuture(key: String, bit: java.lang.Integer, start: java.lang.Integer): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.bitposFrom(key, bit, start, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[bitposRange]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def bitposRangeFuture(key: String, bit: java.lang.Integer, start: java.lang.Integer, stop: java.lang.Integer): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.bitposRange(key, bit, start, stop, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[blpop]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def blpopFuture(key: String, seconds: java.lang.Integer): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.blpop(key, seconds, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[blpopMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def blpopManyFuture(keys: java.util.List[String], seconds: java.lang.Integer): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.blpopMany(keys, seconds, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[brpop]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def brpopFuture(key: String, seconds: java.lang.Integer): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.brpop(key, seconds, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[brpopMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def brpopManyFuture(keys: java.util.List[String], seconds: java.lang.Integer): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.brpopMany(keys, seconds, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[brpoplpush]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def brpoplpushFuture(key: String, destkey: String, seconds: java.lang.Integer): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.brpoplpush(key, destkey, seconds, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clientKill]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clientKillFuture(filter: io.vertx.redis.op.KillFilter): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.clientKill(filter, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clientList]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clientListFuture(): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.clientList({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clientGetname]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clientGetnameFuture(): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.clientGetname({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clientPause]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clientPauseFuture(millis: java.lang.Long): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.clientPause(millis, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clientSetname]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clientSetnameFuture(name: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.clientSetname(name, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterAddslots]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterAddslotsFuture(slots: java.util.List[String]): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.clusterAddslots(slots, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterCountFailureReports]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterCountFailureReportsFuture(nodeId: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.clusterCountFailureReports(nodeId, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterCountkeysinslot]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterCountkeysinslotFuture(slot: java.lang.Long): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.clusterCountkeysinslot(slot, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterDelslots]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterDelslotsFuture(slot: java.lang.Long): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.clusterDelslots(slot, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterDelslotsMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterDelslotsManyFuture(slots: java.util.List[String]): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.clusterDelslotsMany(slots, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterFailover]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterFailoverFuture(): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.clusterFailover({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterFailOverWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterFailOverWithOptionsFuture(options: io.vertx.redis.op.FailoverOptions): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.clusterFailOverWithOptions(options, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterForget]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterForgetFuture(nodeId: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.clusterForget(nodeId, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterGetkeysinslot]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterGetkeysinslotFuture(slot: java.lang.Long, count: java.lang.Long): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.clusterGetkeysinslot(slot, count, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterInfo]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterInfoFuture(): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.clusterInfo({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterKeyslot]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterKeyslotFuture(key: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.clusterKeyslot(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterMeet]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterMeetFuture(ip: String, port: java.lang.Long): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.clusterMeet(ip, port, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterNodes]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterNodesFuture(): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.clusterNodes({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterReplicate]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterReplicateFuture(nodeId: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.clusterReplicate(nodeId, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterReset]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterResetFuture(): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.clusterReset({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterResetWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterResetWithOptionsFuture(options: io.vertx.redis.op.ResetOptions): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.clusterResetWithOptions(options, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterSaveconfig]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterSaveconfigFuture(): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.clusterSaveconfig({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterSetConfigEpoch]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterSetConfigEpochFuture(epoch: java.lang.Long): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.clusterSetConfigEpoch(epoch, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterSetslot]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterSetslotFuture(slot: java.lang.Long, subcommand: io.vertx.redis.op.SlotCmd): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.clusterSetslot(slot, subcommand, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterSetslotWithNode]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterSetslotWithNodeFuture(slot: java.lang.Long, subcommand: io.vertx.redis.op.SlotCmd, nodeId: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.clusterSetslotWithNode(slot, subcommand, nodeId, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterSlaves]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterSlavesFuture(nodeId: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.clusterSlaves(nodeId, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[clusterSlots]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def clusterSlotsFuture(): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.clusterSlots({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[command]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def commandFuture(): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.command({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[commandCount]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def commandCountFuture(): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.commandCount({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[commandGetkeys]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def commandGetkeysFuture(): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.commandGetkeys({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[commandInfo]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def commandInfoFuture(commands: java.util.List[String]): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.commandInfo(commands, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[configGet]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def configGetFuture(parameter: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.configGet(parameter, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[configRewrite]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def configRewriteFuture(): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.configRewrite({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[configSet]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def configSetFuture(parameter: String, value: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.configSet(parameter, value, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[configResetstat]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def configResetstatFuture(): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.configResetstat({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[dbsize]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def dbsizeFuture(): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.dbsize({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[debugObject]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def debugObjectFuture(key: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.debugObject(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[debugSegfault]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def debugSegfaultFuture(): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.debugSegfault({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[decr]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def decrFuture(key: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.decr(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[decrby]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def decrbyFuture(key: String, decrement: java.lang.Long): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.decrby(key, decrement, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[del]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def delFuture(key: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.del(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[delMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def delManyFuture(keys: java.util.List[String]): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.delMany(keys, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[discard]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def discardFuture(): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.discard({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[dump]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def dumpFuture(key: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.dump(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[echo]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def echoFuture(message: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.echo(message, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[eval]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def evalFuture(script: String, keys: java.util.List[String], args: java.util.List[String]): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.eval(script, keys, args, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[evalsha]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def evalshaFuture(sha1: String, keys: java.util.List[String], values: java.util.List[String]): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.evalsha(sha1, keys, values, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[exec]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def execFuture(): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.exec({a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[exists]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def existsFuture(key: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.exists(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[existsMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def existsManyFuture(keys: java.util.List[String]): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.existsMany(keys, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[expire]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def expireFuture(key: String, seconds: java.lang.Integer): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.expire(key, seconds, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[expireat]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def expireatFuture(key: String, seconds: java.lang.Long): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.expireat(key, seconds, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[flushall]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def flushallFuture(): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.flushall({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[flushdb]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def flushdbFuture(): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.flushdb({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[get]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getFuture(key: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.get(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[getBinary]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getBinaryFuture(key: String): scala.concurrent.Future[io.vertx.core.buffer.Buffer] = {
      val promise = Promise[io.vertx.core.buffer.Buffer]()
      asJava.getBinary(key, {a:AsyncResult[io.vertx.core.buffer.Buffer] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[getbit]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getbitFuture(key: String, offset: java.lang.Long): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.getbit(key, offset, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[getrange]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getrangeFuture(key: String, start: java.lang.Long, end: java.lang.Long): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.getrange(key, start, end, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[getset]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getsetFuture(key: String, value: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.getset(key, value, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hdel]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hdelFuture(key: String, field: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.hdel(key, field, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hdelMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hdelManyFuture(key: String, fields: java.util.List[String]): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.hdelMany(key, fields, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hexists]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hexistsFuture(key: String, field: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.hexists(key, field, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hget]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hgetFuture(key: String, field: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.hget(key, field, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hgetall]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hgetallFuture(key: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.hgetall(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hincrby]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hincrbyFuture(key: String, field: String, increment: java.lang.Long): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.hincrby(key, field, increment, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hincrbyfloat]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hincrbyfloatFuture(key: String, field: String, increment: java.lang.Double): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.hincrbyfloat(key, field, increment, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hkeys]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hkeysFuture(key: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.hkeys(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hlen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hlenFuture(key: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.hlen(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hmget]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hmgetFuture(key: String, fields: java.util.List[String]): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.hmget(key, fields, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hmset]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hmsetFuture(key: String, values: io.vertx.core.json.JsonObject): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.hmset(key, values, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hset]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hsetFuture(key: String, field: String, value: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.hset(key, field, value, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hsetnx]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hsetnxFuture(key: String, field: String, value: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.hsetnx(key, field, value, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hvals]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hvalsFuture(key: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.hvals(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[incr]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def incrFuture(key: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.incr(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[incrby]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def incrbyFuture(key: String, increment: java.lang.Long): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.incrby(key, increment, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[incrbyfloat]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def incrbyfloatFuture(key: String, increment: java.lang.Double): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.incrbyfloat(key, increment, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[info]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def infoFuture(): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.info({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[infoSection]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def infoSectionFuture(section: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.infoSection(section, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[keys]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def keysFuture(pattern: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.keys(pattern, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[lastsave]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def lastsaveFuture(): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.lastsave({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[lindex]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def lindexFuture(key: String, index: java.lang.Integer): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.lindex(key, index, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[linsert]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def linsertFuture(key: String, option: io.vertx.redis.op.InsertOptions, pivot: String, value: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.linsert(key, option, pivot, value, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[llen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def llenFuture(key: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.llen(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[lpop]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def lpopFuture(key: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.lpop(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[lpushMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def lpushManyFuture(key: String, values: java.util.List[String]): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.lpushMany(key, values, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[lpush]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def lpushFuture(key: String, value: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.lpush(key, value, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[lpushx]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def lpushxFuture(key: String, value: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.lpushx(key, value, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[lrange]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def lrangeFuture(key: String, from: java.lang.Long, to: java.lang.Long): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.lrange(key, from, to, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[lrem]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def lremFuture(key: String, count: java.lang.Long, value: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.lrem(key, count, value, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[lset]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def lsetFuture(key: String, index: java.lang.Long, value: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.lset(key, index, value, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[ltrim]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def ltrimFuture(key: String, from: java.lang.Long, to: java.lang.Long): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.ltrim(key, from, to, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[mget]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def mgetFuture(key: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.mget(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[mgetMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def mgetManyFuture(keys: java.util.List[String]): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.mgetMany(keys, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[migrate]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def migrateFuture(host: String, port: java.lang.Integer, key: String, destdb: java.lang.Integer, timeout: java.lang.Long, options: io.vertx.redis.op.MigrateOptions): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.migrate(host, port, key, destdb, timeout, options, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[monitor]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def monitorFuture(): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.monitor({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[move]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def moveFuture(key: String, destdb: java.lang.Integer): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.move(key, destdb, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[mset]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def msetFuture(keyvals: io.vertx.core.json.JsonObject): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.mset(keyvals, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[msetnx]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def msetnxFuture(keyvals: io.vertx.core.json.JsonObject): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.msetnx(keyvals, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[multi]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def multiFuture(): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.multi({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[object]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def objectFuture(key: String, cmd: io.vertx.redis.op.ObjectCmd): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.`object`(key, cmd, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[persist]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def persistFuture(key: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.persist(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pexpire]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pexpireFuture(key: String, millis: java.lang.Long): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.pexpire(key, millis, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pexpireat]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pexpireatFuture(key: String, millis: java.lang.Long): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.pexpireat(key, millis, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pfadd]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pfaddFuture(key: String, element: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.pfadd(key, element, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pfaddMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pfaddManyFuture(key: String, elements: java.util.List[String]): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.pfaddMany(key, elements, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pfcount]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pfcountFuture(key: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.pfcount(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pfcountMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pfcountManyFuture(keys: java.util.List[String]): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.pfcountMany(keys, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pfmerge]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pfmergeFuture(destkey: String, keys: java.util.List[String]): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.pfmerge(destkey, keys, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[ping]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pingFuture(): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.ping({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[psetex]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def psetexFuture(key: String, millis: java.lang.Long, value: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.psetex(key, millis, value, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[psubscribe]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def psubscribeFuture(pattern: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.psubscribe(pattern, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[psubscribeMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def psubscribeManyFuture(patterns: java.util.List[String]): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.psubscribeMany(patterns, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pubsubChannels]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pubsubChannelsFuture(pattern: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.pubsubChannels(pattern, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pubsubNumsub]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pubsubNumsubFuture(channels: java.util.List[String]): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.pubsubNumsub(channels, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pubsubNumpat]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pubsubNumpatFuture(): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.pubsubNumpat({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pttl]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pttlFuture(key: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.pttl(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[publish]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def publishFuture(channel: String, message: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.publish(channel, message, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[punsubscribe]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def punsubscribeFuture(patterns: java.util.List[String]): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.punsubscribe(patterns, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[randomkey]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def randomkeyFuture(): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.randomkey({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[rename]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def renameFuture(key: String, newkey: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.rename(key, newkey, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[renamenx]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def renamenxFuture(key: String, newkey: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.renamenx(key, newkey, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[restore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def restoreFuture(key: String, millis: java.lang.Long, serialized: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.restore(key, millis, serialized, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[role]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def roleFuture(): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.role({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[rpop]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def rpopFuture(key: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.rpop(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[rpoplpush]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def rpoplpushFuture(key: String, destkey: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.rpoplpush(key, destkey, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[rpushMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def rpushManyFuture(key: String, values: java.util.List[String]): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.rpushMany(key, values, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[rpush]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def rpushFuture(key: String, value: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.rpush(key, value, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[rpushx]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def rpushxFuture(key: String, value: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.rpushx(key, value, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sadd]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def saddFuture(key: String, member: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.sadd(key, member, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[saddMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def saddManyFuture(key: String, members: java.util.List[String]): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.saddMany(key, members, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[save]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def saveFuture(): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.save({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[scard]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def scardFuture(key: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.scard(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[scriptExists]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def scriptExistsFuture(script: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.scriptExists(script, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[scriptExistsMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def scriptExistsManyFuture(scripts: java.util.List[String]): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.scriptExistsMany(scripts, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[scriptFlush]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def scriptFlushFuture(): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.scriptFlush({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[scriptKill]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def scriptKillFuture(): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.scriptKill({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[scriptLoad]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def scriptLoadFuture(script: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.scriptLoad(script, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sdiff]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sdiffFuture(key: String, cmpkeys: java.util.List[String]): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.sdiff(key, cmpkeys, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sdiffstore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sdiffstoreFuture(destkey: String, key: String, cmpkeys: java.util.List[String]): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.sdiffstore(destkey, key, cmpkeys, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[select]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def selectFuture(dbindex: java.lang.Integer): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.select(dbindex, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[set]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def setFuture(key: String, value: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.set(key, value, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[setWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def setWithOptionsFuture(key: String, value: String, options: io.vertx.redis.op.SetOptions): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.setWithOptions(key, value, options, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[setBinary]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def setBinaryFuture(key: String, value: io.vertx.core.buffer.Buffer): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.setBinary(key, value, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[setBinaryWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def setBinaryWithOptionsFuture(key: String, value: io.vertx.core.buffer.Buffer, options: io.vertx.redis.op.SetOptions): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.setBinaryWithOptions(key, value, options, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[setbit]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def setbitFuture(key: String, offset: java.lang.Long, bit: java.lang.Integer): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.setbit(key, offset, bit, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[setex]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def setexFuture(key: String, seconds: java.lang.Long, value: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.setex(key, seconds, value, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[setnx]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def setnxFuture(key: String, value: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.setnx(key, value, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[setrange]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def setrangeFuture(key: String, offset: java.lang.Integer, value: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.setrange(key, offset, value, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sinter]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sinterFuture(keys: java.util.List[String]): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.sinter(keys, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sinterstore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sinterstoreFuture(destkey: String, keys: java.util.List[String]): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.sinterstore(destkey, keys, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sismember]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sismemberFuture(key: String, member: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.sismember(key, member, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[slaveof]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def slaveofFuture(host: String, port: java.lang.Integer): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.slaveof(host, port, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[slaveofNoone]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def slaveofNooneFuture(): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.slaveofNoone({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[slowlogGet]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def slowlogGetFuture(limit: java.lang.Integer): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.slowlogGet(limit, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[slowlogLen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def slowlogLenFuture(): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.slowlogLen({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[slowlogReset]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def slowlogResetFuture(): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.slowlogReset({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[smembers]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def smembersFuture(key: String): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.smembers(key, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[smove]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def smoveFuture(key: String, destkey: String, member: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.smove(key, destkey, member, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sort]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sortFuture(key: String, options: io.vertx.redis.op.SortOptions): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.sort(key, options, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[spop]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def spopFuture(key: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.spop(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[spopMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def spopManyFuture(key: String, count: java.lang.Integer): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.spopMany(key, count, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[srandmember]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def srandmemberFuture(key: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.srandmember(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[srandmemberCount]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def srandmemberCountFuture(key: String, count: java.lang.Integer): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.srandmemberCount(key, count, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[srem]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sremFuture(key: String, member: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.srem(key, member, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sremMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sremManyFuture(key: String, members: java.util.List[String]): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.sremMany(key, members, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[strlen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def strlenFuture(key: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.strlen(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[subscribe]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def subscribeFuture(channel: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.subscribe(channel, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[subscribeMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def subscribeManyFuture(channels: java.util.List[String]): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.subscribeMany(channels, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sunion]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sunionFuture(keys: java.util.List[String]): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.sunion(keys, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sunionstore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sunionstoreFuture(destkey: String, keys: java.util.List[String]): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.sunionstore(destkey, keys, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sync]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def syncFuture(): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.sync({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[time]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def timeFuture(): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.time({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[ttl]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def ttlFuture(key: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.ttl(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[type]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def typeFuture(key: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.`type`(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[unsubscribe]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def unsubscribeFuture(channels: java.util.List[String]): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.unsubscribe(channels, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[unwatch]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def unwatchFuture(): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.unwatch({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[wait]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def waitFuture(numSlaves: java.lang.Long, timeout: java.lang.Long): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.wait(numSlaves, timeout, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[watch]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def watchFuture(key: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.watch(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[watchMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def watchManyFuture(keys: java.util.List[String]): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.watchMany(keys, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zadd]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zaddFuture(key: String, score: java.lang.Double, member: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.zadd(key, score, member, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zaddMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zaddManyFuture(key: String, members: java.util.Map[String, java.lang.Double]): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.zaddMany(key, members, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zcard]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zcardFuture(key: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.zcard(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zcount]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zcountFuture(key: String, min: java.lang.Double, max: java.lang.Double): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.zcount(key, min, max, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zincrby]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zincrbyFuture(key: String, increment: java.lang.Double, member: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.zincrby(key, increment, member, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zinterstore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zinterstoreFuture(destkey: String, sets: java.util.List[String], options: io.vertx.redis.op.AggregateOptions): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.zinterstore(destkey, sets, options, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zinterstoreWeighed]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zinterstoreWeighedFuture(destkey: String, sets: java.util.Map[String, java.lang.Double], options: io.vertx.redis.op.AggregateOptions): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.zinterstoreWeighed(destkey, sets, options, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zlexcount]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zlexcountFuture(key: String, min: String, max: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.zlexcount(key, min, max, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zrange]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zrangeFuture(key: String, start: java.lang.Long, stop: java.lang.Long): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.zrange(key, start, stop, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zrangeWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zrangeWithOptionsFuture(key: String, start: java.lang.Long, stop: java.lang.Long, options: io.vertx.redis.op.RangeOptions): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.zrangeWithOptions(key, start, stop, options, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zrangebylex]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zrangebylexFuture(key: String, min: String, max: String, options: io.vertx.redis.op.LimitOptions): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.zrangebylex(key, min, max, options, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zrangebyscore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zrangebyscoreFuture(key: String, min: String, max: String, options: io.vertx.redis.op.RangeLimitOptions): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.zrangebyscore(key, min, max, options, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zrank]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zrankFuture(key: String, member: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.zrank(key, member, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zrem]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zremFuture(key: String, member: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.zrem(key, member, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zremMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zremManyFuture(key: String, members: java.util.List[String]): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.zremMany(key, members, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zremrangebylex]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zremrangebylexFuture(key: String, min: String, max: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.zremrangebylex(key, min, max, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zremrangebyrank]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zremrangebyrankFuture(key: String, start: java.lang.Long, stop: java.lang.Long): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.zremrangebyrank(key, start, stop, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zremrangebyscore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zremrangebyscoreFuture(key: String, min: String, max: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.zremrangebyscore(key, min, max, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zrevrange]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zrevrangeFuture(key: String, start: java.lang.Long, stop: java.lang.Long, options: io.vertx.redis.op.RangeOptions): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.zrevrange(key, start, stop, options, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zrevrangebylex]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zrevrangebylexFuture(key: String, max: String, min: String, options: io.vertx.redis.op.LimitOptions): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.zrevrangebylex(key, max, min, options, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zrevrangebyscore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zrevrangebyscoreFuture(key: String, max: String, min: String, options: io.vertx.redis.op.RangeLimitOptions): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.zrevrangebyscore(key, max, min, options, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zrevrank]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zrevrankFuture(key: String, member: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.zrevrank(key, member, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zscore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zscoreFuture(key: String, member: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.zscore(key, member, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zunionstore]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zunionstoreFuture(destkey: String, sets: java.util.List[String], options: io.vertx.redis.op.AggregateOptions): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.zunionstore(destkey, sets, options, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zunionstoreWeighed]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zunionstoreWeighedFuture(key: String, sets: java.util.Map[String, java.lang.Double], options: io.vertx.redis.op.AggregateOptions): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.zunionstoreWeighed(key, sets, options, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[scan]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def scanFuture(cursor: String, options: io.vertx.redis.op.ScanOptions): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.scan(cursor, options, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[sscan]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sscanFuture(key: String, cursor: String, options: io.vertx.redis.op.ScanOptions): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.sscan(key, cursor, options, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[hscan]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def hscanFuture(key: String, cursor: String, options: io.vertx.redis.op.ScanOptions): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.hscan(key, cursor, options, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[zscan]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def zscanFuture(key: String, cursor: String, options: io.vertx.redis.op.ScanOptions): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.zscan(key, cursor, options, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[geoadd]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def geoaddFuture(key: String, longitude: java.lang.Double, latitude: java.lang.Double, member: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.geoadd(key, longitude, latitude, member, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[geoaddMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def geoaddManyFuture(key: String, members: java.util.List[io.vertx.redis.op.GeoMember]): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.geoaddMany(key, members, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[geohash]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def geohashFuture(key: String, member: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.geohash(key, member, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[geohashMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def geohashManyFuture(key: String, members: java.util.List[String]): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.geohashMany(key, members, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[geopos]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def geoposFuture(key: String, member: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.geopos(key, member, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[geoposMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def geoposManyFuture(key: String, members: java.util.List[String]): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.geoposMany(key, members, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[geodist]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def geodistFuture(key: String, member1: String, member2: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.geodist(key, member1, member2, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[geodistWithUnit]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def geodistWithUnitFuture(key: String, member1: String, member2: String, unit: io.vertx.redis.op.GeoUnit): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.geodistWithUnit(key, member1, member2, unit, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[georadius]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def georadiusFuture(key: String, longitude: java.lang.Double, latitude: java.lang.Double, radius: java.lang.Double, unit: io.vertx.redis.op.GeoUnit): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.georadius(key, longitude, latitude, radius, unit, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[georadiusWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def georadiusWithOptionsFuture(key: String, longitude: java.lang.Double, latitude: java.lang.Double, radius: java.lang.Double, unit: io.vertx.redis.op.GeoUnit, options: io.vertx.redis.op.GeoRadiusOptions): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.georadiusWithOptions(key, longitude, latitude, radius, unit, options, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[georadiusbymember]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def georadiusbymemberFuture(key: String, member: String, radius: java.lang.Double, unit: io.vertx.redis.op.GeoUnit): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.georadiusbymember(key, member, radius, unit, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[georadiusbymemberWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def georadiusbymemberWithOptionsFuture(key: String, member: String, radius: java.lang.Double, unit: io.vertx.redis.op.GeoUnit, options: io.vertx.redis.op.GeoRadiusOptions): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.georadiusbymemberWithOptions(key, member, radius, unit, options, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[unlink]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def unlinkFuture(key: String): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.unlink(key, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[unlinkMany]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def unlinkManyFuture(keys: java.util.List[String]): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.unlinkMany(keys, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[swapdb]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def swapdbFuture(index1: java.lang.Integer, index2: java.lang.Integer): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.swapdb(index1, index2, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }

  type ScanOptions = io.vertx.redis.op.ScanOptions

  object ScanOptions {
    def apply() = new ScanOptions()
    def apply(json: JsonObject) = new ScanOptions(json)
  }


  type SetOptions = io.vertx.redis.op.SetOptions

  object SetOptions {
    def apply() = new SetOptions()
    def apply(json: JsonObject) = new SetOptions(json)
  }


  type SortOptions = io.vertx.redis.op.SortOptions

  object SortOptions {
    def apply() = new SortOptions()
    def apply(json: JsonObject) = new SortOptions(json)
  }


}
