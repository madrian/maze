package com.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MazeTests {
    int length;
    int width;
    Maze maze;

    @Before
    public void setUp() {
        length = 16;
        width = 12;
        maze = new Maze(length, width);
    }

    @After
    public void tearDown() {
        length = 0;
        width = 0;
        maze = null;
    }

    @Test
    public void testBuildMazeSize() {
        Maze maze = new Maze(8, 15);
        Assert.assertEquals(8, maze.length);
        Assert.assertEquals(15, maze.width);
    }

    @Test
    public void testBuildMazeStartEnd() {
        Assert.assertNotNull(maze.start);
        Assert.assertNotNull(maze.end);
    }

    @Test
    public void testBuildMapSize() {
        Maze maze = new Maze(5, 8);
        Assert.assertEquals(5, maze.map.length);
        Assert.assertEquals(8, maze.map[0].length);
    }

    @Test
    public void testBuildMapRooms() {
        Maze maze = new Maze(17, 8);
        for(int x = 0; x < 17; x++) {
            for(int y = 0; y < 8; y++) {
                Assert.assertNotNull(maze.map[x][y]);
            }
        }
    }

    @Test
    public void testBuildMapNorthBoundaries() {
        Maze maze = new Maze(4, 15);
        for(int x = 0; x < 4; x++) {
            Assert.assertNull(maze.map[x][0].north);
        }
    }

    @Test
    public void testBuildMapSouthBoundaries() {
        Maze maze = new Maze(8, 10);
        for(int x = 0; x < 8; x++) {
            Assert.assertNull(maze.map[x][9].south);
        }
    }

    @Test
    public void testBuildMapEastBoundaries() {
        Maze maze = new Maze(5, 6);
        for(int y = 0; y < 6; y++) {
            Assert.assertNull(maze.map[4][y].east);
        }
    }

    @Test
    public void testBuildMapWestBoundaries() {
        Maze maze = new Maze(5, 18);
        for(int y = 0; y < 18; y++) {
            Assert.assertNull(maze.map[0][y].west);
        }
    }

}
