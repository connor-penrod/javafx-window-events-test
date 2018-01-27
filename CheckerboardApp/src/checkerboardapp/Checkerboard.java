/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboardapp;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *s
 * @author Connor Penrod
 */
public class Checkerboard {
    private AnchorPane pane;    
    private int numRows, numCols;
    private double boardWidth, boardHeight, rectWidth, rectHeight;
    private Color lightColor, darkColor;
    private boolean hasBuilt;
    
    public Checkerboard(int numRows, int numCols, double boardWidth, double boardHeight, Color lightColor, Color darkColor)
    {
        this.numRows = numRows;
        this.numCols = numCols;
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.lightColor = lightColor;
        this.darkColor = darkColor;
        this.rectWidth = 0;
        this.rectHeight = 0;
        
        this.hasBuilt = false;
        
        this.pane = new AnchorPane();
    }
    public Checkerboard(int numRows, int numCols, double boardWidth, double boardHeight)
    {
        this(numRows, numCols, boardWidth, boardHeight, Color.RED, Color.BLACK);
    }
    
    public AnchorPane build()
    {
        populate(this.pane); 
        this.hasBuilt = true;
        return this.pane;
    }
    
    private void populate(AnchorPane p)
    {
        this.rectWidth = this.boardWidth / this.numCols;
        this.rectHeight = this.boardHeight / this.numRows;

        for(int i = 0; i < this.numCols; i++)
        {
            for(int j = 0; j < this.numRows; j++)
            {
                Rectangle r = new Rectangle(this.rectWidth, this.rectHeight);

                if((i+j) % 2 == 0)
                    r.setFill(this.lightColor);
                else
                    r.setFill(this.darkColor);

                AnchorPane.setTopAnchor(r, j * this.rectHeight);
                AnchorPane.setLeftAnchor(r, i * this.rectWidth);
                p.getChildren().add(r);
            }
        }
    }
    
    public AnchorPane getBoard() {
        if (hasBuilt) return this.pane; 
        else return null;
    }
    
    int getNumRows() {return this.numRows;}
    int getNumCols() {return this.numCols;} 
    double getWidth() {return this.boardWidth;} 
    double getHeight() {return this.boardHeight;} 
    Color getLightColor() {return this.lightColor;} 
    Color getDarkColor() {return this.darkColor;} 
    double getRectangleWidth() {return this.rectWidth;} 
    double getRectangleHeight() {return this.rectHeight;}
}
