package com.khovaylo.app.controller;

import com.khovaylo.app.graphql.GraphQLServiceWithSPQR;
import graphql.ExecutionInput;
import graphql.ExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author Pavel Khovaylo
 */
//@RestController
public class GraphQLController {

//    @Autowired
//    public GraphQLController(UserGraph userGraph) {
//        GraphQLSchema schema = new GraphQLSchemaGenerator()
//                .withBasePackages("com.khovaylo.app")
//                .withOperationsFromSingletons(userGraph)
//                .generate();
//        this.graphQL = GraphQL.newGraphQL(schema).build();
//    }

    @PostMapping(value = "/graphql", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> indexFromAnnotated(@RequestBody Map<String, String> request, HttpServletRequest raw) {
        ExecutionResult executionResult = graphQLService.initGraphQL().execute(ExecutionInput.newExecutionInput()
                .query(request.get("query"))
                .operationName(request.get("operationName"))
                .context(raw)
                .build());
        return executionResult.toSpecification();
    }

    @Autowired
    private GraphQLServiceWithSPQR graphQLService;
}
