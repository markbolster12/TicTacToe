package io.mb12.tictactoe.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class GameManagementPanel extends HBox{
	
	private static final String newGameButtonLabel = "New Game";
	
	private Button newGameButton;
	private Text currentPlayerText;
	
	public GameManagementPanel()
	{
		super();
		
		newGameButton = new Button(newGameButtonLabel);
		setPadding(new Insets(10,10,10,10));
		
		HBox currentPlayerPane = new HBox();
		currentPlayerPane.setPadding(new Insets(5,5,5,5));
		
		currentPlayerText = new Text("Temporary Player");
		currentPlayerPane.getChildren().add(currentPlayerText);
		
		getChildren().add(newGameButton);
		getChildren().add(currentPlayerPane);

	}
	
	public Button getNewGameButton()
	{
		return newGameButton;
	}

	public Text getCurrentPlayerText() {
		return currentPlayerText;
	}
	
	public void setCurrentPlayerText(String text)
	{
		currentPlayerText.setText(text);
	}
	

}
