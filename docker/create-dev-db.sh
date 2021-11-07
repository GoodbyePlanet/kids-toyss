#!/bin/bash

echo Re-creating and starting PostgreSQL container...
echo The container has restart policy 'always', i.e. it will be automatically started by PC startup
echo See file 'docker-compose-create-dev-db.yml' for details like DB name, port, username, password

# Remove existing DB container and volumes
docker-compose -f docker-compose-create-dev-db.yml down -v
docker-compose -f docker-compose-create-dev-db.yml up -d

echo Docker container started
