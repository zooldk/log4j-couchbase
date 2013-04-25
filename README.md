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

## Contact

Steffen Larsen
Email: mailto://zooldk@gmail.com
IM (XMPP): xmpp://zooldk@gmail.com
