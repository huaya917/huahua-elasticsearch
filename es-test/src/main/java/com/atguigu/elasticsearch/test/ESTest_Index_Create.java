package com.atguigu.elasticsearch.test;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;

/**
 * @Author：huahua
 * @Date：2023/11/3 16:04
 * 创建索引
 */
public class ESTest_Index_Create {
    public static void main(String[] args) throws Exception {
        //创建es客户端
        RestHighLevelClient esClient=new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );
        //创建索引
        CreateIndexRequest user = new CreateIndexRequest("user");
        CreateIndexResponse createIndexResponse = esClient.indices().create(user, RequestOptions.DEFAULT);
        //响应状态
        boolean acknowledged = createIndexResponse.isAcknowledged();
        System.out.println("索引操作："+acknowledged);
        //关闭es客户端
        esClient.close();
    }
}
