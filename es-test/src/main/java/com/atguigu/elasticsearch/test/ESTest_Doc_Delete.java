package com.atguigu.elasticsearch.test;

import org.apache.http.HttpHost;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

/**
 * @Author：huahua
 * @Date：2023/11/3 16:04
 * 删除数据
 */
public class ESTest_Doc_Delete {
    public static void main(String[] args) throws Exception {
        //创建es客户端
        RestHighLevelClient esClient=new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );
        DeleteRequest request = new DeleteRequest();
        request.index("user").id("1001");
        DeleteResponse response = esClient.delete(request, RequestOptions.DEFAULT);
        System.out.println(response.toString());
        //关闭es客户端
        esClient.close();
    }
}
