package io.mb12.tictactoe.view;

import io.mb12.tictactoe.controller.TicTacToeController;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class TicTacToePane extends GridPane {
	
	private TicTacToeController controller;
	
	public TicTacToePane(TicTacToeController controller)
	{
		super();
		
		this.controller = controller;
		
		this.setGridLinesVisible(true);
		ColumnConstraints column1 = new ColumnConstraints();
		column1.setPercentWidth(33.33);
		ColumnConstraints column2 = new ColumnConstraints();
		column2.setPercentWidth(33.33);
		ColumnConstraints column3 = new ColumnConstraints();
		column3.setPercentWidth(33.33);
	    this.getColumnConstraints().addAll(column1, column2, column3);
	    
	    RowConstraints row1 = new RowConstraints();
	    row1.setPercentHeight(33.33);
	    RowConstraints row2 = new RowConstraints();
	    row2.setPercentHeight(33.33);
	    RowConstraints row3 = new RowConstraints();
	    row3.setPercentHeight(33.33);
	    this.getRowConstraints().addAll(row1, row2, row3);
	    
	    initializeGameCells();
		
	    
	}
	
	public void initialize()
	{
		
	}
	
	public void initializeGameCells()
	{
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
			    
			    cell.setOnMouseClicked(new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent event) {
		            	controller.handleMove(event);
		            }
		        });
			    
			    this.getChildren().add(cell);
			}
		}
	}
	
	

}
