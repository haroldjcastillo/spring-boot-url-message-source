# Spring Boot - UrlBasedMessageSource

This is an example of a custom implementation [UrlBasedMessageSource](/src/main/java/com/example/demo/UrlBasedMessageSource.java) of `MessageSource` downloading the properties from a URL file.


## Installation

```shell
mvn clean verify
```

## Test the implementation

The property file from https://pastebin.com/raw/47DgMshH

```
cancelButton=cancel
```

Then starts the server:

```shell
mvn spring-boot:run
```

Call the test API

```
curl http://localhost:8080/test/cancelButton
```

This will return `cancel`
