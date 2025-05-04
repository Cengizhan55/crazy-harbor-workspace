FROM        prom/prometheus
MAINTAINER  The Prometheus Authors <prometheus-developers@googlegroups.com>


COPY prometheus.yml /etc/prometheus/prometheus.yml


EXPOSE     9090
VOLUME     [ "/prometheus" ]
WORKDIR    /prometheus
ENTRYPOINT [ "/bin/prometheus" ]
CMD        [ "--config.file=/etc/prometheus/prometheus.yml"]

