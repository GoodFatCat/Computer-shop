# Computer-shop Trial task EasyBoot

# Deployment
## Required software:
- Terminal for running bash scripts

## Run application
To run application execute start.sh
## Stop application
To stop application press ctr+c

# API
## POST
- POST /api/products/computer create Computer
- POST /api/products/laptop create Laptop
- POST /api/products/drive create Hard drive
- POST api/products/monitor create Monitor

# PUT
- PUT /api/products/computer/{id} update Computer
- PUT /api/products/laptop/{id} update Laptop
- PUT /api/products/drive/{id} update Hard drive
- PUT /api/products/Monitor/{id} update Monitor

# GET
- GET /api/products/type/[computer | laptop | monitor | hard_drive] get products by type
- GET /api/products/{id} get product by id
