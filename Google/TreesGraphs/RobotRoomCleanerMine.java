package Google.TreesGraphs;

import java.util.HashSet;



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
public class RobotRoomCleanerMine {

    public void cleanRoom(Robot robot) {
        HashSet<String> visited = new HashSet<>();
        cleanRoom(robot, 0,0,0, visited);
    }

    private void cleanRoom(Robot robot, int x, int y, int dir, HashSet<String> visited) {
        if(visited.contains(x + " " + y)) return;
        visited.add(x+" " + y);
        robot.clean();

        if(robot.move()){
            dir = dir%4;
            int i  = getX(x, dir);
            int j = getY(y, dir);
            System.out.println("dir " + dir + " " + i+ " " + j);
            cleanRoom(robot, i, j, dir, visited);
        }
        robot.turnRight();
        if(robot.move()){
            dir = (dir+1)%4;
            int i = getX(x, dir);
            int j = getY(y, dir);
            System.out.println("dir " + dir + " " + i+ " " + j);
            cleanRoom(robot, i, j, dir, visited);
        }
        robot.turnRight();
        if(robot.move()){
            dir = (dir+2)%4;
            int i = getX(x, dir);
            int j = getY(y, dir);
            System.out.println("dir " + dir + " " + i+ " " + j);
            cleanRoom(robot, i, j, dir, visited);
        }
        robot.turnRight();
        if(robot.move()){
            dir = (dir+3)%4;
            int i = getX(x, dir);
            int j = getY(y, dir);
            System.out.println("dir " + dir + " " + i+ " " + j);
            cleanRoom(robot, i, j, dir, visited);
        }
        return;
    }


    private int getX(int x, int dir) {
        switch (dir){
            case 0:
                x = x - 1;
                break;

            case 2:
                x = x + 1;
                break;
        }

        return x;
    }

    private int getY(int y, int dir) {
        switch (dir){
            case 1:
                y = y + 1;
                break;

            case 3:
                y= y - 1;
                break;
        }

        return y;

    }
}
