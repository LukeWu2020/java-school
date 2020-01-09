## Locks
#### What is a Lock?
 A lock is a tool for controlling access to a shared resource by
 multiple threads. Commonly, a lock provides exclusive access to a
 shared resource: ***only one thread at a time can acquire the lock and all
 access to the shared resource requires that the lock be acquired first.***
 However, some locks may allow concurrent access to a shared resource,
 such as the read lock of a `ReadWriteLock`.
 
 
#### Why choose Lock?
 The use of `synchronized` methods or statements provides access to the
 implicit monitor lock associated with every object, but forces all lock
 acquisition and release to occur in a block-structured way: when
 multiple locks are acquired they must be released in the opposite
 order, and all locks must be released in the same lexical scope in
 which they were acquired.