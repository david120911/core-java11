package alibaba.code.guideline.mysql.orm;

public class OrmTest {


    /**
     * (四) ORM 映射
     * 1. 【强制】在表查询中，一律不要使用 * 作为查询的字段列表，需要哪些字段必须明确写明。
     * 说明:
     * 1)增加查询分析器解析成本。
     * 2)增减字段容易与 resultMap 配置不一致。
     */


    // 一律不要使用*

    /**
     * 2. 【强制】POJO 类的布尔属性不能加 is，而数据库字段必须加 is_，
     * 要求在 resultMap 中进行 字段与属性之间的映射。
     * 说明:参见定义 POJO 类以及数据库字段定义规定，在<resultMap>中增加映射，
     * 是必须的。 在MyBatis Generator生成的代码中，需要进行对应的修改。
     *
     */

    // Pojo布尔属性不能加is 而数据库字段必须加is_


    /**
     * 3. 【强制】不要用 resultClass 当返回参数，
     * 即使所有类属性名与数据库字段一一对应，也需 要定义;反过来，
     * 每一个表也必然有一个与之对应。
     * 说明:配置映射关系，使字段与 DO 类解耦，方便维护。
     */


    // 配置映射关系 是字段与DO类解耦


    /**
     * 4. 【强制】sql.xml 配置参数使用:#{}，#param#
     * 不要使用${} 此种方式容易出现 SQL 注入。
     */


    // 不用${} 易出现SQL注入

    /**
     *
     * 5.【强制】iBATIS自带的queryForList(String
     * statementName,int start,int size)不推 荐使用。
     * 说明:其实现方式是在数据库取到 statementName 对应的 SQL
     * 语句的所有记录，再通过 subList 取 start,size 的子集合。
     * 正例:Map<String, Object> map = new HashMap<String, Object>();
     * map.put("start", start);
     * map.put("size", size);
     */

    // 这里有点没有搞懂 下次再看

    /**
     *
     * 6. 【强制】不允许直接拿 HashMap 与 Hashtable 作为查询结果集的输出。
     * 说明:resultClass=”Hashtable”，会置入字段名和属性值，但是值的类型不可控。
     */

    // 先讲了不允许 那允许什么呢 说说啊

    /**
     *
     * 7. 【强制】更新数据表记录时，必须同时更新记录对应的 gmt_modified 字段值为当前时间。
     *
     */

// 这个设置很有意思

    /**
     *8. 【推荐】不要写一个大而全的数据更新接口，传入为 POJO 类，不管是不是自己的目标更新字
     * 段，都进行 update table set c1=value1,c2=value2,c3=value3; 这是不对的。
     * 执行 SQL 时，不要更新无改动的字段，一是易出错;二是效率低;三是增加 binlog 存储。
     *
     */
//意思是要适可而止 不要搞太多

    /**
     * 9. 【参考】@Transactional 事务不要滥用。事务会影响数据库的 QPS，
     * 另外使用事务的地方需 要考虑各方面的回滚方案，包括缓存回滚、搜索引擎回滚、消息补偿、统计修正等。
     *
     */
// 事务不要滥用

    /**
     *
     * 10. 【参考】<isEqual>中的 compareValue 是与属性值对比的常量，一般是数字，
     * 表示相等时带 上此条件;<isNotEmpty>表示不为空且不为 null 时执行;
     * <isNotNull>表示不为 null 值时 执行。
     *
     *
     * */
// 参考  这些都不是很有感觉 要在实际中多理解  还有那个解耦的


}
