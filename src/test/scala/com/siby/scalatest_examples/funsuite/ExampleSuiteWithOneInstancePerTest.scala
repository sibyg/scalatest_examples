package com.siby.scalatest_examples.funsuite

import org.scalatest.FunSuite
import org.scalatest.OneInstancePerTest

import scala.collection.mutable.ListBuffer

class ExampleSuiteWithOneInstancePerTest extends FunSuite with OneInstancePerTest {
  val builder = new StringBuilder("ScalaTest is")
  val buffer = new ListBuffer[String]

  test("easy") {
    builder.append(" easy")
    buffer+= "easy"
    assert(buffer.nonEmpty)
  }

  test("fun") {
    assert(builder.toString() === "ScalaTest is")
    assert(buffer.isEmpty)
  }
}
