Ferret [![Build Status](https://travis-ci.org/WASdev/sample.ferret.svg?branch=master)](https://travis-ci.org/WASdev/sample.ferret)
======

This sample project contains a simple Servlet application called Ferret. Ferret listens for HTTP requests sent to `<host>:<port>/ferret[/*]`, and responds with information about the request and the server.

## Running in Eclipse

### Maven
1. Download and install [Eclipse with the WebSphere Developer Tools](https://developer.ibm.com/wasdev/downloads/liberty-profile-using-eclipse/).
2. Create a new Liberty Profile Server. See [step 3](https://developer.ibm.com/wasdev/downloads/liberty-profile-using-eclipse/) for details.
3. Clone this repository.
4. Import the sample into Eclipse using *File -> Import -> Maven -> Existing Maven Projects* option.
5. Deploy the sample into Liberty server. Right click on the *ferret* sample and select *Run As -> Run on Server* option. Find and select the Liberty profile server and press *Finish*. 
6. Go to: [http://localhost:9080/ferret](http://localhost:9080/ferret)

### Gradle
1. Go to *Help > Eclipse Marketplace > Install Buildship Gradle Integration 2.0*
2. Clone this project and import into Eclipse as an 'Existing Gradle Project'.
3. Go to *Window > Show View > Other > Gradle Executions & Gradle Tasks*
4. Go to Gradle Tasks view and run `clean` in build folder, then `build` in build folder, then `libertyStart` in liberty folder.
5. You should see the following in the console: `Application JAXWSWebSample started in XX.XX seconds.`

## Running in the Command Line

### Maven cmd-line
This project can be build with [Apache Maven](http://maven.apache.org/). The project uses [Liberty Maven Plug-in][] to automatically download and install Liberty profile runtime from the [Liberty repository](https://developer.ibm.com/wasdev/downloads/). Liberty Maven Plug-in is also used to create, configure, and run the application on the Liberty server. 

Use the following steps to run the application with Maven:

1. Execute full Maven build. This will cause Liberty Maven Plug-in to download and install Liberty profile server.
    ```bash
    $ mvn clean install
    ```

2. To run the server with the Ferret sample execute:
    ```bash
    $ mvn liberty:run-server
    ```

Once the server is running, the application will be available under [http://localhost:9080/ferret](http://localhost:9080/ferret).

### Gradle cmd-line
The sample can be built using [Gradle](https://gradle.org/) and the [Liberty Gradle Plug-in]. In the directory where you cloned the repository issue the following command to build and run the project.

    $ gradle build

To start the application use the command:

    $ gradle libertyStart

To stop the application use the command:

    $ gradle libertyStop

Once the server is running, the application will be available under [http://localhost:9080/ferret](http://localhost:9080/ferret).

## Deploying to Bluemix

Click the button below to deploy your own copy of this application to [Bluemix](https://bluemix.net).

[![Deploy to Bluemix](https://bluemix.net/deploy/button.png)](https://bluemix.net/deploy?repository=https://github.com/WASdev/sample.ferret.git)

# Notice

© Copyright IBM Corporation 2014, 2017.

# License

```text
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
````

[Liberty Maven Plug-in]: https://github.com/WASdev/ci.maven

