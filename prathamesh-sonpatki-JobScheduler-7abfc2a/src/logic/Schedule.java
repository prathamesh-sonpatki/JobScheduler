package logic;

/*
 * Schedule Class ; This class is used to represent overall Schedule of all jobs
 */
/**
 *
 * @author chaitanya
 */
public class Schedule {

    int JobID;
    int OperationID;
    int startTime;
    int endTime;
    Schedule(int jID, int oID , int sTime , int eTime)
    {
     JobID = jID;
     OperationID = oID;
     startTime = sTime;
     endTime = eTime;
    }
    /**
     *
     * @return
     */
    public int getJobID() {
        return JobID;
    }

    /**
     *
     * @return
     */
    public int getOperationID() {
        return OperationID;
    }

    /**
     *
     * @return
     */
   

    /**
     *
     * @param JobID
     */
    public void setJobID(int JobID) {
        this.JobID = JobID;
    }

    /**
     *
     * @param OperationID
     */
    public void setOperationID(int OperationID) {
        this.OperationID = OperationID;
    }

    public int getEndTime() {
        return endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public void print()
    {
        System.out.println("Job "+JobID+" Operation "+OperationID+" Start Time: "+startTime+" End Time: "+endTime);
    }
}
