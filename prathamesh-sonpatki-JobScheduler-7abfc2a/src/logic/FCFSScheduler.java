package logic;

//~--- JDK imports ------------------------------------------------------------
import java.util.ArrayList;
import java.util.List;

/*
 * FCFS Scheduler ; This applies FCFS strategy to allocate machines ;
 */
public class FCFSScheduler extends MachineController implements Scheduler {

    ArrayList<Schedule> scheduleSet;
    ArrayList<Integer> machineIDs;
    Schedule minOperation;
    int minOpMachineID;
    static int currentIndex;

    void generateSchedule(MachineController mc, Population population ,int genIndex) {

        // Assign Machines to 0'th Operation of each job
        for (int i = 0; i < population.getPopulationSize(); i++) {
            this.assignMachinesToZerothOp(mc, population.getChromosomes()[i]);
            /*
            for (int k = 0; k < mc.getTotalMachineCount(); k++) {
            for (int j = 0;  mc.getMachines()[k].sch != null && j < mc.getMachines()[k].getSch().size(); j++) {
            System.out.println("On Machine ID -> " + k + " Job ID " + mc.getMachine(k).getSch().get(j).jobID);
            System.out.println("Operation ID " + mc.getMachine(k).getSch().get(j).operationID);
            System.out.println("Start Time " + mc.getMachine(k).getSch().get(j).startTime);
            System.out.println("End Time " + mc.getMachine(k).getSch().get(j).endTime);

            }
            }
             * */

            // Rest code goes Here !
            //assign memory to scheduleSet
            this.scheduleSet = new ArrayList<Schedule>();
            this.machineIDs = new ArrayList<Integer>();

            //Get machines
            for (int k = 0; k < mc.getTotalMachineCount(); k++) {
                //add 0th operation of each job to scheduleset
                for (int j = 0; (mc.getMachines()[k].getSch() != null) && j < mc.getMachines()[k].getSch().size(); j++) {
                    this.scheduleSet.add(mc.getMachines()[k].getSch().get(j));
                    this.machineIDs.add(k);
                }
            }

            /*
            for(int k = 0 ; k< this.scheduleSet.size();k++)
            {
            System.out.println(  scheduleSet.get(k).startTime+"  " + scheduleSet.get(k).endTime);
            }
             */
            //find an operation from scheduleset such that it's finish time is minimum

            // machine id where  minOperation is going to be executed is stored in minOpMachineID

            while (scheduleSet.isEmpty() != true) {


                int minOperationIndex = findMinOperation(this.scheduleSet);
                // isNextOperation exists for minOperation

                if (population.getChromosomes()[i].getGenes()[scheduleSet.get(minOperationIndex).jobID].geneLength > scheduleSet.get(minOperationIndex).operationID + 1) {

                    //next operation exists
                    //Find previous machine where Oi,j was executed
                    int prevMachineID = population.getChromosomes()[i].getGenes()[scheduleSet.get(minOperationIndex).jobID].getGeneSolution()[scheduleSet.get(minOperationIndex).getOperationID()].getMachineID();
                    //Find next job id , machine id and operation id
                    int nextJobID = scheduleSet.get(minOperationIndex).jobID;
                    int nextOpID = scheduleSet.get(minOperationIndex).operationID + 1;

                    int nextMachineID = population.getChromosomes()[i].getGenes()[scheduleSet.get(minOperationIndex).jobID].getGeneSolution()[nextOpID].getMachineID();
                    int nextProcessingTime = population.getChromosomes()[i].getGenes()[scheduleSet.get(minOperationIndex).jobID].getGeneSolution()[nextOpID].getTime();
                    //get Machine where next operation will happen

                    int nextStartTime = scheduleSet.get(minOperationIndex).endTime;
                   

                    int nextFinishTime = nextStartTime + nextProcessingTime;
                    // System.out.println(nextJobID+" "+nextOpID+" "+nextMachineID+" "+nextStartTime+" "+nextFinishTime);
                    //create object of schedule class for above information
                    if (mc.getMachine(nextMachineID).getSch() == null) {
                        mc.getMachine(nextMachineID).createSch();
                    }
                 //  mc.getMachine(nextMachineID).getSch().add(new Schedule(nextJobID, nextOpID, nextStartTime, nextFinishTime));
                    //System.out.println(schLength+"  " + mc.getMachine(nextMachineID).getSch().size());
                    //check if nextMachineID has one or more operations appended before

                    if (mc.getMachine(nextMachineID).getSch().size() > 0) {
                        int size = mc.getMachines()[nextMachineID].getSch().size() - 1;
                        if (scheduleSet.get(minOperationIndex).endTime >mc.getMachines()[nextMachineID].getSch().get(size).endTime) {
                            nextStartTime += mc.getMachine(prevMachineID).transportTime[nextMachineID];
                            nextFinishTime = nextStartTime + nextProcessingTime;
                        } else if ( (scheduleSet.get(minOperationIndex).endTime + mc.getMachine(prevMachineID).transportTime[nextMachineID] ) > mc.getMachines()[nextMachineID].getSch().get(size).endTime) {
                            nextStartTime += mc.getMachine(prevMachineID).transportTime[nextMachineID];
                            nextFinishTime = nextStartTime + nextProcessingTime;
                        } else {
                            nextStartTime = mc.getMachines()[nextMachineID].getSch().get(size).endTime;
                            nextFinishTime = nextStartTime + nextProcessingTime;
                        }//end of inner else
                    } else {
                        nextStartTime = mc.getMachine(prevMachineID).transportTime[nextMachineID];
                        nextFinishTime = nextStartTime + nextProcessingTime;
                    } //end of outer if-else
                    //update the current schedue with new values of starttime and finishtime
                    mc.getMachine(nextMachineID).getSch().add(new Schedule(nextJobID, nextOpID, nextStartTime, nextFinishTime));
                 //   mc.getMachine(nextMachineID).getSch().get(mc.getMachine(nextMachineID).getSch().size() - 1).setStartTime(nextStartTime);
                    //update scheduleset    with Oi.j+1
                    this.scheduleSet.remove(minOperationIndex);
                    this.scheduleSet.add(new Schedule(nextJobID, nextOpID, nextStartTime, nextFinishTime));
              
                } else {
                    //next operation doesnt exists
                    //delete current operation from scheduleset
                    population.getChromosomes()[i].getGenes()[scheduleSet.get(minOperationIndex).jobID].setMakeSpan(scheduleSet.get(minOperationIndex).getEndTime());

                    this.scheduleSet.remove(minOperationIndex);
                }

            }

             /*
            for (int k = 0; k < mc.getTotalMachineCount(); k++) {
                for (int j = 0; mc.getMachines()[k].sch != null && j < mc.getMachines()[k].getSch().size(); j++) {
                    System.out.println("On Machine ID -> " + k + " Job ID " + mc.getMachine(k).getSch().get(j).jobID);
                    System.out.println("Operation ID " + mc.getMachine(k).getSch().get(j).operationID);
                    System.out.println("Start Time " + mc.getMachine(k).getSch().get(j).startTime);
                    System.out.println("End Time " + mc.getMachine(k).getSch().get(j).endTime);

                }
            }*/
           GanttChart gantt = new GanttChart();
           if(i== 0)
            gantt.drawChart(mc,genIndex);
            mc.clearMachines();
         //   System.out.println("-------------------");
        }
    }

    void assignMachinesToZerothOp(MachineController mc, Chromosome chromosome) {
        for (int i = 0; i < chromosome.getGeneCount(); i++) {
            int machineID = chromosome.getGenes()[i].getGeneSolution()[0].getMachineID();
            this.allocateMachines(mc.getMachine(machineID), chromosome, i);
        }
    }

    void allocateMachines(Machine m, Chromosome c, int jobID) {
        if (m.getSch() == null) {
            m.createSch();
        }
        m.insertOperationToSch(c, jobID);
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

    private int findMinOperation(ArrayList<Schedule> scheduleSet) {
        int min = scheduleSet.get(0).endTime;
        int index = 0;
        this.minOpMachineID = this.machineIDs.get(0);
        for (int i = 1; i < scheduleSet.size(); i++) {
            if (min > scheduleSet.get(i).endTime) {
                min = scheduleSet.get(i).endTime;
                index = i;
                this.minOpMachineID = this.machineIDs.get(i);
            } //select the operation with minimum start time if their finish times are same
            else if (min == scheduleSet.get(i).endTime) {
                if (scheduleSet.get(i).startTime < scheduleSet.get(index).startTime) {
                    min = scheduleSet.get(i).endTime;
                    index = i;
                    this.minOpMachineID = this.machineIDs.get(i);
                }
            }
        }
        currentIndex = index;
        return index;
    }
}
//~ Formatted by Jindent --- http://www.jindent.com

