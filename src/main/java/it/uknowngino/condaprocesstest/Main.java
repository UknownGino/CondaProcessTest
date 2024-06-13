package it.uknowngino.condaprocesstest;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static final String ANACONDA_EXECUTABLE = "C:\\ProgramData\\anaconda3\\Scripts\\conda.exe"; // I'm currently debugging this on windows

    public static void main(String[] args) throws Exception {

        System.out.println("Starting script via anaconda...");
        System.out.println("In a normal scenario, it would print some messages here during execution.");

        ProcessBuilder condaBuilder = new ProcessBuilder(ANACONDA_EXECUTABLE,
                "run",
                "--name", "base", // Using the base environment to test
                "--live-stream", // Also tried without and with --no-capture-output, but same thing happens
                "python", "test_script.py" // Using a script in the project root to test
        );
        condaBuilder.redirectErrorStream(true);

        Process condaProcess = condaBuilder.start();
        BufferedReader condaReader = new BufferedReader(new InputStreamReader(condaProcess.getInputStream()));

        String readerLine;
        while ((readerLine = condaReader.readLine()) != null) {
            System.out.println("Conda process output: " + readerLine);
        }

        System.out.println("But, as you can see, it only prints them after the execution has completed.");
        System.out.println("It should've printed 5 messages with a 1-second pause between each one of them.");
        System.out.println("Instead, it prints them all at one time as soon as the execution finishes.");

    }

}