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

package com.acme.scala
import scala.collection.JavaConverters._
import scala.compat.java8.FunctionConverters._
import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import scala.concurrent.Promise

package object pkg{


import com.acme.pkg.sub.{SubInterface => JSubInterface}
import com.acme.pkg.MyInterface
import com.acme.pkg.{MyInterface => JMyInterface}
import io.vertx.codegen.testmodel.{TestInterface => JTestInterface}
import com.acme.pkg.sub.SubInterface
import io.vertx.codegen.testmodel.TestInterface

/**
  */
implicit class MyInterfaceScala(val asJava: JMyInterface) extends AnyVal {


  def sub(): JSubInterface = {
    asJava.sub()
  }

  def method(): JTestInterface = {
    asJava.method()
  }

}

import com.acme.pkg.sub.{SubInterface => JSubInterface}

/**
  */
implicit class SubInterfaceScala(val asJava: JSubInterface) extends AnyVal {


  def reverse(s: String): String = {
    asJava.reverse(s)
  }

}

}
