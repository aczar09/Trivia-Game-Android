package edu.vassar.cmpu203.triviagame.persistence;

import androidx.annotation.NonNull;

import edu.vassar.cmpu203.triviagame.model.IGameShow;
import edu.vassar.cmpu203.triviagame.model.Player;

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

        void onPlayerReceived(@NonNull Player player);
    }
    /**
     * Issues a ledger retrieval operation.
     * @param listener the observer to be notified of query result
     */
    void retrieveDatabase(@NonNull Listener listener);
    void saveDatabase(IGameShow database);

    void savePlayer(Player player);
    void retrievePlayer(@NonNull Listener listener);
}
