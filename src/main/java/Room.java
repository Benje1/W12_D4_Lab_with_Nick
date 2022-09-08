import java.util.ArrayList;

public abstract class Room {

    protected int capacity;
    protected ArrayList<Guest> guests;
    protected RoomType roomType;


    public Room(RoomType roomType) {
        this.roomType = roomType;
        this.capacity = roomType.capacity;
        this.guests = new ArrayList<>();
    }


    public int getCapacity() {
        return capacity;
    }

    public ArrayList<Guest> getGuests() {
        return guests;
    }

    public RoomType getRoomType() {
        return this.roomType;
    }

    public void addGuest(Guest guest) {
        if (guests.size() < capacity){
        this.guests.add(guest);
        }
    }

    public boolean isRoomFree(){
        if(guests.size() > 0){
            return false;
        } else {
            return true;
        }
    }

    public void removeGuest(Guest guest) {
        this.guests.remove(guest);
    }
}
