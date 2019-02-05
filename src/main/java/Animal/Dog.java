package Animal;

import java.util.Calendar;
import java.util.Date;

public class Dog extends Animal {

    private Date lastWalk;

    public Date getLastWalk() {
        return this.lastWalk;
    }

    public Dog(String name, Gender gender, Date lastWalk)
    {
        super(name, gender);
        Calendar.getInstance().getTime();
        this.lastWalk = lastWalk;
    }

    public boolean needsWalk()
    {
        if(Calendar.getInstance().getTimeInMillis() - this.lastWalk.getTime() > 86400000){
            return true;
        }else {
            return false;
        }
    }

    public String toString()
    {
        return super.toString() + String.format(", last walk: %s", this.lastWalk.toString());
    }
}
