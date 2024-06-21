# NothingIsMissed
This is a Demo Spring Boot Application that utilizes Spring JPA Data to connect to a MSSQL Database.

## How to Run the Project
1. Change the database password on the `docker-compose.yaml` file as needed.
2. Change the database password on the `demo/src/main/resources/application.properties` file as well.
3. Run `docker compose up -d --build`
4. Connect to the backend API using Postman or `curl`

> Connect to the API through `localhost` port 8080

> Connect to the SQL Server through `localhost` port 1433

### API Endpoints
- `GET /items`: To get all the Product
- `POST /item`: To save a new Product to the database (fields: productName, price, amount)
- `GET /item/{id}`: To get a specific Product by id
- `PUT /item/{id}`: To update a specific Product by id
- `DELETE /item/{id}`: To delete a specific Product by id

## TODO:
- [ ] Put all secrets into a seperate environment file
- [ ] Handle incorrect JSON POST request
- [ ] Implement User/Admin Class that can access certain endpoints (Sessions)
- [ ] Implement Frontend