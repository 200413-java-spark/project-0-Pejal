FROM postgres:10
ENV POSTGRES_USER exchangedb
ENV POSTGRES_PASSWORD exchangedb
ADD myschema.sql /docker-entrypoint-initdb.d
EXPOSE 5432