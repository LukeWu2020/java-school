## HTTP Response Message
#### Status Line
The start line of an HTTP response, called the status line, contains the
following information:

1. The protocol version, usually HTTP/1.1.

2. A status code, indicating success or failure of the request. Common
status codes are 200, 404, or 302

3. A status text. A brief, purely informational, textual description of the
status code to help a human understand the HTTP message.

```
HTTP/1.1 200 OK
```

#### Headers
HTTP headers for responses follow the same structure as any other
header: a case-insensitive string followed by a colon (':') and a value
whose structure depends upon the type of the header. The whole header,
including its value, presents as a single line.

There are numerous response headers available. These can be divided into
several groups:

- `General headers`, like`Connection`, apply to the whole message.

- `Response headers`, like `Vary` and `Access-Control-Allow-Origin`,
  give additional information about the server which doesn't fit in the
  status line.
  
- `Entity headers`, like `Content-Length` and `Content-Type`, apply to
  the body of response. Typically, no such headers are transmitted when
  there is no body in the response.
  
![HTTP Response Headers](./http_response_headers.png)
  
#### Body
The last part of a response message is the body. Not all response have
one: response with a status code, like `201` or `204`, usually don't.

Bodies can be broadly divided into three categories:
- `Single-resource body`, consisting of a single file of known length,
  defined by the two headers: `Content-Type` and `Content-Length`.
  
- `Single-resource bodies`, consisting of a single file of unknown
  length, encoded by chunks with `Transfer-Encoding` set to chunked.
  
- `Multiple-resource bodies`, consisting of a multipart body, each
  containing a different section of information. These are relatively
  rare.