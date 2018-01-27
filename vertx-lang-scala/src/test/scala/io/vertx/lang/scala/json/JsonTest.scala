/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.vertx.lang.scala.json

import io.vertx.scala.core._
import org.junit.Test
import org.junit.Assert.assertEquals

/**
 * @author Edgar Chan
 * @author <a href="http://www.campudus.com/">Joern Bernhardt</a>
 */
class JsonTest {

  @Test
  def jsonObjectTest() {

    val enc = """{"foo":"foo text","bar":3.45,"baz":false,"myInt":2147483647}"""

    val obj: JsonObject =
      JsonObject(
        "foo" -> "foo text",
        "bar" -> 3.45d,
        "baz" -> false,
        "myInt" -> Integer.MAX_VALUE)

    assertEquals("foo text", obj.getString("foo"))
    assertEquals(3.45d, obj.getDouble("bar"), 1e-15)
    assertEquals(false, obj.getBoolean("baz"))
    assertEquals(Integer.MAX_VALUE, obj.getInteger("myInt"))
    assertEquals(enc, obj.encode())

  }

  @Test
  def jsonArrayTest() {

    val enc = """["f",3,"b",7,35.4,true]"""
    val array = JsonArray("f", 3, "b", 7, 35.4f, true)

    assertEquals(6, array.size())
    assertEquals(enc, array.encode())
  }
/*
  @Test @Ignore("https://groups.google.com/forum/?fromgroups=#!topic/vertx/TJ2B3D_1zrA and https://groups.google.com/forum/?fromgroups=#!topic/vertx/lOmoB96w8hc")
  def customObjTest() {
    import java.util.Date

    case class Custom(date: Date, other: Boolean)
    val info = Custom(new Date(), false)
    val obj1 = JsonObject("custom" -> info)

    assertEquals(info, obj1.getValue[Custom]("custom"))
  }
*/
  @Test
  def nestedObjectsTest() {
    val obj =
      JsonObject(
        "webappconf" -> JsonObject(
          "port" -> 8080,
          "ssl" -> false,
          "bridge" -> true,
          "some_nested" -> JsonArray(1, 2, JsonObject("next" -> JsonArray(3, 4))),
          "some_list" -> JsonArray(1, 2, JsonArray(3, 4)),
          "inbound_permitted" -> JsonArray(
            JsonObject(
              "address" -> "acme.bar",
              "match" -> JsonObject(
                "action" -> "foo")),
            JsonObject(
              "address" -> "acme.baz",
              "match" -> JsonObject(
                "action" -> "index"))),
          "outbound_permitted" -> JsonArray(
            new JsonObject())))

    assertEquals(jsonString, obj.encode())
  }

  @Test
  def nestedObjectsWithListsTest() {
    val obj =
      JsonObject(
        "webappconf" -> JsonObject(
          "port" -> 8080,
          "ssl" -> false,
          "bridge" -> true,
          "some_nested" -> List(1, 2, JsonObject("next" -> List(3, 4))),
          "some_list" -> List(1, 2, List(3, 4)),
          "inbound_permitted" -> List(
            JsonObject(
              "address" -> "acme.bar",
              "match" -> JsonObject(
                "action" -> "foo")),
            JsonObject(
              "address" -> "acme.baz",
              "match" -> JsonObject(
                "action" -> "index"))),
          "outbound_permitted" -> List(new JsonObject())))

    assertEquals(jsonString, obj.encode())
  }

  @Test
  def nestedObjectsWithArraysTest() {
    val obj =
      JsonObject(
        "webappconf" -> JsonObject(
          "port" -> 8080,
          "ssl" -> false,
          "bridge" -> true,
          "some_nested" -> Array(1, 2, JsonObject("next" -> Array(3, 4))),
          "some_list" -> Array(1, 2, Array(3, 4)),
          "inbound_permitted" -> Array(
            JsonObject(
              "address" -> "acme.bar",
              "match" -> JsonObject(
                "action" -> "foo")),
            JsonObject(
              "address" -> "acme.baz",
              "match" -> JsonObject(
                "action" -> "index"))),
          "outbound_permitted" -> Array(new JsonObject())))

    assertEquals(jsonString, obj.encode())
  }

  @Test
  def mixedNestedObjectsTest() {
    val obj =
      JsonObject(
        "webappconf" -> JsonObject(
          "port" -> 8080,
          "ssl" -> false,
          "bridge" -> true,
          "some_nested" -> Vector(1, 2, JsonObject("next" -> List(3, 4))),
          "some_list" -> JsonArray(1, 2, Vector(3, 4)),
          "inbound_permitted" -> List(
            JsonObject(
              "address" -> "acme.bar",
              "match" -> JsonObject(
                "action" -> "foo")),
            JsonObject(
              "address" -> "acme.baz",
              "match" -> JsonObject(
                "action" -> "index"))),
          "outbound_permitted" -> Array(new JsonObject())))

    assertEquals(jsonString, obj.encode())
  }

  private def jsonString = {
    """
      |{
      |  "webappconf" : {
      |          "port": 8080,
      |          "ssl": false,
      |          "bridge": true,
      |          "some_nested": [1, 2, { "next": [3, 4] }],
      |          "some_list": [1, 2, [3, 4]],
      |          "inbound_permitted": [
      |            {
      |              "address" : "acme.bar",
      |              "match" : {
      |                "action" : "foo"
      |              }
      |            },
      |
      |            {
      |              "address" : "acme.baz",
      |              "match" : {
      |                "action" : "index"
      |              }
      |            }
      |          ],
      |
      |          "outbound_permitted": [
      |            {}
      |          ]
      |        }
      |}
    """.stripMargin.replaceAll("\\s", "")
  }

}
