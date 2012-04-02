package logic;

import org.jscience.mathematics.number.Real;

/*
 * Chromosome Class :: Represents chromosome
 * Each chromosome will have Genes (Set of Jobs)
 * A chromosome is part of population
 */
/**
 *
 * @author chaitanya
 */
public class Chromosome {

    int chromeMachineString[];
    int chromeTimeString[];
    int chromosomeLength;
    int geneCount;
    Gene genes[];
    Real fitnessValue;
    int totalMakeSpan;
    Real weightInRouletteWheel;
    Real cumulativeRouletteWeight;
   
    int selectedCount;

    /**
     * to initialize machine String
     * @param ChromeMachineString
     */
    public void setChromeMachineString(int[] ChromeMachineString) {
        this.chromeMachineString = new int[ChromeMachineString.length];
        System.arraycopy(ChromeMachineString, 0, this.chromeMachineString, 0, ChromeMachineString.length);
    }

    /**
     * copying the parameterized Gene object to the local Gene object
     * @param origGenes
     */
    public void setGenes(Gene[] origGenes) {
        int index = 0;
        this.genes = new Gene[this.getGeneCount()];
        for (index = 0; index < this.getGeneCount(); index++) {
            this.genes[index] = new Gene();
            this.genes[index].setGeneLength(origGenes[index].getGeneLength());

            this.genes[index].setGeneSolution(origGenes[index].getGeneSolution());


        }
    }

    public Real getWeightInRouletteWheel() {
        return weightInRouletteWheel;
    }

    public Real getCumulativeRouletteWeight() {
        return cumulativeRouletteWeight;
    }

    public void setCumulativeRouletteWeight(Real cumulativeRouletteWeight) {
        this.cumulativeRouletteWeight = cumulativeRouletteWeight;
    }

    public int getSelectedCount() {
        return selectedCount;
    }

    public void setSelectedCount(int selectedCount) {
        this.selectedCount = selectedCount;
    }

    public void setWeightInRouletteWheel(Real weightInRouletteWheel) {
        this.weightInRouletteWheel = weightInRouletteWheel;
    }

    public void setChromeTimeString(int[] ChromeTimeString) {
         this.chromeTimeString = new int[ChromeTimeString.length];
        System.arraycopy(ChromeTimeString, 0, this.chromeTimeString, 0, ChromeTimeString.length);
    }

    public void setFitnessValue(Real fitnessValue) {
        this.fitnessValue = fitnessValue;
    }

    public int getTotalMakeSpan() {
        return totalMakeSpan;
    }

    public void setTotalMakeSpan(int totalMakeSpan) {
        this.totalMakeSpan = totalMakeSpan;
    }

    /**
     * Initialize the chromosome
     */
    public Chromosome() {
        chromosomeLength = 0;
        geneCount = 0;
        genes = null;

       
    }

    /**
     * Calculate the fitness value of Chromosome object
     */
    public void calculateFitnessValue() {
         Real.setExactPrecision(20);

        Real max = Real.ZERO;
        for (int i = 0; i < this.getGeneCount(); i++) {
            max = max.plus(Real.valueOf(Math.abs(this.getGenes()[i].getMakeSpan() - this.getGenes()[i].getOptimalMakespan())));
        }

        this.setFitnessValue(Real.ONE.divide(max));

         


    }

  

    /**
     * @param chromosomeLength
     */
    public void setChromosomeLength(int ChromosomeLength) {
        this.chromosomeLength = ChromosomeLength;
    }

    /**
     *
     * @param geneCount
     */
    public void setGeneCount(int GeneCount) {
        this.geneCount = GeneCount;
    }

    /**
     *
     * @return
     */
    public int getChromosomeLength() {
        return chromosomeLength;
    }

    /**
     *
     * @return
     */
    public int getGeneCount() {
        return geneCount;
    }

    /**
     * prints the chromosome details
     */
    public void printChromosome() {
        System.out.println("Chromosome Length = " + this.getChromosomeLength());
        System.out.println("Number Of Genes = " + this.getGeneCount());

        for (int i = 0; i < this.getGeneCount(); i++) {
            System.out.println("Gene[" + i + "]:");
            genes[i].printGenes();
        }

    }

    /**
     *
     * @param jobs
     */
    public void setGenes(Job[] jobs) {

        genes = new Gene[this.getGeneCount()];

        for (int i = 0; i < this.getGeneCount(); i++) {
            genes[i] = new Gene();
            genes[i].setGeneLength(jobs[i].getTotalOperationCount());
            genes[i].setGeneSolution(jobs, i);
        }
    }

    /**
     * Converts the chromosome object to the interger array
     */
    public void chromosomeToIntegerString() {
        chromeMachineString = new int[this.getChromosomeLength()];
        chromeTimeString = new int[this.getChromosomeLength()];

        for (int i = 0; i < this.getGeneCount(); i++) {
            for (int j = 0; j < this.genes[i].geneLength; j++) {
                chromeMachineString[i * this.getGeneCount() + j] = genes[i].getGeneSolution()[j].machineID;
                chromeTimeString[i * this.getGeneCount() + j] = genes[i].getGeneSolution()[j].time;
            }
        }
    }

    void printChromeIntegerString() {
        for (int i = 0; i < this.getChromosomeLength(); i++) {

            // Replace chromeTimeString with chromeMachineString to print it..
            System.out.print(chromeTimeString[i] + " ");
        }

        System.out.println();
    }

    public void integerStringToChromosome() {
        this.setChromeMachineString(this.getChromeMachineString());
        this.setChromeTimeString(this.getChromeTimeString());
        this.setGeneCount(this.getGeneCount());
        this.setGenes(this.getChromeMachineString(), this.getChromeTimeString());

    }

    public int[] getChromeMachineString() {
        return chromeMachineString;
    }

    /**
     *
     * @return
     */
    public int[] getChromeTimeString() {
        return chromeTimeString;
    }

    /**
     *
     * @return
     */
    public Real getFitnessValue() {
        return fitnessValue;
    }

    /**
     *
     * @return
     */
    public Gene[] getGenes() {
        return genes;
    }

    /**
     *
     * @param Machines
     * @param Time
     */
    public void setGenes(int[] Machines, int[] Time) {
        for (int i = 0; i < this.getGeneCount(); i++) {
            //   genes[i].setL(0);
            genes[i].setGeneSolution(Machines, Time, this.getChromosomeLength());

        }
    }
}


