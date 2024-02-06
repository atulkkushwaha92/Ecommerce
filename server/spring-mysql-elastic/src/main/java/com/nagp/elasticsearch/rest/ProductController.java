package com.nagp.elasticsearch.rest;
import com.nagp.elasticsearch.model.dto.ProductDTO;
import com.nagp.elasticsearch.service.IProductService;
import com.nagp.elasticsearch.utils.PathResources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(PathResources.PRODUCT)
public class ProductController {

    private final IProductService productService;

    @Autowired
    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @PostMapping(PathResources.SAVE)
    public ResponseEntity<ProductDTO> saveUser(@RequestBody ProductDTO productDTO) {
        return new ResponseEntity<>(this.productService.save(productDTO), HttpStatus.OK);
    }

    @GetMapping(PathResources.FIND_ONE + "/{" + PathResources.ID + "}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Integer id) {
        return new ResponseEntity<>(this.productService.findById(id), HttpStatus.OK);
    }

    @GetMapping(PathResources.FIND_ALL)
    public ResponseEntity<List<ProductDTO>> findById() {
        return new ResponseEntity<>(this.productService.findAll(), HttpStatus.OK);
    }
}
