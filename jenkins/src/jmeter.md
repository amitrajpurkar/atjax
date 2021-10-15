# JMeter notes

key jmeter config paramters

### load config settings

| users | ramp-up(sec) | loop cnt | hits/min |
|200 |3600(1hr) |480 |1600 |
|200 |900(15min) |120 |1600 |
|50 |900(15min) |2000 |xxx |


## main information
http://jmeter.apache.org/usermanual/test_plan.html
** <span style="color:red">if 10 threads are used
and ramp up period is 100 sec
then jmeter will take 100 seconds to get all 10 threads up and running.
Each thread will start 10 seconds (100/10) after the previous thread was begun</span>
If there are 30 threads and ramp up is 120 seconds, 
then each successive thread will be delayed by 4 seconds **



## command line usage

'''
jmeter -n -t my-test.jmx -l log.jtl -H my.proxy.server -P 8000
jmeter -n -t my-test.jmx -l log.jtl -j run-log.txt -e -o output-folder-location

jmeter 
  -Jjmeter.save.saveservice.data_type=true 
  -Jjmeter.save.saveservice.label=true  
  -Jjmeter.save.saveservice.response_code=true 
  -Jjmeter.save.saveservice.response_data=true 
  -Jjmeter.save.saveservice.response_message=true 
  -Jjmeter.save.saveservice.successful=true 
  -Jjmeter.save.saveservice.thread_name=true  
  -Jjmeter.save.saveservice.time=true
  -Jjmeter.save.saveservice.timestamp="yyyy-MM-dd HH:mm:ss"
  -Jjmeter.save.saveservice.print_field_name=true
  -Jjmeter.save.saveservice.url=true
##  -Jjmeter.save.saveservice.output_format=xml 
  -n -t my-test.jmx -l log.jtl -j run-log.txt
  -Jusers=100 -Jrampup=5000 -Jloops=480 -Jdataset="input-test-data"
##  -JJWT_TOKEN="paste-token-here"
  > "output-result-file.txt" 
'''

## about XSD for report out
the XSD files are included in jmeter installation folders
in the report file "xxx.jtl" you need to insert one line
```
<?xml-stylesheet type="text/xsl" href="path-to-xsl-in-jmeter-install-folder" ?>

this line should be inserted between
<?xml version="1.0"?>  and
<testResults version="1.2">

for xml/xslt translation to run, close the above tag, towards the end of jtl-file
```
once you save the above line indicating stylesheet location, you can open the jtl file in Excel to see prettified results
https://www.blazemeter.com/blog/visualizing-jmeter-jtl-files-viewed-xsl-stylesheet



## references/ links
https://jmeter.apache.org/usermanual/get-started.html#non_gui
https://jmeter.apache.org/usermanual/listeners.html

https://github.com/jmeter-maven-plugin/jmeter-maven-plugin/wiki
https://github.com/jmeter-maven-plugin/jmeter-maven-plugin/wiki/Basic-Configuration
https://cwiki.apache.org/confluence/display/JMETER/JMeterMavenPlugin
https://www.blazemeter.com/blog/how-use-jmeter-maven-plugin

https://www.blazemeter.com/blog/ultimate-jmeter-resource-list

https://guide.blazemeter.com/hc/en-us/articles/360000285437-Recording-Your-Session-Recording-Your-Session
https://artoftesting.com/record-scripts-in-jmeter

https://www.testingjournals.com/understand-summary-report-jmeter/
https://www.blazemeter.com/blog/top-two-techniques-get-jmeter-test-results-non-gui-mode
https://www.blazemeter.com/blog/3-easy-ways-to-monitor-jmeter-non-gui-test-results
https://www.blazemeter.com/blog/9-easy-solutions-jmeter-load-test-%E2%80%9Cout-memory%E2%80%9D-failure
https://hellotestworld.com/2016/02/02/cheatsheet-for-jmeter-__time-function-calls/


