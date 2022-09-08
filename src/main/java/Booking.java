import java.util.ArrayList;

public class Booking {

    private int numberOfNights;
    private Bedroom bedroom;

    public Booking(int numberOfNights, Bedroom bedroom) {
        this.numberOfNights = numberOfNights;
        this.bedroom = bedroom;
    }

    public int getNumberOfNights() {
        return this.numberOfNights;
    }

    public Bedroom getBedroom() {
        return this.bedroom;
    }

    public double getStayCost(){
        double rate = this.bedroom.getNightlyRate();
        double cost = rate * numberOfNights;
        return  cost;
    }

    public boolean canGuestAffordToStay(Guest guest){
        double guestWallet = guest.getWallet();
        if (guestWallet >= getStayCost()){
            return true;
        }else {
            return false;
        }
    }
}
