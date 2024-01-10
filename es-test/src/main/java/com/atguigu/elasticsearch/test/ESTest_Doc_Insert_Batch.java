package com.atguigu.elasticsearch.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

/**
 * @Author：huahua
 * @Date：2023/11/3 16:04
 * 批量插入数据
 */
public class ESTest_Doc_Insert_Batch {
    public static void main(String[] args) throws Exception {
        //创建es客户端
        RestHighLevelClient esClient=new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );
        //批量插入数据
        BulkRequest request = new BulkRequest();

        request.add(new IndexRequest().index("user").id("1001").source(XContentType.JSON,"name","zhangsan","age",10));
        request.add(new IndexRequest().index("user").id("1002").source(XContentType.JSON,"name","lisi","age",10));
        request.add(new IndexRequest().index("user").id("1003").source(XContentType.JSON,"name","wangwu","age",10));
        request.add(new IndexRequest().index("user").id("1004").source(XContentType.JSON,"name","wangwu2","age",20));
        request.add(new IndexRequest().index("user").id("1005").source(XContentType.JSON,"name","wangwu3","age",30));
        request.add(new IndexRequest().index("user").id("1006").source(XContentType.JSON,"name","wangwu4","age",40));
        request.add(new IndexRequest().index("user").id("1007").source(XContentType.JSON,"name","wangwu5","age",50));
        request.add(new IndexRequest().index("user").id("1008").source(XContentType.JSON,"name","wangwu6","age",60));

        BulkResponse response = esClient.bulk(request, RequestOptions.DEFAULT);
        System.out.println(response.getTook());
        System.out.println(response.getIngestTook());
        //关闭es客户端
        esClient.close();
    }
}
