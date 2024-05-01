# Dummy App Name: Synergym

Maven Application command used for code generation
---

mvn archetype:generate -B -DarchetypeGroupId=io.dropwizard.archetypes -DarchetypeArtifactId=java-simple -DarchetypeVersion=4.0.7 -DgroupId=com.synergym -DartifactId=synergym -Dversion=1.0.-SNAPSHOT -Dpackage=com.synergym -Dname=Synergym

Reference for Hibernate DB config file format
---

https://www.dropwizard.io/en/stable/manual/hibernate.html


How to start the this application
---

1. Run `mvn clean install` to build your application
2. Start application with `java -jar target/synergym-1.0.-SNAPSHOT.jar server <absolute_path_to_your_hibernate_db_yaml>`
3. To check that your application is running enter url `http://localhost:8080`

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`
