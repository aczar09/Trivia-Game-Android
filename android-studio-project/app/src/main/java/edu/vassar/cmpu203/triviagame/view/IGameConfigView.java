package edu.vassar.cmpu203.triviagame.view;

public interface IGameConfigView {

    /**
     * Interface that classes interested in being notified of events happening
     * to the view should implement.
     */
    interface Listener {

        void onWWM(); // call when user requests Who Wants to be a Millionaire?

        /**
         * Called when the user is done adding items.
         */
        void onRandom(); // call when user requests random mode

        void onMoreInfo(); // called when user asks for more info
        void onCategoriesMode();
    }


}
