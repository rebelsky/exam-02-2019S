package problem2;

import java.io.PrintWriter;

/**
 * Some simple experiments with SimpleCircularDLLs
 */
public class SimpleCircularDLLExperiment {
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);
    SimpleListExperiment.expt1(pen, new SimpleCircularDLL<String>());
    SimpleListExperiment.expt2(pen, new SimpleCircularDLL<String>());
    SimpleListExperiment.expt3(pen, new SimpleCircularDLL<String>());
    // SimpleListExperiment.expt4(pen, new SimpleDLL<String>(), 3);
  } // main(String[]
} // SimpleCircularDLLExperiment
