FROM mysql/mysql-server
ADD /mysql/data.sql /docker-entrypoint-initdb.d/data.sql
