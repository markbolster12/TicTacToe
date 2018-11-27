package io.mb12.tictactoe;

import io.mb12.tictactoe.controller.TicTacToeController;
import io.mb12.tictactoe.view.TicTacToePane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TicTacToeGame extends Application{
	
	private TicTacToeController controller;
	
	@Override
	public void start(Stage stage) throws Exception {
		
		controller = new TicTacToeController();
		TicTacToePane view = controller.getView();
		
		StackPane root = new StackPane();
		root.getChildren().add(view);
		
		Scene scene = new Scene(root, 500, 500);

        stage.setTitle("Tic Tac Toe");
        stage.setScene(scene);
        stage.show();
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}

	

}
