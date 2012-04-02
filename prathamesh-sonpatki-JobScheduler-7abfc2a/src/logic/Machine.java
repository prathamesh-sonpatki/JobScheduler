package logic;

import java.util.ArrayList;


/*
 * Gives Information about Available Machines
 */
public class Machine {

    private int machineID;
    int totalOperationCount;
    int transportTime[];
    ArrayList<Schedule> sch; //List of operations allocated on this Machine

    /**
     * 
     * @param ID set ID for the machine
     */
    Machine(int ID) {
        this.machineID = ID;
        this.totalOperationCount = 0;
    }

    /**
     *
     * @param sch
     */
    public void setSch(ArrayList<Schedule> Sch) {
        this.sch = Sch;
    }

    /**
     *
     * @param totalOperationCount
     */
    public void setTotalPossibleOperstions(int TotalPossibleOperstions) {
        this.totalOperationCount = TotalPossibleOperstions;
    }

    void clearTotalOperation() {
        this.totalOperationCount = 0;
        this.sch = null;
    }

    /**
     *
     * @return
     */
    public ArrayList<Schedule> getSch() {
        return sch;
    }
    //Allocating memory to sch

    /**
     *
     */
    public void createSch() {
        this.sch = new ArrayList<Schedule>(this.getTotalOperationCount());
    }

    public void insertOperationToSch(Chromosome c, int jobID) {
        int flag = 0;
        int i;
        //INSERT FIRST OPERATION IN SCH
        if (this.getSch().isEmpty()) {
            int finishTime = c.getGenes()[jobID].getGeneSolution()[0].getTime();
            Schedule schNewItem = new Schedule(jobID, 0, 0, finishTime);
            
            this.getSch().add(schNewItem);

        } else {

            int currentTime = c.getGenes()[jobID].getGeneSolution()[0].getTime();
            for (i = 0; i < this.getSch().size(); i++) {
                if (currentTime < (this.getSch().get(i).getEndTime() - this.getSch().get(i).getStartTime())) {
                    if (i != 0) {
                        int startTime = this.getSch().get(i - 1).getEndTime();
                        this.getSch().add(jobID, new Schedule(jobID, 0, startTime, startTime + currentTime));

                    } else {
                        
                        this.getSch().add(i, new Schedule(jobID, 0, 0, currentTime));
                       
                     }// end of if
                    this.propogateSchedules(i + 1, currentTime);
                    // System.out.println(i+"Start Time "+this.getSch().get(i).startTime + "   end " + this.getSch().get(i).endTime + " on machine "  + this.getMachineID());
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                int startTime = this.getSch().get(i - 1).getEndTime();
                this.getSch().add(new Schedule(jobID, 0, startTime, startTime + currentTime));
            }
        }

    }

    void propogateSchedules(int index, int currentTime) {
        for (int i = index; i < this.getSch().size(); i++) {
            this.getSch().get(i).setStartTime(this.getSch().get(i).getStartTime() + currentTime);
            this.getSch().get(i).setEndTime(this.getSch().get(i).getEndTime() + currentTime);
        }
    }

    /**
     *
     * @param machineID
     */
    public void setMachineID(int MachineID) {
        this.machineID = MachineID;
    }

    /**
     *
     */
    public void setTotalPossibleOperstions() {
        this.totalOperationCount++;
    }

    /**
     *
     */
    public void increaseTotalPossibleOperstionCount() {
        this.totalOperationCount++;
    }

    /**
     *
     * @param transportTime
     */
    public void setTransportTime(int[] TransportTime) {
        this.transportTime = TransportTime;
    }

    /**
     *
     * @return
     */
    public int getMachineID() {
        return machineID;
    }

    /**
     *
     * @return
     */
    public int getTotalOperationCount() {
        return totalOperationCount;
    }

    /**
     *
     * @return
     */
    public int[] getTransportTime() {
        return transportTime;
    }
    //Compare two schedules w.r.t to processing time

    void compareSch(Chromosome c, int jobID) {
    }
}
