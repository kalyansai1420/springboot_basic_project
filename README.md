> Spring Boot internal explanation


#### MySQL docker instructions
- `docker pull mysql/mysql-server`
- `docker pull mysql/mysql-server:8.0.28`
- `docker run --name='my_sql_container' -d -p 3306:3306 mysql/mysql-server`
- `docker ps`
- `docker logs my_sql_container`
- `winpty docker exec -it my_sql_container bash`
- `mysql -u root -p`
- `ALTER USER 'root'@'localhost' IDENTIFIED BY 'newpassword';`
- `use mysql;`
- `select user from user;`
- `CREATE USER 'root'@'%' IDENTIFIED BY 'root';`
- `GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' WITH GRANT OPTION;`
- `FLUSH PRIVILEGES;`
- `create database <db_name>;`
- `use <db_name>;`



