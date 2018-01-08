package com.momo.spring.demo.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QStudent is a Querydsl query type for Student
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStudent extends EntityPathBase<Student> {

    private static final long serialVersionUID = 320459887L;

    public static final QStudent student = new QStudent("student");

    public final StringPath chiName = createString("chiName");

    public final StringPath classCode = createString("classCode");

    public final StringPath classLvl = createString("classLvl");

    public final NumberPath<Integer> classNum = createNumber("classNum", Integer.class);

    public final StringPath engName = createString("engName");

    public final StringPath freeMissionInd = createString("freeMissionInd");

    public final NumberPath<Integer> height = createNumber("height", Integer.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath regNum = createString("regNum");

    public final StringPath schHse = createString("schHse");

    public final NumberPath<Integer> schLevelSign = createNumber("schLevelSign", Integer.class);

    public final StringPath schLvl = createString("schLvl");

    public final StringPath schScc = createString("schScc");

    public final ComparablePath<Character> sex = createComparable("sex", Character.class);

    public final StringPath strn = createString("strn");

    public final NumberPath<Integer> stuID = createNumber("stuID", Integer.class);

    public final NumberPath<Integer> suID = createNumber("suID", Integer.class);

    public final NumberPath<Long> updVersion = createNumber("updVersion", Long.class);

    public final NumberPath<Integer> weight = createNumber("weight", Integer.class);

    public QStudent(String variable) {
        super(Student.class, forVariable(variable));
    }

    public QStudent(Path<? extends Student> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStudent(PathMetadata metadata) {
        super(Student.class, metadata);
    }

}

