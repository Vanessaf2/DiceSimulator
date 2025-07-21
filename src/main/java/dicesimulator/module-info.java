module dicesimulator {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics; // This line fixes the error you saw

    opens dicesimulator to javafx.fxml;
    exports dicesimulator;
}