Lokithor
===================

This project simulates a A GPS device/vehicle tracking system. It's a sample project build on [**Wildfly Swarm**](http://wildfly-swarm.io/).

This application is composed by two different services:

* **geolocation-service**: responsible for store device and geolocation records.
* **dashboard-service**: responsible for the user interface where devices can be tracked.



----------

> **Pre-requisites:**

> - JDK 8+.
> - Maven.

Geolocation Service
-------------
#### **Quick Start**
 
* Clone and run:
```
git clone https://github.com/leonardoluiz/lokithor.git
cd geotracking-service
mvn package
java -jar geolocation-service-swarm.jar
```

* Verify if it's running:
```
// Request
curl -X GET http://localhost:8080/version 
```
* You should get this response:
```
// Response
{
    "version": "v 0.0.1"
}
```

* Create a record for the previously created device '68e4587b-14e6-4c2d-a85f-9a0c78ac2c6d':
```
// Request
curl -X POST \
  http://localhost:8080/records \
  -H 'content-type: application/json' \
  -d '{	
	"latitude": "-44.0342618",	
	"longitude": "-19.9025411",	
	"altitude": "800",    
	"deviceId": "'68e4587b-14e6-4c2d-a85f-9a0c78ac2c6d'",    
	"time":"2017-02-01T14:45:00+0800" 
}'
``` 

* Get the location of all active devices:
```
// Request
curl -X GET http://localhost:8080/records/current
```
```
// Response
[  
   {  
      "id":"c1415652-f76f-4d27-83df-e582bf09a256",
      "latitude":-44.034264,
      "longitude":-19.90254,
      "altitude":800.0,
      "time":"Jun 16, 2017 2:26:42 PM",
      "deviceId":"1"
   },
   {  
      "id":"beb710b4-5cc5-4a54-9526-652041e9529e",
      "latitude":-44.034264,
      "longitude":-19.90254,
      "altitude":900.0,
      "time":"Jun 16, 2017 2:29:19 PM",
      "deviceId":"2"
   }
]
``` 

Dashboard Service
-------------
#### **Quick Start**
 
* Clone
```
git clone https://github.com/leonardoluiz/lokithor.git
```
* Build and run:
```
cd dashboard-service
mvn package
java -jar dashboard-service-swarm.jar
```

* Verify if it's running on http://localhost:8081
