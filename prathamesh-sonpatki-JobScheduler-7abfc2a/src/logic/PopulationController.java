package logic;

/**
 *
 * @author chaitanya
 */
public class PopulationController {

    Population population;

    /*
     * Initialize the data member of the PopulationController object
     */
    public PopulationController() {
        population = null;
    }

    public Population getPopulation() {
        return population;
    }

    public void setPopulationDetails(Job[] jobs) {
        population = new Population();
        population.setPopulationSize(jobScheduler.populationSize);
        population.setChromosomes(jobs);
    }
}
