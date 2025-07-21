module dicesimulator {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens dicesimulator to javafx.fxml;
    exports dicesimulator;
}
