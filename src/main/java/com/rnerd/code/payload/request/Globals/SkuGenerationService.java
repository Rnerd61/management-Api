package com.rnerd.code.payload.request.Globals;

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


}
