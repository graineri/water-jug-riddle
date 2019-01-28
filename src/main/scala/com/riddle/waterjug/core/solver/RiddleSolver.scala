package com.riddle.waterjug.core.solver

import com.riddle.waterjug.core.{JugSize, Measurement, RiddleOutcome}

trait RiddleSolver {
  /**
    * Solves the Water Jug Riddle and returns an outcome.
    *
    * @param x the size of the first jug.
    * @param y the size of the second jug.
    * @param z the amount of water to be measured.
    * @return an outcome for the riddle.
    */
  def solve(x: JugSize, y: JugSize, z: Measurement): RiddleOutcome
}
