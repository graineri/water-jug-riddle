package com.riddle.waterjug.core

import com.riddle.waterjug.core.solver.DefaultRiddleSolver

trait Module {
  // Provides
  val solveRiddle: SolveRiddle = new DefaultRiddleSolver().solve
}
