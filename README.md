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


7. How to run From command line console, go to ElevatorApplication folder. Run following command java  -jar target/ElevatorMonitor.jar  --server.port=8082 This will start the application and listen on port 8082.  You can change the port if it is used by other application.


8. In ElevatorApplication folder, there are two files `build.bat.txt` and `run.bat.tx`t. If you use Windows, rename these files to build.bat and run.bat, change `JAVA_HOME` and `M2_HOME` in these files to point to your JDK and MAVEN folder. Then run build.bat to build and run.bat to start the application.


9. How to test In a browser(Firefox or Chrome), visit  [http://localhost:8082/](http://localhost:8082/)  Type in the number of people and select the level you want to go. You will see the movement of number in elevator column. The movement happens every 5 seconds and 2 seconds are allowed for elevator to open and close. Green number means the elevator is idle. Red means it is doing a job. `/\` is displayed for elevator moving up and `V` is indicates elevator is moving down, `-` indicates the elevator is stagnant. see images below


10. To view elevator movement tracking,  visit:
    [http://localhost:8082/elevatormovements](http://localhost:8082/elevatormovements)  This will list all movements for all elevators.  [http://localhost:8082/elevatormovements/A](http://localhost:8082/elevatormovements/A)  will only list movements of elevator A.
