package com.riddle.waterjug.cli

import com.riddle.waterjug.core.SolveRiddle

class CliLauncher(printIntro: Print, readInputParameters: ReadInputParameters, solveRiddle: SolveRiddle,
                  printOutCome: PrintOutcome, readRunAgain: ReadRunAgain) {

  def launch(): Unit = {
    printIntro()
    doLaunch()
  }

  private def doLaunch(): Unit = {
    val inputParameters = readInputParameters()
    val outcome = solveRiddle(inputParameters.x, inputParameters.y, inputParameters.z)
    printOutCome(outcome)
    if (readRunAgain()) doLaunch()
  }

}
