package facadeHome;

public class SmartHomeApp {
    public static void main(String[] args) {
        SecuritySystem mySecurity = new HomeSecuritySystem();
        SmartHomeFacade myHome = new SmartHomeFacade(
            new LivingRoomLights(), new CentralHeating(), mySecurity);
        
        myHome.arriveHome();
        myHome.leaveHome();

        mySecurity.readLog();
    }
}
