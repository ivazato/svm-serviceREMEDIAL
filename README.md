### MySql ###
docker run --name ssi-v2-mysql -e MYSQL_ROOT_PASSWORD=root -v /Users/edson/volumes/mysqlssi:/var/lib/mysql -p 3309:3306 -d mysql

conectarse por el puerto 3309 y crear la bd ssi.
arrancar la aplicacion

### MSSQL ###
docker pull microsoft/mssql-server-linux:2017-latest

Previamente crear la carpeta donde estará el volumen /var/opt/mssql

docker create -v /var/opt/mssql --name mssql microsoft/mssql-server-linux /bin/true
docker run -e 'ACCEPT_EULA=Y' -e 'SA_PASSWORD=P@55w0rd' -p 1433:1433 --volumes-from mssql -d --name sql-server microsoft/mssql-server-linux

### ORM mapping tool ###
https://intellij-support.jetbrains.com/hc/en-us/community/posts/115000751864-Generate-Persistence-Mapping-by-Database-Schema-Detail-settings-for-Entity-Class