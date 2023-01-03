package se.lexicon.springwallet.exeptions;

import lombok.Getter;

@Getter

public class InsufficientFoundsException extends Exception {
    private final double amount;
    public InsufficientFoundsException(double amount, String message) {
        super(message);
        this.amount=amount;
    }
}
