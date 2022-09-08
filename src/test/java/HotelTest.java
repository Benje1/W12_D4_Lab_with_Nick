import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class HotelTest {

    Hotel hotel;
    Guest guest;
    Guest guest2;
    Bedroom bedroom;
    Bedroom bedroom2;
    ConferenceRoom conferenceRoom;
    DiningRoom diningRoom;
    DiningRoom diningRoom2;

    @Before
    public void setUp() throws Exception {
        guest = new Guest("Bob", 800.00);
        guest2 = new Guest("Bobie", 400.00);
        bedroom = new Bedroom(RoomType.DOUBLE, 73, 60.00);
        bedroom2 = new Bedroom(RoomType.DOUBLE, 74, 60.00);
        conferenceRoom = new ConferenceRoom(RoomType.CONFERENCE, "Conference");
        diningRoom = new DiningRoom(RoomType.DININGROOM, "FoodHall");
        diningRoom2 = new DiningRoom(RoomType.DININGROOM, "HallFood");
        hotel = new Hotel();

    }

    @Test
    public void addRoomToHotel(){
        hotel.addBedroom(bedroom);
        assertEquals(1, hotel.howManyRooms());
    }

    @Test
    public void addGuestToRoom(){
        hotel.addBedroom(bedroom);
        hotel.checkGuestIn(guest);
        assertEquals(1, hotel.howManyGuest());
    }

    @Test
    public void removeGuestToRoom(){
        hotel.addBedroom(bedroom);
        hotel.checkGuestIn(guest);
        hotel.checkGuestOut(guest);
        assertEquals(0, hotel.howManyGuest());
    }

    @Test
    public void canMakeABooking(){
        assertEquals(5, hotel.bookRoom(bedroom, 5).getNumberOfNights());
    }

    @Test
    public void canReturnBedroomFromBooking(){
        assertEquals(bedroom, hotel.bookRoom(bedroom, 5).getBedroom());
    }

    @Test
    public void canGetTotalStayCost(){
        assertEquals(300.00, hotel.bookRoom(bedroom, 5).getStayCost(), 0.0);
    }

    @Test
    public void addDiningRoomToHotel(){
        hotel.addDiningRoom(diningRoom);
        assertEquals(1, hotel.howManyDiningRooms());
    }

    @Test
    public void willItSkipBookedRooms(){
        hotel.addBedroom(bedroom);
        hotel.addBedroom(bedroom2);
        hotel.checkGuestIn(guest);
        hotel.checkGuestIn(guest2);
        assertEquals(1, hotel.anyOneIn(bedroom2));
    }

    @Test
    public void howManyEmptyRooms(){
        hotel.addBedroom(bedroom);
        hotel.addBedroom(bedroom2);
        hotel.checkGuestIn(guest);
        assertEquals(1, hotel.howManyEmptyRooms());
    }

    @Test
    public void guestCanAfford(){
        hotel.addBedroom(bedroom);
        hotel.bookAStayForGuest(guest, 4, bedroom);
        assertEquals(1, hotel.anyOneIn(bedroom));

    }






}
