# Notes for developers working on this fork

## Building

This fork is built like the upstream version using Maven.

Compile and run tests:

```sh
mvn clean compile test
```

Build JAR files:

```sh
mvn install
```

## Deployment

Deployment is done by

`mvn deploy`.

The fork is hosted in a [custom Maven repository run by Geofabrik](https://maven.geofabrik.de). New versions are
pushed there using SCP (OpenSSH secure file copy) – authenticated by public key.

If the version string in the `pom.xml` files ends with `-SNAPSHOT`, calling `mvn deploy` will deploy to the
snapshot repository located in the `maven_repository` directory.
