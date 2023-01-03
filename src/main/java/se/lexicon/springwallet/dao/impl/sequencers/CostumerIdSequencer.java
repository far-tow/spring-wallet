package se.lexicon.springwallet.dao.impl.sequencers;

public class CostumerIdSequencer {
    private static long sequencer = 0;

    public static long nextId() {
        return ++sequencer;
    }
}
