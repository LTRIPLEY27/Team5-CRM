package com.ironhack.ui;

import javax.swing.*;
import java.util.*;

public class Menu implements ConsoleOperations {

    private static final Scanner scanner = new Scanner(System.in);

    private final MenuController menuController;

    public Menu(MenuController menuController) {
        this.menuController = menuController;
    }

    public void main() throws Exception {
        String input;
        do {
            var mainMenu = """
                    Welcome to CRM Manager
                    Available Operations
                                     
                    ===============
                    command -> 'new lead' for add a new Lead
                    command -> 'convert' plus the id for convert to new object
                    command -> 'show leads' for show all leads
                    command -> 'lookup lead' for see a lookup lead
                    command -> 'show opportunities' for show all oportunities
                    command -> 'lookup opportunity' for see a lookup opportunity
                    command -> 'open' for changes the sales states to open
                    command -> 'close-lost' for changes the sales states to CLOSE / LOST
                    command -> 'close-won' for changes the sales states to CLOSE / WON

                    [EXIT] - Exit CRM Manager
                    ===============
                    Write your COMMAND:
                    """;
            input = JOptionPane.showInputDialog(mainMenu).trim().toLowerCase();
            var inputSplit = input.split(" ");

            switch (inputSplit[0]) {
                case NEW -> newMenu(inputSplit);
                case CONVERT -> convertMenu(inputSplit);
                case SHOW -> showMenu(inputSplit);
                case LOOKUP -> lookupMenu(inputSplit);
                case OPEN -> openMenu(inputSplit);
                case CLOSE_LOST -> closeLostMenu(inputSplit);
                case CLOSE_WON -> closeWonMenu(inputSplit);
                case "exit" -> {
                    System.out.println("Adeu");
                    System.exit(1);
                }
                default -> System.out.println("Command not recognized!");
            }
        } while (!input.equals("exit"));
    }

    private void closeLostMenu(String[] inputSplit) throws Exception {
        if (inputSplit.length <= 1) {
            throw new Exception();
        }
        int id = Integer.parseInt(inputSplit[1]);

        menuController.closeLost(id);
    }

    private void closeWonMenu(String[] inputSplit) throws Exception {
        if (inputSplit.length <= 1) {
            throw new Exception();
        }
        int id = Integer.parseInt(inputSplit[1]);

        menuController.closeWon(id);
    }

    private void openMenu(String[] inputSplit) throws Exception {
        if (inputSplit.length <= 1) {
            throw new Exception();
        }
        int id = Integer.parseInt(inputSplit[1]);

        menuController.open(id);
    }

    private void lookupMenu(String[] inputSplit) throws Exception {
        if (inputSplit.length <= 2) {
            throw new Exception();
        }
        int id = Integer.parseInt(inputSplit[2]);
        switch (inputSplit[1]) {
            case ConsoleOperationEntities.LEAD -> menuController.lookUpLead(id);
            case ConsoleOperationEntities.OPPORTUNITY -> menuController.lookUpOpportunity(id);
            default -> throw new Exception();
        }
    }

    private void showMenu(String[] inputSplit) throws Exception {
        if (inputSplit.length <= 1) {
            throw new Exception();
        }
        switch (inputSplit[1]) {
            case ConsoleOperationEntities.LEADS -> menuController.showLeads();
            case ConsoleOperationEntities.OPPORTUNITIES -> menuController.showOpportunities();
            default -> throw new Exception();
        }
    }

    private void convertMenu(String[] inputSplit) throws Exception {
        if (inputSplit.length <= 1) {
            throw new Exception();
        }
        int id = Integer.parseInt(inputSplit[1]);

        menuController.convert(id);

    }

    private void newMenu(String[] inputSplit) throws Exception {
        if (inputSplit.length <= 1) {
            throw new Exception();
        }
        switch (inputSplit[1]) {
            case ConsoleOperationEntities.LEAD -> menuController.newLead();
            default -> throw new Exception();
        }
    }

}
