## Thread Pool
#### Core properties
- corePoolSize
- maximumPoolSize
- workQueue
- keepAliveTime

#### How to process a new task?
Proceed in 3 steps:
1. If fewer than `corePoolSize` threads are running, try to start a new
   thread with the given command as its first task. The call to
   addWorker atomically checks runState and workerCount, and so prevents
   false alarms that would add threads when it shouldn't, by returning
   false.

2. If a task can be successfully added to `workQueue`, then we still
   need to double-check whether we should have added a thread (because
   existing ones died since last checking) or that the pool shut down
   since entry into this method. So we recheck state and if necessary
   roll back the enqueuing if stopped, or start a new thread if there
   are none.

3. If we cannot queue task, then we try to add a new thread, but
   guarantee that the number of running threads is less than or equal to
   `maximumPoolSize`. If it fails, we know we are shut down or saturated
   and so reject the task.
   
> Actually, `start a new thread` mean create a wrapper class named
> `ThreadPoolExecutor.Worker`, which works as an important role to
> process a new task. It contains a thread instance and implements
> `Runnable` interface.

#### How to set values to core properties?