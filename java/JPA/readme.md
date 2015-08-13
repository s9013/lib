JPA（Java Persistence API） java持久化api
通过注解或者XML描述对象-关系表的映射关系，并将运行期的实体对象持久化到数据库中。

ORM Object-Relation-Mapping 对象关系映射，对象持久化的核心。ORM是对JDBC的封装。


trategy
strategy是 GenerationType类型的枚举值，它的内容将指定 OpenJPA 容器自动生成实体标识的方式。strategy属性可以是下列枚举值：

GeneratorType.AUTO
表示实体标识由 OpenJPA 容器自动生成，这也是 Strategy 属性的默认值。

GenerationType.IDENTITY
OpenJPA 容器将使用数据库的自增长字段为新增加的实体对象赋唯一值，作为实体的标识。这种情况下需要数据库提供对自增长字段的支持，常用的数据库中，HSQL、SQL Server、MySQL、DB2、Derby 等数据库都能够提供这种支持。

GenerationType.SEQUENCE
表示使用数据库的序列号为新增加的实体对象赋唯一值，作为实体的标识。这种情况下需要数据库提供对序列号的支持，常用的数据库中，Oracle、PostgreSQL 等数据库都能够提供这种支持。

GenerationType.TABLE
表示使用数据库中指定表的某个字段记录实体对象的标识，通过该字段的增长为新增加的实体对象赋唯一值，作为实体的标识。


http://blog.csdn.net/hmk2011/article/details/6289151