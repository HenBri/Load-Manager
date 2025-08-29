module com.libreria.libreria {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;  // agrega hibernate explícitamente
    requires java.sql;
    requires static lombok;

    // Para FXML
    opens com.libreria.libreria to javafx.fxml, org.hibernate.orm.core;
    opens com.libreria.libreria.controller to javafx.fxml;
    opens com.libreria.libreria.model.Entity to org.hibernate.orm.core;

    // Para Hibernate (reflection en entidades JPA)

    exports com.libreria.libreria;
    exports com.libreria.libreria.controller;
    exports com.libreria.libreria.model.Entity;
    exports com.libreria.libreria.model.Service;
}
