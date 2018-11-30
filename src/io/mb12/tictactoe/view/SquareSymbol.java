package io.mb12.tictactoe.view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SquareSymbol extends Rectangle{
	
	public SquareSymbol()
	{
		super(100,100);
		setFill(null);
		setStroke(Color.BLACK);
		setStrokeWidth(5);
	}

}
