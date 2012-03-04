package logic;

/*
*
 */

/**
 *
 * @author chaitanya
 */
public class PopulationController {
    Population population;

    /**
     *
     */
    public PopulationController() {
        population = null;
    }

    /**
     *
     * @return
     */
    public Population getPopulation() {
        return population;
    }

    /**
     *
     * @param job
     */
    public void GetPopulationDetails(Job[] job) {
        population = new Population();
        population.setPopulationSize(jobScheduler.populationSize);
        population.setChromosomes(job);
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
