远程访问

场景：公司需要调用别人的接口，但是别人的服务不能注册到我们的zookeeper中，只能用类似httpClient的方式去调用


remote-one:通过java原生API访问别人的Controller服务，无法直接访问Service

remote-two:httpClient,无法直接访问Service

remote-utils:使用GitHub上别人封装好的一些方法，可以进行很多高大上的操作，如cookie的传递，文件上传下载等操作
