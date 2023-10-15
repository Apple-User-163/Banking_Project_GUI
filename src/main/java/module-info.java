module com.apple163.banking_project_gui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.apple163.banking_project_gui to javafx.fxml;
    exports com.apple163.banking_project_gui;
}