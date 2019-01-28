package com.riddle.waterjug.core.solver

import com.riddle.waterjug.Test
import com.riddle.waterjug.core._

class DefaultRiddleSolverTest extends Test {

  private val solver = new DefaultRiddleSolver

  "Default Riddle Solver" - {
    "should return NoSolution when measurement is not multiple of GCD of jugs" in {
      solver.solve(2, 8, 5) shouldEqual NoSolution("Z is not multiple of gcd(X, Y).")
    }

    "should return NoSolution when measurement is greater than max between jug sizes" in {
      solver.solve(1, 2, 3) shouldEqual NoSolution("Z is greater than max(X, Y).")
    }

    "should return the most efficient solution" in {
      solver.solve(3, 5, 4) shouldEqual Solution(
        actions = Seq(Fill, Transfer, Empty, Transfer, Fill, Transfer),
        states = Seq((0, 0), (0, 5), (3, 2), (0, 2), (2, 0),(2, 5), (3, 4)))
    }
  }
}
