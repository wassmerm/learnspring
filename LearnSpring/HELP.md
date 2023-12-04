# Spring Boot Learning Project

### Project Plan

1.  Implement basic REST API server
2.	Persistence (JPA & Hibernate): Store the data coming in through REST in a database (MySQL)
3.	Implement a second application which will get notified through JMS 2.0 about the incoming REST request
4.	Implement a WebUI using Angular showing the number of items in the JMS queue. And showing a counter of processed messages, to monitor the live system (but manual browser refresh is sufficient)
5.	Fetch data from a public REST API (e.g., live weather data), and also store it in the database. Triggered by a button.
6.	Implement WebUI live update through both, Server-Sent-Events and (alternatively, in parallel) through WebSockets.
7.  Add OAuth 2.0 to the REST API used by the Web UI
8.  Implement Prometheus probes and a Kafka dashboard