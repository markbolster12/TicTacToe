package io.mb12.tictactoe.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class TicTacToeAppModel {
	
	private ObjectProperty<Game> gameProperty;
	private Player player1;
	private Player player2;
	private ObjectProperty<Player> currentPlayer;
	//private Player winner;
	
	public TicTacToeAppModel()
	{
		gameProperty = new SimpleObjectProperty<Game>();
		currentPlayer = new SimpleObjectProperty<Player>();
		
		player1 = new Player("Player 1");
		player1.setSymbol(CellValue.CIRCLE);
		
		player2 = new Player("Player 2");
		player2.setSymbol(CellValue.SQUARE);
	}
	
	public void startNewGame()
	{
		setGame(new Game());
	}
	
	public Game getGame()
	{
		return gameProperty.get();
	}
	
	public void setGame(Game g)
	{
		gameProperty.set(g);
	}
	
	public ObjectProperty<Game> getGameProperty()
	{
		return gameProperty;
	}

	//TODO get rid of this method - use getCurrent...
	public ObjectProperty<Player> getPlayerProperty()
	{
		return currentPlayer;
	}
	
	public ObjectProperty<Player> getCurrentPlayerProperty()
	{
		return currentPlayer;
	}
	
	public void setCurrentPlayer(Player player)
	{
		currentPlayer.set(player);
	}
	
	public Player getCurrentPlayer()
	{
		return currentPlayer.get();
	}
	
	//TODO Get rid of this method - use setCurrentPlayer
	public void setPlayer(Player player)
	{
		currentPlayer.set(player);
	}

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}
}
