package com.donada.dataweave.schema;

import com.donada.dataweave.dataset.Dataset;
import org.springframework.stereotype.Component;

@Component
public class SqlBuilder {

    // This class should not execute SQLs

    public String buildCreateTable(Dataset dataset){
        // Should generate SQL statement to create a table based on the dataset schema
        return "";
    }

    private String mapDataType(String dataType){
        // Should map dataset data types to SQL data types
        return "";
    }

}
