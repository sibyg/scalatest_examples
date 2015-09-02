package com.siby.scalatest_examples.funsuite

import org.scalatest.Tag

object SlowTest extends Tag("com.siby.tags.SlowTest")

object FastTest extends Tag("com.siby.tags.FastTest")