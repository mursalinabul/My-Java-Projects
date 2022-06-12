package info.hccis.wills.services.entity;

import info.hccis.util.CisUtility;
import java.util.Scanner;

/**
 * Wills Summer Services Job.
 *
 * @author bjmaclean
 * @since 20210517
 *
 * @modified BJM 20210519 A4 selection structure changes
 * @modified BJM 20210519 A6 repetition
 */
public class Job {
    
    public static final String BUSINESS_NAME = "Will's Summer Services";
    public static final double COST_PER_SQUARE_METER = 0.016;
    public static final double COST_WASH_PER_VEHICLE = 20.0;
    
    public static final int LENGTH_MIN = 5;
    public static final int LENGTH_MAX = 100;
    public static final int LENGTH_DEFAULT = 100;
    public static final int WIDTH_MIN = 5;
    public static final int WIDTH_MAX = 50;
    public static final int WIDTH_DEFAULT = 50;
    public static final int VEHICLES_MAX = 3;
    
    private Customer customer;
    private int length;
    private int width;
    private int numberOfVehicles;
    private int area;
    private double costGrassCutting;
    private double costWashing;
    private double costTotal;

    //Constructors
    public Job() {
        customer = new Customer();
    }
    
    public Job(String name) {
        customer = new Customer(name);        
    }
    
    public Job(String name, int length, int width, int numberOfVehicles) {
        customer = new Customer(name);
        this.length = length;
        this.width = width;
        this.numberOfVehicles = numberOfVehicles;
    }
    
    public void getInformation() {

        //Obtain the required information from the user
        Scanner input = new Scanner(System.in);
        
        System.out.println("\nPlease enter job information\n");
        
        //Get the customer information.
        customer.getInformation();
        
        System.out.println("What is the length of the lawn(meters)?");
        length = input.nextInt();
        input.nextLine();  //burn

        while (length < LENGTH_MIN || length > LENGTH_MAX) {
            System.out.println("Invalid length entered, please try again");
            System.out.println("What is the length of the lawn(meters)?");
            length = input.nextInt();
            input.nextLine();  //burn
        }
        
        System.out.println("What is the width of the lawn(meters)?");
        width = input.nextInt();
        input.nextLine();  //burn

        while (width < WIDTH_MIN || width > WIDTH_MAX) {
            System.out.println("Invalid width entered, please try again");
            System.out.println("What is the width of the lawn(meters)?");
            width = input.nextInt();
            input.nextLine();  //burn
        }
        
        System.out.println("How many vehicles to wash?");
        numberOfVehicles = input.nextInt();
        input.nextLine();  //burn

        while (numberOfVehicles > VEHICLES_MAX) {
            System.out.println("Invalid number of vehicles entered, please try again");
            System.out.println("How many vehicles to wash?");
            numberOfVehicles = input.nextInt();
            input.nextLine();  //burn
        }
    }

    /**
     * Calculate the overall cost. Also set the related cost attributes.
     *
     * @since 20210517
     * @author BJM
     *
     * @modified BJM 20210519 Selection structures added
     */
    public double calculateCost() {
        
        double discount = customer.getDisountRate();

        //Calculations 
        area = length * width;
        costGrassCutting = COST_PER_SQUARE_METER * area * (1 - discount);
        costWashing = numberOfVehicles * COST_WASH_PER_VEHICLE * (1 - discount);
        costTotal = costGrassCutting + costWashing;
        return costTotal;
        
    }

    public Customer getCustomer() {
        return customer;
    }
    
    public int getLength() {
        return length;
    }
    
    public void setLength(int length) {
        this.length = length;
    }
    
    public int getWidth() {
        return width;
    }
    
    public void setWidth(int width) {
        this.width = width;
    }
    
    public int getNumberOfVehicles() {
        return numberOfVehicles;
    }
    
    public void setNumberOfVehicles(int numberOfVehicles) {
        this.numberOfVehicles = numberOfVehicles;
    }
    
    public int getArea() {
        return area;
    }
    
    public void setArea(int area) {
        this.area = area;
    }
    
    public double getCostGrassCutting() {
        return costGrassCutting;
    }
    
    public void setCostGrassCutting(double costGrassCutting) {
        this.costGrassCutting = costGrassCutting;
    }
    
    public double getCostWashing() {
        return costWashing;
    }
    
    public void setCostWashing(double costWashing) {
        this.costWashing = costWashing;
    }
    
    public double getCostTotal() {
        return costTotal;
    }
    
    public void setCostTotal(double costTotal) {
        this.costTotal = costTotal;
    }
    
    public void display() {
        //Show summary
        System.out.println(this.toString());
    }
    
    public String toString() {
        String output = "---------------------------------" + System.lineSeparator()
                + "- Summary "+System.lineSeparator()
                + "- "+customer.toString()+System.lineSeparator()
                + "- Size of lawn: " + area + " square meters" + System.lineSeparator()
                + "- Cost for grass cutting: " + CisUtility.getCurrency(costGrassCutting) + System.lineSeparator()
                + "- Vehicles to wash: " + numberOfVehicles + System.lineSeparator()
                + "- Cost for washing: " + CisUtility.getCurrency(costWashing) + System.lineSeparator()
                + "- Total cost: " + CisUtility.getCurrency(costTotal) + System.lineSeparator()
                + "---------------------------------" + System.lineSeparator() + System.lineSeparator();
        return output;
    }
    
}
