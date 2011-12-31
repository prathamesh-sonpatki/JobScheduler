/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author prathamesh
 */
public class Job {
    //DataMembers of Job Class
    int TotalOperations;
    int JobID;
    Operation operations[];
        
    //Constructor
    Job()
        {
            TotalOperations = 0;
            operations=null;
        }
    public int getJobID() {
        return JobID;
    }

    public void setJobID(int JobID) {
        this.JobID = JobID;
    }
    public int getTotalOperations() {
        return TotalOperations;
    }

    public void setTotalOperations(int TotalOperations) {
        this.TotalOperations = TotalOperations;
    }

    public Operation[] getOperations() {
        return operations;
    }

    public void setOperations(Operation[] operations) {
        this.operations = operations;
    }
    
      //Print Job Details
        public void printJobDetails()
        {
            System.out.println("Job "+JobID+" has "+TotalOperations+" Operations as follows:");
            for(int i=0;i<TotalOperations;i++)
                {
                    System.out.println("Operation "+i+" has Alternative Solutions as Follows:");
                    operations[i].printOperationDetails();                 
                     
                }
        }
}
