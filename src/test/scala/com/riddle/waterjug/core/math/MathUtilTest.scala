package com.riddle.waterjug.core.math

import com.riddle.waterjug.Test
import com.riddle.waterjug.core.math.MathUtil._

class MathUtilTest extends Test {

  "Math Util" - {
    "should return the greatest common divisor" in {
      gcd(1, 2) shouldEqual 1
      gcd(78, 188) shouldEqual 2
      gcd(30, 60) shouldEqual 30
      gcd(-108, -56) shouldEqual 4
      gcd(1, 0) shouldEqual 1 // Expected though not correct.
      gcd(0, 1) shouldEqual 1 // Expected though not correct.
    }

    "should return whether a number is multiple of another" in {
      isMultiple(1, 0) shouldBe false
      isMultiple(0, 1) shouldBe true
      isMultiple(2, 1) shouldBe true
      isMultiple(1, 2) shouldBe false
      isMultiple(10, 2) shouldBe true
    }
  }
}
