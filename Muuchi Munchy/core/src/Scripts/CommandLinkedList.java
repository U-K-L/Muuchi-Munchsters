package Scripts;

import Scripts.Commands.Command;
import Scripts.Commands.*;
import VisionGoggles.Behavior;

import java.util.LinkedList;
import java.util.Queue;

public class CommandLinkedList implements Behavior {

    public Queue<Command> CommandsList;
    public Command head = null;
    public CommandLinkedList(){
        CommandsList = new LinkedList<Command>();
    }

    @Override
    public void start() {

    }

    @Override
    public void update() {
    }

    @Override
    public void action() {

    }

    @Override
    public String getName() {
        return null;
    }

    public void addUp(int com){
        for(int i = 0; i <= com; i++)
            CommandsList.add(new UP());
    }
    public void addDown(int com){
        for(int i = 0; i <= com; i++)
            CommandsList.add(new DOWN());
    }
    public void addRight(int com){
        for(int i = 0; i <= com; i++)
            CommandsList.add(new RIGHT());
    }
    public void addLeft(int com){
        for(int i = 0; i <= com; i++)
            CommandsList.add(new LEFT());
    }
}
