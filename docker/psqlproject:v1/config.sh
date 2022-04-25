#!/bin/bash

cp /opt/docker/pg_hba.conf /etc/postgresql/13/main/
cp /opt/docker/postgresql.conf /etc/postgresql/13/main/
su postgres -c "/etc/init.d/postgresql start"
su postgres -c psql < /opt/docker/dbsetup.sql
su postgres -c "/etc/init.d/postgresql stop"
