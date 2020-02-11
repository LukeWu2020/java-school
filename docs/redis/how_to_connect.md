### How to connect redis server?

#### Connection without authorization
By default, if no `bind` configuration directive is specified, Redis
listens all connections from internet. If want to listen selected
interfaces, you should use `bind` configuration directive.

```
bind 127.0.0.1
```

#### Connection with authorization
It is possible to require password before processing any other commands
using following configuration directive.

```
requirepass password
```