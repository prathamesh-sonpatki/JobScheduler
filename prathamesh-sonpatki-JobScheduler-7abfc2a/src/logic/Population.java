package logic;

/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */

/**
 *
 * @author chaitanya
 */
public class Population extends Job {
    Chromosome chromosomes[];
    int        populationSize;

    /**
     *
     */
    public Population() {
        populationSize = 0;

        // chromosomes = null;
    }

    /**
     *
     * @param job
     */
    public void setChromosomes(Job job[]) {
        chromosomes = new Chromosome[jobScheduler.populationSize];

        for (int i = 0; i < jobScheduler.populationSize; i++) {
            chromosomes[i] = new Chromosome();

            int length = 0;

            for (int j = 0; j < job.length; j++) {
                length += job[j].getTotalOperations();
            }

            chromosomes[i].setGeneCount(job.length);
            chromosomes[i].setChromosomeLength(length);
            chromosomes[i].setGenes(job);
        }
    }

    /**
     *
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
