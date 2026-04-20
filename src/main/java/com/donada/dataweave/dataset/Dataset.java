package com.donada.dataweave.dataset;

import java.util.List;

public record Dataset (
        String name,
        List<FieldDefinition> fields
) { }
