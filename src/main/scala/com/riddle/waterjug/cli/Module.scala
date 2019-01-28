package com.riddle.waterjug.cli

import com.riddle.waterjug.core.SolveRiddle

trait Module {
  // Requires
  def solveRiddle: SolveRiddle

  // Privates
  private val BannerFile = "banner.txt"
  private val printIntro = () => CliOps.printIntro(BannerFile)
  private val readInputParameters = () => CliOps.readInputParameters()
  private val printOutcome = CliOps.printOutcome _
  private val readRunAgain = () => CliOps.readRunAgain()
  private val cliLauncher =  new CliLauncher(printIntro, readInputParameters, solveRiddle, printOutcome, readRunAgain)

  // Provides
  val launch: () => Unit = () => {
    cliLauncher.launch()
  }
}
