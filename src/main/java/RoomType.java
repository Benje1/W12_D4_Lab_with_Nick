public enum RoomType {

    SINGLE(1),
    DOUBLE(2),
    TRIPLE(3),
    FAMILY(4),
    CONFERENCE(10),
    DININGROOM(20);

    protected final int capacity;

    RoomType(int capacity) {
        this.capacity = capacity;
    }
}
