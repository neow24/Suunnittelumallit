package facadeHome;

public class LivingRoomLights implements Lights {
    @Override
    public void turnOn() {
        System.out.println("Living room lights turned on");
    }

    @Override
    public void turnOff() {
        System.out.println("Living room lights turned off");
    }
}
