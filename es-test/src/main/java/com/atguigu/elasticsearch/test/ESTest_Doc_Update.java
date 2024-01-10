package com.atguigu.elasticsearch.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

/**
 * @Author：huahua
 * @Date：2023/11/3 16:04
 * 修改数据
 */
public class ESTest_Doc_Update {
    public static void main(String[] args) throws Exception {
        //创建es客户端
        RestHighLevelClient esClient=new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );
        //修改数据
        UpdateRequest request = new UpdateRequest();
        request.index("user").id("1001");
        request.doc(XContentType.JSON,"sex","女");
        UpdateResponse response = esClient.update(request, RequestOptions.DEFAULT);
        //操作状态
        System.out.println(response.getResult());
        //关闭es客户端
        esClient.close();
    }
}
