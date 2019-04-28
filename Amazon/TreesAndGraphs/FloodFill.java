package Amazon.TreesAndGraphs;

import java.util.ArrayDeque;
import java.util.Deque;

public class FloodFill {
    public static void main(String[] args) {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int newColor = 2;

        FloodFill fill = new FloodFill();
        image = fill.floodFill(image, 1, 1, newColor);
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Pixel pixel = new Pixel(sr, sc);
        Deque<Pixel> queue = new ArrayDeque<>();
        queue.offer(pixel);
        int initColor = image[sr][sc];

        if(initColor == newColor) return image;

        while (!queue.isEmpty()) {
            Pixel p = queue.poll();
            if (image[p.row][p.col] == initColor) {
                image[p.row][p.col] = newColor;
                if (p.row > 0 && image[p.row - 1][p.col] == initColor) queue.offer(new Pixel(p.row - 1, p.col));
                if (p.col > 0 && image[p.row][p.col - 1] == initColor) queue.offer(new Pixel(p.row, p.col - 1));
                if (p.row < image.length - 1 && image[p.row + 1][p.col] == initColor)
                    queue.offer(new Pixel(p.row + 1, p.col));
                if (p.col < image[0].length - 1 && image[p.row][p.col + 1] == initColor)
                    queue.offer(new Pixel(p.row, p.col + 1));
            }
        }

        return image;
    }
}

class Pixel {
    int row;
    int col;

    Pixel(int row, int col) {
        this.col = col;
        this.row = row;
    }
}