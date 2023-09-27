package com.campusdual.appmazing.service;

import com.campusdual.appmazing.api.IProductService;
import com.campusdual.appmazing.model.Product;
import com.campusdual.appmazing.model.dao.ProductDao;
import com.campusdual.appmazing.model.dto.ProductDTO;
import com.campusdual.appmazing.model.dto.dtomapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("ProductService")
@Lazy
public class ProductService implements IProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public ProductDTO queryProduct(ProductDTO ProductDTO) {
        Product product = ProductMapper.INSTANCE.toEntity(ProductDTO);
        Product productFinal = this.productDao.getReferenceById(product.getId());
        ProductDTO dto = ProductMapper.INSTANCE.toDTO(productFinal);
        return dto;
    }

    @Override
    public List<ProductDTO> queryAllProducts() {
        return null;
    }

    @Override
    public int insertProduct(ProductDTO product) {
        return 0;
    }

    @Override
    public int updateProduct(ProductDTO product) {
        return 0;
    }

    @Override
    public int deleteProduct(ProductDTO product) {
        return 0;
    }
}
