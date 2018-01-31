
package checkerboard;

import board.Checkerboard;
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
 * @author Connor Penrod
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
        
        //event handling for menu buttons
        gridBtn1.setOnAction((a) -> {
            changeGrid(16,16);
            createBoard();
        });
        gridBtn2.setOnAction((a) -> {
            changeGrid(10,10);
            createBoard();
        });
        gridBtn3.setOnAction((a) -> {
            changeGrid(8,8);
            createBoard();
        });
        gridBtn4.setOnAction((a) -> {
            changeGrid(3,3);
            createBoard();
        });
        
        colorBtn1.setOnAction((a) -> {
            changeColor(Color.RED, Color.BLACK);
            createBoard();
        });
        colorBtn2.setOnAction((a) -> {
            changeColor(Color.SKYBLUE, Color.DARKBLUE);
            createBoard();
        });
    }    
    
    public void start(Stage stage) {
        
        
        this.stage = stage;
                
        //create initial board
        createBoard();
        
        //check for any window resizing and recreate the board if changes are detected
        ChangeListener<Number> lambdaChangeListener = (a,b,c) ->
        {
            createBoard();
        };
        this.stage.getScene().widthProperty().addListener(lambdaChangeListener);
        this.stage.getScene().heightProperty().addListener(lambdaChangeListener);
    }
    
    private void createBoard()
    {
        if(this.board != null)
        { 
            rootBox.getChildren().remove(this.board.getBoard());
        } //only remove existing board if existing board exists
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
