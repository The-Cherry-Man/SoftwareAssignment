//package edu.softwareeng.sample;

import java.io.File;
import java.io.IOException;


public class TestUser {

    // TODO 3: change the type of this variable to the name you're using for your
    // User <-> ComputeEngine API; also update the parameter passed to the constructor
    private final UserNetworkBoundaryAPI coordinator;

    public TestUser(UserNetworkBoundaryAPI coordinator) {
        this.coordinator = coordinator;
    }

    public void run(String outputPath) throws IOException {
        char delimiter = ';';
        String inputPath = "test" + File.separatorChar + "testInputFile.test";

        // TODO 4: Call the appropriate method(s) on the coordinator to get it to
        // run the compute job specified by inputPath, outputPath, and delimiter

        FileUserNumber f = new FileUserNumber(inputPath);



        coordinator.userNumberInput(f);

        coordinator.destinationOutput(new Destination(outputPath));

        coordinator.delimeterOuput(new Delimeter(delimiter));

        coordinator.compute(coordinator.collection);

    }

}
