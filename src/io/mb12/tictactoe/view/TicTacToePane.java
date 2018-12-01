package io.mb12.tictactoe.view;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class TicTacToePane extends StackPane {
	
	private ArrayList<GameCell> gameCells;
	private GridPane gameGrid;
	
	public TicTacToePane()
	{
		super();
		
	    initialize();
	}
	
	public void initialize()
	{
		gameGrid = new GridPane();
		
		//Create column contraints
		ColumnConstraints column1 = new ColumnConstraints();
		column1.setPercentWidth(33.33);
		ColumnConstraints column2 = new ColumnConstraints();
		column2.setPercentWidth(33.33);
		ColumnConstraints column3 = new ColumnConstraints();
		column3.setPercentWidth(33.33);

		gameGrid.getColumnConstraints().addAll(column1, column2, column3);
	    
	    //Create row contraints
	    RowConstraints row1 = new RowConstraints();
	    row1.setPercentHeight(33.33);
	    RowConstraints row2 = new RowConstraints();
	    row2.setPercentHeight(33.33);
	    RowConstraints row3 = new RowConstraints();
	    row3.setPercentHeight(33.33);
	    
	    gameGrid.getRowConstraints().addAll(row1, row2, row3);
	    
	    this.getChildren().add(gameGrid);
	    VBox.setVgrow(this, Priority.ALWAYS);
	    
	    this.setPadding(new Insets(10,10,10,10));
	}
	
	public void initializeGameCells()
	{
		gameCells = new ArrayList<GameCell>();
		gameGrid.getChildren().clear();
		
		for(int y=0; y<3; y++)
		{
			for(int x=0; x<3; x++)
			{
				GameCell cell = new GameCell();
			    GridPane.setRowIndex(cell, y);
			    GridPane.setFillWidth(cell, true);
			    GridPane.setFillHeight(cell, true);
			    GridPane.setColumnIndex(cell, x);
			    
			    cell.setX(x);
			    cell.setY(y);
			    
			    gameGrid.getChildren().add(cell);
			    gameCells.add(cell);
			}
		}
	}
	
	public ArrayList<GameCell> getGameCells()
	{
		return gameCells;
	}
	
	
	

}
