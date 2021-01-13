package model.game_running.states;

import model.game_running.RunningMode;
import org.apache.log4j.Logger;

public class PausedState implements GameState {

    private final RunningMode runningMode;
    private static Logger logger;

    public PausedState(RunningMode runningMode) {
        this.runningMode = runningMode;
        logger = Logger.getLogger(this.getClass().getName());
    }


    @Override
    public void showSavedSessions() {
        runningMode.getSessionLoadListener().getSavedSessions();
    }

    @Override
    public void saveGameSession() {
        runningMode.saveGameSession();
    }
}
