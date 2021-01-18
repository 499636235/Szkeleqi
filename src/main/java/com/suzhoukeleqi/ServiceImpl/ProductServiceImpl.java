package com.suzhoukeleqi.ServiceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suzhoukeleqi.Mapper.ProductMapper;
import com.suzhoukeleqi.Service.ProductService;
import com.suzhoukeleqi.Utils.PageUtils;
import com.suzhoukeleqi.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Product selectProductById(int id) {
        return productMapper.selectProductById(id);
    }

    @Override
    public List<ProductListItem> selectProductListByListId(int listid) {
        return productMapper.selectProductListByListId(listid);
    }


    @Override
    public PageResult selectProductListByclass1(PageRequest pageRequest, String class1) {
        ProductMapperRequest object = new ProductMapperRequest();
        object.setClass1(class1);
        return PageUtils.getPageResult(getPageInfo(pageRequest, "selectProductListByclass1", object));
    }

    @Override
    public PageResult selectProductListByclass2(PageRequest pageRequest, String class2) {
        ProductMapperRequest object = new ProductMapperRequest();
        object.setClass1(class2);
        return PageUtils.getPageResult(getPageInfo(pageRequest, "selectProductListByclass2", object));
    }

    @Override
    public List<ProductListItem> selectAllProducts() {
        return productMapper.selectAllProducts();
    }

    @Override
    public PageResult selectAllProductsPages(PageRequest pageRequest) {
        ProductMapperRequest object = new ProductMapperRequest();
        return PageUtils.getPageResult(getPageInfo(pageRequest, "selectAllProductsPages", object));
    }


    @Override
    public List<Product> selectAllFromProduct() {
        return productMapper.selectAllFromProduct();
    }

    /**
     * 分页查询全部产品
     *
     * @param pageRequest
     * @return
     */
    @Override
    public PageResult selectPagesFromProduct(PageRequest pageRequest) {
        ProductMapperRequest object = new ProductMapperRequest();
        return PageUtils.getPageResult(getPageInfo(pageRequest, "selectPagesFromProduct", object));

    }


    /**
     * (通用)调用分页插件完成分页
     * 通过反射调用 Mapper 的方法，减少代码
     *
     * @param pageRequest
     * @return
     */
    private PageInfo<?> getPageInfo(PageRequest pageRequest, String methodname, Object object) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        Method method = null;
        try {
            method = productMapper.getClass().getDeclaredMethod(methodname, object.getClass());
            PageHelper.startPage(pageNum, pageSize);
            List<?> resultList = (List<?>) method.invoke(productMapper, object);
            return new PageInfo<>(resultList);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }
}
