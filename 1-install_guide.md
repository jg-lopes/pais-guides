# Installing PAIS

Last updated: 12/09/2021

On this guide, we will show a step-by-step process in installing PAIS v0.0.6 into your system.

# Step 1. Install JDK

PAIS uses JHipster for the scaffolding of the code that enables the transformation of a BPMN model into a full-fledged application (including UI, backend services, database etc.). JHipster is Java based, thus your computer needs a Java Development Kit (JDK) version 

For PAIS version v0.0.6, you are free to choose any version of JDK from 8 to 15. Note, however, that outside of the LTS versions (8 and 11), all other versions are depecrated.

If you do not have a compatible JDK version installed into your computer, install one via https://adoptopenjdk.net/. We recommend OpenJDK 11.

Once installed, ensure that the files are correctly linked to your system's PATH. Run `java --version` in your Terminal and ensure the correct JDK version can be seen, your output should be similar to:

```
PS C:\PAIS> java --version
openjdk 11.0.12 2021-07-20
OpenJDK Runtime Environment Temurin-11.0.12+7 (build 11.0.12+7)
OpenJDK 64-Bit Server VM Temurin-11.0.12+7 (build 11.0.12+7, mixed mode)
```

# Step 2. Install Docker

Docker is a platform that enables the usage of Containers, an abstraction that enables the self-contained bundling of software and libraries.

Since we deliver PAIS via a Docker container, you must install Docker via its official website https://docs.docker.com/get-docker/.

Once installed, ensure that the Docker Dashboard can connect to the server and the docker files are in your PATH. A call of `docker` should return the docker command's docs, similar to:

```
Usage:  docker [OPTIONS] COMMAND

A self-sufficient runtime for containers

Options:
      --config string      Location of client config files 
      
[...]

Run 'docker COMMAND --help' for more information on a command.

To get more help with docker, check out our guides at https://docs.docker.com/go/guides/
```

# Step 3. Download and installing the PAIS container

The PAIS container can be ran directly via Docker with the following command. If you do not have PAIS downloaded yet, this command will automatically download and install it in a container named `generator-jhipster-pais`.

```
docker run --name generator-jhipster-pais -v [DIRECTORY TO SCAFFOLD]:/home/jhipster/app -d -t agilekip/generator-jhipster-pais:v0.0.6
```

**Important:**  Replace `[DIRECTORY TO SCAFFOLD]` with the directory you wish to set up your code to. PAIS works by mirroring the files between this folder in your system and the home folder inside of the container.

**Tip:** You can substitute `[DIRECTORY TO SCAFFOLD]` to `$PWD` in MacOS/Linux or `${pwd}` in Windows' Powershell to make it mirror into your current working directory.

# Step 4. Running PAIS

You have now set up everything you need to do to run PAIS. You can start your docker container using the command:

```
docker container exec -it generator-jhipster-pais bash
```

This will turn your terminal into a terminal inside of the docker container. Note, however, that every change you make inside of the Home folder of the container will be mirrored into the folder you set up in `[DIRECTORY TO SCAFFOLD]`.

Using the terminal inside of the container, run the following commands to create your PAIS app folder and use JHipster to start scaffolding.

```
cd /home/jhipster/app
mkdir YOUR-APP-NAME
cd YOUR-APP-NAME
jhipster --blueprint pais --skip-jhipster-dependencies
```

# Step 5. Setting up JHipster

When setting up JHipster, it will proceed to start a step-by-step questionaire based on your application's needs. For PAIS, we recommend keeping the defaults, except for the following questions:

```
? What is the base name of your application? 
YOUR-APP-NAME

? What is your default Java package name?
 YOUR-JAVA-PACKAGE-NAME

? Please choose additional languages to install 
Choose the languages which suit your application's needs.
```

JHipster will then proceed to set up the scaffolding. Get a coffee, especially due to the mirroring this can take a while.

# Step 6. Hello, PAIS!

Once JHipster installs all the files, we can proceed into running PAIS. Since PAIS will create a server that you must access from inside your OS (and not inside Docker), you must do the following steps outside of Docker. Thus, leave the previous Terminal (inside Docker) open and start by creating a new Terminal window in your OS.

Now, move to the mirroring folder you set up in `[DIRECTORY TO SCAFFOLD]` in Part 3. This folder will now contain your YOUR-APP-HERE named folder with the JHipster filed you just created. Now run:

```
./mvnw
```

To use Maven from your system to build the app. Once it downloads and sets itself up (once again, it might take a while), your application will be running.

Now go to you browser and access localhost:8080. If you see a JHipster page, congratulations! You have now set up PAIS in your system and you can now proceed to develop your Business Processes.

On the next tutorial, we will how PAIS works for a simple process.