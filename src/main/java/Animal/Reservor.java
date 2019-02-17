package Animal;

import java.util.Date;

public class Reservor {
    public String name;
    public Date ReservedAt;

    public Reservor(String name, Date date) {
        this.name = name;
        this.ReservedAt = date;
    }
}
