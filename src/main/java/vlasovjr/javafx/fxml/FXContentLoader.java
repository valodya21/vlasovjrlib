package vlasovjr.javafx.fxml;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class FXContentLoader {

    /**
     *  @param fxmlURL path to .fxml file
     *  @return loaded object
     */
    public static <T> T load(String fxmlURL){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(FXContentLoader.class.getResource(fxmlURL));
        try {
            return loader.load();
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * This method use custom interface {@link InitFX} to work
     * @param pane the pane what will contain loaded file
     * @param fxmlURL path to .fxml file what will be loaded
     */
    public static void loadTo(AnchorPane pane, String fxmlURL){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(FXContentLoader.class.getResource(fxmlURL));
        AnchorPane anchorPane = null;
        InitFX initFX = null;
        try {
            anchorPane = loader.load();
            initFX = loader.getController();
            if(initFX!=null) initFX.myInit();
        } catch (IOException e){
            e.printStackTrace();
        }
        pane.getChildren().clear();
        pane.getChildren().addAll(anchorPane.getChildren());
        pane.getStylesheets().setAll(anchorPane.getStylesheets());
    }

    /**
     * This method use custom interface {@link InitFX} to work
     * @param pane the pane what will contain loaded file
     * @param date the date what will be transfer to the controller
     * @param fxmlURL path to .fxml file what will be loaded
     */
    public static void loadToWithDate(AnchorPane pane,Object date, String fxmlURL){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(FXContentLoader.class.getResource(fxmlURL));
        AnchorPane anchorPane = null;
        InitFX initFX = null;
        try {
            anchorPane = loader.load();
            initFX = loader.getController();
            if(initFX!=null) {
                initFX.myInit(date);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        pane.getChildren().clear();
        pane.getChildren().addAll(anchorPane.getChildren());
        pane.getStylesheets().setAll(anchorPane.getStylesheets());
    }
}
