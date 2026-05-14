package com.donada.dataweave.dataset;

public record FieldDefinition(
        String name,
        FieldType dataType,
        String varcharSize, // Only relevant for STRING type, can be null for other types
        boolean required,
        boolean unique,
        boolean indexed
) {
}
