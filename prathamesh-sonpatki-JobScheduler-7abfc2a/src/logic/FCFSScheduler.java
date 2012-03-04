package logic;

//~--- JDK imports ------------------------------------------------------------

import com.sun.org.apache.xml.internal.serializer.utils.SystemIDResolver;
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
               this.minOperation =  findMinOperation(this.scheduleSet);
            // machine id where  minOperation is going to be executed is stored in minOpMachineID
            //while(this.scheduleSet.isEmpty())
            //{
               // isNextOperation exists for minOperation
            
               if(chromosome.getGenes()[minOperation.JobID].geneLength > minOperation.OperationID)
               {
                   //next operation exists
               }
               else
               {
                   //next operation doesnt exists
                   //delete current operation from scheduleset
                   this.scheduleSet.remove(minOperation);
               }
        //}
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
        return scheduleSet.get(index);
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
