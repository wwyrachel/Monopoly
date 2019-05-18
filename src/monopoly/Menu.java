package monopoly;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.StreamCorruptedException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Menu extends Application{
	final static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	final static double width = screenSize.getWidth()/3;
	final static double height = screenSize.getHeight()/2;
	static int i = 0;
	static VBox root = new VBox();
	static Scene nextpage = new Scene(NewGame.ngroot, width, height);
	static Scene scene = new Scene(root, width, height);
	static Stage window = new Stage();
	static final FileChooser fileChooser = new FileChooser();
	@Override
	public void start(Stage primaryStage) throws Exception{
		root.setAlignment(Pos.CENTER);
		root.setPrefWidth(width/5);
		root.setSpacing(width/30);
		
		Text t = new Text("Monopoly");
		t.setFont(new Font(width*height/3600));
		VBox title = new VBox(t);
		String[] color = {"ffff00","00ff00","00ffff","ff00ff","ffffff","0000ff","ff0000"};
		title.setStyle("-fx-background-color: #"+color[i]);
		title.setAlignment(Pos.CENTER);
		
		title.setOnMouseClicked(e -> {
			if(i<color.length)i++;
			if(i>=color.length)i=0;
			title.setStyle("-fx-background-color: #"+color[i]);
		});
		
		Button ng = new Button("New Game");
		ng.setMinWidth(root.getPrefWidth());
		Button lg = new Button("Load Game");
		lg.setMinWidth(root.getPrefWidth());
		Button exit = new Button("Exit");
		exit.setMinWidth(root.getPrefWidth());
		exit.setOnAction(e -> {
			System.out.println("Exiting...");
			System.exit(0);
		});
		ng.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				NewGame.NewGameSetting();
				window.setScene(nextpage);
			}
		});
		lg.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Error");
				alert.setHeaderText("Invalid File");
				try {
					File currentDirFile = new File(".");
					fileChooser.setInitialDirectory(currentDirFile);
					File file = fileChooser.showOpenDialog(primaryStage);
					file.toPath();
                    if (file != null) {
                    	alert.setContentText("Cannot load saved game data "+file.getName()+". ");
                    	Message.Send("Loading Game Data: "+file.getName());
            			System.out.println("Loading Game Data: "+file.getName());
                    	NewGame.LoadGame(file);
                    }
				} catch (Exception e){
        			alert.showAndWait();
				}
			}
		});
		root.setStyle("-fx-background-color: #00dddd");
		root.getChildren().addAll(title,ng,lg,exit);
		window.setTitle("Monopoly");
		window.setScene(scene);
		window.setMinWidth(640);
		window.setMinHeight(480);
		window.setResizable(true);
		window.show();
	}
	public static void main(String[] args){
		launch(args);
	}
}
