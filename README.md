# atjax
house collection of projects i did at Jax; Add the key frameworks and noteworthy techniques

### for ideal backend services
Following non-funtional features will make a big difference in producing a High Quality product that can last test of time.
below usecases/ reference implementations, can be seen
* logEvents for capturing meaningful data for machine learning
* logRecord that records severside details and contains individual logEvent
* logForwarder that writes or delegates log-writing to platforms like Splunk or ELK so that meaningful dashboards, controls/ alerts can be done
* Aspects for intercepting at controller, service layer entry-exit points
* use aspects for capturing logs, measuring response times, using circuit breakers for SLA timeouts
* circuitBreaker implementation for wait-periods or timeouts
* configProperties making possible grouping of application properties as java objects
* swagger documentation
* unit test cases for documenting different scenarios that needs to be handled by service-layer and controllers
* arch-unit test cases to ensuring the application code structure is following desired patterns
* jacoco test coverage to keep tap of testability and coverage of your code


### other usecases
* reference for spring-boot-mongodb
* reference for spring-boot with docker / kubernetes integration.. 
* how to get apps deployed to kubernetes
* making use of vagrant or minikube
* using jenkins, gocd, or other ci/cd tools for deployment automation
