package logic;

import java.io.IOException;
import org.jscience.mathematics.number.Real;
import java.io.FileNotFoundException;

/**
 *
 * @author VIT2
 */
public class jobScheduler {

    static final int totalMachineCount = 6;
    static final int populationSize = 6;
   

    public static int getPopulationSize() {
        return populationSize;
    }

    
    /**
     * Main method
     * @param args
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

        /*
         * Create Object of InputController Class and take input from user
         * generating the jobs description along with operations corresponding to each jobs
         * which is useful for initial population generation
         */
        Real.setExactPrecision(20);
        InputController inputControllerObject = new InputController();
        inputControllerObject.getInput();

        /**
         * Generates Initial Population from the jobs description available
         */
        PopulationController populationController = new PopulationController();
        Job jobs[] = inputControllerObject.getJobs();
        populationController.setPopulationDetails(jobs);

        /**
         * Generates Machines
         */
        MachineController machineController = new MachineController();

        machineController.setTotalMachineCount(totalMachineCount);
        machineController.setMachines();
        machineController.assignOperationCount(populationController.getPopulation());
        int index = 0;
        jobScheduler js = new jobScheduler();
        js.performOperations(machineController, populationController.getPopulation(),0);
        while (index < 10) {
             System.out.println("------------");
            System.out.println("Generation " + index);
            machineController.assignOperationCount(populationController.getPopulation());
            js.performOperations(machineController, populationController.getPopulation(),index);
             
            // Clear all machines
            for (int k = 0; k < machineController.getTotalMachineCount(); k++) {

                machineController.getMachines()[k].clearTotalOperation();

            }    // end of inner for loop 2
           /* for(int j = 0; j<populationController.getPopulation().getPopulationSize();j++)
            {
                System.out.println("chromosome"+j);
                for(int m = 0; m<populationController.getPopulation().getChromosomes()[j].getGeneCount();m++)
                {
                    System.out.println("Job "+m+"Makespan = "+populationController.getPopulation().getChromosomes()[j].getGenes()[m].getMakeSpan());
                }
            }*/
            index++;
        }
    }    // end of main function

    void performOperations(MachineController machineController, Population population , int genIndex) {
         Real.setExactPrecision(20);
        FCFSScheduler fcfs = new FCFSScheduler();
        fcfs.generateSchedule(machineController, population,genIndex);
        /*
        for (int k = 0; k < machineController.getTotalMachineCount(); k++) {
                for (int j = 0;  machineController.getMachines()[k].sch != null && j < machineController.getMachines()[k].getSch().size(); j++) {
                    System.out.println("On Machine ID -> " + k + " Job ID " + machineController.getMachine(k).getSch().get(j).jobID);
                    System.out.println("Operation ID " + machineController.getMachine(k).getSch().get(j).operationID);
                    System.out.println("Start Time " + machineController.getMachine(k).getSch().get(j).startTime);
                    System.out.println("End Time " + machineController.getMachine(k).getSch().get(j).endTime);

                }
            }
        System.out.println("---------------------");
        */
         for (int index = 0; index < populationSize; index++) {
            /* Calculate the fitness value of each chromosome in Population */
            
            population.getChromosomes()[index].calculateFitnessValue();


            // Cumulative Fitness value is sum of fitness values of all chromosomes
            population.setCumulativeFitnessValue(
                    population.getCumulativeFitnessValue().plus(
                    population.getChromosomes()[index].getFitnessValue()));

        }

        // end of  for loop

        Real temp = Real.ZERO;
        /**
         * Test Pawan :

         */
        System.out.println("init_CUMF = " + temp);
        for (int i = 0; i < populationSize; i++) {
            Real fv = population.getChromosomes()[i].getFitnessValue();
            //  System.out.println("Chromosome " + i + " : " + fv);
            temp = temp.plus(fv);
        }
      System.out.println("final_CUMF = " + temp);

        Real sum = Real.ZERO;

        // Assign slots to each chromosome in Roulette wheel
        for (int i = 0; i < populationSize; i++) {
            population.getChromosomes()[i].setWeightInRouletteWheel(
                    (population.getChromosomes()[i].fitnessValue).divide(
                    population.getCumulativeFitnessValue()));
            sum = sum.plus(population.getChromosomes()[i].getWeightInRouletteWheel());
            population.getChromosomes()[i].setCumulativeRouletteWeight(sum);

        }    // end of for loop


        Population newPop = new Population();
        newPop.setPopulationSize(population.getPopulationSize());
        newPop.chromosomes = new Chromosome[newPop.getPopulationSize()];

        Selection selection = new Selection();
        for (int i = 0; i < population.getPopulationSize(); i++) {
            selection.select(i, population, newPop);


        }


        CrossOverController crossOver = new CrossOverController();

        Configuration config = new Configuration();
        crossOver.chooseChromosomes(newPop.getPopulationSize(), config);
        crossOver.performCrossOver(newPop, config);


        //copy newPop to poulation

        for (int i = 0; i < newPop.getPopulationSize(); i++) {
            population.getChromosomes()[i].setChromeMachineString(newPop.getChromosomes()[i].getChromeMachineString());
            population.getChromosomes()[i].setChromeTimeString(newPop.getChromosomes()[i].getChromeTimeString());
            population.getChromosomes()[i].integerStringToChromosome();


        }

        temp = Real.ZERO;
        System.out.println("After Crossover initial CUMF = " + temp);
        for (int i = 0; i < newPop.getPopulationSize(); i++) {
            temp = temp.plus(newPop.getChromosomes()[i].getFitnessValue());
            // System.out.println("Chromosome " + i + " : " + newPop.getChromosomes()[i].getFitnessValue());
        }
        System.out.println("After crossover finalCUMF = " + temp);

        System.out.println("------------");

    }
}    // end of class

