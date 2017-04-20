package solrJ;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;
//删除、添加到solr
public class SolrJTest {
//	@Test
	public void addDocument() throws Exception {
		//创建一连接
		SolrServer solrServer = new HttpSolrServer("http://192.168.241.130:8080/solr");
		//创建一个文档对象
		SolrInputDocument document = new SolrInputDocument();
		document.addField("id", "test001");
		document.addField("WEIBO_CONTENT", "雨下整夜我的爱溢出就像雨水，窗台蝴蝶，像诗里纷飞的美丽章节。");
		//把文档对象写入索引库
		solrServer.add(document);
		//提交
		solrServer.commit();
	}
	
	@Test
	public void deleteDocument() throws Exception {
		//创建一连接
		SolrServer solrServer = new HttpSolrServer("http://192.168.241.130:8080/solr");
		//solrServer.deleteById("test001");
		solrServer.deleteByQuery("*:*");
		solrServer.commit();
	}
}
