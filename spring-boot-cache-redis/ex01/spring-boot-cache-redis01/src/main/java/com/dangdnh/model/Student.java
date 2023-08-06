package com.dangdnh.model;

import com.dangdnh.definition.MongoCollections;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = MongoCollections.STUDENTS)
public class Student {

    @Id
    private String id;

    private String name;

    private String code;
}
