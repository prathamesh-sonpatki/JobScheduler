package logic;

//~--- JDK imports ------------------------------------------------------------

import java.util.Scanner;

/*
* Job Class :: Describe details of each job
 */

/**
 *
 * @author prathamesh
 */
public class Job {
    int JobID;

    // DataMembers of Job Class
    int       TotalOperations;
    Operation operations[];

    // Constructor
    Job() {
        TotalOperations = 0;
        operations      = null;
    }

    // Getters and Setters

    /**
     *
     * @return
     */
    public int getJobID() {
        return JobID;
    }

    /**
     *
     * @param JobID
     */
    public void setJobID(int JobID) {
        this.JobID = JobID;
    }

    /**
     *
     * @return
     */
    public int getTotalOperations() {
        return TotalOperations;
    }

    /**
     *
     * @return
     */
    public Operation[] getOperations() {
        return operations;
    }

    /**
     *
     * @param TotalOperations
     */
    public void setTotalOperations(int TotalOperations) {
        this.TotalOperations = TotalOperations;
    }

    // Take Details of each operation

    /**
     *
     * @param s
     * @return
     */
    public Scanner GetOperation(Scanner s) {
        this.operations = new Operation[this.getTotalOperations()];

        for (int j = 0; j < this.getTotalOperations(); j++) {
            operations[j] = new Operation();
            operations[j].setOperationID(j);

            // Set Number of Alternatives for Each Operation
            operations[j].setAlternatives(s.nextInt());

            // Set Possible Solutions for each Operation
            operations[j].setAlternativeSolution(s);
        }

        return s;
    }

    // Print Job Details

    /**
     *
     */
    public void printJobDetails() {
        System.out.println("Job " + JobID + " has " + TotalOperations + " Operations as follows:");

        for (int i = 0; i < TotalOperations; i++) {
            System.out.println("Operation " + i + " has Alternative Solutions as Follows:");
            operations[i].printOperationDetails();
        }
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
