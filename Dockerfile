FROM postgres:10
ENV POSTGRES_USER exchangedb
ENV POSTGRES_PASSWORD exchangedb
ADD schema.sql /docker-entrypoint-initdb.d
EXPOSE 5432