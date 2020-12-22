package model.game_running;

import model.game_building.GameConstants;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

public class GameCommandListener implements KeyListener {
    private boolean canShoot = true;
    private final int DEFAULT_SHOOTER_DELAY = 1000;
    Timer timer = new Timer();
    private RunningMode runningMode;

    public GameCommandListener(RunningMode runningMode) {
        this.runningMode = runningMode;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_P:
                runningMode.setRunningState(GameConstants.GAME_STATE_PAUSED);
                break;
            case KeyEvent.VK_R:
                runningMode.setRunningState(GameConstants.GAME_STATE_RESUMED);
                break;
            case KeyEvent.VK_B:
                runningMode.setRunningState(GameConstants.GAME_STATE_PAUSED);
                runningMode.getBlender().showBlender();
                break;
            case KeyEvent.VK_C:
//                switchAtom
                break;
            case KeyEvent.VK_UP:
                if(canShoot) { // TODO: Change implementation later.
                    runningMode.shootProjectile();
                    canShoot = false;
                    timer.schedule(new TimerTask() { // Creates a TimerTask object that will make canShoot true after a specified time (DEFAULT_SHOOTER_DELAY)
                        @Override
                        public void run() {
                            canShoot = true;
                        }
                    }, DEFAULT_SHOOTER_DELAY);
                }
                break;
            case KeyEvent.VK_LEFT:
                runningMode.moveShooter(GameConstants.SHOOTER_MOVEMENT_LEFT);
                break;
            case KeyEvent.VK_RIGHT:
                runningMode.moveShooter(GameConstants.SHOOTER_MOVEMENT_RIGHT);
                break;
            }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_RIGHT:
                runningMode.moveShooter(GameConstants.SHOOTER_MOVEMENT_STILL);
                break;
        }
        switch (e.getKeyCode()){
            case KeyEvent.VK_D:
                runningMode.rotateShooter(GameConstants.SHOOTER_ROTATION_RIGHT);
                break;
            case KeyEvent.VK_A:
                runningMode.rotateShooter(GameConstants.SHOOTER_ROTATION_LEFT);
                break;
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
