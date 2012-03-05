package logic;

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
    String ChromeMachine, ChromeTime;
    int    ChromeMachineString[];
    int    ChromeTimeString[];
    int    ChromosomeLength;
    int    GeneCount;
    double fitnessValue;
    int totalMakeSpan;
    Gene   genes[];

    /**
     *
     */
    public Chromosome() {
        ChromosomeLength = 0;
        GeneCount        = 0;
        genes            = null;
        ChromeMachine    = "";
        ChromeTime       = "";
    }

  



    /*
     *  public int getFitnessValue()
     * {
     *    int tempFitnessValue = 0;
     *    int count =0;
     *    for(int geneIndex = 0;geneIndex < this.GeneCount;geneIndex++)
     *    {
     *        int maxOperation = this.genes[geneIndex].geneLength;
     *        int minEndTime = this.genes[geneIndex].optimalEndTime;
     *        int currentEndTime = this.genes[geneIndex].geneSolution[maxOperation -1].endTime;
     *        int threshold = this.genes[geneIndex].threshold;
     *
     *        if(minEndTime > currentEndTime)
     *        {
     *            this.genes[geneIndex].nextOptimalEndTime = currentEndTime;
     *        }
     *
     *        tempFitnessValue += Math.abs(currentEndTime - minEndTime);
     *
     *        if(tempFitnessValue <= threshold)
     *        {
     *            count++;
     *        }
     *    }
     *    this.fitnessValue = 1 / (double)tempFitnessValue;
     *    if(count == this.GeneCount)
     *    {
     *        return 0;//found NE point of game
     *    }
     *    return 1;//continue with generations
     * }
     */

    /**
     *
     * @param ChromosomeLength
     */
    public void setChromosomeLength(int ChromosomeLength) {
        this.ChromosomeLength = ChromosomeLength;
    }

    /**
     *
     * @param GeneCount
     */
    public void setGeneCount(int GeneCount) {
        this.GeneCount = GeneCount;
    }

    /**
     *
     * @return
     */
    public int getChromosomeLength() {
        return ChromosomeLength;
    }

    /**
     *
     * @return
     */
    public int getGeneCount() {
        return GeneCount;
    }

    /**
     *
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
     * @param job
     */
    public void setGenes(Job[] job) {
        genes = new Gene[this.getGeneCount()];

        for (int i = 0; i < this.getGeneCount(); i++) {
            genes[i] = new Gene();
            genes[i].setGeneLength(job[i].getTotalOperations());
            genes[i].setGeneSolution(job, i);
        }
    }

    // This method no longer required..
    // To be deleted after Pawan sees it!

    /**
     *
     */
    public void ChromosomeToString() {
        ChromeMachine = "";
        ChromeTime    = "";

        for (int i = 0; i < GeneCount; i++) {
            for (int j = 0; j < genes[i].geneLength; j++) {
                ChromeMachine += genes[i].getGeneSolution()[j].MachineID;
                ChromeTime    += genes[i].getGeneSolution()[j].time;
            }
        }
    }

    // Adding a new function to change Chromosome string to string of integers
    // Because a character string may cause problems with 2 digit numbers like
    // 12 .
    // So converting ChromeMachine and ChromeTime to integer array

    /**
     *
     */
    public void ChromosomeToIntegerString() {
        ChromeMachineString = new int[this.getChromosomeLength()];
        ChromeTimeString    = new int[this.getChromosomeLength()];

        for (int i = 0; i < this.getGeneCount(); i++) {
            for (int j = 0; j < this.genes[i].geneLength; j++) {
                ChromeMachineString[i * this.getGeneCount() + j] = genes[i].getGeneSolution()[j].MachineID;
                ChromeTimeString[i * this.getGeneCount() + j]    = genes[i].getGeneSolution()[j].time;
            }
        }
    }

    void printChromeIntegerString() {
        for (int i = 0; i < this.getChromosomeLength(); i++) {

            // Replace ChromeTimeString with ChromeMachineString to print it..
            System.out.print(ChromeTimeString[i] + " ");
        }

        System.out.println();
    }

    // Adding a new function to change Chromosome string to string of integers
    // Because a character string may cause problems with 2 digit numbers like
    // 12 .
    // So converting ChromeMachine and ChromeTime to integer array

    /**
     *
     * @param Machines
     * @param Times
     */
    public void StringToChromosome(int[] Machines, int[] Times) {
        this.setGenes(Machines, Times);
    }

    /**
     *
     * @return
     */
    public int[] getChromeMachineString() {
        return ChromeMachineString;
    }

    /**
     *
     * @return
     */
    public int[] getChromeTimeString() {
        return ChromeTimeString;
    }

    /**
     *
     * @return
     */
    public double getFitnessValue() {
        return fitnessValue;
    }

    /**
     *
     * @return
     */
    public Gene[] getGenes() {
        return genes;
    }

//  No longer required !

    /**
     *
     * @param Machines
     * @param Time
     * @param NumberOfGenes
     * @return
     */
    public Chromosome StringToChromosome(String Machines, String Time, int NumberOfGenes) {
        Chromosome chromosome = new Chromosome();

        chromosome.setChromosomeLength(Machines.length());
        chromosome.setGeneCount(NumberOfGenes);
        chromosome.setGenes(Machines, Time);

        return chromosome;
    }

    /**
     *
     * @param Machines
     * @param Time
     */
    public void setGenes(int[] Machines, int[] Time) {
        for (int i = 0; i < this.getGeneCount(); i++) {
            genes[i].setGeneSolution(Machines, Time, this.getChromosomeLength());
            genes[i].printGenes();
        }
    }

    // Not required !

    /**
     *
     * @param Machines
     * @param Time
     */
    public void setGenes(String Machines, String Time) {
        genes = new Gene[this.getGeneCount()];

        for (int i = 0; i < GeneCount; i++) {
            genes[i] = new Gene();
            genes[i].setGeneLength(ChromosomeLength / GeneCount);
            genes[i].setGeneSolution(Machines, Time);
            genes[i].printGenes();
        }
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
