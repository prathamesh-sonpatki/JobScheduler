package logic;

import org.jscience.mathematics.number.Real;

/**
 * stores the chromosomes in the Population object
 * @author chaitanya
 */
public class Population extends Job {

    public Chromosome chromosomes[];
    static int populationSize;
    public Real cumulativeFitnessValue;

    /**
     *
     * @return the cumulative fitness value of the Chromosome object
     */
    public Real getCumulativeFitnessValue() {
        return cumulativeFitnessValue;
    }

    /**
     *
     * @param set the cumulative fitness value of the Chromosome object
     */
    public void setCumulativeFitnessValue(Real cumulativeFitnessValue) {
        this.cumulativeFitnessValue = cumulativeFitnessValue;
    }

    /**
     * Initialize the data members of the Population object
     */
    public Population() {
        chromosomes = null;
        cumulativeFitnessValue = Real.ZERO;
    }

    /**
     *
     * @param jobs
     */
    public void setChromosomes(int index , Chromosome chrom)
    {
        
        this.chromosomes[index] = new Chromosome();
        

        this.chromosomes[index].setChromeMachineString(chrom.getChromeMachineString());
        this.chromosomes[index].setChromeTimeString(chrom.getChromeTimeString());
        this.chromosomes[index].setChromosomeLength(chrom.getChromosomeLength());
        this.chromosomes[index].setCumulativeRouletteWeight(chrom.getCumulativeRouletteWeight());
        this.chromosomes[index].setFitnessValue(chrom.getFitnessValue());
        this.chromosomes[index].setGeneCount(chrom.getGeneCount());
        this.chromosomes[index].setTotalMakeSpan(chrom.getTotalMakeSpan());
        this.chromosomes[index].setWeightInRouletteWheel(chrom.getWeightInRouletteWheel());
       
       
        this.chromosomes[index].setGenes(chrom.getGenes());

        

        

    }
    public void setChromosomes(Job jobs[]) {

        chromosomes = new Chromosome[jobScheduler.populationSize];//TO DO use local population size

        for (int i = 0; i < jobScheduler.populationSize; i++) {

            chromosomes[i] = new Chromosome();
            int chromosomeLength = 0;

            for (int j = 0; j < jobs.length; j++) {
                chromosomeLength += jobs[j].getTotalOperationCount();
            }

            chromosomes[i].setGeneCount(jobs.length);
            chromosomes[i].setChromosomeLength(chromosomeLength);
            chromosomes[i].setGenes(jobs);

            chromosomes[i].chromosomeToIntegerString();
        }
    }

    /**
     * defines the total number of chromosomes present in population
     * @param populationSize
     */
    public void setPopulationSize(int populationSize) {
        this.populationSize = populationSize;
    }

    /**
     *
     * @return
     */
    public Chromosome[] getChromosomes() {
        return chromosomes;
    }

    /**
     *
     * @return
     */
    public int getPopulationSize() {
        return populationSize;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com

