## HTTP Request Message
HTTP requests are messages sent by the client to initiate an action on
the server.
#### Start Line
Their start-line contain three elements:
1. An HTTP method, a verb (like `GET`, `PUT` or `POST`) or a noun (like
   `HEAD` or `OPTIONS`), that describes the action to be performed. For
   example, `GET` indicates that a resource should be fetched or `POST`
   means that data is pushed to the server (creating or modifying a
   resource, or generating a temporary document to send back).
   
2. The request target, usually a URL, or the absolute path of the
   protocol, port, and domain are usually characterized by the request
   context. The format of this request target varies between different
   HTTP methods.
   - An absolute path, ultimately followed by a '?' and query string.
     ```
     HEAD /test.html?query=alibaba HTTP/1.1
     ```
   - A complete URL, known as the *absolute form*, s mostly used with
     GET when connected to a proxy.
     ```
     GET http://developer.mozilla.org/en-US/docs/Web/HTTP/Messages HTTP/1.1
     ```
   - The authority component of a URL, consisting of domain name and
     optional port (prefixed by a ':'), is called the `authority form`.
     It is only used with `CONNECT` when setting up an HTTP tunnel.
     ```
     CONNECT developer.mozilla.org:80 HTTP/1.1
     ```
#### Headers
HTTP headers from a request follow the same basic structure of an HTTP
header: a case-insensitive string followed by a colon (':') and a value
whose structure depends upon the header. The whole header, including the
value, consist of one single line, which can be quite long.

There are numerous request headers available. They can be divided in
several groups:

- *General headers*, like `Via`, apply to the message as a whole.
- *Request headers*, like `User-Agent`, `Accept-Type`, modify the
  request by specifying it further(like `Accept-Language`), by giving
  context (like `Referer`), or by conditionally restricting it (like
  `If-None`).
- *Entity headers*, like `Content-Length` which apply to the body of the
  request. Obviously, there is no such header transmitted if there is no
  body in the request.

![HTTP Request Header](./http_request_headers.png)

#### Body
The final part of the request is its body. Not all requests have one:
requests fetching resources, like `GET`, `HEAD`, `DELETE`, or `OPTIONS`,
usually don't need one. Some requests send data to the server in order
to update it: as often the case with `POST` requests (containing HTML
form data).

Bodies can be broadly divided into two categories.

- *Single-resource bodies*, consisting of one single file, defined by the
  two headers: `Content-Type` and `Content-Length`.
- *Multiple-resource bodies*, consisting of a multiple body, each
  containing a different bit of information. This is typically
  associated with HTML Forms. For more details, you can see
  [here](https://developer.mozilla.org/en-US/docs/Web/HTTP/Basics_of_HTTP/MIME_types#multipartform-data).
  