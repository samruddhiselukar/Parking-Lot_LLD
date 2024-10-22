package model;

import exception.InvalidCommandException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Command {
    private static final String SPACE = " ";
    private final String commandName;
    private final List<String> params;

    public String getCommandName(){
        return commandName;
    }

    public List<String> getParams(){
        return params;
    }

    public Command(final String inputLine){
        final List<String> tokensList = Arrays.stream(inputLine.trim().split(SPACE))
                .map(String::trim)
                .filter(token -> (!token.isEmpty())).toList();

        if(tokensList.isEmpty()){
            throw new InvalidCommandException();
        }

        commandName = tokensList.getFirst().toLowerCase();
        tokensList.removeFirst();
        params = tokensList;
    }
}
