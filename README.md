# NothingIsMissed
This is a simple Business bookeeping order backend that utilizes Spring JPA Data to connect to a MSSQL Database.

## How to Run the Project
1. Change the database password on the `docker-compose.yaml` file as needed.
2. Change the database password on the `demo/src/main/resources/application.properties` file as well.
3. Run `docker compose up -d --build`
4. Connect to the backend API using Postman or `curl`

> Connect to the API through `localhost` port 8080

> Connect to the SQL Server through `localhost` port 1433

### API Endpoints
Check the updated API Points using Postman
https://documenter.getpostman.com/view/26309396/2sA3kRK4MM

## TODO:
- [x] Implement other classes and link them together
- [ ] Put all secrets into a seperate environment file
- [ ] Handle incorrect JSON POST request
- [ ] Implement User/Admin Class that can access certain endpoints (Sessions)
- [ ] Implement Frontend