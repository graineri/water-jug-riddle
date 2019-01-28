# Water Jug Riddle

## Overview
Build an application that solves the Water Jug Riddle for dynamic inputs (X, Y, Z). The simulation
should have a UI to display state changes for each state for each jug (Empty, Full or Partially Full).
You have an X-gallon and a Y-gallon jug that you can fill from a lake. (Assume lake has unlimited
amount of water.) By using only an X-gallon and Y-gallon jug (no third jug), measure Z gallons of
water.

## Goals
1. Measure Z gallons of water in the most efficient ​way.
2. Build a UI where a user can enter any input for X, Y, Z and see the solution.
3. If no solution, display “No Solution”.

## Limitations
* No partial measurement. Each jug can be empty or full.
* Actions allowed: Fill, Empty, Transfer.
* Use one of the following programming languages: Scala, Java, Nodejs, Go, Python, C, C++, Kotlin.

## Deliverables
The application source code should be on Github and a link should be provided. If this is not an
option, a public link to the application source code or a zip archive is also acceptable.

## Evaluation Criterias
* Functionality
* Efficiency (Time, Space)
* Code Quality / Design / Patterns
* Testability
* UI/UX design

----

## How to run the application

`$> sbt run`

or 

`$> sbt` and once inside `sbt` console, execute `run`. 

You should the following output:
```

 _    _       _                 ___               ______ _     _     _ _
| |  | |     | |               |_  |              | ___ (_)   | |   | | |
| |  | | __ _| |_ ___ _ __       | |_   _  __ _   | |_/ /_  __| | __| | | ___
| |/\| |/ _` | __/ _ \ '__|      | | | | |/ _` |  |    /| |/ _` |/ _` | |/ _ \
\  /\  / (_| | ||  __/ |     /\__/ / |_| | (_| |  | |\ \| | (_| | (_| | |  __/
 \/  \/ \__,_|\__\___|_|     \____/ \__,_|\__, |  \_| \_|_|\__,_|\__,_|_|\___|
                                           __/ |
                                          |___/

You have an X-gallon and a Y-gallon jug that you can fill from a lake.
Assume lake has unlimited amount of water.
By using only an X-gallon and Y-gallon jug (no third jug), measure Z gallons of water.

Enter gallons for Jug X:
```

Follow the instructions.

## How to run the tests
`$> sbt test` 

or

`$> sbt` and once inside `sbt` console, execute `test`.