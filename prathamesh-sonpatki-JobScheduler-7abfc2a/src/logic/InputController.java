package logic;

//~--- JDK imports ------------------------------------------------------------
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class is used for getting input in proper format from user.
 * @author chaitanya
 */
public class InputController {

    private int totalJobCount;
    public Job[] jobs;

    /**
     * @return the array of Job object
     */
    public Job[] getJobs() {
        return jobs;
    }

    /**
     * Get the data from the file "input.txt" about
     * the total jobs and the available machines and corresponding time
     * and create the Job object
     * @throws FileNotFoundException
     */
    public void getInput() throws FileNotFoundException {

        File inputFile = new File("input.txt");
        Scanner inputScanner = new Scanner(inputFile);

        totalJobCount = inputScanner.nextInt();
        jobs = new Job[totalJobCount];

        /**
         *  For each jobs Get Operation Details
         */
        for (int i = 0; i < totalJobCount; i++) {
            jobs[i] = new Job();

            /**
             * Set Job ID
             */
            jobs[i].setJobID(i);

            /**
             * Number of Operations in a Job
             */
            jobs[i].setTotalOperationCount(6);//TO DO operation in each jobs may be different
            //TODO static value = 6

            /*
             * Get details of each jobs
             */
            inputScanner = jobs[i].setOperations(inputScanner);

        }
    }
}
//~ Formatted by Jindent --- http://www.jindent.com

