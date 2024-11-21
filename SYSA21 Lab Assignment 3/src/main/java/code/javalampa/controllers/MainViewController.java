package code.javalampa.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;

import java.util.ArrayList;

import code.javalampa.controllers.*;
import code.javalampa.models.AppModel;
import code.javalampa.models.PersonRegister;
import code.javalampa.models.Person;
import code.javalampa.models.BankAccount;

public class MainViewController {
    private AppModel appModel;
    private AppController appController;

    @FXML
    private TextField textInputName;

    @FXML
    private TextField textInputAge;

    @FXML
    private TextField textInputId;

    @FXML
    private TextField textInputAccountNo;

    @FXML
    private Button buttonSearchName;

    @FXML
    private Button buttonAddCustomer;

    @FXML
    private Button buttonRemoveCustomer;

    @FXML
    private Button buttonDeposit;

    @FXML
    private Button buttonWithdraw;

    @FXML
    private Button buttonSearchAccountNo;

    @FXML
    private TextArea textAreaAccountHolderName;

    @FXML
    private TextArea textAreaAccountHolderAge;

    @FXML
    private TextArea textAreaAccountHolderId;

    @FXML
    private TextArea textAreaAccount1Number;

    @FXML
    private TextArea textAreaAccount2Number;

    @FXML
    private TextArea textAreaAccount3Number;

    @FXML
    private TextArea textAreaAccount1Balance;

    @FXML
    private TextArea textAreaAccount2Balance;

    @FXML
    private TextArea textAreaAccount3Balance;

    @FXML
    private RadioButton radioButtonAccount1;

    @FXML
    private RadioButton radioButtonAccount2;

    @FXML
    private RadioButton radioButtonAccount3;

    @FXML
    private ToggleGroup accountSelector;

    @FXML
    private Label textLabelLog;

    @FXML
    private TextArea textInputOperationAmount;

    @FXML
    private TextField textInputAddNewAccount;

    @FXML
    private TextField textInputStartingBalance;

    @FXML
    private Button buttonAddNewAccount;

    @FXML
    private TextArea textAreaTotalAmount;

    private String selectedAccount;

    // Event handler methods
    @FXML
    private void buttonPressSearchName() {
        clearLog();
        clearCustomerInfo();
        clearAccountInfo();

        String idString = textInputId.getText().trim();

        if (idString == null || idString.isEmpty()) {
            logMessage("ID-number cannot be empty.");
            return;
        } else {
            Person person = appModel.getPersonRegister().findPerson(idString);
            System.out.println(person);

            if (person == null) {
                logMessage("Customer not found.");
                return;
            } else {
                displayCustomerInfo(person);

                displayAccountInfo(person.getAccounts(), person.getAccounts().size());

                clearInputFields();
            }
        }
    }

    @FXML
    private void buttonPressSearchAccoutnNo() {
        clearLog();
        clearCustomerInfo();
        clearAccountInfo();

        String accountNoString = textInputAccountNo.getText().trim();

        if (accountNoString == null || accountNoString.isEmpty()) {
            logMessage("Account number cannot be empty.");
            return;
        } else {
            BankAccount bankAccount = appModel.getPersonRegister().findAccount(accountNoString);

            if (bankAccount == null) {
                logMessage("Account not found.");
                return;
            } else {

                ArrayList<BankAccount> bankAccountList = new ArrayList<BankAccount>();
                bankAccountList.add(bankAccount);
                displayAccountInfo(bankAccountList, 1);

                clearInputFields(); }
        }
    }

    @FXML
    private void buttonPressAddCustomer() {
        clearLog();

        String name = textInputName.getText().trim();
        String idNumber = textInputId.getText().trim();
        int age = 0;

        try {
            age = Integer.parseInt(textInputAge.getText());
        } catch (NumberFormatException e) {
            logMessage("Invalid age input. Please enter a valid age.");
            return;
        }

        if (name == null || name.isEmpty()) {
            logMessage("Name cannot be empty.");
            return;
        }

        if (age < 18) {
            logMessage("Customer must be at least 18 years old.");
            return;
        }

        if (idNumber == null || idNumber.isEmpty()) {
            logMessage("ID number cannot be empty.");
            return;
        }

        PersonRegister personRegister = appModel.getPersonRegister();

        personRegister.addPerson(new Person(idNumber, name, age));

        Person person = personRegister.findPerson(idNumber);

        logMessage("Customer added successfully.");
        clearInputFields();
    }

    @FXML
    private void buttonPressRemoveCustomer() {
        clearLog();

        String idNumberToRemove = textAreaAccountHolderId.getText();

        if (idNumberToRemove == null || idNumberToRemove.isEmpty()) {
            logMessage("No customer to remove.");
            return;
        } else {
            PersonRegister personRegister = appModel.getPersonRegister();
            Person personToRemove = personRegister.findPerson(idNumberToRemove);

            if (personToRemove == null) {
                logMessage("Customer not found");
                return;
            }

            personRegister.removePerson(personToRemove);
            logMessage("Customer removed successfully: " + idNumberToRemove);
            clearCustomerInfo();
        }
    }

    @FXML
    private void buttonPressDeposit() {
        clearLog();

        BankAccount bankAccount = null;

        if (selectedAccount == "1") {
            bankAccount = appModel.getPersonRegister().findAccount(textAreaAccount1Number.getText());
        } else if (selectedAccount == "2") {
            // Handle deposit for account 2
            bankAccount = appModel.getPersonRegister().findAccount(textAreaAccount2Number.getText());
        } else if (selectedAccount == "3") {
            // Handle deposit for account 3
            bankAccount = appModel.getPersonRegister().findAccount(textAreaAccount3Number.getText());
        } else {
            logMessage("No account selected.");
        }

        if (bankAccount == null) {
            logMessage("Account not found.");
            return;
        }

        Double depositAmount = 0.0;

        try {
            depositAmount = Double.parseDouble(textInputOperationAmount.getText());
        } catch (NumberFormatException e) {
            logMessage("Invalid deposit amount. Please enter a valid number.");
            return;
        }

        if (depositAmount < 0) {
            logMessage("Cannot deposit a negative amount.");
            return;
        }

        bankAccount.deposit(depositAmount);

        logMessage(selectedAccount + " deposited successfully.");
        textInputOperationAmount.clear();
    }

    @FXML
    private void buttonPressWithdraw() {
        clearLog();
        
        BankAccount bankAccount = null;

        if (selectedAccount == "1") {
            bankAccount = appModel.getPersonRegister().findAccount(textAreaAccount1Number.getText());
        } else if (selectedAccount == "2") {
            // Handle deposit for account 2
            bankAccount = appModel.getPersonRegister().findAccount(textAreaAccount2Number.getText());
        } else if (selectedAccount == "3") {
            // Handle deposit for account 3
            bankAccount = appModel.getPersonRegister().findAccount(textAreaAccount3Number.getText());
        } else {
            logMessage("No account selected.");
        }

        if (bankAccount == null) {
            logMessage("Account not found.");
            return;
        }

        Double withdrawAmount = 0.0;

        try {
            withdrawAmount = Double.parseDouble(textInputOperationAmount.getText());
        } catch (NumberFormatException e) {
            logMessage("Invalid deposit amount. Please enter a valid number.");
            return;
        }

        if (withdrawAmount < 0) {
            logMessage("Cannot withdraw a negative amount.");
            return;
        }

        if ((bankAccount.getBalance() / 2) < withdrawAmount) {
            logMessage("Cannot withdraw more than half of the balance.");
            return;
        }

        if (bankAccount.getBalance() < 0) {
            logMessage("Cannot withdraw if balance is negative.");
            return;
        }

        bankAccount.withdraw(withdrawAmount);

        logMessage(selectedAccount + " withdrawn successfully.");
        textInputOperationAmount.clear();

    }

    @FXML
    private void buttonPressAddewAccount() {
        clearLog();

        String accountNo = textInputAddNewAccount.getText().trim();

        if (accountNo == null || accountNo.isEmpty()) {
            logMessage("Account number cannot be empty.");
            return;
        }

        Double startingBalance = 0.0;

        try {
            startingBalance = Double.parseDouble(textInputStartingBalance.getText());
        } catch (NumberFormatException e) {
            logMessage("Invalid starting balance. Please enter a valid number.");
            return;
        }

        String idNumber = textAreaAccountHolderId.getText();

        if (idNumber == null || idNumber.isEmpty()) {
            logMessage("No customer selected.");
            return;
        }

        PersonRegister personRegister = appModel.getPersonRegister();

        Person person = personRegister.findPerson(idNumber);

        if (person.getAccounts().size() >= 3) {
            logMessage("Customer already has 3 accounts, cannot add more.");
            return;
        }

        person.addAccount(new BankAccount(accountNo, startingBalance));

        logMessage("Account added successfully.");

        clearInputFields();
    }

    @FXML
    public void initialize() {
        accountSelector = new ToggleGroup();
        radioButtonAccount1.setToggleGroup(accountSelector);
        radioButtonAccount2.setToggleGroup(accountSelector);
        radioButtonAccount3.setToggleGroup(accountSelector);

        // Set default selected account
        selectedAccount = "";
        //radioButtonAccount1.setSelected(true);

        accountSelector.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == radioButtonAccount1) {
                selectedAccount = "Account1";
            } else if (newValue == radioButtonAccount2) {
                selectedAccount = "Account2";
            } else if (newValue == radioButtonAccount3) {
                selectedAccount = "Account3";
            }
        });
    }

    @FXML
    private void pressRadioButtonAccount1() {
        // Handle radio button account 1
        selectedAccount = "1";
    }

    @FXML
    private void pressRadioButtonAccount2() {
        // Handle radio button account 2
        selectedAccount = "2";
    }

    @FXML
    private void pressRadioButtonAccount3() {
        // Handle radio button account 3
        selectedAccount = "3";
    }

    // Methods to show logs/errors and to clear the label    
    public void clearLog() {
        textLabelLog.setText("");
    }

    public void logMessage(String message) {
        textLabelLog.setText(message);
    }

    public void displayCustomerInfo(Person person) {
        textAreaAccountHolderName.setText(person.getName());
        textAreaAccountHolderAge.setText(Integer.toString(person.getAge()));
        textAreaAccountHolderId.setText(person.getIdentificationNumber());
    }

    public void clearCustomerInfo() {
        textAreaAccountHolderName.clear();
        textAreaAccountHolderAge.clear();
        textAreaAccountHolderId.clear();
    }

    public void clearInputFields() {
        textInputName.clear();
        textInputAge.clear();
        textInputId.clear();
        textInputAccountNo.clear();
        textInputAddNewAccount.clear();
        textInputStartingBalance.clear();
    }

    public void setAppModel(AppModel appModel) {
        this.appModel = appModel;
    }

    public void setAppController(AppController appController) {
        this.appController = appController;
    }

    public void clearAccountInfo() {
        textAreaAccount1Number.clear();
        textAreaAccount1Balance.clear();
        textAreaAccount2Number.clear();
        textAreaAccount2Balance.clear();
        textAreaAccount3Number.clear();
        textAreaAccount3Balance.clear();
        radioButtonAccount1.setSelected(false);
        radioButtonAccount2.setSelected(false);
        radioButtonAccount3.setSelected(false);
        radioButtonAccount1.setDisable(true);
        radioButtonAccount2.setDisable(true);
        radioButtonAccount3.setDisable(true);
        selectedAccount = "";
        textInputOperationAmount.clear();
        textAreaTotalAmount.clear();
    }

    public void displayAccountInfo(ArrayList<BankAccount> accounts, int numberOfAccounts) {
        clearAccountInfo();

        Double totalAmDouble = 0.0;

        for (BankAccount account : accounts) {
            totalAmDouble += account.getBalance();
        }

        textAreaTotalAmount.setText(Double.toString(totalAmDouble));
        
        switch (numberOfAccounts) {
            case 0:
                break;
            case 1:
                textAreaAccount1Number.setText(accounts.get(0).getAccountNumber());
                textAreaAccount1Balance.setText(Double.toString(accounts.get(0).getBalance()));
                radioButtonAccount1.setDisable(false);
                break;
            case 2:
                textAreaAccount1Number.setText(accounts.get(0).getAccountNumber());
                textAreaAccount1Balance.setText(Double.toString(accounts.get(0).getBalance()));
                textAreaAccount2Number.setText(accounts.get(1).getAccountNumber());
                textAreaAccount2Balance.setText(Double.toString(accounts.get(1).getBalance()));
                radioButtonAccount1.setDisable(false);
                radioButtonAccount2.setDisable(false);
                break;
            case 3:
                textAreaAccount1Number.setText(accounts.get(0).getAccountNumber());
                textAreaAccount1Balance.setText(Double.toString(accounts.get(0).getBalance()));
                textAreaAccount2Number.setText(accounts.get(1).getAccountNumber());
                textAreaAccount2Balance.setText(Double.toString(accounts.get(1).getBalance()));
                textAreaAccount3Number.setText(accounts.get(2).getAccountNumber());
                textAreaAccount3Balance.setText(Double.toString(accounts.get(2).getBalance()));
                radioButtonAccount1.setDisable(false);
                radioButtonAccount2.setDisable(false);
                radioButtonAccount3.setDisable(false);
                break;
            default:
                break;
        }
    }

}