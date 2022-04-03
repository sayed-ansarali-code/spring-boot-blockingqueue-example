### Simple SpringBoot Application - To demonstrate async endpoint invocation (calling service)
* A very simple SpringBoot application.
* Starts at port 8082.
* Exposes an endpoint http://localhost:8082/call/{name}
* When invoked from browser (HTTP GET Method), this endpoint internally makes an async call to another endpoint in another service and returns without waiting for response from it.
* The other endpoint thats invoked is http://localhost:8081/callme/{name}

