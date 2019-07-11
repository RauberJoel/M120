package rcas.util;

import javafx.scene.Scene;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.stage.Stage;
import rcas.model.RaceCar;

public class Variables {

    public static Scene scene;
    public static Stage primaryStage;

    public static String LCarName;
    public static double LFrontTrack;
    public static double LRearTrack;
    public static double LWheelbase;
    public static double LCogHeight;
    public static double LFrontRollDist;
    public static double LCornerWeightFL;
    public static double LCornerWeightRL;
    public static double LCornerWeightFR;
    public static double LCornerWeightRR;

    public static String ACarName;
    public static double AFrontTrack;
    public static double ARearTrack;
    public static double AWheelbase;
    public static double ACogHeight;
    public static double AFrontRollDist;
    public static double ACornerWeightFL;
    public static double ACornerWeightRL;
    public static double ACornerWeightFR;
    public static double ACornerWeightRR;

    public static String NCarName;
    public static double NFrontTrack;
    public static double NRearTrack;
    public static double NWheelbase;
    public static double NCogHeight;
    public static double NFrontRollDist;
    public static double NCornerWeightFL;
    public static double NCornerWeightRL;
    public static double NCornerWeightFR;
    public static double NCornerWeightRR;

    public static String selectedCar;

    public static String selectedTab;

    public static RaceCar LRaceCar;
    public static RaceCar ARaceCar;
    public static RaceCar NRaceCar;

    public static SingleSelectionModel<Tab> selectionModel;
}
