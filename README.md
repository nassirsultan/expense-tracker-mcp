# Expense Tracker MCP Server

An MCP (Model Context Protocol) server built with Java 21 and Spring Boot that lets Claude track expenses through natural language, e.g. "Add ₹250 for lunch".

## Tech stack

Java 21, Spring Boot 3.5.x, Spring AI MCP Server (stdio), Maven

## Build and run

Requires JDK 21.

```bash
mvn clean package -DskipTests
npx @modelcontextprotocol/inspector java -jar target/expense-tracker-mcp-0.0.1-SNAPSHOT.jar
```
