package com.siby.scalatest_examples.funsuite

import org.scalatest.{Tag, FunSuite}

import scala.collection.mutable.ListBuffer



class ExampleSuite extends FunSuite {
  test("addition", FastTest) {
    assert(2 + 3 == 5)
  }

  test("subtraction", FastTest) {
    assert(3 - 2 == 1)
  }

  test("mod", FastTest) {
    info("2%3")
    assert(2 % 3 == 2)
  }

  test("multiplication")(pending)

  def fixture = new {
    val builder = new StringBuilder("ScalaTest is")
    val buffer = new ListBuffer[String]
  }

  test("easy") {
    val f = fixture
    f.builder.append(" easy")
    assert(f.builder.toString() == "ScalaTest is easy")
    f.buffer += "sweet"
  }

  test("fun") {
    val f = fixture
    f.builder.append(" fun")
    assert(f.builder.toString() == "ScalaTest is fun")
    assert(f.buffer.isEmpty)
  }

  trait fixtureTrait {
    val setUp: StringBuilder = new StringBuilder("Check")
    val bufferInTrait = new ListBuffer[String]
  }

  test("fixtureTrait") {
    new fixtureTrait {
      setUp.append(" fixtureTrait")
      info(setUp.toString())
      assert(bufferInTrait.isEmpty)
      assert(setUp.toString() === "Check fixtureTrait")
    }
  }
}
