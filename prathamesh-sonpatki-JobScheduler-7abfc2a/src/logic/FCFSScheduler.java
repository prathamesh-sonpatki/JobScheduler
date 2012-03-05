package logic;

//~--- JDK imports ------------------------------------------------------------


import java.util.ArrayList;
import java.util.List;




/*
* FCFS Scheduler ; This applies FCFS strategy to allocate machines ;
 */

public class FCFSScheduler extends MachineController implements Scheduler {
  
    List<Schedule> scheduleSet;
    List <Integer> machineIDs;
    Schedule minOperation;
    int minOpMachineID;
    static int currentIndex;

    void generateSchedule(MachineController mc, Chromosome chromosome) {

        // Assign Machines to 0'th Operation of each job
        assignMachinesToZerothOp(mc, chromosome);

        // Rest code goes Here !
            //assign memory to scheduleSet
            this.scheduleSet = new <Schedule> ArrayList();
            this.machineIDs = new <Schedule> ArrayList();

           //Get machines
        for(int k=0;k<mc.getTotalMachines();k++)
        {
            //add 0th operation of each job to scheduleset
            for(int i=0;(mc.getMachines()[k].getSch() != null) && i<mc.getMachines()[k].getSch().size();i++)
            {
                    this.scheduleSet.add(mc.getMachines()[k].getSch().get(i));
                    this.machineIDs.add(k);
            }
        }

            //find an operation from scheduleset such that it's finish time is minimum
            
            // machine id where  minOperation is going to be executed is stored in minOpMachineID
             
            while(scheduleSet.isEmpty() != true)
            {
             
               
               this.minOperation =  findMinOperation(this.scheduleSet);
               // isNextOperation exists for minOperation
            
               if(chromosome.getGenes()[minOperation.JobID].geneLength > minOperation.OperationID +1)
               {
                   
                   //next operation exists
                   //Find previous machine where Oi,j was executed
                   int prevMachineID = chromosome.getGenes()[minOperation.JobID].getGeneSolution()[minOperation.OperationID].MachineID;
                   //Find next job id , machine id and operation id
                   int nextJobID = minOperation.JobID;
                   int nextOpID = minOperation.OperationID + 1;

                   int nextMachineID = chromosome.getGenes()[minOperation.JobID].getGeneSolution()[nextOpID].MachineID;
                   int nextProcessingTime = chromosome.getGenes()[minOperation.JobID].getGeneSolution()[nextOpID].time;
                   //get Machine where next operation will happen
                   int schLength = 1;
                   int  nextStartTime = minOperation.endTime;
                   if(mc.getMachine(nextMachineID).getSch()!=null)
                   {
                    schLength = mc.getMachine(nextMachineID).getSch().size();
                   
                   }
                  
                   int nextFinishTime = nextStartTime + nextProcessingTime;
                  // System.out.println(nextJobID+" "+nextOpID+" "+nextMachineID+" "+nextStartTime+" "+nextFinishTime);
                   //create object of schedule class for above information
                   if(mc.getMachine(nextMachineID).getSch() == null)
                         mc.getMachine(nextMachineID).createSch();
                         mc.getMachine(nextMachineID).getSch().add(new Schedule(nextJobID,nextOpID,nextStartTime,nextFinishTime));
                   //System.out.println(schLength+"  " + mc.getMachine(nextMachineID).getSch().size());
                   //check if nextMachineID has one or more operations appended before
                  
                   if(mc.getMachine(nextMachineID).getSch().size() >0 )
                   {
                        if(minOperation.endTime > nextFinishTime)
                        {
                            nextStartTime += mc.getMachine(prevMachineID).TransportTime[nextMachineID];
                            nextFinishTime = nextStartTime + nextProcessingTime;
                        }
                        else if(minOperation.endTime + mc.getMachine(prevMachineID).TransportTime[nextMachineID] > nextFinishTime )
                        {
                             nextStartTime += mc.getMachine(prevMachineID).TransportTime[nextMachineID];
                             nextFinishTime = nextStartTime + nextProcessingTime;
                        }
                        else
                        {
                            
                        }
                   }
                   else
                   {
                            nextStartTime += mc.getMachine(prevMachineID).TransportTime[nextMachineID];
                            nextFinishTime = nextStartTime + nextProcessingTime;
                   }
                   //update the current schedue with new values of starttime and finishtime
                    mc.getMachine(nextMachineID).getSch().get(mc.getMachine(nextMachineID).getSch().size() - 1).setEndTime(nextFinishTime);
                    mc.getMachine(nextMachineID).getSch().get(mc.getMachine(nextMachineID).getSch().size() - 1).setStartTime(nextStartTime);
                    //update scheduleset    with Oi.j+1
                     this.scheduleSet.get(currentIndex).setJobID(nextJobID);
                     this.scheduleSet.get(currentIndex).setOperationID(nextOpID);
                     this.scheduleSet.get(currentIndex).setStartTime(nextStartTime);
                     this.scheduleSet.get(currentIndex).setEndTime(nextFinishTime);

               }

               else
               {
                   //next operation doesnt exists
                   //delete current operation from scheduleset
                   chromosome.getGenes()[minOperation.JobID].MakeSpan = minOperation.endTime;
                
                  this.scheduleSet.remove(currentIndex);
                  
                        

               }
              
        }
               
               
               for(int i=0;i<6;i++)
               {
                  System.out.println("Job "+i+"  Total Makespan = "+chromosome.getGenes()[i].MakeSpan);
                  System.out.println("------------------------");
               }
         
           
    }


   

    void assignMachinesToZerothOp(MachineController mc, Chromosome chromosome) {
        for (int i = 0; i < chromosome.getGeneCount(); i++) {
            allocateMachines(mc.getMachine(chromosome.getGenes()[i].getGeneSolution()[0].MachineID), chromosome, i);
        }
    }

    void allocateMachines(Machine m, Chromosome c, int jobID) {
        if (m.getSch() == null) {
            m.createSch();
        }

        m.insertOperationToSch(m, c, jobID);
    }

    void print(Machine m) {
        if (m.getSch() != null) {
            for (int i = 0; i < m.getSch().size(); i++) {
                System.out.print("On Machine : " + m.getMachineID() + " : ");
                m.getSch().get(i).print();
            }
        } else {
            System.out.println("No Operations are allocated on Machine " + m.getMachineID());
        }
    }
//finds the operation with minimum finish time from scheduleset
    private Schedule findMinOperation(List<Schedule> scheduleSet) {
        int min = scheduleSet.get(0).endTime;
        int index = 0;
        this.minOpMachineID = this.machineIDs.get(0);
        for(int i = 1; i<scheduleSet.size();i++)
        {
            if(min >scheduleSet.get(i).endTime)
            {
                min = scheduleSet.get(i).endTime;
                index = i;
                this.minOpMachineID = this.machineIDs.get(i);
            }
            //select the operation with minimum start time if their finish times are same
            else if(min == scheduleSet.get(i).endTime)
            {
                if(scheduleSet.get(i).startTime < scheduleSet.get(index).startTime)
                {
                    min = scheduleSet.get(i).endTime;
                    index = i;
                     this.minOpMachineID = this.machineIDs.get(i);
                }
            }
        }
        currentIndex = index;
        return scheduleSet.get(index);
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
