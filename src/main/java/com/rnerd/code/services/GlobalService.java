package com.rnerd.code.services;

import com.rnerd.code.models.Globals.Products;
import com.rnerd.code.models.Globals.SpareParts;
import com.rnerd.code.repository.Global.ProductsRepo;
import com.rnerd.code.repository.Global.SparePartsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GlobalService {

    private final ProductsRepo productsRepo;
    private final SparePartsRepo sparePartsRepo;

    public List<Products> getAllProductsService(Integer pageNumber){
        int page = pageNumber;
        int pageSize = 10;
        Sort sort = Sort.by(Sort.Direction.DESC, "releaseDate");


        PageRequest pageRequest = PageRequest.of(page, pageSize, sort);
        Page<Products> resultPage = productsRepo.findAll(pageRequest);
        return resultPage.getContent();

    }

    public Products getProductService(String skuid){
        return productsRepo.findBySkuid(skuid);
    }

    public List<SpareParts> getAllPartsService(Integer pageNumber){
        int page = pageNumber;
        int pageSize = 10;
        Sort sort = Sort.by(Sort.Direction.DESC, "name");


        PageRequest pageRequest = PageRequest.of(page, pageSize, sort);
        Page<SpareParts> resultPage = sparePartsRepo.findAll(pageRequest);
        return resultPage.getContent();

    }

    public SpareParts getPartsService(String skuid){
        return sparePartsRepo.findBySkuid(skuid);
    }

}
