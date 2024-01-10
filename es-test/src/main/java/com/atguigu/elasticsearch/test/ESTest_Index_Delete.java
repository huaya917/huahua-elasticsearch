package com.atguigu.elasticsearch.test;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;

/**
 * @Author：huahua
 * @Date：2023/11/3 16:04
 * 删除数据
 */
public class ESTest_Index_Delete {
    public static void main(String[] args) throws Exception {
        //创建es客户端
        RestHighLevelClient esClient=new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );
        //删除索引
        DeleteIndexRequest user = new DeleteIndexRequest("user");
        AcknowledgedResponse delete = esClient.indices().delete(user, RequestOptions.DEFAULT);
        System.out.println("响应结果："+delete);
        //关闭es客户端
        esClient.close();
    }
}
