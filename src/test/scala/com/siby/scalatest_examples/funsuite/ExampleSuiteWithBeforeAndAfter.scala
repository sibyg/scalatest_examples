package com.siby.scalatest_examples.funsuite

import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter

import scala.collection.mutable.ListBuffer

class ExampleSuiteWithBeforeAndAfter extends FunSuite with BeforeAndAfter {

  val builder = new StringBuilder
  val buffer = new ListBuffer[String ]

  after {
    builder.clear()
    buffer.clear()
  }

  before {
    builder.append("Scalatest is")
  }

  test("fun") {
    assert(builder.nonEmpty)
  }

  test("easy") {
    assert(builder.toString() === "Scalatest is")
  }
}
