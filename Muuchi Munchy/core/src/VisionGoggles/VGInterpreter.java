package VisionGoggles;

import java.util.Scanner;

/**
 * Created by Noah on 11/22/2017.
 *
 * Purpose: An interpreter for event scripts.
 * Reads and evaluates what function to perform.
 */

public class VGInterpreter {

    //-------------------------------------------
    //Reads the string and issues out commands
    public static void ReadScript (GameObject obj)
    {
        //parse through string.
        for (int i = 0; i < obj.script.length(); i++) {
            //-----------------------------
            //Decides command for futher parsing.
            switch (obj.script.charAt(i))
            {
                case 'm':
                    MoveObjects(obj, i+1);
                    break;
            }

            //ChooseMethod(obj, obj.script.charAt(i));
        }
    }

    //-------------------
    //Moves objects if m command is read.
    private static void MoveObjects(GameObject obj, int index)
    {

        String str = String.valueOf(obj.script); //Gets the value of string builder script.
        Scanner value = new Scanner(str); //Creates scanner class.
        value.useDelimiter("[^0-9]+"); // Uses regex to get numbers from string.

        //--------------------------------------------------
        //Decides what direction to move.
        switch (obj.script.charAt(index))
        {
            //Move forwards
            case 'f':
                MoveForward(obj);
                index++;
                break;
        }



        /*
        for (; index < obj.script.length(); index++)
        {
            if(obj.script.charAt(index) == 'x') {
                index++;
                obj.x += value.nextInt();
            }
            else if(obj.script.charAt(index) == 'y')
            {
                index++;
                obj.y += value.nextInt();

            }


        }
        */
    }

    public static void MoveForward(GameObject obj)
    {
        switch (obj.direction)
        {
            case 0: //up
                obj.x += obj.velocity;
                obj.y +=  (float)1/2 / (float)( Math.sqrt(3)/2 ) * obj.velocity;
                float dw =   (float)1/2 / (float)( Math.sqrt(3)/2 );
                break;
            case 1: //down
                obj.x -= obj.velocity;
                obj.y -= (obj.velocity / 2);
                break;
            case 2: //right
                obj.x += obj.velocity;
                obj.y -= (obj.velocity / 2);
                break;
            case 3: //left
                obj.x -= obj.velocity;
                obj.y += (obj.velocity / 2);
                break;
        }
    }
}
