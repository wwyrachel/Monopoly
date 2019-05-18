package monopoly;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class InfoText{
	private static DoubleProperty fontSize = new SimpleDoubleProperty(10);
	private static DoubleProperty fontSize2 = new SimpleDoubleProperty(10);
	
	static VBox infobox = new VBox();
	
	static Label round = new Label();
	
	static Label p1name = new Label();
	static Label p2name = new Label();
	static Label p3name = new Label();
	static Label p4name = new Label();
	static Label p5name = new Label();
	static Label p6name = new Label();
	
	static Label p1info = new Label();
	static Label p2info = new Label();
	static Label p3info = new Label();
	static Label p4info = new Label();
	static Label p5info = new Label();
	static Label p6info = new Label();
	
	DoubleProperty fs = new SimpleDoubleProperty(12);

	public static void AddPlayersInfo(int playernum){
		fontSize.bind(Board.scene.widthProperty().add(Board.scene.heightProperty()).divide(120));
		fontSize2.bind(Board.scene.widthProperty().add(Board.scene.heightProperty()).divide(140));

		UpdateRoundText();
		SetNameText(1,p1name);
		SetNameText(2,p2name);
		
		round.setWrapText(true);
		round.prefHeightProperty().bind(Board.scene.heightProperty().divide(95).multiply(1));
		p1name.setWrapText(true);
		p1name.prefHeightProperty().bind(Board.scene.heightProperty().divide(95).multiply(1));
		p1name.setWrapText(true);
		p1name.prefHeightProperty().bind(Board.scene.heightProperty().divide(95).multiply(1));
		p3name.setWrapText(true);
		p3name.prefHeightProperty().bind(Board.scene.heightProperty().divide(95).multiply(1));
		p4name.setWrapText(true);
		p4name.prefHeightProperty().bind(Board.scene.heightProperty().divide(95).multiply(1));
		p5name.setWrapText(true);
		p5name.prefHeightProperty().bind(Board.scene.heightProperty().divide(95).multiply(1));
		p6name.setWrapText(true);
		p6name.prefHeightProperty().bind(Board.scene.heightProperty().divide(95).multiply(1));

		p1info.prefHeightProperty().bind(Board.scene.heightProperty().divide(95).multiply(11));
		p2info.prefHeightProperty().bind(Board.scene.heightProperty().divide(95).multiply(11));
		p3info.prefHeightProperty().bind(Board.scene.heightProperty().divide(95).multiply(11));
		p4info.prefHeightProperty().bind(Board.scene.heightProperty().divide(95).multiply(11));
		p5info.prefHeightProperty().bind(Board.scene.heightProperty().divide(95).multiply(11));
		p6info.prefHeightProperty().bind(Board.scene.heightProperty().divide(95).multiply(11));
		
		switch(Game.players){
			case 2: break;
			case 3: SetNameText(3,p3name);
					break;
			case 4: SetNameText(3,p3name);
					SetNameText(4,p4name);
					break;
			case 5: SetNameText(3,p3name);
					SetNameText(4,p4name);
					SetNameText(5,p5name);
					break;
			case 6: SetNameText(3,p3name);
					SetNameText(4,p4name);
					SetNameText(5,p5name);
					SetNameText(6,p6name);
					break;
		}
		
		p1info.styleProperty().bind(Bindings.concat("-fx-font-size: ", fontSize2.asString()));
		p2info.styleProperty().bind(Bindings.concat("-fx-font-size: ", fontSize2.asString()));
		p3info.styleProperty().bind(Bindings.concat("-fx-font-size: ", fontSize2.asString()));
		p4info.styleProperty().bind(Bindings.concat("-fx-font-size: ", fontSize2.asString()));
		p5info.styleProperty().bind(Bindings.concat("-fx-font-size: ", fontSize2.asString()));
		p6info.styleProperty().bind(Bindings.concat("-fx-font-size: ", fontSize2.asString()));
		
	}
	public static void SetNameText(int p,Label t){
		Color color = Game.color[p-1];
		t.setTextFill(color);
		t.styleProperty().bind(Bindings.concat("-fx-font-size: ", fontSize.asString()));
		t.setText("Player "+p+" "+ Game.playername[p-1]+((Game.AI[p-1]==true)?" (AI)":""));
	}
	public static void UpdateAllPlayerInfo(){
		for(int i = 1; i<= Game.players; i++){
			UpdatePlayerInfo(i);
		}
		UpdateInfoBox();
	}
	public static void UpdatePlayerInfo(int i){
		String t;
		if(!Game.lose[i-1]){
			t = "Cash: "+ Game.cash[i-1]+"\n"+
				"Is in jail: "+((Game.isinjail[i-1])?"Yes":"No")+"\n"+
				"Position: "+ Game.pos[i-1]+"\n";
		}else{
			t = "Bankrupted";
		}
		switch(i){
			case 1: p1info.setText(t);break;
			case 2: p2info.setText(t);break;
			case 3: p3info.setText(t);break;
			case 4: p4info.setText(t);break;
			case 5: p5info.setText(t);break;
			case 6: p6info.setText(t);break;
		}
	}
	public static void UpdateInfoBox(){
		infobox.getChildren().clear();
		infobox.getChildren().addAll(round,p1name,p1info,p2name,p2info);
		switch(Game.players){
			case 2: break;
			case 3: infobox.getChildren().addAll(p3name,p3info);break;
			case 4: infobox.getChildren().addAll(p3name,p3info,p4name,p4info);break;
			case 5: infobox.getChildren().addAll(p3name,p3info,p4name,p4info,p5name,p5info);break;
			case 6: infobox.getChildren().addAll(p3name,p3info,p4name,p4info,p5name,p5info,p6name,p6info);break;
		}
		Board.Info.getChildren().clear();
		Board.Info.getChildren().add(infobox);
	}
	public static void UpdateRoundText(){
		round.styleProperty().bind(Bindings.concat("-fx-font-size: ", fontSize.asString()));
		round.setText("Round "+ Game.RoundCount);
		UpdateInfoBox();
	}
}
