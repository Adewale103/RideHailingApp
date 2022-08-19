package services;

import data.model.Passenger;
import data.model.PassengerUpdateForm;
import exceptions.UserAlreadyExistException;
import exceptions.UserNotFoundException;

import java.util.List;

public interface PassengerService {
    void addPassenger(Passenger passenger) throws UserAlreadyExistException;
    List<Passenger> findPassengerByName(String name) throws UserNotFoundException;
    Passenger findPassengerById(String passengerId) throws UserNotFoundException;
    void updatePassenger(String passengerId, PassengerUpdateForm passengerUpdateForm) throws UserNotFoundException;
    void deletePassenger(Passenger passenger);


}
