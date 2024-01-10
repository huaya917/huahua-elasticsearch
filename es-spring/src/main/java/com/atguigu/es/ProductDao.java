package com.atguigu.es;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author：huahua
 * @Date：2023/11/6 16:55
 */
@Repository
public interface ProductDao  extends ElasticsearchRepository<Product,Long> {
}
