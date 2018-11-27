package io.mb12.tictactoe.model;

public class Game {
	
	private CellValue[][] board;
	private int boardSize;
	
	
	public Game()
	{
		boardSize = 3;
		
	
		board = new CellValue[boardSize][boardSize];
		for(int i=0; i<boardSize; i++)
		{
			for(int j=0; j<boardSize; j++)
			{
				board[i][j] = CellValue.EMPTY;
			}
		}
	}
	
	public void setCellValue(Player player, int x, int y)
	{
		board[x][y] = player.getSymbol();
	}
	
	public CellValue getCellValue(int x, int y)
	{
		return board[x][y];
	}
	
	private boolean checkVertical(CellValue checkFor, int startX)
	{
		//Search up
		//Search down
		int total = 0;
		for(int i=0; i<boardSize; i++)
		{
			if(checkFor == board[startX][i])
			{
				total++;
			}
			else
			{
				i = boardSize;
			}
		}
		
		if(total==boardSize)
		{
			return true;
		}
		return false;
	}
	
	private boolean checkHorizontal(CellValue checkFor, int startY)
	{
		int total = 0;
		for(int i=0; i<boardSize; i++)
		{
			if(checkFor == board[i][startY])
			{
				total++;
			}
			else
			{
				i = boardSize;
			}
		}
		if(total==boardSize)
		{
			return true;
		}
		return false;
	}
	
	private boolean checkUpRight(CellValue checkFor)
	{
		int total = 0;
		//Search Left
		//Search right
		for(int i=0, j=boardSize-1; i<boardSize && j>=0; i++, j--)
		{
			if(checkFor == board[i][j])
			{
				total++;
			}
			else
			{
				i = boardSize;
			}
		}
		if(total==boardSize)
		{
			return true;
		}
		return false;
	}
	
	private boolean checkDownRight(CellValue checkFor)
	{
		int total = 0;
		for(int i=0; i<boardSize; i++)
		{
			if(checkFor == board[i][i])
			{
				total++;
			}
			else
			{
				i = boardSize;
			}
		}
		if(total==boardSize)
		{
			return true;
		}
		return false;
	}
	
	public boolean checkForWinner(int startX, int startY, Player currentPlayer)
	{
		CellValue current = currentPlayer.getSymbol();
		
		if(checkVertical(current, startX))
			return true;
		if(checkHorizontal(current, startY))
			return true;
		if(checkUpRight(current))
			return true;
		if(checkDownRight(current))
			return true;
		
		return false;
	}
	
	public int getBoardSize()
	{
		return boardSize;
	}
}
