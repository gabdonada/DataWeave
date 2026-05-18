package com.donada.dataweave.api;

import com.donada.dataweave.dataset.Dataset;
import com.donada.dataweave.dataset.IDatasetService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/datasets")
public class DatasetController {
    private final IDatasetService datasetService;

    public DatasetController(IDatasetService datasetService) {
        this.datasetService = datasetService;
    }

    @PostMapping("/create")
    public void createDataset(Dataset dataset) {
        datasetService.createDataset(dataset);
    }
}
