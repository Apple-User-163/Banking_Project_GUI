module com.apple163.banking_project_gui {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;


    opens com.apple163.banking_project_gui to javafx.fxml;
    exports com.apple163.banking_project_gui;
}