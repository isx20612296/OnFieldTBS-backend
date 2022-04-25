#!/bin/bash

su postgres -c "/usr/lib/postgresql/13/bin/postgres -D /etc/postgresql/13/main/"

if [ -f /opt/docker/schema.sql ]; then
  su postgres -c psql < /opt/docker/schema.sql
fi
