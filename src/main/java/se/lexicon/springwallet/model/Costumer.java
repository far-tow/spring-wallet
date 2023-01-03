package se.lexicon.springwallet.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Costumer {
    private Long id;
    private String firstName;
    private String lastName;
    private Account account;

    public Costumer(Long id, String firstName, String lastName, Account account) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.account = account;
    }

    public Costumer(String firstName, String lastName, Account account) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.account = account;
    }
}
