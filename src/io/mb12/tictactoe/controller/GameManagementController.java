package io.mb12.tictactoe.controller;

import io.mb12.tictactoe.model.Player;
import io.mb12.tictactoe.model.TicTacToeAppModel;
import io.mb12.tictactoe.view.GameManagementPanel;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;

public class GameManagementController {
	
	private GameManagementPanel view;
	private TicTacToeAppModel model;
	
	public GameManagementController(TicTacToeAppModel model)
	{
		this.model = model;
		initialize();
	}
	
	protected void initialize()
	{
		view = new GameManagementPanel();
		view.getNewGameButton().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				model.startNewGame();
			}
		});
		
		model.getPlayerProperty().addListener(new ChangeListener<Player>() {
			@Override
			public void changed(ObservableValue<? extends Player> observable, Player oldValue, Player newValue) {
				view.setCurrentPlayerText(newValue.getLabel());
			}
			
		});
	}
	
	public Pane getView()
	{
		return view;
	}

}
