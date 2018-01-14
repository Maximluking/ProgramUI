
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import services.CmdLineService;
import services.impl.ClientServiceDb;
import services.impl.ProductServiceDb;
import java.io.IOException;

public class Main extends Application{
    public static void main(String[] args) throws IOException {
        launch(args);
        CmdLineService cmdLineService = new CmdLineService(new ClientServiceDb(), new ProductServiceDb());
        cmdLineService.mainMenu();
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

}
