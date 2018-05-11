# Simple weather api and web app

Project has two parts. First is spring-boot based api that fetches weather information from external weather source and serves it through its API as JSON. Second is the web app that uses the API to display the weather to the user.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

- Java 8 SDK
- Maven 3.x
- Node 10.x and npm 5.x
- OpenWeather Api-key https://openweathermap.org/
- Google Maps Api-key with geolocation enabled, can be obtained for free from Google Console Api

### Installing

After cloning the repository, the apikeys need to be provided to the api.

Go to api-resources directory, create file named apikeys.properties and insert the apikeys 

```bash
$ cd api/src/main/resources
$ echo openWeather.apiKey=youropenweatherapikey >> apikeys.properties
$ echo googleMaps.apiKey=yourgoogleapikey >> apikeys.properties
```

To install webapp dependencies, go to web-directory and run npm install

```bash
$ cd web
$ npm install
```

### Development environment
Start the api. Api runs on port 8080.

```bash
$ cd api
$ mvn spring-boot:run
netty listening on http://localhost:8080
```

Start the web app development server. Development server runs on port 3000.

```bash
$ cd web
$ npm start
webpack-dev-server listening on http://localhost:3000
```

## Running the tests

To run test suite, go to api-directory and run tests with maven

```bash
$ cd api
$ mvn test
```

## Deployment

To make deployment build of the api, go to the api-directory and run mvn package. 

```bash
$ cd api
$ mvn package

and to run

$ jar tvf target/weatherapi-0.0.1-SNAPSHOT.jar-0.0.1-SNAPSHOT.jar
```

To make deployment build of the web-app, go to web-directory, run npm build and grab the contents of web/dist -directory to served on your favourite http-server.

```bash
$ cd web
$ npm build
$ cd dist
publish!
```

## Authors

- **Kalle Moilanen**

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details
