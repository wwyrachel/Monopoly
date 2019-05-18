package monopoly;

import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;

public class Ai {
	public static void AutoThrowDice(){
		if(Game.AI[Game.CurrentPlayerTurn-1]&&!Game.Suspended){
			Buttons.dice.setDisable(true);
			Buttons.retire.setDisable(true);
			Buttons.save.setDisable(true);
			Buttons.SwitchAiButton(false);
	        Task<Void> sleeper = new Task<Void>() {
	            @Override
	            protected Void call() throws Exception {
	                try {
	                    Thread.sleep(0);
	                } catch (InterruptedException e) {
	                }
	                return null;
	            }
	        };
	        sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
	            @Override
	            public void handle(WorkerStateEvent event) {
	            	Game.dice();
	            }
	        });
	        new Thread(sleeper).start();
		}else if(!Game.Suspended){
			Buttons.dice.setDisable(false);
			Buttons.retire.setDisable(false);
			Buttons.SwitchAiButton(true);
			Buttons.report.setDisable(false);
			Buttons.save.setDisable(false);
		}
	}
	public static void AutoBuyProperty(int p,int ppt){
		if(Game.price[ppt]<=(int)(Game.cash[p-1]*0.75)){
			BuyProperty.BuyProperty(p, ppt);
		}
	}
}
