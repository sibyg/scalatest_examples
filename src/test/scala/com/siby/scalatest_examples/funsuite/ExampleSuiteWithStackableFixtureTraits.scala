package com.siby.scalatest_examples.funsuite

import org.scalatest.{FunSuite, Suite, BeforeAndAfterEach}

import scala.collection.mutable.ListBuffer

trait Builder extends BeforeAndAfterEach {
  this: Suite =>
  val builder = new StringBuilder

  override protected def beforeEach(): Unit = {
    builder.append("ScalaTest is ")
    super.beforeEach()
  }

  override protected def afterEach(): Unit = {
    try {
      builder.clear()
    } finally {
      super.afterEach()
    }
  }
}

trait Buffer extends BeforeAndAfterEach {
  this: Suite =>
  val buffer = new ListBuffer[String]

  override protected def beforeEach(): Unit = {
    super.beforeEach()
  }

  override protected def afterEach(): Unit = {
    try {
      buffer.clear()
    } finally {
      super.afterEach()
    }
  }
}

class ExampleSuiteWithStackableFixtureTraits extends FunSuite with Builder with Buffer {
  test("easy") {
    builder.append("easy!")
    assert(builder.toString === "ScalaTest is easy!")
    assert(buffer.isEmpty)
    buffer += "sweet"
  }

  test("fun") {
    builder.append("fun!")
    assert(builder.toString === "ScalaTest is fun!")
    assert(buffer.isEmpty)
    buffer += "clear"
  }
}
