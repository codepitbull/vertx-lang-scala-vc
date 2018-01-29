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
import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import scala.concurrent.Promise

package object testmodel{


import io.vertx.codegen.testmodel.{AbstractHandlerUserType => JAbstractHandlerUserType}
import io.vertx.codegen.testmodel.{RefedInterface1 => JRefedInterface1}
import io.vertx.core.Handler
import io.vertx.codegen.testmodel.RefedInterface1

/**
  */
implicit class AbstractHandlerUserTypeScala(val asJava: JAbstractHandlerUserType) extends AnyVal {


  def handle(arg0: JRefedInterface1): Unit = {
    asJava.handle(arg0.asJava)
  }

}

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.codegen.testmodel.{RefedInterface1 => JRefedInterface1}
import io.vertx.codegen.testmodel.TestDataObject
import scala.collection.JavaConverters._
import io.vertx.codegen.testmodel.RefedInterface1
import io.vertx.codegen.testmodel.{CollectionTCK => JCollectionTCK}
import io.vertx.codegen.testmodel.RefedInterface2
import io.vertx.core.json.JsonArray
import io.vertx.codegen.testmodel.TestEnum
import io.vertx.codegen.testmodel.{TestDataObject => JTestDataObject}
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.codegen.testmodel.{RefedInterface2 => JRefedInterface2}
import io.vertx.core.Handler

/**
  */
implicit class CollectionTCKScala(val asJava: JCollectionTCK) extends AnyVal {


  def methodWithListParams(listString: List[String], listByte: List[java.lang.Byte], listShort: List[java.lang.Short], listInt: List[java.lang.Integer], listLong: List[java.lang.Long], listJsonObject: List[io.vertx.core.json.JsonObject], listJsonArray: List[io.vertx.core.json.JsonArray], listVertxGen: List[JRefedInterface1], listDataObject: List[JTestDataObject], listEnum: List[io.vertx.codegen.testmodel.TestEnum]): Unit = {
    asJava.methodWithListParams(listString.map(x => x.asInstanceOf[String]).asJava, listByte.map(x => x.asInstanceOf[java.lang.Byte]).asJava, listShort.map(x => x.asInstanceOf[java.lang.Short]).asJava, listInt.map(x => x.asInstanceOf[java.lang.Integer]).asJava, listLong.map(x => x.asInstanceOf[java.lang.Long]).asJava, listJsonObject.asJava, listJsonArray.asJava, listVertxGen.asJava, listDataObject.asJava, listEnum.asJava)
  }

  def methodWithSetParams(setString: Set[String], setByte: Set[java.lang.Byte], setShort: Set[java.lang.Short], setInt: Set[java.lang.Integer], setLong: Set[java.lang.Long], setJsonObject: Set[io.vertx.core.json.JsonObject], setJsonArray: Set[io.vertx.core.json.JsonArray], setVertxGen: Set[JRefedInterface1], setDataObject: Set[JTestDataObject], setEnum: Set[io.vertx.codegen.testmodel.TestEnum]): Unit = {
    asJava.methodWithSetParams(setString.map(x => x.asInstanceOf[String]).asJava, setByte.map(x => x.asInstanceOf[java.lang.Byte]).asJava, setShort.map(x => x.asInstanceOf[java.lang.Short]).asJava, setInt.map(x => x.asInstanceOf[java.lang.Integer]).asJava, setLong.map(x => x.asInstanceOf[java.lang.Long]).asJava, setJsonObject.asJava, setJsonArray.asJava, setVertxGen.asJava, setDataObject.asJava, setEnum.asJava)
  }

  def methodWithMapParams(mapString: Map[String, String], mapByte: Map[String, java.lang.Byte], mapShort: Map[String, java.lang.Short], mapInt: Map[String, java.lang.Integer], mapLong: Map[String, java.lang.Long], mapJsonObject: Map[String, io.vertx.core.json.JsonObject], mapJsonArray: Map[String, io.vertx.core.json.JsonArray], mapVertxGen: Map[String, JRefedInterface1]): Unit = {
    asJava.methodWithMapParams(mapString.mapValues(x => x.asInstanceOf[String]).asJava, mapByte.mapValues(x => x.asInstanceOf[java.lang.Byte]).asJava, mapShort.mapValues(x => x.asInstanceOf[java.lang.Short]).asJava, mapInt.mapValues(x => x.asInstanceOf[java.lang.Integer]).asJava, mapLong.mapValues(x => x.asInstanceOf[java.lang.Long]).asJava, mapJsonObject.asJava, mapJsonArray.asJava, mapVertxGen.asJava)
  }

  def methodWithHandlerListAndSet(listStringHandler: List[String] => Unit, listIntHandler: List[java.lang.Integer] => Unit, setStringHandler: Set[String] => Unit, setIntHandler: Set[java.lang.Integer] => Unit): Unit = {
    asJava.methodWithHandlerListAndSet((p:List[String]) => listStringHandler(p), (p:List[java.lang.Integer]) => listIntHandler(p), (p:Set[String]) => setStringHandler(p), (p:Set[java.lang.Integer]) => setIntHandler(p))
  }

  def methodWithHandlerAsyncResultListString(handler: AsyncResult[List[String]] => Unit): Unit = {
    asJava.methodWithHandlerAsyncResultListString((p:AsyncResult[List[String]]) => handler(p))
  }

  def methodWithHandlerAsyncResultListInteger(handler: AsyncResult[List[java.lang.Integer]] => Unit): Unit = {
    asJava.methodWithHandlerAsyncResultListInteger((p:AsyncResult[List[java.lang.Integer]]) => handler(p))
  }

  def methodWithHandlerListVertxGen(listHandler: List[JRefedInterface1] => Unit): Unit = {
    asJava.methodWithHandlerListVertxGen((p:List[JRefedInterface1]) => listHandler(p))
  }

  def methodWithHandlerListAbstractVertxGen(listHandler: List[JRefedInterface2] => Unit): Unit = {
    asJava.methodWithHandlerListAbstractVertxGen((p:List[JRefedInterface2]) => listHandler(p))
  }

  def methodWithHandlerListJsonObject(listHandler: List[io.vertx.core.json.JsonObject] => Unit): Unit = {
    asJava.methodWithHandlerListJsonObject((p:List[io.vertx.core.json.JsonObject]) => listHandler(p))
  }

  def methodWithHandlerListComplexJsonObject(listHandler: List[io.vertx.core.json.JsonObject] => Unit): Unit = {
    asJava.methodWithHandlerListComplexJsonObject((p:List[io.vertx.core.json.JsonObject]) => listHandler(p))
  }

  def methodWithHandlerListJsonArray(listHandler: List[io.vertx.core.json.JsonArray] => Unit): Unit = {
    asJava.methodWithHandlerListJsonArray((p:List[io.vertx.core.json.JsonArray]) => listHandler(p))
  }

  def methodWithHandlerListComplexJsonArray(listHandler: List[io.vertx.core.json.JsonArray] => Unit): Unit = {
    asJava.methodWithHandlerListComplexJsonArray((p:List[io.vertx.core.json.JsonArray]) => listHandler(p))
  }

  def methodWithHandlerListDataObject(listHandler: List[JTestDataObject] => Unit): Unit = {
    asJava.methodWithHandlerListDataObject((p:List[JTestDataObject]) => listHandler(p))
  }

  def methodWithHandlerListEnum(listHandler: List[io.vertx.codegen.testmodel.TestEnum] => Unit): Unit = {
    asJava.methodWithHandlerListEnum((p:List[io.vertx.codegen.testmodel.TestEnum]) => listHandler(p))
  }

  def methodWithHandlerAsyncResultSetString(handler: AsyncResult[Set[String]] => Unit): Unit = {
    asJava.methodWithHandlerAsyncResultSetString((p:AsyncResult[Set[String]]) => handler(p))
  }

  def methodWithHandlerAsyncResultSetInteger(handler: AsyncResult[Set[java.lang.Integer]] => Unit): Unit = {
    asJava.methodWithHandlerAsyncResultSetInteger((p:AsyncResult[Set[java.lang.Integer]]) => handler(p))
  }

  def methodWithHandlerSetVertxGen(listHandler: Set[JRefedInterface1] => Unit): Unit = {
    asJava.methodWithHandlerSetVertxGen((p:Set[JRefedInterface1]) => listHandler(p))
  }

  def methodWithHandlerSetAbstractVertxGen(listHandler: Set[JRefedInterface2] => Unit): Unit = {
    asJava.methodWithHandlerSetAbstractVertxGen((p:Set[JRefedInterface2]) => listHandler(p))
  }

  def methodWithHandlerSetJsonObject(listHandler: Set[io.vertx.core.json.JsonObject] => Unit): Unit = {
    asJava.methodWithHandlerSetJsonObject((p:Set[io.vertx.core.json.JsonObject]) => listHandler(p))
  }

  def methodWithHandlerSetComplexJsonObject(listHandler: Set[io.vertx.core.json.JsonObject] => Unit): Unit = {
    asJava.methodWithHandlerSetComplexJsonObject((p:Set[io.vertx.core.json.JsonObject]) => listHandler(p))
  }

  def methodWithHandlerSetJsonArray(listHandler: Set[io.vertx.core.json.JsonArray] => Unit): Unit = {
    asJava.methodWithHandlerSetJsonArray((p:Set[io.vertx.core.json.JsonArray]) => listHandler(p))
  }

  def methodWithHandlerSetComplexJsonArray(setHandler: Set[io.vertx.core.json.JsonArray] => Unit): Unit = {
    asJava.methodWithHandlerSetComplexJsonArray((p:Set[io.vertx.core.json.JsonArray]) => setHandler(p))
  }

  def methodWithHandlerSetDataObject(setHandler: Set[JTestDataObject] => Unit): Unit = {
    asJava.methodWithHandlerSetDataObject((p:Set[JTestDataObject]) => setHandler(p))
  }

  def methodWithHandlerSetEnum(setHandler: Set[io.vertx.codegen.testmodel.TestEnum] => Unit): Unit = {
    asJava.methodWithHandlerSetEnum((p:Set[io.vertx.codegen.testmodel.TestEnum]) => setHandler(p))
  }

  def methodWithHandlerAsyncResultListVertxGen(listHandler: AsyncResult[List[JRefedInterface1]] => Unit): Unit = {
    asJava.methodWithHandlerAsyncResultListVertxGen((p:AsyncResult[List[JRefedInterface1]]) => listHandler(p))
  }

  def methodWithHandlerAsyncResultListAbstractVertxGen(listHandler: AsyncResult[List[JRefedInterface2]] => Unit): Unit = {
    asJava.methodWithHandlerAsyncResultListAbstractVertxGen((p:AsyncResult[List[JRefedInterface2]]) => listHandler(p))
  }

  def methodWithHandlerAsyncResultListJsonObject(listHandler: AsyncResult[List[io.vertx.core.json.JsonObject]] => Unit): Unit = {
    asJava.methodWithHandlerAsyncResultListJsonObject((p:AsyncResult[List[io.vertx.core.json.JsonObject]]) => listHandler(p))
  }

  def methodWithHandlerAsyncResultListComplexJsonObject(listHandler: AsyncResult[List[io.vertx.core.json.JsonObject]] => Unit): Unit = {
    asJava.methodWithHandlerAsyncResultListComplexJsonObject((p:AsyncResult[List[io.vertx.core.json.JsonObject]]) => listHandler(p))
  }

  def methodWithHandlerAsyncResultListJsonArray(listHandler: AsyncResult[List[io.vertx.core.json.JsonArray]] => Unit): Unit = {
    asJava.methodWithHandlerAsyncResultListJsonArray((p:AsyncResult[List[io.vertx.core.json.JsonArray]]) => listHandler(p))
  }

  def methodWithHandlerAsyncResultListComplexJsonArray(listHandler: AsyncResult[List[io.vertx.core.json.JsonArray]] => Unit): Unit = {
    asJava.methodWithHandlerAsyncResultListComplexJsonArray((p:AsyncResult[List[io.vertx.core.json.JsonArray]]) => listHandler(p))
  }

  def methodWithHandlerAsyncResultListDataObject(listHandler: AsyncResult[List[JTestDataObject]] => Unit): Unit = {
    asJava.methodWithHandlerAsyncResultListDataObject((p:AsyncResult[List[JTestDataObject]]) => listHandler(p))
  }

  def methodWithHandlerAsyncResultListEnum(listHandler: AsyncResult[List[io.vertx.codegen.testmodel.TestEnum]] => Unit): Unit = {
    asJava.methodWithHandlerAsyncResultListEnum((p:AsyncResult[List[io.vertx.codegen.testmodel.TestEnum]]) => listHandler(p))
  }

  def methodWithHandlerAsyncResultSetVertxGen(listHandler: AsyncResult[Set[JRefedInterface1]] => Unit): Unit = {
    asJava.methodWithHandlerAsyncResultSetVertxGen((p:AsyncResult[Set[JRefedInterface1]]) => listHandler(p))
  }

  def methodWithHandlerAsyncResultSetAbstractVertxGen(listHandler: AsyncResult[Set[JRefedInterface2]] => Unit): Unit = {
    asJava.methodWithHandlerAsyncResultSetAbstractVertxGen((p:AsyncResult[Set[JRefedInterface2]]) => listHandler(p))
  }

  def methodWithHandlerAsyncResultSetJsonObject(listHandler: AsyncResult[Set[io.vertx.core.json.JsonObject]] => Unit): Unit = {
    asJava.methodWithHandlerAsyncResultSetJsonObject((p:AsyncResult[Set[io.vertx.core.json.JsonObject]]) => listHandler(p))
  }

  def methodWithHandlerAsyncResultSetComplexJsonObject(listHandler: AsyncResult[Set[io.vertx.core.json.JsonObject]] => Unit): Unit = {
    asJava.methodWithHandlerAsyncResultSetComplexJsonObject((p:AsyncResult[Set[io.vertx.core.json.JsonObject]]) => listHandler(p))
  }

  def methodWithHandlerAsyncResultSetJsonArray(listHandler: AsyncResult[Set[io.vertx.core.json.JsonArray]] => Unit): Unit = {
    asJava.methodWithHandlerAsyncResultSetJsonArray((p:AsyncResult[Set[io.vertx.core.json.JsonArray]]) => listHandler(p))
  }

  def methodWithHandlerAsyncResultSetComplexJsonArray(listHandler: AsyncResult[Set[io.vertx.core.json.JsonArray]] => Unit): Unit = {
    asJava.methodWithHandlerAsyncResultSetComplexJsonArray((p:AsyncResult[Set[io.vertx.core.json.JsonArray]]) => listHandler(p))
  }

  def methodWithHandlerAsyncResultSetDataObject(setHandler: AsyncResult[Set[JTestDataObject]] => Unit): Unit = {
    asJava.methodWithHandlerAsyncResultSetDataObject((p:AsyncResult[Set[JTestDataObject]]) => setHandler(p))
  }

  def methodWithHandlerAsyncResultSetEnum(setHandler: AsyncResult[Set[io.vertx.codegen.testmodel.TestEnum]] => Unit): Unit = {
    asJava.methodWithHandlerAsyncResultSetEnum((p:AsyncResult[Set[io.vertx.codegen.testmodel.TestEnum]]) => setHandler(p))
  }

  def methodWithMapReturn(handler: String => Unit): Map[String, String] = {
    asJava.methodWithMapReturn((p:String) => handler(p)).asScala.toMap
  }

  def methodWithMapStringReturn(handler: String => Unit): Map[String, String] = {
    asJava.methodWithMapStringReturn((p:String) => handler(p)).asScala.toMap
  }

  def methodWithMapLongReturn(handler: String => Unit): Map[String, java.lang.Long] = {
    asJava.methodWithMapLongReturn((p:String) => handler(p)).asScala.toMap
  }

  def methodWithMapIntegerReturn(handler: String => Unit): Map[String, java.lang.Integer] = {
    asJava.methodWithMapIntegerReturn((p:String) => handler(p)).asScala.toMap
  }

  def methodWithMapShortReturn(handler: String => Unit): Map[String, java.lang.Short] = {
    asJava.methodWithMapShortReturn((p:String) => handler(p)).asScala.toMap
  }

  def methodWithMapByteReturn(handler: String => Unit): Map[String, java.lang.Byte] = {
    asJava.methodWithMapByteReturn((p:String) => handler(p)).asScala.toMap
  }

  def methodWithMapCharacterReturn(handler: String => Unit): Map[String, java.lang.Character] = {
    asJava.methodWithMapCharacterReturn((p:String) => handler(p)).asScala.toMap
  }

  def methodWithMapBooleanReturn(handler: String => Unit): Map[String, java.lang.Boolean] = {
    asJava.methodWithMapBooleanReturn((p:String) => handler(p)).asScala.toMap
  }

  def methodWithMapFloatReturn(handler: String => Unit): Map[String, java.lang.Float] = {
    asJava.methodWithMapFloatReturn((p:String) => handler(p)).asScala.toMap
  }

  def methodWithMapDoubleReturn(handler: String => Unit): Map[String, java.lang.Double] = {
    asJava.methodWithMapDoubleReturn((p:String) => handler(p)).asScala.toMap
  }

  def methodWithMapJsonObjectReturn(handler: String => Unit): Map[String, io.vertx.core.json.JsonObject] = {
    asJava.methodWithMapJsonObjectReturn((p:String) => handler(p)).asScala.toMap
  }

  def methodWithMapComplexJsonObjectReturn(handler: String => Unit): Map[String, io.vertx.core.json.JsonObject] = {
    asJava.methodWithMapComplexJsonObjectReturn((p:String) => handler(p)).asScala.toMap
  }

  def methodWithMapJsonArrayReturn(handler: String => Unit): Map[String, io.vertx.core.json.JsonArray] = {
    asJava.methodWithMapJsonArrayReturn((p:String) => handler(p)).asScala.toMap
  }

  def methodWithMapComplexJsonArrayReturn(handler: String => Unit): Map[String, io.vertx.core.json.JsonArray] = {
    asJava.methodWithMapComplexJsonArrayReturn((p:String) => handler(p)).asScala.toMap
  }

  def methodWithListStringReturn(): List[String] = {
    asJava.methodWithListStringReturn().asScala.toList
  }

  def methodWithListLongReturn(): List[java.lang.Long] = {
    asJava.methodWithListLongReturn().asScala.toList
  }

  def methodWithListVertxGenReturn(): List[JRefedInterface1] = {
    asJava.methodWithListVertxGenReturn().asScala.toList
  }

  def methodWithListJsonObjectReturn(): List[io.vertx.core.json.JsonObject] = {
    asJava.methodWithListJsonObjectReturn().asScala.toList
  }

  def methodWithListComplexJsonObjectReturn(): List[io.vertx.core.json.JsonObject] = {
    asJava.methodWithListComplexJsonObjectReturn().asScala.toList
  }

  def methodWithListJsonArrayReturn(): List[io.vertx.core.json.JsonArray] = {
    asJava.methodWithListJsonArrayReturn().asScala.toList
  }

  def methodWithListComplexJsonArrayReturn(): List[io.vertx.core.json.JsonArray] = {
    asJava.methodWithListComplexJsonArrayReturn().asScala.toList
  }

  def methodWithListDataObjectReturn(): List[JTestDataObject] = {
    asJava.methodWithListDataObjectReturn().asScala.toList
  }

  def methodWithListEnumReturn(): List[io.vertx.codegen.testmodel.TestEnum] = {
    asJava.methodWithListEnumReturn().asScala.toList
  }

  def methodWithSetStringReturn(): Seq[String] = {
    asJava.methodWithSetStringReturn().asScala.toSeq
  }

  def methodWithSetLongReturn(): Seq[java.lang.Long] = {
    asJava.methodWithSetLongReturn().asScala.toSeq
  }

  def methodWithSetVertxGenReturn(): Seq[JRefedInterface1] = {
    asJava.methodWithSetVertxGenReturn().asScala.toSeq
  }

  def methodWithSetJsonObjectReturn(): Seq[io.vertx.core.json.JsonObject] = {
    asJava.methodWithSetJsonObjectReturn().asScala.toSeq
  }

  def methodWithSetComplexJsonObjectReturn(): Seq[io.vertx.core.json.JsonObject] = {
    asJava.methodWithSetComplexJsonObjectReturn().asScala.toSeq
  }

  def methodWithSetJsonArrayReturn(): Seq[io.vertx.core.json.JsonArray] = {
    asJava.methodWithSetJsonArrayReturn().asScala.toSeq
  }

  def methodWithSetComplexJsonArrayReturn(): Seq[io.vertx.core.json.JsonArray] = {
    asJava.methodWithSetComplexJsonArrayReturn().asScala.toSeq
  }

  def methodWithSetDataObjectReturn(): Seq[JTestDataObject] = {
    asJava.methodWithSetDataObjectReturn().asScala.toSeq
  }

  def methodWithSetEnumReturn(): Seq[io.vertx.codegen.testmodel.TestEnum] = {
    asJava.methodWithSetEnumReturn().asScala.toSeq
  }

  def methodWithHandlerAsyncResultListStringFuture(): scala.concurrent.Future[List[String]] = {
    val promise = Promise[List[String]]()
    asJava.methodWithHandlerAsyncResultListString({a:AsyncResult[java.util.List[java.lang.String]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.toList);()})
    promise.future
  }

  def methodWithHandlerAsyncResultListIntegerFuture(): scala.concurrent.Future[List[java.lang.Integer]] = {
    val promise = Promise[List[java.lang.Integer]]()
    asJava.methodWithHandlerAsyncResultListInteger({a:AsyncResult[java.util.List[java.lang.Integer]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.toList);()})
    promise.future
  }

  def methodWithHandlerAsyncResultSetStringFuture(): scala.concurrent.Future[Seq[String]] = {
    val promise = Promise[Seq[String]]()
    asJava.methodWithHandlerAsyncResultSetString({a:AsyncResult[java.util.Set[java.lang.String]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.toSeq);()})
    promise.future
  }

  def methodWithHandlerAsyncResultSetIntegerFuture(): scala.concurrent.Future[Seq[java.lang.Integer]] = {
    val promise = Promise[Seq[java.lang.Integer]]()
    asJava.methodWithHandlerAsyncResultSetInteger({a:AsyncResult[java.util.Set[java.lang.Integer]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.toSeq);()})
    promise.future
  }

  def methodWithHandlerAsyncResultListVertxGenFuture(): scala.concurrent.Future[List[JRefedInterface1]] = {
    val promise = Promise[List[JRefedInterface1]]()
    asJava.methodWithHandlerAsyncResultListVertxGen({a:AsyncResult[java.util.List[io.vertx.codegen.testmodel.RefedInterface1]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.toList);()})
    promise.future
  }

  def methodWithHandlerAsyncResultListAbstractVertxGenFuture(): scala.concurrent.Future[List[JRefedInterface2]] = {
    val promise = Promise[List[JRefedInterface2]]()
    asJava.methodWithHandlerAsyncResultListAbstractVertxGen({a:AsyncResult[java.util.List[io.vertx.codegen.testmodel.RefedInterface2]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.toList);()})
    promise.future
  }

  def methodWithHandlerAsyncResultListJsonObjectFuture(): scala.concurrent.Future[List[io.vertx.core.json.JsonObject]] = {
    val promise = Promise[List[io.vertx.core.json.JsonObject]]()
    asJava.methodWithHandlerAsyncResultListJsonObject({a:AsyncResult[java.util.List[io.vertx.core.json.JsonObject]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.toList);()})
    promise.future
  }

  def methodWithHandlerAsyncResultListComplexJsonObjectFuture(): scala.concurrent.Future[List[io.vertx.core.json.JsonObject]] = {
    val promise = Promise[List[io.vertx.core.json.JsonObject]]()
    asJava.methodWithHandlerAsyncResultListComplexJsonObject({a:AsyncResult[java.util.List[io.vertx.core.json.JsonObject]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.toList);()})
    promise.future
  }

  def methodWithHandlerAsyncResultListJsonArrayFuture(): scala.concurrent.Future[List[io.vertx.core.json.JsonArray]] = {
    val promise = Promise[List[io.vertx.core.json.JsonArray]]()
    asJava.methodWithHandlerAsyncResultListJsonArray({a:AsyncResult[java.util.List[io.vertx.core.json.JsonArray]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.toList);()})
    promise.future
  }

  def methodWithHandlerAsyncResultListComplexJsonArrayFuture(): scala.concurrent.Future[List[io.vertx.core.json.JsonArray]] = {
    val promise = Promise[List[io.vertx.core.json.JsonArray]]()
    asJava.methodWithHandlerAsyncResultListComplexJsonArray({a:AsyncResult[java.util.List[io.vertx.core.json.JsonArray]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.toList);()})
    promise.future
  }

  def methodWithHandlerAsyncResultListDataObjectFuture(): scala.concurrent.Future[List[JTestDataObject]] = {
    val promise = Promise[List[JTestDataObject]]()
    asJava.methodWithHandlerAsyncResultListDataObject({a:AsyncResult[java.util.List[io.vertx.codegen.testmodel.TestDataObject]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.toList);()})
    promise.future
  }

  def methodWithHandlerAsyncResultListEnumFuture(): scala.concurrent.Future[List[io.vertx.codegen.testmodel.TestEnum]] = {
    val promise = Promise[List[io.vertx.codegen.testmodel.TestEnum]]()
    asJava.methodWithHandlerAsyncResultListEnum({a:AsyncResult[java.util.List[io.vertx.codegen.testmodel.TestEnum]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.toList);()})
    promise.future
  }

  def methodWithHandlerAsyncResultSetVertxGenFuture(): scala.concurrent.Future[Seq[JRefedInterface1]] = {
    val promise = Promise[Seq[JRefedInterface1]]()
    asJava.methodWithHandlerAsyncResultSetVertxGen({a:AsyncResult[java.util.Set[io.vertx.codegen.testmodel.RefedInterface1]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.toSeq);()})
    promise.future
  }

  def methodWithHandlerAsyncResultSetAbstractVertxGenFuture(): scala.concurrent.Future[Seq[JRefedInterface2]] = {
    val promise = Promise[Seq[JRefedInterface2]]()
    asJava.methodWithHandlerAsyncResultSetAbstractVertxGen({a:AsyncResult[java.util.Set[io.vertx.codegen.testmodel.RefedInterface2]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.toSeq);()})
    promise.future
  }

  def methodWithHandlerAsyncResultSetJsonObjectFuture(): scala.concurrent.Future[Seq[io.vertx.core.json.JsonObject]] = {
    val promise = Promise[Seq[io.vertx.core.json.JsonObject]]()
    asJava.methodWithHandlerAsyncResultSetJsonObject({a:AsyncResult[java.util.Set[io.vertx.core.json.JsonObject]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.toSeq);()})
    promise.future
  }

  def methodWithHandlerAsyncResultSetComplexJsonObjectFuture(): scala.concurrent.Future[Seq[io.vertx.core.json.JsonObject]] = {
    val promise = Promise[Seq[io.vertx.core.json.JsonObject]]()
    asJava.methodWithHandlerAsyncResultSetComplexJsonObject({a:AsyncResult[java.util.Set[io.vertx.core.json.JsonObject]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.toSeq);()})
    promise.future
  }

  def methodWithHandlerAsyncResultSetJsonArrayFuture(): scala.concurrent.Future[Seq[io.vertx.core.json.JsonArray]] = {
    val promise = Promise[Seq[io.vertx.core.json.JsonArray]]()
    asJava.methodWithHandlerAsyncResultSetJsonArray({a:AsyncResult[java.util.Set[io.vertx.core.json.JsonArray]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.toSeq);()})
    promise.future
  }

  def methodWithHandlerAsyncResultSetComplexJsonArrayFuture(): scala.concurrent.Future[Seq[io.vertx.core.json.JsonArray]] = {
    val promise = Promise[Seq[io.vertx.core.json.JsonArray]]()
    asJava.methodWithHandlerAsyncResultSetComplexJsonArray({a:AsyncResult[java.util.Set[io.vertx.core.json.JsonArray]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.toSeq);()})
    promise.future
  }

  def methodWithHandlerAsyncResultSetDataObjectFuture(): scala.concurrent.Future[Seq[JTestDataObject]] = {
    val promise = Promise[Seq[JTestDataObject]]()
    asJava.methodWithHandlerAsyncResultSetDataObject({a:AsyncResult[java.util.Set[io.vertx.codegen.testmodel.TestDataObject]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.toSeq);()})
    promise.future
  }

  def methodWithHandlerAsyncResultSetEnumFuture(): scala.concurrent.Future[Seq[io.vertx.codegen.testmodel.TestEnum]] = {
    val promise = Promise[Seq[io.vertx.codegen.testmodel.TestEnum]]()
    asJava.methodWithHandlerAsyncResultSetEnum({a:AsyncResult[java.util.Set[io.vertx.codegen.testmodel.TestEnum]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.toSeq);()})
    promise.future
  }

}

import io.vertx.codegen.testmodel.{ConcreteHandlerUserType => JConcreteHandlerUserType}
import io.vertx.codegen.testmodel.{RefedInterface1 => JRefedInterface1}
import io.vertx.core.Handler
import io.vertx.codegen.testmodel.RefedInterface1

/**
  */
implicit class ConcreteHandlerUserTypeScala(val asJava: JConcreteHandlerUserType) extends AnyVal {


  def handle(arg0: JRefedInterface1): Unit = {
    asJava.handle(arg0.asJava)
  }

}

import io.vertx.codegen.testmodel.{ConcreteHandlerUserType => JConcreteHandlerUserType}
import io.vertx.codegen.testmodel.{RefedInterface1 => JRefedInterface1}
import io.vertx.codegen.testmodel.{ConcreteHandlerUserTypeExtension => JConcreteHandlerUserTypeExtension}
import io.vertx.codegen.testmodel.RefedInterface1
import io.vertx.codegen.testmodel.ConcreteHandlerUserType

/**
  */
implicit class ConcreteHandlerUserTypeExtensionScala(val asJava: JConcreteHandlerUserTypeExtension) extends AnyVal {


  def handle(arg0: JRefedInterface1): Unit = {
    asJava.handle(arg0.asJava)
  }

}

import io.vertx.codegen.testmodel.DataObjectWithMaps
import io.vertx.codegen.testmodel.DataObjectWithRecursion
import io.vertx.codegen.testmodel.DataObjectWithOnlyJsonObjectConstructor
import io.vertx.codegen.testmodel.{DataObjectWithValues => JDataObjectWithValues}
import io.vertx.codegen.testmodel.{DataObjectWithRecursion => JDataObjectWithRecursion}
import io.vertx.codegen.testmodel.DataObjectWithListAdders
import io.vertx.codegen.testmodel.{DataObjectWithMapAdders => JDataObjectWithMapAdders}
import io.vertx.codegen.testmodel.{DataObjectWithListAdders => JDataObjectWithListAdders}
import io.vertx.codegen.testmodel.{DataObjectWithOnlyJsonObjectConstructor => JDataObjectWithOnlyJsonObjectConstructor}
import io.vertx.codegen.testmodel.DataObjectWithNestedBuffer
import io.vertx.codegen.testmodel.{DataObjectTCK => JDataObjectTCK}
import io.vertx.codegen.testmodel.DataObjectWithValues
import io.vertx.codegen.testmodel.DataObjectWithMapAdders
import io.vertx.codegen.testmodel.{DataObjectWithMaps => JDataObjectWithMaps}
import io.vertx.codegen.testmodel.{DataObjectWithLists => JDataObjectWithLists}
import io.vertx.codegen.testmodel.DataObjectWithLists
import io.vertx.codegen.testmodel.{DataObjectWithNestedBuffer => JDataObjectWithNestedBuffer}

/**
  * todo:
  * - Buffer support
  */
implicit class DataObjectTCKScala(val asJava: JDataObjectTCK) extends AnyVal {


  def getDataObjectWithValues(): JDataObjectWithValues = {
    asJava.getDataObjectWithValues()
  }

  def setDataObjectWithValues(dataObject: JDataObjectWithValues): Unit = {
    asJava.setDataObjectWithValues(dataObject.asJava)
  }

  def getDataObjectWithLists(): JDataObjectWithLists = {
    asJava.getDataObjectWithLists()
  }

  def setDataObjectWithLists(dataObject: JDataObjectWithLists): Unit = {
    asJava.setDataObjectWithLists(dataObject.asJava)
  }

  def getDataObjectWithMaps(): JDataObjectWithMaps = {
    asJava.getDataObjectWithMaps()
  }

  def setDataObjectWithMaps(dataObject: JDataObjectWithMaps): Unit = {
    asJava.setDataObjectWithMaps(dataObject.asJava)
  }

  def methodWithOnlyJsonObjectConstructorDataObject(dataObject: JDataObjectWithOnlyJsonObjectConstructor): Unit = {
    asJava.methodWithOnlyJsonObjectConstructorDataObject(dataObject.asJava)
  }

  def setDataObjectWithBuffer(dataObject: JDataObjectWithNestedBuffer): Unit = {
    asJava.setDataObjectWithBuffer(dataObject.asJava)
  }

  def setDataObjectWithListAdders(dataObject: JDataObjectWithListAdders): Unit = {
    asJava.setDataObjectWithListAdders(dataObject.asJava)
  }

  def setDataObjectWithMapAdders(dataObject: JDataObjectWithMapAdders): Unit = {
    asJava.setDataObjectWithMapAdders(dataObject.asJava)
  }

  def setDataObjectWithRecursion(dataObject: JDataObjectWithRecursion): Unit = {
    asJava.setDataObjectWithRecursion(dataObject.asJava)
  }

}

import io.vertx.core.buffer.Buffer
import io.vertx.codegen.testmodel.{DataObjectWithBuffer => JDataObjectWithBuffer}

/**
  */

  implicit class DataObjectWithBufferScala(val asJava: JDataObjectWithBuffer) extends AnyVal {

    def setBuffer(value: io.vertx.core.buffer.Buffer) = {
      asJava.setBuffer(value)
    }
    def getBuffer: io.vertx.core.buffer.Buffer = {
      asJava.getBuffer()
    }
  }
  
  type DataObjectWithBuffer = JDataObjectWithBuffer
  object DataObjectWithBuffer {
    def apply(): JDataObjectWithBuffer = new DataObjectWithBuffer()
    def apply(json: JsonObject) = new JDataObjectWithBuffer(json)
  }


import io.vertx.core.json.JsonArray
import io.vertx.codegen.testmodel.TestEnum
import io.vertx.codegen.testmodel.{TestDataObject => JTestDataObject}
import io.vertx.codegen.testmodel.{DataObjectWithListAdders => JDataObjectWithListAdders}
import io.vertx.core.json.JsonObject
import io.vertx.codegen.testmodel.TestDataObject
import io.vertx.codegen.testmodel.TestGenEnum

/**
  */

  implicit class DataObjectWithListAddersScala(val asJava: JDataObjectWithListAdders) extends AnyVal {

    def addBooleanValue(value: java.lang.Boolean) = {
      asJava.addBooleanValue(value)
      }
    def addDataObjectValue(value: JTestDataObject) = {
      asJava.addDataObjectValue(value.asJava)
      }
    def addDoubleValue(value: java.lang.Double) = {
      asJava.addDoubleValue(value)
      }
    def addEnumValue(value: io.vertx.codegen.testmodel.TestEnum) = {
      asJava.addEnumValue(value)
      }
    def addFloatValue(value: java.lang.Float) = {
      asJava.addFloatValue(value)
      }
    def addGenEnumValue(value: io.vertx.codegen.testmodel.TestGenEnum) = {
      asJava.addGenEnumValue(value)
      }
    def addIntegerValue(value: java.lang.Integer) = {
      asJava.addIntegerValue(value)
      }
    def addJsonArrayValue(value: io.vertx.core.json.JsonArray) = {
      asJava.addJsonArrayValue(value)
      }
    def addJsonObjectValue(value: io.vertx.core.json.JsonObject) = {
      asJava.addJsonObjectValue(value)
      }
    def addLongValue(value: java.lang.Long) = {
      asJava.addLongValue(value)
      }
    def addShortValue(value: java.lang.Short) = {
      asJava.addShortValue(value)
      }
    def addStringValue(value: String) = {
      asJava.addStringValue(value)
      }
  }
  
  type DataObjectWithListAdders = JDataObjectWithListAdders
  object DataObjectWithListAdders {
    def apply(): JDataObjectWithListAdders = new DataObjectWithListAdders()
    def apply(json: JsonObject) = new JDataObjectWithListAdders(json)
  }


import io.vertx.core.json.JsonArray
import io.vertx.codegen.testmodel.TestEnum
import io.vertx.codegen.testmodel.{TestDataObject => JTestDataObject}
import io.vertx.codegen.testmodel.{DataObjectWithLists => JDataObjectWithLists}
import io.vertx.core.json.JsonObject
import io.vertx.codegen.testmodel.TestDataObject
import io.vertx.codegen.testmodel.TestGenEnum

/**
  */

  implicit class DataObjectWithListsScala(val asJava: JDataObjectWithLists) extends AnyVal {

    def setBooleanValues(value: List[java.lang.Boolean]) = {
        asJava.setBooleanValues(value.asJava)
      }
    def setDataObjectValues(value: List[JTestDataObject]) = {
      asJava.setDataObjectValues(value.asJava)
      }
    def setDoubleValues(value: List[java.lang.Double]) = {
        asJava.setDoubleValues(value.asJava)
      }
    def setEnumValues(value: List[io.vertx.codegen.testmodel.TestEnum]) = {
      asJava.setEnumValues(value.asJava)
      }
    def setFloatValues(value: List[java.lang.Float]) = {
        asJava.setFloatValues(value.asJava)
      }
    def setGenEnumValues(value: List[io.vertx.codegen.testmodel.TestGenEnum]) = {
      asJava.setGenEnumValues(value.asJava)
      }
    def setIntegerValues(value: List[java.lang.Integer]) = {
        asJava.setIntegerValues(value.asJava)
      }
    def setJsonArrayValues(value: List[io.vertx.core.json.JsonArray]) = {
      asJava.setJsonArrayValues(value.asJava)
      }
    def setJsonObjectValues(value: List[io.vertx.core.json.JsonObject]) = {
      asJava.setJsonObjectValues(value.asJava)
      }
    def setLongValues(value: List[java.lang.Long]) = {
        asJava.setLongValues(value.asJava)
      }
    def setShortValues(value: List[java.lang.Short]) = {
        asJava.setShortValues(value.asJava)
      }
    def setStringValues(value: List[String]) = {
      asJava.setStringValues(value.asJava)
      }
  }
  
  type DataObjectWithLists = JDataObjectWithLists
  object DataObjectWithLists {
    def apply(): JDataObjectWithLists = new DataObjectWithLists()
    def apply(json: JsonObject) = new JDataObjectWithLists(json)
  }


import io.vertx.core.json.JsonArray
import io.vertx.codegen.testmodel.TestEnum
import io.vertx.codegen.testmodel.{TestDataObject => JTestDataObject}
import io.vertx.codegen.testmodel.{DataObjectWithMapAdders => JDataObjectWithMapAdders}
import io.vertx.core.json.JsonObject
import io.vertx.codegen.testmodel.TestDataObject
import io.vertx.codegen.testmodel.TestGenEnum

/**
  */

  implicit class DataObjectWithMapAddersScala(val asJava: JDataObjectWithMapAdders) extends AnyVal {

    def addBooleanValue(key: String, value: java.lang.Boolean) = {
      asJava.addBooleanValue(key, value)
    }
    def addDataObjectValue(key: String, value: JTestDataObject) = {
      asJava.addDataObjectValue(key, value.asJava)
    }
    def addDoubleValue(key: String, value: java.lang.Double) = {
      asJava.addDoubleValue(key, value)
    }
    def addEnumValue(key: String, value: io.vertx.codegen.testmodel.TestEnum) = {
      asJava.addEnumValue(key, value)
    }
    def addFloatValue(key: String, value: java.lang.Float) = {
      asJava.addFloatValue(key, value)
    }
    def addGenEnumValue(key: String, value: io.vertx.codegen.testmodel.TestGenEnum) = {
      asJava.addGenEnumValue(key, value)
    }
    def addIntegerValue(key: String, value: java.lang.Integer) = {
      asJava.addIntegerValue(key, value)
    }
    def addJsonArrayValue(key: String, value: io.vertx.core.json.JsonArray) = {
      asJava.addJsonArrayValue(key, value)
    }
    def addJsonObjectValue(key: String, value: io.vertx.core.json.JsonObject) = {
      asJava.addJsonObjectValue(key, value)
    }
    def addLongValue(key: String, value: java.lang.Long) = {
      asJava.addLongValue(key, value)
    }
    def addShortValue(key: String, value: java.lang.Short) = {
      asJava.addShortValue(key, value)
    }
    def addStringValue(key: String, value: String) = {
      asJava.addStringValue(key, value)
    }
  }
  
  type DataObjectWithMapAdders = JDataObjectWithMapAdders
  object DataObjectWithMapAdders {
    def apply(): JDataObjectWithMapAdders = new DataObjectWithMapAdders()
    def apply(json: JsonObject) = new JDataObjectWithMapAdders(json)
  }


import io.vertx.core.json.JsonArray
import io.vertx.codegen.testmodel.TestEnum
import io.vertx.codegen.testmodel.{TestDataObject => JTestDataObject}
import io.vertx.codegen.testmodel.{DataObjectWithMaps => JDataObjectWithMaps}
import io.vertx.core.json.JsonObject
import io.vertx.codegen.testmodel.TestDataObject
import io.vertx.codegen.testmodel.TestGenEnum

/**
  */

  implicit class DataObjectWithMapsScala(val asJava: JDataObjectWithMaps) extends AnyVal {

    def setBooleanValues(value: Map[String, java.lang.Boolean]) = {
      asJava.setBooleanValues(value.asJava)
    }
    def setDataObjectValues(value: Map[String, JTestDataObject]) = {
      asJava.setDataObjectValues(value.asJava)
    }
    def setDoubleValues(value: Map[String, java.lang.Double]) = {
      asJava.setDoubleValues(value.asJava)
    }
    def setEnumValues(value: Map[String, io.vertx.codegen.testmodel.TestEnum]) = {
      asJava.setEnumValues(value.asJava)
    }
    def setFloatValues(value: Map[String, java.lang.Float]) = {
      asJava.setFloatValues(value.asJava)
    }
    def setGenEnumValues(value: Map[String, io.vertx.codegen.testmodel.TestGenEnum]) = {
      asJava.setGenEnumValues(value.asJava)
    }
    def setIntegerValues(value: Map[String, java.lang.Integer]) = {
      asJava.setIntegerValues(value.asJava)
    }
    def setJsonArrayValues(value: Map[String, io.vertx.core.json.JsonArray]) = {
      asJava.setJsonArrayValues(value.asJava)
    }
    def setJsonObjectValues(value: Map[String, io.vertx.core.json.JsonObject]) = {
      asJava.setJsonObjectValues(value.asJava)
    }
    def setLongValues(value: Map[String, java.lang.Long]) = {
      asJava.setLongValues(value.asJava)
    }
    def setShortValues(value: Map[String, java.lang.Short]) = {
      asJava.setShortValues(value.asJava)
    }
    def setStringValues(value: Map[String, String]) = {
      asJava.setStringValues(value.asJava)
    }
  }
  
  type DataObjectWithMaps = JDataObjectWithMaps
  object DataObjectWithMaps {
    def apply(): JDataObjectWithMaps = new DataObjectWithMaps()
    def apply(json: JsonObject) = new JDataObjectWithMaps(json)
  }


import io.vertx.codegen.testmodel.DataObjectWithBuffer
import io.vertx.core.buffer.Buffer
import io.vertx.codegen.testmodel.{DataObjectWithBuffer => JDataObjectWithBuffer}
import io.vertx.codegen.testmodel.{DataObjectWithNestedBuffer => JDataObjectWithNestedBuffer}

/**
  */

  implicit class DataObjectWithNestedBufferScala(val asJava: JDataObjectWithNestedBuffer) extends AnyVal {

    def setBuffer(value: io.vertx.core.buffer.Buffer) = {
      asJava.setBuffer(value)
    }
    def getBuffer: io.vertx.core.buffer.Buffer = {
      asJava.getBuffer()
    }
    def setBuffers(value: List[io.vertx.core.buffer.Buffer]) = {
      asJava.setBuffers(value.asJava)
      }
    def getBuffers: scala.collection.mutable.Buffer[io.vertx.core.buffer.Buffer] = {
      asJava.getBuffers().asScala
    }
    def setNested(value: JDataObjectWithBuffer) = {
      asJava.setNested(value.asJava)
    }
    def getNested: JDataObjectWithBuffer = {
      asJava.getNested()
    }
  }
  
  type DataObjectWithNestedBuffer = JDataObjectWithNestedBuffer
  object DataObjectWithNestedBuffer {
    def apply(): JDataObjectWithNestedBuffer = new DataObjectWithNestedBuffer()
    def apply(json: JsonObject) = new JDataObjectWithNestedBuffer(json)
  }


import io.vertx.codegen.testmodel.{DataObjectWithOnlyJsonObjectConstructor => JDataObjectWithOnlyJsonObjectConstructor}

/**
  */

  implicit class DataObjectWithOnlyJsonObjectConstructorScala(val asJava: JDataObjectWithOnlyJsonObjectConstructor) extends AnyVal {

  }
  
  type DataObjectWithOnlyJsonObjectConstructor = JDataObjectWithOnlyJsonObjectConstructor
  object DataObjectWithOnlyJsonObjectConstructor {
        def apply(json: JsonObject) = new JDataObjectWithOnlyJsonObjectConstructor(json)
  }


import io.vertx.codegen.testmodel.DataObjectWithRecursion
import io.vertx.codegen.testmodel.{DataObjectWithRecursion => JDataObjectWithRecursion}

/**
  */

  implicit class DataObjectWithRecursionScala(val asJava: JDataObjectWithRecursion) extends AnyVal {

    def setData(value: String) = {
      asJava.setData(value)
    }
    def getData: String = {
      asJava.getData()
    }
    def setNext(value: JDataObjectWithRecursion) = {
      asJava.setNext(value.asJava)
    }
    def getNext: JDataObjectWithRecursion = {
      asJava.getNext()
    }
  }
  
  type DataObjectWithRecursion = JDataObjectWithRecursion
  object DataObjectWithRecursion {
        def apply(json: JsonObject) = new JDataObjectWithRecursion(json)
  }


import io.vertx.core.json.JsonArray
import io.vertx.codegen.testmodel.{DataObjectWithValues => JDataObjectWithValues}
import io.vertx.codegen.testmodel.TestEnum
import io.vertx.codegen.testmodel.{TestDataObject => JTestDataObject}
import io.vertx.core.json.JsonObject
import io.vertx.codegen.testmodel.TestDataObject
import io.vertx.codegen.testmodel.TestGenEnum

/**
  */

  implicit class DataObjectWithValuesScala(val asJava: JDataObjectWithValues) extends AnyVal {

    def setBooleanValue(value: java.lang.Boolean) = {
      asJava.setBooleanValue(value)
    }
    def setBoxedBooleanValue(value: java.lang.Boolean) = {
      asJava.setBoxedBooleanValue(value)
    }
    def setBoxedDoubleValue(value: java.lang.Double) = {
      asJava.setBoxedDoubleValue(value)
    }
    def setBoxedFloatValue(value: java.lang.Float) = {
      asJava.setBoxedFloatValue(value)
    }
    def setBoxedIntValue(value: java.lang.Integer) = {
      asJava.setBoxedIntValue(value)
    }
    def setBoxedLongValue(value: java.lang.Long) = {
      asJava.setBoxedLongValue(value)
    }
    def setBoxedShortValue(value: java.lang.Short) = {
      asJava.setBoxedShortValue(value)
    }
    def setDataObjectValue(value: JTestDataObject) = {
      asJava.setDataObjectValue(value.asJava)
    }
    def setDoubleValue(value: java.lang.Double) = {
      asJava.setDoubleValue(value)
    }
    def setEnumValue(value: io.vertx.codegen.testmodel.TestEnum) = {
      asJava.setEnumValue(value)
    }
    def setFloatValue(value: java.lang.Float) = {
      asJava.setFloatValue(value)
    }
    def setGenEnumValue(value: io.vertx.codegen.testmodel.TestGenEnum) = {
      asJava.setGenEnumValue(value)
    }
    def setIntValue(value: java.lang.Integer) = {
      asJava.setIntValue(value)
    }
    def setJsonArrayValue(value: io.vertx.core.json.JsonArray) = {
      asJava.setJsonArrayValue(value)
    }
    def setJsonObjectValue(value: io.vertx.core.json.JsonObject) = {
      asJava.setJsonObjectValue(value)
    }
    def setLongValue(value: java.lang.Long) = {
      asJava.setLongValue(value)
    }
    def setShortValue(value: java.lang.Short) = {
      asJava.setShortValue(value)
    }
    def setStringValue(value: String) = {
      asJava.setStringValue(value)
    }
  }
  
  type DataObjectWithValues = JDataObjectWithValues
  object DataObjectWithValues {
    def apply(): JDataObjectWithValues = new DataObjectWithValues()
    def apply(json: JsonObject) = new JDataObjectWithValues(json)
  }


import io.vertx.codegen.testmodel.{ConcreteHandlerUserType => JConcreteHandlerUserType}
import io.vertx.codegen.testmodel.{AbstractHandlerUserType => JAbstractHandlerUserType}
import io.vertx.codegen.testmodel.{RefedInterface1 => JRefedInterface1}
import io.vertx.codegen.testmodel.{ConcreteHandlerUserTypeExtension => JConcreteHandlerUserTypeExtension}
import io.vertx.core.Handler
import io.vertx.codegen.testmodel.RefedInterface1
import io.vertx.codegen.testmodel.ConcreteHandlerUserType
import io.vertx.codegen.testmodel.AbstractHandlerUserType
import io.vertx.codegen.testmodel.ConcreteHandlerUserTypeExtension
import io.vertx.codegen.testmodel.{Factory => JFactory}

/**
  */
implicit class FactoryScala(val asJava: JFactory) extends AnyVal {


}

import io.vertx.core.json.JsonArray
import io.vertx.codegen.testmodel.{RefedInterface1 => JRefedInterface1}
import io.vertx.codegen.testmodel.TestEnum
import io.vertx.codegen.testmodel.{TestDataObject => JTestDataObject}
import io.vertx.codegen.testmodel.GenericRefedInterface
import io.vertx.core.json.JsonObject
import io.vertx.codegen.testmodel.TestDataObject
import scala.collection.JavaConverters._
import io.vertx.codegen.testmodel.{GenericRefedInterface => JGenericRefedInterface}
import io.vertx.codegen.testmodel.RefedInterface1
import io.vertx.codegen.testmodel.{FunctionParamTCK => JFunctionParamTCK}

/**
  */
implicit class FunctionParamTCKScala(val asJava: JFunctionParamTCK) extends AnyVal {


  def methodWithBasicParam(byteFunc: java.lang.Byte => String, shortFunc: java.lang.Short => String, integerFunc: java.lang.Integer => String, longFunc: java.lang.Long => String, floatFunc: java.lang.Float => String, doubleFunc: java.lang.Double => String, booleanFunc: java.lang.Boolean => String, charFunc: java.lang.Character => String, stringFunc: String => String): List[String] = {
    asJava.methodWithBasicParam(asJavaFunction(byteFunc), asJavaFunction(shortFunc), asJavaFunction(integerFunc), asJavaFunction(longFunc), asJavaFunction(floatFunc), asJavaFunction(doubleFunc), asJavaFunction(booleanFunc), asJavaFunction(charFunc), asJavaFunction(stringFunc)).asScala.toList
  }

  def methodWithJsonParam(objectFunc: io.vertx.core.json.JsonObject => String, arrayFunc: io.vertx.core.json.JsonArray => String): List[String] = {
    asJava.methodWithJsonParam(asJavaFunction(objectFunc), asJavaFunction(arrayFunc)).asScala.toList
  }

  def methodWithVoidParam(func: Void => String): String = {
    asJava.methodWithVoidParam(asJavaFunction(func))
  }

  def methodWithUserTypeParam(arg: JRefedInterface1, func: JRefedInterface1 => String): String = {
    asJava.methodWithUserTypeParam(arg.asJava, asJavaFunction(func))
  }

  def methodWithObjectParam(arg: AnyRef, func: AnyRef => String): String = {
    asJava.methodWithObjectParam(arg, asJavaFunction(func))
  }

  def methodWithDataObjectParam(func: JTestDataObject => String): String = {
    asJava.methodWithDataObjectParam(asJavaFunction(func))
  }

  def methodWithEnumParam(func: io.vertx.codegen.testmodel.TestEnum => String): String = {
    asJava.methodWithEnumParam(asJavaFunction(func))
  }

  def methodWithListParam(stringFunc: List[String] => String): String = {
    asJava.methodWithListParam(asJavaFunction(stringFunc))
  }

  def methodWithSetParam(func: Set[String] => String): String = {
    asJava.methodWithSetParam(asJavaFunction(func))
  }

  def methodWithMapParam(func: Map[String, String] => String): String = {
    asJava.methodWithMapParam(asJavaFunction(func))
  }

  def methodWithGenericParam[T](t: T, func: T => String): String = {
    asJava.methodWithGenericParam[T](t, asJavaFunction(func))
  }

  def methodWithGenericUserTypeParam[T](t: T, func: JGenericRefedInterface[T] => String): String = {
    asJava.methodWithGenericUserTypeParam[T](t, asJavaFunction(func))
  }

  def methodWithBasicReturn(byteFunc: String => java.lang.Byte, shortFunc: String => java.lang.Short, integerFunc: String => java.lang.Integer, longFunc: String => java.lang.Long, floatFunc: String => java.lang.Float, doubleFunc: String => java.lang.Double, booleanFunc: String => java.lang.Boolean, charFunc: String => java.lang.Character, stringFunc: String => String): String = {
    asJava.methodWithBasicReturn(asJavaFunction(byteFunc), asJavaFunction(shortFunc), asJavaFunction(integerFunc), asJavaFunction(longFunc), asJavaFunction(floatFunc), asJavaFunction(doubleFunc), asJavaFunction(booleanFunc), asJavaFunction(charFunc), asJavaFunction(stringFunc))
  }

  def methodWithJsonReturn(objectFunc: String => io.vertx.core.json.JsonObject, arrayFunc: String => io.vertx.core.json.JsonArray): String = {
    asJava.methodWithJsonReturn(asJavaFunction(objectFunc), asJavaFunction(arrayFunc))
  }

  def methodWithObjectReturn(func: java.lang.Integer => AnyRef): String = {
    asJava.methodWithObjectReturn(asJavaFunction(func))
  }

  def methodWithDataObjectReturn(func: String => JTestDataObject): String = {
    asJava.methodWithDataObjectReturn(asJavaFunction(func))
  }

  def methodWithEnumReturn(func: String => io.vertx.codegen.testmodel.TestEnum): String = {
    asJava.methodWithEnumReturn(asJavaFunction(func))
  }

  def methodWithListReturn(func: String => List[String]): String = {
    asJava.methodWithListReturn(asJavaFunction(func))
  }

  def methodWithSetReturn(func: String => Set[String]): String = {
    asJava.methodWithSetReturn(asJavaFunction(func))
  }

  def methodWithMapReturn(func: String => Map[String, String]): String = {
    asJava.methodWithMapReturn(asJavaFunction(func))
  }

  def methodWithGenericReturn[T](func: java.lang.Integer => T): String = {
    asJava.methodWithGenericReturn[T](asJavaFunction(func))
  }

  def methodWithGenericUserTypeReturn[T](func: JGenericRefedInterface[T] => JGenericRefedInterface[T]): String = {
    asJava.methodWithGenericUserTypeReturn[T](asJavaFunction(func))
  }

  def methodWithNullableListParam(func: scala.Option[List[String]] => String): String = {
    asJava.methodWithNullableListParam(asJavaFunction(func))
  }

  def methodWithNullableListReturn(func: String => scala.Option[List[String]]): String = {
    asJava.methodWithNullableListReturn(asJavaFunction(func))
  }

}

import io.vertx.codegen.testmodel.{GenericNullableRefedInterface => JGenericNullableRefedInterface}

/**
  */
implicit class GenericNullableRefedInterfaceScala[T](val asJava: JGenericNullableRefedInterface[T]) extends AnyVal {


  def getValue(): scala.Option[T] = {
    scala.Option(asJava.getValue())
  }

}

import io.vertx.codegen.testmodel.GenericRefedInterface
import io.vertx.codegen.testmodel.{GenericRefedInterface => JGenericRefedInterface}

/**
  */
implicit class GenericRefedInterfaceScala[T](val asJava: JGenericRefedInterface[T]) extends AnyVal {


  def setValue(value: T): JGenericRefedInterface[T] = {
    asJava.setValue(value)
  }

  def getValue(): T = {
    asJava.getValue()
  }

}

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.codegen.testmodel.{InterfaceWithStringArg => JInterfaceWithStringArg}
import io.vertx.codegen.testmodel.{RefedInterface1 => JRefedInterface1}
import io.vertx.codegen.testmodel.GenericRefedInterface
import io.vertx.codegen.testmodel.InterfaceWithApiArg
import io.vertx.codegen.testmodel.TestDataObject
import io.vertx.codegen.testmodel.InterfaceWithStringArg
import io.vertx.codegen.testmodel.RefedInterface1
import io.vertx.codegen.testmodel.GenericNullableRefedInterface
import io.vertx.codegen.testmodel.{GenericsTCK => JGenericsTCK}
import io.vertx.codegen.testmodel.{GenericNullableRefedInterface => JGenericNullableRefedInterface}
import io.vertx.core.json.JsonArray
import io.vertx.codegen.testmodel.TestEnum
import io.vertx.codegen.testmodel.{TestDataObject => JTestDataObject}
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.codegen.testmodel.InterfaceWithVariableArg
import io.vertx.codegen.testmodel.{InterfaceWithApiArg => JInterfaceWithApiArg}
import io.vertx.codegen.testmodel.{InterfaceWithVariableArg => JInterfaceWithVariableArg}
import io.vertx.core.Handler
import io.vertx.codegen.testmodel.{GenericRefedInterface => JGenericRefedInterface}
import io.vertx.codegen.testmodel.TestGenEnum

/**
  */
implicit class GenericsTCKScala(val asJava: JGenericsTCK) extends AnyVal {


  def methodWithByteParameterizedReturn(): JGenericRefedInterface[java.lang.Byte] = {
    asJava.methodWithByteParameterizedReturn()
  }

  def methodWithShortParameterizedReturn(): JGenericRefedInterface[java.lang.Short] = {
    asJava.methodWithShortParameterizedReturn()
  }

  def methodWithIntegerParameterizedReturn(): JGenericRefedInterface[java.lang.Integer] = {
    asJava.methodWithIntegerParameterizedReturn()
  }

  def methodWithLongParameterizedReturn(): JGenericRefedInterface[java.lang.Long] = {
    asJava.methodWithLongParameterizedReturn()
  }

  def methodWithFloatParameterizedReturn(): JGenericRefedInterface[java.lang.Float] = {
    asJava.methodWithFloatParameterizedReturn()
  }

  def methodWithDoubleParameterizedReturn(): JGenericRefedInterface[java.lang.Double] = {
    asJava.methodWithDoubleParameterizedReturn()
  }

  def methodWithBooleanParameterizedReturn(): JGenericRefedInterface[java.lang.Boolean] = {
    asJava.methodWithBooleanParameterizedReturn()
  }

  def methodWithCharacterParameterizedReturn(): JGenericRefedInterface[java.lang.Character] = {
    asJava.methodWithCharacterParameterizedReturn()
  }

  def methodWithStringParameterizedReturn(): JGenericRefedInterface[String] = {
    asJava.methodWithStringParameterizedReturn()
  }

  def methodWithJsonObjectParameterizedReturn(): JGenericRefedInterface[io.vertx.core.json.JsonObject] = {
    asJava.methodWithJsonObjectParameterizedReturn()
  }

  def methodWithJsonArrayParameterizedReturn(): JGenericRefedInterface[io.vertx.core.json.JsonArray] = {
    asJava.methodWithJsonArrayParameterizedReturn()
  }

  def methodWithDataObjectParameterizedReturn(): JGenericRefedInterface[JTestDataObject] = {
    asJava.methodWithDataObjectParameterizedReturn()
  }

  def methodWithEnumParameterizedReturn(): JGenericRefedInterface[io.vertx.codegen.testmodel.TestEnum] = {
    asJava.methodWithEnumParameterizedReturn()
  }

  def methodWithGenEnumParameterizedReturn(): JGenericRefedInterface[io.vertx.codegen.testmodel.TestGenEnum] = {
    asJava.methodWithGenEnumParameterizedReturn()
  }

  def methodWithUserTypeParameterizedReturn(): JGenericRefedInterface[JRefedInterface1] = {
    asJava.methodWithUserTypeParameterizedReturn()
  }

  def methodWithHandlerByteParameterized(handler: JGenericRefedInterface[java.lang.Byte] => Unit): Unit = {
    asJava.methodWithHandlerByteParameterized((p:JGenericRefedInterface[java.lang.Byte]) => handler(p))
  }

  def methodWithHandlerShortParameterized(handler: JGenericRefedInterface[java.lang.Short] => Unit): Unit = {
    asJava.methodWithHandlerShortParameterized((p:JGenericRefedInterface[java.lang.Short]) => handler(p))
  }

  def methodWithHandlerIntegerParameterized(handler: JGenericRefedInterface[java.lang.Integer] => Unit): Unit = {
    asJava.methodWithHandlerIntegerParameterized((p:JGenericRefedInterface[java.lang.Integer]) => handler(p))
  }

  def methodWithHandlerLongParameterized(handler: JGenericRefedInterface[java.lang.Long] => Unit): Unit = {
    asJava.methodWithHandlerLongParameterized((p:JGenericRefedInterface[java.lang.Long]) => handler(p))
  }

  def methodWithHandlerFloatParameterized(handler: JGenericRefedInterface[java.lang.Float] => Unit): Unit = {
    asJava.methodWithHandlerFloatParameterized((p:JGenericRefedInterface[java.lang.Float]) => handler(p))
  }

  def methodWithHandlerDoubleParameterized(handler: JGenericRefedInterface[java.lang.Double] => Unit): Unit = {
    asJava.methodWithHandlerDoubleParameterized((p:JGenericRefedInterface[java.lang.Double]) => handler(p))
  }

  def methodWithHandlerBooleanParameterized(handler: JGenericRefedInterface[java.lang.Boolean] => Unit): Unit = {
    asJava.methodWithHandlerBooleanParameterized((p:JGenericRefedInterface[java.lang.Boolean]) => handler(p))
  }

  def methodWithHandlerCharacterParameterized(handler: JGenericRefedInterface[java.lang.Character] => Unit): Unit = {
    asJava.methodWithHandlerCharacterParameterized((p:JGenericRefedInterface[java.lang.Character]) => handler(p))
  }

  def methodWithHandlerStringParameterized(handler: JGenericRefedInterface[String] => Unit): Unit = {
    asJava.methodWithHandlerStringParameterized((p:JGenericRefedInterface[String]) => handler(p))
  }

  def methodWithHandlerJsonObjectParameterized(handler: JGenericRefedInterface[io.vertx.core.json.JsonObject] => Unit): Unit = {
    asJava.methodWithHandlerJsonObjectParameterized((p:JGenericRefedInterface[io.vertx.core.json.JsonObject]) => handler(p))
  }

  def methodWithHandlerJsonArrayParameterized(handler: JGenericRefedInterface[io.vertx.core.json.JsonArray] => Unit): Unit = {
    asJava.methodWithHandlerJsonArrayParameterized((p:JGenericRefedInterface[io.vertx.core.json.JsonArray]) => handler(p))
  }

  def methodWithHandlerDataObjectParameterized(handler: JGenericRefedInterface[JTestDataObject] => Unit): Unit = {
    asJava.methodWithHandlerDataObjectParameterized((p:JGenericRefedInterface[JTestDataObject]) => handler(p))
  }

  def methodWithHandlerEnumParameterized(handler: JGenericRefedInterface[io.vertx.codegen.testmodel.TestEnum] => Unit): Unit = {
    asJava.methodWithHandlerEnumParameterized((p:JGenericRefedInterface[io.vertx.codegen.testmodel.TestEnum]) => handler(p))
  }

  def methodWithHandlerGenEnumParameterized(handler: JGenericRefedInterface[io.vertx.codegen.testmodel.TestGenEnum] => Unit): Unit = {
    asJava.methodWithHandlerGenEnumParameterized((p:JGenericRefedInterface[io.vertx.codegen.testmodel.TestGenEnum]) => handler(p))
  }

  def methodWithHandlerUserTypeParameterized(handler: JGenericRefedInterface[JRefedInterface1] => Unit): Unit = {
    asJava.methodWithHandlerUserTypeParameterized((p:JGenericRefedInterface[JRefedInterface1]) => handler(p))
  }

  def methodWithHandlerAsyncResultByteParameterized(handler: AsyncResult[JGenericRefedInterface[java.lang.Byte]] => Unit): Unit = {
    asJava.methodWithHandlerAsyncResultByteParameterized((p:AsyncResult[JGenericRefedInterface[java.lang.Byte]]) => handler(p))
  }

  def methodWithHandlerAsyncResultShortParameterized(handler: AsyncResult[JGenericRefedInterface[java.lang.Short]] => Unit): Unit = {
    asJava.methodWithHandlerAsyncResultShortParameterized((p:AsyncResult[JGenericRefedInterface[java.lang.Short]]) => handler(p))
  }

  def methodWithHandlerAsyncResultIntegerParameterized(handler: AsyncResult[JGenericRefedInterface[java.lang.Integer]] => Unit): Unit = {
    asJava.methodWithHandlerAsyncResultIntegerParameterized((p:AsyncResult[JGenericRefedInterface[java.lang.Integer]]) => handler(p))
  }

  def methodWithHandlerAsyncResultLongParameterized(handler: AsyncResult[JGenericRefedInterface[java.lang.Long]] => Unit): Unit = {
    asJava.methodWithHandlerAsyncResultLongParameterized((p:AsyncResult[JGenericRefedInterface[java.lang.Long]]) => handler(p))
  }

  def methodWithHandlerAsyncResultFloatParameterized(handler: AsyncResult[JGenericRefedInterface[java.lang.Float]] => Unit): Unit = {
    asJava.methodWithHandlerAsyncResultFloatParameterized((p:AsyncResult[JGenericRefedInterface[java.lang.Float]]) => handler(p))
  }

  def methodWithHandlerAsyncResultDoubleParameterized(handler: AsyncResult[JGenericRefedInterface[java.lang.Double]] => Unit): Unit = {
    asJava.methodWithHandlerAsyncResultDoubleParameterized((p:AsyncResult[JGenericRefedInterface[java.lang.Double]]) => handler(p))
  }

  def methodWithHandlerAsyncResultBooleanParameterized(handler: AsyncResult[JGenericRefedInterface[java.lang.Boolean]] => Unit): Unit = {
    asJava.methodWithHandlerAsyncResultBooleanParameterized((p:AsyncResult[JGenericRefedInterface[java.lang.Boolean]]) => handler(p))
  }

  def methodWithHandlerAsyncResultCharacterParameterized(handler: AsyncResult[JGenericRefedInterface[java.lang.Character]] => Unit): Unit = {
    asJava.methodWithHandlerAsyncResultCharacterParameterized((p:AsyncResult[JGenericRefedInterface[java.lang.Character]]) => handler(p))
  }

  def methodWithHandlerAsyncResultStringParameterized(handler: AsyncResult[JGenericRefedInterface[String]] => Unit): Unit = {
    asJava.methodWithHandlerAsyncResultStringParameterized((p:AsyncResult[JGenericRefedInterface[String]]) => handler(p))
  }

  def methodWithHandlerAsyncResultJsonObjectParameterized(handler: AsyncResult[JGenericRefedInterface[io.vertx.core.json.JsonObject]] => Unit): Unit = {
    asJava.methodWithHandlerAsyncResultJsonObjectParameterized((p:AsyncResult[JGenericRefedInterface[io.vertx.core.json.JsonObject]]) => handler(p))
  }

  def methodWithHandlerAsyncResultJsonArrayParameterized(handler: AsyncResult[JGenericRefedInterface[io.vertx.core.json.JsonArray]] => Unit): Unit = {
    asJava.methodWithHandlerAsyncResultJsonArrayParameterized((p:AsyncResult[JGenericRefedInterface[io.vertx.core.json.JsonArray]]) => handler(p))
  }

  def methodWithHandlerAsyncResultDataObjectParameterized(handler: AsyncResult[JGenericRefedInterface[JTestDataObject]] => Unit): Unit = {
    asJava.methodWithHandlerAsyncResultDataObjectParameterized((p:AsyncResult[JGenericRefedInterface[JTestDataObject]]) => handler(p))
  }

  def methodWithHandlerAsyncResultEnumParameterized(handler: AsyncResult[JGenericRefedInterface[io.vertx.codegen.testmodel.TestEnum]] => Unit): Unit = {
    asJava.methodWithHandlerAsyncResultEnumParameterized((p:AsyncResult[JGenericRefedInterface[io.vertx.codegen.testmodel.TestEnum]]) => handler(p))
  }

  def methodWithHandlerAsyncResultGenEnumParameterized(handler: AsyncResult[JGenericRefedInterface[io.vertx.codegen.testmodel.TestGenEnum]] => Unit): Unit = {
    asJava.methodWithHandlerAsyncResultGenEnumParameterized((p:AsyncResult[JGenericRefedInterface[io.vertx.codegen.testmodel.TestGenEnum]]) => handler(p))
  }

  def methodWithHandlerAsyncResultUserTypeParameterized(handler: AsyncResult[JGenericRefedInterface[JRefedInterface1]] => Unit): Unit = {
    asJava.methodWithHandlerAsyncResultUserTypeParameterized((p:AsyncResult[JGenericRefedInterface[JRefedInterface1]]) => handler(p))
  }

  def methodWithFunctionParamByteParameterized(handler: JGenericRefedInterface[java.lang.Byte] => String): Unit = {
    asJava.methodWithFunctionParamByteParameterized(asJavaFunction(handler))
  }

  def methodWithFunctionParamShortParameterized(handler: JGenericRefedInterface[java.lang.Short] => String): Unit = {
    asJava.methodWithFunctionParamShortParameterized(asJavaFunction(handler))
  }

  def methodWithFunctionParamIntegerParameterized(handler: JGenericRefedInterface[java.lang.Integer] => String): Unit = {
    asJava.methodWithFunctionParamIntegerParameterized(asJavaFunction(handler))
  }

  def methodWithFunctionParamLongParameterized(handler: JGenericRefedInterface[java.lang.Long] => String): Unit = {
    asJava.methodWithFunctionParamLongParameterized(asJavaFunction(handler))
  }

  def methodWithFunctionParamFloatParameterized(handler: JGenericRefedInterface[java.lang.Float] => String): Unit = {
    asJava.methodWithFunctionParamFloatParameterized(asJavaFunction(handler))
  }

  def methodWithFunctionParamDoubleParameterized(handler: JGenericRefedInterface[java.lang.Double] => String): Unit = {
    asJava.methodWithFunctionParamDoubleParameterized(asJavaFunction(handler))
  }

  def methodWithFunctionParamBooleanParameterized(handler: JGenericRefedInterface[java.lang.Boolean] => String): Unit = {
    asJava.methodWithFunctionParamBooleanParameterized(asJavaFunction(handler))
  }

  def methodWithFunctionParamCharacterParameterized(handler: JGenericRefedInterface[java.lang.Character] => String): Unit = {
    asJava.methodWithFunctionParamCharacterParameterized(asJavaFunction(handler))
  }

  def methodWithFunctionParamStringParameterized(handler: JGenericRefedInterface[String] => String): Unit = {
    asJava.methodWithFunctionParamStringParameterized(asJavaFunction(handler))
  }

  def methodWithFunctionParamJsonObjectParameterized(handler: JGenericRefedInterface[io.vertx.core.json.JsonObject] => String): Unit = {
    asJava.methodWithFunctionParamJsonObjectParameterized(asJavaFunction(handler))
  }

  def methodWithFunctionParamJsonArrayParameterized(handler: JGenericRefedInterface[io.vertx.core.json.JsonArray] => String): Unit = {
    asJava.methodWithFunctionParamJsonArrayParameterized(asJavaFunction(handler))
  }

  def methodWithFunctionParamDataObjectParameterized(handler: JGenericRefedInterface[JTestDataObject] => String): Unit = {
    asJava.methodWithFunctionParamDataObjectParameterized(asJavaFunction(handler))
  }

  def methodWithFunctionParamEnumParameterized(handler: JGenericRefedInterface[io.vertx.codegen.testmodel.TestEnum] => String): Unit = {
    asJava.methodWithFunctionParamEnumParameterized(asJavaFunction(handler))
  }

  def methodWithFunctionParamGenEnumParameterized(handler: JGenericRefedInterface[io.vertx.codegen.testmodel.TestGenEnum] => String): Unit = {
    asJava.methodWithFunctionParamGenEnumParameterized(asJavaFunction(handler))
  }

  def methodWithFunctionParamUserTypeParameterized(handler: JGenericRefedInterface[JRefedInterface1] => String): Unit = {
    asJava.methodWithFunctionParamUserTypeParameterized(asJavaFunction(handler))
  }

  def methodWithClassTypeParameterizedReturn[U](`type`: Class[U]): JGenericRefedInterface[U] = {
    asJava.methodWithClassTypeParameterizedReturn[U](`type`)
  }

  def methodWithHandlerClassTypeParameterized[U](`type`: Class[U], handler: JGenericRefedInterface[U] => Unit): Unit = {
    asJava.methodWithHandlerClassTypeParameterized[U](`type`, (p:JGenericRefedInterface[U]) => handler(p))
  }

  def methodWithHandlerAsyncResultClassTypeParameterized[U](`type`: Class[U], handler: AsyncResult[JGenericRefedInterface[U]] => Unit): Unit = {
    asJava.methodWithHandlerAsyncResultClassTypeParameterized[U](`type`, (p:AsyncResult[JGenericRefedInterface[U]]) => handler(p))
  }

  def methodWithFunctionParamClassTypeParameterized[U](`type`: Class[U], handler: JGenericRefedInterface[U] => String): Unit = {
    asJava.methodWithFunctionParamClassTypeParameterized[U](`type`, asJavaFunction(handler))
  }

  def methodWithClassTypeParam[U](`type`: Class[U], u: U): Unit = {
    asJava.methodWithClassTypeParam[U](`type`, u)
  }

  def methodWithClassTypeReturn[U](`type`: Class[U]): U = {
    asJava.methodWithClassTypeReturn[U](`type`)
  }

  def methodWithClassTypeHandler[U](`type`: Class[U], f: U => Unit): Unit = {
    asJava.methodWithClassTypeHandler[U](`type`, (p:U) => f(p))
  }

  def methodWithClassTypeHandlerAsyncResult[U](`type`: Class[U], f: AsyncResult[U] => Unit): Unit = {
    asJava.methodWithClassTypeHandlerAsyncResult[U](`type`, (p:AsyncResult[U]) => f(p))
  }

  def methodWithClassTypeFunctionParam[U](`type`: Class[U], f: U => String): Unit = {
    asJava.methodWithClassTypeFunctionParam[U](`type`, asJavaFunction(f))
  }

  def methodWithClassTypeFunctionReturn[U](`type`: Class[U], f: String => U): Unit = {
    asJava.methodWithClassTypeFunctionReturn[U](`type`, asJavaFunction(f))
  }

  def interfaceWithApiArg(value: JRefedInterface1): JInterfaceWithApiArg = {
    asJava.interfaceWithApiArg(value.asJava)
  }

  def interfaceWithStringArg(value: String): JInterfaceWithStringArg = {
    asJava.interfaceWithStringArg(value)
  }

  def interfaceWithVariableArg[T, U](value1: T, `type`: Class[U], value2: U): JInterfaceWithVariableArg[T, U] = {
    asJava.interfaceWithVariableArg[T, U](value1, `type`, value2)
  }

  def methodWithHandlerGenericNullableApi(notNull: java.lang.Boolean, handler: JGenericNullableRefedInterface[JRefedInterface1] => Unit): Unit = {
    asJava.methodWithHandlerGenericNullableApi(notNull, (p:JGenericNullableRefedInterface[JRefedInterface1]) => handler(p))
  }

  def methodWithHandlerAsyncResultGenericNullableApi(notNull: java.lang.Boolean, handler: AsyncResult[JGenericNullableRefedInterface[JRefedInterface1]] => Unit): Unit = {
    asJava.methodWithHandlerAsyncResultGenericNullableApi(notNull, (p:AsyncResult[JGenericNullableRefedInterface[JRefedInterface1]]) => handler(p))
  }

  def methodWithGenericNullableApiReturn(notNull: java.lang.Boolean): JGenericNullableRefedInterface[JRefedInterface1] = {
    asJava.methodWithGenericNullableApiReturn(notNull)
  }

  def methodWithParamInferedReturn[T](param: JGenericRefedInterface[T]): JGenericRefedInterface[T] = {
    asJava.methodWithParamInferedReturn[T](param.asJava)
  }

  def methodWithHandlerParamInfered[T](param: JGenericRefedInterface[T], handler: JGenericRefedInterface[T] => Unit): Unit = {
    asJava.methodWithHandlerParamInfered[T](param.asJava, (p:JGenericRefedInterface[T]) => handler(p))
  }

  def methodWithHandlerAsyncResultParamInfered[T](param: JGenericRefedInterface[T], handler: AsyncResult[JGenericRefedInterface[T]] => Unit): Unit = {
    asJava.methodWithHandlerAsyncResultParamInfered[T](param.asJava, (p:AsyncResult[JGenericRefedInterface[T]]) => handler(p))
  }

  def methodWithHandlerAsyncResultByteParameterizedFuture(): scala.concurrent.Future[JGenericRefedInterface[java.lang.Byte]] = {
    val promise = Promise[JGenericRefedInterface[java.lang.Byte]]()
    asJava.methodWithHandlerAsyncResultByteParameterized({a:AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Byte]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

  def methodWithHandlerAsyncResultShortParameterizedFuture(): scala.concurrent.Future[JGenericRefedInterface[java.lang.Short]] = {
    val promise = Promise[JGenericRefedInterface[java.lang.Short]]()
    asJava.methodWithHandlerAsyncResultShortParameterized({a:AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Short]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

  def methodWithHandlerAsyncResultIntegerParameterizedFuture(): scala.concurrent.Future[JGenericRefedInterface[java.lang.Integer]] = {
    val promise = Promise[JGenericRefedInterface[java.lang.Integer]]()
    asJava.methodWithHandlerAsyncResultIntegerParameterized({a:AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Integer]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

  def methodWithHandlerAsyncResultLongParameterizedFuture(): scala.concurrent.Future[JGenericRefedInterface[java.lang.Long]] = {
    val promise = Promise[JGenericRefedInterface[java.lang.Long]]()
    asJava.methodWithHandlerAsyncResultLongParameterized({a:AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Long]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

  def methodWithHandlerAsyncResultFloatParameterizedFuture(): scala.concurrent.Future[JGenericRefedInterface[java.lang.Float]] = {
    val promise = Promise[JGenericRefedInterface[java.lang.Float]]()
    asJava.methodWithHandlerAsyncResultFloatParameterized({a:AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Float]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

  def methodWithHandlerAsyncResultDoubleParameterizedFuture(): scala.concurrent.Future[JGenericRefedInterface[java.lang.Double]] = {
    val promise = Promise[JGenericRefedInterface[java.lang.Double]]()
    asJava.methodWithHandlerAsyncResultDoubleParameterized({a:AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Double]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

  def methodWithHandlerAsyncResultBooleanParameterizedFuture(): scala.concurrent.Future[JGenericRefedInterface[java.lang.Boolean]] = {
    val promise = Promise[JGenericRefedInterface[java.lang.Boolean]]()
    asJava.methodWithHandlerAsyncResultBooleanParameterized({a:AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Boolean]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

  def methodWithHandlerAsyncResultCharacterParameterizedFuture(): scala.concurrent.Future[JGenericRefedInterface[java.lang.Character]] = {
    val promise = Promise[JGenericRefedInterface[java.lang.Character]]()
    asJava.methodWithHandlerAsyncResultCharacterParameterized({a:AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Character]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

  def methodWithHandlerAsyncResultStringParameterizedFuture(): scala.concurrent.Future[JGenericRefedInterface[String]] = {
    val promise = Promise[JGenericRefedInterface[String]]()
    asJava.methodWithHandlerAsyncResultStringParameterized({a:AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.String]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

  def methodWithHandlerAsyncResultJsonObjectParameterizedFuture(): scala.concurrent.Future[JGenericRefedInterface[io.vertx.core.json.JsonObject]] = {
    val promise = Promise[JGenericRefedInterface[io.vertx.core.json.JsonObject]]()
    asJava.methodWithHandlerAsyncResultJsonObjectParameterized({a:AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.core.json.JsonObject]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

  def methodWithHandlerAsyncResultJsonArrayParameterizedFuture(): scala.concurrent.Future[JGenericRefedInterface[io.vertx.core.json.JsonArray]] = {
    val promise = Promise[JGenericRefedInterface[io.vertx.core.json.JsonArray]]()
    asJava.methodWithHandlerAsyncResultJsonArrayParameterized({a:AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.core.json.JsonArray]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

  def methodWithHandlerAsyncResultDataObjectParameterizedFuture(): scala.concurrent.Future[JGenericRefedInterface[JTestDataObject]] = {
    val promise = Promise[JGenericRefedInterface[JTestDataObject]]()
    asJava.methodWithHandlerAsyncResultDataObjectParameterized({a:AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.codegen.testmodel.TestDataObject]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

  def methodWithHandlerAsyncResultEnumParameterizedFuture(): scala.concurrent.Future[JGenericRefedInterface[io.vertx.codegen.testmodel.TestEnum]] = {
    val promise = Promise[JGenericRefedInterface[io.vertx.codegen.testmodel.TestEnum]]()
    asJava.methodWithHandlerAsyncResultEnumParameterized({a:AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.codegen.testmodel.TestEnum]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

  def methodWithHandlerAsyncResultGenEnumParameterizedFuture(): scala.concurrent.Future[JGenericRefedInterface[io.vertx.codegen.testmodel.TestGenEnum]] = {
    val promise = Promise[JGenericRefedInterface[io.vertx.codegen.testmodel.TestGenEnum]]()
    asJava.methodWithHandlerAsyncResultGenEnumParameterized({a:AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.codegen.testmodel.TestGenEnum]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

  def methodWithHandlerAsyncResultUserTypeParameterizedFuture(): scala.concurrent.Future[JGenericRefedInterface[JRefedInterface1]] = {
    val promise = Promise[JGenericRefedInterface[JRefedInterface1]]()
    asJava.methodWithHandlerAsyncResultUserTypeParameterized({a:AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.codegen.testmodel.RefedInterface1]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

  def methodWithHandlerAsyncResultClassTypeParameterizedFuture[U](`type`: Class[U]): scala.concurrent.Future[JGenericRefedInterface[U]] = {
    val promise = Promise[JGenericRefedInterface[U]]()
    asJava.methodWithHandlerAsyncResultClassTypeParameterized[U](`type`, {a:AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[U]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

  def methodWithClassTypeHandlerAsyncResultFuture[U](`type`: Class[U]): scala.concurrent.Future[U] = {
    val promise = Promise[U]()
    asJava.methodWithClassTypeHandlerAsyncResult[U](`type`, {a:AsyncResult[U] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

  def methodWithHandlerAsyncResultGenericNullableApiFuture(notNull: java.lang.Boolean): scala.concurrent.Future[JGenericNullableRefedInterface[JRefedInterface1]] = {
    val promise = Promise[JGenericNullableRefedInterface[JRefedInterface1]]()
    asJava.methodWithHandlerAsyncResultGenericNullableApi(notNull, {a:AsyncResult[io.vertx.codegen.testmodel.GenericNullableRefedInterface[io.vertx.codegen.testmodel.RefedInterface1]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

  def methodWithHandlerAsyncResultParamInferedFuture[T](param: JGenericRefedInterface[T]): scala.concurrent.Future[JGenericRefedInterface[T]] = {
    val promise = Promise[JGenericRefedInterface[T]]()
    asJava.methodWithHandlerAsyncResultParamInfered[T](param, {a:AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[T]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

}

import io.vertx.codegen.testmodel.{RefedInterface1 => JRefedInterface1}
import io.vertx.codegen.testmodel.GenericRefedInterface
import io.vertx.codegen.testmodel.{InterfaceWithApiArg => JInterfaceWithApiArg}
import io.vertx.codegen.testmodel.{GenericRefedInterface => JGenericRefedInterface}
import io.vertx.codegen.testmodel.RefedInterface1

/**
  */
implicit class InterfaceWithApiArgScala(val asJava: JInterfaceWithApiArg) extends AnyVal {


  def setValue(value: JRefedInterface1): JGenericRefedInterface[JRefedInterface1] = {
    asJava.setValue(value.asJava)
  }

  def getValue(): JRefedInterface1 = {
    asJava.getValue()
  }

  def meth(): Unit = {
    asJava.meth()
  }

}

import io.vertx.codegen.testmodel.{InterfaceWithStringArg => JInterfaceWithStringArg}
import io.vertx.codegen.testmodel.GenericRefedInterface
import io.vertx.codegen.testmodel.{GenericRefedInterface => JGenericRefedInterface}

/**
  */
implicit class InterfaceWithStringArgScala(val asJava: JInterfaceWithStringArg) extends AnyVal {


  def setValue(value: String): JGenericRefedInterface[String] = {
    asJava.setValue(value)
  }

  def getValue(): String = {
    asJava.getValue()
  }

  def meth(): Unit = {
    asJava.meth()
  }

}

import io.vertx.codegen.testmodel.GenericRefedInterface
import io.vertx.codegen.testmodel.{InterfaceWithVariableArg => JInterfaceWithVariableArg}
import io.vertx.codegen.testmodel.{GenericRefedInterface => JGenericRefedInterface}

/**
  */
implicit class InterfaceWithVariableArgScala[T, U](val asJava: JInterfaceWithVariableArg[T, U]) extends AnyVal {


  def setValue(value: U): JGenericRefedInterface[U] = {
    asJava.setValue(value)
  }

  def getValue(): U = {
    asJava.getValue()
  }

  def setOtherValue(value: T): Unit = {
    asJava.setOtherValue(value)
  }

  def getOtherValue(): T = {
    asJava.getOtherValue()
  }

}

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.codegen.testmodel.{RefedInterface1 => JRefedInterface1}
import io.vertx.codegen.testmodel.{NullableTCK => JNullableTCK}
import io.vertx.codegen.testmodel.TestDataObject
import scala.collection.JavaConverters._
import io.vertx.codegen.testmodel.RefedInterface1
import io.vertx.core.json.JsonArray
import io.vertx.codegen.testmodel.TestEnum
import io.vertx.codegen.testmodel.{TestDataObject => JTestDataObject}
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.codegen.testmodel.TestGenEnum

/**
  * The TCK for @Nullable.
  */
implicit class NullableTCKScala(val asJava: JNullableTCK) extends AnyVal {


  def methodWithNonNullableByteParam(param: java.lang.Byte): java.lang.Boolean = {
    asJava.methodWithNonNullableByteParam(param)
  }

  def methodWithNullableByteParam(expectNull: java.lang.Boolean, param: scala.Option[java.lang.Byte]): Unit = {
    asJava.methodWithNullableByteParam(expectNull, param.orNull)
  }

  def methodWithNullableByteHandler(notNull: java.lang.Boolean, handler: scala.Option[java.lang.Byte] => Unit): Unit = {
    asJava.methodWithNullableByteHandler(notNull, (p:scala.Option[java.lang.Byte]) => handler(p))
  }

  def methodWithNullableByteHandlerAsyncResult(notNull: java.lang.Boolean, handler: AsyncResult[scala.Option[java.lang.Byte]] => Unit): Unit = {
    asJava.methodWithNullableByteHandlerAsyncResult(notNull, (p:AsyncResult[scala.Option[java.lang.Byte]]) => handler(p))
  }

  def methodWithNullableByteReturn(notNull: java.lang.Boolean): scala.Option[java.lang.Byte] = {
    scala.Option(asJava.methodWithNullableByteReturn(notNull))
  }

  def methodWithNonNullableShortParam(param: java.lang.Short): java.lang.Boolean = {
    asJava.methodWithNonNullableShortParam(param)
  }

  def methodWithNullableShortParam(expectNull: java.lang.Boolean, param: scala.Option[java.lang.Short]): Unit = {
    asJava.methodWithNullableShortParam(expectNull, param.orNull)
  }

  def methodWithNullableShortHandler(notNull: java.lang.Boolean, handler: scala.Option[java.lang.Short] => Unit): Unit = {
    asJava.methodWithNullableShortHandler(notNull, (p:scala.Option[java.lang.Short]) => handler(p))
  }

  def methodWithNullableShortHandlerAsyncResult(notNull: java.lang.Boolean, handler: AsyncResult[scala.Option[java.lang.Short]] => Unit): Unit = {
    asJava.methodWithNullableShortHandlerAsyncResult(notNull, (p:AsyncResult[scala.Option[java.lang.Short]]) => handler(p))
  }

  def methodWithNullableShortReturn(notNull: java.lang.Boolean): scala.Option[java.lang.Short] = {
    scala.Option(asJava.methodWithNullableShortReturn(notNull))
  }

  def methodWithNonNullableIntegerParam(param: java.lang.Integer): java.lang.Boolean = {
    asJava.methodWithNonNullableIntegerParam(param)
  }

  def methodWithNullableIntegerParam(expectNull: java.lang.Boolean, param: scala.Option[java.lang.Integer]): Unit = {
    asJava.methodWithNullableIntegerParam(expectNull, param.orNull)
  }

  def methodWithNullableIntegerHandler(notNull: java.lang.Boolean, handler: scala.Option[java.lang.Integer] => Unit): Unit = {
    asJava.methodWithNullableIntegerHandler(notNull, (p:scala.Option[java.lang.Integer]) => handler(p))
  }

  def methodWithNullableIntegerHandlerAsyncResult(notNull: java.lang.Boolean, handler: AsyncResult[scala.Option[java.lang.Integer]] => Unit): Unit = {
    asJava.methodWithNullableIntegerHandlerAsyncResult(notNull, (p:AsyncResult[scala.Option[java.lang.Integer]]) => handler(p))
  }

  def methodWithNullableIntegerReturn(notNull: java.lang.Boolean): scala.Option[java.lang.Integer] = {
    scala.Option(asJava.methodWithNullableIntegerReturn(notNull))
  }

  def methodWithNonNullableLongParam(param: java.lang.Long): java.lang.Boolean = {
    asJava.methodWithNonNullableLongParam(param)
  }

  def methodWithNullableLongParam(expectNull: java.lang.Boolean, param: scala.Option[java.lang.Long]): Unit = {
    asJava.methodWithNullableLongParam(expectNull, param.orNull)
  }

  def methodWithNullableLongHandler(notNull: java.lang.Boolean, handler: scala.Option[java.lang.Long] => Unit): Unit = {
    asJava.methodWithNullableLongHandler(notNull, (p:scala.Option[java.lang.Long]) => handler(p))
  }

  def methodWithNullableLongHandlerAsyncResult(notNull: java.lang.Boolean, handler: AsyncResult[scala.Option[java.lang.Long]] => Unit): Unit = {
    asJava.methodWithNullableLongHandlerAsyncResult(notNull, (p:AsyncResult[scala.Option[java.lang.Long]]) => handler(p))
  }

  def methodWithNullableLongReturn(notNull: java.lang.Boolean): scala.Option[java.lang.Long] = {
    scala.Option(asJava.methodWithNullableLongReturn(notNull))
  }

  def methodWithNonNullableFloatParam(param: java.lang.Float): java.lang.Boolean = {
    asJava.methodWithNonNullableFloatParam(param)
  }

  def methodWithNullableFloatParam(expectNull: java.lang.Boolean, param: scala.Option[java.lang.Float]): Unit = {
    asJava.methodWithNullableFloatParam(expectNull, param.orNull)
  }

  def methodWithNullableFloatHandler(notNull: java.lang.Boolean, handler: scala.Option[java.lang.Float] => Unit): Unit = {
    asJava.methodWithNullableFloatHandler(notNull, (p:scala.Option[java.lang.Float]) => handler(p))
  }

  def methodWithNullableFloatHandlerAsyncResult(notNull: java.lang.Boolean, handler: AsyncResult[scala.Option[java.lang.Float]] => Unit): Unit = {
    asJava.methodWithNullableFloatHandlerAsyncResult(notNull, (p:AsyncResult[scala.Option[java.lang.Float]]) => handler(p))
  }

  def methodWithNullableFloatReturn(notNull: java.lang.Boolean): scala.Option[java.lang.Float] = {
    scala.Option(asJava.methodWithNullableFloatReturn(notNull))
  }

  def methodWithNonNullableDoubleParam(param: java.lang.Double): java.lang.Boolean = {
    asJava.methodWithNonNullableDoubleParam(param)
  }

  def methodWithNullableDoubleParam(expectNull: java.lang.Boolean, param: scala.Option[java.lang.Double]): Unit = {
    asJava.methodWithNullableDoubleParam(expectNull, param.orNull)
  }

  def methodWithNullableDoubleHandler(notNull: java.lang.Boolean, handler: scala.Option[java.lang.Double] => Unit): Unit = {
    asJava.methodWithNullableDoubleHandler(notNull, (p:scala.Option[java.lang.Double]) => handler(p))
  }

  def methodWithNullableDoubleHandlerAsyncResult(notNull: java.lang.Boolean, handler: AsyncResult[scala.Option[java.lang.Double]] => Unit): Unit = {
    asJava.methodWithNullableDoubleHandlerAsyncResult(notNull, (p:AsyncResult[scala.Option[java.lang.Double]]) => handler(p))
  }

  def methodWithNullableDoubleReturn(notNull: java.lang.Boolean): scala.Option[java.lang.Double] = {
    scala.Option(asJava.methodWithNullableDoubleReturn(notNull))
  }

  def methodWithNonNullableBooleanParam(param: java.lang.Boolean): java.lang.Boolean = {
    asJava.methodWithNonNullableBooleanParam(param)
  }

  def methodWithNullableBooleanParam(expectNull: java.lang.Boolean, param: scala.Option[java.lang.Boolean]): Unit = {
    asJava.methodWithNullableBooleanParam(expectNull, param.orNull)
  }

  def methodWithNullableBooleanHandler(notNull: java.lang.Boolean, handler: scala.Option[java.lang.Boolean] => Unit): Unit = {
    asJava.methodWithNullableBooleanHandler(notNull, (p:scala.Option[java.lang.Boolean]) => handler(p))
  }

  def methodWithNullableBooleanHandlerAsyncResult(notNull: java.lang.Boolean, handler: AsyncResult[scala.Option[java.lang.Boolean]] => Unit): Unit = {
    asJava.methodWithNullableBooleanHandlerAsyncResult(notNull, (p:AsyncResult[scala.Option[java.lang.Boolean]]) => handler(p))
  }

  def methodWithNullableBooleanReturn(notNull: java.lang.Boolean): scala.Option[java.lang.Boolean] = {
    scala.Option(asJava.methodWithNullableBooleanReturn(notNull))
  }

  def methodWithNonNullableStringParam(param: String): java.lang.Boolean = {
    asJava.methodWithNonNullableStringParam(param)
  }

  def methodWithNullableStringParam(expectNull: java.lang.Boolean, param: scala.Option[String]): Unit = {
    asJava.methodWithNullableStringParam(expectNull, param.orNull)
  }

  def methodWithNullableStringHandler(notNull: java.lang.Boolean, handler: scala.Option[String] => Unit): Unit = {
    asJava.methodWithNullableStringHandler(notNull, (p:scala.Option[String]) => handler(p))
  }

  def methodWithNullableStringHandlerAsyncResult(notNull: java.lang.Boolean, handler: AsyncResult[scala.Option[String]] => Unit): Unit = {
    asJava.methodWithNullableStringHandlerAsyncResult(notNull, (p:AsyncResult[scala.Option[String]]) => handler(p))
  }

  def methodWithNullableStringReturn(notNull: java.lang.Boolean): scala.Option[String] = {
    scala.Option(asJava.methodWithNullableStringReturn(notNull))
  }

  def methodWithNonNullableCharParam(param: java.lang.Character): java.lang.Boolean = {
    asJava.methodWithNonNullableCharParam(param)
  }

  def methodWithNullableCharParam(expectNull: java.lang.Boolean, param: scala.Option[java.lang.Character]): Unit = {
    asJava.methodWithNullableCharParam(expectNull, param.orNull)
  }

  def methodWithNullableCharHandler(notNull: java.lang.Boolean, handler: scala.Option[java.lang.Character] => Unit): Unit = {
    asJava.methodWithNullableCharHandler(notNull, (p:scala.Option[java.lang.Character]) => handler(p))
  }

  def methodWithNullableCharHandlerAsyncResult(notNull: java.lang.Boolean, handler: AsyncResult[scala.Option[java.lang.Character]] => Unit): Unit = {
    asJava.methodWithNullableCharHandlerAsyncResult(notNull, (p:AsyncResult[scala.Option[java.lang.Character]]) => handler(p))
  }

  def methodWithNullableCharReturn(notNull: java.lang.Boolean): scala.Option[java.lang.Character] = {
    scala.Option(asJava.methodWithNullableCharReturn(notNull))
  }

  def methodWithNonNullableJsonObjectParam(param: io.vertx.core.json.JsonObject): java.lang.Boolean = {
    asJava.methodWithNonNullableJsonObjectParam(param)
  }

  def methodWithNullableJsonObjectParam(expectNull: java.lang.Boolean, param: scala.Option[io.vertx.core.json.JsonObject]): Unit = {
    asJava.methodWithNullableJsonObjectParam(expectNull, param.orNull)
  }

  def methodWithNullableJsonObjectHandler(notNull: java.lang.Boolean, handler: scala.Option[io.vertx.core.json.JsonObject] => Unit): Unit = {
    asJava.methodWithNullableJsonObjectHandler(notNull, (p:scala.Option[io.vertx.core.json.JsonObject]) => handler(p))
  }

  def methodWithNullableJsonObjectHandlerAsyncResult(notNull: java.lang.Boolean, handler: AsyncResult[scala.Option[io.vertx.core.json.JsonObject]] => Unit): Unit = {
    asJava.methodWithNullableJsonObjectHandlerAsyncResult(notNull, (p:AsyncResult[scala.Option[io.vertx.core.json.JsonObject]]) => handler(p))
  }

  def methodWithNullableJsonObjectReturn(notNull: java.lang.Boolean): scala.Option[io.vertx.core.json.JsonObject] = {
    scala.Option(asJava.methodWithNullableJsonObjectReturn(notNull))
  }

  def methodWithNonNullableJsonArrayParam(param: io.vertx.core.json.JsonArray): java.lang.Boolean = {
    asJava.methodWithNonNullableJsonArrayParam(param)
  }

  def methodWithNullableJsonArrayParam(expectNull: java.lang.Boolean, param: scala.Option[io.vertx.core.json.JsonArray]): Unit = {
    asJava.methodWithNullableJsonArrayParam(expectNull, param.orNull)
  }

  def methodWithNullableJsonArrayHandler(notNull: java.lang.Boolean, handler: scala.Option[io.vertx.core.json.JsonArray] => Unit): Unit = {
    asJava.methodWithNullableJsonArrayHandler(notNull, (p:scala.Option[io.vertx.core.json.JsonArray]) => handler(p))
  }

  def methodWithNullableJsonArrayHandlerAsyncResult(notNull: java.lang.Boolean, handler: AsyncResult[scala.Option[io.vertx.core.json.JsonArray]] => Unit): Unit = {
    asJava.methodWithNullableJsonArrayHandlerAsyncResult(notNull, (p:AsyncResult[scala.Option[io.vertx.core.json.JsonArray]]) => handler(p))
  }

  def methodWithNullableJsonArrayReturn(notNull: java.lang.Boolean): scala.Option[io.vertx.core.json.JsonArray] = {
    scala.Option(asJava.methodWithNullableJsonArrayReturn(notNull))
  }

  def methodWithNonNullableApiParam(param: JRefedInterface1): java.lang.Boolean = {
    asJava.methodWithNonNullableApiParam(param.asJava)
  }

  def methodWithNullableApiParam(expectNull: java.lang.Boolean, param: scala.Option[JRefedInterface1]): Unit = {
    asJava.methodWithNullableApiParam(expectNull, param.map(x => x.asJava).orNull)
  }

  def methodWithNullableApiHandler(notNull: java.lang.Boolean, handler: scala.Option[JRefedInterface1] => Unit): Unit = {
    asJava.methodWithNullableApiHandler(notNull, (p:scala.Option[JRefedInterface1]) => handler(p))
  }

  def methodWithNullableApiHandlerAsyncResult(notNull: java.lang.Boolean, handler: AsyncResult[scala.Option[JRefedInterface1]] => Unit): Unit = {
    asJava.methodWithNullableApiHandlerAsyncResult(notNull, (p:AsyncResult[scala.Option[JRefedInterface1]]) => handler(p))
  }

  def methodWithNullableApiReturn(notNull: java.lang.Boolean): scala.Option[JRefedInterface1] = {
    scala.Option(asJava.methodWithNullableApiReturn(notNull))
  }

  def methodWithNonNullableDataObjectParam(param: JTestDataObject): java.lang.Boolean = {
    asJava.methodWithNonNullableDataObjectParam(param.asJava)
  }

  def methodWithNullableDataObjectParam(expectNull: java.lang.Boolean, param: scala.Option[JTestDataObject]): Unit = {
    asJava.methodWithNullableDataObjectParam(expectNull, param.map(x => x.asJava).orNull)
  }

  def methodWithNullableDataObjectHandler(notNull: java.lang.Boolean, handler: scala.Option[JTestDataObject] => Unit): Unit = {
    asJava.methodWithNullableDataObjectHandler(notNull, (p:scala.Option[JTestDataObject]) => handler(p))
  }

  def methodWithNullableDataObjectHandlerAsyncResult(notNull: java.lang.Boolean, handler: AsyncResult[scala.Option[JTestDataObject]] => Unit): Unit = {
    asJava.methodWithNullableDataObjectHandlerAsyncResult(notNull, (p:AsyncResult[scala.Option[JTestDataObject]]) => handler(p))
  }

  def methodWithNullableDataObjectReturn(notNull: java.lang.Boolean): scala.Option[JTestDataObject] = {
    scala.Option(asJava.methodWithNullableDataObjectReturn(notNull))
  }

  def methodWithNonNullableEnumParam(param: io.vertx.codegen.testmodel.TestEnum): java.lang.Boolean = {
    asJava.methodWithNonNullableEnumParam(param)
  }

  def methodWithNullableEnumParam(expectNull: java.lang.Boolean, param: scala.Option[io.vertx.codegen.testmodel.TestEnum]): Unit = {
    asJava.methodWithNullableEnumParam(expectNull, param.orNull)
  }

  def methodWithNullableEnumHandler(notNull: java.lang.Boolean, handler: scala.Option[io.vertx.codegen.testmodel.TestEnum] => Unit): Unit = {
    asJava.methodWithNullableEnumHandler(notNull, (p:scala.Option[io.vertx.codegen.testmodel.TestEnum]) => handler(p))
  }

  def methodWithNullableEnumHandlerAsyncResult(notNull: java.lang.Boolean, handler: AsyncResult[scala.Option[io.vertx.codegen.testmodel.TestEnum]] => Unit): Unit = {
    asJava.methodWithNullableEnumHandlerAsyncResult(notNull, (p:AsyncResult[scala.Option[io.vertx.codegen.testmodel.TestEnum]]) => handler(p))
  }

  def methodWithNullableEnumReturn(notNull: java.lang.Boolean): scala.Option[io.vertx.codegen.testmodel.TestEnum] = {
    scala.Option(asJava.methodWithNullableEnumReturn(notNull))
  }

  def methodWithNonNullableGenEnumParam(param: io.vertx.codegen.testmodel.TestGenEnum): java.lang.Boolean = {
    asJava.methodWithNonNullableGenEnumParam(param)
  }

  def methodWithNullableGenEnumParam(expectNull: java.lang.Boolean, param: scala.Option[io.vertx.codegen.testmodel.TestGenEnum]): Unit = {
    asJava.methodWithNullableGenEnumParam(expectNull, param.orNull)
  }

  def methodWithNullableGenEnumHandler(notNull: java.lang.Boolean, handler: scala.Option[io.vertx.codegen.testmodel.TestGenEnum] => Unit): Unit = {
    asJava.methodWithNullableGenEnumHandler(notNull, (p:scala.Option[io.vertx.codegen.testmodel.TestGenEnum]) => handler(p))
  }

  def methodWithNullableGenEnumHandlerAsyncResult(notNull: java.lang.Boolean, handler: AsyncResult[scala.Option[io.vertx.codegen.testmodel.TestGenEnum]] => Unit): Unit = {
    asJava.methodWithNullableGenEnumHandlerAsyncResult(notNull, (p:AsyncResult[scala.Option[io.vertx.codegen.testmodel.TestGenEnum]]) => handler(p))
  }

  def methodWithNullableGenEnumReturn(notNull: java.lang.Boolean): scala.Option[io.vertx.codegen.testmodel.TestGenEnum] = {
    scala.Option(asJava.methodWithNullableGenEnumReturn(notNull))
  }

  def methodWithNullableTypeVariableParam[T](expectNull: java.lang.Boolean, param: T): Unit = {
    asJava.methodWithNullableTypeVariableParam[T](expectNull, param)
  }

  def methodWithNullableTypeVariableHandler[T](notNull: java.lang.Boolean, value: T, handler: T => Unit): Unit = {
    asJava.methodWithNullableTypeVariableHandler[T](notNull, value, (p:T) => handler(p))
  }

  def methodWithNullableTypeVariableHandlerAsyncResult[T](notNull: java.lang.Boolean, value: T, handler: AsyncResult[T] => Unit): Unit = {
    asJava.methodWithNullableTypeVariableHandlerAsyncResult[T](notNull, value, (p:AsyncResult[T]) => handler(p))
  }

  def methodWithNullableTypeVariableReturn[T](notNull: java.lang.Boolean, value: T): scala.Option[T] = {
    scala.Option(asJava.methodWithNullableTypeVariableReturn[T](notNull, value))
  }

  def methodWithNullableObjectParam(expectNull: java.lang.Boolean, param: AnyRef): Unit = {
    asJava.methodWithNullableObjectParam(expectNull, param)
  }

  def methodWithNonNullableListByteParam(param: List[java.lang.Byte]): java.lang.Boolean = {
    asJava.methodWithNonNullableListByteParam(param.map(x => x.asInstanceOf[java.lang.Byte]).asJava)
  }

  def methodWithNullableListByteParam(expectNull: java.lang.Boolean, param: scala.Option[List[java.lang.Byte]]): Unit = {
    asJava.methodWithNullableListByteParam(expectNull, param.map(x => x.map(x => x.asInstanceOf[java.lang.Byte]).asJava).orNull)
  }

  def methodWithNullableListByteHandler(notNull: java.lang.Boolean, handler: scala.Option[List[java.lang.Byte]] => Unit): Unit = {
    asJava.methodWithNullableListByteHandler(notNull, (p:scala.Option[List[java.lang.Byte]]) => handler(p))
  }

  def methodWithNullableListByteHandlerAsyncResult(notNull: java.lang.Boolean, handler: AsyncResult[scala.Option[List[java.lang.Byte]]] => Unit): Unit = {
    asJava.methodWithNullableListByteHandlerAsyncResult(notNull, (p:AsyncResult[scala.Option[List[java.lang.Byte]]]) => handler(p))
  }

  def methodWithNullableListByteReturn(notNull: java.lang.Boolean): scala.Option[List[java.lang.Byte]] = {
    scala.Option(asJava.methodWithNullableListByteReturn(notNull)).flatMap(x => Some(x.asScala.toList))
  }

  def methodWithNonNullableListShortParam(param: List[java.lang.Short]): java.lang.Boolean = {
    asJava.methodWithNonNullableListShortParam(param.map(x => x.asInstanceOf[java.lang.Short]).asJava)
  }

  def methodWithNullableListShortParam(expectNull: java.lang.Boolean, param: scala.Option[List[java.lang.Short]]): Unit = {
    asJava.methodWithNullableListShortParam(expectNull, param.map(x => x.map(x => x.asInstanceOf[java.lang.Short]).asJava).orNull)
  }

  def methodWithNullableListShortHandler(notNull: java.lang.Boolean, handler: scala.Option[List[java.lang.Short]] => Unit): Unit = {
    asJava.methodWithNullableListShortHandler(notNull, (p:scala.Option[List[java.lang.Short]]) => handler(p))
  }

  def methodWithNullableListShortHandlerAsyncResult(notNull: java.lang.Boolean, handler: AsyncResult[scala.Option[List[java.lang.Short]]] => Unit): Unit = {
    asJava.methodWithNullableListShortHandlerAsyncResult(notNull, (p:AsyncResult[scala.Option[List[java.lang.Short]]]) => handler(p))
  }

  def methodWithNullableListShortReturn(notNull: java.lang.Boolean): scala.Option[List[java.lang.Short]] = {
    scala.Option(asJava.methodWithNullableListShortReturn(notNull)).flatMap(x => Some(x.asScala.toList))
  }

  def methodWithNonNullableListIntegerParam(param: List[java.lang.Integer]): java.lang.Boolean = {
    asJava.methodWithNonNullableListIntegerParam(param.map(x => x.asInstanceOf[java.lang.Integer]).asJava)
  }

  def methodWithNullableListIntegerParam(expectNull: java.lang.Boolean, param: scala.Option[List[java.lang.Integer]]): Unit = {
    asJava.methodWithNullableListIntegerParam(expectNull, param.map(x => x.map(x => x.asInstanceOf[java.lang.Integer]).asJava).orNull)
  }

  def methodWithNullableListIntegerHandler(notNull: java.lang.Boolean, handler: scala.Option[List[java.lang.Integer]] => Unit): Unit = {
    asJava.methodWithNullableListIntegerHandler(notNull, (p:scala.Option[List[java.lang.Integer]]) => handler(p))
  }

  def methodWithNullableListIntegerHandlerAsyncResult(notNull: java.lang.Boolean, handler: AsyncResult[scala.Option[List[java.lang.Integer]]] => Unit): Unit = {
    asJava.methodWithNullableListIntegerHandlerAsyncResult(notNull, (p:AsyncResult[scala.Option[List[java.lang.Integer]]]) => handler(p))
  }

  def methodWithNullableListIntegerReturn(notNull: java.lang.Boolean): scala.Option[List[java.lang.Integer]] = {
    scala.Option(asJava.methodWithNullableListIntegerReturn(notNull)).flatMap(x => Some(x.asScala.toList))
  }

  def methodWithNonNullableListLongParam(param: List[java.lang.Long]): java.lang.Boolean = {
    asJava.methodWithNonNullableListLongParam(param.map(x => x.asInstanceOf[java.lang.Long]).asJava)
  }

  def methodWithNullableListLongParam(expectNull: java.lang.Boolean, param: scala.Option[List[java.lang.Long]]): Unit = {
    asJava.methodWithNullableListLongParam(expectNull, param.map(x => x.map(x => x.asInstanceOf[java.lang.Long]).asJava).orNull)
  }

  def methodWithNullableListLongHandler(notNull: java.lang.Boolean, handler: scala.Option[List[java.lang.Long]] => Unit): Unit = {
    asJava.methodWithNullableListLongHandler(notNull, (p:scala.Option[List[java.lang.Long]]) => handler(p))
  }

  def methodWithNullableListLongHandlerAsyncResult(notNull: java.lang.Boolean, handler: AsyncResult[scala.Option[List[java.lang.Long]]] => Unit): Unit = {
    asJava.methodWithNullableListLongHandlerAsyncResult(notNull, (p:AsyncResult[scala.Option[List[java.lang.Long]]]) => handler(p))
  }

  def methodWithNullableListLongReturn(notNull: java.lang.Boolean): scala.Option[List[java.lang.Long]] = {
    scala.Option(asJava.methodWithNullableListLongReturn(notNull)).flatMap(x => Some(x.asScala.toList))
  }

  def methodWithNonNullableListFloatParam(param: List[java.lang.Float]): java.lang.Boolean = {
    asJava.methodWithNonNullableListFloatParam(param.map(x => x.asInstanceOf[java.lang.Float]).asJava)
  }

  def methodWithNullableListFloatParam(expectNull: java.lang.Boolean, param: scala.Option[List[java.lang.Float]]): Unit = {
    asJava.methodWithNullableListFloatParam(expectNull, param.map(x => x.map(x => x.asInstanceOf[java.lang.Float]).asJava).orNull)
  }

  def methodWithNullableListFloatHandler(notNull: java.lang.Boolean, handler: scala.Option[List[java.lang.Float]] => Unit): Unit = {
    asJava.methodWithNullableListFloatHandler(notNull, (p:scala.Option[List[java.lang.Float]]) => handler(p))
  }

  def methodWithNullableListFloatHandlerAsyncResult(notNull: java.lang.Boolean, handler: AsyncResult[scala.Option[List[java.lang.Float]]] => Unit): Unit = {
    asJava.methodWithNullableListFloatHandlerAsyncResult(notNull, (p:AsyncResult[scala.Option[List[java.lang.Float]]]) => handler(p))
  }

  def methodWithNullableListFloatReturn(notNull: java.lang.Boolean): scala.Option[List[java.lang.Float]] = {
    scala.Option(asJava.methodWithNullableListFloatReturn(notNull)).flatMap(x => Some(x.asScala.toList))
  }

  def methodWithNonNullableListDoubleParam(param: List[java.lang.Double]): java.lang.Boolean = {
    asJava.methodWithNonNullableListDoubleParam(param.map(x => x.asInstanceOf[java.lang.Double]).asJava)
  }

  def methodWithNullableListDoubleParam(expectNull: java.lang.Boolean, param: scala.Option[List[java.lang.Double]]): Unit = {
    asJava.methodWithNullableListDoubleParam(expectNull, param.map(x => x.map(x => x.asInstanceOf[java.lang.Double]).asJava).orNull)
  }

  def methodWithNullableListDoubleHandler(notNull: java.lang.Boolean, handler: scala.Option[List[java.lang.Double]] => Unit): Unit = {
    asJava.methodWithNullableListDoubleHandler(notNull, (p:scala.Option[List[java.lang.Double]]) => handler(p))
  }

  def methodWithNullableListDoubleHandlerAsyncResult(notNull: java.lang.Boolean, handler: AsyncResult[scala.Option[List[java.lang.Double]]] => Unit): Unit = {
    asJava.methodWithNullableListDoubleHandlerAsyncResult(notNull, (p:AsyncResult[scala.Option[List[java.lang.Double]]]) => handler(p))
  }

  def methodWithNullableListDoubleReturn(notNull: java.lang.Boolean): scala.Option[List[java.lang.Double]] = {
    scala.Option(asJava.methodWithNullableListDoubleReturn(notNull)).flatMap(x => Some(x.asScala.toList))
  }

  def methodWithNonNullableListBooleanParam(param: List[java.lang.Boolean]): java.lang.Boolean = {
    asJava.methodWithNonNullableListBooleanParam(param.map(x => x.asInstanceOf[java.lang.Boolean]).asJava)
  }

  def methodWithNullableListBooleanParam(expectNull: java.lang.Boolean, param: scala.Option[List[java.lang.Boolean]]): Unit = {
    asJava.methodWithNullableListBooleanParam(expectNull, param.map(x => x.map(x => x.asInstanceOf[java.lang.Boolean]).asJava).orNull)
  }

  def methodWithNullableListBooleanHandler(notNull: java.lang.Boolean, handler: scala.Option[List[java.lang.Boolean]] => Unit): Unit = {
    asJava.methodWithNullableListBooleanHandler(notNull, (p:scala.Option[List[java.lang.Boolean]]) => handler(p))
  }

  def methodWithNullableListBooleanHandlerAsyncResult(notNull: java.lang.Boolean, handler: AsyncResult[scala.Option[List[java.lang.Boolean]]] => Unit): Unit = {
    asJava.methodWithNullableListBooleanHandlerAsyncResult(notNull, (p:AsyncResult[scala.Option[List[java.lang.Boolean]]]) => handler(p))
  }

  def methodWithNullableListBooleanReturn(notNull: java.lang.Boolean): scala.Option[List[java.lang.Boolean]] = {
    scala.Option(asJava.methodWithNullableListBooleanReturn(notNull)).flatMap(x => Some(x.asScala.toList))
  }

  def methodWithNonNullableListStringParam(param: List[String]): java.lang.Boolean = {
    asJava.methodWithNonNullableListStringParam(param.map(x => x.asInstanceOf[String]).asJava)
  }

  def methodWithNullableListStringParam(expectNull: java.lang.Boolean, param: scala.Option[List[String]]): Unit = {
    asJava.methodWithNullableListStringParam(expectNull, param.map(x => x.map(x => x.asInstanceOf[String]).asJava).orNull)
  }

  def methodWithNullableListStringHandler(notNull: java.lang.Boolean, handler: scala.Option[List[String]] => Unit): Unit = {
    asJava.methodWithNullableListStringHandler(notNull, (p:scala.Option[List[String]]) => handler(p))
  }

  def methodWithNullableListStringHandlerAsyncResult(notNull: java.lang.Boolean, handler: AsyncResult[scala.Option[List[String]]] => Unit): Unit = {
    asJava.methodWithNullableListStringHandlerAsyncResult(notNull, (p:AsyncResult[scala.Option[List[String]]]) => handler(p))
  }

  def methodWithNullableListStringReturn(notNull: java.lang.Boolean): scala.Option[List[String]] = {
    scala.Option(asJava.methodWithNullableListStringReturn(notNull)).flatMap(x => Some(x.asScala.toList))
  }

  def methodWithNonNullableListCharParam(param: List[java.lang.Character]): java.lang.Boolean = {
    asJava.methodWithNonNullableListCharParam(param.map(x => x.asInstanceOf[java.lang.Character]).asJava)
  }

  def methodWithNullableListCharParam(expectNull: java.lang.Boolean, param: scala.Option[List[java.lang.Character]]): Unit = {
    asJava.methodWithNullableListCharParam(expectNull, param.map(x => x.map(x => x.asInstanceOf[java.lang.Character]).asJava).orNull)
  }

  def methodWithNullableListCharHandler(notNull: java.lang.Boolean, handler: scala.Option[List[java.lang.Character]] => Unit): Unit = {
    asJava.methodWithNullableListCharHandler(notNull, (p:scala.Option[List[java.lang.Character]]) => handler(p))
  }

  def methodWithNullableListCharHandlerAsyncResult(notNull: java.lang.Boolean, handler: AsyncResult[scala.Option[List[java.lang.Character]]] => Unit): Unit = {
    asJava.methodWithNullableListCharHandlerAsyncResult(notNull, (p:AsyncResult[scala.Option[List[java.lang.Character]]]) => handler(p))
  }

  def methodWithNullableListCharReturn(notNull: java.lang.Boolean): scala.Option[List[java.lang.Character]] = {
    scala.Option(asJava.methodWithNullableListCharReturn(notNull)).flatMap(x => Some(x.asScala.toList))
  }

  def methodWithNonNullableListJsonObjectParam(param: List[io.vertx.core.json.JsonObject]): java.lang.Boolean = {
    asJava.methodWithNonNullableListJsonObjectParam(param.asJava)
  }

  def methodWithNullableListJsonObjectParam(expectNull: java.lang.Boolean, param: scala.Option[List[io.vertx.core.json.JsonObject]]): Unit = {
    asJava.methodWithNullableListJsonObjectParam(expectNull, param.map(x => x.asJava).orNull)
  }

  def methodWithNullableListJsonObjectHandler(notNull: java.lang.Boolean, handler: scala.Option[List[io.vertx.core.json.JsonObject]] => Unit): Unit = {
    asJava.methodWithNullableListJsonObjectHandler(notNull, (p:scala.Option[List[io.vertx.core.json.JsonObject]]) => handler(p))
  }

  def methodWithNullableListJsonObjectHandlerAsyncResult(notNull: java.lang.Boolean, handler: AsyncResult[scala.Option[List[io.vertx.core.json.JsonObject]]] => Unit): Unit = {
    asJava.methodWithNullableListJsonObjectHandlerAsyncResult(notNull, (p:AsyncResult[scala.Option[List[io.vertx.core.json.JsonObject]]]) => handler(p))
  }

  def methodWithNullableListJsonObjectReturn(notNull: java.lang.Boolean): scala.Option[List[io.vertx.core.json.JsonObject]] = {
    scala.Option(asJava.methodWithNullableListJsonObjectReturn(notNull)).flatMap(x => Some(x.asScala.toList))
  }

  def methodWithNonNullableListJsonArrayParam(param: List[io.vertx.core.json.JsonArray]): java.lang.Boolean = {
    asJava.methodWithNonNullableListJsonArrayParam(param.asJava)
  }

  def methodWithNullableListJsonArrayParam(expectNull: java.lang.Boolean, param: scala.Option[List[io.vertx.core.json.JsonArray]]): Unit = {
    asJava.methodWithNullableListJsonArrayParam(expectNull, param.map(x => x.asJava).orNull)
  }

  def methodWithNullableListJsonArrayHandler(notNull: java.lang.Boolean, handler: scala.Option[List[io.vertx.core.json.JsonArray]] => Unit): Unit = {
    asJava.methodWithNullableListJsonArrayHandler(notNull, (p:scala.Option[List[io.vertx.core.json.JsonArray]]) => handler(p))
  }

  def methodWithNullableListJsonArrayHandlerAsyncResult(notNull: java.lang.Boolean, handler: AsyncResult[scala.Option[List[io.vertx.core.json.JsonArray]]] => Unit): Unit = {
    asJava.methodWithNullableListJsonArrayHandlerAsyncResult(notNull, (p:AsyncResult[scala.Option[List[io.vertx.core.json.JsonArray]]]) => handler(p))
  }

  def methodWithNullableListJsonArrayReturn(notNull: java.lang.Boolean): scala.Option[List[io.vertx.core.json.JsonArray]] = {
    scala.Option(asJava.methodWithNullableListJsonArrayReturn(notNull)).flatMap(x => Some(x.asScala.toList))
  }

  def methodWithNonNullableListApiParam(param: List[JRefedInterface1]): java.lang.Boolean = {
    asJava.methodWithNonNullableListApiParam(param.asJava)
  }

  def methodWithNullableListApiParam(expectNull: java.lang.Boolean, param: scala.Option[List[JRefedInterface1]]): Unit = {
    asJava.methodWithNullableListApiParam(expectNull, param.map(x => x.asJava).orNull)
  }

  def methodWithNullableListApiHandler(notNull: java.lang.Boolean, handler: scala.Option[List[JRefedInterface1]] => Unit): Unit = {
    asJava.methodWithNullableListApiHandler(notNull, (p:scala.Option[List[JRefedInterface1]]) => handler(p))
  }

  def methodWithNullableListApiHandlerAsyncResult(notNull: java.lang.Boolean, handler: AsyncResult[scala.Option[List[JRefedInterface1]]] => Unit): Unit = {
    asJava.methodWithNullableListApiHandlerAsyncResult(notNull, (p:AsyncResult[scala.Option[List[JRefedInterface1]]]) => handler(p))
  }

  def methodWithNullableListApiReturn(notNull: java.lang.Boolean): scala.Option[List[JRefedInterface1]] = {
    scala.Option(asJava.methodWithNullableListApiReturn(notNull)).flatMap(x => Some(x.asScala.toList))
  }

  def methodWithNonNullableListDataObjectParam(param: List[JTestDataObject]): java.lang.Boolean = {
    asJava.methodWithNonNullableListDataObjectParam(param.asJava)
  }

  def methodWithNullableListDataObjectParam(expectNull: java.lang.Boolean, param: scala.Option[List[JTestDataObject]]): Unit = {
    asJava.methodWithNullableListDataObjectParam(expectNull, param.map(x => x.asJava).orNull)
  }

  def methodWithNullableListDataObjectHandler(notNull: java.lang.Boolean, handler: scala.Option[List[JTestDataObject]] => Unit): Unit = {
    asJava.methodWithNullableListDataObjectHandler(notNull, (p:scala.Option[List[JTestDataObject]]) => handler(p))
  }

  def methodWithNullableListDataObjectHandlerAsyncResult(notNull: java.lang.Boolean, handler: AsyncResult[scala.Option[List[JTestDataObject]]] => Unit): Unit = {
    asJava.methodWithNullableListDataObjectHandlerAsyncResult(notNull, (p:AsyncResult[scala.Option[List[JTestDataObject]]]) => handler(p))
  }

  def methodWithNullableListDataObjectReturn(notNull: java.lang.Boolean): scala.Option[List[JTestDataObject]] = {
    scala.Option(asJava.methodWithNullableListDataObjectReturn(notNull)).flatMap(x => Some(x.asScala.toList))
  }

  def methodWithNonNullableListEnumParam(param: List[io.vertx.codegen.testmodel.TestEnum]): java.lang.Boolean = {
    asJava.methodWithNonNullableListEnumParam(param.asJava)
  }

  def methodWithNullableListEnumParam(expectNull: java.lang.Boolean, param: scala.Option[List[io.vertx.codegen.testmodel.TestEnum]]): Unit = {
    asJava.methodWithNullableListEnumParam(expectNull, param.map(x => x.asJava).orNull)
  }

  def methodWithNullableListEnumHandler(notNull: java.lang.Boolean, handler: scala.Option[List[io.vertx.codegen.testmodel.TestEnum]] => Unit): Unit = {
    asJava.methodWithNullableListEnumHandler(notNull, (p:scala.Option[List[io.vertx.codegen.testmodel.TestEnum]]) => handler(p))
  }

  def methodWithNullableListEnumHandlerAsyncResult(notNull: java.lang.Boolean, handler: AsyncResult[scala.Option[List[io.vertx.codegen.testmodel.TestEnum]]] => Unit): Unit = {
    asJava.methodWithNullableListEnumHandlerAsyncResult(notNull, (p:AsyncResult[scala.Option[List[io.vertx.codegen.testmodel.TestEnum]]]) => handler(p))
  }

  def methodWithNullableListEnumReturn(notNull: java.lang.Boolean): scala.Option[List[io.vertx.codegen.testmodel.TestEnum]] = {
    scala.Option(asJava.methodWithNullableListEnumReturn(notNull)).flatMap(x => Some(x.asScala.toList))
  }

  def methodWithNonNullableListGenEnumParam(param: List[io.vertx.codegen.testmodel.TestGenEnum]): java.lang.Boolean = {
    asJava.methodWithNonNullableListGenEnumParam(param.asJava)
  }

  def methodWithNullableListGenEnumParam(expectNull: java.lang.Boolean, param: scala.Option[List[io.vertx.codegen.testmodel.TestGenEnum]]): Unit = {
    asJava.methodWithNullableListGenEnumParam(expectNull, param.map(x => x.asJava).orNull)
  }

  def methodWithNullableListGenEnumHandler(notNull: java.lang.Boolean, handler: scala.Option[List[io.vertx.codegen.testmodel.TestGenEnum]] => Unit): Unit = {
    asJava.methodWithNullableListGenEnumHandler(notNull, (p:scala.Option[List[io.vertx.codegen.testmodel.TestGenEnum]]) => handler(p))
  }

  def methodWithNullableListGenEnumHandlerAsyncResult(notNull: java.lang.Boolean, handler: AsyncResult[scala.Option[List[io.vertx.codegen.testmodel.TestGenEnum]]] => Unit): Unit = {
    asJava.methodWithNullableListGenEnumHandlerAsyncResult(notNull, (p:AsyncResult[scala.Option[List[io.vertx.codegen.testmodel.TestGenEnum]]]) => handler(p))
  }

  def methodWithNullableListGenEnumReturn(notNull: java.lang.Boolean): scala.Option[List[io.vertx.codegen.testmodel.TestGenEnum]] = {
    scala.Option(asJava.methodWithNullableListGenEnumReturn(notNull)).flatMap(x => Some(x.asScala.toList))
  }

  def methodWithNonNullableSetByteParam(param: Set[java.lang.Byte]): java.lang.Boolean = {
    asJava.methodWithNonNullableSetByteParam(param.map(x => x.asInstanceOf[java.lang.Byte]).asJava)
  }

  def methodWithNullableSetByteParam(expectNull: java.lang.Boolean, param: scala.Option[Set[java.lang.Byte]]): Unit = {
    asJava.methodWithNullableSetByteParam(expectNull, param.map(x => x.map(x => x.asInstanceOf[java.lang.Byte]).asJava).orNull)
  }

  def methodWithNullableSetByteHandler(notNull: java.lang.Boolean, handler: scala.Option[Set[java.lang.Byte]] => Unit): Unit = {
    asJava.methodWithNullableSetByteHandler(notNull, (p:scala.Option[Set[java.lang.Byte]]) => handler(p))
  }

  def methodWithNullableSetByteHandlerAsyncResult(notNull: java.lang.Boolean, handler: AsyncResult[scala.Option[Set[java.lang.Byte]]] => Unit): Unit = {
    asJava.methodWithNullableSetByteHandlerAsyncResult(notNull, (p:AsyncResult[scala.Option[Set[java.lang.Byte]]]) => handler(p))
  }

  def methodWithNullableSetByteReturn(notNull: java.lang.Boolean): scala.Option[Seq[java.lang.Byte]] = {
    scala.Option(asJava.methodWithNullableSetByteReturn(notNull)).flatMap(x => Some(x.asScala.toSeq))
  }

  def methodWithNonNullableSetShortParam(param: Set[java.lang.Short]): java.lang.Boolean = {
    asJava.methodWithNonNullableSetShortParam(param.map(x => x.asInstanceOf[java.lang.Short]).asJava)
  }

  def methodWithNullableSetShortParam(expectNull: java.lang.Boolean, param: scala.Option[Set[java.lang.Short]]): Unit = {
    asJava.methodWithNullableSetShortParam(expectNull, param.map(x => x.map(x => x.asInstanceOf[java.lang.Short]).asJava).orNull)
  }

  def methodWithNullableSetShortHandler(notNull: java.lang.Boolean, handler: scala.Option[Set[java.lang.Short]] => Unit): Unit = {
    asJava.methodWithNullableSetShortHandler(notNull, (p:scala.Option[Set[java.lang.Short]]) => handler(p))
  }

  def methodWithNullableSetShortHandlerAsyncResult(notNull: java.lang.Boolean, handler: AsyncResult[scala.Option[Set[java.lang.Short]]] => Unit): Unit = {
    asJava.methodWithNullableSetShortHandlerAsyncResult(notNull, (p:AsyncResult[scala.Option[Set[java.lang.Short]]]) => handler(p))
  }

  def methodWithNullableSetShortReturn(notNull: java.lang.Boolean): scala.Option[Seq[java.lang.Short]] = {
    scala.Option(asJava.methodWithNullableSetShortReturn(notNull)).flatMap(x => Some(x.asScala.toSeq))
  }

  def methodWithNonNullableSetIntegerParam(param: Set[java.lang.Integer]): java.lang.Boolean = {
    asJava.methodWithNonNullableSetIntegerParam(param.map(x => x.asInstanceOf[java.lang.Integer]).asJava)
  }

  def methodWithNullableSetIntegerParam(expectNull: java.lang.Boolean, param: scala.Option[Set[java.lang.Integer]]): Unit = {
    asJava.methodWithNullableSetIntegerParam(expectNull, param.map(x => x.map(x => x.asInstanceOf[java.lang.Integer]).asJava).orNull)
  }

  def methodWithNullableSetIntegerHandler(notNull: java.lang.Boolean, handler: scala.Option[Set[java.lang.Integer]] => Unit): Unit = {
    asJava.methodWithNullableSetIntegerHandler(notNull, (p:scala.Option[Set[java.lang.Integer]]) => handler(p))
  }

  def methodWithNullableSetIntegerHandlerAsyncResult(notNull: java.lang.Boolean, handler: AsyncResult[scala.Option[Set[java.lang.Integer]]] => Unit): Unit = {
    asJava.methodWithNullableSetIntegerHandlerAsyncResult(notNull, (p:AsyncResult[scala.Option[Set[java.lang.Integer]]]) => handler(p))
  }

  def methodWithNullableSetIntegerReturn(notNull: java.lang.Boolean): scala.Option[Seq[java.lang.Integer]] = {
    scala.Option(asJava.methodWithNullableSetIntegerReturn(notNull)).flatMap(x => Some(x.asScala.toSeq))
  }

  def methodWithNonNullableSetLongParam(param: Set[java.lang.Long]): java.lang.Boolean = {
    asJava.methodWithNonNullableSetLongParam(param.map(x => x.asInstanceOf[java.lang.Long]).asJava)
  }

  def methodWithNullableSetLongParam(expectNull: java.lang.Boolean, param: scala.Option[Set[java.lang.Long]]): Unit = {
    asJava.methodWithNullableSetLongParam(expectNull, param.map(x => x.map(x => x.asInstanceOf[java.lang.Long]).asJava).orNull)
  }

  def methodWithNullableSetLongHandler(notNull: java.lang.Boolean, handler: scala.Option[Set[java.lang.Long]] => Unit): Unit = {
    asJava.methodWithNullableSetLongHandler(notNull, (p:scala.Option[Set[java.lang.Long]]) => handler(p))
  }

  def methodWithNullableSetLongHandlerAsyncResult(notNull: java.lang.Boolean, handler: AsyncResult[scala.Option[Set[java.lang.Long]]] => Unit): Unit = {
    asJava.methodWithNullableSetLongHandlerAsyncResult(notNull, (p:AsyncResult[scala.Option[Set[java.lang.Long]]]) => handler(p))
  }

  def methodWithNullableSetLongReturn(notNull: java.lang.Boolean): scala.Option[Seq[java.lang.Long]] = {
    scala.Option(asJava.methodWithNullableSetLongReturn(notNull)).flatMap(x => Some(x.asScala.toSeq))
  }

  def methodWithNonNullableSetFloatParam(param: Set[java.lang.Float]): java.lang.Boolean = {
    asJava.methodWithNonNullableSetFloatParam(param.map(x => x.asInstanceOf[java.lang.Float]).asJava)
  }

  def methodWithNullableSetFloatParam(expectNull: java.lang.Boolean, param: scala.Option[Set[java.lang.Float]]): Unit = {
    asJava.methodWithNullableSetFloatParam(expectNull, param.map(x => x.map(x => x.asInstanceOf[java.lang.Float]).asJava).orNull)
  }

  def methodWithNullableSetFloatHandler(notNull: java.lang.Boolean, handler: scala.Option[Set[java.lang.Float]] => Unit): Unit = {
    asJava.methodWithNullableSetFloatHandler(notNull, (p:scala.Option[Set[java.lang.Float]]) => handler(p))
  }

  def methodWithNullableSetFloatHandlerAsyncResult(notNull: java.lang.Boolean, handler: AsyncResult[scala.Option[Set[java.lang.Float]]] => Unit): Unit = {
    asJava.methodWithNullableSetFloatHandlerAsyncResult(notNull, (p:AsyncResult[scala.Option[Set[java.lang.Float]]]) => handler(p))
  }

  def methodWithNullableSetFloatReturn(notNull: java.lang.Boolean): scala.Option[Seq[java.lang.Float]] = {
    scala.Option(asJava.methodWithNullableSetFloatReturn(notNull)).flatMap(x => Some(x.asScala.toSeq))
  }

  def methodWithNonNullableSetDoubleParam(param: Set[java.lang.Double]): java.lang.Boolean = {
    asJava.methodWithNonNullableSetDoubleParam(param.map(x => x.asInstanceOf[java.lang.Double]).asJava)
  }

  def methodWithNullableSetDoubleParam(expectNull: java.lang.Boolean, param: scala.Option[Set[java.lang.Double]]): Unit = {
    asJava.methodWithNullableSetDoubleParam(expectNull, param.map(x => x.map(x => x.asInstanceOf[java.lang.Double]).asJava).orNull)
  }

  def methodWithNullableSetDoubleHandler(notNull: java.lang.Boolean, handler: scala.Option[Set[java.lang.Double]] => Unit): Unit = {
    asJava.methodWithNullableSetDoubleHandler(notNull, (p:scala.Option[Set[java.lang.Double]]) => handler(p))
  }

  def methodWithNullableSetDoubleHandlerAsyncResult(notNull: java.lang.Boolean, handler: AsyncResult[scala.Option[Set[java.lang.Double]]] => Unit): Unit = {
    asJava.methodWithNullableSetDoubleHandlerAsyncResult(notNull, (p:AsyncResult[scala.Option[Set[java.lang.Double]]]) => handler(p))
  }

  def methodWithNullableSetDoubleReturn(notNull: java.lang.Boolean): scala.Option[Seq[java.lang.Double]] = {
    scala.Option(asJava.methodWithNullableSetDoubleReturn(notNull)).flatMap(x => Some(x.asScala.toSeq))
  }

  def methodWithNonNullableSetBooleanParam(param: Set[java.lang.Boolean]): java.lang.Boolean = {
    asJava.methodWithNonNullableSetBooleanParam(param.map(x => x.asInstanceOf[java.lang.Boolean]).asJava)
  }

  def methodWithNullableSetBooleanParam(expectNull: java.lang.Boolean, param: scala.Option[Set[java.lang.Boolean]]): Unit = {
    asJava.methodWithNullableSetBooleanParam(expectNull, param.map(x => x.map(x => x.asInstanceOf[java.lang.Boolean]).asJava).orNull)
  }

  def methodWithNullableSetBooleanHandler(notNull: java.lang.Boolean, handler: scala.Option[Set[java.lang.Boolean]] => Unit): Unit = {
    asJava.methodWithNullableSetBooleanHandler(notNull, (p:scala.Option[Set[java.lang.Boolean]]) => handler(p))
  }

  def methodWithNullableSetBooleanHandlerAsyncResult(notNull: java.lang.Boolean, handler: AsyncResult[scala.Option[Set[java.lang.Boolean]]] => Unit): Unit = {
    asJava.methodWithNullableSetBooleanHandlerAsyncResult(notNull, (p:AsyncResult[scala.Option[Set[java.lang.Boolean]]]) => handler(p))
  }

  def methodWithNullableSetBooleanReturn(notNull: java.lang.Boolean): scala.Option[Seq[java.lang.Boolean]] = {
    scala.Option(asJava.methodWithNullableSetBooleanReturn(notNull)).flatMap(x => Some(x.asScala.toSeq))
  }

  def methodWithNonNullableSetStringParam(param: Set[String]): java.lang.Boolean = {
    asJava.methodWithNonNullableSetStringParam(param.map(x => x.asInstanceOf[String]).asJava)
  }

  def methodWithNullableSetStringParam(expectNull: java.lang.Boolean, param: scala.Option[Set[String]]): Unit = {
    asJava.methodWithNullableSetStringParam(expectNull, param.map(x => x.map(x => x.asInstanceOf[String]).asJava).orNull)
  }

  def methodWithNullableSetStringHandler(notNull: java.lang.Boolean, handler: scala.Option[Set[String]] => Unit): Unit = {
    asJava.methodWithNullableSetStringHandler(notNull, (p:scala.Option[Set[String]]) => handler(p))
  }

  def methodWithNullableSetStringHandlerAsyncResult(notNull: java.lang.Boolean, handler: AsyncResult[scala.Option[Set[String]]] => Unit): Unit = {
    asJava.methodWithNullableSetStringHandlerAsyncResult(notNull, (p:AsyncResult[scala.Option[Set[String]]]) => handler(p))
  }

  def methodWithNullableSetStringReturn(notNull: java.lang.Boolean): scala.Option[Seq[String]] = {
    scala.Option(asJava.methodWithNullableSetStringReturn(notNull)).flatMap(x => Some(x.asScala.toSeq))
  }

  def methodWithNonNullableSetCharParam(param: Set[java.lang.Character]): java.lang.Boolean = {
    asJava.methodWithNonNullableSetCharParam(param.map(x => x.asInstanceOf[java.lang.Character]).asJava)
  }

  def methodWithNullableSetCharParam(expectNull: java.lang.Boolean, param: scala.Option[Set[java.lang.Character]]): Unit = {
    asJava.methodWithNullableSetCharParam(expectNull, param.map(x => x.map(x => x.asInstanceOf[java.lang.Character]).asJava).orNull)
  }

  def methodWithNullableSetCharHandler(notNull: java.lang.Boolean, handler: scala.Option[Set[java.lang.Character]] => Unit): Unit = {
    asJava.methodWithNullableSetCharHandler(notNull, (p:scala.Option[Set[java.lang.Character]]) => handler(p))
  }

  def methodWithNullableSetCharHandlerAsyncResult(notNull: java.lang.Boolean, handler: AsyncResult[scala.Option[Set[java.lang.Character]]] => Unit): Unit = {
    asJava.methodWithNullableSetCharHandlerAsyncResult(notNull, (p:AsyncResult[scala.Option[Set[java.lang.Character]]]) => handler(p))
  }

  def methodWithNullableSetCharReturn(notNull: java.lang.Boolean): scala.Option[Seq[java.lang.Character]] = {
    scala.Option(asJava.methodWithNullableSetCharReturn(notNull)).flatMap(x => Some(x.asScala.toSeq))
  }

  def methodWithNonNullableSetJsonObjectParam(param: Set[io.vertx.core.json.JsonObject]): java.lang.Boolean = {
    asJava.methodWithNonNullableSetJsonObjectParam(param.asJava)
  }

  def methodWithNullableSetJsonObjectParam(expectNull: java.lang.Boolean, param: scala.Option[Set[io.vertx.core.json.JsonObject]]): Unit = {
    asJava.methodWithNullableSetJsonObjectParam(expectNull, param.map(x => x.asJava).orNull)
  }

  def methodWithNullableSetJsonObjectHandler(notNull: java.lang.Boolean, handler: scala.Option[Set[io.vertx.core.json.JsonObject]] => Unit): Unit = {
    asJava.methodWithNullableSetJsonObjectHandler(notNull, (p:scala.Option[Set[io.vertx.core.json.JsonObject]]) => handler(p))
  }

  def methodWithNullableSetJsonObjectHandlerAsyncResult(notNull: java.lang.Boolean, handler: AsyncResult[scala.Option[Set[io.vertx.core.json.JsonObject]]] => Unit): Unit = {
    asJava.methodWithNullableSetJsonObjectHandlerAsyncResult(notNull, (p:AsyncResult[scala.Option[Set[io.vertx.core.json.JsonObject]]]) => handler(p))
  }

  def methodWithNullableSetJsonObjectReturn(notNull: java.lang.Boolean): scala.Option[Seq[io.vertx.core.json.JsonObject]] = {
    scala.Option(asJava.methodWithNullableSetJsonObjectReturn(notNull)).flatMap(x => Some(x.asScala.toSeq))
  }

  def methodWithNonNullableSetJsonArrayParam(param: Set[io.vertx.core.json.JsonArray]): java.lang.Boolean = {
    asJava.methodWithNonNullableSetJsonArrayParam(param.asJava)
  }

  def methodWithNullableSetJsonArrayParam(expectNull: java.lang.Boolean, param: scala.Option[Set[io.vertx.core.json.JsonArray]]): Unit = {
    asJava.methodWithNullableSetJsonArrayParam(expectNull, param.map(x => x.asJava).orNull)
  }

  def methodWithNullableSetJsonArrayHandler(notNull: java.lang.Boolean, handler: scala.Option[Set[io.vertx.core.json.JsonArray]] => Unit): Unit = {
    asJava.methodWithNullableSetJsonArrayHandler(notNull, (p:scala.Option[Set[io.vertx.core.json.JsonArray]]) => handler(p))
  }

  def methodWithNullableSetJsonArrayHandlerAsyncResult(notNull: java.lang.Boolean, handler: AsyncResult[scala.Option[Set[io.vertx.core.json.JsonArray]]] => Unit): Unit = {
    asJava.methodWithNullableSetJsonArrayHandlerAsyncResult(notNull, (p:AsyncResult[scala.Option[Set[io.vertx.core.json.JsonArray]]]) => handler(p))
  }

  def methodWithNullableSetJsonArrayReturn(notNull: java.lang.Boolean): scala.Option[Seq[io.vertx.core.json.JsonArray]] = {
    scala.Option(asJava.methodWithNullableSetJsonArrayReturn(notNull)).flatMap(x => Some(x.asScala.toSeq))
  }

  def methodWithNonNullableSetApiParam(param: Set[JRefedInterface1]): java.lang.Boolean = {
    asJava.methodWithNonNullableSetApiParam(param.asJava)
  }

  def methodWithNullableSetApiParam(expectNull: java.lang.Boolean, param: scala.Option[Set[JRefedInterface1]]): Unit = {
    asJava.methodWithNullableSetApiParam(expectNull, param.map(x => x.asJava).orNull)
  }

  def methodWithNullableSetApiHandler(notNull: java.lang.Boolean, handler: scala.Option[Set[JRefedInterface1]] => Unit): Unit = {
    asJava.methodWithNullableSetApiHandler(notNull, (p:scala.Option[Set[JRefedInterface1]]) => handler(p))
  }

  def methodWithNullableSetApiHandlerAsyncResult(notNull: java.lang.Boolean, handler: AsyncResult[scala.Option[Set[JRefedInterface1]]] => Unit): Unit = {
    asJava.methodWithNullableSetApiHandlerAsyncResult(notNull, (p:AsyncResult[scala.Option[Set[JRefedInterface1]]]) => handler(p))
  }

  def methodWithNullableSetApiReturn(notNull: java.lang.Boolean): scala.Option[Seq[JRefedInterface1]] = {
    scala.Option(asJava.methodWithNullableSetApiReturn(notNull)).flatMap(x => Some(x.asScala.toSeq))
  }

  def methodWithNonNullableSetDataObjectParam(param: Set[JTestDataObject]): java.lang.Boolean = {
    asJava.methodWithNonNullableSetDataObjectParam(param.asJava)
  }

  def methodWithNullableSetDataObjectParam(expectNull: java.lang.Boolean, param: scala.Option[Set[JTestDataObject]]): Unit = {
    asJava.methodWithNullableSetDataObjectParam(expectNull, param.map(x => x.asJava).orNull)
  }

  def methodWithNullableSetDataObjectHandler(notNull: java.lang.Boolean, handler: scala.Option[Set[JTestDataObject]] => Unit): Unit = {
    asJava.methodWithNullableSetDataObjectHandler(notNull, (p:scala.Option[Set[JTestDataObject]]) => handler(p))
  }

  def methodWithNullableSetDataObjectHandlerAsyncResult(notNull: java.lang.Boolean, handler: AsyncResult[scala.Option[Set[JTestDataObject]]] => Unit): Unit = {
    asJava.methodWithNullableSetDataObjectHandlerAsyncResult(notNull, (p:AsyncResult[scala.Option[Set[JTestDataObject]]]) => handler(p))
  }

  def methodWithNullableSetDataObjectReturn(notNull: java.lang.Boolean): scala.Option[Seq[JTestDataObject]] = {
    scala.Option(asJava.methodWithNullableSetDataObjectReturn(notNull)).flatMap(x => Some(x.asScala.toSeq))
  }

  def methodWithNonNullableSetEnumParam(param: Set[io.vertx.codegen.testmodel.TestEnum]): java.lang.Boolean = {
    asJava.methodWithNonNullableSetEnumParam(param.asJava)
  }

  def methodWithNullableSetEnumParam(expectNull: java.lang.Boolean, param: scala.Option[Set[io.vertx.codegen.testmodel.TestEnum]]): Unit = {
    asJava.methodWithNullableSetEnumParam(expectNull, param.map(x => x.asJava).orNull)
  }

  def methodWithNullableSetEnumHandler(notNull: java.lang.Boolean, handler: scala.Option[Set[io.vertx.codegen.testmodel.TestEnum]] => Unit): Unit = {
    asJava.methodWithNullableSetEnumHandler(notNull, (p:scala.Option[Set[io.vertx.codegen.testmodel.TestEnum]]) => handler(p))
  }

  def methodWithNullableSetEnumHandlerAsyncResult(notNull: java.lang.Boolean, handler: AsyncResult[scala.Option[Set[io.vertx.codegen.testmodel.TestEnum]]] => Unit): Unit = {
    asJava.methodWithNullableSetEnumHandlerAsyncResult(notNull, (p:AsyncResult[scala.Option[Set[io.vertx.codegen.testmodel.TestEnum]]]) => handler(p))
  }

  def methodWithNullableSetEnumReturn(notNull: java.lang.Boolean): scala.Option[Seq[io.vertx.codegen.testmodel.TestEnum]] = {
    scala.Option(asJava.methodWithNullableSetEnumReturn(notNull)).flatMap(x => Some(x.asScala.toSeq))
  }

  def methodWithNonNullableSetGenEnumParam(param: Set[io.vertx.codegen.testmodel.TestGenEnum]): java.lang.Boolean = {
    asJava.methodWithNonNullableSetGenEnumParam(param.asJava)
  }

  def methodWithNullableSetGenEnumParam(expectNull: java.lang.Boolean, param: scala.Option[Set[io.vertx.codegen.testmodel.TestGenEnum]]): Unit = {
    asJava.methodWithNullableSetGenEnumParam(expectNull, param.map(x => x.asJava).orNull)
  }

  def methodWithNullableSetGenEnumHandler(notNull: java.lang.Boolean, handler: scala.Option[Set[io.vertx.codegen.testmodel.TestGenEnum]] => Unit): Unit = {
    asJava.methodWithNullableSetGenEnumHandler(notNull, (p:scala.Option[Set[io.vertx.codegen.testmodel.TestGenEnum]]) => handler(p))
  }

  def methodWithNullableSetGenEnumHandlerAsyncResult(notNull: java.lang.Boolean, handler: AsyncResult[scala.Option[Set[io.vertx.codegen.testmodel.TestGenEnum]]] => Unit): Unit = {
    asJava.methodWithNullableSetGenEnumHandlerAsyncResult(notNull, (p:AsyncResult[scala.Option[Set[io.vertx.codegen.testmodel.TestGenEnum]]]) => handler(p))
  }

  def methodWithNullableSetGenEnumReturn(notNull: java.lang.Boolean): scala.Option[Seq[io.vertx.codegen.testmodel.TestGenEnum]] = {
    scala.Option(asJava.methodWithNullableSetGenEnumReturn(notNull)).flatMap(x => Some(x.asScala.toSeq))
  }

  def methodWithNonNullableMapByteParam(param: Map[String, java.lang.Byte]): java.lang.Boolean = {
    asJava.methodWithNonNullableMapByteParam(param.mapValues(x => x.asInstanceOf[java.lang.Byte]).asJava)
  }

  def methodWithNullableMapByteParam(expectNull: java.lang.Boolean, param: scala.Option[Map[String, java.lang.Byte]]): Unit = {
    asJava.methodWithNullableMapByteParam(expectNull, param.map(x => x.mapValues(x => x.asInstanceOf[java.lang.Byte]).asJava).orNull)
  }

  def methodWithNullableMapByteHandler(notNull: java.lang.Boolean, handler: scala.Option[Map[String, java.lang.Byte]] => Unit): Unit = {
    asJava.methodWithNullableMapByteHandler(notNull, (p:scala.Option[Map[String, java.lang.Byte]]) => handler(p))
  }

  def methodWithNullableMapByteHandlerAsyncResult(notNull: java.lang.Boolean, handler: AsyncResult[scala.Option[Map[String, java.lang.Byte]]] => Unit): Unit = {
    asJava.methodWithNullableMapByteHandlerAsyncResult(notNull, (p:AsyncResult[scala.Option[Map[String, java.lang.Byte]]]) => handler(p))
  }

  def methodWithNullableMapByteReturn(notNull: java.lang.Boolean): scala.Option[Map[String, java.lang.Byte]] = {
    scala.Option(asJava.methodWithNullableMapByteReturn(notNull)).flatMap(x => Some(x.asScala.toMap))
  }

  def methodWithNonNullableMapShortParam(param: Map[String, java.lang.Short]): java.lang.Boolean = {
    asJava.methodWithNonNullableMapShortParam(param.mapValues(x => x.asInstanceOf[java.lang.Short]).asJava)
  }

  def methodWithNullableMapShortParam(expectNull: java.lang.Boolean, param: scala.Option[Map[String, java.lang.Short]]): Unit = {
    asJava.methodWithNullableMapShortParam(expectNull, param.map(x => x.mapValues(x => x.asInstanceOf[java.lang.Short]).asJava).orNull)
  }

  def methodWithNullableMapShortHandler(notNull: java.lang.Boolean, handler: scala.Option[Map[String, java.lang.Short]] => Unit): Unit = {
    asJava.methodWithNullableMapShortHandler(notNull, (p:scala.Option[Map[String, java.lang.Short]]) => handler(p))
  }

  def methodWithNullableMapShortHandlerAsyncResult(notNull: java.lang.Boolean, handler: AsyncResult[scala.Option[Map[String, java.lang.Short]]] => Unit): Unit = {
    asJava.methodWithNullableMapShortHandlerAsyncResult(notNull, (p:AsyncResult[scala.Option[Map[String, java.lang.Short]]]) => handler(p))
  }

  def methodWithNullableMapShortReturn(notNull: java.lang.Boolean): scala.Option[Map[String, java.lang.Short]] = {
    scala.Option(asJava.methodWithNullableMapShortReturn(notNull)).flatMap(x => Some(x.asScala.toMap))
  }

  def methodWithNonNullableMapIntegerParam(param: Map[String, java.lang.Integer]): java.lang.Boolean = {
    asJava.methodWithNonNullableMapIntegerParam(param.mapValues(x => x.asInstanceOf[java.lang.Integer]).asJava)
  }

  def methodWithNullableMapIntegerParam(expectNull: java.lang.Boolean, param: scala.Option[Map[String, java.lang.Integer]]): Unit = {
    asJava.methodWithNullableMapIntegerParam(expectNull, param.map(x => x.mapValues(x => x.asInstanceOf[java.lang.Integer]).asJava).orNull)
  }

  def methodWithNullableMapIntegerHandler(notNull: java.lang.Boolean, handler: scala.Option[Map[String, java.lang.Integer]] => Unit): Unit = {
    asJava.methodWithNullableMapIntegerHandler(notNull, (p:scala.Option[Map[String, java.lang.Integer]]) => handler(p))
  }

  def methodWithNullableMapIntegerHandlerAsyncResult(notNull: java.lang.Boolean, handler: AsyncResult[scala.Option[Map[String, java.lang.Integer]]] => Unit): Unit = {
    asJava.methodWithNullableMapIntegerHandlerAsyncResult(notNull, (p:AsyncResult[scala.Option[Map[String, java.lang.Integer]]]) => handler(p))
  }

  def methodWithNullableMapIntegerReturn(notNull: java.lang.Boolean): scala.Option[Map[String, java.lang.Integer]] = {
    scala.Option(asJava.methodWithNullableMapIntegerReturn(notNull)).flatMap(x => Some(x.asScala.toMap))
  }

  def methodWithNonNullableMapLongParam(param: Map[String, java.lang.Long]): java.lang.Boolean = {
    asJava.methodWithNonNullableMapLongParam(param.mapValues(x => x.asInstanceOf[java.lang.Long]).asJava)
  }

  def methodWithNullableMapLongParam(expectNull: java.lang.Boolean, param: scala.Option[Map[String, java.lang.Long]]): Unit = {
    asJava.methodWithNullableMapLongParam(expectNull, param.map(x => x.mapValues(x => x.asInstanceOf[java.lang.Long]).asJava).orNull)
  }

  def methodWithNullableMapLongHandler(notNull: java.lang.Boolean, handler: scala.Option[Map[String, java.lang.Long]] => Unit): Unit = {
    asJava.methodWithNullableMapLongHandler(notNull, (p:scala.Option[Map[String, java.lang.Long]]) => handler(p))
  }

  def methodWithNullableMapLongHandlerAsyncResult(notNull: java.lang.Boolean, handler: AsyncResult[scala.Option[Map[String, java.lang.Long]]] => Unit): Unit = {
    asJava.methodWithNullableMapLongHandlerAsyncResult(notNull, (p:AsyncResult[scala.Option[Map[String, java.lang.Long]]]) => handler(p))
  }

  def methodWithNullableMapLongReturn(notNull: java.lang.Boolean): scala.Option[Map[String, java.lang.Long]] = {
    scala.Option(asJava.methodWithNullableMapLongReturn(notNull)).flatMap(x => Some(x.asScala.toMap))
  }

  def methodWithNonNullableMapFloatParam(param: Map[String, java.lang.Float]): java.lang.Boolean = {
    asJava.methodWithNonNullableMapFloatParam(param.mapValues(x => x.asInstanceOf[java.lang.Float]).asJava)
  }

  def methodWithNullableMapFloatParam(expectNull: java.lang.Boolean, param: scala.Option[Map[String, java.lang.Float]]): Unit = {
    asJava.methodWithNullableMapFloatParam(expectNull, param.map(x => x.mapValues(x => x.asInstanceOf[java.lang.Float]).asJava).orNull)
  }

  def methodWithNullableMapFloatHandler(notNull: java.lang.Boolean, handler: scala.Option[Map[String, java.lang.Float]] => Unit): Unit = {
    asJava.methodWithNullableMapFloatHandler(notNull, (p:scala.Option[Map[String, java.lang.Float]]) => handler(p))
  }

  def methodWithNullableMapFloatHandlerAsyncResult(notNull: java.lang.Boolean, handler: AsyncResult[scala.Option[Map[String, java.lang.Float]]] => Unit): Unit = {
    asJava.methodWithNullableMapFloatHandlerAsyncResult(notNull, (p:AsyncResult[scala.Option[Map[String, java.lang.Float]]]) => handler(p))
  }

  def methodWithNullableMapFloatReturn(notNull: java.lang.Boolean): scala.Option[Map[String, java.lang.Float]] = {
    scala.Option(asJava.methodWithNullableMapFloatReturn(notNull)).flatMap(x => Some(x.asScala.toMap))
  }

  def methodWithNonNullableMapDoubleParam(param: Map[String, java.lang.Double]): java.lang.Boolean = {
    asJava.methodWithNonNullableMapDoubleParam(param.mapValues(x => x.asInstanceOf[java.lang.Double]).asJava)
  }

  def methodWithNullableMapDoubleParam(expectNull: java.lang.Boolean, param: scala.Option[Map[String, java.lang.Double]]): Unit = {
    asJava.methodWithNullableMapDoubleParam(expectNull, param.map(x => x.mapValues(x => x.asInstanceOf[java.lang.Double]).asJava).orNull)
  }

  def methodWithNullableMapDoubleHandler(notNull: java.lang.Boolean, handler: scala.Option[Map[String, java.lang.Double]] => Unit): Unit = {
    asJava.methodWithNullableMapDoubleHandler(notNull, (p:scala.Option[Map[String, java.lang.Double]]) => handler(p))
  }

  def methodWithNullableMapDoubleHandlerAsyncResult(notNull: java.lang.Boolean, handler: AsyncResult[scala.Option[Map[String, java.lang.Double]]] => Unit): Unit = {
    asJava.methodWithNullableMapDoubleHandlerAsyncResult(notNull, (p:AsyncResult[scala.Option[Map[String, java.lang.Double]]]) => handler(p))
  }

  def methodWithNullableMapDoubleReturn(notNull: java.lang.Boolean): scala.Option[Map[String, java.lang.Double]] = {
    scala.Option(asJava.methodWithNullableMapDoubleReturn(notNull)).flatMap(x => Some(x.asScala.toMap))
  }

  def methodWithNonNullableMapBooleanParam(param: Map[String, java.lang.Boolean]): java.lang.Boolean = {
    asJava.methodWithNonNullableMapBooleanParam(param.mapValues(x => x.asInstanceOf[java.lang.Boolean]).asJava)
  }

  def methodWithNullableMapBooleanParam(expectNull: java.lang.Boolean, param: scala.Option[Map[String, java.lang.Boolean]]): Unit = {
    asJava.methodWithNullableMapBooleanParam(expectNull, param.map(x => x.mapValues(x => x.asInstanceOf[java.lang.Boolean]).asJava).orNull)
  }

  def methodWithNullableMapBooleanHandler(notNull: java.lang.Boolean, handler: scala.Option[Map[String, java.lang.Boolean]] => Unit): Unit = {
    asJava.methodWithNullableMapBooleanHandler(notNull, (p:scala.Option[Map[String, java.lang.Boolean]]) => handler(p))
  }

  def methodWithNullableMapBooleanHandlerAsyncResult(notNull: java.lang.Boolean, handler: AsyncResult[scala.Option[Map[String, java.lang.Boolean]]] => Unit): Unit = {
    asJava.methodWithNullableMapBooleanHandlerAsyncResult(notNull, (p:AsyncResult[scala.Option[Map[String, java.lang.Boolean]]]) => handler(p))
  }

  def methodWithNullableMapBooleanReturn(notNull: java.lang.Boolean): scala.Option[Map[String, java.lang.Boolean]] = {
    scala.Option(asJava.methodWithNullableMapBooleanReturn(notNull)).flatMap(x => Some(x.asScala.toMap))
  }

  def methodWithNonNullableMapStringParam(param: Map[String, String]): java.lang.Boolean = {
    asJava.methodWithNonNullableMapStringParam(param.mapValues(x => x.asInstanceOf[String]).asJava)
  }

  def methodWithNullableMapStringParam(expectNull: java.lang.Boolean, param: scala.Option[Map[String, String]]): Unit = {
    asJava.methodWithNullableMapStringParam(expectNull, param.map(x => x.mapValues(x => x.asInstanceOf[String]).asJava).orNull)
  }

  def methodWithNullableMapStringHandler(notNull: java.lang.Boolean, handler: scala.Option[Map[String, String]] => Unit): Unit = {
    asJava.methodWithNullableMapStringHandler(notNull, (p:scala.Option[Map[String, String]]) => handler(p))
  }

  def methodWithNullableMapStringHandlerAsyncResult(notNull: java.lang.Boolean, handler: AsyncResult[scala.Option[Map[String, String]]] => Unit): Unit = {
    asJava.methodWithNullableMapStringHandlerAsyncResult(notNull, (p:AsyncResult[scala.Option[Map[String, String]]]) => handler(p))
  }

  def methodWithNullableMapStringReturn(notNull: java.lang.Boolean): scala.Option[Map[String, String]] = {
    scala.Option(asJava.methodWithNullableMapStringReturn(notNull)).flatMap(x => Some(x.asScala.toMap))
  }

  def methodWithNonNullableMapCharParam(param: Map[String, java.lang.Character]): java.lang.Boolean = {
    asJava.methodWithNonNullableMapCharParam(param.mapValues(x => x.asInstanceOf[java.lang.Character]).asJava)
  }

  def methodWithNullableMapCharParam(expectNull: java.lang.Boolean, param: scala.Option[Map[String, java.lang.Character]]): Unit = {
    asJava.methodWithNullableMapCharParam(expectNull, param.map(x => x.mapValues(x => x.asInstanceOf[java.lang.Character]).asJava).orNull)
  }

  def methodWithNullableMapCharHandler(notNull: java.lang.Boolean, handler: scala.Option[Map[String, java.lang.Character]] => Unit): Unit = {
    asJava.methodWithNullableMapCharHandler(notNull, (p:scala.Option[Map[String, java.lang.Character]]) => handler(p))
  }

  def methodWithNullableMapCharHandlerAsyncResult(notNull: java.lang.Boolean, handler: AsyncResult[scala.Option[Map[String, java.lang.Character]]] => Unit): Unit = {
    asJava.methodWithNullableMapCharHandlerAsyncResult(notNull, (p:AsyncResult[scala.Option[Map[String, java.lang.Character]]]) => handler(p))
  }

  def methodWithNullableMapCharReturn(notNull: java.lang.Boolean): scala.Option[Map[String, java.lang.Character]] = {
    scala.Option(asJava.methodWithNullableMapCharReturn(notNull)).flatMap(x => Some(x.asScala.toMap))
  }

  def methodWithNonNullableMapJsonObjectParam(param: Map[String, io.vertx.core.json.JsonObject]): java.lang.Boolean = {
    asJava.methodWithNonNullableMapJsonObjectParam(param.asJava)
  }

  def methodWithNullableMapJsonObjectParam(expectNull: java.lang.Boolean, param: scala.Option[Map[String, io.vertx.core.json.JsonObject]]): Unit = {
    asJava.methodWithNullableMapJsonObjectParam(expectNull, param.map(x => x.asJava).orNull)
  }

  def methodWithNullableMapJsonObjectHandler(notNull: java.lang.Boolean, handler: scala.Option[Map[String, io.vertx.core.json.JsonObject]] => Unit): Unit = {
    asJava.methodWithNullableMapJsonObjectHandler(notNull, (p:scala.Option[Map[String, io.vertx.core.json.JsonObject]]) => handler(p))
  }

  def methodWithNullableMapJsonObjectHandlerAsyncResult(notNull: java.lang.Boolean, handler: AsyncResult[scala.Option[Map[String, io.vertx.core.json.JsonObject]]] => Unit): Unit = {
    asJava.methodWithNullableMapJsonObjectHandlerAsyncResult(notNull, (p:AsyncResult[scala.Option[Map[String, io.vertx.core.json.JsonObject]]]) => handler(p))
  }

  def methodWithNullableMapJsonObjectReturn(notNull: java.lang.Boolean): scala.Option[Map[String, io.vertx.core.json.JsonObject]] = {
    scala.Option(asJava.methodWithNullableMapJsonObjectReturn(notNull)).flatMap(x => Some(x.asScala.toMap))
  }

  def methodWithNonNullableMapJsonArrayParam(param: Map[String, io.vertx.core.json.JsonArray]): java.lang.Boolean = {
    asJava.methodWithNonNullableMapJsonArrayParam(param.asJava)
  }

  def methodWithNullableMapJsonArrayParam(expectNull: java.lang.Boolean, param: scala.Option[Map[String, io.vertx.core.json.JsonArray]]): Unit = {
    asJava.methodWithNullableMapJsonArrayParam(expectNull, param.map(x => x.asJava).orNull)
  }

  def methodWithNullableMapJsonArrayHandler(notNull: java.lang.Boolean, handler: scala.Option[Map[String, io.vertx.core.json.JsonArray]] => Unit): Unit = {
    asJava.methodWithNullableMapJsonArrayHandler(notNull, (p:scala.Option[Map[String, io.vertx.core.json.JsonArray]]) => handler(p))
  }

  def methodWithNullableMapJsonArrayHandlerAsyncResult(notNull: java.lang.Boolean, handler: AsyncResult[scala.Option[Map[String, io.vertx.core.json.JsonArray]]] => Unit): Unit = {
    asJava.methodWithNullableMapJsonArrayHandlerAsyncResult(notNull, (p:AsyncResult[scala.Option[Map[String, io.vertx.core.json.JsonArray]]]) => handler(p))
  }

  def methodWithNullableMapJsonArrayReturn(notNull: java.lang.Boolean): scala.Option[Map[String, io.vertx.core.json.JsonArray]] = {
    scala.Option(asJava.methodWithNullableMapJsonArrayReturn(notNull)).flatMap(x => Some(x.asScala.toMap))
  }

  def methodWithNonNullableMapApiParam(param: Map[String, JRefedInterface1]): java.lang.Boolean = {
    asJava.methodWithNonNullableMapApiParam(param.asJava)
  }

  def methodWithNullableMapApiParam(expectNull: java.lang.Boolean, param: scala.Option[Map[String, JRefedInterface1]]): Unit = {
    asJava.methodWithNullableMapApiParam(expectNull, param.map(x => x.asJava).orNull)
  }

  def methodWithListNullableByteParam(param: List[scala.Option[java.lang.Byte]]): Unit = {
    asJava.methodWithListNullableByteParam(param.map({case Some(x) => x.asInstanceOf[java.lang.Byte]; case None => null}).asJava)
  }

  def methodWithListNullableByteHandler(handler: List[scala.Option[java.lang.Byte]] => Unit): Unit = {
    asJava.methodWithListNullableByteHandler((p:List[scala.Option[java.lang.Byte]]) => handler(p))
  }

  def methodWithListNullableByteHandlerAsyncResult(handler: AsyncResult[List[scala.Option[java.lang.Byte]]] => Unit): Unit = {
    asJava.methodWithListNullableByteHandlerAsyncResult((p:AsyncResult[List[scala.Option[java.lang.Byte]]]) => handler(p))
  }

  def methodWithListNullableByteReturn(): List[scala.Option[java.lang.Byte]] = {
    asJava.methodWithListNullableByteReturn().asScala.map(x => Option(x)).toList
  }

  def methodWithListNullableShortParam(param: List[scala.Option[java.lang.Short]]): Unit = {
    asJava.methodWithListNullableShortParam(param.map({case Some(x) => x.asInstanceOf[java.lang.Short]; case None => null}).asJava)
  }

  def methodWithListNullableShortHandler(handler: List[scala.Option[java.lang.Short]] => Unit): Unit = {
    asJava.methodWithListNullableShortHandler((p:List[scala.Option[java.lang.Short]]) => handler(p))
  }

  def methodWithListNullableShortHandlerAsyncResult(handler: AsyncResult[List[scala.Option[java.lang.Short]]] => Unit): Unit = {
    asJava.methodWithListNullableShortHandlerAsyncResult((p:AsyncResult[List[scala.Option[java.lang.Short]]]) => handler(p))
  }

  def methodWithListNullableShortReturn(): List[scala.Option[java.lang.Short]] = {
    asJava.methodWithListNullableShortReturn().asScala.map(x => Option(x)).toList
  }

  def methodWithListNullableIntegerParam(param: List[scala.Option[java.lang.Integer]]): Unit = {
    asJava.methodWithListNullableIntegerParam(param.map({case Some(x) => x.asInstanceOf[java.lang.Integer]; case None => null}).asJava)
  }

  def methodWithListNullableIntegerHandler(handler: List[scala.Option[java.lang.Integer]] => Unit): Unit = {
    asJava.methodWithListNullableIntegerHandler((p:List[scala.Option[java.lang.Integer]]) => handler(p))
  }

  def methodWithListNullableIntegerHandlerAsyncResult(handler: AsyncResult[List[scala.Option[java.lang.Integer]]] => Unit): Unit = {
    asJava.methodWithListNullableIntegerHandlerAsyncResult((p:AsyncResult[List[scala.Option[java.lang.Integer]]]) => handler(p))
  }

  def methodWithListNullableIntegerReturn(): List[scala.Option[java.lang.Integer]] = {
    asJava.methodWithListNullableIntegerReturn().asScala.map(x => Option(x)).toList
  }

  def methodWithListNullableLongParam(param: List[scala.Option[java.lang.Long]]): Unit = {
    asJava.methodWithListNullableLongParam(param.map({case Some(x) => x.asInstanceOf[java.lang.Long]; case None => null}).asJava)
  }

  def methodWithListNullableLongHandler(handler: List[scala.Option[java.lang.Long]] => Unit): Unit = {
    asJava.methodWithListNullableLongHandler((p:List[scala.Option[java.lang.Long]]) => handler(p))
  }

  def methodWithListNullableLongHandlerAsyncResult(handler: AsyncResult[List[scala.Option[java.lang.Long]]] => Unit): Unit = {
    asJava.methodWithListNullableLongHandlerAsyncResult((p:AsyncResult[List[scala.Option[java.lang.Long]]]) => handler(p))
  }

  def methodWithListNullableLongReturn(): List[scala.Option[java.lang.Long]] = {
    asJava.methodWithListNullableLongReturn().asScala.map(x => Option(x)).toList
  }

  def methodWithListNullableBooleanParam(param: List[scala.Option[java.lang.Boolean]]): Unit = {
    asJava.methodWithListNullableBooleanParam(param.map({case Some(x) => x.asInstanceOf[java.lang.Boolean]; case None => null}).asJava)
  }

  def methodWithListNullableBooleanHandler(handler: List[scala.Option[java.lang.Boolean]] => Unit): Unit = {
    asJava.methodWithListNullableBooleanHandler((p:List[scala.Option[java.lang.Boolean]]) => handler(p))
  }

  def methodWithListNullableBooleanHandlerAsyncResult(handler: AsyncResult[List[scala.Option[java.lang.Boolean]]] => Unit): Unit = {
    asJava.methodWithListNullableBooleanHandlerAsyncResult((p:AsyncResult[List[scala.Option[java.lang.Boolean]]]) => handler(p))
  }

  def methodWithListNullableBooleanReturn(): List[scala.Option[java.lang.Boolean]] = {
    asJava.methodWithListNullableBooleanReturn().asScala.map(x => Option(x)).toList
  }

  def methodWithListNullableFloatParam(param: List[scala.Option[java.lang.Float]]): Unit = {
    asJava.methodWithListNullableFloatParam(param.map({case Some(x) => x.asInstanceOf[java.lang.Float]; case None => null}).asJava)
  }

  def methodWithListNullableFloatHandler(handler: List[scala.Option[java.lang.Float]] => Unit): Unit = {
    asJava.methodWithListNullableFloatHandler((p:List[scala.Option[java.lang.Float]]) => handler(p))
  }

  def methodWithListNullableFloatHandlerAsyncResult(handler: AsyncResult[List[scala.Option[java.lang.Float]]] => Unit): Unit = {
    asJava.methodWithListNullableFloatHandlerAsyncResult((p:AsyncResult[List[scala.Option[java.lang.Float]]]) => handler(p))
  }

  def methodWithListNullableFloatReturn(): List[scala.Option[java.lang.Float]] = {
    asJava.methodWithListNullableFloatReturn().asScala.map(x => Option(x)).toList
  }

  def methodWithListNullableDoubleParam(param: List[scala.Option[java.lang.Double]]): Unit = {
    asJava.methodWithListNullableDoubleParam(param.map({case Some(x) => x.asInstanceOf[java.lang.Double]; case None => null}).asJava)
  }

  def methodWithListNullableDoubleHandler(handler: List[scala.Option[java.lang.Double]] => Unit): Unit = {
    asJava.methodWithListNullableDoubleHandler((p:List[scala.Option[java.lang.Double]]) => handler(p))
  }

  def methodWithListNullableDoubleHandlerAsyncResult(handler: AsyncResult[List[scala.Option[java.lang.Double]]] => Unit): Unit = {
    asJava.methodWithListNullableDoubleHandlerAsyncResult((p:AsyncResult[List[scala.Option[java.lang.Double]]]) => handler(p))
  }

  def methodWithListNullableDoubleReturn(): List[scala.Option[java.lang.Double]] = {
    asJava.methodWithListNullableDoubleReturn().asScala.map(x => Option(x)).toList
  }

  def methodWithListNullableStringParam(param: List[scala.Option[String]]): Unit = {
    asJava.methodWithListNullableStringParam(param.map({case Some(x) => x.asInstanceOf[String]; case None => null}).asJava)
  }

  def methodWithListNullableStringHandler(handler: List[scala.Option[String]] => Unit): Unit = {
    asJava.methodWithListNullableStringHandler((p:List[scala.Option[String]]) => handler(p))
  }

  def methodWithListNullableStringHandlerAsyncResult(handler: AsyncResult[List[scala.Option[String]]] => Unit): Unit = {
    asJava.methodWithListNullableStringHandlerAsyncResult((p:AsyncResult[List[scala.Option[String]]]) => handler(p))
  }

  def methodWithListNullableStringReturn(): List[scala.Option[String]] = {
    asJava.methodWithListNullableStringReturn().asScala.map(x => Option(x)).toList
  }

  def methodWithListNullableCharParam(param: List[scala.Option[java.lang.Character]]): Unit = {
    asJava.methodWithListNullableCharParam(param.map({case Some(x) => x.asInstanceOf[java.lang.Character]; case None => null}).asJava)
  }

  def methodWithListNullableCharHandler(handler: List[scala.Option[java.lang.Character]] => Unit): Unit = {
    asJava.methodWithListNullableCharHandler((p:List[scala.Option[java.lang.Character]]) => handler(p))
  }

  def methodWithListNullableCharHandlerAsyncResult(handler: AsyncResult[List[scala.Option[java.lang.Character]]] => Unit): Unit = {
    asJava.methodWithListNullableCharHandlerAsyncResult((p:AsyncResult[List[scala.Option[java.lang.Character]]]) => handler(p))
  }

  def methodWithListNullableCharReturn(): List[scala.Option[java.lang.Character]] = {
    asJava.methodWithListNullableCharReturn().asScala.map(x => Option(x)).toList
  }

  def methodWithListNullableJsonObjectParam(param: List[scala.Option[io.vertx.core.json.JsonObject]]): Unit = {
    asJava.methodWithListNullableJsonObjectParam(param.map(x => x.orNull).asJava)
  }

  def methodWithListNullableJsonObjectHandler(handler: List[scala.Option[io.vertx.core.json.JsonObject]] => Unit): Unit = {
    asJava.methodWithListNullableJsonObjectHandler((p:List[scala.Option[io.vertx.core.json.JsonObject]]) => handler(p))
  }

  def methodWithListNullableJsonObjectHandlerAsyncResult(handler: AsyncResult[List[scala.Option[io.vertx.core.json.JsonObject]]] => Unit): Unit = {
    asJava.methodWithListNullableJsonObjectHandlerAsyncResult((p:AsyncResult[List[scala.Option[io.vertx.core.json.JsonObject]]]) => handler(p))
  }

  def methodWithListNullableJsonObjectReturn(): List[scala.Option[io.vertx.core.json.JsonObject]] = {
    asJava.methodWithListNullableJsonObjectReturn().asScala.map(x => Option(x)).toList
  }

  def methodWithListNullableJsonArrayParam(param: List[scala.Option[io.vertx.core.json.JsonArray]]): Unit = {
    asJava.methodWithListNullableJsonArrayParam(param.map(x => x.orNull).asJava)
  }

  def methodWithListNullableJsonArrayHandler(handler: List[scala.Option[io.vertx.core.json.JsonArray]] => Unit): Unit = {
    asJava.methodWithListNullableJsonArrayHandler((p:List[scala.Option[io.vertx.core.json.JsonArray]]) => handler(p))
  }

  def methodWithListNullableJsonArrayHandlerAsyncResult(handler: AsyncResult[List[scala.Option[io.vertx.core.json.JsonArray]]] => Unit): Unit = {
    asJava.methodWithListNullableJsonArrayHandlerAsyncResult((p:AsyncResult[List[scala.Option[io.vertx.core.json.JsonArray]]]) => handler(p))
  }

  def methodWithListNullableJsonArrayReturn(): List[scala.Option[io.vertx.core.json.JsonArray]] = {
    asJava.methodWithListNullableJsonArrayReturn().asScala.map(x => Option(x)).toList
  }

  def methodWithListNullableApiParam(param: List[scala.Option[JRefedInterface1]]): Unit = {
    asJava.methodWithListNullableApiParam(param.map(x => x.orNull).asJava)
  }

  def methodWithListNullableApiHandler(handler: List[scala.Option[JRefedInterface1]] => Unit): Unit = {
    asJava.methodWithListNullableApiHandler((p:List[scala.Option[JRefedInterface1]]) => handler(p))
  }

  def methodWithListNullableApiHandlerAsyncResult(handler: AsyncResult[List[scala.Option[JRefedInterface1]]] => Unit): Unit = {
    asJava.methodWithListNullableApiHandlerAsyncResult((p:AsyncResult[List[scala.Option[JRefedInterface1]]]) => handler(p))
  }

  def methodWithListNullableApiReturn(): List[scala.Option[JRefedInterface1]] = {
    asJava.methodWithListNullableApiReturn().asScala.map(x => Option(x)).toList
  }

  def methodWithListNullableDataObjectParam(param: List[scala.Option[JTestDataObject]]): Unit = {
    asJava.methodWithListNullableDataObjectParam(param.map(x => x.orNull).asJava)
  }

  def methodWithListNullableDataObjectHandler(handler: List[scala.Option[JTestDataObject]] => Unit): Unit = {
    asJava.methodWithListNullableDataObjectHandler((p:List[scala.Option[JTestDataObject]]) => handler(p))
  }

  def methodWithListNullableDataObjectHandlerAsyncResult(handler: AsyncResult[List[scala.Option[JTestDataObject]]] => Unit): Unit = {
    asJava.methodWithListNullableDataObjectHandlerAsyncResult((p:AsyncResult[List[scala.Option[JTestDataObject]]]) => handler(p))
  }

  def methodWithListNullableDataObjectReturn(): List[scala.Option[JTestDataObject]] = {
    asJava.methodWithListNullableDataObjectReturn().asScala.map(x => Option(x)).toList
  }

  def methodWithListNullableEnumParam(param: List[scala.Option[io.vertx.codegen.testmodel.TestEnum]]): Unit = {
    asJava.methodWithListNullableEnumParam(param.map(x => x.orNull).asJava)
  }

  def methodWithListNullableEnumHandler(handler: List[scala.Option[io.vertx.codegen.testmodel.TestEnum]] => Unit): Unit = {
    asJava.methodWithListNullableEnumHandler((p:List[scala.Option[io.vertx.codegen.testmodel.TestEnum]]) => handler(p))
  }

  def methodWithListNullableEnumHandlerAsyncResult(handler: AsyncResult[List[scala.Option[io.vertx.codegen.testmodel.TestEnum]]] => Unit): Unit = {
    asJava.methodWithListNullableEnumHandlerAsyncResult((p:AsyncResult[List[scala.Option[io.vertx.codegen.testmodel.TestEnum]]]) => handler(p))
  }

  def methodWithListNullableEnumReturn(): List[scala.Option[io.vertx.codegen.testmodel.TestEnum]] = {
    asJava.methodWithListNullableEnumReturn().asScala.map(x => Option(x)).toList
  }

  def methodWithListNullableGenEnumParam(param: List[scala.Option[io.vertx.codegen.testmodel.TestGenEnum]]): Unit = {
    asJava.methodWithListNullableGenEnumParam(param.map(x => x.orNull).asJava)
  }

  def methodWithListNullableGenEnumHandler(handler: List[scala.Option[io.vertx.codegen.testmodel.TestGenEnum]] => Unit): Unit = {
    asJava.methodWithListNullableGenEnumHandler((p:List[scala.Option[io.vertx.codegen.testmodel.TestGenEnum]]) => handler(p))
  }

  def methodWithListNullableGenEnumHandlerAsyncResult(handler: AsyncResult[List[scala.Option[io.vertx.codegen.testmodel.TestGenEnum]]] => Unit): Unit = {
    asJava.methodWithListNullableGenEnumHandlerAsyncResult((p:AsyncResult[List[scala.Option[io.vertx.codegen.testmodel.TestGenEnum]]]) => handler(p))
  }

  def methodWithListNullableGenEnumReturn(): List[scala.Option[io.vertx.codegen.testmodel.TestGenEnum]] = {
    asJava.methodWithListNullableGenEnumReturn().asScala.map(x => Option(x)).toList
  }

  def methodWithSetNullableByteParam(param: Set[scala.Option[java.lang.Byte]]): Unit = {
    asJava.methodWithSetNullableByteParam(param.map({case Some(x) => x.asInstanceOf[java.lang.Byte]; case None => null}).asJava)
  }

  def methodWithSetNullableByteHandler(handler: Set[scala.Option[java.lang.Byte]] => Unit): Unit = {
    asJava.methodWithSetNullableByteHandler((p:Set[scala.Option[java.lang.Byte]]) => handler(p))
  }

  def methodWithSetNullableByteHandlerAsyncResult(handler: AsyncResult[Set[scala.Option[java.lang.Byte]]] => Unit): Unit = {
    asJava.methodWithSetNullableByteHandlerAsyncResult((p:AsyncResult[Set[scala.Option[java.lang.Byte]]]) => handler(p))
  }

  def methodWithSetNullableByteReturn(): Seq[scala.Option[java.lang.Byte]] = {
    asJava.methodWithSetNullableByteReturn().asScala.map(x => Option(x)).toSeq
  }

  def methodWithSetNullableShortParam(param: Set[scala.Option[java.lang.Short]]): Unit = {
    asJava.methodWithSetNullableShortParam(param.map({case Some(x) => x.asInstanceOf[java.lang.Short]; case None => null}).asJava)
  }

  def methodWithSetNullableShortHandler(handler: Set[scala.Option[java.lang.Short]] => Unit): Unit = {
    asJava.methodWithSetNullableShortHandler((p:Set[scala.Option[java.lang.Short]]) => handler(p))
  }

  def methodWithSetNullableShortHandlerAsyncResult(handler: AsyncResult[Set[scala.Option[java.lang.Short]]] => Unit): Unit = {
    asJava.methodWithSetNullableShortHandlerAsyncResult((p:AsyncResult[Set[scala.Option[java.lang.Short]]]) => handler(p))
  }

  def methodWithSetNullableShortReturn(): Seq[scala.Option[java.lang.Short]] = {
    asJava.methodWithSetNullableShortReturn().asScala.map(x => Option(x)).toSeq
  }

  def methodWithSetNullableIntegerParam(param: Set[scala.Option[java.lang.Integer]]): Unit = {
    asJava.methodWithSetNullableIntegerParam(param.map({case Some(x) => x.asInstanceOf[java.lang.Integer]; case None => null}).asJava)
  }

  def methodWithSetNullableIntegerHandler(handler: Set[scala.Option[java.lang.Integer]] => Unit): Unit = {
    asJava.methodWithSetNullableIntegerHandler((p:Set[scala.Option[java.lang.Integer]]) => handler(p))
  }

  def methodWithSetNullableIntegerHandlerAsyncResult(handler: AsyncResult[Set[scala.Option[java.lang.Integer]]] => Unit): Unit = {
    asJava.methodWithSetNullableIntegerHandlerAsyncResult((p:AsyncResult[Set[scala.Option[java.lang.Integer]]]) => handler(p))
  }

  def methodWithSetNullableIntegerReturn(): Seq[scala.Option[java.lang.Integer]] = {
    asJava.methodWithSetNullableIntegerReturn().asScala.map(x => Option(x)).toSeq
  }

  def methodWithSetNullableLongParam(param: Set[scala.Option[java.lang.Long]]): Unit = {
    asJava.methodWithSetNullableLongParam(param.map({case Some(x) => x.asInstanceOf[java.lang.Long]; case None => null}).asJava)
  }

  def methodWithSetNullableLongHandler(handler: Set[scala.Option[java.lang.Long]] => Unit): Unit = {
    asJava.methodWithSetNullableLongHandler((p:Set[scala.Option[java.lang.Long]]) => handler(p))
  }

  def methodWithSetNullableLongHandlerAsyncResult(handler: AsyncResult[Set[scala.Option[java.lang.Long]]] => Unit): Unit = {
    asJava.methodWithSetNullableLongHandlerAsyncResult((p:AsyncResult[Set[scala.Option[java.lang.Long]]]) => handler(p))
  }

  def methodWithSetNullableLongReturn(): Seq[scala.Option[java.lang.Long]] = {
    asJava.methodWithSetNullableLongReturn().asScala.map(x => Option(x)).toSeq
  }

  def methodWithSetNullableBooleanParam(param: Set[scala.Option[java.lang.Boolean]]): Unit = {
    asJava.methodWithSetNullableBooleanParam(param.map({case Some(x) => x.asInstanceOf[java.lang.Boolean]; case None => null}).asJava)
  }

  def methodWithSetNullableBooleanHandler(handler: Set[scala.Option[java.lang.Boolean]] => Unit): Unit = {
    asJava.methodWithSetNullableBooleanHandler((p:Set[scala.Option[java.lang.Boolean]]) => handler(p))
  }

  def methodWithSetNullableBooleanHandlerAsyncResult(handler: AsyncResult[Set[scala.Option[java.lang.Boolean]]] => Unit): Unit = {
    asJava.methodWithSetNullableBooleanHandlerAsyncResult((p:AsyncResult[Set[scala.Option[java.lang.Boolean]]]) => handler(p))
  }

  def methodWithSetNullableBooleanReturn(): Seq[scala.Option[java.lang.Boolean]] = {
    asJava.methodWithSetNullableBooleanReturn().asScala.map(x => Option(x)).toSeq
  }

  def methodWithSetNullableFloatParam(param: Set[scala.Option[java.lang.Float]]): Unit = {
    asJava.methodWithSetNullableFloatParam(param.map({case Some(x) => x.asInstanceOf[java.lang.Float]; case None => null}).asJava)
  }

  def methodWithSetNullableFloatHandler(handler: Set[scala.Option[java.lang.Float]] => Unit): Unit = {
    asJava.methodWithSetNullableFloatHandler((p:Set[scala.Option[java.lang.Float]]) => handler(p))
  }

  def methodWithSetNullableFloatHandlerAsyncResult(handler: AsyncResult[Set[scala.Option[java.lang.Float]]] => Unit): Unit = {
    asJava.methodWithSetNullableFloatHandlerAsyncResult((p:AsyncResult[Set[scala.Option[java.lang.Float]]]) => handler(p))
  }

  def methodWithSetNullableFloatReturn(): Seq[scala.Option[java.lang.Float]] = {
    asJava.methodWithSetNullableFloatReturn().asScala.map(x => Option(x)).toSeq
  }

  def methodWithSetNullableDoubleParam(param: Set[scala.Option[java.lang.Double]]): Unit = {
    asJava.methodWithSetNullableDoubleParam(param.map({case Some(x) => x.asInstanceOf[java.lang.Double]; case None => null}).asJava)
  }

  def methodWithSetNullableDoubleHandler(handler: Set[scala.Option[java.lang.Double]] => Unit): Unit = {
    asJava.methodWithSetNullableDoubleHandler((p:Set[scala.Option[java.lang.Double]]) => handler(p))
  }

  def methodWithSetNullableDoubleHandlerAsyncResult(handler: AsyncResult[Set[scala.Option[java.lang.Double]]] => Unit): Unit = {
    asJava.methodWithSetNullableDoubleHandlerAsyncResult((p:AsyncResult[Set[scala.Option[java.lang.Double]]]) => handler(p))
  }

  def methodWithSetNullableDoubleReturn(): Seq[scala.Option[java.lang.Double]] = {
    asJava.methodWithSetNullableDoubleReturn().asScala.map(x => Option(x)).toSeq
  }

  def methodWithSetNullableStringParam(param: Set[scala.Option[String]]): Unit = {
    asJava.methodWithSetNullableStringParam(param.map({case Some(x) => x.asInstanceOf[String]; case None => null}).asJava)
  }

  def methodWithSetNullableStringHandler(handler: Set[scala.Option[String]] => Unit): Unit = {
    asJava.methodWithSetNullableStringHandler((p:Set[scala.Option[String]]) => handler(p))
  }

  def methodWithSetNullableStringHandlerAsyncResult(handler: AsyncResult[Set[scala.Option[String]]] => Unit): Unit = {
    asJava.methodWithSetNullableStringHandlerAsyncResult((p:AsyncResult[Set[scala.Option[String]]]) => handler(p))
  }

  def methodWithSetNullableStringReturn(): Seq[scala.Option[String]] = {
    asJava.methodWithSetNullableStringReturn().asScala.map(x => Option(x)).toSeq
  }

  def methodWithSetNullableCharParam(param: Set[scala.Option[java.lang.Character]]): Unit = {
    asJava.methodWithSetNullableCharParam(param.map({case Some(x) => x.asInstanceOf[java.lang.Character]; case None => null}).asJava)
  }

  def methodWithSetNullableCharHandler(handler: Set[scala.Option[java.lang.Character]] => Unit): Unit = {
    asJava.methodWithSetNullableCharHandler((p:Set[scala.Option[java.lang.Character]]) => handler(p))
  }

  def methodWithSetNullableCharHandlerAsyncResult(handler: AsyncResult[Set[scala.Option[java.lang.Character]]] => Unit): Unit = {
    asJava.methodWithSetNullableCharHandlerAsyncResult((p:AsyncResult[Set[scala.Option[java.lang.Character]]]) => handler(p))
  }

  def methodWithSetNullableCharReturn(): Seq[scala.Option[java.lang.Character]] = {
    asJava.methodWithSetNullableCharReturn().asScala.map(x => Option(x)).toSeq
  }

  def methodWithSetNullableJsonObjectParam(param: Set[scala.Option[io.vertx.core.json.JsonObject]]): Unit = {
    asJava.methodWithSetNullableJsonObjectParam(param.map(x => x.orNull).asJava)
  }

  def methodWithSetNullableJsonObjectHandler(handler: Set[scala.Option[io.vertx.core.json.JsonObject]] => Unit): Unit = {
    asJava.methodWithSetNullableJsonObjectHandler((p:Set[scala.Option[io.vertx.core.json.JsonObject]]) => handler(p))
  }

  def methodWithSetNullableJsonObjectHandlerAsyncResult(handler: AsyncResult[Set[scala.Option[io.vertx.core.json.JsonObject]]] => Unit): Unit = {
    asJava.methodWithSetNullableJsonObjectHandlerAsyncResult((p:AsyncResult[Set[scala.Option[io.vertx.core.json.JsonObject]]]) => handler(p))
  }

  def methodWithSetNullableJsonObjectReturn(): Seq[scala.Option[io.vertx.core.json.JsonObject]] = {
    asJava.methodWithSetNullableJsonObjectReturn().asScala.map(x => Option(x)).toSeq
  }

  def methodWithSetNullableJsonArrayParam(param: Set[scala.Option[io.vertx.core.json.JsonArray]]): Unit = {
    asJava.methodWithSetNullableJsonArrayParam(param.map(x => x.orNull).asJava)
  }

  def methodWithSetNullableJsonArrayHandler(handler: Set[scala.Option[io.vertx.core.json.JsonArray]] => Unit): Unit = {
    asJava.methodWithSetNullableJsonArrayHandler((p:Set[scala.Option[io.vertx.core.json.JsonArray]]) => handler(p))
  }

  def methodWithSetNullableJsonArrayHandlerAsyncResult(handler: AsyncResult[Set[scala.Option[io.vertx.core.json.JsonArray]]] => Unit): Unit = {
    asJava.methodWithSetNullableJsonArrayHandlerAsyncResult((p:AsyncResult[Set[scala.Option[io.vertx.core.json.JsonArray]]]) => handler(p))
  }

  def methodWithSetNullableJsonArrayReturn(): Seq[scala.Option[io.vertx.core.json.JsonArray]] = {
    asJava.methodWithSetNullableJsonArrayReturn().asScala.map(x => Option(x)).toSeq
  }

  def methodWithSetNullableApiParam(param: Set[scala.Option[JRefedInterface1]]): Unit = {
    asJava.methodWithSetNullableApiParam(param.map(x => x.orNull).asJava)
  }

  def methodWithSetNullableApiHandler(handler: Set[scala.Option[JRefedInterface1]] => Unit): Unit = {
    asJava.methodWithSetNullableApiHandler((p:Set[scala.Option[JRefedInterface1]]) => handler(p))
  }

  def methodWithSetNullableApiHandlerAsyncResult(handler: AsyncResult[Set[scala.Option[JRefedInterface1]]] => Unit): Unit = {
    asJava.methodWithSetNullableApiHandlerAsyncResult((p:AsyncResult[Set[scala.Option[JRefedInterface1]]]) => handler(p))
  }

  def methodWithSetNullableApiReturn(): Seq[scala.Option[JRefedInterface1]] = {
    asJava.methodWithSetNullableApiReturn().asScala.map(x => Option(x)).toSeq
  }

  def methodWithSetNullableDataObjectParam(param: Set[scala.Option[JTestDataObject]]): Unit = {
    asJava.methodWithSetNullableDataObjectParam(param.map(x => x.orNull).asJava)
  }

  def methodWithSetNullableDataObjectHandler(handler: Set[scala.Option[JTestDataObject]] => Unit): Unit = {
    asJava.methodWithSetNullableDataObjectHandler((p:Set[scala.Option[JTestDataObject]]) => handler(p))
  }

  def methodWithSetNullableDataObjectHandlerAsyncResult(handler: AsyncResult[Set[scala.Option[JTestDataObject]]] => Unit): Unit = {
    asJava.methodWithSetNullableDataObjectHandlerAsyncResult((p:AsyncResult[Set[scala.Option[JTestDataObject]]]) => handler(p))
  }

  def methodWithSetNullableDataObjectReturn(): Seq[scala.Option[JTestDataObject]] = {
    asJava.methodWithSetNullableDataObjectReturn().asScala.map(x => Option(x)).toSeq
  }

  def methodWithSetNullableEnumParam(param: Set[scala.Option[io.vertx.codegen.testmodel.TestEnum]]): Unit = {
    asJava.methodWithSetNullableEnumParam(param.map(x => x.orNull).asJava)
  }

  def methodWithSetNullableEnumHandler(handler: Set[scala.Option[io.vertx.codegen.testmodel.TestEnum]] => Unit): Unit = {
    asJava.methodWithSetNullableEnumHandler((p:Set[scala.Option[io.vertx.codegen.testmodel.TestEnum]]) => handler(p))
  }

  def methodWithSetNullableEnumHandlerAsyncResult(handler: AsyncResult[Set[scala.Option[io.vertx.codegen.testmodel.TestEnum]]] => Unit): Unit = {
    asJava.methodWithSetNullableEnumHandlerAsyncResult((p:AsyncResult[Set[scala.Option[io.vertx.codegen.testmodel.TestEnum]]]) => handler(p))
  }

  def methodWithSetNullableEnumReturn(): Seq[scala.Option[io.vertx.codegen.testmodel.TestEnum]] = {
    asJava.methodWithSetNullableEnumReturn().asScala.map(x => Option(x)).toSeq
  }

  def methodWithSetNullableGenEnumParam(param: Set[scala.Option[io.vertx.codegen.testmodel.TestGenEnum]]): Unit = {
    asJava.methodWithSetNullableGenEnumParam(param.map(x => x.orNull).asJava)
  }

  def methodWithSetNullableGenEnumHandler(handler: Set[scala.Option[io.vertx.codegen.testmodel.TestGenEnum]] => Unit): Unit = {
    asJava.methodWithSetNullableGenEnumHandler((p:Set[scala.Option[io.vertx.codegen.testmodel.TestGenEnum]]) => handler(p))
  }

  def methodWithSetNullableGenEnumHandlerAsyncResult(handler: AsyncResult[Set[scala.Option[io.vertx.codegen.testmodel.TestGenEnum]]] => Unit): Unit = {
    asJava.methodWithSetNullableGenEnumHandlerAsyncResult((p:AsyncResult[Set[scala.Option[io.vertx.codegen.testmodel.TestGenEnum]]]) => handler(p))
  }

  def methodWithSetNullableGenEnumReturn(): Seq[scala.Option[io.vertx.codegen.testmodel.TestGenEnum]] = {
    asJava.methodWithSetNullableGenEnumReturn().asScala.map(x => Option(x)).toSeq
  }

  def methodWithMapNullableByteParam(param: Map[String, scala.Option[java.lang.Byte]]): Unit = {
    asJava.methodWithMapNullableByteParam(param.mapValues({case Some(x) => x.asInstanceOf[java.lang.Byte]; case None => null}).asJava)
  }

  def methodWithMapNullableByteHandler(handler: Map[String, scala.Option[java.lang.Byte]] => Unit): Unit = {
    asJava.methodWithMapNullableByteHandler((p:Map[String, scala.Option[java.lang.Byte]]) => handler(p))
  }

  def methodWithMapNullableByteHandlerAsyncResult(handler: AsyncResult[Map[String, scala.Option[java.lang.Byte]]] => Unit): Unit = {
    asJava.methodWithMapNullableByteHandlerAsyncResult((p:AsyncResult[Map[String, scala.Option[java.lang.Byte]]]) => handler(p))
  }

  def methodWithMapNullableByteReturn(): Map[String, scala.Option[java.lang.Byte]] = {
    asJava.methodWithMapNullableByteReturn().asScala.mapValues(x => Option(x)).toMap
  }

  def methodWithMapNullableShortParam(param: Map[String, scala.Option[java.lang.Short]]): Unit = {
    asJava.methodWithMapNullableShortParam(param.mapValues({case Some(x) => x.asInstanceOf[java.lang.Short]; case None => null}).asJava)
  }

  def methodWithMapNullableShortHandler(handler: Map[String, scala.Option[java.lang.Short]] => Unit): Unit = {
    asJava.methodWithMapNullableShortHandler((p:Map[String, scala.Option[java.lang.Short]]) => handler(p))
  }

  def methodWithMapNullableShortHandlerAsyncResult(handler: AsyncResult[Map[String, scala.Option[java.lang.Short]]] => Unit): Unit = {
    asJava.methodWithMapNullableShortHandlerAsyncResult((p:AsyncResult[Map[String, scala.Option[java.lang.Short]]]) => handler(p))
  }

  def methodWithMapNullableShortReturn(): Map[String, scala.Option[java.lang.Short]] = {
    asJava.methodWithMapNullableShortReturn().asScala.mapValues(x => Option(x)).toMap
  }

  def methodWithMapNullableIntegerParam(param: Map[String, scala.Option[java.lang.Integer]]): Unit = {
    asJava.methodWithMapNullableIntegerParam(param.mapValues({case Some(x) => x.asInstanceOf[java.lang.Integer]; case None => null}).asJava)
  }

  def methodWithMapNullableIntegerHandler(handler: Map[String, scala.Option[java.lang.Integer]] => Unit): Unit = {
    asJava.methodWithMapNullableIntegerHandler((p:Map[String, scala.Option[java.lang.Integer]]) => handler(p))
  }

  def methodWithMapNullableIntegerHandlerAsyncResult(handler: AsyncResult[Map[String, scala.Option[java.lang.Integer]]] => Unit): Unit = {
    asJava.methodWithMapNullableIntegerHandlerAsyncResult((p:AsyncResult[Map[String, scala.Option[java.lang.Integer]]]) => handler(p))
  }

  def methodWithMapNullableIntegerReturn(): Map[String, scala.Option[java.lang.Integer]] = {
    asJava.methodWithMapNullableIntegerReturn().asScala.mapValues(x => Option(x)).toMap
  }

  def methodWithMapNullableLongParam(param: Map[String, scala.Option[java.lang.Long]]): Unit = {
    asJava.methodWithMapNullableLongParam(param.mapValues({case Some(x) => x.asInstanceOf[java.lang.Long]; case None => null}).asJava)
  }

  def methodWithMapNullableLongHandler(handler: Map[String, scala.Option[java.lang.Long]] => Unit): Unit = {
    asJava.methodWithMapNullableLongHandler((p:Map[String, scala.Option[java.lang.Long]]) => handler(p))
  }

  def methodWithMapNullableLongHandlerAsyncResult(handler: AsyncResult[Map[String, scala.Option[java.lang.Long]]] => Unit): Unit = {
    asJava.methodWithMapNullableLongHandlerAsyncResult((p:AsyncResult[Map[String, scala.Option[java.lang.Long]]]) => handler(p))
  }

  def methodWithMapNullableLongReturn(): Map[String, scala.Option[java.lang.Long]] = {
    asJava.methodWithMapNullableLongReturn().asScala.mapValues(x => Option(x)).toMap
  }

  def methodWithMapNullableBooleanParam(param: Map[String, scala.Option[java.lang.Boolean]]): Unit = {
    asJava.methodWithMapNullableBooleanParam(param.mapValues({case Some(x) => x.asInstanceOf[java.lang.Boolean]; case None => null}).asJava)
  }

  def methodWithMapNullableBooleanHandler(handler: Map[String, scala.Option[java.lang.Boolean]] => Unit): Unit = {
    asJava.methodWithMapNullableBooleanHandler((p:Map[String, scala.Option[java.lang.Boolean]]) => handler(p))
  }

  def methodWithMapNullableBooleanHandlerAsyncResult(handler: AsyncResult[Map[String, scala.Option[java.lang.Boolean]]] => Unit): Unit = {
    asJava.methodWithMapNullableBooleanHandlerAsyncResult((p:AsyncResult[Map[String, scala.Option[java.lang.Boolean]]]) => handler(p))
  }

  def methodWithMapNullableBooleanReturn(): Map[String, scala.Option[java.lang.Boolean]] = {
    asJava.methodWithMapNullableBooleanReturn().asScala.mapValues(x => Option(x)).toMap
  }

  def methodWithMapNullableFloatParam(param: Map[String, scala.Option[java.lang.Float]]): Unit = {
    asJava.methodWithMapNullableFloatParam(param.mapValues({case Some(x) => x.asInstanceOf[java.lang.Float]; case None => null}).asJava)
  }

  def methodWithMapNullableFloatHandler(handler: Map[String, scala.Option[java.lang.Float]] => Unit): Unit = {
    asJava.methodWithMapNullableFloatHandler((p:Map[String, scala.Option[java.lang.Float]]) => handler(p))
  }

  def methodWithMapNullableFloatHandlerAsyncResult(handler: AsyncResult[Map[String, scala.Option[java.lang.Float]]] => Unit): Unit = {
    asJava.methodWithMapNullableFloatHandlerAsyncResult((p:AsyncResult[Map[String, scala.Option[java.lang.Float]]]) => handler(p))
  }

  def methodWithMapNullableFloatReturn(): Map[String, scala.Option[java.lang.Float]] = {
    asJava.methodWithMapNullableFloatReturn().asScala.mapValues(x => Option(x)).toMap
  }

  def methodWithMapNullableDoubleParam(param: Map[String, scala.Option[java.lang.Double]]): Unit = {
    asJava.methodWithMapNullableDoubleParam(param.mapValues({case Some(x) => x.asInstanceOf[java.lang.Double]; case None => null}).asJava)
  }

  def methodWithMapNullableDoubleHandler(handler: Map[String, scala.Option[java.lang.Double]] => Unit): Unit = {
    asJava.methodWithMapNullableDoubleHandler((p:Map[String, scala.Option[java.lang.Double]]) => handler(p))
  }

  def methodWithMapNullableDoubleHandlerAsyncResult(handler: AsyncResult[Map[String, scala.Option[java.lang.Double]]] => Unit): Unit = {
    asJava.methodWithMapNullableDoubleHandlerAsyncResult((p:AsyncResult[Map[String, scala.Option[java.lang.Double]]]) => handler(p))
  }

  def methodWithMapNullableDoubleReturn(): Map[String, scala.Option[java.lang.Double]] = {
    asJava.methodWithMapNullableDoubleReturn().asScala.mapValues(x => Option(x)).toMap
  }

  def methodWithMapNullableStringParam(param: Map[String, scala.Option[String]]): Unit = {
    asJava.methodWithMapNullableStringParam(param.mapValues({case Some(x) => x.asInstanceOf[String]; case None => null}).asJava)
  }

  def methodWithMapNullableStringHandler(handler: Map[String, scala.Option[String]] => Unit): Unit = {
    asJava.methodWithMapNullableStringHandler((p:Map[String, scala.Option[String]]) => handler(p))
  }

  def methodWithMapNullableStringHandlerAsyncResult(handler: AsyncResult[Map[String, scala.Option[String]]] => Unit): Unit = {
    asJava.methodWithMapNullableStringHandlerAsyncResult((p:AsyncResult[Map[String, scala.Option[String]]]) => handler(p))
  }

  def methodWithMapNullableStringReturn(): Map[String, scala.Option[String]] = {
    asJava.methodWithMapNullableStringReturn().asScala.mapValues(x => Option(x)).toMap
  }

  def methodWithMapNullableCharParam(param: Map[String, scala.Option[java.lang.Character]]): Unit = {
    asJava.methodWithMapNullableCharParam(param.mapValues({case Some(x) => x.asInstanceOf[java.lang.Character]; case None => null}).asJava)
  }

  def methodWithMapNullableCharHandler(handler: Map[String, scala.Option[java.lang.Character]] => Unit): Unit = {
    asJava.methodWithMapNullableCharHandler((p:Map[String, scala.Option[java.lang.Character]]) => handler(p))
  }

  def methodWithMapNullableCharHandlerAsyncResult(handler: AsyncResult[Map[String, scala.Option[java.lang.Character]]] => Unit): Unit = {
    asJava.methodWithMapNullableCharHandlerAsyncResult((p:AsyncResult[Map[String, scala.Option[java.lang.Character]]]) => handler(p))
  }

  def methodWithMapNullableCharReturn(): Map[String, scala.Option[java.lang.Character]] = {
    asJava.methodWithMapNullableCharReturn().asScala.mapValues(x => Option(x)).toMap
  }

  def methodWithMapNullableJsonObjectParam(param: Map[String, scala.Option[io.vertx.core.json.JsonObject]]): Unit = {
    asJava.methodWithMapNullableJsonObjectParam(param.mapValues(x => x.orNull).asJava)
  }

  def methodWithMapNullableJsonObjectHandler(handler: Map[String, scala.Option[io.vertx.core.json.JsonObject]] => Unit): Unit = {
    asJava.methodWithMapNullableJsonObjectHandler((p:Map[String, scala.Option[io.vertx.core.json.JsonObject]]) => handler(p))
  }

  def methodWithMapNullableJsonObjectHandlerAsyncResult(handler: AsyncResult[Map[String, scala.Option[io.vertx.core.json.JsonObject]]] => Unit): Unit = {
    asJava.methodWithMapNullableJsonObjectHandlerAsyncResult((p:AsyncResult[Map[String, scala.Option[io.vertx.core.json.JsonObject]]]) => handler(p))
  }

  def methodWithMapNullableJsonObjectReturn(): Map[String, scala.Option[io.vertx.core.json.JsonObject]] = {
    asJava.methodWithMapNullableJsonObjectReturn().asScala.mapValues(x => Option(x)).toMap
  }

  def methodWithMapNullableJsonArrayParam(param: Map[String, scala.Option[io.vertx.core.json.JsonArray]]): Unit = {
    asJava.methodWithMapNullableJsonArrayParam(param.mapValues(x => x.orNull).asJava)
  }

  def methodWithMapNullableJsonArrayHandler(handler: Map[String, scala.Option[io.vertx.core.json.JsonArray]] => Unit): Unit = {
    asJava.methodWithMapNullableJsonArrayHandler((p:Map[String, scala.Option[io.vertx.core.json.JsonArray]]) => handler(p))
  }

  def methodWithMapNullableJsonArrayHandlerAsyncResult(handler: AsyncResult[Map[String, scala.Option[io.vertx.core.json.JsonArray]]] => Unit): Unit = {
    asJava.methodWithMapNullableJsonArrayHandlerAsyncResult((p:AsyncResult[Map[String, scala.Option[io.vertx.core.json.JsonArray]]]) => handler(p))
  }

  def methodWithMapNullableJsonArrayReturn(): Map[String, scala.Option[io.vertx.core.json.JsonArray]] = {
    asJava.methodWithMapNullableJsonArrayReturn().asScala.mapValues(x => Option(x)).toMap
  }

  def methodWithMapNullableApiParam(param: Map[String, scala.Option[JRefedInterface1]]): Unit = {
    asJava.methodWithMapNullableApiParam(param.mapValues(x => x.orNull).asJava)
  }

  def methodWithNullableHandler(expectNull: java.lang.Boolean, handler: scala.Option[String => Unit]): Unit = {
    asJava.methodWithNullableHandler(expectNull, handler match {case Some(t) => (p:String) => t(p); case None => null})
  }

  def methodWithNullableHandlerAsyncResult(expectNull: java.lang.Boolean, handler: scala.Option[AsyncResult[String] => Unit]): Unit = {
    asJava.methodWithNullableHandlerAsyncResult(expectNull, handler match {case Some(t) => (p:AsyncResult[String]) => t(p); case None => null})
  }

  def methodWithNullableByteHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[scala.Option[java.lang.Byte]] = {
    val promise = Promise[scala.Option[java.lang.Byte]]()
    asJava.methodWithNullableByteHandlerAsyncResult(notNull, {a:AsyncResult[java.lang.Byte] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()));()})
    promise.future
  }

  def methodWithNullableShortHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[scala.Option[java.lang.Short]] = {
    val promise = Promise[scala.Option[java.lang.Short]]()
    asJava.methodWithNullableShortHandlerAsyncResult(notNull, {a:AsyncResult[java.lang.Short] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()));()})
    promise.future
  }

  def methodWithNullableIntegerHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[scala.Option[java.lang.Integer]] = {
    val promise = Promise[scala.Option[java.lang.Integer]]()
    asJava.methodWithNullableIntegerHandlerAsyncResult(notNull, {a:AsyncResult[java.lang.Integer] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()));()})
    promise.future
  }

  def methodWithNullableLongHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[scala.Option[java.lang.Long]] = {
    val promise = Promise[scala.Option[java.lang.Long]]()
    asJava.methodWithNullableLongHandlerAsyncResult(notNull, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()));()})
    promise.future
  }

  def methodWithNullableFloatHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[scala.Option[java.lang.Float]] = {
    val promise = Promise[scala.Option[java.lang.Float]]()
    asJava.methodWithNullableFloatHandlerAsyncResult(notNull, {a:AsyncResult[java.lang.Float] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()));()})
    promise.future
  }

  def methodWithNullableDoubleHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[scala.Option[java.lang.Double]] = {
    val promise = Promise[scala.Option[java.lang.Double]]()
    asJava.methodWithNullableDoubleHandlerAsyncResult(notNull, {a:AsyncResult[java.lang.Double] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()));()})
    promise.future
  }

  def methodWithNullableBooleanHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[scala.Option[java.lang.Boolean]] = {
    val promise = Promise[scala.Option[java.lang.Boolean]]()
    asJava.methodWithNullableBooleanHandlerAsyncResult(notNull, {a:AsyncResult[java.lang.Boolean] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()));()})
    promise.future
  }

  def methodWithNullableStringHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[scala.Option[String]] = {
    val promise = Promise[scala.Option[String]]()
    asJava.methodWithNullableStringHandlerAsyncResult(notNull, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()));()})
    promise.future
  }

  def methodWithNullableCharHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[scala.Option[java.lang.Character]] = {
    val promise = Promise[scala.Option[java.lang.Character]]()
    asJava.methodWithNullableCharHandlerAsyncResult(notNull, {a:AsyncResult[java.lang.Character] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()));()})
    promise.future
  }

  def methodWithNullableJsonObjectHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[scala.Option[io.vertx.core.json.JsonObject]] = {
    val promise = Promise[scala.Option[io.vertx.core.json.JsonObject]]()
    asJava.methodWithNullableJsonObjectHandlerAsyncResult(notNull, {a:AsyncResult[io.vertx.core.json.JsonObject] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()));()})
    promise.future
  }

  def methodWithNullableJsonArrayHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[scala.Option[io.vertx.core.json.JsonArray]] = {
    val promise = Promise[scala.Option[io.vertx.core.json.JsonArray]]()
    asJava.methodWithNullableJsonArrayHandlerAsyncResult(notNull, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()));()})
    promise.future
  }

  def methodWithNullableApiHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[scala.Option[JRefedInterface1]] = {
    val promise = Promise[scala.Option[JRefedInterface1]]()
    asJava.methodWithNullableApiHandlerAsyncResult(notNull, {a:AsyncResult[io.vertx.codegen.testmodel.RefedInterface1] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()));()})
    promise.future
  }

  def methodWithNullableDataObjectHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[scala.Option[JTestDataObject]] = {
    val promise = Promise[scala.Option[JTestDataObject]]()
    asJava.methodWithNullableDataObjectHandlerAsyncResult(notNull, {a:AsyncResult[io.vertx.codegen.testmodel.TestDataObject] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()));()})
    promise.future
  }

  def methodWithNullableEnumHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[scala.Option[io.vertx.codegen.testmodel.TestEnum]] = {
    val promise = Promise[scala.Option[io.vertx.codegen.testmodel.TestEnum]]()
    asJava.methodWithNullableEnumHandlerAsyncResult(notNull, {a:AsyncResult[io.vertx.codegen.testmodel.TestEnum] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()));()})
    promise.future
  }

  def methodWithNullableGenEnumHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[scala.Option[io.vertx.codegen.testmodel.TestGenEnum]] = {
    val promise = Promise[scala.Option[io.vertx.codegen.testmodel.TestGenEnum]]()
    asJava.methodWithNullableGenEnumHandlerAsyncResult(notNull, {a:AsyncResult[io.vertx.codegen.testmodel.TestGenEnum] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()));()})
    promise.future
  }

  def methodWithNullableTypeVariableHandlerAsyncResultFuture[T](notNull: java.lang.Boolean, value: T): scala.concurrent.Future[T] = {
    val promise = Promise[T]()
    asJava.methodWithNullableTypeVariableHandlerAsyncResult[T](notNull, value, {a:AsyncResult[T] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

  def methodWithNullableListByteHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[scala.Option[List[java.lang.Byte]]] = {
    val promise = Promise[scala.Option[List[java.lang.Byte]]]()
    asJava.methodWithNullableListByteHandlerAsyncResult(notNull, {a:AsyncResult[java.util.List[java.lang.Byte]] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()).flatMap(x => Some(x.asScala.toList)));()})
    promise.future
  }

  def methodWithNullableListShortHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[scala.Option[List[java.lang.Short]]] = {
    val promise = Promise[scala.Option[List[java.lang.Short]]]()
    asJava.methodWithNullableListShortHandlerAsyncResult(notNull, {a:AsyncResult[java.util.List[java.lang.Short]] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()).flatMap(x => Some(x.asScala.toList)));()})
    promise.future
  }

  def methodWithNullableListIntegerHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[scala.Option[List[java.lang.Integer]]] = {
    val promise = Promise[scala.Option[List[java.lang.Integer]]]()
    asJava.methodWithNullableListIntegerHandlerAsyncResult(notNull, {a:AsyncResult[java.util.List[java.lang.Integer]] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()).flatMap(x => Some(x.asScala.toList)));()})
    promise.future
  }

  def methodWithNullableListLongHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[scala.Option[List[java.lang.Long]]] = {
    val promise = Promise[scala.Option[List[java.lang.Long]]]()
    asJava.methodWithNullableListLongHandlerAsyncResult(notNull, {a:AsyncResult[java.util.List[java.lang.Long]] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()).flatMap(x => Some(x.asScala.toList)));()})
    promise.future
  }

  def methodWithNullableListFloatHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[scala.Option[List[java.lang.Float]]] = {
    val promise = Promise[scala.Option[List[java.lang.Float]]]()
    asJava.methodWithNullableListFloatHandlerAsyncResult(notNull, {a:AsyncResult[java.util.List[java.lang.Float]] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()).flatMap(x => Some(x.asScala.toList)));()})
    promise.future
  }

  def methodWithNullableListDoubleHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[scala.Option[List[java.lang.Double]]] = {
    val promise = Promise[scala.Option[List[java.lang.Double]]]()
    asJava.methodWithNullableListDoubleHandlerAsyncResult(notNull, {a:AsyncResult[java.util.List[java.lang.Double]] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()).flatMap(x => Some(x.asScala.toList)));()})
    promise.future
  }

  def methodWithNullableListBooleanHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[scala.Option[List[java.lang.Boolean]]] = {
    val promise = Promise[scala.Option[List[java.lang.Boolean]]]()
    asJava.methodWithNullableListBooleanHandlerAsyncResult(notNull, {a:AsyncResult[java.util.List[java.lang.Boolean]] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()).flatMap(x => Some(x.asScala.toList)));()})
    promise.future
  }

  def methodWithNullableListStringHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[scala.Option[List[String]]] = {
    val promise = Promise[scala.Option[List[String]]]()
    asJava.methodWithNullableListStringHandlerAsyncResult(notNull, {a:AsyncResult[java.util.List[java.lang.String]] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()).flatMap(x => Some(x.asScala.toList)));()})
    promise.future
  }

  def methodWithNullableListCharHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[scala.Option[List[java.lang.Character]]] = {
    val promise = Promise[scala.Option[List[java.lang.Character]]]()
    asJava.methodWithNullableListCharHandlerAsyncResult(notNull, {a:AsyncResult[java.util.List[java.lang.Character]] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()).flatMap(x => Some(x.asScala.toList)));()})
    promise.future
  }

  def methodWithNullableListJsonObjectHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[scala.Option[List[io.vertx.core.json.JsonObject]]] = {
    val promise = Promise[scala.Option[List[io.vertx.core.json.JsonObject]]]()
    asJava.methodWithNullableListJsonObjectHandlerAsyncResult(notNull, {a:AsyncResult[java.util.List[io.vertx.core.json.JsonObject]] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()).flatMap(x => Some(x.asScala.toList)));()})
    promise.future
  }

  def methodWithNullableListJsonArrayHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[scala.Option[List[io.vertx.core.json.JsonArray]]] = {
    val promise = Promise[scala.Option[List[io.vertx.core.json.JsonArray]]]()
    asJava.methodWithNullableListJsonArrayHandlerAsyncResult(notNull, {a:AsyncResult[java.util.List[io.vertx.core.json.JsonArray]] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()).flatMap(x => Some(x.asScala.toList)));()})
    promise.future
  }

  def methodWithNullableListApiHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[scala.Option[List[JRefedInterface1]]] = {
    val promise = Promise[scala.Option[List[JRefedInterface1]]]()
    asJava.methodWithNullableListApiHandlerAsyncResult(notNull, {a:AsyncResult[java.util.List[io.vertx.codegen.testmodel.RefedInterface1]] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()).flatMap(x => Some(x.asScala.toList)));()})
    promise.future
  }

  def methodWithNullableListDataObjectHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[scala.Option[List[JTestDataObject]]] = {
    val promise = Promise[scala.Option[List[JTestDataObject]]]()
    asJava.methodWithNullableListDataObjectHandlerAsyncResult(notNull, {a:AsyncResult[java.util.List[io.vertx.codegen.testmodel.TestDataObject]] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()).flatMap(x => Some(x.asScala.toList)));()})
    promise.future
  }

  def methodWithNullableListEnumHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[scala.Option[List[io.vertx.codegen.testmodel.TestEnum]]] = {
    val promise = Promise[scala.Option[List[io.vertx.codegen.testmodel.TestEnum]]]()
    asJava.methodWithNullableListEnumHandlerAsyncResult(notNull, {a:AsyncResult[java.util.List[io.vertx.codegen.testmodel.TestEnum]] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()).flatMap(x => Some(x.asScala.toList)));()})
    promise.future
  }

  def methodWithNullableListGenEnumHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[scala.Option[List[io.vertx.codegen.testmodel.TestGenEnum]]] = {
    val promise = Promise[scala.Option[List[io.vertx.codegen.testmodel.TestGenEnum]]]()
    asJava.methodWithNullableListGenEnumHandlerAsyncResult(notNull, {a:AsyncResult[java.util.List[io.vertx.codegen.testmodel.TestGenEnum]] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()).flatMap(x => Some(x.asScala.toList)));()})
    promise.future
  }

  def methodWithNullableSetByteHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[scala.Option[Seq[java.lang.Byte]]] = {
    val promise = Promise[scala.Option[Seq[java.lang.Byte]]]()
    asJava.methodWithNullableSetByteHandlerAsyncResult(notNull, {a:AsyncResult[java.util.Set[java.lang.Byte]] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()).flatMap(x => Some(x.asScala.toSeq)));()})
    promise.future
  }

  def methodWithNullableSetShortHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[scala.Option[Seq[java.lang.Short]]] = {
    val promise = Promise[scala.Option[Seq[java.lang.Short]]]()
    asJava.methodWithNullableSetShortHandlerAsyncResult(notNull, {a:AsyncResult[java.util.Set[java.lang.Short]] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()).flatMap(x => Some(x.asScala.toSeq)));()})
    promise.future
  }

  def methodWithNullableSetIntegerHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[scala.Option[Seq[java.lang.Integer]]] = {
    val promise = Promise[scala.Option[Seq[java.lang.Integer]]]()
    asJava.methodWithNullableSetIntegerHandlerAsyncResult(notNull, {a:AsyncResult[java.util.Set[java.lang.Integer]] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()).flatMap(x => Some(x.asScala.toSeq)));()})
    promise.future
  }

  def methodWithNullableSetLongHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[scala.Option[Seq[java.lang.Long]]] = {
    val promise = Promise[scala.Option[Seq[java.lang.Long]]]()
    asJava.methodWithNullableSetLongHandlerAsyncResult(notNull, {a:AsyncResult[java.util.Set[java.lang.Long]] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()).flatMap(x => Some(x.asScala.toSeq)));()})
    promise.future
  }

  def methodWithNullableSetFloatHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[scala.Option[Seq[java.lang.Float]]] = {
    val promise = Promise[scala.Option[Seq[java.lang.Float]]]()
    asJava.methodWithNullableSetFloatHandlerAsyncResult(notNull, {a:AsyncResult[java.util.Set[java.lang.Float]] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()).flatMap(x => Some(x.asScala.toSeq)));()})
    promise.future
  }

  def methodWithNullableSetDoubleHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[scala.Option[Seq[java.lang.Double]]] = {
    val promise = Promise[scala.Option[Seq[java.lang.Double]]]()
    asJava.methodWithNullableSetDoubleHandlerAsyncResult(notNull, {a:AsyncResult[java.util.Set[java.lang.Double]] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()).flatMap(x => Some(x.asScala.toSeq)));()})
    promise.future
  }

  def methodWithNullableSetBooleanHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[scala.Option[Seq[java.lang.Boolean]]] = {
    val promise = Promise[scala.Option[Seq[java.lang.Boolean]]]()
    asJava.methodWithNullableSetBooleanHandlerAsyncResult(notNull, {a:AsyncResult[java.util.Set[java.lang.Boolean]] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()).flatMap(x => Some(x.asScala.toSeq)));()})
    promise.future
  }

  def methodWithNullableSetStringHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[scala.Option[Seq[String]]] = {
    val promise = Promise[scala.Option[Seq[String]]]()
    asJava.methodWithNullableSetStringHandlerAsyncResult(notNull, {a:AsyncResult[java.util.Set[java.lang.String]] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()).flatMap(x => Some(x.asScala.toSeq)));()})
    promise.future
  }

  def methodWithNullableSetCharHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[scala.Option[Seq[java.lang.Character]]] = {
    val promise = Promise[scala.Option[Seq[java.lang.Character]]]()
    asJava.methodWithNullableSetCharHandlerAsyncResult(notNull, {a:AsyncResult[java.util.Set[java.lang.Character]] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()).flatMap(x => Some(x.asScala.toSeq)));()})
    promise.future
  }

  def methodWithNullableSetJsonObjectHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[scala.Option[Seq[io.vertx.core.json.JsonObject]]] = {
    val promise = Promise[scala.Option[Seq[io.vertx.core.json.JsonObject]]]()
    asJava.methodWithNullableSetJsonObjectHandlerAsyncResult(notNull, {a:AsyncResult[java.util.Set[io.vertx.core.json.JsonObject]] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()).flatMap(x => Some(x.asScala.toSeq)));()})
    promise.future
  }

  def methodWithNullableSetJsonArrayHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[scala.Option[Seq[io.vertx.core.json.JsonArray]]] = {
    val promise = Promise[scala.Option[Seq[io.vertx.core.json.JsonArray]]]()
    asJava.methodWithNullableSetJsonArrayHandlerAsyncResult(notNull, {a:AsyncResult[java.util.Set[io.vertx.core.json.JsonArray]] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()).flatMap(x => Some(x.asScala.toSeq)));()})
    promise.future
  }

  def methodWithNullableSetApiHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[scala.Option[Seq[JRefedInterface1]]] = {
    val promise = Promise[scala.Option[Seq[JRefedInterface1]]]()
    asJava.methodWithNullableSetApiHandlerAsyncResult(notNull, {a:AsyncResult[java.util.Set[io.vertx.codegen.testmodel.RefedInterface1]] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()).flatMap(x => Some(x.asScala.toSeq)));()})
    promise.future
  }

  def methodWithNullableSetDataObjectHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[scala.Option[Seq[JTestDataObject]]] = {
    val promise = Promise[scala.Option[Seq[JTestDataObject]]]()
    asJava.methodWithNullableSetDataObjectHandlerAsyncResult(notNull, {a:AsyncResult[java.util.Set[io.vertx.codegen.testmodel.TestDataObject]] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()).flatMap(x => Some(x.asScala.toSeq)));()})
    promise.future
  }

  def methodWithNullableSetEnumHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[scala.Option[Seq[io.vertx.codegen.testmodel.TestEnum]]] = {
    val promise = Promise[scala.Option[Seq[io.vertx.codegen.testmodel.TestEnum]]]()
    asJava.methodWithNullableSetEnumHandlerAsyncResult(notNull, {a:AsyncResult[java.util.Set[io.vertx.codegen.testmodel.TestEnum]] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()).flatMap(x => Some(x.asScala.toSeq)));()})
    promise.future
  }

  def methodWithNullableSetGenEnumHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[scala.Option[Seq[io.vertx.codegen.testmodel.TestGenEnum]]] = {
    val promise = Promise[scala.Option[Seq[io.vertx.codegen.testmodel.TestGenEnum]]]()
    asJava.methodWithNullableSetGenEnumHandlerAsyncResult(notNull, {a:AsyncResult[java.util.Set[io.vertx.codegen.testmodel.TestGenEnum]] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()).flatMap(x => Some(x.asScala.toSeq)));()})
    promise.future
  }

  def methodWithNullableMapByteHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[scala.Option[Map[String, java.lang.Byte]]] = {
    val promise = Promise[scala.Option[Map[String, java.lang.Byte]]]()
    asJava.methodWithNullableMapByteHandlerAsyncResult(notNull, {a:AsyncResult[java.util.Map[java.lang.String,java.lang.Byte]] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()).flatMap(x => Some(x.asScala.toMap)));()})
    promise.future
  }

  def methodWithNullableMapShortHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[scala.Option[Map[String, java.lang.Short]]] = {
    val promise = Promise[scala.Option[Map[String, java.lang.Short]]]()
    asJava.methodWithNullableMapShortHandlerAsyncResult(notNull, {a:AsyncResult[java.util.Map[java.lang.String,java.lang.Short]] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()).flatMap(x => Some(x.asScala.toMap)));()})
    promise.future
  }

  def methodWithNullableMapIntegerHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[scala.Option[Map[String, java.lang.Integer]]] = {
    val promise = Promise[scala.Option[Map[String, java.lang.Integer]]]()
    asJava.methodWithNullableMapIntegerHandlerAsyncResult(notNull, {a:AsyncResult[java.util.Map[java.lang.String,java.lang.Integer]] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()).flatMap(x => Some(x.asScala.toMap)));()})
    promise.future
  }

  def methodWithNullableMapLongHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[scala.Option[Map[String, java.lang.Long]]] = {
    val promise = Promise[scala.Option[Map[String, java.lang.Long]]]()
    asJava.methodWithNullableMapLongHandlerAsyncResult(notNull, {a:AsyncResult[java.util.Map[java.lang.String,java.lang.Long]] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()).flatMap(x => Some(x.asScala.toMap)));()})
    promise.future
  }

  def methodWithNullableMapFloatHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[scala.Option[Map[String, java.lang.Float]]] = {
    val promise = Promise[scala.Option[Map[String, java.lang.Float]]]()
    asJava.methodWithNullableMapFloatHandlerAsyncResult(notNull, {a:AsyncResult[java.util.Map[java.lang.String,java.lang.Float]] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()).flatMap(x => Some(x.asScala.toMap)));()})
    promise.future
  }

  def methodWithNullableMapDoubleHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[scala.Option[Map[String, java.lang.Double]]] = {
    val promise = Promise[scala.Option[Map[String, java.lang.Double]]]()
    asJava.methodWithNullableMapDoubleHandlerAsyncResult(notNull, {a:AsyncResult[java.util.Map[java.lang.String,java.lang.Double]] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()).flatMap(x => Some(x.asScala.toMap)));()})
    promise.future
  }

  def methodWithNullableMapBooleanHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[scala.Option[Map[String, java.lang.Boolean]]] = {
    val promise = Promise[scala.Option[Map[String, java.lang.Boolean]]]()
    asJava.methodWithNullableMapBooleanHandlerAsyncResult(notNull, {a:AsyncResult[java.util.Map[java.lang.String,java.lang.Boolean]] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()).flatMap(x => Some(x.asScala.toMap)));()})
    promise.future
  }

  def methodWithNullableMapStringHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[scala.Option[Map[String, String]]] = {
    val promise = Promise[scala.Option[Map[String, String]]]()
    asJava.methodWithNullableMapStringHandlerAsyncResult(notNull, {a:AsyncResult[java.util.Map[java.lang.String,java.lang.String]] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()).flatMap(x => Some(x.asScala.toMap)));()})
    promise.future
  }

  def methodWithNullableMapCharHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[scala.Option[Map[String, java.lang.Character]]] = {
    val promise = Promise[scala.Option[Map[String, java.lang.Character]]]()
    asJava.methodWithNullableMapCharHandlerAsyncResult(notNull, {a:AsyncResult[java.util.Map[java.lang.String,java.lang.Character]] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()).flatMap(x => Some(x.asScala.toMap)));()})
    promise.future
  }

  def methodWithNullableMapJsonObjectHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[scala.Option[Map[String, io.vertx.core.json.JsonObject]]] = {
    val promise = Promise[scala.Option[Map[String, io.vertx.core.json.JsonObject]]]()
    asJava.methodWithNullableMapJsonObjectHandlerAsyncResult(notNull, {a:AsyncResult[java.util.Map[java.lang.String,io.vertx.core.json.JsonObject]] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()).flatMap(x => Some(x.asScala.toMap)));()})
    promise.future
  }

  def methodWithNullableMapJsonArrayHandlerAsyncResultFuture(notNull: java.lang.Boolean): scala.concurrent.Future[scala.Option[Map[String, io.vertx.core.json.JsonArray]]] = {
    val promise = Promise[scala.Option[Map[String, io.vertx.core.json.JsonArray]]]()
    asJava.methodWithNullableMapJsonArrayHandlerAsyncResult(notNull, {a:AsyncResult[java.util.Map[java.lang.String,io.vertx.core.json.JsonArray]] => if(a.failed) promise.failure(a.cause) else promise.success(scala.Option(a.result()).flatMap(x => Some(x.asScala.toMap)));()})
    promise.future
  }

  def methodWithListNullableByteHandlerAsyncResultFuture(): scala.concurrent.Future[List[scala.Option[java.lang.Byte]]] = {
    val promise = Promise[List[scala.Option[java.lang.Byte]]]()
    asJava.methodWithListNullableByteHandlerAsyncResult({a:AsyncResult[java.util.List[java.lang.Byte]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.map(x => Option(x)).toList);()})
    promise.future
  }

  def methodWithListNullableShortHandlerAsyncResultFuture(): scala.concurrent.Future[List[scala.Option[java.lang.Short]]] = {
    val promise = Promise[List[scala.Option[java.lang.Short]]]()
    asJava.methodWithListNullableShortHandlerAsyncResult({a:AsyncResult[java.util.List[java.lang.Short]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.map(x => Option(x)).toList);()})
    promise.future
  }

  def methodWithListNullableIntegerHandlerAsyncResultFuture(): scala.concurrent.Future[List[scala.Option[java.lang.Integer]]] = {
    val promise = Promise[List[scala.Option[java.lang.Integer]]]()
    asJava.methodWithListNullableIntegerHandlerAsyncResult({a:AsyncResult[java.util.List[java.lang.Integer]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.map(x => Option(x)).toList);()})
    promise.future
  }

  def methodWithListNullableLongHandlerAsyncResultFuture(): scala.concurrent.Future[List[scala.Option[java.lang.Long]]] = {
    val promise = Promise[List[scala.Option[java.lang.Long]]]()
    asJava.methodWithListNullableLongHandlerAsyncResult({a:AsyncResult[java.util.List[java.lang.Long]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.map(x => Option(x)).toList);()})
    promise.future
  }

  def methodWithListNullableBooleanHandlerAsyncResultFuture(): scala.concurrent.Future[List[scala.Option[java.lang.Boolean]]] = {
    val promise = Promise[List[scala.Option[java.lang.Boolean]]]()
    asJava.methodWithListNullableBooleanHandlerAsyncResult({a:AsyncResult[java.util.List[java.lang.Boolean]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.map(x => Option(x)).toList);()})
    promise.future
  }

  def methodWithListNullableFloatHandlerAsyncResultFuture(): scala.concurrent.Future[List[scala.Option[java.lang.Float]]] = {
    val promise = Promise[List[scala.Option[java.lang.Float]]]()
    asJava.methodWithListNullableFloatHandlerAsyncResult({a:AsyncResult[java.util.List[java.lang.Float]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.map(x => Option(x)).toList);()})
    promise.future
  }

  def methodWithListNullableDoubleHandlerAsyncResultFuture(): scala.concurrent.Future[List[scala.Option[java.lang.Double]]] = {
    val promise = Promise[List[scala.Option[java.lang.Double]]]()
    asJava.methodWithListNullableDoubleHandlerAsyncResult({a:AsyncResult[java.util.List[java.lang.Double]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.map(x => Option(x)).toList);()})
    promise.future
  }

  def methodWithListNullableStringHandlerAsyncResultFuture(): scala.concurrent.Future[List[scala.Option[String]]] = {
    val promise = Promise[List[scala.Option[String]]]()
    asJava.methodWithListNullableStringHandlerAsyncResult({a:AsyncResult[java.util.List[java.lang.String]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.map(x => Option(x)).toList);()})
    promise.future
  }

  def methodWithListNullableCharHandlerAsyncResultFuture(): scala.concurrent.Future[List[scala.Option[java.lang.Character]]] = {
    val promise = Promise[List[scala.Option[java.lang.Character]]]()
    asJava.methodWithListNullableCharHandlerAsyncResult({a:AsyncResult[java.util.List[java.lang.Character]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.map(x => Option(x)).toList);()})
    promise.future
  }

  def methodWithListNullableJsonObjectHandlerAsyncResultFuture(): scala.concurrent.Future[List[scala.Option[io.vertx.core.json.JsonObject]]] = {
    val promise = Promise[List[scala.Option[io.vertx.core.json.JsonObject]]]()
    asJava.methodWithListNullableJsonObjectHandlerAsyncResult({a:AsyncResult[java.util.List[io.vertx.core.json.JsonObject]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.map(x => Option(x)).toList);()})
    promise.future
  }

  def methodWithListNullableJsonArrayHandlerAsyncResultFuture(): scala.concurrent.Future[List[scala.Option[io.vertx.core.json.JsonArray]]] = {
    val promise = Promise[List[scala.Option[io.vertx.core.json.JsonArray]]]()
    asJava.methodWithListNullableJsonArrayHandlerAsyncResult({a:AsyncResult[java.util.List[io.vertx.core.json.JsonArray]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.map(x => Option(x)).toList);()})
    promise.future
  }

  def methodWithListNullableApiHandlerAsyncResultFuture(): scala.concurrent.Future[List[scala.Option[JRefedInterface1]]] = {
    val promise = Promise[List[scala.Option[JRefedInterface1]]]()
    asJava.methodWithListNullableApiHandlerAsyncResult({a:AsyncResult[java.util.List[io.vertx.codegen.testmodel.RefedInterface1]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.map(x => Option(x)).toList);()})
    promise.future
  }

  def methodWithListNullableDataObjectHandlerAsyncResultFuture(): scala.concurrent.Future[List[scala.Option[JTestDataObject]]] = {
    val promise = Promise[List[scala.Option[JTestDataObject]]]()
    asJava.methodWithListNullableDataObjectHandlerAsyncResult({a:AsyncResult[java.util.List[io.vertx.codegen.testmodel.TestDataObject]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.map(x => Option(x)).toList);()})
    promise.future
  }

  def methodWithListNullableEnumHandlerAsyncResultFuture(): scala.concurrent.Future[List[scala.Option[io.vertx.codegen.testmodel.TestEnum]]] = {
    val promise = Promise[List[scala.Option[io.vertx.codegen.testmodel.TestEnum]]]()
    asJava.methodWithListNullableEnumHandlerAsyncResult({a:AsyncResult[java.util.List[io.vertx.codegen.testmodel.TestEnum]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.map(x => Option(x)).toList);()})
    promise.future
  }

  def methodWithListNullableGenEnumHandlerAsyncResultFuture(): scala.concurrent.Future[List[scala.Option[io.vertx.codegen.testmodel.TestGenEnum]]] = {
    val promise = Promise[List[scala.Option[io.vertx.codegen.testmodel.TestGenEnum]]]()
    asJava.methodWithListNullableGenEnumHandlerAsyncResult({a:AsyncResult[java.util.List[io.vertx.codegen.testmodel.TestGenEnum]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.map(x => Option(x)).toList);()})
    promise.future
  }

  def methodWithSetNullableByteHandlerAsyncResultFuture(): scala.concurrent.Future[Seq[scala.Option[java.lang.Byte]]] = {
    val promise = Promise[Seq[scala.Option[java.lang.Byte]]]()
    asJava.methodWithSetNullableByteHandlerAsyncResult({a:AsyncResult[java.util.Set[java.lang.Byte]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.map(x => Option(x)).toSeq);()})
    promise.future
  }

  def methodWithSetNullableShortHandlerAsyncResultFuture(): scala.concurrent.Future[Seq[scala.Option[java.lang.Short]]] = {
    val promise = Promise[Seq[scala.Option[java.lang.Short]]]()
    asJava.methodWithSetNullableShortHandlerAsyncResult({a:AsyncResult[java.util.Set[java.lang.Short]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.map(x => Option(x)).toSeq);()})
    promise.future
  }

  def methodWithSetNullableIntegerHandlerAsyncResultFuture(): scala.concurrent.Future[Seq[scala.Option[java.lang.Integer]]] = {
    val promise = Promise[Seq[scala.Option[java.lang.Integer]]]()
    asJava.methodWithSetNullableIntegerHandlerAsyncResult({a:AsyncResult[java.util.Set[java.lang.Integer]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.map(x => Option(x)).toSeq);()})
    promise.future
  }

  def methodWithSetNullableLongHandlerAsyncResultFuture(): scala.concurrent.Future[Seq[scala.Option[java.lang.Long]]] = {
    val promise = Promise[Seq[scala.Option[java.lang.Long]]]()
    asJava.methodWithSetNullableLongHandlerAsyncResult({a:AsyncResult[java.util.Set[java.lang.Long]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.map(x => Option(x)).toSeq);()})
    promise.future
  }

  def methodWithSetNullableBooleanHandlerAsyncResultFuture(): scala.concurrent.Future[Seq[scala.Option[java.lang.Boolean]]] = {
    val promise = Promise[Seq[scala.Option[java.lang.Boolean]]]()
    asJava.methodWithSetNullableBooleanHandlerAsyncResult({a:AsyncResult[java.util.Set[java.lang.Boolean]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.map(x => Option(x)).toSeq);()})
    promise.future
  }

  def methodWithSetNullableFloatHandlerAsyncResultFuture(): scala.concurrent.Future[Seq[scala.Option[java.lang.Float]]] = {
    val promise = Promise[Seq[scala.Option[java.lang.Float]]]()
    asJava.methodWithSetNullableFloatHandlerAsyncResult({a:AsyncResult[java.util.Set[java.lang.Float]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.map(x => Option(x)).toSeq);()})
    promise.future
  }

  def methodWithSetNullableDoubleHandlerAsyncResultFuture(): scala.concurrent.Future[Seq[scala.Option[java.lang.Double]]] = {
    val promise = Promise[Seq[scala.Option[java.lang.Double]]]()
    asJava.methodWithSetNullableDoubleHandlerAsyncResult({a:AsyncResult[java.util.Set[java.lang.Double]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.map(x => Option(x)).toSeq);()})
    promise.future
  }

  def methodWithSetNullableStringHandlerAsyncResultFuture(): scala.concurrent.Future[Seq[scala.Option[String]]] = {
    val promise = Promise[Seq[scala.Option[String]]]()
    asJava.methodWithSetNullableStringHandlerAsyncResult({a:AsyncResult[java.util.Set[java.lang.String]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.map(x => Option(x)).toSeq);()})
    promise.future
  }

  def methodWithSetNullableCharHandlerAsyncResultFuture(): scala.concurrent.Future[Seq[scala.Option[java.lang.Character]]] = {
    val promise = Promise[Seq[scala.Option[java.lang.Character]]]()
    asJava.methodWithSetNullableCharHandlerAsyncResult({a:AsyncResult[java.util.Set[java.lang.Character]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.map(x => Option(x)).toSeq);()})
    promise.future
  }

  def methodWithSetNullableJsonObjectHandlerAsyncResultFuture(): scala.concurrent.Future[Seq[scala.Option[io.vertx.core.json.JsonObject]]] = {
    val promise = Promise[Seq[scala.Option[io.vertx.core.json.JsonObject]]]()
    asJava.methodWithSetNullableJsonObjectHandlerAsyncResult({a:AsyncResult[java.util.Set[io.vertx.core.json.JsonObject]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.map(x => Option(x)).toSeq);()})
    promise.future
  }

  def methodWithSetNullableJsonArrayHandlerAsyncResultFuture(): scala.concurrent.Future[Seq[scala.Option[io.vertx.core.json.JsonArray]]] = {
    val promise = Promise[Seq[scala.Option[io.vertx.core.json.JsonArray]]]()
    asJava.methodWithSetNullableJsonArrayHandlerAsyncResult({a:AsyncResult[java.util.Set[io.vertx.core.json.JsonArray]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.map(x => Option(x)).toSeq);()})
    promise.future
  }

  def methodWithSetNullableApiHandlerAsyncResultFuture(): scala.concurrent.Future[Seq[scala.Option[JRefedInterface1]]] = {
    val promise = Promise[Seq[scala.Option[JRefedInterface1]]]()
    asJava.methodWithSetNullableApiHandlerAsyncResult({a:AsyncResult[java.util.Set[io.vertx.codegen.testmodel.RefedInterface1]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.map(x => Option(x)).toSeq);()})
    promise.future
  }

  def methodWithSetNullableDataObjectHandlerAsyncResultFuture(): scala.concurrent.Future[Seq[scala.Option[JTestDataObject]]] = {
    val promise = Promise[Seq[scala.Option[JTestDataObject]]]()
    asJava.methodWithSetNullableDataObjectHandlerAsyncResult({a:AsyncResult[java.util.Set[io.vertx.codegen.testmodel.TestDataObject]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.map(x => Option(x)).toSeq);()})
    promise.future
  }

  def methodWithSetNullableEnumHandlerAsyncResultFuture(): scala.concurrent.Future[Seq[scala.Option[io.vertx.codegen.testmodel.TestEnum]]] = {
    val promise = Promise[Seq[scala.Option[io.vertx.codegen.testmodel.TestEnum]]]()
    asJava.methodWithSetNullableEnumHandlerAsyncResult({a:AsyncResult[java.util.Set[io.vertx.codegen.testmodel.TestEnum]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.map(x => Option(x)).toSeq);()})
    promise.future
  }

  def methodWithSetNullableGenEnumHandlerAsyncResultFuture(): scala.concurrent.Future[Seq[scala.Option[io.vertx.codegen.testmodel.TestGenEnum]]] = {
    val promise = Promise[Seq[scala.Option[io.vertx.codegen.testmodel.TestGenEnum]]]()
    asJava.methodWithSetNullableGenEnumHandlerAsyncResult({a:AsyncResult[java.util.Set[io.vertx.codegen.testmodel.TestGenEnum]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.map(x => Option(x)).toSeq);()})
    promise.future
  }

  def methodWithMapNullableByteHandlerAsyncResultFuture(): scala.concurrent.Future[Map[String, scala.Option[java.lang.Byte]]] = {
    val promise = Promise[Map[String, scala.Option[java.lang.Byte]]]()
    asJava.methodWithMapNullableByteHandlerAsyncResult({a:AsyncResult[java.util.Map[java.lang.String,java.lang.Byte]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.mapValues(x => Option(x)).toMap);()})
    promise.future
  }

  def methodWithMapNullableShortHandlerAsyncResultFuture(): scala.concurrent.Future[Map[String, scala.Option[java.lang.Short]]] = {
    val promise = Promise[Map[String, scala.Option[java.lang.Short]]]()
    asJava.methodWithMapNullableShortHandlerAsyncResult({a:AsyncResult[java.util.Map[java.lang.String,java.lang.Short]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.mapValues(x => Option(x)).toMap);()})
    promise.future
  }

  def methodWithMapNullableIntegerHandlerAsyncResultFuture(): scala.concurrent.Future[Map[String, scala.Option[java.lang.Integer]]] = {
    val promise = Promise[Map[String, scala.Option[java.lang.Integer]]]()
    asJava.methodWithMapNullableIntegerHandlerAsyncResult({a:AsyncResult[java.util.Map[java.lang.String,java.lang.Integer]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.mapValues(x => Option(x)).toMap);()})
    promise.future
  }

  def methodWithMapNullableLongHandlerAsyncResultFuture(): scala.concurrent.Future[Map[String, scala.Option[java.lang.Long]]] = {
    val promise = Promise[Map[String, scala.Option[java.lang.Long]]]()
    asJava.methodWithMapNullableLongHandlerAsyncResult({a:AsyncResult[java.util.Map[java.lang.String,java.lang.Long]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.mapValues(x => Option(x)).toMap);()})
    promise.future
  }

  def methodWithMapNullableBooleanHandlerAsyncResultFuture(): scala.concurrent.Future[Map[String, scala.Option[java.lang.Boolean]]] = {
    val promise = Promise[Map[String, scala.Option[java.lang.Boolean]]]()
    asJava.methodWithMapNullableBooleanHandlerAsyncResult({a:AsyncResult[java.util.Map[java.lang.String,java.lang.Boolean]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.mapValues(x => Option(x)).toMap);()})
    promise.future
  }

  def methodWithMapNullableFloatHandlerAsyncResultFuture(): scala.concurrent.Future[Map[String, scala.Option[java.lang.Float]]] = {
    val promise = Promise[Map[String, scala.Option[java.lang.Float]]]()
    asJava.methodWithMapNullableFloatHandlerAsyncResult({a:AsyncResult[java.util.Map[java.lang.String,java.lang.Float]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.mapValues(x => Option(x)).toMap);()})
    promise.future
  }

  def methodWithMapNullableDoubleHandlerAsyncResultFuture(): scala.concurrent.Future[Map[String, scala.Option[java.lang.Double]]] = {
    val promise = Promise[Map[String, scala.Option[java.lang.Double]]]()
    asJava.methodWithMapNullableDoubleHandlerAsyncResult({a:AsyncResult[java.util.Map[java.lang.String,java.lang.Double]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.mapValues(x => Option(x)).toMap);()})
    promise.future
  }

  def methodWithMapNullableStringHandlerAsyncResultFuture(): scala.concurrent.Future[Map[String, scala.Option[String]]] = {
    val promise = Promise[Map[String, scala.Option[String]]]()
    asJava.methodWithMapNullableStringHandlerAsyncResult({a:AsyncResult[java.util.Map[java.lang.String,java.lang.String]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.mapValues(x => Option(x)).toMap);()})
    promise.future
  }

  def methodWithMapNullableCharHandlerAsyncResultFuture(): scala.concurrent.Future[Map[String, scala.Option[java.lang.Character]]] = {
    val promise = Promise[Map[String, scala.Option[java.lang.Character]]]()
    asJava.methodWithMapNullableCharHandlerAsyncResult({a:AsyncResult[java.util.Map[java.lang.String,java.lang.Character]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.mapValues(x => Option(x)).toMap);()})
    promise.future
  }

  def methodWithMapNullableJsonObjectHandlerAsyncResultFuture(): scala.concurrent.Future[Map[String, scala.Option[io.vertx.core.json.JsonObject]]] = {
    val promise = Promise[Map[String, scala.Option[io.vertx.core.json.JsonObject]]]()
    asJava.methodWithMapNullableJsonObjectHandlerAsyncResult({a:AsyncResult[java.util.Map[java.lang.String,io.vertx.core.json.JsonObject]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.mapValues(x => Option(x)).toMap);()})
    promise.future
  }

  def methodWithMapNullableJsonArrayHandlerAsyncResultFuture(): scala.concurrent.Future[Map[String, scala.Option[io.vertx.core.json.JsonArray]]] = {
    val promise = Promise[Map[String, scala.Option[io.vertx.core.json.JsonArray]]]()
    asJava.methodWithMapNullableJsonArrayHandlerAsyncResult({a:AsyncResult[java.util.Map[java.lang.String,io.vertx.core.json.JsonArray]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result().asScala.mapValues(x => Option(x)).toMap);()})
    promise.future
  }

  def methodWithNullableHandlerAsyncResultFuture(expectNull: java.lang.Boolean): scala.concurrent.Future[String] = {
    val promise = Promise[String]()
    asJava.methodWithNullableHandlerAsyncResult(expectNull, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

}

import io.vertx.codegen.testmodel.{RefedInterface1 => JRefedInterface1}
import io.vertx.codegen.testmodel.RefedInterface1

/**
  */
implicit class RefedInterface1Scala(val asJava: JRefedInterface1) extends AnyVal {


  def setString(str: String): JRefedInterface1 = {
    asJava.setString(str)
  }

  def getString(): String = {
    asJava.getString()
  }

}

import io.vertx.codegen.testmodel.{RefedInterface2 => JRefedInterface2}
import io.vertx.codegen.testmodel.RefedInterface2

/**
  */
implicit class RefedInterface2Scala(val asJava: JRefedInterface2) extends AnyVal {


  def setString(str: String): JRefedInterface2 = {
    asJava.setString(str)
  }

  def getString(): String = {
    asJava.getString()
  }

}

import io.vertx.codegen.testmodel.{SuperInterface1 => JSuperInterface1}

/**
  */
implicit class SuperInterface1Scala(val asJava: JSuperInterface1) extends AnyVal {


  def superMethodWithBasicParams(b: java.lang.Byte, s: java.lang.Short, i: java.lang.Integer, l: java.lang.Long, f: java.lang.Float, d: java.lang.Double, bool: java.lang.Boolean, ch: java.lang.Character, str: String): Unit = {
    asJava.superMethodWithBasicParams(b, s, i, l, f, d, bool, ch, str)
  }

  def superMethodOverloadedBySubclass(): java.lang.Integer = {
    asJava.superMethodOverloadedBySubclass()
  }

}

import io.vertx.codegen.testmodel.{SuperInterface2 => JSuperInterface2}

/**
  */
implicit class SuperInterface2Scala(val asJava: JSuperInterface2) extends AnyVal {


  def otherSuperMethodWithBasicParams(b: java.lang.Byte, s: java.lang.Short, i: java.lang.Integer, l: java.lang.Long, f: java.lang.Float, d: java.lang.Double, bool: java.lang.Boolean, ch: java.lang.Character, str: String): Unit = {
    asJava.otherSuperMethodWithBasicParams(b, s, i, l, f, d, bool, ch, str)
  }

}

import io.vertx.codegen.testmodel.{TestDataObject => JTestDataObject}

/**
  */

  implicit class TestDataObjectScala(val asJava: JTestDataObject) extends AnyVal {

    def setBar(value: java.lang.Integer) = {
      asJava.setBar(value)
    }
    def getBar: java.lang.Integer = {
      asJava.getBar()
    }
    def setFoo(value: String) = {
      asJava.setFoo(value)
    }
    def getFoo: String = {
      asJava.getFoo()
    }
    def setWibble(value: java.lang.Double) = {
      asJava.setWibble(value)
    }
    def getWibble: java.lang.Double = {
      asJava.getWibble()
    }
  }
  
  type TestDataObject = JTestDataObject
  object TestDataObject {
    def apply(): JTestDataObject = new TestDataObject()
    def apply(json: JsonObject) = new JTestDataObject(json)
  }


import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.codegen.testmodel.{ConcreteHandlerUserType => JConcreteHandlerUserType}
import io.vertx.codegen.testmodel.{ConcreteHandlerUserTypeExtension => JConcreteHandlerUserTypeExtension}
import io.vertx.codegen.testmodel.TestDataObject
import io.vertx.codegen.testmodel.AbstractHandlerUserType
import io.vertx.codegen.testmodel.TestEnum
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.codegen.testmodel.{SuperInterface1 => JSuperInterface1}
import io.vertx.codegen.testmodel.{RefedInterface2 => JRefedInterface2}
import io.vertx.codegen.testmodel.{SuperInterface2 => JSuperInterface2}
import io.vertx.codegen.testmodel.ConcreteHandlerUserType
import io.vertx.codegen.testmodel.ConcreteHandlerUserTypeExtension
import io.vertx.codegen.testmodel.TestGenEnum
import io.vertx.codegen.testmodel.{AbstractHandlerUserType => JAbstractHandlerUserType}
import io.vertx.codegen.testmodel.{RefedInterface1 => JRefedInterface1}
import io.vertx.codegen.testmodel.GenericRefedInterface
import scala.collection.JavaConverters._
import io.vertx.codegen.testmodel.RefedInterface1
import io.vertx.codegen.testmodel.SuperInterface1
import io.vertx.codegen.testmodel.RefedInterface2
import io.vertx.codegen.testmodel.SuperInterface2
import io.vertx.core.json.JsonArray
import io.vertx.codegen.testmodel.{TestDataObject => JTestDataObject}
import io.vertx.codegen.testmodel.{TestInterface => JTestInterface}
import io.vertx.core.Handler
import io.vertx.codegen.testmodel.{GenericRefedInterface => JGenericRefedInterface}
import io.vertx.codegen.testmodel.TestInterface

/**
  */
implicit class TestInterfaceScala(val asJava: JTestInterface) extends AnyVal {


  def fluentMethod(str: String): JTestInterface = {
    asJava.fluentMethod(str)
  }

  def otherSuperMethodWithBasicParams(b: java.lang.Byte, s: java.lang.Short, i: java.lang.Integer, l: java.lang.Long, f: java.lang.Float, d: java.lang.Double, bool: java.lang.Boolean, ch: java.lang.Character, str: String): Unit = {
    asJava.otherSuperMethodWithBasicParams(b, s, i, l, f, d, bool, ch, str)
  }

  def methodWithBasicParams(b: java.lang.Byte, s: java.lang.Short, i: java.lang.Integer, l: java.lang.Long, f: java.lang.Float, d: java.lang.Double, bool: java.lang.Boolean, ch: java.lang.Character, str: String): Unit = {
    asJava.methodWithBasicParams(b, s, i, l, f, d, bool, ch, str)
  }

  def methodWithBasicBoxedParams(b: java.lang.Byte, s: java.lang.Short, i: java.lang.Integer, l: java.lang.Long, f: java.lang.Float, d: java.lang.Double, bool: java.lang.Boolean, ch: java.lang.Character): Unit = {
    asJava.methodWithBasicBoxedParams(b, s, i, l, f, d, bool, ch)
  }

  def methodWithHandlerBasicTypes(byteHandler: java.lang.Byte => Unit, shortHandler: java.lang.Short => Unit, intHandler: java.lang.Integer => Unit, longHandler: java.lang.Long => Unit, floatHandler: java.lang.Float => Unit, doubleHandler: java.lang.Double => Unit, booleanHandler: java.lang.Boolean => Unit, charHandler: java.lang.Character => Unit, stringHandler: String => Unit): Unit = {
    asJava.methodWithHandlerBasicTypes((p:java.lang.Byte) => byteHandler(p), (p:java.lang.Short) => shortHandler(p), (p:java.lang.Integer) => intHandler(p), (p:java.lang.Long) => longHandler(p), (p:java.lang.Float) => floatHandler(p), (p:java.lang.Double) => doubleHandler(p), (p:java.lang.Boolean) => booleanHandler(p), (p:java.lang.Character) => charHandler(p), (p:String) => stringHandler(p))
  }

  def methodWithHandlerStringReturn(expected: String): Handler[String] = {
    asJava.methodWithHandlerStringReturn(expected)
  }

  def methodWithHandlerGenericReturn[T](handler: T => Unit): Handler[T] = {
    asJava.methodWithHandlerGenericReturn[T]((p:T) => handler(p))
  }

  def methodWithHandlerVertxGenReturn(expected: String): Handler[JRefedInterface1] = {
    asJava.methodWithHandlerVertxGenReturn(expected)
  }

  def methodWithHandlerAsyncResultByte(sendFailure: java.lang.Boolean, handler: AsyncResult[java.lang.Byte] => Unit): Unit = {
    asJava.methodWithHandlerAsyncResultByte(sendFailure, (p:AsyncResult[java.lang.Byte]) => handler(p))
  }

  def methodWithHandlerAsyncResultShort(sendFailure: java.lang.Boolean, handler: AsyncResult[java.lang.Short] => Unit): Unit = {
    asJava.methodWithHandlerAsyncResultShort(sendFailure, (p:AsyncResult[java.lang.Short]) => handler(p))
  }

  def methodWithHandlerAsyncResultInteger(sendFailure: java.lang.Boolean, handler: AsyncResult[java.lang.Integer] => Unit): Unit = {
    asJava.methodWithHandlerAsyncResultInteger(sendFailure, (p:AsyncResult[java.lang.Integer]) => handler(p))
  }

  def methodWithHandlerAsyncResultLong(sendFailure: java.lang.Boolean, handler: AsyncResult[java.lang.Long] => Unit): Unit = {
    asJava.methodWithHandlerAsyncResultLong(sendFailure, (p:AsyncResult[java.lang.Long]) => handler(p))
  }

  def methodWithHandlerAsyncResultFloat(sendFailure: java.lang.Boolean, handler: AsyncResult[java.lang.Float] => Unit): Unit = {
    asJava.methodWithHandlerAsyncResultFloat(sendFailure, (p:AsyncResult[java.lang.Float]) => handler(p))
  }

  def methodWithHandlerAsyncResultDouble(sendFailure: java.lang.Boolean, handler: AsyncResult[java.lang.Double] => Unit): Unit = {
    asJava.methodWithHandlerAsyncResultDouble(sendFailure, (p:AsyncResult[java.lang.Double]) => handler(p))
  }

  def methodWithHandlerAsyncResultBoolean(sendFailure: java.lang.Boolean, handler: AsyncResult[java.lang.Boolean] => Unit): Unit = {
    asJava.methodWithHandlerAsyncResultBoolean(sendFailure, (p:AsyncResult[java.lang.Boolean]) => handler(p))
  }

  def methodWithHandlerAsyncResultCharacter(sendFailure: java.lang.Boolean, handler: AsyncResult[java.lang.Character] => Unit): Unit = {
    asJava.methodWithHandlerAsyncResultCharacter(sendFailure, (p:AsyncResult[java.lang.Character]) => handler(p))
  }

  def methodWithHandlerAsyncResultString(sendFailure: java.lang.Boolean, handler: AsyncResult[String] => Unit): Unit = {
    asJava.methodWithHandlerAsyncResultString(sendFailure, (p:AsyncResult[String]) => handler(p))
  }

  def methodWithHandlerAsyncResultDataObject(sendFailure: java.lang.Boolean, handler: AsyncResult[JTestDataObject] => Unit): Unit = {
    asJava.methodWithHandlerAsyncResultDataObject(sendFailure, (p:AsyncResult[JTestDataObject]) => handler(p))
  }

  def methodWithHandlerAsyncResultStringReturn(expected: String, fail: java.lang.Boolean): Handler[AsyncResult[String]] = {
    asJava.methodWithHandlerAsyncResultStringReturn(expected, fail)
  }

  def methodWithHandlerAsyncResultGenericReturn[T](handler: AsyncResult[T] => Unit): Handler[AsyncResult[T]] = {
    asJava.methodWithHandlerAsyncResultGenericReturn[T]((p:AsyncResult[T]) => handler(p))
  }

  def methodWithHandlerAsyncResultVertxGenReturn(expected: String, fail: java.lang.Boolean): Handler[AsyncResult[JRefedInterface1]] = {
    asJava.methodWithHandlerAsyncResultVertxGenReturn(expected, fail)
  }

  def methodWithUserTypes(refed: JRefedInterface1): Unit = {
    asJava.methodWithUserTypes(refed.asJava)
  }

  def methodWithObjectParam(str: String, obj: AnyRef): Unit = {
    asJava.methodWithObjectParam(str, obj)
  }

  def methodWithDataObjectParam(dataObject: JTestDataObject): Unit = {
    asJava.methodWithDataObjectParam(dataObject.asJava)
  }

  def methodWithHandlerUserTypes(handler: JRefedInterface1 => Unit): Unit = {
    asJava.methodWithHandlerUserTypes((p:JRefedInterface1) => handler(p))
  }

  def methodWithHandlerAsyncResultUserTypes(handler: AsyncResult[JRefedInterface1] => Unit): Unit = {
    asJava.methodWithHandlerAsyncResultUserTypes((p:AsyncResult[JRefedInterface1]) => handler(p))
  }

  def methodWithConcreteHandlerUserTypeSubtype(handler: JConcreteHandlerUserType): Unit = {
    asJava.methodWithConcreteHandlerUserTypeSubtype(handler.asJava)
  }

  def methodWithAbstractHandlerUserTypeSubtype(handler: JAbstractHandlerUserType): Unit = {
    asJava.methodWithAbstractHandlerUserTypeSubtype(handler.asJava)
  }

  def methodWithConcreteHandlerUserTypeSubtypeExtension(handler: JConcreteHandlerUserTypeExtension): Unit = {
    asJava.methodWithConcreteHandlerUserTypeSubtypeExtension(handler.asJava)
  }

  def methodWithHandlerVoid(handler: Void => Unit): Unit = {
    asJava.methodWithHandlerVoid((p:Void) => handler(p))
  }

  def methodWithHandlerAsyncResultVoid(sendFailure: java.lang.Boolean, handler: AsyncResult[Void] => Unit): Unit = {
    asJava.methodWithHandlerAsyncResultVoid(sendFailure, (p:AsyncResult[Void]) => handler(p))
  }

  def methodWithHandlerThrowable(handler: Throwable => Unit): Unit = {
    asJava.methodWithHandlerThrowable((p:Throwable) => handler(p))
  }

  def methodWithHandlerDataObject(handler: JTestDataObject => Unit): Unit = {
    asJava.methodWithHandlerDataObject((p:JTestDataObject) => handler(p))
  }

  def methodWithHandlerGenericUserType[U](value: U, handler: JGenericRefedInterface[U] => Unit): Unit = {
    asJava.methodWithHandlerGenericUserType[U](value, (p:JGenericRefedInterface[U]) => handler(p))
  }

  def methodWithHandlerAsyncResultGenericUserType[U](value: U, handler: AsyncResult[JGenericRefedInterface[U]] => Unit): Unit = {
    asJava.methodWithHandlerAsyncResultGenericUserType[U](value, (p:AsyncResult[JGenericRefedInterface[U]]) => handler(p))
  }

  def methodWithByteReturn(): java.lang.Byte = {
    asJava.methodWithByteReturn()
  }

  def methodWithShortReturn(): java.lang.Short = {
    asJava.methodWithShortReturn()
  }

  def methodWithIntReturn(): java.lang.Integer = {
    asJava.methodWithIntReturn()
  }

  def methodWithLongReturn(): java.lang.Long = {
    asJava.methodWithLongReturn()
  }

  def methodWithFloatReturn(): java.lang.Float = {
    asJava.methodWithFloatReturn()
  }

  def methodWithDoubleReturn(): java.lang.Double = {
    asJava.methodWithDoubleReturn()
  }

  def methodWithBooleanReturn(): java.lang.Boolean = {
    asJava.methodWithBooleanReturn()
  }

  def methodWithCharReturn(): java.lang.Character = {
    asJava.methodWithCharReturn()
  }

  def methodWithStringReturn(): String = {
    asJava.methodWithStringReturn()
  }

  def methodWithVertxGenReturn(): JRefedInterface1 = {
    asJava.methodWithVertxGenReturn()
  }

  def methodWithVertxGenNullReturn(): JRefedInterface1 = {
    asJava.methodWithVertxGenNullReturn()
  }

  def methodWithAbstractVertxGenReturn(): JRefedInterface2 = {
    asJava.methodWithAbstractVertxGenReturn()
  }

  def methodWithDataObjectReturn(): JTestDataObject = {
    asJava.methodWithDataObjectReturn()
  }

  def methodWithDataObjectNullReturn(): JTestDataObject = {
    asJava.methodWithDataObjectNullReturn()
  }

  def methodWithGenericUserTypeReturn[U](value: U): JGenericRefedInterface[U] = {
    asJava.methodWithGenericUserTypeReturn[U](value)
  }

  def overloadedMethod(str: String, handler: String => Unit): String = {
    asJava.overloadedMethod(str, (p:String) => handler(p))
  }

  def overloadedMethod(str: String, refed: JRefedInterface1): String = {
    asJava.overloadedMethod(str, refed.asJava)
  }

  def overloadedMethod(str: String, refed: JRefedInterface1, handler: String => Unit): String = {
    asJava.overloadedMethod(str, refed.asJava, (p:String) => handler(p))
  }

  def overloadedMethod(str: String, refed: JRefedInterface1, period: java.lang.Long, handler: String => Unit): String = {
    asJava.overloadedMethod(str, refed.asJava, period, (p:String) => handler(p))
  }

  def methodWithGenericReturn[U](`type`: String): U = {
    asJava.methodWithGenericReturn[U](`type`)
  }

  def methodWithGenericParam[U](`type`: String, u: U): Unit = {
    asJava.methodWithGenericParam[U](`type`, u)
  }

  def methodWithGenericHandler[U](`type`: String, handler: U => Unit): Unit = {
    asJava.methodWithGenericHandler[U](`type`, (p:U) => handler(p))
  }

  def methodWithGenericHandlerAsyncResult[U](`type`: String, asyncResultHandler: AsyncResult[U] => Unit): Unit = {
    asJava.methodWithGenericHandlerAsyncResult[U](`type`, (p:AsyncResult[U]) => asyncResultHandler(p))
  }

  def methodWithJsonObjectReturn(): io.vertx.core.json.JsonObject = {
    asJava.methodWithJsonObjectReturn()
  }

  def methodWithNullJsonObjectReturn(): io.vertx.core.json.JsonObject = {
    asJava.methodWithNullJsonObjectReturn()
  }

  def methodWithComplexJsonObjectReturn(): io.vertx.core.json.JsonObject = {
    asJava.methodWithComplexJsonObjectReturn()
  }

  def methodWithJsonArrayReturn(): io.vertx.core.json.JsonArray = {
    asJava.methodWithJsonArrayReturn()
  }

  def methodWithNullJsonArrayReturn(): io.vertx.core.json.JsonArray = {
    asJava.methodWithNullJsonArrayReturn()
  }

  def methodWithComplexJsonArrayReturn(): io.vertx.core.json.JsonArray = {
    asJava.methodWithComplexJsonArrayReturn()
  }

  def methodWithJsonParams(jsonObject: io.vertx.core.json.JsonObject, jsonArray: io.vertx.core.json.JsonArray): Unit = {
    asJava.methodWithJsonParams(jsonObject, jsonArray)
  }

  def methodWithNullJsonParams(jsonObject: io.vertx.core.json.JsonObject, jsonArray: io.vertx.core.json.JsonArray): Unit = {
    asJava.methodWithNullJsonParams(jsonObject, jsonArray)
  }

  def methodWithHandlerJson(jsonObjectHandler: io.vertx.core.json.JsonObject => Unit, jsonArrayHandler: io.vertx.core.json.JsonArray => Unit): Unit = {
    asJava.methodWithHandlerJson((p:io.vertx.core.json.JsonObject) => jsonObjectHandler(p), (p:io.vertx.core.json.JsonArray) => jsonArrayHandler(p))
  }

  def methodWithHandlerComplexJson(jsonObjectHandler: io.vertx.core.json.JsonObject => Unit, jsonArrayHandler: io.vertx.core.json.JsonArray => Unit): Unit = {
    asJava.methodWithHandlerComplexJson((p:io.vertx.core.json.JsonObject) => jsonObjectHandler(p), (p:io.vertx.core.json.JsonArray) => jsonArrayHandler(p))
  }

  def methodWithHandlerAsyncResultJsonObject(handler: AsyncResult[io.vertx.core.json.JsonObject] => Unit): Unit = {
    asJava.methodWithHandlerAsyncResultJsonObject((p:AsyncResult[io.vertx.core.json.JsonObject]) => handler(p))
  }

  def methodWithHandlerAsyncResultNullJsonObject(handler: AsyncResult[io.vertx.core.json.JsonObject] => Unit): Unit = {
    asJava.methodWithHandlerAsyncResultNullJsonObject((p:AsyncResult[io.vertx.core.json.JsonObject]) => handler(p))
  }

  def methodWithHandlerAsyncResultComplexJsonObject(handler: AsyncResult[io.vertx.core.json.JsonObject] => Unit): Unit = {
    asJava.methodWithHandlerAsyncResultComplexJsonObject((p:AsyncResult[io.vertx.core.json.JsonObject]) => handler(p))
  }

  def methodWithHandlerAsyncResultJsonArray(handler: AsyncResult[io.vertx.core.json.JsonArray] => Unit): Unit = {
    asJava.methodWithHandlerAsyncResultJsonArray((p:AsyncResult[io.vertx.core.json.JsonArray]) => handler(p))
  }

  def methodWithHandlerAsyncResultNullJsonArray(handler: AsyncResult[io.vertx.core.json.JsonArray] => Unit): Unit = {
    asJava.methodWithHandlerAsyncResultNullJsonArray((p:AsyncResult[io.vertx.core.json.JsonArray]) => handler(p))
  }

  def methodWithHandlerAsyncResultComplexJsonArray(handler: AsyncResult[io.vertx.core.json.JsonArray] => Unit): Unit = {
    asJava.methodWithHandlerAsyncResultComplexJsonArray((p:AsyncResult[io.vertx.core.json.JsonArray]) => handler(p))
  }

  def methodWithEnumParam(strVal: String, weirdo: io.vertx.codegen.testmodel.TestEnum): String = {
    asJava.methodWithEnumParam(strVal, weirdo)
  }

  def methodWithEnumReturn(strVal: String): io.vertx.codegen.testmodel.TestEnum = {
    asJava.methodWithEnumReturn(strVal)
  }

  def methodWithGenEnumParam(strVal: String, weirdo: io.vertx.codegen.testmodel.TestGenEnum): String = {
    asJava.methodWithGenEnumParam(strVal, weirdo)
  }

  def methodWithGenEnumReturn(strVal: String): io.vertx.codegen.testmodel.TestGenEnum = {
    asJava.methodWithGenEnumReturn(strVal)
  }

  def methodWithThrowableReturn(strVal: String): Throwable = {
    asJava.methodWithThrowableReturn(strVal)
  }

  def methodWithThrowableParam(t: Throwable): String = {
    asJava.methodWithThrowableParam(t)
  }

  def superMethodOverloadedBySubclass(s: String): java.lang.Integer = {
    asJava.superMethodOverloadedBySubclass(s)
  }

  def methodWithCachedReturn(foo: String): JRefedInterface1 = {
    asJava.methodWithCachedReturn(foo)
  }

  def methodWithCachedReturnPrimitive(arg: java.lang.Integer): java.lang.Integer = {
    asJava.methodWithCachedReturnPrimitive(arg)
  }

  def methodWithCachedListReturn(): List[JRefedInterface1] = {
    asJava.methodWithCachedListReturn().asScala.toList
  }

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

  def methodWithHandlerAsyncResultDataObjectFuture(sendFailure: java.lang.Boolean): scala.concurrent.Future[JTestDataObject] = {
    val promise = Promise[JTestDataObject]()
    asJava.methodWithHandlerAsyncResultDataObject(sendFailure, {a:AsyncResult[io.vertx.codegen.testmodel.TestDataObject] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

  def methodWithHandlerAsyncResultUserTypesFuture(): scala.concurrent.Future[JRefedInterface1] = {
    val promise = Promise[JRefedInterface1]()
    asJava.methodWithHandlerAsyncResultUserTypes({a:AsyncResult[io.vertx.codegen.testmodel.RefedInterface1] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

  def methodWithHandlerAsyncResultVoidFuture(sendFailure: java.lang.Boolean): scala.concurrent.Future[Unit] = {
    val promise = Promise[Unit]()
    asJava.methodWithHandlerAsyncResultVoid(sendFailure, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
    promise.future
  }

  def methodWithHandlerAsyncResultGenericUserTypeFuture[U](value: U): scala.concurrent.Future[JGenericRefedInterface[U]] = {
    val promise = Promise[JGenericRefedInterface[U]]()
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
