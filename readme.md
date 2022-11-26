# Job App
 
This app is an API which enables you to search and insert jobs.

## How to execute the application

First of all you need to build the docker container.
Therefore, you can simply write ``docker-compose build --no-cache app``. 

This should build two images:
1. db-1 - The database image
2. app - Where the application is being handled.

Both images are bundled in the technikum container.

After that, you need to start just the db-1 container and connect to the database. If you use the Workbench
or the Terminal is up to you.

There you can create the ``root`` user. After connecting to the database you have to execute the AdminUser.sql file.
This file generates the database, a new user and grant the privileges.
With this step, the setup is completed. 

You can stop the database image now and start the whole microservice with ``docker-compose up``. Of course,
if you prefer you can add the ``-d`` option. By starting the microservice the table ``job`` will be 
created.

For inserting data into the database please have a look at the first API call.

## API Calls

Please consider, the application is available under the following endpoint: 

``localhost:8080/api``

### Inserting random data

METHOD: ``GET``, ENDPOINT:``/randomJobs``

With this call 100 random generated jobs will be inserted into the database.

### Get all jobs

METHOD: ``GET``, ENDPOINT: ``/jobs``

Returns all jobs available as JSON.

### Filter for job by id

METHOD: ``GET``, ENDPOINT: ``/job/{id}``

``id`` ... the id for a certain job.

Returns a certain job filtered by a given id.

### Delete job by id

METHOD: ``DELETE``, ENDPOINT: ``/jobs/{id}``

``id`` ... the id for a certain job.

Delete the job with given id.