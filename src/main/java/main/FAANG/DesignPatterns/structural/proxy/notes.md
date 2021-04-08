Proxy is a structural design pattern that lets you provide a substitute or placeholder for another object. A proxy controls access to the original object, allowing you to perform something either before or after the request gets through to the original object.

Applicability

 Logging requests (logging proxy). This is when you want to keep a history of requests to the service object.
 The proxy can log each request before passing it to the service.
 
 Access control (protection proxy). This is when you want only specific clients to be able to use the service object; for instance, when your objects are crucial parts of an operating system and clients are various launched applications (including malicious ones).
 The proxy can pass the request to the service object only if the client’s credentials match some criteria.
  
 Lazy initialization (virtual proxy). This is when you have a heavyweight service object that wastes system resources by being always up, even though you only need it from time to time.
 Instead of creating the object when the app launches, you can delay the object’s initialization to a time when it’s really needed.
 
 Pros
 
 You can control the service object without clients knowing about it.
 You can manage the lifecycle of the service object when clients don’t care about it.
 The proxy works even if the service object isn’t ready or is not available.
 Open/Closed Principle. You can introduce new proxies without changing the service or clients.
  
 Cons
 The code may become more complicated since you need to introduce a lot of new classes.
 The response from the service might get delayed.
 
 
 ThirdPartyYouTubeLib.java: Remote service interface
 ThirdPartyYouTubeClass.java: Remote service implementation
 Video.java: Video file
 YouTubeCacheProxy.java: Caching proxy
 YouTubeDownloader.java: Media downloader app 
 Demo.java:  client code