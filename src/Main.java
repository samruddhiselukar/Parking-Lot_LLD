import commands.CommandExecutorFactory;
import commands.OutputPrinter;
import exception.InvalidModeException;
import mode.FileMode;
import mode.InteractiveMode;
import service.ParkingLotService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        final OutputPrinter outputPrinter = new OutputPrinter();
        final ParkingLotService parkingLotService = new ParkingLotService();
        final CommandExecutorFactory commandExecutorFactory =
                new CommandExecutorFactory(parkingLotService);

        try {
            if (isInteractiveMode(args)) {
                new InteractiveMode(commandExecutorFactory, outputPrinter).process();
            } else if (isFileInputMode(args)) {
                new FileMode(commandExecutorFactory, outputPrinter, args[0]).process();
            } else {
                throw new InvalidModeException("Invalid Mode");
            }
        } catch (IOException e) {
            System.err.println("Error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static boolean isFileInputMode(final String[] args) {
        return args.length == 1;
    }

    private static boolean isInteractiveMode(final String[] args) {
        return args.length == 0;
    }
}