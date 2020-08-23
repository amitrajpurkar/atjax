# atjax
house collection of projects i did at Jax; Add the key frameworks and noteworthy techniques

### for ideal backend services
uses these reference implementations
* logEvents for capturing meaningful data for machine learning
* logRecord that records severside details and contains individual logEvent
* logForwarder that writes or delegates log-writing to platforms like Splunk or ELK so that meaningful dashboards, controls/ alerts can be done
* Aspects for intercepting at controller, service layer entry-exit points
* use aspects for capturing logs, measuring response times, using circuit breakers for SLA timeouts
* circuitBreaker implementation for wait-periods or timeouts
* configProperties making possible grouping of application properties as java objects

