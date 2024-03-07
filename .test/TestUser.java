//package edu.softwareeng.sample;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;


public class TestUser {

    // TODO 3: change the type of this variable to the name you're using for your
    // User <-> ComputeEngine API; also update the parameter passed to the constructor
    private final UserNetworkBoundaryAPI coordinator;

    public TestUser(UserNetworkBoundaryAPI coordinator) {
        
        this.coordinator = coordinator;
    }

    public void run(String outputPath) throws IOException, ExecutionException, InterruptedException {
        char delimiter = ';';
        String inputPath = ".test" + File.separatorChar + "testInputFile.test.txt";

        // TODO 4: Call the appropriate method(s) on the coordinator to get it to
        // run the compute job specified by inputPath, outputPath, and delimiter

       FileUserNumber f = new FileUserNumber(inputPath);

        ConfigKey useredNumberInputKey = coordinator.userNumberInput(f);

        ConfigKey destinationOutputKey = coordinator.destinationOutput(new Destinations(outputPath));

        ConfigKey delimeterOuputKey = coordinator.delimeterOuput(new Delimeter(delimiter));

        ConfigKeyCollection c = new ConfigKeyCollection();

        c.addKey(useredNumberInputKey);

        c.addKey(destinationOutputKey);

        c.addKey(delimeterOuputKey);

        coordinator.compute(c);

    }

}
