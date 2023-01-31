COMPOSE_DIR = $(CURDIR)/ambiente

help:
	@echo "Available commands:"
	@echo "  build      - Builds the Docker containers"
	@echo "  up         - Brings up the containers in detached mode"
	@echo "  down       - Stops and removes the containers"
	@echo "  start      - Starts the containers"
	@echo "  stop       - Stops the containers"
	@echo "  restart    - Restarts the containers"

build:
	cd $(COMPOSE_DIR) && \
	docker-compose build

up:
	cd $(COMPOSE_DIR) && \
	docker-compose up -d

down:
	cd $(COMPOSE_DIR) && \
	docker-compose down

start:
	cd $(COMPOSE_DIR) && \
	docker-compose start

stop:
	cd $(COMPOSE_DIR) && \
	docker-compose stop

restart:
	cd $(COMPOSE_DIR) && \
	docker-compose restart
