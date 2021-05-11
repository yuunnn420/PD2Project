package sample;

import javafx.animation.TranslateTransition;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
import javafx.util.Duration;
import javafx.fxml.FXML;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Level1Controller {

    @FXML
    private GridPane gridpane;
    int [][] map =new int[][]{
            {0,0,0,0,0,0,0,0},
            {0,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,1,0},
            {0,0,0,0,0,0,0,0},};
    //0障礙物 1land
    Image playerImage = new Image(getClass().getResourceAsStream("/image/player.png"),100,100,false,false);
    ImageView player = new ImageView(playerImage);
    Image fireImage = new Image(getClass().getResourceAsStream("/image/fire.png"),100,100,false,false);
    ImageView fire = new ImageView(fireImage);
    Image iceImage = new Image(getClass().getResourceAsStream("/image/ice.jpeg"),100,100,false,false);
    ImageView ice = new ImageView(iceImage);
    public void drawMap() {
        for(int i=0;i<6;i++){//h
            for(int j=0;j<8;j++){//w
                if(map[i][j]==1){//land
                    Image landImage = new Image(getClass().getResourceAsStream("/image/land.jpg"),100,100,false,false);
                    ImageView land = new ImageView(landImage);
                    GridPane.setConstraints(land,j,i);
                    gridpane.getChildren().add(land);
                }
                //0
            }
        }
        GridPane.setConstraints(player,1,1);
        gridpane.getChildren().add(player);
        GridPane.setConstraints(ice,2,3);
        gridpane.getChildren().add(ice);
        GridPane.setConstraints(fire,5,1);
        gridpane.getChildren().add(fire);
    }
    @FXML
    void keyPressed(KeyEvent event) {
        switch (event.getCode()) {
            case W:
                GridPane.setRowIndex(player,GridPane.getRowIndex(player)-1);
                System.out.println("up");
                if(GridPane.getRowIndex(player)==GridPane.getRowIndex(ice) && GridPane.getColumnIndex(player)==GridPane.getColumnIndex(ice)) {
                    if (GridPane.getColumnIndex(fire) == GridPane.getColumnIndex(ice) && GridPane.getRowIndex(fire) < GridPane.getRowIndex(ice)) {

                        fire.setVisible(false);
                        ice.setVisible(false);
                    }
                    else {
                        GridPane.setRowIndex(ice, 1);
                    }
                }
                break;
            case A:
                GridPane.setColumnIndex(player,GridPane.getColumnIndex(player)-1);
                System.out.println("left");
                if(GridPane.getRowIndex(player) == GridPane.getRowIndex(ice) && GridPane.getColumnIndex(player)==GridPane.getColumnIndex(ice)) {
                    if (GridPane.getRowIndex(fire) == GridPane.getRowIndex(ice) && GridPane.getColumnIndex(fire) < GridPane.getColumnIndex(ice)) {
                        fire.setVisible(false);
                        ice.setVisible(false);
                    }
                    else {
                        GridPane.setColumnIndex(ice, 1);
                    }
                }
                break;
            case S:
                GridPane.setRowIndex(player,GridPane.getRowIndex(player)+1);
                System.out.println("down");
                if(GridPane.getRowIndex(player)==GridPane.getRowIndex(ice) && GridPane.getColumnIndex(player)==GridPane.getColumnIndex(ice)) {
                    if (GridPane.getColumnIndex(fire) == GridPane.getColumnIndex(ice) && GridPane.getRowIndex(fire) > GridPane.getRowIndex(ice)) {
                        // && GridPane.getRowIndex(fire) < GridPane.getRowIndex(ice)
                        fire.setVisible(false);
                        ice.setVisible(false);
                    }
                    else {
                        GridPane.setRowIndex(ice, 4);
                    }
                }
                break;
            case D:
                GridPane.setColumnIndex(player,GridPane.getColumnIndex(player)+1);
                System.out.println("right");
                if(GridPane.getRowIndex(player)==GridPane.getRowIndex(ice) && GridPane.getColumnIndex(player)==GridPane.getColumnIndex(ice)) {
                    if (GridPane.getRowIndex(fire) == GridPane.getRowIndex(ice) && GridPane.getColumnIndex(fire) > GridPane.getColumnIndex(ice)) {
                        fire.setVisible(false);
                        ice.setVisible(false);
                    }
                    else {
                        GridPane.setColumnIndex(ice, 6);
                    }
                }
                break;
            default:
                break;
        }
    }
}
