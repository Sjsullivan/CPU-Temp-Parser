# Requirements

  * JDK 11.0 or newer
  * Provided codebase repository
  * Gradle

## Imported Java Libraries

For development the following java libraries were imported and utilized.

```
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.List;
import java.util.Vector;
```

This listing was obtained by manually grabbing the imports from the files.


# Compilation

The code can be compiled with gradle by using the standard `gradlew.bat build`
command while navigated inside the repository's first directory.

If editing the codebase in Eclipse, follow these instructions to import the project in correctly:

```
File -> Import -> Existing Gradle Project -> Finish
```

Note that after being set up correctly the project should run entirely through Eclipse.


# Sample Execution & Output

If run from the command line, use the command

```
./gradlew.bat cmdLineJavaExec -Pargs="inputTextFileName.txt"
```
while in the base directory of this project, with the appropriate file name replacing the runtime argument.


If run using the above method, output *simliar* to

```
      0 <= x <	    30; y_0      =     61.0000 +	 0.6333x; interpolation
     30 <= x <	    60; y_1      =     98.0000 +	-0.6000x; interpolation
     60 <= x <	    90; y_2      =     20.0000 +	 0.7000x; interpolation
     90 <= x <	   120; y_3      =    128.0000 +	-0.5000x; interpolation
    120 <= x <	   150; y_4      =     12.0000 +	 0.4667x; interpolation
    150 <= x <	   180; y_5      =    112.0000 +	-0.2000x; interpolation
    180 <= x <	   210; y_6      =     34.0000 +	 0.2333x; interpolation
    210 <= x <	   240; y_7      =    146.0000 +	-0.3000x; interpolation
    240 <= x <	   270; y_8      =      2.0000 +	 0.3000x; interpolation
    270 <= x <	   300; y_9      =    137.0000 +	-0.2000x; interpolation
    300 <= x <	   330; y_10     =    197.0000 +	-0.4000x; interpolation
    330 <= x <	   360; y_11     =    -78.0000 +	 0.4333x; interpolation
```

will  be created for each core and written into their respective files.