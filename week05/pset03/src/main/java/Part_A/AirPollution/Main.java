package Part_A.AirPollution;

public class Main {
    public static void main(String[] args)
    {
        AirPollutionAlert singaporeAlert = new AirPollutionAlert();
        Subscriber man = new Subscriber("man", singaporeAlert);
        Subscriber simon = new Subscriber("simon", singaporeAlert);
        singaporeAlert.setAirPollutionIndex(200);
        singaporeAlert.setAirPollutionIndex(50);
        singaporeAlert.setAirPollutionIndex(120);
        singaporeAlert.unregister(man);
        singaporeAlert.setAirPollutionIndex(300);
    }
}

