--------------------
Project Overview 
--------------------

* Uses **Kotlin 1.7**

* Requires at least **Java 17** and **Gradle 7.5+**

* Retrofit for networking

* Jackson JSON parser is used

* Multi-Threading is handled using **Coroutines**

* Docker version 20

--------------------
How to build and run
--------------------

the API alongside the frontend use Docker Compose to run. Relevant Docker version is mentioned above

to build and run this project, create a new directory and name it **mhp**. cd into that directory and then:

> git clone git@github.com:charlesganza/houses-api.git got-api

> git clone git@github.com:charlesganza/houses-frontend.git got-frontend

> git clone git@github.com:charlesganza/got-houses-compose-file.git .

while in the adjacent folder you just created, run the below command
> docker-compose up

once Docker finishes getting everything working, go to **localhost:9090**

You should now see the project live

----
API
----
The API runs on localhost:8080 and is documented as follows:

| Endpoint    | Accepts | Method | Request query       | Response |
|-------------|---------|--------|---------------------|----------|
| /api/search | -       | GET    | ?query=House Algood |      [{"url":"https://www.anapioficeandfire.com/api/houses/1","name":"House Algood","region":"The Westerlands","coatOfArms":"A golden wreath, on a blue field with a gold border(Azure, a garland of laurel within a bordure or)","words":"","titles":[""],"seats":[""],"currentLord":"","heir":"","overlord":"https://www.anapioficeandfire.com/api/houses/229","founded":"","founder":"","diedOut":"","ancestralWeapons":[""],"cadetBranches":[],"swornMembers":[]}]    |
