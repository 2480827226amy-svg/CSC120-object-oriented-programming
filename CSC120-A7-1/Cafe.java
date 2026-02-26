/* This is a stub for the Cafe class */
/**
 * This class represents a cafe shop that can sell coffee and restock things when inventory is in stock.
 */
public class Cafe extends Building implements CafeRequirements {

    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    /**
     * Constructs a cafe shop with name, address and number of floors. It has initial inventory of coffee, sugar, cream, and cups.
     * @param name the name of cafe
     * @param address the address of cafe
     * @param nFloors the number of floors in this building
     * @param nCoffeeOunces initial ounces of coffee
     * @param nSugarPackets initial number of sugar packets 
     * @param nCreams initial number of "splashes" of cream
     * @param nCups initial number of cups
     */
    public Cafe(String name,String address,int nFloors,int nCoffeeOunces,int nSugarPackets,int nCreams,int nCups) {
        super(name,address,nFloors);
        this.nCoffeeOunces=nCoffeeOunces;
        this.nSugarPackets=nSugarPackets;
        this.nCreams=nCreams;
        this.nCups=nCups;
        System.out.println("You have built a cafe: ☕");
    }
    
    /**
     * Restocks the inventory by adding certain numbers of coffee, sugar, cream, and cups.
     * @param nCoffeeOunces the number of coffee ounces we want to add
     * @param nSugarPackets the number of sugar packets we want to add
     * @param nCreams the number of cream splashes we want to add
     * @param nCups the number of cups we want to add
     */
    private void restock(int nCoffeeOunces,int nSugarPackets,int nCreams,int nCups) {
        this.nCoffeeOunces+=nCoffeeOunces;
        this.nSugarPackets+=nSugarPackets;
        this.nCreams+=nCreams;
        this.nCups+=nCups;
    }

     /**
     * Sell the coffee of given size, sugar packets and cream splashes.
     * @param size the size of the coffee we will use
     * @param nSugarPackets the number of sugar packets we will use
     * @param nCreams the number of cream splashes we will use
     */
    public void sellCoffee(int size,int nSugarPackets,int nCreams) {
        if (size<=0||nSugarPackets<=0||nCreams<=0){
            throw new RuntimeException("This order is invalid.");
        }
        if (this.nCoffeeOunces<size) {
            restock(200,0,0,0);  
        }
        if (this.nSugarPackets<nSugarPackets) {
            restock(0,200,0,0);  
        }
        if (this.nCreams<nCreams) {
            restock(0,0,200,0);  
        }
        if (this.nCups<1) {
            restock(0,0,0,200);  
        }
        this.nCoffeeOunces-=size;
        this.nSugarPackets-=nSugarPackets;
        this.nCreams-=nCreams;
        this.nCups=this.nCups-1;
    }

    // public static void main(String[] args) {
        
    // }
}
