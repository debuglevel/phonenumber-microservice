<!--- some badges to display on the GitHub page -->
![Travis (.org)](https://img.shields.io/travis/debuglevel/phonenumber-microservice?label=Travis%20build)
![Gitlab pipeline status](https://img.shields.io/gitlab/pipeline/debuglevel/phonenumber-microservice?label=GitLab%20build)
![GitHub release (latest SemVer)](https://img.shields.io/github/v/release/debuglevel/phonenumber-microservice?sort=semver)
![GitHub](https://img.shields.io/github/license/debuglevel/phonenumber-microservice)

# Phonenumber Microservice
This microservice applies various operations (well, only formatting them at the moment) on phone numbers.

# HTTP API

## Swagger / OpenAPI
There is an OpenAPI (former: Swagger) specification created, which is available at <http://localhost:8080/swagger/phonenumber-microservice-0.1.0.yml> (or somewhere in the jar file). It can easily be pasted into the [Swagger Editor](https://editor.swagger.io) which provides a live demo for [Swagger UI](https://swagger.io/tools/swagger-ui/), but also offers to create client libraries via [Swagger Codegen](https://swagger.io/tools/swagger-codegen/).

## Format phone number
To format a phone number, it has to be POSTed as JSON payload in the body to the service
```shell script
$ curl -X POST -d '{"phonenumber":"0921123456789"}' -H "Content-Type: application/json" -H "Accept: application/json" http://localhost:8080/format/
```
which produces this JSON response
```json
{
  "phonenumber" : "0921123456789",
  "formattedPhonenumber" : "+49 (921) 123456789"
}
```

There is no GET method because passing phone numbers leads just to too much problems; e.g. the plus in "+49" is " 49" in URL encoding, the slash in "030/1234" is interpreted as path separator, and some frameworks or proxies encode/interpret those characters wrong, twice, nothing at all et cetera. Submitting them as JSON payload reduces this lack of clarity.      

## Geocode phone number
To get the location of a phone number, it has to be POSTed as JSON payload in the body to the service
```shell script
$ curl -X POST -d '{"phonenumber":"0721123456789"}' -H "Content-Type: application/json" -H "Accept: application/json" http://localhost:8080/geocode/
```
which produces this JSON response
```json
{
  "phonenumber" : "0721123456789",
  "location" : "Karlsruhe"
}
```

## Get combined information for phone number
Get all above information in a single request:
* Format a phone number
* Geocode a phone number

To get the information of a phone number, it has to be POSTed as JSON payload in the body to the service
```shell script
$ curl -X POST -d '{"phonenumber":"0721123456789"}' -H "Content-Type: application/json" -H "Accept: application/json" http://localhost:8080/information/
```
which produces this JSON response
```json
{
  "phonenumber" : "0721123456789",
  "formattedPhonenumber" : "+49 (921) 123456789",
  "location" : "Karlsruhe"
}
```

# Configuration
There is a `application.yml` included in the jar file. Its content can be modified and saved as a separate `application.yml` on the level of the jar file. Configuration can also be applied via the other supported ways of Micronaut (see <https://docs.micronaut.io/latest/guide/index.html#config>). For Docker, the configuration via environment variables is the most interesting one (see `docker-compose.yml`).
