/**
 * Copyright 2018 LinkedIn Corporation. All rights reserved.
 * Licensed under the BSD-2 Clause license.
 * See LICENSE in the project root for license information.
 */
package com.linkedin.transport.examples.avro;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.apache.avro.Schema;
import org.testng.annotations.Test;

import static com.linkedin.transport.avro.common.AssertAvroUdf.*;
import static com.linkedin.transport.avro.common.SchemaFactory.*;


public class TestMapValuesFunctionWrapper {
  @Test
  public void testMapValues() {
    assertFunction(new MapValuesFunctionWrapper(), new Schema[]{map(STRING, INTEGER)},
        new Object[]{ImmutableMap.of("1", 4, "2", 5, "3", 6)}, ImmutableList.of(4, 5, 6));

    assertFunction(new MapValuesFunctionWrapper(), new Schema[]{map(STRING, STRING)},
        new Object[]{ImmutableMap.of("1", "4", "2", "5", "3", "6")}, ImmutableList.of("4", "5", "6"));

    assertFunction(new MapValuesFunctionWrapper(), new Schema[]{map(STRING, STRING)}, new Object[]{null}, null);
  }
}
