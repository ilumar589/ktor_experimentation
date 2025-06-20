# ko-digital-trainsystem

A good starting tutorial: https://www.youtube.com/watch?v=tstB08EDClw&t=65s

auto-reaload : ./gradlew -t build -x test -i then run the application normally


This project was created using the [Ktor Project Generator](https://start.ktor.io).

Here are some useful links to get you started:

- [Ktor Documentation](https://ktor.io/docs/home.html)
- [Ktor GitHub page](https://github.com/ktorio/ktor)
- The [Ktor Slack chat](https://app.slack.com/client/T09229ZC6/C0A974TJ9). You'll need to [request an invite](https://surveys.jetbrains.com/s3/kotlin-slack-sign-up) to join.

## Features

Here's a list of features included in this project:

| Name                                                                   | Description                                                                        |
| ------------------------------------------------------------------------|------------------------------------------------------------------------------------ |
| [Task Scheduling](https://start.ktor.io/p/ktor-server-task-scheduling) | Manages scheduled tasks across instances of your distributed Ktor server           |
| [Kafka](https://start.ktor.io/p/ktor-server-kafka)                     | Adds Kafka support to your application                                             |
| [Routing](https://start.ktor.io/p/routing)                             | Provides a structured routing DSL                                                  |
| [kotlinx.serialization](https://start.ktor.io/p/kotlinx-serialization) | Handles JSON serialization using kotlinx.serialization library                     |
| [Content Negotiation](https://start.ktor.io/p/content-negotiation)     | Provides automatic content conversion according to Content-Type and Accept headers |
| [Postgres](https://start.ktor.io/p/postgres)                           | Adds Postgres database to your application                                         |
| [Exposed](https://start.ktor.io/p/exposed)                             | Adds Exposed database to your application                                          |
| [HTML DSL](https://start.ktor.io/p/html-dsl)                           | Generates HTML from Kotlin DSL                                                     |
| [HTMX](https://start.ktor.io/p/htmx)                                   | Includes HTMX for front-end scripting                                              |
| [CSS DSL](https://start.ktor.io/p/css-dsl)                             | Generates CSS from Kotlin DSL                                                      |
| [Server-Sent Events (SSE)](https://start.ktor.io/p/sse)                | Support for server push events                                                     |
| [Status Pages](https://start.ktor.io/p/status-pages)                   | Provides exception handling for routes                                             |
| [Static Content](https://start.ktor.io/p/static-content)               | Serves static files from defined locations                                         |
| [Sessions](https://start.ktor.io/p/ktor-sessions)                      | Adds support for persistent sessions through cookies or headers                    |
| [Partial Content](https://start.ktor.io/p/partial-content)             | Handles requests with the Range header                                             |
| [Forwarded Headers](https://start.ktor.io/p/forwarded-header-support)  | Allows handling proxied headers (X-Forwarded-*)                                    |
| [Default Headers](https://start.ktor.io/p/default-headers)             | Adds a default set of headers to HTTP responses                                    |
| [Compression](https://start.ktor.io/p/compression)                     | Compresses responses using encoding algorithms like GZIP                           |
| [Caching Headers](https://start.ktor.io/p/caching-headers)             | Provides options for responding with standard cache-control headers                |

## Structure

This project includes the following modules:

| Path             | Description                              |
| ------------------|------------------------------------------ |
| [server](server) | A runnable Ktor server implementation    |
| [web](web)       | Front-end Kotlin scripts for the browser |

## Building

To build the project, use one of the following tasks:

| Task                                            | Description                                                          |
| -------------------------------------------------|---------------------------------------------------------------------- |
| `./gradlew build`                               | Build everything                                                     |
| `./gradlew :server:buildFatJar`                 | Build an executable JAR of the server with all dependencies included |
| `./gradlew :server:buildImage`                  | Build the docker image to use with the fat JAR                       |
| `./gradlew :server:publishImageToLocalRegistry` | Publish the docker image locally                                     |
| `./gradlew -t :web:build`                       | Build WASM scripts continuously                                      |

## Running

To run the project, use one of the following tasks:

| Task                                 | Description                            |
| --------------------------------------|---------------------------------------- |
| `./gradlew :server:run`              | Run the server                         |
| `./gradlew :server:runDocker`        | Run using the local docker image       |
| `./gradlew -t :web:wasmJsBrowserRun` | Run scripts in a browser, without Ktor |

If the server starts successfully, you'll see the following output:

```
2024-12-04 14:32:45.584 [main] INFO  Application - Application started in 0.303 seconds.
2024-12-04 14:32:45.682 [main] INFO  Application - Responding at http://0.0.0.0:8080
```

