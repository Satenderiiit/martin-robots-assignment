package com.mars.robot.move;


import com.mars.robot.model.Coordinate;

public class Rover {

    private static final int MAX_X_COORDINATE = 50;
    private static final int MAX_Y_COORDINATE = 50;
    public int xAxis;
    public int yAxis;
    public String direction;
    public String robotStatus="";
    private String[] message;
    private Coordinate coordinate = new Coordinate(xAxis, yAxis);


    public Rover(String location){
        this.message = location.replaceAll("^\\s+","").split(" "); // remove whitespace as prefix & split
        this.xAxis = Integer.parseInt(message[0]);
        this.yAxis = Integer.parseInt(message[1]);
        this.direction = message[2];
    }

    public String turnLeft(){
        switch(direction)
        {
            case "N":
                return direction="W";

            case "W":
                return direction="S";

            case "S":
                return direction="E";

            case "E":
                return direction="N";

            default:
                throw new IllegalArgumentException();

        }
    }
    public String turnRight() {
        switch(direction)
        {
            case "N":
                return direction="E";

            case "W":
                return direction="N";

            case "S":
                return direction="W";

            case "E":
                return direction="S";

            default:
                throw new IllegalArgumentException();

        }
    }

    public Coordinate moveForward() {

        switch(direction)
        {
            case "N":
                yAxis += 1;
                break;

            case "W":
                xAxis -= 1;
                break;

            case "S":
                yAxis -= 1;
                break;

            case "E":
                xAxis += 1;
                break;

            default:
                throw new IllegalArgumentException();

        }
        return new Coordinate(xAxis, yAxis);
    }

    public void robotInstructionProcessing(String instructions){
        char[] commands = instructions.toCharArray();
        if(commands.length < 100) {
            for (char command : commands) {
                switch (command) {
                    case 'L':
                        direction= turnLeft();
                        break;

                    case 'R':
                        direction= turnRight();
                        break;
                    case 'F':
                        coordinate = moveForward();

                        break;
                    default:
                        throw new IllegalArgumentException("Instruction should only be in L R or F characters");
                }
            }
            if(coordinate.X()>50 || coordinate.Y()>50){
                robotStatus = "LOST";
            }

        } else{
            throw new IllegalArgumentException("Instruction should be less than 100 characters in length.");
        }
    }

}
