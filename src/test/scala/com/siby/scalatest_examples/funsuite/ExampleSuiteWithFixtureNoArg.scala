package com.siby.scalatest_examples.funsuite

import org.scalatest.{Outcome, FunSuite}
import scala.collection.mutable.ListBuffer

class ExampleSuiteWithFixtureNoArg extends FunSuite {

  val builder = new StringBuilder
  val buffer = new ListBuffer[String]


  override protected def withFixture(test: NoArgTest): Outcome = {
    try {
      builder.append("Scalatest is") // perform setup
      super.withFixture(test)
    } finally {
      builder.clear() // perform cleanup
      buffer.clear()
    }
  }

  test("fun") {
    builder.append(" fun")
    assert(builder.toString() === "Scalatest is fun")
    assert(buffer.isEmpty)
  }
}
