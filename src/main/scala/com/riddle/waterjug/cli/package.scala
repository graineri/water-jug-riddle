package com.riddle.waterjug

import com.riddle.waterjug.core.RiddleOutcome

package object cli {
  private[cli] type Print = () => Unit
  private[cli] type ReadInputParameters = () => InputParameters
  private[cli] type PrintOutcome = RiddleOutcome => Unit
  private[cli] type ReadRunAgain = () => Boolean

  private[cli] case class InputParameters(x: Int, y: Int, z: Int)
}
