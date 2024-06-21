FROM mcr.microsoft.com/mssql/server:2022-latest

WORKDIR /home

COPY ./init.sql .

COPY ./init.sh .

EXPOSE 1433

ENV ACCEPT_EULA Y

ARG MSSQL_SA_PASSWORD='Strongp@55w0rd'

ENV MSSQL_SA_PASSWORD $MSSQL_SA_PASSWORD

ARG sqlcmd='/opt/mssql-tools/bin/sqlcmd'

RUN ./init.sh