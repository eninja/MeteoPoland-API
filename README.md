# MeteoPoland-API
[![Build Status](https://travis-ci.org/eninja/MeteoPoland-API.svg?branch=master)](https://travis-ci.org/eninja/MeteoPoland-API)
[![codecov](https://codecov.io/gh/eninja/MeteoPoland-API/branch/master/graph/badge.svg)](https://codecov.io/gh/eninja/MeteoPoland-API)[
![sonarcloud](https://sonarcloud.io/api/project_badges/measure?project=meteo-poland&metric=alert_status
)](https://sonarcloud.io/dashboard?id=meteo-poland)


Spring Boot REST Service to obtain data from air and weather stations in Poland

Add measurements to database : /add

| HTTP Method | URI |Description |
| --- | --- | --- |
| GET | `/add/station?id={station_id}` | Add measurements from selected station |
| GET | `/add/station/all` | Add all measurements from API. Warning! It takes about 90 minutes |

Get measurements from database : /get

| HTTP Method | URI |Description |
| --- | --- | --- |
| GET | `/get/measurements/air` | Get places by Air Quality |
| GET | `/get/measurements/coldest` | Get coldest place from given date in format: YYYY-MM-DD |
| GET | `/get/measurements/coldestTop` | Get ten coldest measurements|
| GET | `/get/measurements/date` | Get measurements from given date|
| GET | `/get/measurements/hottest` | Get hottest place from given date|
| GET | `/get/measurements/hottestTop` | Get ten hottest measurements|
| GET | `/get/measurements/synoptic` | Get synoptic measurements from given date|
| GET | `/get/stations/all` | Get all stations |

Get measurements directly from API : /online

| HTTP Method | URI |Description |
| --- | --- | --- |
| GET | `/online/stations/all` |  Get all stations|
| GET | `/online/stations/coldest` |  Get coldest station|
| GET | `/online/stations/hottest` |  Get hottest station|
| GET | `/online/stations/select?id={city}` | Get all measurements stations for given city name|

## Tested on

- Java SE Development Kit 8
- Maven 3.0+
- MySQL 5.0+ _(should work with any other relational database, but you need to change dependency)_


## Getting Started

Import the Maven project straight to your Java IDE.
