# Battery-Simulator-Microservice 🔋💥
## Authors: Mark Veerasingam and Lucas Jeanes
### Description: 
ATU 3rd Year CICD 1 Project

This where we handle all database logging and operations for the Simulator.

## Instructions:
### Running the application From Docker:
- [Pull the Lithium Ion Battery Simulator Artifact Repository from Docker Hub](https://hub.docker.com/repository/docker/mveerasingam/batterysimulator_jobmanagerservice/general)
  - We found an issue when trying the command
    
    `docker pull mveerasingam/batterysimulator_jobmanagerservice`
    
    Produced an **Error response from daemon: manifest for mveerasingam/batterysimulator_jobmanagerservice:latest not found: manifest unknown: manifest unknown**
    
- You can pull each of the images individually
  

```docker pull mveerasingam/batterysimulator_jobmanagerservice:battery-simulator-database```

```docker pull mveerasingam/batterysimulator_jobmanagerservice:battery-simulator-flask```

```docker pull mveerasingam/batterysimulator_jobmanagerservice:battery-simulator-job-manager```

```docker pull mveerasingam/batterysimulator_jobmanagerservice:battery-simulator-queue-service```

```docker pull mveerasingam/batterysimulator_jobmanagerservice:rabbitmq```


- We've updated the [Docker Compose File in Job Manager to Containerise the above images from Docker](https://github.com/mVeerasingam/BatterySimulator-JobManager/blob/master/docker-compose.yml)

### Supporting Microservices
[Battery Simulator Microservice 🔋💥](https://github.com/mVeerasingam/Battery-Simulator-Microservice)
[Battery Job Manager 🔋🔄]([https://github.com/mVeerasingam/Battery_Sim_CICD.draw.io](https://github.com/mVeerasingam/BatterySimulator-JobManager))
[Battery Simulator Queue Service](https://github.com/mVeerasingam/BatterySimulator-QueueService)
