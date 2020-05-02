//package com.tao.blog.u.neo4j;
//
//import static org.neo4j.driver.v1.Values.parameters;
//
//import java.util.List;
//import java.util.Map;
//
//import org.neo4j.driver.v1.AuthTokens;
//import org.neo4j.driver.v1.Driver;
//import org.neo4j.driver.v1.GraphDatabase;
//import org.neo4j.driver.v1.Session;
//import org.neo4j.driver.v1.StatementResult;
//import org.neo4j.driver.v1.Value;
//
///**
// * 使用服务器开发的方式，连接，Neo4j；
// * 
// * @author tao
// *
// */
//public class Neo4jServerTest {
//
//	public static void main(String[] args) {
////		Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "neo4j123"));
////		Session session = driver.session();
////		Value value = parameters("name", "tangtao", "title", "test");
////		session.run("CREATE (a:Person {name: {name}, title: {title}})", value);
////
////		StatementResult result = session.run(
////				"MATCH (a:Person) WHERE a.name = {name} " + "RETURN a.name AS name, a.title AS title",
////				parameters("name", "tangtao"));
////
////		result.list().forEach(record -> {
////			System.out.println(record.get("title").asString() + " " + record.get("name").asString());
////		});
////		session.close();
////		driver.close();
//		test();
//	}
//
//	public static void test() {
//		Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "neo4j123"));
//		Neo4jUtil util = new Neo4jUtil(driver);
//		List<Map<String, Object>> list = util.getFields("CREATE (a:Person {name: \"张三\", title: \"test\"})");
//		for (Map<String, Object> map : list) {
//			System.out.println(map.get("title") + " " + map.get("name"));
//		}
//
//	}
//
//}
