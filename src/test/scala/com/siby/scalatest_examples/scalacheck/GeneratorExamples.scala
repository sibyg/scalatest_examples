package com.siby.scalatest_examples.scalacheck

import org.scalacheck.{Arbitrary, Gen}

object GeneratorExamples extends App {

  private val gen: Gen[(Int, Int)] = for {
    a <- Gen.choose(1, 100) suchThat (_ % 2 == 0)
    b <- Gen.choose(1, 100) suchThat (_ % 3 == 0)
  } yield (a, b)
  val myGen = gen.sample

  val smallEvenInteger: Gen[Int] = Gen.choose(0, 200) suchThat (_ % 2 == 0)

  smallEvenInteger.sample match {
    case Some(x) => println(x)
    case None => // do nothing
  }

  val vowel = Gen.oneOf('a', 'e', 'i', 'o', 'u')

  println("Arbitrary=" + Arbitrary.arbitrary[Int].sample)
}
