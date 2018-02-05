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

package io.vertx.scala.codegen
import scala.collection.JavaConverters._
import scala.compat.java8.FunctionConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import scala.reflect.runtime.universe._
import scala.concurrent.Promise

package object testmodel{


import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.AsyncResult
import scala.collection.JavaConverters._
import io.vertx.core.Handler

  /**
   */
  implicit class CollectionTCKScala(val asJava: io.vertx.codegen.testmodel.CollectionTCK) extends AnyVal {

    def methodWithHandlerAsyncResultListStringFuture(): scala.concurrent.Future[java.util.List[String]] = {
      val promise = Promise[java.util.List[String]]()
      asJava.methodWithHandlerAsyncResultListString({a:AsyncResult[java.util.List[java.lang.String]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithHandlerAsyncResultListIntegerFuture(): scala.concurrent.Future[java.util.List[java.lang.Integer]] = {
      val promise = Promise[java.util.List[java.lang.Integer]]()
      asJava.methodWithHandlerAsyncResultListInteger({a:AsyncResult[java.util.List[java.lang.Integer]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithHandlerAsyncResultSetStringFuture(): scala.concurrent.Future[java.util.Set[String]] = {
      val promise = Promise[java.util.Set[String]]()
      asJava.methodWithHandlerAsyncResultSetString({a:AsyncResult[java.util.Set[java.lang.String]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithHandlerAsyncResultSetIntegerFuture(): scala.concurrent.Future[java.util.Set[java.lang.Integer]] = {
      val promise = Promise[java.util.Set[java.lang.Integer]]()
      asJava.methodWithHandlerAsyncResultSetInteger({a:AsyncResult[java.util.Set[java.lang.Integer]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithHandlerAsyncResultListVertxGenFuture(): scala.concurrent.Future[java.util.List[io.vertx.codegen.testmodel.RefedInterface1]] = {
      val promise = Promise[java.util.List[io.vertx.codegen.testmodel.RefedInterface1]]()
      asJava.methodWithHandlerAsyncResultListVertxGen({a:AsyncResult[java.util.List[io.vertx.codegen.testmodel.RefedInterface1]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithHandlerAsyncResultListAbstractVertxGenFuture(): scala.concurrent.Future[java.util.List[io.vertx.codegen.testmodel.RefedInterface2]] = {
      val promise = Promise[java.util.List[io.vertx.codegen.testmodel.RefedInterface2]]()
      asJava.methodWithHandlerAsyncResultListAbstractVertxGen({a:AsyncResult[java.util.List[io.vertx.codegen.testmodel.RefedInterface2]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithHandlerAsyncResultListJsonObjectFuture(): scala.concurrent.Future[java.util.List[io.vertx.core.json.JsonObject]] = {
      val promise = Promise[java.util.List[io.vertx.core.json.JsonObject]]()
      asJava.methodWithHandlerAsyncResultListJsonObject({a:AsyncResult[java.util.List[io.vertx.core.json.JsonObject]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithHandlerAsyncResultListComplexJsonObjectFuture(): scala.concurrent.Future[java.util.List[io.vertx.core.json.JsonObject]] = {
      val promise = Promise[java.util.List[io.vertx.core.json.JsonObject]]()
      asJava.methodWithHandlerAsyncResultListComplexJsonObject({a:AsyncResult[java.util.List[io.vertx.core.json.JsonObject]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithHandlerAsyncResultListJsonArrayFuture(): scala.concurrent.Future[java.util.List[io.vertx.core.json.JsonArray]] = {
      val promise = Promise[java.util.List[io.vertx.core.json.JsonArray]]()
      asJava.methodWithHandlerAsyncResultListJsonArray({a:AsyncResult[java.util.List[io.vertx.core.json.JsonArray]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithHandlerAsyncResultListComplexJsonArrayFuture(): scala.concurrent.Future[java.util.List[io.vertx.core.json.JsonArray]] = {
      val promise = Promise[java.util.List[io.vertx.core.json.JsonArray]]()
      asJava.methodWithHandlerAsyncResultListComplexJsonArray({a:AsyncResult[java.util.List[io.vertx.core.json.JsonArray]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithHandlerAsyncResultListDataObjectFuture(): scala.concurrent.Future[java.util.List[io.vertx.codegen.testmodel.TestDataObject]] = {
      val promise = Promise[java.util.List[io.vertx.codegen.testmodel.TestDataObject]]()
      asJava.methodWithHandlerAsyncResultListDataObject({a:AsyncResult[java.util.List[io.vertx.codegen.testmodel.TestDataObject]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithHandlerAsyncResultListEnumFuture(): scala.concurrent.Future[java.util.List[io.vertx.codegen.testmodel.TestEnum]] = {
      val promise = Promise[java.util.List[io.vertx.codegen.testmodel.TestEnum]]()
      asJava.methodWithHandlerAsyncResultListEnum({a:AsyncResult[java.util.List[io.vertx.codegen.testmodel.TestEnum]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithHandlerAsyncResultSetVertxGenFuture(): scala.concurrent.Future[java.util.Set[io.vertx.codegen.testmodel.RefedInterface1]] = {
      val promise = Promise[java.util.Set[io.vertx.codegen.testmodel.RefedInterface1]]()
      asJava.methodWithHandlerAsyncResultSetVertxGen({a:AsyncResult[java.util.Set[io.vertx.codegen.testmodel.RefedInterface1]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithHandlerAsyncResultSetAbstractVertxGenFuture(): scala.concurrent.Future[java.util.Set[io.vertx.codegen.testmodel.RefedInterface2]] = {
      val promise = Promise[java.util.Set[io.vertx.codegen.testmodel.RefedInterface2]]()
      asJava.methodWithHandlerAsyncResultSetAbstractVertxGen({a:AsyncResult[java.util.Set[io.vertx.codegen.testmodel.RefedInterface2]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithHandlerAsyncResultSetJsonObjectFuture(): scala.concurrent.Future[java.util.Set[io.vertx.core.json.JsonObject]] = {
      val promise = Promise[java.util.Set[io.vertx.core.json.JsonObject]]()
      asJava.methodWithHandlerAsyncResultSetJsonObject({a:AsyncResult[java.util.Set[io.vertx.core.json.JsonObject]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithHandlerAsyncResultSetComplexJsonObjectFuture(): scala.concurrent.Future[java.util.Set[io.vertx.core.json.JsonObject]] = {
      val promise = Promise[java.util.Set[io.vertx.core.json.JsonObject]]()
      asJava.methodWithHandlerAsyncResultSetComplexJsonObject({a:AsyncResult[java.util.Set[io.vertx.core.json.JsonObject]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithHandlerAsyncResultSetJsonArrayFuture(): scala.concurrent.Future[java.util.Set[io.vertx.core.json.JsonArray]] = {
      val promise = Promise[java.util.Set[io.vertx.core.json.JsonArray]]()
      asJava.methodWithHandlerAsyncResultSetJsonArray({a:AsyncResult[java.util.Set[io.vertx.core.json.JsonArray]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithHandlerAsyncResultSetComplexJsonArrayFuture(): scala.concurrent.Future[java.util.Set[io.vertx.core.json.JsonArray]] = {
      val promise = Promise[java.util.Set[io.vertx.core.json.JsonArray]]()
      asJava.methodWithHandlerAsyncResultSetComplexJsonArray({a:AsyncResult[java.util.Set[io.vertx.core.json.JsonArray]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithHandlerAsyncResultSetDataObjectFuture(): scala.concurrent.Future[java.util.Set[io.vertx.codegen.testmodel.TestDataObject]] = {
      val promise = Promise[java.util.Set[io.vertx.codegen.testmodel.TestDataObject]]()
      asJava.methodWithHandlerAsyncResultSetDataObject({a:AsyncResult[java.util.Set[io.vertx.codegen.testmodel.TestDataObject]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithHandlerAsyncResultSetEnumFuture(): scala.concurrent.Future[java.util.Set[io.vertx.codegen.testmodel.TestEnum]] = {
      val promise = Promise[java.util.Set[io.vertx.codegen.testmodel.TestEnum]]()
      asJava.methodWithHandlerAsyncResultSetEnum({a:AsyncResult[java.util.Set[io.vertx.codegen.testmodel.TestEnum]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }

  type DataObjectWithBuffer = io.vertx.codegen.testmodel.DataObjectWithBuffer

  object DataObjectWithBuffer {
    def apply() = new DataObjectWithBuffer()
    def apply(json: JsonObject) = new DataObjectWithBuffer(json)
  }


  type DataObjectWithListAdders = io.vertx.codegen.testmodel.DataObjectWithListAdders

  object DataObjectWithListAdders {
    def apply() = new DataObjectWithListAdders()
    def apply(json: JsonObject) = new DataObjectWithListAdders(json)
  }


  type DataObjectWithLists = io.vertx.codegen.testmodel.DataObjectWithLists

  object DataObjectWithLists {
    def apply() = new DataObjectWithLists()
    def apply(json: JsonObject) = new DataObjectWithLists(json)
  }


  type DataObjectWithMapAdders = io.vertx.codegen.testmodel.DataObjectWithMapAdders

  object DataObjectWithMapAdders {
    def apply() = new DataObjectWithMapAdders()
    def apply(json: JsonObject) = new DataObjectWithMapAdders(json)
  }


  type DataObjectWithMaps = io.vertx.codegen.testmodel.DataObjectWithMaps

  object DataObjectWithMaps {
    def apply() = new DataObjectWithMaps()
    def apply(json: JsonObject) = new DataObjectWithMaps(json)
  }


  type DataObjectWithNestedBuffer = io.vertx.codegen.testmodel.DataObjectWithNestedBuffer

  object DataObjectWithNestedBuffer {
    def apply() = new DataObjectWithNestedBuffer()
    def apply(json: JsonObject) = new DataObjectWithNestedBuffer(json)
  }


  type DataObjectWithOnlyJsonObjectConstructor = io.vertx.codegen.testmodel.DataObjectWithOnlyJsonObjectConstructor

  object DataObjectWithOnlyJsonObjectConstructor {
        def apply(json: JsonObject) = new DataObjectWithOnlyJsonObjectConstructor(json)
  }


  type DataObjectWithRecursion = io.vertx.codegen.testmodel.DataObjectWithRecursion

  object DataObjectWithRecursion {
        def apply(json: JsonObject) = new DataObjectWithRecursion(json)
  }


  type DataObjectWithValues = io.vertx.codegen.testmodel.DataObjectWithValues

  object DataObjectWithValues {
    def apply() = new DataObjectWithValues()
    def apply(json: JsonObject) = new DataObjectWithValues(json)
  }


import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.codegen.testmodel.{GenericNullableRefedInterface => JGenericNullableRefedInterface}
import io.vertx.codegen.testmodel.{RefedInterface1 => JRefedInterface1}
import io.vertx.codegen.testmodel.GenericRefedInterface
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.codegen.testmodel.{GenericRefedInterface => JGenericRefedInterface}
import io.vertx.codegen.testmodel.RefedInterface1
import io.vertx.codegen.testmodel.GenericNullableRefedInterface

  /**
   */
  implicit class GenericsTCKScala(val asJava: io.vertx.codegen.testmodel.GenericsTCK) extends AnyVal {

    def methodWithHandlerAsyncResultByteParameterizedFuture(): scala.concurrent.Future[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Byte]] = {
      val promise = Promise[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Byte]]()
      asJava.methodWithHandlerAsyncResultByteParameterized({a:AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Byte]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithHandlerAsyncResultShortParameterizedFuture(): scala.concurrent.Future[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Short]] = {
      val promise = Promise[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Short]]()
      asJava.methodWithHandlerAsyncResultShortParameterized({a:AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Short]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithHandlerAsyncResultIntegerParameterizedFuture(): scala.concurrent.Future[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Integer]] = {
      val promise = Promise[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Integer]]()
      asJava.methodWithHandlerAsyncResultIntegerParameterized({a:AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Integer]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithHandlerAsyncResultLongParameterizedFuture(): scala.concurrent.Future[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Long]] = {
      val promise = Promise[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Long]]()
      asJava.methodWithHandlerAsyncResultLongParameterized({a:AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Long]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithHandlerAsyncResultFloatParameterizedFuture(): scala.concurrent.Future[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Float]] = {
      val promise = Promise[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Float]]()
      asJava.methodWithHandlerAsyncResultFloatParameterized({a:AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Float]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithHandlerAsyncResultDoubleParameterizedFuture(): scala.concurrent.Future[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Double]] = {
      val promise = Promise[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Double]]()
      asJava.methodWithHandlerAsyncResultDoubleParameterized({a:AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Double]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithHandlerAsyncResultBooleanParameterizedFuture(): scala.concurrent.Future[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Boolean]] = {
      val promise = Promise[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Boolean]]()
      asJava.methodWithHandlerAsyncResultBooleanParameterized({a:AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Boolean]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithHandlerAsyncResultCharacterParameterizedFuture(): scala.concurrent.Future[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Character]] = {
      val promise = Promise[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Character]]()
      asJava.methodWithHandlerAsyncResultCharacterParameterized({a:AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Character]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithHandlerAsyncResultStringParameterizedFuture(): scala.concurrent.Future[io.vertx.codegen.testmodel.GenericRefedInterface[String]] = {
      val promise = Promise[io.vertx.codegen.testmodel.GenericRefedInterface[String]]()
      asJava.methodWithHandlerAsyncResultStringParameterized({a:AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.String]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithHandlerAsyncResultJsonObjectParameterizedFuture(): scala.concurrent.Future[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.core.json.JsonObject]] = {
      val promise = Promise[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.core.json.JsonObject]]()
      asJava.methodWithHandlerAsyncResultJsonObjectParameterized({a:AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.core.json.JsonObject]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithHandlerAsyncResultJsonArrayParameterizedFuture(): scala.concurrent.Future[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.core.json.JsonArray]] = {
      val promise = Promise[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.core.json.JsonArray]]()
      asJava.methodWithHandlerAsyncResultJsonArrayParameterized({a:AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.core.json.JsonArray]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithHandlerAsyncResultDataObjectParameterizedFuture(): scala.concurrent.Future[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.codegen.testmodel.TestDataObject]] = {
      val promise = Promise[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.codegen.testmodel.TestDataObject]]()
      asJava.methodWithHandlerAsyncResultDataObjectParameterized({a:AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.codegen.testmodel.TestDataObject]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithHandlerAsyncResultEnumParameterizedFuture(): scala.concurrent.Future[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.codegen.testmodel.TestEnum]] = {
      val promise = Promise[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.codegen.testmodel.TestEnum]]()
      asJava.methodWithHandlerAsyncResultEnumParameterized({a:AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.codegen.testmodel.TestEnum]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithHandlerAsyncResultGenEnumParameterizedFuture(): scala.concurrent.Future[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.codegen.testmodel.TestGenEnum]] = {
      val promise = Promise[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.codegen.testmodel.TestGenEnum]]()
      asJava.methodWithHandlerAsyncResultGenEnumParameterized({a:AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.codegen.testmodel.TestGenEnum]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithHandlerAsyncResultUserTypeParameterizedFuture(): scala.concurrent.Future[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.codegen.testmodel.RefedInterface1]] = {
      val promise = Promise[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.codegen.testmodel.RefedInterface1]]()
      asJava.methodWithHandlerAsyncResultUserTypeParameterized({a:AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.codegen.testmodel.RefedInterface1]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithHandlerAsyncResultClassTypeParameterizedFuture[U](`type`: Class[U]): scala.concurrent.Future[io.vertx.codegen.testmodel.GenericRefedInterface[U]] = {
      val promise = Promise[io.vertx.codegen.testmodel.GenericRefedInterface[U]]()
      asJava.methodWithHandlerAsyncResultClassTypeParameterized[U](`type`, {a:AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[U]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithClassTypeHandlerAsyncResultFuture[U](`type`: Class[U]): scala.concurrent.Future[U] = {
      val promise = Promise[U]()
      asJava.methodWithClassTypeHandlerAsyncResult[U](`type`, {a:AsyncResult[U] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithHandlerAsyncResultGenericNullableApiFuture(notNull: java.lang.Boolean): scala.concurrent.Future[io.vertx.codegen.testmodel.GenericNullableRefedInterface[io.vertx.codegen.testmodel.RefedInterface1]] = {
      val promise = Promise[io.vertx.codegen.testmodel.GenericNullableRefedInterface[io.vertx.codegen.testmodel.RefedInterface1]]()
      asJava.methodWithHandlerAsyncResultGenericNullableApi(notNull, {a:AsyncResult[io.vertx.codegen.testmodel.GenericNullableRefedInterface[io.vertx.codegen.testmodel.RefedInterface1]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithHandlerAsyncResultParamInferedFuture[T](param: io.vertx.codegen.testmodel.GenericRefedInterface[T]): scala.concurrent.Future[io.vertx.codegen.testmodel.GenericRefedInterface[T]] = {
      val promise = Promise[io.vertx.codegen.testmodel.GenericRefedInterface[T]]()
      asJava.methodWithHandlerAsyncResultParamInfered[T](param, {a:AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[T]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.json.JsonArray
import io.vertx.codegen.testmodel.{RefedInterface1 => JRefedInterface1}
import io.vertx.codegen.testmodel.TestEnum
import io.vertx.codegen.testmodel.{TestDataObject => JTestDataObject}
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.codegen.testmodel.TestDataObject
import io.vertx.core.Handler
import scala.collection.JavaConverters._
import io.vertx.codegen.testmodel.RefedInterface1
import io.vertx.codegen.testmodel.TestGenEnum

  /**
   * The TCK for @Nullable.
   */
  implicit class NullableTCKScala(val asJava: io.vertx.codegen.testmodel.NullableTCK) extends AnyVal {

    def methodWithNullableByteHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[java.lang.Byte] = {
      val promise = Promise[java.lang.Byte]()
      asJava.methodWithNullableByteHandlerAsyncResult(notNull, {a:AsyncResult[java.lang.Byte] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithNullableShortHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[java.lang.Short] = {
      val promise = Promise[java.lang.Short]()
      asJava.methodWithNullableShortHandlerAsyncResult(notNull, {a:AsyncResult[java.lang.Short] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithNullableIntegerHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[java.lang.Integer] = {
      val promise = Promise[java.lang.Integer]()
      asJava.methodWithNullableIntegerHandlerAsyncResult(notNull, {a:AsyncResult[java.lang.Integer] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithNullableLongHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.methodWithNullableLongHandlerAsyncResult(notNull, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithNullableFloatHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[java.lang.Float] = {
      val promise = Promise[java.lang.Float]()
      asJava.methodWithNullableFloatHandlerAsyncResult(notNull, {a:AsyncResult[java.lang.Float] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithNullableDoubleHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[java.lang.Double] = {
      val promise = Promise[java.lang.Double]()
      asJava.methodWithNullableDoubleHandlerAsyncResult(notNull, {a:AsyncResult[java.lang.Double] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithNullableBooleanHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[java.lang.Boolean] = {
      val promise = Promise[java.lang.Boolean]()
      asJava.methodWithNullableBooleanHandlerAsyncResult(notNull, {a:AsyncResult[java.lang.Boolean] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithNullableStringHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.methodWithNullableStringHandlerAsyncResult(notNull, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithNullableCharHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[java.lang.Character] = {
      val promise = Promise[java.lang.Character]()
      asJava.methodWithNullableCharHandlerAsyncResult(notNull, {a:AsyncResult[java.lang.Character] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithNullableJsonObjectHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = Promise[io.vertx.core.json.JsonObject]()
      asJava.methodWithNullableJsonObjectHandlerAsyncResult(notNull, {a:AsyncResult[io.vertx.core.json.JsonObject] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithNullableJsonArrayHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.methodWithNullableJsonArrayHandlerAsyncResult(notNull, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithNullableApiHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[io.vertx.codegen.testmodel.RefedInterface1] = {
      val promise = Promise[io.vertx.codegen.testmodel.RefedInterface1]()
      asJava.methodWithNullableApiHandlerAsyncResult(notNull, {a:AsyncResult[io.vertx.codegen.testmodel.RefedInterface1] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithNullableDataObjectHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[io.vertx.codegen.testmodel.TestDataObject] = {
      val promise = Promise[io.vertx.codegen.testmodel.TestDataObject]()
      asJava.methodWithNullableDataObjectHandlerAsyncResult(notNull, {a:AsyncResult[io.vertx.codegen.testmodel.TestDataObject] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithNullableEnumHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[io.vertx.codegen.testmodel.TestEnum] = {
      val promise = Promise[io.vertx.codegen.testmodel.TestEnum]()
      asJava.methodWithNullableEnumHandlerAsyncResult(notNull, {a:AsyncResult[io.vertx.codegen.testmodel.TestEnum] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithNullableGenEnumHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[io.vertx.codegen.testmodel.TestGenEnum] = {
      val promise = Promise[io.vertx.codegen.testmodel.TestGenEnum]()
      asJava.methodWithNullableGenEnumHandlerAsyncResult(notNull, {a:AsyncResult[io.vertx.codegen.testmodel.TestGenEnum] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithNullableTypeVariableHandlerAsyncResultFuture[T](notNull: java.lang.Boolean, value: T): scala.concurrent.Future[T] = {
      val promise = Promise[T]()
      asJava.methodWithNullableTypeVariableHandlerAsyncResult[T](notNull, value, {a:AsyncResult[T] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithNullableListByteHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[java.util.List[java.lang.Byte]] = {
      val promise = Promise[java.util.List[java.lang.Byte]]()
      asJava.methodWithNullableListByteHandlerAsyncResult(notNull, {a:AsyncResult[java.util.List[java.lang.Byte]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithNullableListShortHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[java.util.List[java.lang.Short]] = {
      val promise = Promise[java.util.List[java.lang.Short]]()
      asJava.methodWithNullableListShortHandlerAsyncResult(notNull, {a:AsyncResult[java.util.List[java.lang.Short]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithNullableListIntegerHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[java.util.List[java.lang.Integer]] = {
      val promise = Promise[java.util.List[java.lang.Integer]]()
      asJava.methodWithNullableListIntegerHandlerAsyncResult(notNull, {a:AsyncResult[java.util.List[java.lang.Integer]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithNullableListLongHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[java.util.List[java.lang.Long]] = {
      val promise = Promise[java.util.List[java.lang.Long]]()
      asJava.methodWithNullableListLongHandlerAsyncResult(notNull, {a:AsyncResult[java.util.List[java.lang.Long]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithNullableListFloatHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[java.util.List[java.lang.Float]] = {
      val promise = Promise[java.util.List[java.lang.Float]]()
      asJava.methodWithNullableListFloatHandlerAsyncResult(notNull, {a:AsyncResult[java.util.List[java.lang.Float]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithNullableListDoubleHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[java.util.List[java.lang.Double]] = {
      val promise = Promise[java.util.List[java.lang.Double]]()
      asJava.methodWithNullableListDoubleHandlerAsyncResult(notNull, {a:AsyncResult[java.util.List[java.lang.Double]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithNullableListBooleanHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[java.util.List[java.lang.Boolean]] = {
      val promise = Promise[java.util.List[java.lang.Boolean]]()
      asJava.methodWithNullableListBooleanHandlerAsyncResult(notNull, {a:AsyncResult[java.util.List[java.lang.Boolean]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithNullableListStringHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[java.util.List[String]] = {
      val promise = Promise[java.util.List[String]]()
      asJava.methodWithNullableListStringHandlerAsyncResult(notNull, {a:AsyncResult[java.util.List[java.lang.String]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithNullableListCharHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[java.util.List[java.lang.Character]] = {
      val promise = Promise[java.util.List[java.lang.Character]]()
      asJava.methodWithNullableListCharHandlerAsyncResult(notNull, {a:AsyncResult[java.util.List[java.lang.Character]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithNullableListJsonObjectHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[java.util.List[io.vertx.core.json.JsonObject]] = {
      val promise = Promise[java.util.List[io.vertx.core.json.JsonObject]]()
      asJava.methodWithNullableListJsonObjectHandlerAsyncResult(notNull, {a:AsyncResult[java.util.List[io.vertx.core.json.JsonObject]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithNullableListJsonArrayHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[java.util.List[io.vertx.core.json.JsonArray]] = {
      val promise = Promise[java.util.List[io.vertx.core.json.JsonArray]]()
      asJava.methodWithNullableListJsonArrayHandlerAsyncResult(notNull, {a:AsyncResult[java.util.List[io.vertx.core.json.JsonArray]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithNullableListApiHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[java.util.List[io.vertx.codegen.testmodel.RefedInterface1]] = {
      val promise = Promise[java.util.List[io.vertx.codegen.testmodel.RefedInterface1]]()
      asJava.methodWithNullableListApiHandlerAsyncResult(notNull, {a:AsyncResult[java.util.List[io.vertx.codegen.testmodel.RefedInterface1]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithNullableListDataObjectHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[java.util.List[io.vertx.codegen.testmodel.TestDataObject]] = {
      val promise = Promise[java.util.List[io.vertx.codegen.testmodel.TestDataObject]]()
      asJava.methodWithNullableListDataObjectHandlerAsyncResult(notNull, {a:AsyncResult[java.util.List[io.vertx.codegen.testmodel.TestDataObject]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithNullableListEnumHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[java.util.List[io.vertx.codegen.testmodel.TestEnum]] = {
      val promise = Promise[java.util.List[io.vertx.codegen.testmodel.TestEnum]]()
      asJava.methodWithNullableListEnumHandlerAsyncResult(notNull, {a:AsyncResult[java.util.List[io.vertx.codegen.testmodel.TestEnum]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithNullableListGenEnumHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[java.util.List[io.vertx.codegen.testmodel.TestGenEnum]] = {
      val promise = Promise[java.util.List[io.vertx.codegen.testmodel.TestGenEnum]]()
      asJava.methodWithNullableListGenEnumHandlerAsyncResult(notNull, {a:AsyncResult[java.util.List[io.vertx.codegen.testmodel.TestGenEnum]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithNullableSetByteHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[java.util.Set[java.lang.Byte]] = {
      val promise = Promise[java.util.Set[java.lang.Byte]]()
      asJava.methodWithNullableSetByteHandlerAsyncResult(notNull, {a:AsyncResult[java.util.Set[java.lang.Byte]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithNullableSetShortHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[java.util.Set[java.lang.Short]] = {
      val promise = Promise[java.util.Set[java.lang.Short]]()
      asJava.methodWithNullableSetShortHandlerAsyncResult(notNull, {a:AsyncResult[java.util.Set[java.lang.Short]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithNullableSetIntegerHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[java.util.Set[java.lang.Integer]] = {
      val promise = Promise[java.util.Set[java.lang.Integer]]()
      asJava.methodWithNullableSetIntegerHandlerAsyncResult(notNull, {a:AsyncResult[java.util.Set[java.lang.Integer]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithNullableSetLongHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[java.util.Set[java.lang.Long]] = {
      val promise = Promise[java.util.Set[java.lang.Long]]()
      asJava.methodWithNullableSetLongHandlerAsyncResult(notNull, {a:AsyncResult[java.util.Set[java.lang.Long]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithNullableSetFloatHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[java.util.Set[java.lang.Float]] = {
      val promise = Promise[java.util.Set[java.lang.Float]]()
      asJava.methodWithNullableSetFloatHandlerAsyncResult(notNull, {a:AsyncResult[java.util.Set[java.lang.Float]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithNullableSetDoubleHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[java.util.Set[java.lang.Double]] = {
      val promise = Promise[java.util.Set[java.lang.Double]]()
      asJava.methodWithNullableSetDoubleHandlerAsyncResult(notNull, {a:AsyncResult[java.util.Set[java.lang.Double]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithNullableSetBooleanHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[java.util.Set[java.lang.Boolean]] = {
      val promise = Promise[java.util.Set[java.lang.Boolean]]()
      asJava.methodWithNullableSetBooleanHandlerAsyncResult(notNull, {a:AsyncResult[java.util.Set[java.lang.Boolean]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithNullableSetStringHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[java.util.Set[String]] = {
      val promise = Promise[java.util.Set[String]]()
      asJava.methodWithNullableSetStringHandlerAsyncResult(notNull, {a:AsyncResult[java.util.Set[java.lang.String]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithNullableSetCharHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[java.util.Set[java.lang.Character]] = {
      val promise = Promise[java.util.Set[java.lang.Character]]()
      asJava.methodWithNullableSetCharHandlerAsyncResult(notNull, {a:AsyncResult[java.util.Set[java.lang.Character]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithNullableSetJsonObjectHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[java.util.Set[io.vertx.core.json.JsonObject]] = {
      val promise = Promise[java.util.Set[io.vertx.core.json.JsonObject]]()
      asJava.methodWithNullableSetJsonObjectHandlerAsyncResult(notNull, {a:AsyncResult[java.util.Set[io.vertx.core.json.JsonObject]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithNullableSetJsonArrayHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[java.util.Set[io.vertx.core.json.JsonArray]] = {
      val promise = Promise[java.util.Set[io.vertx.core.json.JsonArray]]()
      asJava.methodWithNullableSetJsonArrayHandlerAsyncResult(notNull, {a:AsyncResult[java.util.Set[io.vertx.core.json.JsonArray]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithNullableSetApiHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[java.util.Set[io.vertx.codegen.testmodel.RefedInterface1]] = {
      val promise = Promise[java.util.Set[io.vertx.codegen.testmodel.RefedInterface1]]()
      asJava.methodWithNullableSetApiHandlerAsyncResult(notNull, {a:AsyncResult[java.util.Set[io.vertx.codegen.testmodel.RefedInterface1]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithNullableSetDataObjectHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[java.util.Set[io.vertx.codegen.testmodel.TestDataObject]] = {
      val promise = Promise[java.util.Set[io.vertx.codegen.testmodel.TestDataObject]]()
      asJava.methodWithNullableSetDataObjectHandlerAsyncResult(notNull, {a:AsyncResult[java.util.Set[io.vertx.codegen.testmodel.TestDataObject]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithNullableSetEnumHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[java.util.Set[io.vertx.codegen.testmodel.TestEnum]] = {
      val promise = Promise[java.util.Set[io.vertx.codegen.testmodel.TestEnum]]()
      asJava.methodWithNullableSetEnumHandlerAsyncResult(notNull, {a:AsyncResult[java.util.Set[io.vertx.codegen.testmodel.TestEnum]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithNullableSetGenEnumHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[java.util.Set[io.vertx.codegen.testmodel.TestGenEnum]] = {
      val promise = Promise[java.util.Set[io.vertx.codegen.testmodel.TestGenEnum]]()
      asJava.methodWithNullableSetGenEnumHandlerAsyncResult(notNull, {a:AsyncResult[java.util.Set[io.vertx.codegen.testmodel.TestGenEnum]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithNullableMapByteHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[java.util.Map[String, java.lang.Byte]] = {
      val promise = Promise[java.util.Map[String, java.lang.Byte]]()
      asJava.methodWithNullableMapByteHandlerAsyncResult(notNull, {a:AsyncResult[java.util.Map[java.lang.String,java.lang.Byte]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithNullableMapShortHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[java.util.Map[String, java.lang.Short]] = {
      val promise = Promise[java.util.Map[String, java.lang.Short]]()
      asJava.methodWithNullableMapShortHandlerAsyncResult(notNull, {a:AsyncResult[java.util.Map[java.lang.String,java.lang.Short]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithNullableMapIntegerHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[java.util.Map[String, java.lang.Integer]] = {
      val promise = Promise[java.util.Map[String, java.lang.Integer]]()
      asJava.methodWithNullableMapIntegerHandlerAsyncResult(notNull, {a:AsyncResult[java.util.Map[java.lang.String,java.lang.Integer]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithNullableMapLongHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[java.util.Map[String, java.lang.Long]] = {
      val promise = Promise[java.util.Map[String, java.lang.Long]]()
      asJava.methodWithNullableMapLongHandlerAsyncResult(notNull, {a:AsyncResult[java.util.Map[java.lang.String,java.lang.Long]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithNullableMapFloatHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[java.util.Map[String, java.lang.Float]] = {
      val promise = Promise[java.util.Map[String, java.lang.Float]]()
      asJava.methodWithNullableMapFloatHandlerAsyncResult(notNull, {a:AsyncResult[java.util.Map[java.lang.String,java.lang.Float]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithNullableMapDoubleHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[java.util.Map[String, java.lang.Double]] = {
      val promise = Promise[java.util.Map[String, java.lang.Double]]()
      asJava.methodWithNullableMapDoubleHandlerAsyncResult(notNull, {a:AsyncResult[java.util.Map[java.lang.String,java.lang.Double]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithNullableMapBooleanHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[java.util.Map[String, java.lang.Boolean]] = {
      val promise = Promise[java.util.Map[String, java.lang.Boolean]]()
      asJava.methodWithNullableMapBooleanHandlerAsyncResult(notNull, {a:AsyncResult[java.util.Map[java.lang.String,java.lang.Boolean]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithNullableMapStringHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[java.util.Map[String, String]] = {
      val promise = Promise[java.util.Map[String, String]]()
      asJava.methodWithNullableMapStringHandlerAsyncResult(notNull, {a:AsyncResult[java.util.Map[java.lang.String,java.lang.String]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithNullableMapCharHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[java.util.Map[String, java.lang.Character]] = {
      val promise = Promise[java.util.Map[String, java.lang.Character]]()
      asJava.methodWithNullableMapCharHandlerAsyncResult(notNull, {a:AsyncResult[java.util.Map[java.lang.String,java.lang.Character]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithNullableMapJsonObjectHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[java.util.Map[String, io.vertx.core.json.JsonObject]] = {
      val promise = Promise[java.util.Map[String, io.vertx.core.json.JsonObject]]()
      asJava.methodWithNullableMapJsonObjectHandlerAsyncResult(notNull, {a:AsyncResult[java.util.Map[java.lang.String,io.vertx.core.json.JsonObject]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithNullableMapJsonArrayHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[java.util.Map[String, io.vertx.core.json.JsonArray]] = {
      val promise = Promise[java.util.Map[String, io.vertx.core.json.JsonArray]]()
      asJava.methodWithNullableMapJsonArrayHandlerAsyncResult(notNull, {a:AsyncResult[java.util.Map[java.lang.String,io.vertx.core.json.JsonArray]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithListNullableByteHandlerAsyncResultFuture(): scala.concurrent.Future[java.util.List[java.lang.Byte]] = {
      val promise = Promise[java.util.List[java.lang.Byte]]()
      asJava.methodWithListNullableByteHandlerAsyncResult({a:AsyncResult[java.util.List[java.lang.Byte]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithListNullableShortHandlerAsyncResultFuture(): scala.concurrent.Future[java.util.List[java.lang.Short]] = {
      val promise = Promise[java.util.List[java.lang.Short]]()
      asJava.methodWithListNullableShortHandlerAsyncResult({a:AsyncResult[java.util.List[java.lang.Short]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithListNullableIntegerHandlerAsyncResultFuture(): scala.concurrent.Future[java.util.List[java.lang.Integer]] = {
      val promise = Promise[java.util.List[java.lang.Integer]]()
      asJava.methodWithListNullableIntegerHandlerAsyncResult({a:AsyncResult[java.util.List[java.lang.Integer]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithListNullableLongHandlerAsyncResultFuture(): scala.concurrent.Future[java.util.List[java.lang.Long]] = {
      val promise = Promise[java.util.List[java.lang.Long]]()
      asJava.methodWithListNullableLongHandlerAsyncResult({a:AsyncResult[java.util.List[java.lang.Long]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithListNullableBooleanHandlerAsyncResultFuture(): scala.concurrent.Future[java.util.List[java.lang.Boolean]] = {
      val promise = Promise[java.util.List[java.lang.Boolean]]()
      asJava.methodWithListNullableBooleanHandlerAsyncResult({a:AsyncResult[java.util.List[java.lang.Boolean]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithListNullableFloatHandlerAsyncResultFuture(): scala.concurrent.Future[java.util.List[java.lang.Float]] = {
      val promise = Promise[java.util.List[java.lang.Float]]()
      asJava.methodWithListNullableFloatHandlerAsyncResult({a:AsyncResult[java.util.List[java.lang.Float]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithListNullableDoubleHandlerAsyncResultFuture(): scala.concurrent.Future[java.util.List[java.lang.Double]] = {
      val promise = Promise[java.util.List[java.lang.Double]]()
      asJava.methodWithListNullableDoubleHandlerAsyncResult({a:AsyncResult[java.util.List[java.lang.Double]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithListNullableStringHandlerAsyncResultFuture(): scala.concurrent.Future[java.util.List[String]] = {
      val promise = Promise[java.util.List[String]]()
      asJava.methodWithListNullableStringHandlerAsyncResult({a:AsyncResult[java.util.List[java.lang.String]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithListNullableCharHandlerAsyncResultFuture(): scala.concurrent.Future[java.util.List[java.lang.Character]] = {
      val promise = Promise[java.util.List[java.lang.Character]]()
      asJava.methodWithListNullableCharHandlerAsyncResult({a:AsyncResult[java.util.List[java.lang.Character]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithListNullableJsonObjectHandlerAsyncResultFuture(): scala.concurrent.Future[java.util.List[io.vertx.core.json.JsonObject]] = {
      val promise = Promise[java.util.List[io.vertx.core.json.JsonObject]]()
      asJava.methodWithListNullableJsonObjectHandlerAsyncResult({a:AsyncResult[java.util.List[io.vertx.core.json.JsonObject]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithListNullableJsonArrayHandlerAsyncResultFuture(): scala.concurrent.Future[java.util.List[io.vertx.core.json.JsonArray]] = {
      val promise = Promise[java.util.List[io.vertx.core.json.JsonArray]]()
      asJava.methodWithListNullableJsonArrayHandlerAsyncResult({a:AsyncResult[java.util.List[io.vertx.core.json.JsonArray]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithListNullableApiHandlerAsyncResultFuture(): scala.concurrent.Future[java.util.List[io.vertx.codegen.testmodel.RefedInterface1]] = {
      val promise = Promise[java.util.List[io.vertx.codegen.testmodel.RefedInterface1]]()
      asJava.methodWithListNullableApiHandlerAsyncResult({a:AsyncResult[java.util.List[io.vertx.codegen.testmodel.RefedInterface1]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithListNullableDataObjectHandlerAsyncResultFuture(): scala.concurrent.Future[java.util.List[io.vertx.codegen.testmodel.TestDataObject]] = {
      val promise = Promise[java.util.List[io.vertx.codegen.testmodel.TestDataObject]]()
      asJava.methodWithListNullableDataObjectHandlerAsyncResult({a:AsyncResult[java.util.List[io.vertx.codegen.testmodel.TestDataObject]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithListNullableEnumHandlerAsyncResultFuture(): scala.concurrent.Future[java.util.List[io.vertx.codegen.testmodel.TestEnum]] = {
      val promise = Promise[java.util.List[io.vertx.codegen.testmodel.TestEnum]]()
      asJava.methodWithListNullableEnumHandlerAsyncResult({a:AsyncResult[java.util.List[io.vertx.codegen.testmodel.TestEnum]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithListNullableGenEnumHandlerAsyncResultFuture(): scala.concurrent.Future[java.util.List[io.vertx.codegen.testmodel.TestGenEnum]] = {
      val promise = Promise[java.util.List[io.vertx.codegen.testmodel.TestGenEnum]]()
      asJava.methodWithListNullableGenEnumHandlerAsyncResult({a:AsyncResult[java.util.List[io.vertx.codegen.testmodel.TestGenEnum]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithSetNullableByteHandlerAsyncResultFuture(): scala.concurrent.Future[java.util.Set[java.lang.Byte]] = {
      val promise = Promise[java.util.Set[java.lang.Byte]]()
      asJava.methodWithSetNullableByteHandlerAsyncResult({a:AsyncResult[java.util.Set[java.lang.Byte]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithSetNullableShortHandlerAsyncResultFuture(): scala.concurrent.Future[java.util.Set[java.lang.Short]] = {
      val promise = Promise[java.util.Set[java.lang.Short]]()
      asJava.methodWithSetNullableShortHandlerAsyncResult({a:AsyncResult[java.util.Set[java.lang.Short]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithSetNullableIntegerHandlerAsyncResultFuture(): scala.concurrent.Future[java.util.Set[java.lang.Integer]] = {
      val promise = Promise[java.util.Set[java.lang.Integer]]()
      asJava.methodWithSetNullableIntegerHandlerAsyncResult({a:AsyncResult[java.util.Set[java.lang.Integer]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithSetNullableLongHandlerAsyncResultFuture(): scala.concurrent.Future[java.util.Set[java.lang.Long]] = {
      val promise = Promise[java.util.Set[java.lang.Long]]()
      asJava.methodWithSetNullableLongHandlerAsyncResult({a:AsyncResult[java.util.Set[java.lang.Long]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithSetNullableBooleanHandlerAsyncResultFuture(): scala.concurrent.Future[java.util.Set[java.lang.Boolean]] = {
      val promise = Promise[java.util.Set[java.lang.Boolean]]()
      asJava.methodWithSetNullableBooleanHandlerAsyncResult({a:AsyncResult[java.util.Set[java.lang.Boolean]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithSetNullableFloatHandlerAsyncResultFuture(): scala.concurrent.Future[java.util.Set[java.lang.Float]] = {
      val promise = Promise[java.util.Set[java.lang.Float]]()
      asJava.methodWithSetNullableFloatHandlerAsyncResult({a:AsyncResult[java.util.Set[java.lang.Float]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithSetNullableDoubleHandlerAsyncResultFuture(): scala.concurrent.Future[java.util.Set[java.lang.Double]] = {
      val promise = Promise[java.util.Set[java.lang.Double]]()
      asJava.methodWithSetNullableDoubleHandlerAsyncResult({a:AsyncResult[java.util.Set[java.lang.Double]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithSetNullableStringHandlerAsyncResultFuture(): scala.concurrent.Future[java.util.Set[String]] = {
      val promise = Promise[java.util.Set[String]]()
      asJava.methodWithSetNullableStringHandlerAsyncResult({a:AsyncResult[java.util.Set[java.lang.String]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithSetNullableCharHandlerAsyncResultFuture(): scala.concurrent.Future[java.util.Set[java.lang.Character]] = {
      val promise = Promise[java.util.Set[java.lang.Character]]()
      asJava.methodWithSetNullableCharHandlerAsyncResult({a:AsyncResult[java.util.Set[java.lang.Character]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithSetNullableJsonObjectHandlerAsyncResultFuture(): scala.concurrent.Future[java.util.Set[io.vertx.core.json.JsonObject]] = {
      val promise = Promise[java.util.Set[io.vertx.core.json.JsonObject]]()
      asJava.methodWithSetNullableJsonObjectHandlerAsyncResult({a:AsyncResult[java.util.Set[io.vertx.core.json.JsonObject]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithSetNullableJsonArrayHandlerAsyncResultFuture(): scala.concurrent.Future[java.util.Set[io.vertx.core.json.JsonArray]] = {
      val promise = Promise[java.util.Set[io.vertx.core.json.JsonArray]]()
      asJava.methodWithSetNullableJsonArrayHandlerAsyncResult({a:AsyncResult[java.util.Set[io.vertx.core.json.JsonArray]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithSetNullableApiHandlerAsyncResultFuture(): scala.concurrent.Future[java.util.Set[io.vertx.codegen.testmodel.RefedInterface1]] = {
      val promise = Promise[java.util.Set[io.vertx.codegen.testmodel.RefedInterface1]]()
      asJava.methodWithSetNullableApiHandlerAsyncResult({a:AsyncResult[java.util.Set[io.vertx.codegen.testmodel.RefedInterface1]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithSetNullableDataObjectHandlerAsyncResultFuture(): scala.concurrent.Future[java.util.Set[io.vertx.codegen.testmodel.TestDataObject]] = {
      val promise = Promise[java.util.Set[io.vertx.codegen.testmodel.TestDataObject]]()
      asJava.methodWithSetNullableDataObjectHandlerAsyncResult({a:AsyncResult[java.util.Set[io.vertx.codegen.testmodel.TestDataObject]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithSetNullableEnumHandlerAsyncResultFuture(): scala.concurrent.Future[java.util.Set[io.vertx.codegen.testmodel.TestEnum]] = {
      val promise = Promise[java.util.Set[io.vertx.codegen.testmodel.TestEnum]]()
      asJava.methodWithSetNullableEnumHandlerAsyncResult({a:AsyncResult[java.util.Set[io.vertx.codegen.testmodel.TestEnum]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithSetNullableGenEnumHandlerAsyncResultFuture(): scala.concurrent.Future[java.util.Set[io.vertx.codegen.testmodel.TestGenEnum]] = {
      val promise = Promise[java.util.Set[io.vertx.codegen.testmodel.TestGenEnum]]()
      asJava.methodWithSetNullableGenEnumHandlerAsyncResult({a:AsyncResult[java.util.Set[io.vertx.codegen.testmodel.TestGenEnum]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithMapNullableByteHandlerAsyncResultFuture(): scala.concurrent.Future[java.util.Map[String, java.lang.Byte]] = {
      val promise = Promise[java.util.Map[String, java.lang.Byte]]()
      asJava.methodWithMapNullableByteHandlerAsyncResult({a:AsyncResult[java.util.Map[java.lang.String,java.lang.Byte]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithMapNullableShortHandlerAsyncResultFuture(): scala.concurrent.Future[java.util.Map[String, java.lang.Short]] = {
      val promise = Promise[java.util.Map[String, java.lang.Short]]()
      asJava.methodWithMapNullableShortHandlerAsyncResult({a:AsyncResult[java.util.Map[java.lang.String,java.lang.Short]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithMapNullableIntegerHandlerAsyncResultFuture(): scala.concurrent.Future[java.util.Map[String, java.lang.Integer]] = {
      val promise = Promise[java.util.Map[String, java.lang.Integer]]()
      asJava.methodWithMapNullableIntegerHandlerAsyncResult({a:AsyncResult[java.util.Map[java.lang.String,java.lang.Integer]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithMapNullableLongHandlerAsyncResultFuture(): scala.concurrent.Future[java.util.Map[String, java.lang.Long]] = {
      val promise = Promise[java.util.Map[String, java.lang.Long]]()
      asJava.methodWithMapNullableLongHandlerAsyncResult({a:AsyncResult[java.util.Map[java.lang.String,java.lang.Long]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithMapNullableBooleanHandlerAsyncResultFuture(): scala.concurrent.Future[java.util.Map[String, java.lang.Boolean]] = {
      val promise = Promise[java.util.Map[String, java.lang.Boolean]]()
      asJava.methodWithMapNullableBooleanHandlerAsyncResult({a:AsyncResult[java.util.Map[java.lang.String,java.lang.Boolean]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithMapNullableFloatHandlerAsyncResultFuture(): scala.concurrent.Future[java.util.Map[String, java.lang.Float]] = {
      val promise = Promise[java.util.Map[String, java.lang.Float]]()
      asJava.methodWithMapNullableFloatHandlerAsyncResult({a:AsyncResult[java.util.Map[java.lang.String,java.lang.Float]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithMapNullableDoubleHandlerAsyncResultFuture(): scala.concurrent.Future[java.util.Map[String, java.lang.Double]] = {
      val promise = Promise[java.util.Map[String, java.lang.Double]]()
      asJava.methodWithMapNullableDoubleHandlerAsyncResult({a:AsyncResult[java.util.Map[java.lang.String,java.lang.Double]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithMapNullableStringHandlerAsyncResultFuture(): scala.concurrent.Future[java.util.Map[String, String]] = {
      val promise = Promise[java.util.Map[String, String]]()
      asJava.methodWithMapNullableStringHandlerAsyncResult({a:AsyncResult[java.util.Map[java.lang.String,java.lang.String]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithMapNullableCharHandlerAsyncResultFuture(): scala.concurrent.Future[java.util.Map[String, java.lang.Character]] = {
      val promise = Promise[java.util.Map[String, java.lang.Character]]()
      asJava.methodWithMapNullableCharHandlerAsyncResult({a:AsyncResult[java.util.Map[java.lang.String,java.lang.Character]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithMapNullableJsonObjectHandlerAsyncResultFuture(): scala.concurrent.Future[java.util.Map[String, io.vertx.core.json.JsonObject]] = {
      val promise = Promise[java.util.Map[String, io.vertx.core.json.JsonObject]]()
      asJava.methodWithMapNullableJsonObjectHandlerAsyncResult({a:AsyncResult[java.util.Map[java.lang.String,io.vertx.core.json.JsonObject]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithMapNullableJsonArrayHandlerAsyncResultFuture(): scala.concurrent.Future[java.util.Map[String, io.vertx.core.json.JsonArray]] = {
      val promise = Promise[java.util.Map[String, io.vertx.core.json.JsonArray]]()
      asJava.methodWithMapNullableJsonArrayHandlerAsyncResult({a:AsyncResult[java.util.Map[java.lang.String,io.vertx.core.json.JsonArray]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithNullableHandlerAsyncResultFuture(expectNull: java.lang.Boolean): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.methodWithNullableHandlerAsyncResult(expectNull, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }

  type TestDataObject = io.vertx.codegen.testmodel.TestDataObject

  object TestDataObject {
    def apply() = new TestDataObject()
    def apply(json: JsonObject) = new TestDataObject(json)
  }


import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.codegen.testmodel.{ConcreteHandlerUserType => JConcreteHandlerUserType}
import io.vertx.codegen.testmodel.{AbstractHandlerUserType => JAbstractHandlerUserType}
import io.vertx.codegen.testmodel.{RefedInterface1 => JRefedInterface1}
import io.vertx.codegen.testmodel.{ConcreteHandlerUserTypeExtension => JConcreteHandlerUserTypeExtension}
import io.vertx.codegen.testmodel.GenericRefedInterface
import io.vertx.codegen.testmodel.TestDataObject
import io.vertx.codegen.testmodel.RefedInterface1
import io.vertx.codegen.testmodel.AbstractHandlerUserType
import io.vertx.core.json.JsonArray
import io.vertx.codegen.testmodel.TestEnum
import io.vertx.codegen.testmodel.{TestDataObject => JTestDataObject}
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.codegen.testmodel.{GenericRefedInterface => JGenericRefedInterface}
import io.vertx.codegen.testmodel.ConcreteHandlerUserType
import io.vertx.codegen.testmodel.ConcreteHandlerUserTypeExtension
import io.vertx.codegen.testmodel.TestGenEnum

  /**
   */
  implicit class TestInterfaceScala(val asJava: io.vertx.codegen.testmodel.TestInterface) extends AnyVal {

    def methodWithHandlerAsyncResultByteFuture(sendFailure: java.lang.Boolean): scala.concurrent.Future[java.lang.Byte] = {
      val promise = Promise[java.lang.Byte]()
      asJava.methodWithHandlerAsyncResultByte(sendFailure, {a:AsyncResult[java.lang.Byte] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithHandlerAsyncResultShortFuture(sendFailure: java.lang.Boolean): scala.concurrent.Future[java.lang.Short] = {
      val promise = Promise[java.lang.Short]()
      asJava.methodWithHandlerAsyncResultShort(sendFailure, {a:AsyncResult[java.lang.Short] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithHandlerAsyncResultIntegerFuture(sendFailure: java.lang.Boolean): scala.concurrent.Future[java.lang.Integer] = {
      val promise = Promise[java.lang.Integer]()
      asJava.methodWithHandlerAsyncResultInteger(sendFailure, {a:AsyncResult[java.lang.Integer] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithHandlerAsyncResultLongFuture(sendFailure: java.lang.Boolean): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.methodWithHandlerAsyncResultLong(sendFailure, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithHandlerAsyncResultFloatFuture(sendFailure: java.lang.Boolean): scala.concurrent.Future[java.lang.Float] = {
      val promise = Promise[java.lang.Float]()
      asJava.methodWithHandlerAsyncResultFloat(sendFailure, {a:AsyncResult[java.lang.Float] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithHandlerAsyncResultDoubleFuture(sendFailure: java.lang.Boolean): scala.concurrent.Future[java.lang.Double] = {
      val promise = Promise[java.lang.Double]()
      asJava.methodWithHandlerAsyncResultDouble(sendFailure, {a:AsyncResult[java.lang.Double] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithHandlerAsyncResultBooleanFuture(sendFailure: java.lang.Boolean): scala.concurrent.Future[java.lang.Boolean] = {
      val promise = Promise[java.lang.Boolean]()
      asJava.methodWithHandlerAsyncResultBoolean(sendFailure, {a:AsyncResult[java.lang.Boolean] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithHandlerAsyncResultCharacterFuture(sendFailure: java.lang.Boolean): scala.concurrent.Future[java.lang.Character] = {
      val promise = Promise[java.lang.Character]()
      asJava.methodWithHandlerAsyncResultCharacter(sendFailure, {a:AsyncResult[java.lang.Character] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithHandlerAsyncResultStringFuture(sendFailure: java.lang.Boolean): scala.concurrent.Future[String] = {
      val promise = Promise[String]()
      asJava.methodWithHandlerAsyncResultString(sendFailure, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithHandlerAsyncResultDataObjectFuture(sendFailure: java.lang.Boolean): scala.concurrent.Future[io.vertx.codegen.testmodel.TestDataObject] = {
      val promise = Promise[io.vertx.codegen.testmodel.TestDataObject]()
      asJava.methodWithHandlerAsyncResultDataObject(sendFailure, {a:AsyncResult[io.vertx.codegen.testmodel.TestDataObject] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithHandlerAsyncResultUserTypesFuture(): scala.concurrent.Future[io.vertx.codegen.testmodel.RefedInterface1] = {
      val promise = Promise[io.vertx.codegen.testmodel.RefedInterface1]()
      asJava.methodWithHandlerAsyncResultUserTypes({a:AsyncResult[io.vertx.codegen.testmodel.RefedInterface1] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithHandlerAsyncResultVoidFuture(sendFailure: java.lang.Boolean): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.methodWithHandlerAsyncResultVoid(sendFailure, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithHandlerAsyncResultGenericUserTypeFuture[U](value: U): scala.concurrent.Future[io.vertx.codegen.testmodel.GenericRefedInterface[U]] = {
      val promise = Promise[io.vertx.codegen.testmodel.GenericRefedInterface[U]]()
      asJava.methodWithHandlerAsyncResultGenericUserType[U](value, {a:AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[U]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithGenericHandlerAsyncResultFuture[U](`type`: String): scala.concurrent.Future[U] = {
      val promise = Promise[U]()
      asJava.methodWithGenericHandlerAsyncResult[U](`type`, {a:AsyncResult[U] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithHandlerAsyncResultJsonObjectFuture(): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = Promise[io.vertx.core.json.JsonObject]()
      asJava.methodWithHandlerAsyncResultJsonObject({a:AsyncResult[io.vertx.core.json.JsonObject] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithHandlerAsyncResultNullJsonObjectFuture(): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = Promise[io.vertx.core.json.JsonObject]()
      asJava.methodWithHandlerAsyncResultNullJsonObject({a:AsyncResult[io.vertx.core.json.JsonObject] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithHandlerAsyncResultComplexJsonObjectFuture(): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = Promise[io.vertx.core.json.JsonObject]()
      asJava.methodWithHandlerAsyncResultComplexJsonObject({a:AsyncResult[io.vertx.core.json.JsonObject] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithHandlerAsyncResultJsonArrayFuture(): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.methodWithHandlerAsyncResultJsonArray({a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithHandlerAsyncResultNullJsonArrayFuture(): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.methodWithHandlerAsyncResultNullJsonArray({a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def methodWithHandlerAsyncResultComplexJsonArrayFuture(): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.methodWithHandlerAsyncResultComplexJsonArray({a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }

}
