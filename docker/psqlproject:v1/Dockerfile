FROM debian:11
LABEl desc="Imatge per la base de dades del projecte de 2WIAM"
RUN apt update && apt upgrade -y
RUN apt install postgresql -y
RUN mkdir /opt/docker
WORKDIR /opt/docker/
COPY * /opt/docker/
RUN chmod +x /opt/docker/config.sh && /opt/docker/config.sh
EXPOSE 5432
CMD ["/bin/bash","/opt/docker/startup.sh"]
