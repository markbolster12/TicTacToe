package io.mb12.tictactoe.controller;

import java.util.ArrayList;

import io.mb12.tictactoe.model.Game;
import io.mb12.tictactoe.model.Player;
import io.mb12.tictactoe.model.TicTacToeAppModel;
import io.mb12.tictactoe.view.GameCell;
import io.mb12.tictactoe.view.TicTacToePane;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class TicTacToeController {
	
	private Game game;
	
	//SubControllers
	private GameManagementController gameManagementController;
	
	//Model
	private TicTacToeAppModel appModel;
	
	//View
	private TicTacToePane gameView;
	
	//Root of the view to represent this class
	private StackPane root;
	
	
	public TicTacToeController(TicTacToeAppModel model)
	{
		appModel = model;
		
		
		initialize();

		gameManagementController = new GameManagementController(model);
		
		newGame();
	}
	
	protected void initialize()
	{
		root = new StackPane();
	    VBox.setVgrow(root, Priority.ALWAYS);
	    
		gameView = new TicTacToePane();

		appModel.getPlayerProperty().addListener(new ChangeListener<Player>() {

			@Override
			public void changed(ObservableValue<? extends Player> observable, Player oldValue, Player newValue) {
				System.out.println("Player changed " + newValue.getLabel());
			}
			
		});
		
		appModel.getGameProperty().addListener(new ChangeListener<Game>() {

			@Override
			public void changed(ObservableValue<? extends Game> observable, Game oldValue, Game newValue) {
				newGame();
			}
			
		});
	}
	
	//Return the view for this controller
	//TODO Should probably remove the creation of any UI elements and put these in the view class
	public Pane getView()
	{
		VBox viewRoot = new VBox();
		viewRoot.getChildren().add(gameManagementController.getView());
		viewRoot.getChildren().add(gameView);
	    VBox.setVgrow(gameView, Priority.ALWAYS);
	    VBox.setVgrow(viewRoot, Priority.ALWAYS);
	    root.getChildren().add(viewRoot);
	    
		return root;
	}
	
	//Logic for handling a player's move
	//It should be passed the cell which was chosen by the player who's turn it was
	public void handleMove(GameCell selected)
	{	
		//Set the cell's value based on the current player (update the model)
		game.setCellValue(appModel.getCurrentPlayer(), selected.getX(), selected.getY());
		
		//Update the view with the symbol of the current player
		selected.setSelected(appModel.getCurrentPlayer().getSymbol());
		
		//Check if there is a winner
		if(game.checkForWinner(selected.getX(), selected.getY(), appModel.getCurrentPlayer()))
		{
			handleWinnerFound();
		}
		
		endTurn();
	}
	
	protected void handleWinnerFound()
	{
		System.out.println("Winner!");
		StackPane winnerView = new StackPane();
		Text winnerText = new Text("Winner! " + appModel.getCurrentPlayer().getLabel());
		winnerView.getChildren().add(winnerText);
		winnerView.setId("winnerView");
		root.getChildren().add(winnerView);
		
	}
	
	//Returns true if it is currently player one's turn
	private boolean isPlayerOneTurn()
	{
		return appModel.getCurrentPlayer() == appModel.getPlayer1();
	}
	

	//Returns true if it is currently player two's turn
	private boolean isPlayerTwoTurn()
	{
		return appModel.getCurrentPlayer() == appModel.getPlayer2();
	}
	
	//Switches who's turn in is
	protected void togglePlayers()
	{
		if(isPlayerOneTurn())
		{
			appModel.setPlayer(appModel.getPlayer2());
		}
		else
		{
			appModel.setPlayer(appModel.getPlayer1());
		}
	}
	
	//Logic for what happens when the turn ends
	protected void endTurn()
	{
		togglePlayers();
	}
	
	
	//TODO clean this up a bit
	//Method to start a new game
	//Update the UI when a new game is created (or changed)
	public void newGame()
	{
		System.out.println("Starting new game");
		gameView.initializeGameCells();
		appModel.setCurrentPlayer(appModel.getPlayer1());
		game = new Game();
		
		//Configure behavior of the cells in the new view
		ArrayList<GameCell> gameCells = gameView.getGameCells();
		for(int i=0; i<gameCells.size(); i++)
		{
			GameCell curr = gameCells.get(i);
			curr.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent arg0) {
					handleMove(curr);
				}
				
			});
		}
	}
}
