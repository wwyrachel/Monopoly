package monopoly;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.paint.Color;

public class Game{
	static int CurrentPlayerTurn = 1;
	static int RoundCount = 1;
	final static int basecash = 2000;
	final static int salary = 1500;
	final static int fine = 90;
	static int players;
	static String[] playername = {"Steve","Mary",
			"David","Stella",
			"Peter","Michelle"};
	static Color[] color = new Color[6];
	static int[] pos = new int[6];
	static int[] cash = new int[6];
	static Boolean[] AI = new Boolean[6];
	static Boolean[] isinjail = new Boolean[6];
	static int[] dicecounter = new int[6];
	static int[] jailtime = new int[6];
	static Boolean[] lose = new Boolean[6];
	static Boolean[][] property = new Boolean[6][12];
	static String[] propertyname = {"Central","Wan Chai","Stanley",
			"Shek O","Mong Kok","Tsing Yi","Shatin",
			"Tuen Mun","Tai Po","Sai Kung", 
			"Yuen Long", "Tai O"};
	static Boolean Suspended = false;
	final static int[] price = {850,750,650,350,550,450,650,
			350,550,400,450,650};
	final static int[] rent = {90,70,65,15,35,20,70,25,20,15,
			25,30};
	public Game(){}
	public Game(int players, String... name){
		RoundCount = 1;
		CurrentPlayerTurn = 1;
		this.players = players;
		Suspended = false;
		for(int i=0;i<name.length;i++){
			playername[i]=name[i];
		}
		for(int i=0;i<6;i++){
			pos[i] = 1;
			for(int j=0;j<property[i].length;j++)property[i][j]=false;
			cash[i] = basecash;
			AI[i] = false;
			isinjail[i] = false;
			dicecounter[i] = 0;
			jailtime[i] = 0;
			lose[i] = false;
		}
	}
	public void SetColor(int player, Color c){
		color[player-1] = c;
	}
	public void SetAI(int player, Boolean ai){
		AI[player-1] = ai;
	}
	public static void report(){
		System.out.println("====== Report ======\n");
		Message.Send("====== Report ======\n");
		for(int i=0;i<players;i++){
			if(!lose[i]){
				System.out.println("Player "+(i+1)+" "+playername[i]+((AI[i])?"(AI)":"")+" status: ");
				Message.Send("Player "+(i+1)+" "+playername[i]+((AI[i])?"(AI)":"")+" status: ");
				System.out.println("Color: "+color[i]);
				Message.Send("Color: "+color[i]);
				System.out.println("Cash: "+cash[i]);
				Message.Send("Cash: "+cash[i]);
				ArrayList<String> temp = new ArrayList<String>();
				for(int j=0;j<12;j++){
					if(property[i][j])temp.add(propertyname[j]);
				}
				System.out.println("Is in jail: "+((isinjail[i])?"Yes ("+jailtime[i]+" turns left)":"No"));
				Message.Send("Is in jail: "+((isinjail[i])?"Yes ("+jailtime[i]+" turns left)":"No"));
				System.out.println("Owning Property: "+temp.toString());
				Message.Send("Owning Property: "+temp.toString());
				System.out.println("Position: "+pos[i]+"\n");
				Message.Send("Position: "+pos[i]+"\n");
			}
		}
		System.out.println("=================");
		Message.Send("=================");
	}
	public static void move(int p, int s){
		if(pos[p-1]+s>20){
			pos[p-1] += s-20;
		}else{pos[p-1] += s;}
		switch(p){
			case 1: Board.move(pos[p-1], Board.p1, p);break;
			case 2: Board.move(pos[p-1], Board.p2, p);break;
			case 3: Board.move(pos[p-1], Board.p3, p);break;
			case 4: Board.move(pos[p-1], Board.p4, p);break;
			case 5: Board.move(pos[p-1], Board.p5, p);break;
			case 6: Board.move(pos[p-1], Board.p6, p);break;
		}
		System.out.println(playername[p-1]+" moves to "+pos[p-1]);
		switch(pos[p-1]){
			case 1: System.out.println(playername[p-1]+" gets HKD "+salary+" salary");
					Message.Send(playername[p-1]+" gets HKD "+salary+" salary");
					add(p,salary);
					break;
			case 2: propertysquare(p, 0);
					break;
			case 3: propertysquare(p, 1);
					break;
			case 4: incometax(p);
					break;
			case 5: propertysquare(p, 2);
					break;
			case 7: propertysquare(p, 3);
					break;
			case 8: propertysquare(p, 4);
					break;
			case 9: chance(p);
					break;
			case 10: propertysquare(p, 5);
					break;
			case 11: break;
			case 12: propertysquare(p, 6);
					break;
			case 13: chance(p);
					break;
			case 14: propertysquare(p, 7);
					break;
			case 15: propertysquare(p, 8);
					break;
			case 16: jail(p, 3);
					break;
			case 17: propertysquare(p, 9);
					break;
			case 18: propertysquare(p, 10);
					break;
			case 19: chance(p);
					break;
			case 20: propertysquare(p, 11);
					break;
		}
	}
	public static void chance(int p){
		int random = ThreadLocalRandom.current().nextInt(-30, 20 + 1)*10;
		if(random>0){
			System.out.println(playername[p-1]+" gains HKD "+random+" while having a chance");
			Message.Send(playername[p-1]+" gains HKD "+random+" while having a chance");
			add(p, random);
		}
		if(random<=0){
			System.out.println(playername[p-1]+" loses HKD "+random*-1+" while having a chance");
			Message.Send(playername[p-1]+" loses HKD "+random*-1+" while having a chance");
			sub(p, -random);
		}
	}
	public static void propertysquare(int p, int ppt){
		int owner = -1;
		boolean bought = false;
		for(int i=0;i<players;i++){
			if(property[i][ppt]){
				owner = i;
				bought = true;
				break;
			}
		}
		if(bought&&owner!=(p-1)){
			Message.Send(playername[p-1]+" pays HKD "+rent[ppt]+" rent to "+playername[owner]);
			sub(p, rent[ppt]);
			add(owner+1, rent[ppt]);
		}else if(!bought&&cash[p-1]>=price[ppt]){
			if(!AI[p-1]){
				BuyProperty.CallBuyWindow(p, ppt);
			}else{
				Ai.AutoBuyProperty(p, ppt);
			}
		}
	}
	public static void add(int p,int a){
		cash[p-1] += a;
		InfoText.UpdatePlayerInfo(p);
		System.out.println(playername[p-1]+"'s Current Cash: HKD "+cash[p-1]);
		Message.Send(playername[p-1]+"'s Current Cash: HKD "+cash[p-1]);
	}
	public static void sub(int p,int a){
		cash[p-1] -= a;
		InfoText.UpdatePlayerInfo(p);
		System.out.println(playername[p-1]+"'s Current Cash: HKD "+cash[p-1]);
		Message.Send(playername[p-1]+"'s Current Cash: HKD "+cash[p-1]);
		if(cash[p-1]<=0){
			bankrupt(p);
		}
	}
	public static void incometax(int p){
		int tax = (int) (cash[p-1]*0.1);
		System.out.println(playername[p-1]+" pays 10% income tax (HKD "+tax+")");
		Message.Send(playername[p-1]+" pays 10% income tax (HKD "+tax+")");
		sub(p,tax);
	}
	public static void jail(int p,int r){
		System.out.println(playername[p-1]+" goes to jail for "+r+" rounds");
		Message.Send(playername[p-1]+" goes to jail for "+r+" rounds");
		pos[p-1] = 6;
		isinjail[p-1] = true;
		jailtime[p-1] += 3;
		switch(p){
			case 1: Board.move(-1, Board.p1, p);break;
			case 2: Board.move(-1, Board.p2, p);break;
			case 3: Board.move(-1, Board.p3, p);break;
			case 4: Board.move(-1, Board.p4, p);break;
			case 5: Board.move(-1, Board.p5, p);break;
			case 6: Board.move(-1, Board.p6, p);break;
		}
	}
	public static void dice(){
		if(!has1player()&&RoundCount<100){
		int random = ThreadLocalRandom.current().nextInt(1, 6 + 1);
		System.out.println(playername[CurrentPlayerTurn-1]+" throws a "+random);
		Message.Send(playername[CurrentPlayerTurn-1]+" throws a "+random);
		if(isinjail[CurrentPlayerTurn-1]){
			if(dicecounter[CurrentPlayerTurn-1]==random){
				isinjail[CurrentPlayerTurn-1] = false;
				dicecounter[CurrentPlayerTurn-1] = 0;
				jailtime[CurrentPlayerTurn-1]=0;
				System.out.println(playername[CurrentPlayerTurn-1]+" gets out of the jail by throwing a "+random+" twice");
				Message.Send(playername[CurrentPlayerTurn-1]+" gets out of the jail by throwing a "+random+" twice");
				move(CurrentPlayerTurn, random);
			}else if(jailtime[CurrentPlayerTurn-1]<=0){
				System.out.println(playername[CurrentPlayerTurn-1]+" gets out of the jail by paying HKD "+fine+" fine");
				Message.Send(playername[CurrentPlayerTurn-1]+" gets out of the jail by paying HKD "+fine+" fine");
				sub(CurrentPlayerTurn,fine);
				move(CurrentPlayerTurn, random);
				isinjail[CurrentPlayerTurn-1]=false;
				dicecounter[CurrentPlayerTurn-1]=0;
				jailtime[CurrentPlayerTurn-1]=0;
			}else{
				dicecounter[CurrentPlayerTurn-1]=random;
				jailtime[CurrentPlayerTurn-1]--;
				System.out.println(playername[CurrentPlayerTurn-1]+" is in jail ("+jailtime[CurrentPlayerTurn-1]+" turns left)");
				Message.Send(playername[CurrentPlayerTurn-1]+" is in jail ("+jailtime[CurrentPlayerTurn-1]+" turns left)");
			}
		}else{
			move(CurrentPlayerTurn,random);
		}
		InfoText.UpdatePlayerInfo(CurrentPlayerTurn);
		nextplayer();
		Ai.AutoThrowDice();
		}
	}
	public static void nextplayer(){
		if(CurrentPlayerTurn<players){
			CurrentPlayerTurn++;
		}else{
			roundend();
			CurrentPlayerTurn=1;
		}
		if(lose[CurrentPlayerTurn-1]){
			nextplayer();
		}
	}
	public static void roundend(){
		RoundCount++;
		InfoText.UpdateRoundText();
		if(RoundCount>=100){
			endgame(-1);
		}else{
			Message.Send("\n\nRound "+RoundCount+" starts");
			System.out.println("\n\nRound "+RoundCount+" starts");
		}
	}
	public static boolean has1player(){
		int c = 0;
		for(int i=0;i<players;i++){
			if(!lose[i])c++;
		}
		if(c==1){return true;}else{return false;}
	}
	public static void retire(int p){
		bankrupt(p);
		Message.Send(playername[p-1]+" has left the game");
		System.out.println(playername[p-1]+" has left the game");
		nextplayer();
		Ai.AutoThrowDice();
		
	}
	public static void bankrupt(int p){
		lose[p-1] = true;
		Message.Send(playername[p-1]+" is bankrupted");
		System.out.println(playername[p-1]+" is bankrupted");
		Board.removeplayer(p);
		for(int i=0;i<12;i++){
			if(property[p-1][i]){
				Board.removeproperty(i);
				property[p-1][i] = false;
			}
		}
		if(has1player()){
			for(int i=0;i<players;i++){
				if(!lose[i]){
					endgame(i+1);
					break;
				}
			}
		}
	}
	public static void endgame(int p){
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Game Over");
		if(has1player()){
			alert.setContentText(playername[p-1]+" is the last player in the game(Cash HKD "+cash[p-1]+").");
			alert.setHeaderText(playername[p-1]+" Wins!");
		}else{
			int w = 0;
			ArrayList<String> winnerlist = new ArrayList<String>();
			for(int i=0;i<players;i++){
				if(cash[i]>cash[w]){
					w = i;
				}
			}
			winnerlist.add(playername[w]);
			for(int i=0;i<players;i++){
				if(cash[i]==cash[w]&&i!=w){
					winnerlist.add(playername[i]);
				}
			}
			alert.setContentText(winnerlist.toString()+" is the wealthiest player in the game(Cash HKD "+cash[w]+").");
			alert.setHeaderText(winnerlist.toString()+" Wins!");
		}
		alert.showAndWait();
		Suspended = true;
		Buttons.dice.setDisable(true);
		Buttons.auto.setDisable(true);
		Buttons.save.setDisable(true);
		Buttons.retire.setDisable(true);
	}
}
