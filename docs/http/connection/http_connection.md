## Connection Management
Connection management is a key topic in HTTP: opening and maintaining
connections largely impacts the performance of Web sites and Web
applications. In HTTP/1.x, there are several models: short-lived
connections, persistent connections, and HTTP pipelining.

HTTP mostly relies on TCP for its transport protocol, providing a
connection between the client and the server. In its infancy, HTTP used
a single model to handle such connections. These connections were
short-lived: a new one created each time a request needed sending, and
closed once the answer had been received.

This simple model held an innate limitation on performance: opening each
TCP connection is a resource-consuming operation. Several messages must
be exchanged between the client and the server. Network latency and
bandwidth affect performance when a request needs sending. Modern Web
pages require many requests (a dozen or more) to serve the amount of
information needed, proving this earlier model inefficient.

Two newer models were created in HTTP/1.1. The persistent-connection
model keeps connections opened between successive requests, reducing the
time needed to open new connections. The HTTP pipelining model goes one
step further, by sending several successive requests without even
waiting for an answer, reducing much of the latency in the network.

![HTTP Connection Model](./http_1_x_connections.png)

It's important point to note that connection management in HTTP applies
to the connection between two consecutive nodes, which is hop-by-hop and
not end-to-end. The model used in connections between a client and its
first proxy may differ from the model between a proxy and the
destination server (or any intermediate proxies). The HTTP headers
involved in defining the connection model, like Connection and
Keep-Alive, are hop-by-hop headers with their values able to be changed
by intermediary nodes.

A related topic is the concept of HTTP connection upgrades, wherein an
HTTP/1.1 connection is upgraded to a different protocol, such as
TLS/1.0, WebSocket, or even HTTP/2 in cleartext. This protocol upgrade
mechanism is documented in more detail elsewhere.