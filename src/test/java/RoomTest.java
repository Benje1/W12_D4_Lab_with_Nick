import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoomTest {

    Bedroom room;
    ConferenceRoom conferenceRoom;

    @Before
    public void before() {
        room = new Bedroom(RoomType.DOUBLE, 101, 60.00);
        conferenceRoom = new ConferenceRoom(RoomType.CONFERENCE, "CodeClan Conference");
    }

    @Test
    public void roomHasType() {
        assertEquals(RoomType.DOUBLE, room.getRoomType());
    }

    @Test
    public void conferenceRoomHasType() {
        assertEquals(RoomType.CONFERENCE, conferenceRoom.getRoomType());
    }

    @Test
    public void checkRoomHasNumber() {
        assertEquals(101, room.getRoomNumber());
    }

    @Test
    public void checkConferenceRoomHasName(){
        assertEquals("CodeClan Conference", conferenceRoom.getName());
    }

    @Test
    public void checkRoomHasRate(){
        assertEquals(60.00, room.getNightlyRate(), 0.0);
    }

    @Test
    public void roomHasSize(){
        assertEquals(3500.00, Bedroom.getSize(), 0.0);
    }
}
