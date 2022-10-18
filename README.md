


# Concatenation Connector

Simple showcase connector that performs a concatenation

## Build

```bash
mvn clean package
```

## API

### Input

```json
{
  "input1": ".....",
  "input2": "....."
}
```

### Output

```json
{
  "result": {
    "concatenationResult": "....."
  }
}
```

## Test locally

Run unit tests

```bash
mvn clean verify
```

Use the [Camunda Job Worker Connector Run-Time](https://github.com/camunda/connector-framework/tree/main/runtime-job-worker) to run your function as a local Job Worker.

## Element Template

The element templates can be found in the [element-templates/template-connector.json](element-templates/template-connector.json) file.
