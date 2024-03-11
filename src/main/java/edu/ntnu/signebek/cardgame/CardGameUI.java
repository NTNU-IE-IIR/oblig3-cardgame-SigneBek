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

  private Label sumFaces;
  private Label cardsHearts;
  private Label flush;
  private Label queenSpades;

  private CardGameController controller;

  @Override
  public void start(Stage stage) {
    this.controller = new CardGameController(this);

    BorderPane rootNode = new BorderPane();
    VBox centerPane=setCenterPane();

    rootNode.setCenter(centerPane);
    rootNode.setBackground(new Background(new BackgroundFill(Color.DARKGREEN, null, null)));

    Screen screen = Screen.getPrimary();
    Rectangle2D bounds = screen.getVisualBounds();
    Scene scene = new Scene(rootNode, bounds.getMaxX()-200, bounds.getMaxY()-100);
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

      Button checkHandButton = new Button("Check hand");

      VBox buttonsHands = new VBox(dealHandButton, checkHandButton);
      buttonsHands.setAlignment(Pos.CENTER);
      buttonsHands.setPadding(new Insets(10));
      buttonsHands.setSpacing(30);

      VBox bottomCenterPane=setBottomPane();
      topCenterPane.getChildren().addAll(card1,card2,card3,card4,card5,buttonsHands);
      topCenterPane.setPadding(new Insets(10));
      topCenterPane.setAlignment(Pos.CENTER_LEFT);
      topCenterPane.setSpacing(30);
      topCenterPane.setMinHeight(500);
      topCenterPane.setBackground(new Background(new BackgroundFill(Color.FORESTGREEN, null, null)));
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
      sumFacesT.setFont(Font.font(15));
      sumFaces = new Label("-");
      HBox one = new HBox(sumFacesT,sumFaces);
      one.setAlignment(Pos.TOP_CENTER);

      Text cardsHeartsT = new Text("Cards of hearts: ");
      cardsHeartsT.setFont(Font.font(15));
      cardsHearts = new Label("-");
      HBox two = new HBox(cardsHeartsT,cardsHearts);
      two.setAlignment(Pos.TOP_CENTER);

      Text flushT = new Text("Flush: ");
      flushT.setFont(Font.font(15));
      flush = new Label("-");
      HBox three = new HBox(flushT,flush);
      three.setAlignment(Pos.TOP_CENTER);

      Text queenSpadesT = new Text("Queen of spades?: ");
      queenSpadesT.setFont(Font.font(15));
      queenSpades = new Label("-");
      HBox four = new HBox(queenSpadesT,queenSpades);
      four.setAlignment(Pos.TOP_CENTER);

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
    for (int i=0; i <hand.size();i++){
      cardsOnHand.add(hand.get(i).getAsString());
      pathToFileCard.add("/cards/"+hand.get(i).getAsString()+".png");
    }
    System.out.println(cardsOnHand);
    System.out.println(pathToFileCard);
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

 public static void appMain(String[] args){
    launch();
  }


}
