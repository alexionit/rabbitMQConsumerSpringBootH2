# rabbitMQConsumerSpringBootH2

The docker compose yml below was used save into docker-compose.yml

version: '3.8'

services:
  rabbitmq:
    image: rabbitmq:3-management
    hostname: my-rabbit
    volumes:
      - ./rabbitmq/etc/definitions.json:/etc/rabbitmq/definitions.json
      - ./rabbitmq/etc/rabbitmq.conf:/etc/rabbitmq/rabbitmq.conf
      - ./rabbitmq/data:/var/lib/rabbitmq/mnesia/rabbit@my-rabbit
      - ./rabbitmq/logs:/var/log/rabbitmq/log
    ports:
      - 5672:5672
      - 15672:15672
      
      
command to run where yml file is located:
docker-compose up
