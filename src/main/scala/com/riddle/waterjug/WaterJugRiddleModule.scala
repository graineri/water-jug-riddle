package com.riddle.waterjug

/**
  * Water Jug Riddle's module: binds all application modules together.
  *
  * @note BEWARE! THE ORDER IN WHICH MODULES ARE MIXED-IN IS IMPORTANT, AS NON-LAZY VALS REQUIRE ALL OF ITS DEPENDENCIES
  *       TO BE PREVIOUSLY INSTANTIATED. SO, MODULES THAT COME FIRST ARE GENERALLY PROVIDERS OF THOSE BELOW THEM.
  */
object WaterJugRiddleModule
  extends core.Module
  with cli.Module
  with boot.Module
