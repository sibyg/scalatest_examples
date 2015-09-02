package com.siby.scalatest_examples.funsuite

import java.io.{File, FileWriter}

import org.scalatest.FunSuite

import scala.collection.mutable.ListBuffer

class ExampleSuiteWithDifferentFixtures extends FunSuite {
  final val tmpFile = "temp.txt"

  trait Builder {
    val builder = new StringBuilder("Scalatest is")
  }

  trait Buffer {
    val buffer = new ListBuffer[String]
  }

  def withWriter(testCode: FileWriter => Any): Unit = {
    val writer = new FileWriter(tmpFile)
    try {
      testCode(writer)
    } finally {
      writer.close()
    }
  }

  test("productive") {
    new Builder {
      builder.append(" productive")
      assert(builder.toString() === "Scalatest is productive")
    }
  }

  test("effective") {
    new Buffer {
      buffer += "effective"
      assert(buffer === List("effective"))
    }
  }

  test("save") {
    withWriter { writer =>
      writer.write("Save the world")
      writer.flush()
      assert(new File(tmpFile).length === 14)
    }
  }
}
