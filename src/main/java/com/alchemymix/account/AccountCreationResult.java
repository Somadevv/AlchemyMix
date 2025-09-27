package com.alchemymix.account;

import com.alchemymix.model.Account;

public class AccountCreationResult {

    public enum Status {
        SUCCESS,
        INVALID_INPUT,
        ALREADY_EXISTS,
        IO_ERROR
    }

    private final Status status;
    private final String message;
    private final Account account; // optional, only set on success

    public AccountCreationResult(Status status, String message) {
        this(status, message, null);
    }

    public AccountCreationResult(Status status, String message, Account account) {
        this.status = status;
        this.message = message;
        this.account = account;
    }

    public Status getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Account getAccount() {
        return account;
    }

    public boolean isSuccess() {
        return status == Status.SUCCESS;
    }
}
