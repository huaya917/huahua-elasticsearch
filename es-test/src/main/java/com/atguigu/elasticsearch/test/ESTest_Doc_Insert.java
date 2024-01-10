package com.atguigu.elasticsearch.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

/**
 * @Author：huahua
 * @Date：2023/11/3 16:04
 * 插入数据
 */
public class ESTest_Doc_Insert {
    public static void main(String[] args) throws Exception {
        //创建es客户端
        RestHighLevelClient esClient=new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );
        //插入数据
        IndexRequest request = new IndexRequest();
        request.index("user").id("1001");

        //准备数据源
        User user=new User();
        user.setName("zhangsan");
        user.setSex("男");
        user.setAge(30);
        //向es中插入数据，数据必须是json格式
        ObjectMapper mapper=new ObjectMapper();
        String userJson = mapper.writeValueAsString(user);
        //设置数据源
        request.source(userJson, XContentType.JSON);

        IndexResponse response = esClient.index(request, RequestOptions.DEFAULT);
        //操作状态
        System.out.println(response.getResult());
        //关闭es客户端
        esClient.close();
    }
}
