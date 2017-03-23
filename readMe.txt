远程访问

场景：公司需要调用别人的接口，但是别人的服务不能注册到我们的zookeeper中，只能用类似httpClient的方式去调用


remote-one:通过java原生API访问别人的Controller服务，无法直接访问Service

remote-two:httpClient,无法直接访问Service

remote-three-RMI:RMI远程调用框架---远程方法调用（Remote Method Invoke）