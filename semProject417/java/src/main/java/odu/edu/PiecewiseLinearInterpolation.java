package src.main.java.odu.edu;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PiecewiseLinearInterpolation {

	/**
     * Calculate the interpolation for the given core.
     *
     * @param core the int of the core requested for interpolation
     *
     * @return void
     * 
     */
    public static void interpolate(int core)
    {
    	double temp1, temp2;
		double sumXY, sumX, sumY, sumX2, slope, intercept;
		sumXY = sumX = sumY = sumX2 = slope = intercept = 0.0;
		
		FileWriter file;
		BufferedWriter ostream;
		
		switch(core){
		
		case 0: try {
				file = new FileWriter("core_0_analysis.txt");
				ostream = new BufferedWriter(file);
				//Fill in local copy of data
				double[] readings_core_0 = TemperatureParser.getCore(0);
				for(int x = 0; x < readings_core_0.length-1; x++)
				{
					//First calculate
					temp1 = (readings_core_0[x+1]-readings_core_0[x]);
					temp2 = ((x+1)*30)-(x*30);
					temp1 /= temp2;
					temp2 = readings_core_0[x]+(temp1 * (-1*(x*30)));
					//Call to print to file function
					writeInterpolation(ostream, (x*30), ((x+1)*30), x, temp2, temp1);
				}
    			ostream.close();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
			break;
			
		case 1: try {
				file = new FileWriter("core_1_analysis.txt");
				ostream = new BufferedWriter(file);
				//Fill in local copy of data
				double[] readings_core_1 = TemperatureParser.getCore(1);
				for(int x = 0; x < readings_core_1.length-1; x++)
				{
					//First calculate
					temp1 = (readings_core_1[x+1]-readings_core_1[x]);
					temp2 = ((x+1)*30)-(x*30);
					temp1 /= temp2;
					temp2 = readings_core_1[x]+(temp1 * (-1*(x*30)));
					//Call to print to file function
					writeInterpolation(ostream, (x*30), ((x+1)*30), x, temp2, temp1);
				}
				ostream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case 2: try {
				file = new FileWriter("core_2_analysis.txt");
				ostream = new BufferedWriter(file);
				//Fill in local copy of data
				double[] readings_core_2 = TemperatureParser.getCore(2);
				for(int x = 0; x < readings_core_2.length-1; x++)
				{
					//First calculate
					temp1 = (readings_core_2[x+1]-readings_core_2[x]);
					temp2 = ((x+1)*30)-(x*30);
					temp1 /= temp2;
					temp2 = readings_core_2[x]+(temp1 * (-1*(x*30)));
					//Call to print to file function
					writeInterpolation(ostream, (x*30), ((x+1)*30), x, temp2, temp1);
				}
				ostream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
			
		case 3: try {
				file = new FileWriter("core_3_analysis.txt");
				ostream = new BufferedWriter(file);
				//Fill in local copy of data
				double[] readings_core_3 = TemperatureParser.getCore(3);
				for(int x = 0; x < readings_core_3.length-1; x++)
				{
				//First calculate
					temp1 = (readings_core_3[x+1]-readings_core_3[x]);
					temp2 = ((x+1)*30)-(x*30);
					temp1 /= temp2;
					temp2 = readings_core_3[x]+(temp1 * (-1*(x*30)));
					//Call to print to file function
					writeInterpolation(ostream, (x*30), ((x+1)*30), x, temp2, temp1);
				}
				ostream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
    }
    
    
    /**
     * Write the interpolation data to the provided file.
     *
     * @param outputStream the BufferedWriter opened on a provided file previously, lowerBound the int lower boundary of the interpolation,
     * 		  upperBound the int upper boundary on interpolation, count the int current record being interpolated,
     * 		  value2 the Double slope value for the interpolation, value1 the Double intercept value for the interpolation
     *
     * @return void
     * 
     */
    public static void writeInterpolation(BufferedWriter outputStream, int lowerBound, int upperBound, int count, double value2, double value1)
    {
    	
    	try {
    		outputStream.write(String.format(" %1$6d <= x <\t%2$6d; y_%3$-7d= %4$11.04f +\t%5$7.04fx; interpolation\n", lowerBound, upperBound, count, value2, value1));
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
}
