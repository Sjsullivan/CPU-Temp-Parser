package src.main.java;

import java.util.*;

import src.main.java.odu.edu.TemperatureParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;

import static src.main.java.odu.edu.TemperatureParser.*;

/**
 * A simple command line test driver for TemperatureParser.
 */
public class ParseTempsDriver {

    /**
     * The main function used to demonstrate the TemperatureParser class.
     *
     * @param args used to pass in a single filename
     */
    public static void main(String[] args)
    {
        BufferedReader tFileStream = null;

        // Parse command line argument 1
        try {
            tFileStream = new BufferedReader(new FileReader(new File(args[0])));
            
        }
        catch (ArrayIndexOutOfBoundsException e) {
            // Throw error caught after file was found, during traversal
        	System.out.println("Out of bounds exception while reading file. Please try again.");
        }
        catch (FileNotFoundException e) {
            // Throw error caught failing to find file
        	System.out.println("File not found. Please try again.");
        }

        List<CoreTempReading> allTheTemps = parseRawTemps(tFileStream);

        for (CoreTempReading aReading : allTheTemps) {
            System.out.println(aReading);
        }
        //Run the calculation method with interpolation input type
        TemperatureParser.calculate();
    }
}
