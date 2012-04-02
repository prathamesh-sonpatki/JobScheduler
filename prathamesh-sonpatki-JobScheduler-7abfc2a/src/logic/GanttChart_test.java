package logic;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;
import org.jfree.data.time.SimpleTimePeriod;

public class GanttChart_test {

private static final long serialVersionUID = 3488074583840465632L;

public static IntervalCategoryDataset createDataset(MachineController machineController) {

TaskSeries seriesOne = new TaskSeries("SCHEDUuLES");

    Machine m[] = machineController.getMachines();
    for(int k=0; k<machineController.getTotalMachineCount(); k++)
    {
        //determine the task


        /*TO DO : ASK  PRATHAMESH**/
        Task t = new Task("Machines--"+k,new SimpleTimePeriod(1,20));
        List<Schedule> sch = m[k].getSch();
        System.out.println(m[k]);
        try{
            Iterator<Schedule> iterator = sch.iterator();
        }catch(Exception e)
        {
            System.out.println(e);

        }

        /*while(iterator.hasNext())
        {
            Schedule next = iterator.next();
            /*Schedule s = sch.get(i);
            int startTime = s.getStartTime();
            int endTime = s.getEndTime();
            int jobID = s.getJobID();
            int operationID = s.getOperationID();

            Task t1 = new Task("subTask", new SimpleTimePeriod(startTime, endTime));
            t.addSubtask(t1);
             *
             * /
        }*/
        seriesOne.add(t);
    }
    final TaskSeriesCollection collection = new TaskSeriesCollection();

    /**
    * Adding the series to the collection
    * Holds actual Dates.
    */
    collection.add(seriesOne);

    return collection;
}

private static Date makeDate(final int day, final int month, final int year) {

final Calendar calendar = Calendar.getInstance();
calendar.set(year, month, day);
final Date result = calendar.getTime();
return result;

}

/**
* Creates a Gantt chart based on input data set
*/
private JFreeChart createChart(final IntervalCategoryDataset dataset) {
final JFreeChart chart = ChartFactory.createGanttChart(
"Gantt Chart - Sanjaal.com Feature Implmentation", // chart title
"Task", // domain axis label
"Date", // range axis label
dataset, // data
true, // include legend
true, // tooltips
false // urls
);
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
ChartUtilities.saveChartAsJPEG(new File(fileName), chart, 800, 600);
} catch (IOException e) {
e.printStackTrace();
System.err.println("Problem occurred creating chart.");
}
}

/**
* Testing the Gantt Chart Creation
*/
public static void main(final MachineController machineController) {

final GanttChart_test chartCreator = new GanttChart_test();
System.out.println("...Creating Dataset");
IntervalCategoryDataset dataset = createDataset(machineController);

System.out.println("...Creating Chart");
JFreeChart chart = chartCreator.createChart(dataset);

String fileName = "C:/temp/myGantChartDemo.jpg";

System.out.println("...Saving the Chart");
chartCreator.saveChart(chart, fileName);

System.out.println("...Chart Created Successfully and Saved");
System.out.println("Output Chart File Location: " + fileName);

}
}