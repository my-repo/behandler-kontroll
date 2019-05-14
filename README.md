# behandler kontroll
Repository for Pale. Application written in Kotlin used to receive legeerklæringer from external systems, doing some validation, then pushing it to our internal systems.

## Technologies used
* Kotlin
* Gradle

#### Requirements

* JDK 11


#### Build and run tests
To build locally and run the integration tests you can simply run `./gradlew shadowJar` or on windows 
`gradlew.bat shadowJar`


#### Creating a docker image
Creating a docker image should be as simple as `docker build -t behandler-kontroll .`

#### Running a docker image
`docker run --rm -it -p 8080:8080 behandler-kontroll`

## Contact us
### Code/project related questions can be sent to
* Nabil Fario, `nabil.fario@nav.no`

### For NAV employees
We are available at the Slack channel #barken
