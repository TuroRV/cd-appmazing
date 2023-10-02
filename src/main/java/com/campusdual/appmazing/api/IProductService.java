package com.campusdual.appmazing.api;

import com.campusdual.appmazing.model.dto.ProductDTO;

import java.math.BigDecimal;
import java.util.List;

public interface IProductService {
    public ProductDTO queryProduct (ProductDTO ProductDTO);
    List<ProductDTO> queryAllProducts();
    int insertProduct (ProductDTO productDTO);
    int updateProduct(ProductDTO productDTO);
    int deleteProduct(ProductDTO productDTO);
    int buyProduct(ProductDTO product, int quantity);
    BigDecimal calculateTotalPrice(ProductDTO product,int quantity);

}
