package monopoly;

import java.awt.Dimension;
import java.awt.Toolkit;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Board extends Application{
	final static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	final static double width = screenSize.getWidth()/1.5;
	final static double height = screenSize.getHeight()/1.5;
	
	private static DoubleProperty fontSize = new SimpleDoubleProperty(10);
	private static DoubleProperty fontSize2 = new SimpleDoubleProperty(10);
	private static DoubleProperty fontSize3 = new SimpleDoubleProperty(10);
	private static DoubleProperty tfontSize = new SimpleDoubleProperty(10);
	private static DoubleProperty tfontSize2 = new SimpleDoubleProperty(10);
	private static DoubleProperty tfontSize3 = new SimpleDoubleProperty(10);
	private static DoubleProperty tfontSize4 = new SimpleDoubleProperty(10);
	
	static Circle p1 = new Circle();
	static Circle p2 = new Circle();
	static Circle p3 = new Circle();
	static Circle p4 = new Circle();
	static Circle p5 = new Circle();
	static Circle p6 = new Circle();
	
	static HBox rt = new HBox();
	static Scene scene = new Scene(rt, width, height);
	static VBox Info = new VBox();
	static DoubleBinding playerW = scene.widthProperty().divide(5).multiply(3).divide(48);
	static DoubleBinding playerH = scene.heightProperty().divide(48);
	static DoubleBinding playerX = scene.widthProperty().multiply(26).divide(45); //520
	static DoubleBinding playerY = scene.heightProperty().multiply(26).divide(27); //520
	
	static Rectangle r2 = new Rectangle();
	static Rectangle r3 = new Rectangle();
	static Rectangle r5 = new Rectangle();
	static Rectangle r12 = new Rectangle();
	static Rectangle r14 = new Rectangle();
	static Rectangle r15 = new Rectangle();
	static Rectangle r7 = new Rectangle();
	static Rectangle r8 = new Rectangle();
	static Rectangle r10 = new Rectangle();
	static Rectangle r17 = new Rectangle();
	static Rectangle r18 = new Rectangle();
	static Rectangle r20 = new Rectangle();
	
	static VBox h1 = new VBox();
	static VBox h2 = new VBox();
	
	public static void start() throws Exception {
		Menu.window.setMinWidth(1280);
		Menu.window.setMinHeight(720);
		
		VBox board = new VBox();
		Pane b = new Pane();
		Info.prefWidthProperty().bind(scene.widthProperty().divide(5));
		Info.prefHeightProperty().bind(scene.heightProperty().divide(5).multiply(4));
		Info.maxWidthProperty().bind(scene.widthProperty().divide(5));
		Info.maxHeightProperty().bind(scene.heightProperty().divide(5).multiply(4));
		Info.setStyle("-fx-background-color: #bbbbbb");
		
		Message.AddMessageBox();
		
		fontSize.bind(scene.widthProperty().multiply(scene.heightProperty()).divide(23500));
		fontSize2.bind(scene.widthProperty().multiply(scene.heightProperty()).divide(94500));
		fontSize3.bind(scene.widthProperty().multiply(scene.heightProperty()).divide(47000));
        b.prefWidthProperty().bind(scene.widthProperty().divide(5).multiply(3));
        b.prefHeightProperty().bind(scene.heightProperty());
        
		HBox up = new HBox();
		HBox low = new HBox();
		VBox upleft = new VBox();
		VBox upmid = new VBox();
		VBox upright = new VBox();
		HBox upmidup = new HBox();
		VBox t = new VBox();
		Text title = new Text("MONOPOLY");
		t.setAlignment(Pos.CENTER);
		t.styleProperty().bind(Bindings.concat("-fx-font-size: ", fontSize.asString()));
		
		p1.setVisible(true);
		p2.setVisible(true);
		p3.setVisible(false);
		p4.setVisible(false);
		p5.setVisible(false);
		p6.setVisible(false);
		
		p1.radiusProperty().bind(Bindings.min(playerW,playerH));
		p1.centerXProperty().bind(playerX);
		p1.centerYProperty().bind(playerY);
        p1.setFill(Game.color[0]);
		
        p2.radiusProperty().bind(Bindings.min(playerW,playerH));
		p2.centerXProperty().bind(playerX.multiply(241).divide(246));
		p2.centerYProperty().bind(playerY.multiply(241).divide(246));
        p2.setFill(Game.color[1]);
        
        if(Game.players>2){
        	p3.setVisible(true);
        	p3.radiusProperty().bind(Bindings.min(playerW,playerH));
        }
		p3.centerXProperty().bind(playerX.multiply(118).divide(123));
		p3.centerYProperty().bind(playerY.multiply(118).divide(123));
        p3.setFill(Game.color[2]);
        
        if(Game.players>3){
        	p4.setVisible(true);
        	p4.radiusProperty().bind(Bindings.min(playerW,playerH));
        }
		p4.centerXProperty().bind(playerX.multiply(77).divide(82));
		p4.centerYProperty().bind(playerY.multiply(77).divide(82));
		p4.setFill(Game.color[3]);
        
        if(Game.players>4){
        	p5.setVisible(true);
        	p5.radiusProperty().bind(Bindings.min(playerW,playerH));
        }
		p5.centerXProperty().bind(playerX.multiply(113).divide(123));
		p5.centerYProperty().bind(playerY.multiply(113).divide(123));
		p5.setFill(Game.color[4]);
        
        if(Game.players>5){
        	p6.setVisible(true);
        	p6.radiusProperty().bind(Bindings.min(playerW,playerH));
        }
		p6.centerXProperty().bind(playerX.multiply(221).divide(246));
		p6.centerYProperty().bind(playerY.multiply(221).divide(246));
		p6.setFill(Game.color[5]);
    
		Rectangle square1 = new Rectangle();
		Rectangle square2 = new Rectangle();
		Rectangle square3 = new Rectangle();
		Rectangle square4 = new Rectangle();
		Rectangle square5 = new Rectangle();
		Rectangle square6 = new Rectangle();
		Rectangle jsquare6 = new Rectangle();
		Rectangle square7 = new Rectangle();
		Rectangle square8 = new Rectangle();
		Rectangle square9 = new Rectangle();
		Rectangle square10 = new Rectangle();
		Rectangle square11 = new Rectangle();
		Rectangle square12 = new Rectangle();
		Rectangle square13 = new Rectangle();
		Rectangle square14 = new Rectangle();
		Rectangle square15 = new Rectangle();
		Rectangle square16 = new Rectangle();
		Rectangle square17 = new Rectangle();
		Rectangle square18 = new Rectangle();
		Rectangle square19 = new Rectangle();
		Rectangle square20 = new Rectangle();
		
		square1.heightProperty().bind(board.heightProperty().divide(6));
		square1.widthProperty().bind(board.widthProperty().divide(6));
		square2.heightProperty().bind(board.heightProperty().divide(6));
		square2.widthProperty().bind(board.widthProperty().divide(6));
		square3.heightProperty().bind(board.heightProperty().divide(6));
		square3.widthProperty().bind(board.widthProperty().divide(6));
		square4.heightProperty().bind(board.heightProperty().divide(6));
		square4.widthProperty().bind(board.widthProperty().divide(6));
		square5.heightProperty().bind(board.heightProperty().divide(6));
		square5.widthProperty().bind(board.widthProperty().divide(6));
		square6.heightProperty().bind(board.heightProperty().divide(6));
		square6.widthProperty().bind(board.widthProperty().divide(6));
		square7.heightProperty().bind(board.heightProperty().divide(6));
		square7.widthProperty().bind(board.widthProperty().divide(6));
		square8.heightProperty().bind(board.heightProperty().divide(6));
		square8.widthProperty().bind(board.widthProperty().divide(6));
		square9.heightProperty().bind(board.heightProperty().divide(6));
		square9.widthProperty().bind(board.widthProperty().divide(6));
		square10.heightProperty().bind(board.heightProperty().divide(6));
		square10.widthProperty().bind(board.widthProperty().divide(6));
		square11.heightProperty().bind(board.heightProperty().divide(6));
		square11.widthProperty().bind(board.widthProperty().divide(6));
		square12.heightProperty().bind(board.heightProperty().divide(6));
		square12.widthProperty().bind(board.widthProperty().divide(6));
		square13.heightProperty().bind(board.heightProperty().divide(6));
		square13.widthProperty().bind(board.widthProperty().divide(6));
		square14.heightProperty().bind(board.heightProperty().divide(6));
		square14.widthProperty().bind(board.widthProperty().divide(6));
		square15.heightProperty().bind(board.heightProperty().divide(6));
		square15.widthProperty().bind(board.widthProperty().divide(6));
		square16.heightProperty().bind(board.heightProperty().divide(6));
		square16.widthProperty().bind(board.widthProperty().divide(6));
		square17.heightProperty().bind(board.heightProperty().divide(6));
		square17.widthProperty().bind(board.widthProperty().divide(6));
		square18.heightProperty().bind(board.heightProperty().divide(6));
		square18.widthProperty().bind(board.widthProperty().divide(6));
		square19.heightProperty().bind(board.heightProperty().divide(6));
		square19.widthProperty().bind(board.widthProperty().divide(6));
		square20.heightProperty().bind(board.heightProperty().divide(6));
		square20.widthProperty().bind(board.widthProperty().divide(6));
		
		square1.setFill(Color.WHITE);
		square1.setStroke(Color.BLACK);
		square1.setStrokeWidth(2);
		square2.setFill(Color.WHITE);
		square2.setStroke(Color.BLACK);
		square2.setStrokeWidth(2);
		square3.setFill(Color.WHITE);
		square3.setStroke(Color.BLACK);
		square3.setStrokeWidth(2);
		square4.setFill(Color.WHITE);
		square4.setStroke(Color.BLACK);
		square4.setStrokeWidth(2);
		square5.setFill(Color.WHITE);
		square5.setStroke(Color.BLACK);
		square5.setStrokeWidth(2);
		square6.setFill(Color.WHITE);
		square6.setStroke(Color.BLACK);
		jsquare6.setFill(Color.ORANGE);
		square6.setStrokeWidth(2);
		square7.setFill(Color.WHITE);
		square7.setStroke(Color.BLACK);
		square7.setStrokeWidth(2);
		square8.setFill(Color.WHITE);
		square8.setStroke(Color.BLACK);
		square8.setStrokeWidth(2);
		square9.setFill(Color.WHITE);
		square9.setStroke(Color.BLACK);
		square9.setStrokeWidth(2);
		square10.setFill(Color.WHITE);
		square10.setStroke(Color.BLACK);
		square10.setStrokeWidth(2);
		square11.setFill(Color.WHITE);
		square11.setStroke(Color.BLACK);
		square11.setStrokeWidth(2);
		square12.setFill(Color.WHITE);
		square12.setStroke(Color.BLACK);
		square12.setStrokeWidth(2);
		square13.setFill(Color.WHITE);
		square13.setStroke(Color.BLACK);
		square13.setStrokeWidth(2);
		square14.setFill(Color.WHITE);
		square14.setStroke(Color.BLACK);
		square14.setStrokeWidth(2);
		square15.setFill(Color.WHITE);
		square15.setStroke(Color.BLACK);
		square15.setStrokeWidth(2);
		square16.setFill(Color.WHITE);
		square16.setStroke(Color.BLACK);
		square16.setStrokeWidth(2);
		square17.setFill(Color.WHITE);
		square17.setStroke(Color.BLACK);
		square17.setStrokeWidth(2);
		square18.setFill(Color.WHITE);
		square18.setStroke(Color.BLACK);
		square18.setStrokeWidth(2);
		square19.setFill(Color.WHITE);
		square19.setStroke(Color.BLACK);
		square19.setStrokeWidth(2);
		square20.setFill(Color.WHITE);
		square20.setStroke(Color.BLACK);
		square20.setStrokeWidth(2);
		
		Label t1 = new Label("COLLECT HKD "+ Game.salary);
		Label t1n2 = new Label("SALARY AS YOU PASS");
		Label t1n3 = new Label("GO");
		t1n3.setTextFill(Color.GREEN);
		
		Label t2 = new Label(Game.propertyname[0]);
		Label t2n2 = new Label("HKD "+ Game.price[0]);
		
		Label t3 = new Label(Game.propertyname[1]);
		Label t3n2 = new Label("HKD "+ Game.price[1]);
		
		Label t4 = new Label("INCOME TAX");
		Label t4n2 = new Label("PAY 10%");
		
		Label t5 = new Label(Game.propertyname[2]);
		Label t5n2 = new Label("HKD "+ Game.price[2]);
		
		Label t6 = new Label("IN JAIL");
		Label t6n2 = new Label("JUST VISITING");
		
		Label t7 = new Label(Game.propertyname[3]);
		Label t7n2 = new Label("HKD "+ Game.price[3]);
		
		Label t8 = new Label(Game.propertyname[4]);
		Label t8n2 = new Label("HKD "+ Game.price[4]);
		
		Label t9 = new Label("?");
		Label t9n2 = new Label("CHANCE");
		t9.setTextFill(Color.RED);
		
		Label t10 = new Label(Game.propertyname[5]);
		Label t10n2 = new Label("HKD "+ Game.price[5]);
		
		Label t11 = new Label("FREE PARKING");
		
		Label t12 = new Label(Game.propertyname[6]);
		Label t12n2 = new Label("HKD "+ Game.price[6]);
		
		Label t13 = new Label("?");
		Label t13n2 = new Label("CHANCE");
		t13.setTextFill(Color.BLUE);
		
		Label t14 = new Label(Game.propertyname[7]);
		Label t14n2 = new Label("HKD "+ Game.price[7]);
		
		Label t15 = new Label(Game.propertyname[8]);
		Label t15n2 = new Label("HKD "+ Game.price[8]);
		
		Label t16 = new Label("GO TO JAIL");

		Label t17 = new Label(Game.propertyname[9]);
		Label t17n2 = new Label("HKD "+ Game.price[9]);
		
		Label t18 = new Label(Game.propertyname[10]);
		Label t18n2 = new Label("HKD "+ Game.price[10]);
		
		Label t19 = new Label("?");
		Label t19n2 = new Label("CHANCE");
		t19.setTextFill(Color.GOLD);
		
		Label t20 = new Label(Game.propertyname[11]);
		Label t20n2 = new Label("HKD "+ Game.price[11]);
		
		t1.setAlignment(Pos.CENTER);
		t2.setAlignment(Pos.CENTER);
		t3.setAlignment(Pos.CENTER);
		t4.setAlignment(Pos.CENTER);
		t5.setAlignment(Pos.CENTER);
		t6.setAlignment(Pos.CENTER);
		t7.setAlignment(Pos.CENTER);
		t8.setAlignment(Pos.CENTER);
		t9.setAlignment(Pos.CENTER);
		t10.setAlignment(Pos.CENTER);
		t11.setAlignment(Pos.CENTER);
		t12.setAlignment(Pos.CENTER);
		t13.setAlignment(Pos.CENTER);
		t14.setAlignment(Pos.CENTER);
		t15.setAlignment(Pos.CENTER);
		t16.setAlignment(Pos.CENTER);
		t17.setAlignment(Pos.CENTER);
		t18.setAlignment(Pos.CENTER);
		t19.setAlignment(Pos.CENTER);
		t20.setAlignment(Pos.CENTER);
		
		tfontSize.bind(Board.scene.widthProperty().add(Board.scene.heightProperty()).divide(100));
		tfontSize2.bind(Board.scene.widthProperty().add(Board.scene.heightProperty()).divide(140));
		tfontSize3.bind(Board.scene.widthProperty().add(Board.scene.heightProperty()).divide(170));
		tfontSize4.bind(Board.scene.widthProperty().add(Board.scene.heightProperty()).divide(50));
		
		t1.styleProperty().bind(Bindings.concat("-fx-font-size: ", tfontSize3.asString()));
		t1n2.styleProperty().bind(Bindings.concat("-fx-font-size: ", tfontSize3.asString()));
		t1n3.styleProperty().bind(Bindings.concat("-fx-font-size: ", tfontSize.asString()));
		
		t2.styleProperty().bind(Bindings.concat("-fx-font-size: ", tfontSize.asString()));
		t2n2.styleProperty().bind(Bindings.concat("-fx-font-size: ", tfontSize.asString()));
		
		t3.styleProperty().bind(Bindings.concat("-fx-font-size: ", tfontSize.asString()));
		t3n2.styleProperty().bind(Bindings.concat("-fx-font-size: ", tfontSize.asString()));
		
		t4.styleProperty().bind(Bindings.concat("-fx-font-size: ", tfontSize.asString()));
		t4n2.styleProperty().bind(Bindings.concat("-fx-font-size: ", tfontSize.asString()));
		
		t5.styleProperty().bind(Bindings.concat("-fx-font-size: ", tfontSize.asString()));
		t5n2.styleProperty().bind(Bindings.concat("-fx-font-size: ", tfontSize.asString()));
		
		t6.styleProperty().bind(Bindings.concat("-fx-font-size: ", tfontSize.asString()));
		t6n2.styleProperty().bind(Bindings.concat("-fx-font-size: ", tfontSize2.asString()));
		
		t7.styleProperty().bind(Bindings.concat("-fx-font-size: ", tfontSize.asString()));
		t7n2.styleProperty().bind(Bindings.concat("-fx-font-size: ", tfontSize.asString()));
		
		t8.styleProperty().bind(Bindings.concat("-fx-font-size: ", tfontSize.asString()));
		t8n2.styleProperty().bind(Bindings.concat("-fx-font-size: ", tfontSize.asString()));
		
		t9.styleProperty().bind(Bindings.concat("-fx-font-size: ", tfontSize4.asString()));
		t9n2.styleProperty().bind(Bindings.concat("-fx-font-size: ", tfontSize2.asString()));
		
		t10.styleProperty().bind(Bindings.concat("-fx-font-size: ", tfontSize.asString()));
		t10n2.styleProperty().bind(Bindings.concat("-fx-font-size: ", tfontSize.asString()));
		
		t11.styleProperty().bind(Bindings.concat("-fx-font-size: ", tfontSize2.asString()));
		
		t12.styleProperty().bind(Bindings.concat("-fx-font-size: ", tfontSize.asString()));
		t12n2.styleProperty().bind(Bindings.concat("-fx-font-size: ", tfontSize.asString()));
		
		t13.styleProperty().bind(Bindings.concat("-fx-font-size: ", tfontSize4.asString()));
		t13n2.styleProperty().bind(Bindings.concat("-fx-font-size: ", tfontSize2.asString()));
		
		t14.styleProperty().bind(Bindings.concat("-fx-font-size: ", tfontSize.asString()));
		t14n2.styleProperty().bind(Bindings.concat("-fx-font-size: ", tfontSize.asString()));
		
		t15.styleProperty().bind(Bindings.concat("-fx-font-size: ", tfontSize.asString()));
		t15n2.styleProperty().bind(Bindings.concat("-fx-font-size: ", tfontSize.asString()));
		
		t16.styleProperty().bind(Bindings.concat("-fx-font-size: ", tfontSize.asString()));
		
		t17.styleProperty().bind(Bindings.concat("-fx-font-size: ", tfontSize.asString()));
		t17n2.styleProperty().bind(Bindings.concat("-fx-font-size: ", tfontSize.asString()));
		
		t18.styleProperty().bind(Bindings.concat("-fx-font-size: ", tfontSize.asString()));
		t18n2.styleProperty().bind(Bindings.concat("-fx-font-size: ", tfontSize.asString()));
		
		t19.styleProperty().bind(Bindings.concat("-fx-font-size: ", tfontSize4.asString()));
		t19n2.styleProperty().bind(Bindings.concat("-fx-font-size: ", tfontSize2.asString()));
		
		t20.styleProperty().bind(Bindings.concat("-fx-font-size: ", tfontSize.asString()));
		t20n2.styleProperty().bind(Bindings.concat("-fx-font-size: ", tfontSize.asString()));
		
		Pane jail = new Pane(jsquare6,t6);
		jail.prefHeightProperty().bind(board.heightProperty().divide(12));
		jail.prefWidthProperty().bind(board.widthProperty().divide(6));
		t6.setAlignment(Pos.CENTER);
		jsquare6.heightProperty().bind(board.heightProperty().divide(12));
		jsquare6.widthProperty().bind(board.widthProperty().divide(6));
		
		VBox textbox1 = new VBox(t1,t1n2,t1n3);
		VBox textbox2 = new VBox(t2,t2n2);
		VBox textbox3 = new VBox(t3,t3n2);
		VBox textbox4 = new VBox(t4,t4n2);
		VBox textbox5 = new VBox(t5,t5n2);
		VBox textbox6 = new VBox(jail,t6n2);
		VBox textbox7 = new VBox(t7,t7n2);
		VBox textbox8 = new VBox(t8,t8n2);
		VBox textbox9 = new VBox(t9,t9n2);
		VBox textbox10 = new VBox(t10,t10n2);
		VBox textbox11 = new VBox(t11);
		VBox textbox12 = new VBox(t12,t12n2);
		VBox textbox13 = new VBox(t13,t13n2);
		VBox textbox14 = new VBox(t14,t14n2);
		VBox textbox15 = new VBox(t15,t15n2);
		VBox textbox16 = new VBox(t16);
		VBox textbox17 = new VBox(t17,t17n2);
		VBox textbox18 = new VBox(t18,t18n2);
		VBox textbox19 = new VBox(t19,t19n2);
		VBox textbox20 = new VBox(t20,t20n2);
		
		textbox1.prefHeightProperty().bind(board.heightProperty().divide(6));
		textbox1.prefWidthProperty().bind(board.widthProperty().divide(6));
		textbox2.prefHeightProperty().bind(board.heightProperty().divide(6).subtract(r2.heightProperty()));
		textbox2.prefWidthProperty().bind(board.widthProperty().divide(6).subtract(r2.widthProperty()));
		textbox3.prefHeightProperty().bind(board.heightProperty().divide(6).subtract(r3.heightProperty()));
		textbox3.prefWidthProperty().bind(board.widthProperty().divide(6).subtract(r3.widthProperty()));
		textbox4.prefHeightProperty().bind(board.heightProperty().divide(6));
		textbox4.prefWidthProperty().bind(board.widthProperty().divide(6));
		textbox5.prefHeightProperty().bind(board.heightProperty().divide(6).subtract(r5.heightProperty()));
		textbox5.prefWidthProperty().bind(board.widthProperty().divide(6).subtract(r5.widthProperty()));
		textbox6.prefHeightProperty().bind(board.heightProperty().divide(6));
		textbox6.prefWidthProperty().bind(board.widthProperty().divide(6));
		textbox7.prefHeightProperty().bind(board.heightProperty().divide(6).subtract(r7.heightProperty()));
		textbox7.prefWidthProperty().bind(board.widthProperty().divide(6).subtract(r7.widthProperty()));
		textbox8.prefHeightProperty().bind(board.heightProperty().divide(6).subtract(r8.heightProperty()));
		textbox8.prefWidthProperty().bind(board.widthProperty().divide(6).subtract(r8.widthProperty()));
		textbox9.prefHeightProperty().bind(board.heightProperty().divide(6));
		textbox9.prefWidthProperty().bind(board.widthProperty().divide(6));
		textbox10.prefHeightProperty().bind(board.heightProperty().divide(6).subtract(r10.heightProperty()));
		textbox10.prefWidthProperty().bind(board.widthProperty().divide(6).subtract(r10.widthProperty()));
		textbox11.prefHeightProperty().bind(board.heightProperty().divide(6));
		textbox11.prefWidthProperty().bind(board.widthProperty().divide(6));
		textbox12.prefHeightProperty().bind(board.heightProperty().divide(6).subtract(r12.heightProperty()));
		textbox12.prefWidthProperty().bind(board.widthProperty().divide(6).subtract(r12.widthProperty()));
		textbox13.prefHeightProperty().bind(board.heightProperty().divide(6));
		textbox13.prefWidthProperty().bind(board.widthProperty().divide(6));
		textbox14.prefHeightProperty().bind(board.heightProperty().divide(6).subtract(r14.heightProperty()));
		textbox14.prefWidthProperty().bind(board.widthProperty().divide(6).subtract(r14.widthProperty()));
		textbox15.prefHeightProperty().bind(board.heightProperty().divide(6).subtract(r15.heightProperty()));
		textbox15.prefWidthProperty().bind(board.widthProperty().divide(6).subtract(r15.widthProperty()));
		textbox16.prefHeightProperty().bind(board.heightProperty().divide(6));
		textbox16.prefWidthProperty().bind(board.widthProperty().divide(6));
		textbox17.prefHeightProperty().bind(board.heightProperty().divide(6).subtract(r17.heightProperty()));
		textbox17.prefWidthProperty().bind(board.widthProperty().divide(6).subtract(r17.widthProperty()));
		textbox18.prefHeightProperty().bind(board.heightProperty().divide(6).subtract(r18.heightProperty()));
		textbox18.prefWidthProperty().bind(board.widthProperty().divide(6).subtract(r18.widthProperty()));
		textbox19.prefHeightProperty().bind(board.heightProperty().divide(6));
		textbox19.prefWidthProperty().bind(board.widthProperty().divide(6));
		textbox20.prefHeightProperty().bind(board.heightProperty().divide(6).subtract(r20.heightProperty()));
		textbox20.prefWidthProperty().bind(board.widthProperty().divide(6).subtract(r20.widthProperty()));
		
		textbox1.setAlignment(Pos.CENTER);
		textbox2.setAlignment(Pos.CENTER);
		textbox3.setAlignment(Pos.CENTER);
		textbox4.setAlignment(Pos.CENTER);
		textbox5.setAlignment(Pos.CENTER);
		textbox6.setAlignment(Pos.TOP_CENTER);
		textbox11.setAlignment(Pos.CENTER);
		textbox12.setAlignment(Pos.CENTER);
		textbox13.setAlignment(Pos.CENTER);
		textbox14.setAlignment(Pos.CENTER);
		textbox15.setAlignment(Pos.CENTER);
		textbox16.setAlignment(Pos.CENTER);
		
		textbox7.setAlignment(Pos.CENTER);
		textbox8.setAlignment(Pos.CENTER);
		textbox9.setAlignment(Pos.CENTER);
		textbox10.setAlignment(Pos.CENTER);
		textbox17.setAlignment(Pos.CENTER);
		textbox18.setAlignment(Pos.CENTER);
		textbox19.setAlignment(Pos.CENTER);
		textbox20.setAlignment(Pos.CENTER);
		
		textbox7.setRotate(180);
		textbox8.setRotate(180);
		textbox10.setRotate(180);
		textbox12.setRotate(180);
		textbox14.setRotate(180);
		textbox15.setRotate(180);
		//textbox16.setRotate(45);
		//textbox1.setRotate(315);
		
		r2.heightProperty().bind(board.heightProperty().divide(30));
		r2.widthProperty().bind(board.widthProperty().divide(6));
		r2.setFill(Color.GREY);
		r3.heightProperty().bind(board.heightProperty().divide(30));
		r3.widthProperty().bind(board.widthProperty().divide(6));
		r3.setFill(Color.GREY);
		r5.heightProperty().bind(board.heightProperty().divide(30));
		r5.widthProperty().bind(board.widthProperty().divide(6));
		r5.setFill(Color.GREY);
		r12.heightProperty().bind(board.heightProperty().divide(30));
		r12.widthProperty().bind(board.widthProperty().divide(6));
		r12.setFill(Color.GREY);
		r14.heightProperty().bind(board.heightProperty().divide(30));
		r14.widthProperty().bind(board.widthProperty().divide(6));
		r14.setFill(Color.GREY);
		r15.heightProperty().bind(board.heightProperty().divide(30));
		r15.widthProperty().bind(board.widthProperty().divide(6));
		r15.setFill(Color.GREY);
		r17.heightProperty().bind(board.heightProperty().divide(6));
		r17.widthProperty().bind(board.widthProperty().divide(30));
		r17.setFill(Color.GREY);
		r18.heightProperty().bind(board.heightProperty().divide(6));
		r18.widthProperty().bind(board.widthProperty().divide(30));
		r18.setFill(Color.GREY);
		r20.heightProperty().bind(board.heightProperty().divide(6));
		r20.widthProperty().bind(board.widthProperty().divide(30));
		r20.setFill(Color.GREY);
		r7.heightProperty().bind(board.heightProperty().divide(6));
		r7.widthProperty().bind(board.widthProperty().divide(30));
		r7.setFill(Color.GREY);
		r8.heightProperty().bind(board.heightProperty().divide(6));
		r8.widthProperty().bind(board.widthProperty().divide(30));
		r8.setFill(Color.GREY);
		r10.heightProperty().bind(board.heightProperty().divide(6));
		r10.widthProperty().bind(board.widthProperty().divide(30));
		r10.setFill(Color.GREY);
		
		r12.setRotate(180);
		r14.setRotate(180);
		r15.setRotate(180);
		r7.setRotate(180);
		r8.setRotate(180);
		r10.setRotate(180);
		
		VBox vb1 = new VBox(textbox1);
		VBox vb2 = new VBox(r2,textbox2);
		VBox vb3 = new VBox(r3,textbox3);
		VBox vb4 = new VBox(textbox4);
		VBox vb5 = new VBox(r5,textbox5);
		VBox vb6 = new VBox(textbox6);
		HBox hb7 = new HBox(r7,textbox7);
		HBox hb8 = new HBox(r8,textbox8);
		HBox hb9 = new HBox(textbox9);
		HBox hb10 = new HBox(r10,textbox10);
		VBox vb11 = new VBox(textbox11);
		VBox vb12 = new VBox(r12,textbox12);
		VBox vb13 = new VBox(textbox13);
		VBox vb14 = new VBox(r14,textbox14);
		VBox vb15 = new VBox(r15,textbox15);
		VBox vb16 = new VBox(textbox16);
		HBox hb17 = new HBox(r17,textbox17);
		HBox hb18 = new HBox(r18,textbox18);
		HBox hb19 = new HBox(textbox19);
		HBox hb20 = new HBox(r20,textbox20);
		
		Pane pos1 = new Pane(square1,vb1);
		Pane pos2 = new Pane(square2,vb2);
		Pane pos3 = new Pane(square3,vb3);
		Pane pos4 = new Pane(square4,vb4);
		Pane pos5 = new Pane(square5,vb5);
		Pane pos6 = new Pane(square6,vb6);
		Pane pos7 = new Pane(square7,hb7);
		Pane pos8 = new Pane(square8,hb8);
		Pane pos9 = new Pane(square9,hb9);
		Pane pos10 = new Pane(square10,hb10);
		Pane pos11 = new Pane(square11,vb11);
		Pane pos12 = new Pane(square12,vb12);
		Pane pos13 = new Pane(square13,vb13);
		Pane pos14 = new Pane(square14,vb14);
		Pane pos15 = new Pane(square15,vb15);
		Pane pos16 = new Pane(square16,vb16);
		Pane pos17 = new Pane(square17,hb17);
		Pane pos18 = new Pane(square18,hb18);
		Pane pos19 = new Pane(square19,hb19);
		Pane pos20 = new Pane(square20,hb20);
		
		pos12.setRotate(180);
		pos14.setRotate(180);
		pos15.setRotate(180);
		pos7.setRotate(180);
		pos8.setRotate(180);
		pos10.setRotate(180);
		
        board.prefWidthProperty().bind(scene.widthProperty().divide(5).multiply(3));
        h1.prefWidthProperty().bind(scene.widthProperty().divide(5));
        h2.prefWidthProperty().bind(scene.widthProperty().divide(5));
        board.prefHeightProperty().bind(scene.heightProperty());
        h1.prefHeightProperty().bind(scene.heightProperty());
        h2.prefHeightProperty().bind(scene.heightProperty());
		
        up.prefWidthProperty().bind(board.widthProperty());
        low.prefWidthProperty().bind(board.widthProperty());
        up.prefHeightProperty().bind(board.heightProperty().divide(6).multiply(5));
        low.prefHeightProperty().bind(board.heightProperty().divide(6));
        
        t.prefHeightProperty().bind(board.heightProperty().divide(6).multiply(4));
        t.prefWidthProperty().bind(board.widthProperty().divide(6).multiply(4));
        upleft.prefWidthProperty().bind(board.widthProperty().divide(6));
        upleft.prefHeightProperty().bind(board.heightProperty().divide(6).multiply(5));
        upmid.prefWidthProperty().bind(board.widthProperty().divide(6).multiply(4));
        upmid.prefHeightProperty().bind(board.heightProperty().divide(6));
        upright.prefWidthProperty().bind(board.widthProperty().divide(6));
        upright.prefHeightProperty().bind(board.heightProperty().divide(6).multiply(5));
        upmidup.prefHeightProperty().bind(board.heightProperty().divide(6));
        upmidup.prefWidthProperty().bind(board.widthProperty().divide(6).multiply(4));
        
        pos1.prefWidthProperty().bind(low.widthProperty().divide(6));
        pos1.prefHeightProperty().bind(low.heightProperty().divide(6));
        pos2.prefWidthProperty().bind(low.widthProperty().divide(6));
        pos2.prefHeightProperty().bind(low.heightProperty().divide(6));
        pos3.prefWidthProperty().bind(low.widthProperty().divide(6));
        pos3.prefHeightProperty().bind(low.heightProperty().divide(6));
        pos4.prefWidthProperty().bind(low.widthProperty().divide(6));
        pos4.prefHeightProperty().bind(low.heightProperty().divide(6));
        pos5.prefWidthProperty().bind(low.widthProperty().divide(6));
        pos5.prefHeightProperty().bind(low.heightProperty().divide(6));
        pos6.prefWidthProperty().bind(low.widthProperty().divide(6));
        pos6.prefHeightProperty().bind(low.heightProperty().divide(6));
        pos7.prefWidthProperty().bind(board.widthProperty().divide(6));
        pos7.prefHeightProperty().bind(board.heightProperty().divide(6));
        pos8.prefWidthProperty().bind(board.widthProperty().divide(6));
        pos8.prefHeightProperty().bind(board.heightProperty().divide(6));
        pos9.prefWidthProperty().bind(board.widthProperty().divide(6));
        pos9.prefHeightProperty().bind(board.heightProperty().divide(6));
        pos10.prefWidthProperty().bind(board.widthProperty().divide(6));
        pos10.prefHeightProperty().bind(board.heightProperty().divide(6));
        pos11.prefWidthProperty().bind(board.widthProperty().divide(6));
        pos11.prefHeightProperty().bind(board.heightProperty().divide(6));
        pos12.prefWidthProperty().bind(board.widthProperty().divide(6));
        pos12.prefHeightProperty().bind(board.heightProperty().divide(6));
        pos13.prefWidthProperty().bind(board.widthProperty().divide(6));
        pos13.prefHeightProperty().bind(board.heightProperty().divide(6));
        pos14.prefWidthProperty().bind(board.widthProperty().divide(6));
        pos14.prefHeightProperty().bind(board.heightProperty().divide(6));
        pos15.prefWidthProperty().bind(board.widthProperty().divide(6));
        pos15.prefHeightProperty().bind(board.heightProperty().divide(6));
        pos16.prefWidthProperty().bind(board.widthProperty().divide(6));
        pos16.prefHeightProperty().bind(board.heightProperty().divide(6));
        pos17.prefWidthProperty().bind(board.widthProperty().divide(6));
        pos17.prefHeightProperty().bind(board.heightProperty().divide(6));
        pos18.prefWidthProperty().bind(board.widthProperty().divide(6));
        pos18.prefHeightProperty().bind(board.heightProperty().divide(6));
        pos19.prefWidthProperty().bind(board.widthProperty().divide(6));
        pos19.prefHeightProperty().bind(board.heightProperty().divide(6));
        pos20.prefWidthProperty().bind(board.widthProperty().divide(6));
        pos20.prefHeightProperty().bind(board.heightProperty().divide(6));
        
        low.getChildren().addAll(pos6,pos5,pos4,pos3,pos2,pos1);
        upleft.getChildren().addAll(pos11,pos10,pos9,pos8,pos7);
        upmidup.getChildren().addAll(pos12,pos13,pos14,pos15);
        upright.getChildren().addAll(pos16,pos17,pos18,pos19,pos20);
        
        t.getChildren().add(title);
        upmid.getChildren().addAll(upmidup,t);
        up.getChildren().addAll(upleft,upmid,upright);
        board.getChildren().addAll(up,low);
        b.getChildren().addAll(board,p1, p2, p3, p4, p5, p6);
        rt.getChildren().clear();
        rt.getChildren().addAll(h1,b,h2);
        h2.getChildren().clear();
        h2.getChildren().add(Info);
        Buttons.AddButtons();
        Menu.window.setScene(scene);
	}
	public static void close() throws Exception{
		Stage stage = new Stage();
		Scene scene = new Scene(Menu.root);
		stage.setScene(scene);
		stage.show();
	}
	public static void removeplayer(int p){
		switch(p){
			case 1: p1.setVisible(false);break;
			case 2: p2.setVisible(false);break;
			case 3: p3.setVisible(false);break;
			case 4: p4.setVisible(false);break;
			case 5: p5.setVisible(false);break;
			case 6: p6.setVisible(false);break;
		}
	}
	public static void removeproperty(int i){
		switch(i){
			case 0: r2.setFill(Color.GREY);break;
			case 1: r3.setFill(Color.GREY);break;
			case 2: r5.setFill(Color.GREY);break;
			case 3: r7.setFill(Color.GREY);break;
			case 4: r8.setFill(Color.GREY);break;
			case 5: r10.setFill(Color.GREY);break;
			case 6: r12.setFill(Color.GREY);break;
			case 7: r14.setFill(Color.GREY);break;
			case 8: r15.setFill(Color.GREY);break;
			case 9: r17.setFill(Color.GREY);break;
			case 10: r18.setFill(Color.GREY);break;
			case 11: r20.setFill(Color.GREY);break;
		}
	}
	public static void move(int pos,Circle player,int p){
		int i = 0;
		switch(p){
			case 1: i=0;break;
			case 2: i=1;break;
			case 3: i=2;break;
			case 4: i=3;break;
			case 5: i=4;break;
			case 6: i=5;break;
		}
		switch(pos){
			case -1: player.centerXProperty().bind(playerX.multiply(7-i).divide(52));
					player.centerYProperty().bind(playerY.multiply(48).divide(52));
					break;
			case 1: player.centerXProperty().bind(playerX.multiply(52-i).divide(52));
					player.centerYProperty().bind(playerY.multiply(52-i).divide(52));
					break;
			case 2: player.centerXProperty().bind(playerX.multiply(43-i).divide(52));
					player.centerYProperty().bind(playerY.multiply(52-i).divide(52));
					break;
			case 3: player.centerXProperty().bind(playerX.multiply(34-i).divide(52));
					player.centerYProperty().bind(playerY.multiply(52-i).divide(52));
					break;
			case 4: player.centerXProperty().bind(playerX.multiply(25-i).divide(52));
					player.centerYProperty().bind(playerY.multiply(52-i).divide(52));
					break;
			case 5: player.centerXProperty().bind(playerX.multiply(16-i).divide(52));
					player.centerYProperty().bind(playerY.multiply(52-i).divide(52));
					break;
			case 6: player.centerXProperty().bind(playerX.multiply(7-i).divide(52));
					player.centerYProperty().bind(playerY.multiply(52).divide(52));
					break;
			case 7: player.centerXProperty().bind(playerX.multiply(7-i).divide(52));
					player.centerYProperty().bind(playerY.multiply(43-i).divide(52));
					break;
			case 8: player.centerXProperty().bind(playerX.multiply(7-i).divide(52));
					player.centerYProperty().bind(playerY.multiply(34-i).divide(52));
					break;
			case 9: player.centerXProperty().bind(playerX.multiply(7-i).divide(52));
					player.centerYProperty().bind(playerY.multiply(25-i).divide(52));
					break;
			case 10: player.centerXProperty().bind(playerX.multiply(7-i).divide(52));
					player.centerYProperty().bind(playerY.multiply(16-i).divide(52));
					break;
			case 11: player.centerXProperty().bind(playerX.multiply(7-i).divide(52));
					player.centerYProperty().bind(playerY.multiply(7-i).divide(52));
					break;
			case 12: player.centerXProperty().bind(playerX.multiply(16-i).divide(52));
					player.centerYProperty().bind(playerY.multiply(7-i).divide(52));
					break;
			case 13: player.centerXProperty().bind(playerX.multiply(25-i).divide(52));
					player.centerYProperty().bind(playerY.multiply(7-i).divide(52));
					break;
			case 14: player.centerXProperty().bind(playerX.multiply(34-i).divide(52));
					player.centerYProperty().bind(playerY.multiply(7-i).divide(52));
					break;
			case 15: player.centerXProperty().bind(playerX.multiply(43-i).divide(52));
					player.centerYProperty().bind(playerY.multiply(7-i).divide(52));
					break;
			case 16: player.centerXProperty().bind(playerX.multiply(52-i).divide(52));
					player.centerYProperty().bind(playerY.multiply(7-i).divide(52));
					break;
			case 17: player.centerXProperty().bind(playerX.multiply(52-i).divide(52));
					player.centerYProperty().bind(playerY.multiply(16-i).divide(52));
					break;
			case 18: player.centerXProperty().bind(playerX.multiply(52-i).divide(52));
					player.centerYProperty().bind(playerY.multiply(25-i).divide(52));
					break;
			case 19: player.centerXProperty().bind(playerX.multiply(52-i).divide(52));
					player.centerYProperty().bind(playerY.multiply(34-i).divide(52));
					break;
			case 20: player.centerXProperty().bind(playerX.multiply(52-i).divide(52));
					player.centerYProperty().bind(playerY.multiply(43-i).divide(52));
					break;
		}
	}
	public static void UpdateBoard(){
		if(!Game.lose[0]){move(Game.pos[0], Board.p1,1);}else{
            Board.p1.setVisible(false);}
		if(!Game.lose[1]){move(Game.pos[1], Board.p2,2);}else{
            Board.p2.setVisible(false);}
		if(!Game.lose[2]){move(Game.pos[2], Board.p3,3);}else{
            Board.p3.setVisible(false);}
		if(!Game.lose[3]){move(Game.pos[3], Board.p4,4);}else{
            Board.p4.setVisible(false);}
		if(!Game.lose[4]){move(Game.pos[4], Board.p5,5);}else{
            Board.p5.setVisible(false);}
		if(!Game.lose[5]){move(Game.pos[5], Board.p6,6);}else{
            Board.p6.setVisible(false);}
		
		if(Game.isinjail[0]){move(-1, Board.p1,1);}
		if(Game.isinjail[1]){move(-1, Board.p2,2);}
		if(Game.isinjail[2]){move(-1, Board.p3,3);}
		if(Game.isinjail[3]){move(-1, Board.p4,4);}
		if(Game.isinjail[4]){move(-1, Board.p5,5);}
		if(Game.isinjail[5]){move(-1, Board.p6,6);}
		
		for(int i=0;i<12;i++){
			for(int j=0;j<6;j++){
				if(Game.property[j][i]){
					switch(i){
				    	case 0: Board.r2.setFill(Game.color[j]);break;
				    	case 1: Board.r3.setFill(Game.color[j]);break;
				    	case 2: Board.r5.setFill(Game.color[j]);break;
				    	case 3: Board.r7.setFill(Game.color[j]);break;
				    	case 4: Board.r8.setFill(Game.color[j]);break;
				    	case 5: Board.r10.setFill(Game.color[j]);break;
				    	case 6: Board.r12.setFill(Game.color[j]);break;
				    	case 7: Board.r14.setFill(Game.color[j]);break;
				    	case 8: Board.r15.setFill(Game.color[j]);break;
				    	case 9: Board.r17.setFill(Game.color[j]);break;
				    	case 10: Board.r18.setFill(Game.color[j]);break;
				    	case 11: Board.r20.setFill(Game.color[j]);break;
					}
				}
			}
		}
	}
	public static void main(String[] args){
		launch(args);
	}
	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
