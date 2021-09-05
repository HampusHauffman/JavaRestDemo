# Simple Rest API for ads
### Hampus Hauffman 

### Tools:
This was done using Java. Spring-boot, JPA, H2 and Jackson.

### How to run:
To run this open the project in your IDE and run. 
Since it uses H2 there should be no need to start a server.
However since it uses Spring Data JPA it is DB-agnostic.

### Test it:
In order to test it we'll do the following things using curl:
* Add 3 entries of ads.
    * ```curl -i -X POST -d "title=t&description=d&category=c&name=n&email=e" localhost:8080/ads```
    * ```curl -i -X POST -d "title=t2&description=d2&category=c2&name=n2&email=e2" localhost:8080/ads```
    * ```curl -i -X POST -d "title=t3&description=d3&category=c3&name=n2&email=e2" localhost:8080/ads```
* Fetch the ads
    * ```curl -i -X GET localhost:8080/ads```
    * Take note that one user has 2 ads and the id of the ads
* Fetch a specific ad based on ID
    * ```curl -i -X GET localhost:8080/ads/2```
    * Replace the number in the URL with the id of one of the ads
* Fetch ads based on category
    * ```curl -i -X GET localhost:8080/ads/category/c2```
* Fetch ads based on category and time
    * ```curl -i -X GET localhost:8080/ads/c/2020-01-01/2030-01-01```
* Fail to fetch ads with the wrong time
    * ```curl -i -X GET localhost:8080/ads/c/2030-01-01/2030-01-01```
* Update one ad based on ID
    * ```curl -i -X POST -d "title=tU&description=dU&category=cU&name=n2&email=e2&id=2" localhost:8080/ads```
    * change the id's value to one present in your db
* Fetch Users
    * ```curl -i -X GET localhost:8080/ads```
  





#### Final notes:
There is obviously a lot of things that would need to be done
for this to be production ready, such as proper error handling, logging.
However, I hope this is sufficient in showing I'm a capable developer.


