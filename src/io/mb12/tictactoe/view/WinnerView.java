package io.mb12.tictactoe.view;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class WinnerView extends StackPane{
	
	public static final String winnerViewID = "winnerView";
	
	private Text winnerText;
	
	public WinnerView()
	{
		initialize();
	}

	public void initialize()
	{
		setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));

		winnerText = new Text("Winner! ");
		winnerText.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
		getChildren().add(winnerText);
		setId("winnerView");
		
		this.setMaxHeight(100);
		this.setMaxWidth(300);

	}
}
