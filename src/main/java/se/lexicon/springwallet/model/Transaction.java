package se.lexicon.springwallet.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {
    private final String id;
    private final Costumer costumer;
    private final TransactionType type;
    private final Double amount;
    private final LocalDateTime dateTime;

    public Transaction(Costumer costumer, TransactionType type, Double amount) {
        this.id = UUID.randomUUID().toString();
        this.costumer = costumer;
        this.type = type;
        this.amount = amount;
        this.dateTime = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public Costumer getCostumer() {
        return costumer;
    }

    public TransactionType getType() {
        return type;
    }

    public Double getAmount() {
        return amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", customer=" + costumer +
                ", type=" + type +
                ", amount=" + amount +
                ", dateTime=" + dateTime +
                '}';
    }
}
