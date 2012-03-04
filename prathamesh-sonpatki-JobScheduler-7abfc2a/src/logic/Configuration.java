package logic;

/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */

/**
 *
 * @author Pawan
 */
public class Configuration {
    CrossoverScheme       crossoverScheme;
    RandomNumberGenerator randomNumberGenerator;

    final void setCrossoverScheme(String option) {
        if (option.equals("Single Point Crossover")) {

            // crossoverScheme = new SinglePointCrossover();
        } else if (option.equals("Two Point Crossover")) {

            // crossoverScheme = new TwoPointCrossover();
        }
    }

    final void setRandomNumberGenerator(String option) {
        if (option.equals("MersenneTwister")) {
            randomNumberGenerator = new MersenneTwister();
        }
    }

    CrossoverScheme getCrossoverScheme() {
        return this.crossoverScheme;
    }

    RandomNumberGenerator getRandomNumberGenerator() {
        return this.randomNumberGenerator;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
