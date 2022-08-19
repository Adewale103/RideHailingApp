package services;

import data.model.Passenger;
import data.model.PassengerUpdateForm;
import data.repository.PassengerDatabase;
import exceptions.UserAlreadyExistException;
import exceptions.UserNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class PassengerServiceImpl implements PassengerService{
    @Override
    public void addPassenger(Passenger passenger) throws UserAlreadyExistException {
     if(PassengerDatabase.getPassengers().containsKey(passenger.getPassengerId())){
     throw new UserAlreadyExistException("Passenger already registered");}
     PassengerDatabase.addPassengers(passenger);
    }

    @Override
    public List<Passenger> findPassengerByName(String name) throws UserNotFoundException {
        List<Passenger> foundPassengers =new ArrayList<>();
        for(Passenger passenger : PassengerDatabase.findAllPassengers()){
            if(name.equals(passenger.getFirstName())|| name.equals(passenger.getLastName())){
                foundPassengers.add(passenger);
            }
        }
        if(foundPassengers.isEmpty()){
            throw new UserNotFoundException("Passenger not found!");
        }
        return foundPassengers;
    }

    @Override
    public Passenger findPassengerById(String passengerId) throws UserNotFoundException {
        Passenger foundPassenger = PassengerDatabase.getPassengers().get(passengerId);
        if(foundPassenger == null){
            throw new UserNotFoundException("Passenger not found!");
        }
        return foundPassenger;
    }

    @Override
    public void updatePassenger(String passengerId, PassengerUpdateForm passengerUpdateForm) throws UserNotFoundException {
     Passenger passenger = PassengerDatabase.getPassengers().get(passengerId);
     if(passengerUpdateForm.firstName() != null){
     passenger.setFirstName(passengerUpdateForm.firstName());}
     if(passengerUpdateForm.lastName() != null){
         passenger.setLastName(passengerUpdateForm.lastName());
     }
     if(passengerUpdateForm.email() != null){
         passenger.setEmail(passengerUpdateForm.email());
     }
     if(passengerUpdateForm.phoneNumber() != null){
         passenger.setPhoneNumber(passengerUpdateForm.phoneNumber());
     }
     PassengerDatabase.addPassengers(passenger);
    }

    @Override
    public void deletePassenger(Passenger passenger) {
     if(PassengerDatabase.getPassengers().containsValue(passenger)){
         PassengerDatabase.deletePassenger(passenger);
     }
    }
}
