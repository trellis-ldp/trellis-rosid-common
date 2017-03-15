/*
 * Copyright Amherst College
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package edu.amherst.acdc.trellis.rosid.common;

import java.util.Map;

import org.apache.commons.rdf.api.Dataset;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serializer;


/**
 * @author acoburn
 */
public class DatasetSerde implements Serde<Dataset> {

    private final DatasetSerialization serde = new DatasetSerialization();

    @Override
    public void configure(final Map<String, ?> map, final boolean isKey) {
        serde.configure(map, isKey);
    }

    @Override
    public Serializer<Dataset> serializer() {
        return serde;
    }

    @Override
    public Deserializer<Dataset> deserializer() {
        return serde;
    }

    @Override
    public void close() {
        serde.close();
    }
}