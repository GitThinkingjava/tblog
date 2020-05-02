//package com.tao.blog.u.neo4j;
//
//import java.io.File;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.neo4j.graphdb.*;
//import org.neo4j.graphdb.factory.*;
//
///**
// * Neo4j 嵌入式开发
// * @author tao
// *
// */
//public class EmbeddeddConnction {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		GraphDatabaseService graphDb = new GraphDatabaseFactory().newEmbeddedDatabase(new File("Data/Test"));
//		System.out.println("Database Load!");
//		// 开启事务
//		try (Transaction tx = graphDb.beginTx()) {
//			// Perform DB operations
//			Node steve = graphDb.createNode(Labels.USER);
//			steve.setProperty("name", "Steve");
//			Node linda = graphDb.createNode(Labels.USER);
//			linda.setProperty("name", "Linda");
//			steve.createRelationshipTo(linda, RelationshipTypes.IS_FRIEND_OF);
//			System.out.println("created node name is" + steve.getProperty("name"));
//			tx.success();
//		}
//		// 查询数据库
//		String query = "match (n:USER) return n.name as name";
//		Map<String, Object> parameters = new HashMap<String, Object>();
//		try (Result result = graphDb.execute(query, parameters)) {
//			while (result.hasNext()) {
//				Map<String, Object> row = result.next();
//				for (String key : result.columns()) {
//					System.out.printf("%s = %s%n", key, row.get(key));
//				}
//			}
//		}
//
//		registerShutdownHook(graphDb);
//		System.out.println("Database Shutdown!");
//
//	}
//
//	// 设置标签，但是必须继承于接口label
//	public enum Labels implements Label {
//		USER, MOVIE;
//	}
//
//	public enum RelationshipTypes implements RelationshipType {
//		IS_FRIEND_OF, HAS_SEEN;
//	}
//
//	private static void registerShutdownHook(final GraphDatabaseService graphDb) {
//		Runtime.getRuntime().addShutdownHook(new Thread() {
//			@Override
//			public void run() {
//				graphDb.shutdown();
//			}
//		});
//	}
//	private static final File DB_PATH = new File("D:\\Neo4jDb");
//	private static GraphDatabaseService graphDb;
//
//	private static void registerShutdownHook(final GraphDatabaseService graphDb) {
//		Runtime.getRuntime().addShutdownHook(new Thread() {
//			@Override
//			public void run() {
//				graphDb.shutdown();
//			}
//		});
//	}
//
//	private static enum RelTypes implements RelationshipType {
//		RELEASED;
//	}
//
//	@SuppressWarnings("unused")
//	private static void addData() {
//		Node node1;
//		Node node2;
//		Label label1;
//		Label label2;
//		Relationship relationship;
//
//		try (Transaction tx = graphDb.beginTx()) {
//			// 创建标签
//			label1 = Label.label("Musician");
//			label2 = Label.label("Album");
//			// 创建节点
//			node1 = graphDb.createNode(label1);
//			node1.setProperty("name", "Jay Chou");
//			node2 = graphDb.createNode(label2);
//			node2.setProperty("name", "Fantasy");
//			// 创建关系及属性
//			relationship = node1.createRelationshipTo(node2, RelTypes.RELEASED);
//			relationship.setProperty("date", "2001-09-14");
//			// 结果输出
//			System.out.println("created node name is " + node1.getProperty("name"));
//			System.out.println(relationship.getProperty("date"));
//			System.out.println("created node name is " + node2.getProperty("name"));
//			// 提交事务
//			tx.success();
//		}
//		graphDb.shutdown();
//	}
//
//	@SuppressWarnings("unused")
//	private static void queryAndUpdate() {
//		try (Transaction tx = graphDb.beginTx()) {
//			// 查询节点
//			Label label = Label.label("Musician");
//			Node node = graphDb.findNode(label, "name", "Jay Chou");
//			System.out.println("query node name is " + node.getProperty("name"));
//			// 更新节点
//			node.setProperty("birthday", "1979-01-18");
//			System.out
//					.println(node.getProperty("name") + "'s birthday is " + node.getProperty("birthday", new String()));
//			// 提交事务
//			tx.success();
//		}
//		graphDb.shutdown();
//	}
//
//	@SuppressWarnings("unused")
//	private static void delete() {
//		try (Transaction tx = graphDb.beginTx()) {
//			// 获得节点
//			Label label = Label.label("Album");
//			Node node = graphDb.findNode(label, "name", "Fantasy");
//			// 获得关系
//			Relationship relationship = node.getSingleRelationship(RelTypes.RELEASED, Direction.INCOMING);
//			// 删除关系和节点
//			relationship.delete();
//			relationship.getStartNode().delete();
//			node.delete();
//			tx.success();
//		}
//		graphDb.shutdown();
//	}
//
//	public static void main(String[] args) {
//		graphDb = new GraphDatabaseFactory().newEmbeddedDatabase(DB_PATH);
//		registerShutdownHook(graphDb);
//		addData();
//		// queryAndUpdate();
//		// delete();
//
//	}
//}
