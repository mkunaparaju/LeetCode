package GoldmanSachs;

public class RobotReturn {
    public static void main(String[] args) {
        RobotReturn rr = new RobotReturn();
        System.out.println(rr.judgeCircle("UD"));
    }
    public boolean judgeCircle(String moves) {
        String [] in = moves.split("");
        int row = 0;
        int col = 0;

        for(int i = 0 ; i < in.length; i++){

            switch(in[i]){
                case "U":
                    col++;
                    break;

                case "D":
                    col--;
                    break;

                case "L":
                    row--;
                    break;

                case "R":
                    row++;
                    break;

            }
        }

        return (row == 0 && col == 0);
    }
}
