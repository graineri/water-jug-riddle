package com.riddle.waterjug.core.solver

import com.riddle.waterjug.core._
import com.riddle.waterjug.core.math.MathUtil._

import scala.annotation.tailrec

class DefaultRiddleSolver extends RiddleSolver {

  override def solve(x: JugSize, y: JugSize, z: Measurement): RiddleOutcome = {
    if (!isMultiple(z, gcd(x, y)))
      NoSolution("Z is not multiple of gcd(X, Y).")
    else if (Math.max(x, y) < z)
      NoSolution("Z is greater than max(X, Y).")
    else {
      val s1 = doSolve(x, y, z)
      val s2 = doSolve(y, x, z)
      if (s1.actions.length <= s2.actions.length) s1
      else Solution(s2.actions, s2.states.map(_.swap))
    }
  }

  private def doSolve(x: JugSize, y: JugSize, z: Measurement): Solution = {
    doSolve(x, y, z, Seq(Fill), Seq((0, 0), (x, 0)))
  }

  @tailrec
  private def doSolve(x: JugSize, y: JugSize, z: Measurement, actions: Seq[Action], states: Seq[JugState]): Solution = {
    val (xCurrentState, yCurrentState) = states.last
    if (xCurrentState == z || yCurrentState == z) Solution(actions, states)
    else {
      // Obtain maximum amount of water to be poured.
      val toBePoured = Math.min(xCurrentState, y - yCurrentState)
      val xNew = xCurrentState - toBePoured
      val yNew =  yCurrentState + toBePoured

      if (xNew == z || yNew == z)
        Solution(actions :+ Transfer, states :+ (xNew, yNew))
      else {
        val maybeFillX: Option[(Action, JugState)] = {
          if (xNew == 0) Some(Fill, (x, yNew))
          else None
        }

        val maybeEmptyY: Option[(Action, JugState)] = {
          if (yNew == y) Some(Empty, (xNew, 0))
          else None
        }
        doSolve(x, y, z,
          (actions :+ Transfer)    ++ maybeFillX.map(_._1) ++ maybeEmptyY.map(_._1),
          (states :+ (xNew, yNew)) ++ maybeFillX.map(_._2) ++ maybeEmptyY.map(_._2))
      }
    }
  }
}
