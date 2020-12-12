package model.game_space;

public class GameTimer {
    private int remainingTimeMillis;
    private final int MIN_TO_MILLS_CONVERSION_CONSTANT = 60000;

    /**
     * given a number of minutes, it converts it to milliseconds and initializes the game timer.
     *
     * @param timeInMinutes the number of minutes with which the the timer will be initialized.
     */
    public GameTimer(int timeInMinutes) {
        this.remainingTimeMillis = timeInMinutes * MIN_TO_MILLS_CONVERSION_CONSTANT;
    }

    /**
     * decreases the game timer.
     * usually decreased with the same delay given to the thready this is called from.
     *
     * @param timeInMillis the amount of time decreased in millisecond.
     */
    public void decrease(int timeInMillis) {
        remainingTimeMillis -= timeInMillis;
    }

    public String getCurrentTimer() {
        return getMinutesCounter() + " : " + getSecondsCounter();
    }

    public int getRemainingTimeMillis() {
        return this.remainingTimeMillis;
    }

    /**
     * converts the remaining time from millisecond to minutes
     *
     * @return returns the remaining minutes (floored)
     */
    private int getMinutesCounter() {
        return remainingTimeMillis / MIN_TO_MILLS_CONVERSION_CONSTANT;
    }

    /**
     * gets the number of seconds remaining in the current minute
     *
     * @return the number of seconds remaining in a minute
     */
    private int getSecondsCounter() {
        int secondsInMillis = remainingTimeMillis % MIN_TO_MILLS_CONVERSION_CONSTANT;
        return secondsInMillis / 1000;
    }
}