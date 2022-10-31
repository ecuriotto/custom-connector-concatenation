package io.camunda.connector;

import io.camunda.connector.api.annotation.OutboundConnector;
import io.camunda.connector.api.outbound.OutboundConnectorContext;
import io.camunda.connector.api.outbound.OutboundConnectorFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@OutboundConnector(
    name = "concatenation-connector",
    inputVariables = {"input1", "input2"},
    type = "io.camunda:concatenation-api:1")
public class ConcatenationConnectorFunction implements OutboundConnectorFunction {

  private static final Logger LOGGER = LoggerFactory.getLogger(ConcatenationConnectorFunction.class);

  @Override
  public Object execute(OutboundConnectorContext context) throws Exception {
    var connectorRequest = context.getVariablesAsType(ConcatenationConnectorRequest.class);
    return executeConnector(connectorRequest);
  }

  private ConcatenationConnectorResult executeConnector(final ConcatenationConnectorRequest connectorRequest) {

    LOGGER.info("Executing my connector with request {}", connectorRequest);
    String concatenationResult = connectorRequest.getInput1() + " " +connectorRequest.getInput2();
    var result = new ConcatenationConnectorResult();
    result.setConcatenationResult("Result of concatenation: " + concatenationResult);
    return result;
  }
}
