package logic;

/*
* Schedule Class ; This class is used to represent overall Schedule of all jobs
 */

/**
 *
 * @author chaitanya
 */
public class Schedule {
    int jobID;
    int operationID;
    int endTime;
    int startTime;

    Schedule(int jID, int oID, int sTime, int eTime) {
        jobID       = jID;
        operationID = oID;
        startTime   = sTime;
        endTime     = eTime;
    }

    /**
     *
     * @return
     */
    public int getJobID() {
        return jobID;
    }

    /**
     *
     * @return
     */
    public int getOperationID() {
        return operationID;
    }

    /**
     *
     * @return
     */

    /**
     *
     * @param jobID
     */
    public void setJobID(int JobID) {
        this.jobID = JobID;
    }

    /**
     *
     * @param operationID
     */
    public void setOperationID(int OperationID) {
        this.operationID = OperationID;
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

    public void print() {
        System.out.println("Job " + jobID + " Operation " + operationID + " Start Time: " + startTime + " End Time: "
                           + endTime);
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
