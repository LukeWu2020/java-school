## Class Loader
#### Terms
- Bootstrap Loader

    the bootstrap class loader supplied by the Java Virtual Machine, 
- User-defined Loader

     Every user-defined class loader is an instance of a subclass of the
     abstract class ClassLoader. Applications employ user-defined class
     loaders in order to extend the manner in which the Java Virtual
     Machine dynamically loads and thereby creates classes. User-defined
     class loaders can be used to create classes that originate from
     user-defined sources.
- Defining Loader

    A class loader L may create C by defining it directly or by
    delegating to another class loader. If L creates C directly, we say
    that L defines C or, equivalently, that L is the defining loader of
    C.
- Initiating Loader

    When one class loader delegates to another class loader, the loader
    that initiates the loading is not necessarily the same loader that
    completes the loading and defines the class. If L creates C, either
    by defining it directly or by delegation, we say that L initiates
    loading of C or, equivalently, that L is an initiating loader of C.
    
> At run time, a class or interface is determined not by its name alone,
> but by a pair: its binary name (§4.2.1) and its defining class loader.
> Each such class or interface belongs to a single run-time package. The
> run-time package of a class or interface is determined by the package
> name and defining class loader of the class or interface.