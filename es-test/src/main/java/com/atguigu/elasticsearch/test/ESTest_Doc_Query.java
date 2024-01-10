package com.atguigu.elasticsearch.test;

import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortOrder;

/**
 * @Author：huahua
 * @Date：2023/11/3 16:04
 * 查询数据
 */
public class ESTest_Doc_Query {
    public static void main(String[] args) throws Exception {
        //创建es客户端
        RestHighLevelClient esClient=new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );
        ////1、查询索引中全部的数据数据
        //SearchRequest request=new SearchRequest();
        //request.indices("user");
        //request.source(new SearchSourceBuilder().query(QueryBuilders.matchAllQuery()));
        //
        //SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
        //SearchHits hits = response.getHits();
        //System.out.println(hits.getTotalHits());
        //System.out.println(response.getTook());
        //for (SearchHit hit:hits){
        //    System.out.println("查询结果："+hit.getSourceAsString());
        //}


        //2、条件查询查询 termQuery
        //SearchRequest request=new SearchRequest();
        //request.indices("user");
        //request.source(new SearchSourceBuilder().query(QueryBuilders.termQuery("name","lisi")));
        //
        //SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
        //SearchHits hits = response.getHits();
        //System.out.println(hits.getTotalHits());
        //System.out.println(response.getTook());
        //for (SearchHit hit:hits){
        //    System.out.println("查询结果："+hit.getSourceAsString());
        //}


        //3、分页查询查询
        //SearchRequest request=new SearchRequest();
        //request.indices("user");
        //SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
        ////分页设置，从第一条开始，每页两条
        //builder.from(0);
        //builder.size(2);
        //request.source(builder);
        //SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
        //SearchHits hits = response.getHits();
        //System.out.println(hits.getTotalHits());
        //System.out.println(response.getTook());
        //for (SearchHit hit:hits){
        //    System.out.println("查询结果："+hit.getSourceAsString());
        //}


        ////4、排序查询查询
        //SearchRequest request=new SearchRequest();
        //request.indices("user");
        //SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
        ////分页设置，从第一条开始，每页两条
        ////builder.from(0);
        ////builder.size(2);
        ////排序规则，以name排序
        //builder.sort("age", SortOrder.DESC);
        //request.source(builder);
        //SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
        //SearchHits hits = response.getHits();
        //System.out.println(hits.getTotalHits());
        //System.out.println(response.getTook());
        //for (SearchHit hit:hits){
        //    System.out.println("查询结果："+hit.getSourceAsString());
        //}


        ////5、过滤字段
        //SearchRequest request=new SearchRequest();
        //request.indices("user");
        //SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
        ////排序规则，以name排序
        ////builder.sort("age", SortOrder.DESC);
        //String [] excludes={};
        //String [] includes={"name"};
        //builder.fetchSource(includes,excludes);
        //request.source(builder);
        //SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
        //SearchHits hits = response.getHits();
        //System.out.println(hits.getTotalHits());
        //System.out.println(response.getTook());
        //for (SearchHit hit:hits){
        //    System.out.println("查询结果："+hit.getSourceAsString());
        //}

        ////6、组合查询
        //SearchRequest request=new SearchRequest();
        //request.indices("user");
        //SearchSourceBuilder builder = new SearchSourceBuilder();
        //BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        ////设置查询条件,age为30的数据
        ////boolQueryBuilder.must(QueryBuilders.matchQuery("age",30));
        //
        ////设置查询条件,age为30或者40的数据
        //boolQueryBuilder.should(QueryBuilders.matchQuery("age",30));
        //boolQueryBuilder.should(QueryBuilders.matchQuery("age",40));
        //
        //builder.query(boolQueryBuilder);
        //request.source(builder);
        //SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
        //SearchHits hits = response.getHits();
        //System.out.println(hits.getTotalHits());
        //System.out.println(response.getTook());
        //for (SearchHit hit:hits){
        //    System.out.println("查询结果："+hit.getSourceAsString());
        //}

        ////7、范围查询
        //SearchRequest request=new SearchRequest();
        //request.indices("user");
        //SearchSourceBuilder builder = new SearchSourceBuilder();
        //RangeQueryBuilder rangeQuery = QueryBuilders.rangeQuery("age");
        ////设置查询条件
        //rangeQuery.gte(30);
        //rangeQuery.lte(80);
        //builder.query(rangeQuery);
        //request.source(builder);
        //SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
        //SearchHits hits = response.getHits();
        //System.out.println(hits.getTotalHits());
        //System.out.println(response.getTook());
        //for (SearchHit hit:hits){
        //    System.out.println("查询结果："+hit.getSourceAsString());
        //}

        ////8、模糊查询
        //SearchRequest request=new SearchRequest();
        //request.indices("user");
        //SearchSourceBuilder builder = new SearchSourceBuilder();
        //FuzzyQueryBuilder fuzzyQueryBuilder = QueryBuilders.fuzzyQuery("name", "wangwu").fuzziness(Fuzziness.ONE);
        //builder.query(fuzzyQueryBuilder);
        //request.source(builder);
        //SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
        //SearchHits hits = response.getHits();
        //System.out.println(hits.getTotalHits());
        //System.out.println(response.getTook());
        //for (SearchHit hit:hits){
        //    System.out.println("查询结果："+hit.getSourceAsString());
        //}

        ////9、高亮查询
        //SearchRequest request=new SearchRequest();
        //request.indices("user");
        //SearchSourceBuilder builder = new SearchSourceBuilder();
        //TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", "zhangsan");
        //HighlightBuilder highlightBuilder=new HighlightBuilder();
        //highlightBuilder.preTags("<font color='red'>");
        //highlightBuilder.postTags("</font");
        //highlightBuilder.field("name");
        //builder.highlighter(highlightBuilder);
        //builder.query(termQueryBuilder);
        //request.source(builder);
        //SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
        //SearchHits hits = response.getHits();
        //System.out.println(hits.getTotalHits());
        //System.out.println(response.getTook());
        //for (SearchHit hit:hits){
        //    System.out.println("查询结果："+hit.getSourceAsString());
        //}

        ////10、聚合查询
        //SearchRequest request=new SearchRequest();
        //request.indices("user");
        //SearchSourceBuilder builder = new SearchSourceBuilder();
        //AggregationBuilder aggregationBuilder= AggregationBuilders.max("maxAge").field("age");
        //builder.aggregation(aggregationBuilder);
        //request.source(builder);
        //SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
        //SearchHits hits = response.getHits();
        //System.out.println(hits.getTotalHits());
        //System.out.println(response.getTook());
        //for (SearchHit hit:hits){
        //    System.out.println("查询结果："+hit.getSourceAsString());
        //}

        //11、分组查询
        SearchRequest request=new SearchRequest();
        request.indices("user");
        SearchSourceBuilder builder = new SearchSourceBuilder();
        AggregationBuilder aggregationBuilder= AggregationBuilders.terms("ageGroup").field("age");
        builder.aggregation(aggregationBuilder);
        request.source(builder);
        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        System.out.println(response.getTook());
        for (SearchHit hit:hits){
            System.out.println("查询结果："+hit.getSourceAsString());
        }

        //关闭es客户端
        esClient.close();
    }
}
