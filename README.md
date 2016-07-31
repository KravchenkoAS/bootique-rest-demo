Simple [Bootique](http://bootique.io) demo app. To build do something like this:

```
git clone git@github.com:bootique-examples/bootique-rest-demo.git
cd bootique-rest-demo

mvn clean package
```
To print supported options:
```
java -jar target/bootique-demo-0.0.1-SNAPSHOT.jar 
```
To run with **default** config:
```
java -jar target/bootique-demo-0.0.1-SNAPSHOT.jar --server
```
Then open [http://127.0.0.1:8080/](http://127.0.0.1:8080/). 

Available metrics URLs:

* [http://127.0.0.1:8080/metrics](http://127.0.0.1:8080/metrics).
* [http://127.0.0.1:8080/threads](http://127.0.0.1:8080/threads).