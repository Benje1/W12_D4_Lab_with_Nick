public class Bedroom extends Room{

    private int roomNumber;
    private double nightlyRate;
    private static double length = 70.00;
    private static double width = 50.00;

    public Bedroom(RoomType roomType, int roomNumber, double nightlyRate) {
        super(roomType);
        this.roomNumber = roomNumber;
        this.nightlyRate = nightlyRate;
    }

    public static double getSize(){
        double size = length * width;
        return size;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public double getNightlyRate() {
        return nightlyRate;
    }
}
