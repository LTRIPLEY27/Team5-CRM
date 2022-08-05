package com.ironhack.ui;


import java.util.Scanner;

public interface ConsoleOperations {

    // Operations to create or find leads / opportunities
    String NEW = "new";
    String CONVERT = "convert";
    String SHOW = "show";
    String LOOKUP = "lookup";

    //Operations for Statuses
    String OPEN = "Open";
    String CLOSE_LOST = "Close-Lost";
    String CLOSE_WON = "Close-Won";

    // Operations for Products
    String HYBRID = "Hybrid";
    String FLATBED = "Flatbed";
    String BOX = "Box";

    // Operations for Industries
    String PRODUCE = "Produce";
    String ECOMMERCE = "E-Commerce";
    String MANUFACTURING = "Manufacturing";
    String MEDICAL = "Medical";
    String OTHER = "Other Industries";


}