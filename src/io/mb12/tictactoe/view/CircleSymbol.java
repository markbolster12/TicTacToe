package io.mb12.tictactoe.view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CircleSymbol extends Circle{
	
	public CircleSymbol()
	{
		super(50);
		setFill(null);
		setStroke(Color.BLACK);
		setStrokeWidth(5);
	}

}
