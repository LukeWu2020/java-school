## Basic Aspects of HTTP
#### HTTP is simple
HTTP is generally designed to be simple and human readable, even with
the added complexity introduced in HTTP/2 by encapsulating HTTP messages
into frames. HTTP messages can be read and understood by humans,
providing easier testing for developers, and reduced complexity for
newcomers.

#### HTTP is extensible
Introduced in HTTP/1.0, HTTP headers make this protocol easy to extend
and experiment with. New functionality can even be introduced by a
simple agreement between a client and a server about a new header's
semantics.

#### HTTP is stateless, but have sessions
HTTP is stateless: there is no link between two requests being
successively carried out on the same connection. This immediately has
the prospect of being problematic for users attempting to interact with
certain pages coherently, for example, using e-commerce shopping
baskets. But while the core of HTTP itself is stateless, HTTP cookies
allow the use of stateful sessions. Using header extensibility, HTTP
Cookies are added to the workflow, allowing session creation on each
HTTP request to share the same context, or the same state.

#### HTTP and connections
A connection is controlled at the transport layer, and therefore
fundamentally out of scope for HTTP. Though HTTP doesn't require the
underlying transport protocol to be connection-based; only requiring it
to be reliable, or not lose messages (so at minimum presenting an
error). Among the two most common transport protocols on the Internet,
TCP is reliable and UDP isn't. HTTP therefore relies on the TCP
standard, which is connection-based.

Before a client and server can exchange an HTTP request/response pair,
they must establish a TCP connection, a process which requires several
round-trips. The default behavior of HTTP/1.0 is to open a separate TCP
connection for each HTTP request/response pair. This is less efficient
than sharing a single TCP connection when multiple requests are sent in
close succession.

In order to mitigate this flaw, HTTP/1.1 introduced pipelining (which
proved difficult to implement) and persistent connections: the
underlying TCP connection can be partially controlled using the
Connection header. HTTP/2 went a step further by multiplexing messages
over a single connection, helping keep the connection warm and more
efficient.

Experiments are in progress to design a better transport protocol more
suited to HTTP. For example, Google is experimenting with QUIC which
builds on UDP to provide a more reliable and efficient transport
protocol.