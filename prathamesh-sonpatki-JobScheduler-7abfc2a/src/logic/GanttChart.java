package logic;

//~--- non-JDK imports --------------------------------------------------------
import java.awt.Paint;
import java.awt.PaintContext;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.ColorModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;
import org.jfree.data.time.SimpleTimePeriod;

//~--- JDK imports ------------------------------------------------------------

import java.io.File;
import java.io.IOException;
import org.jfree.chart.ChartMouseEvent;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.entity.CategoryItemEntity;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.GanttRenderer;
import org.jfree.data.gantt.XYTaskDataset;

public class GanttChart {

    TaskSeriesCollection collection;

    public IntervalCategoryDataset createDataset(MachineController machineController) {
        TaskSeries seriesOne = new TaskSeries("SCHEDULES");

        for (int k = 0; k < machineController.getTotalMachineCount(); k++) {

            Task mainTask = new Task("Machines--" + k, new SimpleTimePeriod(1, 50));

            System.out.println("This is in CreateDataset : ");
            System.out.println("Machine : " + k);
            for (int j = 0; j < machineController.getMachines()[k].getSch().size(); j++) {
                int start = machineController.getMachines()[k].getSch().get(j).getStartTime();
                int end = machineController.getMachines()[k].getSch().get(j).getEndTime();
                System.out.println("\nJOBID : "+machineController.getMachines()[k].getSch().get(j).jobID);
                System.out.println("OPID : "+machineController.getMachines()[k].getSch().get(j).operationID);
                System.out.println("Start : "+machineController.getMachines()[k].getSch().get(j).startTime);
                System.out.println("End : "+machineController.getMachines()[k].getSch().get(j).endTime);
                Task subtask = new Task("subtask", new SimpleTimePeriod(start, end));
                mainTask.addSubtask(subtask);
            }

            seriesOne.add(mainTask);
        }

        collection = new TaskSeriesCollection();

        /**
         * Adding the series to the collection
         * Holds actual Dates.
         */
        collection.add(seriesOne);

        return collection;
    }

    /**
     * Creates a Gantt chart based on input data set
     */
    private JFreeChart createChart(final IntervalCategoryDataset dataset) {
        final JFreeChart chart = ChartFactory.createGanttChart("Machine Schedule", // chart title
                "Machines", // domain axis label
                "Time", // range axis label
                dataset, // data
                true, // include legend
                false, // tooltips
                false // urls
                );

        final CategoryPlot plot = (CategoryPlot) chart.getPlot();
        MyGanttRenderer renderer = new MyGanttRenderer();
        plot.setRenderer(renderer);
        renderer.setMaximumBarWidth(0.01);


        // System.out.println("Row : "+dataset.getRowCount());
        // System.out.println("Col : "+dataset.getColumnCount());

        for (int row = 0; row < 1; row++) {
            for (int j = 0; j < 6; j++) {
                renderer.getItemPaint(row, j);
            }
        }

        return chart;
    }

    public void saveChart(JFreeChart chart, String fileLocation) {
        String fileName = fileLocation;

        try {

            /**
             * This utility saves the JFreeChart as a JPEG First Parameter:
             * FileName Second Parameter: Chart To Save Third Parameter: Height
             * Of Picture Fourth Parameter: Width Of Picture
             */
            ChartUtilities.saveChartAsJPEG(new File(fileName), chart, 1024, 768);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Problem occurred creating chart.");
        }
    }

    public void drawChart(MachineController machineController, int index) {

//      final MainTest chartCreator = new MainTest();
        IntervalCategoryDataset dataset = createDataset(machineController);
        JFreeChart chart = this.createChart(dataset);
        String fileName = "Chrom" + index + ".jpg";

        this.saveChart(chart, fileName);
    }
}
//~ Formatted by Jindent --- http://www.jindent.com

