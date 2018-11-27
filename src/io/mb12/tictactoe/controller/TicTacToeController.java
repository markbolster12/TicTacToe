package io.mb12.tictactoe.controller;

import io.mb12.tictactoe.model.CellValue;
import io.mb12.tictactoe.model.Game;
import io.mb12.tictactoe.model.Player;
import io.mb12.tictactoe.view.GameCell;
import io.mb12.tictactoe.view.TicTacToePane;
import javafx.scene.input.MouseEvent;

public class TicTacToeController {
	
	private Game game;
	private Player player1;
	private Player player2;
	private Player currentPlayer;
	
	private TicTacToePane gameView;
	
	public TicTacToeController()
	{
		player1 = new Player("Player 1");
		player1.setSymbol(CellValue.CIRCLE);
		player2 = new Player("Player 2");
		player2.setSymbol(CellValue.SQUARE);
		
		currentPlayer = player1;
		
		gameView = new TicTacToePane(this);
		game = new Game();
	}
	
	public TicTacToePane getView()
	{
		return gameView;
	}
	
	public void handleMove(MouseEvent event)
	{
		GameCell selected = (GameCell)event.getSource();
		System.out.println(selected.getX() + ", " + selected.getY());
		game.setCellValue(currentPlayer, selected.getX(), selected.getY());
		selected.setSelected(currentPlayer.getSymbol());
		checkGameState(selected.getX(), selected.getY());
		endTurn();
	}
	
	public void checkGameState(int sx, int sy)
	{
		if(game.checkForWinner(sx, sy, currentPlayer))
		{
			
		}
		System.out.println(game.checkForWinner(sx, sy, currentPlayer));
	}
	
	public void endTurn()
	{
		if(currentPlayer == player1)
		{
			currentPlayer = player2;
		}
		else
		{
			currentPlayer = player1;
		}
	}
	
	public void newGame()
	{
		//Connect game and gameView
		game = new Game();
		//gameView = new TicTacToePane();
		
		
	}
	
	

}
