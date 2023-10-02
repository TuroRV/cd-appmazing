package com.campusdual.appmazing.service;

import com.campusdual.appmazing.api.IProductService;
import com.campusdual.appmazing.model.Product;
import com.campusdual.appmazing.model.dao.ProductDao;
import com.campusdual.appmazing.model.dto.ProductDTO;
import com.campusdual.appmazing.model.dto.dtomapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
        return ProductMapper.INSTANCE.toDTOList(this.productDao.findAll());
    }

    @Override
    public int insertProduct(ProductDTO productDTO) {
        Product product = ProductMapper.INSTANCE.toEntity(productDTO);
        this.productDao.saveAndFlush(product);
        return product.getId();
    }

    @Override
    public int updateProduct(ProductDTO productDTO) {
        return this.insertProduct(productDTO);
    }

    @Override
    public int deleteProduct(ProductDTO productDTO) {
        int id = productDTO.getId();
        Product product = ProductMapper.INSTANCE.toEntity(productDTO);
        this.productDao.delete(product);
        return id;
    }
    @Override
    public int buyProduct(ProductDTO product, int quantity){
        ProductDTO productToBuy = this.queryProduct(product);
        if (productToBuy.isActive() && quantity <= productToBuy.getStock()) {
            productToBuy.setStock(productToBuy.getStock() - quantity);
            this.updateProduct(productToBuy);
        }
        return productToBuy.getStock();
    }
@Override
    public BigDecimal calculateTotalPrice (ProductDTO product, int quantity){
        ProductDTO productToBuy = this.queryProduct(product);
        return productToBuy.getPrice().multiply(BigDecimal.valueOf(quantity));

    }

}
