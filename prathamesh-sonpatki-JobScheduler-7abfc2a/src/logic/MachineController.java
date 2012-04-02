package logic;

/**
 * This class will create required Machines for operations
 * @author chaitanya
 */
public class MachineController {

    static final int[][] transportTime = {
        {0, 1, 2, 1, 2, 2},
        {1, 0, 1, 2, 2, 1},
        {2, 1, 0, 2, 1, 2},
        {1, 2, 2, 0, 1, 1},
        {2, 2, 1, 1, 0, 2},
        {2, 1, 2, 1, 2, 0}
    };
    int totalMachineCount;
    Machine[] machines;

    /**
     *
     * @return
     */
    public int getTotalMachineCount() {
        return totalMachineCount;
    }

    /**
     *
     * @return
     */
    public Machine[] getMachines() {
        return machines;
    }

    /**
     *
     * @param totalMachineCount
     */
    public void setTotalMachineCount(int totalMachineCount) {
        this.totalMachineCount = totalMachineCount;
    }

    // Creates new Machines
    /**
     * create Machine objects
     */
    public void setMachines() {

        this.machines = new Machine[this.getTotalMachineCount()];

        for (int i = 0; i < this.getTotalMachineCount(); i++) {
            this.machines[i] = new Machine(i);
            this.getMachines()[i].setTransportTime(transportTime[i]);
        }
    }

    // Method for getting machine by Machine ID
    /**
     *
     * @param MachineID
     * @return
     */
    public Machine getMachine(int MachineID) {
        for (int i = 0; i < this.getTotalMachineCount(); i++) {
            if (this.getMachines()[i].getMachineID() == MachineID) {
                return this.getMachines()[i];
            }
        }

        return null;
    }

    /**
     * assigns totalOperationCount for each machines
     * @param population
     */
    void assignOperationCount(Population population) {

        int populationSize = population.getPopulationSize();
        int chromosomeLength = population.getChromosomes()[0].getChromosomeLength();

        for (int i = 0; i < populationSize; i++) {
            for (int j = 0; j < chromosomeLength; j++) {
                int machineID = population.getChromosomes()[i].getChromeMachineString()[j];

                this.getMachines()[machineID].increaseTotalPossibleOperstionCount();
            }

        }
    }

    void clearMachines() {
        for (int i = 0; i < totalMachineCount; i++) {
            for (int k = 0; k < this.getTotalMachineCount(); k++) {
                this.getMachines()[k].clearTotalOperation();
            }    
        }
    }
}
//~ Formatted by Jindent --- http://www.jindent.com

