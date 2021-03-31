# Broadcast-service 

Simple apps to read file and broadcast into message broker.

## Description

For coding pretest Backend Developer at Bibit  

## Getting Started

### Dependencies

* Kafka  
* Java8 / Java11
* Docker(optional)

### Installing

* To run kafka(zookeper & broker) from dockerfile(using port 2181 & 9092) 
```
docker-compose up -d
```

### Executing program

* Run only

```
./gradlew build run
```

* Using native image
```
./gradlew nativeImage
```

## Description

* After application running it will read a file from resources and publish it into a topic 
with job scheduler (45s)


## Authors

[Rully](https://github.com/r4lly99)