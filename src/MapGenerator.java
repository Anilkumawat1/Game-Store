import java.awt.*;

public class MapGenerator {

    public int[][] map;
    public int brickwidth;
    public int brickheight;

    public MapGenerator(int row, int col) {
        map = new int[row][col];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = 1;     //  1 detect that the ball has not intersected with the brick and
                //  add the brick to the panel if 0 is there then it will not generate any brick
            }
        }

        brickwidth = 540 / col;
        brickheight = 150 / row;

    }

    public void draw(Graphics2D g) {

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] > 0) {
                    g.setColor(Color.WHITE);
                    g.fillRect(j * brickwidth + 80, i * brickheight + 50, brickwidth, brickheight);

                    // creating border in between rectangle to make separate bricks
                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.BLACK);
                    g.drawRect(j * brickwidth + 80, i * brickheight + 50, brickwidth, brickheight);
                }
            }
        }

    }

    public void setBrickValue(int value, int row, int col) {
        map[row][col] = value;             // used to remove brick when ball intersect by making value 0

    }
}