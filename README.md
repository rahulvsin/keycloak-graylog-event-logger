# keycloak-graylog-event-logger

keycloak-graylog-event-logger is a Provider jar created for Keycloak to send the user logs to Graylog via GELF UDP.

## Setup

Change the HOST and PORT in GrayLogMessageSenderContants.java according to the Graylog input setup.

## Deployment

* Copy the folder inside dependecy_module to KEYCLOAK_HOME/modules/system/layers/base/
* Use mvn clean and mvn package to generate jar file
* Copy the jar file to KEYCLOAK_HOME/standalone/deployments/
* Restart the container
* Login to Keycloak admin UI and go to Events section.
* Add graylog-event-dispatcher from Event Listeners selector inside Config tab
