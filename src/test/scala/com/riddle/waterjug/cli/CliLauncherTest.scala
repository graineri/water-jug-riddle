package com.riddle.waterjug.cli

import com.riddle.waterjug.Test
import com.riddle.waterjug.core.{NoSolution, SolveRiddle}
import org.mockito.Mockito.{verify, when}

class CliLauncherTest extends Test {
  "CLI Launcher" - {
    "should launch the CLI application based on dependencies" in {
      val printIntro = mock[Print]
      val readInputParameters = mock[ReadInputParameters]
      val solveRiddle = mock[SolveRiddle]
      val printOutcome = mock[PrintOutcome]
      val readRunAgain = mock[ReadRunAgain]
      val noSolutionOutcome = NoSolution("")
      val cliLauncher = new CliLauncher(printIntro, readInputParameters, solveRiddle, printOutcome, readRunAgain)

      when(readInputParameters.apply).thenReturn(InputParameters(1, 2, 3))
      when(solveRiddle.apply(1, 2, 3)).thenReturn(noSolutionOutcome)
      when(readRunAgain.apply).thenReturn(false)

      cliLauncher.launch()

      verify(printIntro).apply()
      verify(solveRiddle).apply(1, 2, 3)
      verify(printOutcome).apply(noSolutionOutcome)
      verify(readRunAgain).apply()
    }
  }
}
