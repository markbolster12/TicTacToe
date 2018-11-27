package io.mb12.tictactoe.model;

public class Player {
	
	private String label;
	private CellValue symbol;
	
	public Player(String l)
	{
		label = l;
	}
	
	public void setSymbol(CellValue v)
	{
		symbol = v;
	}
	
	public CellValue getSymbol()
	{
		return symbol;
	}
	
	public String getLabel()
	{
		return label;
	}

}
