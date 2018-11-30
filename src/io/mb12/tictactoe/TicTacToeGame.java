package io.mb12.tictactoe;

import io.mb12.tictactoe.controller.TicTacToeController;
import io.mb12.tictactoe.model.TicTacToeAppModel;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TicTacToeGame extends Application{
	
	private TicTacToeController controller;
	private TicTacToeAppModel model;
	private Pane view;
	
	@Override
	public void start(Stage stage) throws Exception {
		
		initialize();
		
		Scene scene = new Scene(view, 500, 500);

        stage.setTitle("Tic Tac Toe");
        stage.setScene(scene);
        stage.show();
	}
	
	protected void initialize()
	{
		//Create the model and pass it to the controller
		model = new TicTacToeAppModel();
		controller = new TicTacToeController(model);
		
		//Create the root of what will be displayed
		view = new VBox();
		
		//Add the view from the controller
		view.getChildren().add(controller.getView());
	}
	
	//Launch the application
	public static void main(String[] args)
	{
		launch(args);
	}
}
