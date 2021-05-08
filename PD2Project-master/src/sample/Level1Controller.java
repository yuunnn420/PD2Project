package sample;

import javafx.animation.TranslateTransition;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import javafx.fxml.FXML;

public class Level1Controller {

    @FXML
    private ImageView player;
    @FXML
    private ImageView ice;
    @FXML
    private ImageView fire;
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
                    if (GridPane.getRowIndex(fire) == GridPane.getRowIndex(ice) && GridPane.getColumnIndex(fire) < GridPane.getColumnIndex(ice)) {
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
