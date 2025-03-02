module com.farmline.farmline {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.json;
    requires mysql.connector.j;

    opens com.farmline.farmline.controller to javafx.fxml;
    exports com.farmline.farmline;
}
