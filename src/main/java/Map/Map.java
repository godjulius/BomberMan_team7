package Map;

import BomberMan.constValue.constValue;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Map {
    /*private final Image tileMap_0 = new Image("file:src/Image/brick.png",
                                                 Constant.ENTITY_SIZE,
                                                 Constant.ENTITY_SIZE,
                                              true, true);

    /*private final Image tileMap_1 = new Image("file:src/Image/glass.png",
                                                 Constant.ENTITY_SIZE,
                                                 Constant.ENTITY_SIZE,
                                              true, true);*/
    private final Image tileMap_2 = new Image("file:readme/wall.png",
                                                 constValue.ENTITY_SIZE,
                                                 constValue.ENTITY_SIZE,
                                              true, true);

    private int[][] mapTitle = new int[20][40];
    private Image[][]imagesMap = new Image[20][40];



    public Map() {
        //super();
    }

    public void LoadMap(int level) throws FileNotFoundException {
        Scanner input = new Scanner(new File("src/main/resources/assets/levels/MapGame1.txt"));
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 40; j++){
                int a = input.nextInt();
                mapTitle[i][j] = a;
            }
        }

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 40; j++) {
                switch (mapTitle[i][j]) {
                    /*case 0:
                        imagesMap[i][j] = tileMap_0;
                        break;
                    /*case 1:
                        imagesMap[i][j] = tileMap_1;
                        break;*/
                    case 2:
                        imagesMap[i][j] = tileMap_2;
                        break;
                }
            }
        }

    }

    public void DrawMap(GraphicsContext mainGraphic) {
        int x_pos = 0;
        int y_pos = 30;

        int width =(int) constValue.FRAME_SIZE;
        int hight =(int) constValue.FRAME_SIZE;

        for (int i = 0; i < 20; i++) {
            x_pos = 0;
            for (int j = 0; j < 40; j++) {
                mainGraphic.drawImage(imagesMap[i][j],x_pos,y_pos);
                x_pos = x_pos + width;
            }
            y_pos = y_pos + hight;
        }
    }

    public Image[][] getImagesMap() {
        return imagesMap;
    }

    public int[][] getMapTitle() {
        return mapTitle;
    }
}