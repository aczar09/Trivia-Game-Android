package edu.vassar.cmpu203.triviagame.view;

import android.view.View;

import androidx.annotation.NonNull;

public interface IGameConfig {

    /**
     * Interface that classes interested in being notified of events happening
     * to the view should implement.
     */
    interface Listener {
        /**
         * Called when an item is to be added onto the sale.
         *
         * @param name name of product to add
         * @param qty number of units to add
         @param view the view where the event originated
         */
        void onWWM(); // call when user requests Who Wants to be a Millionaire?

        /**
         * Called when the user is done adding items.
         */
        void onRandom(); // call when user requests random mode

        void onMoreInfo(); // called when user asks for more info

    }


}
