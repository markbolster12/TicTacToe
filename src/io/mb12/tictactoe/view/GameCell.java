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
		
		c = new Circle(50);
		c.setFill(null);
		c.setStroke(Color.BLACK);
		c.setStrokeWidth(5);
		
		sq = new Rectangle(100,100);
		sq.setFill(null);
		sq.setStroke(Color.BLACK);
		sq.setStrokeWidth(5);
		
		this.setStyle("-fx-border-color: black");
		
//		this.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                toggleSelected();
//            }
//        });
		
		this.setSelected(CellValue.EMPTY);
	}
	
	
	public void setSelected(CellValue val)
	{
		if(val == CellValue.SQUARE)
		{
			displayShape = sq;
			this.getChildren().clear();
			this.getChildren().add(displayShape);
			//this.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		}
		else if(val == CellValue.CIRCLE)
		{
			displayShape = c;
			this.getChildren().clear();
			this.getChildren().add(displayShape);
			//this.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
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
