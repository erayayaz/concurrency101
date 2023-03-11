## Requirmements
- Java17
- PostgreSQL

## DB
```shell
docker run --name postgres -e POSTGRES_PASSWORD=fresh -e POSTGRES_DB=concurrency -e POSTGRES_USER=postgres postgres
```
## RUN
```shell
./gradlew bootRun
```

## Benchmark
```shell
echo "{
  "uuid" : "34628519-4e86-4a55-8dc1-b1f8b2b65e69",
  "amount" : 23
}" > input.json

ab -n 100 -c 50 -T 'application/json' -p ./input.json http://localhost:8080/invoices
```