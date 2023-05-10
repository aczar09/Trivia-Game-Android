package edu.vassar.cmpu203.triviagame.persistence;

import android.util.Log;

import androidx.annotation.NonNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import edu.vassar.cmpu203.triviagame.model.IGameShow;
import edu.vassar.cmpu203.triviagame.model.Player;
import edu.vassar.cmpu203.triviagame.model.RandMultiChoice;

public class LocalStorageFacade implements IPersistenceFacade {

    private final File file; // the file to write to/read from
    private final File file2; // the file that player stats will be saved
    //private IGameShow database;  // a recreation of the ledger because we can only easily save
    // full ledgers, instead of individual sales

    /**
     * This is the constructor for LocalStorage
     * @param storageDir
     */
    public LocalStorageFacade(File storageDir){
        this.file = new File(storageDir, "database");
        this.file2 = new File(storageDir, "player");
        //this.database = null;
        //this.database = new RandMultiChoice();
    }

    /**
     * This will retrieve the database for our questions.
     * @param listener the observer to be notified of query result
     */
    public void retrieveDatabase(@NonNull Listener listener) {
        if (file.isFile()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                IGameShow database = (IGameShow) objectInputStream.readObject();
                listener.onDatabaseReceived(database);
            } catch (IOException e) {
                final String emsg = String.format("I/O error writing to %s", this.file);
                Log.e("TriviaTime", emsg);
                e.printStackTrace();

            } catch (ClassNotFoundException e) {
                final String emsg = String.format("Can't find class of object from %s", this.file);
                Log.e("TriviaTime", emsg);
                e.printStackTrace();

            }
        }
    }

    /**
     * This will retrieve the player stats back to MainActivity
     * @param listener
     */
        public void retrievePlayer(@NonNull Listener listener){
            if (file2.isFile()){
                try{
                    FileInputStream fileInputStream = new FileInputStream(file2);
                    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                    Player player = (Player) objectInputStream.readObject();
                    listener.onPlayerReceived(player);
                } catch(IOException e){
                    final String emsg = String.format("I/O error writing to %s", this.file2);
                    Log.e("TriviaTime", emsg);
                    e.printStackTrace();

                } catch(ClassNotFoundException e){
                    final String emsg = String.format("Can't find class of object from %s", this.file2);
                    Log.e("TriviaTime", emsg);
                    e.printStackTrace();

                }
            }
        }


    /**
     * Saves the database from mainActivity
     * @param database the question database
     */
    public void saveDatabase(IGameShow database){
        //this.database = database;
        File outfile = new File(this.file, "questionbase");
        try {
            FileOutputStream fos = new FileOutputStream(this.file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(database);

        } catch (IOException e) {
            final String emsg = String.format("I/O error writing to %s", this.file);
            Log.e("TriviaTime", emsg);
            e.printStackTrace();
        }

    }

    /**
     * Saves the player stats from mainActivity
     * @param player the player object from MA
     */
    public void savePlayer(Player player){
        File outfile = new File(this.file2, "player");
        try{
            FileOutputStream fos =  new FileOutputStream(this.file2);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(player);
        }catch (IOException e) {
            final String emsg = String.format("I/O error writing to %s", this.file2);
            Log.e("TriviaTime", emsg);
            e.printStackTrace();
        }
    }


}
