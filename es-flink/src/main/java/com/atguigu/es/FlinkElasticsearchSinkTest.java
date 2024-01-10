package com.atguigu.es;

import org.apache.flink.api.common.functions.RuntimeContext;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.elasticsearch.ElasticsearchSinkFunction;
import org.apache.flink.streaming.connectors.elasticsearch.RequestIndexer;
import org.apache.flink.streaming.connectors.elasticsearch7.ElasticsearchSink;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.Requests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author：huahua
 * @Date：2023/11/6 19:07
 */
public class FlinkElasticsearchSinkTest {

    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env =StreamExecutionEnvironment.getExecutionEnvironment();
        DataStreamSource<String> source = env.socketTextStream("localhost", 9999);
        List<HttpHost> httpHosts = new ArrayList<>();
        httpHosts.add(new HttpHost("127.0.0.1", 9200, "http"));
        ElasticsearchSink.Builder<String> esSinkBuilder = new
                ElasticsearchSink.Builder<>(httpHosts,
                new ElasticsearchSinkFunction<String>() {
                    @Override
                    public void process(String element, RuntimeContext ctx,RequestIndexer indexer) {
                        Map<String,String>JsonMap=new HashMap<>();
                        JsonMap.put("data",element);
                        IndexRequest indexRequest = Requests.indexRequest();
                        indexRequest.index("flink-index");
                        indexRequest.id("9001");
                        indexRequest.source(JsonMap);
                        indexer.add(indexRequest);
                    }
                }
        );
        esSinkBuilder.setBulkFlushMaxActions(1);
        source.addSink(esSinkBuilder.build());
        env.execute("flink-es");
    }
}
