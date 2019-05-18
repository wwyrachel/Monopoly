package monopoly;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class BuyProperty {
	static Alert alert = new Alert(AlertType.CONFIRMATION);
	public static void CallBuyWindow(int p, int ppt){
		alert.setTitle("Buying Property");
		alert.setHeaderText(Game.propertyname[ppt]);
		alert.setContentText("Do you want to buy "+ Game.propertyname[ppt]+" for HKD "+ Game.price[ppt]+"?");
		
		ButtonType btn1 = new ButtonType("Yes");
		ButtonType btn2 = new ButtonType("No");
		alert.getButtonTypes().setAll(btn1,btn2);
		
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == btn1){
		   BuyProperty(p,ppt);
		}
	}
	public static void BuyProperty(int p, int ppt){
		 Game.sub(p, Game.price[ppt]);
		    switch(ppt){
		    	case 0: Board.r2.setFill(Game.color[p-1]);break;
		    	case 1: Board.r3.setFill(Game.color[p-1]);break;
		    	case 2: Board.r5.setFill(Game.color[p-1]);break;
		    	case 3: Board.r7.setFill(Game.color[p-1]);break;
		    	case 4: Board.r8.setFill(Game.color[p-1]);break;
		    	case 5: Board.r10.setFill(Game.color[p-1]);break;
		    	case 6: Board.r12.setFill(Game.color[p-1]);break;
		    	case 7: Board.r14.setFill(Game.color[p-1]);break;
		    	case 8: Board.r15.setFill(Game.color[p-1]);break;
		    	case 9: Board.r17.setFill(Game.color[p-1]);break;
		    	case 10: Board.r18.setFill(Game.color[p-1]);break;
		    	case 11: Board.r20.setFill(Game.color[p-1]);break;
		    }
		    Game.property[p-1][ppt] = true;
		    Message.Send(Game.playername[p-1]+" buys "+ Game.propertyname[ppt]+" for HKD "+ Game.price[ppt]);
	}
}
