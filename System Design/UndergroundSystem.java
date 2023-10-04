class Passenger {
    String checkInStation;
    String checkOutStation;
    int checkInTime;
    int checkOutTime;

    public Passenger(String checkInStation, int checkInTime) {
        this.checkInStation = checkInStation;
        this.checkInTime = checkInTime;
    }

    public void checkOut(String checkOutStation, int checkOutTime) {
        this.checkOutStation = checkOutStation;
        this.checkOutTime = checkOutTime;
    }
}

class Route {
    private String startStation;
    private String endStation;
    private int totalNumberOfTrips;
    private int totalTimeSpentInTrips;

    public Route(String startStation, String endStation) {
        this.startStation = startStation;
        this.endStation = endStation;
    }

    public void addTrip(int startTime, int endTime) {
        totalNumberOfTrips++;
        totalTimeSpentInTrips += (endTime - startTime);
    }

    public double getAverageTime() {
        return (double) totalTimeSpentInTrips / totalNumberOfTrips;
    }
}

public class UndergroundSystem {
    Map<Integer, Passenger> passengerMap;
    Map<String, Route> routeMap;
    public UndergroundSystem() {
        this.passengerMap = new HashMap<>();
        this.routeMap = new HashMap<>();
    }
    public void checkIn(int id, String stationName, int t) {
        Passenger passenger = new Passenger(stationName, t);
        passengerMap.put(id, passenger);
    }

    public void checkOut(int id, String stationName, int t) {
        Passenger passenger = passengerMap.get(id);
        passenger.checkOut(stationName, t);
        String key = passenger.checkInStation + "," + passenger.checkOutStation;
        Route route = routeMap.getOrDefault(key, new Route(passenger.checkInStation, passenger.checkOutStation));
        route.addTrip(passenger.checkInTime, passenger.checkOutTime);
        routeMap.put(key, route);
    }

    public double getAverageTime(String startStation, String endStation) {
        return routeMap.get(startStation + "," + endStation).getAverageTime();
    }
}


/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
