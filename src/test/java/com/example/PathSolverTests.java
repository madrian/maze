package com.example;

import org.junit.Assert;
import org.junit.Test;

public class PathSolverTests {

    /**
     *   [e][e][e][e][s]
     *   [ ][ ][ ][ ][s]
     *   [ ][ ][ ][ ][s]
     *   [ ][ ][ ][ ][s]
     *   [ ][ ][ ][ ][x]
     */
    @Test
    public void testPathSolverBasic() {
        Maze maze = new Maze(5, 5);
        PathSolver solver = new PathSolver();
        Path actual = solver.solve(maze);
        Path expected = new Path();
        expected.add(Direction.EAST, 4);
        expected.add(Direction.SOUTH, 4);
        Assert.assertEquals(expected, actual);
    }

    /**
     *   [s][#][ ][ ][ ]
     *   [e][e][e][e][s]
     *   [ ][ ][ ][ ][s]
     *   [ ][ ][ ][ ][s]
     *   [ ][ ][ ][ ][x]
     */
    @Test
    public void testPathSolverBlockOne() {
        Maze maze = new Maze(5, 5);
        maze.map[1][0].isBlocked = true;
        PathSolver solver = new PathSolver();
        Path actual = solver.solve(maze);
        Path expected = new Path();
        expected.add(Direction.SOUTH);
        expected.add(Direction.EAST, 4);
        expected.add(Direction.SOUTH, 3);
        Assert.assertEquals(expected, actual);
    }

    /**
     *   [s][#][ ][ ][ ]
     *   [e][e][e][e][s]
     *   [ ][ ][ ][s][w]
     *   [ ][ ][ ][s][#]
     *   [ ][ ][ ][e][x]
     */
    @Test
    public void testPathSolverBlockTwo() {
        Maze maze = new Maze(5, 5);
        maze.map[1][0].isBlocked = true;
        maze.map[4][3].isBlocked = true;
        PathSolver solver = new PathSolver();
        Path actual = solver.solve(maze);
        Path expected = new Path();
        expected.add(Direction.SOUTH);
        expected.add(Direction.EAST, 4);
        expected.add(Direction.SOUTH);
        expected.add(Direction.WEST);
        expected.add(Direction.SOUTH, 2);
        expected.add(Direction.EAST);
        Assert.assertEquals(expected, actual);
    }

    /**
     *   [ ][ ][ ][ ][ ]
     *   [ ][ ][ ][ ][ ]
     *   [ ][ ][ ][ ][ ]
     *   [ ][ ][ ][ ][#]
     *   [ ][ ][ ][#][ ]
     */
    @Test
    public void testPathSolverBlockPath() {
        Maze maze = new Maze(5, 5);
        maze.map[3][4].isBlocked = true;
        maze.map[4][3].isBlocked = true;
        PathSolver solver = new PathSolver();
        Path path = solver.solve(maze);
        Assert.assertEquals(path, new Path());
    }

    /**
     *   [s][#][e][e][s]
     *   [s][#][n][#][s]
     *   [s][#][n][#][s]
     *   [s][#][n][#][s]
     *   [e][e][n][#][x]
     */
    @Test
    public void testPathSolverBlockSnake() {
        Maze maze = new Maze(5, 5);
        maze.map[1][0].isBlocked = true;
        maze.map[1][1].isBlocked = true;
        maze.map[1][2].isBlocked = true;
        maze.map[1][3].isBlocked = true;
        maze.map[3][1].isBlocked = true;
        maze.map[3][2].isBlocked = true;
        maze.map[3][3].isBlocked = true;
        maze.map[3][4].isBlocked = true;
        PathSolver solver = new PathSolver();
        Path actual = solver.solve(maze);
        Path expected = new Path();
        expected.add(Direction.SOUTH, 4);
        expected.add(Direction.EAST, 2);
        expected.add(Direction.NORTH,4);
        expected.add(Direction.EAST, 2);
        expected.add(Direction.SOUTH, 4);
        Assert.assertEquals(expected, actual);
    }
}
