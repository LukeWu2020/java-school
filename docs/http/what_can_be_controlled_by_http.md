## What can be controlled by HTTP
This extensible nature of HTTP has, over time, allowed for more control
and functionality of the Web. Cache or authentication methods were
functions handled early in HTTP history. The ability to relax the origin
constraint, by contrast, has only been added in the 2010s.

Here is a list of common features controllable with HTTP.

- Caching
 
    How documents are cached can be controlled by HTTP. The server can
    instruct proxies and clients, about what to cache and for how long.
    The client can instruct intermediate cache proxies to ignore the
    stored document.
    
- Relaxing the origin constraint

    To prevent snooping and other privacy invasions, Web browsers
    enforce strict separation between Web sites. Only pages from the
    same origin can access all the information of a Web page. Though
    such constraint is a burden to the server, HTTP headers can relax
    this strict separation on the server side, allowing a document to
    become a patchwork of information sourced from different domains;
    there could even be security-related reasons
    
- Authentication

    Some pages may be protected so that only specific users can access
    them. Basic authentication may be provided by HTTP, either using the
    WWW-Authenticate and similar headers, or by setting a specific
    session using HTTP cookies.
        
- Proxy and tunneling

    Servers or clients are often located on intranets and hide their
    true IP address from other computers. HTTP requests then go through
    proxies to cross this network barrier. Not all proxies are HTTP
    proxies. The SOCKS protocol, for example, operates at a lower level.
    Other protocols, like ftp, can be handled by these proxies.
    
- Sessions

    Using HTTP cookies allows you to link requests with the state of the
    server. This creates sessions, despite basic HTTP being a state-less
    protocol. This is useful not only for e-commerce shopping baskets,
    but also for any site allowing user configuration of the output.