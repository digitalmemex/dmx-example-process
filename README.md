# DMX Process Engine Example

Requires https://github.com/digitalmemex/dmx-process-engine

## Usage

Clone this repository

    cd deepamehta-4.8.2/bundle-dev
    git clone https://github.com/digitalmemex/dmx-example-process
    cd dmx-example-process

Build and deploy this plugin

    mvn clean package

## Test

    curl http://localhost:8080/process/list 
    ["ExampleCheck"]%

    curl http://localhost:8080/process/info/ExampleCheck 
    {"name":"ExampleCheck","version":1,"key":"examplecheck","resource":"examplecheck.bpmn"}% 

    curl http://localhost:8080/process/start/examplecheck
    {"id":"301"}%


