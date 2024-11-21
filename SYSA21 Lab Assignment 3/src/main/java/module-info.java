module assignment3 {
    exports code.javalampa;
    exports code.javalampa.models;

    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    
    opens code.javalampa.controllers to javafx.fxml;
}

/*
* Define a new module named 'javafx.gui.lab'.
* This is the name of the module and can be used by
* other modules to refer to this one.
*/

    /*
    * Export the 'se.lu.ics' package, allowing other modules
    * to access the public classes and interfaces within this package.
    */

    /*
    * Declare that this module requires the 'javafx.fxml' module to function.
    * This means that the current module depends on
    * the JavaFX FXML library for its functionality.
    */

    /*
    * Declare that this module requires the 'javafx.controls' module.
    * This means it uses the JavaFX Controls library, which includes
    * UI components like buttons, text fields, etc.
    */

    /*
    * Declare a transitive dependency on the 'javafx.graphics' module.
    * This means that not only does this module
    * require 'javafx.graphics', but any module that requires
    * this module ('javafx.gui.lab') will also implicitly require 'javafx.graphics'.
    */

