package com.donada.dataweave.dataset;

import com.donada.dataweave.schema.SchemaManager;
import com.donada.dataweave.schema.SqlBuilder;
import org.springframework.stereotype.Service;

@Service
public class DatasetServiceImpl implements IDatasetService {
    // this class should coordinate the flow, apply business rules and call components - Should not execute SQL or build it

    private final SqlBuilder sqlBuilder;
    private final SchemaManager schemaManager;

    public DatasetServiceImpl(SqlBuilder sqlBuilder, SchemaManager schemaManager) {
        this.sqlBuilder = sqlBuilder;
        this.schemaManager = schemaManager;
    }

    @Override
    public void createDataset(Dataset dataset) {
        String sql = sqlBuilder.buildCreateTable(dataset);
        schemaManager.createTable(sql);
    }
}
