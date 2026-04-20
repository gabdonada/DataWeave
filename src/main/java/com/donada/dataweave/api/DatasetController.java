package com.donada.dataweave.api;

import com.donada.dataweave.dataset.Dataset;
import com.donada.dataweave.dataset.DatasetService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/datasets")
public class DatasetController {
    private final DatasetService datasetService;

    public DatasetController(DatasetService datasetService) {
        this.datasetService = datasetService;
    }

    @PostMapping
    public void createDataset(Dataset dataset) {
        datasetService.createDataset(dataset);
    }
}
