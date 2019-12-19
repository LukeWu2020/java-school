The Java HotSpot VM includes three different types of collectors.

- The serial collector uses a single thread to perform all garbage collection work, which makes it relatively efficient because
 there is no communication overhead between threads. It is best-suited to single processor machines, 
 because it cannot take advantage of multiprocessor hardware, although it can be useful on multiprocessors for applications 
 with small data sets (up to approximately 100 MB). The serial collector is selected by default on certain hardware and 
 operating system configurations, or can be explicitly enabled with the option `-XX:+UseSerialGC`.

