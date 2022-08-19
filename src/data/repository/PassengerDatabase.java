package data.repository;

import data.model.Passenger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PassengerDatabase {
    private static Map<String, Passenger> passengers = new HashMap<>();

    public static Map<String, Passenger> getPassengers() {
        return passengers;
    }

    public static void addPassengers(Passenger passenger){
        passengers.put(passenger.getPassengerId(),passenger);
    }
    public static List<Passenger> findAllPassengers(){
        return new ArrayList<>(passengers.values());
    }
    public static void deletePassenger(Passenger passenger){
        if(passengers.containsKey(passenger.getPassengerId())){
            passengers.remove(passenger.getPassengerId(),passenger);
        }
    }
}
