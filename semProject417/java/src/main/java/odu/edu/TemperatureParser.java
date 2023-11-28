package src.main.java.odu.edu;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.util.List;
import java.util.Vector;

public class TemperatureParser
{
    /**
     * A pair of values where:
     * <ul>
     *   <li> _step_ attribute represents the time at which the readind was
     *        taken.
     *   </li>
     *   <li> _readings_ is a vector with _n_ temperature readings,
     *        where _n_ is the number of CPU Cores.
     *   </li>
     * </ul>
     */
	public static double[] readings_core_0;
    public static double[] readings_core_1;
    public static double[] readings_core_2;
    public static double[] readings_core_3;
    
    
    /**
     * Return any of the readings_core arrays for
     * usage in interpolation and approximation.
     *
     *@param coreNum the int designating which core to return
     *
     * @return the specificed readings_core array based on coreNum
     */
    public static double[] getCore(int coreNum)
    {
    	switch(coreNum){
    		case 0: return readings_core_0;
    		case 1: return readings_core_1;
    		case 2: return readings_core_2;
    		case 3: return readings_core_3;
    		default: System.out.println("Invalid core. Giving core 0.");
    				return readings_core_0;
    	}
    	
    }
    
    public static class CoreTempReading
    {
        /**
         * Time-step at which the readings were measured.
         */
        public int step;

        /**
         * Temperature readings (one per CPU core).
         */
        public double[] readings;
        

        /**
         * Create a reading for the specified time-step.
         *
         * @param time time-step at which the readings were measured
         * @param theReadings temperature readings (one per core)
         */
        public CoreTempReading(int time, double[] theReadings)
        {
            this.step = time;
            this.readings = theReadings;
        }

        /**
         * Generate a printable form of the temperature reading in the
         * form (time, [core_0, core_1, ... core_{n-1}]).
         *
         * @return the string representation
         */
        @Override
        public String toString()
        {
            StringBuilder bld = new StringBuilder();
            bld.append("(" + this.step + ", [");

            for (int i = 0; i < this.readings.length - 1; i++) {
                bld.append(this.readings[i]).append(", ");
            }
            bld.append(this.readings[this.readings.length - 1]).append("])");

            return bld.toString();
        }
    }

    /**
     * Take an input file and parse all core temps. Assume a step size of
     * 30 seconds.
     *
     * @param inputTemps an input file
     *
     * @return a vector of 2-tuples (pairs) containing time step and core
     *         temperature readings
     */
    public static List<CoreTempReading> parseRawTemps(BufferedReader inputTemps)
    {
        return parseRawTemps(inputTemps, 30);
    }

    /**
     * Take an input file and time-step size and parse all core temps.
     *
     * @param inputTemps an input file
     * @param stepSize time-step in seconds
     *
     * @return a vector of 2-tuples (pairs) containing time step and core
     *         temperature readings
     */
    public static List<CoreTempReading> parseRawTemps(BufferedReader inputTemps,
                                        int stepSize)
    {
        String[][] rawLines = inputTemps.lines()
                                        .map(s -> s.split("([^0-9]*\\s)|([^0-9]*$)"))
                                        .toArray(String[][]::new);

        List<CoreTempReading> allReadings = new Vector<>(rawLines.length);
        readings_core_0 = new double[rawLines.length];
        readings_core_1 = new double[rawLines.length];
        readings_core_2 = new double[rawLines.length];
        readings_core_3 = new double[rawLines.length];

        int step = 0;
        for (String[] line : rawLines) {
            double[] tempReadings = new double[line.length];

            for (int i = 0; i < tempReadings.length; i++) {
                tempReadings[i] = Double.parseDouble(line[i]);
                //Adding the reading to the appropriate core array
                switch(i) {
                case 0: readings_core_0[step/30] = Double.parseDouble(line[i]);
                		break;
                case 1: readings_core_1[step/30] = Double.parseDouble(line[i]);
        				break;
                case 2: readings_core_2[step/30] = Double.parseDouble(line[i]);
        				break;
                case 3: readings_core_3[step/30] = Double.parseDouble(line[i]);
        				break;
        		default: System.out.println("Switch case error. Please see the mistake.");
        				break;
                }
            }

            allReadings.add(new CoreTempReading(step, tempReadings));

            step += stepSize;
        }

        return allReadings;
    }
    
    /**
     * Take both types of calculation and apply for all cores.
     *
     * @param type the String of the calculation requested
     *
     * @return void
     * 
     */
    public static void calculate()
    {
    	
    	
    		double temp1, temp2;
    		double sumXY, sumX, sumY, sumX2, slope, intercept;
    		sumXY = sumX = sumY = sumX2 = slope = intercept = 0.0;
    		//Create FileWriter and BufferedWriter for output
    		FileWriter file;
    		BufferedWriter ostream;
    		//Outer looping of cores
    		for(int c = 0; c < 4; c++)
    		{
    			PiecewiseLinearInterpolation.interpolate(c);
    			LeastSquaresApproximation.approximate(c);
    			
    		}
    	
    	//End function
    }
    
}
