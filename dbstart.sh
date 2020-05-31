#!/bin/bash
docker run --name dbmysql \
    --publish 3306:3306 \
    --volume $PWD/.docker/dbdata:/var/lib/mysql \
    --env MYSQL_DATABASE=springbootdb \
    --env MYSQL_ROOT_PASSWORD=root \
    --env MYSQL_USER=root \
    --detach  \
    mysql:5.7 \
    --innodb-use-native-aio=0
