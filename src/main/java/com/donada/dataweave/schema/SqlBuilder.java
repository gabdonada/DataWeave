package com.donada.dataweave.schema;

import com.donada.dataweave.dataset.Dataset;
import com.donada.dataweave.dataset.FieldDefinition;
import org.springframework.stereotype.Component;

@Component
public class SqlBuilder {
    // This class should not execute SQLs

    public String buildCreateTable(Dataset dataset){
        String generatedSQL = String.format("CREATE TABLE %s (", dataset.name());
        for (var field : dataset.fields()) {
            generatedSQL += String.format("%s %s, ", field.name(), mapDataType(field));
        }
        generatedSQL = generatedSQL.substring(0, generatedSQL.length() - 2) + ")";
        return generatedSQL;
    }

    private String mapDataType(FieldDefinition field){
        return switch (field.dataType()) {
            case STRING -> {
                if (field.varcharSize() == null || field.varcharSize().isEmpty()) {
                    throw new IllegalArgumentException("VARCHAR size must be specified for STRING type");
                } else {
                    yield "VARCHAR(%s)".formatted(field.varcharSize());
                }
            }
            case NUMBER -> "INT";
            case BOOLEAN -> "BOOLEAN";
            case DATE -> "DATE";
            case TIMESTAMP -> "TIMESTAMP";
            case LONG -> "BIGINT";
        };
    }

}
