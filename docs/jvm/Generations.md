## What is the Generation
In JVM, memory is managed in generations (memory pools holding objects
of different ages). Garbage collection occurs in each generation when
the generation fills up. The vast majority of objects are allocated in a
pool dedicated to young objects (the young generation), and most objects
die there. When the young generation fills up, it causes a minor
collection in which only the young generation is collected; garbage in
other generations is not reclaimed. Minor collections can be optimized,
assuming that the weak generational hypothesis holds and most objects in
the young generation are garbage and can be reclaimed. The costs of such
collections are, to the first order, proportional to the number of live
objects being collected; a young generation full of dead objects is
collected very quickly.

Typically, some fraction of the surviving objects from the young
generation are moved to the tenured generation during each minor
collection. Eventually, the tenured generation will fill up and must be
collected, resulting in a major collection, in which the entire heap is
collected. Major collections usually last much longer than minor
collections because a significantly larger number of objects are
involved.

## Default Arrangement of Generations
`Please note that it shows the default arrangement of generations for
all collectors with the exception of the Parallel Collector and G1
Collector`

![Default arrangement of generations](./arrangement_of_generations.png)

At initialization, a maximum address space is virtually reserved but not
allocated to physical memory unless it is needed. The complete address
space reserved for object memory can be divided into the young and
tenured generations.

The young generation consists of eden and two survivor spaces. Most
objects are initially allocated in eden. One survivor space is empty at
any time, and serves as the destination of any live objects in eden; the
other survivor space is the destination during the next copying
collection. Objects are copied between survivor spaces in this way until
they are old enough to be tenured (copied to the tenured generation).

## Performance Considerations
This figure consists of a row of six rectangles. These rectangles are
labeled as follows (from left to right):

- Throughput is the percentage of total time not spent in garbage
  collection considered over long periods of time. Throughput includes
  time spent in allocation (but tuning for speed of allocation is
  generally not needed).

- Pauses are the times when an application appears unresponsive because
  garbage collection is occurring.
  
## Measurement

The command line option `-verbose:gc` causes information about the heap
and garbage collection to be printed at each collection.

For example, here is output from a server application. The output shows
two minor collections followed by one major collection.
```
[GC 325407K->83000K(776768K), 0.2300771 secs]
[GC 325816K->83372K(776768K), 0.2454258 secs]
[Full GC 267628K->83769K(776768K), 1.8479984 secs]
``` 

The numbers before and after the arrow (for example, 325407K->83000K
from the first line) indicate the combined size of live objects before
and after garbage collection, respectively.
 
The next number in parentheses (for example, (776768K) again from the
first line) is the committed size of the heap: the amount of space
usable for Java objects without requesting more memory from the
operating system. Note that this number only includes one of the
survivor spaces. Except during a garbage collection, only one survivor
space will be used at any given time to store objects.

The last item on the line (for example, 0.2300771 secs) indicates the
time taken to perform the collection, which is in this case
approximately a quarter of a second.

After minor collections, the size includes some objects that are garbage
(no longer alive) but cannot be reclaimed. These objects are either
contained in the tenured generation or referenced from the tenured
generation.

The command line option `-XX:+PrintGCDetails` causes additional
information about the collection to be printed.

The command line option `-XX:+PrintGCTimeStamps` add a time stamp at the
start of each collection. This is useful to see how frequently garbage
collections occur.




