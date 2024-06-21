/opt/mssql/bin/sqlservr &

# Wait the SQL Server to start
sleep 20

/opt/mssql-tools/bin/sqlcmd -S localhost,1433 -U sa -P Strongp@55w0rd -i /home/init.sql