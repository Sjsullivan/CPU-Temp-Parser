package src.main.java.odu.edu;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class LeastSquaresApproximation {

	/**
     * Calculate the least squares approximation for the given core.
     *
     * @param core the int of the core requested for approximation
     *
     * @return void
     * 
     */
    public static void approximate(int core)
    {
    	double temp1, temp2;
		double sumXY, sumX, sumY, sumX2, slope, intercept;
		sumXY = sumX = sumY = sumX2 = slope = intercept = 0.0;
		
		FileWriter file;
		BufferedWriter ostream;
		
		switch(core){
		
		case 0: try {
				file = new FileWriter("core_0_analysis.txt", true);
				ostream = new BufferedWriter(file);
				//Fill in local copy of data
				double[] readings_core_0 = TemperatureParser.getCore(0);
				for(int x = 0; x < readings_core_0.length-1; x++)
				{
					//Approximation calculation
					sumX += (x*30);
					sumY += (readings_core_0[x]);
					sumXY += (x*30)*(readings_core_0[x]);
					sumX2 += (x*30)*(x*30);
				}
				//Add the last data point, as for loop looks ahead it is behind 1 from the number of steps
        		sumX += ((readings_core_0.length-1)*30);
				sumY += (readings_core_0[readings_core_0.length-1]);
				sumXY += ((readings_core_0.length-1)*30)*(readings_core_0[readings_core_0.length-1]);
				sumX2 += ((readings_core_0.length-1)*30)*((readings_core_0.length-1)*30);
				
				//Calculate least squares approximation using gathered data
				temp1 = (readings_core_0.length*(sumXY))-(sumX*sumY);
				temp2 = (readings_core_0.length*sumX2)-(sumX*sumX);
				slope = temp1/temp2;
				intercept = sumY - (slope*sumX);
				//Call the write to file function
				writeApproximation(ostream, slope, intercept);
    			ostream.close();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
			break;
			
		case 1: try {
			file = new FileWriter("core_1_analysis.txt", true);
			ostream = new BufferedWriter(file);
			//Fill in local copy of data
			double[] readings_core_1 = TemperatureParser.getCore(1);
			for(int x = 0; x < readings_core_1.length-1; x++)
			{
				//Approximation calculation
				sumX += (x*30);
				sumY += (readings_core_1[x]);
				sumXY += (x*30)*(readings_core_1[x]);
				sumX2 += (x*30)*(x*30);
			}
			//Add the last data point, as for loop looks ahead it is behind 1 from the number of steps
    		sumX += ((readings_core_1.length-1)*30);
			sumY += (readings_core_1[readings_core_1.length-1]);
			sumXY += ((readings_core_1.length-1)*30)*(readings_core_1[readings_core_1.length-1]);
			sumX2 += ((readings_core_1.length-1)*30)*((readings_core_1.length-1)*30);
			
			//Calculate least squares approximation using gathered data
			temp1 = (readings_core_1.length*(sumXY))-(sumX*sumY);
			temp2 = (readings_core_1.length*sumX2)-(sumX*sumX);
			slope = temp1/temp2;
			intercept = sumY - (slope*sumX);
			//Call the write to file function
			writeApproximation(ostream, slope, intercept);
			ostream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case 2: try {
			file = new FileWriter("core_2_analysis.txt", true);
			ostream = new BufferedWriter(file);
			//Fill in local copy of data
			double[] readings_core_2 = TemperatureParser.getCore(2);
			for(int x = 0; x < readings_core_2.length-1; x++)
			{
				//Approximation calculation
				sumX += (x*30);
				sumY += (readings_core_2[x]);
				sumXY += (x*30)*(readings_core_2[x]);
				sumX2 += (x*30)*(x*30);
			}
			//Add the last data point, as for loop looks ahead it is behind 1 from the number of steps
    		sumX += ((readings_core_2.length-1)*30);
			sumY += (readings_core_2[readings_core_2.length-1]);
			sumXY += ((readings_core_2.length-1)*30)*(readings_core_2[readings_core_2.length-1]);
			sumX2 += ((readings_core_2.length-1)*30)*((readings_core_2.length-1)*30);
			
			//Calculate least squares approximation using gathered data
			temp1 = (readings_core_2.length*(sumXY))-(sumX*sumY);
			temp2 = (readings_core_2.length*sumX2)-(sumX*sumX);
			slope = temp1/temp2;
			intercept = sumY - (slope*sumX);
			//Call the write to file function
			writeApproximation(ostream, slope, intercept);
			ostream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case 3: try {
			file = new FileWriter("core_3_analysis.txt", true);
			ostream = new BufferedWriter(file);
			//Fill in local copy of data
			double[] readings_core_3 = TemperatureParser.getCore(3);
			for(int x = 0; x < readings_core_3.length-1; x++)
			{
				//Approximation calculation
				sumX += (x*30);
				sumY += (readings_core_3[x]);
				sumXY += (x*30)*(readings_core_3[x]);
				sumX2 += (x*30)*(x*30);
			}
			//Add the last data point, as for loop looks ahead it is behind 1 from the number of steps
    		sumX += ((readings_core_3.length-1)*30);
			sumY += (readings_core_3[readings_core_3.length-1]);
			sumXY += ((readings_core_3.length-1)*30)*(readings_core_3[readings_core_3.length-1]);
			sumX2 += ((readings_core_3.length-1)*30)*((readings_core_3.length-1)*30);
			
			//Calculate least squares approximation using gathered data
			temp1 = (readings_core_3.length*(sumXY))-(sumX*sumY);
			temp2 = (readings_core_3.length*sumX2)-(sumX*sumX);
			slope = temp1/temp2;
			intercept = sumY - (slope*sumX);
			//Call the write to file function
			writeApproximation(ostream, slope, intercept);
			ostream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		
		}
    }
    
    /**
     * Write the approximation data to the provided file.
     *
     * @param outputStream the BufferedWriter opened on a provided file previously, slope the Double slope value for the approximation,
     * 		   intercept the Double intercept value for the approximation
     *
     *
     * @return void
     * 
     */
    public static void writeApproximation(BufferedWriter outputStream, double slope, double intercept)
    {
    	try {
    		//Formatting prettiness
			System.out.println();
    		outputStream.write(String.format("      \t\t\ty \t = %1$6fx  - \t%2$6f; approximation\n", slope, intercept));
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
	
}
