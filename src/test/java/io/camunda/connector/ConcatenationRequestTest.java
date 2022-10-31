package io.camunda.connector;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import io.camunda.connector.impl.ConnectorInputException;
import io.camunda.connector.test.outbound.OutboundConnectorContextBuilder;
import org.junit.jupiter.api.Test;

public class ConcatenationRequestTest {

  @Test
  void shouldFailWhenValidate_NoInput1() {
    // given
    var input = new ConcatenationConnectorRequest();

    input.setInput2("my_input2");

    var context = OutboundConnectorContextBuilder.create().build();
    // when
    assertThatThrownBy(() -> context.validate(input))
      // then
      .isInstanceOf(ConnectorInputException.class)
      .hasMessageContaining("input1");
  }

  @Test
  void shouldFailWhenValidate_NoInput2() {
    // given
    var input = new ConcatenationConnectorRequest();

    input.setInput1("my_input1");
    var context = OutboundConnectorContextBuilder.create().build();
    // when
    assertThatThrownBy(() -> context.validate(input))
      // then
      .isInstanceOf(ConnectorInputException.class)
      .hasMessageContaining("input2");
  }


}