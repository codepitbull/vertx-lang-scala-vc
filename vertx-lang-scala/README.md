Disclaimer
==========
The code in here is currently in an early preview state following the principle of 'First make it work, then make it beautiful'*[]: 
__It has not yet been optimized for performance and contains a lot of boilerplate.__


Using it
========

After building this project you can start using it with the g8 prototype:

```sbt new vert-x3/vertx-scala.g8```

If you want to play with Vert.x-web and the security modules check out and build:

[Vert.x Scala Lang Stack](https://github.com/codepitbull/vertx-lang-scala-stack)

Diversions from Vert.x-API
==========================

Futures, Promises and the VertxExecutionContext
===============================================
Scala has built in Promises/Futures. They're a perfect replacement for completionHandlers and so on.
To use them we needed an _implicit VertxExectionContext_ which is available inside every Verticle deriving from 
 ScalaVerticle.
 
Using Scala-Futures removes the need for the Vert.x-CompositeFuture and makes for a more fluent programming experience:  
```
class PromiseTestVerticle extends ScalaVerticle {

  override def startFuture(): Future[Unit] = {
    Future.sequence(Seq(
      vertx.eventBus().consumer[String]("asd").handler(a => println(a)).completionFuture(),
      vertx.eventBus().consumer[String]("asd2").handler(a => println(a)).completionFuture())
    )
  }
}
```



What are Vert.x Scala Streams?
===========
This project provides a streaming API based on Scala and Vert.x Read/WriteStreams with optional Reactive Streams integration.
Main aim was a convenient way for writing streams and use already existing backpressure mechanisms.
It provides two APIs, one for Vert.x internal usage and another one to integrate with Reactive Streams implementations.

Vert.x Streams
==============
The whole API is based on the concepts of Reactive Streams (the basic Reactive Streams interfaces have been copied and 
renamed to  avoid confusions). I used this approach as we don't have concurrency inside a Verticle, the place a stream 
will be used, and I can therefore ignore several safeguards required by the Reactive Streams TCK. 
To use streams in a vertx-scala project you have to include the following import:
```io.vertx.lang.scala.streams._```
All ReadStream/WriteStream-implementations will now receive additionial methods (if you want to know how google for 
Pimp-My-Library and/or Type classes).
Here's a little example.

``` 
val consumer = vertx.eventBus().consumer[String]("sourceAddress")
    val producer = vertx.eventBus().sender[String]("sinkAddress")

    consumer.bodyStream()
      .stream
      .mapAsync((a:String) => vertx.eventBus().sendFuture[String]("stageAddress", a))
      .mapAsync((a:Message[String]) => vertx.executeBlocking(() => a))
      .map(a => a.body())
      .sink(producer)
      .run()
```

This stream will 
- consume messages from the eventbus ariving on "sourceAddress"
- forward them to "stageAddress"
- after receiving a reply from "stageAddress" it will then redirect the message trhough a blocking call (doesn*'t really make sense, just showing off here ...)
- it will then extract the body
- then it will send the body to "sinkAddress"

That's it.

Reactive Streams
================
This implementation can also integrate with Reactive Streams (it's actually TCK-compliant). As before, eveything you need 
is provided using this import:
```io.vertx.lang.scala.streams._```

A Reactive Streams Publisher will now have a *stream* method which is the entry-point for Vert.x (example taken from 
AkkaIntegrationTest): 

``` 
val source: Source[Int, NotUsed] = Source(0 to 100)
        .map(a => a + 1)
      val src = source.runWith(asPublisher(false))

      src.stream
        .sink(producer)
        .run()
```

Here we see an Akka-Stream being converted to a Publisher and in turn used as entry point for a Vert.x-Stream.
The same works for Reactive Stream Subscribers which can be used as Sinks.

``` 
val akkaFlow: Subscriber[Int] = Flow[Int]
        .runWith(Source.asSubscriber[Int])

      new VertxListSource(List(1, 2, 3, 4, 5)).stream
        .sink(akkaFlow)
        .run()
```
 
How to use it ?
===============

Add the repo to _build.sbt_:
```
resolvers +=
  "Bintray Vert.x Streams" at "http://dl.bintray.com/codepitbull/maven"
```

Add the dependency:
```
"de.codepitbull.scala.vertx" %% "vertx-streams" % "3.5.0.PRE1"
```

Everything is centered around *io.vertx.lang.scala.streams.Stream*. You should never have to access API-classes directly.
Inside a Verticle to the following to get all required operations:
```io.vertx.lang.scala.streams._```

Let's take a look at a small example:
```
val input = vertx.eventBus().consumer[String]("input")
val output = vertx.eventBus().sender[String]("output")
  
input.toSource
  .map(a => a.body())
  .filter(a => a.startsWith("Hello"))
  .sink(output)
  .run()
```
This silly example consumes incoming messages from the *inout*-address, removes all events not starting with "Hello" and
 forwards the remaining ones to the eventbus-address *output*. All covered by backpressure.

