# Run

docker run -d -p 3000:3000 -v /home/mlabouardy/cloud/scheduler/data:/usr/src/app/csv --name scrapper-service scrapper-servic


docker run -d -p 8081:8080 -v /home/mlabouardy/cloud/scheduler/data/schedule.csv:/data/schedule.csv --name schedule-service mlabouardy/schedule-service


docker run -d -p 9000:9000 --name config-server mlabouardy/config-service
