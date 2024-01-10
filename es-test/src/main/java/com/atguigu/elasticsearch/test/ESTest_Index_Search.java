package com.atguigu.elasticsearch.test;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;

/**
 * @Author：huahua
 * @Date：2023/11/3 16:04
 * 查询数据
 */
public class ESTest_Index_Search {
    public static void main(String[] args) throws Exception {
        //创建es客户端
        RestHighLevelClient esClient=new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );
        //查询索引
        GetIndexRequest user = new GetIndexRequest("user");
        GetIndexResponse getIndexResponse = esClient.indices().get(user, RequestOptions.DEFAULT);
        //响应状态
        System.out.println( getIndexResponse.getAliases());
        System.out.println( getIndexResponse.getMappings());
        System.out.println( getIndexResponse.getSettings());
        //关闭es客户端
        esClient.close();
    }
}
