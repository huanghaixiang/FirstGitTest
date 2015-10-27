package huang.util.search;

import java.io.IOException;
import java.util.List;

import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import huang.model.UserDo;
import huang.util.InitES;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.Bulk;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.indices.CreateIndex;
import io.searchbox.indices.IndicesExists;

public class ElasticSearchUtil {

	private static JestClient client = InitES.getClient();
	
	
	
    /**
     * 创建索引
     */
    public static void index(String indexName,String typeName,Object obj){
    	 
    	 try {
    		 IndicesExists indicesExists = new IndicesExists.Builder(indexName).build();
             JestResult result = client.execute(indicesExists);
             if (!result.isSucceeded()) {
                 // Create articles index
                 CreateIndex createIndex = new CreateIndex.Builder("articles").build();
                 client.execute(createIndex);
             }
    		 Index index = new Index.Builder(obj).index(indexName).type(typeName).build();
    		 client.execute(index);
         } catch (IOException e) {
             e.printStackTrace();
         }
    }
	/**
	 * 查询
	 * @param <T>
	 * @param query
	 * @return 
	 */
    public static List<UserDo> search(String indexName,String typeName,String target) {
    	SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
    	searchSourceBuilder.query(QueryBuilders.queryStringQuery(target));
    	Search search = (Search) new Search.Builder(searchSourceBuilder.toString())
    	                                // multiple index or types can be added.
    	                                .addIndex(indexName)
    	                                .addType(typeName)
    	                                .build();

    	try {
			JestResult result = client.execute(search);
			List<UserDo> list = result.getSourceAsObjectList(UserDo.class);
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
	public static void main(String[] args){
		
		UserDo  user = new UserDo();
		user.setId(1);
		user.setPassword("123");
		user.setUserno("2239");
//		ElasticSearchUtil.index("users","users",user);
		//�����������
		
		//��ʼ����
		ElasticSearchUtil.search("users", "users", "2239");
		System.out.println("������ϣ��ȴ�5��");
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
