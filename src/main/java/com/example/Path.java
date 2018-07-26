package com.example;

import java.util.ArrayList;
import java.util.List;

public class Path {
    List<Direction> path = new ArrayList<Direction>();
    boolean isFound;

    public Path add(Direction d) {
        path.add(d);
        return this;
    }

    public Path add(Direction d, int frequency) {
        while(frequency-- > 0) path.add(d);
        return this;
    }

    public void removeLast() {
        if(path.size() > 0)
            path.remove(path.size() - 1);
    }

    public void print() {
        System.out.println(this.toString());
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || !(obj instanceof Path)) return false;
        Path other = (Path)obj;
        for(int i = 0; i < other.path.size(); i++) {
            if(!this.path.get(i).equals(other.path.get(i)))
                return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Direction d : path) {
            sb.append(d + "->");
        }
        sb.append("x");
        return sb.toString();
    }
}
