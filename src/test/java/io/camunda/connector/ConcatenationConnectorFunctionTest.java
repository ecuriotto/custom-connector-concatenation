package io.camunda.connector;

import static org.assertj.core.api.Assertions.assertThat;

import io.camunda.connector.test.outbound.OutboundConnectorContextBuilder;
import org.junit.jupiter.api.Test;

public class ConcatenationConnectorFunctionTest {

  @Test
  void shouldReturnReceivedMessageWhenExecute() throws Exception {
    // given
    var input = new ConcatenationConnectorRequest();

    input.setInput1("my_input1_value");
    input.setInput2("my_input2_value");
    var function = new ConcatenationConnectorFunction();
    var context = OutboundConnectorContextBuilder.create()
      .variables(input)
      .build();
    // when
    var result = function.execute(context);
    // then
    assertThat(result)
      .isInstanceOf(ConcatenationConnectorResult.class)
      .extracting("concatenationResult")
      .isEqualTo("Result of concatenation: my_input1_value my_input2_value");
  }
  /*
   * {"input1":"hello","input2":"world"}
   */
}