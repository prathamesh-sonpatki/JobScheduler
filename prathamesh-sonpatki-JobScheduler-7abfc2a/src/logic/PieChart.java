package logic;

import java.awt.Font;
import java.io.IOException;

import javax.swing.JPanel;
import java.text.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import java.io.File;

/**
 * A simple demonstration application showing how to create a pie chart using
 * data from a {@link DefaultPieDataset}.
 */
public class PieChart extends ApplicationFrame {

    /**
     * Default constructor.
     *
     * @param title  the frame title.
     */
    public PieChart(String title) {
        super(title);
    }

    /**
     * Creates a sample dataset.
     *
     * @return A sample dataset.
     */
    private PieDataset createDataset(Population population) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        DecimalFormat df = new DecimalFormat();
        df.setMinimumFractionDigits(2);
        df.setMaximumFractionDigits(2);

        for (int i = 0; i < population.getPopulationSize(); i++) {
            dataset.setValue("(" + df.format(population.getChromosomes()[i].getWeightInRouletteWheel().times(100 * population.getChromosomes()[i].getSelectedCount()).doubleValue()) + " % )", population.getChromosomes()[i].getWeightInRouletteWheel().times(100 * population.getChromosomes()[i].getSelectedCount()).doubleValue());

        }
        return dataset;
    }

    /**
     * Creates a chart.
     *
     * @param dataset  the dataset.
     *
     * @return A chart.
     */
    private JFreeChart createChart(PieDataset dataset) {

        JFreeChart chart = ChartFactory.createPieChart(
                "Generation 1", // chart title
                dataset, // data
                false, // include legend
                false,
                false);

        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelFont(new Font("SansSerif", Font.BOLD, 25));
        plot.setNoDataMessage("No data available");
        plot.setCircular(false);
        plot.setLabelGap(0.01);
        return chart;

    }

    public void drawChart(Population population) throws IOException {
        JFreeChart chart = this.createChart(createDataset(population));


        ChartUtilities.saveChartAsJPEG(new File("pie.jpg"), chart, 2048, 1024);

    }
}
