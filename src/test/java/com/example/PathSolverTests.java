package com.example;

import org.junit.Test;

public class PathSolverTests {

    @Test
    public void testPathSolverBasic() {
        Maze maze = new Maze(5, 5);
        PathSolver solver = new PathSolver();
        Path path = solver.solve(maze);
        path.print();
    }

    @Test
    public void testPathSolverBlockOne() {
        Maze maze = new Maze(5, 5);
        maze.map[1][0].isBlocked = true;
        PathSolver solver = new PathSolver();
        Path path = solver.solve(maze);
        path.print();
    }

    @Test
    public void testPathSolverBlockTwo() {
        Maze maze = new Maze(5, 5);
        maze.map[1][0].isBlocked = true;
        maze.map[4][3].isBlocked = true;
        PathSolver solver = new PathSolver();
        Path path = solver.solve(maze);
        path.print();
    }
}
