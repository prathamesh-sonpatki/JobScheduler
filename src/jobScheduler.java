/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author prathamesh
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
    public class jobScheduler{
    private static final int NUMBER_OF_EVOLUTIONS = 5000;
    private static final int POPULATION_SIZE = 5000;
    private static int TotalJobs;
        
       public static void main(String[] args) throws FileNotFoundException, IOException {
       //Get the number of jobs from user
           File fp = new File("input.txt");
           System.out.println("Enter number of jobs:");
           Scanner s = new Scanner(fp);
           TotalJobs = s.nextInt();
      //For each job Get Operation Details
           for(int i=0;i<TotalJobs;i++)
            {
               
               System.out.println("Enter Number of Operations of Job "+i);

               Job job = new Job();
               //Set Job ID
               job.setJobID(i);
               //Number of Operations in a Job
               job.setTotalOperations(s.nextInt());
               s.nextLine();
               //Get details of each  Operation
               Operation op[] = new Operation[job.getTotalOperations()];
               for(int j=0;j<job.getTotalOperations();j++)
                {
                    op[j] = new Operation();
                    op[j].setOperationID(j);
                    //Set Number of Alternatives for Each Operation
                    op[j].setAlternatives(s.nextInt());
                    
                    //Set Possible Solutions for each Operation
                    op[j].setPossSol(s);
                    
                }
               job.setOperations(op);
               job.printJobDetails();


               
            }
         
        /*Operation[] op = new Operation[6];
        
           String line = null;
        String [] array = new String[10];
        int i=0;
        BufferedReader buffer = new BufferedReader(new FileReader("input.txt"));
        for(line = buffer.readLine();line!=null;line=buffer.readLine())
            {
            array = line.split(" ");
            op[i]=new Operation();
            op[i].getOperationDetails(array);
            System.out.println("Operation "+i+" can be done in following ways:");

            op[i++].printOperationDetails();

                   
            }
       */

       }

}
