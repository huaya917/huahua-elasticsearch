package com.atguigu.elasticsearch.test;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

/**
 * @Author：huahua
 * @Date：2023/11/3 16:04
 */
public class ESTest_Client {
    public static void main(String[] args) throws Exception {
        //创建es客户端
        RestHighLevelClient esClient=new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );

        //关闭es客户端
        esClient.close();
    }
}
