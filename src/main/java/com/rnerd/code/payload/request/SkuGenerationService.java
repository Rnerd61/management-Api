package com.rnerd.code.payload.request;

import com.rnerd.code.models.Globals.SpareParts;
import com.rnerd.code.repository.Global.SparePartsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkuGenerationService {

    private final SparePartsRepo sparePartsRepo;

    @Autowired
    public SkuGenerationService(SparePartsRepo sparePartsRepo) {
        this.sparePartsRepo = sparePartsRepo;
    }

    public String generateSku(SpareParts spareParts) {
        // Extract the first 4 letters of manufacturer, partType, and model
        String manufacturerPrefix = spareParts.getManufacturer().substring(0, Math.min(spareParts.getManufacturer().length(), 4));
        String partTypePrefix = spareParts.getPartType().substring(0, Math.min(spareParts.getPartType().length(), 4));
        String modelPrefix = spareParts.getModel().substring(0, Math.min(spareParts.getModel().length(), 4));

        // Combine the prefixes to create the base SKU
        String baseSku = manufacturerPrefix + "-" + partTypePrefix + "-" + modelPrefix;

        // Check if a SKU with this base already exists
        long count = sparePartsRepo.countBySkuStartingWith(baseSku);

        // If there are clashes, append a number
        if (count > 0) {
            return baseSku + "-" + (count + 1);
        } else {
            return baseSku;
        }
    }
}
