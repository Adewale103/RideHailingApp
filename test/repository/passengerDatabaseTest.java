package repository;

import data.model.Passenger;
import data.repository.PassengerDatabase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class passengerDatabaseTest {
  @Test
    @DisplayName("To add passenger to database")
    public void testThatPassengerCanBeAddedToDatabaseTest(){
      assertTrue(PassengerDatabase.getPassengers().isEmpty());
    Passenger passenger = new Passenger("1","Wale","Samuel","adeyinka@gmail.com"
    ,"09021876733","1234");
    PassengerDatabase.addPassengers(passenger);
    assertEquals(1,PassengerDatabase.getPassengers().size());
  }
}
