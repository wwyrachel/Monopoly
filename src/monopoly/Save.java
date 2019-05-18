package monopoly;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.scene.paint.Color;

public class Save {
	public static void save(){
		try{
			String dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
			String filename = "save"+dateFormat.toString()+".sav";
			FileOutputStream saveFile = new FileOutputStream(filename);
			Message.Send("Game saved as "+filename+" in "+System.getProperty("user.dir"));
			System.out.println("Game saved as "+filename+" in "+System.getProperty("user.dir"));
			
			ObjectOutputStream save = new ObjectOutputStream(saveFile);
	
			save.writeObject(Game.CurrentPlayerTurn);
			save.writeObject(Game.RoundCount);
			save.writeObject(Game.players);
			for(int i=0;i<6;i++){
				save.writeObject(Game.playername[i].toString());
				save.writeObject(Game.color[i].toString());
				save.writeObject(Game.pos[i]);
				save.writeObject(Game.cash[i]);
				save.writeObject(Game.AI[i].toString());
				save.writeObject(Game.isinjail[i].toString());
				save.writeObject(Game.dicecounter[i]);
				save.writeObject(Game.jailtime[i]);
				save.writeObject(Game.lose[i]);
				for(int j=0;j<12;j++){
					save.writeObject(Game.property[i][j].toString());
				}
			}
	
			save.close();
		}catch(Exception exc){
			exc.printStackTrace();
		}
	}
	public static void load(File file){
		try{
			FileInputStream saveFile = new FileInputStream(file);

			ObjectInputStream save = new ObjectInputStream(saveFile);

			Game.CurrentPlayerTurn = (int) save.readObject();
			Game.RoundCount = (int) save.readObject();
			Game.players = (int) save.readObject();
			for(int i=0;i<6;i++){
				Game.playername[i] = (String)save.readObject();
				Game.color[i] = Color.web((String)save.readObject());
				Game.pos[i] = (int)save.readObject();
				Game.cash[i] = (int)save.readObject();
				Game.AI[i] = (boolean)save.readObject();
				Game.isinjail[i] = (boolean)save.readObject();
				Game.dicecounter[i] = (int)save.readObject();
				Game.jailtime[i] = (int) save.readObject();
				Game.lose[i] = (boolean) save.readObject();
				for(int j=0;j<12;j++){
					Game.property[i][j] = (boolean)save.readObject();
				}
			}
			save.close();
			}catch(Exception exc){
			exc.printStackTrace();
		}
	}
	public static String[] StringToStringArray(String a) {
		String[] r = a.replaceAll("\\[", "").replaceAll("\\]", "").split(",");
		return r;
	}
	public static Boolean[] StringtoBooleanArray(String a){
		String[] b = a.replaceAll("\\[", "").replaceAll("\\]", "").split(",");
		Boolean[] r = new Boolean[b.length];
		for(int i=0;i<b.length;i++){
			if(b[i]=="true"){r[i]=true;}else{r[i]=false;}
		}
		return r;
	}
	public static Color[] StringtoColorArray(String a){
		String[] b = a.replaceAll("\\[", "").replaceAll("\\]", "").split(",");
		Color[] r = new Color[b.length];
		for(int i=0;i<b.length;i++){
			if(b[i]!=null){r[i] = Color.web(b[i]);}
		}
		return r;
	}
	public static int[] StringToIntArray(String a) {
		String[] b = a.replaceAll("\\[", "").replaceAll("\\]", "").split(",");
		int[] r = new int[b.length];
		for(int i=0;i<b.length;i++){
			r[i] = Integer.parseInt(b[i].trim());
		}
		return r;
	}
}
