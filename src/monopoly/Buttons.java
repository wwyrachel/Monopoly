package monopoly;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Buttons {
	static VBox ButtonBox = new VBox();
	static Button dice = new Button("Throw");
	static Button report = new Button("Report");
	static Button save = new Button("Save");
	static Button auto = new Button("Auto");
	static Button retire = new Button("Retire");
	static Button back = new Button("Back to Menu");
	
	public static void AddButtons(){
		ButtonBox.prefWidthProperty().bind(Board.scene.widthProperty().divide(5));
		ButtonBox.prefHeightProperty().bind(Board.scene.heightProperty().divide(5));
		ButtonBox.setSpacing(15);
		
		HBox HBB1 = new HBox();
		HBB1.setSpacing(15);
		HBB1.prefWidthProperty().bind(Board.scene.widthProperty().divide(5));
		HBB1.prefHeightProperty().bind(Board.scene.heightProperty().divide(6));
		
		dice.prefWidthProperty().bind(HBB1.widthProperty().divide(2));
		dice.prefHeightProperty().bind(HBB1.heightProperty());
		dice.setOnAction(e -> {
			Game.dice();
		});
		
		report.setDisable(false);
		report.prefWidthProperty().bind(HBB1.widthProperty().divide(2));
		report.prefHeightProperty().bind(HBB1.heightProperty());
		report.setOnAction(e -> {
			Game.report();
		});
		
		HBox HBB2 = new HBox();
		HBB2.setSpacing(15);
		HBB2.prefWidthProperty().bind(Board.scene.widthProperty().divide(56));
		HBB2.prefHeightProperty().bind(Board.scene.heightProperty().divide(6));
		
		save.prefWidthProperty().bind(HBB1.widthProperty().divide(2));
		save.prefHeightProperty().bind(HBB1.heightProperty());
		save.setOnAction(e -> {
			Save.save();
		});
		
		auto.setDisable(false);
		auto.prefWidthProperty().bind(HBB1.widthProperty().divide(2));
		auto.prefHeightProperty().bind(HBB1.heightProperty());
		
		HBox HBB3 = new HBox();
		HBB3.setSpacing(15);
		HBB3.prefWidthProperty().bind(Board.scene.widthProperty().divide(5));
		HBB3.prefHeightProperty().bind(Board.scene.heightProperty().divide(6));
		
		retire.prefWidthProperty().bind(HBB1.widthProperty().divide(2));
		retire.prefHeightProperty().bind(HBB1.heightProperty());
		retire.setOnAction(e -> {
			Game.retire(Game.CurrentPlayerTurn);
		});
		
		back.prefWidthProperty().bind(HBB1.widthProperty().divide(2));
		back.prefHeightProperty().bind(HBB1.heightProperty());
		back.setOnAction(e -> {
			Menu.window.setWidth(640);
			Menu.window.setHeight(480);
			Menu.window.setScene(Menu.scene);
			Game.Suspended=true;
		});
		
		ButtonBox.getChildren().clear();
		HBB1.getChildren().addAll(dice,report);
		HBB2.getChildren().addAll(save,auto);
		HBB3.getChildren().addAll(retire,back);
		ButtonBox.getChildren().addAll(HBB1,HBB2,HBB3);
		ButtonBox.setStyle("-fx-background-color: #888888");
		Board.h2.getChildren().add(ButtonBox);
	}
	public static void SwitchAiButton(boolean b){
		if(b){
			auto.setText("Auto");
			auto.setOnAction(e -> {
				Game.AI[Game.CurrentPlayerTurn-1] = true;
				Ai.AutoThrowDice();
				SwitchAiButton(false);
			});
		}else{
			auto.setText("Take Control");
			auto.setOnAction(e -> {
				Game.AI[Game.CurrentPlayerTurn-1] = false;
				SwitchAiButton(true);
			});
		}
	}
}
