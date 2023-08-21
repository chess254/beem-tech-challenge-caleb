# Beem Tech Challenge!

## Elevator simulation
### Technologies used:
**Back-end:**  Spring Boot, Spring Data, JAP, Spring MVC Test Framework,  DBUnit  Front-end talks to back-end via Restful API.

**Front-end:**  AngularJS, Bootstrap(responsive)

**Database**:  Spring Boot embedded hsqldb.

**Build Tool:** [Maven3](https://maven.apache.org/docs/3.8.6/release-notes.html)

**JDK:** [Java 8](https://www.openlogic.com/openjdk-downloads)

### How to build

1. Download [Maven3](https://maven.apache.org/docs/3.8.6/release-notes.html) on your computer.
   *reference* [How to Install Maven on Windows, Linux, and Mac](https://www.baeldung.com/install-maven-on-windows-linux-mac)


2. Add mavens bin folder to  `%path%`  environment variable.


3. Download [JDK 8](https://www.openlogic.com/openjdk-downloads). .  Add its bin folder to  `%path%`  environment variable.
   Set `JAVA_HOME` environment variable,  point to JDK home folder.
   *reference* [Set JAVA_HOME on Windows 7, 8, 10, Mac OS X, Linux ](https://www.baeldung.com/java-home-on-windows-7-8-10-mac-os-x-linux)


4. Clone the repository


5. From terminal console,  go to ElevatorApplication folder.


6. Run  `mvn package`  to build, unit test and package it.  ElevatorMonitor.jar will be generated in target folder.


7. How to run From command line console, go to ElevatorApplication folder. Run following command java  `-jar target/ElevatorMonitor.jar  --server.port=8080` This will start the application and listen on port 8080.  You can change the port if it is used by other application.



8. How to test In a browser(Firefox or Chrome), visit  [`http://localhost:8080`](http://localhost:8080)  <br> Type in the number of people and select the level you want to go. <br>You will see the movement of number in elevator column. <br>The movement happens every 5 seconds and 2 seconds are allowed for elevator to open and close. <br>Number besides square/arrow indicates number of people in an elevator. <br>Red means elevator is in motion. An upward arrow is displayed for elevator moving up and downward arrow indicates elevator is moving down, square indicates the elevator is stagnant. *see image below*

![screenshot.png](src%2Fmain%2Fresources%2Fstatic%2Fscreenshot.png)
in this sample image, there are 4 elevators A,B,C,D 
Elevator A is on 10th floor with 3 passengers moving downwards
Elevator B is on first floor moving upwards with 10 passengers
Elevator C and D are idle on 4th and 3rd floor respectively.
9. To view elevator movement tracking,  visit:
    [`http://localhost:8080/elevatormovements`](http://localhost:8080/elevatormovements)  This will list all movements for all elevators.  [http://localhost:8080/elevatormovements/A](http://localhost:8080/elevatormovements/A)  will only list movements of elevator A.

10. There are 4 endpoints (I added 2 more to aid in visualization )  NB: replace 8080 with local port

GET [`localhost:/8080/elevators`](localhost:/8080/elevators)

GET [`localhost:/8080/elevators/floorNo/{floorNo}/toFloorNo/{toFloorNo}/noOfPeople/{noOfPeople}`](localhost:/8080/elevators/floorNo/{floorNo}/toFloorNo/{toFloorNo}/noOfPeople/{noOfPeople}) *calls closest elevator and transports clients to selected floor*
*({floorNo} ->pickup floor, {toFloor} -> destination floor, {noOfPeople} -> number of passengers)*

GET [`localhost:/8080/elevatormovements`](localhost:/8080/elevatormovements) *fetches movements of all elevators*

GET [`localhost:/8080/elevatormovements/{elevatorID}`](localhost:/8080/elevatormovements/{elevatorID}) *
replace elevatorID with A,B,C or D fetches movements for a specific elevator*

All the elevator events are stored in an in-memory sql database, h2 which can be accessed on localhost:8080/h2-console   (JDBC URL: `jdbc:h2:mem:testdb`, username: `sa`, no password)
![Screenshot254.png](src%2Fmain%2Fresources%2Fstatic%2Fdatabase.png)

All events are also logged to the console.

The elevators move concurrently and asynchronously.

Tests are in the src/test/package. 
