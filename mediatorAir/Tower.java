package mediatorAir;

import java.util.ArrayList;

public class Tower implements ATC {
    private java.util.List<Runway> runways;

    public Tower() {
        this.runways = new ArrayList<>();
    }

    public void registerRunway(Runway runway) {
        runways.add(runway);
    }

    public void requestRunway(Aircraft aircraft) {
        System.out.println("Runway request from " + aircraft);
        Runway runway = selectRunway();
        if (runway.addAircraft(aircraft)) {
            if (aircraft.getIntention() == Intention.LANDING)
                aircraft.clearForLanding(runway);
            else if (aircraft.getIntention() == Intention.TAKEOFF)
                aircraft.clearForTakeoff(runway);
        } else {
            aircraft.holdPosition(runway);
        }
    }

    public Runway selectRunway() {
        for (Runway runway : runways)
            if (runway.isVacant())
                return runway;
        
        Runway selectedRunway = runways.get(0);
        for (Runway runway : runways)
            if (runway.getQueueSize() < selectedRunway.getQueueSize())
                selectedRunway = runway;

        return selectedRunway;
    }

    public void acknowledge(String msg) {
        System.out.println("Tower received acknowledge message: " + msg);
    } 

    public void tick() {
        for (Runway runway : runways)
            if (runway.decreaseOccupiedTime()) {
                Aircraft aircraft = runway.getWaitingAircraft();
                if (aircraft != null) {
                    runway.addAircraft(aircraft);
                    if (aircraft.getIntention() == Intention.LANDING)
                        aircraft.clearForLanding(runway);
                    else
                        aircraft.clearForTakeoff(runway);
                }
            }
    }
}
