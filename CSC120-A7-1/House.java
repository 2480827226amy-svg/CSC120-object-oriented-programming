import java.util.ArrayList;

/* This is a stub for the House class */
/**
 * This class represents a building with residents.
 */
public class House extends Building implements HouseRequirements {

    private ArrayList<Student> residents; // The <Student> tells Java what kind of data we plan to store IN the ArrayList
    private boolean hasDiningRoom;

    /**
     * Construct a house with name, address, number of floors, and whether it includes a dining room.
     * @param name the name of the house
     * @param address the address of the house
     * @param nFloors the number of floors in the building
     * @param hasDiningRoom whether the house has a dining room
     */
    public House(String name,String address,int nFloors,boolean hasDiningRoom) {
        super(name,address,nFloors);
        this.hasDiningRoom=hasDiningRoom;
        this.residents=new ArrayList<Student>();
        System.out.println("You have built a house: 🏠");
    }

    /**
     * Check whether this house has a dining room.
     * @return true if the house has a dining room, false if the house does not has a dining room
     */
    public boolean hasDiningRoom() {
        if (this.hasDiningRoom) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns the number of students live in this house.
     * @return the number of residents
     */
    public int nResidents() {
        return this.residents.size();
    }

    /**
     * Add a student to the residents in this house.
     * @param s the student that moves into the house
     * @throws RuntimeException if the student is already in the list of the residents
     */
    public void moveIn(Student s) {
        if (this.residents.contains(s)) {
            throw new RuntimeException("This student is already a resident in the house.");
        } else {
            this.residents.add(s);
        }
    }

    /**
     * Removes a student from the residents in this house.
     * @param s the student moving out of the house
     * @return the student who can move out
     * @throws RuntimeException if the student is not found from the list of the residents
     */
    public Student moveOut(Student s) {
        if (this.residents.contains(s)) {
            this.residents.remove(s);
            return s;
        } else {
            throw new RuntimeException("This student is not a resident of this house.");
        }
       
    }

    /**
     * Checks whether a student is the resident in this house.
     * @param s the student we want to check
     * @return true if the student is a resident, false if the student is not a resident
     */
    public boolean isResident(Student s) {
        if (this.residents.contains(s)) {
            return true;
        } else {
            return false;
        }
    }

    // public static void main(String[] args) {

    // }
}