package edu.vassar.cmpu203.triviagame.persistence;

import androidx.annotation.NonNull;

import edu.vassar.cmpu203.triviagame.model.IGameShow;

/**
 * Interace that specifies a contract that all persistence solutions must fulfill.
 */
public interface IPersistenceFacade {

    /**
     * Interface that classes interested in being notified of data-generating events
     * from the persistence layer should implement.
     */
    interface Listener{
        void onDatabaseReceived(@NonNull IGameShow database);
    }
    /**
     * Issues a ledger retrieval operation.
     * @param listener the observer to be notified of query result
     */
    void retrieveDatabase(@NonNull Listener listener);
    void saveDatabase(IGameShow database);
}
