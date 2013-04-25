#log4j-couchbase
===============

Version: 0.3.0

## Description

Log4j couchbase appender, that persist logs in couchbase for easy mapping and searching in java logs.
The appender is based on Log4j version 1.x. New version of the appender that suits the 2.x versions will be applied later.

## Usage

Use the logger by adding this to your maven pom.xml file:

```xml
<dependency>
	<groupId>dk.braintrust.os.logger</groupId>
	<artifactId>log4j-couchbase-logger</artifactId>
	<version>0.3.0-SNAPSHOT</version>
</dependency>
```

After that every time you do a log, like this:

log.error("This is a fatal error!");

The log will be persisted in the couchbase datastructure.

## Contact

Steffen Larsen
Email: zooldk@gmail.com
IM (XMPP): zooldk@gmail.com
