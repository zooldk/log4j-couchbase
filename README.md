#log4j-couchbase
===============

Version: 0.3.0

## Description

Log4j couchbase appender, that persist logs in couchbase for easy mapping and searching in java logs.
The appender is based on Log4j version 1.x. New version of the appender that suits the 2.x versions will be applied later.

## Idea

To use the force of couchbase to take structured data and make filters (map/reduce sets). In this way it should be easy to make a simple GUI that can filter and search all your log, depending of what you want to index for your GUI. Another idea could be to setup replication from couchbase into Elastic Search and use that for word searching and indexing/weighting of commond errors....


## Usage
After adding your log4j into your classpath or pom.xml, you should add this log appender:

```xml
<dependency>
	<groupId>dk.braintrust.os.logger</groupId>
	<artifactId>log4j-couchbase-logger</artifactId>
	<version>0.3.0-SNAPSHOT</version>
</dependency>
```

If you are not using maven, just run 'mvn clean install' and add the jar file to your classpath.


After adding this, you can now use the logger, by using the normal log4j format, like e.g.:

log.error("This is a fatal error!");

### Dataformat

The log will be persisted in the couchbase datastructure which will look something like this:

```json
{
  "msg": "This is an error with a stack!",
  "hostname": "58b03572d12c.netpoint.com",
  "thread": "main",
  "timestamp": 1366404509322,
  "fieldData": {
    "level": "ERROR",
    "mdc": {},
    "file": "TestLogger.java",
    "exception": {
      "exception_class": "java.lang.StackOverflowError",
      "exception_message": "Craaaap",
      "stacktrace": "java.lang.StackOverflowError: Craaaap\n\tat dk.braintrust.os.logger.TestLogger.testErrorLogger(TestLogger.java:19)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:39)\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:25)\n\tat java.lang.reflect.Method.invoke(Method.java:597)\n\tat org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:45)\n\tat org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:15)\n\tat org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:42)\n\tat org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:20)\n\tat org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:263)\n\tat org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:68)\n\tat org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:47)\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:231)\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:60)\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:229)\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:50)\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:222)\n\tat org.junit.internal.runners.statements.RunBefores.evaluate(RunBefores.java:28)\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:300)\n\tat org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:50)\n\tat org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:38)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:467)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:683)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:390)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:197)"
    },
    "class": "dk.braintrust.os.logger.TestLogger",
    "line_number": "19",
    "method": "testErrorLogger"
  },
  "exceptionInformation": {
    "exception_class": "java.lang.StackOverflowError",
    "exception_message": "Craaaap",
    "stacktrace": "java.lang.StackOverflowError: Craaaap\n\tat dk.braintrust.os.logger.TestLogger.testErrorLogger(TestLogger.java:19)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:39)\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:25)\n\tat java.lang.reflect.Method.invoke(Method.java:597)\n\tat org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:45)\n\tat org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:15)\n\tat org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:42)\n\tat org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:20)\n\tat org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:263)\n\tat org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:68)\n\tat org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:47)\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:231)\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:60)\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:229)\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:50)\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:222)\n\tat org.junit.internal.runners.statements.RunBefores.evaluate(RunBefores.java:28)\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:300)\n\tat org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:50)\n\tat org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:38)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:467)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:683)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:390)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:197)"
  }
}
```

## TODO

* Break up the json model further for the exceptions, to be able to make better maps and views in couchbase
* Clean up code
* Make prototype of GUI for testing out the maps and views
* Spread out the word to get feedback

## Contact

Steffen Larsen
Email: mailto://zooldk@gmail.com
IM (XMPP): xmpp://zooldk@gmail.com
