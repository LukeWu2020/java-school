## HTTP Headers
HTTP headers let the client and the server pass additional information
with an HTTP request or response. An HTTP header consists of its
case-insensitive name followed by a colon (:), then by its value.
***Whitespace before the value is ignored***.

```
Content-Type: application/json
X-Market-Id: us
```

>Custom proprietary headers have historically been used with an `X-`
>prefix, but this convention was deprecated in June 2012 because of the
>inconveniences it caused when nonstandard fields became standard in
>[RFC 6648](https://tools.ietf.org/html/rfc6648); others are listed in
>an
>[IANA registry](https://www.iana.org/assignments/message-headers/message-headers.xhtml),
>whose original content was defined in
>[RFC 4229](https://tools.ietf.org/html/rfc4229). IANA also maintains [a
>registry of proposed new HTTP headers](https://www.iana.org/assignments/message-headers/message-headers.xhtml).

Headers can be grouped according to their contexts:

- `General headers` apply to both requests and responses, but with no
  relation to the data transmitted in the body.
  
- `Request headers` contain more information about the resource to be
  fetched, or about the client requesting in resource.
  
- `Response headers` hold additional information about the response.
  like its location or about the server providing it.
  
- `Entity headers` contain information about the body of the resource,
  like its content length or `MIME type`.
  
## Authentication
#### [WWW-Authenticate](./headers/www_authenticate.md)
Defines the authentication method that should be used to access a resource.

#### [Authorization](./headers/authorization.md)
Contains the credentials to authenticate a user-agent with a server.

## Connection Management
#### [Connection](./headers/connection.md)
Controls whether the network connection stays open after the current
transaction finishes.

#### [Keep-Alive](./headers/keep_alive.md)
Controls how long a persistent connection should stay open.

## Message body information
#### Content-Length
The size of the resource, in decimal number of bytes.

#### Content-Type
Indicates the media type of the resource.

#### Content-Encoding
Used to specify the compression algorithm.

#### Content-Language
Describes the human language(s) intended for the audience, so that it
allows a user to differentiate according to the users' own preferred
language.

#### Content-Location
Indicates an alternate location for the returned data.