# RedisExperiments

* This little project is testing redis
________________________________________

1. Checking the effect of caching
   
* To test the operation of the services, we will execute a post request several times, adding a new book:

```
curl --location --request POST 'localhost:8080/api/v1/books' \
--header 'Content-Type: application/json' \  
--data-raw '{  
    "name": "bookOne",  
    "description": "something text",  
    "price": 12345  
}'  
```

2. Next, run the following commands in a separate terminal:

```
docker exec -it rc-redis sh
# redis-cli  
127.0.0.1:6379> KEYS *  
1) "bookCache::2"  
2) "bookCache::1"  
127.0.0.1:6379> FLUSHALL  
OK  
127.0.0.1:6379> 
```

3. Next, we connect to the main application container in log reading mode using the command:

```
docker logs -f (id container)
```

4. Then we query the list of books several times:

```
curl --location --request GET 'localhost:8080/api/v1/books'
```

5. And finally in the logs we get the result