package Prefabs;
import Scripts.*;
import Scripts.Commands.DOWN;
import Scripts.Commands.NOMOVE;
import Scripts.Commands.RIGHT;
import Scripts.Commands.UP;
import VisionGoggles.*;
/**
 * Created by Noah on 11/27/2018.
 */

public class Pblock extends GameObject {

    public FourDirections fourdirections;
    private int num = 6;
    private int num2 = 4;
    private CommandLinkedList commands;
    public Pblock(){
        super(0, 400, 10,"images/Player.png", "player");

        commands = new CommandLinkedList();
        //commands.CommandsList.add(new RIGHT());

        fourdirections = new FourDirections((this), commands);
        Z = 10;
        addCommands();
        AddComponent(fourdirections);
        AddComponent(commands);

        commands.head = commands.CommandsList.peek();

    }
    public void update(){
        super.update();
    }

    private void addCommands(){
        commands.addUp(7);
        commands.addRight(7);
        commands.addDown(9);
        commands.addLeft(7);
        commands.CommandsList.add(new NOMOVE());
    }
}
