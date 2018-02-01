/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player;

import com.jfoenix.controls.JFXButton;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;

/**
 *
 * @author msalik42
 */
public class FXMLDocumentController implements Initializable {
    
     @FXML
    private JFXButton open;

    @FXML
    private JFXButton playVideo;

    @FXML
    private JFXButton pauseVideo;

    @FXML
    private JFXButton stopVideo;

    @FXML
    private JFXButton slowerVideo;

    @FXML
    private JFXButton slowVideo;

    @FXML
    private JFXButton normal;
    
    @FXML
    private JFXButton fastVideo;

    @FXML
    private JFXButton fasterVideo;

    @FXML
    private JFXButton exit;

    @FXML
    private MediaView mediaView;
    
    
    private MediaPlayer mediaplayer;
    
    private String filepath;
    
    @FXML
    void handleButtonAction(ActionEvent event) {
        FileChooser filechooser = new FileChooser();
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Select a file (.mp4)","*.mp4");
            filechooser.getExtensionFilters().add(filter);
            File file = filechooser.showOpenDialog(null);
            filepath = file.toURI().toString();
            if(filepath != null){
            Media media = new Media(filepath);
            mediaplayer = new MediaPlayer(media);
            mediaView.setMediaPlayer(mediaplayer);
            
            //DoubleProperty width = mediaView.fitWidthProperty();
            //DoubleProperty height = mediaView.fitHeightProperty();
            
            //width.bind(Bindings.selectDouble(mediaView.sceneProperty(),"width"));
            //height.bind(Bindings.selectDouble(mediaView.sceneProperty(),"hwight"));
            
            //mediaplayer.play();
            }
    
    }
    @FXML
    void exit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void fastVideo(ActionEvent event) {
        mediaplayer.setRate(1.5);
    }

    @FXML
    void fasterVideo(ActionEvent event) {
        mediaplayer.setRate(2);
    }

    @FXML
    void pauseVideo(ActionEvent event) {
        mediaplayer.pause();
    }

    @FXML
    void playVideo(ActionEvent event) {
        mediaplayer.play();
    }

    @FXML
    void slowVideo(ActionEvent event) {
        mediaplayer.setRate(0.75);
    }

    @FXML
    void slowerVideo(ActionEvent event) {
       mediaplayer.setRate(0.3);
    }

    @FXML
    void stopVideo(ActionEvent event) {
        mediaplayer.stop();
    }
    
    @FXML
    void normal(ActionEvent event) {
        mediaplayer.setRate(1);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
