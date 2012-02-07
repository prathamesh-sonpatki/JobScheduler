package logic;


import java.util.ArrayList;
import java.util.List;

/*
 * Machine Class ; Gives Information about Available Machines
 *
 */
/**
 *
 * @author chaitanya
 */
public class Machine {
    private int MachineID;//set
    int TotalPossibleOperstions;//set
    int TransportTime [] ;//set
    List<Schedule> Sch;

    

    Machine(int ID)
        {
            this.MachineID = ID;
            this.TotalPossibleOperstions = 0;
            
           
        }

    /**
     *
     * @param Sch
     */
    public void setSch(List<Schedule> Sch) {
        this.Sch = Sch;
    }

    /**
     *
     * @param TotalPossibleOperstions
     */
    public void setTotalPossibleOperstions(int TotalPossibleOperstions) {
        this.TotalPossibleOperstions = TotalPossibleOperstions;
    }
    
    void clearTotalOperation()
    {
        this.TotalPossibleOperstions = 0;
        this.Sch = null;
        
      
    }

    /**
     *
     * @return
     */
    public List<Schedule> getSch() {
        return Sch;
    }
    //Allocating memory to Sch
    /**
     *
     */
    public void createSch()
    {
        this.Sch = new <Schedule> ArrayList(this.getTotalPossibleOperstions());
    }

    public void insertOperationToSch(Machine m , Chromosome c , int jobID)
    {  int flag = 0;
       int i;
       //INSERT FIRST OPERATION IN SCH
       if(this.getSch().isEmpty() )
       {
         
           this.getSch().add(new Schedule(jobID,0,0,c.getGenes()[jobID].getGeneSolution()[0].getTime()));

       }
       else
       {
          
         for( i = 0; i< this.getSch().size();i++)
         {
             if(c.getGenes()[jobID].getGeneSolution()[0].getTime() < c.getGenes()[this.Sch.get(i).getJobID()].getGeneSolution()[0].getTime())
             {
                 if(i!=0)
                 {
                     this.getSch().add(i, new Schedule(jobID, 0, this.getSch().get(i-1).endTime,this.getSch().get(i-1).endTime+c.getGenes()[jobID].getGeneSolution()[0].getTime() ));

                 }
                else
                 {
                   this.getSch().add(i, new Schedule(jobID, 0, 0,c.getGenes()[i].getGeneSolution()[0].getTime() ));
                 }
               propogateSchedules(i+1);
               flag = 1;
               break;
             }
            else
             {
                flag = 0;
             }
          }
         if(flag == 0)
             this.getSch().add(new Schedule(jobID,0,this.getSch().get(i-1).getEndTime(),this.getSch().get(i-1).getEndTime()+c.getGenes()[jobID].getGeneSolution()[0].getTime()));
       }

    }
    void propogateSchedules(int index)
    {
        for(int i = index;i<this.getSch().size();i++)
        {
             this.getSch().get(i).setStartTime(this.getSch().get(i-1).getEndTime());
             this.getSch().get(i).setEndTime(this.getSch().get(i-1).getEndTime()+this.getSch().get(i).getStartTime());
        }
    }
    /**
     *
     * @param MachineID
     */
    public void setMachineID(int MachineID) {
        this.MachineID = MachineID;
    }

    //Add element to Sch
    void addSchedule(GeneSolution operation,int jobID , int operationID)
    {
    }
    /**
     *
     */
    public void setTotalPossibleOperstions() {
        this.TotalPossibleOperstions ++;
    }

    /**
     *
     */
    public void incTotalPossibleOperstions() {
        this.TotalPossibleOperstions ++;
    }

    /**
     *
     * @param TransportTime
     */
    public void setTransportTime(int[] TransportTime) {
        this.TransportTime = TransportTime;
    }

    

    /**
     *
     * @return
     */
    public int getMachineID() {
        return MachineID;
    }

    /**
     *
     * @return
     */
    public int getTotalPossibleOperstions() {
        return TotalPossibleOperstions;
    }

    /**
     *
     * @return
     */
    public int[] getTransportTime() {
        return TransportTime;
    }
    //Compare two schedules w.r.t to processing time
    void compareSch(Chromosome c , int jobID)
    {
       



    }
}
