## Concurrent Mark Sweep(CMS) Collector
The Concurrent Mark Sweep (CMS) collector is designed for applications
that prefer shorter garbage collection pauses and that can afford to
share processor resources with the garbage collector while **the
application is running**. 

Typically applications that have a relatively large set of long-lived
data (a large tenured generation) and run on machines with two or more
processors tend to benefit from the use of this collector. However, this
collector should be considered for any application with a low pause time
requirement. 

The CMS collector is enabled with the command-line option
`-XX:+UseConcMarkSweepGC`.

Similar to the other available collectors, the CMS collector is
generational; thus both minor and major collections occur. The CMS
collector attempts to reduce pause times due to **major collections** by
using separate garbage collector threads to trace the reachable objects
concurrently with the execution of the application threads. During each
major collection cycle, the CMS collector pauses all the application
threads for a brief period at the beginning of the collection and again
toward the middle of the collection. The second pause tends to be the
longer of the two pauses. Multiple threads are used to do the collection
work during both pauses. The remainder of the collection (including most
of the tracing of live objects and sweeping of unreachable objects is
done with one or more garbage collector threads that run concurrently
with the application. Minor collections can interleave with an ongoing
major cycle, and are done in a manner similar to the parallel collector
(in particular, the application threads are stopped during minor
collections).
> Stop all application threads during major collection in Mark phase and
> minor collection.

## Concurrent Mode Failure 
The CMS collector uses one or more garbage collector threads that run
simultaneously with the application threads with the goal of completing
the collection of the tenured generation before it becomes full. As
described previously, in normal operation, the CMS collector does most
of its tracing and sweeping work with the application threads still
running, so only brief pauses are seen by the application threads.
However, if the CMS collector is unable to finish reclaiming the
unreachable objects before the tenured generation fills up, or if an
allocation cannot be satisfied with the available free space blocks in
the tenured generation, then the application is paused and the
collection is completed with all the application threads stopped. The
inability to complete a collection concurrently is referred to as
concurrent mode failure and indicates the need to adjust the CMS
collector parameters. If a concurrent collection is interrupted by an
explicit garbage collection (System.gc()) or for a garbage collection
needed to provide information for diagnostic tools, then a concurrent
mode interruption is reported.

## Excessive GC Time and OutOfMemoryError
The CMS collector throws an OutOfMemoryError if too much time is being
spent in garbage collection: if more than 98% of the total time is spent
in garbage collection and less than 2% of the heap is recovered, then an
OutOfMemoryError is thrown. This feature is designed to prevent
applications from running for an extended period of time while making
little or no progress because the heap is too small. If necessary, this
feature can be disabled by adding the option `-XX:-UseGCOverheadLimit`
to the command line.

The policy is the same as that in the parallel collector, except that
time spent performing concurrent collections is not counted toward the
98% time limit. In other words, only collections performed while the
application is stopped count toward excessive GC time. Such collections
are typically due to a concurrent mode failure or an explicit collection
request (for example, a call to System.gc).

## Floating Garbage
The CMS collector, like all the other collectors in Java HotSpot VM, is
a tracing collector that identifies at least all the reachable objects
in the heap. In the parlance of Richard Jones and Rafael D. Lins in
their publication Garbage Collection: Algorithms for Automated Dynamic
Memory, it is an incremental update collector. Because application
threads and the garbage collector thread run concurrently during a major
collection, objects that are traced by the garbage collector thread may
subsequently become unreachable by the time collection process ends.
Such unreachable objects that have not yet been reclaimed are referred
to as floating garbage. The amount of floating garbage depends on the
duration of the concurrent collection cycle and on the frequency of
reference updates, also known as mutations, by the application.
Furthermore, because the young generation and the tenured generation are
collected independently, each acts a source of roots to the other. As a
rough guideline, try increasing the size of the tenured generation by
20% to account for the floating garbage. Floating garbage in the heap at
the end of one concurrent collection cycle is collected during the next
collection cycle.