package services;

import data.model.Passenger;
import data.model.PassengerUpdateForm;
import data.repository.PassengerDatabase;
import exceptions.UserAlreadyExistException;
import exceptions.UserNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PassengerServiceTest {

    private PassengerService passengerService;
    private Passenger passenger1;
    private Passenger passenger2;
    private Passenger passenger3;

    @BeforeEach
    private void setUp(){
        passengerService = new PassengerServiceImpl();
        passenger1 = new Passenger("1","Wale","Samuel","dewale@gmail.com"
        , "09021333899","1234");
        passenger2 = new Passenger("2","Bayo","Anuoluwa","bolu@gmail.com"
                , "08102633899","1302");
        passenger3 = new Passenger("3","Olu","Bankole","kenyo@gmail.com"
                , "09045911092","8410");
    }

    @Test
    @DisplayName("add passenger test")
    public void testThatPassengerCanBeAdded(){
        passengerService.addPassenger(passenger1);
        passengerService.addPassenger(passenger2);
        passengerService.addPassenger(passenger3);
        assertFalse(PassengerDatabase.getPassengers().isEmpty());
        assertEquals(3, PassengerDatabase.getPassengers().size());
    }

    @Test
    @DisplayName("Passenger already exist test")
    public void testThatSamePassengerCannotBeAddedTwice() {
        passengerService.addPassenger(passenger1);
        passengerService.addPassenger(passenger2);
        passengerService.addPassenger(passenger3);
        assertThrows(UserAlreadyExistException.class, () -> passengerService.addPassenger(passenger1));
        assertEquals(3, PassengerDatabase.getPassengers().size());
    }
    @Test
    @DisplayName("Passenger can be found by name")
    public void passengerCanBeFoundByNameTest(){
        passengerService.addPassenger(passenger1);
        passengerService.addPassenger(passenger2);
        List<Passenger> foundPassengers = passengerService.findPassengerByName("Wale");
        assertEquals("[Passenger{passengerId='1', firstName='Wale', lastName='Samuel', " +
                "email='dewale@gmail.com', phoneNumber='09021333899', password='1234'}]",foundPassengers.toString());
    }

    @Test
    @DisplayName("Passenger can be found by PassengerrId")
    public void passengerCanBeFoundByIdTest(){
        passengerService.addPassenger(passenger1);
        passengerService.addPassenger(passenger2);
        Passenger foundPassenger = passengerService.findPassengerById("1");
        assertEquals("Passenger{passengerId='1', firstName='Wale', lastName='Samuel', " +
                "email='dewale@gmail.com', phoneNumber='09021333899', password='1234'}",foundPassenger.toString());

    }

    @Test
    @DisplayName("Update Passenger")
    public void passengerCanUpdateDetailsTest(){
        passengerService.addPassenger(passenger1);
        passengerService.addPassenger(passenger2);
        PassengerUpdateForm form = new PassengerUpdateForm("Ben","Kayode","kay@gmail.com","0810273536");
        passengerService.updatePassenger("1",form);
        assertEquals("Kayode",passenger1.getLastName());
    }

    @Test
    @DisplayName("Delete Passenger")
    public void passengerCanBeDeletedTest(){
        passengerService.addPassenger(passenger1);
        passengerService.addPassenger(passenger2);
        passengerService.deletePassenger(passenger1);
        assertThrows(UserNotFoundException.class,()->passengerService.findPassengerByName("1"));
        assertEquals(1, PassengerDatabase.getPassengers().size());
    }
}
