package edu.ntnu.signebek.cardgame;


import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class CardGameUI extends Application {
  private ImageView card1;
  private ImageView card2;
  private ImageView card3;
  private ImageView card4;
  private ImageView card5;

  private Label sumFaces= new Label("-");
  private Label cardsHearts= new Label("-");
  private Label flush= new Label("-");
  private Label queenSpades= new Label("-");

  private CardGameController controller;

  @Override
  public void start(Stage stage) {
    //TODO make an css file for this mess
    this.controller = new CardGameController(this);

    BorderPane rootNode = new BorderPane();
    VBox centerPane=setCenterPane();

    rootNode.setCenter(centerPane);
    rootNode.getStyleClass().add("root");

    Screen screen = Screen.getPrimary();
    Rectangle2D bounds = screen.getVisualBounds();
    Scene scene = new Scene(rootNode, bounds.getMaxX()-200, bounds.getMaxY()-100);
    scene.getStylesheets().add(getClass().getResource("/css/stylesheet.css").toExternalForm());
    stage.setScene(scene);
    stage.setTitle("Card Game");
    stage.show();
  }


  private VBox setCenterPane(){
    VBox centerPane = new VBox();
    try{
      HBox topCenterPane= new HBox();
      int cardHeight = 300;
      int cardWidth = 200;
      Image backOfCard = new Image(getClass().getResource("/cards/back.png").toExternalForm());

      card1 = new ImageView(backOfCard);
      card1.setFitHeight(cardHeight);
      card1.setFitWidth(cardWidth);

      card2 = new ImageView(backOfCard);
      card2.setFitHeight(cardHeight);
      card2.setFitWidth(cardWidth);

      card3 = new ImageView(backOfCard);
      card3.setFitHeight(cardHeight);
      card3.setFitWidth(cardWidth);

      card4 = new ImageView(backOfCard);
      card4.setFitHeight(cardHeight);
      card4.setFitWidth(cardWidth);

      card5 = new ImageView(backOfCard);
      card5.setFitHeight(cardHeight);
      card5.setFitWidth(cardWidth);


      Button dealHandButton = new Button("Deal Hand");
      dealHandButton.setOnAction((event)->
         controller.dealHand()
          );
      dealHandButton.getStyleClass().add("buttons");

      Button checkHandButton = new Button("Check hand");
      checkHandButton.setOnAction((event)->
                                     controller.checkHand()
      );
      checkHandButton.getStyleClass().add("buttons");


      VBox buttonsHands = new VBox(dealHandButton, checkHandButton);
      buttonsHands.setAlignment(Pos.CENTER);
      buttonsHands.setPadding(new Insets(10));
      buttonsHands.setSpacing(30);

      VBox bottomCenterPane=setBottomPane();
      topCenterPane.getChildren().addAll(card1,card2,card3,card4,card5,buttonsHands);
      topCenterPane.getStyleClass().add("topCenterPane");
      centerPane.getChildren().addAll(topCenterPane,bottomCenterPane);


  } catch (Exception e){
    e.printStackTrace();
  }
    return centerPane;
  }

 private VBox setBottomPane() {
    VBox bottomPane = new VBox();
    try {

      Text sumFacesT = new Text("Sum of the faces: ");
      HBox one = new HBox(sumFacesT,sumFaces);
      one.getStyleClass().add("text-for-check");

      Text cardsHeartsT = new Text("Cards of hearts: ");
      HBox two = new HBox(cardsHeartsT,cardsHearts);
      two.getStyleClass().add("text-for-check");

      Text flushT = new Text("Flush: ");
      HBox three = new HBox(flushT,flush);
      three.getStyleClass().add("text-for-check");

      Text queenSpadesT = new Text("Queen of spades?: ");
      HBox four = new HBox(queenSpadesT,queenSpades);
      four.getStyleClass().add("text-for-check");

      bottomPane.getChildren().addAll(one, two, three, four);
      bottomPane.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
      bottomPane.setMinHeight(300);
      bottomPane.setSpacing(20);
      bottomPane.setAlignment(Pos.TOP_CENTER);
      bottomPane.setPadding(new Insets(10));

      return bottomPane;
    } catch (Exception e){
      e.printStackTrace();
      return null;
    }
 }

 public void dealHand(ArrayList<PlayingCard> hand){
   ArrayList<String> cardsOnHand=new ArrayList<>();
   ArrayList<String> pathToFileCard = new ArrayList<>();

   if (!(hand.isEmpty())){
      for (int i=0; i <hand.size();i++){
        cardsOnHand.add(hand.get(i).getAsString());
        pathToFileCard.add("/cards/"+hand.get(i).getAsString()+".png");
      }
    } else {
     for (int i=0; i <5;i++){
       pathToFileCard.add("/cards/back.png");
     }
    }
   //TODO refactor this shit
    this.card1.setImage(
        new ImageView(getClass().getResource(pathToFileCard.get(0)).toExternalForm()).getImage());
   this.card2.setImage(
       new ImageView(getClass().getResource(pathToFileCard.get(1)).toExternalForm()).getImage());
   this.card3.setImage(
       new ImageView(getClass().getResource(pathToFileCard.get(2)).toExternalForm()).getImage());
   this.card4.setImage(
       new ImageView(getClass().getResource(pathToFileCard.get(3)).toExternalForm()).getImage());
   this.card5.setImage(
       new ImageView(getClass().getResource(pathToFileCard.get(4)).toExternalForm()).getImage());

 }

 public void checkHand(ArrayList<String> heartsOnHand, int sumOfFaces,boolean flush, boolean queenOfSpades){
   this.sumFaces.setText(String.valueOf(sumOfFaces));

   if (!heartsOnHand.isEmpty()){
     this.cardsHearts.setText(String.valueOf(heartsOnHand));
   } else{
     this.cardsHearts.setText("None");
   }
   String flushCheck = "No";
   if (flush){
     flushCheck="Yes";
   }
   this.flush.setText(flushCheck);
   String S12 = "No";
   if (queenOfSpades){
     S12="Yes";
   }
   this.queenSpades.setText(S12);
 }
 public void setLabelBlank(){
   sumFaces.setText("-");
   cardsHearts.setText("-");
   flush.setText("-");
   queenSpades.setText("-");
 }

 public static void appMain(String[] args){

    launch();
  }


}
