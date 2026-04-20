package com.donada.dataweave.dataset;

public record FieldDefinition(
        String name,
        FieldType type,
        boolean required,
        boolean unique,
        boolean indexed
) {
}
