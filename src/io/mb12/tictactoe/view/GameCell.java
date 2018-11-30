package io.mb12.tictactoe.view;

import io.mb12.tictactoe.model.CellValue;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class GameCell extends StackPane{
	
	private Shape displayShape;
	public Circle c;
	public Rectangle sq;
	private int x;
	private int y;
	
	public GameCell()
	{
		super();
		
		this.setStyle("-fx-border-color: black");
		this.setSelected(CellValue.EMPTY);
	}
	
	//TODO Can move this logic to a controller
	public void setSelected(CellValue val)
	{
		if(val == CellValue.SQUARE)
		{
			this.getChildren().clear();
			this.getChildren().add(new SquareSymbol());
		}
		else if(val == CellValue.CIRCLE)
		{
			this.getChildren().clear();
			this.getChildren().add(new CircleSymbol());
		}
		else
		{
			displayShape = null;
			this.getChildren().clear();
		}
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


}
