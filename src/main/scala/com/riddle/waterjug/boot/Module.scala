package com.riddle.waterjug.boot

trait Module {
  // Requires
  def launch: () => Unit

  // Provides
  def apply(args: Array[String]): Unit = {
    launch()
  }
}
