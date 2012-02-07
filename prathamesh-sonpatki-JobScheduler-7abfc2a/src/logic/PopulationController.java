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
  * @return
  */
 public Population getPopulation() {
        return population;
    }


 /**
  *
  */
 public PopulationController() {
    population = null;
    }


    /**
     *
     * @param job
     */
    public void GetPopulationDetails(Job [] job)
    {

        population = new Population();
        population.setPopulationSize(jobScheduler.populationSize);

        population.setChromosomes(job);
       




    }


}
