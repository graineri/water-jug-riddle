package com.riddle.waterjug

package object core {
  type JugSize = Int
  type Measurement = Int
  type JugState = (Measurement, Measurement)

  type SolveRiddle = (JugSize, JugSize, Measurement) => RiddleOutcome

  sealed trait Action
  case object Empty extends Action
  case object Fill extends Action
  case object Transfer extends Action

  sealed trait RiddleOutcome
  case class NoSolution(reason: String) extends RiddleOutcome
  case class Solution(actions: Seq[Action], states: Seq[JugState]) extends RiddleOutcome
}
