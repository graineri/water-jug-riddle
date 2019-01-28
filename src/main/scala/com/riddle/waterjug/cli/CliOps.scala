package com.riddle.waterjug.cli

import com.riddle.waterjug.core._

import scala.io.{Source, StdIn}
import scala.util.Try

object CliOps {

  def printIntro(bannerFile: String): Unit = {
    printBanner(bannerFile)
    printInstructions()
  }

  def printBanner(bannerFile: String): Unit = println(Source.fromResource(bannerFile).mkString)

  def printInstructions(): Unit = println(
    "You have an X-gallon and a Y-gallon jug that you can fill from a lake.\n" +
    "Assume lake has unlimited amount of water.\n" +
    "By using only an X-gallon and Y-gallon jug (no third jug), measure Z gallons of water.\n")

  def readInputParameters(): InputParameters = {
    val x = readInt("Enter gallons for Jug X: ")
    val y = readInt("Enter gallons for Jug Y: ")
    val z = readInt("Enter the gallons you want to measure (Z): ")

    InputParameters(x, y, z)
  }

  def printOutcome(outcome: RiddleOutcome): Unit = {
    outcome match {
      case NoSolution(_) =>
        println("\nNo Solution!")

      case Solution(actions, states) =>
        println("\nSolution found!\n")
        println(s"Number of steps: ${actions.length}")
        print("Detail: ")
        printSolution(actions, states)
    }
  }

  def readRunAgain(): Boolean = {
    print("Run again? [y/n] Default: Yes -> ")
    val runAgain = StdIn.readLine()
    runAgain.isEmpty || runAgain == "y"
  }

  private def printSolution(actions: Seq[Action], states: Seq[JugState]): Unit = {
    states match {
      case head :: Nil => print(s"$head\n\n")

      case head :: tail =>
        print(s"$head -> ")
        print(actions.head)
        printSolution(actions.tail, tail)
    }
  }

  private def readInt(prompt: String): Int = {
    print(prompt)
    Try(StdIn.readInt())
      .filter(_ > 0)
      .getOrElse(readInt(prompt))
  }
}
