> Based on JDK 8, this document describes mechanisms for `Thread` in the
> Java Language. This is just a summary document, and the JDK class file
> description is recommended for details. Before you want to learn more
> about concurrency, you must know `Thread` in detail.

### What is a thread?
A thread is a thread of execution in Java program. JVM allows an
application to have multiple threads of execution running concurrently.

Every thread has a priority. Threads with higher priority are executed
in preference to threads with lower priority. When code running in some
thread creates a new `Thread` object, the new thread has its priority
initially set equal to the priority of the running thread.

Each thread may or may not also be marked as a daemon, and the thread
created in running thread is a daemon thread if and only if the creating
thread is a daemon.

Every thread has a name for identification purposes. More than one
thread may have the same name. If a name is not specified when a thread
is created, a new name is generated for it.

### Main thread
When a Java Virtual Machine starts up, there is usually a single
non-daemon thread (which typically calls the method named `main` of some
designated class).

The Java Virtual Machine continues to execute threads until either of
the following occurs:
- The `exit` method of class `Runtime` has been called and the security
  manager has permitted the exit operation to take place.

- All threads that are not daemon threads have died, either by returning
  from the call to the `run` method or by throwing an exception that
  propagates beyond the `run` method.
  
### How to create a thread?
There are two ways to create a new thread of execution. 

One is to declare a class to be a subclass of `Thread`. This subclass
should override the `run` method of class `Thread`. An instance of the
subclass can then be allocated and started. 

The other one is to declare a class implements the `runnable` interface.
An instance of the class can then be allocated, passed as an argument
when creating `Thread`, and started.

### Important methods

- `interrupt` Set status of the thread to interrupted. If this thread is
  blocked in an invocation of the `Object.wait()` method of the `Object`
  class, or of the `join()`, `sleep(long)` methods of this class, then
  its interrupt status will be cleared and it will receive an
  `InterruptedException`.
  >  You should call the method `interrupted()` to clear interrupted
  >  status after an InterruptedException is thrown.
  
- `yield` A hint to the scheduler that the current thread is willing to
  yield its current use of a processor. The scheduler is free to ignore
  this hint.
  > Note that if this method is called, the race conditions held by
  > current thread are released. The method `wait()` of `Object` class
  > has the same function.

- `sleep` Causes the currently executing thread to sleep (temporarily
  cease execution) for the specified number of milliseconds, subject to
  the precision and accuracy of system timers and schedulers. 
  > The thread does not lose ownership of any monitors. It is different
  > from the invocation of `yield` method.