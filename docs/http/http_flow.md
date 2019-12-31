## HTTP Flow
When a client wants to communicate with a server, either the final
server or an intermediate proxy, it performs the following steps:

1. Open a TCP connection: The TCP connection is used to send a request,
   or several, and receive an answer. The client may open a new
   connection, reuse an existing connection, or open several TCP
   connections to the servers.
2. Send an HTTP message: HTTP messages (before HTTP/2) are
   human-readable. With HTTP/2, these simple messages are encapsulated
   in frames, making them impossible to read directly, but the principle
   remains the same. For example:
   
    ```
    GET / HTTP/1.1
    Host: developer.mozilla.org
    Accept-Language: fr
    ```
3. Read the response sent by the server, such as:

    ```
    HTTP/1.1 200 OK
    Date: Sat, 09 Oct 2010 14:28:02 GMT
    Server: Apache
    Last-Modified: Tue, 01 Dec 2009 20:18:22 GMT
    ETag: "51142bc1-7449-479b075b2891b"
    Accept-Ranges: bytes
    Content-Length: 29769
    Content-Type: text/html

    <!DOCTYPE html... (here comes the 29769 bytes of the requested web page)
    ```
4. Close or reuse the connection for further requests.

If HTTP pipeline is activated, several requests can be sent without
waiting for the first response to be fully received. HTTP pipeline has
proven difficult to implement in existing networks, where old pieces of
software coexist with modern versions. HTTP pipeline has been superseded
in HTTP/2 with more robust multiplexing requests within a frame.