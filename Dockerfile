FROM postgres:10
ENV POSTGRES_USER opsdb
ENV POSTGRES_PASSWORD opsdb
ADD schema.sql /docker-entrypoint-initdb.d
EXPOSE 5432