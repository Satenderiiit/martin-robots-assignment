# martin-robots-assignment
The surface of Mars can be modelled by a rectangular grid around which robots are able to move according to instructions provided from Earth. You are to write a program that determines each sequence of robot positions and reports the final position of the robot.


#How to Run

1. Clone this repository

2. Ensure you are using JDK 1.8 and Maven 3.x above.

3. You can build the project and run the tests by running 'mvn clean package' or 'mvn clean install'


In General TDD , Code Machine MACOS; Intellij IDEA

#UseCase execution

1. Run App.main()


2. You will be presented with 
         "Please provide positions for the robot format eg: 1 1 E"
3. INPUT  0 3 W


4. You will presented with 
           "Please provide robot instruction format eg: RFRFRFRF"
5. INPUT LLFFFLFLFL

6  OUTPUT: Robots position after instruction command execution: 2 4 S



#  TIMEOUT (as per stated time to complete the test):- next steps would be.

1. Next step would be to work out the logic to implement the scent aspect which prevent the other future robots from dropping.
2. Also apply validation possibly via regex to validate the input to app is correct.