package Animal;

import Webshop.Sellable;

import java.util.Date;

public abstract class Animal extends Sellable {
    private Gender gender;
    private Reservor reservedBy;

    public String getName() {
        return this.name;
    }

    public Gender getGender() {
        return this.gender;
    }

    public Reservor getReservedBy() {
        return this.reservedBy;
    }

    public Animal(String name, Gender gender) {
        super(name);
        this.gender = gender;
    }

    public boolean reserve(String reservedBy) {

        if(this.reservedBy == null) {
            this.reservedBy = new Reservor(reservedBy, new Date());
            return true;
        } else {
            return false;
        }
    }


    public String toString() {
        String reserved = "not reserved";
        if (this.reservedBy != null)
        {
            reserved = String.format("reserved by %s", this.reservedBy.name);
        }
        return String.format("%s, %s, %s", this.name, this.gender, reserved);
    }
}
