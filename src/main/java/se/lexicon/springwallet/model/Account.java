package se.lexicon.springwallet.model;

import lombok.*;
import se.lexicon.springwallet.exeptions.InsufficientFoundsException;

@Getter
@Setter
@EqualsAndHashCode(exclude = "balance")
@ToString(includeFieldNames = false)
@AllArgsConstructor
@NoArgsConstructor

@Data
public class Account {
    private Long id;
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }


    public void withdraw(double amount) throws InsufficientFoundsException {
        if (amount <= 0) throw new IllegalArgumentException("Amount is not valid");
        if (amount > balance) throw new InsufficientFoundsException(amount, "Balance is insufficient");
        this.balance -= amount;
    }

    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Amount is not valid");
        this.balance += amount;
    }
}
