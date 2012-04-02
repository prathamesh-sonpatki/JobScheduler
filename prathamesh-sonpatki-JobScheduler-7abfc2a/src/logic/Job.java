package logic;

//~--- JDK imports ------------------------------------------------------------
import java.util.Scanner;

/**
 * Stores the details of each job which contains multiple operations
 * along with the available machines and corresponding time
 * @author prathamesh
 */
public class Job {

    int jobID;
    int totalOperationCount;

    Operation operations[];

    /**
     * set datamember values
     */
    Job() {
        totalOperationCount = 0;
        operations = null;
    }

    /**
     * @return job ID of the Job object
     */
    public int getJobID() {
        return jobID;
    }

    /**
     * set jobID of the Job object
     * @param jobID
     */
    public void setJobID(int JobID) {
        this.jobID = JobID;
    }

    /**
     *
     * @return totaloperations of Job object
     */
    public int getTotalOperationCount() {
        return totalOperationCount;
    }

    /**
     *
     * @return the array of operation present in job
     */
    public Operation[] getOperations() {
        return operations;
    }

    /**
     *
     * @param set totalOperationCount of Job object
     */
    public void setTotalOperationCount(int TotalOperations) {
        this.totalOperationCount = TotalOperations;
    }

    /**
     * creates the Operation objects for current job
     * @param s for accessing the data from file "input.txt"
     * @return scanner object s
     */
    public Scanner setOperations(Scanner s) {
        this.operations = new Operation[this.getTotalOperationCount()];

        for (int j = 0; j < this.getTotalOperationCount(); j++){
            operations[j] = new Operation();

            /*
             * set the operation ID of the operation j
             */
            operations[j].setOperationID(j);

            /**
             *  Set Number of Alternatives for Each Operation
             */
            operations[j].setAlternativeCount(s.nextInt());

            /**
             *  Set Possible Solutions for each Operation
             */
            operations[j].setAlternativeSolution(s);
        }

        return s;
    }

    /**
     * print the job datails
     */
    public void printJobDetails() {
        System.out.println("Job " + jobID + " has " + totalOperationCount + " Operations as follows:");

        for (int i = 0; i < totalOperationCount; i++) {
            System.out.println("Operation " + i + " has Alternative Solutions as Follows:");
            operations[i].printOperationDetails();
        }
    }
}

//~ Formatted by Jindent --- http://www.jindent.com

