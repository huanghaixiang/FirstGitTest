package com.noah.manage.util.search;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import com.noah.manage.model.UserBean;
import com.noah.manage.util.InitES;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.Bulk;
import io.searchbox.core.Delete;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.Update;
import io.searchbox.indices.CreateIndex;
import io.searchbox.indices.DeleteIndex;
import io.searchbox.indices.IndicesExists;

public class ElasticSearchUtil {

	private static JestClient client = InitES.getClient();
	
	
	
    /**
     * 创建索引
     */
    public static void index(String indexName,String typeName,Object obj){
    	 
    	 try {
//    		 IndicesExists indicesExists = new IndicesExists.Builder(indexName).build();
//             JestResult result = client.execute(indicesExists);
//             if (!result.isSucceeded()) {
//                 // Create articles index
//                 CreateIndex createIndex = new CreateIndex.Builder(indexName).build();
//                 client.execute(createIndex);
//             }
    		 Index index = new Index.Builder(obj).index(indexName).type(typeName).build();
    		 client.execute(index);
         } catch (IOException e) {
             e.printStackTrace();
         }
    }
    /**
     * 更新索引
     */
    public static void update(String indexName,String typeName,Object obj){
    	Update updateindex = new Update.Builder(obj).index(indexName).type(typeName).build();
    	try {
			client.execute(updateindex);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }
    
    
    
	/**
	 * 查询
	 * @param <T>
	 * @param query
	 * @return 
	 */
    public static List<UserBean> search(String indexName,String typeName,String target) {
    	SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
    	searchSourceBuilder.query(QueryBuilders.multiMatchQuery(target, "id","userno"));
//    	searchSourceBuilder.query(QueryBuilders.queryStringQuery(target));
    	
    	Search search = (Search) new Search.Builder(searchSourceBuilder.toString())
    	                                // multiple index or types can be added.
    	                                .addIndex(indexName)
    	                                .addType(typeName)
    	                                .build();

    	try {
			JestResult result = client.execute(search);
			List<UserBean> list = result.getSourceAsObjectList(UserBean.class);
//			System.out.println(list.size()+list.get(0).getUserno());
			return list;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }

    
    /**
     * 批量创建索引
     */
    public static void indexBulk(String indexName) {
        try {
            // drop
//            DeleteIndex dIndex = new DeleteIndex(new DeleteIndex.Builder(indexName));
//            client.execute(dIndex);
//            // create
//            CreateIndex cIndex = new CreateIndex(new CreateIndex.Builder(
//                    indexName));
//            client.execute(cIndex);
            // add doc
            Bulk.Builder bulkBuilder = new Bulk.Builder();
//            for (int i = 0; i < 1000; i++) {
 
//                User user = new User();
//                user.setId(new Long(i));
//                user.setName("fox " + i);
//                user.setAge(i % 100);
//                Index index = new Index.Builder(user).index(indexName)
//                        .type(indexName).build();
//                bulkBuilder.addAction(index);
//            }
            client.execute(bulkBuilder.build());
            //
//            client.shutdownClient();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    /**
     * 删除索引
     * @param args
     */
    public void deleteIndex(String id){
    	Delete deleteIndex = new Delete.Builder(id).build();
    	try {
			client.execute(deleteIndex);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    
    
    
    
    
	public static void main(String[] args){
		
		UserBean  user = new UserBean();
		user.setId(1);
		user.setPassword("123");
		user.setUserno("2239");
//		ElasticSearchUtil.index("users","users",user);
		
		
		ElasticSearchUtil.search("users", "users", "2239");
		System.out.println("暂停5秒");
//		ElasticSearchUtil.search("2239");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ElasticSearchUtil.search("users", "users", "2239");
		
		
	}
}
