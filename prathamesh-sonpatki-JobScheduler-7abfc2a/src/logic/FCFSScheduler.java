package logic;

import java.util.Set;

/*
 * FCFS Scheduler ; This applies FCFS strategy to allocate machines ;
 */
/**
 *
 * @author chaitanya
 */
public class FCFSScheduler  extends MachineController implements Scheduler {
Set<Schedule> scheduleSet;

    public Set<Schedule> getScheduleSet() {
        return scheduleSet;
    }
    void generateSchedule(MachineController mc ,Chromosome chromosome)
    {
        //Assign Machines to 0'th Operation of each job

        assignMachinesToZerothOp(mc,chromosome);
        // Rest code goes Here !
//        scheduleSet = new Set<Schedule>() {};

       // isNextOp?
    }

    public void setScheduleSet(Set<Schedule> scheduleSet) {
        this.scheduleSet = scheduleSet;
    }

    void assignMachinesToZerothOp(MachineController mc , Chromosome chromosome)

    {
        for(int i = 0; i < chromosome.getGeneCount(); i++ )
            {
                    allocateMachines(mc.getMachine(chromosome.getGenes()[i].getGeneSolution()[0].MachineID),chromosome,i);
            }
    }

    void allocateMachines(Machine m , Chromosome c , int jobID)
    {
        if(m.getSch() == null)
        {
            
            //Allocate memory to Sch
            //Size  = m.getTotalPossibleOperations()
            m.createSch();
        }
        m.insertOperationToSch(m, c, jobID);
    
    }

    void print(Machine m)
    {
         if(m.getSch()!=null)
         {
            for(int i =0;i<m.getSch().size();i++)
            {
           
            System.out.print("On Machine : "+m.getMachineID()+" : ");
            m.getSch().get(i).print();
            
             
            }
        }
        else
            System.out.println("No Operations are allocated on Machine "+m.getMachineID());

    }
}
