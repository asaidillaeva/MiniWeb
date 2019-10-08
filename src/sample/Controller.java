package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class Controller {
    @FXML
    private TextField searchTextField;
    @FXML
    private BorderPane borderPane;
    @FXML
    private Button searchButton;
    private WebEngine webBrowserEngine;

    @FXML
    private Label loadingLabel;

    @FXML
    private WebView mainWebView;
     @FXML
    void initialize(){
         webBrowserEngine = mainWebView.getEngine();
         loadingLabel.setText(" ");
         mainWebView.prefWidthProperty().bind(borderPane.widthProperty());
         mainWebView.prefHeightProperty().bind(borderPane.heightProperty());
     }




}
