package com.mars.robot.move;


public class Rover {

    private static final int MAX_X_COORDINATE = 50;
    private static final int MAX_Y_COORDINATE = 50;
    public int xAxis;
    public int yAxis;
    public String direction;
    public String robotStatus="";
    private String[] message;


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

}
