package info.hccis.wills.services;

import info.hccis.util.CisUtility;
import info.hccis.wills.services.entity.Job;
import info.hccis.wills.services.entity.Login;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Main class
 *
 * @author bjmaclean
 * @modified by AFM Mursalin for Assignment 4
 */
public class Controller {

    public static final int EXIT = 0;

    public static final String MENU = "1) Add Job" + System.lineSeparator()
            + "2) Show total of all jobs" + System.lineSeparator()
            + "3) Show all jobs" + System.lineSeparator()
            + "4) Show distinct customers" + System.lineSeparator()
            + EXIT + ") Exit"
            + System.lineSeparator();

    public static final String MESSAGE_ERROR = "Error";
    public static final String MESSAGE_EXIT = "Goodbye";
    public static final String MESSAGE_SUCCESS = "Success";
    private static double total = 0;

    //Assignment #3 collections
    private static HashSet<String> names = new HashSet();
    private static ArrayList<Job> jobs = new ArrayList();

    public static void main(String[] args) {
        
        //Assignment 4 login menu
        Login login=new Login();
        login.loadCredential();
        
        System.out.println("Please login");
        
        do{
         login.login();   
        } while (login.isValid==false);
        
        System.out.println(" ");
        
        System.out.println("Welcome " + login.userEnteredName);
        
        
        
        

        System.out.println("---------------------------------");
        System.out.println("- Welcome to " + Job.BUSINESS_NAME);
        System.out.println("---------------------------------");
        System.out.println("");

        int menuOption;

        do {
            menuOption = CisUtility.getInputInt(MENU);

            switch (menuOption) {
                case EXIT:
                    System.out.println(MESSAGE_EXIT);
                    break; //Break out of the loop as we're finished.
                case 1:
                    addJob();
                    break;
                case 2:
                    showTotal();
                    break;
                case 3:
                    showJobs();
                    break;
                case 4:
                    showDistinctCustomers();
                    break;
                default:
                    System.out.println(MESSAGE_ERROR);
                    break;
            }
        } while (menuOption != EXIT);
    }

    /**
     * Show distinct customers. (Assignment #3)
     *
     * @since 20210609
     * @author BJM
     */
    public static void showDistinctCustomers() {
        for (String current : names) {
                CisUtility.display(current);
            
        }
    }

    
    /**
     * Show jobs from the jobs array. (Assignment #1)
     *
     * @since 20210609
     * @author BJM
     */
    public static void showJobs() {
        for (Job current : jobs) {
            if (current != null) {
                current.display();
            }
        }
    }

    /**
     * Allow the user to add a new job.
     *
     * @since 20210519
     * @author BJM
     */
    public static void addJob() {
        Job job = new Job();
        job.getInformation();
        job.calculateCost();
        job.display();
        total += job.getCostTotal();

        //Assignment #1 Add to the array
        names.add(job.getCustomer().getFirstName() + " " + job.getCustomer().getLastName());
        jobs.add(job);
    }

    /**
     * show the total of all jobs
     *
     * @since 20210519
     * @author BJM
     */
    public static void showTotal() {
        System.out.println("\nTotal so far: " + CisUtility.getCurrency(total) + System.lineSeparator());
    }

}
