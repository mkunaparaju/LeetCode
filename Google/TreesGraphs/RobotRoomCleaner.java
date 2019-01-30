package Google.TreesGraphs;

import Microsoft.TreesAndGraphs.Inorder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

interface Robot {
    // Returns true if the cell in front is open and robot moves into the cell.
    // Returns false if the cell in front is blocked and robot stays in the current cell.
    public boolean move();

    // Robot will stay in the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    public void turnLeft();

    public void turnRight();

    // Clean the current cell.
    public void clean();
}


/*

room = [
  [1,1,1,1,1,0,1,1],
  [1,1,1,1,1,0,1,1],
  [1,0,1,1,1,1,1,1],
  [0,0,0,1,0,0,0,0],
  [1,1,1,1,1,1,1,1]
],
row = 1,
col = 3

 */
public class RobotRoomCleaner {

    public void cleanRoom(Robot robot) {
        HashSet<String> visited = new HashSet<>();
        cleanRoom(robot, 0,0,0, visited);
    }

    private void cleanRoom(Robot robot, int x, int y, int dir, HashSet<String> visited) {
        if(visited.contains(x + " " + y)) return;
        visited.add(x+" " + y);
        robot.clean();

        for(int n =0; n< 4; n++){
            if(robot.move()){
                int i = x, j = y;
                switch(dir){
                    case 0:
                        i = x - 1;
                        break;
                    case 1:
                        j = y+1;
                        break;
                    case 2:
                        i = x+ 1;
                        break;
                    case 3:
                        j = y- 1;
                        break;
                }
                cleanRoom(robot,i,j,dir,visited);
                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
            robot.turnRight();
            dir = (dir+1) %4;
        }
    }



}
