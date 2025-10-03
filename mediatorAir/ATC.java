package mediatorAir;

public interface ATC {
    void registerRunway(Runway Runway);
    void requestRunway(Aircraft aircraft);
    void acknowledge(String message);
    void tick();
}
