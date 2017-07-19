/**
 * 
 */
package com.test.floow.dao.mongodb;

import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.test.floow.utility.FloowConstants;

/**
 * @author danie
 *
 */
public class ManageCollectionServiceImpl implements ManageCollectionService {

	private static final String sourceClass = ManageCollectionServiceImpl.class.getName();
	private Logger logger = Logger.getLogger(sourceClass);

	public boolean IsDBPresent(Map<String, String> configMongoDB) {
		// TODO Auto-generated method stub
		final String sourceMethod = "IsCollectionPresent";
		logger.entering(sourceClass, sourceMethod);
		MongoClient mongoClient = null;
		boolean result = false;
		try {
			configMongoDB.get(FloowConstants.MONGO_HOSTNAME);
			String hostNameMongo = configMongoDB.get(FloowConstants.MONGO_HOSTNAME);
			String portMongo =  configMongoDB.get(FloowConstants.MONGO_PORT);
			int portMongoInt = Integer.parseInt(portMongo);
			mongoClient = new MongoClient(hostNameMongo, portMongoInt);
			MongoDatabase dbName = mongoClient
					.getDatabase(FloowConstants.DBNAME);
			if (dbName != null) {
				result =  true;
			}
			return result;
		} catch (Exception e) {
			logger.logp(Level.SEVERE, sourceClass, sourceMethod, "Unable to connect Mongo DDB: ", e);
			return false;
		} finally {
			mongoClient.close();
		}
		
	}

	public boolean isCollectionPresent(Map<String, String> configMongoDB) {
		final String sourceMethod = "IsCollectionPresent";
		logger.entering(sourceClass, sourceMethod);
		MongoClient mongoClient = null;
		boolean result = false;
		try {
			String nameColletion = configMongoDB.get(FloowConstants.ID_HOSTNAME);
			String hostNameMongo = configMongoDB.get(FloowConstants.MONGO_HOSTNAME);
			String portMongo =  configMongoDB.get(FloowConstants.MONGO_PORT);
			int portMongoInt = Integer.parseInt(portMongo);
			mongoClient = new MongoClient(hostNameMongo, portMongoInt);
			if (mongoClient.getDB(FloowConstants.DBNAME).		
					collectionExists(nameColletion)) {
				result = true;
			}
			return result;
		} catch (Exception e) {
			logger.logp(Level.SEVERE, sourceClass, sourceMethod, "Unable to connect Mongo DDB: ", e);
			return false;
		} finally {
			mongoClient.close();
		}
	}
	
	public boolean updateMongo(Map<String, String> configMongoDB) {
		// TODO Auto-generated method stub
		final String sourceMethod = "createCollection";
		logger.entering(sourceClass, sourceMethod);
		try {
			if (IsDBPresent(configMongoDB)) {
				if (isCollectionPresent(configMongoDB)) {
					return updateCollection(configMongoDB);
				} else {
					return createCollection(configMongoDB);
				}
			} else {
				return createCollection(configMongoDB);
			}
		} catch (Exception e) {
			logger.logp(Level.SEVERE, sourceClass, sourceMethod, "Unable to connect Mongo DB: ", e);
			return false;
		}
		
	}
	
	public boolean updateCollection(Map<String, String> configMongoDB) {
		final String sourceMethod = "createCollection";
		logger.entering(sourceClass, sourceMethod);
		MongoClient mongoClient = null;
		
		try {
			String nameColletion = configMongoDB.get(FloowConstants.ID_HOSTNAME);
			String hostNameMongo = configMongoDB.get(FloowConstants.MONGO_HOSTNAME);
			String portMongo =  configMongoDB.get(FloowConstants.MONGO_PORT);
			String strSearch =  configMongoDB.get(FloowConstants.ID_STRING);
			String qta = configMongoDB.get("qta");
			int portMongoInt = Integer.parseInt(portMongo);
			mongoClient = new MongoClient(hostNameMongo, portMongoInt);
			DB db = mongoClient.getDB(FloowConstants.DBNAME);
			DBCollection table = db.getCollection(nameColletion);
			// BasicDBObject document = new BasicDBObject();
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("hostName", nameColletion);
			BasicDBObject newDocument = new BasicDBObject();
			newDocument.put("qta", qta);
			newDocument.put("search", strSearch);
			newDocument.put("modificatedDate", new Date());
			BasicDBObject updateObj = new BasicDBObject();
			updateObj.put("$set", newDocument);
			table.update(searchQuery, updateObj);
			return true;
		} catch (Exception e) {
			logger.logp(Level.SEVERE, sourceClass, sourceMethod, "Unable to connect Mongo DB: ", e);
			return false;
		}
	}
	
	public boolean createCollection(Map<String, String> configMongoDB) {
		final String sourceMethod = "createCollection";
		logger.entering(sourceClass, sourceMethod);
		MongoClient mongoClient = null;
		try {
			String nameColletion = configMongoDB.get(FloowConstants.ID_HOSTNAME);
			String hostNameMongo = configMongoDB.get(FloowConstants.MONGO_HOSTNAME);
			String portMongo =  configMongoDB.get(FloowConstants.MONGO_PORT);
			String strSearch =  configMongoDB.get(FloowConstants.ID_STRING);
			String qta = configMongoDB.get("qta");
			int portMongoInt = Integer.parseInt(portMongo);
			mongoClient = new MongoClient(hostNameMongo, portMongoInt);
			DB db = mongoClient.getDB(FloowConstants.DBNAME);
			DBCollection table = db.getCollection(nameColletion);
			BasicDBObject document = new BasicDBObject();
			document.put("hostName", nameColletion);
			document.put("search", strSearch);
			document.put("qta", qta);
			document.put("createdDate", new Date());
			table.insert(document);
			return true;
		} catch (Exception e) {
			logger.logp(Level.SEVERE, sourceClass, sourceMethod, "Unable to connect Mongo DB: ", e);
			return false;
		}	
	}
}
