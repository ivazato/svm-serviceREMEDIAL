### MySql ###
docker run --name ssi-v2-mysql -e MYSQL_ROOT_PASSWORD=root -v /Users/edson/volumes/mysqlssi:/var/lib/mysql -p 3309:3306 -d mysql

conectarse por el puerto 3309 y crear la bd ssi.
arrancar la aplicacion
