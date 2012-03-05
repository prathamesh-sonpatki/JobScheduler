package logic;

//~--- JDK imports ------------------------------------------------------------

import java.io.FileNotFoundException;


public class jobScheduler {
    static final int     TotalMachines  = 6;
    static final int[][] TransportTime  = {
        {
            0, 1, 2, 1, 2, 2
        }, {
            1, 0, 1, 2, 2, 1
        }, {
            2, 1, 0, 2, 1, 2
        }, {
            1, 2, 2, 0, 1, 1
        }, {
            2, 2, 1, 1, 0, 2
        }, {
            2, 1, 2, 1, 2, 0
        }
    };
    static final int     populationSize = 1000;
    int                  TotalJobs;

    /**
     *
     * @return
     */
    public static int getPopulationSize() {
        return populationSize;
    }

    /**
     *
     * @return
     */
    public int getTotalJobs() {
        return TotalJobs;
    }

    // private static final int NUMBER_OF_EVOLUTIONS = 5000;

    /**
     *
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {

        // Create Object of InputController Class and take input from user
        InputController inputControllerObject = new InputController();

        inputControllerObject.GetInput();

        Job job[] = inputControllerObject.getJob();

        // Generate population
        PopulationController populationController = new PopulationController();

        populationController.GetPopulationDetails(job);

        // Using new functions for ChromeMachineIntegerString and ChromeTimeIntegerString
        for (int i = 0; i < populationController.population.populationSize; i++) {
            populationController.population.chromosomes[i].ChromosomeToIntegerString();

            // populationController.population.chromosomes[i].StringToChromosome(populationController.population.chromosomes[i].ChromeMachineString,populationController.population.chromosomes[i].ChromeTimeString);
        }

        // Generate Machines
        MachineController machineController = new MachineController();

        machineController.setTotalMachines(TotalMachines);
        machineController.setMachines();

        // Set Transport Time for each machine.
        for (int i = 0; i < machineController.getTotalMachines(); i++) {
            machineController.getMachines()[i].setTransportTime(TransportTime[i]);
        }

        // Create object of FCFSScheduler class
        FCFSScheduler fcfs = new FCFSScheduler();

        // Set TotalPossibleOperations for each machine !
        for (int i = 0; i < populationController.getPopulation().getPopulationSize(); i++) {
            for (int j = 0; j < populationController.getPopulation().getChromosomes()[i].getChromosomeLength(); j++) {
                int machineID = populationController.getPopulation().getChromosomes()[i].getChromeMachineString()[j];

                machineController.getMachines()[machineID].incTotalPossibleOperstions();
            }

            // Print TotalPossibleOperations of each machine !
            int k;

            for (k = 0; k < machineController.getTotalMachines(); k++) {

                // System.out.println("On Machine "+machineController.getMachines()[k].getMachineID()+" : "+machineController.getMachines()[k].getTotalPossibleOperstions()+" Operations will be performed");
                // System.out.println(machineController.getMachines()[k].getTotalPossibleOperstions());
                // Clearing of Total Operations is required because each chromosome will have different sequence of Machines
                machineController.getMachines()[k].clearTotalOperation();
            }

            // Scheduling Code Goes Here !! :D
             System.out.println("Chromosome "+ (i+1) );
            fcfs.generateSchedule(machineController, populationController.getPopulation().getChromosomes()[i]);

            for (k = 0; k < machineController.getTotalMachines(); k++) {
            //    fcfs.print(machineController.getMachines()[k]);
            }
            
            
            for (k = 0; k < machineController.getTotalMachines(); k++) {
                machineController.getMachines()[k].clearTotalOperation();
            }

              
            // print sch of each machine
    //        System.out.println(
        //        "------------------------------------------------------------------------------------------");
        }

        // iterate till get the NE point
        // FitnessFunction fitnessFunctionObj = new FitnessFunction();
        // while(fitnessFunctionObj.findNEPoint(populationController.population) == false)
        {

            // do iterative genetic operation
        }
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
