package monopoly;

import javafx.scene.control.TextArea;

public class Message {
	static TextArea Message = new TextArea();
	
	public static void AddMessageBox(){
		Message.setText("Round "+ Game.RoundCount+" starts\n");
		Message.prefWidthProperty().bind(Board.scene.widthProperty().divide(5).multiply(4));
		Message.prefHeightProperty().bind(Board.scene.heightProperty());
		Message.setEditable(false);
		Message.setWrapText(true);
		Board.h1.getChildren().clear();
		Board.h1.getChildren().add(Message);
	}
	
	public static void Send(String r){
		Message.appendText(r+"\n");
	}
	
}
