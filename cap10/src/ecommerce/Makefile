COMMAND=$(eval MS_LIST=$(shell ls | grep -E 'commons|ms|acl' | cut -d "/" -f1 | sort -u))

define EXECUTE_COMMAND
	${MAKE} ${1} -C ./${2} TAG=${TAG};
endef

build:
	@$(COMMAND)
	@$(foreach microservice,$(MS_LIST),$(call EXECUTE_COMMAND,'build',$(microservice),))

start:
	docker-compose up -d --build

stop:
	docker-compose stop

build-start:
	make build
	make start

destroy:
	make stop
	docker-compose rm -f

show-logs:
	docker-compose logs -f