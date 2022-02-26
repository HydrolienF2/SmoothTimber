package net.sourcewriters.smoothtimber.api.data.json;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.syntaxphoenix.syntaxapi.json.JsonObject;
import com.syntaxphoenix.syntaxapi.json.JsonValue;
import com.syntaxphoenix.syntaxapi.json.ValueType;
import com.syntaxphoenix.syntaxapi.json.io.JsonParser;
import com.syntaxphoenix.syntaxapi.json.io.JsonSyntaxException;
import com.syntaxphoenix.syntaxapi.json.io.JsonWriter;

import net.sourcewriters.smoothtimber.api.data.AbstractDataFactory;
import net.sourcewriters.smoothtimber.api.data.IDataAdapterRegistry;
import net.sourcewriters.smoothtimber.api.data.IDataContainer;

@SuppressWarnings("rawtypes")
public final class JsonFactory extends AbstractDataFactory<JsonValue> {

    private final JsonParser parser = new JsonParser();
    private final JsonWriter writer = new JsonWriter().setPretty(true).setSpaces(true).setIndent(4);

    public JsonFactory(final IDataAdapterRegistry<JsonValue> registry) {
        super(registry);
    }

    public JsonParser getParser() {
        return parser;
    }

    public JsonWriter getWriter() {
        return writer;
    }

    @Override
    public JsonFactory toFile(final IDataContainer container, final File file) throws IOException {
        writer.toFile(JsonAdapter.toJsonObject(registry, container), file);
        return this;
    }

    @Override
    public JsonFactory toStream(final IDataContainer container, final OutputStream stream) throws IOException {
        writer.toStream(JsonAdapter.toJsonObject(registry, container), stream);
        return this;
    }

    @Override
    public JsonFactory toString(final IDataContainer container, final StringBuilder builder) throws IOException {
        builder.append(writer.toString(JsonAdapter.toJsonObject(registry, container)));
        return this;
    }

    @Override
    public JsonFactory fromFile(final IDataContainer rawContainer, final File file) throws IOException, JsonSyntaxException {
        if (!(rawContainer instanceof JsonContainer)) {
            throw new IllegalArgumentException("Unsupported container type: " + rawContainer.getClass().getSimpleName());
        }
        final JsonContainer container = (JsonContainer) rawContainer;
        final JsonValue<?> value = parser.fromFile(file);
        if (value == null || !value.hasType(ValueType.OBJECT)) {
            return this;
        }
        container.setRoot((JsonObject) value);
        return this;
    }

    @Override
    public JsonFactory fromStream(final IDataContainer rawContainer, final InputStream stream) throws IOException, JsonSyntaxException {
        if (!(rawContainer instanceof JsonContainer)) {
            throw new IllegalArgumentException("Unsupported container type: " + rawContainer.getClass().getSimpleName());
        }
        final JsonContainer container = (JsonContainer) rawContainer;
        final JsonValue<?> value = parser.fromStream(stream);
        if (value == null || !value.hasType(ValueType.OBJECT)) {
            return this;
        }
        container.setRoot((JsonObject) value);
        return this;
    }

    @Override
    public JsonFactory fromString(final IDataContainer rawContainer, final String string) throws IOException, JsonSyntaxException {
        if (!(rawContainer instanceof JsonContainer)) {
            throw new IllegalArgumentException("Unsupported container type: " + rawContainer.getClass().getSimpleName());
        }
        final JsonContainer container = (JsonContainer) rawContainer;
        final JsonValue<?> value = parser.fromString(string);
        if (value == null || !value.hasType(ValueType.OBJECT)) {
            return this;
        }
        container.setRoot((JsonObject) value);
        return this;
    }

}
