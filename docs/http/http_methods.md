## HTTP Methods
HTTP defines a set of **request methods** to indicate the desired action
to be performed for a given resource. Although they can also be nouns,
these request methods are sometimes referred as *HTTP verbs*. Each of
them implements a different semantic, but some common features are
shared by a group of them: e.g. a request method can be safe,
idempotent, or cacheable. See more details about it from
[RFC 7231](https://tools.ietf.org/html/rfc7231#section-4.3).

#### GET
The `GET` method requests a representation of the specified resource.
Requests using `GET` should only retrieve data. A payload within a `GET`
request message has no defined semantics; sending a payload body on a
`GET` request might cause some existing implementations to reject the
request. It's much better to use query parameters.

#### HEAD
The `HEAD` method asks for a response identical to that of a `GET`
request, **but without the response body**. This method can be used for
obtaining metadata about the selected representation without
transferring the representation data and is often used for testing
hypertext links for validity, accessibility, and recent modification.


#### POST(Save Operation)
The `POST` method is used to submit an entity to the specified resource,
often causing a change in state or side effects on the server. For
example, POST is used for the following functions (among others):xww
- Providing a block of data, such as the fields entered into an HTML
  form, to a data-handling process.
- Posting a message to a bulletin board, newsgroup, mailing list, blog,
  or similar group of articles.
- Creating a new resource that has yet to be identified by the origin
  server.
-  Appending data to a resource's existing representation(s).


#### PUT(Full Update Operation)
The `PUT` method replaces all current representations of the target
resource with the request payload.

#### DELETE
The `DELETE` method deletes the specified resource.

#### CONNECT
The `CONNECT` method establishes a tunnel to the server identified by the
target resource.

#### OPTIONS
The `OPTIONS` method is used to describe the communication options for the
target resource.

#### TRACE
The `TRACE` method performs a message loop-back test along the path to the
target resource.

#### PATCH(Partial Update Operation)
The `PATCH` method is used to apply partial modifications to a resource.