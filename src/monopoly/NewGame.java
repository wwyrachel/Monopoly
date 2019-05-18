package monopoly;

import java.io.File;

import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import monopoly.Game;

public class NewGame {
	static VBox ngroot = new VBox();
	static VBox ps = new VBox();
	
	static ChoiceBox<String> pa1 = new ChoiceBox<String>(FXCollections.observableArrayList("Human","AI"));
	static ChoiceBox<String> pa2 = new ChoiceBox<String>(FXCollections.observableArrayList("Human","AI"));
	static ChoiceBox<String> pa3 = new ChoiceBox<String>(FXCollections.observableArrayList("Human","AI"));
	static ChoiceBox<String> pa4 = new ChoiceBox<String>(FXCollections.observableArrayList("Human","AI"));
	static ChoiceBox<String> pa5 = new ChoiceBox<String>(FXCollections.observableArrayList("Human","AI"));
	static ChoiceBox<String> pa6 = new ChoiceBox<String>(FXCollections.observableArrayList("Human","AI"));
	
	static HBox p1 = new HBox();
	static HBox p2 = new HBox();
	static HBox p3 = new HBox();
	static HBox p4 = new HBox();
	static HBox p5 = new HBox();
	static HBox p6 = new HBox();
	
	static HBox h = new HBox();
	static HBox h1 = new HBox();
	
	static TextField p1name = new TextField();
	static TextField p2name = new TextField();
	static TextField p3name = new TextField();
	static TextField p4name = new TextField();
	static TextField p5name = new TextField();
	static TextField p6name = new TextField();
	
	static ColorPicker cp1 = new ColorPicker();
	static ColorPicker cp2 = new ColorPicker();
	static ColorPicker cp3 = new ColorPicker();
	static ColorPicker cp4 = new ColorPicker();
	static ColorPicker cp5 = new ColorPicker();
	static ColorPicker cp6 = new ColorPicker();
	
	static ChoiceBox<Integer> mp = new ChoiceBox<Integer>(FXCollections.observableArrayList(2,3,4,5,6));
	
	public static void NewGameSetting(){
		System.out.println("New Game");
		ngroot.setAlignment(Pos.CENTER);
		ngroot.setPrefWidth(Menu.width/3);
		NewGame.ngroot.setStyle("-fx-background-color: #00dddd");
		ngroot.setSpacing(Menu.width/30);
		
		ps.setAlignment(Pos.CENTER);
		ps.setPrefWidth(Menu.width/5);
		ps.setSpacing(Menu.width/30);
		
		cp1.setValue(Color.BLUE);
		cp1.setMaxWidth(Menu.root.getPrefWidth()*0.8);
		cp2.setValue(Color.RED);
		cp2.setMaxWidth(Menu.root.getPrefWidth()*0.8);
		cp3.setValue(Color.GREEN);
		cp3.setMaxWidth(Menu.root.getPrefWidth()*0.8);
		cp4.setValue(Color.GOLD);
		cp4.setMaxWidth(Menu.root.getPrefWidth()*0.8);
		cp5.setValue(Color.BROWN);
		cp5.setMaxWidth(Menu.root.getPrefWidth()*0.8);
		cp6.setValue(Color.PURPLE);
		cp6.setMaxWidth(Menu.root.getPrefWidth()*0.8);
		
		pa1.setTooltip(new Tooltip("Select Human/AI"));
		pa1.setValue("Human");
		
		pa2.setTooltip(new Tooltip("Select Human/AI"));
		pa2.setValue("AI");
		
		pa3.setTooltip(new Tooltip("Select Human/AI"));
		pa3.setValue("AI");
		
		pa4.setTooltip(new Tooltip("Select Human/AI"));
		pa4.setValue("AI");
		
		pa5.setTooltip(new Tooltip("Select Human/AI"));
		pa5.setValue("AI");
		
		pa6.setTooltip(new Tooltip("Select Human/AI"));
		pa6.setValue("AI");
		
		p1.setAlignment(Pos.CENTER);
		p1.setSpacing(Menu.width/30);
		p1name.setMinWidth(Menu.width/3);
		Text t = new Text("P1 Name: ");
		t.setFont(new Font(Menu.width* Menu.height/10800));
		p1.getChildren().clear();
		p1.getChildren().addAll(t,p1name,cp1,pa1);
		
		p2.setAlignment(Pos.CENTER);
		p2.setSpacing(Menu.width/30);
		p2name.setMinWidth(Menu.width/3);
		t = new Text("P2 Name: ");
		t.setFont(new Font(Menu.width* Menu.height/10800));
		p2.getChildren().clear();
		p2.getChildren().addAll(t,p2name,cp2,pa2);

		p3.setAlignment(Pos.CENTER);
		p3.setSpacing(Menu.width/30);
		p3name.setMinWidth(Menu.width/3);
		t = new Text("P3 Name: ");
		t.setFont(new Font(Menu.width* Menu.height/10800));
		p3.getChildren().clear();
		p3.getChildren().addAll(t,p3name,cp3,pa3);
		
		p4.setAlignment(Pos.CENTER);
		p4.setSpacing(Menu.width/30);
		p4name.setMinWidth(Menu.width/3);
		t = new Text("P4 Name: ");
		t.setFont(new Font(Menu.width* Menu.height/10800));
		p4.getChildren().clear();
		p4.getChildren().addAll(t,p4name,cp4,pa4);
		
		p5.setAlignment(Pos.CENTER);
		p5.setSpacing(Menu.width/30);
		p5name.setMinWidth(Menu.width/3);
		t = new Text("P5 Name: ");
		t.setFont(new Font(Menu.width* Menu.height/10800));
		p5.getChildren().clear();
		p5.getChildren().addAll(t,p5name,cp5,pa5);
		
		p6.setAlignment(Pos.CENTER);
		p6.setSpacing(Menu.width/30);
		p6name.setMinWidth(Menu.width/3);
		t = new Text("P6 Name: ");
		t.setFont(new Font(Menu.width* Menu.height/10800));
		p6.getChildren().clear();
		p6.getChildren().addAll(t,p6name,cp6,pa6);
		
		h.getChildren().clear();
		
		h.setAlignment(Pos.CENTER);
		h.setSpacing(Menu.width/30);
		Text t1 = new Text(" Players");
		t1.setFont(new Font(Menu.width* Menu.height/10800));
		mp.setTooltip(new Tooltip("Select the number of players"));
		mp.setValue(2);
		h.getChildren().addAll(mp,t1);
		ps.getChildren().clear();
		ps.getChildren().add(p1);
		ps.getChildren().add(p2);
		
		p1name.setText("Steve");
		p2name.setText("Mary");
		p3name.setText("David");
		p4name.setText("Stella");
		p5name.setText("Peter");
		p6name.setText("Michelle");
		mp.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) ->{
			switch(newValue){
				case 2: ps.getChildren().clear();
						ps.getChildren().add(p1);
						ps.getChildren().add(p2);
						break;
				case 3: ps.getChildren().clear();
						ps.getChildren().add(p1);
						ps.getChildren().add(p2);
						ps.getChildren().add(p3);
						break;
				case 4: ps.getChildren().clear();
						ps.getChildren().add(p1);
						ps.getChildren().add(p2);
						ps.getChildren().add(p3);
						ps.getChildren().add(p4);
						break;
				case 5: ps.getChildren().clear();
						ps.getChildren().add(p1);
						ps.getChildren().add(p2);
						ps.getChildren().add(p3);
						ps.getChildren().add(p4);
						ps.getChildren().add(p5);
						break;
				case 6: ps.getChildren().clear();
						ps.getChildren().add(p1);
						ps.getChildren().add(p2);
						ps.getChildren().add(p3);
						ps.getChildren().add(p4);
						ps.getChildren().add(p5);
						ps.getChildren().add(p6);
						break;
			}
		});
		
		Button back = new Button("Back");
		back.setMinWidth(NewGame.ngroot.getPrefWidth());
		back.setOnAction(e -> {
			System.out.println("Back to menu");
			Menu.window.setScene(Menu.scene);
		});
		Button start = new Button("Start");
		start.setMinWidth(NewGame.ngroot.getPrefWidth());
		start.setOnAction(e -> {
			try {
				GameSetup();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		h1.setAlignment(Pos.CENTER);
		h1.setSpacing(Menu.width/30);
		h1.getChildren().clear();
		h1.getChildren().addAll(start,back);
		
		ngroot.getChildren().clear();
		ngroot.getChildren().addAll(h,ps,h1);
	}
	public static void GameSetup() throws Exception{
		Game NewGame = new Game();
		switch(monopoly.NewGame.mp.getValue()){
		case 2: System.out.println("Creating new game with "+monopoly.NewGame.mp.getValue()+" players: "
				+monopoly.NewGame.p1name.getText()+", "
				+monopoly.NewGame.p2name.getText());
				NewGame = new Game(2, monopoly.NewGame.p1name.getText(), monopoly.NewGame.p2name.getText());
				break;
		case 3: System.out.println("Creating new game with "+monopoly.NewGame.mp.getValue()+" players: "
				+monopoly.NewGame.p1name.getText()+", "
				+monopoly.NewGame.p2name.getText()+", "
				+monopoly.NewGame.p3name.getText());
				NewGame = new Game(3, monopoly.NewGame.p1name.getText(), monopoly.NewGame.p2name.getText(), monopoly.NewGame.p3name.getText());
				break;
		case 4: System.out.println("Creating new game with "+monopoly.NewGame.mp.getValue()+" players: "
				+monopoly.NewGame.p1name.getText()+", "
				+monopoly.NewGame.p2name.getText()+", "
				+monopoly.NewGame.p3name.getText()+", "
				+monopoly.NewGame.p4name.getText());
				NewGame = new Game(4, monopoly.NewGame.p1name.getText(), monopoly.NewGame.p2name.getText(), monopoly.NewGame.p3name.getText(), monopoly.NewGame.p4name.getText());
				break;
		case 5: System.out.println("Creating new game with "+monopoly.NewGame.mp.getValue()+" players: "
				+monopoly.NewGame.p1name.getText()+", "
				+monopoly.NewGame.p2name.getText()+", "
				+monopoly.NewGame.p3name.getText()+", "
				+monopoly.NewGame.p4name.getText()+", "
				+monopoly.NewGame.p5name.getText());
				NewGame = new Game(5, monopoly.NewGame.p1name.getText(), monopoly.NewGame.p2name.getText(), monopoly.NewGame.p3name.getText(), monopoly.NewGame.p4name.getText(), monopoly.NewGame.p5name.getText());
				break;
		case 6: System.out.println("Creating new game with "+monopoly.NewGame.mp.getValue()+" players: "
				+monopoly.NewGame.p1name.getText()+", "
				+monopoly.NewGame.p2name.getText()+", "
				+monopoly.NewGame.p3name.getText()+", "
				+monopoly.NewGame.p4name.getText()+", "
				+monopoly.NewGame.p5name.getText()+", "
				+monopoly.NewGame.p6name.getText());
				NewGame = new Game(6, monopoly.NewGame.p1name.getText(), monopoly.NewGame.p2name.getText(), monopoly.NewGame.p3name.getText(), monopoly.NewGame.p4name.getText(), monopoly.NewGame.p5name.getText(), monopoly.NewGame.p6name.getText());
				break;}
	
		NewGame.SetColor(1, monopoly.NewGame.cp1.getValue());
		NewGame.SetColor(2, monopoly.NewGame.cp2.getValue());
		NewGame.SetColor(3, monopoly.NewGame.cp3.getValue());
		NewGame.SetColor(4, monopoly.NewGame.cp4.getValue());
		NewGame.SetColor(5, monopoly.NewGame.cp5.getValue());
		NewGame.SetColor(6, monopoly.NewGame.cp6.getValue());
		
		if(monopoly.NewGame.pa1.getValue()=="AI")NewGame.SetAI(1,true);
		if(monopoly.NewGame.pa2.getValue()=="AI")NewGame.SetAI(2,true);
		if(monopoly.NewGame.pa3.getValue()=="AI")NewGame.SetAI(3,true);
		if(monopoly.NewGame.pa4.getValue()=="AI")NewGame.SetAI(4,true);
		if(monopoly.NewGame.pa5.getValue()=="AI")NewGame.SetAI(5,true);
		if(monopoly.NewGame.pa6.getValue()=="AI")NewGame.SetAI(6,true);
		
		InfoText.AddPlayersInfo(monopoly.NewGame.mp.getValue());
		InfoText.UpdateAllPlayerInfo();
		
		Board.start();
		Ai.AutoThrowDice();
	}
	public static void LoadGame(File file) throws Exception{
		Save.load(file);
		switch(Game.players){
		case 2: System.out.println("Loading saved game with "+ Game.players+" players: "
				+ Game.playername[0]+", "
				+ Game.playername[1]);
				break;
		case 3: System.out.println("Loading saved game with "+ Game.players+" players: "
				+ Game.playername[0]+", "
				+ Game.playername[1]+", "
				+ Game.playername[2]);
				break;
		case 4: System.out.println("Loading saved game with "+ Game.players+" players: "
				+ Game.playername[0]+", "
				+ Game.playername[1]+", "
				+ Game.playername[2]+", "
				+ Game.playername[3]);
				break;
		case 5: System.out.println("Loading saved game with "+ Game.players+" players: "
				+ Game.playername[0]+", "
				+ Game.playername[1]+", "
				+ Game.playername[2]+", "
				+ Game.playername[3]+", "
				+ Game.playername[4]);
				break;
		case 6: System.out.println("Loading saved game with "+ Game.players+" players: "
				+ Game.playername[0]+", "
				+ Game.playername[1]+", "
				+ Game.playername[2]+", "
				+ Game.playername[3]+", "
				+ Game.playername[4]+", "
				+ Game.playername[5]);
				break;}
		InfoText.AddPlayersInfo(Game.players);
		InfoText.UpdateAllPlayerInfo();
		
		Game.Suspended = false;
		Board.start();
		Board.UpdateBoard();
		Ai.AutoThrowDice();
		Game.report();
	}
}
