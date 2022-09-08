import java.util.ArrayList;
import java.util.HashMap;

public class Hotel {

    private ArrayList<Bedroom> bedrooms;
    private ArrayList<ConferenceRoom> conferenceRooms;
    private HashMap<String, DiningRoom> diningHall;

    public Hotel() {
        this.bedrooms = new ArrayList<>();
        this.conferenceRooms = new ArrayList<>();
        this.diningHall = new HashMap<>();
    }

    public void addBedroom(Bedroom bedroom){
        this.bedrooms.add(bedroom);
    }

    public void addConferenceRoom(ConferenceRoom conferenceRoom){
        this.conferenceRooms.add(conferenceRoom);
    }

    public void checkGuestIn(Guest guest){
        for (int i = 0; i < this.bedrooms.size(); i++){
            if(this.bedrooms.get(i).isRoomFree()){
                this.bedrooms.get(i).addGuest(guest);
                break;
            }
        }
    }

    public int howManyEmptyRooms(){
        int emptyRooms = 0;
        for(int i = 0; i < this.bedrooms.size(); i++){
            if (!this.bedrooms.get(i).isRoomFree()){
                emptyRooms++;
            }
        }
        return emptyRooms;
    }

    public void checkGuestOut(Guest guest){
        this.bedrooms.get(0).removeGuest(guest);
    }

    public int howManyRooms() {
        return this.bedrooms.size();
    }

    public int howManyGuest() {
        int guestNumber = 0;
        for (int i = 0; i < this.bedrooms.size(); i++){
             guestNumber += this.bedrooms.get(1).guests.size();
        }
        return guestNumber;
    }

    public Booking bookRoom(Bedroom bedroom, int numberOfNights){
        Booking booking = new Booking(numberOfNights, bedroom);
        return booking;
    }

    public int howManyDiningRooms() {
        return this.diningHall.size();
    }

    public void addDiningRoom(DiningRoom diningRoom) {
        this.diningHall.put(diningRoom.getName(), diningRoom);
    }

    public int anyOneIn(Bedroom bedroom) {
        int index = this.bedrooms.indexOf(bedroom);
        return this.bedrooms.get(index).guests.size();
    }

    public void bookAStayForGuest(Guest guest, int numberOfNights, Bedroom bedroom){
        Booking booking = bookRoom(bedroom, numberOfNights);
        if (booking.canGuestAffordToStay(guest)){
            checkGuestIn(guest);
        }
    }
}
