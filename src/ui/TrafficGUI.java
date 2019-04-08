package ui;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import model.Traffic;
import threads.LightThread;

public class TrafficGUI {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Circle light;
    
    private Traffic tc;

    @FXML
    void startTraffic(ActionEvent event) throws InterruptedException {
    	LightThread l = new LightThread(this);
    	l.setDaemon(true);
    	l.start();
    	
    	tc.addStartTime(System.currentTimeMillis());
    }
    
    public void setFillGreen() {
    	light.setFill(Color.GREEN);
    }
    
    public void setFillYellow() {
    	light.setFill(Color.YELLOW);
    }
    
    public void setFillRed() {
    	light.setFill(Color.RED);
    }
    
    public void setFillWhite() {
    	light.setFill(Color.WHITE);
    }
    
    @FXML
    void exportReport(ActionEvent event) {
    	try {
			tc.exportReport();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    }

    

    @FXML
    void initialize() {
       tc = new Traffic();
    }
}

