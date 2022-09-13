package com.antoniomasfanclub.models;

import com.antoniomasfanclub.models.enums.*;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class CLI {
    private final CRM crm;
    private final Scanner scanner;
    /**
     * We use this in order  to be able to display emojis in Windows terminals too
     */
    private final PrintWriter printer = new PrintWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8), true);

    public CLI() {
        crm = new CRM();
        scanner = new Scanner(System.in);
        populateCRM();
    }


    /**
     * The core method of the CRM, and the only public one. Creates an infinite loop that translates user input into
     * actions, and only ends when instructed to by the user,
     */
    public void startCRM() {
        printer.println(Colours.BACKGROUND_YELLOW + "@@@@@@@@@@@@ Welcome to the " + Colours.RED + "🍆Antonio Mas👼🏻 Fan Club CRM®️" + Colours.BLACK + "! @@@@@@@@@@@@" + Colours.RESET);
        boolean run = true;

        do {
            printCRMOptions();
            String[] userInput = scanner.nextLine().trim().toLowerCase().split("[ -]");
            try {
                switch (userInput[0]) {
                    case "new":
                        if (userInput[1].equals("lead")) {
                            createNewLead();
                            break;
                        }
                    case "lookup":
                        int id = Integer.parseInt(userInput[userInput.length - 1]);
                        if (userInput[1].equals("lead")) {
                            printItem(() -> this.crm.getLead(id));
                            break;
                        }
                        if (userInput[1].equals("opportunity")) {
                            printItem(() -> this.crm.getOpportunity(id));
                            break;
                        }
                        if (userInput[1].equals("contact")) {
                            printItem(() -> this.crm.getContact(id));
                            break;
                        }
                        if (userInput[1].equals("account")) {
                            printItem(() -> this.crm.getAccount(id).getFullDetails());
                            break;
                        }
                        if (userInput[1].equals("sales") || userInput[1].equals("salesrep")) {
                            printItem(() -> this.crm.getSalesRep(id).getFullDetails());
                            break;
                        }
                        printer.println("Could not understand your input, please try again using " + colour(Colours.CYAN, "lead") + ", " + colour(Colours.CYAN, "contact") + ", " + colour(Colours.CYAN, "account") + " , " + colour(Colours.CYAN, "opportunity") + " or " + colour(Colours.CYAN, "sales rep") + " followed by the id");
                        break;
                    case "list":
                        if (userInput[1].equals("leads")) {
                            printList(this.crm.getLeads());
                            break;
                        }
                        if (userInput[1].equals("opportunities")) {
                            printList(this.crm.getOpportunities());
                            break;
                        }
                        if (userInput[1].equals("contacts")) {
                            printList(this.crm.getContacts());
                            break;
                        }
                        if (userInput[1].equals("accounts")) {
                            printList(this.crm.getAccounts());
                            break;
                        }
                        if (userInput[1].equals("sales") || userInput[1].equals("salesreps")) {
                            printList(this.crm.getSalesReps());
                            break;
                        }
                        printer.println("Could not understand your input, please try again using " + colour(Colours.CYAN, "leads") + ", " + colour(Colours.CYAN, "contacts") + ", " + colour(Colours.CYAN, "accounts") + ", " + colour(Colours.CYAN, "opportunities") + " or " + colour(Colours.CYAN, "sales reps") + ".");
                        break;
                    case "convert":
                        convertLead(Integer.parseInt(userInput[userInput.length - 1]));
                        break;
                    case "closed":
                        closeOpportunity(userInput);
                        break;
                    case "quit":
                        run = false;
                        break;
                    default:
                        printer.println("Sorry, I do not understand '" + colour(Colours.YELLOW, String.join(" ", userInput)) + "'. Could you try again?");
                }
            } catch (Exception e) {
                printer.println("Your command seems to be unrecognisable or incomplete. Please try again.");
                printer.println("If you are trying to enter an ID, make sure it's an " + colour(Colours.YELLOW, "integer") + " and that you include it " + colour(Colours.YELLOW, "at the end") + " of your command");
            }
        } while (run);
        printer.println("Quitting the CRM. " + colour(Colours.YELLOW, "Have a great day!"));
    }

    /**
     * To avoid clogging the previous method, the options menu is extracted to an independent method.
     */
    private void printCRMOptions() {
        printer.println();
        printer.println("- To create a new lead, type '" + colour(Colours.GREEN, Command.NEW_LEAD.toString()) + "' ");
        printer.println("- To see all details from a specific lead, sales rep, contact, account or opportunity, type '" + colour(Colours.GREEN, Command.LOOKUP.toString()) + "' or the equivalent, followed by the " + colour(Colours.GREEN, "item id"));
        printer.println("- To see all current leads, sales reps, contacts, accounts or opportunities, type '" + colour(Colours.GREEN, Command.LIST_LEADS.toString()) + "' or the equivalent");
        printer.println("- To convert a lead into an opportunity type '" + colour(Colours.GREEN, Command.CONVERT.toString()) + "' followed by the " + colour(Colours.GREEN, "lead id"));
        printer.println("- To close an opportunity, type '" + colour(Colours.RED, Command.CLOSED_LOST.toString()) + "' or '" + colour(Colours.GREEN, Command.CLOSED_WON.toString()) + "' followed by the " + colour(Colours.GREEN, "opportunity id"));
        printer.println("- To quit the CRM, type '" + colour(Colours.RED, Command.QUIT.toString()) + "' ");
    }

    /**
     * Creates a new lead using user console input to assign its values.
     */
    private void createNewLead() {
        Lead lead = new Lead();
        updateStringKey("Please introduce this lead's " + colour(Colours.CYAN, "👤 name") + ":", lead::setName);
        updateStringKey("Please introduce this lead's " + colour(Colours.CYAN, "🏢 company name") + ":", lead::setCompanyName);
        updateStringKey("Please introduce this lead's " + colour(Colours.CYAN, "☎️ phone number") + ":", lead::setPhoneNumber);
        updateStringKey("Please introduce this lead's " + colour(Colours.CYAN, "✉️ email") + ":", lead::setEmail);
        updateIntegerKeyFromMap("Please introduce this lead's " + colour(Colours.CYAN, "💼 sales rep") + ":",
                this.crm.salesReps, (Integer salesRepId) -> lead.setSalesRep(this.crm.getSalesRep(salesRepId)));


        this.crm.addLead(lead, lead.getSalesRep().getId());
        printer.println(colour(Colours.GREEN, "Success!") + " Lead with ID " + colour(Colours.CYAN, lead.getId() + "") + " was added to the leads list.");
    }

    /**
     * Converts an existing lead into an opportunity, generating a new account and contact in the process.
     *
     * @param key the ID of the lead instance to convert into an opportunity
     */
    private void convertLead(int key) {
        try {
            Lead lead = this.crm.getLead(key);
            Contact contact = new Contact(lead);
            printer.println("Converting the following lead: " + lead);

            Opportunity opportunity = createOpportunity(contact);
            printer.println("\nOpportunity created: " + opportunity + "\n");

            int nextInt = -1;
            boolean validInput = false;

            // In this do{} while() we await for an account ID or the keyword "new" in order to know if the new opportunity
            // should be associated with an existing account or  if we should create a new one
            do {
                printer.println("Please introduce the ID of the account you want to associate this opportunity with. If you want to create a new opportunity instead, type " + colour(Colours.GREEN, "new") + " instead");
                printList(this.crm.getAccounts());
                String[] userInput = scanner.nextLine().trim().toLowerCase().split("[ -]");

                if (userInput[0].equals("new")) {
                    Account account = createAccount(contact, opportunity);
                    printer.println("\nAccount created: " + account + "\n");
                    this.crm.addAccount(account);
                    validInput = true;

                } else try {
                    int index = Integer.parseInt(userInput[0]);
                    Account account = this.crm.getAccounts().get(index);
                    if (account == null)
                        printer.println(colour(Colours.RED, "Error - ") + "No account was found with ID " + nextInt);
                    else {
                        account.addOpportunity(opportunity);
                        account.addContact(contact);
                        validInput = true;
                    }
                } catch (NumberFormatException e) {
                    printError(e);
                }
            } while (!validInput);

            this.crm.addOpportunity(opportunity, lead.getSalesRep().getId());
            this.crm.addContact(contact);
            this.crm.deleteLead(key);

            printer.println("Completed lead conversion to opportunity\n");
        } catch (IllegalArgumentException e) {
            printError(e);
        }
    }

    /**
     * Creates a new Opportunity instance associated with a Contact instance.
     *
     * @param contact the Contact instance the new Opportunity should be associated with, based on the original Lead
     * @return the created Opportunity instance
     */
    private Opportunity createOpportunity(Contact contact) {
        Opportunity opportunity = new Opportunity();
        opportunity.setContact(contact);
        printer.println("Creating a new " + colour(Colours.GREEN, "opportunity"));
        updateIntegerKey("Please input this opportunity's quantity", opportunity::setQuantity);
        updateEnumKey(Product.BOX, opportunity::setProduct, opportunity::getProduct);
        updateEnumKey(Status.OPEN, opportunity::setStatus, opportunity::getStatus);
        return opportunity;
    }

    /**
     * Creates a new Account instance associated with a Contact and an Opportunity instances.
     *
     * @param contact     the Contact instance the new Account should be associated with, based on the original Lead
     * @param opportunity the Opportunity instance the new Account should be associated with
     * @return the created Account instance
     */
    private Account createAccount(Contact contact, Opportunity opportunity) {
        Account account = new Account();
        printer.println("Creating the associated " + colour(Colours.CYAN, "account"));
        account.addContact(contact);
        account.addOpportunity(opportunity);
        updateEnumKey(Industry.MEDICAL, account::setIndustry, account::getIndustry);
        updateStringKey("Please introduce this account's " + colour(Colours.GREEN, "🇺🇳 country") + ":", account::setCountry);
        updateStringKey("Please introduce this account's " + colour(Colours.CYAN, "🏬 city") + ":", account::setCity);
        updateIntegerKey("Please introduce this account's " + colour(Colours.YELLOW, "👔 employee count") + ":", account::setEmployeeCount);
        return account;
    }

    /**
     * Reads user input to find an opportunity and close it as instructed
     *
     * @param userInput String array ideally with: [1] 'won' or 'lost' strings, and [2] associated Opportunity id.
     */
    private void closeOpportunity(String[] userInput) {
        try {
            if (userInput[1].equals("lost")) {
                this.crm.getOpportunity(Integer.parseInt(userInput[2])).setStatus(Status.CLOSED_LOST);
                printer.println("Opportunity closed as " + colour(Colours.RED, "Lost"));
            } else if (userInput[1].equals("won")) {
                this.crm.getOpportunity(Integer.parseInt(userInput[2])).setStatus(Status.CLOSED_WON);
                printer.println("Opportunity closed as " + colour(Colours.GREEN, "Won"));

            } else {
                printer.println("Opportunities must be marked as " + colour(Colours.RED, "lost") + " or " + colour(Colours.GREEN, "won") + " when closing.");
            }
        } catch (IllegalArgumentException e) {
            printError(e);
        }
    }

    /**
     * Prints all the keys of any given Map onto the console.
     *
     * @param list Any kind of Map that you want to print on the console
     */
    private <T> void printList(Map<Integer, T> list) {
        if (list.keySet().size() == 0)
            printer.println("There are no items in this list.");
        for (int key : list.keySet()) {
            printer.println(list.get(key));
        }
    }

    /**
     * This method enables us to reuse the logic to print single object instances into the console
     *
     * @param itemGetter getter for the object instance you want to print
     */
    private void printItem(Callable<?> itemGetter) {
        try {
            printer.println(itemGetter.call());
        } catch (Exception e) {
            printError(e);
        }
    }

    /**
     * This method takes a generic function, and runs it until it no longer throws an exception.
     *
     * @param message      The message shown in the console before running the update method
     * @param updateMethod A consumer, ideally a class setter.
     */
    private void updateGenericKey(String message, Runnable updateMethod) {
        boolean wasUpdatedSuccessfully = false;
        do {
            printer.println(message);
            try {
                updateMethod.run();
                wasUpdatedSuccessfully = true;
            } catch (IllegalArgumentException e) {
                printError(e);
            }
        } while (!wasUpdatedSuccessfully);
    }

    /**
     * Enables a simple way to update String-based class instance properties from the console.
     *
     * @param message      The message shown in the console before running the update method
     * @param updateMethod A consumer, ideally a class setter, that accepts a String param.
     */
    private void updateStringKey(String message, Consumer<String> updateMethod) {
        updateGenericKey(message, () -> updateMethod.accept(scanner.nextLine()));
    }

    /**
     * Enables a simple way to update Integer-based class instance properties from the console.
     *
     * @param message      The message shown in the console before running the update method
     * @param updateMethod A consumer, ideally a class setter, that accepts an Integer param.
     */
    private void updateIntegerKey(String message, Consumer<Integer> updateMethod) {
        updateGenericKey(message, () -> {
            boolean validInput = false;
            int nextInt = 0;
            do {
                if (scanner.hasNextInt()) {
                    nextInt = scanner.nextInt();
                    validInput = true;
                } else printer.println("Only integers are allowed as options, please try again.");
                scanner.nextLine();
            } while (!validInput);
            updateMethod.accept(nextInt);
        });
    }

    /**
     * Enables a simple way to update Object keys from the console printing a map as an options list.
     *
     * @param message      The message shown in the console before running the update method
     * @param map          A map with Integer keys for the element you want to select
     * @param updateMethod A consumer, ideally a class setter, that accepts an Integer param.
     */
    private <T> void updateIntegerKeyFromMap(String message, Map<Integer, T> map, Consumer<Integer> updateMethod) {
        StringBuilder fullMessage = new StringBuilder(message + "\n");
        if (map.isEmpty()) {
            printer.println("There are " + colour(Colours.YELLOW, "no valid values") + " for this position. We shall leave it " + colour(Colours.YELLOW, "empty") + " for now.");
        } else {
            for (T value : map.values()) fullMessage.append(value.toString()).append("\n");
            this.updateIntegerKey(fullMessage.toString(), updateMethod);
        }
    }

    /**
     * This method takes an enum key and a class instance's property's getter and setter to provide a standarised way to update
     * enum based class properties.
     *
     * @param enumExample Any value for the enum of the class property you want to update
     * @param setter      Setter method to update the enum-based class property
     * @param getter      Getter method to check the enum-based class property
     */
    private <T extends Enum<T>> void updateEnumKey(Enum<T> enumExample, Consumer<T> setter, Supplier<T> getter) {
        do {
            int nextInt = 0;
            T[] enumValues = enumExample.getDeclaringClass().getEnumConstants();
            printer.println("Please enter the number of the product for this opportunity.");
            for (int i = 1; i <= enumValues.length; i++) {
                printer.println(colour(Colours.CYAN, " " + i + "- ") + enumValues[i - 1]);
            }
            if (scanner.hasNextInt()) {
                nextInt = scanner.nextInt();
                scanner.nextLine();
            } else {
                printer.println("Only integers are allowed as options, please try again.");
                scanner.nextLine();
            }
            if (nextInt > 0 && nextInt <= enumValues.length) {
                setter.accept(enumValues[nextInt - 1]);
            }
        } while (getter.get() == null);
    }

    /**
     * This simple method lets us avoid having to append Reset for every colour we add.
     *
     * @param colour the desired colour for the string, with the Colour enum
     * @param string the string you want to colour
     * @return Coloured string
     */
    protected static String colour(Colours colour, String string) {
        return colour + string + Colours.RESET;
    }

    private void printError(Exception e) {
        printer.println(colour(Colours.RED, "Error") + " " + e.getMessage() + "\n");
    }

    /**
     * Populate the CRM with dummy data so lists are not empty at app startup.
     */
    private void populateCRM() {
        SalesRep salesRep1 = new SalesRep("Pepe García");
        SalesRep salesRep2 = new SalesRep("María Barranco");

        this.crm.addSalesRep(salesRep1);
        this.crm.addSalesRep(salesRep2);

        this.crm.addLead(new Lead("Benito Pérez", "636227551", "beni@email.com", "MediaMarkt"), salesRep1.getId());
        this.crm.addLead(new Lead("Coronel Tapioca", "636726671", "tapi@email.com", "Inditex"), salesRep1.getId());
        this.crm.addLead(new Lead("Juan Benigómez", "637538792", "per@email.com", "Keychron"), salesRep2.getId());

        Contact contact1 = new Contact(new Lead("Esteban Coestáocupado", "687493822", "esteban@email.com", "BBVA"));
        Contact contact2 = new Contact(new Lead("Federico Trillo", "675392876", "fede@email.com", "Construcciones Trillo S.L."));

        this.crm.addContact(contact1);
        this.crm.addContact(contact2);

        Opportunity opportunity1 = new Opportunity(3, Product.FLATBED, Status.OPEN, contact1);
        Opportunity opportunity2 = new Opportunity(5, Product.HYBRID, Status.CLOSED_WON, contact2);

        opportunity1.setContact(contact1);
        opportunity2.setContact(contact2);

        salesRep1.addOpportunity(opportunity1);
        salesRep2.addOpportunity(opportunity2);

        this.crm.addOpportunity(opportunity1, salesRep1.getId());
        this.crm.addOpportunity(opportunity2, salesRep2.getId());

        Account account1 = new Account(Industry.MANUFACTURING, 135, "Barcelona", "Spain");
        Account account2 = new Account(Industry.ECOMMERCE, 56, "Madrid", "Spain");

        account1.addOpportunity(opportunity1);
        account2.addOpportunity(opportunity2);

        account1.addContact(contact1);
        account2.addContact(contact2);

        this.crm.addAccount(account1);
        this.crm.addAccount(account2);
    }
}
