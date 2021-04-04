import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;

public class Calculator extends Application{
    TextField num1 = new TextField();
    TextField num2 = new TextField();
    TextField result = new TextField();
    Button add = new Button("Add");
    Button subtract = new Button("Subtract");
    Button multiply = new Button("Multiply");
    Button divide = new Button("Divide");


    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11,11,11,11));
        pane.setVgap(5);
        pane.setHgap(5);

        pane.add(new Label("Num 1:"),0,0);
        pane.add(num1,1,0);
        num1.setPrefColumnCount(3);
        pane.add(new Label("Num 2:"),2,0);
        pane.add(num2,3,0);
        num2.setPrefColumnCount(1);
        pane.add(new Label("Result:"),4,0);
        pane.add(result,5,0);
        result.setPrefColumnCount(1);
        result.setEditable(false);
        pane.add(add,2,1);
        pane.setHalignment(add,HPos.RIGHT);
        add.setOnAction(e -> add());
        pane.add(subtract,3,1);
        pane.setHalignment(subtract,HPos.RIGHT);
        subtract.setOnAction(e -> subtract());
        pane.add(multiply,4,1);
        pane.setHalignment(multiply,HPos.RIGHT);
        multiply.setOnAction(e -> multiply());
        pane.add(divide,5,1);
        pane.setHalignment(divide,HPos.LEFT);
        divide.setOnAction(e -> divide());

        Scene sc = new Scene(pane,500,500);
        primaryStage.setScene(sc);
        primaryStage.setTitle("Basic Calculator");
        primaryStage.show();
    }

    public int min(int no_1, int no_2){
        if (no_1 < no_2){
            return no_1;
        }else return no_2;
    }
    public int max(int no_1, int no_2){
        if (no_1 > no_2){
            return no_1;
        }else return no_2;
    }

    public void add(){
        int answer = Integer.parseInt(num1.getText()) + Integer.parseInt(num2.getText());
        result.setText(String.valueOf(answer));
    }
    public void subtract(){
        int max = max(Integer.parseInt(num1.getText()), Integer.parseInt(num2.getText()));
        int min = min(Integer.parseInt(num1.getText()), Integer.parseInt(num2.getText()));
        int answer = max - min;
        result.setText(String.valueOf(answer));
    }
    public void multiply(){
        int answer = Integer.parseInt(num1.getText()) * Integer.parseInt(num2.getText());
        result.setText(String.valueOf(answer));
    }
    public void divide(){
        int max = max(Integer.parseInt(num1.getText()), Integer.parseInt(num2.getText()));
        int min = min(Integer.parseInt(num1.getText()), Integer.parseInt(num2.getText()));
        int answer = max / min;
        result.setText(String.valueOf(answer));
    }
}


