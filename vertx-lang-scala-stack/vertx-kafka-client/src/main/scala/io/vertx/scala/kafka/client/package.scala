//MODULE: vertx-kafka-client
//MODULE: io.vertx.kafka.client
//MODULE: io.vertx
//MODULE: io.vertx.scala.kafka.client
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

package object client{


import io.vertx.kafka.client.consumer.OffsetAndMetadata
import io.vertx.core.Vertx
import io.vertx.kafka.client.consumer.KafkaConsumerRecords
import scala.collection.JavaConverters._
import io.vertx.kafka.client.common.{TopicPartition => JTopicPartition}
import io.vertx.core.{Vertx => JVertx}
import io.vertx.kafka.client.common.TopicPartition
import io.vertx.kafka.client.consumer.{OffsetAndTimestamp => JOffsetAndTimestamp}
import io.vertx.kafka.client.consumer.{KafkaConsumerRecords => JKafkaConsumerRecords}
import io.vertx.kafka.client.consumer.{OffsetAndMetadata => JOffsetAndMetadata}
import io.vertx.kafka.client.consumer.KafkaConsumerRecord
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.kafka.client.consumer.{KafkaConsumerRecord => JKafkaConsumerRecord}
import io.vertx.kafka.client.consumer.OffsetAndTimestamp

  /**
   * Vert.x Kafka consumer.
   * 
   * You receive Kafka records by providing a [[io.vertx.kafka.client.consumer.KafkaConsumer#handler]]. As messages arrive the handler
   * will be called with the records.
   * 
   * The [[io.vertx.kafka.client.consumer.KafkaConsumer#pause]] and [[io.vertx.kafka.client.consumer.KafkaConsumer#resume]] provides global control over reading the records from the consumer.
   * 
   * The [[io.vertx.kafka.client.consumer.KafkaConsumer#pause]] and [[io.vertx.kafka.client.consumer.KafkaConsumer#resume]] provides finer grained control over reading records
   * for specific Topic/Partition, these are Kafka's specific operations.
   */
  implicit class KafkaConsumerScala[K, V](val asJava: io.vertx.kafka.client.consumer.KafkaConsumer[K, V]) extends AnyVal {

    /**
     * Like [[subscribe]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def subscribeFuture(topic: String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.subscribe(topic, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[subscribe]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def subscribeFuture(topics: java.util.Set[String]): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.subscribe(topics, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[assign]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def assignFuture(topicPartition: io.vertx.kafka.client.common.TopicPartition): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.assign(topicPartition, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[assign]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def assignFuture(topicPartitions: java.util.Set[io.vertx.kafka.client.common.TopicPartition]): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.assign(topicPartitions, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[assignment]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def assignmentFuture(): scala.concurrent.Future[java.util.Set[io.vertx.kafka.client.common.TopicPartition]] = {
      val promise = Promise[java.util.Set[io.vertx.kafka.client.common.TopicPartition]]()
      asJava.assignment({a:AsyncResult[java.util.Set[io.vertx.kafka.client.common.TopicPartition]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[unsubscribe]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def unsubscribeFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.unsubscribe({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[subscription]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def subscriptionFuture(): scala.concurrent.Future[java.util.Set[String]] = {
      val promise = Promise[java.util.Set[String]]()
      asJava.subscription({a:AsyncResult[java.util.Set[java.lang.String]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pause]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pauseFuture(topicPartition: io.vertx.kafka.client.common.TopicPartition): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.pause(topicPartition, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[pause]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pauseFuture(topicPartitions: java.util.Set[io.vertx.kafka.client.common.TopicPartition]): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.pause(topicPartitions, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[paused]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pausedFuture(): scala.concurrent.Future[java.util.Set[io.vertx.kafka.client.common.TopicPartition]] = {
      val promise = Promise[java.util.Set[io.vertx.kafka.client.common.TopicPartition]]()
      asJava.paused({a:AsyncResult[java.util.Set[io.vertx.kafka.client.common.TopicPartition]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[resume]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def resumeFuture(topicPartition: io.vertx.kafka.client.common.TopicPartition): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.resume(topicPartition, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[resume]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def resumeFuture(topicPartitions: java.util.Set[io.vertx.kafka.client.common.TopicPartition]): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.resume(topicPartitions, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[seek]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def seekFuture(topicPartition: io.vertx.kafka.client.common.TopicPartition, offset: java.lang.Long): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.seek(topicPartition, offset, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[seekToBeginning]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def seekToBeginningFuture(topicPartition: io.vertx.kafka.client.common.TopicPartition): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.seekToBeginning(topicPartition, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[seekToBeginning]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def seekToBeginningFuture(topicPartitions: java.util.Set[io.vertx.kafka.client.common.TopicPartition]): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.seekToBeginning(topicPartitions, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[seekToEnd]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def seekToEndFuture(topicPartition: io.vertx.kafka.client.common.TopicPartition): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.seekToEnd(topicPartition, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[seekToEnd]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def seekToEndFuture(topicPartitions: java.util.Set[io.vertx.kafka.client.common.TopicPartition]): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.seekToEnd(topicPartitions, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[commit]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def commitFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.commit({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[committed]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def committedFuture(topicPartition: io.vertx.kafka.client.common.TopicPartition): scala.concurrent.Future[io.vertx.kafka.client.consumer.OffsetAndMetadata] = {
      val promise = Promise[io.vertx.kafka.client.consumer.OffsetAndMetadata]()
      asJava.committed(topicPartition, {a:AsyncResult[io.vertx.kafka.client.consumer.OffsetAndMetadata] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[partitionsFor]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def partitionsForFuture(topic: String): scala.concurrent.Future[java.util.List[io.vertx.kafka.client.common.PartitionInfo]] = {
      val promise = Promise[java.util.List[io.vertx.kafka.client.common.PartitionInfo]]()
      asJava.partitionsFor(topic, {a:AsyncResult[java.util.List[io.vertx.kafka.client.common.PartitionInfo]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
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
     * Like [[position]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def positionFuture(partition: io.vertx.kafka.client.common.TopicPartition): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.position(partition, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[offsetsForTimes]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def offsetsForTimesFuture(topicPartition: io.vertx.kafka.client.common.TopicPartition, timestamp: java.lang.Long): scala.concurrent.Future[io.vertx.kafka.client.consumer.OffsetAndTimestamp] = {
      val promise = Promise[io.vertx.kafka.client.consumer.OffsetAndTimestamp]()
      asJava.offsetsForTimes(topicPartition, timestamp, {a:AsyncResult[io.vertx.kafka.client.consumer.OffsetAndTimestamp] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[beginningOffsets]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def beginningOffsetsFuture(topicPartition: io.vertx.kafka.client.common.TopicPartition): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.beginningOffsets(topicPartition, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[endOffsets]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def endOffsetsFuture(topicPartition: io.vertx.kafka.client.common.TopicPartition): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.endOffsets(topicPartition, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }

import io.vertx.kafka.client.producer.RecordMetadata
import io.vertx.core.Vertx
import io.vertx.kafka.client.producer.{RecordMetadata => JRecordMetadata}
import io.vertx.core.AsyncResult
import scala.collection.JavaConverters._
import io.vertx.core.Handler
import io.vertx.kafka.client.producer.KafkaProducerRecord
import io.vertx.kafka.client.producer.{KafkaProducerRecord => JKafkaProducerRecord}
import io.vertx.core.{Vertx => JVertx}

  /**
   * Vert.x Kafka producer.
   * 
   * The  provides global control over writing a record.
   */
  implicit class KafkaProducerScala[K, V](val asJava: io.vertx.kafka.client.producer.KafkaProducer[K, V]) extends AnyVal {

    /**
     * Like [[write]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def writeFuture(record: io.vertx.kafka.client.producer.KafkaProducerRecord[K, V]): scala.concurrent.Future[io.vertx.kafka.client.producer.RecordMetadata] = {
      val promise = Promise[io.vertx.kafka.client.producer.RecordMetadata]()
      asJava.write(record, {a:AsyncResult[io.vertx.kafka.client.producer.RecordMetadata] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[partitionsFor]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def partitionsForFuture(topic: String): scala.concurrent.Future[java.util.List[io.vertx.kafka.client.common.PartitionInfo]] = {
      val promise = Promise[java.util.List[io.vertx.kafka.client.common.PartitionInfo]]()
      asJava.partitionsFor(topic, {a:AsyncResult[java.util.List[io.vertx.kafka.client.common.PartitionInfo]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
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
     * Like [[close]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def closeFuture(timeout: java.lang.Long): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.close(timeout, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }

  type Node = io.vertx.kafka.client.common.Node

  object Node {
    def apply() = new Node()
    def apply(json: JsonObject) = new Node(json)
  }


  type OffsetAndMetadata = io.vertx.kafka.client.consumer.OffsetAndMetadata

  object OffsetAndMetadata {
    def apply() = new OffsetAndMetadata()
    def apply(json: JsonObject) = new OffsetAndMetadata(json)
  }


  type OffsetAndTimestamp = io.vertx.kafka.client.consumer.OffsetAndTimestamp

  object OffsetAndTimestamp {
    def apply() = new OffsetAndTimestamp()
    def apply(json: JsonObject) = new OffsetAndTimestamp(json)
  }


  type PartitionInfo = io.vertx.kafka.client.common.PartitionInfo

  object PartitionInfo {
    def apply() = new PartitionInfo()
    def apply(json: JsonObject) = new PartitionInfo(json)
  }


  type RecordMetadata = io.vertx.kafka.client.producer.RecordMetadata

  object RecordMetadata {
    def apply() = new RecordMetadata()
    def apply(json: JsonObject) = new RecordMetadata(json)
  }


  type TopicPartition = io.vertx.kafka.client.common.TopicPartition

  object TopicPartition {
    def apply() = new TopicPartition()
    def apply(json: JsonObject) = new TopicPartition(json)
  }


}
