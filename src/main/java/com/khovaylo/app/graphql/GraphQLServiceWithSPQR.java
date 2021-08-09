package com.khovaylo.app.graphql;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import io.leangen.graphql.GraphQLSchemaGenerator;
import io.leangen.graphql.metadata.strategy.query.AnnotatedResolverBuilder;
import io.leangen.graphql.metadata.strategy.query.PublicResolverBuilder;
import io.leangen.graphql.metadata.strategy.value.jackson.JacksonValueMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * @author Pavel Khovaylo
 */
//@Service
public class GraphQLServiceWithSPQR {

    private GraphQL graphQL;

    @Autowired
    private UserGraph userGraph;

    @PostConstruct
    public void init() throws IOException {
        GraphQLSchema schema = buildSchema();
        this.graphQL = GraphQL.newGraphQL(schema).build();
    }

    private GraphQLSchema buildSchema() throws IOException {
        return new GraphQLSchemaGenerator().withResolverBuilders(
                new AnnotatedResolverBuilder(),
                new PublicResolverBuilder("com.khovaylo.app"))
                .withOperationsFromSingleton(userGraph)
                .withValueMapperFactory(new JacksonValueMapperFactory())
                .generate();
    }

    public GraphQL initGraphQL() {
        return graphQL;
    }
}
