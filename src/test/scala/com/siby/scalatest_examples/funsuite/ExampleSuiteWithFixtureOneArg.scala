package com.siby.scalatest_examples.funsuite

import java.io.{File, FileWriter}

import org.scalatest.{Outcome, fixture}

class ExampleSuiteWithFixtureOneArg extends fixture.FunSuite {
  override type FixtureParam = FileWriter
  val tempFile: String = "temp.txt"
  override protected def withFixture(test: OneArgTest): Outcome = {
    val writer = new FileWriter(tempFile)
    try {
      test(writer)
    } finally {
      writer.close()
      new File(tempFile).delete()
    }
  }

  test("easy") { writer =>
    writer.write("easy")
    writer.flush()
    assert(new File(tempFile).length() === 4)
  }
}
