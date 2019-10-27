package design.concretes;

import design.patterns.Entity;
import design.patterns.Observed;

public class Clock extends Entity {
    private static Clock instance = new Clock();

    private Clock() { }

    public static Clock getInstance() {
        return instance;
    }

    public static class ClockObserved extends Observed<Integer> {

        ClockObserved() {
            state = 0;
        }

        @Override
        public <K> boolean updateState(K change) {
            if(change instanceof Integer) {
                state += (Integer)change;
                update();
                return true;
            }
            return false;
        }
    }

    public Integer getState() {return observed.getState();}

    private ClockObserved observed;

    public <K> boolean updateState(K change) {
        return observed.updateState(change);
    }
}
