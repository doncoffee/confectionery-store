package by.academy.controller;

import by.academy.controller.impl.create.*;
import by.academy.controller.impl.gotopage.*;
import by.academy.controller.impl.read.*;
import by.academy.controller.impl.delete.*;
import by.academy.controller.impl.update.*;

public enum CommandInvoker {
    CREATE_ADDRESS(new AddAddressCommand()),
    CREATE_BRAND(new AddBrandCommand()),
    CREATE_CHOCOLATE(new AddChocolateCommand()),
    CREATE_COOKIE(new AddCookieCommand()),
    CREATE_PHONE_NUMBER(new AddPhoneNumberCommand()),
    CREATE_STORE(new AddStoreCommand()),
    CREATE_SUPPLIER(new AddSupplierCommand()),
    CREATE_SWEETS(new AddSweetsCommand()),
    READ_ADDRESS(new ReadAddressCommand()),
    READ_BRAND(new ReadBrandCommand()),
    READ_CHOCOLATE(new ReadChocolateCommand()),
    READ_COOKIE(new ReadCookieCommand()),
    READ_PHONE_NUMBER(new ReadPhoneNumberCommand()),
    READ_STORE(new ReadStoreCommand()),
    READ_SUPPLIER(new ReadSupplierCommand()),
    READ_SWEETS(new ReadSweetsCommand()),
    DELETE_ADDRESS(new DeleteAddressCommand()),
    DELETE_BRAND(new DeleteBrandCommand()),
    DELETE_CHOCOLATE(new DeleteChocolateCommand()),
    DELETE_COOKIE(new DeleteCookieCommand()),
    DELETE_PHONE_NUMBER(new DeletePhoneNumberCommand()),
    DELETE_STORE(new DeleteStoreCommand()),
    DELETE_SUPPLIER(new DeleteSupplierCommand()),
    DELETE_SWEETS(new DeleteSweetsCommand()),
    UPDATE_ADDRESS(new UpdateAddressCommand()),
    UPDATE_BRAND(new UpdateBrandCommand()),
    UPDATE_CHOCOLATE(new UpdateChocolateCommand()),
    UPDATE_COOKIE(new UpdateCookieCommand()),
    UPDATE_PHONE_NUMBER(new UpdatePhoneNumberCommand()),
    UPDATE_STORE(new UpdateStoreCommand()),
    UPDATE_SUPPLIER(new UpdateSupplierCommand()),
    UPDATE_SWEETS(new UpdateSweetsCommand()),
    GO_TO_ADD_ADDRESS(new GoToAddAddressCommand()),
    GO_TO_ADD_BRAND(new GoToAddBrandCommand()),
    GO_TO_ADD_CHOCOLATE(new GoToAddChocolateCommand()),
    GO_TO_ADD_COOKIE(new GoToAddCookieCommand()),
    GO_TO_ADD_PHONE_NUMBER(new GoToAddPhoneNumberCommand()),
    GO_TO_ADD_STORE(new GoToAddStoreCommand()),
    GO_TO_ADD_SUPPLIER(new GoToAddSupplierCommand()),
    GO_TO_ADD_SWEETS(new GoToAddSweetsCommand()),
    GO_TO_EDIT_ADDRESS(new GoToEditAddressCommand()),
    GO_TO_EDIT_BRAND(new GoToEditBrandCommand()),
    GO_TO_EDIT_CHOCOLATE(new GoToEditChocolateCommand()),
    GO_TO_EDIT_COOKIE(new GoToEditCookieCommand()),
    GO_TO_EDIT_PHONE_NUMBER(new GoToEditPhoneNumberCommand()),
    GO_TO_EDIT_STORE(new GoToEditStoreCommand()),
    GO_TO_EDIT_SUPPLIER(new GoToEditSupplierCommand()),
    GO_TO_EDIT_SWEETS(new GoToEditSweetsCommand());

    private final Command command;

    CommandInvoker(Command command) {
        this.command = command;
    }

    public static Command define(String command) {
        CommandInvoker commandType = CommandInvoker.valueOf(command.toUpperCase());
        return commandType.command;
    }
}
