# LokiThor

# A GPS device/vehicle tracking system

*You will need JDK 8.*

##Usage:

* Clone:
* $ git clone https://github.com/leonardoluiz/lokithor.git
* Run:	
* $ cd devicemonitor-service
* $ mvn wildfly-swarm:run
* Send a tracking record
```
curl -X POST -H "Content-Type: application/json" -d '{
	"latitude": "100",
	"longitude": "200",
	"altitude": "800",
    "deviceId": "68e4587b-14e6-4c2d-a85f-9a0c78ac2c6d",
    "time":"2017-02-01T14:45:00+0800"
}' "http://localhost:8080/api/tracking-record/"
```
* Take a look at console output