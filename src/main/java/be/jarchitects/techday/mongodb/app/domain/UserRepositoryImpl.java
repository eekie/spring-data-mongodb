package be.jarchitects.techday.mongodb.app.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.regex.Pattern;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

/**
 * Created by tom on 9/11/14.
 */
@Repository
class UserRepositoryImpl implements CustomUserRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<User> customQuery() {
        Query query = new Query();
        query.limit(10);
        query.addCriteria(Criteria.where("lastName").is("Mouse"));
        return mongoTemplate.find(query, User.class);
    }

    @Override
    public List<User> basicJsonQuery() {
        BasicQuery query = new BasicQuery("{ $or: [{firstName: 'Daffy'}, {firstName: 'Donald'}]} ");
        return mongoTemplate.find(query, User.class);
    }

    @Override
    public List<LastNameStats> groupByLastName(String lastNameRegex) {
        Aggregation aggregation = newAggregation(
            match(Criteria.where("lastName").regex(Pattern.compile(lastNameRegex, Pattern.CASE_INSENSITIVE | Pattern.DOTALL))),
            group("lastName").count().as("count"),
            sort(Sort.Direction.ASC, "lastName")
        );
        AggregationResults<LastNameStats> results = mongoTemplate.aggregate(aggregation, "user", LastNameStats.class);
        return results.getMappedResults();
    }

}
