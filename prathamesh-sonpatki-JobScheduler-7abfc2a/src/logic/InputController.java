package logic;

//~--- JDK imports ------------------------------------------------------------

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

/*
* This class is used for getting input in proper format from user.
*
 */

/**
 *
 * @author chaitanya
 */
public class InputController {
    private int TotalJobs;

    /**
     *
     */
    public Job[] job;

    /**
     *
     * @return
     */
    public Job[] getJob() {
        return job;
    }

//  Get the number of jobs from user

    /**
     *
     * @throws FileNotFoundException
     */
    public void GetInput() throws FileNotFoundException {
        File    inputFile    = new File("input.txt");
        Scanner inputScanner = new Scanner(inputFile);

        TotalJobs = inputScanner.nextInt();
        job       = new Job[TotalJobs];

        // For each job Get Operation Details
        for (int i = 0; i < TotalJobs; i++) {
            job[i] = new Job();

            // Set Job ID
            job[i].setJobID(i);

            // Number of Operations in a Job
            job[i].setTotalOperations(6);

            // Get details of each job
            inputScanner = job[i].GetOperation(inputScanner);

            // job.printJobDetails();
        }
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
