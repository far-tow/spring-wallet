package se.lexicon.springwallet.dao.impl.sequencers;

public class CustomerIdSequencer {
    private static long sequencer = 0;

    public static long nextId() {
        return ++sequencer;
    }
}
