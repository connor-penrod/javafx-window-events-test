/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboardapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Conno
 */
public class CheckerboardFXMLController implements Initializable, Startable {
    
    @FXML
    private VBox rootBox;
    
    @FXML
    private MenuBar bar;
    
    @FXML
    private MenuItem gridBtn1, gridBtn2, gridBtn3, gridBtn4, colorBtn1, colorBtn2;
    
    private Checkerboard board;
    private int numRows, numCols;
    private Color lightColor, darkColor;
    private Stage stage;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.numRows = 5;
        this.numCols = 5;
        this.lightColor = Color.RED;
        this.darkColor = Color.BLACK;
        
        gridBtn1.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                changeGrid(16,16);
                recreateBoard();
            }
        });
        gridBtn2.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                changeGrid(10,10);
                recreateBoard();
            }
        });
        gridBtn3.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                changeGrid(8,8);
                recreateBoard();
            }
        });
        gridBtn4.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                changeGrid(3,3);
                recreateBoard();
            }
        });
        
        colorBtn1.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                changeColor(Color.RED, Color.BLACK);
                recreateBoard();
            }
        });
        colorBtn2.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                changeColor(Color.SKYBLUE, Color.DARKBLUE);
                recreateBoard();
            }
        });
    }    
    
    public void start(Stage stage) {
        
        
        this.stage = stage;
                
        //create initial board
        this.board = new Checkerboard(this.numCols, this.numRows, this.stage.getScene().getWidth(), this.stage.getScene().getHeight() - this.bar.getHeight());
        rootBox.getChildren().add(this.board.build());
        
        
        ChangeListener<Number> lambdaChangeListender = new ChangeListener<Number> (
        {
            recreateBoard();
        });
        //check for any window resizing and recreate the board if changes are detected
        this.stage.getScene().widthProperty().addListener((a, b, c) -> {
            recreateBoard();    
        });
        
        this.stage.getScene().heightProperty().addListener((a, b, c) -> {
            recreateBoard();
        });
    }
    
    private void recreateBoard()
    {
        rootBox.getChildren().remove(this.board.getBoard());
        this.board = new Checkerboard(this.numCols, this.numRows, this.stage.getScene().getWidth(), this.stage.getScene().getHeight() - this.bar.getHeight(), this.lightColor, this.darkColor);
        rootBox.getChildren().add(this.board.build());
    }
    
    private void changeGrid(int x, int y)
    {
        this.numRows = y;
        this.numCols = x;
    }
    private void changeColor(Color light, Color dark)
    {
        this.lightColor = light;
        this.darkColor = dark;
    }
}