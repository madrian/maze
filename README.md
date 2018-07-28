# Maze
Maze is simple demo app on path traversal.

## Problem
Given a rectangular matrix of length `l`, width `w`, start node `a`, and end node `b`, traverse the matrix and find a path from node `a` to node `b`. Some nodes in the matrix may be blocked and cannot be passed through.

## Solution
Define each node as a `Room` with four possible directions: `east`, `west`, `north`, and `south`. A room will also have flags to indicated if it's `blocked` or `visited`.

### Room
#### Directions
  * EAST
  * WEST
  * NORTH
  * SOUTH

#### Flags
  * blocked
  * visited
  
### Path algorithm
The class `PathSolver` is the core implementation that finds a `Path` of traversal consisting of combinations of `Direction`s east, west, south and north. It uses a recursive method `move(Room a, Room b, Path path)` that tries all directions from room `a` to room `b` and saving the directions on `path` on each recursive call to `move`.

