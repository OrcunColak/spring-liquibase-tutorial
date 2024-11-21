# Read me

In this example, all files inside the changelog/changes directory will be included and executed in lexicographical
order (
based on filename).

# Maven

```
mvn liquibase:update
```

Check current status:

```
mvn liquibase:status
```

Generate SQL without executing:

```
mvn liquibase:updateSQL
```

# Context

See https://medium.com/@dvlreddy/using-liquibase-for-managing-database-within-spring-boot-microservice-a3626d02d737
Contexts allow you to control which changes run in different environments

**application-dev.yml**

```
spring:
  liquibase:
    contexts: dev
    drop-first: true
```

**application-prod.yml**

```
spring:
  liquibase:
    contexts: prod
    drop-first: false
```

```
<changeSet id="20240119-2" author="john.doe" context="dev">
    <insert tableName="customers">
        <column name="id" value="1"/>
        <column name="name" value="Test User"/>
        <column name="email" value="test@example.com"/>
    </insert>
</changeSet>
```

# Labels

Labels provide another way to categorize changes:

```
<changeSet id="20240119-3" author="john.doe" labels="schema-only">
    <createIndex tableName="customers" indexName="idx_customer_email">
        <column name="email"/>
    </createIndex>
</changeSet>
```

# Creating Tables

```
<changeSet id="20240119-4" author="john.doe">
    <createTable tableName="orders">
        <column name="id" type="bigint" autoIncrement="true">
            <constraints primaryKey="true" nullable="false"/>
        </column>
        <column name="customer_id" type="bigint">
            <constraints nullable="false" 
                        foreignKeyName="fk_orders_customer" 
                        references="customers(id)"/>
        </column>
        <column name="total_amount" type="decimal(10,2)"/>
        <column name="status" type="varchar(20)"/>
        <column name="created_at" type="timestamp" defaultValueComputed="CURRENT_TIMESTAMP"/>
    </createTable>
</changeSet>
```

# Load data

```
<changeSet id="20240119-9" author="john.doe" context="dev">
    <loadData tableName="customers"
              file="db/data/dev/customers.csv"
              separator=",">
        <column name="id" type="NUMERIC"/>
        <column name="name" type="STRING"/>
        <column name="email" type="STRING"/>
    </loadData>
</changeSet>
```

# Preconditions

```
<changeSet id="20240119-8" author="john.doe">
    <preConditions onFail="MARK_RAN">
        <not>
            <tableExists tableName="product_categories"/>
        </not>
    </preConditions>
    <createTable tableName="product_categories">
        <column name="id" type="bigint" autoIncrement="true">
            <constraints primaryKey="true" nullable="false"/>
        </column>
        <column name="name" type="varchar(50)"/>
    </createTable>
</changeSet>
```

# Rolling Back Changes

```
<changeSet id="20240119-7" author="john.doe">
    <createTable tableName="products">
        <column name="id" type="bigint" autoIncrement="true">
            <constraints primaryKey="true" nullable="false"/>
        </column>
        <column name="name" type="varchar(100)"/>
        <column name="price" type="decimal(10,2)"/>
    </createTable>
    <rollback>
        <dropTable tableName="products"/>
    </rollback>
</changeSet>
```

# Creating Indexes

```
<changeSet id="20240119-6" author="john.doe">
    <createIndex indexName="idx_orders_customer"
                 tableName="orders">
        <column name="customer_id"/>
    </createIndex>
</changeSet>
```

# Adding Columns

```
<changeSet id="20240119-5" author="john.doe">
    <addColumn tableName="customers">
        <column name="phone_number" type="varchar(20)"/>
    </addColumn>
</changeSet>
```