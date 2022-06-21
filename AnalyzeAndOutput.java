
/**
 * AnalyzeAndOutput
 *
 * @author Kadin Sayani, UCID: 30061129
 *
 */

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import javafx.scene.chart.XYChart;

public class AnalyzeAndOutput extends FibAlgorithms {

    /**
     * Program to run three fibonacci algorithms,
     * calculate runtimes and output them to a file,
     * and produce a graph for runtime analysis.
     *
     * @param int[] n
     *
     */
    public static void analyzeAndOutput(int[] n) {
        // Create instance of class containing three algorithms
        FibAlgorithms instance = new FibAlgorithms();

        // Series objects for graph
        XYChart.Series series1 = new XYChart.Series<>();
        XYChart.Series series2 = new XYChart.Series<>();
        XYChart.Series series3 = new XYChart.Series<>();

        // Set series names
        series1.setName("Fib1");
        series2.setName("Fib2");
        series3.setName("Fib3");

        // Try and catch block for handling file writing exceptions
        try {
            File file = new File("output.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            // Run Fib1, write to file, and add data to series
            for (int i : n) {
                long startTime = System.nanoTime();
                long fn = instance.fib1(i);
                long endTime = System.nanoTime();
                series1.getData().add(new XYChart.Data<>(fn, (endTime - startTime)));
                bw.write("Fib1 computes F" + i + " in " + (endTime - startTime) + " nanoseconds.\n");
            }

            bw.write("\n");

            // Run Fib2, write to file, and add data to series
            for (int i : n) {
                long startTime = System.nanoTime();
                long fn = instance.fib2(i);
                long endTime = System.nanoTime();
                series2.getData().add(new XYChart.Data<>(fn, (endTime - startTime)));
                bw.write("Fib2 computes F" + i + " in " + (endTime - startTime) + " nanoseconds.\n");
            }

            bw.write("\n");

            // Run Fib3, write to file, and add data to series
            for (int i : n) {
                long startTime = System.nanoTime();
                long fn = instance.fib3(i);
                long endTime = System.nanoTime();
                series3.getData().add(new XYChart.Data<>(fn, (endTime - startTime)));
                bw.write("Fib3 computes F" + i + " in " + (endTime - startTime) + " nanoseconds.\n");
            }
            bw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        // fibonacciChart code
        fibonacciChart lineChart = new fibonacciChart();
        lineChart.setVals(series1, series2, series3);
        fibonacciChart.launch(lineChart.getClass());
    }

    /**
     * Test analyzeAndOutput with a test array of n's
     */
    public static void main(String[] args) {
        int[] testInputs = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
        analyzeAndOutput(testInputs);
    }
}
