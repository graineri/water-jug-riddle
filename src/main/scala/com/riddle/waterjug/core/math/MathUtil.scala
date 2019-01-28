package com.riddle.waterjug.core.math

import scala.annotation.tailrec

object MathUtil {
  @tailrec
  def gcd(a: Int, b: Int): Int = if (b == 0) a.abs else gcd(b, a % b)

  def isMultiple(a: Int, b: Int): Boolean = if (b == 0) false else a % b == 0
}
